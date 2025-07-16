package jp.co.sony.reonpocket.modules.deviceInfo.presenter;

import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: DeviceInfoPresenter.kt */
final class DeviceInfoPresenter$registerActionCallbackListener$1 extends Lambda implements Function1<BleDataEntity, Unit> {
    final /* synthetic */ DeviceInfoPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceInfoPresenter$registerActionCallbackListener$1(DeviceInfoPresenter deviceInfoPresenter) {
        super(1);
        this.this$0 = deviceInfoPresenter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BleDataEntity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(BleDataEntity bleDataEntity) {
        Intrinsics.checkNotNullParameter(bleDataEntity, "it");
        this.this$0.onDataReceived(bleDataEntity);
    }
}
