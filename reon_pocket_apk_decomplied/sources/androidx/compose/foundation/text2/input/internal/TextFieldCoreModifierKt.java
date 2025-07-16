package androidx.compose.foundation.text2.input.internal;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a.\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000eH\u0002\u001a\f\u0010\u0013\u001a\u00020\u0005*\u00020\u0005H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0006\u001a\u00020\u0007*\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\t¨\u0006\u0014"}, d2 = {"DefaultCursorThickness", "Landroidx/compose/ui/unit/Dp;", "F", "cursorAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "isSpecified", "", "Landroidx/compose/ui/graphics/Brush;", "(Landroidx/compose/ui/graphics/Brush;)Z", "getCursorRectInScroller", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/Density;", "cursorOffset", "", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "rtl", "textFieldWidth", "roundToNext", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldCoreModifier.kt */
public final class TextFieldCoreModifierKt {
    private static final float DefaultCursorThickness = Dp.m6614constructorimpl((float) 2);
    /* access modifiers changed from: private */
    public static final AnimationSpec<Float> cursorAnimationSpec = AnimationSpecKt.m130infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(TextFieldCoreModifierKt$cursorAnimationSpec$1.INSTANCE), (RepeatMode) null, 0, 6, (Object) null);

    /* access modifiers changed from: private */
    public static final boolean isSpecified(Brush brush) {
        return !(brush instanceof SolidColor) || ((SolidColor) brush).m4212getValue0d7_KjU() != Color.Companion.m3852getUnspecified0d7_KjU();
    }

    /* access modifiers changed from: private */
    public static final Rect getCursorRectInScroller(Density density, int i, TextLayoutResult textLayoutResult, boolean z, int i2) {
        Rect rect;
        float f;
        float f2;
        if (textLayoutResult == null || (rect = textLayoutResult.getCursorRect(RangesKt.coerceIn(i, (ClosedRange<Integer>) new IntRange(0, textLayoutResult.getLayoutInput().getText().length())))) == null) {
            rect = Rect.Companion.getZero();
        }
        Rect rect2 = rect;
        int r7 = density.m6545roundToPx0680j_4(DefaultCursorThickness);
        if (z) {
            f = (((float) i2) - rect2.getLeft()) - ((float) r7);
        } else {
            f = rect2.getLeft();
        }
        float f3 = f;
        if (z) {
            f2 = ((float) i2) - rect2.getLeft();
        } else {
            f2 = rect2.getLeft() + ((float) r7);
        }
        return Rect.copy$default(rect2, f3, 0.0f, f2, 0.0f, 10, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final float roundToNext(float f) {
        double d;
        if (Float.isNaN(f) || Float.isInfinite(f)) {
            return f;
        }
        if (f > 0.0f) {
            d = Math.ceil((double) f);
        } else {
            d = Math.floor((double) f);
        }
        return (float) d;
    }
}
