package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListTagsOfResourceRequest extends AmazonWebServiceRequest implements Serializable {
    private String nextToken;
    private String resourceArn;

    public String getResourceArn() {
        return this.resourceArn;
    }

    public void setResourceArn(String str) {
        this.resourceArn = str;
    }

    public ListTagsOfResourceRequest withResourceArn(String str) {
        this.resourceArn = str;
        return this;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public ListTagsOfResourceRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getResourceArn() != null) {
            sb.append("ResourceArn: " + getResourceArn() + ",");
        }
        if (getNextToken() != null) {
            sb.append("NextToken: " + getNextToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getResourceArn() == null ? 0 : getResourceArn().hashCode()) + 31) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListTagsOfResourceRequest)) {
            return false;
        }
        ListTagsOfResourceRequest listTagsOfResourceRequest = (ListTagsOfResourceRequest) obj;
        if ((listTagsOfResourceRequest.getResourceArn() == null) ^ (getResourceArn() == null)) {
            return false;
        }
        if (listTagsOfResourceRequest.getResourceArn() != null && !listTagsOfResourceRequest.getResourceArn().equals(getResourceArn())) {
            return false;
        }
        if ((listTagsOfResourceRequest.getNextToken() == null) ^ (getNextToken() == null)) {
            return false;
        }
        return listTagsOfResourceRequest.getNextToken() == null || listTagsOfResourceRequest.getNextToken().equals(getNextToken());
    }
}
