package jp.co.sony.reonpocket.connection.log.job;

import java.util.ArrayList;
import jp.co.sony.reon.android.ble.constant.ReasonCodeConstant;
import jp.co.sony.reon.android.ble.listener.ConnectCallbackListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u000b\u001a\u00020\u00032\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\b0\rj\b\u0012\u0004\u0012\u00020\b`\u000eH\u0016¨\u0006\u000f"}, d2 = {"jp/co/sony/reonpocket/connection/log/job/ReadLogJobTask$mConnectCallbackListener$1", "Ljp/co/sony/reon/android/ble/listener/ConnectCallbackListener;", "onConnectFailed", "", "aReason", "Ljp/co/sony/reon/android/ble/constant/ReasonCodeConstant;", "onConnected", "aMacAddress", "", "aDeviceName", "onConnectionSuspended", "onServicesDiscovered", "aServiceUuidList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ReadLogJobTask.kt */
public final class ReadLogJobTask$mConnectCallbackListener$1 implements ConnectCallbackListener {
    final /* synthetic */ ReadLogJobTask this$0;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ReadLogJobTask.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReasonCodeConstant.values().length];
            try {
                iArr[ReasonCodeConstant.MANUAL_DISCONNECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public void onConnected(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "aMacAddress");
    }

    ReadLogJobTask$mConnectCallbackListener$1(ReadLogJobTask readLogJobTask) {
        this.this$0 = readLogJobTask;
    }

    public void onConnectFailed(ReasonCodeConstant reasonCodeConstant) {
        Intrinsics.checkNotNullParameter(reasonCodeConstant, "aReason");
        this.this$0.handleJobFailed();
    }

    public void onConnectionSuspended(ReasonCodeConstant reasonCodeConstant) {
        Intrinsics.checkNotNullParameter(reasonCodeConstant, "aReason");
        this.this$0.unregisterDataCallbackListener();
        if (WhenMappings.$EnumSwitchMapping$0[reasonCodeConstant.ordinal()] != 1) {
            this.this$0.handleJobFailed();
        } else if (this.this$0.mJobInterrupt) {
            this.this$0.handleJobSuspended();
        } else {
            this.this$0.handleJobSuccess();
        }
    }

    public void onServicesDiscovered(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "aServiceUuidList");
        this.this$0.registerDataCallbackListener();
        this.this$0.writeOwner();
    }
}
