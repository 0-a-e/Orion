package org.apache.commons.compress.archivers.cpio;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.CharsetNames;

public class CpioArchiveOutputStream extends ArchiveOutputStream implements CpioConstants {
    private final int blockSize;
    private boolean closed;
    private long crc;
    final String encoding;
    private CpioArchiveEntry entry;
    private final short entryFormat;
    private boolean finished;
    private final HashMap<String, CpioArchiveEntry> names;
    private long nextArtificalDeviceAndInode;
    private final OutputStream out;
    private long written;
    private final ZipEncoding zipEncoding;

    public CpioArchiveOutputStream(OutputStream outputStream, short s) {
        this(outputStream, s, 512, CharsetNames.US_ASCII);
    }

    public CpioArchiveOutputStream(OutputStream outputStream, short s, int i) {
        this(outputStream, s, i, CharsetNames.US_ASCII);
    }

    public CpioArchiveOutputStream(OutputStream outputStream, short s, int i, String str) {
        this.closed = false;
        this.names = new HashMap<>();
        this.crc = 0;
        this.nextArtificalDeviceAndInode = 1;
        this.out = outputStream;
        if (s == 1 || s == 2 || s == 4 || s == 8) {
            this.entryFormat = s;
            this.blockSize = i;
            this.encoding = str;
            this.zipEncoding = ZipEncodingHelper.getZipEncoding(str);
            return;
        }
        throw new IllegalArgumentException("Unknown format: " + s);
    }

    public CpioArchiveOutputStream(OutputStream outputStream) {
        this(outputStream, 1);
    }

    public CpioArchiveOutputStream(OutputStream outputStream, String str) {
        this(outputStream, 1, 512, str);
    }

    private void ensureOpen() throws IOException {
        if (this.closed) {
            throw new IOException("Stream closed");
        }
    }

    public void putArchiveEntry(ArchiveEntry archiveEntry) throws IOException {
        if (!this.finished) {
            CpioArchiveEntry cpioArchiveEntry = (CpioArchiveEntry) archiveEntry;
            ensureOpen();
            if (this.entry != null) {
                closeArchiveEntry();
            }
            if (cpioArchiveEntry.getTime() == -1) {
                cpioArchiveEntry.setTime(System.currentTimeMillis() / 1000);
            }
            short format = cpioArchiveEntry.getFormat();
            if (format != this.entryFormat) {
                throw new IOException("Header format: " + format + " does not match existing format: " + this.entryFormat);
            } else if (this.names.put(cpioArchiveEntry.getName(), cpioArchiveEntry) == null) {
                writeHeader(cpioArchiveEntry);
                this.entry = cpioArchiveEntry;
                this.written = 0;
            } else {
                throw new IOException("Duplicate entry: " + cpioArchiveEntry.getName());
            }
        } else {
            throw new IOException("Stream has already been finished");
        }
    }

    private void writeHeader(CpioArchiveEntry cpioArchiveEntry) throws IOException {
        short format = cpioArchiveEntry.getFormat();
        if (format == 1) {
            this.out.write(ArchiveUtils.toAsciiBytes(CpioConstants.MAGIC_NEW));
            count(6);
            writeNewEntry(cpioArchiveEntry);
        } else if (format == 2) {
            this.out.write(ArchiveUtils.toAsciiBytes(CpioConstants.MAGIC_NEW_CRC));
            count(6);
            writeNewEntry(cpioArchiveEntry);
        } else if (format == 4) {
            this.out.write(ArchiveUtils.toAsciiBytes(CpioConstants.MAGIC_OLD_ASCII));
            count(6);
            writeOldAsciiEntry(cpioArchiveEntry);
        } else if (format == 8) {
            writeBinaryLong(29127, 2, true);
            writeOldBinaryEntry(cpioArchiveEntry, true);
        } else {
            throw new IOException("Unknown format " + cpioArchiveEntry.getFormat());
        }
    }

