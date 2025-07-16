package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5", f = "DragGestureDetector.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {175, 884, 926, 192}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "down", "overSlop", "$this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv", "pointerDirectionConfig$iv", "pointer$iv", "touchSlop$iv", "totalPositionChange$iv", "$this$awaitEachGesture", "down", "overSlop", "$this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv", "pointerDirectionConfig$iv", "pointer$iv", "dragEvent$iv", "touchSlop$iv", "totalPositionChange$iv"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "F$0", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "F$0", "J$0"})
/* compiled from: DragGestureDetector.kt */
final class DragGestureDetectorKt$detectDragGestures$5 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
    final /* synthetic */ Function0<Unit> $onDragCancel;
    final /* synthetic */ Function0<Unit> $onDragEnd;
    final /* synthetic */ Function1<Offset, Unit> $onDragStart;
    float F$0;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DragGestureDetectorKt$detectDragGestures$5(Function1<? super Offset, Unit> function1, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super DragGestureDetectorKt$detectDragGestures$5> continuation) {
        super(2, continuation);
        this.$onDragStart = function1;
        this.$onDrag = function2;
        this.$onDragCancel = function0;
        this.$onDragEnd = function02;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureDetectorKt$detectDragGestures$5 dragGestureDetectorKt$detectDragGestures$5 = new DragGestureDetectorKt$detectDragGestures$5(this.$onDragStart, this.$onDrag, this.$onDragCancel, this.$onDragEnd, continuation);
        dragGestureDetectorKt$detectDragGestures$5.L$0 = obj;
        return dragGestureDetectorKt$detectDragGestures$5;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$detectDragGestures$5) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0114 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x014a A[SYNTHETIC] */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) {
        /*
            r24 = this;
            r0 = r24
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L_0x0098
            if (r2 == r6) goto L_0x008e
            if (r2 == r5) goto L_0x005d
            if (r2 == r4) goto L_0x0026
            if (r2 != r3) goto L_0x001e
            kotlin.ResultKt.throwOnFailure(r25)
            r1 = r25
            goto L_0x025e
        L_0x001e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0026:
            long r8 = r0.J$0
            float r2 = r0.F$0
            java.lang.Object r10 = r0.L$6
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            java.lang.Object r11 = r0.L$5
            kotlin.jvm.internal.Ref$LongRef r11 = (kotlin.jvm.internal.Ref.LongRef) r11
            java.lang.Object r12 = r0.L$4
            androidx.compose.foundation.gestures.PointerDirectionConfig r12 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r12
            java.lang.Object r13 = r0.L$3
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
            java.lang.Object r14 = r0.L$2
            kotlin.jvm.internal.Ref$LongRef r14 = (kotlin.jvm.internal.Ref.LongRef) r14
            java.lang.Object r15 = r0.L$1
            androidx.compose.ui.input.pointer.PointerInputChange r15 = (androidx.compose.ui.input.pointer.PointerInputChange) r15
            java.lang.Object r3 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
            kotlin.ResultKt.throwOnFailure(r25)
            r6 = r1
            r20 = r12
            r12 = r2
            r2 = r13
            r13 = r20
            r21 = r8
            r9 = r4
            r4 = r21
            r8 = r15
            r23 = r14
            r14 = r11
            r11 = r23
            goto L_0x01de
        L_0x005d:
            long r2 = r0.J$0
            float r8 = r0.F$0
            java.lang.Object r9 = r0.L$5
            kotlin.jvm.internal.Ref$LongRef r9 = (kotlin.jvm.internal.Ref.LongRef) r9
            java.lang.Object r10 = r0.L$4
            androidx.compose.foundation.gestures.PointerDirectionConfig r10 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r10
            java.lang.Object r11 = r0.L$3
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
            java.lang.Object r12 = r0.L$2
            kotlin.jvm.internal.Ref$LongRef r12 = (kotlin.jvm.internal.Ref.LongRef) r12
            java.lang.Object r13 = r0.L$1
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            java.lang.Object r14 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r14 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r14
            kotlin.ResultKt.throwOnFailure(r25)
            r15 = r25
            r20 = r12
            r12 = r8
            r8 = r13
            r13 = r10
            r21 = r14
            r14 = r9
            r9 = r2
            r2 = r11
            r11 = r20
            r3 = r21
            goto L_0x0115
        L_0x008e:
            java.lang.Object r2 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
            kotlin.ResultKt.throwOnFailure(r25)
            r3 = r25
            goto L_0x00b2
        L_0x0098:
            kotlin.ResultKt.throwOnFailure(r25)
            java.lang.Object r2 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
            r11 = r0
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
            r0.L$0 = r2
            r0.label = r6
            r9 = 0
            r10 = 0
            r12 = 2
            r13 = 0
            r8 = r2
            java.lang.Object r3 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r8, r9, r10, r11, r12, r13)
            if (r3 != r1) goto L_0x00b2
            return r1
        L_0x00b2:
            androidx.compose.ui.input.pointer.PointerInputChange r3 = (androidx.compose.ui.input.pointer.PointerInputChange) r3
            kotlin.jvm.internal.Ref$LongRef r8 = new kotlin.jvm.internal.Ref$LongRef
            r8.<init>()
            androidx.compose.ui.geometry.Offset$Companion r9 = androidx.compose.ui.geometry.Offset.Companion
            long r9 = r9.m3578getZeroF1C5BW0()
            r8.element = r9
        L_0x00c1:
            long r9 = r3.m5111getIdJ3iCeTQ()
            int r11 = r3.m5116getTypeT8wyACA()
            androidx.compose.foundation.gestures.PointerDirectionConfig r12 = androidx.compose.foundation.gestures.DragGestureDetectorKt.getBidirectionalPointerDirectionConfig()
            androidx.compose.ui.input.pointer.PointerEvent r13 = r2.getCurrentEvent()
            boolean r13 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m375isPointerUpDmW0f2w(r13, r9)
            if (r13 == 0) goto L_0x00dc
            r6 = r1
            r9 = r4
            r1 = r7
            goto L_0x020b
        L_0x00dc:
            androidx.compose.ui.platform.ViewConfiguration r13 = r2.getViewConfiguration()
            float r11 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m376pointerSlopE8SPZFQ(r13, r11)
            kotlin.jvm.internal.Ref$LongRef r13 = new kotlin.jvm.internal.Ref$LongRef
            r13.<init>()
            r13.element = r9
            androidx.compose.ui.geometry.Offset$Companion r9 = androidx.compose.ui.geometry.Offset.Companion
            long r9 = r9.m3578getZeroF1C5BW0()
            r14 = r13
            r13 = r12
            r12 = r11
            r11 = r8
            r8 = r3
            r3 = r2
        L_0x00f7:
            r15 = r0
            kotlin.coroutines.Continuation r15 = (kotlin.coroutines.Continuation) r15
            r0.L$0 = r3
            r0.L$1 = r8
            r0.L$2 = r11
            r0.L$3 = r2
            r0.L$4 = r13
            r0.L$5 = r14
            r0.L$6 = r7
            r0.F$0 = r12
            r0.J$0 = r9
            r0.label = r5
            java.lang.Object r15 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r2, r7, r15, r6, r7)
            if (r15 != r1) goto L_0x0115
            return r1
        L_0x0115:
            androidx.compose.ui.input.pointer.PointerEvent r15 = (androidx.compose.ui.input.pointer.PointerEvent) r15
            java.util.List r5 = r15.getChanges()
            int r6 = r5.size()
            r16 = 0
            r7 = r16
        L_0x0123:
            if (r7 >= r6) goto L_0x014a
            java.lang.Object r17 = r5.get(r7)
            r18 = r17
            androidx.compose.ui.input.pointer.PointerInputChange r18 = (androidx.compose.ui.input.pointer.PointerInputChange) r18
            r25 = r5
            long r4 = r18.m5111getIdJ3iCeTQ()
            r18 = r1
            r19 = r2
            long r1 = r14.element
            boolean r1 = androidx.compose.ui.input.pointer.PointerId.m5095equalsimpl0(r4, r1)
            if (r1 == 0) goto L_0x0140
            goto L_0x0150
        L_0x0140:
            int r7 = r7 + 1
            r5 = r25
            r1 = r18
            r2 = r19
            r4 = 3
            goto L_0x0123
        L_0x014a:
            r18 = r1
            r19 = r2
            r17 = 0
        L_0x0150:
            r1 = r17
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            if (r1 != 0) goto L_0x015f
        L_0x0156:
            r2 = r3
            r3 = r8
            r8 = r11
            r6 = r18
            r1 = 0
            r9 = 3
            goto L_0x020b
        L_0x015f:
            boolean r2 = r1.isConsumed()
            if (r2 == 0) goto L_0x0166
            goto L_0x0156
        L_0x0166:
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r1)
            if (r2 == 0) goto L_0x019f
            java.util.List r1 = r15.getChanges()
            int r2 = r1.size()
            r4 = r16
        L_0x0176:
            if (r4 >= r2) goto L_0x0189
            java.lang.Object r5 = r1.get(r4)
            r6 = r5
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            boolean r6 = r6.getPressed()
            if (r6 == 0) goto L_0x0186
            goto L_0x018a
        L_0x0186:
            int r4 = r4 + 1
            goto L_0x0176
        L_0x0189:
            r5 = 0
        L_0x018a:
            androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
            if (r5 != 0) goto L_0x018f
            goto L_0x0156
        L_0x018f:
            long r1 = r5.m5111getIdJ3iCeTQ()
            r14.element = r1
            r1 = r18
            r2 = r19
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            goto L_0x00f7
        L_0x019f:
            long r4 = r1.m5113getPositionF1C5BW0()
            long r6 = r1.m5114getPreviousPositionF1C5BW0()
            long r4 = androidx.compose.ui.geometry.Offset.m3566minusMKHz9U(r4, r6)
            long r4 = androidx.compose.ui.geometry.Offset.m3567plusMKHz9U(r9, r4)
            float r2 = r13.m406calculateDeltaChangek4lQ0M(r4)
            int r2 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r2 >= 0) goto L_0x01f4
            androidx.compose.ui.input.pointer.PointerEventPass r2 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r6 = r0
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r0.L$0 = r3
            r0.L$1 = r8
            r0.L$2 = r11
            r7 = r19
            r0.L$3 = r7
            r0.L$4 = r13
            r0.L$5 = r14
            r0.L$6 = r1
            r0.F$0 = r12
            r0.J$0 = r4
            r9 = 3
            r0.label = r9
            java.lang.Object r2 = r7.awaitPointerEvent(r2, r6)
            r6 = r18
            if (r2 != r6) goto L_0x01dc
            return r6
        L_0x01dc:
            r10 = r1
            r2 = r7
        L_0x01de:
            boolean r1 = r10.isConsumed()
            if (r1 == 0) goto L_0x01e9
            r2 = r3
            r3 = r8
            r8 = r11
            r1 = 0
            goto L_0x020b
        L_0x01e9:
            r1 = r6
            r6 = 1
            r7 = 0
            r20 = r4
            r4 = r9
            r9 = r20
            r5 = 2
            goto L_0x00f7
        L_0x01f4:
            r6 = r18
            r7 = r19
            r9 = 3
            long r4 = r13.m407calculatePostSlopOffset8S9VItk(r4, r12)
            r1.consume()
            r11.element = r4
            boolean r2 = r1.isConsumed()
            if (r2 == 0) goto L_0x0274
            r2 = r3
            r3 = r8
            r8 = r11
        L_0x020b:
            if (r1 == 0) goto L_0x021b
            boolean r4 = r1.isConsumed()
            if (r4 == 0) goto L_0x0214
            goto L_0x021b
        L_0x0214:
            r1 = r6
            r4 = r9
            r5 = 2
            r6 = 1
            r7 = 0
            goto L_0x00c1
        L_0x021b:
            if (r1 == 0) goto L_0x0271
            kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r3 = r0.$onDragStart
            long r4 = r1.m5113getPositionF1C5BW0()
            androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.m3551boximpl(r4)
            r3.invoke(r4)
            kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.geometry.Offset, kotlin.Unit> r3 = r0.$onDrag
            long r4 = r8.element
            androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.m3551boximpl(r4)
            r3.invoke(r1, r4)
            long r3 = r1.m5111getIdJ3iCeTQ()
            androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5$2 r1 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5$2
            kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.geometry.Offset, kotlin.Unit> r5 = r0.$onDrag
            r1.<init>(r5)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r5 = r0
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r10 = 0
            r0.L$0 = r10
            r0.L$1 = r10
            r0.L$2 = r10
            r0.L$3 = r10
            r0.L$4 = r10
            r0.L$5 = r10
            r0.L$6 = r10
            r15 = 4
            r0.label = r15
            java.lang.Object r1 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m373dragjO51t88(r2, r3, r1, r5)
            if (r1 != r6) goto L_0x025e
            return r6
        L_0x025e:
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x026c
            kotlin.jvm.functions.Function0<kotlin.Unit> r1 = r0.$onDragCancel
            r1.invoke()
            goto L_0x0271
        L_0x026c:
            kotlin.jvm.functions.Function0<kotlin.Unit> r1 = r0.$onDragEnd
            r1.invoke()
        L_0x0271:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x0274:
            r10 = 0
            r15 = 4
            androidx.compose.ui.geometry.Offset$Companion r1 = androidx.compose.ui.geometry.Offset.Companion
            long r1 = r1.m3578getZeroF1C5BW0()
            r4 = r9
            r5 = 2
            r20 = r1
            r1 = r6
            r2 = r7
            r7 = r10
            r6 = 1
            r9 = r20
            goto L_0x00f7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
