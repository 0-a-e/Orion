package org.apache.commons.compress.archivers.zip;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.commons.compress.archivers.zip.UnsupportedZipFeatureException;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.deflate64.Deflate64CompressorInputStream;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

public class ZipArchiveInputStream extends ArchiveInputStream implements InputStreamStatistics {
    private static final byte[] APK_SIGNING_BLOCK_MAGIC = {65, 80, TarConstants.LF_GNUTYPE_LONGLINK, 32, TarConstants.LF_GNUTYPE_SPARSE, 105, TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 32, 66, 108, 111, 99, 107, 32, TarConstants.LF_BLK, TarConstants.LF_SYMLINK};
    private static final byte[] CFH = ZipLong.CFH_SIG.getBytes();
    private static final int CFH_LEN = 46;
    private static final byte[] DD = ZipLong.DD_SIG.getBytes();
    private static final byte[] LFH = ZipLong.LFH_SIG.getBytes();
    private static final int LFH_LEN = 30;
    private static final BigInteger LONG_MAX = BigInteger.valueOf(Long.MAX_VALUE);
    private static final long TWO_EXP_32 = 4294967296L;
    private static final String USE_ZIPFILE_INSTEAD_OF_STREAM_DISCLAIMER = " while reading a stored entry using data descriptor. Either the archive is broken or it can not be read using ZipArchiveInputStream and you must use ZipFile. A common cause for this is a ZIP archive containing a ZIP archive. See http://commons.apache.org/proper/commons-compress/zip.html#ZipArchiveInputStream_vs_ZipFile";
    private boolean allowStoredEntriesWithDataDescriptor;
    private final ByteBuffer buf;
    private boolean closed;
    /* access modifiers changed from: private */
    public CurrentEntry current;
    final String encoding;
    private int entriesRead;
    private boolean hitCentralDirectory;
    private final InputStream in;
    private final Inflater inf;
    private ByteArrayInputStream lastStoredEntry;
    private final byte[] lfhBuf;
    private final byte[] shortBuf;
    private final byte[] skipBuf;
    private final byte[] twoDwordBuf;
    private long uncompressedCount;
    private final boolean useUnicodeExtraFields;
    private final byte[] wordBuf;
    private final ZipEncoding zipEncoding;

    public ZipArchiveInputStream(InputStream inputStream) {
        this(inputStream, "UTF8");
    }

    public ZipArchiveInputStream(InputStream inputStream, String str) {
        this(inputStream, str, true);
    }

    public ZipArchiveInputStream(InputStream inputStream, String str, boolean z) {
        this(inputStream, str, z, false);
    }

    public ZipArchiveInputStream(InputStream inputStream, String str, boolean z, boolean z2) {
        this.inf = new Inflater(true);
        ByteBuffer allocate = ByteBuffer.allocate(512);
        this.buf = allocate;
        this.current = null;
        this.closed = false;
        this.hitCentralDirectory = false;
        this.lastStoredEntry = null;
        this.allowStoredEntriesWithDataDescriptor = false;
        this.uncompressedCount = 0;
        this.lfhBuf = new byte[30];
        this.skipBuf = new byte[1024];
        this.shortBuf = new byte[2];
        this.wordBuf = new byte[4];
        this.twoDwordBuf = new byte[16];
        this.entriesRead = 0;
        this.encoding = str;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(str);
        this.useUnicodeExtraFields = z;
        this.in = new PushbackInputStream(inputStream, allocate.capacity());
        this.allowStoredEntriesWithDataDescriptor = z2;
        allocate.limit(0);
    }

