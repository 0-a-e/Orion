package org.apache.commons.compress.archivers.zip;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Calendar;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.ZipException;
import org.altbeacon.beacon.Beacon$$ExternalSyntheticApiModelOutline0;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;

public class ZipArchiveOutputStream extends ArchiveOutputStream {
    static final int BUFFER_SIZE = 512;
    private static final int CFH_COMMENT_LENGTH_OFFSET = 32;
    private static final int CFH_COMPRESSED_SIZE_OFFSET = 20;
    private static final int CFH_CRC_OFFSET = 16;
    private static final int CFH_DISK_NUMBER_OFFSET = 34;
    private static final int CFH_EXTERNAL_ATTRIBUTES_OFFSET = 38;
    private static final int CFH_EXTRA_LENGTH_OFFSET = 30;
    private static final int CFH_FILENAME_LENGTH_OFFSET = 28;
    private static final int CFH_FILENAME_OFFSET = 46;
    private static final int CFH_GPB_OFFSET = 8;
    private static final int CFH_INTERNAL_ATTRIBUTES_OFFSET = 36;
    private static final int CFH_LFH_OFFSET = 42;
    private static final int CFH_METHOD_OFFSET = 10;
    private static final int CFH_ORIGINAL_SIZE_OFFSET = 24;
    static final byte[] CFH_SIG = ZipLong.CFH_SIG.getBytes();
    private static final int CFH_SIG_OFFSET = 0;
    private static final int CFH_TIME_OFFSET = 12;
    private static final int CFH_VERSION_MADE_BY_OFFSET = 4;
    private static final int CFH_VERSION_NEEDED_OFFSET = 6;
    static final byte[] DD_SIG = ZipLong.DD_SIG.getBytes();
    public static final int DEFAULT_COMPRESSION = -1;
    static final String DEFAULT_ENCODING = "UTF8";
    public static final int DEFLATED = 8;
    @Deprecated
    public static final int EFS_FLAG = 2048;
    private static final byte[] EMPTY = new byte[0];
    static final byte[] EOCD_SIG = ZipLong.getBytes(101010256);
    private static final int LFH_COMPRESSED_SIZE_OFFSET = 18;
    private static final int LFH_CRC_OFFSET = 14;
    private static final int LFH_EXTRA_LENGTH_OFFSET = 28;
    private static final int LFH_FILENAME_LENGTH_OFFSET = 26;
    private static final int LFH_FILENAME_OFFSET = 30;
    private static final int LFH_GPB_OFFSET = 6;
    private static final int LFH_METHOD_OFFSET = 8;
    private static final int LFH_ORIGINAL_SIZE_OFFSET = 22;
    static final byte[] LFH_SIG = ZipLong.LFH_SIG.getBytes();
    private static final int LFH_SIG_OFFSET = 0;
    private static final int LFH_TIME_OFFSET = 10;
    private static final int LFH_VERSION_NEEDED_OFFSET = 4;
    private static final byte[] LZERO = {0, 0, 0, 0};
    private static final byte[] ONE = ZipLong.getBytes(1);
    public static final int STORED = 0;
    private static final byte[] ZERO = {0, 0};
    static final byte[] ZIP64_EOCD_LOC_SIG = ZipLong.getBytes(117853008);
    static final byte[] ZIP64_EOCD_SIG = ZipLong.getBytes(101075792);
    private final Calendar calendarInstance = Calendar.getInstance();
    private long cdLength = 0;
    private long cdOffset = 0;
    private final SeekableByteChannel channel;
    private String comment = "";
    private final byte[] copyBuffer = new byte[32768];
    private UnicodeExtraFieldPolicy createUnicodeExtraFields = UnicodeExtraFieldPolicy.NEVER;
    protected final Deflater def;
    private String encoding = DEFAULT_ENCODING;
    private final List<ZipArchiveEntry> entries = new LinkedList();
    private CurrentEntry entry;
    private boolean fallbackToUTF8 = false;
    protected boolean finished = false;
    private boolean hasCompressionLevelChanged = false;
    private boolean hasUsedZip64 = false;
    private int level = -1;
    private final Map<ZipArchiveEntry, EntryMetaData> metaData = new HashMap();
    private int method = 8;
    private final OutputStream out;
    private final StreamCompressor streamCompressor;
    private boolean useUTF8Flag = true;
    private Zip64Mode zip64Mode = Zip64Mode.AsNeeded;
    private ZipEncoding zipEncoding = ZipEncodingHelper.getZipEncoding(DEFAULT_ENCODING);

    private int versionNeededToExtractMethod(int i) {
        return i == 8 ? 20 : 10;
    }

    public ZipArchiveOutputStream(OutputStream outputStream) {
        this.out = outputStream;
        this.channel = null;
        Deflater deflater = new Deflater(this.level, true);
        this.def = deflater;
        this.streamCompressor = StreamCompressor.create(outputStream, deflater);
    }

