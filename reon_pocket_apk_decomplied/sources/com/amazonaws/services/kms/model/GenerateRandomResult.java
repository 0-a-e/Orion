package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.nio.ByteBuffer;

public class GenerateRandomResult implements Serializable {
    private ByteBuffer ciphertextForRecipient;
    private ByteBuffer plaintext;

    public ByteBuffer getPlaintext() {
        return this.plaintext;
    }

    public void setPlaintext(ByteBuffer byteBuffer) {
        this.plaintext = byteBuffer;
    }

    public GenerateRandomResult withPlaintext(ByteBuffer byteBuffer) {
        this.plaintext = byteBuffer;
        return this;
    }

    public ByteBuffer getCiphertextForRecipient() {
        return this.ciphertextForRecipient;
    }

    public void setCiphertextForRecipient(ByteBuffer byteBuffer) {
        this.ciphertextForRecipient = byteBuffer;
    }

    public GenerateRandomResult withCiphertextForRecipient(ByteBuffer byteBuffer) {
        this.ciphertextForRecipient = byteBuffer;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getPlaintext() != null) {
            sb.append("Plaintext: " + getPlaintext() + ",");
        }
        if (getCiphertextForRecipient() != null) {
            sb.append("CiphertextForRecipient: " + getCiphertextForRecipient());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getPlaintext() == null ? 0 : getPlaintext().hashCode()) + 31) * 31;
        if (getCiphertextForRecipient() != null) {
            i = getCiphertextForRecipient().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GenerateRandomResult)) {
            return false;
        }
        GenerateRandomResult generateRandomResult = (GenerateRandomResult) obj;
        if ((generateRandomResult.getPlaintext() == null) ^ (getPlaintext() == null)) {
            return false;
        }
        if (generateRandomResult.getPlaintext() != null && !generateRandomResult.getPlaintext().equals(getPlaintext())) {
            return false;
        }
        if ((generateRandomResult.getCiphertextForRecipient() == null) ^ (getCiphertextForRecipient() == null)) {
            return false;
        }
        return generateRandomResult.getCiphertextForRecipient() == null || generateRandomResult.getCiphertextForRecipient().equals(getCiphertextForRecipient());
    }
}
