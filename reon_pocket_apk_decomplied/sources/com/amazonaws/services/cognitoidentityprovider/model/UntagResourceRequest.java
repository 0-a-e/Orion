package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UntagResourceRequest extends AmazonWebServiceRequest implements Serializable {
    private String resourceArn;
    private List<String> tagKeys;

    public String getResourceArn() {
        return this.resourceArn;
    }

    public void setResourceArn(String str) {
        this.resourceArn = str;
    }

    public UntagResourceRequest withResourceArn(String str) {
        this.resourceArn = str;
        return this;
    }

    public List<String> getTagKeys() {
        return this.tagKeys;
    }

    public void setTagKeys(Collection<String> collection) {
        if (collection == null) {
            this.tagKeys = null;
        } else {
            this.tagKeys = new ArrayList(collection);
        }
    }

    public UntagResourceRequest withTagKeys(String... strArr) {
        if (getTagKeys() == null) {
            this.tagKeys = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.tagKeys.add(add);
        }
        return this;
    }

    public UntagResourceRequest withTagKeys(Collection<String> collection) {
        setTagKeys(collection);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getResourceArn() != null) {
            sb.append("ResourceArn: " + getResourceArn() + ",");
        }
        if (getTagKeys() != null) {
            sb.append("TagKeys: " + getTagKeys());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getResourceArn() == null ? 0 : getResourceArn().hashCode()) + 31) * 31;
        if (getTagKeys() != null) {
            i = getTagKeys().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UntagResourceRequest)) {
            return false;
        }
        UntagResourceRequest untagResourceRequest = (UntagResourceRequest) obj;
        if ((untagResourceRequest.getResourceArn() == null) ^ (getResourceArn() == null)) {
            return false;
        }
        if (untagResourceRequest.getResourceArn() != null && !untagResourceRequest.getResourceArn().equals(getResourceArn())) {
            return false;
        }
        if ((untagResourceRequest.getTagKeys() == null) ^ (getTagKeys() == null)) {
            return false;
        }
        return untagResourceRequest.getTagKeys() == null || untagResourceRequest.getTagKeys().equals(getTagKeys());
    }
}
