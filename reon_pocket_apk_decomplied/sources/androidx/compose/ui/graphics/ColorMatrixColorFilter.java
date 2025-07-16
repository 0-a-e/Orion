package androidx.compose.ui.graphics;

import android.graphics.ColorFilter;
import com.amazonaws.services.s3.internal.Constants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001d\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0015\u0010\u0014\u001a\u00020\u0003H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\t\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/graphics/ColorMatrixColorFilter;", "Landroidx/compose/ui/graphics/ColorFilter;", "colorMatrix", "Landroidx/compose/ui/graphics/ColorMatrix;", "([FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "nativeColorFilter", "Landroid/graphics/ColorFilter;", "Landroidx/compose/ui/graphics/NativeColorFilter;", "([FLandroid/graphics/ColorFilter;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "[F", "copyColorMatrix", "targetColorMatrix", "copyColorMatrix-gBh15pI", "([F)[F", "equals", "", "other", "", "hashCode", "", "obtainColorMatrix", "obtainColorMatrix-p10-uLo", "()[F", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ColorFilter.kt */
public final class ColorMatrixColorFilter extends ColorFilter {
    private float[] colorMatrix;

    public /* synthetic */ ColorMatrixColorFilter(float[] fArr, ColorFilter colorFilter, DefaultConstructorMarker defaultConstructorMarker) {
        this(fArr, colorFilter);
    }

    public /* synthetic */ ColorMatrixColorFilter(float[] fArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(fArr);
    }

    private ColorMatrixColorFilter(float[] fArr, ColorFilter colorFilter) {
        super(colorFilter);
        this.colorMatrix = fArr;
    }

    private ColorMatrixColorFilter(float[] fArr) {
        this(fArr, AndroidColorFilter_androidKt.m3668actualColorMatrixColorFilterjHGOpc(fArr), (DefaultConstructorMarker) null);
    }

    /* renamed from: copyColorMatrix-gBh15pI$default  reason: not valid java name */
    public static /* synthetic */ float[] m3893copyColorMatrixgBh15pI$default(ColorMatrixColorFilter colorMatrixColorFilter, float[] fArr, int i, Object obj) {
        if ((i & 1) != 0) {
            fArr = ColorMatrix.m3873constructorimpl$default((float[]) null, 1, (DefaultConstructorMarker) null);
        }
        return colorMatrixColorFilter.m3895copyColorMatrixgBh15pI(fArr);
    }

    /* renamed from: copyColorMatrix-gBh15pI  reason: not valid java name */
    public final float[] m3895copyColorMatrixgBh15pI(float[] fArr) {
        ArraysKt.copyInto$default(m3894obtainColorMatrixp10uLo(), fArr, 0, 0, 0, 14, (Object) null);
        return fArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ColorMatrixColorFilter) && Arrays.equals(m3894obtainColorMatrixp10uLo(), ((ColorMatrixColorFilter) obj).m3894obtainColorMatrixp10uLo());
    }

    /* renamed from: obtainColorMatrix-p10-uLo  reason: not valid java name */
    private final float[] m3894obtainColorMatrixp10uLo() {
        float[] fArr = this.colorMatrix;
        if (fArr != null) {
            return fArr;
        }
        float[] actualColorMatrixFromFilter = AndroidColorFilter_androidKt.actualColorMatrixFromFilter(getNativeColorFilter$ui_graphics_release());
        this.colorMatrix = actualColorMatrixFromFilter;
        return actualColorMatrixFromFilter;
    }

    public int hashCode() {
        float[] fArr = this.colorMatrix;
        if (fArr != null) {
            return ColorMatrix.m3880hashCodeimpl(fArr);
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ColorMatrixColorFilter(colorMatrix=");
        float[] fArr = this.colorMatrix;
        sb.append(fArr == null ? Constants.NULL_VERSION_ID : ColorMatrix.m3891toStringimpl(fArr));
        sb.append(')');
        return sb.toString();
    }
}
