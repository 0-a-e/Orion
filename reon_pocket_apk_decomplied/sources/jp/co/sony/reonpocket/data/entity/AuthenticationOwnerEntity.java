package jp.co.sony.reonpocket.data.entity;

import androidx.core.app.NotificationCompat;
import java.util.List;
import jp.co.sony.reonpocket.constant.AuthenticationType;
import jp.co.sony.reonpocket.constant.OwnerStatus;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0000\b'\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/AuthenticationOwnerEntity;", "Ljp/co/sony/reonpocket/data/entity/AuthenticationEntity;", "authenticationType", "Ljp/co/sony/reonpocket/constant/AuthenticationType;", "status", "Ljp/co/sony/reonpocket/constant/OwnerStatus;", "ownerId", "", "(Ljp/co/sony/reonpocket/constant/AuthenticationType;Ljp/co/sony/reonpocket/constant/OwnerStatus;Ljava/lang/String;)V", "getOwnerId", "()Ljava/lang/String;", "getStatus", "()Ljp/co/sony/reonpocket/constant/OwnerStatus;", "toByte", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AuthenticationEntity.kt */
public abstract class AuthenticationOwnerEntity extends AuthenticationEntity {
    public static final int $stable = 0;
    private final String ownerId;
    private final OwnerStatus status;

    public final OwnerStatus getStatus() {
        return this.status;
    }

    public final String getOwnerId() {
        return this.ownerId;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AuthenticationOwnerEntity(AuthenticationType authenticationType, OwnerStatus ownerStatus, String str) {
        super(authenticationType);
        Intrinsics.checkNotNullParameter(authenticationType, "authenticationType");
        Intrinsics.checkNotNullParameter(ownerStatus, NotificationCompat.CATEGORY_STATUS);
        this.status = ownerStatus;
        this.ownerId = str;
    }

    public byte[] toByte() {
        String str = this.ownerId;
        if (str == null) {
            return null;
        }
        List<String> split = new Regex("\\s+").split(str, 0);
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        String str2 = this.ownerId;
        debugLogUtil.d("ownerId: " + str2);
        List mutableListOf = CollectionsKt.mutableListOf(Byte.valueOf((byte) getType().getCode()), Byte.valueOf((byte) this.status.getCode()));
        for (String next : split) {
            if (next.length() > 0 && !Intrinsics.areEqual((Object) next, (Object) " ")) {
                mutableListOf.add(Byte.valueOf((byte) Integer.parseInt(next)));
            }
        }
        return CollectionsKt.toByteArray(mutableListOf);
    }
}
