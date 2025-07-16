package jp.co.sony.reonpocket.modules.connect.presenter;

import java.util.ArrayList;
import jp.co.sony.reonpocket.constant.BleConnStatusCode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "bleConnStatusCode", "Ljp/co/sony/reonpocket/constant/BleConnStatusCode;", "arrayList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ConnectionPresenter.kt */
final class ConnectionPresenter$connectDFU$1 extends Lambda implements Function2<BleConnStatusCode, ArrayList<String>, Unit> {
    final /* synthetic */ ConnectionPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConnectionPresenter$connectDFU$1(ConnectionPresenter connectionPresenter) {
        super(2);
        this.this$0 = connectionPresenter;
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
