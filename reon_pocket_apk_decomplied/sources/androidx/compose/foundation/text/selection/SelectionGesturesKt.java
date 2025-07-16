package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\b\u001a\u00020\u0006*\u00020\tH@¢\u0006\u0002\u0010\n\u001a&\u0010\u000b\u001a\u00020\u0005*\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a*\u0010\u0011\u001a\u00020\u0012*\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H@¢\u0006\u0002\u0010\u0018\u001a\u001c\u0010\u0019\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0000\u001a\"\u0010\u001e\u001a\u00020\u0012*\u00020\t2\u0006\u0010\u0013\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u0006H@¢\u0006\u0002\u0010\u001f\u001a \u0010 \u001a\u00020\u001a*\u00020\u001a2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00120\"H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u00068@X\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"ClicksSlop", "", "STATIC_KEY", "", "isPrecisePointer", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "(Landroidx/compose/ui/input/pointer/PointerEvent;)Z", "awaitDown", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "distanceIsTolerable", "offset1", "Landroidx/compose/ui/geometry/Offset;", "offset2", "distanceIsTolerable-2x9bVx0", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JJ)Z", "mouseSelection", "", "observer", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "clicksCounter", "Landroidx/compose/foundation/text/selection/ClicksCounter;", "down", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/selection/ClicksCounter;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectionGestureInput", "Landroidx/compose/ui/Modifier;", "mouseSelectionObserver", "textDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "touchSelection", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/TextDragObserver;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSelectionTouchMode", "updateTouchMode", "Lkotlin/Function1;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionGestures.kt */
public final class SelectionGesturesKt {
    public static final double ClicksSlop = 100.0d;
    private static final int STATIC_KEY = 8675309;

