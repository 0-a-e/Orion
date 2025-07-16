package androidx.compose.ui.unit;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Velocity", "Landroidx/compose/ui/unit/Velocity;", "x", "", "y", "(FF)J", "ui-unit_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Velocity.kt */
public final class VelocityKt {
    public static final long Velocity(float f, float f2) {
        long floatToRawIntBits = (long) Float.floatToRawIntBits(f);
        return Velocity.m6849constructorimpl((((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (floatToRawIntBits << 32));
    }
}
