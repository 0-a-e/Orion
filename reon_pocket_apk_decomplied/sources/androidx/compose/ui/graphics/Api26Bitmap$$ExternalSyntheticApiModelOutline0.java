package androidx.compose.ui.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorSpace;
import java.util.function.DoubleUnaryOperator;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Api26Bitmap$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ BlendModeColorFilter m(int i, BlendMode blendMode) {
        return new BlendModeColorFilter(i, blendMode);
    }

    public static /* synthetic */ ColorSpace.Rgb m(String str, float[] fArr, float[] fArr2, ColorSpace.Rgb.TransferParameters transferParameters) {
        return new ColorSpace.Rgb(str, fArr, fArr2, transferParameters);
    }

    public static /* synthetic */ ColorSpace.Rgb m(String str, float[] fArr, float[] fArr2, DoubleUnaryOperator doubleUnaryOperator, DoubleUnaryOperator doubleUnaryOperator2, float f, float f2) {
        return new ColorSpace.Rgb(str, fArr, fArr2, doubleUnaryOperator, doubleUnaryOperator2, f, f2);
    }

    public static /* bridge */ /* synthetic */ boolean m$1(Object obj) {
        return obj instanceof ColorSpace.Rgb;
    }
}
