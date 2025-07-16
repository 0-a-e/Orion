package org.apache.commons.compress.archivers.cpio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.CharsetNames;
import org.apache.commons.compress.utils.IOUtils;

public class CpioArchiveInputStream extends ArchiveInputStream implements CpioConstants {
    private final int blockSize;
    private boolean closed;
    private long crc;
    final String encoding;
    private CpioArchiveEntry entry;
    private long entryBytesRead;
    private boolean entryEOF;
    private final byte[] fourBytesBuf;
    private final InputStream in;
    private final byte[] sixBytesBuf;
    private final byte[] tmpbuf;
    private final byte[] twoBytesBuf;
    private final ZipEncoding zipEncoding;

    public CpioArchiveInputStream(InputStream inputStream) {
        this(inputStream, 512, CharsetNames.US_ASCII);
    }

    public CpioArchiveInputStream(InputStream inputStream, String str) {
        this(inputStream, 512, str);
    }

    public CpioArchiveInputStream(InputStream inputStream, int i) {
        this(inputStream, i, CharsetNames.US_ASCII);
    }

    public CpioArchiveInputStream(InputStream inputStream, int i, String str) {
        this.closed = false;
        this.entryBytesRead = 0;
        this.entryEOF = false;
        this.tmpbuf = new byte[4096];
        this.crc = 0;
        this.twoBytesBuf = new byte[2];
        this.fourBytesBuf = new byte[4];
        this.sixBytesBuf = new byte[6];
        this.in = inputStream;
        if (i > 0) {
            this.blockSize = i;
            this.encoding = str;
            this.zipEncoding = ZipEncodingHelper.getZipEncoding(str);
            return;
        }
        throw new IllegalArgumentException("blockSize must be bigger than 0");
    }

