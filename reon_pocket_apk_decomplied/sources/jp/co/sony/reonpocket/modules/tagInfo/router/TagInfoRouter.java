package jp.co.sony.reonpocket.modules.tagInfo.router;

import jp.co.sony.reonpocket.modules.base.router.BaseRouter;
import jp.co.sony.reonpocket.modules.tagInfo.view.TagInfoActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ljp/co/sony/reonpocket/modules/tagInfo/router/TagInfoRouter;", "Ljp/co/sony/reonpocket/modules/base/router/BaseRouter;", "Ljp/co/sony/reonpocket/modules/tagInfo/router/TagInfoWireFrame;", "aActivity", "Ljp/co/sony/reonpocket/modules/tagInfo/view/TagInfoActivity;", "(Ljp/co/sony/reonpocket/modules/tagInfo/view/TagInfoActivity;)V", "goToChangeUserInfo", "", "goToLegal", "goToOss", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagInfoRouter.kt */
public final class TagInfoRouter extends BaseRouter implements TagInfoWireFrame {
    public static final int $stable = 8;
    private final TagInfoActivity aActivity;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TagInfoRouter(TagInfoActivity tagInfoActivity) {
        super(tagInfoActivity);
        Intrinsics.checkNotNullParameter(tagInfoActivity, "aActivity");
        this.aActivity = tagInfoActivity;
    }

    public void goToLegal() {
        this.aActivity.transitToLegalFragment();
    }

    public void goToChangeUserInfo() {
        this.aActivity.transitToChangeUserInfo();
    }

    public void goToOss() {
        this.aActivity.transitToOssContentFragment();
    }
}
