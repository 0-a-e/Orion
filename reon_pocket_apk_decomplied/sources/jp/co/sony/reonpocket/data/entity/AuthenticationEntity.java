package jp.co.sony.reonpocket.data.entity;

import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import jp.co.sony.reonpocket.constant.AuthenticationType;
import jp.co.sony.reonpocket.constant.OwnerStatus;
import jp.co.sony.reonpocket.constant.TagDeviceType;
import jp.co.sony.reonpocket.constant.TagStatus;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\b'\u0018\u0000 \t2\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/AuthenticationEntity;", "", "type", "Ljp/co/sony/reonpocket/constant/AuthenticationType;", "(Ljp/co/sony/reonpocket/constant/AuthenticationType;)V", "getType", "()Ljp/co/sony/reonpocket/constant/AuthenticationType;", "toByte", "", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AuthenticationEntity.kt */
public abstract class AuthenticationEntity {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final AuthenticationType type;

    public abstract byte[] toByte();

    public AuthenticationEntity(AuthenticationType authenticationType) {
        Intrinsics.checkNotNullParameter(authenticationType, TransferTable.COLUMN_TYPE);
        this.type = authenticationType;
    }

    public final AuthenticationType getType() {
        return this.type;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\n"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/AuthenticationEntity$Companion;", "", "()V", "convertOwner", "Ljp/co/sony/reonpocket/data/entity/AuthenticationEntity;", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "convertOwnerUnregister", "convertTag", "getObject", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: AuthenticationEntity.kt */
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* compiled from: AuthenticationEntity.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            static {
                /*
                    jp.co.sony.reonpocket.constant.AuthenticationType[] r0 = jp.co.sony.reonpocket.constant.AuthenticationType.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    jp.co.sony.reonpocket.constant.AuthenticationType r1 = jp.co.sony.reonpocket.constant.AuthenticationType.OWNER     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    jp.co.sony.reonpocket.constant.AuthenticationType r1 = jp.co.sony.reonpocket.constant.AuthenticationType.TAG     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    jp.co.sony.reonpocket.constant.AuthenticationType r1 = jp.co.sony.reonpocket.constant.AuthenticationType.OWNER_UNREGISTER     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.data.entity.AuthenticationEntity.Companion.WhenMappings.<clinit>():void");
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AuthenticationEntity getObject(BleDataEntity bleDataEntity) {
            Object obj;
            Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
            Integer intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 0, (ByteOrder) null, 4, (Object) null);
            Iterator it = AuthenticationType.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                int code = ((AuthenticationType) obj).getCode();
                if (intValue$default != null && code == intValue$default.intValue()) {
                    break;
                }
            }
            AuthenticationType authenticationType = (AuthenticationType) obj;
            if (authenticationType == null) {
                return null;
            }
            int i = WhenMappings.$EnumSwitchMapping$0[authenticationType.ordinal()];
            if (i == 1) {
                return convertOwner(bleDataEntity);
            }
            if (i == 2) {
                return convertTag(bleDataEntity);
            }
            if (i == 3) {
                return convertOwnerUnregister(bleDataEntity);
            }
            throw new NoWhenBranchMatchedException();
        }

        public final AuthenticationEntity convertOwner(BleDataEntity bleDataEntity) {
            Object obj;
            Integer[] intArray$default;
            Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
            Integer intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 1, (ByteOrder) null, 4, (Object) null);
            Iterator it = OwnerStatus.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                int code = ((OwnerStatus) obj).getCode();
                if (intValue$default != null && code == intValue$default.intValue()) {
                    break;
                }
            }
            OwnerStatus ownerStatus = (OwnerStatus) obj;
            if (ownerStatus == null || (intArray$default = BleDataEntity.getIntArray$default(bleDataEntity, 17, 2, 16, (ByteOrder) null, 8, (Object) null)) == null) {
                return null;
            }
            int length = intArray$default.length;
            int i = 0;
            String str = "";
            int i2 = 0;
            while (i < length) {
                int i3 = i2 + 1;
                str = str + intArray$default[i].intValue();
                if (i2 < 15) {
                    str = str + " ";
                }
                i++;
                i2 = i3;
            }
            return new AuthenticationOwnerRegisterEntity(ownerStatus, str);
        }

        public final AuthenticationEntity convertTag(BleDataEntity bleDataEntity) {
            Object obj;
            Integer[] intArray$default;
            Object obj2;
            Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
            Integer intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 1, (ByteOrder) null, 4, (Object) null);
            Iterator it = TagStatus.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                int code = ((TagStatus) obj).getCode();
                if (intValue$default != null && code == intValue$default.intValue()) {
                    break;
                }
            }
            TagStatus tagStatus = (TagStatus) obj;
            if (tagStatus == null || (intArray$default = BleDataEntity.getIntArray$default(bleDataEntity, 17, 2, 6, (ByteOrder) null, 8, (Object) null)) == null) {
                return null;
            }
            String str = "";
            for (Number intValue : ArraysKt.reversed((T[]) intArray$default)) {
                String num = Integer.toString(intValue.intValue(), CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
                Locale locale = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
                String upperCase = num.toUpperCase(locale);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                String format = String.format(":%2s", Arrays.copyOf(new Object[]{upperCase}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                str = str + StringsKt.replace$default(format, " ", "0", false, 4, (Object) null);
            }
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            Integer intValue$default2 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 8, (ByteOrder) null, 4, (Object) null);
            Iterator it2 = TagDeviceType.getEntries().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it2.next();
                int code2 = ((TagDeviceType) obj2).getCode();
                if (intValue$default2 != null && code2 == intValue$default2.intValue()) {
                    break;
                }
            }
            TagDeviceType tagDeviceType = (TagDeviceType) obj2;
            if (tagDeviceType == null) {
                return null;
            }
            return new AuthenticationTagEntity(tagStatus, substring, tagDeviceType);
        }

        public final AuthenticationEntity convertOwnerUnregister(BleDataEntity bleDataEntity) {
            String str;
            Object obj;
            Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
            Integer intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 1, (ByteOrder) null, 4, (Object) null);
            Iterator it = OwnerStatus.getEntries().iterator();
            while (true) {
                str = null;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                int code = ((OwnerStatus) obj).getCode();
                if (intValue$default != null && code == intValue$default.intValue()) {
                    break;
                }
            }
            OwnerStatus ownerStatus = (OwnerStatus) obj;
            if (ownerStatus == null) {
                ownerStatus = OwnerStatus.UNREGISTERED;
            }
            OwnerStatus ownerStatus2 = ownerStatus;
            Integer[] intArray$default = BleDataEntity.getIntArray$default(bleDataEntity, 17, 2, 16, (ByteOrder) null, 8, (Object) null);
            if (intArray$default != null) {
                str = ArraysKt.joinToString$default((Object[]) intArray$default, (CharSequence) " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            }
            return new AuthenticationOwnerUnregisterEntity(ownerStatus2, str);
        }
    }
}
