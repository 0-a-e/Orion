package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J#\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\"\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u001a\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001c\u0010\u001a\u001a\u00020\f*\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001cJ\u0016\u0010\u001e\u001a\u00020\u001f*\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"Landroidx/compose/foundation/pager/DefaultPagerNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "state", "Landroidx/compose/foundation/pager/PagerState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/gestures/Orientation;)V", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getState", "()Landroidx/compose/foundation/pager/PagerState;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "consumeOnOrientation", "consumeOnOrientation-8S9VItk", "(JLandroidx/compose/foundation/gestures/Orientation;)J", "consumeOnOrientation-QWom1Mo", "mainAxis", "", "mainAxis-k-4lQ0M", "(J)F", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Pager.kt */
final class DefaultPagerNestedScrollConnection implements NestedScrollConnection {
    private final Orientation orientation;
    private final PagerState state;

    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    public /* synthetic */ Object m966onPreFlingQWom1Mo(long j, Continuation continuation) {
        return NestedScrollConnection.CC.m4977$default$onPreFlingQWom1Mo(this, j, continuation);
    }

    public DefaultPagerNestedScrollConnection(PagerState pagerState, Orientation orientation2) {
        this.state = pagerState;
        this.orientation = orientation2;
    }

    public final PagerState getState() {
        return this.state;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    /* renamed from: consumeOnOrientation-QWom1Mo  reason: not valid java name */
    public final long m963consumeOnOrientationQWom1Mo(long j, Orientation orientation2) {
        if (orientation2 == Orientation.Vertical) {
            return Velocity.m6851copyOhffZ5M$default(j, 0.0f, 0.0f, 2, (Object) null);
        }
        return Velocity.m6851copyOhffZ5M$default(j, 0.0f, 0.0f, 1, (Object) null);
    }

    /* renamed from: consumeOnOrientation-8S9VItk  reason: not valid java name */
    public final long m962consumeOnOrientation8S9VItk(long j, Orientation orientation2) {
        if (orientation2 == Orientation.Vertical) {
            return Offset.m3556copydBAh8RU$default(j, 0.0f, 0.0f, 2, (Object) null);
        }
        return Offset.m3556copydBAh8RU$default(j, 0.0f, 0.0f, 1, (Object) null);
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m967onPreScrollOzD1aCk(long j, int i) {
        if (!NestedScrollSource.m5000equalsimpl0(i, NestedScrollSource.Companion.m5005getDragWNlRxjI()) || ((double) Math.abs(this.state.getCurrentPageOffsetFraction())) <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return Offset.Companion.m3578getZeroF1C5BW0();
        }
        float currentPageOffsetFraction = this.state.getCurrentPageOffsetFraction() * ((float) this.state.getPageSize$foundation_release());
        float pageSize = (((float) (this.state.getLayoutInfo().getPageSize() + this.state.getLayoutInfo().getPageSpacing())) * (-Math.signum(this.state.getCurrentPageOffsetFraction()))) + currentPageOffsetFraction;
        if (this.state.getCurrentPageOffsetFraction() > 0.0f) {
            float f = pageSize;
            pageSize = currentPageOffsetFraction;
            currentPageOffsetFraction = f;
        }
        float f2 = -this.state.dispatchRawDelta(-RangesKt.coerceIn(this.orientation == Orientation.Horizontal ? Offset.m3562getXimpl(j) : Offset.m3563getYimpl(j), currentPageOffsetFraction, pageSize));
        float r0 = this.orientation == Orientation.Horizontal ? f2 : Offset.m3562getXimpl(j);
        if (this.orientation != Orientation.Vertical) {
            f2 = Offset.m3563getYimpl(j);
        }
        return Offset.m3555copydBAh8RU(j, r0, f2);
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m965onPostScrollDzOQY0M(long j, long j2, int i) {
        if (!NestedScrollSource.m5000equalsimpl0(i, NestedScrollSource.Companion.m5006getFlingWNlRxjI()) || m961mainAxisk4lQ0M(j2) == 0.0f) {
            return Offset.Companion.m3578getZeroF1C5BW0();
        }
        throw new CancellationException();
    }

    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    public Object m964onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        return Velocity.m6846boximpl(m963consumeOnOrientationQWom1Mo(j2, this.orientation));
    }

    /* renamed from: mainAxis-k-4lQ0M  reason: not valid java name */
    private final float m961mainAxisk4lQ0M(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m3562getXimpl(j) : Offset.m3563getYimpl(j);
    }
}
