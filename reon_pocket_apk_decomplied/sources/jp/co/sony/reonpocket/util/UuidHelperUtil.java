package jp.co.sony.reonpocket.util;

import android.content.Context;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jp.co.sony.reon.android.ble.constant.TagGattProfileConstant;
import jp.co.sony.reonpocket.constant.GattProfileConstant;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0005\u000b\f\r\u000e\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004¨\u0006\u0010"}, d2 = {"Ljp/co/sony/reonpocket/util/UuidHelperUtil;", "", "()V", "getOwnIdByteArray", "", "aContext", "Landroid/content/Context;", "getOwnerId", "", "getUUIDFromByteArray", "aBytes", "DeviceControlService", "DeviceInformationService", "DfuService", "GenericAccessService", "TagService", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: UuidHelperUtil.kt */
public final class UuidHelperUtil {
    public static final int $stable = 0;
    public static final UuidHelperUtil INSTANCE = new UuidHelperUtil();

    private UuidHelperUtil() {
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\b"}, d2 = {"Ljp/co/sony/reonpocket/util/UuidHelperUtil$DeviceInformationService;", "", "()V", "getLongUuidByShortUuid", "", "aShortUuid", "getShortUuidByLongUuid", "aLongUuid", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: UuidHelperUtil.kt */
    public static final class DeviceInformationService {
        public static final int $stable = 0;
        public static final DeviceInformationService INSTANCE = new DeviceInformationService();

        private DeviceInformationService() {
        }

        public final String getLongUuidByShortUuid(String str) {
            Intrinsics.checkNotNullParameter(str, "aShortUuid");
            return StringsKt.replace$default(GattProfileConstant.BASE_SERVICE_DEVICE_INFORMATION, "xxxx", str, false, 4, (Object) null);
        }

        public final String getShortUuidByLongUuid(String str) {
            Intrinsics.checkNotNullParameter(str, "aLongUuid");
            Matcher matcher = Pattern.compile(GattProfileConstant.REGEX_SERVICE_DEVICE_INFORMATION, 2).matcher(str);
            if (!matcher.matches()) {
                return str;
            }
            String group = matcher.group(1);
            Intrinsics.checkNotNull(group);
            return group;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\b"}, d2 = {"Ljp/co/sony/reonpocket/util/UuidHelperUtil$DeviceControlService;", "", "()V", "getLongUuidByShortUuid", "", "aShortUuid", "getShortUuidByLongUuid", "aLongUuid", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: UuidHelperUtil.kt */
    public static final class DeviceControlService {
        public static final int $stable = 0;
        public static final DeviceControlService INSTANCE = new DeviceControlService();

        private DeviceControlService() {
        }

        public final String getLongUuidByShortUuid(String str) {
            Intrinsics.checkNotNullParameter(str, "aShortUuid");
            return StringsKt.replace$default(GattProfileConstant.BASE_SERVICE_DEVICE_CONTROL, "xxxx", str, false, 4, (Object) null);
        }

        public final String getShortUuidByLongUuid(String str) {
            Intrinsics.checkNotNullParameter(str, "aLongUuid");
            Matcher matcher = Pattern.compile(GattProfileConstant.REGEX_SERVICE_DEVICE_CONTROL, 2).matcher(str);
            if (!matcher.matches()) {
                return str;
            }
            String group = matcher.group(1);
            Intrinsics.checkNotNull(group);
            return group;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\b"}, d2 = {"Ljp/co/sony/reonpocket/util/UuidHelperUtil$GenericAccessService;", "", "()V", "getLongUuidByShortUuid", "", "aShortUuid", "getShortUuidByLongUuid", "aLongUuid", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: UuidHelperUtil.kt */
    public static final class GenericAccessService {
        public static final int $stable = 0;
        public static final GenericAccessService INSTANCE = new GenericAccessService();

        private GenericAccessService() {
        }

        public final String getLongUuidByShortUuid(String str) {
            Intrinsics.checkNotNullParameter(str, "aShortUuid");
            return StringsKt.replace$default(GattProfileConstant.BASE_SERVICE_DEVICE_INFORMATION, "xxxx", str, false, 4, (Object) null);
        }

        public final String getShortUuidByLongUuid(String str) {
            Intrinsics.checkNotNullParameter(str, "aLongUuid");
            Matcher matcher = Pattern.compile(GattProfileConstant.REGEX_SERVICE_DEVICE_INFORMATION, 2).matcher(str);
            if (!matcher.matches()) {
                return str;
            }
            String group = matcher.group(1);
            Intrinsics.checkNotNull(group);
            return group;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\b"}, d2 = {"Ljp/co/sony/reonpocket/util/UuidHelperUtil$DfuService;", "", "()V", "getLongUuidByShortUuid", "", "aShortUuid", "getShortUuidByLongUuid", "aLongUuid", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: UuidHelperUtil.kt */
    public static final class DfuService {
        public static final int $stable = 0;
        public static final DfuService INSTANCE = new DfuService();

        private DfuService() {
        }

        public final String getLongUuidByShortUuid(String str) {
            Intrinsics.checkNotNullParameter(str, "aShortUuid");
            return StringsKt.replace$default(GattProfileConstant.BASE_SERVICE_DEVICE_DFU, "xxxx", str, false, 4, (Object) null);
        }

        public final String getShortUuidByLongUuid(String str) {
            Intrinsics.checkNotNullParameter(str, "aLongUuid");
            Matcher matcher = Pattern.compile(GattProfileConstant.REGEX_SERVICE_DEVICE_DFU, 2).matcher(str);
            if (!matcher.matches()) {
                return str;
            }
            String group = matcher.group(1);
            Intrinsics.checkNotNull(group);
            return group;
        }
    }

    public final String getUUIDFromByteArray(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "aBytes");
        if (bArr.length == 0) {
            return "";
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        String uuid = new UUID(wrap.getLong(), wrap.getLong()).toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        return StringsKt.replace$default(uuid, "-", "", false, 4, (Object) null);
    }

    public final byte[] getOwnIdByteArray(Context context) {
        List<String> list;
        Intrinsics.checkNotNullParameter(context, "aContext");
        String stringValue = SimpleStorageUtil.INSTANCE.getStringValue(context, SimpleStorageUtil.REON_OWNER_ID);
        if (stringValue != null) {
            list = new Regex("\\s+").split(stringValue, 0);
        } else {
            list = null;
        }
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        debugLogUtil.d("ownerId: " + stringValue);
        List arrayList = new ArrayList();
        if (list != null) {
            for (String next : list) {
                CharSequence charSequence = next;
                if (!(charSequence == null || charSequence.length() == 0 || Intrinsics.areEqual((Object) next, (Object) " "))) {
                    arrayList.add(Byte.valueOf((byte) Integer.parseInt(next)));
                }
            }
        }
        return CollectionsKt.toByteArray(arrayList);
    }

    public final String getOwnerId(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        return getUUIDFromByteArray(getOwnIdByteArray(context));
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\b"}, d2 = {"Ljp/co/sony/reonpocket/util/UuidHelperUtil$TagService;", "", "()V", "getServiceUuid", "", "aUuid", "getShortUuidByLongUuid", "aLongUuid", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: UuidHelperUtil.kt */
    public static final class TagService {
        public static final int $stable = 0;
        public static final TagService INSTANCE = new TagService();

        private TagService() {
        }

        public final String getServiceUuid(String str) {
            Intrinsics.checkNotNullParameter(str, "aUuid");
            return StringsKt.replace$default(TagGattProfileConstant.TAG_BASE_SERVICE_UUID, "xxxx", str, false, 4, (Object) null);
        }

        public final String getShortUuidByLongUuid(String str) {
            Intrinsics.checkNotNullParameter(str, "aLongUuid");
            Matcher matcher = Pattern.compile(TagGattProfileConstant.TAG_REGEX_SERVICE_DEVICE_CONTROL, 2).matcher(str);
            if (!matcher.matches()) {
                return str;
            }
            String group = matcher.group(1);
            Intrinsics.checkNotNull(group);
            return group;
        }
    }
}
