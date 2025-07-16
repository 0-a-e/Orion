package jp.co.sony.reonpocket.modules.base.view;

import jp.co.sony.reonpocket.constant.NotificationId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0016\u001a\u00020\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"ERROR_CONNECTION_STATE", "", "ERROR_CONNECTION_STATE_WITHOUT_UNREGISTER", "ERROR_DEVICE_COULD_NOT_CHARGE", "ERROR_DEVICE_COULD_NOT_CHARGE_UNKNOWN", "ERROR_DEVICE_FAN_INVALID", "ERROR_DEVICE_LOWTEMP", "ERROR_DEVICE_OVERHEAT", "ERROR_DEVICE_STOP", "ERROR_DFU_FAIL", "ERROR_DFU_FAIL_DUE_TO_LOW_BATTERY", "ERROR_INTERNET_CONNECTION_INVALID", "ERROR_INVALID_OWNER", "ERROR_OPERATE_WHEN_CHARGE", "ERROR_OPERATE_WHEN_NO_ENOUGH_BATTERY", "ERROR_TEMP", "ERROR_UNEXPECTED", "USB_AROUND_OVER_HEAT", "USB_AROUND_WATER_WET_DETECTION", "USB_WATER_WET_DETECTION", "VBUS_VOLTAGE_ABNORMALITY_DETECTED", "convertNotificationIdToErrorReason", "notificationId", "Ljp/co/sony/reonpocket/constant/NotificationId;", "app_prodRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseActivity.kt */
public final class BaseActivityKt {
    public static final String ERROR_CONNECTION_STATE = "error_connection_state";
    public static final String ERROR_CONNECTION_STATE_WITHOUT_UNREGISTER = "error_connection_state_without_unregister";
    public static final String ERROR_DEVICE_COULD_NOT_CHARGE = "error_device_could_not_charge";
    public static final String ERROR_DEVICE_COULD_NOT_CHARGE_UNKNOWN = "error_device_could_not_charge_unknown";
    public static final String ERROR_DEVICE_FAN_INVALID = "error_device_fan_invalid";
    public static final String ERROR_DEVICE_LOWTEMP = "error_device_low_temp";
    public static final String ERROR_DEVICE_OVERHEAT = "error_device_overheat";
    public static final String ERROR_DEVICE_STOP = "error_device_stop";
    public static final String ERROR_DFU_FAIL = "error_dfu_fail";
    public static final String ERROR_DFU_FAIL_DUE_TO_LOW_BATTERY = "error_dfu_fail_due_to_low_battery";
    public static final String ERROR_INTERNET_CONNECTION_INVALID = "error_internet_connection_invalid";
    public static final String ERROR_INVALID_OWNER = "error_invalid_owner";
    public static final String ERROR_OPERATE_WHEN_CHARGE = "error_operate_when_charge";
    public static final String ERROR_OPERATE_WHEN_NO_ENOUGH_BATTERY = "error_operate_when_no_enough_battery";
    public static final String ERROR_TEMP = "error_temp";
    public static final String ERROR_UNEXPECTED = "error_unexpected";
    public static final String USB_AROUND_OVER_HEAT = "error_usb_around_over_heat";
    public static final String USB_AROUND_WATER_WET_DETECTION = "error_useb_around_water_wet_detection";
    public static final String USB_WATER_WET_DETECTION = "error_usb_water_wet_detection";
    public static final String VBUS_VOLTAGE_ABNORMALITY_DETECTED = "error_vbus_voltage_abnormality_detected";

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BaseActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                jp.co.sony.reonpocket.constant.NotificationId[] r0 = jp.co.sony.reonpocket.constant.NotificationId.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.NotificationId r1 = jp.co.sony.reonpocket.constant.NotificationId.NotifyAlertVbusVoltage     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                jp.co.sony.reonpocket.constant.NotificationId r1 = jp.co.sony.reonpocket.constant.NotificationId.NotifyAlertUsbWater     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                jp.co.sony.reonpocket.constant.NotificationId r1 = jp.co.sony.reonpocket.constant.NotificationId.NotifyAlertAroundUsbWater     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                jp.co.sony.reonpocket.constant.NotificationId r1 = jp.co.sony.reonpocket.constant.NotificationId.NotifyAlertAroundUsbHeat     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.base.view.BaseActivityKt.WhenMappings.<clinit>():void");
        }
    }

    public static final String convertNotificationIdToErrorReason(NotificationId notificationId) {
        Intrinsics.checkNotNullParameter(notificationId, "notificationId");
        int i = WhenMappings.$EnumSwitchMapping$0[notificationId.ordinal()];
        if (i == 1) {
            return VBUS_VOLTAGE_ABNORMALITY_DETECTED;
        }
        if (i == 2) {
            return USB_WATER_WET_DETECTION;
        }
        if (i == 3) {
            return USB_AROUND_WATER_WET_DETECTION;
        }
        if (i != 4) {
            return null;
        }
        return USB_AROUND_OVER_HEAT;
    }
}
