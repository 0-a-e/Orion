package org.apache.commons.compress.archivers.zip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.EntryStreamOffsets;
import org.apache.commons.compress.archivers.zip.ExtraFieldUtils;

public class ZipArchiveEntry extends ZipEntry implements ArchiveEntry, EntryStreamOffsets {
    public static final int CRC_UNKNOWN = -1;
    private static final byte[] EMPTY = new byte[0];
    public static final int PLATFORM_FAT = 0;
    public static final int PLATFORM_UNIX = 3;
    private static final int SHORT_MASK = 65535;
    private static final int SHORT_SHIFT = 16;
    private static final ZipExtraField[] noExtraFields = new ZipExtraField[0];
    private int alignment;
    private CommentSource commentSource;
    private long dataOffset;
    private long externalAttributes;
    private ZipExtraField[] extraFields;
    private GeneralPurposeBit gpb;
    private int internalAttributes;
    private boolean isStreamContiguous;
    private long localHeaderOffset;
    private int method;
    private String name;
    private NameSource nameSource;
    private int platform;
    private int rawFlag;
    private byte[] rawName;
    private long size;
    private UnparseableExtraFieldData unparseableExtra;
    private int versionMadeBy;
    private int versionRequired;

    public enum CommentSource {
        COMMENT,
        UNICODE_EXTRA_FIELD
    }

    public enum NameSource {
        NAME,
        NAME_WITH_EFS_FLAG,
        UNICODE_EXTRA_FIELD
    }

    public ZipArchiveEntry(String str) {
        super(str);
        this.method = -1;
        this.size = -1;
        this.internalAttributes = 0;
        this.platform = 0;
        this.externalAttributes = 0;
        this.alignment = 0;
        this.unparseableExtra = null;
        this.name = null;
        this.rawName = null;
        this.gpb = new GeneralPurposeBit();
        this.localHeaderOffset = -1;
        this.dataOffset = -1;
        this.isStreamContiguous = false;
        this.nameSource = NameSource.NAME;
        this.commentSource = CommentSource.COMMENT;
        setName(str);
    }

    public ZipArchiveEntry(ZipEntry zipEntry) throws ZipException {
        super(zipEntry);
        this.method = -1;
        this.size = -1;
        this.internalAttributes = 0;
        this.platform = 0;
        this.externalAttributes = 0;
        this.alignment = 0;
        this.unparseableExtra = null;
        this.name = null;
        this.rawName = null;
        this.gpb = new GeneralPurposeBit();
        this.localHeaderOffset = -1;
        this.dataOffset = -1;
        this.isStreamContiguous = false;
        this.nameSource = NameSource.NAME;
        this.commentSource = CommentSource.COMMENT;
        setName(zipEntry.getName());
        byte[] extra = zipEntry.getExtra();
        if (extra != null) {
            setExtraFields(ExtraFieldUtils.parse(extra, true, (ExtraFieldParsingBehavior) ExtraFieldParsingMode.BEST_EFFORT));
        } else {
            setExtra();
        }
        setMethod(zipEntry.getMethod());
        this.size = zipEntry.getSize();
    }

    public ZipArchiveEntry(ZipArchiveEntry zipArchiveEntry) throws ZipException {
        this((ZipEntry) zipArchiveEntry);
        GeneralPurposeBit generalPurposeBit;
        setInternalAttributes(zipArchiveEntry.getInternalAttributes());
        setExternalAttributes(zipArchiveEntry.getExternalAttributes());
        setExtraFields(getAllExtraFieldsNoCopy());
        setPlatform(zipArchiveEntry.getPlatform());
        GeneralPurposeBit generalPurposeBit2 = zipArchiveEntry.getGeneralPurposeBit();
        if (generalPurposeBit2 == null) {
            generalPurposeBit = null;
        } else {
            generalPurposeBit = (GeneralPurposeBit) generalPurposeBit2.clone();
        }
        setGeneralPurposeBit(generalPurposeBit);
    }

