package jp.co.sony.reonpocket.data.entity;

import androidx.core.app.NotificationCompat;
import java.util.List;
import jp.co.sony.reonpocket.constant.AuthenticationType;
import jp.co.sony.reonpocket.constant.TagDeviceType;
import jp.co.sony.reonpocket.constant.TagStatus;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/AuthenticationTagUnregisterEntity;", "Ljp/co/sony/reonpocket/data/entity/AuthenticationEntity;", "status", "Ljp/co/sony/reonpocket/constant/TagStatus;", "deviceType", "Ljp/co/sony/reonpocket/constant/TagDeviceType;", "(Ljp/co/sony/reonpocket/constant/TagStatus;Ljp/co/sony/reonpocket/constant/TagDeviceType;)V", "getDeviceType", "()Ljp/co/sony/reonpocket/constant/TagDeviceType;", "getStatus", "()Ljp/co/sony/reonpocket/constant/TagStatus;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toByte", "", "toString", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AuthenticationEntity.kt */
public final class AuthenticationTagUnregisterEntity extends AuthenticationEntity {
    public static final int $stable = 0;
    private final TagDeviceType deviceType;
    private final TagStatus status;

    public static /* synthetic */ AuthenticationTagUnregisterEntity copy$default(AuthenticationTagUnregisterEntity authenticationTagUnregisterEntity, TagStatus tagStatus, TagDeviceType tagDeviceType, int i, Object obj) {
        if ((i & 1) != 0) {
            tagStatus = authenticationTagUnregisterEntity.status;
        }
        if ((i & 2) != 0) {
            tagDeviceType = authenticationTagUnregisterEntity.deviceType;
        }
        return authenticationTagUnregisterEntity.copy(tagStatus, tagDeviceType);
    }

    public final TagStatus component1() {
        return this.status;
    }

    public final TagDeviceType component2() {
        return this.deviceType;
    }

    public final AuthenticationTagUnregisterEntity copy(TagStatus tagStatus, TagDeviceType tagDeviceType) {
        Intrinsics.checkNotNullParameter(tagStatus, NotificationCompat.CATEGORY_STATUS);
        Intrinsics.checkNotNullParameter(tagDeviceType, "deviceType");
        return new AuthenticationTagUnregisterEntity(tagStatus, tagDeviceType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticationTagUnregisterEntity)) {
            return false;
        }
        AuthenticationTagUnregisterEntity authenticationTagUnregisterEntity = (AuthenticationTagUnregisterEntity) obj;
        return this.status == authenticationTagUnregisterEntity.status && this.deviceType == authenticationTagUnregisterEntity.deviceType;
    }

    public int hashCode() {
        return (this.status.hashCode() * 31) + this.deviceType.hashCode();
    }

    public String toString() {
        TagStatus tagStatus = this.status;
        TagDeviceType tagDeviceType = this.deviceType;
        return "AuthenticationTagUnregisterEntity(status=" + tagStatus + ", deviceType=" + tagDeviceType + ")";
    }

    public final TagStatus getStatus() {
        return this.status;
    }

    public final TagDeviceType getDeviceType() {
        return this.deviceType;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AuthenticationTagUnregisterEntity(TagStatus tagStatus, TagDeviceType tagDeviceType) {
        super(AuthenticationType.TAG);
        Intrinsics.checkNotNullParameter(tagStatus, NotificationCompat.CATEGORY_STATUS);
        Intrinsics.checkNotNullParameter(tagDeviceType, "deviceType");
        this.status = tagStatus;
        this.deviceType = tagDeviceType;
    }

    public byte[] toByte() {
        List mutableListOf = CollectionsKt.mutableListOf(Byte.valueOf((byte) getType().getCode()), Byte.valueOf((byte) this.status.getCode()));
        for (int i = 1; i < 7; i++) {
            mutableListOf.add((byte) 0);
        }
        mutableListOf.add(Byte.valueOf((byte) this.deviceType.getCode()));
        return CollectionsKt.toByteArray(mutableListOf);
    }
}