    public ZipArchiveOutputStream(File file) throws IOException {
        StreamCompressor streamCompressor2;
        SeekableByteChannel seekableByteChannel;
        Deflater deflater = new Deflater(this.level, true);
        this.def = deflater;
        FileOutputStream fileOutputStream = null;
        try {
            seekableByteChannel = Files.newByteChannel(file.toPath(), EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.TRUNCATE_EXISTING), new FileAttribute[0]);
            try {
                streamCompressor2 = StreamCompressor.create(seekableByteChannel, deflater);
            } catch (IOException unused) {
                IOUtils.closeQuietly(seekableByteChannel);
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                streamCompressor2 = StreamCompressor.create((OutputStream) fileOutputStream2, this.def);
                fileOutputStream = fileOutputStream2;
                seekableByteChannel = null;
                this.out = fileOutputStream;
                this.channel = seekableByteChannel;
                this.streamCompressor = streamCompressor2;
            }
        } catch (IOException unused2) {
            seekableByteChannel = null;
            IOUtils.closeQuietly(seekableByteChannel);
            FileOutputStream fileOutputStream22 = new FileOutputStream(file);
            streamCompressor2 = StreamCompressor.create((OutputStream) fileOutputStream22, this.def);
            fileOutputStream = fileOutputStream22;
            seekableByteChannel = null;
            this.out = fileOutputStream;
            this.channel = seekableByteChannel;
            this.streamCompressor = streamCompressor2;
        }
        this.out = fileOutputStream;
        this.channel = seekableByteChannel;
        this.streamCompressor = streamCompressor2;
    }

    public ZipArchiveOutputStream(SeekableByteChannel seekableByteChannel) throws IOException {
        this.channel = seekableByteChannel;
        Deflater deflater = new Deflater(this.level, true);
        this.def = deflater;
        this.streamCompressor = StreamCompressor.create(seekableByteChannel, deflater);
        this.out = null;
    }

    public boolean isSeekable() {
        return this.channel != null;
    }

    public void setEncoding(String str) {
        this.encoding = str;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(str);
        if (this.useUTF8Flag && !ZipEncodingHelper.isUTF8(str)) {
            this.useUTF8Flag = false;
        }
    }

    public String getEncoding() {
        return this.encoding;
    }

    public void setUseLanguageEncodingFlag(boolean z) {
        this.useUTF8Flag = z && ZipEncodingHelper.isUTF8(this.encoding);
    }

    public void setCreateUnicodeExtraFields(UnicodeExtraFieldPolicy unicodeExtraFieldPolicy) {
        this.createUnicodeExtraFields = unicodeExtraFieldPolicy;
    }

    public void setFallbackToUTF8(boolean z) {
        this.fallbackToUTF8 = z;
    }

    public void setUseZip64(Zip64Mode zip64Mode2) {
        this.zip64Mode = zip64Mode2;
    }

    public void finish() throws IOException {
        if (this.finished) {
            throw new IOException("This archive has already been finished");
        } else if (this.entry == null) {
            this.cdOffset = this.streamCompressor.getTotalBytesWritten();
            writeCentralDirectoryInChunks();
            this.cdLength = this.streamCompressor.getTotalBytesWritten() - this.cdOffset;
            writeZip64CentralDirectory();
            writeCentralDirectoryEnd();
            this.metaData.clear();
            this.entries.clear();
            this.streamCompressor.close();
            this.finished = true;
        } else {
            throw new IOException("This archive contains unclosed entries.");
        }
    }

    private void writeCentralDirectoryInChunks() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(70000);
        while (true) {
            int i = 0;
            for (ZipArchiveEntry createCentralFileHeader : this.entries) {
                byteArrayOutputStream.write(createCentralFileHeader(createCentralFileHeader));
                i++;
                if (i > 1000) {
                    writeCounted(byteArrayOutputStream.toByteArray());
                    byteArrayOutputStream.reset();
                }
            }
            writeCounted(byteArrayOutputStream.toByteArray());
            return;
        }
    }

    public void closeArchiveEntry() throws IOException {
        preClose();
        flushDeflater();
        long totalBytesWritten = this.streamCompressor.getTotalBytesWritten() - this.entry.dataStart;
        long crc32 = this.streamCompressor.getCrc32();
        long unused = this.entry.bytesRead = this.streamCompressor.getBytesRead();
        closeEntry(handleSizesAndCrc(totalBytesWritten, crc32, getEffectiveZip64Mode(this.entry.entry)), false);
        this.streamCompressor.reset();
    }

    private void closeCopiedEntry(boolean z) throws IOException {
        preClose();
        CurrentEntry currentEntry = this.entry;
        long unused = currentEntry.bytesRead = currentEntry.entry.getSize();
        closeEntry(checkIfNeedsZip64(getEffectiveZip64Mode(this.entry.entry)), z);
    }

    private void closeEntry(boolean z, boolean z2) throws IOException {
        if (!z2 && this.channel != null) {
            rewriteSizesAndCrc(z);
        }
        if (!z2) {
            writeDataDescriptor(this.entry.entry);
        }
        this.entry = null;
    }

    private void preClose() throws IOException {
        if (!this.finished) {
            CurrentEntry currentEntry = this.entry;
            if (currentEntry == null) {
                throw new IOException("No current entry to close");
            } else if (!currentEntry.hasWritten) {
                write(EMPTY, 0, 0);
            }
        } else {
            throw new IOException("Stream has already been finished");
        }
    }

    public void addRawArchiveEntry(ZipArchiveEntry zipArchiveEntry, InputStream inputStream) throws IOException {
        ZipArchiveEntry zipArchiveEntry2 = new ZipArchiveEntry(zipArchiveEntry);
        if (hasZip64Extra(zipArchiveEntry2)) {
            zipArchiveEntry2.removeExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
        }
        boolean z = (zipArchiveEntry2.getCrc() == -1 || zipArchiveEntry2.getSize() == -1 || zipArchiveEntry2.getCompressedSize() == -1) ? false : true;
        putArchiveEntry(zipArchiveEntry2, z);
        copyFromZipInputStream(inputStream);
        closeCopiedEntry(z);
    }

    private void flushDeflater() throws IOException {
        if (this.entry.entry.getMethod() == 8) {
            this.streamCompressor.flushDeflater();
        }
    }

    private boolean handleSizesAndCrc(long j, long j2, Zip64Mode zip64Mode2) throws ZipException {
        if (this.entry.entry.getMethod() == 8) {
            this.entry.entry.setSize(this.entry.bytesRead);
            this.entry.entry.setCompressedSize(j);
            this.entry.entry.setCrc(j2);
        } else if (this.channel != null) {
            this.entry.entry.setSize(j);
            this.entry.entry.setCompressedSize(j);
            this.entry.entry.setCrc(j2);
        } else if (this.entry.entry.getCrc() != j2) {
            throw new ZipException("Bad CRC checksum for entry " + this.entry.entry.getName() + ": " + Long.toHexString(this.entry.entry.getCrc()) + " instead of " + Long.toHexString(j2));
        } else if (this.entry.entry.getSize() != j) {
            throw new ZipException("Bad size for entry " + this.entry.entry.getName() + ": " + this.entry.entry.getSize() + " instead of " + j);
        }
        return checkIfNeedsZip64(zip64Mode2);
    }

    private boolean checkIfNeedsZip64(Zip64Mode zip64Mode2) throws ZipException {
        boolean isZip64Required = isZip64Required(this.entry.entry, zip64Mode2);
        if (!isZip64Required || zip64Mode2 != Zip64Mode.Never) {
            return isZip64Required;
        }
        throw new Zip64RequiredException(Zip64RequiredException.getEntryTooBigMessage(this.entry.entry));
    }

    private boolean isZip64Required(ZipArchiveEntry zipArchiveEntry, Zip64Mode zip64Mode2) {
        return zip64Mode2 == Zip64Mode.Always || isTooLageForZip32(zipArchiveEntry);
    }

    private boolean isTooLageForZip32(ZipArchiveEntry zipArchiveEntry) {
        return zipArchiveEntry.getSize() >= 4294967295L || zipArchiveEntry.getCompressedSize() >= 4294967295L;
    }

    private void rewriteSizesAndCrc(boolean z) throws IOException {
        long m = Beacon$$ExternalSyntheticApiModelOutline0.m(this.channel);
        SeekableByteChannel unused = this.channel.position(this.entry.localDataStart);
        writeOut(ZipLong.getBytes(this.entry.entry.getCrc()));
        if (!hasZip64Extra(this.entry.entry) || !z) {
            writeOut(ZipLong.getBytes(this.entry.entry.getCompressedSize()));
            writeOut(ZipLong.getBytes(this.entry.entry.getSize()));
        } else {
            writeOut(ZipLong.ZIP64_MAGIC.getBytes());
            writeOut(ZipLong.ZIP64_MAGIC.getBytes());
        }
        if (hasZip64Extra(this.entry.entry)) {
            ByteBuffer name = getName(this.entry.entry);
            SeekableByteChannel unused2 = this.channel.position(this.entry.localDataStart + 16 + ((long) (name.limit() - name.position())) + 4);
            writeOut(ZipEightByteInteger.getBytes(this.entry.entry.getSize()));
            writeOut(ZipEightByteInteger.getBytes(this.entry.entry.getCompressedSize()));
            if (!z) {
                SeekableByteChannel unused3 = this.channel.position(this.entry.localDataStart - 10);
                writeOut(ZipShort.getBytes(versionNeededToExtract(this.entry.entry.getMethod(), false, false)));
                this.entry.entry.removeExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
                this.entry.entry.setExtra();
                if (this.entry.causedUseOfZip64) {
                    this.hasUsedZip64 = false;
                }
            }
        }
        SeekableByteChannel unused4 = this.channel.position(m);
    }

    public void putArchiveEntry(ArchiveEntry archiveEntry) throws IOException {
        putArchiveEntry(archiveEntry, false);
    }

    private void putArchiveEntry(ArchiveEntry archiveEntry, boolean z) throws IOException {
        ZipEightByteInteger zipEightByteInteger;
        ZipEightByteInteger zipEightByteInteger2;
        if (!this.finished) {
            if (this.entry != null) {
                closeArchiveEntry();
            }
            ZipArchiveEntry zipArchiveEntry = (ZipArchiveEntry) archiveEntry;
            CurrentEntry currentEntry = new CurrentEntry(zipArchiveEntry);
            this.entry = currentEntry;
            this.entries.add(currentEntry.entry);
            setDefaults(this.entry.entry);
            Zip64Mode effectiveZip64Mode = getEffectiveZip64Mode(this.entry.entry);
            validateSizeInformation(effectiveZip64Mode);
            if (shouldAddZip64Extra(this.entry.entry, effectiveZip64Mode)) {
                Zip64ExtendedInformationExtraField zip64Extra = getZip64Extra(this.entry.entry);
                if (z) {
                    zipEightByteInteger2 = new ZipEightByteInteger(this.entry.entry.getSize());
                    zipEightByteInteger = new ZipEightByteInteger(this.entry.entry.getCompressedSize());
                } else {
                    if (this.entry.entry.getMethod() != 0 || this.entry.entry.getSize() == -1) {
                        zipEightByteInteger2 = ZipEightByteInteger.ZERO;
                    } else {
                        zipEightByteInteger2 = new ZipEightByteInteger(this.entry.entry.getSize());
                    }
                    zipEightByteInteger = zipEightByteInteger2;
                }
                zip64Extra.setSize(zipEightByteInteger2);
                zip64Extra.setCompressedSize(zipEightByteInteger);
                this.entry.entry.setExtra();
            }
            if (this.entry.entry.getMethod() == 8 && this.hasCompressionLevelChanged) {
                this.def.setLevel(this.level);
                this.hasCompressionLevelChanged = false;
            }
            writeLocalFileHeader(zipArchiveEntry, z);
            return;
        }
        throw new IOException("Stream has already been finished");
    }

    private void setDefaults(ZipArchiveEntry zipArchiveEntry) {
        if (zipArchiveEntry.getMethod() == -1) {
            zipArchiveEntry.setMethod(this.method);
        }
        if (zipArchiveEntry.getTime() == -1) {
            zipArchiveEntry.setTime(System.currentTimeMillis());
        }
    }

    private void validateSizeInformation(Zip64Mode zip64Mode2) throws ZipException {
        if (this.entry.entry.getMethod() == 0 && this.channel == null) {
            if (this.entry.entry.getSize() == -1) {
                throw new ZipException("Uncompressed size is required for STORED method when not writing to a file");
            } else if (this.entry.entry.getCrc() != -1) {
                this.entry.entry.setCompressedSize(this.entry.entry.getSize());
            } else {
                throw new ZipException("CRC checksum is required for STORED method when not writing to a file");
            }
        }
        if ((this.entry.entry.getSize() >= 4294967295L || this.entry.entry.getCompressedSize() >= 4294967295L) && zip64Mode2 == Zip64Mode.Never) {
            throw new Zip64RequiredException(Zip64RequiredException.getEntryTooBigMessage(this.entry.entry));
        }
    }

    private boolean shouldAddZip64Extra(ZipArchiveEntry zipArchiveEntry, Zip64Mode zip64Mode2) {
        return zip64Mode2 == Zip64Mode.Always || zipArchiveEntry.getSize() >= 4294967295L || zipArchiveEntry.getCompressedSize() >= 4294967295L || !(zipArchiveEntry.getSize() != -1 || this.channel == null || zip64Mode2 == Zip64Mode.Never);
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public void setLevel(int i) {
        if (i < -1 || i > 9) {
            throw new IllegalArgumentException("Invalid compression level: " + i);
        } else if (this.level != i) {
            this.hasCompressionLevelChanged = true;
            this.level = i;
        }
    }

    public void setMethod(int i) {
        this.method = i;
    }

    public boolean canWriteEntryData(ArchiveEntry archiveEntry) {
        if (!(archiveEntry instanceof ZipArchiveEntry)) {
            return false;
        }
        ZipArchiveEntry zipArchiveEntry = (ZipArchiveEntry) archiveEntry;
        if (zipArchiveEntry.getMethod() == ZipMethod.IMPLODING.getCode() || zipArchiveEntry.getMethod() == ZipMethod.UNSHRINKING.getCode() || !ZipUtil.canHandleEntryData(zipArchiveEntry)) {
            return false;
        }
        return true;
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        CurrentEntry currentEntry = this.entry;
        if (currentEntry != null) {
            ZipUtil.checkRequestedFeatures(currentEntry.entry);
            count(this.streamCompressor.write(bArr, i, i2, this.entry.entry.getMethod()));
            return;
        }
        throw new IllegalStateException("No current entry");
    }

    private void writeCounted(byte[] bArr) throws IOException {
        this.streamCompressor.writeCounted(bArr);
    }

    private void copyFromZipInputStream(InputStream inputStream) throws IOException {
        CurrentEntry currentEntry = this.entry;
        if (currentEntry != null) {
            ZipUtil.checkRequestedFeatures(currentEntry.entry);
            boolean unused = this.entry.hasWritten = true;
            while (true) {
                int read = inputStream.read(this.copyBuffer);
                if (read >= 0) {
                    this.streamCompressor.writeCounted(this.copyBuffer, 0, read);
                    count(read);
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalStateException("No current entry");
        }
    }

    public void close() throws IOException {
        try {
            if (!this.finished) {
                finish();
            }
        } finally {
            destroy();
        }
    }

    public void flush() throws IOException {
        OutputStream outputStream = this.out;
        if (outputStream != null) {
            outputStream.flush();
        }
    }

    /* access modifiers changed from: protected */
    public final void deflate() throws IOException {
        this.streamCompressor.deflate();
    }

    /* access modifiers changed from: protected */
    public void writeLocalFileHeader(ZipArchiveEntry zipArchiveEntry) throws IOException {
        writeLocalFileHeader(zipArchiveEntry, false);
    }

    private void writeLocalFileHeader(ZipArchiveEntry zipArchiveEntry, boolean z) throws IOException {
        boolean canEncode = this.zipEncoding.canEncode(zipArchiveEntry.getName());
        ByteBuffer name = getName(zipArchiveEntry);
        if (this.createUnicodeExtraFields != UnicodeExtraFieldPolicy.NEVER) {
            addUnicodeExtraFields(zipArchiveEntry, canEncode, name);
        }
        long totalBytesWritten = this.streamCompressor.getTotalBytesWritten();
        byte[] createLocalFileHeader = createLocalFileHeader(zipArchiveEntry, name, canEncode, z, totalBytesWritten);
        this.metaData.put(zipArchiveEntry, new EntryMetaData(totalBytesWritten, usesDataDescriptor(zipArchiveEntry.getMethod(), z)));
        long unused = this.entry.localDataStart = totalBytesWritten + 14;
        writeCounted(createLocalFileHeader);
        long unused2 = this.entry.dataStart = this.streamCompressor.getTotalBytesWritten();
    }

    private byte[] createLocalFileHeader(ZipArchiveEntry zipArchiveEntry, ByteBuffer byteBuffer, boolean z, boolean z2, long j) {
        ZipArchiveEntry zipArchiveEntry2 = zipArchiveEntry;
        boolean z3 = z2;
        ResourceAlignmentExtraField resourceAlignmentExtraField = (ResourceAlignmentExtraField) zipArchiveEntry2.getExtraField(ResourceAlignmentExtraField.ID);
        if (resourceAlignmentExtraField != null) {
            zipArchiveEntry2.removeExtraField(ResourceAlignmentExtraField.ID);
        }
        int alignment = zipArchiveEntry.getAlignment();
        if (alignment <= 0 && resourceAlignmentExtraField != null) {
            alignment = resourceAlignmentExtraField.getAlignment();
        }
        boolean z4 = true;
        if (alignment > 1 || (resourceAlignmentExtraField != null && !resourceAlignmentExtraField.allowMethodChange())) {
            zipArchiveEntry2.addExtraField(new ResourceAlignmentExtraField(alignment, resourceAlignmentExtraField != null && resourceAlignmentExtraField.allowMethodChange(), (int) ((((-j) - ((long) (((byteBuffer.limit() + 30) - byteBuffer.position()) + zipArchiveEntry.getLocalFileDataExtra().length))) - 6) & ((long) (alignment - 1)))));
        }
        byte[] localFileDataExtra = zipArchiveEntry.getLocalFileDataExtra();
        int limit = byteBuffer.limit() - byteBuffer.position();
        int i = limit + 30;
        byte[] bArr = new byte[(localFileDataExtra.length + i)];
        System.arraycopy(LFH_SIG, 0, bArr, 0, 4);
        int method2 = zipArchiveEntry.getMethod();
        boolean usesDataDescriptor = usesDataDescriptor(method2, z3);
        ZipShort.putShort(versionNeededToExtract(method2, hasZip64Extra(zipArchiveEntry), usesDataDescriptor), bArr, 4);
        if (z || !this.fallbackToUTF8) {
            z4 = false;
        }
        getGeneralPurposeBits(z4, usesDataDescriptor).encode(bArr, 6);
        ZipShort.putShort(method2, bArr, 8);
        ZipUtil.toDosTime(this.calendarInstance, zipArchiveEntry.getTime(), bArr, 10);
        if (z3) {
            ZipLong.putLong(zipArchiveEntry.getCrc(), bArr, 14);
        } else if (method2 == 8 || this.channel != null) {
            System.arraycopy(LZERO, 0, bArr, 14, 4);
        } else {
            ZipLong.putLong(zipArchiveEntry.getCrc(), bArr, 14);
        }
        if (hasZip64Extra(this.entry.entry)) {
            ZipLong.ZIP64_MAGIC.putLong(bArr, 18);
            ZipLong.ZIP64_MAGIC.putLong(bArr, 22);
        } else if (z3) {
            ZipLong.putLong(zipArchiveEntry.getCompressedSize(), bArr, 18);
            ZipLong.putLong(zipArchiveEntry.getSize(), bArr, 22);
        } else if (method2 == 8 || this.channel != null) {
            byte[] bArr2 = LZERO;
            System.arraycopy(bArr2, 0, bArr, 18, 4);
            System.arraycopy(bArr2, 0, bArr, 22, 4);
        } else {
            ZipLong.putLong(zipArchiveEntry.getSize(), bArr, 18);
            ZipLong.putLong(zipArchiveEntry.getSize(), bArr, 22);
        }
        ZipShort.putShort(limit, bArr, 26);
        ZipShort.putShort(localFileDataExtra.length, bArr, 28);
        System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset(), bArr, 30, limit);
        System.arraycopy(localFileDataExtra, 0, bArr, i, localFileDataExtra.length);
        return bArr;
    }

    private void addUnicodeExtraFields(ZipArchiveEntry zipArchiveEntry, boolean z, ByteBuffer byteBuffer) throws IOException {
        if (this.createUnicodeExtraFields == UnicodeExtraFieldPolicy.ALWAYS || !z) {
            zipArchiveEntry.addExtraField(new UnicodePathExtraField(zipArchiveEntry.getName(), byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position()));
        }
        String comment2 = zipArchiveEntry.getComment();
        if (comment2 != null && !"".equals(comment2)) {
            boolean canEncode = this.zipEncoding.canEncode(comment2);
            if (this.createUnicodeExtraFields == UnicodeExtraFieldPolicy.ALWAYS || !canEncode) {
                ByteBuffer encode = getEntryEncoding(zipArchiveEntry).encode(comment2);
                zipArchiveEntry.addExtraField(new UnicodeCommentExtraField(comment2, encode.array(), encode.arrayOffset(), encode.limit() - encode.position()));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void writeDataDescriptor(ZipArchiveEntry zipArchiveEntry) throws IOException {
        if (usesDataDescriptor(zipArchiveEntry.getMethod(), false)) {
            writeCounted(DD_SIG);
            writeCounted(ZipLong.getBytes(zipArchiveEntry.getCrc()));
            if (!hasZip64Extra(zipArchiveEntry)) {
                writeCounted(ZipLong.getBytes(zipArchiveEntry.getCompressedSize()));
                writeCounted(ZipLong.getBytes(zipArchiveEntry.getSize()));
                return;
            }
            writeCounted(ZipEightByteInteger.getBytes(zipArchiveEntry.getCompressedSize()));
            writeCounted(ZipEightByteInteger.getBytes(zipArchiveEntry.getSize()));
        }
    }

    /* access modifiers changed from: protected */
    public void writeCentralFileHeader(ZipArchiveEntry zipArchiveEntry) throws IOException {
        writeCounted(createCentralFileHeader(zipArchiveEntry));
    }

    private byte[] createCentralFileHeader(ZipArchiveEntry zipArchiveEntry) throws IOException {
        EntryMetaData entryMetaData = this.metaData.get(zipArchiveEntry);
        boolean z = hasZip64Extra(zipArchiveEntry) || zipArchiveEntry.getCompressedSize() >= 4294967295L || zipArchiveEntry.getSize() >= 4294967295L || entryMetaData.offset >= 4294967295L || this.zip64Mode == Zip64Mode.Always;
        if (!z || this.zip64Mode != Zip64Mode.Never) {
            handleZip64Extra(zipArchiveEntry, entryMetaData.offset, z);
            return createCentralFileHeader(zipArchiveEntry, getName(zipArchiveEntry), entryMetaData, z);
        }
        throw new Zip64RequiredException("Archive's size exceeds the limit of 4GByte.");
    }

    private byte[] createCentralFileHeader(ZipArchiveEntry zipArchiveEntry, ByteBuffer byteBuffer, EntryMetaData entryMetaData, boolean z) throws IOException {
        byte[] centralDirectoryExtra = zipArchiveEntry.getCentralDirectoryExtra();
        String comment2 = zipArchiveEntry.getComment();
        if (comment2 == null) {
            comment2 = "";
        }
        ByteBuffer encode = getEntryEncoding(zipArchiveEntry).encode(comment2);
        int limit = byteBuffer.limit() - byteBuffer.position();
        int limit2 = encode.limit() - encode.position();
        int i = limit + 46;
        byte[] bArr = new byte[(centralDirectoryExtra.length + i + limit2)];
        System.arraycopy(CFH_SIG, 0, bArr, 0, 4);
        ZipShort.putShort((zipArchiveEntry.getPlatform() << 8) | (!this.hasUsedZip64 ? 20 : 45), bArr, 4);
        int method2 = zipArchiveEntry.getMethod();
        boolean canEncode = this.zipEncoding.canEncode(zipArchiveEntry.getName());
        ZipShort.putShort(versionNeededToExtract(method2, z, entryMetaData.usesDataDescriptor), bArr, 6);
        getGeneralPurposeBits(!canEncode && this.fallbackToUTF8, entryMetaData.usesDataDescriptor).encode(bArr, 8);
        ZipShort.putShort(method2, bArr, 10);
        ZipUtil.toDosTime(this.calendarInstance, zipArchiveEntry.getTime(), bArr, 12);
        ZipLong.putLong(zipArchiveEntry.getCrc(), bArr, 16);
        if (zipArchiveEntry.getCompressedSize() >= 4294967295L || zipArchiveEntry.getSize() >= 4294967295L || this.zip64Mode == Zip64Mode.Always) {
            ZipLong.ZIP64_MAGIC.putLong(bArr, 20);
            ZipLong.ZIP64_MAGIC.putLong(bArr, 24);
        } else {
            ZipLong.putLong(zipArchiveEntry.getCompressedSize(), bArr, 20);
            ZipLong.putLong(zipArchiveEntry.getSize(), bArr, 24);
        }
        ZipShort.putShort(limit, bArr, 28);
        ZipShort.putShort(centralDirectoryExtra.length, bArr, 30);
        ZipShort.putShort(limit2, bArr, 32);
        System.arraycopy(ZERO, 0, bArr, 34, 2);
        ZipShort.putShort(zipArchiveEntry.getInternalAttributes(), bArr, 36);
        ZipLong.putLong(zipArchiveEntry.getExternalAttributes(), bArr, 38);
        if (entryMetaData.offset >= 4294967295L || this.zip64Mode == Zip64Mode.Always) {
            ZipLong.putLong(4294967295L, bArr, 42);
        } else {
            ZipLong.putLong(Math.min(entryMetaData.offset, 4294967295L), bArr, 42);
        }
        System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset(), bArr, 46, limit);
        System.arraycopy(centralDirectoryExtra, 0, bArr, i, centralDirectoryExtra.length);
        System.arraycopy(encode.array(), encode.arrayOffset(), bArr, i + centralDirectoryExtra.length, limit2);
        return bArr;
    }

    private void handleZip64Extra(ZipArchiveEntry zipArchiveEntry, long j, boolean z) {
        if (z) {
            Zip64ExtendedInformationExtraField zip64Extra = getZip64Extra(zipArchiveEntry);
            if (zipArchiveEntry.getCompressedSize() >= 4294967295L || zipArchiveEntry.getSize() >= 4294967295L || this.zip64Mode == Zip64Mode.Always) {
                zip64Extra.setCompressedSize(new ZipEightByteInteger(zipArchiveEntry.getCompressedSize()));
                zip64Extra.setSize(new ZipEightByteInteger(zipArchiveEntry.getSize()));
            } else {
                zip64Extra.setCompressedSize((ZipEightByteInteger) null);
                zip64Extra.setSize((ZipEightByteInteger) null);
            }
            if (j >= 4294967295L || this.zip64Mode == Zip64Mode.Always) {
                zip64Extra.setRelativeHeaderOffset(new ZipEightByteInteger(j));
            }
            zipArchiveEntry.setExtra();
        }
    }

    /* access modifiers changed from: protected */
    public void writeCentralDirectoryEnd() throws IOException {
        writeCounted(EOCD_SIG);
        byte[] bArr = ZERO;
        writeCounted(bArr);
        writeCounted(bArr);
        int size = this.entries.size();
        if (size > 65535 && this.zip64Mode == Zip64Mode.Never) {
            throw new Zip64RequiredException("Archive contains more than 65535 entries.");
        } else if (this.cdOffset <= 4294967295L || this.zip64Mode != Zip64Mode.Never) {
            byte[] bytes = ZipShort.getBytes(Math.min(size, 65535));
            writeCounted(bytes);
            writeCounted(bytes);
            writeCounted(ZipLong.getBytes(Math.min(this.cdLength, 4294967295L)));
            writeCounted(ZipLong.getBytes(Math.min(this.cdOffset, 4294967295L)));
            ByteBuffer encode = this.zipEncoding.encode(this.comment);
            int limit = encode.limit() - encode.position();
            writeCounted(ZipShort.getBytes(limit));
            this.streamCompressor.writeCounted(encode.array(), encode.arrayOffset(), limit);
        } else {
            throw new Zip64RequiredException("Archive's size exceeds the limit of 4GByte.");
        }
    }

    /* access modifiers changed from: protected */
    public void writeZip64CentralDirectory() throws IOException {
        if (this.zip64Mode != Zip64Mode.Never) {
            if (!this.hasUsedZip64 && (this.cdOffset >= 4294967295L || this.cdLength >= 4294967295L || this.entries.size() >= 65535)) {
                this.hasUsedZip64 = true;
            }
            if (this.hasUsedZip64) {
                long totalBytesWritten = this.streamCompressor.getTotalBytesWritten();
                writeOut(ZIP64_EOCD_SIG);
                writeOut(ZipEightByteInteger.getBytes(44));
                writeOut(ZipShort.getBytes(45));
                writeOut(ZipShort.getBytes(45));
                byte[] bArr = LZERO;
                writeOut(bArr);
                writeOut(bArr);
                byte[] bytes = ZipEightByteInteger.getBytes((long) this.entries.size());
                writeOut(bytes);
                writeOut(bytes);
                writeOut(ZipEightByteInteger.getBytes(this.cdLength));
                writeOut(ZipEightByteInteger.getBytes(this.cdOffset));
                writeOut(ZIP64_EOCD_LOC_SIG);
                writeOut(bArr);
                writeOut(ZipEightByteInteger.getBytes(totalBytesWritten));
                writeOut(ONE);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void writeOut(byte[] bArr) throws IOException {
        this.streamCompressor.writeOut(bArr, 0, bArr.length);
    }

    /* access modifiers changed from: protected */
    public final void writeOut(byte[] bArr, int i, int i2) throws IOException {
        this.streamCompressor.writeOut(bArr, i, i2);
    }

    private GeneralPurposeBit getGeneralPurposeBits(boolean z, boolean z2) {
        GeneralPurposeBit generalPurposeBit = new GeneralPurposeBit();
        generalPurposeBit.useUTF8ForNames(this.useUTF8Flag || z);
        if (z2) {
            generalPurposeBit.useDataDescriptor(true);
        }
        return generalPurposeBit;
    }

    private int versionNeededToExtract(int i, boolean z, boolean z2) {
        if (z) {
            return 45;
        }
        if (z2) {
            return 20;
        }
        return versionNeededToExtractMethod(i);
    }

    private boolean usesDataDescriptor(int i, boolean z) {
        return !z && i == 8 && this.channel == null;
    }

    public ArchiveEntry createArchiveEntry(File file, String str) throws IOException {
        if (!this.finished) {
            return new ZipArchiveEntry(file, str);
        }
        throw new IOException("Stream has already been finished");
    }

    private Zip64ExtendedInformationExtraField getZip64Extra(ZipArchiveEntry zipArchiveEntry) {
        CurrentEntry currentEntry = this.entry;
        if (currentEntry != null) {
            boolean unused = currentEntry.causedUseOfZip64 = !this.hasUsedZip64;
        }
        this.hasUsedZip64 = true;
        Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField = (Zip64ExtendedInformationExtraField) zipArchiveEntry.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
        if (zip64ExtendedInformationExtraField == null) {
            zip64ExtendedInformationExtraField = new Zip64ExtendedInformationExtraField();
        }
        zipArchiveEntry.addAsFirstExtraField(zip64ExtendedInformationExtraField);
        return zip64ExtendedInformationExtraField;
    }

    private boolean hasZip64Extra(ZipArchiveEntry zipArchiveEntry) {
        return zipArchiveEntry.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID) != null;
    }

    private Zip64Mode getEffectiveZip64Mode(ZipArchiveEntry zipArchiveEntry) {
        if (this.zip64Mode == Zip64Mode.AsNeeded && this.channel == null && zipArchiveEntry.getMethod() == 8 && zipArchiveEntry.getSize() == -1) {
            return Zip64Mode.Never;
        }
        return this.zip64Mode;
    }

    private ZipEncoding getEntryEncoding(ZipArchiveEntry zipArchiveEntry) {
        return (this.zipEncoding.canEncode(zipArchiveEntry.getName()) || !this.fallbackToUTF8) ? this.zipEncoding : ZipEncodingHelper.UTF8_ZIP_ENCODING;
    }

    private ByteBuffer getName(ZipArchiveEntry zipArchiveEntry) throws IOException {
        return getEntryEncoding(zipArchiveEntry).encode(zipArchiveEntry.getName());
    }

    /* access modifiers changed from: package-private */
    public void destroy() throws IOException {
        try {
            SeekableByteChannel seekableByteChannel = this.channel;
            if (seekableByteChannel != null) {
                Beacon$$ExternalSyntheticApiModelOutline0.m(seekableByteChannel);
            }
        } finally {
            OutputStream outputStream = this.out;
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    public static final class UnicodeExtraFieldPolicy {
        public static final UnicodeExtraFieldPolicy ALWAYS = new UnicodeExtraFieldPolicy("always");
        public static final UnicodeExtraFieldPolicy NEVER = new UnicodeExtraFieldPolicy("never");
        public static final UnicodeExtraFieldPolicy NOT_ENCODEABLE = new UnicodeExtraFieldPolicy("not encodeable");
        private final String name;

        private UnicodeExtraFieldPolicy(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    private static final class CurrentEntry {
        /* access modifiers changed from: private */
        public long bytesRead;
        /* access modifiers changed from: private */
        public boolean causedUseOfZip64;
        /* access modifiers changed from: private */
        public long dataStart;
        /* access modifiers changed from: private */
        public final ZipArchiveEntry entry;
        /* access modifiers changed from: private */
        public boolean hasWritten;
        /* access modifiers changed from: private */
        public long localDataStart;

        private CurrentEntry(ZipArchiveEntry zipArchiveEntry) {
            this.localDataStart = 0;
            this.dataStart = 0;
            this.bytesRead = 0;
            this.causedUseOfZip64 = false;
            this.entry = zipArchiveEntry;
        }
    }

    private static final class EntryMetaData {
        /* access modifiers changed from: private */
        public final long offset;
        /* access modifiers changed from: private */
        public final boolean usesDataDescriptor;

        private EntryMetaData(long j, boolean z) {
            this.offset = j;
            this.usesDataDescriptor = z;
        }
    }
}
