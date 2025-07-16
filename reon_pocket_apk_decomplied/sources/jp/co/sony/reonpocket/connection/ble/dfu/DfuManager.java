package jp.co.sony.reonpocket.connection.ble.dfu;

import android.content.Context;
import android.net.Uri;
import java.util.UUID;
import jp.co.sony.reonpocket.constant.GattProfileConstant;
import jp.co.sony.reonpocket.constant.ModelConstant;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.util.UuidHelperUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuProgressListener;
import no.nordicsemi.android.dfu.DfuServiceController;
import no.nordicsemi.android.dfu.DfuServiceInitiator;
import no.nordicsemi.android.dfu.DfuServiceListenerHelper;

@Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JO\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0007¢\u0006\u0002\u0010\u0017JO\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0007¢\u0006\u0002\u0010\u0017J\u0006\u0010\u0019\u001a\u00020\u000bJ\u000e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Ljp/co/sony/reonpocket/connection/ble/dfu/DfuManager;", "", "()V", "mDefaultDfuProgressListener", "jp/co/sony/reonpocket/connection/ble/dfu/DfuManager$mDefaultDfuProgressListener$1", "Ljp/co/sony/reonpocket/connection/ble/dfu/DfuManager$mDefaultDfuProgressListener$1;", "mDfuProgressListener", "Lno/nordicsemi/android/dfu/DfuProgressListener;", "mDfuServiceController", "Lno/nordicsemi/android/dfu/DfuServiceController;", "executeDfu", "", "aContext", "Landroid/content/Context;", "aMacAddress", "", "aDeviceName", "aRawResId", "", "aFilePath", "aFileStreamUri", "Landroid/net/Uri;", "aDfuProgressListener", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Landroid/net/Uri;Lno/nordicsemi/android/dfu/DfuProgressListener;)V", "executeTagDfu", "processAbort", "registerProgressListener", "unregisterProgressListener", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DfuManager.kt */
public final class DfuManager {
    public static final int $stable = 8;
    public static final DfuManager INSTANCE = new DfuManager();
    private static final DfuManager$mDefaultDfuProgressListener$1 mDefaultDfuProgressListener = new DfuManager$mDefaultDfuProgressListener$1();
    /* access modifiers changed from: private */
    public static DfuProgressListener mDfuProgressListener;
    private static DfuServiceController mDfuServiceController;

    private DfuManager() {
    }

    public final void registerProgressListener(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        DebugLogUtil.INSTANCE.v("");
        DfuServiceListenerHelper.registerProgressListener(context, mDefaultDfuProgressListener);
    }

    public final void unregisterProgressListener(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        DebugLogUtil.INSTANCE.v("");
        DfuServiceListenerHelper.unregisterProgressListener(context, mDefaultDfuProgressListener);
        mDfuProgressListener = null;
    }

    public static /* synthetic */ void executeDfu$default(DfuManager dfuManager, Context context, String str, String str2, Integer num, String str3, Uri uri, DfuProgressListener dfuProgressListener, int i, Object obj) {
        dfuManager.executeDfu(context, str, str2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : uri, dfuProgressListener);
    }

    public final void executeDfu(Context context, String str, String str2, Integer num, String str3, Uri uri, DfuProgressListener dfuProgressListener) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aMacAddress");
        Intrinsics.checkNotNullParameter(str2, "aDeviceName");
        Intrinsics.checkNotNullParameter(dfuProgressListener, "aDfuProgressListener");
        DebugLogUtil.INSTANCE.v("");
        UUID fromString = UUID.fromString(UuidHelperUtil.DfuService.INSTANCE.getLongUuidByShortUuid(GattProfileConstant.SERVICE_DEVICE_DFU));
        UUID fromString2 = UUID.fromString(UuidHelperUtil.DfuService.INSTANCE.getLongUuidByShortUuid(GattProfileConstant.CHARACTERISTIC_DFU_CONTROL_POINT));
        UUID fromString3 = UUID.fromString(UuidHelperUtil.DfuService.INSTANCE.getLongUuidByShortUuid(GattProfileConstant.CHARACTERISTIC_DFU_PACKET));
        mDfuProgressListener = dfuProgressListener;
        DfuServiceInitiator customUuidsForSecureDfu = new DfuServiceInitiator(str).setDeviceName(str2).setKeepBond(false).setForceDfu(false).setPacketsReceiptNotificationsEnabled(false).setPacketsReceiptNotificationsValue(12).setUnsafeExperimentalButtonlessServiceInSecureDfuEnabled(true).setDisableNotification(true).setForeground(false).setCustomUuidsForSecureDfu(fromString, fromString2, fromString3);
        Integer resByDfuModelName = ModelConstant.INSTANCE.getResByDfuModelName(str2);
        if ((resByDfuModelName != null ? customUuidsForSecureDfu.setZip(resByDfuModelName.intValue()) : null) == null && !(str3 == null && uri == null)) {
            customUuidsForSecureDfu.setZip(uri, str3);
        }
        mDfuServiceController = customUuidsForSecureDfu.start(context, DfuService.class);
    }

    public static /* synthetic */ void executeTagDfu$default(DfuManager dfuManager, Context context, String str, String str2, Integer num, String str3, Uri uri, DfuProgressListener dfuProgressListener, int i, Object obj) {
        dfuManager.executeTagDfu(context, str, str2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : uri, dfuProgressListener);
    }

    public final void executeTagDfu(Context context, String str, String str2, Integer num, String str3, Uri uri, DfuProgressListener dfuProgressListener) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aMacAddress");
        Intrinsics.checkNotNullParameter(str2, "aDeviceName");
        Intrinsics.checkNotNullParameter(dfuProgressListener, "aDfuProgressListener");
        DebugLogUtil.INSTANCE.v("");
        UUID fromString = UUID.fromString(UuidHelperUtil.DfuService.INSTANCE.getLongUuidByShortUuid(GattProfileConstant.SERVICE_DEVICE_DFU));
        UUID fromString2 = UUID.fromString(UuidHelperUtil.DfuService.INSTANCE.getLongUuidByShortUuid(GattProfileConstant.CHARACTERISTIC_DFU_CONTROL_POINT));
        UUID fromString3 = UUID.fromString(UuidHelperUtil.DfuService.INSTANCE.getLongUuidByShortUuid(GattProfileConstant.CHARACTERISTIC_DFU_PACKET));
        mDfuProgressListener = dfuProgressListener;
        DfuServiceInitiator customUuidsForSecureDfu = new DfuServiceInitiator(str).setDeviceName(str2).setKeepBond(false).setForceDfu(false).setPacketsReceiptNotificationsEnabled(false).setPacketsReceiptNotificationsValue(12).setUnsafeExperimentalButtonlessServiceInSecureDfuEnabled(true).setDisableNotification(true).setForeground(false).setCustomUuidsForSecureDfu(fromString, fromString2, fromString3);
        Integer resByDfuTagModelName = ModelConstant.INSTANCE.getResByDfuTagModelName(str2);
        if ((resByDfuTagModelName != null ? customUuidsForSecureDfu.setZip(resByDfuTagModelName.intValue()) : null) == null && !(str3 == null && uri == null)) {
            customUuidsForSecureDfu.setZip(uri, str3);
        }
        mDfuServiceController = customUuidsForSecureDfu.start(context, DfuService.class);
    }

    public final void processAbort() {
        DfuServiceController dfuServiceController = mDfuServiceController;
        if (dfuServiceController != null) {
            dfuServiceController.abort();
        }
    }
}
