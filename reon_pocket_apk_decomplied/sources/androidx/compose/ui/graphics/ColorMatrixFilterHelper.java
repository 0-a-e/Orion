package androidx.compose.ui.graphics;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\t"}, d2 = {"Landroidx/compose/ui/graphics/ColorMatrixFilterHelper;", "", "()V", "getColorMatrix", "Landroidx/compose/ui/graphics/ColorMatrix;", "colorFilter", "Landroid/graphics/ColorMatrixColorFilter;", "getColorMatrix-8unuwjk", "(Landroid/graphics/ColorMatrixColorFilter;)[F", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidColorFilter.android.kt */
final class ColorMatrixFilterHelper {
    public static final ColorMatrixFilterHelper INSTANCE = new ColorMatrixFilterHelper();

    private ColorMatrixFilterHelper() {
    }

    /* renamed from: getColorMatrix-8unuwjk  reason: not valid java name */
    public final float[] m3896getColorMatrix8unuwjk(ColorMatrixColorFilter colorMatrixColorFilter) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrixColorFilter.getColorMatrix(colorMatrix);
        return ColorMatrix.m3872constructorimpl(colorMatrix.getArray());
    }
}
