package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import android.text.Layout;
import androidx.compose.ui.text.android.TextLayoutKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000\u001a\u001e\u0010\t\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"EllipsisChar", "", "getEllipsizedLeftPadding", "", "Landroid/text/Layout;", "lineIndex", "", "paint", "Landroid/graphics/Paint;", "getEllipsizedRightPadding", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: IndentationFixSpan.kt */
public final class IndentationFixSpanKt {
    private static final String EllipsisChar = "…";

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: IndentationFixSpan.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            try {
                iArr[Layout.Alignment.ALIGN_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ float getEllipsizedLeftPadding$default(Layout layout, int i, Paint paint, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            paint = layout.getPaint();
        }
        return getEllipsizedLeftPadding(layout, i, paint);
    }

    public static final float getEllipsizedLeftPadding(Layout layout, int i, Paint paint) {
        float f;
        float f2;
        float lineLeft = layout.getLineLeft(i);
        if (!TextLayoutKt.isLineEllipsized(layout, i) || layout.getParagraphDirection(i) != 1 || lineLeft >= 0.0f) {
            return 0.0f;
        }
        float primaryHorizontal = (layout.getPrimaryHorizontal(layout.getLineStart(i) + layout.getEllipsisStart(i)) - lineLeft) + paint.measureText(EllipsisChar);
        Layout.Alignment paragraphAlignment = layout.getParagraphAlignment(i);
        if ((paragraphAlignment == null ? -1 : WhenMappings.$EnumSwitchMapping$0[paragraphAlignment.ordinal()]) == 1) {
            f = Math.abs(lineLeft);
            f2 = (((float) layout.getWidth()) - primaryHorizontal) / 2.0f;
        } else {
            f = Math.abs(lineLeft);
            f2 = ((float) layout.getWidth()) - primaryHorizontal;
        }
        return f + f2;
    }

    public static /* synthetic */ float getEllipsizedRightPadding$default(Layout layout, int i, Paint paint, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            paint = layout.getPaint();
        }
        return getEllipsizedRightPadding(layout, i, paint);
    }

    public static final float getEllipsizedRightPadding(Layout layout, int i, Paint paint) {
        float f;
        float f2;
        if (!TextLayoutKt.isLineEllipsized(layout, i)) {
            return 0.0f;
        }
        int i2 = -1;
        if (layout.getParagraphDirection(i) != -1 || ((float) layout.getWidth()) >= layout.getLineRight(i)) {
            return 0.0f;
        }
        float lineRight = (layout.getLineRight(i) - layout.getPrimaryHorizontal(layout.getLineStart(i) + layout.getEllipsisStart(i))) + paint.measureText(EllipsisChar);
        Layout.Alignment paragraphAlignment = layout.getParagraphAlignment(i);
        if (paragraphAlignment != null) {
            i2 = WhenMappings.$EnumSwitchMapping$0[paragraphAlignment.ordinal()];
        }
        if (i2 == 1) {
            f = ((float) layout.getWidth()) - layout.getLineRight(i);
            f2 = (((float) layout.getWidth()) - lineRight) / 2.0f;
        } else {
            f = ((float) layout.getWidth()) - layout.getLineRight(i);
            f2 = ((float) layout.getWidth()) - lineRight;
        }
        return f - f2;
    }
}
