package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000f\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u001b\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0004\b \u0010\u001cJ\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"ø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u000e\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\tJ\u0006\u0010(\u001a\u00020\tJ8\u0010)\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ$\u0010*\u001a\u00020\"*\u00020+2\u0006\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020.ø\u0001\u0000¢\u0006\u0004\b/\u00100J\u0014\u00101\u001a\u00020\"*\u00020\"ø\u0001\u0000¢\u0006\u0004\b2\u0010%J\n\u00101\u001a\u000203*\u000203J\u0014\u00104\u001a\u00020\"*\u00020\"ø\u0001\u0000¢\u0006\u0004\b5\u0010%J\u0014\u00106\u001a\u00020\u0019*\u00020\u0019ø\u0001\u0000¢\u0006\u0004\b7\u0010%J\u0014\u00108\u001a\u000203*\u00020\"ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u0014\u00108\u001a\u000203*\u00020\u0019ø\u0001\u0000¢\u0006\u0004\b;\u0010:J\u0017\u0010<\u001a\u00020\"*\u000203ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\u001c\u0010)\u001a\u00020\u0019*\u00020\u00192\u0006\u0010?\u001a\u000203ø\u0001\u0000¢\u0006\u0004\b@\u0010AR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006B"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollingLogic;", "", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "reverseDirection", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/OverscrollEffect;ZLandroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "isNestedFlinging", "Landroidx/compose/runtime/MutableState;", "getScrollableState", "()Landroidx/compose/foundation/gestures/ScrollableState;", "setScrollableState", "(Landroidx/compose/foundation/gestures/ScrollableState;)V", "shouldDispatchOverscroll", "getShouldDispatchOverscroll", "()Z", "doFlingAnimation", "Landroidx/compose/ui/unit/Velocity;", "available", "doFlingAnimation-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStopped", "", "initialVelocity", "onDragStopped-sF-c-tU", "performRawScroll", "Landroidx/compose/ui/geometry/Offset;", "scroll", "performRawScroll-MK-Hz9U", "(J)J", "registerNestedFling", "isFlinging", "shouldScrollImmediately", "update", "dispatchScroll", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialAvailableDelta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "dispatchScroll-3eAAhYA", "(Landroidx/compose/foundation/gestures/ScrollScope;JI)J", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "", "singleAxisOffset", "singleAxisOffset-MK-Hz9U", "singleAxisVelocity", "singleAxisVelocity-AH228Gc", "toFloat", "toFloat-k-4lQ0M", "(J)F", "toFloat-TH1AsA0", "toOffset", "toOffset-tuRUvjQ", "(F)J", "newValue", "update-QWom1Mo", "(JF)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scrollable.kt */
final class ScrollingLogic {
    /* access modifiers changed from: private */
    public FlingBehavior flingBehavior;
    private final MutableState<Boolean> isNestedFlinging = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    /* access modifiers changed from: private */
    public NestedScrollDispatcher nestedScrollDispatcher;
    private Orientation orientation;
    private OverscrollEffect overscrollEffect;
    private boolean reverseDirection;
    private ScrollableState scrollableState;

    public ScrollingLogic(ScrollableState scrollableState2, Orientation orientation2, OverscrollEffect overscrollEffect2, boolean z, FlingBehavior flingBehavior2, NestedScrollDispatcher nestedScrollDispatcher2) {
        this.scrollableState = scrollableState2;
        this.orientation = orientation2;
        this.overscrollEffect = overscrollEffect2;
        this.reverseDirection = z;
        this.flingBehavior = flingBehavior2;
        this.nestedScrollDispatcher = nestedScrollDispatcher2;
    }

    public final ScrollableState getScrollableState() {
        return this.scrollableState;
    }

    public final void setScrollableState(ScrollableState scrollableState2) {
        this.scrollableState = scrollableState2;
    }

