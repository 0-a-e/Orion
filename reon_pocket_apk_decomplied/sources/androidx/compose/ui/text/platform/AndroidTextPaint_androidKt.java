package androidx.compose.ui.text.platform;

import android.text.TextPaint;
import kotlin.Metadata;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"setAlpha", "", "Landroid/text/TextPaint;", "alpha", "", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidTextPaint.android.kt */
public final class AndroidTextPaint_androidKt {
    public static final void setAlpha(TextPaint textPaint, float f) {
        if (!Float.isNaN(f)) {
            textPaint.setAlpha(MathKt.roundToInt(RangesKt.coerceIn(f, 0.0f, 1.0f) * ((float) 255)));
        }
    }
}
