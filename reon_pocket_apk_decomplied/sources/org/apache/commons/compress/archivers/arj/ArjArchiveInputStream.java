package org.apache.commons.compress.archivers.arj;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.utils.BoundedInputStream;
import org.apache.commons.compress.utils.CRC32VerifyingInputStream;
import org.apache.commons.compress.utils.IOUtils;

public class ArjArchiveInputStream extends ArchiveInputStream {
    private static final int ARJ_MAGIC_1 = 96;
    private static final int ARJ_MAGIC_2 = 234;
    private final String charsetName;
    private InputStream currentInputStream;
    private LocalFileHeader currentLocalFileHeader;
    private final DataInputStream in;
    private final MainHeader mainHeader;

    public ArjArchiveInputStream(InputStream inputStream, String str) throws ArchiveException {
        this.currentLocalFileHeader = null;
        this.currentInputStream = null;
        this.in = new DataInputStream(inputStream);
        this.charsetName = str;
        try {
            MainHeader readMainHeader = readMainHeader();
            this.mainHeader = readMainHeader;
            if ((readMainHeader.arjFlags & 1) != 0) {
                throw new ArchiveException("Encrypted ARJ files are unsupported");
            } else if ((readMainHeader.arjFlags & 4) != 0) {
                throw new ArchiveException("Multi-volume ARJ files are unsupported");
            }
        } catch (IOException e) {
            throw new ArchiveException(e.getMessage(), e);
        }
    }

    public ArjArchiveInputStream(InputStream inputStream) throws ArchiveException {
        this(inputStream, "CP437");
    }

    public void close() throws IOException {
        this.in.close();
    }

    private int read8(DataInputStream dataInputStream) throws IOException {
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        count(1);
        return readUnsignedByte;
    }

    private int read16(DataInputStream dataInputStream) throws IOException {
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        count(2);
        return Integer.reverseBytes(readUnsignedShort) >>> 16;
    }

