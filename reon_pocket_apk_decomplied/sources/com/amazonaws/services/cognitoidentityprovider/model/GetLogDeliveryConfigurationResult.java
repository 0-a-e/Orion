package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

public class GetLogDeliveryConfigurationResult implements Serializable {
    private LogDeliveryConfigurationType logDeliveryConfiguration;

    public LogDeliveryConfigurationType getLogDeliveryConfiguration() {
        return this.logDeliveryConfiguration;
    }

    public void setLogDeliveryConfiguration(LogDeliveryConfigurationType logDeliveryConfigurationType) {
        this.logDeliveryConfiguration = logDeliveryConfigurationType;
    }

    public GetLogDeliveryConfigurationResult withLogDeliveryConfiguration(LogDeliveryConfigurationType logDeliveryConfigurationType) {
        this.logDeliveryConfiguration = logDeliveryConfigurationType;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getLogDeliveryConfiguration() != null) {
            sb.append("LogDeliveryConfiguration: " + getLogDeliveryConfiguration());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        if (getLogDeliveryConfiguration() == null) {
            i = 0;
        } else {
            i = getLogDeliveryConfiguration().hashCode();
        }
        return 31 + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetLogDeliveryConfigurationResult)) {
            return false;
        }
        GetLogDeliveryConfigurationResult getLogDeliveryConfigurationResult = (GetLogDeliveryConfigurationResult) obj;
        if ((getLogDeliveryConfigurationResult.getLogDeliveryConfiguration() == null) ^ (getLogDeliveryConfiguration() == null)) {
            return false;
        }
        return getLogDeliveryConfigurationResult.getLogDeliveryConfiguration() == null || getLogDeliveryConfigurationResult.getLogDeliveryConfiguration().equals(getLogDeliveryConfiguration());
    }
}
