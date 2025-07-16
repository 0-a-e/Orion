package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SetLogDeliveryConfigurationRequest extends AmazonWebServiceRequest implements Serializable {
    private List<LogConfigurationType> logConfigurations;
    private String userPoolId;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public SetLogDeliveryConfigurationRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public List<LogConfigurationType> getLogConfigurations() {
        return this.logConfigurations;
    }

    public void setLogConfigurations(Collection<LogConfigurationType> collection) {
        if (collection == null) {
            this.logConfigurations = null;
        } else {
            this.logConfigurations = new ArrayList(collection);
        }
    }

    public SetLogDeliveryConfigurationRequest withLogConfigurations(LogConfigurationType... logConfigurationTypeArr) {
        if (getLogConfigurations() == null) {
            this.logConfigurations = new ArrayList(logConfigurationTypeArr.length);
        }
        for (LogConfigurationType add : logConfigurationTypeArr) {
            this.logConfigurations.add(add);
        }
        return this;
    }

    public SetLogDeliveryConfigurationRequest withLogConfigurations(Collection<LogConfigurationType> collection) {
        setLogConfigurations(collection);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getLogConfigurations() != null) {
            sb.append("LogConfigurations: " + getLogConfigurations());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31;
        if (getLogConfigurations() != null) {
            i = getLogConfigurations().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SetLogDeliveryConfigurationRequest)) {
            return false;
        }
        SetLogDeliveryConfigurationRequest setLogDeliveryConfigurationRequest = (SetLogDeliveryConfigurationRequest) obj;
        if ((setLogDeliveryConfigurationRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (setLogDeliveryConfigurationRequest.getUserPoolId() != null && !setLogDeliveryConfigurationRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((setLogDeliveryConfigurationRequest.getLogConfigurations() == null) ^ (getLogConfigurations() == null)) {
            return false;
        }
        return setLogDeliveryConfigurationRequest.getLogConfigurations() == null || setLogDeliveryConfigurationRequest.getLogConfigurations().equals(getLogConfigurations());
    }
}
