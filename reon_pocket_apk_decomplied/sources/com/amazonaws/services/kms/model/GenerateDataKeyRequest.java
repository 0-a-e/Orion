package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateDataKeyRequest extends AmazonWebServiceRequest implements Serializable {
    private Boolean dryRun;
    private Map<String, String> encryptionContext = new HashMap();
    private List<String> grantTokens = new ArrayList();
    private String keyId;
    private String keySpec;
    private Integer numberOfBytes;
    private RecipientInfo recipient;

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public GenerateDataKeyRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public Map<String, String> getEncryptionContext() {
        return this.encryptionContext;
    }

    public void setEncryptionContext(Map<String, String> map) {
        this.encryptionContext = map;
    }

    public GenerateDataKeyRequest withEncryptionContext(Map<String, String> map) {
        this.encryptionContext = map;
        return this;
    }

    public GenerateDataKeyRequest addEncryptionContextEntry(String str, String str2) {
        if (this.encryptionContext == null) {
            this.encryptionContext = new HashMap();
        }
        if (!this.encryptionContext.containsKey(str)) {
            this.encryptionContext.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public GenerateDataKeyRequest clearEncryptionContextEntries() {
        this.encryptionContext = null;
        return this;
    }

    public Integer getNumberOfBytes() {
        return this.numberOfBytes;
    }

    public void setNumberOfBytes(Integer num) {
        this.numberOfBytes = num;
    }

    public GenerateDataKeyRequest withNumberOfBytes(Integer num) {
        this.numberOfBytes = num;
        return this;
    }

    public String getKeySpec() {
        return this.keySpec;
    }

    public void setKeySpec(String str) {
        this.keySpec = str;
    }

    public GenerateDataKeyRequest withKeySpec(String str) {
        this.keySpec = str;
        return this;
    }

    public void setKeySpec(DataKeySpec dataKeySpec) {
        this.keySpec = dataKeySpec.toString();
    }

    public GenerateDataKeyRequest withKeySpec(DataKeySpec dataKeySpec) {
        this.keySpec = dataKeySpec.toString();
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

    public GenerateDataKeyRequest withGrantTokens(String... strArr) {
        if (getGrantTokens() == null) {
            this.grantTokens = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.grantTokens.add(add);
        }
        return this;
    }

    public GenerateDataKeyRequest withGrantTokens(Collection<String> collection) {
        setGrantTokens(collection);
        return this;
    }

    public RecipientInfo getRecipient() {
        return this.recipient;
    }

    public void setRecipient(RecipientInfo recipientInfo) {
        this.recipient = recipientInfo;
    }

    public GenerateDataKeyRequest withRecipient(RecipientInfo recipientInfo) {
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

    public GenerateDataKeyRequest withDryRun(Boolean bool) {
        this.dryRun = bool;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getEncryptionContext() != null) {
            sb.append("EncryptionContext: " + getEncryptionContext() + ",");
        }
        if (getNumberOfBytes() != null) {
            sb.append("NumberOfBytes: " + getNumberOfBytes() + ",");
        }
        if (getKeySpec() != null) {
            sb.append("KeySpec: " + getKeySpec() + ",");
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
        int hashCode = ((((((((((((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31) + (getEncryptionContext() == null ? 0 : getEncryptionContext().hashCode())) * 31) + (getNumberOfBytes() == null ? 0 : getNumberOfBytes().hashCode())) * 31) + (getKeySpec() == null ? 0 : getKeySpec().hashCode())) * 31) + (getGrantTokens() == null ? 0 : getGrantTokens().hashCode())) * 31) + (getRecipient() == null ? 0 : getRecipient().hashCode())) * 31;
        if (getDryRun() != null) {
            i = getDryRun().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GenerateDataKeyRequest)) {
            return false;
        }
        GenerateDataKeyRequest generateDataKeyRequest = (GenerateDataKeyRequest) obj;
        if ((generateDataKeyRequest.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (generateDataKeyRequest.getKeyId() != null && !generateDataKeyRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((generateDataKeyRequest.getEncryptionContext() == null) ^ (getEncryptionContext() == null)) {
            return false;
        }
        if (generateDataKeyRequest.getEncryptionContext() != null && !generateDataKeyRequest.getEncryptionContext().equals(getEncryptionContext())) {
            return false;
        }
        if ((generateDataKeyRequest.getNumberOfBytes() == null) ^ (getNumberOfBytes() == null)) {
            return false;
        }
        if (generateDataKeyRequest.getNumberOfBytes() != null && !generateDataKeyRequest.getNumberOfBytes().equals(getNumberOfBytes())) {
            return false;
        }
        if ((generateDataKeyRequest.getKeySpec() == null) ^ (getKeySpec() == null)) {
            return false;
        }
        if (generateDataKeyRequest.getKeySpec() != null && !generateDataKeyRequest.getKeySpec().equals(getKeySpec())) {
            return false;
        }
        if ((generateDataKeyRequest.getGrantTokens() == null) ^ (getGrantTokens() == null)) {
            return false;
        }
        if (generateDataKeyRequest.getGrantTokens() != null && !generateDataKeyRequest.getGrantTokens().equals(getGrantTokens())) {
            return false;
        }
        if ((generateDataKeyRequest.getRecipient() == null) ^ (getRecipient() == null)) {
            return false;
        }
        if (generateDataKeyRequest.getRecipient() != null && !generateDataKeyRequest.getRecipient().equals(getRecipient())) {
            return false;
        }
        if ((generateDataKeyRequest.getDryRun() == null) ^ (getDryRun() == null)) {
            return false;
        }
        return generateDataKeyRequest.getDryRun() == null || generateDataKeyRequest.getDryRun().equals(getDryRun());
    }
}
