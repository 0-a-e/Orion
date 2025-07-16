package jp.co.sony.reonpocket.data.entity.tag;

import com.google.firebase.messaging.Constants;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import jp.co.sony.reonpocket.constant.TagCarryAroundStatus;
import jp.co.sony.reonpocket.constant.TagCorrectionStatus;
import jp.co.sony.reonpocket.constant.TagIlluminationStatus;
import jp.co.sony.reonpocket.constant.TagProximityStatus;
import jp.co.sony.reonpocket.modules.pairing.view.PairingActivityKt;
import jp.co.sony.reonpocket.util.DataEntityHelper;
import jp.co.sony.reonpocket.util.JSONObjectExtensionKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b&\b\u0007\u0018\u0000 92\u00020\u0001:\u00039:;Bµ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u001bJ\u0006\u00108\u001a\u00020\u0016R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001f\u0010\u001dR\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b \u0010\u001dR\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b!\u0010\u001dR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0013\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010-\u001a\u0004\b.\u0010,R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010-\u001a\u0004\b1\u0010,R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b4\u0010\u001dR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b5\u0010#R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b6\u0010*R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010-\u001a\u0004\b7\u0010,¨\u0006<"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity;", "", "fwVersionCode", "", "formatVersion", "sequenceNumber", "temperature", "", "humidity", "illumination", "proximity", "tempCorrection", "Ljp/co/sony/reonpocket/constant/TagCorrectionStatus;", "humiCorrection", "carryAroundStatus", "Ljp/co/sony/reonpocket/constant/TagCarryAroundStatus;", "illuminationStatus", "Ljp/co/sony/reonpocket/constant/TagIlluminationStatus;", "proximityStatus", "Ljp/co/sony/reonpocket/constant/TagProximityStatus;", "batteryLevel", "serialNo", "", "bdAddress", "accelerationXAxis", "accelerationYAxis", "accelerationZAxis", "(IILjava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljp/co/sony/reonpocket/constant/TagCorrectionStatus;Ljp/co/sony/reonpocket/constant/TagCorrectionStatus;Ljp/co/sony/reonpocket/constant/TagCarryAroundStatus;Ljp/co/sony/reonpocket/constant/TagIlluminationStatus;Ljp/co/sony/reonpocket/constant/TagProximityStatus;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAccelerationXAxis", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAccelerationYAxis", "getAccelerationZAxis", "getBatteryLevel", "getBdAddress", "()Ljava/lang/String;", "getCarryAroundStatus", "()Ljp/co/sony/reonpocket/constant/TagCarryAroundStatus;", "getFormatVersion", "()I", "getFwVersionCode", "getHumiCorrection", "()Ljp/co/sony/reonpocket/constant/TagCorrectionStatus;", "getHumidity", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getIllumination", "getIlluminationStatus", "()Ljp/co/sony/reonpocket/constant/TagIlluminationStatus;", "getProximity", "getProximityStatus", "()Ljp/co/sony/reonpocket/constant/TagProximityStatus;", "getSequenceNumber", "getSerialNo", "getTempCorrection", "getTemperature", "toJSONString", "Companion", "FormatVersion", "JsonKey", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagDataEntity.kt */
public final class TagDataEntity {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final ArrayList<String> DECRYPTION_KEY = CollectionsKt.arrayListOf("D2", "23", "EC", "09", "13", "84", "F9", "96", "31", "45", "FC", "F2", "CF", "FA", "34", "41");
    public static final int NOT_RECEIVED_VALUE = 0;
    public static final int TAG_ALS_UNKNOWN_VALUE = 65535;
    public static final int TAG_PS_UNKNOWN_VALUE = 65535;
    private final Integer accelerationXAxis;
    private final Integer accelerationYAxis;
    private final Integer accelerationZAxis;
    private final Integer batteryLevel;
    private final String bdAddress;
    private final TagCarryAroundStatus carryAroundStatus;
    private final int formatVersion;
    private final int fwVersionCode;
    private final TagCorrectionStatus humiCorrection;
    private final Float humidity;
    private final Float illumination;
    private final TagIlluminationStatus illuminationStatus;
    private final Float proximity;
    private final TagProximityStatus proximityStatus;
    private final Integer sequenceNumber;
    private final String serialNo;
    private final TagCorrectionStatus tempCorrection;
    private final Float temperature;

    public TagDataEntity(int i, int i2, Integer num, Float f, Float f2, Float f3, Float f4, TagCorrectionStatus tagCorrectionStatus, TagCorrectionStatus tagCorrectionStatus2, TagCarryAroundStatus tagCarryAroundStatus, TagIlluminationStatus tagIlluminationStatus, TagProximityStatus tagProximityStatus, Integer num2, String str, String str2, Integer num3, Integer num4, Integer num5) {
        this.fwVersionCode = i;
        this.formatVersion = i2;
        this.sequenceNumber = num;
        this.temperature = f;
        this.humidity = f2;
        this.illumination = f3;
        this.proximity = f4;
        this.tempCorrection = tagCorrectionStatus;
        this.humiCorrection = tagCorrectionStatus2;
        this.carryAroundStatus = tagCarryAroundStatus;
        this.illuminationStatus = tagIlluminationStatus;
        this.proximityStatus = tagProximityStatus;
        this.batteryLevel = num2;
        this.serialNo = str;
        this.bdAddress = str2;
        this.accelerationXAxis = num3;
        this.accelerationYAxis = num4;
        this.accelerationZAxis = num5;
    }

    public final int getFwVersionCode() {
        return this.fwVersionCode;
    }

    public final int getFormatVersion() {
        return this.formatVersion;
    }

    public final Integer getSequenceNumber() {
        return this.sequenceNumber;
    }

    public final Float getTemperature() {
        return this.temperature;
    }

    public final Float getHumidity() {
        return this.humidity;
    }

    public final Float getIllumination() {
        return this.illumination;
    }

    public final Float getProximity() {
        return this.proximity;
    }

    public final TagCorrectionStatus getTempCorrection() {
        return this.tempCorrection;
    }

    public final TagCorrectionStatus getHumiCorrection() {
        return this.humiCorrection;
    }

    public final TagCarryAroundStatus getCarryAroundStatus() {
        return this.carryAroundStatus;
    }

    public final TagIlluminationStatus getIlluminationStatus() {
        return this.illuminationStatus;
    }

    public final TagProximityStatus getProximityStatus() {
        return this.proximityStatus;
    }

    public final Integer getBatteryLevel() {
        return this.batteryLevel;
    }

    public final String getSerialNo() {
        return this.serialNo;
    }

    public final String getBdAddress() {
        return this.bdAddress;
    }

    public final Integer getAccelerationXAxis() {
        return this.accelerationXAxis;
    }

    public final Integer getAccelerationYAxis() {
        return this.accelerationYAxis;
    }

