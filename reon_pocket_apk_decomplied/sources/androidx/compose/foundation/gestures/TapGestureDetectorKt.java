package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001c\u0010\t\u001a\u00020\n*\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH@¢\u0006\u0002\u0010\u000e\u001a&\u0010\t\u001a\u00020\n*\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H@¢\u0006\u0002\u0010\u0011\u001a\u001c\u0010\u0012\u001a\u0004\u0018\u00010\n*\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\nH@¢\u0006\u0002\u0010\u0014\u001a\u0012\u0010\u0015\u001a\u00020\u0005*\u00020\u000bH@¢\u0006\u0002\u0010\u0016\u001a[\u0010\u0017\u001a\u00020\u0005*\u00020\u00182/\b\u0002\u0010\u0019\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u00072\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001bH@¢\u0006\u0002\u0010\u001c\u001a\u0001\u0010\u001d\u001a\u00020\u0005*\u00020\u00182\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001b2\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001b2/\b\u0002\u0010\u0019\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u00072\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001bH@¢\u0006\u0002\u0010 \u001a\u0014\u0010!\u001a\u0004\u0018\u00010\n*\u00020\u000bH@¢\u0006\u0002\u0010\u0016\u001a\u001e\u0010!\u001a\u0004\u0018\u00010\n*\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H@¢\u0006\u0002\u0010\"\"7\u0010\u0000\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\b\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006#"}, d2 = {"NoPressGesture", "Lkotlin/Function3;", "Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function3;", "awaitFirstDown", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "requireUnconsumed", "", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLandroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSecondDown", "firstUp", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerInputChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeUntilUp", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTapAndPress", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onPress", "onTap", "Lkotlin/Function1;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTapGestures", "onDoubleTap", "onLongPress", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForUpOrCancellation", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TapGestureDetector.kt */
public final class TapGestureDetectorKt {
    /* access modifiers changed from: private */
    public static final Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> NoPressGesture = new TapGestureDetectorKt$NoPressGesture$1((Continuation<? super TapGestureDetectorKt$NoPressGesture$1>) null);

    public static /* synthetic */ Object detectTapGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function1 function12, Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3, Function1 function13, Continuation continuation, int i, Object obj) {
        Function1 function14 = (i & 1) != 0 ? null : function1;
        Function1 function15 = (i & 2) != 0 ? null : function12;
        if ((i & 4) != 0) {
            function3 = NoPressGesture;
        }
        return detectTapGestures(pointerInputScope, function14, function15, function3, (i & 8) != 0 ? null : function13, continuation);
    }

    public static final Object detectTapGestures(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function12, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function13, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new TapGestureDetectorKt$detectTapGestures$2(pointerInputScope, function3, function12, function1, function13, (Continuation<? super TapGestureDetectorKt$detectTapGestures$2>) null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0053 A[LOOP:0: B:17:0x0051->B:18:0x0053, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0079 A[SYNTHETIC] */
    public static final java.lang.Object consumeUntilUp(androidx.compose.ui.input.pointer.AwaitPointerEventScope r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            boolean r0 = r9 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1
            r0.<init>(r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r8 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0045
        L_0x002e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r9)
        L_0x0039:
            r0.L$0 = r8
            r0.label = r3
            r9 = 0
            java.lang.Object r9 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r8, r9, r0, r3, r9)
            if (r9 != r1) goto L_0x0045
            return r1
        L_0x0045:
            androidx.compose.ui.input.pointer.PointerEvent r9 = (androidx.compose.ui.input.pointer.PointerEvent) r9
            java.util.List r2 = r9.getChanges()
            int r4 = r2.size()
            r5 = 0
            r6 = r5
        L_0x0051:
            if (r6 >= r4) goto L_0x005f
            java.lang.Object r7 = r2.get(r6)
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            r7.consume()
            int r6 = r6 + 1
            goto L_0x0051
        L_0x005f:
            java.util.List r9 = r9.getChanges()
            int r2 = r9.size()
        L_0x0067:
            if (r5 >= r2) goto L_0x0079
            java.lang.Object r4 = r9.get(r5)
            androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
            boolean r4 = r4.getPressed()
            if (r4 == 0) goto L_0x0076
            goto L_0x0039
        L_0x0076:
            int r5 = r5 + 1
            goto L_0x0067
        L_0x0079:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.consumeUntilUp(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final Object awaitSecondDown(AwaitPointerEventScope awaitPointerEventScope, PointerInputChange pointerInputChange, Continuation<? super PointerInputChange> continuation) {
        return awaitPointerEventScope.withTimeoutOrNull(awaitPointerEventScope.getViewConfiguration().getDoubleTapTimeoutMillis(), new TapGestureDetectorKt$awaitSecondDown$2(pointerInputChange, (Continuation<? super TapGestureDetectorKt$awaitSecondDown$2>) null), continuation);
    }

    public static /* synthetic */ Object detectTapAndPress$default(PointerInputScope pointerInputScope, Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function3 = NoPressGesture;
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        return detectTapAndPress(pointerInputScope, function3, function1, continuation);
    }

    public static final Object detectTapAndPress(PointerInputScope pointerInputScope, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new TapGestureDetectorKt$detectTapAndPress$2(pointerInputScope, function3, function1, new PressGestureScopeImpl(pointerInputScope), (Continuation<? super TapGestureDetectorKt$detectTapAndPress$2>) null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public static /* synthetic */ Object awaitFirstDown$default(AwaitPointerEventScope awaitPointerEventScope, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return awaitFirstDown(awaitPointerEventScope, z, PointerEventPass.Main, continuation);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0051 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0077 A[SYNTHETIC] */
    public static final java.lang.Object awaitFirstDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope r9, boolean r10, androidx.compose.ui.input.pointer.PointerEventPass r11, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r12) {
        /*
            boolean r0 = r12 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2
            if (r0 == 0) goto L_0x0014
            r0 = r12
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2
            r0.<init>(r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            boolean r9 = r0.Z$0
            java.lang.Object r10 = r0.L$1
            androidx.compose.ui.input.pointer.PointerEventPass r10 = (androidx.compose.ui.input.pointer.PointerEventPass) r10
            java.lang.Object r11 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
            kotlin.ResultKt.throwOnFailure(r12)
            r8 = r10
            r10 = r9
            r9 = r11
            r11 = r8
            goto L_0x0052
        L_0x0038:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r12)
        L_0x0043:
            r0.L$0 = r9
            r0.L$1 = r11
            r0.Z$0 = r10
            r0.label = r3
            java.lang.Object r12 = r9.awaitPointerEvent(r11, r0)
            if (r12 != r1) goto L_0x0052
            return r1
        L_0x0052:
            androidx.compose.ui.input.pointer.PointerEvent r12 = (androidx.compose.ui.input.pointer.PointerEvent) r12
            java.util.List r2 = r12.getChanges()
            int r4 = r2.size()
            r5 = 0
            r6 = r5
        L_0x005e:
            if (r6 >= r4) goto L_0x0077
            java.lang.Object r7 = r2.get(r6)
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            if (r10 == 0) goto L_0x006d
            boolean r7 = androidx.compose.ui.input.pointer.PointerEventKt.changedToDown(r7)
            goto L_0x0071
        L_0x006d:
            boolean r7 = androidx.compose.ui.input.pointer.PointerEventKt.changedToDownIgnoreConsumed(r7)
        L_0x0071:
            if (r7 != 0) goto L_0x0074
            goto L_0x0043
        L_0x0074:
            int r6 = r6 + 1
            goto L_0x005e
        L_0x0077:
            java.util.List r9 = r12.getChanges()
            java.lang.Object r9 = r9.get(r5)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope, boolean, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object awaitFirstDown$default(AwaitPointerEventScope awaitPointerEventScope, boolean z, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return awaitFirstDown(awaitPointerEventScope, z, pointerEventPass, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008b, code lost:
        r0 = r0.getChanges();
        r9 = r0.size();
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0094, code lost:
        if (r10 >= r9) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0096, code lost:
        r11 = r0.get(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a0, code lost:
        if (r11.isConsumed() != false) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ae, code lost:
        if (androidx.compose.ui.input.pointer.PointerEventKt.m5057isOutOfBoundsjwHxaWs(r11, r8.m5010getSizeYbymL2g(), r8.m5009getExtendedTouchPaddingNHjbRc()) == false) goto L_0x00b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b1, code lost:
        r10 = r10 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b4, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b5, code lost:
        r0 = androidx.compose.ui.input.pointer.PointerEventPass.Final;
        r1.L$0 = r8;
        r1.L$1 = r3;
        r1.label = 2;
        r0 = r8.awaitPointerEvent(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c1, code lost:
        if (r0 != r2) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c3, code lost:
        return r2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0067 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00de A[LOOP:2: B:36:0x00cf->B:40:0x00de, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e7 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00dd A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object waitForUpOrCancellation(androidx.compose.ui.input.pointer.AwaitPointerEventScope r18, androidx.compose.ui.input.pointer.PointerEventPass r19, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r20) {
        /*
            r0 = r20
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForUpOrCancellation$2
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForUpOrCancellation$2 r1 = (androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForUpOrCancellation$2) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForUpOrCancellation$2 r1 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForUpOrCancellation$2
            r1.<init>(r0)
        L_0x001b:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 0
            r5 = 2
            r6 = 0
            r7 = 1
            if (r3 == 0) goto L_0x0053
            if (r3 == r7) goto L_0x0047
            if (r3 != r5) goto L_0x003f
            java.lang.Object r3 = r1.L$1
            androidx.compose.ui.input.pointer.PointerEventPass r3 = (androidx.compose.ui.input.pointer.PointerEventPass) r3
            java.lang.Object r8 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            kotlin.ResultKt.throwOnFailure(r0)
        L_0x0038:
            r16 = r3
            r3 = r1
            r1 = r16
            goto L_0x00c4
        L_0x003f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0047:
            java.lang.Object r3 = r1.L$1
            androidx.compose.ui.input.pointer.PointerEventPass r3 = (androidx.compose.ui.input.pointer.PointerEventPass) r3
            java.lang.Object r8 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0072
        L_0x0053:
            kotlin.ResultKt.throwOnFailure(r0)
            r0 = r18
            r3 = r1
            r1 = r19
        L_0x005b:
            r3.L$0 = r0
            r3.L$1 = r1
            r3.label = r7
            java.lang.Object r8 = r0.awaitPointerEvent(r1, r3)
            if (r8 != r2) goto L_0x0068
            return r2
        L_0x0068:
            r16 = r8
            r8 = r0
            r0 = r16
            r17 = r3
            r3 = r1
            r1 = r17
        L_0x0072:
            androidx.compose.ui.input.pointer.PointerEvent r0 = (androidx.compose.ui.input.pointer.PointerEvent) r0
            java.util.List r9 = r0.getChanges()
            int r10 = r9.size()
            r11 = r6
        L_0x007d:
            if (r11 >= r10) goto L_0x00e7
            java.lang.Object r12 = r9.get(r11)
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            boolean r12 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUp(r12)
            if (r12 != 0) goto L_0x00e4
            java.util.List r0 = r0.getChanges()
            int r9 = r0.size()
            r10 = r6
        L_0x0094:
            if (r10 >= r9) goto L_0x00b5
            java.lang.Object r11 = r0.get(r10)
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            boolean r12 = r11.isConsumed()
            if (r12 != 0) goto L_0x00b4
            long r12 = r8.m5010getSizeYbymL2g()
            long r14 = r8.m5009getExtendedTouchPaddingNHjbRc()
            boolean r11 = androidx.compose.ui.input.pointer.PointerEventKt.m5057isOutOfBoundsjwHxaWs(r11, r12, r14)
            if (r11 == 0) goto L_0x00b1
            goto L_0x00b4
        L_0x00b1:
            int r10 = r10 + 1
            goto L_0x0094
        L_0x00b4:
            return r4
        L_0x00b5:
            androidx.compose.ui.input.pointer.PointerEventPass r0 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r1.L$0 = r8
            r1.L$1 = r3
            r1.label = r5
            java.lang.Object r0 = r8.awaitPointerEvent(r0, r1)
            if (r0 != r2) goto L_0x0038
            return r2
        L_0x00c4:
            androidx.compose.ui.input.pointer.PointerEvent r0 = (androidx.compose.ui.input.pointer.PointerEvent) r0
            java.util.List r0 = r0.getChanges()
            int r9 = r0.size()
            r10 = r6
        L_0x00cf:
            if (r10 >= r9) goto L_0x00e1
            java.lang.Object r11 = r0.get(r10)
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            boolean r11 = r11.isConsumed()
            if (r11 == 0) goto L_0x00de
            return r4
        L_0x00de:
            int r10 = r10 + 1
            goto L_0x00cf
        L_0x00e1:
            r0 = r8
            goto L_0x005b
        L_0x00e4:
            int r11 = r11 + 1
            goto L_0x007d
        L_0x00e7:
            java.util.List r0 = r0.getChanges()
            java.lang.Object r0 = r0.get(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object waitForUpOrCancellation$default(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return waitForUpOrCancellation(awaitPointerEventScope, pointerEventPass, continuation);
    }
}
