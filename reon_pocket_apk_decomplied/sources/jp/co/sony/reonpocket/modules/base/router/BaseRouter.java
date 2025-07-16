package jp.co.sony.reonpocket.modules.base.router;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import jp.co.sony.reonpocket.modules.base.view.BaseActivity;
import jp.co.sony.reonpocket.util.MyContentUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nJ \u0010\u000b\u001a\u00020\u00062\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0004J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0004J \u0010\u0010\u001a\u00020\u00062\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0004J(\u0010\u0013\u001a\u00020\u00062\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0004J\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Ljp/co/sony/reonpocket/modules/base/router/BaseRouter;", "", "aActivity", "Ljp/co/sony/reonpocket/modules/base/view/BaseActivity;", "(Ljp/co/sony/reonpocket/modules/base/view/BaseActivity;)V", "finish", "", "goToStore", "jump2Url", "aUrl", "", "transitAndClear", "aClass", "Ljava/lang/Class;", "aBundle", "Landroid/os/Bundle;", "transitToActivity", "aIntent", "Landroid/content/Intent;", "transitToActivityForResult", "aRequestCode", "", "transitToEula", "aContext", "Landroid/content/Context;", "transitToPrivacy", "transitToSupport", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseRouter.kt */
public class BaseRouter {
    public static final int $stable = 8;
    private final BaseActivity aActivity;

    public BaseRouter(BaseActivity baseActivity) {
        Intrinsics.checkNotNullParameter(baseActivity, "aActivity");
        this.aActivity = baseActivity;
    }

    /* access modifiers changed from: protected */
    public final void transitToActivity(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "aIntent");
        this.aActivity.startActivity(intent);
    }

    public static /* synthetic */ void transitToActivity$default(BaseRouter baseRouter, Class cls, Bundle bundle, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                bundle = null;
            }
            baseRouter.transitToActivity(cls, bundle);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: transitToActivity");
    }

    /* access modifiers changed from: protected */
    public final void transitToActivity(Class<?> cls, Bundle bundle) {
        Intrinsics.checkNotNullParameter(cls, "aClass");
        Intent intent = new Intent(this.aActivity, cls);
        intent.setFlags(335544320);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        this.aActivity.startActivity(intent);
    }

    public static /* synthetic */ void transitToActivityForResult$default(BaseRouter baseRouter, Class cls, int i, Bundle bundle, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                bundle = null;
            }
            baseRouter.transitToActivityForResult(cls, i, bundle);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: transitToActivityForResult");
    }

    /* access modifiers changed from: protected */
    public final void transitToActivityForResult(Class<?> cls, int i, Bundle bundle) {
        Intrinsics.checkNotNullParameter(cls, "aClass");
        Intent intent = new Intent(this.aActivity, cls);
        intent.setFlags(603979776);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        this.aActivity.startActivityForResult(intent, i);
    }

    public static /* synthetic */ void transitAndClear$default(BaseRouter baseRouter, Class cls, Bundle bundle, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                bundle = null;
            }
            baseRouter.transitAndClear(cls, bundle);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: transitAndClear");
    }

    /* access modifiers changed from: protected */
    public final void transitAndClear(Class<?> cls, Bundle bundle) {
        Intrinsics.checkNotNullParameter(cls, "aClass");
        Intent intent = new Intent(this.aActivity, cls);
        intent.setFlags(268468224);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        this.aActivity.startActivity(intent);
    }

    public final void finish() {
        this.aActivity.finish();
    }

    public final void jump2Url(String str) {
        Intrinsics.checkNotNullParameter(str, "aUrl");
        this.aActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public final void transitToEula(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        jump2Url(MyContentUtil.getEulaURL$default(MyContentUtil.INSTANCE, context, (String) null, (String) null, 6, (Object) null));
    }

    public final void transitToPrivacy(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        jump2Url(MyContentUtil.getPrivacyURL$default(MyContentUtil.INSTANCE, context, (String) null, (String) null, 6, (Object) null));
    }

    public final void transitToSupport(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        jump2Url(MyContentUtil.getSupportURL$default(MyContentUtil.INSTANCE, context, (String) null, (String) null, 6, (Object) null));
    }

    public final void goToStore() {
        try {
            this.aActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=jp.co.sony.reonpocket")));
        } catch (ActivityNotFoundException unused) {
            this.aActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=jp.co.sony.reonpocket")));
        }
    }
}
