package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport_ApplicationExitInfo extends CrashlyticsReport.ApplicationExitInfo {
    private final int importance;
    private final int pid;
    private final String processName;
    private final long pss;
    private final int reasonCode;
    private final long rss;
    private final long timestamp;
    private final String traceFile;

    private AutoValue_CrashlyticsReport_ApplicationExitInfo(int i, String str, int i2, int i3, long j, long j2, long j3, String str2) {
        this.pid = i;
        this.processName = str;
        this.reasonCode = i2;
        this.importance = i3;
        this.pss = j;
        this.rss = j2;
        this.timestamp = j3;
        this.traceFile = str2;
    }

    public int getPid() {
        return this.pid;
    }

    public String getProcessName() {
        return this.processName;
    }

    public int getReasonCode() {
        return this.reasonCode;
    }

    public int getImportance() {
        return this.importance;
    }

    public long getPss() {
        return this.pss;
    }

    public long getRss() {
        return this.rss;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getTraceFile() {
        return this.traceFile;
    }

    public String toString() {
        return "ApplicationExitInfo{pid=" + this.pid + ", processName=" + this.processName + ", reasonCode=" + this.reasonCode + ", importance=" + this.importance + ", pss=" + this.pss + ", rss=" + this.rss + ", timestamp=" + this.timestamp + ", traceFile=" + this.traceFile + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.ApplicationExitInfo)) {
            return false;
        }
        CrashlyticsReport.ApplicationExitInfo applicationExitInfo = (CrashlyticsReport.ApplicationExitInfo) obj;
        if (this.pid == applicationExitInfo.getPid() && this.processName.equals(applicationExitInfo.getProcessName()) && this.reasonCode == applicationExitInfo.getReasonCode() && this.importance == applicationExitInfo.getImportance() && this.pss == applicationExitInfo.getPss() && this.rss == applicationExitInfo.getRss() && this.timestamp == applicationExitInfo.getTimestamp()) {
            String str = this.traceFile;
            if (str == null) {
                if (applicationExitInfo.getTraceFile() == null) {
                    return true;
                }
            } else if (str.equals(applicationExitInfo.getTraceFile())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.pss;
        long j2 = this.rss;
        long j3 = this.timestamp;
        int hashCode = (((((((((((((this.pid ^ 1000003) * 1000003) ^ this.processName.hashCode()) * 1000003) ^ this.reasonCode) * 1000003) ^ this.importance) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        String str = this.traceFile;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    static final class Builder extends CrashlyticsReport.ApplicationExitInfo.Builder {
        private Integer importance;
        private Integer pid;
        private String processName;
        private Long pss;
        private Integer reasonCode;
        private Long rss;
        private Long timestamp;
        private String traceFile;

        Builder() {
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder setPid(int i) {
            this.pid = Integer.valueOf(i);
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder setProcessName(String str) {
            if (str != null) {
                this.processName = str;
                return this;
            }
            throw new NullPointerException("Null processName");
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder setReasonCode(int i) {
            this.reasonCode = Integer.valueOf(i);
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder setImportance(int i) {
            this.importance = Integer.valueOf(i);
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder setPss(long j) {
            this.pss = Long.valueOf(j);
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder setRss(long j) {
            this.rss = Long.valueOf(j);
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder setTimestamp(long j) {
            this.timestamp = Long.valueOf(j);
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder setTraceFile(String str) {
            this.traceFile = str;
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo build() {
            String str;
            if (this.pid == null) {
                str = " pid";
            } else {
                str = "";
            }
            if (this.processName == null) {
                str = str + " processName";
            }
            if (this.reasonCode == null) {
                str = str + " reasonCode";
            }
            if (this.importance == null) {
                str = str + " importance";
            }
            if (this.pss == null) {
                str = str + " pss";
            }
            if (this.rss == null) {
                str = str + " rss";
            }
            if (this.timestamp == null) {
                str = str + " timestamp";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_ApplicationExitInfo(this.pid.intValue(), this.processName, this.reasonCode.intValue(), this.importance.intValue(), this.pss.longValue(), this.rss.longValue(), this.timestamp.longValue(), this.traceFile);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
