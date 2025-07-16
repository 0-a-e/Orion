package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J8\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/android/style/LineHeightSpan;", "Landroid/text/style/LineHeightSpan;", "lineHeight", "", "(F)V", "getLineHeight", "()F", "chooseHeight", "", "text", "", "start", "", "end", "spanstartVertical", "fontMetricsInt", "Landroid/graphics/Paint$FontMetricsInt;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LineHeightSpan.kt */
public final class LineHeightSpan implements android.text.style.LineHeightSpan {
    public static final int $stable = 0;
    private final float lineHeight;

    public LineHeightSpan(float f) {
        this.lineHeight = f;
    }

    public final float getLineHeight() {
        return this.lineHeight;
    }

    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        int lineHeight2 = LineHeightStyleSpanKt.lineHeight(fontMetricsInt);
        if (lineHeight2 > 0) {
            int ceil = (int) ((float) Math.ceil((double) this.lineHeight));
            fontMetricsInt.descent = (int) Math.ceil(((double) fontMetricsInt.descent) * ((double) ((((float) ceil) * 1.0f) / ((float) lineHeight2))));
            fontMetricsInt.ascent = fontMetricsInt.descent - ceil;
        }
    }
}
