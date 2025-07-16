package jp.co.sony.reonpocket.data.entity;

import androidx.core.app.NotificationCompat;
import java.util.List;
import jp.co.sony.reonpocket.constant.OwnerStatus;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/SetOwnerEntity;", "", "status", "Ljp/co/sony/reonpocket/constant/OwnerStatus;", "ownerId", "", "(Ljp/co/sony/reonpocket/constant/OwnerStatus;Ljava/lang/String;)V", "getOwnerId", "()Ljava/lang/String;", "getStatus", "()Ljp/co/sony/reonpocket/constant/OwnerStatus;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toByte", "", "toString", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SetOwnerEntity.kt */
public final class SetOwnerEntity {
    public static final int $stable = 0;
    private final String ownerId;
    private final OwnerStatus status;

    public static /* synthetic */ SetOwnerEntity copy$default(SetOwnerEntity setOwnerEntity, OwnerStatus ownerStatus, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            ownerStatus = setOwnerEntity.status;
        }
        if ((i & 2) != 0) {
            str = setOwnerEntity.ownerId;
        }
        return setOwnerEntity.copy(ownerStatus, str);
    }

    public final OwnerStatus component1() {
        return this.status;
    }

    public final String component2() {
        return this.ownerId;
    }

    public final SetOwnerEntity copy(OwnerStatus ownerStatus, String str) {
        Intrinsics.checkNotNullParameter(ownerStatus, NotificationCompat.CATEGORY_STATUS);
        return new SetOwnerEntity(ownerStatus, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SetOwnerEntity)) {
            return false;
        }
        SetOwnerEntity setOwnerEntity = (SetOwnerEntity) obj;
        return this.status == setOwnerEntity.status && Intrinsics.areEqual((Object) this.ownerId, (Object) setOwnerEntity.ownerId);
    }

    public int hashCode() {
        int hashCode = this.status.hashCode() * 31;
        String str = this.ownerId;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        OwnerStatus ownerStatus = this.status;
        String str = this.ownerId;
        return "SetOwnerEntity(status=" + ownerStatus + ", ownerId=" + str + ")";
    }

    public SetOwnerEntity(OwnerStatus ownerStatus, String str) {
        Intrinsics.checkNotNullParameter(ownerStatus, NotificationCompat.CATEGORY_STATUS);
        this.status = ownerStatus;
        this.ownerId = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SetOwnerEntity(OwnerStatus ownerStatus, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? OwnerStatus.REGISTER : ownerStatus, str);
    }

    public final OwnerStatus getStatus() {
        return this.status;
    }

    public final String getOwnerId() {
        return this.ownerId;
    }

    public final byte[] toByte() {
        String str = this.ownerId;
        if (str == null) {
            return null;
        }
        List<String> split = new Regex("\\s+").split(str, 0);
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        String str2 = this.ownerId;
        debugLogUtil.d("ownerId: " + str2);
        List mutableListOf = CollectionsKt.mutableListOf(Byte.valueOf((byte) this.status.getCode()));
        for (String next : split) {
            if (next.length() > 0 && !Intrinsics.areEqual((Object) next, (Object) " ")) {
                mutableListOf.add(Byte.valueOf((byte) Integer.parseInt(next)));
            }
        }
        return CollectionsKt.toByteArray(mutableListOf);
    }
}
