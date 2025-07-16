package androidx.compose.ui.unit.fontscaling;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004J\u001e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/unit/fontscaling/MathUtils;", "", "()V", "constrainedMap", "", "rangeMin", "rangeMax", "valueMin", "valueMax", "value", "lerp", "start", "stop", "amount", "lerpInv", "a", "b", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MathUtils.android.kt */
public final class MathUtils {
    public static final int $stable = 0;
    public static final MathUtils INSTANCE = new MathUtils();

    public final float lerp(float f, float f2, float f3) {
        return f + ((f2 - f) * f3);
    }

    public final float lerpInv(float f, float f2, float f3) {
        if (f == f2) {
            return 0.0f;
        }
        return (f3 - f) / (f2 - f);
    }

    private MathUtils() {
    }

    public final float constrainedMap(float f, float f2, float f3, float f4, float f5) {
        return lerp(f, f2, Math.max(0.0f, Math.min(1.0f, lerpInv(f3, f4, f5))));
    }
}