    public static final Modifier updateSelectionTouchMode(Modifier modifier, Function1<? super Boolean, Unit> function1) {
        return SuspendingPointerInputFilterKt.pointerInput(modifier, (Object) Integer.valueOf(STATIC_KEY), (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new SelectionGesturesKt$updateSelectionTouchMode$1(function1, (Continuation<? super SelectionGesturesKt$updateSelectionTouchMode$1>) null));
    }

    public static final Modifier selectionGestureInput(Modifier modifier, MouseSelectionObserver mouseSelectionObserver, TextDragObserver textDragObserver) {
        return SuspendingPointerInputFilterKt.pointerInput(modifier, mouseSelectionObserver, textDragObserver, new SelectionGesturesKt$selectionGestureInput$1(mouseSelectionObserver, textDragObserver, (Continuation<? super SelectionGesturesKt$selectionGestureInput$1>) null));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: androidx.compose.foundation.text.TextDragObserver} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a4 A[Catch:{ CancellationException -> 0x00d8 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ad A[Catch:{ CancellationException -> 0x00d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d2 A[Catch:{ CancellationException -> 0x00d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object touchSelection(androidx.compose.ui.input.pointer.AwaitPointerEventScope r9, androidx.compose.foundation.text.TextDragObserver r10, androidx.compose.ui.input.pointer.PointerEvent r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            boolean r0 = r12 instanceof androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$1 r0 = (androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$1 r0 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$1
            r0.<init>(r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0051
            if (r2 == r4) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r9 = r0.L$1
            r10 = r9
            androidx.compose.foundation.text.TextDragObserver r10 = (androidx.compose.foundation.text.TextDragObserver) r10
            java.lang.Object r9 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r9 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r9
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ CancellationException -> 0x00d8 }
            goto L_0x00a5
        L_0x0036:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003e:
            java.lang.Object r9 = r0.L$2
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            java.lang.Object r10 = r0.L$1
            androidx.compose.foundation.text.TextDragObserver r10 = (androidx.compose.foundation.text.TextDragObserver) r10
            java.lang.Object r11 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ CancellationException -> 0x00d8 }
            r8 = r11
            r11 = r9
            r9 = r8
            goto L_0x0071
        L_0x0051:
            kotlin.ResultKt.throwOnFailure(r12)
            java.util.List r11 = r11.getChanges()     // Catch:{ CancellationException -> 0x00d8 }
            java.lang.Object r11 = kotlin.collections.CollectionsKt.first(r11)     // Catch:{ CancellationException -> 0x00d8 }
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11     // Catch:{ CancellationException -> 0x00d8 }
            long r5 = r11.m5111getIdJ3iCeTQ()     // Catch:{ CancellationException -> 0x00d8 }
            r0.L$0 = r9     // Catch:{ CancellationException -> 0x00d8 }
            r0.L$1 = r10     // Catch:{ CancellationException -> 0x00d8 }
            r0.L$2 = r11     // Catch:{ CancellationException -> 0x00d8 }
            r0.label = r4     // Catch:{ CancellationException -> 0x00d8 }
            java.lang.Object r12 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m364awaitLongPressOrCancellationrnUCldI(r9, r5, r0)     // Catch:{ CancellationException -> 0x00d8 }
            if (r12 != r1) goto L_0x0071
            return r1
        L_0x0071:
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12     // Catch:{ CancellationException -> 0x00d8 }
            if (r12 == 0) goto L_0x00d5
            long r4 = r11.m5113getPositionF1C5BW0()     // Catch:{ CancellationException -> 0x00d8 }
            long r6 = r12.m5113getPositionF1C5BW0()     // Catch:{ CancellationException -> 0x00d8 }
            boolean r11 = m1232distanceIsTolerable2x9bVx0(r9, r4, r6)     // Catch:{ CancellationException -> 0x00d8 }
            if (r11 == 0) goto L_0x00d5
            long r4 = r12.m5113getPositionF1C5BW0()     // Catch:{ CancellationException -> 0x00d8 }
            r10.m1121onStartk4lQ0M(r4)     // Catch:{ CancellationException -> 0x00d8 }
            long r11 = r12.m5111getIdJ3iCeTQ()     // Catch:{ CancellationException -> 0x00d8 }
            androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$2 r2 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$2     // Catch:{ CancellationException -> 0x00d8 }
            r2.<init>(r10)     // Catch:{ CancellationException -> 0x00d8 }
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2     // Catch:{ CancellationException -> 0x00d8 }
            r0.L$0 = r9     // Catch:{ CancellationException -> 0x00d8 }
            r0.L$1 = r10     // Catch:{ CancellationException -> 0x00d8 }
            r4 = 0
            r0.L$2 = r4     // Catch:{ CancellationException -> 0x00d8 }
            r0.label = r3     // Catch:{ CancellationException -> 0x00d8 }
            java.lang.Object r12 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m373dragjO51t88(r9, r11, r2, r0)     // Catch:{ CancellationException -> 0x00d8 }
            if (r12 != r1) goto L_0x00a5
            return r1
        L_0x00a5:
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch:{ CancellationException -> 0x00d8 }
            boolean r11 = r12.booleanValue()     // Catch:{ CancellationException -> 0x00d8 }
            if (r11 == 0) goto L_0x00d2
            androidx.compose.ui.input.pointer.PointerEvent r9 = r9.getCurrentEvent()     // Catch:{ CancellationException -> 0x00d8 }
            java.util.List r9 = r9.getChanges()     // Catch:{ CancellationException -> 0x00d8 }
            int r11 = r9.size()     // Catch:{ CancellationException -> 0x00d8 }
            r12 = 0
        L_0x00ba:
            if (r12 >= r11) goto L_0x00ce
            java.lang.Object r0 = r9.get(r12)     // Catch:{ CancellationException -> 0x00d8 }
            androidx.compose.ui.input.pointer.PointerInputChange r0 = (androidx.compose.ui.input.pointer.PointerInputChange) r0     // Catch:{ CancellationException -> 0x00d8 }
            boolean r1 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUp(r0)     // Catch:{ CancellationException -> 0x00d8 }
            if (r1 == 0) goto L_0x00cb
            r0.consume()     // Catch:{ CancellationException -> 0x00d8 }
        L_0x00cb:
            int r12 = r12 + 1
            goto L_0x00ba
        L_0x00ce:
            r10.onStop()     // Catch:{ CancellationException -> 0x00d8 }
            goto L_0x00d5
        L_0x00d2:
            r10.onCancel()     // Catch:{ CancellationException -> 0x00d8 }
        L_0x00d5:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x00d8:
            r9 = move-exception
            r10.onCancel()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.touchSelection(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.foundation.text.TextDragObserver, androidx.compose.ui.input.pointer.PointerEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: androidx.compose.foundation.text.selection.MouseSelectionObserver} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: androidx.compose.foundation.text.selection.MouseSelectionObserver} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object mouseSelection(androidx.compose.ui.input.pointer.AwaitPointerEventScope r7, androidx.compose.foundation.text.selection.MouseSelectionObserver r8, androidx.compose.foundation.text.selection.ClicksCounter r9, androidx.compose.ui.input.pointer.PointerEvent r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            boolean r0 = r11 instanceof androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$1 r0 = (androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$1 r0 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$1
            r0.<init>(r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x004d
            if (r2 == r5) goto L_0x0040
            if (r2 != r4) goto L_0x0038
            java.lang.Object r7 = r0.L$1
            r8 = r7
            androidx.compose.foundation.text.selection.MouseSelectionObserver r8 = (androidx.compose.foundation.text.selection.MouseSelectionObserver) r8
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00ef
        L_0x0038:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0040:
            java.lang.Object r7 = r0.L$1
            r8 = r7
            androidx.compose.foundation.text.selection.MouseSelectionObserver r8 = (androidx.compose.foundation.text.selection.MouseSelectionObserver) r8
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0085
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r11)
            r9.update(r10)
            java.util.List r11 = r10.getChanges()
            java.lang.Object r11 = r11.get(r3)
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            boolean r10 = androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt.isShiftPressed(r10)
            if (r10 == 0) goto L_0x00b1
            long r9 = r11.m5113getPositionF1C5BW0()
            boolean r9 = r8.m1213onExtendk4lQ0M(r9)
            if (r9 == 0) goto L_0x011a
            long r9 = r11.m5111getIdJ3iCeTQ()
            androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$shouldConsumeUp$1 r11 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$shouldConsumeUp$1
            r11.<init>(r8)
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r5
            java.lang.Object r11 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m373dragjO51t88(r7, r9, r11, r0)
            if (r11 != r1) goto L_0x0085
            return r1
        L_0x0085:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r9 = r11.booleanValue()
            if (r9 == 0) goto L_0x00ad
            androidx.compose.ui.input.pointer.PointerEvent r7 = r7.getCurrentEvent()
            java.util.List r7 = r7.getChanges()
            int r9 = r7.size()
        L_0x0099:
            if (r3 >= r9) goto L_0x00ad
            java.lang.Object r10 = r7.get(r3)
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            boolean r11 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUp(r10)
            if (r11 == 0) goto L_0x00aa
            r10.consume()
        L_0x00aa:
            int r3 = r3 + 1
            goto L_0x0099
        L_0x00ad:
            r8.onDragDone()
            goto L_0x011a
        L_0x00b1:
            int r9 = r9.getClicks()
            if (r9 == r5) goto L_0x00c7
            if (r9 == r4) goto L_0x00c0
            androidx.compose.foundation.text.selection.SelectionAdjustment$Companion r9 = androidx.compose.foundation.text.selection.SelectionAdjustment.Companion
            androidx.compose.foundation.text.selection.SelectionAdjustment r9 = r9.getParagraph()
            goto L_0x00cd
        L_0x00c0:
            androidx.compose.foundation.text.selection.SelectionAdjustment$Companion r9 = androidx.compose.foundation.text.selection.SelectionAdjustment.Companion
            androidx.compose.foundation.text.selection.SelectionAdjustment r9 = r9.getWord()
            goto L_0x00cd
        L_0x00c7:
            androidx.compose.foundation.text.selection.SelectionAdjustment$Companion r9 = androidx.compose.foundation.text.selection.SelectionAdjustment.Companion
            androidx.compose.foundation.text.selection.SelectionAdjustment r9 = r9.getNone()
        L_0x00cd:
            long r5 = r11.m5113getPositionF1C5BW0()
            boolean r10 = r8.m1215onStart3MmeM6k(r5, r9)
            if (r10 == 0) goto L_0x011a
            long r10 = r11.m5111getIdJ3iCeTQ()
            androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$shouldConsumeUp$2 r2 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$shouldConsumeUp$2
            r2.<init>(r8, r9)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r11 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m373dragjO51t88(r7, r10, r2, r0)
            if (r11 != r1) goto L_0x00ef
            return r1
        L_0x00ef:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r9 = r11.booleanValue()
            if (r9 == 0) goto L_0x0117
            androidx.compose.ui.input.pointer.PointerEvent r7 = r7.getCurrentEvent()
            java.util.List r7 = r7.getChanges()
            int r9 = r7.size()
        L_0x0103:
            if (r3 >= r9) goto L_0x0117
            java.lang.Object r10 = r7.get(r3)
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            boolean r11 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUp(r10)
            if (r11 == 0) goto L_0x0114
            r10.consume()
        L_0x0114:
            int r3 = r3 + 1
            goto L_0x0103
        L_0x0117:
            r8.onDragDone()
        L_0x011a:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.mouseSelection(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.foundation.text.selection.MouseSelectionObserver, androidx.compose.foundation.text.selection.ClicksCounter, androidx.compose.ui.input.pointer.PointerEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0045 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0063 A[SYNTHETIC] */
    public static final java.lang.Object awaitDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope r7, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerEvent> r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1 r0 = (androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1 r0 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1
            r0.<init>(r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0046
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r8)
        L_0x0039:
            androidx.compose.ui.input.pointer.PointerEventPass r8 = androidx.compose.ui.input.pointer.PointerEventPass.Main
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r8 = r7.awaitPointerEvent(r8, r0)
            if (r8 != r1) goto L_0x0046
            return r1
        L_0x0046:
            androidx.compose.ui.input.pointer.PointerEvent r8 = (androidx.compose.ui.input.pointer.PointerEvent) r8
            java.util.List r2 = r8.getChanges()
            int r4 = r2.size()
            r5 = 0
        L_0x0051:
            if (r5 >= r4) goto L_0x0063
            java.lang.Object r6 = r2.get(r5)
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            boolean r6 = androidx.compose.ui.input.pointer.PointerEventKt.changedToDownIgnoreConsumed(r6)
            if (r6 != 0) goto L_0x0060
            goto L_0x0039
        L_0x0060:
            int r5 = r5 + 1
            goto L_0x0051
        L_0x0063:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.awaitDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: distanceIsTolerable-2x9bVx0  reason: not valid java name */
    private static final boolean m1232distanceIsTolerable2x9bVx0(AwaitPointerEventScope awaitPointerEventScope, long j, long j2) {
        return Offset.m3560getDistanceimpl(Offset.m3566minusMKHz9U(j, j2)) < awaitPointerEventScope.getViewConfiguration().getTouchSlop();
    }

    public static final boolean isPrecisePointer(PointerEvent pointerEvent) {
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            if (!PointerType.m5189equalsimpl0(changes.get(i).m5116getTypeT8wyACA(), PointerType.Companion.m5194getMouseT8wyACA())) {
                return false;
            }
        }
        return true;
    }
}
