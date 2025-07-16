package jp.co.sony.reonpocket.connection.aws;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JE\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2%\b\u0002\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\fJE\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2%\b\u0002\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f¨\u0006\u0013"}, d2 = {"Ljp/co/sony/reonpocket/connection/aws/AWSManager;", "", "()V", "registerDeviceInfo", "", "aContext", "Landroid/content/Context;", "aDeviceInfoEntity", "Ljp/co/sony/reonpocket/connection/aws/DeviceInfoEntity;", "aIsCreate", "", "aCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "aResult", "registerUserInfo", "aUserInfoEntity", "Ljp/co/sony/reonpocket/connection/aws/UserInfoEntity;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AWSManager.kt */
public final class AWSManager {
    public static final int $stable = 0;
    public static final AWSManager INSTANCE = new AWSManager();

    private AWSManager() {
    }

    public static /* synthetic */ void registerUserInfo$default(AWSManager aWSManager, Context context, UserInfoEntity userInfoEntity, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            function1 = null;
        }
        aWSManager.registerUserInfo(context, userInfoEntity, z, function1);
    }

    public final void registerUserInfo(Context context, UserInfoEntity userInfoEntity, boolean z, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(userInfoEntity, "aUserInfoEntity");
        DynamoDBManager.INSTANCE.registerUserInfo(context, userInfoEntity, z, function1);
    }

    public static /* synthetic */ void registerDeviceInfo$default(AWSManager aWSManager, Context context, DeviceInfoEntity deviceInfoEntity, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            function1 = null;
        }
        aWSManager.registerDeviceInfo(context, deviceInfoEntity, z, function1);
    }

    public final void registerDeviceInfo(Context context, DeviceInfoEntity deviceInfoEntity, boolean z, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(deviceInfoEntity, "aDeviceInfoEntity");
        DynamoDBManager.INSTANCE.registerDeviceInfo(context, deviceInfoEntity, z, function1);
    }
}
