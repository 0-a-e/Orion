package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.util.VelocityTracker1D;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u0018ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0006J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u0012R\"\u0010\u0003\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "", "()V", "currentPointerPositionAccumulator", "Landroidx/compose/ui/geometry/Offset;", "getCurrentPointerPositionAccumulator-F1C5BW0$ui_release", "()J", "setCurrentPointerPositionAccumulator-k-4lQ0M$ui_release", "(J)V", "J", "lastMoveEventTimeStamp", "", "getLastMoveEventTimeStamp$ui_release", "setLastMoveEventTimeStamp$ui_release", "xVelocityTracker", "Landroidx/compose/ui/input/pointer/util/VelocityTracker1D;", "yVelocityTracker", "addPosition", "", "timeMillis", "position", "addPosition-Uv8p0NA", "(JJ)V", "calculateVelocity", "Landroidx/compose/ui/unit/Velocity;", "calculateVelocity-9UxMQ8M", "maximumVelocity", "calculateVelocity-AH228Gc", "(J)J", "resetTracking", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: VelocityTracker.kt */
public final class VelocityTracker {
    public static final int $stable = 8;
    private long currentPointerPositionAccumulator = Offset.Companion.m3578getZeroF1C5BW0();
    private long lastMoveEventTimeStamp;
    private final VelocityTracker1D xVelocityTracker = new VelocityTracker1D(false, (VelocityTracker1D.Strategy) null, 3, (DefaultConstructorMarker) null);
    private final VelocityTracker1D yVelocityTracker = new VelocityTracker1D(false, (VelocityTracker1D.Strategy) null, 3, (DefaultConstructorMarker) null);

    /* renamed from: getCurrentPointerPositionAccumulator-F1C5BW0$ui_release  reason: not valid java name */
    public final long m5247getCurrentPointerPositionAccumulatorF1C5BW0$ui_release() {
        return this.currentPointerPositionAccumulator;
    }

    /* renamed from: setCurrentPointerPositionAccumulator-k-4lQ0M$ui_release  reason: not valid java name */
    public final void m5248setCurrentPointerPositionAccumulatork4lQ0M$ui_release(long j) {
        this.currentPointerPositionAccumulator = j;
    }

    public final long getLastMoveEventTimeStamp$ui_release() {
        return this.lastMoveEventTimeStamp;
    }

    public final void setLastMoveEventTimeStamp$ui_release(long j) {
        this.lastMoveEventTimeStamp = j;
    }

    /* renamed from: addPosition-Uv8p0NA  reason: not valid java name */
    public final void m5244addPositionUv8p0NA(long j, long j2) {
        this.xVelocityTracker.addDataPoint(j, Offset.m3562getXimpl(j2));
        this.yVelocityTracker.addDataPoint(j, Offset.m3563getYimpl(j2));
    }

    /* renamed from: calculateVelocity-9UxMQ8M  reason: not valid java name */
    public final long m5245calculateVelocity9UxMQ8M() {
        return m5246calculateVelocityAH228Gc(VelocityKt.Velocity(Float.MAX_VALUE, Float.MAX_VALUE));
    }

    /* renamed from: calculateVelocity-AH228Gc  reason: not valid java name */
    public final long m5246calculateVelocityAH228Gc(long j) {
        if (Velocity.m6855getXimpl(j) > 0.0f && Velocity.m6856getYimpl(j) > 0.0f) {
            return VelocityKt.Velocity(this.xVelocityTracker.calculateVelocity(Velocity.m6855getXimpl(j)), this.yVelocityTracker.calculateVelocity(Velocity.m6856getYimpl(j)));
        }
        throw new IllegalStateException(("maximumVelocity should be a positive value. You specified=" + Velocity.m6862toStringimpl(j)).toString());
    }

    public final void resetTracking() {
        this.xVelocityTracker.resetTracking();
        this.yVelocityTracker.resetTracking();
        this.lastMoveEventTimeStamp = 0;
    }
}
