package androidx.compose.ui.text.android.style;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\f\u0010\f\u001a\u00020\b*\u00020\nH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Landroidx/compose/ui/text/android/style/LetterSpacingSpanPx;", "Landroid/text/style/MetricAffectingSpan;", "letterSpacing", "", "(F)V", "getLetterSpacing", "()F", "updateDrawState", "", "textPaint", "Landroid/text/TextPaint;", "updateMeasureState", "updatePaint", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LetterSpacingSpanPx.kt */
public final class LetterSpacingSpanPx extends MetricAffectingSpan {
    public static final int $stable = 0;
    private final float letterSpacing;

    public LetterSpacingSpanPx(float f) {
        this.letterSpacing = f;
    }

    public final float getLetterSpacing() {
        return this.letterSpacing;
    }

    private final void updatePaint(TextPaint textPaint) {
        float textSize = textPaint.getTextSize() * textPaint.getTextScaleX();
        if (textSize != 0.0f) {
            textPaint.setLetterSpacing(this.letterSpacing / textSize);
        }
    }

    public void updateDrawState(TextPaint textPaint) {
        updatePaint(textPaint);
    }

    public void updateMeasureState(TextPaint textPaint) {
        updatePaint(textPaint);
    }
}
