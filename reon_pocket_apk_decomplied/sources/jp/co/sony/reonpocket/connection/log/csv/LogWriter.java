package jp.co.sony.reonpocket.connection.log.csv;

import java.io.Writer;
import java.util.List;
import java.util.Map;
import jp.co.sony.reonpocket.connection.log.entity.LogEntity;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.QuoteMode;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001a\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007*\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/csv/LogWriter;", "Ljp/co/sony/reonpocket/connection/log/csv/CSVWriter;", "Ljp/co/sony/reonpocket/connection/log/entity/LogEntity;", "aWriter", "Ljava/io/Writer;", "(Ljava/io/Writer;)V", "encode", "", "Ljp/co/sony/reonpocket/connection/log/csv/LogColumn;", "", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LogCSV.kt */
public final class LogWriter extends CSVWriter<LogEntity> {
    public static final int $stable = 0;
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final CSVFormat FORMAT;
    /* access modifiers changed from: private */
    public static final List<LogColumn> HEADERS = ArraysKt.toList((T[]) LogColumn.values());

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/csv/LogWriter$Companion;", "", "()V", "FORMAT", "Lorg/apache/commons/csv/CSVFormat;", "getFORMAT", "()Lorg/apache/commons/csv/CSVFormat;", "HEADERS", "", "Ljp/co/sony/reonpocket/connection/log/csv/LogColumn;", "getHEADERS", "()Ljava/util/List;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: LogCSV.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CSVFormat getFORMAT() {
            return LogWriter.FORMAT;
        }