    public ZipArchiveEntry getNextZipEntry() throws IOException {
        boolean z;
        ZipLong zipLong;
        ZipLong zipLong2;
        this.uncompressedCount = 0;
        if (!this.closed && !this.hitCentralDirectory) {
            if (this.current != null) {
                closeEntry();
                z = false;
            } else {
                z = true;
            }
            long bytesRead = getBytesRead();
            if (z) {
                try {
                    readFirstLocalFileHeader(this.lfhBuf);
                } catch (EOFException unused) {
                }
            } else {
                readFully(this.lfhBuf);
            }
            ZipLong zipLong3 = new ZipLong(this.lfhBuf);
            if (zipLong3.equals(ZipLong.LFH_SIG)) {
                this.current = new CurrentEntry((AnonymousClass1) null);
                this.current.entry.setPlatform((ZipShort.getValue(this.lfhBuf, 4) >> 8) & 15);
                GeneralPurposeBit parse = GeneralPurposeBit.parse(this.lfhBuf, 6);
                boolean usesUTF8ForNames = parse.usesUTF8ForNames();
                ZipEncoding zipEncoding2 = usesUTF8ForNames ? ZipEncodingHelper.UTF8_ZIP_ENCODING : this.zipEncoding;
                boolean unused2 = this.current.hasDataDescriptor = parse.usesDataDescriptor();
                this.current.entry.setGeneralPurposeBit(parse);
                this.current.entry.setMethod(ZipShort.getValue(this.lfhBuf, 8));
                this.current.entry.setTime(ZipUtil.dosToJavaTime(ZipLong.getValue(this.lfhBuf, 10)));
                if (!this.current.hasDataDescriptor) {
                    this.current.entry.setCrc(ZipLong.getValue(this.lfhBuf, 14));
                    zipLong2 = new ZipLong(this.lfhBuf, 18);
                    zipLong = new ZipLong(this.lfhBuf, 22);
                } else {
                    zipLong2 = null;
                    zipLong = null;
                }
                int value = ZipShort.getValue(this.lfhBuf, 26);
                int value2 = ZipShort.getValue(this.lfhBuf, 28);
                byte[] bArr = new byte[value];
                readFully(bArr);
                this.current.entry.setName(zipEncoding2.decode(bArr), bArr);
                if (usesUTF8ForNames) {
                    this.current.entry.setNameSource(ZipArchiveEntry.NameSource.NAME_WITH_EFS_FLAG);
                }
                byte[] bArr2 = new byte[value2];
                readFully(bArr2);
                this.current.entry.setExtra(bArr2);
                if (!usesUTF8ForNames && this.useUnicodeExtraFields) {
                    ZipUtil.setNameAndCommentFromExtraFields(this.current.entry, bArr, (byte[]) null);
                }
                processZip64Extra(zipLong, zipLong2);
                this.current.entry.setLocalHeaderOffset(bytesRead);
                this.current.entry.setDataOffset(getBytesRead());
                this.current.entry.setStreamContiguous(true);
                ZipMethod methodByCode = ZipMethod.getMethodByCode(this.current.entry.getMethod());
                if (this.current.entry.getCompressedSize() != -1) {
                    if (!(!ZipUtil.canHandleEntryData(this.current.entry) || methodByCode == ZipMethod.STORED || methodByCode == ZipMethod.DEFLATED)) {
                        BoundedInputStream boundedInputStream = new BoundedInputStream(this.in, this.current.entry.getCompressedSize());
                        int i = AnonymousClass1.$SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[methodByCode.ordinal()];
                        if (i == 1) {
                            InputStream unused3 = this.current.in = new UnshrinkingInputStream(boundedInputStream);
                        } else if (i == 2) {
                            InputStream unused4 = this.current.in = new ExplodingInputStream(this.current.entry.getGeneralPurposeBit().getSlidingDictionarySize(), this.current.entry.getGeneralPurposeBit().getNumberOfShannonFanoTrees(), boundedInputStream);
                        } else if (i == 3) {
                            InputStream unused5 = this.current.in = new BZip2CompressorInputStream(boundedInputStream);
                        } else if (i == 4) {
                            InputStream unused6 = this.current.in = new Deflate64CompressorInputStream((InputStream) boundedInputStream);
                        }
                    }
                } else if (methodByCode == ZipMethod.ENHANCED_DEFLATED) {
                    InputStream unused7 = this.current.in = new Deflate64CompressorInputStream(this.in);
                }
                this.entriesRead++;
                return this.current.entry;
            } else if (zipLong3.equals(ZipLong.CFH_SIG) || zipLong3.equals(ZipLong.AED_SIG) || isApkSigningBlock(this.lfhBuf)) {
                this.hitCentralDirectory = true;
                skipRemainderOfArchive();
                return null;
            } else {
                throw new ZipException(String.format("Unexpected record signature: 0X%X", new Object[]{Long.valueOf(zipLong3.getValue())}));
            }
        }
        return null;
    }