    public final Integer getAccelerationZAxis() {
        return this.accelerationZAxis;
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0012R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity$Companion;", "", "()V", "DECRYPTION_KEY", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "NOT_RECEIVED_VALUE", "", "TAG_ALS_UNKNOWN_VALUE", "TAG_PS_UNKNOWN_VALUE", "decryptionData", "", "dataArray", "from", "Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity;", "data", "jsonObj", "Lorg/json/JSONObject;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TagDataEntity.kt */
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* compiled from: TagDataEntity.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
            static {
                /*
                    jp.co.sony.reonpocket.data.entity.tag.TagDataEntity$FormatVersion[] r0 = jp.co.sony.reonpocket.data.entity.tag.TagDataEntity.FormatVersion.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    jp.co.sony.reonpocket.data.entity.tag.TagDataEntity$FormatVersion r1 = jp.co.sony.reonpocket.data.entity.tag.TagDataEntity.FormatVersion.CONNECTION_5     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    jp.co.sony.reonpocket.data.entity.tag.TagDataEntity$FormatVersion r1 = jp.co.sony.reonpocket.data.entity.tag.TagDataEntity.FormatVersion.DATA_6     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    jp.co.sony.reonpocket.data.entity.tag.TagDataEntity$FormatVersion r1 = jp.co.sony.reonpocket.data.entity.tag.TagDataEntity.FormatVersion.CONNECTION_7     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    jp.co.sony.reonpocket.data.entity.tag.TagDataEntity$FormatVersion r1 = jp.co.sony.reonpocket.data.entity.tag.TagDataEntity.FormatVersion.DATA_8     // Catch:{ NoSuchFieldError -> 0x002b }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                    r2 = 4
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
                L_0x002b:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.data.entity.tag.TagDataEntity.Companion.WhenMappings.<clinit>():void");
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TagDataEntity from(byte[] bArr) {
            FormatVersion formatVersion;
            int i;
            String str;
            String str2;
            Integer num;
            TagProximityStatus tagProximityStatus;
            TagIlluminationStatus tagIlluminationStatus;
            TagCarryAroundStatus tagCarryAroundStatus;
            TagCorrectionStatus tagCorrectionStatus;
            TagCorrectionStatus tagCorrectionStatus2;
            Float f;
            Float f2;
            Float f3;
            Float f4;
            Integer num2;
            TagIlluminationStatus tagIlluminationStatus2;
            TagProximityStatus tagProximityStatus2;
            TagCorrectionStatus tagCorrectionStatus3;
            TagCorrectionStatus tagCorrectionStatus4;
            int i2;
            TagCarryAroundStatus tagCarryAroundStatus2;
            TagIlluminationStatus tagIlluminationStatus3;
            TagProximityStatus tagProximityStatus3;
            TagCorrectionStatus tagCorrectionStatus5;
            TagCorrectionStatus tagCorrectionStatus6;
            TagCarryAroundStatus tagCarryAroundStatus3;
            TagCorrectionStatus tagCorrectionStatus7;
            TagCorrectionStatus tagCorrectionStatus8;
            int i3;
            TagCarryAroundStatus tagCarryAroundStatus4;
            TagIlluminationStatus tagIlluminationStatus4;
            TagProximityStatus tagProximityStatus4;
            TagCorrectionStatus tagCorrectionStatus9;
            TagCorrectionStatus tagCorrectionStatus10;
            TagCarryAroundStatus tagCarryAroundStatus5;
            TagIlluminationStatus tagIlluminationStatus5;
            TagProximityStatus tagProximityStatus5;
            byte[] bArr2 = bArr;
            Intrinsics.checkNotNullParameter(bArr2, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
            Integer intValue$default = DataEntityHelper.getIntValue$default(DataEntityHelper.INSTANCE, bArr, DataEntityHelper.DataFormat.FORMAT_UINT8, 0, (ByteOrder) null, 8, (Object) null);
            int intValue = intValue$default != null ? intValue$default.intValue() : 0;
            Integer intValue$default2 = DataEntityHelper.getIntValue$default(DataEntityHelper.INSTANCE, bArr, DataEntityHelper.DataFormat.FORMAT_UINT8, 1, (ByteOrder) null, 8, (Object) null);
            int intValue2 = intValue$default2 != null ? intValue$default2.intValue() : 0;
            FormatVersion[] values = FormatVersion.values();
            int length = values.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    formatVersion = null;
                    break;
                }
                formatVersion = values[i4];
                if (formatVersion.getKey() == intValue2) {
                    break;
                }
                i4++;
            }
            if (formatVersion == null) {
                i = -1;
            } else {
                i = WhenMappings.$EnumSwitchMapping$0[formatVersion.ordinal()];
            }
            if (i == 1) {
                Integer num3 = 0;
                String str3 = "toString(...)";
                Integer intValue$default3 = DataEntityHelper.getIntValue$default(DataEntityHelper.INSTANCE, bArr, DataEntityHelper.DataFormat.FORMAT_UINT8, 2, (ByteOrder) null, 8, (Object) null);
                Integer num4 = intValue$default3 == null ? null : intValue$default3;
                DataEntityHelper dataEntityHelper = DataEntityHelper.INSTANCE;
                DataEntityHelper.DataFormat dataFormat = DataEntityHelper.DataFormat.FORMAT_SINT16;
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                Intrinsics.checkNotNullExpressionValue(byteOrder, "LITTLE_ENDIAN");
                Integer intValue3 = dataEntityHelper.getIntValue(bArr2, dataFormat, 3, byteOrder);
                Float valueOf = Float.valueOf((float) (intValue3 != null ? intValue3.intValue() : 0));
                DataEntityHelper dataEntityHelper2 = DataEntityHelper.INSTANCE;
                DataEntityHelper.DataFormat dataFormat2 = DataEntityHelper.DataFormat.FORMAT_SINT16;
                ByteOrder byteOrder2 = ByteOrder.LITTLE_ENDIAN;
                Intrinsics.checkNotNullExpressionValue(byteOrder2, "LITTLE_ENDIAN");
                Integer intValue4 = dataEntityHelper2.getIntValue(bArr2, dataFormat2, 5, byteOrder2);
                Float valueOf2 = Float.valueOf((float) (intValue4 != null ? intValue4.intValue() : 0));
                DataEntityHelper dataEntityHelper3 = DataEntityHelper.INSTANCE;
                DataEntityHelper.DataFormat dataFormat3 = DataEntityHelper.DataFormat.FORMAT_UINT16;
                ByteOrder byteOrder3 = ByteOrder.LITTLE_ENDIAN;
                Intrinsics.checkNotNullExpressionValue(byteOrder3, "LITTLE_ENDIAN");
                Integer intValue5 = dataEntityHelper3.getIntValue(bArr2, dataFormat3, 7, byteOrder3);
                int intValue6 = intValue5 != null ? intValue5.intValue() : 0;
                Float valueOf3 = Float.valueOf((float) (intValue6 & 16383));
                TagIlluminationStatus[] values2 = TagIlluminationStatus.values();
                int length2 = values2.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length2) {
                        tagIlluminationStatus2 = null;
                        break;
                    }
                    tagIlluminationStatus2 = values2[i5];
                    if (tagIlluminationStatus2.getCode() == ((intValue6 & CpioConstants.C_ISSOCK) >> 14)) {
                        break;
                    }
                    i5++;
                }
                if (tagIlluminationStatus2 == null) {
                    tagIlluminationStatus2 = TagIlluminationStatus.UNKNOWN;
                }
                TagIlluminationStatus tagIlluminationStatus6 = tagIlluminationStatus2;
                DataEntityHelper dataEntityHelper4 = DataEntityHelper.INSTANCE;
                DataEntityHelper.DataFormat dataFormat4 = DataEntityHelper.DataFormat.FORMAT_UINT16;
                ByteOrder byteOrder4 = ByteOrder.LITTLE_ENDIAN;
                Intrinsics.checkNotNullExpressionValue(byteOrder4, "LITTLE_ENDIAN");
                Integer intValue7 = dataEntityHelper4.getIntValue(bArr2, dataFormat4, 9, byteOrder4);
                int intValue8 = intValue7 != null ? intValue7.intValue() : 0;
                Float valueOf4 = Float.valueOf((float) (intValue8 & 16383));
                TagProximityStatus[] values3 = TagProximityStatus.values();
                int length3 = values3.length;
                int i6 = 0;
                while (true) {
                    if (i6 >= length3) {
                        tagProximityStatus2 = null;
                        break;
                    }
                    tagProximityStatus2 = values3[i6];
                    if (tagProximityStatus2.getCode() == ((intValue8 & CpioConstants.C_ISSOCK) >> 14)) {
                        break;
                    }
                    i6++;
                }
                if (tagProximityStatus2 == null) {
                    tagProximityStatus2 = TagProximityStatus.UNKNOWN;
                }
                TagProximityStatus tagProximityStatus6 = tagProximityStatus2;
                Integer intValue$default4 = DataEntityHelper.getIntValue$default(DataEntityHelper.INSTANCE, bArr, DataEntityHelper.DataFormat.FORMAT_UINT8, 11, (ByteOrder) null, 8, (Object) null);
                TagCorrectionStatus[] values4 = TagCorrectionStatus.values();
                int length4 = values4.length;
                int i7 = 0;
                while (true) {
                    if (i7 >= length4) {
                        tagCorrectionStatus3 = null;
                        break;
                    }
                    tagCorrectionStatus3 = values4[i7];
                    if (intValue$default4 != null && tagCorrectionStatus3.getCode() == (intValue$default4.intValue() & 1)) {
                        break;
                    }
                    i7++;
                }
                if (tagCorrectionStatus3 == null) {
                    tagCorrectionStatus3 = TagCorrectionStatus.NO_CORRECTION;
                }
                TagCorrectionStatus tagCorrectionStatus11 = tagCorrectionStatus3;
                TagCorrectionStatus[] values5 = TagCorrectionStatus.values();
                int length5 = values5.length;
                int i8 = 0;
                while (true) {
                    if (i8 >= length5) {
                        tagCorrectionStatus4 = null;
                        break;
                    }
                    tagCorrectionStatus4 = values5[i8];
                    if (intValue$default4 != null && tagCorrectionStatus4.getCode() == ((intValue$default4.intValue() & 2) >> 1)) {
                        break;
                    }
                    i8++;
                }
                if (tagCorrectionStatus4 == null) {
                    tagCorrectionStatus4 = TagCorrectionStatus.NO_CORRECTION;
                }
                TagCorrectionStatus tagCorrectionStatus12 = tagCorrectionStatus4;
                TagCarryAroundStatus[] values6 = TagCarryAroundStatus.values();
                int length6 = values6.length;
                int i9 = 0;
                while (true) {
                    if (i9 >= length6) {
                        i2 = 2;
                        tagCarryAroundStatus2 = null;
                        break;
                    }
                    tagCarryAroundStatus2 = values6[i9];
                    if (intValue$default4 != null) {
                        i2 = 2;
                        if (tagCarryAroundStatus2.getCode() == ((intValue$default4.intValue() & 12) >> 2)) {
                            break;
                        }
                    }
                    i9++;
                }
                if (tagCarryAroundStatus2 == null) {
                    tagCarryAroundStatus2 = TagCarryAroundStatus.UNKNOWN;
                }
                TagCarryAroundStatus tagCarryAroundStatus6 = tagCarryAroundStatus2;
                Integer intValue$default5 = DataEntityHelper.getIntValue$default(DataEntityHelper.INSTANCE, bArr, DataEntityHelper.DataFormat.FORMAT_UINT8, 12, (ByteOrder) null, 8, (Object) null);
                if (intValue$default5 != null) {
                    num3 = intValue$default5;
                }
                int i10 = i2;
                Integer[] intArray$default = DataEntityHelper.getIntArray$default(DataEntityHelper.INSTANCE, bArr, DataEntityHelper.DataFormat.FORMAT_UINT8, 13, 8, (ByteOrder) null, 16, (Object) null);
                if (intArray$default == null) {
                    intArray$default = new Integer[0];
                }
                String str4 = "";
                for (Object obj : ArraysKt.reversedArray((T[]) intArray$default)) {
                    String num5 = Integer.toString(((Number) obj).intValue(), CharsKt.checkRadix(16));
                    Intrinsics.checkNotNullExpressionValue(num5, str3);
                    Locale locale = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
                    String upperCase = num5.toUpperCase(locale);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    String substring = upperCase.substring(1, i10);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    str4 = str4 + substring;
                }
                String str5 = str3;
                String str6 = str4;
                Integer[] intArray$default2 = DataEntityHelper.getIntArray$default(DataEntityHelper.INSTANCE, bArr, DataEntityHelper.DataFormat.FORMAT_UINT8, 21, 6, (ByteOrder) null, 16, (Object) null);
                if (intArray$default2 == null) {
                    intArray$default2 = new Integer[0];
                }
                String str7 = "";
                for (Object obj2 : ArraysKt.reversedArray((T[]) intArray$default2)) {
                    String num6 = Integer.toString(((Number) obj2).intValue(), CharsKt.checkRadix(16));
                    Intrinsics.checkNotNullExpressionValue(num6, str5);
                    Locale locale2 = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(locale2, "ROOT");
                    String upperCase2 = num6.toUpperCase(locale2);
                    Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                    String format = String.format(":%2s", Arrays.copyOf(new Object[]{upperCase2}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    str7 = str7 + StringsKt.replace$default(format, " ", "0", false, 4, (Object) null);
                }
                if (str7.length() > 0) {
                    str7 = str7.substring(1);
                    Intrinsics.checkNotNullExpressionValue(str7, "substring(...)");
                }
                Unit unit = Unit.INSTANCE;
                str = str7;
                f4 = valueOf;
                f = valueOf4;
                tagProximityStatus = tagProximityStatus6;
                tagCorrectionStatus2 = tagCorrectionStatus11;
                num2 = num4;
                tagCarryAroundStatus = tagCarryAroundStatus6;
                f3 = valueOf2;
                f2 = valueOf3;
                tagIlluminationStatus = tagIlluminationStatus6;
                tagCorrectionStatus = tagCorrectionStatus12;
                str2 = str6;
            } else if (i == 2) {
                Integer intValue$default6 = DataEntityHelper.getIntValue$default(DataEntityHelper.INSTANCE, bArr, DataEntityHelper.DataFormat.FORMAT_UINT8, 2, (ByteOrder) null, 8, (Object) null);
                num2 = intValue$default6 == null ? null : intValue$default6;
                DataEntityHelper dataEntityHelper5 = DataEntityHelper.INSTANCE;
                DataEntityHelper.DataFormat dataFormat5 = DataEntityHelper.DataFormat.FORMAT_SINT16;
                ByteOrder byteOrder5 = ByteOrder.LITTLE_ENDIAN;
                Intrinsics.checkNotNullExpressionValue(byteOrder5, "LITTLE_ENDIAN");
                Integer intValue9 = dataEntityHelper5.getIntValue(bArr2, dataFormat5, 3, byteOrder5);
                Float valueOf5 = Float.valueOf((float) (intValue9 != null ? intValue9.intValue() : 0));
                DataEntityHelper dataEntityHelper6 = DataEntityHelper.INSTANCE;
                DataEntityHelper.DataFormat dataFormat6 = DataEntityHelper.DataFormat.FORMAT_SINT16;
                ByteOrder byteOrder6 = ByteOrder.LITTLE_ENDIAN;
                Intrinsics.checkNotNullExpressionValue(byteOrder6, "LITTLE_ENDIAN");
                Integer intValue10 = dataEntityHelper6.getIntValue(bArr2, dataFormat6, 5, byteOrder6);
                Float valueOf6 = Float.valueOf((float) (intValue10 != null ? intValue10.intValue() : 0));
                DataEntityHelper dataEntityHelper7 = DataEntityHelper.INSTANCE;
                DataEntityHelper.DataFormat dataFormat7 = DataEntityHelper.DataFormat.FORMAT_UINT16;
                ByteOrder byteOrder7 = ByteOrder.LITTLE_ENDIAN;
                Intrinsics.checkNotNullExpressionValue(byteOrder7, "LITTLE_ENDIAN");
                Integer intValue11 = dataEntityHelper7.getIntValue(bArr2, dataFormat7, 7, byteOrder7);
                int intValue12 = intValue11 != null ? intValue11.intValue() : 0;
                Float valueOf7 = Float.valueOf((float) (intValue12 & 16383));
                TagIlluminationStatus[] values7 = TagIlluminationStatus.values();
                int length7 = values7.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length7) {
                        tagIlluminationStatus3 = null;
                        break;
                    }
                    tagIlluminationStatus3 = values7[i11];
                    if (tagIlluminationStatus3.getCode() == ((intValue12 & CpioConstants.C_ISSOCK) >> 14)) {
                        break;
                    }
                    i11++;
                }
                if (tagIlluminationStatus3 == null) {
                    tagIlluminationStatus3 = TagIlluminationStatus.UNKNOWN;
                }
                TagIlluminationStatus tagIlluminationStatus7 = tagIlluminationStatus3;
                DataEntityHelper dataEntityHelper8 = DataEntityHelper.INSTANCE;
                DataEntityHelper.DataFormat dataFormat8 = DataEntityHelper.DataFormat.FORMAT_UINT16;
                ByteOrder byteOrder8 = ByteOrder.LITTLE_ENDIAN;
                Intrinsics.checkNotNullExpressionValue(byteOrder8, "LITTLE_ENDIAN");
                Integer intValue13 = dataEntityHelper8.getIntValue(bArr2, dataFormat8, 9, byteOrder8);
                int intValue14 = intValue13 != null ? intValue13.intValue() : 0;
                Float valueOf8 = Float.valueOf((float) (intValue14 & 16383));
                TagProximityStatus[] values8 = TagProximityStatus.values();
                int length8 = values8.length;
                int i12 = 0;
                while (true) {
                    if (i12 >= length8) {
                        tagProximityStatus3 = null;
                        break;
                    }
                    tagProximityStatus3 = values8[i12];
                    if (tagProximityStatus3.getCode() == ((intValue14 & CpioConstants.C_ISSOCK) >> 14)) {
                        break;
                    }
                    i12++;
                }
                if (tagProximityStatus3 == null) {
                    tagProximityStatus3 = TagProximityStatus.UNKNOWN;
                }
                TagProximityStatus tagProximityStatus7 = tagProximityStatus3;
                Integer intValue$default7 = DataEntityHelper.getIntValue$default(DataEntityHelper.INSTANCE, bArr, DataEntityHelper.DataFormat.FORMAT_UINT8, 11, (ByteOrder) null, 8, (Object) null);
                TagCorrectionStatus[] values9 = TagCorrectionStatus.values();
                int length9 = values9.length;
                int i13 = 0;
                while (true) {
                    if (i13 >= length9) {
                        tagCorrectionStatus5 = null;
                        break;
                    }
                    tagCorrectionStatus5 = values9[i13];
                    if (intValue$default7 != null && tagCorrectionStatus5.getCode() == (intValue$default7.intValue() & 1)) {
                        break;
                    }
                    i13++;
                }
                if (tagCorrectionStatus5 == null) {
                    tagCorrectionStatus5 = TagCorrectionStatus.NO_CORRECTION;
                }
                TagCorrectionStatus tagCorrectionStatus13 = tagCorrectionStatus5;
                TagCorrectionStatus[] values10 = TagCorrectionStatus.values();
                int length10 = values10.length;
                int i14 = 0;
                while (true) {
                    if (i14 >= length10) {
                        tagCorrectionStatus6 = null;
                        break;
                    }
                    tagCorrectionStatus6 = values10[i14];
                    if (intValue$default7 != null && tagCorrectionStatus6.getCode() == ((intValue$default7.intValue() & 2) >> 1)) {
                        break;
                    }
                    i14++;
                }
                if (tagCorrectionStatus6 == null) {
                    tagCorrectionStatus6 = TagCorrectionStatus.NO_CORRECTION;
                }
                TagCorrectionStatus tagCorrectionStatus14 = tagCorrectionStatus6;
                TagCarryAroundStatus[] values11 = TagCarryAroundStatus.values();
                int length11 = values11.length;
                int i15 = 0;
                while (true) {
                    if (i15 >= length11) {
                        tagCarryAroundStatus3 = null;
                        break;
                    }
                    tagCarryAroundStatus3 = values11[i15];
                    if (intValue$default7 != null && tagCarryAroundStatus3.getCode() == ((intValue$default7.intValue() & 12) >> 2)) {
                        break;
                    }
                    i15++;
                }
                if (tagCarryAroundStatus3 == null) {
                    tagCarryAroundStatus3 = TagCarryAroundStatus.UNKNOWN;
                }
                TagCarryAroundStatus tagCarryAroundStatus7 = tagCarryAroundStatus3;
                Integer intValue$default8 = DataEntityHelper.getIntValue$default(DataEntityHelper.INSTANCE, bArr, DataEntityHelper.DataFormat.FORMAT_UINT8, 12, (ByteOrder) null, 8, (Object) null);
                if (intValue$default8 == null) {
                    intValue$default8 = null;
                }
                Unit unit2 = Unit.INSTANCE;
                num = intValue$default8;
                tagIlluminationStatus = tagIlluminationStatus7;
                tagProximityStatus = tagProximityStatus7;
                tagCarryAroundStatus = tagCarryAroundStatus7;
                str2 = null;
                str = null;
                f3 = valueOf6;
                f2 = valueOf7;
                tagCorrectionStatus = tagCorrectionStatus14;
                f4 = valueOf5;
                tagCorrectionStatus2 = tagCorrectionStatus13;
                f = valueOf8;
            } else if (i == 3) {
                num = 0;
                String str8 = "toString(...)";
                Integer intValue$default9 = DataEntityHelper.getIntValue$default(DataEntityHelper.INSTANCE, bArr, DataEntityHelper.DataFormat.FORMAT_UINT8, 2, (ByteOrder) null, 8, (Object) null);
                Integer num7 = intValue$default9 == null ? null : intValue$default9;
                DataEntityHelper dataEntityHelper9 = DataEntityHelper.INSTANCE;
                DataEntityHelper.DataFormat dataFormat9 = DataEntityHelper.DataFormat.FORMAT_SINT16;
                ByteOrder byteOrder9 = ByteOrder.LITTLE_ENDIAN;
                Intrinsics.checkNotNullExpressionValue(byteOrder9, "LITTLE_ENDIAN");
                Integer intValue15 = dataEntityHelper9.getIntValue(bArr2, dataFormat9, 3, byteOrder9);
                Float valueOf9 = Float.valueOf((float) (intValue15 != null ? intValue15.intValue() : 0));
                DataEntityHelper dataEntityHelper10 = DataEntityHelper.INSTANCE;
                DataEntityHelper.DataFormat dataFormat10 = DataEntityHelper.DataFormat.FORMAT_SINT16;
                ByteOrder byteOrder10 = ByteOrder.LITTLE_ENDIAN;
                Intrinsics.checkNotNullExpressionValue(byteOrder10, "LITTLE_ENDIAN");
                Integer intValue16 = dataEntityHelper10.getIntValue(bArr2, dataFormat10, 5, byteOrder10);
                Float valueOf10 = Float.valueOf((float) (intValue16 != null ? intValue16.intValue() : 0));
                DataEntityHelper dataEntityHelper11 = DataEntityHelper.INSTANCE;
                DataEntityHelper.DataFormat dataFormat11 = DataEntityHelper.DataFormat.FORMAT_UINT16;
                ByteOrder byteOrder11 = ByteOrder.LITTLE_ENDIAN;
                Intrinsics.checkNotNullExpressionValue(byteOrder11, "LITTLE_ENDIAN");
                Integer intValue17 = dataEntityHelper11.getIntValue(bArr2, dataFormat11, 7, byteOrder11);
                Float valueOf11 = Float.valueOf((float) (intValue17 != null ? intValue17.intValue() : 0));
                Integer intValue$default10 = DataEntityHelper.getIntValue$default(DataEntityHelper.INSTANCE, bArr, DataEntityHelper.DataFormat.FORMAT_UINT8, 9, (ByteOrder) null, 8, (Object) null);
                Float valueOf12 = Float.valueOf((float) (intValue$default10 != null ? intValue$default10.intValue() : 0));
                Integer intValue$default11 = DataEntityHelper.getIntValue$default(DataEntityHelper.INSTANCE, bArr, DataEntityHelper.DataFormat.FORMAT_UINT8, 10, (ByteOrder) null, 8, (Object) null);
                TagCorrectionStatus[] values12 = TagCorrectionStatus.values();
                int length12 = values12.length;
                int i16 = 0;
                while (true) {
                    if (i16 >= length12) {
                        tagCorrectionStatus7 = null;
                        break;
                    }
                    tagCorrectionStatus7 = values12[i16];
                    if (intValue$default11 != null && tagCorrectionStatus7.getCode() == (intValue$default11.intValue() & 1)) {
                        break;
                    }
                    i16++;
                }
                if (tagCorrectionStatus7 == null) {
                    tagCorrectionStatus7 = TagCorrectionStatus.NO_CORRECTION;
                }
                TagCorrectionStatus tagCorrectionStatus15 = tagCorrectionStatus7;
                TagCorrectionStatus[] values13 = TagCorrectionStatus.values();
                int length13 = values13.length;
                int i17 = 0;
                while (true) {
                    if (i17 >= length13) {
                        tagCorrectionStatus8 = null;
                        break;
                    }
                    tagCorrectionStatus8 = values13[i17];
                    if (intValue$default11 != null && tagCorrectionStatus8.getCode() == ((intValue$default11.intValue() & 2) >> 1)) {
                        break;
                    }
                    i17++;
                }
                if (tagCorrectionStatus8 == null) {
                    tagCorrectionStatus8 = TagCorrectionStatus.NO_CORRECTION;
                }
                TagCorrectionStatus tagCorrectionStatus16 = tagCorrectionStatus8;
                TagCarryAroundStatus[] values14 = TagCarryAroundStatus.values();
                int length14 = values14.length;
                int i18 = 0;
                while (true) {
                    if (i18 >= length14) {
                        i3 = 12;
                        tagCarryAroundStatus4 = null;
                        break;
                    }
                    tagCarryAroundStatus4 = values14[i18];
                    if (intValue$default11 != null) {
                        i3 = 12;
                        if (tagCarryAroundStatus4.getCode() == ((intValue$default11.intValue() & 12) >> 2)) {
                            break;
                        }
                    }
                    i18++;
                }
                if (tagCarryAroundStatus4 == null) {
                    tagCarryAroundStatus4 = TagCarryAroundStatus.UNKNOWN;
                }
                TagCarryAroundStatus tagCarryAroundStatus8 = tagCarryAroundStatus4;
                TagIlluminationStatus[] values15 = TagIlluminationStatus.values();
                int length15 = values15.length;
                int i19 = 0;
                while (true) {
                    if (i19 >= length15) {
                        tagIlluminationStatus4 = null;
                        break;
                    }
                    tagIlluminationStatus4 = values15[i19];
                    if (intValue$default11 != null) {
                        if (tagIlluminationStatus4.getCode() == ((intValue$default11.intValue() & 48) >> 4)) {
                            break;
                        }
                    }
                    i19++;
                }
                if (tagIlluminationStatus4 == null) {
                    tagIlluminationStatus4 = TagIlluminationStatus.UNKNOWN;
                }
                TagIlluminationStatus tagIlluminationStatus8 = tagIlluminationStatus4;
                TagProximityStatus[] values16 = TagProximityStatus.values();
                int length16 = values16.length;
                int i20 = 0;
                while (true) {
                    if (i20 >= length16) {
                        tagProximityStatus4 = null;
                        break;
                    }
                    tagProximityStatus4 = values16[i20];
                    if (intValue$default11 != null && tagProximityStatus4.getCode() == ((intValue$default11.intValue() & 192) >> 6)) {
                        break;
                    }
                    i20++;
                }
                if (tagProximityStatus4 == null) {
                    tagProximityStatus4 = TagProximityStatus.UNKNOWN;
                }
                TagProximityStatus tagProximityStatus8 = tagProximityStatus4;
                Integer intValue$default12 = DataEntityHelper.getIntValue$default(DataEntityHelper.INSTANCE, bArr, DataEntityHelper.DataFormat.FORMAT_UINT8, 11, (ByteOrder) null, 8, (Object) null);
                if (intValue$default12 != null) {
                    num = intValue$default12;
                }
                DataEntityHelper dataEntityHelper12 = DataEntityHelper.INSTANCE;
                DataEntityHelper.DataFormat dataFormat12 = DataEntityHelper.DataFormat.FORMAT_UINT32;
                ByteOrder byteOrder12 = ByteOrder.LITTLE_ENDIAN;
                Intrinsics.checkNotNullExpressionValue(byteOrder12, "LITTLE_ENDIAN");
                Integer intValue18 = dataEntityHelper12.getIntValue(bArr2, dataFormat12, i3, byteOrder12);
                String hexString = Integer.toHexString(intValue18 != null ? intValue18.intValue() : 0);
                Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(...)");
                String padStart = StringsKt.padStart(hexString, 8, '0');
                Integer[] intArray$default3 = DataEntityHelper.getIntArray$default(DataEntityHelper.INSTANCE, bArr, DataEntityHelper.DataFormat.FORMAT_UINT8, 16, 6, (ByteOrder) null, 16, (Object) null);
                if (intArray$default3 == null) {
                    intArray$default3 = new Integer[0];
                }
                String str9 = "";
                for (Number intValue19 : ArraysKt.reversed((T[]) intArray$default3)) {
                    String num8 = Integer.toString(intValue19.intValue(), CharsKt.checkRadix(16));
                    Intrinsics.checkNotNullExpressionValue(num8, str8);
                    Locale locale3 = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(locale3, "ROOT");
                    String upperCase3 = num8.toUpperCase(locale3);
                    Intrinsics.checkNotNullExpressionValue(upperCase3, "toUpperCase(...)");
                    String format2 = String.format(":%2s", Arrays.copyOf(new Object[]{upperCase3}, 1));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                    str9 = str9 + StringsKt.replace$default(format2, " ", "0", false, 4, (Object) null);
                }
                if (str9.length() > 0) {
                    str9 = str9.substring(1);
                    Intrinsics.checkNotNullExpressionValue(str9, "substring(...)");
                }
                Unit unit3 = Unit.INSTANCE;
                f4 = valueOf9;
                num2 = num7;
                tagCarryAroundStatus = tagCarryAroundStatus8;
                f3 = valueOf10;
                f2 = valueOf11;
                f = valueOf12;
                tagProximityStatus = tagProximityStatus8;
                tagCorrectionStatus2 = tagCorrectionStatus15;
                str = str9;
                str2 = padStart;
                tagIlluminationStatus = tagIlluminationStatus8;
                tagCorrectionStatus = tagCorrectionStatus16;
            } else if (i != 4) {
                Unit unit4 = Unit.INSTANCE;
                num2 = null;
                f4 = null;
                f3 = null;
                f2 = null;
                f = null;
                tagCorrectionStatus2 = null;
                tagCorrectionStatus = null;
                tagCarryAroundStatus = null;
                tagIlluminationStatus = null;
                tagProximityStatus = null;
                num = null;
                str2 = null;
                str = null;
            } else {
                Integer intValue$default13 = DataEntityHelper.getIntValue$default(DataEntityHelper.INSTANCE, bArr, DataEntityHelper.DataFormat.FORMAT_UINT8, 2, (ByteOrder) null, 8, (Object) null);
                Integer num9 = intValue$default13 == null ? null : intValue$default13;
                DataEntityHelper dataEntityHelper13 = DataEntityHelper.INSTANCE;
                DataEntityHelper.DataFormat dataFormat13 = DataEntityHelper.DataFormat.FORMAT_SINT16;
                ByteOrder byteOrder13 = ByteOrder.LITTLE_ENDIAN;
                Intrinsics.checkNotNullExpressionValue(byteOrder13, "LITTLE_ENDIAN");
                Integer intValue20 = dataEntityHelper13.getIntValue(bArr2, dataFormat13, 3, byteOrder13);
                Float valueOf13 = Float.valueOf((float) (intValue20 != null ? intValue20.intValue() : 0));
                DataEntityHelper dataEntityHelper14 = DataEntityHelper.INSTANCE;
                DataEntityHelper.DataFormat dataFormat14 = DataEntityHelper.DataFormat.FORMAT_SINT16;
                ByteOrder byteOrder14 = ByteOrder.LITTLE_ENDIAN;
                Intrinsics.checkNotNullExpressionValue(byteOrder14, "LITTLE_ENDIAN");
                Integer intValue21 = dataEntityHelper14.getIntValue(bArr2, dataFormat14, 5, byteOrder14);
                Float valueOf14 = Float.valueOf((float) (intValue21 != null ? intValue21.intValue() : 0));
                DataEntityHelper dataEntityHelper15 = DataEntityHelper.INSTANCE;
                DataEntityHelper.DataFormat dataFormat15 = DataEntityHelper.DataFormat.FORMAT_UINT16;
                ByteOrder byteOrder15 = ByteOrder.LITTLE_ENDIAN;
                Intrinsics.checkNotNullExpressionValue(byteOrder15, "LITTLE_ENDIAN");
                Integer intValue22 = dataEntityHelper15.getIntValue(bArr2, dataFormat15, 7, byteOrder15);
                Float valueOf15 = Float.valueOf((float) (intValue22 != null ? intValue22.intValue() : 0));
                Integer intValue$default14 = DataEntityHelper.getIntValue$default(DataEntityHelper.INSTANCE, bArr, DataEntityHelper.DataFormat.FORMAT_UINT8, 9, (ByteOrder) null, 8, (Object) null);
                Float valueOf16 = Float.valueOf((float) (intValue$default14 != null ? intValue$default14.intValue() : 0));
                Integer intValue$default15 = DataEntityHelper.getIntValue$default(DataEntityHelper.INSTANCE, bArr, DataEntityHelper.DataFormat.FORMAT_UINT8, 10, (ByteOrder) null, 8, (Object) null);
                TagCorrectionStatus[] values17 = TagCorrectionStatus.values();
                int length17 = values17.length;
                int i21 = 0;
                while (true) {
                    if (i21 >= length17) {
                        tagCorrectionStatus9 = null;
                        break;
                    }
                    tagCorrectionStatus9 = values17[i21];
                    if (intValue$default15 != null && tagCorrectionStatus9.getCode() == (intValue$default15.intValue() & 1)) {
                        break;
                    }
                    i21++;
                }
                if (tagCorrectionStatus9 == null) {
                    tagCorrectionStatus9 = TagCorrectionStatus.NO_CORRECTION;
                }
                TagCorrectionStatus tagCorrectionStatus17 = tagCorrectionStatus9;
                TagCorrectionStatus[] values18 = TagCorrectionStatus.values();
                int length18 = values18.length;
                int i22 = 0;
                while (true) {
                    if (i22 >= length18) {
                        tagCorrectionStatus10 = null;
                        break;
                    }
                    tagCorrectionStatus10 = values18[i22];
                    if (intValue$default15 != null && tagCorrectionStatus10.getCode() == ((intValue$default15.intValue() & 2) >> 1)) {
                        break;
                    }
                    i22++;
                }
                if (tagCorrectionStatus10 == null) {
                    tagCorrectionStatus10 = TagCorrectionStatus.NO_CORRECTION;
                }
                TagCorrectionStatus tagCorrectionStatus18 = tagCorrectionStatus10;
                TagCarryAroundStatus[] values19 = TagCarryAroundStatus.values();
                int length19 = values19.length;
                int i23 = 0;
                while (true) {
                    if (i23 >= length19) {
                        tagCarryAroundStatus5 = null;
                        break;
                    }
                    tagCarryAroundStatus5 = values19[i23];
                    if (intValue$default15 != null && tagCarryAroundStatus5.getCode() == ((intValue$default15.intValue() & 12) >> 2)) {
                        break;
                    }
                    i23++;
                }
                if (tagCarryAroundStatus5 == null) {
                    tagCarryAroundStatus5 = TagCarryAroundStatus.UNKNOWN;
                }
                TagCarryAroundStatus tagCarryAroundStatus9 = tagCarryAroundStatus5;
                TagIlluminationStatus[] values20 = TagIlluminationStatus.values();
                int length20 = values20.length;
                int i24 = 0;
                while (true) {
                    if (i24 >= length20) {
                        tagIlluminationStatus5 = null;
                        break;
                    }
                    tagIlluminationStatus5 = values20[i24];
                    if (intValue$default15 != null && tagIlluminationStatus5.getCode() == ((intValue$default15.intValue() & 48) >> 4)) {
                        break;
                    }
                    i24++;
                }
                if (tagIlluminationStatus5 == null) {
                    tagIlluminationStatus5 = TagIlluminationStatus.UNKNOWN;
                }
                TagIlluminationStatus tagIlluminationStatus9 = tagIlluminationStatus5;
                TagProximityStatus[] values21 = TagProximityStatus.values();
                int length21 = values21.length;
                int i25 = 0;
                while (true) {
                    if (i25 >= length21) {
                        tagProximityStatus5 = null;
                        break;
                    }
                    tagProximityStatus5 = values21[i25];
                    if (intValue$default15 != null && tagProximityStatus5.getCode() == ((intValue$default15.intValue() & 192) >> 6)) {
                        break;
                    }
                    i25++;
                }
                if (tagProximityStatus5 == null) {
                    tagProximityStatus5 = TagProximityStatus.UNKNOWN;
                }
                TagProximityStatus tagProximityStatus9 = tagProximityStatus5;
                Integer intValue$default16 = DataEntityHelper.getIntValue$default(DataEntityHelper.INSTANCE, bArr, DataEntityHelper.DataFormat.FORMAT_UINT8, 11, (ByteOrder) null, 8, (Object) null);
                if (intValue$default16 == null) {
                    intValue$default16 = null;
                }
                Unit unit5 = Unit.INSTANCE;
                num = intValue$default16;
                tagCarryAroundStatus = tagCarryAroundStatus9;
                num2 = num9;
                tagIlluminationStatus = tagIlluminationStatus9;
                tagProximityStatus = tagProximityStatus9;
                str2 = null;
                str = null;
                f4 = valueOf13;
                tagCorrectionStatus2 = tagCorrectionStatus17;
                tagCorrectionStatus = tagCorrectionStatus18;
                f2 = valueOf15;
                f = valueOf16;
                f3 = valueOf14;
            }
            return new TagDataEntity(intValue, intValue2, num2, f4, f3, f2, f, tagCorrectionStatus2, tagCorrectionStatus, tagCarryAroundStatus, tagIlluminationStatus, tagProximityStatus, num, str2, str, (Integer) null, (Integer) null, (Integer) null);
        }

        public final byte[] decryptionData(byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "dataArray");
            List arrayList = new ArrayList();
            int length = bArr.length;
            for (int i = 0; i < length; i++) {
                byte b = bArr[i];
                Object obj = TagDataEntity.DECRYPTION_KEY.get(i % TagDataEntity.DECRYPTION_KEY.size());
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                arrayList.add(Byte.valueOf((byte) (b ^ ((byte) Integer.parseInt((String) obj, CharsKt.checkRadix(16))))));
            }
            return CollectionsKt.toByteArray(arrayList);
        }

        public final TagDataEntity from(JSONObject jSONObject) {
            TagIlluminationStatus tagIlluminationStatus;
            TagProximityStatus tagProximityStatus;
            TagCorrectionStatus tagCorrectionStatus;
            TagCorrectionStatus tagCorrectionStatus2;
            TagCarryAroundStatus tagCarryAroundStatus;
            Intrinsics.checkNotNullParameter(jSONObject, "jsonObj");
            Integer num = (Integer) JSONObjectExtensionKt.value$default(jSONObject, JsonKey.FW_VERSION_CODE.getKey(), false, false, 6, (Object) null);
            if (num != null) {
                int intValue = num.intValue();
                Integer num2 = (Integer) JSONObjectExtensionKt.value$default(jSONObject, JsonKey.FORMAT_VERSION.getKey(), false, false, 6, (Object) null);
                if (num2 != null) {
                    int intValue2 = num2.intValue();
                    Integer num3 = (Integer) JSONObjectExtensionKt.value$default(jSONObject, JsonKey.SEQUENCE_NUMBER.getKey(), false, false, 6, (Object) null);
                    if (num3 != null) {
                        num3.intValue();
                        Integer num4 = (Integer) JSONObjectExtensionKt.value$default(jSONObject, JsonKey.TEMPERATURE.getKey(), false, false, 6, (Object) null);
                        if (num4 != null) {
                            int intValue3 = num4.intValue();
                            Integer num5 = (Integer) JSONObjectExtensionKt.value$default(jSONObject, JsonKey.HUMIDITY.getKey(), false, false, 6, (Object) null);
                            if (num5 != null) {
                                int intValue4 = num5.intValue();
                                Integer num6 = (Integer) JSONObjectExtensionKt.value$default(jSONObject, JsonKey.ILLUMINATION.getKey(), false, false, 6, (Object) null);
                                if (num6 != null) {
                                    int intValue5 = num6.intValue();
                                    Integer num7 = (Integer) JSONObjectExtensionKt.value$default(jSONObject, JsonKey.ILLUMINATION_STATUS.getKey(), false, false, 6, (Object) null);
                                    TagIlluminationStatus[] values = TagIlluminationStatus.values();
                                    int length = values.length;
                                    int i = 0;
                                    while (true) {
                                        if (i >= length) {
                                            tagIlluminationStatus = null;
                                            break;
                                        }
                                        tagIlluminationStatus = values[i];
                                        int code = tagIlluminationStatus.getCode();
                                        if (num7 != null && code == num7.intValue()) {
                                            break;
                                        }
                                        i++;
                                    }
                                    TagIlluminationStatus tagIlluminationStatus2 = tagIlluminationStatus == null ? TagIlluminationStatus.UNKNOWN : tagIlluminationStatus;
                                    Integer num8 = (Integer) JSONObjectExtensionKt.value$default(jSONObject, JsonKey.PROXIMITY.getKey(), false, false, 6, (Object) null);
                                    if (num8 != null) {
                                        int intValue6 = num8.intValue();
                                        Integer num9 = (Integer) JSONObjectExtensionKt.value$default(jSONObject, JsonKey.PROXIMITY_STATUS.getKey(), false, false, 6, (Object) null);
                                        TagProximityStatus[] values2 = TagProximityStatus.values();
                                        int length2 = values2.length;
                                        int i2 = 0;
                                        while (true) {
                                            if (i2 >= length2) {
                                                tagProximityStatus = null;
                                                break;
                                            }
                                            tagProximityStatus = values2[i2];
                                            int code2 = tagProximityStatus.getCode();
                                            if (num9 != null && code2 == num9.intValue()) {
                                                break;
                                            }
                                            i2++;
                                        }
                                        TagProximityStatus tagProximityStatus2 = tagProximityStatus == null ? TagProximityStatus.UNKNOWN : tagProximityStatus;
                                        Integer num10 = (Integer) JSONObjectExtensionKt.value$default(jSONObject, JsonKey.TEMP_CORRECTION.getKey(), false, false, 6, (Object) null);
                                        if (num10 != null) {
                                            int intValue7 = num10.intValue();
                                            TagCorrectionStatus[] values3 = TagCorrectionStatus.values();
                                            int length3 = values3.length;
                                            int i3 = 0;
                                            while (true) {
                                                if (i3 >= length3) {
                                                    tagCorrectionStatus = null;
                                                    break;
                                                }
                                                tagCorrectionStatus = values3[i3];
                                                if (tagCorrectionStatus.getCode() == intValue7) {
                                                    break;
                                                }
                                                i3++;
                                            }
                                            TagCorrectionStatus tagCorrectionStatus3 = tagCorrectionStatus == null ? TagCorrectionStatus.NO_CORRECTION : tagCorrectionStatus;
                                            Integer num11 = (Integer) JSONObjectExtensionKt.value$default(jSONObject, JsonKey.TEMP_CORRECTION.getKey(), false, false, 6, (Object) null);
                                            if (num11 != null) {
                                                int intValue8 = num11.intValue();
                                                TagCorrectionStatus[] values4 = TagCorrectionStatus.values();
                                                int length4 = values4.length;
                                                int i4 = 0;
                                                while (true) {
                                                    if (i4 >= length4) {
                                                        tagCorrectionStatus2 = null;
                                                        break;
                                                    }
                                                    tagCorrectionStatus2 = values4[i4];
                                                    if (tagCorrectionStatus2.getCode() == intValue8) {
                                                        break;
                                                    }
                                                    i4++;
                                                }
                                                TagCorrectionStatus tagCorrectionStatus4 = tagCorrectionStatus2 == null ? TagCorrectionStatus.NO_CORRECTION : tagCorrectionStatus2;
                                                Integer num12 = (Integer) JSONObjectExtensionKt.value$default(jSONObject, JsonKey.CARRY_AROUND_STATUS.getKey(), false, false, 6, (Object) null);
                                                if (num12 != null) {
                                                    int intValue9 = num12.intValue();
                                                    TagCarryAroundStatus[] values5 = TagCarryAroundStatus.values();
                                                    int length5 = values5.length;
                                                    int i5 = 0;
                                                    while (true) {
                                                        if (i5 >= length5) {
                                                            tagCarryAroundStatus = null;
                                                            break;
                                                        }
                                                        tagCarryAroundStatus = values5[i5];
                                                        if (tagCarryAroundStatus.getCode() == intValue9) {
                                                            break;
                                                        }
                                                        i5++;
                                                    }
                                                    TagCarryAroundStatus tagCarryAroundStatus2 = tagCarryAroundStatus == null ? TagCarryAroundStatus.UNKNOWN : tagCarryAroundStatus;
                                                    Integer num13 = (Integer) JSONObjectExtensionKt.value$default(jSONObject, JsonKey.BATTERY_LEVEL.getKey(), false, false, 6, (Object) null);
                                                    if (num13 != null) {
                                                        num13.intValue();
                                                        return new TagDataEntity(intValue, intValue2, num3, Float.valueOf((float) intValue3), Float.valueOf((float) intValue4), Float.valueOf((float) intValue5), Float.valueOf((float) intValue6), tagCorrectionStatus3, tagCorrectionStatus4, tagCarryAroundStatus2, tagIlluminationStatus2, tagProximityStatus2, num13, (String) JSONObjectExtensionKt.value$default(jSONObject, JsonKey.SERIAL_NUMBER.getKey(), false, false, 6, (Object) null), (String) JSONObjectExtensionKt.value$default(jSONObject, JsonKey.BD_ADDRESS.getKey(), false, false, 6, (Object) null), (Integer) JSONObjectExtensionKt.value$default(jSONObject, JsonKey.ACCELERATION_X_AXIS.getKey(), false, false, 6, (Object) null), (Integer) JSONObjectExtensionKt.value$default(jSONObject, JsonKey.ACCELERATION_Y_AXIS.getKey(), false, false, 6, (Object) null), (Integer) JSONObjectExtensionKt.value$default(jSONObject, JsonKey.ACCELERATION_Z_AXIS.getKey(), false, false, 6, (Object) null));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity$JsonKey;", "", "key", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "FW_VERSION_CODE", "FORMAT_VERSION", "SEQUENCE_NUMBER", "TEMPERATURE", "HUMIDITY", "ILLUMINATION", "ILLUMINATION_STATUS", "PROXIMITY", "PROXIMITY_STATUS", "TEMP_CORRECTION", "HUMI_CORRECTION", "CARRY_AROUND_STATUS", "BATTERY_LEVEL", "SERIAL_NUMBER", "BD_ADDRESS", "ACCELERATION_X_AXIS", "ACCELERATION_Y_AXIS", "ACCELERATION_Z_AXIS", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TagDataEntity.kt */
    public enum JsonKey {
        FW_VERSION_CODE("fwVersionCode"),
        FORMAT_VERSION("formatVersion"),
        SEQUENCE_NUMBER("sequenceNumber"),
        TEMPERATURE(PairingActivityKt.TRANSIT_TO_MAIN_TEMPERATURE),
        HUMIDITY("humidity"),
        ILLUMINATION("illumination"),
        ILLUMINATION_STATUS("illuminationStatus"),
        PROXIMITY("proximity"),
        PROXIMITY_STATUS("proximityStatus"),
        TEMP_CORRECTION("tempCorrection"),
        HUMI_CORRECTION("humiCorrection"),
        CARRY_AROUND_STATUS("carryAroundStatus"),
        BATTERY_LEVEL("batteryLevel"),
        SERIAL_NUMBER("serialNo"),
        BD_ADDRESS("bdAddress"),
        ACCELERATION_X_AXIS("accelerationXAxis"),
        ACCELERATION_Y_AXIS("accelerationYAxis"),
        ACCELERATION_Z_AXIS("accelerationZAxis");
        
        private final String key;

        public static EnumEntries<JsonKey> getEntries() {
            return $ENTRIES;
        }

        private JsonKey(String str) {
            this.key = str;
        }

        public final String getKey() {
            return this.key;
        }

        static {
            JsonKey[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity$FormatVersion;", "", "key", "", "(Ljava/lang/String;II)V", "getKey", "()I", "CONNECTION_1", "DATA_2", "CONNECTION_3", "DATA_4", "CONNECTION_5", "DATA_6", "CONNECTION_7", "DATA_8", "DATA_9", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TagDataEntity.kt */
    public enum FormatVersion {
        CONNECTION_1(1),
        DATA_2(2),
        CONNECTION_3(3),
        DATA_4(4),
        CONNECTION_5(5),
        DATA_6(6),
        CONNECTION_7(7),
        DATA_8(8),
        DATA_9(9);
        
        private final int key;

        public static EnumEntries<FormatVersion> getEntries() {
            return $ENTRIES;
        }

        private FormatVersion(int i) {
            this.key = i;
        }

        public final int getKey() {
            return this.key;
        }

        static {
            FormatVersion[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    public final String toJSONString() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(JsonKey.FW_VERSION_CODE.getKey(), this.fwVersionCode);
        jSONObject.put(JsonKey.FORMAT_VERSION.getKey(), this.formatVersion);
        jSONObject.put(JsonKey.SEQUENCE_NUMBER.getKey(), this.sequenceNumber);
        jSONObject.put(JsonKey.TEMPERATURE.getKey(), this.temperature);
        jSONObject.put(JsonKey.HUMIDITY.getKey(), this.humidity);
        jSONObject.put(JsonKey.ILLUMINATION.getKey(), this.illumination);
        jSONObject.put(JsonKey.PROXIMITY.getKey(), this.proximity);
        String key = JsonKey.TEMP_CORRECTION.getKey();
        TagCorrectionStatus tagCorrectionStatus = this.tempCorrection;
        Integer num = null;
        jSONObject.put(key, tagCorrectionStatus != null ? Integer.valueOf(tagCorrectionStatus.getCode()) : null);
        String key2 = JsonKey.HUMI_CORRECTION.getKey();
        TagCorrectionStatus tagCorrectionStatus2 = this.humiCorrection;
        jSONObject.put(key2, tagCorrectionStatus2 != null ? Integer.valueOf(tagCorrectionStatus2.getCode()) : null);
        String key3 = JsonKey.CARRY_AROUND_STATUS.getKey();
        TagCarryAroundStatus tagCarryAroundStatus = this.carryAroundStatus;
        jSONObject.put(key3, tagCarryAroundStatus != null ? Integer.valueOf(tagCarryAroundStatus.getCode()) : null);
        String key4 = JsonKey.ILLUMINATION_STATUS.getKey();
        TagIlluminationStatus tagIlluminationStatus = this.illuminationStatus;
        jSONObject.put(key4, tagIlluminationStatus != null ? Integer.valueOf(tagIlluminationStatus.getCode()) : null);
        String key5 = JsonKey.PROXIMITY_STATUS.getKey();
        TagProximityStatus tagProximityStatus = this.proximityStatus;
        if (tagProximityStatus != null) {
            num = Integer.valueOf(tagProximityStatus.getCode());
        }
        jSONObject.put(key5, num);
        jSONObject.put(JsonKey.BATTERY_LEVEL.getKey(), this.batteryLevel);
        if (this.serialNo != null) {
            jSONObject.put(JsonKey.SERIAL_NUMBER.getKey(), this.serialNo);
        }
        if (this.bdAddress != null) {
            jSONObject.put(JsonKey.BD_ADDRESS.getKey(), this.bdAddress);
        }
        jSONObject.put(JsonKey.ACCELERATION_X_AXIS.getKey(), this.accelerationXAxis);
        jSONObject.put(JsonKey.ACCELERATION_Y_AXIS.getKey(), this.accelerationYAxis);
        jSONObject.put(JsonKey.ACCELERATION_Z_AXIS.getKey(), this.accelerationZAxis);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
        return jSONObject2;
    }
}