    private void writeNewEntry(CpioArchiveEntry cpioArchiveEntry) throws IOException {
        long inode = cpioArchiveEntry.getInode();
        long deviceMin = cpioArchiveEntry.getDeviceMin();
        if (CpioConstants.CPIO_TRAILER.equals(cpioArchiveEntry.getName())) {
            inode = 0;
            deviceMin = 0;
        } else if (inode == 0 && deviceMin == 0) {
            inode = this.nextArtificalDeviceAndInode;
            this.nextArtificalDeviceAndInode = inode + 1;
            deviceMin = inode >> 32;
        } else {
            this.nextArtificalDeviceAndInode = Math.max(this.nextArtificalDeviceAndInode, (4294967296L * deviceMin) + inode) + 1;
        }
        writeAsciiLong(inode, 8, 16);
        writeAsciiLong(cpioArchiveEntry.getMode(), 8, 16);
        writeAsciiLong(cpioArchiveEntry.getUID(), 8, 16);
        writeAsciiLong(cpioArchiveEntry.getGID(), 8, 16);
        writeAsciiLong(cpioArchiveEntry.getNumberOfLinks(), 8, 16);
        writeAsciiLong(cpioArchiveEntry.getTime(), 8, 16);
        writeAsciiLong(cpioArchiveEntry.getSize(), 8, 16);
        writeAsciiLong(cpioArchiveEntry.getDeviceMaj(), 8, 16);
        writeAsciiLong(deviceMin, 8, 16);
        writeAsciiLong(cpioArchiveEntry.getRemoteDeviceMaj(), 8, 16);
        writeAsciiLong(cpioArchiveEntry.getRemoteDeviceMin(), 8, 16);
        byte[] encode = encode(cpioArchiveEntry.getName());
        writeAsciiLong(((long) encode.length) + 1, 8, 16);
        writeAsciiLong(cpioArchiveEntry.getChksum(), 8, 16);
        writeCString(encode);
        pad(cpioArchiveEntry.getHeaderPadCount((long) encode.length));
    }

    private void writeOldAsciiEntry(CpioArchiveEntry cpioArchiveEntry) throws IOException {
        long inode = cpioArchiveEntry.getInode();
        long device = cpioArchiveEntry.getDevice();
        if (CpioConstants.CPIO_TRAILER.equals(cpioArchiveEntry.getName())) {
            inode = 0;
            device = 0;
        } else if (inode == 0 && device == 0) {
            long j = this.nextArtificalDeviceAndInode;
            this.nextArtificalDeviceAndInode = j + 1;
            device = 262143 & (j >> 18);
            inode = j & 262143;
        } else {
            this.nextArtificalDeviceAndInode = Math.max(this.nextArtificalDeviceAndInode, (262144 * device) + inode) + 1;
        }
        writeAsciiLong(device, 6, 8);
        writeAsciiLong(inode, 6, 8);
        writeAsciiLong(cpioArchiveEntry.getMode(), 6, 8);
        writeAsciiLong(cpioArchiveEntry.getUID(), 6, 8);
        writeAsciiLong(cpioArchiveEntry.getGID(), 6, 8);
        writeAsciiLong(cpioArchiveEntry.getNumberOfLinks(), 6, 8);
        writeAsciiLong(cpioArchiveEntry.getRemoteDevice(), 6, 8);
        writeAsciiLong(cpioArchiveEntry.getTime(), 11, 8);
        byte[] encode = encode(cpioArchiveEntry.getName());
        writeAsciiLong(((long) encode.length) + 1, 6, 8);
        writeAsciiLong(cpioArchiveEntry.getSize(), 11, 8);
        writeCString(encode);
    }

    private void writeOldBinaryEntry(CpioArchiveEntry cpioArchiveEntry, boolean z) throws IOException {
        long inode = cpioArchiveEntry.getInode();
        long device = cpioArchiveEntry.getDevice();
        if (CpioConstants.CPIO_TRAILER.equals(cpioArchiveEntry.getName())) {
            inode = 0;
            device = 0;
        } else if (inode == 0 && device == 0) {
            long j = this.nextArtificalDeviceAndInode;
            this.nextArtificalDeviceAndInode = j + 1;
            device = 65535 & (j >> 16);
            inode = j & 65535;
        } else {
            this.nextArtificalDeviceAndInode = Math.max(this.nextArtificalDeviceAndInode, (65536 * device) + inode) + 1;
        }
        writeBinaryLong(device, 2, z);
        writeBinaryLong(inode, 2, z);
        writeBinaryLong(cpioArchiveEntry.getMode(), 2, z);
        writeBinaryLong(cpioArchiveEntry.getUID(), 2, z);
        writeBinaryLong(cpioArchiveEntry.getGID(), 2, z);
        writeBinaryLong(cpioArchiveEntry.getNumberOfLinks(), 2, z);
        writeBinaryLong(cpioArchiveEntry.getRemoteDevice(), 2, z);
        writeBinaryLong(cpioArchiveEntry.getTime(), 4, z);
        byte[] encode = encode(cpioArchiveEntry.getName());
        writeBinaryLong(((long) encode.length) + 1, 2, z);
        writeBinaryLong(cpioArchiveEntry.getSize(), 4, z);
        writeCString(encode);
        pad(cpioArchiveEntry.getHeaderPadCount((long) encode.length));
    }

