package jp.co.sony.reonpocket.util;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b¨\u0006\u000b"}, d2 = {"Ljp/co/sony/reonpocket/util/DensityUtil;", "", "()V", "dip2px", "", "aContext", "Landroid/content/Context;", "aDpValue", "", "px2dip", "aPxValue", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DensityUtil.kt */
public final class DensityUtil {
    public static final int $stable = 0;
    public static final DensityUtil INSTANCE = new DensityUtil();

    private DensityUtil() {
    }

    public final int dip2px(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final int px2dip(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
