package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

public class CloudWatchLogsConfigurationType implements Serializable {
    private String logGroupArn;

    public String getLogGroupArn() {
        return this.logGroupArn;
    }

    public void setLogGroupArn(String str) {
        this.logGroupArn = str;
    }

    public CloudWatchLogsConfigurationType withLogGroupArn(String str) {
        this.logGroupArn = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getLogGroupArn() != null) {
            sb.append("LogGroupArn: " + getLogGroupArn());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getLogGroupArn() == null ? 0 : getLogGroupArn().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CloudWatchLogsConfigurationType)) {
            return false;
        }
        CloudWatchLogsConfigurationType cloudWatchLogsConfigurationType = (CloudWatchLogsConfigurationType) obj;
        if ((cloudWatchLogsConfigurationType.getLogGroupArn() == null) ^ (getLogGroupArn() == null)) {
            return false;
        }
        return cloudWatchLogsConfigurationType.getLogGroupArn() == null || cloudWatchLogsConfigurationType.getLogGroupArn().equals(getLogGroupArn());
    }
}