        public final List<LogColumn> getHEADERS() {
            return LogWriter.HEADERS;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LogWriter(Writer writer) {
        super(writer, HEADERS, FORMAT);
        Intrinsics.checkNotNullParameter(writer, "aWriter");
    }

    static {
        CSVFormat withQuoteMode = CSVFormat.DEFAULT.withRecordSeparator("\n").withEscape((char) Typography.quote).withQuoteMode(QuoteMode.NONE);
        Intrinsics.checkNotNullExpressionValue(withQuoteMode, "withQuoteMode(...)");
        FORMAT = withQuoteMode;
    }

    public Map<LogColumn, String> encode(LogEntity logEntity) {
        Intrinsics.checkNotNullParameter(logEntity, "<this>");
        return MapsKt.mapOf(TuplesKt.to(LogColumn.DATE, logEntity.getDate()), TuplesKt.to(LogColumn.OWNER_ID, logEntity.getOwnerId()), TuplesKt.to(LogColumn.FW_VER, logEntity.getFwVer()), TuplesKt.to(LogColumn.APP_VER, logEntity.getAppVer()), TuplesKt.to(LogColumn.LOG_TYPE, logEntity.getLogType()), TuplesKt.to(LogColumn.OPERATION, logEntity.getOperation()), TuplesKt.to(LogColumn.MODE, logEntity.getMode()), TuplesKt.to(LogColumn.MODE_COOL_WARM_SETTING, logEntity.getModeCoolHeatSetting()), TuplesKt.to(LogColumn.COOL_STATUS, logEntity.getCoolStatus()), TuplesKt.to(LogColumn.COOL_TEMP, logEntity.getCoolTemp()), TuplesKt.to(LogColumn.COOL_OPTION, logEntity.getCoolOption()), TuplesKt.to(LogColumn.BOOST_TEMP_OFFSET, logEntity.getBoostTempOffset()), TuplesKt.to(LogColumn.BOOST_OPERATION_STATUS, logEntity.getBoostOperationStatus()), TuplesKt.to(LogColumn.SMART_COOL_SPEC_TEMP, logEntity.getSmartCoolSpecTemp()), TuplesKt.to(LogColumn.SMART_COOL_TARGET_TEMP, logEntity.getSmartCoolTargetTemp()), TuplesKt.to(LogColumn.SMART_COOL_TEMP_PREF, logEntity.getSmartCoolTempPref()), TuplesKt.to(LogColumn.WARM_STATUS, logEntity.getWarmStatus()), TuplesKt.to(LogColumn.WARM_TEMP, logEntity.getWarmTemp()), TuplesKt.to(LogColumn.WARM_OPTION, logEntity.getWarmOption()), TuplesKt.to(LogColumn.SMART_WARM_SPEC_TEMP, logEntity.getSmartWarmSpecTemp()), TuplesKt.to(LogColumn.SMART_WARM_TARGET_TEMP, logEntity.getSmartWarmTargetTemp()), TuplesKt.to(LogColumn.SMART_WARM_TEMP_PREF, logEntity.getSmartWarmTempPref()), TuplesKt.to(LogColumn.TAG_INVALID, logEntity.getTagInvalid()), TuplesKt.to(LogColumn.DURATION_STATUS, logEntity.getDurationStatus()), TuplesKt.to(LogColumn.COOL_WARM_CHANGE_OPERATION_STATUS_1, logEntity.getCoolWarmChangeOperationStatus1()), TuplesKt.to(LogColumn.COOL_WARM_CHANGE_OPERATION_STATUS_2, logEntity.getCoolWarmChangeOperationStatus2()), TuplesKt.to(LogColumn.FAN_STATUS, logEntity.getFanStatus()), TuplesKt.to(LogColumn.FAN_STEP, logEntity.getFanStep()), TuplesKt.to(LogColumn.SYSTEM_STATUS, logEntity.getSystemStatus()), TuplesKt.to(LogColumn.BATTERY_LEVEL, logEntity.getBatteryLevel()), TuplesKt.to(LogColumn.TEC_TEMP, logEntity.getTecTemp()), TuplesKt.to(LogColumn.TEC2_TEMP, logEntity.getTec2Temp()), TuplesKt.to(LogColumn.FIN_TEMP, logEntity.getFinTemp()), TuplesKt.to(LogColumn.CLOTHES_TEMP_A, logEntity.getClothesTempA()), TuplesKt.to(LogColumn.CLOTHES_TEMP_B, logEntity.getClothesTempB()), TuplesKt.to(LogColumn.CLOTHES_HUMI_B, logEntity.getClothesHumiB()), TuplesKt.to(LogColumn.BODY_SURFACE_TEMP, logEntity.getBodySurfaceTemp()), TuplesKt.to(LogColumn.TEC_OUTPUT, logEntity.getTecOutput()), TuplesKt.to(LogColumn.TEC2_OUTPUT, logEntity.getTec2Output()), TuplesKt.to(LogColumn.FAN_OUTPUT, logEntity.getFanOutput()), TuplesKt.to(LogColumn.CHARGE_STATUS, logEntity.getChargeStatus()), TuplesKt.to(LogColumn.USB_CONNECT_STATUS, logEntity.getUsbConnectStatus()), TuplesKt.to(LogColumn.ACTIVITY, logEntity.getActivity()), TuplesKt.to(LogColumn.SKIN_CONTACT_STATUS, logEntity.getSkinContactStatus()), TuplesKt.to(LogColumn.ANOMALY_DETECTION_TYPE, logEntity.getAnomalyDetectionType()), TuplesKt.to(LogColumn.SERVICE_INFO_PLAN, logEntity.getServiceInfoPlan()), TuplesKt.to(LogColumn.SERVICE_INFO_STATUS, logEntity.getServiceInfoStatus()), TuplesKt.to(LogColumn.SERVICE_INFO_AVAILABLE_TIME, logEntity.getServiceInfoAvailableTime()), TuplesKt.to(LogColumn.TAG_TEMP, logEntity.getTagTemp()), TuplesKt.to(LogColumn.TAG_HUMI, logEntity.getTagHumi()), TuplesKt.to(LogColumn.TAG_ALS, logEntity.getTagALS()), TuplesKt.to(LogColumn.TAG_PS, logEntity.getTagPS()), TuplesKt.to(LogColumn.TAG_CARRY_STATUS, logEntity.getTagCarryStatus()), TuplesKt.to(LogColumn.TAG_ALS_STATUS, logEntity.getTagALSStatus()), TuplesKt.to(LogColumn.TAG_PS_STATUS, logEntity.getTagPSStatus()), TuplesKt.to(LogColumn.TAG_TEMP_CORRECTION, logEntity.getTagTempCollection()), TuplesKt.to(LogColumn.TAG_HUMI_CORRECTION, logEntity.getTagHumiCollection()), TuplesKt.to(LogColumn.COOL_SWITCHING_TEMP, logEntity.getCoolSwitchingTemp()), TuplesKt.to(LogColumn.COOL_SWITCHING_HUMI, logEntity.getCoolSwitchingHumi()), TuplesKt.to(LogColumn.WARM_SWITCHING_TEMP, logEntity.getWarmSwitchingTemp()), TuplesKt.to(LogColumn.WARM_SWITCHING_HUMI, logEntity.getWarmSwitchingHumi()));
    }
}
