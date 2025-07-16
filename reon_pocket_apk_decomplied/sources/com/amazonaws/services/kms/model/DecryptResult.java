package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.nio.ByteBuffer;

public class DecryptResult implements Serializable {
    private ByteBuffer ciphertextForRecipient;
    private String encryptionAlgorithm;
    private String keyId;
    private ByteBuffer plaintext;

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public DecryptResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public ByteBuffer getPlaintext() {
        return this.plaintext;
    }

    public void setPlaintext(ByteBuffer byteBuffer) {
        this.plaintext = byteBuffer;
    }

    public DecryptResult withPlaintext(ByteBuffer byteBuffer) {
        this.plaintext = byteBuffer;
        return this;
    }

    public String getEncryptionAlgorithm() {
        return this.encryptionAlgorithm;
    }

    public void setEncryptionAlgorithm(String str) {
        this.encryptionAlgorithm = str;
    }

    public DecryptResult withEncryptionAlgorithm(String str) {
        this.encryptionAlgorithm = str;
        return this;
    }

    public void setEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.encryptionAlgorithm = encryptionAlgorithmSpec.toString();
    }

    public DecryptResult withEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.encryptionAlgorithm = encryptionAlgorithmSpec.toString();
        return this;
    }

    public ByteBuffer getCiphertextForRecipient() {
        return this.ciphertextForRecipient;
    }

    public void setCiphertextForRecipient(ByteBuffer byteBuffer) {
        this.ciphertextForRecipient = byteBuffer;
    }

    public DecryptResult withCiphertextForRecipient(ByteBuffer byteBuffer) {
        this.ciphertextForRecipient = byteBuffer;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getPlaintext() != null) {
            sb.append("Plaintext: " + getPlaintext() + ",");
        }
        if (getEncryptionAlgorithm() != null) {
            sb.append("EncryptionAlgorithm: " + getEncryptionAlgorithm() + ",");
        }
        if (getCiphertextForRecipient() != null) {
            sb.append("CiphertextForRecipient: " + getCiphertextForRecipient());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31) + (getPlaintext() == null ? 0 : getPlaintext().hashCode())) * 31) + (getEncryptionAlgorithm() == null ? 0 : getEncryptionAlgorithm().hashCode())) * 31;
        if (getCiphertextForRecipient() != null) {
            i = getCiphertextForRecipient().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DecryptResult)) {
            return false;
        }
        DecryptResult decryptResult = (DecryptResult) obj;
        if ((decryptResult.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (decryptResult.getKeyId() != null && !decryptResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((decryptResult.getPlaintext() == null) ^ (getPlaintext() == null)) {
            return false;
        }
        if (decryptResult.getPlaintext() != null && !decryptResult.getPlaintext().equals(getPlaintext())) {
            return false;
        }
        if ((decryptResult.getEncryptionAlgorithm() == null) ^ (getEncryptionAlgorithm() == null)) {
            return false;
        }
        if (decryptResult.getEncryptionAlgorithm() != null && !decryptResult.getEncryptionAlgorithm().equals(getEncryptionAlgorithm())) {
            return false;
        }
        if ((decryptResult.getCiphertextForRecipient() == null) ^ (getCiphertextForRecipient() == null)) {
            return false;
        }
        return decryptResult.getCiphertextForRecipient() == null || decryptResult.getCiphertextForRecipient().equals(getCiphertextForRecipient());
    }
}
