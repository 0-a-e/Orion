package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J#\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J*\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\"\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollableNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "enabled", "", "(Landroidx/compose/foundation/gestures/ScrollingLogic;Z)V", "getEnabled", "()Z", "setEnabled", "(Z)V", "getScrollingLogic", "()Landroidx/compose/foundation/gestures/ScrollingLogic;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scrollable.kt */
final class ScrollableNestedScrollConnection implements NestedScrollConnection {
    private boolean enabled;
    private final ScrollingLogic scrollingLogic;

    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    public /* synthetic */ Object m461onPreFlingQWom1Mo(long j, Continuation continuation) {
        return NestedScrollConnection.CC.m4977$default$onPreFlingQWom1Mo(this, j, continuation);
    }

    public ScrollableNestedScrollConnection(ScrollingLogic scrollingLogic2, boolean z) {
        this.scrollingLogic = scrollingLogic2;
        this.enabled = z;
    }

    public final ScrollingLogic getScrollingLogic() {
        return this.scrollingLogic;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m462onPreScrollOzD1aCk(long j, int i) {
        if (NestedScrollSource.m5000equalsimpl0(i, NestedScrollSource.Companion.m5006getFlingWNlRxjI())) {
            this.scrollingLogic.registerNestedFling(true);
        }
        return Offset.Companion.m3578getZeroF1C5BW0();
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m460onPostScrollDzOQY0M(long j, long j2, int i) {
        if (this.enabled) {
            return this.scrollingLogic.m468performRawScrollMKHz9U(j2);
        }
        return Offset.Companion.m3578getZeroF1C5BW0();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m459onPostFlingRZ2iAVY(long r3, long r5, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r7) {
        /*
            r2 = this;
            boolean r3 = r7 instanceof androidx.compose.foundation.gestures.ScrollableNestedScrollConnection$onPostFling$1
            if (r3 == 0) goto L_0x0014
            r3 = r7
            androidx.compose.foundation.gestures.ScrollableNestedScrollConnection$onPostFling$1 r3 = (androidx.compose.foundation.gestures.ScrollableNestedScrollConnection$onPostFling$1) r3
            int r4 = r3.label
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r0
            if (r4 == 0) goto L_0x0014
            int r4 = r3.label
            int r4 = r4 - r0
            r3.label = r4
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.ScrollableNestedScrollConnection$onPostFling$1 r3 = new androidx.compose.foundation.gestures.ScrollableNestedScrollConnection$onPostFling$1
            r3.<init>(r2, r7)
        L_0x0019:
            java.lang.Object r4 = r3.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r3.label
            r1 = 1
            if (r0 == 0) goto L_0x0038
            if (r0 != r1) goto L_0x0030
            long r5 = r3.J$0
            java.lang.Object r3 = r3.L$0
            androidx.compose.foundation.gestures.ScrollableNestedScrollConnection r3 = (androidx.compose.foundation.gestures.ScrollableNestedScrollConnection) r3
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x004f
        L_0x0030:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r4)
            boolean r4 = r2.enabled
            if (r4 == 0) goto L_0x005a
            androidx.compose.foundation.gestures.ScrollingLogic r4 = r2.scrollingLogic
            r3.L$0 = r2
            r3.J$0 = r5
            r3.label = r1
            java.lang.Object r4 = r4.m466doFlingAnimationQWom1Mo(r5, r3)
            if (r4 != r7) goto L_0x004e
            return r7
        L_0x004e:
            r3 = r2
        L_0x004f:
            androidx.compose.ui.unit.Velocity r4 = (androidx.compose.ui.unit.Velocity) r4
            long r0 = r4.m6864unboximpl()
            long r4 = androidx.compose.ui.unit.Velocity.m6858minusAH228Gc(r5, r0)
            goto L_0x0061
        L_0x005a:
            androidx.compose.ui.unit.Velocity$Companion r3 = androidx.compose.ui.unit.Velocity.Companion
            long r4 = r3.m6866getZero9UxMQ8M()
            r3 = r2
        L_0x0061:
            androidx.compose.ui.unit.Velocity r4 = androidx.compose.ui.unit.Velocity.m6846boximpl(r4)
            r4.m6864unboximpl()
            androidx.compose.foundation.gestures.ScrollingLogic r3 = r3.scrollingLogic
            r5 = 0
            r3.registerNestedFling(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableNestedScrollConnection.m459onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
