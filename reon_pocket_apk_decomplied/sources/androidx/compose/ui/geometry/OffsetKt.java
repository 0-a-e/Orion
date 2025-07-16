package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0011\u001a*\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a%\u0010\u0018\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aH\bø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001e\u0010\u0007\u001a\u00020\u0001*\u00020\u00028FX\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"isFinite", "", "Landroidx/compose/ui/geometry/Offset;", "isFinite-k-4lQ0M$annotations", "(J)V", "isFinite-k-4lQ0M", "(J)Z", "isSpecified", "isSpecified-k-4lQ0M$annotations", "isSpecified-k-4lQ0M", "isUnspecified", "isUnspecified-k-4lQ0M$annotations", "isUnspecified-k-4lQ0M", "Offset", "x", "", "y", "(FF)J", "lerp", "start", "stop", "fraction", "lerp-Wko1d7g", "(JJF)J", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-3MmeM6k", "(JLkotlin/jvm/functions/Function0;)J", "ui-geometry_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Offset.kt */
public final class OffsetKt {
    /* renamed from: isFinite-k-4lQ0M$annotations  reason: not valid java name */
    public static /* synthetic */ void m3580isFinitek4lQ0M$annotations(long j) {
    }

    /* renamed from: isSpecified-k-4lQ0M$annotations  reason: not valid java name */
    public static /* synthetic */ void m3582isSpecifiedk4lQ0M$annotations(long j) {
    }

    /* renamed from: isUnspecified-k-4lQ0M$annotations  reason: not valid java name */
    public static /* synthetic */ void m3584isUnspecifiedk4lQ0M$annotations(long j) {
    }

    /* renamed from: lerp-Wko1d7g  reason: not valid java name */
    public static final long m3585lerpWko1d7g(long j, long j2, float f) {
        return Offset(MathHelpersKt.lerp(Offset.m3562getXimpl(j), Offset.m3562getXimpl(j2), f), MathHelpersKt.lerp(Offset.m3563getYimpl(j), Offset.m3563getYimpl(j2), f));
    }

    /* renamed from: isFinite-k-4lQ0M  reason: not valid java name */
    public static final boolean m3579isFinitek4lQ0M(long j) {
        float r0 = Offset.m3562getXimpl(j);
        if (!Float.isInfinite(r0) && !Float.isNaN(r0)) {
            float r2 = Offset.m3563getYimpl(j);
            return !Float.isInfinite(r2) && !Float.isNaN(r2);
        }
    }

    /* renamed from: isSpecified-k-4lQ0M  reason: not valid java name */
    public static final boolean m3581isSpecifiedk4lQ0M(long j) {
        return j != Offset.Companion.m3577getUnspecifiedF1C5BW0();
    }

    /* renamed from: isUnspecified-k-4lQ0M  reason: not valid java name */
    public static final boolean m3583isUnspecifiedk4lQ0M(long j) {
        return j == Offset.Companion.m3577getUnspecifiedF1C5BW0();
    }

    /* renamed from: takeOrElse-3MmeM6k  reason: not valid java name */
    public static final long m3586takeOrElse3MmeM6k(long j, Function0<Offset> function0) {
        return m3581isSpecifiedk4lQ0M(j) ? j : function0.invoke().m3572unboximpl();
    }

    public static final long Offset(float f, float f2) {
        long floatToRawIntBits = (long) Float.floatToRawIntBits(f);
        return Offset.m3554constructorimpl((((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (floatToRawIntBits << 32));
    }
}