    /* renamed from: org.apache.commons.compress.archivers.zip.ZipArchiveInputStream$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                org.apache.commons.compress.archivers.zip.ZipMethod[] r0 = org.apache.commons.compress.archivers.zip.ZipMethod.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod = r0
                org.apache.commons.compress.archivers.zip.ZipMethod r1 = org.apache.commons.compress.archivers.zip.ZipMethod.UNSHRINKING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod     // Catch:{ NoSuchFieldError -> 0x001d }
                org.apache.commons.compress.archivers.zip.ZipMethod r1 = org.apache.commons.compress.archivers.zip.ZipMethod.IMPLODING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.apache.commons.compress.archivers.zip.ZipMethod r1 = org.apache.commons.compress.archivers.zip.ZipMethod.BZIP2     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.apache.commons.compress.archivers.zip.ZipMethod r1 = org.apache.commons.compress.archivers.zip.ZipMethod.ENHANCED_DEFLATED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.zip.ZipArchiveInputStream.AnonymousClass1.<clinit>():void");
        }
    }

    private void readFirstLocalFileHeader(byte[] bArr) throws IOException {
        readFully(bArr);
        ZipLong zipLong = new ZipLong(bArr);
        if (zipLong.equals(ZipLong.DD_SIG)) {
            throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.SPLITTING);
        } else if (zipLong.equals(ZipLong.SINGLE_SEGMENT_SPLIT_MARKER)) {
            byte[] bArr2 = new byte[4];
            readFully(bArr2);
            System.arraycopy(bArr, 4, bArr, 0, 26);
            System.arraycopy(bArr2, 0, bArr, 26, 4);
        }
    }

    private void processZip64Extra(ZipLong zipLong, ZipLong zipLong2) {
        Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField = (Zip64ExtendedInformationExtraField) this.current.entry.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
        boolean unused = this.current.usesZip64 = zip64ExtendedInformationExtraField != null;
        if (this.current.hasDataDescriptor) {
            return;
        }
        if (zip64ExtendedInformationExtraField != null && (ZipLong.ZIP64_MAGIC.equals(zipLong2) || ZipLong.ZIP64_MAGIC.equals(zipLong))) {
            this.current.entry.setCompressedSize(zip64ExtendedInformationExtraField.getCompressedSize().getLongValue());
            this.current.entry.setSize(zip64ExtendedInformationExtraField.getSize().getLongValue());
        } else if (zipLong2 != null && zipLong != null) {
            this.current.entry.setCompressedSize(zipLong2.getValue());
            this.current.entry.setSize(zipLong.getValue());
        }
    }

    public ArchiveEntry getNextEntry() throws IOException {
        return getNextZipEntry();
    }

    public boolean canReadEntryData(ArchiveEntry archiveEntry) {
        if (!(archiveEntry instanceof ZipArchiveEntry)) {
            return false;
        }
        ZipArchiveEntry zipArchiveEntry = (ZipArchiveEntry) archiveEntry;
        if (!ZipUtil.canHandleEntryData(zipArchiveEntry) || !supportsDataDescriptorFor(zipArchiveEntry) || !supportsCompressedSizeFor(zipArchiveEntry)) {
            return false;
        }
        return true;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (!this.closed) {
            CurrentEntry currentEntry = this.current;
            if (currentEntry == null) {
                return -1;
            }
            if (i > bArr.length || i2 < 0 || i < 0 || bArr.length - i < i2) {
                throw new ArrayIndexOutOfBoundsException();
            }
            ZipUtil.checkRequestedFeatures(currentEntry.entry);
            if (!supportsDataDescriptorFor(this.current.entry)) {
                throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.DATA_DESCRIPTOR, this.current.entry);
            } else if (supportsCompressedSizeFor(this.current.entry)) {
                if (this.current.entry.getMethod() == 0) {
                    i3 = readStored(bArr, i, i2);
                } else if (this.current.entry.getMethod() == 8) {
                    i3 = readDeflated(bArr, i, i2);
                } else if (this.current.entry.getMethod() == ZipMethod.UNSHRINKING.getCode() || this.current.entry.getMethod() == ZipMethod.IMPLODING.getCode() || this.current.entry.getMethod() == ZipMethod.ENHANCED_DEFLATED.getCode() || this.current.entry.getMethod() == ZipMethod.BZIP2.getCode()) {
                    i3 = this.current.in.read(bArr, i, i2);
                } else {
                    throw new UnsupportedZipFeatureException(ZipMethod.getMethodByCode(this.current.entry.getMethod()), this.current.entry);
                }
                if (i3 >= 0) {
                    this.current.crc.update(bArr, i, i3);
                    this.uncompressedCount += (long) i3;
                }
                return i3;
            } else {
                throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.UNKNOWN_COMPRESSED_SIZE, this.current.entry);
            }
        } else {
            throw new IOException("The stream is closed");
        }
    }

    public long getCompressedCount() {
        if (this.current.entry.getMethod() == 0) {
            return this.current.bytesRead;
        }
        if (this.current.entry.getMethod() == 8) {
            return getBytesInflated();
        }
        if (this.current.entry.getMethod() == ZipMethod.UNSHRINKING.getCode()) {
            return ((UnshrinkingInputStream) this.current.in).getCompressedCount();
        }
        if (this.current.entry.getMethod() == ZipMethod.IMPLODING.getCode()) {
            return ((ExplodingInputStream) this.current.in).getCompressedCount();
        }
        if (this.current.entry.getMethod() == ZipMethod.ENHANCED_DEFLATED.getCode()) {
            return ((Deflate64CompressorInputStream) this.current.in).getCompressedCount();
        }
        if (this.current.entry.getMethod() == ZipMethod.BZIP2.getCode()) {
            return ((BZip2CompressorInputStream) this.current.in).getCompressedCount();
        }
        return -1;
    }

    public long getUncompressedCount() {
        return this.uncompressedCount;
    }

    private int readStored(byte[] bArr, int i, int i2) throws IOException {
        if (this.current.hasDataDescriptor) {
            if (this.lastStoredEntry == null) {
                readStoredEntry();
            }
            return this.lastStoredEntry.read(bArr, i, i2);
        }
        long size = this.current.entry.getSize();
        if (this.current.bytesRead >= size) {
            return -1;
        }
        if (this.buf.position() >= this.buf.limit()) {
            this.buf.position(0);
            int read = this.in.read(this.buf.array());
            if (read != -1) {
                this.buf.limit(read);
                count(read);
                CurrentEntry currentEntry = this.current;
                long unused = currentEntry.bytesReadFromStream = currentEntry.bytesReadFromStream + ((long) read);
            } else {
                this.buf.limit(0);
                throw new IOException("Truncated ZIP file");
            }
        }
        int min = Math.min(this.buf.remaining(), i2);
        if (size - this.current.bytesRead < ((long) min)) {
            min = (int) (size - this.current.bytesRead);
        }
        this.buf.get(bArr, i, min);
        CurrentEntry currentEntry2 = this.current;
        long unused2 = currentEntry2.bytesRead = currentEntry2.bytesRead + ((long) min);
        return min;
    }

    private int readDeflated(byte[] bArr, int i, int i2) throws IOException {
        int readFromInflater = readFromInflater(bArr, i, i2);
        if (readFromInflater <= 0) {
            if (this.inf.finished()) {
                return -1;
            }
            if (this.inf.needsDictionary()) {
                throw new ZipException("This archive needs a preset dictionary which is not supported by Commons Compress.");
            } else if (readFromInflater == -1) {
                throw new IOException("Truncated ZIP file");
            }
        }
        return readFromInflater;
    }

    private int readFromInflater(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (true) {
            if (this.inf.needsInput()) {
                int fill = fill();
                if (fill > 0) {
                    CurrentEntry currentEntry = this.current;
                    long unused = currentEntry.bytesReadFromStream = currentEntry.bytesReadFromStream + ((long) this.buf.limit());
                } else if (fill == -1) {
                    return -1;
                }
            }
            try {
                i3 = this.inf.inflate(bArr, i, i2);
                if (i3 == 0) {
                    if (!this.inf.needsInput()) {
                        break;
                    }
                } else {
                    break;
                }
            } catch (DataFormatException e) {
                throw ((IOException) new ZipException(e.getMessage()).initCause(e));
            }
        }
        return i3;
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            try {
                this.in.close();
            } finally {
                this.inf.end();
            }
        }
    }

    public long skip(long j) throws IOException {
        long j2 = 0;
        if (j >= 0) {
            while (j2 < j) {
                long j3 = j - j2;
                byte[] bArr = this.skipBuf;
                if (((long) bArr.length) <= j3) {
                    j3 = (long) bArr.length;
                }
                int read = read(bArr, 0, (int) j3);
                if (read == -1) {
                    return j2;
                }
                j2 += (long) read;
            }
            return j2;
        }
        throw new IllegalArgumentException();
    }

    public static boolean matches(byte[] bArr, int i) {
        if (i < ZipArchiveOutputStream.LFH_SIG.length) {
            return false;
        }
        if (checksig(bArr, ZipArchiveOutputStream.LFH_SIG) || checksig(bArr, ZipArchiveOutputStream.EOCD_SIG) || checksig(bArr, ZipArchiveOutputStream.DD_SIG) || checksig(bArr, ZipLong.SINGLE_SEGMENT_SPLIT_MARKER.getBytes())) {
            return true;
        }
        return false;
    }

    private static boolean checksig(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private void closeEntry() throws IOException {
        if (this.closed) {
            throw new IOException("The stream is closed");
        } else if (this.current != null) {
            if (currentEntryHasOutstandingBytes()) {
                drainCurrentEntryData();
            } else {
                skip(Long.MAX_VALUE);
                int access$700 = (int) (this.current.bytesReadFromStream - (this.current.entry.getMethod() == 8 ? getBytesInflated() : this.current.bytesRead));
                if (access$700 > 0) {
                    pushback(this.buf.array(), this.buf.limit() - access$700, access$700);
                    CurrentEntry currentEntry = this.current;
                    long unused = currentEntry.bytesReadFromStream = currentEntry.bytesReadFromStream - ((long) access$700);
                }
                if (currentEntryHasOutstandingBytes()) {
                    drainCurrentEntryData();
                }
            }
            if (this.lastStoredEntry == null && this.current.hasDataDescriptor) {
                readDataDescriptor();
            }
            this.inf.reset();
            this.buf.clear().flip();
            this.current = null;
            this.lastStoredEntry = null;
        }
    }

    private boolean currentEntryHasOutstandingBytes() {
        return this.current.bytesReadFromStream <= this.current.entry.getCompressedSize() && !this.current.hasDataDescriptor;
    }

    private void drainCurrentEntryData() throws IOException {
        long compressedSize = this.current.entry.getCompressedSize() - this.current.bytesReadFromStream;
        while (compressedSize > 0) {
            long read = (long) this.in.read(this.buf.array(), 0, (int) Math.min((long) this.buf.capacity(), compressedSize));
            if (read >= 0) {
                count(read);
                compressedSize -= read;
            } else {
                throw new EOFException("Truncated ZIP entry: " + ArchiveUtils.sanitize(this.current.entry.getName()));
            }
        }
    }

    private long getBytesInflated() {
        long bytesRead = this.inf.getBytesRead();
        if (this.current.bytesReadFromStream >= TWO_EXP_32) {
            while (true) {
                long j = bytesRead + TWO_EXP_32;
                if (j > this.current.bytesReadFromStream) {
                    break;
                }
                bytesRead = j;
            }
        }
        return bytesRead;
    }

    private int fill() throws IOException {
        if (!this.closed) {
            int read = this.in.read(this.buf.array());
            if (read > 0) {
                this.buf.limit(read);
                count(this.buf.limit());
                this.inf.setInput(this.buf.array(), 0, this.buf.limit());
            }
            return read;
        }
        throw new IOException("The stream is closed");
    }

    private void readFully(byte[] bArr) throws IOException {
        readFully(bArr, 0);
    }

    private void readFully(byte[] bArr, int i) throws IOException {
        int length = bArr.length - i;
        int readFully = IOUtils.readFully(this.in, bArr, i, length);
        count(readFully);
        if (readFully < length) {
            throw new EOFException();
        }
    }

    private void readDataDescriptor() throws IOException {
        readFully(this.wordBuf);
        ZipLong zipLong = new ZipLong(this.wordBuf);
        if (ZipLong.DD_SIG.equals(zipLong)) {
            readFully(this.wordBuf);
            zipLong = new ZipLong(this.wordBuf);
        }
        this.current.entry.setCrc(zipLong.getValue());
        readFully(this.twoDwordBuf);
        ZipLong zipLong2 = new ZipLong(this.twoDwordBuf, 8);
        if (zipLong2.equals(ZipLong.CFH_SIG) || zipLong2.equals(ZipLong.LFH_SIG)) {
            pushback(this.twoDwordBuf, 8, 8);
            this.current.entry.setCompressedSize(ZipLong.getValue(this.twoDwordBuf));
            this.current.entry.setSize(ZipLong.getValue(this.twoDwordBuf, 4));
            return;
        }
        this.current.entry.setCompressedSize(ZipEightByteInteger.getLongValue(this.twoDwordBuf));
        this.current.entry.setSize(ZipEightByteInteger.getLongValue(this.twoDwordBuf, 8));
    }

    private boolean supportsDataDescriptorFor(ZipArchiveEntry zipArchiveEntry) {
        return !zipArchiveEntry.getGeneralPurposeBit().usesDataDescriptor() || (this.allowStoredEntriesWithDataDescriptor && zipArchiveEntry.getMethod() == 0) || zipArchiveEntry.getMethod() == 8 || zipArchiveEntry.getMethod() == ZipMethod.ENHANCED_DEFLATED.getCode();
    }

    private boolean supportsCompressedSizeFor(ZipArchiveEntry zipArchiveEntry) {
        return zipArchiveEntry.getCompressedSize() != -1 || zipArchiveEntry.getMethod() == 8 || zipArchiveEntry.getMethod() == ZipMethod.ENHANCED_DEFLATED.getCode() || (zipArchiveEntry.getGeneralPurposeBit().usesDataDescriptor() && this.allowStoredEntriesWithDataDescriptor && zipArchiveEntry.getMethod() == 0);
    }

    private void readStoredEntry() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = this.current.usesZip64 ? 20 : 12;
        boolean z = false;
        int i2 = 0;
        while (!z) {
            int read = this.in.read(this.buf.array(), i2, 512 - i2);
            if (read > 0) {
                int i3 = read + i2;
                if (i3 < 4) {
                    i2 = i3;
                } else {
                    z = bufferContainsSignature(byteArrayOutputStream, i2, read, i);
                    if (!z) {
                        i2 = cacheBytesRead(byteArrayOutputStream, i2, read, i);
                    }
                }
            } else {
                throw new IOException("Truncated ZIP file");
            }
        }
        if (this.current.entry.getCompressedSize() == this.current.entry.getSize()) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (((long) byteArray.length) == this.current.entry.getSize()) {
                this.lastStoredEntry = new ByteArrayInputStream(byteArray);
                return;
            }
            throw new ZipException("actual and claimed size don't match while reading a stored entry using data descriptor. Either the archive is broken or it can not be read using ZipArchiveInputStream and you must use ZipFile. A common cause for this is a ZIP archive containing a ZIP archive. See http://commons.apache.org/proper/commons-compress/zip.html#ZipArchiveInputStream_vs_ZipFile");
        }
        throw new ZipException("compressed and uncompressed size don't match while reading a stored entry using data descriptor. Either the archive is broken or it can not be read using ZipArchiveInputStream and you must use ZipFile. A common cause for this is a ZIP archive containing a ZIP archive. See http://commons.apache.org/proper/commons-compress/zip.html#ZipArchiveInputStream_vs_ZipFile");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a2 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean bufferContainsSignature(java.io.ByteArrayOutputStream r11, int r12, int r13, int r14) throws java.io.IOException {
        /*
            r10 = this;
            r0 = 0
            r1 = r0
            r2 = r1
        L_0x0003:
            if (r1 != 0) goto L_0x00a6
            int r3 = r12 + r13
            int r4 = r3 + -4
            if (r2 >= r4) goto L_0x00a6
            java.nio.ByteBuffer r4 = r10.buf
            byte[] r4 = r4.array()
            byte r4 = r4[r2]
            byte[] r5 = LFH
            byte r6 = r5[r0]
            if (r4 != r6) goto L_0x00a2
            java.nio.ByteBuffer r4 = r10.buf
            byte[] r4 = r4.array()
            int r6 = r2 + 1
            byte r4 = r4[r6]
            r6 = 1
            byte r7 = r5[r6]
            if (r4 != r7) goto L_0x00a2
            r4 = 2
            r7 = 3
            if (r2 < r14) goto L_0x0048
            java.nio.ByteBuffer r8 = r10.buf
            byte[] r8 = r8.array()
            int r9 = r2 + 2
            byte r8 = r8[r9]
            byte r9 = r5[r4]
            if (r8 != r9) goto L_0x0048
            java.nio.ByteBuffer r8 = r10.buf
            byte[] r8 = r8.array()
            int r9 = r2 + 3
            byte r8 = r8[r9]
            byte r5 = r5[r7]
            if (r8 == r5) goto L_0x0064
        L_0x0048:
            java.nio.ByteBuffer r5 = r10.buf
            byte[] r5 = r5.array()
            byte r5 = r5[r2]
            byte[] r8 = CFH
            byte r9 = r8[r4]
            if (r5 != r9) goto L_0x0069
            java.nio.ByteBuffer r5 = r10.buf
            byte[] r5 = r5.array()
            int r9 = r2 + 3
            byte r5 = r5[r9]
            byte r8 = r8[r7]
            if (r5 != r8) goto L_0x0069
        L_0x0064:
            int r1 = r2 - r14
            r4 = r1
        L_0x0067:
            r1 = r6
            goto L_0x008a
        L_0x0069:
            java.nio.ByteBuffer r5 = r10.buf
            byte[] r5 = r5.array()
            int r8 = r2 + 2
            byte r5 = r5[r8]
            byte[] r8 = DD
            byte r4 = r8[r4]
            if (r5 != r4) goto L_0x0089
            java.nio.ByteBuffer r4 = r10.buf
            byte[] r4 = r4.array()
            int r5 = r2 + 3
            byte r4 = r4[r5]
            byte r5 = r8[r7]
            if (r4 != r5) goto L_0x0089
            r4 = r2
            goto L_0x0067
        L_0x0089:
            r4 = r2
        L_0x008a:
            if (r1 == 0) goto L_0x00a2
            java.nio.ByteBuffer r5 = r10.buf
            byte[] r5 = r5.array()
            int r3 = r3 - r4
            r10.pushback(r5, r4, r3)
            java.nio.ByteBuffer r3 = r10.buf
            byte[] r3 = r3.array()
            r11.write(r3, r0, r4)
            r10.readDataDescriptor()
        L_0x00a2:
            int r2 = r2 + 1
            goto L_0x0003
        L_0x00a6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.zip.ZipArchiveInputStream.bufferContainsSignature(java.io.ByteArrayOutputStream, int, int, int):boolean");
    }

    private int cacheBytesRead(ByteArrayOutputStream byteArrayOutputStream, int i, int i2, int i3) {
        int i4 = i + i2;
        int i5 = (i4 - i3) - 3;
        if (i5 <= 0) {
            return i4;
        }
        byteArrayOutputStream.write(this.buf.array(), 0, i5);
        int i6 = i3 + 3;
        System.arraycopy(this.buf.array(), i5, this.buf.array(), 0, i6);
        return i6;
    }

    private void pushback(byte[] bArr, int i, int i2) throws IOException {
        ((PushbackInputStream) this.in).unread(bArr, i, i2);
        pushedBackBytes((long) i2);
    }

    private void skipRemainderOfArchive() throws IOException {
        realSkip((((long) this.entriesRead) * 46) - 30);
        findEocdRecord();
        realSkip(16);
        readFully(this.shortBuf);
        realSkip((long) ZipShort.getValue(this.shortBuf));
    }

    private void findEocdRecord() throws IOException {
        int i = -1;
        while (true) {
            boolean z = false;
            while (true) {
                if (!z) {
                    i = readOneByte();
                    if (i <= -1) {
                        return;
                    }
                }
                if (isFirstByteOfEocdSig(i)) {
                    i = readOneByte();
                    if (i == ZipArchiveOutputStream.EOCD_SIG[1]) {
                        i = readOneByte();
                        if (i == ZipArchiveOutputStream.EOCD_SIG[2]) {
                            i = readOneByte();
                            if (i != -1 && i != ZipArchiveOutputStream.EOCD_SIG[3]) {
                                z = isFirstByteOfEocdSig(i);
                            } else {
                                return;
                            }
                        } else if (i != -1) {
                            z = isFirstByteOfEocdSig(i);
                        } else {
                            return;
                        }
                    } else if (i != -1) {
                        z = isFirstByteOfEocdSig(i);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private void realSkip(long j) throws IOException {
        long j2 = 0;
        if (j >= 0) {
            while (j2 < j) {
                long j3 = j - j2;
                InputStream inputStream = this.in;
                byte[] bArr = this.skipBuf;
                if (((long) bArr.length) <= j3) {
                    j3 = (long) bArr.length;
                }
                int read = inputStream.read(bArr, 0, (int) j3);
                if (read != -1) {
                    count(read);
                    j2 += (long) read;
                } else {
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    private int readOneByte() throws IOException {
        int read = this.in.read();
        if (read != -1) {
            count(1);
        }
        return read;
    }

    private boolean isFirstByteOfEocdSig(int i) {
        return i == ZipArchiveOutputStream.EOCD_SIG[0];
    }

    private boolean isApkSigningBlock(byte[] bArr) throws IOException {
        BigInteger value = ZipEightByteInteger.getValue(bArr);
        long length = (long) (8 - bArr.length);
        byte[] bArr2 = APK_SIGNING_BLOCK_MAGIC;
        BigInteger add = value.add(BigInteger.valueOf(length - ((long) bArr2.length)));
        int length2 = bArr2.length;
        byte[] bArr3 = new byte[length2];
        try {
            if (add.signum() < 0) {
                int length3 = bArr.length + add.intValue();
                if (length3 < 8) {
                    return false;
                }
                int abs = Math.abs(add.intValue());
                System.arraycopy(bArr, length3, bArr3, 0, Math.min(abs, length2));
                if (abs < length2) {
                    readFully(bArr3, abs);
                }
            } else {
                while (true) {
                    BigInteger bigInteger = LONG_MAX;
                    if (add.compareTo(bigInteger) <= 0) {
                        break;
                    }
                    realSkip(Long.MAX_VALUE);
                    add = add.add(bigInteger.negate());
                }
                realSkip(add.longValue());
                readFully(bArr3);
            }
            return Arrays.equals(bArr3, APK_SIGNING_BLOCK_MAGIC);
        } catch (EOFException unused) {
            return false;
        }
    }

    private static final class CurrentEntry {
        /* access modifiers changed from: private */
        public long bytesRead;
        /* access modifiers changed from: private */
        public long bytesReadFromStream;
        /* access modifiers changed from: private */
        public final CRC32 crc;
        /* access modifiers changed from: private */
        public final ZipArchiveEntry entry;
        /* access modifiers changed from: private */
        public boolean hasDataDescriptor;
        /* access modifiers changed from: private */
        public InputStream in;
        /* access modifiers changed from: private */
        public boolean usesZip64;

