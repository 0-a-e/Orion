package org.apache.commons.compress.archivers.zip;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipException;

public abstract class PKWareExtraHeader implements ZipExtraField {
    private byte[] centralData;
    private final ZipShort headerId;
    private byte[] localData;

    protected PKWareExtraHeader(ZipShort zipShort) {
        this.headerId = zipShort;
    }

    public ZipShort getHeaderId() {
        return this.headerId;
    }

    public void setLocalFileDataData(byte[] bArr) {
        this.localData = ZipUtil.copy(bArr);
    }

    public ZipShort getLocalFileDataLength() {
        byte[] bArr = this.localData;
        return new ZipShort(bArr != null ? bArr.length : 0);
    }

    public byte[] getLocalFileDataData() {
        return ZipUtil.copy(this.localData);
    }

    public void setCentralDirectoryData(byte[] bArr) {
        this.centralData = ZipUtil.copy(bArr);
    }

    public ZipShort getCentralDirectoryLength() {
        if (this.centralData != null) {
            return new ZipShort(this.centralData.length);
        }
        return getLocalFileDataLength();
    }

    public byte[] getCentralDirectoryData() {
        byte[] bArr = this.centralData;
        if (bArr != null) {
            return ZipUtil.copy(bArr);
        }
        return getLocalFileDataData();
    }

    public void parseFromLocalFileData(byte[] bArr, int i, int i2) throws ZipException {
        setLocalFileDataData(Arrays.copyOfRange(bArr, i, i2 + i));
    }

    public void parseFromCentralDirectoryData(byte[] bArr, int i, int i2) throws ZipException {
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i2 + i);
        setCentralDirectoryData(copyOfRange);
        if (this.localData == null) {
            setLocalFileDataData(copyOfRange);
        }
    }

    /* access modifiers changed from: protected */
    public final void assertMinimalLength(int i, int i2) throws ZipException {
        if (i2 < i) {
            throw new ZipException(getClass().getName() + " is too short, only " + i2 + " bytes, expected at least " + i);
        }
    }

    public enum EncryptionAlgorithm {
        DES(26113),
        RC2pre52(26114),
        TripleDES168(26115),
        TripleDES192(26121),
        AES128(26126),
        AES192(26127),
        AES256(26128),
        RC2(26370),
        RC4(26625),
        UNKNOWN(65535);
        
        private static final Map<Integer, EncryptionAlgorithm> codeToEnum = null;
        private final int code;

        static {
            int i;
            HashMap hashMap = new HashMap();
            for (EncryptionAlgorithm encryptionAlgorithm : values()) {
                hashMap.put(Integer.valueOf(encryptionAlgorithm.getCode()), encryptionAlgorithm);
            }
            codeToEnum = Collections.unmodifiableMap(hashMap);
        }

        private EncryptionAlgorithm(int i) {
            this.code = i;
        }

        public int getCode() {
            return this.code;
        }

        public static EncryptionAlgorithm getAlgorithmByCode(int i) {
            return codeToEnum.get(Integer.valueOf(i));
        }
    }

    public enum HashAlgorithm {
        NONE(0),
        CRC32(1),
        MD5(32771),
        SHA1(32772),
        RIPEND160(32775),
        SHA256(32780),
        SHA384(32781),
        SHA512(32782);
        
        private static final Map<Integer, HashAlgorithm> codeToEnum = null;
        private final int code;

        static {
            int i;
            HashMap hashMap = new HashMap();
            for (HashAlgorithm hashAlgorithm : values()) {
                hashMap.put(Integer.valueOf(hashAlgorithm.getCode()), hashAlgorithm);
            }
            codeToEnum = Collections.unmodifiableMap(hashMap);
        }

        private HashAlgorithm(int i) {
            this.code = i;
        }

        public int getCode() {
            return this.code;
        }

        public static HashAlgorithm getAlgorithmByCode(int i) {
            return codeToEnum.get(Integer.valueOf(i));
        }
    }
}