    /* renamed from: toOffset-tuRUvjQ  reason: not valid java name */
    public final long m474toOffsettuRUvjQ(float f) {
        if (f == 0.0f) {
            return Offset.Companion.m3578getZeroF1C5BW0();
        }
        if (this.orientation == Orientation.Horizontal) {
            return OffsetKt.Offset(f, 0.0f);
        }
        return OffsetKt.Offset(0.0f, f);
    }

    /* renamed from: singleAxisOffset-MK-Hz9U  reason: not valid java name */
    public final long m470singleAxisOffsetMKHz9U(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m3556copydBAh8RU$default(j, 0.0f, 0.0f, 1, (Object) null) : Offset.m3556copydBAh8RU$default(j, 0.0f, 0.0f, 2, (Object) null);
    }

    /* renamed from: toFloat-k-4lQ0M  reason: not valid java name */
    public final float m473toFloatk4lQ0M(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m3562getXimpl(j) : Offset.m3563getYimpl(j);
    }

    /* renamed from: toFloat-TH1AsA0  reason: not valid java name */
    public final float m472toFloatTH1AsA0(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m6855getXimpl(j) : Velocity.m6856getYimpl(j);
    }

    /* renamed from: singleAxisVelocity-AH228Gc  reason: not valid java name */
    public final long m471singleAxisVelocityAH228Gc(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m6851copyOhffZ5M$default(j, 0.0f, 0.0f, 1, (Object) null) : Velocity.m6851copyOhffZ5M$default(j, 0.0f, 0.0f, 2, (Object) null);
    }

    /* renamed from: update-QWom1Mo  reason: not valid java name */
    public final long m475updateQWom1Mo(long j, float f) {
        return this.orientation == Orientation.Horizontal ? Velocity.m6851copyOhffZ5M$default(j, f, 0.0f, 2, (Object) null) : Velocity.m6851copyOhffZ5M$default(j, 0.0f, f, 1, (Object) null);
    }

    public final float reverseIfNeeded(float f) {
        return this.reverseDirection ? f * ((float) -1) : f;
    }

    /* renamed from: reverseIfNeeded-MK-Hz9U  reason: not valid java name */
    public final long m469reverseIfNeededMKHz9U(long j) {
        return this.reverseDirection ? Offset.m3569timestuRUvjQ(j, -1.0f) : j;
    }

    /* renamed from: dispatchScroll-3eAAhYA  reason: not valid java name */
    public final long m465dispatchScroll3eAAhYA(ScrollScope scrollScope, long j, int i) {
        Function1 scrollingLogic$dispatchScroll$performScroll$1 = new ScrollingLogic$dispatchScroll$performScroll$1(this, i, scrollScope);
        OverscrollEffect overscrollEffect2 = this.overscrollEffect;
        if (NestedScrollSource.m5000equalsimpl0(i, NestedScrollSource.Companion.m5008getWheelWNlRxjI())) {
            return ((Offset) scrollingLogic$dispatchScroll$performScroll$1.invoke(Offset.m3551boximpl(j))).m3572unboximpl();
        }
        if (overscrollEffect2 == null || !getShouldDispatchOverscroll()) {
            return ((Offset) scrollingLogic$dispatchScroll$performScroll$1.invoke(Offset.m3551boximpl(j))).m3572unboximpl();
        }
        return overscrollEffect2.m313applyToScrollRhakbz0(j, i, scrollingLogic$dispatchScroll$performScroll$1);
    }

    private final boolean getShouldDispatchOverscroll() {
        return this.scrollableState.getCanScrollForward() || this.scrollableState.getCanScrollBackward();
    }