    public int available() throws IOException {
        ensureOpen();
        return this.entryEOF ? 0 : 1;
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.in.close();
            this.closed = true;
        }
    }

    private void closeEntry() throws IOException {
        do {
        } while (skip(2147483647L) == 2147483647L);
    }

    private void ensureOpen() throws IOException {
        if (this.closed) {
            throw new IOException("Stream closed");
        }
    }

    public CpioArchiveEntry getNextCPIOEntry() throws IOException {
        ensureOpen();
        if (this.entry != null) {
            closeEntry();
        }
        byte[] bArr = this.twoBytesBuf;
        readFully(bArr, 0, bArr.length);
        if (CpioUtil.byteArray2long(this.twoBytesBuf, false) == 29127) {
            this.entry = readOldBinaryEntry(false);
        } else if (CpioUtil.byteArray2long(this.twoBytesBuf, true) == 29127) {
            this.entry = readOldBinaryEntry(true);
        } else {
            byte[] bArr2 = this.twoBytesBuf;
            System.arraycopy(bArr2, 0, this.sixBytesBuf, 0, bArr2.length);
            readFully(this.sixBytesBuf, this.twoBytesBuf.length, this.fourBytesBuf.length);
            String asciiString = ArchiveUtils.toAsciiString(this.sixBytesBuf);
            asciiString.hashCode();
            char c = 65535;
            switch (asciiString.hashCode()) {
                case 1426477263:
                    if (asciiString.equals(CpioConstants.MAGIC_NEW)) {
                        c = 0;
                        break;
                    }
                    break;
                case 1426477264:
                    if (asciiString.equals(CpioConstants.MAGIC_NEW_CRC)) {
                        c = 1;
                        break;
                    }
                    break;
                case 1426477269:
                    if (asciiString.equals(CpioConstants.MAGIC_OLD_ASCII)) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.entry = readNewEntry(false);
                    break;
                case 1:
                    this.entry = readNewEntry(true);
                    break;
                case 2:
                    this.entry = readOldAsciiEntry();
                    break;
                default:
                    throw new IOException("Unknown magic [" + asciiString + "]. Occured at byte: " + getBytesRead());
            }
        }
        this.entryBytesRead = 0;
        this.entryEOF = false;
        this.crc = 0;
        if (!this.entry.getName().equals(CpioConstants.CPIO_TRAILER)) {
            return this.entry;
        }
        this.entryEOF = true;
        skipRemainderOfLastBlock();
        return null;
    }

    private void skip(int i) throws IOException {
        if (i > 0) {
            readFully(this.fourBytesBuf, 0, i);
        }
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        ensureOpen();
        if (i < 0 || i2 < 0 || i > bArr.length - i2) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return 0;
        }
        CpioArchiveEntry cpioArchiveEntry = this.entry;
        if (cpioArchiveEntry == null || this.entryEOF) {
            return -1;
        }
        if (this.entryBytesRead == cpioArchiveEntry.getSize()) {
            skip(this.entry.getDataPadCount());
            this.entryEOF = true;
            if (this.entry.getFormat() != 2 || this.crc == this.entry.getChksum()) {
                return -1;
            }
            throw new IOException("CRC Error. Occured at byte: " + getBytesRead());
        }
        int min = (int) Math.min((long) i2, this.entry.getSize() - this.entryBytesRead);
        if (min < 0) {
            return -1;
        }
        int readFully = readFully(bArr, i, min);
        if (this.entry.getFormat() == 2) {
            for (int i3 = 0; i3 < readFully; i3++) {
                this.crc = (this.crc + ((long) (bArr[i3] & 255))) & 4294967295L;
            }
        }
        if (readFully > 0) {
            this.entryBytesRead += (long) readFully;
        }
        return readFully;
    }

    private final int readFully(byte[] bArr, int i, int i2) throws IOException {
        int readFully = IOUtils.readFully(this.in, bArr, i, i2);
        count(readFully);
        if (readFully >= i2) {
            return readFully;
        }
        throw new EOFException();
    }

    private long readBinaryLong(int i, boolean z) throws IOException {
        byte[] bArr = new byte[i];
        readFully(bArr, 0, i);
        return CpioUtil.byteArray2long(bArr, z);
    }

    private long readAsciiLong(int i, int i2) throws IOException {
        byte[] bArr = new byte[i];
        readFully(bArr, 0, i);
        return Long.parseLong(ArchiveUtils.toAsciiString(bArr), i2);
    }

    private CpioArchiveEntry readNewEntry(boolean z) throws IOException {
        CpioArchiveEntry cpioArchiveEntry;
        if (z) {
            cpioArchiveEntry = new CpioArchiveEntry(2);
        } else {
            cpioArchiveEntry = new CpioArchiveEntry(1);
        }
        cpioArchiveEntry.setInode(readAsciiLong(8, 16));
        long readAsciiLong = readAsciiLong(8, 16);
        if (CpioUtil.fileType(readAsciiLong) != 0) {
            cpioArchiveEntry.setMode(readAsciiLong);
        }
        cpioArchiveEntry.setUID(readAsciiLong(8, 16));
        cpioArchiveEntry.setGID(readAsciiLong(8, 16));
        cpioArchiveEntry.setNumberOfLinks(readAsciiLong(8, 16));
        cpioArchiveEntry.setTime(readAsciiLong(8, 16));
        cpioArchiveEntry.setSize(readAsciiLong(8, 16));
        if (cpioArchiveEntry.getSize() >= 0) {
            cpioArchiveEntry.setDeviceMaj(readAsciiLong(8, 16));
            cpioArchiveEntry.setDeviceMin(readAsciiLong(8, 16));
            cpioArchiveEntry.setRemoteDeviceMaj(readAsciiLong(8, 16));
            cpioArchiveEntry.setRemoteDeviceMin(readAsciiLong(8, 16));
            long readAsciiLong2 = readAsciiLong(8, 16);
            if (readAsciiLong2 >= 0) {
                cpioArchiveEntry.setChksum(readAsciiLong(8, 16));
                String readCString = readCString((int) readAsciiLong2);
                cpioArchiveEntry.setName(readCString);
                if (CpioUtil.fileType(readAsciiLong) != 0 || readCString.equals(CpioConstants.CPIO_TRAILER)) {
                    skip(cpioArchiveEntry.getHeaderPadCount(readAsciiLong2 - 1));
                    return cpioArchiveEntry;
                }
                throw new IOException("Mode 0 only allowed in the trailer. Found entry name: " + ArchiveUtils.sanitize(readCString) + " Occured at byte: " + getBytesRead());
            }
            throw new IOException("Found illegal entry with negative name length");
        }
        throw new IOException("Found illegal entry with negative length");
    }

    private CpioArchiveEntry readOldAsciiEntry() throws IOException {
        CpioArchiveEntry cpioArchiveEntry = new CpioArchiveEntry(4);
        cpioArchiveEntry.setDevice(readAsciiLong(6, 8));
        cpioArchiveEntry.setInode(readAsciiLong(6, 8));
        long readAsciiLong = readAsciiLong(6, 8);
        if (CpioUtil.fileType(readAsciiLong) != 0) {
            cpioArchiveEntry.setMode(readAsciiLong);
        }
        cpioArchiveEntry.setUID(readAsciiLong(6, 8));
        cpioArchiveEntry.setGID(readAsciiLong(6, 8));
        cpioArchiveEntry.setNumberOfLinks(readAsciiLong(6, 8));
        cpioArchiveEntry.setRemoteDevice(readAsciiLong(6, 8));
        cpioArchiveEntry.setTime(readAsciiLong(11, 8));
        long readAsciiLong2 = readAsciiLong(6, 8);
        if (readAsciiLong2 >= 0) {
            cpioArchiveEntry.setSize(readAsciiLong(11, 8));
            if (cpioArchiveEntry.getSize() >= 0) {
                String readCString = readCString((int) readAsciiLong2);
                cpioArchiveEntry.setName(readCString);
                if (CpioUtil.fileType(readAsciiLong) != 0 || readCString.equals(CpioConstants.CPIO_TRAILER)) {
                    return cpioArchiveEntry;
                }
                throw new IOException("Mode 0 only allowed in the trailer. Found entry: " + ArchiveUtils.sanitize(readCString) + " Occured at byte: " + getBytesRead());
            }
            throw new IOException("Found illegal entry with negative length");
        }
        throw new IOException("Found illegal entry with negative name length");
    }

    private CpioArchiveEntry readOldBinaryEntry(boolean z) throws IOException {
        CpioArchiveEntry cpioArchiveEntry = new CpioArchiveEntry(8);
        cpioArchiveEntry.setDevice(readBinaryLong(2, z));
        cpioArchiveEntry.setInode(readBinaryLong(2, z));
        long readBinaryLong = readBinaryLong(2, z);
        if (CpioUtil.fileType(readBinaryLong) != 0) {
            cpioArchiveEntry.setMode(readBinaryLong);
        }
        cpioArchiveEntry.setUID(readBinaryLong(2, z));
        cpioArchiveEntry.setGID(readBinaryLong(2, z));
        cpioArchiveEntry.setNumberOfLinks(readBinaryLong(2, z));
        cpioArchiveEntry.setRemoteDevice(readBinaryLong(2, z));
        cpioArchiveEntry.setTime(readBinaryLong(4, z));
        long readBinaryLong2 = readBinaryLong(2, z);
        if (readBinaryLong2 >= 0) {
            cpioArchiveEntry.setSize(readBinaryLong(4, z));
            if (cpioArchiveEntry.getSize() >= 0) {
                String readCString = readCString((int) readBinaryLong2);
                cpioArchiveEntry.setName(readCString);
                if (CpioUtil.fileType(readBinaryLong) != 0 || readCString.equals(CpioConstants.CPIO_TRAILER)) {
                    skip(cpioArchiveEntry.getHeaderPadCount(readBinaryLong2 - 1));
                    return cpioArchiveEntry;
                }
                throw new IOException("Mode 0 only allowed in the trailer. Found entry: " + ArchiveUtils.sanitize(readCString) + "Occured at byte: " + getBytesRead());
            }
            throw new IOException("Found illegal entry with negative length");
        }
        throw new IOException("Found illegal entry with negative name length");
    }

    private String readCString(int i) throws IOException {
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        readFully(bArr, 0, i2);
        if (this.in.read() != -1) {
            return this.zipEncoding.decode(bArr);
        }
        throw new EOFException();
    }

    public long skip(long j) throws IOException {
        if (j >= 0) {
            ensureOpen();
            int min = (int) Math.min(j, 2147483647L);
            int i = 0;
            while (true) {
                if (i >= min) {
                    break;
                }
                int i2 = min - i;
                byte[] bArr = this.tmpbuf;
                if (i2 > bArr.length) {
                    i2 = bArr.length;
                }
                int read = read(bArr, 0, i2);
                if (read == -1) {
                    this.entryEOF = true;
                    break;
                }
                i += read;
            }
            return (long) i;
        }
        throw new IllegalArgumentException("Negative skip length");
    }

    public ArchiveEntry getNextEntry() throws IOException {
        return getNextCPIOEntry();
    }

    private void skipRemainderOfLastBlock() throws IOException {
        long bytesRead = getBytesRead();
        int i = this.blockSize;
        long j = bytesRead % ((long) i);
        long j2 = j == 0 ? 0 : ((long) i) - j;
        while (j2 > 0) {
            long skip = skip(((long) this.blockSize) - j);
            if (skip > 0) {
                j2 -= skip;
            } else {
                return;
            }
        }
    }

    public static boolean matches(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        byte b = bArr[0];
        if (b == 113 && (bArr[1] & 255) == 199) {
            return true;
        }
        byte b2 = bArr[1];
        if (b2 == 113 && (b & 255) == 199) {
            return true;
        }
        if (b != 48 || b2 != 55 || bArr[2] != 48 || bArr[3] != 55 || bArr[4] != 48) {
            return false;
        }
        byte b3 = bArr[5];
        return b3 == 49 || b3 == 50 || b3 == 55;
    }
}
