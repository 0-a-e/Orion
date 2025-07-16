package jp.co.sony.reon.android.ble.constant;

import jp.co.sony.reonpocket.constant.GattProfileConstant;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ljp/co/sony/reon/android/ble/constant/TagGattProfileConstant;", "", "()V", "TAG_BASE_SERVICE_UUID", "", "TAG_LONG_SERVICE_DEVICE_CONTROL", "TAG_REGEX_SERVICE_DEVICE_CONTROL", "DeviceControlService", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagGattProfileConstant.kt */
public final class TagGattProfileConstant {
    public static final TagGattProfileConstant INSTANCE = new TagGattProfileConstant();
    public static final String TAG_BASE_SERVICE_UUID = "1667xxxx-e783-4330-b308-b9e1481ecfcc";
    public static final String TAG_LONG_SERVICE_DEVICE_CONTROL = "16671501-e783-4330-b308-b9e1481ecfcc";
    public static final String TAG_REGEX_SERVICE_DEVICE_CONTROL = "1667(.{4})-e783-4330-b308-b9e1481ecfcc";

    private TagGattProfileConstant() {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Ljp/co/sony/reon/android/ble/constant/TagGattProfileConstant$DeviceControlService;", "", "uuid", "", "(Ljava/lang/String;ILjava/lang/String;)V", "serviceUuid", "getServiceUuid", "()Ljava/lang/String;", "getUuid", "SERVICE_DEVICE_CONTROL", "CHARACTERISTIC_SET_TAG_CONTROL", "CHARACTERISTIC_REQUEST_DFU", "CHARACTERISTIC_REQUEST_INITIALIZE", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TagGattProfileConstant.kt */
    public enum DeviceControlService {
        SERVICE_DEVICE_CONTROL(GattProfileConstant.SERVICE_DEVICE_CONTROL),
        CHARACTERISTIC_SET_TAG_CONTROL(GattProfileConstant.CHARACTERISTIC_CURRENT_TIME),
        CHARACTERISTIC_REQUEST_DFU(GattProfileConstant.CHARACTERISTIC_REQUEST_DFU),
        CHARACTERISTIC_REQUEST_INITIALIZE(GattProfileConstant.CHARACTERISTIC_INITIALIZE);
        
        private final String serviceUuid;
        private final String uuid;

        public static EnumEntries<DeviceControlService> getEntries() {
            return $ENTRIES;
        }

        private DeviceControlService(String str) {
            this.uuid = str;
            this.serviceUuid = StringsKt.replace$default(TagGattProfileConstant.TAG_BASE_SERVICE_UUID, "xxxx", str, false, 4, (Object) null);
        }

        public final String getUuid() {
            return this.uuid;
        }

        static {
            DeviceControlService[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }

        public final String getServiceUuid() {
            return this.serviceUuid;
        }
    }
}
