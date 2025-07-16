package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

public class SmsConfigurationType implements Serializable {
    private String externalId;
    private String snsCallerArn;
    private String snsRegion;

    public String getSnsCallerArn() {
        return this.snsCallerArn;
    }

    public void setSnsCallerArn(String str) {
        this.snsCallerArn = str;
    }

    public SmsConfigurationType withSnsCallerArn(String str) {
        this.snsCallerArn = str;
        return this;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public void setExternalId(String str) {
        this.externalId = str;
    }

    public SmsConfigurationType withExternalId(String str) {
        this.externalId = str;
        return this;
    }

    public String getSnsRegion() {
        return this.snsRegion;
    }

    public void setSnsRegion(String str) {
        this.snsRegion = str;
    }

    public SmsConfigurationType withSnsRegion(String str) {
        this.snsRegion = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getSnsCallerArn() != null) {
            sb.append("SnsCallerArn: " + getSnsCallerArn() + ",");
        }
        if (getExternalId() != null) {
            sb.append("ExternalId: " + getExternalId() + ",");
        }
        if (getSnsRegion() != null) {
            sb.append("SnsRegion: " + getSnsRegion());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((getSnsCallerArn() == null ? 0 : getSnsCallerArn().hashCode()) + 31) * 31) + (getExternalId() == null ? 0 : getExternalId().hashCode())) * 31;
        if (getSnsRegion() != null) {
            i = getSnsRegion().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SmsConfigurationType)) {
            return false;
        }
        SmsConfigurationType smsConfigurationType = (SmsConfigurationType) obj;
        if ((smsConfigurationType.getSnsCallerArn() == null) ^ (getSnsCallerArn() == null)) {
            return false;
        }
        if (smsConfigurationType.getSnsCallerArn() != null && !smsConfigurationType.getSnsCallerArn().equals(getSnsCallerArn())) {
            return false;
        }
        if ((smsConfigurationType.getExternalId() == null) ^ (getExternalId() == null)) {
            return false;
        }
        if (smsConfigurationType.getExternalId() != null && !smsConfigurationType.getExternalId().equals(getExternalId())) {
            return false;
        }
        if ((smsConfigurationType.getSnsRegion() == null) ^ (getSnsRegion() == null)) {
            return false;
        }
        return smsConfigurationType.getSnsRegion() == null || smsConfigurationType.getSnsRegion().equals(getSnsRegion());
    }
}
