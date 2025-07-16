package jp.co.sony.reonpocket.modules.main.presenter;

import java.util.ArrayList;
import jp.co.sony.reonpocket.constant.BleConnStatusCode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "bleConnStatusCode", "Ljp/co/sony/reonpocket/constant/BleConnStatusCode;", "arrayList", "Ljava/util/ArrayList;", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainPresenter.kt */
final class MainPresenter$registerConnectCallbackListener$1 extends Lambda implements Function2<BleConnStatusCode, ArrayList<String>, Unit> {
    final /* synthetic */ MainPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainPresenter$registerConnectCallbackListener$1(MainPresenter mainPresenter) {
        super(2);
        this.this$0 = mainPresenter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((BleConnStatusCode) obj, (ArrayList<String>) (ArrayList) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(BleConnStatusCode bleConnStatusCode, ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(bleConnStatusCode, "bleConnStatusCode");
        this.this$0.onConnectionStatus(bleConnStatusCode, arrayList);
    }
}
