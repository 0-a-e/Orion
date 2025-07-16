package jp.co.sony.reonpocket.connection.log.csv;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\bA\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bD¨\u0006E"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/csv/LogColumn;", "", "Ljp/co/sony/reonpocket/connection/log/csv/Column;", "header", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getHeader", "()Ljava/lang/String;", "DATE", "OWNER_ID", "FW_VER", "APP_VER", "LOG_TYPE", "OPERATION", "MODE", "MODE_COOL_WARM_SETTING", "COOL_STATUS", "COOL_TEMP", "COOL_OPTION", "BOOST_TEMP_OFFSET", "BOOST_OPERATION_STATUS", "SMART_COOL_SPEC_TEMP", "SMART_COOL_TARGET_TEMP", "SMART_COOL_TEMP_PREF", "WARM_STATUS", "WARM_TEMP", "WARM_OPTION", "SMART_WARM_SPEC_TEMP", "SMART_WARM_TARGET_TEMP", "SMART_WARM_TEMP_PREF", "TAG_INVALID", "DURATION_STATUS", "COOL_WARM_CHANGE_OPERATION_STATUS_1", "COOL_WARM_CHANGE_OPERATION_STATUS_2", "FAN_STATUS", "FAN_STEP", "SYSTEM_STATUS", "BATTERY_LEVEL", "TEC_TEMP", "TEC2_TEMP", "FIN_TEMP", "CLOTHES_TEMP_A", "CLOTHES_TEMP_B", "CLOTHES_HUMI_B", "BODY_SURFACE_TEMP", "TEC_OUTPUT", "TEC2_OUTPUT", "FAN_OUTPUT", "CHARGE_STATUS", "USB_CONNECT_STATUS", "ACTIVITY", "SKIN_CONTACT_STATUS", "SERVICE_INFO_PLAN", "SERVICE_INFO_STATUS", "SERVICE_INFO_AVAILABLE_TIME", "ANOMALY_DETECTION_TYPE", "TAG_TEMP", "TAG_HUMI", "TAG_ALS", "TAG_PS", "TAG_CARRY_STATUS", "TAG_ALS_STATUS", "TAG_PS_STATUS", "TAG_TEMP_CORRECTION", "TAG_HUMI_CORRECTION", "COOL_SWITCHING_TEMP", "COOL_SWITCHING_HUMI", "WARM_SWITCHING_TEMP", "WARM_SWITCHING_HUMI", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LogCSV.kt */
public enum LogColumn implements Column {
    DATE("Date"),
    OWNER_ID("Owner ID"),
    FW_VER("FW ver."),
    APP_VER("App ver."),
    LOG_TYPE("LogType"),
    OPERATION("Operation"),
    MODE("Mode"),
    MODE_COOL_WARM_SETTING("Mode Cool Warm Setting"),
    COOL_STATUS("Cool Status"),
    COOL_TEMP("Cool Temp"),
    COOL_OPTION("Cool Option"),
    BOOST_TEMP_OFFSET("Boost Temp Offset"),
    BOOST_OPERATION_STATUS("Boost Operation Status"),
    SMART_COOL_SPEC_TEMP("Smart Cool Specified Temp"),
    SMART_COOL_TARGET_TEMP("Smart Cool Target Temp"),
    SMART_COOL_TEMP_PREF("Smart Cool Temp Preference"),
    WARM_STATUS("Warm Status"),
    WARM_TEMP("Warm Temp"),
    WARM_OPTION("Warm Option"),
    SMART_WARM_SPEC_TEMP("Smart Warm Specified Temp"),
    SMART_WARM_TARGET_TEMP("Smart Warm Target Temp"),
    SMART_WARM_TEMP_PREF("Smart Warm Temp Preference"),
    TAG_INVALID("func limit by tag invalid"),
    DURATION_STATUS("duration status"),
    COOL_WARM_CHANGE_OPERATION_STATUS_1("Cool Warm change operation status 1"),
    COOL_WARM_CHANGE_OPERATION_STATUS_2("Cool Warm change operation status 2"),
    FAN_STATUS("Fan Status"),
    FAN_STEP("Fan Step"),
    SYSTEM_STATUS("System Status"),
    BATTERY_LEVEL("Battery Level"),
    TEC_TEMP("Tec Temp"),
    TEC2_TEMP("Tec 2 Temp"),
    FIN_TEMP("Fin Temp"),
    CLOTHES_TEMP_A("Clothes Temp A"),
    CLOTHES_TEMP_B("Clothes Temp B"),
    CLOTHES_HUMI_B("Clothes Humi B"),
    BODY_SURFACE_TEMP("Body Surface Temp"),
    TEC_OUTPUT("Tec Output"),
    TEC2_OUTPUT("Tec 2 Output"),
    FAN_OUTPUT("Fan Output"),
    CHARGE_STATUS("Charge Status"),
    USB_CONNECT_STATUS("USB Connect Status"),
    ACTIVITY("Activity"),
    SKIN_CONTACT_STATUS("Skin Contact Status"),
    SERVICE_INFO_PLAN("Service Info Plan"),
    SERVICE_INFO_STATUS("Service Info Status"),
    SERVICE_INFO_AVAILABLE_TIME("Service Info Available Time"),
    ANOMALY_DETECTION_TYPE("Anomaly Detection Type"),
    TAG_TEMP("Tag Temp"),
    TAG_HUMI("Tag Humi"),
    TAG_ALS("Tag ALS"),
    TAG_PS("Tag PS"),
    TAG_CARRY_STATUS("Tag Carry Status"),
    TAG_ALS_STATUS("Tag ALS Status"),
    TAG_PS_STATUS("Tag PS Status"),
    TAG_TEMP_CORRECTION("Tag Temp Correction"),
    TAG_HUMI_CORRECTION("Tag Humi Correction"),
    COOL_SWITCHING_TEMP("Cool Switching Temp"),
    COOL_SWITCHING_HUMI("Cool Switching Humi"),
    WARM_SWITCHING_TEMP("Warm Switching Temp"),
    WARM_SWITCHING_HUMI("Warm Switching Humi");
    
    private final String header;

    public static EnumEntries<LogColumn> getEntries() {
        return $ENTRIES;
    }

    private LogColumn(String str) {
        this.header = str;
    }

    public String getHeader() {
        return this.header;
    }

    static {
        LogColumn[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
