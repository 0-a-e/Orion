package org.apache.commons.compress.archivers.tar;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;

public class TarArchiveInputStream extends ArchiveInputStream {
    private static final int SMALL_BUFFER_SIZE = 256;
    private final int blockSize;
    private TarArchiveEntry currEntry;
    final String encoding;
    private long entryOffset;
    private long entrySize;
    private Map<String, String> globalPaxHeaders;
    private boolean hasHitEOF;
    private final InputStream is;
    private final boolean lenient;
    private final int recordSize;
    private final byte[] smallBuf;
    private final ZipEncoding zipEncoding;

    public void mark(int i) {
    }

    public boolean markSupported() {
        return false;
    }

    public TarArchiveInputStream(InputStream inputStream) {
        this(inputStream, (int) TarConstants.DEFAULT_BLKSIZE, 512);
    }

    public TarArchiveInputStream(InputStream inputStream, boolean z) {
        this(inputStream, TarConstants.DEFAULT_BLKSIZE, 512, (String) null, z);
    }

    public TarArchiveInputStream(InputStream inputStream, String str) {
        this(inputStream, TarConstants.DEFAULT_BLKSIZE, 512, str);
    }

    public TarArchiveInputStream(InputStream inputStream, int i) {
        this(inputStream, i, 512);
    }

    public TarArchiveInputStream(InputStream inputStream, int i, String str) {
        this(inputStream, i, 512, str);
    }

    public TarArchiveInputStream(InputStream inputStream, int i, int i2) {
        this(inputStream, i, i2, (String) null);
    }

    public TarArchiveInputStream(InputStream inputStream, int i, int i2, String str) {
        this(inputStream, i, i2, str, false);
    }

    public TarArchiveInputStream(InputStream inputStream, int i, int i2, String str, boolean z) {
        this.smallBuf = new byte[256];
        this.globalPaxHeaders = new HashMap();
        this.is = inputStream;
        this.hasHitEOF = false;
        this.encoding = str;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(str);
        this.recordSize = i2;
        this.blockSize = i;
        this.lenient = z;
    }

    public void close() throws IOException {
        this.is.close();
    }

    public int getRecordSize() {
        return this.recordSize;
    }

    public int available() throws IOException {
        if (isDirectory()) {
            return 0;
        }
        long j = this.entrySize;
        long j2 = this.entryOffset;
        if (j - j2 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) (j - j2);
    }

    public long skip(long j) throws IOException {
        if (j <= 0 || isDirectory()) {
            return 0;
        }
        long skip = IOUtils.skip(this.is, Math.min(j, this.entrySize - this.entryOffset));
        count(skip);
        this.entryOffset += skip;
        return skip;
    }

    public synchronized void reset() {
    }

    public TarArchiveEntry getNextTarEntry() throws IOException {
        if (isAtEOF()) {
            return null;
        }
        if (this.currEntry != null) {
            IOUtils.skip(this, Long.MAX_VALUE);
            skipRecordPadding();
        }
        byte[] record = getRecord();
        if (record == null) {
            this.currEntry = null;
            return null;
        }
        try {
            TarArchiveEntry tarArchiveEntry = new TarArchiveEntry(record, this.zipEncoding, this.lenient);
            this.currEntry = tarArchiveEntry;
            this.entryOffset = 0;
            this.entrySize = tarArchiveEntry.getSize();
            if (this.currEntry.isGNULongLinkEntry()) {
                byte[] longNameData = getLongNameData();
                if (longNameData == null) {
                    return null;
                }
                this.currEntry.setLinkName(this.zipEncoding.decode(longNameData));
            }
            if (this.currEntry.isGNULongNameEntry()) {
                byte[] longNameData2 = getLongNameData();
                if (longNameData2 == null) {
                    return null;
                }
                this.currEntry.setName(this.zipEncoding.decode(longNameData2));
            }
            if (this.currEntry.isGlobalPaxHeader()) {
                readGlobalPaxHeaders();
            }
            if (this.currEntry.isPaxHeader()) {
                paxHeaders();
            } else if (!this.globalPaxHeaders.isEmpty()) {
                applyPaxHeadersToCurrentEntry(this.globalPaxHeaders);
            }
            if (this.currEntry.isOldGNUSparse()) {
                readOldGNUSparse();
            }
            this.entrySize = this.currEntry.getSize();
            return this.currEntry;
        } catch (IllegalArgumentException e) {
            throw new IOException("Error detected parsing the header", e);
        }
    }

