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
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5", f = "DragGestureDetector.kt", i = {0, 1, 2}, l = {234, 235, 240}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "$this$awaitEachGesture"}, s = {"L$0", "L$0", "L$0"})
/* compiled from: DragGestureDetector.kt */
final class DragGestureDetectorKt$detectDragGesturesAfterLongPress$5 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
    final /* synthetic */ Function0<Unit> $onDragCancel;
    final /* synthetic */ Function0<Unit> $onDragEnd;
    final /* synthetic */ Function1<Offset, Unit> $onDragStart;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super DragGestureDetectorKt$detectDragGesturesAfterLongPress$5> continuation) {
        super(2, continuation);
        this.$onDragStart = function1;
        this.$onDragEnd = function0;
        this.$onDragCancel = function02;
        this.$onDrag = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureDetectorKt$detectDragGesturesAfterLongPress$5 dragGestureDetectorKt$detectDragGesturesAfterLongPress$5 = new DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(this.$onDragStart, this.$onDragEnd, this.$onDragCancel, this.$onDrag, continuation);
        dragGestureDetectorKt$detectDragGesturesAfterLongPress$5.L$0 = obj;
        return dragGestureDetectorKt$detectDragGesturesAfterLongPress$5;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$detectDragGesturesAfterLongPress$5) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v20, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: androidx.compose.ui.input.pointer.AwaitPointerEventScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0065 A[Catch:{ CancellationException -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0096 A[Catch:{ CancellationException -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00bd A[Catch:{ CancellationException -> 0x00c5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 == r4) goto L_0x002a
            if (r1 == r3) goto L_0x0022
            if (r1 != r2) goto L_0x001a
            java.lang.Object r0 = r11.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r0 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r0
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ CancellationException -> 0x00c5 }
            goto L_0x008e
        L_0x001a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0022:
            java.lang.Object r1 = r11.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ CancellationException -> 0x00c5 }
            goto L_0x0061
        L_0x002a:
            java.lang.Object r1 = r11.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ CancellationException -> 0x00c5 }
            goto L_0x004d
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Object r12 = r11.L$0
            r1 = r12
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            r8 = r11
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8     // Catch:{ CancellationException -> 0x00c5 }
            r11.L$0 = r1     // Catch:{ CancellationException -> 0x00c5 }
            r11.label = r4     // Catch:{ CancellationException -> 0x00c5 }
            r6 = 0
            r7 = 0
            r9 = 2
            r10 = 0
            r5 = r1
            java.lang.Object r12 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r5, r6, r7, r8, r9, r10)     // Catch:{ CancellationException -> 0x00c5 }
            if (r12 != r0) goto L_0x004d
            return r0
        L_0x004d:
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12     // Catch:{ CancellationException -> 0x00c5 }
            long r4 = r12.m5111getIdJ3iCeTQ()     // Catch:{ CancellationException -> 0x00c5 }
            r12 = r11
            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12     // Catch:{ CancellationException -> 0x00c5 }
            r11.L$0 = r1     // Catch:{ CancellationException -> 0x00c5 }
            r11.label = r3     // Catch:{ CancellationException -> 0x00c5 }
            java.lang.Object r12 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m364awaitLongPressOrCancellationrnUCldI(r1, r4, r12)     // Catch:{ CancellationException -> 0x00c5 }
            if (r12 != r0) goto L_0x0061
            return r0
        L_0x0061:
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12     // Catch:{ CancellationException -> 0x00c5 }
            if (r12 == 0) goto L_0x00c2
            kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r3 = r11.$onDragStart     // Catch:{ CancellationException -> 0x00c5 }
            long r4 = r12.m5113getPositionF1C5BW0()     // Catch:{ CancellationException -> 0x00c5 }
            androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.m3551boximpl(r4)     // Catch:{ CancellationException -> 0x00c5 }
            r3.invoke(r4)     // Catch:{ CancellationException -> 0x00c5 }
            long r3 = r12.m5111getIdJ3iCeTQ()     // Catch:{ CancellationException -> 0x00c5 }
            androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$1 r12 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$1     // Catch:{ CancellationException -> 0x00c5 }
            kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.geometry.Offset, kotlin.Unit> r5 = r11.$onDrag     // Catch:{ CancellationException -> 0x00c5 }
            r12.<init>(r5)     // Catch:{ CancellationException -> 0x00c5 }
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12     // Catch:{ CancellationException -> 0x00c5 }
            r5 = r11
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch:{ CancellationException -> 0x00c5 }
            r11.L$0 = r1     // Catch:{ CancellationException -> 0x00c5 }
            r11.label = r2     // Catch:{ CancellationException -> 0x00c5 }
            java.lang.Object r12 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m373dragjO51t88(r1, r3, r12, r5)     // Catch:{ CancellationException -> 0x00c5 }
            if (r12 != r0) goto L_0x008d
            return r0
        L_0x008d:
            r0 = r1
        L_0x008e:
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch:{ CancellationException -> 0x00c5 }
            boolean r12 = r12.booleanValue()     // Catch:{ CancellationException -> 0x00c5 }
            if (r12 == 0) goto L_0x00bd
            androidx.compose.ui.input.pointer.PointerEvent r12 = r0.getCurrentEvent()     // Catch:{ CancellationException -> 0x00c5 }
            java.util.List r12 = r12.getChanges()     // Catch:{ CancellationException -> 0x00c5 }
            int r0 = r12.size()     // Catch:{ CancellationException -> 0x00c5 }
            r1 = 0
        L_0x00a3:
            if (r1 >= r0) goto L_0x00b7
            java.lang.Object r2 = r12.get(r1)     // Catch:{ CancellationException -> 0x00c5 }
            androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2     // Catch:{ CancellationException -> 0x00c5 }
            boolean r3 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUp(r2)     // Catch:{ CancellationException -> 0x00c5 }
            if (r3 == 0) goto L_0x00b4
            r2.consume()     // Catch:{ CancellationException -> 0x00c5 }
        L_0x00b4:
            int r1 = r1 + 1
            goto L_0x00a3
        L_0x00b7:
            kotlin.jvm.functions.Function0<kotlin.Unit> r12 = r11.$onDragEnd     // Catch:{ CancellationException -> 0x00c5 }
            r12.invoke()     // Catch:{ CancellationException -> 0x00c5 }
            goto L_0x00c2
        L_0x00bd:
            kotlin.jvm.functions.Function0<kotlin.Unit> r12 = r11.$onDragCancel     // Catch:{ CancellationException -> 0x00c5 }
            r12.invoke()     // Catch:{ CancellationException -> 0x00c5 }
        L_0x00c2:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x00c5:
            r12 = move-exception
            kotlin.jvm.functions.Function0<kotlin.Unit> r0 = r11.$onDragCancel
            r0.invoke()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
