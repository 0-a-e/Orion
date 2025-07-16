package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenerateMacRequest extends AmazonWebServiceRequest implements Serializable {
    private Boolean dryRun;
    private List<String> grantTokens = new ArrayList();
    private String keyId;
    private String macAlgorithm;
    private ByteBuffer message;

    public ByteBuffer getMessage() {
        return this.message;
    }

    public void setMessage(ByteBuffer byteBuffer) {
        this.message = byteBuffer;
    }

    public GenerateMacRequest withMessage(ByteBuffer byteBuffer) {
        this.message = byteBuffer;
        return this;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public GenerateMacRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public String getMacAlgorithm() {
        return this.macAlgorithm;
    }

    public void setMacAlgorithm(String str) {
        this.macAlgorithm = str;
    }

    public GenerateMacRequest withMacAlgorithm(String str) {
        this.macAlgorithm = str;
        return this;
    }

    public void setMacAlgorithm(MacAlgorithmSpec macAlgorithmSpec) {
        this.macAlgorithm = macAlgorithmSpec.toString();
    }

    public GenerateMacRequest withMacAlgorithm(MacAlgorithmSpec macAlgorithmSpec) {
        this.macAlgorithm = macAlgorithmSpec.toString();
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

    public GenerateMacRequest withGrantTokens(String... strArr) {
        if (getGrantTokens() == null) {
            this.grantTokens = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.grantTokens.add(add);
        }
        return this;
    }

    public GenerateMacRequest withGrantTokens(Collection<String> collection) {
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

    public GenerateMacRequest withDryRun(Boolean bool) {
        this.dryRun = bool;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getMessage() != null) {
            sb.append("Message: " + getMessage() + ",");
        }
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getMacAlgorithm() != null) {
            sb.append("MacAlgorithm: " + getMacAlgorithm() + ",");
        }
        if (getGrantTokens() != null) {
            sb.append("GrantTokens: " + getGrantTokens() + ",");
        }
        if (getDryRun() != null) {
            sb.append("DryRun: " + getDryRun());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((((getMessage() == null ? 0 : getMessage().hashCode()) + 31) * 31) + (getKeyId() == null ? 0 : getKeyId().hashCode())) * 31) + (getMacAlgorithm() == null ? 0 : getMacAlgorithm().hashCode())) * 31) + (getGrantTokens() == null ? 0 : getGrantTokens().hashCode())) * 31;
        if (getDryRun() != null) {
            i = getDryRun().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GenerateMacRequest)) {
            return false;
        }
        GenerateMacRequest generateMacRequest = (GenerateMacRequest) obj;
        if ((generateMacRequest.getMessage() == null) ^ (getMessage() == null)) {
            return false;
        }
        if (generateMacRequest.getMessage() != null && !generateMacRequest.getMessage().equals(getMessage())) {
            return false;
        }
        if ((generateMacRequest.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (generateMacRequest.getKeyId() != null && !generateMacRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((generateMacRequest.getMacAlgorithm() == null) ^ (getMacAlgorithm() == null)) {
            return false;
        }
        if (generateMacRequest.getMacAlgorithm() != null && !generateMacRequest.getMacAlgorithm().equals(getMacAlgorithm())) {
            return false;
        }
        if ((generateMacRequest.getGrantTokens() == null) ^ (getGrantTokens() == null)) {
            return false;
        }
        if (generateMacRequest.getGrantTokens() != null && !generateMacRequest.getGrantTokens().equals(getGrantTokens())) {
            return false;
        }
        if ((generateMacRequest.getDryRun() == null) ^ (getDryRun() == null)) {
            return false;
        }
        return generateMacRequest.getDryRun() == null || generateMacRequest.getDryRun().equals(getDryRun());
    }
}
