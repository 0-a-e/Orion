package org.apache.commons.compress.archivers.zip;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipException;

public class ExtraFieldUtils {
    private static final int WORD = 4;
    private static final Map<ZipShort, Class<?>> implementations = new ConcurrentHashMap();

    static {
        register(AsiExtraField.class);
        register(X5455_ExtendedTimestamp.class);
        register(X7875_NewUnix.class);
        register(JarMarker.class);
        register(UnicodePathExtraField.class);
        register(UnicodeCommentExtraField.class);
        register(Zip64ExtendedInformationExtraField.class);
        register(X000A_NTFS.class);
        register(X0014_X509Certificates.class);
        register(X0015_CertificateIdForFile.class);
        register(X0016_CertificateIdForCentralDirectory.class);
        register(X0017_StrongEncryptionHeader.class);
        register(X0019_EncryptionRecipientCertificateList.class);
        register(ResourceAlignmentExtraField.class);
    }

    public static void register(Class<?> cls) {
        try {
            implementations.put(((ZipExtraField) cls.newInstance()).getHeaderId(), cls);
        } catch (ClassCastException unused) {
            throw new RuntimeException(cls + " doesn't implement ZipExtraField");
        } catch (InstantiationException unused2) {
            throw new RuntimeException(cls + " is not a concrete class");
        } catch (IllegalAccessException unused3) {
            throw new RuntimeException(cls + "'s no-arg constructor is not public");
        }
    }

    public static ZipExtraField createExtraField(ZipShort zipShort) throws InstantiationException, IllegalAccessException {
        ZipExtraField createExtraFieldNoDefault = createExtraFieldNoDefault(zipShort);
        if (createExtraFieldNoDefault != null) {
            return createExtraFieldNoDefault;
        }
        UnrecognizedExtraField unrecognizedExtraField = new UnrecognizedExtraField();
        unrecognizedExtraField.setHeaderId(zipShort);
        return unrecognizedExtraField;
    }

    public static ZipExtraField createExtraFieldNoDefault(ZipShort zipShort) throws InstantiationException, IllegalAccessException {
        Class cls = implementations.get(zipShort);
        if (cls != null) {
            return (ZipExtraField) cls.newInstance();
        }
        return null;
    }

    public static ZipExtraField[] parse(byte[] bArr) throws ZipException {
        return parse(bArr, true, UnparseableExtraField.THROW);
    }

    public static ZipExtraField[] parse(byte[] bArr, boolean z) throws ZipException {
        return parse(bArr, z, UnparseableExtraField.THROW);
    }

    public static ZipExtraField[] parse(byte[] bArr, boolean z, final UnparseableExtraField unparseableExtraField) throws ZipException {
        return parse(bArr, z, (ExtraFieldParsingBehavior) new ExtraFieldParsingBehavior() {
            public ZipExtraField onUnparseableExtraField(byte[] bArr, int i, int i2, boolean z, int i3) throws ZipException {
                return unparseableExtraField.onUnparseableExtraField(bArr, i, i2, z, i3);
            }

            public ZipExtraField createExtraField(ZipShort zipShort) throws ZipException, InstantiationException, IllegalAccessException {
                return ExtraFieldUtils.createExtraField(zipShort);
            }

            public ZipExtraField fill(ZipExtraField zipExtraField, byte[] bArr, int i, int i2, boolean z) throws ZipException {
                return ExtraFieldUtils.fillExtraField(zipExtraField, bArr, i, i2, z);
            }
        });
    }

