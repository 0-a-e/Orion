package jp.co.sony.reonpocket.data.entity;

import androidx.core.app.NotificationCompat;
import java.util.List;
import jp.co.sony.reonpocket.constant.AuthenticationType;
import jp.co.sony.reonpocket.constant.TagDeviceType;
import jp.co.sony.reonpocket.constant.TagStatus;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/AuthenticationTagEntity;", "Ljp/co/sony/reonpocket/data/entity/AuthenticationEntity;", "status", "Ljp/co/sony/reonpocket/constant/TagStatus;", "bdAddress", "", "deviceType", "Ljp/co/sony/reonpocket/constant/TagDeviceType;", "(Ljp/co/sony/reonpocket/constant/TagStatus;Ljava/lang/String;Ljp/co/sony/reonpocket/constant/TagDeviceType;)V", "getBdAddress", "()Ljava/lang/String;", "getDeviceType", "()Ljp/co/sony/reonpocket/constant/TagDeviceType;", "getStatus", "()Ljp/co/sony/reonpocket/constant/TagStatus;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toByte", "", "toString", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AuthenticationEntity.kt */
public final class AuthenticationTagEntity extends AuthenticationEntity {
    public static final int $stable = 0;
    private final String bdAddress;
    private final TagDeviceType deviceType;
    private final TagStatus status;

    public static /* synthetic */ AuthenticationTagEntity copy$default(AuthenticationTagEntity authenticationTagEntity, TagStatus tagStatus, String str, TagDeviceType tagDeviceType, int i, Object obj) {
        if ((i & 1) != 0) {
            tagStatus = authenticationTagEntity.status;
        }
        if ((i & 2) != 0) {
            str = authenticationTagEntity.bdAddress;
        }
        if ((i & 4) != 0) {
            tagDeviceType = authenticationTagEntity.deviceType;
        }
        return authenticationTagEntity.copy(tagStatus, str, tagDeviceType);
    }

    public final TagStatus component1() {
        return this.status;
    }

    public final String component2() {
        return this.bdAddress;
    }

    public final TagDeviceType component3() {
        return this.deviceType;
    }

    public final AuthenticationTagEntity copy(TagStatus tagStatus, String str, TagDeviceType tagDeviceType) {
        Intrinsics.checkNotNullParameter(tagStatus, NotificationCompat.CATEGORY_STATUS);
        Intrinsics.checkNotNullParameter(tagDeviceType, "deviceType");
        return new AuthenticationTagEntity(tagStatus, str, tagDeviceType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticationTagEntity)) {
            return false;
        }
        AuthenticationTagEntity authenticationTagEntity = (AuthenticationTagEntity) obj;
        return this.status == authenticationTagEntity.status && Intrinsics.areEqual((Object) this.bdAddress, (Object) authenticationTagEntity.bdAddress) && this.deviceType == authenticationTagEntity.deviceType;
    }

    public int hashCode() {
        int hashCode = this.status.hashCode() * 31;
        String str = this.bdAddress;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.deviceType.hashCode();
    }

    public String toString() {
        TagStatus tagStatus = this.status;
        String str = this.bdAddress;
        TagDeviceType tagDeviceType = this.deviceType;
        return "AuthenticationTagEntity(status=" + tagStatus + ", bdAddress=" + str + ", deviceType=" + tagDeviceType + ")";
    }

    public final TagStatus getStatus() {
        return this.status;
    }

    public final String getBdAddress() {
        return this.bdAddress;
    }

    public final TagDeviceType getDeviceType() {
        return this.deviceType;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AuthenticationTagEntity(TagStatus tagStatus, String str, TagDeviceType tagDeviceType) {
        super(AuthenticationType.TAG);
        Intrinsics.checkNotNullParameter(tagStatus, NotificationCompat.CATEGORY_STATUS);
        Intrinsics.checkNotNullParameter(tagDeviceType, "deviceType");
        this.status = tagStatus;
        this.bdAddress = str;
        this.deviceType = tagDeviceType;
    }

    public byte[] toByte() {
        String str = this.bdAddress;
        if (str == null) {
            return null;
        }
        List<String> reversed = CollectionsKt.reversed(StringsKt.split$default((CharSequence) str, new String[]{"+", ":", " "}, false, 0, 6, (Object) null));
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        String str2 = this.bdAddress;
        debugLogUtil.d("bdAddress: " + str2);
        List mutableListOf = CollectionsKt.mutableListOf(Byte.valueOf((byte) getType().getCode()), Byte.valueOf((byte) this.status.getCode()));
        for (String str3 : reversed) {
            if (str3.length() > 0 && !Intrinsics.areEqual((Object) str3, (Object) " ")) {
                mutableListOf.add(Byte.valueOf((byte) Integer.parseInt(str3, CharsKt.checkRadix(16))));
            }
        }
        mutableListOf.add(Byte.valueOf((byte) this.deviceType.getCode()));
        return CollectionsKt.toByteArray(mutableListOf);
    }
}
