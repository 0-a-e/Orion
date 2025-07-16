package jp.co.sony.reonpocket.util;

import android.content.Context;
import android.os.Build;
import java.util.Locale;
import jp.co.sony.reonpocket.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Ljp/co/sony/reonpocket/util/LocaleUtil;", "", "()V", "getLocale", "Ljava/util/Locale;", "aContext", "Landroid/content/Context;", "isRtl", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocaleUtil.kt */
public final class LocaleUtil {
    public static final int $stable = 0;
    public static final LocaleUtil INSTANCE = new LocaleUtil();

    private LocaleUtil() {
    }

    public final boolean isRtl(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        return context.getResources().getBoolean(R.bool.is_right_to_left);
    }

    public final Locale getLocale(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        if (Build.VERSION.SDK_INT >= 24) {
            Locale m = context.getResources().getConfiguration().getLocales().get(0);
            Intrinsics.checkNotNull(m);
            return m;
        }
        Locale locale = context.getResources().getConfiguration().locale;
        Intrinsics.checkNotNull(locale);
        return locale;
    }
}