    protected ZipArchiveEntry() {
        this("");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ZipArchiveEntry(java.io.File r3, java.lang.String r4) {
        /*
            r2 = this;
            boolean r0 = r3.isDirectory()
            if (r0 == 0) goto L_0x001d
            java.lang.String r0 = "/"
            boolean r1 = r4.endsWith(r0)
            if (r1 != 0) goto L_0x001d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            r1.append(r0)
            java.lang.String r4 = r1.toString()
        L_0x001d:
            r2.<init>((java.lang.String) r4)
            boolean r4 = r3.isFile()
            if (r4 == 0) goto L_0x002d
            long r0 = r3.length()
            r2.setSize(r0)
        L_0x002d:
            long r3 = r3.lastModified()
            r2.setTime(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.zip.ZipArchiveEntry.<init>(java.io.File, java.lang.String):void");
    }

    public Object clone() {
        ZipArchiveEntry zipArchiveEntry = (ZipArchiveEntry) super.clone();
        zipArchiveEntry.setInternalAttributes(getInternalAttributes());
        zipArchiveEntry.setExternalAttributes(getExternalAttributes());
        zipArchiveEntry.setExtraFields(getAllExtraFieldsNoCopy());
        return zipArchiveEntry;
    }

    public int getMethod() {
        return this.method;
    }

    public void setMethod(int i) {
        if (i >= 0) {
            this.method = i;
            return;
        }
        throw new IllegalArgumentException("ZIP compression method can not be negative: " + i);
    }

    public int getInternalAttributes() {
        return this.internalAttributes;
    }

    public void setInternalAttributes(int i) {
        this.internalAttributes = i;
    }

    public long getExternalAttributes() {
        return this.externalAttributes;
    }

    public void setExternalAttributes(long j) {
        this.externalAttributes = j;
    }

    public void setUnixMode(int i) {
        int i2 = 0;
        int i3 = ((i & 128) == 0 ? 1 : 0) | (i << 16);
        if (isDirectory()) {
            i2 = 16;
        }
        setExternalAttributes((long) (i3 | i2));
        this.platform = 3;
    }

    public int getUnixMode() {
        if (this.platform != 3) {
            return 0;
        }
        return (int) ((getExternalAttributes() >> 16) & 65535);
    }

    public boolean isUnixSymlink() {
        return (getUnixMode() & 61440) == 40960;
    }

    public int getPlatform() {
        return this.platform;
    }

    /* access modifiers changed from: protected */
    public void setPlatform(int i) {
        this.platform = i;
    }

    /* access modifiers changed from: protected */
    public int getAlignment() {
        return this.alignment;
    }

    public void setAlignment(int i) {
        if (((i - 1) & i) != 0 || i > 65535) {
            throw new IllegalArgumentException("Invalid value for alignment, must be power of two and no bigger than 65535 but is " + i);
        }
        this.alignment = i;
    }

    public void setExtraFields(ZipExtraField[] zipExtraFieldArr) {
        this.unparseableExtra = null;
        ArrayList arrayList = new ArrayList();
        if (zipExtraFieldArr != null) {
            for (UnparseableExtraFieldData unparseableExtraFieldData : zipExtraFieldArr) {
                if (unparseableExtraFieldData instanceof UnparseableExtraFieldData) {
                    this.unparseableExtra = unparseableExtraFieldData;
                } else {
                    arrayList.add(unparseableExtraFieldData);
                }
            }
        }
        this.extraFields = (ZipExtraField[]) arrayList.toArray(noExtraFields);
        setExtra();
    }

    public ZipExtraField[] getExtraFields() {
        return getParseableExtraFields();
    }

    public ZipExtraField[] getExtraFields(boolean z) {
        if (z) {
            return getAllExtraFields();
        }
        return getParseableExtraFields();
    }

    public ZipExtraField[] getExtraFields(ExtraFieldParsingBehavior extraFieldParsingBehavior) throws ZipException {
        ZipExtraField zipExtraField;
        if (extraFieldParsingBehavior == ExtraFieldParsingMode.BEST_EFFORT) {
            return getExtraFields(true);
        }
        if (extraFieldParsingBehavior == ExtraFieldParsingMode.ONLY_PARSEABLE_LENIENT) {
            return getExtraFields(false);
        }
        ArrayList<ZipExtraField> arrayList = new ArrayList<>(Arrays.asList(ExtraFieldUtils.parse(getExtra(), true, extraFieldParsingBehavior)));
        ArrayList arrayList2 = new ArrayList(Arrays.asList(ExtraFieldUtils.parse(getCentralDirectoryExtra(), false, extraFieldParsingBehavior)));
        ArrayList arrayList3 = new ArrayList();
        for (ZipExtraField zipExtraField2 : arrayList) {
            if (zipExtraField2 instanceof UnparseableExtraFieldData) {
                zipExtraField = findUnparseable(arrayList2);
            } else {
                zipExtraField = findMatching(zipExtraField2.getHeaderId(), arrayList2);
            }
            if (zipExtraField != null) {
                byte[] centralDirectoryData = zipExtraField.getCentralDirectoryData();
                if (centralDirectoryData != null && centralDirectoryData.length > 0) {
                    zipExtraField2.parseFromCentralDirectoryData(centralDirectoryData, 0, centralDirectoryData.length);
                }
                arrayList2.remove(zipExtraField);
            }
            arrayList3.add(zipExtraField2);
        }
        arrayList3.addAll(arrayList2);
        return (ZipExtraField[]) arrayList3.toArray(noExtraFields);
    }

    private ZipExtraField[] getParseableExtraFieldsNoCopy() {
        ZipExtraField[] zipExtraFieldArr = this.extraFields;
        return zipExtraFieldArr == null ? noExtraFields : zipExtraFieldArr;
    }

    private ZipExtraField[] getParseableExtraFields() {
        ZipExtraField[] parseableExtraFieldsNoCopy = getParseableExtraFieldsNoCopy();
        return parseableExtraFieldsNoCopy == this.extraFields ? (ZipExtraField[]) Arrays.copyOf(parseableExtraFieldsNoCopy, parseableExtraFieldsNoCopy.length) : parseableExtraFieldsNoCopy;
    }

    private ZipExtraField[] getAllExtraFieldsNoCopy() {
        ZipExtraField[] zipExtraFieldArr = this.extraFields;
        if (zipExtraFieldArr == null) {
            return getUnparseableOnly();
        }
        return this.unparseableExtra != null ? getMergedFields() : zipExtraFieldArr;
    }

    private ZipExtraField[] getMergedFields() {
        ZipExtraField[] zipExtraFieldArr = this.extraFields;
        ZipExtraField[] zipExtraFieldArr2 = (ZipExtraField[]) Arrays.copyOf(zipExtraFieldArr, zipExtraFieldArr.length + 1);
        zipExtraFieldArr2[this.extraFields.length] = this.unparseableExtra;
        return zipExtraFieldArr2;
    }

    private ZipExtraField[] getUnparseableOnly() {
        UnparseableExtraFieldData unparseableExtraFieldData = this.unparseableExtra;
        if (unparseableExtraFieldData == null) {
            return noExtraFields;
        }
        return new ZipExtraField[]{unparseableExtraFieldData};
    }

    private ZipExtraField[] getAllExtraFields() {
        ZipExtraField[] allExtraFieldsNoCopy = getAllExtraFieldsNoCopy();
        return allExtraFieldsNoCopy == this.extraFields ? (ZipExtraField[]) Arrays.copyOf(allExtraFieldsNoCopy, allExtraFieldsNoCopy.length) : allExtraFieldsNoCopy;
    }

    private ZipExtraField findUnparseable(List<ZipExtraField> list) {
        for (ZipExtraField next : list) {
            if (next instanceof UnparseableExtraFieldData) {
                return next;
            }
        }
        return null;
    }

    private ZipExtraField findMatching(ZipShort zipShort, List<ZipExtraField> list) {
        for (ZipExtraField next : list) {
            if (zipShort.equals(next.getHeaderId())) {
                return next;
            }
        }
        return null;
    }

    public void addExtraField(ZipExtraField zipExtraField) {
        if (zipExtraField instanceof UnparseableExtraFieldData) {
            this.unparseableExtra = (UnparseableExtraFieldData) zipExtraField;
        } else if (this.extraFields == null) {
            this.extraFields = new ZipExtraField[]{zipExtraField};
        } else {
            if (getExtraField(zipExtraField.getHeaderId()) != null) {
                removeExtraField(zipExtraField.getHeaderId());
            }
            ZipExtraField[] zipExtraFieldArr = this.extraFields;
            ZipExtraField[] zipExtraFieldArr2 = (ZipExtraField[]) Arrays.copyOf(zipExtraFieldArr, zipExtraFieldArr.length + 1);
            zipExtraFieldArr2[zipExtraFieldArr2.length - 1] = zipExtraField;
            this.extraFields = zipExtraFieldArr2;
        }
        setExtra();
    }

    public void addAsFirstExtraField(ZipExtraField zipExtraField) {
        if (zipExtraField instanceof UnparseableExtraFieldData) {
            this.unparseableExtra = (UnparseableExtraFieldData) zipExtraField;
        } else {
            if (getExtraField(zipExtraField.getHeaderId()) != null) {
                removeExtraField(zipExtraField.getHeaderId());
            }
            ZipExtraField[] zipExtraFieldArr = this.extraFields;
            ZipExtraField[] zipExtraFieldArr2 = new ZipExtraField[(zipExtraFieldArr != null ? zipExtraFieldArr.length + 1 : 1)];
            this.extraFields = zipExtraFieldArr2;
            zipExtraFieldArr2[0] = zipExtraField;
            if (zipExtraFieldArr != null) {
                System.arraycopy(zipExtraFieldArr, 0, zipExtraFieldArr2, 1, zipExtraFieldArr2.length - 1);
            }
        }
        setExtra();
    }

    public void removeExtraField(ZipShort zipShort) {
        if (this.extraFields != null) {
            ArrayList arrayList = new ArrayList();
            for (ZipExtraField zipExtraField : this.extraFields) {
                if (!zipShort.equals(zipExtraField.getHeaderId())) {
                    arrayList.add(zipExtraField);
                }
            }
            if (this.extraFields.length != arrayList.size()) {
                this.extraFields = (ZipExtraField[]) arrayList.toArray(noExtraFields);
                setExtra();
                return;
            }
            throw new NoSuchElementException();
        }
        throw new NoSuchElementException();
    }

    public void removeUnparseableExtraFieldData() {
        if (this.unparseableExtra != null) {
            this.unparseableExtra = null;
            setExtra();
            return;
        }
        throw new NoSuchElementException();
    }

    public ZipExtraField getExtraField(ZipShort zipShort) {
        ZipExtraField[] zipExtraFieldArr = this.extraFields;
        if (zipExtraFieldArr == null) {
            return null;
        }
        for (ZipExtraField zipExtraField : zipExtraFieldArr) {
            if (zipShort.equals(zipExtraField.getHeaderId())) {
                return zipExtraField;
            }
        }
        return null;
    }

    public UnparseableExtraFieldData getUnparseableExtraFieldData() {
        return this.unparseableExtra;
    }

    public void setExtra(byte[] bArr) throws RuntimeException {
        try {
            mergeExtraFields(ExtraFieldUtils.parse(bArr, true, (ExtraFieldParsingBehavior) ExtraFieldParsingMode.BEST_EFFORT), true);
        } catch (ZipException e) {
            throw new RuntimeException("Error parsing extra fields for entry: " + getName() + " - " + e.getMessage(), e);
        }
    }

    /* access modifiers changed from: protected */
    public void setExtra() {
        super.setExtra(ExtraFieldUtils.mergeLocalFileDataData(getAllExtraFieldsNoCopy()));
    }

    public void setCentralDirectoryExtra(byte[] bArr) {
        try {
            mergeExtraFields(ExtraFieldUtils.parse(bArr, false, (ExtraFieldParsingBehavior) ExtraFieldParsingMode.BEST_EFFORT), false);
        } catch (ZipException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public byte[] getLocalFileDataExtra() {
        byte[] extra = getExtra();
        return extra != null ? extra : EMPTY;
    }

    public byte[] getCentralDirectoryExtra() {
        return ExtraFieldUtils.mergeCentralDirectoryData(getAllExtraFieldsNoCopy());
    }

    public String getName() {
        String str = this.name;
        return str == null ? super.getName() : str;
    }

    public boolean isDirectory() {
        String name2 = getName();
        return name2 != null && name2.endsWith("/");
    }

    /* access modifiers changed from: protected */
    public void setName(String str) {
        if (str != null && getPlatform() == 0 && !str.contains("/")) {
            str = str.replace('\\', '/');
        }
        this.name = str;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long j) {
        if (j >= 0) {
            this.size = j;
            return;
        }
        throw new IllegalArgumentException("Invalid entry size");
    }

    /* access modifiers changed from: protected */
    public void setName(String str, byte[] bArr) {
        setName(str);
        this.rawName = bArr;
    }

    public byte[] getRawName() {
        byte[] bArr = this.rawName;
        if (bArr != null) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public long getLocalHeaderOffset() {
        return this.localHeaderOffset;
    }

    /* access modifiers changed from: protected */
    public void setLocalHeaderOffset(long j) {
        this.localHeaderOffset = j;
    }

    public long getDataOffset() {
        return this.dataOffset;
    }

    /* access modifiers changed from: protected */
    public void setDataOffset(long j) {
        this.dataOffset = j;
    }

    public boolean isStreamContiguous() {
        return this.isStreamContiguous;
    }

    /* access modifiers changed from: protected */
    public void setStreamContiguous(boolean z) {
        this.isStreamContiguous = z;
    }

    public int hashCode() {
        String name2 = getName();
        if (name2 == null) {
            name2 = "";
        }
        return name2.hashCode();
    }

    public GeneralPurposeBit getGeneralPurposeBit() {
        return this.gpb;
    }

    public void setGeneralPurposeBit(GeneralPurposeBit generalPurposeBit) {
        this.gpb = generalPurposeBit;
    }

    private void mergeExtraFields(ZipExtraField[] zipExtraFieldArr, boolean z) {
        ZipExtraField zipExtraField;
        byte[] bArr;
        if (this.extraFields == null) {
            setExtraFields(zipExtraFieldArr);
            return;
        }
        for (ZipExtraField zipExtraField2 : zipExtraFieldArr) {
            if (zipExtraField2 instanceof UnparseableExtraFieldData) {
                zipExtraField = this.unparseableExtra;
            } else {
                zipExtraField = getExtraField(zipExtraField2.getHeaderId());
            }
            if (zipExtraField == null) {
                addExtraField(zipExtraField2);
            } else {
                if (z) {
                    bArr = zipExtraField2.getLocalFileDataData();
                } else {
                    bArr = zipExtraField2.getCentralDirectoryData();
                }
                if (z) {
                    try {
                        zipExtraField.parseFromLocalFileData(bArr, 0, bArr.length);
                    } catch (ZipException unused) {
                        UnrecognizedExtraField unrecognizedExtraField = new UnrecognizedExtraField();
                        unrecognizedExtraField.setHeaderId(zipExtraField.getHeaderId());
                        if (z) {
                            unrecognizedExtraField.setLocalFileDataData(bArr);
                            unrecognizedExtraField.setCentralDirectoryData(zipExtraField.getCentralDirectoryData());
                        } else {
                            unrecognizedExtraField.setLocalFileDataData(zipExtraField.getLocalFileDataData());
                            unrecognizedExtraField.setCentralDirectoryData(bArr);
                        }
                        removeExtraField(zipExtraField.getHeaderId());
                        addExtraField(unrecognizedExtraField);
                    }
                } else {
                    zipExtraField.parseFromCentralDirectoryData(bArr, 0, bArr.length);
                }
            }
        }
        setExtra();
    }

    public Date getLastModifiedDate() {
        return new Date(getTime());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ZipArchiveEntry zipArchiveEntry = (ZipArchiveEntry) obj;
        String name2 = getName();
        String name3 = zipArchiveEntry.getName();
        if (name2 == null) {
            if (name3 != null) {
                return false;
            }
        } else if (!name2.equals(name3)) {
            return false;
        }
        String comment = getComment();
        String comment2 = zipArchiveEntry.getComment();
        if (comment == null) {
            comment = "";
        }
        if (comment2 == null) {
            comment2 = "";
        }
        if (getTime() == zipArchiveEntry.getTime() && comment.equals(comment2) && getInternalAttributes() == zipArchiveEntry.getInternalAttributes() && getPlatform() == zipArchiveEntry.getPlatform() && getExternalAttributes() == zipArchiveEntry.getExternalAttributes() && getMethod() == zipArchiveEntry.getMethod() && getSize() == zipArchiveEntry.getSize() && getCrc() == zipArchiveEntry.getCrc() && getCompressedSize() == zipArchiveEntry.getCompressedSize() && Arrays.equals(getCentralDirectoryExtra(), zipArchiveEntry.getCentralDirectoryExtra()) && Arrays.equals(getLocalFileDataExtra(), zipArchiveEntry.getLocalFileDataExtra()) && this.localHeaderOffset == zipArchiveEntry.localHeaderOffset && this.dataOffset == zipArchiveEntry.dataOffset && this.gpb.equals(zipArchiveEntry.gpb)) {
            return true;
        }
        return false;
    }

    public void setVersionMadeBy(int i) {
        this.versionMadeBy = i;
    }

    public void setVersionRequired(int i) {
        this.versionRequired = i;
    }

    public int getVersionRequired() {
        return this.versionRequired;
    }

    public int getVersionMadeBy() {
        return this.versionMadeBy;
    }

    public int getRawFlag() {
        return this.rawFlag;
    }

    public void setRawFlag(int i) {
        this.rawFlag = i;
    }

    public NameSource getNameSource() {
        return this.nameSource;
    }

    public void setNameSource(NameSource nameSource2) {
        this.nameSource = nameSource2;
    }

    public CommentSource getCommentSource() {
        return this.commentSource;
    }

    public void setCommentSource(CommentSource commentSource2) {
        this.commentSource = commentSource2;
    }

    public enum ExtraFieldParsingMode implements ExtraFieldParsingBehavior {
        BEST_EFFORT(ExtraFieldUtils.UnparseableExtraField.READ) {
            public ZipExtraField fill(ZipExtraField zipExtraField, byte[] bArr, int i, int i2, boolean z) {
                return ExtraFieldParsingMode.fillAndMakeUnrecognizedOnError(zipExtraField, bArr, i, i2, z);
            }
        },
        STRICT_FOR_KNOW_EXTRA_FIELDS(ExtraFieldUtils.UnparseableExtraField.READ),
        ONLY_PARSEABLE_LENIENT(ExtraFieldUtils.UnparseableExtraField.SKIP) {
            public ZipExtraField fill(ZipExtraField zipExtraField, byte[] bArr, int i, int i2, boolean z) {
                return ExtraFieldParsingMode.fillAndMakeUnrecognizedOnError(zipExtraField, bArr, i, i2, z);
            }
        },
        ONLY_PARSEABLE_STRICT(ExtraFieldUtils.UnparseableExtraField.SKIP),
        DRACONIC(ExtraFieldUtils.UnparseableExtraField.THROW);
        
        private final ExtraFieldUtils.UnparseableExtraField onUnparseableData;

        private ExtraFieldParsingMode(ExtraFieldUtils.UnparseableExtraField unparseableExtraField) {
            this.onUnparseableData = unparseableExtraField;
        }

        public ZipExtraField onUnparseableExtraField(byte[] bArr, int i, int i2, boolean z, int i3) throws ZipException {
            return this.onUnparseableData.onUnparseableExtraField(bArr, i, i2, z, i3);
        }

        public ZipExtraField createExtraField(ZipShort zipShort) throws ZipException, InstantiationException, IllegalAccessException {
            return ExtraFieldUtils.createExtraField(zipShort);
        }

        public ZipExtraField fill(ZipExtraField zipExtraField, byte[] bArr, int i, int i2, boolean z) throws ZipException {
            return ExtraFieldUtils.fillExtraField(zipExtraField, bArr, i, i2, z);
        }

        /* access modifiers changed from: private */
        public static ZipExtraField fillAndMakeUnrecognizedOnError(ZipExtraField zipExtraField, byte[] bArr, int i, int i2, boolean z) {
            try {
                return ExtraFieldUtils.fillExtraField(zipExtraField, bArr, i, i2, z);
            } catch (ZipException unused) {
                UnrecognizedExtraField unrecognizedExtraField = new UnrecognizedExtraField();
                unrecognizedExtraField.setHeaderId(zipExtraField.getHeaderId());
                if (z) {
                    unrecognizedExtraField.setLocalFileDataData(Arrays.copyOfRange(bArr, i, i2 + i));
                } else {
                    unrecognizedExtraField.setCentralDirectoryData(Arrays.copyOfRange(bArr, i, i2 + i));
                }
                return unrecognizedExtraField;
            }
        }
    }
}
