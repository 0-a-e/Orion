package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.nio.ByteBuffer;

public class GenerateDataKeyWithoutPlaintextResult implements Serializable {
    private ByteBuffer ciphertextBlob;
    private String keyId;

    public ByteBuffer getCiphertextBlob() {
        return this.ciphertextBlob;
    }

    public void setCiphertextBlob(ByteBuffer byteBuffer) {
        this.ciphertextBlob = byteBuffer;
    }

    public GenerateDataKeyWithoutPlaintextResult withCiphertextBlob(ByteBuffer byteBuffer) {
        this.ciphertextBlob = byteBuffer;
        return this;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public GenerateDataKeyWithoutPlaintextResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getCiphertextBlob() != null) {
            sb.append("CiphertextBlob: " + getCiphertextBlob() + ",");
        }
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getCiphertextBlob() == null ? 0 : getCiphertextBlob().hashCode()) + 31) * 31;
        if (getKeyId() != null) {
            i = getKeyId().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GenerateDataKeyWithoutPlaintextResult)) {
            return false;
        }
        GenerateDataKeyWithoutPlaintextResult generateDataKeyWithoutPlaintextResult = (GenerateDataKeyWithoutPlaintextResult) obj;
        if ((generateDataKeyWithoutPlaintextResult.getCiphertextBlob() == null) ^ (getCiphertextBlob() == null)) {
            return false;
        }
        if (generateDataKeyWithoutPlaintextResult.getCiphertextBlob() != null && !generateDataKeyWithoutPlaintextResult.getCiphertextBlob().equals(getCiphertextBlob())) {
            return false;
        }
        if ((generateDataKeyWithoutPlaintextResult.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        return generateDataKeyWithoutPlaintextResult.getKeyId() == null || generateDataKeyWithoutPlaintextResult.getKeyId().equals(getKeyId());
    }
}
