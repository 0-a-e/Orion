package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateDataKeyPairRequest extends AmazonWebServiceRequest implements Serializable {
    private Boolean dryRun;
    private Map<String, String> encryptionContext = new HashMap();
    private List<String> grantTokens = new ArrayList();
    private String keyId;
    private String keyPairSpec;
    private RecipientInfo recipient;

    public Map<String, String> getEncryptionContext() {
        return this.encryptionContext;
    }

    public void setEncryptionContext(Map<String, String> map) {
        this.encryptionContext = map;
    }

    public GenerateDataKeyPairRequest withEncryptionContext(Map<String, String> map) {
        this.encryptionContext = map;
        return this;
    }

    public GenerateDataKeyPairRequest addEncryptionContextEntry(String str, String str2) {
        if (this.encryptionContext == null) {
            this.encryptionContext = new HashMap();
        }
        if (!this.encryptionContext.containsKey(str)) {
            this.encryptionContext.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public GenerateDataKeyPairRequest clearEncryptionContextEntries() {
        this.encryptionContext = null;
        return this;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public GenerateDataKeyPairRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public String getKeyPairSpec() {
        return this.keyPairSpec;
    }

    public void setKeyPairSpec(String str) {
        this.keyPairSpec = str;
    }

    public GenerateDataKeyPairRequest withKeyPairSpec(String str) {
        this.keyPairSpec = str;
        return this;
    }

    public void setKeyPairSpec(DataKeyPairSpec dataKeyPairSpec) {
        this.keyPairSpec = dataKeyPairSpec.toString();
    }

    public GenerateDataKeyPairRequest withKeyPairSpec(DataKeyPairSpec dataKeyPairSpec) {
        this.keyPairSpec = dataKeyPairSpec.toString();
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

    public GenerateDataKeyPairRequest withGrantTokens(String... strArr) {
        if (getGrantTokens() == null) {
            this.grantTokens = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.grantTokens.add(add);
        }
        return this;
    }

    public GenerateDataKeyPairRequest withGrantTokens(Collection<String> collection) {
        setGrantTokens(collection);
        return this;
    }

    public RecipientInfo getRecipient() {
        return this.recipient;
    }

    public void setRecipient(RecipientInfo recipientInfo) {
        this.recipient = recipientInfo;
    }

    public GenerateDataKeyPairRequest withRecipient(RecipientInfo recipientInfo) {
        this.recipient = recipientInfo;
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

    public GenerateDataKeyPairRequest withDryRun(Boolean bool) {
        this.dryRun = bool;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getEncryptionContext() != null) {
            sb.append("EncryptionContext: " + getEncryptionContext() + ",");
        }
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getKeyPairSpec() != null) {
            sb.append("KeyPairSpec: " + getKeyPairSpec() + ",");
        }
        if (getGrantTokens() != null) {
            sb.append("GrantTokens: " + getGrantTokens() + ",");
        }
        if (getRecipient() != null) {
            sb.append("Recipient: " + getRecipient() + ",");
        }
        if (getDryRun() != null) {
            sb.append("DryRun: " + getDryRun());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((((((getEncryptionContext() == null ? 0 : getEncryptionContext().hashCode()) + 31) * 31) + (getKeyId() == null ? 0 : getKeyId().hashCode())) * 31) + (getKeyPairSpec() == null ? 0 : getKeyPairSpec().hashCode())) * 31) + (getGrantTokens() == null ? 0 : getGrantTokens().hashCode())) * 31) + (getRecipient() == null ? 0 : getRecipient().hashCode())) * 31;
        if (getDryRun() != null) {
            i = getDryRun().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GenerateDataKeyPairRequest)) {
            return false;
        }
        GenerateDataKeyPairRequest generateDataKeyPairRequest = (GenerateDataKeyPairRequest) obj;
        if ((generateDataKeyPairRequest.getEncryptionContext() == null) ^ (getEncryptionContext() == null)) {
            return false;
        }
        if (generateDataKeyPairRequest.getEncryptionContext() != null && !generateDataKeyPairRequest.getEncryptionContext().equals(getEncryptionContext())) {
            return false;
        }
        if ((generateDataKeyPairRequest.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (generateDataKeyPairRequest.getKeyId() != null && !generateDataKeyPairRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((generateDataKeyPairRequest.getKeyPairSpec() == null) ^ (getKeyPairSpec() == null)) {
            return false;
        }
        if (generateDataKeyPairRequest.getKeyPairSpec() != null && !generateDataKeyPairRequest.getKeyPairSpec().equals(getKeyPairSpec())) {
            return false;
        }
        if ((generateDataKeyPairRequest.getGrantTokens() == null) ^ (getGrantTokens() == null)) {
            return false;
        }
        if (generateDataKeyPairRequest.getGrantTokens() != null && !generateDataKeyPairRequest.getGrantTokens().equals(getGrantTokens())) {
            return false;
        }
        if ((generateDataKeyPairRequest.getRecipient() == null) ^ (getRecipient() == null)) {
            return false;
        }
        if (generateDataKeyPairRequest.getRecipient() != null && !generateDataKeyPairRequest.getRecipient().equals(getRecipient())) {
            return false;
        }
        if ((generateDataKeyPairRequest.getDryRun() == null) ^ (getDryRun() == null)) {
            return false;
        }
        return generateDataKeyPairRequest.getDryRun() == null || generateDataKeyPairRequest.getDryRun().equals(getDryRun());
    }
}
