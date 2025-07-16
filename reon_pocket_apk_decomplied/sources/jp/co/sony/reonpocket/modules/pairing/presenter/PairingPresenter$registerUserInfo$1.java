package jp.co.sony.reonpocket.modules.pairing.presenter;

import android.content.Context;
import jp.co.sony.reonpocket.modules.pairing.view.PairingActivity;
import jp.co.sony.reonpocket.modules.pairing.view.PairingViewInput;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "result", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: PairingPresenter.kt */
final class PairingPresenter$registerUserInfo$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ PairingPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PairingPresenter$registerUserInfo$1(PairingPresenter pairingPresenter) {
        super(1);
        this.this$0 = pairingPresenter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        debugLogUtil.d("Table(DeviceInfoEntity) result:" + z);
        Context access$getAContext$p = this.this$0.aContext;
        Intrinsics.checkNotNull(access$getAContext$p, "null cannot be cast to non-null type jp.co.sony.reonpocket.modules.pairing.view.PairingActivity");
        ((PairingActivity) access$getAContext$p).runOnUiThread(new PairingPresenter$registerUserInfo$1$$ExternalSyntheticLambda0(this.this$0));
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(PairingPresenter pairingPresenter) {
        Intrinsics.checkNotNullParameter(pairingPresenter, "this$0");
        PairingViewInput access$getAView$p = pairingPresenter.aView;
        if (access$getAView$p != null) {
            access$getAView$p.onFinishSend();
        }
    }
}
