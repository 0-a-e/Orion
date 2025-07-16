package jp.co.sony.reonpocket.util;

import android.content.Context;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/util/CrashlyticsUtil;", "", "()V", "setFBCrashlyticsCollectionSetting", "", "aContext", "Landroid/content/Context;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CrashlyticsUtil.kt */
public final class CrashlyticsUtil {
    public static final int $stable = 0;
    public static final CrashlyticsUtil INSTANCE = new CrashlyticsUtil();

    private CrashlyticsUtil() {
    }

    public final void setFBCrashlyticsCollectionSetting(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(MyContentUtil.isSupportLog$default(MyContentUtil.INSTANCE, context, (String) null, 2, (Object) null));
    }
}
