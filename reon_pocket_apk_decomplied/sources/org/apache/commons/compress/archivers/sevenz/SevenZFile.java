package org.apache.commons.compress.archivers.sevenz;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.zip.CRC32;
import org.altbeacon.beacon.Beacon$$ExternalSyntheticApiModelOutline0;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.commons.compress.utils.CRC32VerifyingInputStream;
import org.apache.commons.compress.utils.CharsetNames;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

public class SevenZFile implements Closeable {
    private static final String DEFAULT_FILE_NAME = "unknown archive";
    private static final CharsetEncoder PASSWORD_ENCODER = StandardCharsets.UTF_16LE.newEncoder();
    static final int SIGNATURE_HEADER_SIZE = 32;
    static final byte[] sevenZSignature = {TarConstants.LF_CONTIG, 122, -68, -81, 39, 28};
    private final Archive archive;
    private SeekableByteChannel channel;
    /* access modifiers changed from: private */
    public long compressedBytesReadFromCurrentEntry;
    private int currentEntryIndex;
    private int currentFolderIndex;
    private InputStream currentFolderInputStream;
    private final ArrayList<InputStream> deferredBlockStreams;
    private final String fileName;
    private final SevenZFileOptions options;
    private byte[] password;
    /* access modifiers changed from: private */
    public long uncompressedBytesReadFromCurrentEntry;

    public SevenZFile(File file, char[] cArr) throws IOException {
        this(file, cArr, SevenZFileOptions.DEFAULT);
    }

    public SevenZFile(File file, char[] cArr, SevenZFileOptions sevenZFileOptions) throws IOException {
        this(Files.newByteChannel(file.toPath(), EnumSet.of(StandardOpenOption.READ), new FileAttribute[0]), file.getAbsolutePath(), utf16Decode(cArr), true, sevenZFileOptions);
    }

