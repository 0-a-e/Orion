package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2", f = "DragGestureDetector.kt", i = {0, 0, 1, 1, 1}, l = {812, 829}, m = "invokeSuspend", n = {"$this$withTimeout", "finished", "$this$withTimeout", "event", "finished"}, s = {"L$0", "I$0", "L$0", "L$1", "I$0"})
/* compiled from: DragGestureDetector.kt */
final class DragGestureDetectorKt$awaitLongPressOrCancellation$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<PointerInputChange> $currentDown;
    final /* synthetic */ Ref.ObjectRef<PointerInputChange> $longPress;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DragGestureDetectorKt$awaitLongPressOrCancellation$2(Ref.ObjectRef<PointerInputChange> objectRef, Ref.ObjectRef<PointerInputChange> objectRef2, Continuation<? super DragGestureDetectorKt$awaitLongPressOrCancellation$2> continuation) {
        super(2, continuation);
        this.$currentDown = objectRef;
        this.$longPress = objectRef2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureDetectorKt$awaitLongPressOrCancellation$2 dragGestureDetectorKt$awaitLongPressOrCancellation$2 = new DragGestureDetectorKt$awaitLongPressOrCancellation$2(this.$currentDown, this.$longPress, continuation);
        dragGestureDetectorKt$awaitLongPressOrCancellation$2.L$0 = obj;
        return dragGestureDetectorKt$awaitLongPressOrCancellation$2;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$awaitLongPressOrCancellation$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0072 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x009e A[EDGE_INSN: B:63:0x009e->B:27:0x009e ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d3 A[EDGE_INSN: B:64:0x00d3->B:37:0x00d3 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            r16 = this;
            r0 = r16
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r6 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 == r6) goto L_0x002a
            if (r2 != r3) goto L_0x0022
            int r2 = r0.I$0
            java.lang.Object r7 = r0.L$1
            androidx.compose.ui.input.pointer.PointerEvent r7 = (androidx.compose.ui.input.pointer.PointerEvent) r7
            java.lang.Object r8 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            kotlin.ResultKt.throwOnFailure(r17)
            r4 = r17
            goto L_0x00b5
        L_0x0022:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x002a:
            int r2 = r0.I$0
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            kotlin.ResultKt.throwOnFailure(r17)
            r8 = r17
            goto L_0x0055
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r17)
            java.lang.Object r2 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
            r7 = r2
            r2 = 0
        L_0x003f:
            if (r2 != 0) goto L_0x014f
            androidx.compose.ui.input.pointer.PointerEventPass r8 = androidx.compose.ui.input.pointer.PointerEventPass.Main
            r9 = r0
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r0.L$0 = r7
            r0.L$1 = r4
            r0.I$0 = r2
            r0.label = r6
            java.lang.Object r8 = r7.awaitPointerEvent(r8, r9)
            if (r8 != r1) goto L_0x0055
            return r1
        L_0x0055:
            androidx.compose.ui.input.pointer.PointerEvent r8 = (androidx.compose.ui.input.pointer.PointerEvent) r8
            java.util.List r9 = r8.getChanges()
            int r10 = r9.size()
            r11 = 0
        L_0x0060:
            if (r11 >= r10) goto L_0x0072
            java.lang.Object r12 = r9.get(r11)
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            boolean r12 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r12)
            if (r12 != 0) goto L_0x006f
            goto L_0x0073
        L_0x006f:
            int r11 = r11 + 1
            goto L_0x0060
        L_0x0072:
            r2 = r6
        L_0x0073:
            java.util.List r9 = r8.getChanges()
            int r10 = r9.size()
            r11 = 0
        L_0x007c:
            if (r11 >= r10) goto L_0x009e
            java.lang.Object r12 = r9.get(r11)
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            boolean r13 = r12.isConsumed()
            if (r13 != 0) goto L_0x009d
            long r13 = r7.m5010getSizeYbymL2g()
            long r4 = r7.m5009getExtendedTouchPaddingNHjbRc()
            boolean r4 = androidx.compose.ui.input.pointer.PointerEventKt.m5057isOutOfBoundsjwHxaWs(r12, r13, r4)
            if (r4 == 0) goto L_0x0099
            goto L_0x009d
        L_0x0099:
            int r11 = r11 + 1
            r4 = 0
            goto L_0x007c
        L_0x009d:
            r2 = r6
        L_0x009e:
            androidx.compose.ui.input.pointer.PointerEventPass r4 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r5 = r0
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r0.L$0 = r7
            r0.L$1 = r8
            r0.I$0 = r2
            r0.label = r3
            java.lang.Object r4 = r7.awaitPointerEvent(r4, r5)
            if (r4 != r1) goto L_0x00b2
            return r1
        L_0x00b2:
            r15 = r8
            r8 = r7
            r7 = r15
        L_0x00b5:
            androidx.compose.ui.input.pointer.PointerEvent r4 = (androidx.compose.ui.input.pointer.PointerEvent) r4
            java.util.List r4 = r4.getChanges()
            int r5 = r4.size()
            r9 = 0
        L_0x00c0:
            if (r9 >= r5) goto L_0x00d3
            java.lang.Object r10 = r4.get(r9)
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            boolean r10 = r10.isConsumed()
            if (r10 == 0) goto L_0x00d0
            r2 = r6
            goto L_0x00d3
        L_0x00d0:
            int r9 = r9 + 1
            goto L_0x00c0
        L_0x00d3:
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r4 = r0.$currentDown
            T r4 = r4.element
            androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
            long r4 = r4.m5111getIdJ3iCeTQ()
            boolean r4 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m375isPointerUpDmW0f2w(r7, r4)
            if (r4 == 0) goto L_0x0116
            java.util.List r4 = r7.getChanges()
            int r5 = r4.size()
            r7 = 0
        L_0x00ec:
            if (r7 >= r5) goto L_0x00ff
            java.lang.Object r9 = r4.get(r7)
            r10 = r9
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            boolean r10 = r10.getPressed()
            if (r10 == 0) goto L_0x00fc
            goto L_0x0100
        L_0x00fc:
            int r7 = r7 + 1
            goto L_0x00ec
        L_0x00ff:
            r9 = 0
        L_0x0100:
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            if (r9 == 0) goto L_0x0111
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r4 = r0.$currentDown
            r4.element = r9
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r4 = r0.$longPress
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r5 = r0.$currentDown
            T r5 = r5.element
            r4.element = r5
            goto L_0x014a
        L_0x0111:
            r2 = r6
            r7 = r8
            r4 = 0
            goto L_0x003f
        L_0x0116:
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r4 = r0.$longPress
            java.util.List r5 = r7.getChanges()
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r7 = r0.$currentDown
            int r9 = r5.size()
            r10 = 0
        L_0x0123:
            if (r10 >= r9) goto L_0x0147
            java.lang.Object r11 = r5.get(r10)
            r12 = r11
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            long r12 = r12.m5111getIdJ3iCeTQ()
            T r14 = r7.element
            androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.ui.input.pointer.PointerInputChange) r14
            r17 = r7
            long r6 = r14.m5111getIdJ3iCeTQ()
            boolean r6 = androidx.compose.ui.input.pointer.PointerId.m5095equalsimpl0(r12, r6)
            if (r6 == 0) goto L_0x0141
            goto L_0x0148
        L_0x0141:
            int r10 = r10 + 1
            r7 = r17
            r6 = 1
            goto L_0x0123
        L_0x0147:
            r11 = 0
        L_0x0148:
            r4.element = r11
        L_0x014a:
            r7 = r8
            r4 = 0
            r6 = 1
            goto L_0x003f
        L_0x014f:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
