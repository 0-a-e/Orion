package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/Velocity;", "velocity"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1", f = "Scrollable.kt", i = {0, 1, 1, 2, 2}, l = {804, 807, 810}, m = "invokeSuspend", n = {"velocity", "velocity", "available", "velocity", "velocityLeft"}, s = {"J$0", "J$0", "J$1", "J$0", "J$1"})
/* compiled from: Scrollable.kt */
final class ScrollingLogic$onDragStopped$performFling$1 extends SuspendLambda implements Function2<Velocity, Continuation<? super Velocity>, Object> {
    /* synthetic */ long J$0;
    long J$1;
    int label;
    final /* synthetic */ ScrollingLogic this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollingLogic$onDragStopped$performFling$1(ScrollingLogic scrollingLogic, Continuation<? super ScrollingLogic$onDragStopped$performFling$1> continuation) {
        super(2, continuation);
        this.this$0 = scrollingLogic;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ScrollingLogic$onDragStopped$performFling$1 scrollingLogic$onDragStopped$performFling$1 = new ScrollingLogic$onDragStopped$performFling$1(this.this$0, continuation);
        scrollingLogic$onDragStopped$performFling$1.J$0 = ((Velocity) obj).m6864unboximpl();
        return scrollingLogic$onDragStopped$performFling$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m478invokesFctU(((Velocity) obj).m6864unboximpl(), (Continuation) obj2);
    }

    /* renamed from: invoke-sF-c-tU  reason: not valid java name */
    public final Object m478invokesFctU(long j, Continuation<? super Velocity> continuation) {
        return ((ScrollingLogic$onDragStopped$performFling$1) create(Velocity.m6846boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0097 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 == r5) goto L_0x0037
            if (r2 == r4) goto L_0x0028
            if (r2 != r3) goto L_0x0020
            long r1 = r0.J$1
            long r3 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r19)
            r5 = r3
            r3 = r1
            r2 = r19
            goto L_0x0098
        L_0x0020:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0028:
            long r4 = r0.J$1
            long r6 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r19)
            r2 = r19
            r16 = r4
            r5 = r6
            r7 = r16
            goto L_0x0075
        L_0x0037:
            long r5 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r19)
            r2 = r19
            goto L_0x0059
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r19)
            long r6 = r0.J$0
            androidx.compose.foundation.gestures.ScrollingLogic r2 = r0.this$0
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r2 = r2.nestedScrollDispatcher
            r8 = r0
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r0.J$0 = r6
            r0.label = r5
            java.lang.Object r2 = r2.m4991dispatchPreFlingQWom1Mo(r6, r8)
            if (r2 != r1) goto L_0x0058
            return r1
        L_0x0058:
            r5 = r6
        L_0x0059:
            androidx.compose.ui.unit.Velocity r2 = (androidx.compose.ui.unit.Velocity) r2
            long r7 = r2.m6864unboximpl()
            long r7 = androidx.compose.ui.unit.Velocity.m6858minusAH228Gc(r5, r7)
            androidx.compose.foundation.gestures.ScrollingLogic r2 = r0.this$0
            r9 = r0
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r0.J$0 = r5
            r0.J$1 = r7
            r0.label = r4
            java.lang.Object r2 = r2.m466doFlingAnimationQWom1Mo(r7, r9)
            if (r2 != r1) goto L_0x0075
            return r1
        L_0x0075:
            androidx.compose.ui.unit.Velocity r2 = (androidx.compose.ui.unit.Velocity) r2
            long r14 = r2.m6864unboximpl()
            androidx.compose.foundation.gestures.ScrollingLogic r2 = r0.this$0
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r9 = r2.nestedScrollDispatcher
            long r10 = androidx.compose.ui.unit.Velocity.m6858minusAH228Gc(r7, r14)
            r2 = r0
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r0.J$0 = r5
            r0.J$1 = r14
            r0.label = r3
            r12 = r14
            r3 = r14
            r14 = r2
            java.lang.Object r2 = r9.m4989dispatchPostFlingRZ2iAVY(r10, r12, r14)
            if (r2 != r1) goto L_0x0098
            return r1
        L_0x0098:
            androidx.compose.ui.unit.Velocity r2 = (androidx.compose.ui.unit.Velocity) r2
            long r1 = r2.m6864unboximpl()
            long r1 = androidx.compose.ui.unit.Velocity.m6858minusAH228Gc(r3, r1)
            long r1 = androidx.compose.ui.unit.Velocity.m6858minusAH228Gc(r5, r1)
            androidx.compose.ui.unit.Velocity r1 = androidx.compose.ui.unit.Velocity.m6846boximpl(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
