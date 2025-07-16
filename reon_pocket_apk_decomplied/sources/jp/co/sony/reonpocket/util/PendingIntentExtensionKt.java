package jp.co.sony.reonpocket.util;

import android.os.Build;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0003"}, d2 = {"asPendingIntentImmutableFlag", "", "asPendingIntentMutableFlag", "app_prodRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: PendingIntentExtension.kt */
public final class PendingIntentExtensionKt {
    public static final int asPendingIntentImmutableFlag(int i) {
        return i | AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
    }

    public static final int asPendingIntentMutableFlag(int i) {
        return Build.VERSION.SDK_INT >= 31 ? i | 33554432 : i;
    }
}
