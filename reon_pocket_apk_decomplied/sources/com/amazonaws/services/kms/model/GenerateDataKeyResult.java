package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.nio.ByteBuffer;

public class GenerateDataKeyResult implements Serializable {
    private ByteBuffer ciphertextBlob;
    private ByteBuffer ciphertextForRecipient;
    private String keyId;
    private ByteBuffer plaintext;

    public ByteBuffer getCiphertextBlob() {
        return this.ciphertextBlob;
    }

    public void setCiphertextBlob(ByteBuffer byteBuffer) {
        this.ciphertextBlob = byteBuffer;
    }

    public GenerateDataKeyResult withCiphertextBlob(ByteBuffer byteBuffer) {
        this.ciphertextBlob = byteBuffer;
        return this;
    }

    public ByteBuffer getPlaintext() {
        return this.plaintext;
    }

    public void setPlaintext(ByteBuffer byteBuffer) {
        this.plaintext = byteBuffer;
    }

    public GenerateDataKeyResult withPlaintext(ByteBuffer byteBuffer) {
        this.plaintext = byteBuffer;
        return this;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public GenerateDataKeyResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public ByteBuffer getCiphertextForRecipient() {
        return this.ciphertextForRecipient;
    }

    public void setCiphertextForRecipient(ByteBuffer byteBuffer) {
        this.ciphertextForRecipient = byteBuffer;
    }

    public GenerateDataKeyResult withCiphertextForRecipient(ByteBuffer byteBuffer) {
        this.ciphertextForRecipient = byteBuffer;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getCiphertextBlob() != null) {
            sb.append("CiphertextBlob: " + getCiphertextBlob() + ",");
        }
        if (getPlaintext() != null) {
            sb.append("Plaintext: " + getPlaintext() + ",");
        }
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getCiphertextForRecipient() != null) {
            sb.append("CiphertextForRecipient: " + getCiphertextForRecipient());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((getCiphertextBlob() == null ? 0 : getCiphertextBlob().hashCode()) + 31) * 31) + (getPlaintext() == null ? 0 : getPlaintext().hashCode())) * 31) + (getKeyId() == null ? 0 : getKeyId().hashCode())) * 31;
        if (getCiphertextForRecipient() != null) {
            i = getCiphertextForRecipient().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GenerateDataKeyResult)) {
            return false;
        }
        GenerateDataKeyResult generateDataKeyResult = (GenerateDataKeyResult) obj;
        if ((generateDataKeyResult.getCiphertextBlob() == null) ^ (getCiphertextBlob() == null)) {
            return false;
        }
        if (generateDataKeyResult.getCiphertextBlob() != null && !generateDataKeyResult.getCiphertextBlob().equals(getCiphertextBlob())) {
            return false;
        }
        if ((generateDataKeyResult.getPlaintext() == null) ^ (getPlaintext() == null)) {
            return false;
        }
        if (generateDataKeyResult.getPlaintext() != null && !generateDataKeyResult.getPlaintext().equals(getPlaintext())) {
            return false;
        }
        if ((generateDataKeyResult.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (generateDataKeyResult.getKeyId() != null && !generateDataKeyResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((generateDataKeyResult.getCiphertextForRecipient() == null) ^ (getCiphertextForRecipient() == null)) {
            return false;
        }
        return generateDataKeyResult.getCiphertextForRecipient() == null || generateDataKeyResult.getCiphertextForRecipient().equals(getCiphertextForRecipient());
    }
}