    public SevenZFile(File file, byte[] bArr) throws IOException {
        this(Files.newByteChannel(file.toPath(), EnumSet.of(StandardOpenOption.READ), new FileAttribute[0]), file.getAbsolutePath(), bArr, true, SevenZFileOptions.DEFAULT);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel) throws IOException {
        this(seekableByteChannel, SevenZFileOptions.DEFAULT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SevenZFile(SeekableByteChannel seekableByteChannel, SevenZFileOptions sevenZFileOptions) throws IOException {
        this(seekableByteChannel, DEFAULT_FILE_NAME, (char[]) null, sevenZFileOptions);
        char[] cArr = null;
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel, char[] cArr) throws IOException {
        this(seekableByteChannel, cArr, SevenZFileOptions.DEFAULT);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel, char[] cArr, SevenZFileOptions sevenZFileOptions) throws IOException {
        this(seekableByteChannel, DEFAULT_FILE_NAME, cArr, sevenZFileOptions);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel, String str, char[] cArr) throws IOException {
        this(seekableByteChannel, str, cArr, SevenZFileOptions.DEFAULT);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel, String str, char[] cArr, SevenZFileOptions sevenZFileOptions) throws IOException {
        this(seekableByteChannel, str, utf16Decode(cArr), false, sevenZFileOptions);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel, String str) throws IOException {
        this(seekableByteChannel, str, SevenZFileOptions.DEFAULT);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel, String str, SevenZFileOptions sevenZFileOptions) throws IOException {
        this(seekableByteChannel, str, (byte[]) null, false, sevenZFileOptions);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel, byte[] bArr) throws IOException {
        this(seekableByteChannel, DEFAULT_FILE_NAME, bArr);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel, String str, byte[] bArr) throws IOException {
        this(seekableByteChannel, str, bArr, false, SevenZFileOptions.DEFAULT);
    }

    private SevenZFile(SeekableByteChannel seekableByteChannel, String str, byte[] bArr, boolean z, SevenZFileOptions sevenZFileOptions) throws IOException {
        this.currentEntryIndex = -1;
        this.currentFolderIndex = -1;
        this.currentFolderInputStream = null;
        this.deferredBlockStreams = new ArrayList<>();
        this.channel = seekableByteChannel;
        this.fileName = str;
        this.options = sevenZFileOptions;
        try {
            this.archive = readHeaders(bArr);
            if (bArr != null) {
                this.password = Arrays.copyOf(bArr, bArr.length);
            } else {
                this.password = null;
            }
        } catch (Throwable th) {
            if (z) {
                Beacon$$ExternalSyntheticApiModelOutline0.m(this.channel);
            }
            throw th;
        }
    }

    public SevenZFile(File file) throws IOException {
        this(file, SevenZFileOptions.DEFAULT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SevenZFile(File file, SevenZFileOptions sevenZFileOptions) throws IOException {
        this(file, (char[]) null, sevenZFileOptions);
        char[] cArr = null;
    }

    public void close() throws IOException {
        SeekableByteChannel seekableByteChannel = this.channel;
        if (seekableByteChannel != null) {
            try {
                Beacon$$ExternalSyntheticApiModelOutline0.m(seekableByteChannel);
            } finally {
                this.channel = null;
                byte[] bArr = this.password;
                if (bArr != null) {
                    Arrays.fill(bArr, (byte) 0);
                }
                this.password = null;
            }
        }
    }

    public SevenZArchiveEntry getNextEntry() throws IOException {
        if (this.currentEntryIndex >= this.archive.files.length - 1) {
            return null;
        }
        this.currentEntryIndex++;
        SevenZArchiveEntry sevenZArchiveEntry = this.archive.files[this.currentEntryIndex];
        if (sevenZArchiveEntry.getName() == null && this.options.getUseDefaultNameForUnnamedEntries()) {
            sevenZArchiveEntry.setName(getDefaultName());
        }
        buildDecodingStream();
        this.compressedBytesReadFromCurrentEntry = 0;
        this.uncompressedBytesReadFromCurrentEntry = 0;
        return sevenZArchiveEntry;
    }

    public Iterable<SevenZArchiveEntry> getEntries() {
        return Arrays.asList(this.archive.files);
    }

    private Archive readHeaders(byte[] bArr) throws IOException {
        ByteBuffer order = ByteBuffer.allocate(12).order(ByteOrder.LITTLE_ENDIAN);
        readFully(order);
        byte[] bArr2 = new byte[6];
        order.get(bArr2);
        if (Arrays.equals(bArr2, sevenZSignature)) {
            byte b = order.get();
            byte b2 = order.get();
            if (b == 0) {
                StartHeader readStartHeader = readStartHeader(((long) order.getInt()) & 4294967295L);
                assertFitsIntoInt("nextHeaderSize", readStartHeader.nextHeaderSize);
                SeekableByteChannel unused = this.channel.position(readStartHeader.nextHeaderOffset + 32);
                ByteBuffer order2 = ByteBuffer.allocate((int) readStartHeader.nextHeaderSize).order(ByteOrder.LITTLE_ENDIAN);
                readFully(order2);
                CRC32 crc32 = new CRC32();
                crc32.update(order2.array());
                if (readStartHeader.nextHeaderCrc == crc32.getValue()) {
                    Archive archive2 = new Archive();
                    int unsignedByte = getUnsignedByte(order2);
                    if (unsignedByte == 23) {
                        order2 = readEncodedHeader(order2, archive2, bArr);
                        archive2 = new Archive();
                        unsignedByte = getUnsignedByte(order2);
                    }
                    if (unsignedByte == 1) {
                        readHeader(order2, archive2);
                        return archive2;
                    }
                    throw new IOException("Broken or unsupported archive: no Header");
                }
                throw new IOException("NextHeader CRC mismatch");
            }
            throw new IOException(String.format("Unsupported 7z version (%d,%d)", new Object[]{Byte.valueOf(b), Byte.valueOf(b2)}));
        }
        throw new IOException("Bad 7z signature");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004b, code lost:
        r10.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004e, code lost:
        throw r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0045, code lost:
        r11 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.apache.commons.compress.archivers.sevenz.StartHeader readStartHeader(long r10) throws java.io.IOException {
        /*
            r9 = this;
            org.apache.commons.compress.archivers.sevenz.StartHeader r0 = new org.apache.commons.compress.archivers.sevenz.StartHeader
            r0.<init>()
            java.io.DataInputStream r1 = new java.io.DataInputStream
            org.apache.commons.compress.utils.CRC32VerifyingInputStream r8 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream
            org.apache.commons.compress.archivers.sevenz.BoundedSeekableByteChannelInputStream r3 = new org.apache.commons.compress.archivers.sevenz.BoundedSeekableByteChannelInputStream
            java.nio.channels.SeekableByteChannel r2 = r9.channel
            r4 = 20
            r3.<init>(r2, r4)
            r2 = r8
            r6 = r10
            r2.<init>((java.io.InputStream) r3, (long) r4, (long) r6)
            r1.<init>(r8)
            long r10 = r1.readLong()     // Catch:{ all -> 0x0043 }
            long r10 = java.lang.Long.reverseBytes(r10)     // Catch:{ all -> 0x0043 }
            r0.nextHeaderOffset = r10     // Catch:{ all -> 0x0043 }
            long r10 = r1.readLong()     // Catch:{ all -> 0x0043 }
            long r10 = java.lang.Long.reverseBytes(r10)     // Catch:{ all -> 0x0043 }
            r0.nextHeaderSize = r10     // Catch:{ all -> 0x0043 }
            int r10 = r1.readInt()     // Catch:{ all -> 0x0043 }
            int r10 = java.lang.Integer.reverseBytes(r10)     // Catch:{ all -> 0x0043 }
            long r10 = (long) r10     // Catch:{ all -> 0x0043 }
            r2 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r10 = r10 & r2
            r0.nextHeaderCrc = r10     // Catch:{ all -> 0x0043 }
            r1.close()
            return r0
        L_0x0043:
            r10 = move-exception
            throw r10     // Catch:{ all -> 0x0045 }
        L_0x0045:
            r11 = move-exception
            r1.close()     // Catch:{ all -> 0x004a }
            goto L_0x004e
        L_0x004a:
            r0 = move-exception
            r10.addSuppressed(r0)
        L_0x004e:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.sevenz.SevenZFile.readStartHeader(long):org.apache.commons.compress.archivers.sevenz.StartHeader");
    }

    private void readHeader(ByteBuffer byteBuffer, Archive archive2) throws IOException {
        int unsignedByte = getUnsignedByte(byteBuffer);
        if (unsignedByte == 2) {
            readArchiveProperties(byteBuffer);
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte != 3) {
            if (unsignedByte == 4) {
                readStreamsInfo(byteBuffer, archive2);
                unsignedByte = getUnsignedByte(byteBuffer);
            }
            if (unsignedByte == 5) {
                readFilesInfo(byteBuffer, archive2);
                unsignedByte = getUnsignedByte(byteBuffer);
            }
            if (unsignedByte != 0) {
                throw new IOException("Badly terminated header, found " + unsignedByte);
            }
            return;
        }
        throw new IOException("Additional streams unsupported");
    }

    private void readArchiveProperties(ByteBuffer byteBuffer) throws IOException {
        int unsignedByte = getUnsignedByte(byteBuffer);
        while (unsignedByte != 0) {
            long readUint64 = readUint64(byteBuffer);
            assertFitsIntoInt("propertySize", readUint64);
            byteBuffer.get(new byte[((int) readUint64)]);
            unsignedByte = getUnsignedByte(byteBuffer);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0094, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0099, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009a, code lost:
        r10.addSuppressed(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009d, code lost:
        throw r12;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.nio.ByteBuffer readEncodedHeader(java.nio.ByteBuffer r10, org.apache.commons.compress.archivers.sevenz.Archive r11, byte[] r12) throws java.io.IOException {
        /*
            r9 = this;
            r9.readStreamsInfo(r10, r11)
            org.apache.commons.compress.archivers.sevenz.Folder[] r10 = r11.folders
            r0 = 0
            r10 = r10[r0]
            r1 = 32
            long r3 = r11.packPos
            long r3 = r3 + r1
            java.nio.channels.SeekableByteChannel r1 = r9.channel
            java.nio.channels.SeekableByteChannel unused = r1.position(r3)
            org.apache.commons.compress.archivers.sevenz.BoundedSeekableByteChannelInputStream r1 = new org.apache.commons.compress.archivers.sevenz.BoundedSeekableByteChannelInputStream
            java.nio.channels.SeekableByteChannel r2 = r9.channel
            long[] r11 = r11.packSizes
            r3 = r11[r0]
            r1.<init>(r2, r3)
            java.lang.Iterable r11 = r10.getOrderedCoders()
            java.util.Iterator r11 = r11.iterator()
            r3 = r1
        L_0x0026:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x005b
            java.lang.Object r0 = r11.next()
            r6 = r0
            org.apache.commons.compress.archivers.sevenz.Coder r6 = (org.apache.commons.compress.archivers.sevenz.Coder) r6
            long r0 = r6.numInStreams
            r4 = 1
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x0053
            long r0 = r6.numOutStreams
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x0053
            java.lang.String r2 = r9.fileName
            long r4 = r10.getUnpackSizeForCoder(r6)
            org.apache.commons.compress.archivers.sevenz.SevenZFileOptions r0 = r9.options
            int r8 = r0.getMaxMemoryLimitInKb()
            r7 = r12
            java.io.InputStream r3 = org.apache.commons.compress.archivers.sevenz.Coders.addDecoder(r2, r3, r4, r6, r7, r8)
            goto L_0x0026
        L_0x0053:
            java.io.IOException r10 = new java.io.IOException
            java.lang.String r11 = "Multi input/output stream coders are not yet supported"
            r10.<init>(r11)
            throw r10
        L_0x005b:
            boolean r11 = r10.hasCrc
            if (r11 == 0) goto L_0x006c
            org.apache.commons.compress.utils.CRC32VerifyingInputStream r11 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream
            long r4 = r10.getUnpackSize()
            long r6 = r10.crc
            r2 = r11
            r2.<init>((java.io.InputStream) r3, (long) r4, (long) r6)
            r3 = r11
        L_0x006c:
            java.lang.String r11 = "unpackSize"
            long r0 = r10.getUnpackSize()
            assertFitsIntoInt(r11, r0)
            long r10 = r10.getUnpackSize()
            int r10 = (int) r10
            byte[] r10 = new byte[r10]
            java.io.DataInputStream r11 = new java.io.DataInputStream
            r11.<init>(r3)
            r11.readFully(r10)     // Catch:{ all -> 0x0092 }
            r11.close()
            java.nio.ByteBuffer r10 = java.nio.ByteBuffer.wrap(r10)
            java.nio.ByteOrder r11 = java.nio.ByteOrder.LITTLE_ENDIAN
            java.nio.ByteBuffer r10 = r10.order(r11)
            return r10
        L_0x0092:
            r10 = move-exception
            throw r10     // Catch:{ all -> 0x0094 }
        L_0x0094:
            r12 = move-exception
            r11.close()     // Catch:{ all -> 0x0099 }
            goto L_0x009d
        L_0x0099:
            r11 = move-exception
            r10.addSuppressed(r11)
        L_0x009d:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.sevenz.SevenZFile.readEncodedHeader(java.nio.ByteBuffer, org.apache.commons.compress.archivers.sevenz.Archive, byte[]):java.nio.ByteBuffer");
    }

    private void readStreamsInfo(ByteBuffer byteBuffer, Archive archive2) throws IOException {
        int unsignedByte = getUnsignedByte(byteBuffer);
        if (unsignedByte == 6) {
            readPackInfo(byteBuffer, archive2);
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte == 7) {
            readUnpackInfo(byteBuffer, archive2);
            unsignedByte = getUnsignedByte(byteBuffer);
        } else {
            archive2.folders = new Folder[0];
        }
        if (unsignedByte == 8) {
            readSubStreamsInfo(byteBuffer, archive2);
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte != 0) {
            throw new IOException("Badly terminated StreamsInfo");
        }
    }

    private void readPackInfo(ByteBuffer byteBuffer, Archive archive2) throws IOException {
        archive2.packPos = readUint64(byteBuffer);
        long readUint64 = readUint64(byteBuffer);
        assertFitsIntoInt("numPackStreams", readUint64);
        int i = (int) readUint64;
        int unsignedByte = getUnsignedByte(byteBuffer);
        if (unsignedByte == 9) {
            archive2.packSizes = new long[i];
            for (int i2 = 0; i2 < archive2.packSizes.length; i2++) {
                archive2.packSizes[i2] = readUint64(byteBuffer);
            }
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte == 10) {
            archive2.packCrcsDefined = readAllOrBits(byteBuffer, i);
            archive2.packCrcs = new long[i];
            for (int i3 = 0; i3 < i; i3++) {
                if (archive2.packCrcsDefined.get(i3)) {
                    archive2.packCrcs[i3] = ((long) byteBuffer.getInt()) & 4294967295L;
                }
            }
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte != 0) {
            throw new IOException("Badly terminated PackInfo (" + unsignedByte + ")");
        }
    }

    private void readUnpackInfo(ByteBuffer byteBuffer, Archive archive2) throws IOException {
        int unsignedByte = getUnsignedByte(byteBuffer);
        if (unsignedByte == 11) {
            long readUint64 = readUint64(byteBuffer);
            assertFitsIntoInt("numFolders", readUint64);
            int i = (int) readUint64;
            Folder[] folderArr = new Folder[i];
            archive2.folders = folderArr;
            if (getUnsignedByte(byteBuffer) == 0) {
                for (int i2 = 0; i2 < i; i2++) {
                    folderArr[i2] = readFolder(byteBuffer);
                }
                int unsignedByte2 = getUnsignedByte(byteBuffer);
                if (unsignedByte2 == 12) {
                    for (int i3 = 0; i3 < i; i3++) {
                        Folder folder = folderArr[i3];
                        assertFitsIntoInt("totalOutputStreams", folder.totalOutputStreams);
                        folder.unpackSizes = new long[((int) folder.totalOutputStreams)];
                        for (int i4 = 0; ((long) i4) < folder.totalOutputStreams; i4++) {
                            folder.unpackSizes[i4] = readUint64(byteBuffer);
                        }
                    }
                    int unsignedByte3 = getUnsignedByte(byteBuffer);
                    if (unsignedByte3 == 10) {
                        BitSet readAllOrBits = readAllOrBits(byteBuffer, i);
                        for (int i5 = 0; i5 < i; i5++) {
                            if (readAllOrBits.get(i5)) {
                                folderArr[i5].hasCrc = true;
                                folderArr[i5].crc = ((long) byteBuffer.getInt()) & 4294967295L;
                            } else {
                                folderArr[i5].hasCrc = false;
                            }
                        }
                        unsignedByte3 = getUnsignedByte(byteBuffer);
                    }
                    if (unsignedByte3 != 0) {
                        throw new IOException("Badly terminated UnpackInfo");
                    }
                    return;
                }
                throw new IOException("Expected kCodersUnpackSize, got " + unsignedByte2);
            }
            throw new IOException("External unsupported");
        }
        throw new IOException("Expected kFolder, got " + unsignedByte);
    }

    private void readSubStreamsInfo(ByteBuffer byteBuffer, Archive archive2) throws IOException {
        boolean z;
        Archive archive3 = archive2;
        Folder[] folderArr = archive3.folders;
        int length = folderArr.length;
        int i = 0;
        while (true) {
            z = true;
            if (i >= length) {
                break;
            }
            folderArr[i].numUnpackSubStreams = 1;
            i++;
        }
        int length2 = archive3.folders.length;
        int unsignedByte = getUnsignedByte(byteBuffer);
        if (unsignedByte == 13) {
            int i2 = 0;
            for (Folder folder : archive3.folders) {
                long readUint64 = readUint64(byteBuffer);
                assertFitsIntoInt("numStreams", readUint64);
                folder.numUnpackSubStreams = (int) readUint64;
                i2 = (int) (((long) i2) + readUint64);
            }
            unsignedByte = getUnsignedByte(byteBuffer);
            length2 = i2;
        }
        SubStreamsInfo subStreamsInfo = new SubStreamsInfo();
        subStreamsInfo.unpackSizes = new long[length2];
        subStreamsInfo.hasCrc = new BitSet(length2);
        subStreamsInfo.crcs = new long[length2];
        int i3 = 0;
        for (Folder folder2 : archive3.folders) {
            if (folder2.numUnpackSubStreams != 0) {
                long j = 0;
                if (unsignedByte == 9) {
                    int i4 = 0;
                    while (i4 < folder2.numUnpackSubStreams - 1) {
                        long readUint642 = readUint64(byteBuffer);
                        subStreamsInfo.unpackSizes[i3] = readUint642;
                        j += readUint642;
                        i4++;
                        i3++;
                    }
                }
                subStreamsInfo.unpackSizes[i3] = folder2.getUnpackSize() - j;
                i3++;
            }
        }
        if (unsignedByte == 9) {
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        int i5 = 0;
        for (Folder folder3 : archive3.folders) {
            if (folder3.numUnpackSubStreams != 1 || !folder3.hasCrc) {
                i5 += folder3.numUnpackSubStreams;
            }
        }
        if (unsignedByte == 10) {
            BitSet readAllOrBits = readAllOrBits(byteBuffer, i5);
            long[] jArr = new long[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                if (readAllOrBits.get(i6)) {
                    jArr[i6] = ((long) byteBuffer.getInt()) & 4294967295L;
                }
            }
            Folder[] folderArr2 = archive3.folders;
            int length3 = folderArr2.length;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (i7 < length3) {
                Folder folder4 = folderArr2[i7];
                if (folder4.numUnpackSubStreams != z || !folder4.hasCrc) {
                    for (int i10 = 0; i10 < folder4.numUnpackSubStreams; i10++) {
                        subStreamsInfo.hasCrc.set(i8, readAllOrBits.get(i9));
                        subStreamsInfo.crcs[i8] = jArr[i9];
                        i8++;
                        i9++;
                    }
                } else {
                    subStreamsInfo.hasCrc.set(i8, z);
                    subStreamsInfo.crcs[i8] = folder4.crc;
                    i8++;
                }
                i7++;
                ByteBuffer byteBuffer2 = byteBuffer;
                z = true;
            }
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte == 0) {
            archive3.subStreamsInfo = subStreamsInfo;
            return;
        }
        throw new IOException("Badly terminated SubStreamsInfo");
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00fd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.apache.commons.compress.archivers.sevenz.Folder readFolder(java.nio.ByteBuffer r20) throws java.io.IOException {
        /*
            r19 = this;
            r0 = r20
            org.apache.commons.compress.archivers.sevenz.Folder r1 = new org.apache.commons.compress.archivers.sevenz.Folder
            r1.<init>()
            long r2 = readUint64(r20)
            java.lang.String r4 = "numCoders"
            assertFitsIntoInt(r4, r2)
            int r2 = (int) r2
            org.apache.commons.compress.archivers.sevenz.Coder[] r3 = new org.apache.commons.compress.archivers.sevenz.Coder[r2]
            r4 = 0
            r6 = 0
            r8 = r4
            r10 = r8
            r7 = r6
        L_0x0019:
            r12 = 1
            if (r7 >= r2) goto L_0x009d
            org.apache.commons.compress.archivers.sevenz.Coder r14 = new org.apache.commons.compress.archivers.sevenz.Coder
            r14.<init>()
            r3[r7] = r14
            int r14 = getUnsignedByte(r20)
            r15 = r14 & 15
            r16 = r14 & 16
            r17 = 1
            if (r16 != 0) goto L_0x0033
            r16 = r17
            goto L_0x0035
        L_0x0033:
            r16 = r6
        L_0x0035:
            r18 = r14 & 32
            if (r18 == 0) goto L_0x003c
            r18 = r17
            goto L_0x003e
        L_0x003c:
            r18 = r6
        L_0x003e:
            r14 = r14 & 128(0x80, float:1.794E-43)
            if (r14 == 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r17 = r6
        L_0x0045:
            r14 = r3[r7]
            byte[] r15 = new byte[r15]
            r14.decompressionMethodId = r15
            r14 = r3[r7]
            byte[] r14 = r14.decompressionMethodId
            r0.get(r14)
            if (r16 == 0) goto L_0x005d
            r14 = r3[r7]
            r14.numInStreams = r12
            r14 = r3[r7]
            r14.numOutStreams = r12
            goto L_0x006d
        L_0x005d:
            r12 = r3[r7]
            long r13 = readUint64(r20)
            r12.numInStreams = r13
            r12 = r3[r7]
            long r13 = readUint64(r20)
            r12.numOutStreams = r13
        L_0x006d:
            r12 = r3[r7]
            long r12 = r12.numInStreams
            long r8 = r8 + r12
            r12 = r3[r7]
            long r12 = r12.numOutStreams
            long r10 = r10 + r12
            if (r18 == 0) goto L_0x0090
            long r12 = readUint64(r20)
            java.lang.String r14 = "propertiesSize"
            assertFitsIntoInt(r14, r12)
            r14 = r3[r7]
            int r12 = (int) r12
            byte[] r12 = new byte[r12]
            r14.properties = r12
            r12 = r3[r7]
            byte[] r12 = r12.properties
            r0.get(r12)
        L_0x0090:
            if (r17 != 0) goto L_0x0095
            int r7 = r7 + 1
            goto L_0x0019
        L_0x0095:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Alternative methods are unsupported, please report. The reference implementation doesn't support them either."
            r0.<init>(r1)
            throw r0
        L_0x009d:
            r1.coders = r3
            java.lang.String r2 = "totalInStreams"
            assertFitsIntoInt(r2, r8)
            r1.totalInputStreams = r8
            java.lang.String r2 = "totalOutStreams"
            assertFitsIntoInt(r2, r10)
            r1.totalOutputStreams = r10
            int r2 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x011b
            long r10 = r10 - r12
            java.lang.String r2 = "numBindPairs"
            assertFitsIntoInt(r2, r10)
            int r2 = (int) r10
            org.apache.commons.compress.archivers.sevenz.BindPair[] r3 = new org.apache.commons.compress.archivers.sevenz.BindPair[r2]
            r4 = r6
        L_0x00bb:
            if (r4 >= r2) goto L_0x00d5
            org.apache.commons.compress.archivers.sevenz.BindPair r5 = new org.apache.commons.compress.archivers.sevenz.BindPair
            r5.<init>()
            r3[r4] = r5
            long r14 = readUint64(r20)
            r5.inIndex = r14
            r5 = r3[r4]
            long r14 = readUint64(r20)
            r5.outIndex = r14
            int r4 = r4 + 1
            goto L_0x00bb
        L_0x00d5:
            r1.bindPairs = r3
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 < 0) goto L_0x0113
            long r2 = r8 - r10
            java.lang.String r4 = "numPackedStreams"
            assertFitsIntoInt(r4, r2)
            int r4 = (int) r2
            long[] r5 = new long[r4]
            int r2 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x0105
            r0 = r6
        L_0x00ea:
            int r2 = (int) r8
            if (r0 >= r2) goto L_0x00f7
            int r3 = r1.findBindPairForInStream(r0)
            if (r3 >= 0) goto L_0x00f4
            goto L_0x00f7
        L_0x00f4:
            int r0 = r0 + 1
            goto L_0x00ea
        L_0x00f7:
            if (r0 == r2) goto L_0x00fd
            long r2 = (long) r0
            r5[r6] = r2
            goto L_0x0110
        L_0x00fd:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Couldn't find stream's bind pair index"
            r0.<init>(r1)
            throw r0
        L_0x0105:
            if (r6 >= r4) goto L_0x0110
            long r2 = readUint64(r20)
            r5[r6] = r2
            int r6 = r6 + 1
            goto L_0x0105
        L_0x0110:
            r1.packedStreams = r5
            return r1
        L_0x0113:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Total input streams can't be less than the number of bind pairs"
            r0.<init>(r1)
            throw r0
        L_0x011b:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Total output streams can't be 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.sevenz.SevenZFile.readFolder(java.nio.ByteBuffer):org.apache.commons.compress.archivers.sevenz.Folder");
    }

    private BitSet readAllOrBits(ByteBuffer byteBuffer, int i) throws IOException {
        if (getUnsignedByte(byteBuffer) == 0) {
            return readBits(byteBuffer, i);
        }
        BitSet bitSet = new BitSet(i);
        for (int i2 = 0; i2 < i; i2++) {
            bitSet.set(i2, true);
        }
        return bitSet;
    }

    private BitSet readBits(ByteBuffer byteBuffer, int i) throws IOException {
        BitSet bitSet = new BitSet(i);
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            if (i2 == 0) {
                i3 = getUnsignedByte(byteBuffer);
                i2 = 128;
            }
            bitSet.set(i4, (i3 & i2) != 0);
            i2 >>>= 1;
        }
        return bitSet;
    }

    private void readFilesInfo(ByteBuffer byteBuffer, Archive archive2) throws IOException {
        ByteBuffer byteBuffer2 = byteBuffer;
        Archive archive3 = archive2;
        long readUint64 = readUint64(byteBuffer);
        assertFitsIntoInt("numFiles", readUint64);
        int i = (int) readUint64;
        SevenZArchiveEntry[] sevenZArchiveEntryArr = new SevenZArchiveEntry[i];
        boolean z = false;
        for (int i2 = 0; i2 < i; i2++) {
            sevenZArchiveEntryArr[i2] = new SevenZArchiveEntry();
        }
        BitSet bitSet = null;
        BitSet bitSet2 = null;
        BitSet bitSet3 = null;
        while (true) {
            int unsignedByte = getUnsignedByte(byteBuffer);
            if (unsignedByte == 0) {
                int i3 = z;
                int i4 = i3;
                int i5 = i4;
                while (i3 < i) {
                    boolean z2 = true;
                    sevenZArchiveEntryArr[i3].setHasStream((bitSet == null || !bitSet.get(i3)) ? true : z);
                    if (sevenZArchiveEntryArr[i3].hasStream()) {
                        sevenZArchiveEntryArr[i3].setDirectory(z);
                        sevenZArchiveEntryArr[i3].setAntiItem(z);
                        sevenZArchiveEntryArr[i3].setHasCrc(archive3.subStreamsInfo.hasCrc.get(i4));
                        sevenZArchiveEntryArr[i3].setCrcValue(archive3.subStreamsInfo.crcs[i4]);
                        sevenZArchiveEntryArr[i3].setSize(archive3.subStreamsInfo.unpackSizes[i4]);
                        i4++;
                    } else {
                        sevenZArchiveEntryArr[i3].setDirectory((bitSet2 == null || !bitSet2.get(i5)) ? true : z);
                        SevenZArchiveEntry sevenZArchiveEntry = sevenZArchiveEntryArr[i3];
                        if (bitSet3 == null || !bitSet3.get(i5)) {
                            z2 = z;
                        }
                        sevenZArchiveEntry.setAntiItem(z2);
                        sevenZArchiveEntryArr[i3].setHasCrc(z);
                        sevenZArchiveEntryArr[i3].setSize(0);
                        i5++;
                    }
                    i3++;
                }
                archive3.files = sevenZArchiveEntryArr;
                calculateStreamMap(archive3);
                return;
            }
            long readUint642 = readUint64(byteBuffer);
            switch (unsignedByte) {
                case 14:
                    bitSet = readBits(byteBuffer2, i);
                    break;
                case 15:
                    if (bitSet != null) {
                        bitSet2 = readBits(byteBuffer2, bitSet.cardinality());
                        break;
                    } else {
                        throw new IOException("Header format error: kEmptyStream must appear before kEmptyFile");
                    }
                case 16:
                    if (bitSet != null) {
                        bitSet3 = readBits(byteBuffer2, bitSet.cardinality());
                        break;
                    } else {
                        throw new IOException("Header format error: kEmptyStream must appear before kAnti");
                    }
                case 17:
                    if (getUnsignedByte(byteBuffer) == 0) {
                        long j = readUint642 - 1;
                        if ((1 & j) == 0) {
                            assertFitsIntoInt("file names length", j);
                            int i6 = (int) j;
                            byte[] bArr = new byte[i6];
                            byteBuffer2.get(bArr);
                            int i7 = z;
                            int i8 = i7;
                            int i9 = i8;
                            while (i7 < i6) {
                                if (bArr[i7] == 0 && bArr[i7 + 1] == 0) {
                                    sevenZArchiveEntryArr[i9].setName(new String(bArr, i8, i7 - i8, CharsetNames.UTF_16LE));
                                    i8 = i7 + 2;
                                    i9++;
                                }
                                i7 += 2;
                                Archive archive4 = archive2;
                            }
                            if (i8 != i6 || i9 != i) {
                                break;
                            } else {
                                break;
                            }
                        } else {
                            throw new IOException("File names length invalid");
                        }
                    } else {
                        throw new IOException("Not implemented");
                    }
                case 18:
                    BitSet readAllOrBits = readAllOrBits(byteBuffer2, i);
                    if (getUnsignedByte(byteBuffer) == 0) {
                        for (int i10 = z; i10 < i; i10++) {
                            sevenZArchiveEntryArr[i10].setHasCreationDate(readAllOrBits.get(i10));
                            if (sevenZArchiveEntryArr[i10].getHasCreationDate()) {
                                sevenZArchiveEntryArr[i10].setCreationDate(byteBuffer.getLong());
                            }
                        }
                        break;
                    } else {
                        throw new IOException("Unimplemented");
                    }
                case 19:
                    BitSet readAllOrBits2 = readAllOrBits(byteBuffer2, i);
                    if (getUnsignedByte(byteBuffer) == 0) {
                        for (int i11 = z; i11 < i; i11++) {
                            sevenZArchiveEntryArr[i11].setHasAccessDate(readAllOrBits2.get(i11));
                            if (sevenZArchiveEntryArr[i11].getHasAccessDate()) {
                                sevenZArchiveEntryArr[i11].setAccessDate(byteBuffer.getLong());
                            }
                        }
                        break;
                    } else {
                        throw new IOException("Unimplemented");
                    }
                case 20:
                    BitSet readAllOrBits3 = readAllOrBits(byteBuffer2, i);
                    if (getUnsignedByte(byteBuffer) == 0) {
                        for (int i12 = z; i12 < i; i12++) {
                            sevenZArchiveEntryArr[i12].setHasLastModifiedDate(readAllOrBits3.get(i12));
                            if (sevenZArchiveEntryArr[i12].getHasLastModifiedDate()) {
                                sevenZArchiveEntryArr[i12].setLastModifiedDate(byteBuffer.getLong());
                            }
                        }
                        break;
                    } else {
                        throw new IOException("Unimplemented");
                    }
                case 21:
                    BitSet readAllOrBits4 = readAllOrBits(byteBuffer2, i);
                    if (getUnsignedByte(byteBuffer) == 0) {
                        for (int i13 = z; i13 < i; i13++) {
                            sevenZArchiveEntryArr[i13].setHasWindowsAttributes(readAllOrBits4.get(i13));
                            if (sevenZArchiveEntryArr[i13].getHasWindowsAttributes()) {
                                sevenZArchiveEntryArr[i13].setWindowsAttributes(byteBuffer.getInt());
                            }
                        }
                        break;
                    } else {
                        throw new IOException("Unimplemented");
                    }
                case 24:
                    throw new IOException("kStartPos is unsupported, please report");
                case 25:
                    if (skipBytesFully(byteBuffer2, readUint642) >= readUint642) {
                        break;
                    } else {
                        throw new IOException("Incomplete kDummy property");
                    }
                default:
                    if (skipBytesFully(byteBuffer2, readUint642) >= readUint642) {
                        break;
                    } else {
                        throw new IOException("Incomplete property of type " + unsignedByte);
                    }
            }
            archive3 = archive2;
            z = false;
        }
        throw new IOException("Error parsing file names");
    }

    private void calculateStreamMap(Archive archive2) throws IOException {
        StreamMap streamMap = new StreamMap();
        int length = archive2.folders != null ? archive2.folders.length : 0;
        streamMap.folderFirstPackStreamIndex = new int[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            streamMap.folderFirstPackStreamIndex[i2] = i;
            i += archive2.folders[i2].packedStreams.length;
        }
        int length2 = archive2.packSizes != null ? archive2.packSizes.length : 0;
        streamMap.packStreamOffsets = new long[length2];
        long j = 0;
        for (int i3 = 0; i3 < length2; i3++) {
            streamMap.packStreamOffsets[i3] = j;
            j += archive2.packSizes[i3];
        }
        streamMap.folderFirstFileIndex = new int[length];
        streamMap.fileFolderIndex = new int[archive2.files.length];
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < archive2.files.length; i6++) {
            if (archive2.files[i6].hasStream() || i4 != 0) {
                if (i4 == 0) {
                    while (i5 < archive2.folders.length) {
                        streamMap.folderFirstFileIndex[i5] = i6;
                        if (archive2.folders[i5].numUnpackSubStreams > 0) {
                            break;
                        }
                        i5++;
                    }
                    if (i5 >= archive2.folders.length) {
                        throw new IOException("Too few folders in archive");
                    }
                }
                streamMap.fileFolderIndex[i6] = i5;
                if (archive2.files[i6].hasStream() && (i4 = i4 + 1) >= archive2.folders[i5].numUnpackSubStreams) {
                    i5++;
                    i4 = 0;
                }
            } else {
                streamMap.fileFolderIndex[i6] = -1;
            }
        }
        archive2.streamMap = streamMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: org.apache.commons.compress.utils.BoundedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: org.apache.commons.compress.utils.BoundedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: org.apache.commons.compress.utils.CRC32VerifyingInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: org.apache.commons.compress.utils.BoundedInputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void buildDecodingStream() throws java.io.IOException {
        /*
            r9 = this;
            org.apache.commons.compress.archivers.sevenz.Archive r0 = r9.archive
            org.apache.commons.compress.archivers.sevenz.StreamMap r0 = r0.streamMap
            int[] r0 = r0.fileFolderIndex
            int r1 = r9.currentEntryIndex
            r0 = r0[r1]
            if (r0 >= 0) goto L_0x0012
            java.util.ArrayList<java.io.InputStream> r0 = r9.deferredBlockStreams
            r0.clear()
            return
        L_0x0012:
            org.apache.commons.compress.archivers.sevenz.Archive r1 = r9.archive
            org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry[] r1 = r1.files
            int r2 = r9.currentEntryIndex
            r1 = r1[r2]
            int r2 = r9.currentFolderIndex
            if (r2 != r0) goto L_0x0030
            org.apache.commons.compress.archivers.sevenz.Archive r0 = r9.archive
            org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry[] r0 = r0.files
            int r2 = r9.currentEntryIndex
            int r2 = r2 + -1
            r0 = r0[r2]
            java.lang.Iterable r0 = r0.getContentMethods()
            r1.setContentMethods(r0)
            goto L_0x0067
        L_0x0030:
            r9.currentFolderIndex = r0
            java.util.ArrayList<java.io.InputStream> r2 = r9.deferredBlockStreams
            r2.clear()
            java.io.InputStream r2 = r9.currentFolderInputStream
            if (r2 == 0) goto L_0x0041
            r2.close()
            r2 = 0
            r9.currentFolderInputStream = r2
        L_0x0041:
            org.apache.commons.compress.archivers.sevenz.Archive r2 = r9.archive
            org.apache.commons.compress.archivers.sevenz.Folder[] r2 = r2.folders
            r4 = r2[r0]
            org.apache.commons.compress.archivers.sevenz.Archive r2 = r9.archive
            org.apache.commons.compress.archivers.sevenz.StreamMap r2 = r2.streamMap
            int[] r2 = r2.folderFirstPackStreamIndex
            r7 = r2[r0]
            org.apache.commons.compress.archivers.sevenz.Archive r0 = r9.archive
            long r2 = r0.packPos
            r5 = 32
            long r2 = r2 + r5
            org.apache.commons.compress.archivers.sevenz.Archive r0 = r9.archive
            org.apache.commons.compress.archivers.sevenz.StreamMap r0 = r0.streamMap
            long[] r0 = r0.packStreamOffsets
            r5 = r0[r7]
            long r5 = r5 + r2
            r3 = r9
            r8 = r1
            java.io.InputStream r0 = r3.buildDecoderStack(r4, r5, r7, r8)
            r9.currentFolderInputStream = r0
        L_0x0067:
            org.apache.commons.compress.utils.BoundedInputStream r3 = new org.apache.commons.compress.utils.BoundedInputStream
            java.io.InputStream r0 = r9.currentFolderInputStream
            long r4 = r1.getSize()
            r3.<init>(r0, r4)
            boolean r0 = r1.getHasCrc()
            if (r0 == 0) goto L_0x0087
            org.apache.commons.compress.utils.CRC32VerifyingInputStream r0 = new org.apache.commons.compress.utils.CRC32VerifyingInputStream
            long r4 = r1.getSize()
            long r6 = r1.getCrcValue()
            r2 = r0
            r2.<init>((java.io.InputStream) r3, (long) r4, (long) r6)
            r3 = r0
        L_0x0087:
            java.util.ArrayList<java.io.InputStream> r0 = r9.deferredBlockStreams
            r0.add(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.sevenz.SevenZFile.buildDecodingStream():void");
    }

    private InputStream buildDecoderStack(Folder folder, long j, int i, SevenZArchiveEntry sevenZArchiveEntry) throws IOException {
        SeekableByteChannel unused = this.channel.position(j);
        AnonymousClass1 r10 = new FilterInputStream(new BufferedInputStream(new BoundedSeekableByteChannelInputStream(this.channel, this.archive.packSizes[i]))) {
            public int read() throws IOException {
                int read = this.in.read();
                if (read >= 0) {
                    count(1);
                }
                return read;
            }

            public int read(byte[] bArr) throws IOException {
                return read(bArr, 0, bArr.length);
            }

            public int read(byte[] bArr, int i, int i2) throws IOException {
                int read = this.in.read(bArr, i, i2);
                if (read >= 0) {
                    count(read);
                }
                return read;
            }

            private void count(int i) {
                SevenZFile sevenZFile = SevenZFile.this;
                long unused = sevenZFile.compressedBytesReadFromCurrentEntry = sevenZFile.compressedBytesReadFromCurrentEntry + ((long) i);
            }
        };
        LinkedList linkedList = new LinkedList();
        InputStream inputStream = r10;
        for (Coder next : folder.getOrderedCoders()) {
            if (next.numInStreams == 1 && next.numOutStreams == 1) {
                SevenZMethod byId = SevenZMethod.byId(next.decompressionMethodId);
                inputStream = Coders.addDecoder(this.fileName, inputStream, folder.getUnpackSizeForCoder(next), next, this.password, this.options.getMaxMemoryLimitInKb());
                linkedList.addFirst(new SevenZMethodConfiguration(byId, Coders.findByMethod(byId).getOptionsFromCoder(next, inputStream)));
            } else {
                throw new IOException("Multi input/output stream coders are not yet supported");
            }
        }
        sevenZArchiveEntry.setContentMethods(linkedList);
        return folder.hasCrc ? new CRC32VerifyingInputStream(inputStream, folder.getUnpackSize(), folder.crc) : inputStream;
    }

    public int read() throws IOException {
        int read = getCurrentStream().read();
        if (read >= 0) {
            this.uncompressedBytesReadFromCurrentEntry++;
        }
        return read;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0046, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0047, code lost:
        if (r0 != null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004e, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0051, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.InputStream getCurrentStream() throws java.io.IOException {
        /*
            r6 = this;
            org.apache.commons.compress.archivers.sevenz.Archive r0 = r6.archive
            org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry[] r0 = r0.files
            int r1 = r6.currentEntryIndex
            r0 = r0[r1]
            long r0 = r0.getSize()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 0
            if (r0 != 0) goto L_0x001b
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            byte[] r1 = new byte[r1]
            r0.<init>(r1)
            return r0
        L_0x001b:
            java.util.ArrayList<java.io.InputStream> r0 = r6.deferredBlockStreams
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x005b
        L_0x0023:
            java.util.ArrayList<java.io.InputStream> r0 = r6.deferredBlockStreams
            int r0 = r0.size()
            r4 = 1
            if (r0 <= r4) goto L_0x0052
            java.util.ArrayList<java.io.InputStream> r0 = r6.deferredBlockStreams
            java.lang.Object r0 = r0.remove(r1)
            java.io.InputStream r0 = (java.io.InputStream) r0
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            org.apache.commons.compress.utils.IOUtils.skip(r0, r4)     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0041
            r0.close()
        L_0x0041:
            r6.compressedBytesReadFromCurrentEntry = r2
            goto L_0x0023
        L_0x0044:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0046 }
        L_0x0046:
            r2 = move-exception
            if (r0 == 0) goto L_0x0051
            r0.close()     // Catch:{ all -> 0x004d }
            goto L_0x0051
        L_0x004d:
            r0 = move-exception
            r1.addSuppressed(r0)
        L_0x0051:
            throw r2
        L_0x0052:
            java.util.ArrayList<java.io.InputStream> r0 = r6.deferredBlockStreams
            java.lang.Object r0 = r0.get(r1)
            java.io.InputStream r0 = (java.io.InputStream) r0
            return r0
        L_0x005b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "No current 7z entry (call getNextEntry() first)."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.sevenz.SevenZFile.getCurrentStream():java.io.InputStream");
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = getCurrentStream().read(bArr, i, i2);
        if (read > 0) {
            this.uncompressedBytesReadFromCurrentEntry += (long) read;
        }
        return read;
    }

    public InputStreamStatistics getStatisticsForCurrentEntry() {
        return new InputStreamStatistics() {
            public long getCompressedCount() {
                return SevenZFile.this.compressedBytesReadFromCurrentEntry;
            }

            public long getUncompressedCount() {
                return SevenZFile.this.uncompressedBytesReadFromCurrentEntry;
            }
        };
    }

    private static long readUint64(ByteBuffer byteBuffer) throws IOException {
        long unsignedByte = (long) getUnsignedByte(byteBuffer);
        int i = 128;
        long j = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            if ((((long) i) & unsignedByte) == 0) {
                return ((unsignedByte & ((long) (i - 1))) << (i2 * 8)) | j;
            }
            j |= ((long) getUnsignedByte(byteBuffer)) << (i2 * 8);
            i >>>= 1;
        }
        return j;
    }

    private static int getUnsignedByte(ByteBuffer byteBuffer) {
        return byteBuffer.get() & 255;
    }

    public static boolean matches(byte[] bArr, int i) {
        if (i < sevenZSignature.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr2 = sevenZSignature;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    private static long skipBytesFully(ByteBuffer byteBuffer, long j) throws IOException {
        if (j < 1) {
            return 0;
        }
        int position = byteBuffer.position();
        long remaining = (long) byteBuffer.remaining();
        if (remaining < j) {
            j = remaining;
        }
        byteBuffer.position(position + ((int) j));
        return j;
    }

    private void readFully(ByteBuffer byteBuffer) throws IOException {
        byteBuffer.rewind();
        IOUtils.readFully((ReadableByteChannel) this.channel, byteBuffer);
        byteBuffer.flip();
    }

    public String toString() {
        return this.archive.toString();
    }

    public String getDefaultName() {
        if (DEFAULT_FILE_NAME.equals(this.fileName) || this.fileName == null) {
            return null;
        }
        String name = new File(this.fileName).getName();
        int lastIndexOf = name.lastIndexOf(InstructionFileId.DOT);
        if (lastIndexOf > 0) {
            return name.substring(0, lastIndexOf);
        }
        return name + "~";
    }

    private static byte[] utf16Decode(char[] cArr) throws IOException {
        if (cArr == null) {
            return null;
        }
        ByteBuffer encode = PASSWORD_ENCODER.encode(CharBuffer.wrap(cArr));
        if (encode.hasArray()) {
            return encode.array();
        }
        byte[] bArr = new byte[encode.remaining()];
        encode.get(bArr);
        return bArr;
    }

    private static void assertFitsIntoInt(String str, long j) throws IOException {
        if (j > 2147483647L) {
            throw new IOException("Cannot handle " + str + j);
        }
    }
}
