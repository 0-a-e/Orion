package jp.co.sony.reonpocket.modules.autoStart.router;

import jp.co.sony.reonpocket.modules.autoStart.view.AutoStartActivity;
import jp.co.sony.reonpocket.modules.base.router.BaseRouter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reonpocket/modules/autoStart/router/AutoStartRouter;", "Ljp/co/sony/reonpocket/modules/base/router/BaseRouter;", "aActivity", "Ljp/co/sony/reonpocket/modules/autoStart/view/AutoStartActivity;", "(Ljp/co/sony/reonpocket/modules/autoStart/view/AutoStartActivity;)V", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AutoStartRouter.kt */
public final class AutoStartRouter extends BaseRouter {
    public static final int $stable = 8;
    private final AutoStartActivity aActivity;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AutoStartRouter(AutoStartActivity autoStartActivity) {
        super(autoStartActivity);
        Intrinsics.checkNotNullParameter(autoStartActivity, "aActivity");
        this.aActivity = autoStartActivity;
    }
}