    private int read32(DataInputStream dataInputStream) throws IOException {
        int readInt = dataInputStream.readInt();
        count(4);
        return Integer.reverseBytes(readInt);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r4 = new java.lang.String(r0.toByteArray());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0036, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
        r4.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
        if (r3.charsetName == null) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0013, code lost:
        r4 = new java.lang.String(r0.toByteArray(), r3.charsetName);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String readString(java.io.DataInputStream r4) throws java.io.IOException {
        /*
            r3 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
        L_0x0005:
            int r1 = r4.readUnsignedByte()     // Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x000f
            r0.write(r1)     // Catch:{ all -> 0x002f }
            goto L_0x0005
        L_0x000f:
            java.lang.String r4 = r3.charsetName     // Catch:{ all -> 0x002f }
            if (r4 == 0) goto L_0x0022
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x002f }
            byte[] r1 = r0.toByteArray()     // Catch:{ all -> 0x002f }
            java.lang.String r2 = r3.charsetName     // Catch:{ all -> 0x002f }
            r4.<init>(r1, r2)     // Catch:{ all -> 0x002f }
            r0.close()
            return r4
        L_0x0022:
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x002f }
            byte[] r1 = r0.toByteArray()     // Catch:{ all -> 0x002f }
            r4.<init>(r1)     // Catch:{ all -> 0x002f }
            r0.close()
            return r4
        L_0x002f:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0031 }
        L_0x0031:
            r1 = move-exception
            r0.close()     // Catch:{ all -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r0 = move-exception
            r4.addSuppressed(r0)
        L_0x003a:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.arj.ArjArchiveInputStream.readString(java.io.DataInputStream):java.lang.String");
    }

    private void readFully(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        dataInputStream.readFully(bArr);
        count(bArr.length);
    }

    private byte[] readHeader() throws IOException {
        boolean z = false;
        byte[] bArr = null;
        do {
            int read8 = read8(this.in);
            while (true) {
                int read82 = read8(this.in);
                if (read8 == 96 || read82 == ARJ_MAGIC_2) {
                    int read16 = read16(this.in);
                } else {
                    read8 = read82;
                }
            }
            int read162 = read16(this.in);
            if (read162 == 0) {
                return null;
            }
            if (read162 <= 2600) {
                bArr = new byte[read162];
                readFully(this.in, bArr);
                CRC32 crc32 = new CRC32();
                crc32.update(bArr);
                if ((((long) read32(this.in)) & 4294967295L) == crc32.getValue()) {
                    z = true;
                    continue;
                } else {
                    continue;
                }
            }
        } while (!z);
        return bArr;
    }

    private MainHeader readMainHeader() throws IOException {
        byte[] readHeader = readHeader();
        if (readHeader != null) {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(readHeader));
            int readUnsignedByte = dataInputStream.readUnsignedByte();
            byte[] bArr = new byte[(readUnsignedByte - 1)];
            dataInputStream.readFully(bArr);
            DataInputStream dataInputStream2 = new DataInputStream(new ByteArrayInputStream(bArr));
            MainHeader mainHeader2 = new MainHeader();
            mainHeader2.archiverVersionNumber = dataInputStream2.readUnsignedByte();
            mainHeader2.minVersionToExtract = dataInputStream2.readUnsignedByte();
            mainHeader2.hostOS = dataInputStream2.readUnsignedByte();
            mainHeader2.arjFlags = dataInputStream2.readUnsignedByte();
            mainHeader2.securityVersion = dataInputStream2.readUnsignedByte();
            mainHeader2.fileType = dataInputStream2.readUnsignedByte();
            mainHeader2.reserved = dataInputStream2.readUnsignedByte();
            mainHeader2.dateTimeCreated = read32(dataInputStream2);
            mainHeader2.dateTimeModified = read32(dataInputStream2);
            mainHeader2.archiveSize = ((long) read32(dataInputStream2)) & 4294967295L;
            mainHeader2.securityEnvelopeFilePosition = read32(dataInputStream2);
            mainHeader2.fileSpecPosition = read16(dataInputStream2);
            mainHeader2.securityEnvelopeLength = read16(dataInputStream2);
            pushedBackBytes(20);
            mainHeader2.encryptionVersion = dataInputStream2.readUnsignedByte();
            mainHeader2.lastChapter = dataInputStream2.readUnsignedByte();
            if (readUnsignedByte >= 33) {
                mainHeader2.arjProtectionFactor = dataInputStream2.readUnsignedByte();
                mainHeader2.arjFlags2 = dataInputStream2.readUnsignedByte();
                dataInputStream2.readUnsignedByte();
                dataInputStream2.readUnsignedByte();
            }
            mainHeader2.name = readString(dataInputStream);
            mainHeader2.comment = readString(dataInputStream);
            int read16 = read16(this.in);
            if (read16 > 0) {
                mainHeader2.extendedHeaderBytes = new byte[read16];
                readFully(this.in, mainHeader2.extendedHeaderBytes);
                CRC32 crc32 = new CRC32();
                crc32.update(mainHeader2.extendedHeaderBytes);
                if ((((long) read32(this.in)) & 4294967295L) != crc32.getValue()) {
                    throw new IOException("Extended header CRC32 verification failure");
                }
            }
            return mainHeader2;
        }
        throw new IOException("Archive ends without any headers");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00f1, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00f6, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r0.addSuppressed(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00fa, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00fd, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0102, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0103, code lost:
        r0.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0106, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.apache.commons.compress.archivers.arj.LocalFileHeader readLocalFileHeader() throws java.io.IOException {
        /*
            r12 = this;
            byte[] r0 = r12.readHeader()
            if (r0 != 0) goto L_0x0008
            r0 = 0
            return r0
        L_0x0008:
            java.io.DataInputStream r1 = new java.io.DataInputStream
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream
            r2.<init>(r0)
            r1.<init>(r2)
            int r0 = r1.readUnsignedByte()     // Catch:{ all -> 0x00fb }
            int r2 = r0 + -1
            byte[] r2 = new byte[r2]     // Catch:{ all -> 0x00fb }
            r1.readFully(r2)     // Catch:{ all -> 0x00fb }
            java.io.DataInputStream r3 = new java.io.DataInputStream     // Catch:{ all -> 0x00fb }
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x00fb }
            r4.<init>(r2)     // Catch:{ all -> 0x00fb }
            r3.<init>(r4)     // Catch:{ all -> 0x00fb }
            org.apache.commons.compress.archivers.arj.LocalFileHeader r2 = new org.apache.commons.compress.archivers.arj.LocalFileHeader     // Catch:{ all -> 0x00ef }
            r2.<init>()     // Catch:{ all -> 0x00ef }
            int r4 = r3.readUnsignedByte()     // Catch:{ all -> 0x00ef }
            r2.archiverVersionNumber = r4     // Catch:{ all -> 0x00ef }
            int r4 = r3.readUnsignedByte()     // Catch:{ all -> 0x00ef }
            r2.minVersionToExtract = r4     // Catch:{ all -> 0x00ef }
            int r4 = r3.readUnsignedByte()     // Catch:{ all -> 0x00ef }
            r2.hostOS = r4     // Catch:{ all -> 0x00ef }
            int r4 = r3.readUnsignedByte()     // Catch:{ all -> 0x00ef }
            r2.arjFlags = r4     // Catch:{ all -> 0x00ef }
            int r4 = r3.readUnsignedByte()     // Catch:{ all -> 0x00ef }
            r2.method = r4     // Catch:{ all -> 0x00ef }
            int r4 = r3.readUnsignedByte()     // Catch:{ all -> 0x00ef }
            r2.fileType = r4     // Catch:{ all -> 0x00ef }
            int r4 = r3.readUnsignedByte()     // Catch:{ all -> 0x00ef }
            r2.reserved = r4     // Catch:{ all -> 0x00ef }
            int r4 = r12.read32(r3)     // Catch:{ all -> 0x00ef }
            r2.dateTimeModified = r4     // Catch:{ all -> 0x00ef }
            int r4 = r12.read32(r3)     // Catch:{ all -> 0x00ef }
            long r4 = (long) r4     // Catch:{ all -> 0x00ef }
            r6 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r4 = r4 & r6
            r2.compressedSize = r4     // Catch:{ all -> 0x00ef }
            int r4 = r12.read32(r3)     // Catch:{ all -> 0x00ef }
            long r4 = (long) r4     // Catch:{ all -> 0x00ef }
            long r4 = r4 & r6
            r2.originalSize = r4     // Catch:{ all -> 0x00ef }
            int r4 = r12.read32(r3)     // Catch:{ all -> 0x00ef }
            long r4 = (long) r4     // Catch:{ all -> 0x00ef }
            long r4 = r4 & r6
            r2.originalCrc32 = r4     // Catch:{ all -> 0x00ef }
            int r4 = r12.read16(r3)     // Catch:{ all -> 0x00ef }
            r2.fileSpecPosition = r4     // Catch:{ all -> 0x00ef }
            int r4 = r12.read16(r3)     // Catch:{ all -> 0x00ef }
            r2.fileAccessMode = r4     // Catch:{ all -> 0x00ef }
            r4 = 20
            r12.pushedBackBytes(r4)     // Catch:{ all -> 0x00ef }
            int r4 = r3.readUnsignedByte()     // Catch:{ all -> 0x00ef }
            r2.firstChapter = r4     // Catch:{ all -> 0x00ef }
            int r4 = r3.readUnsignedByte()     // Catch:{ all -> 0x00ef }
            r2.lastChapter = r4     // Catch:{ all -> 0x00ef }
            r12.readExtraData(r0, r3, r2)     // Catch:{ all -> 0x00ef }
            java.lang.String r0 = r12.readString(r1)     // Catch:{ all -> 0x00ef }
            r2.name = r0     // Catch:{ all -> 0x00ef }
            java.lang.String r0 = r12.readString(r1)     // Catch:{ all -> 0x00ef }
            r2.comment = r0     // Catch:{ all -> 0x00ef }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x00ef }
            r0.<init>()     // Catch:{ all -> 0x00ef }
        L_0x00aa:
            java.io.DataInputStream r4 = r12.in     // Catch:{ all -> 0x00ef }
            int r4 = r12.read16(r4)     // Catch:{ all -> 0x00ef }
            if (r4 <= 0) goto L_0x00dd
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x00ef }
            java.io.DataInputStream r5 = r12.in     // Catch:{ all -> 0x00ef }
            r12.readFully(r5, r4)     // Catch:{ all -> 0x00ef }
            java.io.DataInputStream r5 = r12.in     // Catch:{ all -> 0x00ef }
            int r5 = r12.read32(r5)     // Catch:{ all -> 0x00ef }
            long r8 = (long) r5     // Catch:{ all -> 0x00ef }
            long r8 = r8 & r6
            java.util.zip.CRC32 r5 = new java.util.zip.CRC32     // Catch:{ all -> 0x00ef }
            r5.<init>()     // Catch:{ all -> 0x00ef }
            r5.update(r4)     // Catch:{ all -> 0x00ef }
            long r10 = r5.getValue()     // Catch:{ all -> 0x00ef }
            int r5 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r5 != 0) goto L_0x00d5
            r0.add(r4)     // Catch:{ all -> 0x00ef }
            goto L_0x00aa
        L_0x00d5:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00ef }
            java.lang.String r2 = "Extended header CRC32 verification failure"
            r0.<init>(r2)     // Catch:{ all -> 0x00ef }
            throw r0     // Catch:{ all -> 0x00ef }
        L_0x00dd:
            r4 = 0
            byte[][] r4 = new byte[r4][]     // Catch:{ all -> 0x00ef }
            java.lang.Object[] r0 = r0.toArray(r4)     // Catch:{ all -> 0x00ef }
            byte[][] r0 = (byte[][]) r0     // Catch:{ all -> 0x00ef }
            r2.extendedHeaders = r0     // Catch:{ all -> 0x00ef }
            r3.close()     // Catch:{ all -> 0x00fb }
            r1.close()
            return r2
        L_0x00ef:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x00f1 }
        L_0x00f1:
            r2 = move-exception
            r3.close()     // Catch:{ all -> 0x00f6 }
            goto L_0x00fa
        L_0x00f6:
            r3 = move-exception
            r0.addSuppressed(r3)     // Catch:{ all -> 0x00fb }
        L_0x00fa:
            throw r2     // Catch:{ all -> 0x00fb }
        L_0x00fb:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x00fd }
        L_0x00fd:
            r2 = move-exception
            r1.close()     // Catch:{ all -> 0x0102 }
            goto L_0x0106
        L_0x0102:
            r1 = move-exception
            r0.addSuppressed(r1)
        L_0x0106:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.arj.ArjArchiveInputStream.readLocalFileHeader():org.apache.commons.compress.archivers.arj.LocalFileHeader");
    }

    private void readExtraData(int i, DataInputStream dataInputStream, LocalFileHeader localFileHeader) throws IOException {
        if (i >= 33) {
            localFileHeader.extendedFilePosition = read32(dataInputStream);
            if (i >= 45) {
                localFileHeader.dateTimeAccessed = read32(dataInputStream);
                localFileHeader.dateTimeCreated = read32(dataInputStream);
                localFileHeader.originalSizeEvenForVolumes = read32(dataInputStream);
                pushedBackBytes(12);
            }
            pushedBackBytes(4);
        }
    }

    public static boolean matches(byte[] bArr, int i) {
        return i >= 2 && (bArr[0] & 255) == 96 && (bArr[1] & 255) == ARJ_MAGIC_2;
    }

    public String getArchiveName() {
        return this.mainHeader.name;
    }

    public String getArchiveComment() {
        return this.mainHeader.comment;
    }

    public ArjArchiveEntry getNextEntry() throws IOException {
        InputStream inputStream = this.currentInputStream;
        if (inputStream != null) {
            IOUtils.skip(inputStream, Long.MAX_VALUE);
            this.currentInputStream.close();
            this.currentLocalFileHeader = null;
            this.currentInputStream = null;
        }
        LocalFileHeader readLocalFileHeader = readLocalFileHeader();
        this.currentLocalFileHeader = readLocalFileHeader;
        if (readLocalFileHeader != null) {
            this.currentInputStream = new BoundedInputStream(this.in, this.currentLocalFileHeader.compressedSize);
            if (this.currentLocalFileHeader.method == 0) {
                this.currentInputStream = new CRC32VerifyingInputStream(this.currentInputStream, this.currentLocalFileHeader.originalSize, this.currentLocalFileHeader.originalCrc32);
            }
            return new ArjArchiveEntry(this.currentLocalFileHeader);
        }
        this.currentInputStream = null;
        return null;
    }

    public boolean canReadEntryData(ArchiveEntry archiveEntry) {
        return (archiveEntry instanceof ArjArchiveEntry) && ((ArjArchiveEntry) archiveEntry).getMethod() == 0;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        LocalFileHeader localFileHeader = this.currentLocalFileHeader;
        if (localFileHeader == null) {
            throw new IllegalStateException("No current arj entry");
        } else if (localFileHeader.method == 0) {
            return this.currentInputStream.read(bArr, i, i2);
        } else {
            throw new IOException("Unsupported compression method " + this.currentLocalFileHeader.method);
        }
    }
}
