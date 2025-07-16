package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DeriveSharedSecretRequest extends AmazonWebServiceRequest implements Serializable {
    private Boolean dryRun;
    private List<String> grantTokens = new ArrayList();
    private String keyAgreementAlgorithm;
    private String keyId;
    private ByteBuffer publicKey;
    private RecipientInfo recipient;

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public DeriveSharedSecretRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public String getKeyAgreementAlgorithm() {
        return this.keyAgreementAlgorithm;
    }

    public void setKeyAgreementAlgorithm(String str) {
        this.keyAgreementAlgorithm = str;
    }

    public DeriveSharedSecretRequest withKeyAgreementAlgorithm(String str) {
        this.keyAgreementAlgorithm = str;
        return this;
    }

    public void setKeyAgreementAlgorithm(KeyAgreementAlgorithmSpec keyAgreementAlgorithmSpec) {
        this.keyAgreementAlgorithm = keyAgreementAlgorithmSpec.toString();
    }

    public DeriveSharedSecretRequest withKeyAgreementAlgorithm(KeyAgreementAlgorithmSpec keyAgreementAlgorithmSpec) {
        this.keyAgreementAlgorithm = keyAgreementAlgorithmSpec.toString();
        return this;
    }

    public ByteBuffer getPublicKey() {
        return this.publicKey;
    }

    public void setPublicKey(ByteBuffer byteBuffer) {
        this.publicKey = byteBuffer;
    }

    public DeriveSharedSecretRequest withPublicKey(ByteBuffer byteBuffer) {
        this.publicKey = byteBuffer;
        return this;
    }

    public List<String> getGrantTokens() {
        return this.grantTokens;
    }

    public void setGrantTokens(Collection<String> collection) {
        if (collection == null) {
            this.grantTokens = null;
        } else {
            this.grantTokens = new ArrayList(collection);
        }
    }

    public DeriveSharedSecretRequest withGrantTokens(String... strArr) {
        if (getGrantTokens() == null) {
            this.grantTokens = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.grantTokens.add(add);
        }
        return this;
    }

    public DeriveSharedSecretRequest withGrantTokens(Collection<String> collection) {
        setGrantTokens(collection);
        return this;
    }

    public Boolean isDryRun() {
        return this.dryRun;
    }

    public Boolean getDryRun() {
        return this.dryRun;
    }

    public void setDryRun(Boolean bool) {
        this.dryRun = bool;
    }

    public DeriveSharedSecretRequest withDryRun(Boolean bool) {
        this.dryRun = bool;
        return this;
    }

    public RecipientInfo getRecipient() {
        return this.recipient;
    }

    public void setRecipient(RecipientInfo recipientInfo) {
        this.recipient = recipientInfo;
    }

    public DeriveSharedSecretRequest withRecipient(RecipientInfo recipientInfo) {
        this.recipient = recipientInfo;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getKeyAgreementAlgorithm() != null) {
            sb.append("KeyAgreementAlgorithm: " + getKeyAgreementAlgorithm() + ",");
        }
        if (getPublicKey() != null) {
            sb.append("PublicKey: " + getPublicKey() + ",");
        }
        if (getGrantTokens() != null) {
            sb.append("GrantTokens: " + getGrantTokens() + ",");
        }
        if (getDryRun() != null) {
            sb.append("DryRun: " + getDryRun() + ",");
        }
        if (getRecipient() != null) {
            sb.append("Recipient: " + getRecipient());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((((((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31) + (getKeyAgreementAlgorithm() == null ? 0 : getKeyAgreementAlgorithm().hashCode())) * 31) + (getPublicKey() == null ? 0 : getPublicKey().hashCode())) * 31) + (getGrantTokens() == null ? 0 : getGrantTokens().hashCode())) * 31) + (getDryRun() == null ? 0 : getDryRun().hashCode())) * 31;
        if (getRecipient() != null) {
            i = getRecipient().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeriveSharedSecretRequest)) {
            return false;
        }
        DeriveSharedSecretRequest deriveSharedSecretRequest = (DeriveSharedSecretRequest) obj;
        if ((deriveSharedSecretRequest.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (deriveSharedSecretRequest.getKeyId() != null && !deriveSharedSecretRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((deriveSharedSecretRequest.getKeyAgreementAlgorithm() == null) ^ (getKeyAgreementAlgorithm() == null)) {
            return false;
        }
        if (deriveSharedSecretRequest.getKeyAgreementAlgorithm() != null && !deriveSharedSecretRequest.getKeyAgreementAlgorithm().equals(getKeyAgreementAlgorithm())) {
            return false;
        }
        if ((deriveSharedSecretRequest.getPublicKey() == null) ^ (getPublicKey() == null)) {
            return false;
        }
        if (deriveSharedSecretRequest.getPublicKey() != null && !deriveSharedSecretRequest.getPublicKey().equals(getPublicKey())) {
            return false;
        }
        if ((deriveSharedSecretRequest.getGrantTokens() == null) ^ (getGrantTokens() == null)) {
            return false;
        }
        if (deriveSharedSecretRequest.getGrantTokens() != null && !deriveSharedSecretRequest.getGrantTokens().equals(getGrantTokens())) {
            return false;
        }
        if ((deriveSharedSecretRequest.getDryRun() == null) ^ (getDryRun() == null)) {
            return false;
        }
        if (deriveSharedSecretRequest.getDryRun() != null && !deriveSharedSecretRequest.getDryRun().equals(getDryRun())) {
            return false;
        }
        if ((deriveSharedSecretRequest.getRecipient() == null) ^ (getRecipient() == null)) {
            return false;
        }
        return deriveSharedSecretRequest.getRecipient() == null || deriveSharedSecretRequest.getRecipient().equals(getRecipient());
    }
}
