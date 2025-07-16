package org.apache.commons.compress.archivers.tar;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import jp.co.sony.reonpocket.modules.pairing.view.PairingActivityKt;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.CountingOutputStream;
import org.apache.commons.compress.utils.FixedLengthBlockOutputStream;

public class TarArchiveOutputStream extends ArchiveOutputStream {
    private static final ZipEncoding ASCII = ZipEncodingHelper.getZipEncoding("ASCII");
    public static final int BIGNUMBER_ERROR = 0;
    public static final int BIGNUMBER_POSIX = 2;
    public static final int BIGNUMBER_STAR = 1;
    private static final int BLOCK_SIZE_UNSPECIFIED = -511;
    public static final int LONGFILE_ERROR = 0;
    public static final int LONGFILE_GNU = 2;
    public static final int LONGFILE_POSIX = 3;
    public static final int LONGFILE_TRUNCATE = 1;
    private static final int RECORD_SIZE = 512;
    private boolean addPaxHeadersForNonAsciiNames;
    private int bigNumberMode;
    private boolean closed;
    private final CountingOutputStream countingOut;
    private long currBytes;
    private String currName;
    private long currSize;
    final String encoding;
    private boolean finished;
    private boolean haveUnclosedEntry;
    private int longFileMode;
    private final FixedLengthBlockOutputStream out;
    private final byte[] recordBuf;
    private final int recordsPerBlock;
    private int recordsWritten;
    private final ZipEncoding zipEncoding;

    private boolean shouldBeReplaced(char c) {
        return c == 0 || c == '/' || c == '\\';
    }

    @Deprecated
    public int getRecordSize() {
        return 512;
    }

    public TarArchiveOutputStream(OutputStream outputStream) {
        this(outputStream, (int) BLOCK_SIZE_UNSPECIFIED);
    }

    public TarArchiveOutputStream(OutputStream outputStream, String str) {
        this(outputStream, (int) BLOCK_SIZE_UNSPECIFIED, str);
    }

    public TarArchiveOutputStream(OutputStream outputStream, int i) {
        this(outputStream, i, (String) null);
    }

    @Deprecated
    public TarArchiveOutputStream(OutputStream outputStream, int i, int i2) {
        this(outputStream, i, i2, (String) null);
    }

    @Deprecated
    public TarArchiveOutputStream(OutputStream outputStream, int i, int i2, String str) {
        this(outputStream, i, str);
        if (i2 != 512) {
            throw new IllegalArgumentException("Tar record size must always be 512 bytes. Attempt to set size of " + i2);
        }
    }

    public TarArchiveOutputStream(OutputStream outputStream, int i, String str) {
        this.longFileMode = 0;
        this.bigNumberMode = 0;
        this.closed = false;
        this.haveUnclosedEntry = false;
        this.finished = false;
        this.addPaxHeadersForNonAsciiNames = false;
        int i2 = BLOCK_SIZE_UNSPECIFIED == i ? 512 : i;
        if (i2 <= 0 || i2 % 512 != 0) {
            throw new IllegalArgumentException("Block size must be a multiple of 512 bytes. Attempt to use set size of " + i);
        }
        CountingOutputStream countingOutputStream = new CountingOutputStream(outputStream);
        this.countingOut = countingOutputStream;
        this.out = new FixedLengthBlockOutputStream((OutputStream) countingOutputStream, 512);
        this.encoding = str;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(str);
        this.recordBuf = new byte[512];
        this.recordsPerBlock = i2 / 512;
    }

    public void setLongFileMode(int i) {
        this.longFileMode = i;
    }

    public void setBigNumberMode(int i) {
        this.bigNumberMode = i;
    }

    public void setAddPaxHeadersForNonAsciiNames(boolean z) {
        this.addPaxHeadersForNonAsciiNames = z;
    }

    @Deprecated
    public int getCount() {
        return (int) getBytesWritten();
    }

    public long getBytesWritten() {
        return this.countingOut.getBytesWritten();
    }

