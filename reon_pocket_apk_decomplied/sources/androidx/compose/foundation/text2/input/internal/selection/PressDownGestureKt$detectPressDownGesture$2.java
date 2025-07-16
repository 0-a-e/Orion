package androidx.compose.foundation.text2.input.internal.selection;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text2.input.internal.selection.PressDownGestureKt$detectPressDownGesture$2", f = "PressDownGesture.kt", i = {0, 1, 1}, l = {32, 38}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "down"}, s = {"L$0", "L$0", "L$1"})
/* compiled from: PressDownGesture.kt */
final class PressDownGestureKt$detectPressDownGesture$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TapOnPosition $onDown;
    final /* synthetic */ Function0<Unit> $onUp;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PressDownGestureKt$detectPressDownGesture$2(TapOnPosition tapOnPosition, Function0<Unit> function0, Continuation<? super PressDownGestureKt$detectPressDownGesture$2> continuation) {
        super(2, continuation);
        this.$onDown = tapOnPosition;
        this.$onUp = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PressDownGestureKt$detectPressDownGesture$2 pressDownGestureKt$detectPressDownGesture$2 = new PressDownGestureKt$detectPressDownGesture$2(this.$onDown, this.$onUp, continuation);
        pressDownGestureKt$detectPressDownGesture$2.L$0 = obj;
        return pressDownGestureKt$detectPressDownGesture$2;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((PressDownGestureKt$detectPressDownGesture$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: androidx.compose.ui.input.pointer.AwaitPointerEventScope} */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0066 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0092 A[SYNTHETIC] */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x002a
            if (r1 == r3) goto L_0x0022
            if (r1 != r2) goto L_0x001a
            java.lang.Object r1 = r12.L$1
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            java.lang.Object r4 = r12.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0067
        L_0x001a:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0022:
            java.lang.Object r1 = r12.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0045
        L_0x002a:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            r1 = r13
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            r7 = r12
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r12.L$0 = r1
            r12.label = r3
            r5 = 0
            r6 = 0
            r8 = 2
            r9 = 0
            r4 = r1
            java.lang.Object r13 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r4, r5, r6, r7, r8, r9)
            if (r13 != r0) goto L_0x0045
            return r0
        L_0x0045:
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            androidx.compose.foundation.text2.input.internal.selection.TapOnPosition r4 = r12.$onDown
            long r5 = r13.m5113getPositionF1C5BW0()
            r4.m1435onEventk4lQ0M(r5)
            kotlin.jvm.functions.Function0<kotlin.Unit> r4 = r12.$onUp
            if (r4 == 0) goto L_0x0097
            r4 = r1
            r1 = r13
        L_0x0056:
            r13 = r12
            kotlin.coroutines.Continuation r13 = (kotlin.coroutines.Continuation) r13
            r12.L$0 = r4
            r12.L$1 = r1
            r12.label = r2
            r5 = 0
            java.lang.Object r13 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r4, r5, r13, r3, r5)
            if (r13 != r0) goto L_0x0067
            return r0
        L_0x0067:
            androidx.compose.ui.input.pointer.PointerEvent r13 = (androidx.compose.ui.input.pointer.PointerEvent) r13
            java.util.List r13 = r13.getChanges()
            int r5 = r13.size()
            r6 = 0
        L_0x0072:
            if (r6 >= r5) goto L_0x0092
            java.lang.Object r7 = r13.get(r6)
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            long r8 = r7.m5111getIdJ3iCeTQ()
            long r10 = r1.m5111getIdJ3iCeTQ()
            boolean r8 = androidx.compose.ui.input.pointer.PointerId.m5095equalsimpl0(r8, r10)
            if (r8 == 0) goto L_0x008f
            boolean r7 = r7.getPressed()
            if (r7 == 0) goto L_0x008f
            goto L_0x0056
        L_0x008f:
            int r6 = r6 + 1
            goto L_0x0072
        L_0x0092:
            kotlin.jvm.functions.Function0<kotlin.Unit> r13 = r12.$onUp
            r13.invoke()
        L_0x0097:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text2.input.internal.selection.PressDownGestureKt$detectPressDownGesture$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