    private void skipRecordPadding() throws IOException {
        if (!isDirectory()) {
            long j = this.entrySize;
            if (j > 0) {
                int i = this.recordSize;
                if (j % ((long) i) != 0) {
                    count(IOUtils.skip(this.is, (((j / ((long) i)) + 1) * ((long) i)) - j));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public byte[] getLongNameData() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = read(this.smallBuf);
            if (read < 0) {
                break;
            }
            byteArrayOutputStream.write(this.smallBuf, 0, read);
        }
        getNextEntry();
        if (this.currEntry == null) {
            return null;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        int length = byteArray.length;
        while (length > 0 && byteArray[length - 1] == 0) {
            length--;
        }
        if (length == byteArray.length) {
            return byteArray;
        }
        byte[] bArr = new byte[length];
        System.arraycopy(byteArray, 0, bArr, 0, length);
        return bArr;
    }

    private byte[] getRecord() throws IOException {
        byte[] readRecord = readRecord();
        setAtEOF(isEOFRecord(readRecord));
        if (!isAtEOF() || readRecord == null) {
            return readRecord;
        }
        tryToConsumeSecondEOFRecord();
        consumeRemainderOfLastBlock();
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean isEOFRecord(byte[] bArr) {
        return bArr == null || ArchiveUtils.isArrayZero(bArr, this.recordSize);
    }

    /* access modifiers changed from: protected */
    public byte[] readRecord() throws IOException {
        byte[] bArr = new byte[this.recordSize];
        int readFully = IOUtils.readFully(this.is, bArr);
        count(readFully);
        if (readFully != this.recordSize) {
            return null;
        }
        return bArr;
    }

    private void readGlobalPaxHeaders() throws IOException {
        this.globalPaxHeaders = parsePaxHeaders(this);
        getNextEntry();
    }

    private void paxHeaders() throws IOException {
        Map<String, String> parsePaxHeaders = parsePaxHeaders(this);
        getNextEntry();
        applyPaxHeadersToCurrentEntry(parsePaxHeaders);
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> parsePaxHeaders(InputStream inputStream) throws IOException {
        int read;
        int read2;
        HashMap hashMap = new HashMap(this.globalPaxHeaders);
        do {
            int i = 0;
            int i2 = 0;
            while (true) {
                read = inputStream.read();
                if (read == -1) {
                    break;
                }
                i++;
                if (read == 10) {
                    continue;
                    break;
                } else if (read == 32) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        read2 = inputStream.read();
                        if (read2 == -1) {
                            break;
                        }
                        i++;
                        if (read2 == 61) {
                            String byteArrayOutputStream2 = byteArrayOutputStream.toString("UTF-8");
                            int i3 = i2 - i;
                            if (i3 == 1) {
                                hashMap.remove(byteArrayOutputStream2);
                            } else {
                                byte[] bArr = new byte[i3];
                                int readFully = IOUtils.readFully(inputStream, bArr);
                                if (readFully == i3) {
                                    hashMap.put(byteArrayOutputStream2, new String(bArr, 0, i3 - 1, "UTF-8"));
                                } else {
                                    throw new IOException("Failed to read Paxheader. Expected " + i3 + " bytes, read " + readFully);
                                }
                            }
                        } else {
                            byteArrayOutputStream.write((byte) read2);
                        }
                    }
                    read = read2;
                    continue;
                } else {
                    i2 = (i2 * 10) + (read - 48);
                }
            }
        } while (read != -1);
        return hashMap;
    }

    private void applyPaxHeadersToCurrentEntry(Map<String, String> map) {
        this.currEntry.updateEntryFromPaxHeaders(map);
    }

    private void readOldGNUSparse() throws IOException {
        byte[] record;
        if (this.currEntry.isExtended()) {
            do {
                record = getRecord();
                if (record == null) {
                    this.currEntry = null;
                    return;
                }
            } while (new TarArchiveSparseEntry(record).isExtended());
        }
    }

    private boolean isDirectory() {
        TarArchiveEntry tarArchiveEntry = this.currEntry;
        return tarArchiveEntry != null && tarArchiveEntry.isDirectory();
    }

    public ArchiveEntry getNextEntry() throws IOException {
        return getNextTarEntry();
    }

    private void tryToConsumeSecondEOFRecord() throws IOException {
        boolean markSupported = this.is.markSupported();
        if (markSupported) {
            this.is.mark(this.recordSize);
        }
        try {
            if ((!isEOFRecord(readRecord())) && markSupported) {
            }
        } finally {
            if (markSupported) {
                pushedBackBytes((long) this.recordSize);
                this.is.reset();
            }
        }
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (isAtEOF() || isDirectory() || this.entryOffset >= this.entrySize) {
            return -1;
        }
        if (this.currEntry != null) {
            int min = Math.min(i2, available());
            int read = this.is.read(bArr, i, min);
            if (read != -1) {
                count(read);
                this.entryOffset += (long) read;
            } else if (min <= 0) {
                setAtEOF(true);
            } else {
                throw new IOException("Truncated TAR archive");
            }
            return read;
        }
        throw new IllegalStateException("No current tar entry");
    }

    public boolean canReadEntryData(ArchiveEntry archiveEntry) {
        if (archiveEntry instanceof TarArchiveEntry) {
            return !((TarArchiveEntry) archiveEntry).isSparse();
        }
        return false;
    }

    public TarArchiveEntry getCurrentEntry() {
        return this.currEntry;
    }

    /* access modifiers changed from: protected */
    public final void setCurrentEntry(TarArchiveEntry tarArchiveEntry) {
        this.currEntry = tarArchiveEntry;
    }

    /* access modifiers changed from: protected */
    public final boolean isAtEOF() {
        return this.hasHitEOF;
    }

    /* access modifiers changed from: protected */
    public final void setAtEOF(boolean z) {
        this.hasHitEOF = z;
    }

    private void consumeRemainderOfLastBlock() throws IOException {
        long bytesRead = getBytesRead();
        int i = this.blockSize;
        long j = bytesRead % ((long) i);
        if (j > 0) {
            count(IOUtils.skip(this.is, ((long) i) - j));
        }
    }

    public static boolean matches(byte[] bArr, int i) {
        if (i < 265) {
            return false;
        }
        if (ArchiveUtils.matchAsciiBuffer("ustar\u0000", bArr, 257, 6) && ArchiveUtils.matchAsciiBuffer(TarConstants.VERSION_POSIX, bArr, TarConstants.VERSION_OFFSET, 2)) {
            return true;
        }
        if (ArchiveUtils.matchAsciiBuffer(TarConstants.MAGIC_GNU, bArr, 257, 6) && (ArchiveUtils.matchAsciiBuffer(TarConstants.VERSION_GNU_SPACE, bArr, TarConstants.VERSION_OFFSET, 2) || ArchiveUtils.matchAsciiBuffer(TarConstants.VERSION_GNU_ZERO, bArr, TarConstants.VERSION_OFFSET, 2))) {
            return true;
        }
        if (!ArchiveUtils.matchAsciiBuffer("ustar\u0000", bArr, 257, 6) || !ArchiveUtils.matchAsciiBuffer(TarConstants.VERSION_ANT, bArr, TarConstants.VERSION_OFFSET, 2)) {
            return false;
        }
        return true;
    }
}
