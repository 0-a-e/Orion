package jp.co.sony.reonpocket.data.entity;

import androidx.core.app.NotificationCompat;
import jp.co.sony.reonpocket.constant.AuthenticationType;
import jp.co.sony.reonpocket.constant.OwnerStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/AuthenticationOwnerRegisterEntity;", "Ljp/co/sony/reonpocket/data/entity/AuthenticationOwnerEntity;", "status", "Ljp/co/sony/reonpocket/constant/OwnerStatus;", "ownerId", "", "(Ljp/co/sony/reonpocket/constant/OwnerStatus;Ljava/lang/String;)V", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AuthenticationEntity.kt */
public final class AuthenticationOwnerRegisterEntity extends AuthenticationOwnerEntity {
    public static final int $stable = 0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AuthenticationOwnerRegisterEntity(OwnerStatus ownerStatus, String str) {
        super(AuthenticationType.OWNER, ownerStatus, str);
        Intrinsics.checkNotNullParameter(ownerStatus, NotificationCompat.CATEGORY_STATUS);
    }
}
