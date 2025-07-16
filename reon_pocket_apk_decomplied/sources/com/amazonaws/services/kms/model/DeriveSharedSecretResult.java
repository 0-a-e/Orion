package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.nio.ByteBuffer;

public class DeriveSharedSecretResult implements Serializable {
    private ByteBuffer ciphertextForRecipient;
    private String keyAgreementAlgorithm;
    private String keyId;
    private String keyOrigin;
    private ByteBuffer sharedSecret;

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public DeriveSharedSecretResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public ByteBuffer getSharedSecret() {
        return this.sharedSecret;
    }

    public void setSharedSecret(ByteBuffer byteBuffer) {
        this.sharedSecret = byteBuffer;
    }

    public DeriveSharedSecretResult withSharedSecret(ByteBuffer byteBuffer) {
        this.sharedSecret = byteBuffer;
        return this;
    }

    public ByteBuffer getCiphertextForRecipient() {
        return this.ciphertextForRecipient;
    }

    public void setCiphertextForRecipient(ByteBuffer byteBuffer) {
        this.ciphertextForRecipient = byteBuffer;
    }

    public DeriveSharedSecretResult withCiphertextForRecipient(ByteBuffer byteBuffer) {
        this.ciphertextForRecipient = byteBuffer;
        return this;
    }

    public String getKeyAgreementAlgorithm() {
        return this.keyAgreementAlgorithm;
    }

    public void setKeyAgreementAlgorithm(String str) {
        this.keyAgreementAlgorithm = str;
    }

    public DeriveSharedSecretResult withKeyAgreementAlgorithm(String str) {
        this.keyAgreementAlgorithm = str;
        return this;
    }

    public void setKeyAgreementAlgorithm(KeyAgreementAlgorithmSpec keyAgreementAlgorithmSpec) {
        this.keyAgreementAlgorithm = keyAgreementAlgorithmSpec.toString();
    }

    public DeriveSharedSecretResult withKeyAgreementAlgorithm(KeyAgreementAlgorithmSpec keyAgreementAlgorithmSpec) {
        this.keyAgreementAlgorithm = keyAgreementAlgorithmSpec.toString();
        return this;
    }

    public String getKeyOrigin() {
        return this.keyOrigin;
    }

    public void setKeyOrigin(String str) {
        this.keyOrigin = str;
    }

    public DeriveSharedSecretResult withKeyOrigin(String str) {
        this.keyOrigin = str;
        return this;
    }

    public void setKeyOrigin(OriginType originType) {
        this.keyOrigin = originType.toString();
    }

    public DeriveSharedSecretResult withKeyOrigin(OriginType originType) {
        this.keyOrigin = originType.toString();
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getSharedSecret() != null) {
            sb.append("SharedSecret: " + getSharedSecret() + ",");
        }
        if (getCiphertextForRecipient() != null) {
            sb.append("CiphertextForRecipient: " + getCiphertextForRecipient() + ",");
        }
        if (getKeyAgreementAlgorithm() != null) {
            sb.append("KeyAgreementAlgorithm: " + getKeyAgreementAlgorithm() + ",");
        }
        if (getKeyOrigin() != null) {
            sb.append("KeyOrigin: " + getKeyOrigin());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        int hashCode = ((((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31) + (getSharedSecret() == null ? 0 : getSharedSecret().hashCode())) * 31;
        if (getCiphertextForRecipient() == null) {
            i = 0;
        } else {
            i = getCiphertextForRecipient().hashCode();
        }
        int hashCode2 = (((hashCode + i) * 31) + (getKeyAgreementAlgorithm() == null ? 0 : getKeyAgreementAlgorithm().hashCode())) * 31;
        if (getKeyOrigin() != null) {
            i2 = getKeyOrigin().hashCode();
        }
        return hashCode2 + i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeriveSharedSecretResult)) {
            return false;
        }
        DeriveSharedSecretResult deriveSharedSecretResult = (DeriveSharedSecretResult) obj;
        if ((deriveSharedSecretResult.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (deriveSharedSecretResult.getKeyId() != null && !deriveSharedSecretResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((deriveSharedSecretResult.getSharedSecret() == null) ^ (getSharedSecret() == null)) {
            return false;
        }
        if (deriveSharedSecretResult.getSharedSecret() != null && !deriveSharedSecretResult.getSharedSecret().equals(getSharedSecret())) {
            return false;
        }
        if ((deriveSharedSecretResult.getCiphertextForRecipient() == null) ^ (getCiphertextForRecipient() == null)) {
            return false;
        }
        if (deriveSharedSecretResult.getCiphertextForRecipient() != null && !deriveSharedSecretResult.getCiphertextForRecipient().equals(getCiphertextForRecipient())) {
            return false;
        }
        if ((deriveSharedSecretResult.getKeyAgreementAlgorithm() == null) ^ (getKeyAgreementAlgorithm() == null)) {
            return false;
        }
        if (deriveSharedSecretResult.getKeyAgreementAlgorithm() != null && !deriveSharedSecretResult.getKeyAgreementAlgorithm().equals(getKeyAgreementAlgorithm())) {
            return false;
        }
        if ((deriveSharedSecretResult.getKeyOrigin() == null) ^ (getKeyOrigin() == null)) {
            return false;
        }
        return deriveSharedSecretResult.getKeyOrigin() == null || deriveSharedSecretResult.getKeyOrigin().equals(getKeyOrigin());
    }
}
