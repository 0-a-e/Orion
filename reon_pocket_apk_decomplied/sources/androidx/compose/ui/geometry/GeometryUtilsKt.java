package androidx.compose.ui.geometry;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"toStringAsFixed", "", "", "digits", "", "ui-geometry_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: GeometryUtils.kt */
public final class GeometryUtilsKt {
    public static final String toStringAsFixed(float f, int i) {
        int max = Math.max(i, 0);
        float pow = (float) Math.pow((double) 10.0f, (double) max);
        float f2 = f * pow;
        int i2 = (int) f2;
        if (f2 - ((float) i2) >= 0.5f) {
            i2++;
        }
        float f3 = ((float) i2) / pow;
        if (max > 0) {
            return String.valueOf(f3);
        }
        return String.valueOf((int) f3);
    }
}
