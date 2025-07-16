package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.nio.ByteBuffer;

public class RecipientInfo implements Serializable {
    private ByteBuffer attestationDocument;
    private String keyEncryptionAlgorithm;

    public String getKeyEncryptionAlgorithm() {
        return this.keyEncryptionAlgorithm;
    }

    public void setKeyEncryptionAlgorithm(String str) {
        this.keyEncryptionAlgorithm = str;
    }

    public RecipientInfo withKeyEncryptionAlgorithm(String str) {
        this.keyEncryptionAlgorithm = str;
        return this;
    }

    public void setKeyEncryptionAlgorithm(KeyEncryptionMechanism keyEncryptionMechanism) {
        this.keyEncryptionAlgorithm = keyEncryptionMechanism.toString();
    }

    public RecipientInfo withKeyEncryptionAlgorithm(KeyEncryptionMechanism keyEncryptionMechanism) {
        this.keyEncryptionAlgorithm = keyEncryptionMechanism.toString();
        return this;
    }

    public ByteBuffer getAttestationDocument() {
        return this.attestationDocument;
    }

    public void setAttestationDocument(ByteBuffer byteBuffer) {
        this.attestationDocument = byteBuffer;
    }

    public RecipientInfo withAttestationDocument(ByteBuffer byteBuffer) {
        this.attestationDocument = byteBuffer;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyEncryptionAlgorithm() != null) {
            sb.append("KeyEncryptionAlgorithm: " + getKeyEncryptionAlgorithm() + ",");
        }
        if (getAttestationDocument() != null) {
            sb.append("AttestationDocument: " + getAttestationDocument());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        if (getKeyEncryptionAlgorithm() == null) {
            i = 0;
        } else {
            i = getKeyEncryptionAlgorithm().hashCode();
        }
        int i3 = (i + 31) * 31;
        if (getAttestationDocument() != null) {
            i2 = getAttestationDocument().hashCode();
        }
        return i3 + i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RecipientInfo)) {
            return false;
        }
        RecipientInfo recipientInfo = (RecipientInfo) obj;
        if ((recipientInfo.getKeyEncryptionAlgorithm() == null) ^ (getKeyEncryptionAlgorithm() == null)) {
            return false;
        }
        if (recipientInfo.getKeyEncryptionAlgorithm() != null && !recipientInfo.getKeyEncryptionAlgorithm().equals(getKeyEncryptionAlgorithm())) {
            return false;
        }
        if ((recipientInfo.getAttestationDocument() == null) ^ (getAttestationDocument() == null)) {
            return false;
        }
        return recipientInfo.getAttestationDocument() == null || recipientInfo.getAttestationDocument().equals(getAttestationDocument());
    }
}
