package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0002J#\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\"\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/platform/NestedScrollInteropConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "consumedScrollCache", "", "nestedScrollChildHelper", "Landroidx/core/view/NestedScrollingChildHelper;", "interruptOngoingScrolls", "", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NestedScrollInteropConnection.android.kt */
public final class NestedScrollInteropConnection implements NestedScrollConnection {
    public static final int $stable = 8;
    private final int[] consumedScrollCache = new int[2];
    private final NestedScrollingChildHelper nestedScrollChildHelper;
    private final View view;

    public NestedScrollInteropConnection(View view2) {
        this.view = view2;
        NestedScrollingChildHelper nestedScrollingChildHelper = new NestedScrollingChildHelper(view2);
        nestedScrollingChildHelper.setNestedScrollingEnabled(true);
        this.nestedScrollChildHelper = nestedScrollingChildHelper;
        ViewCompat.setNestedScrollingEnabled(view2, true);
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m5808onPreScrollOzD1aCk(long j, int i) {
        if (!this.nestedScrollChildHelper.startNestedScroll(NestedScrollInteropConnectionKt.m5812getScrollAxesk4lQ0M(j), NestedScrollInteropConnectionKt.m5814toViewTypeGyEprt8(i))) {
            return Offset.Companion.m3578getZeroF1C5BW0();
        }
        ArraysKt.fill$default(this.consumedScrollCache, 0, 0, 0, 6, (Object) null);
        this.nestedScrollChildHelper.dispatchNestedPreScroll(NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m3562getXimpl(j)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m3563getYimpl(j)), this.consumedScrollCache, (int[]) null, NestedScrollInteropConnectionKt.m5814toViewTypeGyEprt8(i));
        return NestedScrollInteropConnectionKt.m5813toOffsetUv8p0NA(this.consumedScrollCache, j);
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m5806onPostScrollDzOQY0M(long j, long j2, int i) {
        if (!this.nestedScrollChildHelper.startNestedScroll(NestedScrollInteropConnectionKt.m5812getScrollAxesk4lQ0M(j2), NestedScrollInteropConnectionKt.m5814toViewTypeGyEprt8(i))) {
            return Offset.Companion.m3578getZeroF1C5BW0();
        }
        ArraysKt.fill$default(this.consumedScrollCache, 0, 0, 0, 6, (Object) null);
        this.nestedScrollChildHelper.dispatchNestedScroll(NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m3562getXimpl(j)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m3563getYimpl(j)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m3562getXimpl(j2)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m3563getYimpl(j2)), (int[]) null, NestedScrollInteropConnectionKt.m5814toViewTypeGyEprt8(i), this.consumedScrollCache);
        return NestedScrollInteropConnectionKt.m5813toOffsetUv8p0NA(this.consumedScrollCache, j2);
    }

    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    public Object m5807onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        if (!this.nestedScrollChildHelper.dispatchNestedPreFling(NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m6855getXimpl(j)), NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m6856getYimpl(j)))) {
            j = Velocity.Companion.m6866getZero9UxMQ8M();
        }
        interruptOngoingScrolls();
        return Velocity.m6846boximpl(j);
    }

    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    public Object m5805onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        if (!this.nestedScrollChildHelper.dispatchNestedFling(NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m6855getXimpl(j2)), NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m6856getYimpl(j2)), true)) {
            j2 = Velocity.Companion.m6866getZero9UxMQ8M();
        }
        interruptOngoingScrolls();
        return Velocity.m6846boximpl(j2);
    }

    private final void interruptOngoingScrolls() {
        if (this.nestedScrollChildHelper.hasNestedScrollingParent(0)) {
            this.nestedScrollChildHelper.stopNestedScroll(0);
        }
        if (this.nestedScrollChildHelper.hasNestedScrollingParent(1)) {
            this.nestedScrollChildHelper.stopNestedScroll(1);
        }
    }
}