    public void finish() throws IOException {
        if (this.finished) {
            throw new IOException("This archive has already been finished");
        } else if (!this.haveUnclosedEntry) {
            writeEOFRecord();
            writeEOFRecord();
            padAsNeeded();
            this.out.flush();
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

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void putArchiveEntry(org.apache.commons.compress.archivers.ArchiveEntry r18) throws java.io.IOException {
        /*
            r17 = this;
            r7 = r17
            boolean r0 = r7.finished
            if (r0 != 0) goto L_0x00fa
            r8 = r18
            org.apache.commons.compress.archivers.tar.TarArchiveEntry r8 = (org.apache.commons.compress.archivers.tar.TarArchiveEntry) r8
            boolean r0 = r8.isGlobalPaxHeader()
            r9 = 0
            r12 = 1
            if (r0 == 0) goto L_0x0045
            java.util.Map r0 = r8.getExtraPaxHeaders()
            byte[] r0 = r7.encodeExtendedPaxHeadersContents(r0)
            int r1 = r0.length
            long r1 = (long) r1
            r8.setSize(r1)
            byte[] r1 = r7.recordBuf
            org.apache.commons.compress.archivers.zip.ZipEncoding r2 = r7.zipEncoding
            int r3 = r7.bigNumberMode
            if (r3 != r12) goto L_0x002a
            r11 = r12
            goto L_0x002b
        L_0x002a:
            r11 = 0
        L_0x002b:
            r8.writeEntryHeader(r1, r2, r11)
            byte[] r1 = r7.recordBuf
            r7.writeRecord(r1)
            long r1 = r8.getSize()
            r7.currSize = r1
            r7.currBytes = r9
            r7.haveUnclosedEntry = r12
            r7.write(r0)
            r17.closeArchiveEntry()
            goto L_0x00f9
        L_0x0045:
            java.util.HashMap r13 = new java.util.HashMap
            r13.<init>()
            java.lang.String r14 = r8.getName()
            r5 = 76
            java.lang.String r6 = "file name"
            java.lang.String r4 = "path"
            r0 = r17
            r1 = r8
            r2 = r14
            r3 = r13
            boolean r15 = r0.handleLongName(r1, r2, r3, r4, r5, r6)
            java.lang.String r6 = r8.getLinkName()
            if (r6 == 0) goto L_0x007f
            int r0 = r6.length()
            if (r0 <= 0) goto L_0x007f
            r5 = 75
            java.lang.String r16 = "link name"
            java.lang.String r4 = "linkpath"
            r0 = r17
            r1 = r8
            r2 = r6
            r3 = r13
            r11 = r6
            r6 = r16
            boolean r0 = r0.handleLongName(r1, r2, r3, r4, r5, r6)
            if (r0 == 0) goto L_0x0080
            r0 = r12
            goto L_0x0081
        L_0x007f:
            r11 = r6
        L_0x0080:
            r0 = 0
        L_0x0081:
            int r1 = r7.bigNumberMode
            r2 = 2
            if (r1 != r2) goto L_0x008a
            r7.addPaxHeadersForBigNumbers(r13, r8)
            goto L_0x008f
        L_0x008a:
            if (r1 == r12) goto L_0x008f
            r7.failForBigNumbers(r8)
        L_0x008f:
            boolean r1 = r7.addPaxHeadersForNonAsciiNames
            if (r1 == 0) goto L_0x00a2
            if (r15 != 0) goto L_0x00a2
            org.apache.commons.compress.archivers.zip.ZipEncoding r1 = ASCII
            boolean r1 = r1.canEncode(r14)
            if (r1 != 0) goto L_0x00a2
            java.lang.String r1 = "path"
            r13.put(r1, r14)
        L_0x00a2:
            boolean r1 = r7.addPaxHeadersForNonAsciiNames
            if (r1 == 0) goto L_0x00c1
            if (r0 != 0) goto L_0x00c1
            boolean r0 = r8.isLink()
            if (r0 != 0) goto L_0x00b4
            boolean r0 = r8.isSymbolicLink()
            if (r0 == 0) goto L_0x00c1
        L_0x00b4:
            org.apache.commons.compress.archivers.zip.ZipEncoding r0 = ASCII
            boolean r0 = r0.canEncode(r11)
            if (r0 != 0) goto L_0x00c1
            java.lang.String r0 = "linkpath"
            r13.put(r0, r11)
        L_0x00c1:
            java.util.Map r0 = r8.getExtraPaxHeaders()
            r13.putAll(r0)
            int r0 = r13.size()
            if (r0 <= 0) goto L_0x00d1
            r7.writePaxHeaders(r8, r14, r13)
        L_0x00d1:
            byte[] r0 = r7.recordBuf
            org.apache.commons.compress.archivers.zip.ZipEncoding r1 = r7.zipEncoding
            int r2 = r7.bigNumberMode
            if (r2 != r12) goto L_0x00db
            r11 = r12
            goto L_0x00dc
        L_0x00db:
            r11 = 0
        L_0x00dc:
            r8.writeEntryHeader(r0, r1, r11)
            byte[] r0 = r7.recordBuf
            r7.writeRecord(r0)
            r7.currBytes = r9
            boolean r0 = r8.isDirectory()
            if (r0 == 0) goto L_0x00ef
            r7.currSize = r9
            goto L_0x00f5
        L_0x00ef:
            long r0 = r8.getSize()
            r7.currSize = r0
        L_0x00f5:
            r7.currName = r14
            r7.haveUnclosedEntry = r12
        L_0x00f9:
            return
        L_0x00fa:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Stream has already been finished"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.tar.TarArchiveOutputStream.putArchiveEntry(org.apache.commons.compress.archivers.ArchiveEntry):void");
    }

    public void closeArchiveEntry() throws IOException {
        if (this.finished) {
            throw new IOException("Stream has already been finished");
        } else if (this.haveUnclosedEntry) {
            this.out.flushBlock();
            long j = this.currBytes;
            long j2 = this.currSize;
            if (j >= j2) {
                int i = (int) (((long) this.recordsWritten) + (j2 / 512));
                this.recordsWritten = i;
                if (0 != j2 % 512) {
                    this.recordsWritten = i + 1;
                }
                this.haveUnclosedEntry = false;
                return;
            }
            throw new IOException("Entry '" + this.currName + "' closed at '" + this.currBytes + "' before the '" + this.currSize + "' bytes specified in the header were written");
        } else {
            throw new IOException("No current entry to close");
        }
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.haveUnclosedEntry) {
            long j = (long) i2;
            if (this.currBytes + j <= this.currSize) {
                this.out.write(bArr, i, i2);
                this.currBytes += j;
                return;
            }
            throw new IOException("Request to write '" + i2 + "' bytes exceeds size in header of '" + this.currSize + "' bytes for entry '" + this.currName + "'");
        }
        throw new IllegalStateException("No current tar entry");
    }

    /* access modifiers changed from: package-private */
    public void writePaxHeaders(TarArchiveEntry tarArchiveEntry, String str, Map<String, String> map) throws IOException {
        String str2 = "./PaxHeaders.X/" + stripTo7Bits(str);
        if (str2.length() >= 100) {
            str2 = str2.substring(0, 99);
        }
        TarArchiveEntry tarArchiveEntry2 = new TarArchiveEntry(str2, (byte) TarConstants.LF_PAX_EXTENDED_HEADER_LC);
        transferModTime(tarArchiveEntry, tarArchiveEntry2);
        byte[] encodeExtendedPaxHeadersContents = encodeExtendedPaxHeadersContents(map);
        tarArchiveEntry2.setSize((long) encodeExtendedPaxHeadersContents.length);
        putArchiveEntry(tarArchiveEntry2);
        write(encodeExtendedPaxHeadersContents);
        closeArchiveEntry();
    }

    private byte[] encodeExtendedPaxHeadersContents(Map<String, String> map) throws UnsupportedEncodingException {
        StringWriter stringWriter = new StringWriter();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) next.getValue();
            int length = str.length() + str2.length() + 5;
            String str3 = length + " " + str + "=" + str2 + "\n";
            int length2 = str3.getBytes("UTF-8").length;
            while (length != length2) {
                str3 = length2 + " " + str + "=" + str2 + "\n";
                int i = length2;
                length2 = str3.getBytes("UTF-8").length;
                length = i;
            }
            stringWriter.write(str3);
        }
        return stringWriter.toString().getBytes("UTF-8");
    }

    private String stripTo7Bits(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char charAt = (char) (str.charAt(i) & 127);
            if (shouldBeReplaced(charAt)) {
                sb.append("_");
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    private void writeEOFRecord() throws IOException {
        Arrays.fill(this.recordBuf, (byte) 0);
        writeRecord(this.recordBuf);
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public ArchiveEntry createArchiveEntry(File file, String str) throws IOException {
        if (!this.finished) {
            return new TarArchiveEntry(file, str);
        }
        throw new IOException("Stream has already been finished");
    }

    private void writeRecord(byte[] bArr) throws IOException {
        if (bArr.length == 512) {
            this.out.write(bArr);
            this.recordsWritten++;
            return;
        }
        throw new IOException("Record to write has length '" + bArr.length + "' which is not the record size of '512'");
    }

    private void padAsNeeded() throws IOException {
        int i = this.recordsWritten % this.recordsPerBlock;
        if (i != 0) {
            while (i < this.recordsPerBlock) {
                writeEOFRecord();
                i++;
            }
        }
    }

    private void addPaxHeadersForBigNumbers(Map<String, String> map, TarArchiveEntry tarArchiveEntry) {
        addPaxHeaderForBigNumber(map, "size", tarArchiveEntry.getSize(), TarConstants.MAXSIZE);
        addPaxHeaderForBigNumber(map, "gid", tarArchiveEntry.getLongGroupId(), TarConstants.MAXID);
        addPaxHeaderForBigNumber(map, "mtime", tarArchiveEntry.getModTime().getTime() / 1000, TarConstants.MAXSIZE);
        addPaxHeaderForBigNumber(map, "uid", tarArchiveEntry.getLongUserId(), TarConstants.MAXID);
        Map<String, String> map2 = map;
        addPaxHeaderForBigNumber(map2, "SCHILY.devmajor", (long) tarArchiveEntry.getDevMajor(), TarConstants.MAXID);
        addPaxHeaderForBigNumber(map2, "SCHILY.devminor", (long) tarArchiveEntry.getDevMinor(), TarConstants.MAXID);
        failForBigNumber(PairingActivityKt.TRANSIT_TO_MAIN_MODE, (long) tarArchiveEntry.getMode(), TarConstants.MAXID);
    }

    private void addPaxHeaderForBigNumber(Map<String, String> map, String str, long j, long j2) {
        if (j < 0 || j > j2) {
            map.put(str, String.valueOf(j));
        }
    }

    private void failForBigNumbers(TarArchiveEntry tarArchiveEntry) {
        failForBigNumber("entry size", tarArchiveEntry.getSize(), TarConstants.MAXSIZE);
        failForBigNumberWithPosixMessage("group id", tarArchiveEntry.getLongGroupId(), TarConstants.MAXID);
        failForBigNumber("last modification time", tarArchiveEntry.getModTime().getTime() / 1000, TarConstants.MAXSIZE);
        failForBigNumber("user id", tarArchiveEntry.getLongUserId(), TarConstants.MAXID);
        failForBigNumber(PairingActivityKt.TRANSIT_TO_MAIN_MODE, (long) tarArchiveEntry.getMode(), TarConstants.MAXID);
        failForBigNumber("major device number", (long) tarArchiveEntry.getDevMajor(), TarConstants.MAXID);
        failForBigNumber("minor device number", (long) tarArchiveEntry.getDevMinor(), TarConstants.MAXID);
    }

    private void failForBigNumber(String str, long j, long j2) {
        failForBigNumber(str, j, j2, "");
    }

    private void failForBigNumberWithPosixMessage(String str, long j, long j2) {
        failForBigNumber(str, j, j2, " Use STAR or POSIX extensions to overcome this limit");
    }

    private void failForBigNumber(String str, long j, long j2, String str2) {
        if (j < 0 || j > j2) {
            throw new RuntimeException(str + " '" + j + "' is too big ( > " + j2 + " )." + str2);
        }
    }

    private boolean handleLongName(TarArchiveEntry tarArchiveEntry, String str, Map<String, String> map, String str2, byte b, String str3) throws IOException {
        ByteBuffer encode = this.zipEncoding.encode(str);
        int limit = encode.limit() - encode.position();
        if (limit >= 100) {
            int i = this.longFileMode;
            if (i == 3) {
                map.put(str2, str);
                return true;
            } else if (i == 2) {
                TarArchiveEntry tarArchiveEntry2 = new TarArchiveEntry(TarConstants.GNU_LONGLINK, b);
                tarArchiveEntry2.setSize(((long) limit) + 1);
                transferModTime(tarArchiveEntry, tarArchiveEntry2);
                putArchiveEntry(tarArchiveEntry2);
                write(encode.array(), encode.arrayOffset(), limit);
                write(0);
                closeArchiveEntry();
            } else if (i != 1) {
                throw new RuntimeException(str3 + " '" + str + "' is too long ( > 100 bytes)");
            }
        }
        return false;
    }

    private void transferModTime(TarArchiveEntry tarArchiveEntry, TarArchiveEntry tarArchiveEntry2) {
        Date modTime = tarArchiveEntry.getModTime();
        long time = modTime.getTime() / 1000;
        if (time < 0 || time > TarConstants.MAXSIZE) {
            modTime = new Date(0);
        }
        tarArchiveEntry2.setModTime(modTime);
    }
}
