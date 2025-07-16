package jp.co.sony.reonpocket.connection.log.constant;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/constant/LogTypeCode;", "", "code", "", "summary", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "DEVICE_MODE_CHANGE_1", "FAN", "SYSTEM", "STATUS_MONITORING_15SEC_1", "STATUS_MONITORING_60SEC", "PAID_MEMBERSHIP_STATUS", "STATUS_MONITORING_15SEC_2", "TAG_STATUS", "DEVICE_MODE_CHANGE_2", "ANOMALY_DETECTION_TYPE", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LogConstant.kt */
public enum LogTypeCode {
    DEVICE_MODE_CHANGE_1(0, "Device Mode Change 1"),
    FAN(1, "Air Changed"),
    SYSTEM(2, "System Changed"),
    STATUS_MONITORING_15SEC_1(3, "Status Monitoring 15sec 1"),
    STATUS_MONITORING_60SEC(4, "Status Monitoring 60sec"),
    PAID_MEMBERSHIP_STATUS(5, "Paid Membership Status"),
    STATUS_MONITORING_15SEC_2(6, "Status Monitoring 15sec 2"),
    TAG_STATUS(7, "REON Tag Status"),
    DEVICE_MODE_CHANGE_2(8, "Device Mode Change 2"),
    ANOMALY_DETECTION_TYPE(9, "Anomaly Detection Type");
    
    private final int code;
    private final String summary;

    public static EnumEntries<LogTypeCode> getEntries() {
        return $ENTRIES;
    }

    private LogTypeCode(int i, String str) {
        this.code = i;
        this.summary = str;
    }

    public final int getCode() {
        return this.code;
    }

    static {
        LogTypeCode[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