    public void closeArchiveEntry() throws IOException {
        if (!this.finished) {
            ensureOpen();
            CpioArchiveEntry cpioArchiveEntry = this.entry;
            if (cpioArchiveEntry == null) {
                throw new IOException("Trying to close non-existent entry");
            } else if (cpioArchiveEntry.getSize() == this.written) {
                pad(this.entry.getDataPadCount());
                if (this.entry.getFormat() != 2 || this.crc == this.entry.getChksum()) {
                    this.entry = null;
                    this.crc = 0;
                    this.written = 0;
                    return;
                }
                throw new IOException("CRC Error");
            } else {
                throw new IOException("Invalid entry size (expected " + this.entry.getSize() + " but got " + this.written + " bytes)");
            }
        } else {
            throw new IOException("Stream has already been finished");
        }
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        ensureOpen();
        if (i < 0 || i2 < 0 || i > bArr.length - i2) {
            throw new IndexOutOfBoundsException();
        } else if (i2 != 0) {
            CpioArchiveEntry cpioArchiveEntry = this.entry;
            if (cpioArchiveEntry != null) {
                long j = (long) i2;
                if (this.written + j <= cpioArchiveEntry.getSize()) {
                    this.out.write(bArr, i, i2);
                    this.written += j;
                    if (this.entry.getFormat() == 2) {
                        for (int i3 = 0; i3 < i2; i3++) {
                            this.crc = (this.crc + ((long) (bArr[i3] & 255))) & 4294967295L;
                        }
                    }
                    count(i2);
                    return;
                }
                throw new IOException("Attempt to write past end of STORED entry");
            }
            throw new IOException("No current CPIO entry");
        }
    }

    public void finish() throws IOException {
        ensureOpen();
        if (this.finished) {
            throw new IOException("This archive has already been finished");
        } else if (this.entry == null) {
            CpioArchiveEntry cpioArchiveEntry = new CpioArchiveEntry(this.entryFormat);
            this.entry = cpioArchiveEntry;
            cpioArchiveEntry.setName(CpioConstants.CPIO_TRAILER);
            this.entry.setNumberOfLinks(1);
            writeHeader(this.entry);
            closeArchiveEntry();
            long bytesWritten = getBytesWritten();
            int i = this.blockSize;
            int i2 = (int) (bytesWritten % ((long) i));
            if (i2 != 0) {
                pad(i - i2);
            }
            this.finished = true;
        } else {
            throw new IOException("This archive contains unclosed entries.");
        }
    }

    public void close() throws IOException {
        try {
            if (!this.finished) {
                finish();
            }
        } finally {
            if (!this.closed) {
                this.out.close();
                this.closed = true;
            }
        }
    }

    private void pad(int i) throws IOException {
        if (i > 0) {
            this.out.write(new byte[i]);
            count(i);
        }
    }

    private void writeBinaryLong(long j, int i, boolean z) throws IOException {
        byte[] long2byteArray = CpioUtil.long2byteArray(j, i, z);
        this.out.write(long2byteArray);
        count(long2byteArray.length);
    }

    private void writeAsciiLong(long j, int i, int i2) throws IOException {
        String str;
        StringBuilder sb = new StringBuilder();
        if (i2 == 16) {
            sb.append(Long.toHexString(j));
        } else if (i2 == 8) {
            sb.append(Long.toOctalString(j));
        } else {
            sb.append(Long.toString(j));
        }
        if (sb.length() <= i) {
            int length = i - sb.length();
            for (int i3 = 0; i3 < length; i3++) {
                sb.insert(0, "0");
            }
            str = sb.toString();
        } else {
            str = sb.substring(sb.length() - i);
        }
        byte[] asciiBytes = ArchiveUtils.toAsciiBytes(str);
        this.out.write(asciiBytes);
        count(asciiBytes.length);
    }

    private byte[] encode(String str) throws IOException {
        ByteBuffer encode = this.zipEncoding.encode(str);
        return Arrays.copyOfRange(encode.array(), encode.arrayOffset(), encode.arrayOffset() + (encode.limit() - encode.position()));
    }

    private void writeCString(byte[] bArr) throws IOException {
        this.out.write(bArr);
        this.out.write(0);
        count(bArr.length + 1);
    }

    public ArchiveEntry createArchiveEntry(File file, String str) throws IOException {
        if (!this.finished) {
            return new CpioArchiveEntry(file, str);
        }
        throw new IOException("Stream has already been finished");
    }
}
