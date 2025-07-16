package jp.co.sony.reonpocket.data.interactor;

import java.util.ArrayList;
import jp.co.sony.reon.android.ble.constant.TagGattProfileConstant;
import jp.co.sony.reonpocket.constant.BleConnStatusCode;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "bleConnStatusCode", "Ljp/co/sony/reonpocket/constant/BleConnStatusCode;", "<anonymous parameter 2>", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagWriteInteractor.kt */
final class TagWriteInteractor$startWrite$1 extends Lambda implements Function3<String, BleConnStatusCode, ArrayList<String>, Unit> {
    final /* synthetic */ TagGattProfileConstant.DeviceControlService $serviceCharacteristic;
    final /* synthetic */ TagWriteInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TagWriteInteractor$startWrite$1(TagWriteInteractor tagWriteInteractor, TagGattProfileConstant.DeviceControlService deviceControlService) {
        super(3);
        this.this$0 = tagWriteInteractor;
        this.$serviceCharacteristic = deviceControlService;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((String) obj, (BleConnStatusCode) obj2, (ArrayList<String>) (ArrayList) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(String str, BleConnStatusCode bleConnStatusCode, ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(bleConnStatusCode, "bleConnStatusCode");
        if (!this.this$0.mBleInteractor.getIsTagConnected() || !this.this$0.canReceiveTagConnectCallbackListener) {
            this.this$0.mBleInteractor.disconnectTag();
            DebugLogUtil.INSTANCE.e("tag data error: Tag is not connected");
            return;
        }
        this.this$0.onTagConnectionStatus(bleConnStatusCode, this.$serviceCharacteristic);
    }
}