    public static ZipExtraField[] parse(byte[] bArr, boolean z, ExtraFieldParsingBehavior extraFieldParsingBehavior) throws ZipException {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            if (i > bArr.length - 4) {
                break;
            }
            ZipShort zipShort = new ZipShort(bArr, i);
            int value = new ZipShort(bArr, i + 2).getValue();
            int i2 = i + 4;
            if (i2 + value > bArr.length) {
                ZipExtraField onUnparseableExtraField = extraFieldParsingBehavior.onUnparseableExtraField(bArr, i, bArr.length - i, z, value);
                if (onUnparseableExtraField != null) {
                    arrayList.add(onUnparseableExtraField);
                }
            } else {
                try {
                    arrayList.add(Objects.requireNonNull(extraFieldParsingBehavior.fill((ZipExtraField) Objects.requireNonNull(extraFieldParsingBehavior.createExtraField(zipShort), "createExtraField must not return null"), bArr, i2, value, z), "fill must not return null"));
                    i += value + 4;
                } catch (IllegalAccessException | InstantiationException e) {
                    throw ((ZipException) new ZipException(e.getMessage()).initCause(e));
                }
            }
        }
        return (ZipExtraField[]) arrayList.toArray(new ZipExtraField[arrayList.size()]);
    }

    public static byte[] mergeLocalFileDataData(ZipExtraField[] zipExtraFieldArr) {
        byte[] localFileDataData;
        boolean z = zipExtraFieldArr.length > 0 && (zipExtraFieldArr[zipExtraFieldArr.length - 1] instanceof UnparseableExtraFieldData);
        int length = zipExtraFieldArr.length;
        if (z) {
            length--;
        }
        int i = length * 4;
        for (ZipExtraField localFileDataLength : zipExtraFieldArr) {
            i += localFileDataLength.getLocalFileDataLength().getValue();
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            System.arraycopy(zipExtraFieldArr[i3].getHeaderId().getBytes(), 0, bArr, i2, 2);
            System.arraycopy(zipExtraFieldArr[i3].getLocalFileDataLength().getBytes(), 0, bArr, i2 + 2, 2);
            i2 += 4;
            byte[] localFileDataData2 = zipExtraFieldArr[i3].getLocalFileDataData();
            if (localFileDataData2 != null) {
                System.arraycopy(localFileDataData2, 0, bArr, i2, localFileDataData2.length);
                i2 += localFileDataData2.length;
            }
        }
        if (z && (localFileDataData = zipExtraFieldArr[zipExtraFieldArr.length - 1].getLocalFileDataData()) != null) {
            System.arraycopy(localFileDataData, 0, bArr, i2, localFileDataData.length);
        }
        return bArr;
    }

    public static byte[] mergeCentralDirectoryData(ZipExtraField[] zipExtraFieldArr) {
        byte[] centralDirectoryData;
        boolean z = zipExtraFieldArr.length > 0 && (zipExtraFieldArr[zipExtraFieldArr.length - 1] instanceof UnparseableExtraFieldData);
        int length = zipExtraFieldArr.length;
        if (z) {
            length--;
        }
        int i = length * 4;
        for (ZipExtraField centralDirectoryLength : zipExtraFieldArr) {
            i += centralDirectoryLength.getCentralDirectoryLength().getValue();
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            System.arraycopy(zipExtraFieldArr[i3].getHeaderId().getBytes(), 0, bArr, i2, 2);
            System.arraycopy(zipExtraFieldArr[i3].getCentralDirectoryLength().getBytes(), 0, bArr, i2 + 2, 2);
            i2 += 4;
            byte[] centralDirectoryData2 = zipExtraFieldArr[i3].getCentralDirectoryData();
            if (centralDirectoryData2 != null) {
                System.arraycopy(centralDirectoryData2, 0, bArr, i2, centralDirectoryData2.length);
                i2 += centralDirectoryData2.length;
            }
        }
        if (z && (centralDirectoryData = zipExtraFieldArr[zipExtraFieldArr.length - 1].getCentralDirectoryData()) != null) {
            System.arraycopy(centralDirectoryData, 0, bArr, i2, centralDirectoryData.length);
        }
        return bArr;
    }

    public static ZipExtraField fillExtraField(ZipExtraField zipExtraField, byte[] bArr, int i, int i2, boolean z) throws ZipException {
        if (z) {
            try {
                zipExtraField.parseFromLocalFileData(bArr, i, i2);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw ((ZipException) new ZipException("Failed to parse corrupt ZIP extra field of type " + Integer.toHexString(zipExtraField.getHeaderId().getValue())).initCause(e));
            }
        } else {
            zipExtraField.parseFromCentralDirectoryData(bArr, i, i2);
        }
        return zipExtraField;
    }

    public static final class UnparseableExtraField implements UnparseableExtraFieldBehavior {
        public static final UnparseableExtraField READ = new UnparseableExtraField(2);
        public static final int READ_KEY = 2;
        public static final UnparseableExtraField SKIP = new UnparseableExtraField(1);
        public static final int SKIP_KEY = 1;
        public static final UnparseableExtraField THROW = new UnparseableExtraField(0);
        public static final int THROW_KEY = 0;
        private final int key;

        private UnparseableExtraField(int i) {
            this.key = i;
        }

        public int getKey() {
            return this.key;
        }

        public ZipExtraField onUnparseableExtraField(byte[] bArr, int i, int i2, boolean z, int i3) throws ZipException {
            int i4 = this.key;
            if (i4 == 0) {
                StringBuilder sb = new StringBuilder("Bad extra field starting at ");
                sb.append(i);
                sb.append(".  Block length of ");
                sb.append(i3);
                sb.append(" bytes exceeds remaining data of ");
                sb.append(i2 - 4);
                sb.append(" bytes.");
                throw new ZipException(sb.toString());
            } else if (i4 == 1) {
                return null;
            } else {
                if (i4 == 2) {
                    UnparseableExtraFieldData unparseableExtraFieldData = new UnparseableExtraFieldData();
                    if (z) {
                        unparseableExtraFieldData.parseFromLocalFileData(bArr, i, i2);
                    } else {
                        unparseableExtraFieldData.parseFromCentralDirectoryData(bArr, i, i2);
                    }
                    return unparseableExtraFieldData;
                }
                throw new ZipException("Unknown UnparseableExtraField key: " + this.key);
            }
        }
    }
}