    /* renamed from: performRawScroll-MK-Hz9U  reason: not valid java name */
    public final long m468performRawScrollMKHz9U(long j) {
        if (this.scrollableState.isScrollInProgress()) {
            return Offset.Companion.m3578getZeroF1C5BW0();
        }
        return m474toOffsettuRUvjQ(reverseIfNeeded(this.scrollableState.dispatchRawDelta(reverseIfNeeded(m473toFloatk4lQ0M(j)))));
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: onDragStopped-sF-c-tU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m467onDragStoppedsFctU(long r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1 r0 = (androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1 r0 = new androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1
            r0.<init>(r6, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 == r4) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            goto L_0x0032
        L_0x002a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0032:
            java.lang.Object r7 = r0.L$0
            androidx.compose.foundation.gestures.ScrollingLogic r7 = (androidx.compose.foundation.gestures.ScrollingLogic) r7
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0072
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r9)
            r6.registerNestedFling(r4)
            long r7 = r6.m471singleAxisVelocityAH228Gc(r7)
            androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1 r9 = new androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1
            r2 = 0
            r9.<init>(r6, r2)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            androidx.compose.foundation.OverscrollEffect r2 = r6.overscrollEffect
            if (r2 == 0) goto L_0x0063
            boolean r5 = r6.getShouldDispatchOverscroll()
            if (r5 == 0) goto L_0x0063
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r2.m312applyToFlingBMRW4eQ(r7, r9, r0)
            if (r7 != r1) goto L_0x0061
            return r1
        L_0x0061:
            r7 = r6
            goto L_0x0072
        L_0x0063:
            androidx.compose.ui.unit.Velocity r7 = androidx.compose.ui.unit.Velocity.m6846boximpl(r7)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r9.invoke(r7, r0)
            if (r7 != r1) goto L_0x0061
            return r1
        L_0x0072:
            r8 = 0
            r7.registerNestedFling(r8)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.m467onDragStoppedsFctU(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: doFlingAnimation-QWom1Mo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m466doFlingAnimationQWom1Mo(long r12, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = (androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            r0.<init>(r11, r14)
        L_0x0019:
            r4 = r0
            java.lang.Object r14 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L_0x0037
            if (r1 != r2) goto L_0x002f
            java.lang.Object r12 = r4.L$0
            kotlin.jvm.internal.Ref$LongRef r12 = (kotlin.jvm.internal.Ref.LongRef) r12
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x005e
        L_0x002f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r14)
            kotlin.jvm.internal.Ref$LongRef r14 = new kotlin.jvm.internal.Ref$LongRef
            r14.<init>()
            r14.element = r12
            androidx.compose.foundation.gestures.ScrollableState r1 = r11.scrollableState
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2 r3 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2
            r10 = 0
            r5 = r3
            r6 = r11
            r7 = r14
            r8 = r12
            r5.<init>(r6, r7, r8, r10)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4.L$0 = r14
            r4.label = r2
            r2 = 0
            r5 = 1
            r6 = 0
            java.lang.Object r12 = androidx.compose.foundation.gestures.ScrollableState.CC.scroll$default(r1, r2, r3, r4, r5, r6)
            if (r12 != r0) goto L_0x005d
            return r0
        L_0x005d:
            r12 = r14
        L_0x005e:
            long r12 = r12.element
            androidx.compose.ui.unit.Velocity r12 = androidx.compose.ui.unit.Velocity.m6846boximpl(r12)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.m466doFlingAnimationQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean shouldScrollImmediately() {
        if (!this.scrollableState.isScrollInProgress() && !this.isNestedFlinging.getValue().booleanValue()) {
            OverscrollEffect overscrollEffect2 = this.overscrollEffect;
            return overscrollEffect2 != null ? overscrollEffect2.isInProgress() : false;
        }
    }

    public final void registerNestedFling(boolean z) {
        this.isNestedFlinging.setValue(Boolean.valueOf(z));
    }

    public final void update(ScrollableState scrollableState2, Orientation orientation2, OverscrollEffect overscrollEffect2, boolean z, FlingBehavior flingBehavior2, NestedScrollDispatcher nestedScrollDispatcher2) {
        this.scrollableState = scrollableState2;
        this.orientation = orientation2;
        this.overscrollEffect = overscrollEffect2;
        this.reverseDirection = z;
        this.flingBehavior = flingBehavior2;
        this.nestedScrollDispatcher = nestedScrollDispatcher2;
    }
}
