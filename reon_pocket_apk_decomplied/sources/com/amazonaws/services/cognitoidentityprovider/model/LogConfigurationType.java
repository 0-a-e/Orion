package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

public class LogConfigurationType implements Serializable {
    private CloudWatchLogsConfigurationType cloudWatchLogsConfiguration;
    private String eventSource;
    private String logLevel;

    public String getLogLevel() {
        return this.logLevel;
    }

    public void setLogLevel(String str) {
        this.logLevel = str;
    }

    public LogConfigurationType withLogLevel(String str) {
        this.logLevel = str;
        return this;
    }

    public void setLogLevel(LogLevel logLevel2) {
        this.logLevel = logLevel2.toString();
    }

    public LogConfigurationType withLogLevel(LogLevel logLevel2) {
        this.logLevel = logLevel2.toString();
        return this;
    }

    public String getEventSource() {
        return this.eventSource;
    }

    public void setEventSource(String str) {
        this.eventSource = str;
    }

    public LogConfigurationType withEventSource(String str) {
        this.eventSource = str;
        return this;
    }

    public void setEventSource(EventSourceName eventSourceName) {
        this.eventSource = eventSourceName.toString();
    }

    public LogConfigurationType withEventSource(EventSourceName eventSourceName) {
        this.eventSource = eventSourceName.toString();
        return this;
    }

    public CloudWatchLogsConfigurationType getCloudWatchLogsConfiguration() {
        return this.cloudWatchLogsConfiguration;
    }

    public void setCloudWatchLogsConfiguration(CloudWatchLogsConfigurationType cloudWatchLogsConfigurationType) {
        this.cloudWatchLogsConfiguration = cloudWatchLogsConfigurationType;
    }

    public LogConfigurationType withCloudWatchLogsConfiguration(CloudWatchLogsConfigurationType cloudWatchLogsConfigurationType) {
        this.cloudWatchLogsConfiguration = cloudWatchLogsConfigurationType;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getLogLevel() != null) {
            sb.append("LogLevel: " + getLogLevel() + ",");
        }
        if (getEventSource() != null) {
            sb.append("EventSource: " + getEventSource() + ",");
        }
        if (getCloudWatchLogsConfiguration() != null) {
            sb.append("CloudWatchLogsConfiguration: " + getCloudWatchLogsConfiguration());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((getLogLevel() == null ? 0 : getLogLevel().hashCode()) + 31) * 31) + (getEventSource() == null ? 0 : getEventSource().hashCode())) * 31;
        if (getCloudWatchLogsConfiguration() != null) {
            i = getCloudWatchLogsConfiguration().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof LogConfigurationType)) {
            return false;
        }
        LogConfigurationType logConfigurationType = (LogConfigurationType) obj;
        if ((logConfigurationType.getLogLevel() == null) ^ (getLogLevel() == null)) {
            return false;
        }
        if (logConfigurationType.getLogLevel() != null && !logConfigurationType.getLogLevel().equals(getLogLevel())) {
            return false;
        }
        if ((logConfigurationType.getEventSource() == null) ^ (getEventSource() == null)) {
            return false;
        }
        if (logConfigurationType.getEventSource() != null && !logConfigurationType.getEventSource().equals(getEventSource())) {
            return false;
        }
        if ((logConfigurationType.getCloudWatchLogsConfiguration() == null) ^ (getCloudWatchLogsConfiguration() == null)) {
            return false;
        }
        return logConfigurationType.getCloudWatchLogsConfiguration() == null || logConfigurationType.getCloudWatchLogsConfiguration().equals(getCloudWatchLogsConfiguration());
    }
}
