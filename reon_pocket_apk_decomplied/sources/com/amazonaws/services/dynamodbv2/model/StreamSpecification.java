package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

public class StreamSpecification implements Serializable {
    private Boolean streamEnabled;
    private String streamViewType;

    public Boolean isStreamEnabled() {
        return this.streamEnabled;
    }

    public Boolean getStreamEnabled() {
        return this.streamEnabled;
    }

    public void setStreamEnabled(Boolean bool) {
        this.streamEnabled = bool;
    }

    public StreamSpecification withStreamEnabled(Boolean bool) {
        this.streamEnabled = bool;
        return this;
    }

    public String getStreamViewType() {
        return this.streamViewType;
    }

    public void setStreamViewType(String str) {
        this.streamViewType = str;
    }

    public StreamSpecification withStreamViewType(String str) {
        this.streamViewType = str;
        return this;
    }

    public void setStreamViewType(StreamViewType streamViewType2) {
        this.streamViewType = streamViewType2.toString();
    }

    public StreamSpecification withStreamViewType(StreamViewType streamViewType2) {
        this.streamViewType = streamViewType2.toString();
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getStreamEnabled() != null) {
            sb.append("StreamEnabled: " + getStreamEnabled() + ",");
        }
        if (getStreamViewType() != null) {
            sb.append("StreamViewType: " + getStreamViewType());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getStreamEnabled() == null ? 0 : getStreamEnabled().hashCode()) + 31) * 31;
        if (getStreamViewType() != null) {
            i = getStreamViewType().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof StreamSpecification)) {
            return false;
        }
        StreamSpecification streamSpecification = (StreamSpecification) obj;
        if ((streamSpecification.getStreamEnabled() == null) ^ (getStreamEnabled() == null)) {
            return false;
        }
        if (streamSpecification.getStreamEnabled() != null && !streamSpecification.getStreamEnabled().equals(getStreamEnabled())) {
            return false;
        }
        if ((streamSpecification.getStreamViewType() == null) ^ (getStreamViewType() == null)) {
            return false;
        }
        return streamSpecification.getStreamViewType() == null || streamSpecification.getStreamViewType().equals(getStreamViewType());
    }
}
