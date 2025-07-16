package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListTagsOfResourceResult implements Serializable {
    private String nextToken;
    private List<Tag> tags;

    public List<Tag> getTags() {
        return this.tags;
    }

    public void setTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
        } else {
            this.tags = new ArrayList(collection);
        }
    }

    public ListTagsOfResourceResult withTags(Tag... tagArr) {
        if (getTags() == null) {
            this.tags = new ArrayList(tagArr.length);
        }
        for (Tag add : tagArr) {
            this.tags.add(add);
        }
        return this;
    }

    public ListTagsOfResourceResult withTags(Collection<Tag> collection) {
        setTags(collection);
        return this;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public ListTagsOfResourceResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getTags() != null) {
            sb.append("Tags: " + getTags() + ",");
        }
        if (getNextToken() != null) {
            sb.append("NextToken: " + getNextToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getTags() == null ? 0 : getTags().hashCode()) + 31) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListTagsOfResourceResult)) {
            return false;
        }
        ListTagsOfResourceResult listTagsOfResourceResult = (ListTagsOfResourceResult) obj;
        if ((listTagsOfResourceResult.getTags() == null) ^ (getTags() == null)) {
            return false;
        }
        if (listTagsOfResourceResult.getTags() != null && !listTagsOfResourceResult.getTags().equals(getTags())) {
            return false;
        }
        if ((listTagsOfResourceResult.getNextToken() == null) ^ (getNextToken() == null)) {
            return false;
        }
        return listTagsOfResourceResult.getNextToken() == null || listTagsOfResourceResult.getNextToken().equals(getNextToken());
    }
}
