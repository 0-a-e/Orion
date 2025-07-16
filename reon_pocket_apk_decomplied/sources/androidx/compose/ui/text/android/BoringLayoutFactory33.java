package androidx.compose.ui.text.android;

import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat$$ExternalSyntheticApiModelOutline0;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jf\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\nH\u0007J\"\u0010\u0018\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0004¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/text/android/BoringLayoutFactory33;", "", "()V", "create", "Landroid/text/BoringLayout;", "text", "", "paint", "Landroid/text/TextPaint;", "width", "", "alignment", "Landroid/text/Layout$Alignment;", "lineSpacingMultiplier", "", "lineSpacingExtra", "metrics", "Landroid/text/BoringLayout$Metrics;", "includePadding", "", "useFallbackLineSpacing", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "ellipsizedWidth", "isBoring", "textDir", "Landroid/text/TextDirectionHeuristic;", "isFallbackLineSpacingEnabled", "layout", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BoringLayoutFactory.kt */
final class BoringLayoutFactory33 {
    public static final BoringLayoutFactory33 INSTANCE = new BoringLayoutFactory33();

    private BoringLayoutFactory33() {
    }

    @JvmStatic
    public static final BoringLayout.Metrics isBoring(CharSequence charSequence, TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic) {
        return BoringLayout.isBoring(charSequence, textPaint, textDirectionHeuristic, true, (BoringLayout.Metrics) null);
    }

    public static /* synthetic */ BoringLayout create$default(CharSequence charSequence, TextPaint textPaint, int i, Layout.Alignment alignment, float f, float f2, BoringLayout.Metrics metrics, boolean z, boolean z2, TextUtils.TruncateAt truncateAt, int i2, int i3, Object obj) {
        int i4 = i3;
        return create(charSequence, textPaint, i, alignment, f, f2, metrics, z, z2, (i4 & 512) != 0 ? null : truncateAt, (i4 & 1024) != 0 ? i : i2);
    }

    @JvmStatic
    public static final BoringLayout create(CharSequence charSequence, TextPaint textPaint, int i, Layout.Alignment alignment, float f, float f2, BoringLayout.Metrics metrics, boolean z, boolean z2, TextUtils.TruncateAt truncateAt, int i2) {
        return NotificationCompat$$ExternalSyntheticApiModelOutline0.m(charSequence, textPaint, i, alignment, f, f2, metrics, z, truncateAt, i2, z2);
    }

    public final boolean isFallbackLineSpacingEnabled(BoringLayout boringLayout) {
        return boringLayout.isFallbackLineSpacingEnabled();
    }
}
