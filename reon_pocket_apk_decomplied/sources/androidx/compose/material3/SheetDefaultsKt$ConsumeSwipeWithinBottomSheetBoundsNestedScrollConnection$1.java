package androidx.compose.material3;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u0015*\u00020\tH\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0014\u001a\u00020\u0015*\u00020\u0003H\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\t*\u00020\u0015H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, d2 = {"androidx/compose/material3/SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "toFloat", "", "offsetToFloat", "(J)F", "velocityToFloat", "toOffset", "(F)J", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SheetDefaults.kt */
public final class SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ Function1<Float, Unit> $onFling;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ SheetState $sheetState;

    SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1(SheetState sheetState, Function1<? super Float, Unit> function1, Orientation orientation) {
        this.$sheetState = sheetState;
        this.$onFling = function1;
        this.$orientation = orientation;
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m2173onPreScrollOzD1aCk(long j, int i) {
        float offsetToFloat = offsetToFloat(j);
        if (offsetToFloat >= 0.0f || !NestedScrollSource.m5000equalsimpl0(i, NestedScrollSource.Companion.m5005getDragWNlRxjI())) {
            return Offset.Companion.m3578getZeroF1C5BW0();
        }
        return toOffset(this.$sheetState.getAnchoredDraggableState$material3_release().dispatchRawDelta(offsetToFloat));
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m2171onPostScrollDzOQY0M(long j, long j2, int i) {
        if (NestedScrollSource.m5000equalsimpl0(i, NestedScrollSource.Companion.m5005getDragWNlRxjI())) {
            return toOffset(this.$sheetState.getAnchoredDraggableState$material3_release().dispatchRawDelta(offsetToFloat(j2)));
        }
        return Offset.Companion.m3578getZeroF1C5BW0();
    }

    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    public Object m2172onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        float velocityToFloat = velocityToFloat(j);
        float requireOffset = this.$sheetState.requireOffset();
        float minAnchor = this.$sheetState.getAnchoredDraggableState$material3_release().getAnchors().minAnchor();
        if (velocityToFloat >= 0.0f || requireOffset <= minAnchor) {
            j = Velocity.Companion.m6866getZero9UxMQ8M();
        } else {
            this.$onFling.invoke(Boxing.boxFloat(velocityToFloat));
        }
        return Velocity.m6846boximpl(j);
    }

    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    public Object m2170onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        this.$onFling.invoke(Boxing.boxFloat(velocityToFloat(j2)));
        return Velocity.m6846boximpl(j2);
    }

    private final long toOffset(float f) {
        float f2 = this.$orientation == Orientation.Horizontal ? f : 0.0f;
        if (this.$orientation != Orientation.Vertical) {
            f = 0.0f;
        }
        return OffsetKt.Offset(f2, f);
    }

    private final float velocityToFloat(long j) {
        return this.$orientation == Orientation.Horizontal ? Velocity.m6855getXimpl(j) : Velocity.m6856getYimpl(j);
    }

    private final float offsetToFloat(long j) {
        return this.$orientation == Orientation.Horizontal ? Offset.m3562getXimpl(j) : Offset.m3563getYimpl(j);
    }
}
