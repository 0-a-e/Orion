package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J5\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\r\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, d2 = {"androidx/compose/ui/graphics/colorspace/Connector$Companion$identity$1", "Landroidx/compose/ui/graphics/colorspace/Connector;", "transform", "", "v", "transformToColor", "Landroidx/compose/ui/graphics/Color;", "r", "", "g", "b", "a", "transformToColor-wmQWz5c$ui_graphics_release", "(FFFF)J", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Connector.kt */
public final class Connector$Companion$identity$1 extends Connector {
    public float[] transform(float[] fArr) {
        return fArr;
    }

    Connector$Companion$identity$1(ColorSpace colorSpace, int i) {
        super(colorSpace, colorSpace, i, (DefaultConstructorMarker) null);
    }

    /* renamed from: transformToColor-wmQWz5c$ui_graphics_release  reason: not valid java name */
    public long m4302transformToColorwmQWz5c$ui_graphics_release(float f, float f2, float f3, float f4) {
        return ColorKt.Color(f, f2, f3, f4, getDestination());
    }
}