        private CurrentEntry() {
            this.entry = new ZipArchiveEntry();
            this.crc = new CRC32();
        }

        /* synthetic */ CurrentEntry(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ long access$708(CurrentEntry currentEntry) {
            long j = currentEntry.bytesReadFromStream;
            currentEntry.bytesReadFromStream = 1 + j;
            return j;
        }
    }

    private class BoundedInputStream extends InputStream {
        private final InputStream in;
        private final long max;
        private long pos = 0;

        public BoundedInputStream(InputStream inputStream, long j) {
            this.max = j;
            this.in = inputStream;
        }

        public int read() throws IOException {
            long j = this.max;
            if (j >= 0 && this.pos >= j) {
                return -1;
            }
            int read = this.in.read();
            this.pos++;
            ZipArchiveInputStream.this.count(1);
            CurrentEntry.access$708(ZipArchiveInputStream.this.current);
            return read;
        }

        public int read(byte[] bArr) throws IOException {
            return read(bArr, 0, bArr.length);
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            long j = this.max;
            if (j >= 0 && this.pos >= j) {
                return -1;
            }
            int read = this.in.read(bArr, i, (int) (j >= 0 ? Math.min((long) i2, j - this.pos) : (long) i2));
            if (read == -1) {
                return -1;
            }
            long j2 = (long) read;
            this.pos += j2;
            ZipArchiveInputStream.this.count(read);
            CurrentEntry access$900 = ZipArchiveInputStream.this.current;
            long unused = access$900.bytesReadFromStream = access$900.bytesReadFromStream + j2;
            return read;
        }

        public long skip(long j) throws IOException {
            long j2 = this.max;
            if (j2 >= 0) {
                j = Math.min(j, j2 - this.pos);
            }
            long skip = IOUtils.skip(this.in, j);
            this.pos += skip;
            return skip;
        }

        public int available() throws IOException {
            long j = this.max;
            if (j < 0 || this.pos < j) {
                return this.in.available();
            }
            return 0;
        }
    }
}
