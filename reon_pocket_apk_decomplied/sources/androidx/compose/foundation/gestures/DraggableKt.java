package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u001a!\u0010\b\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0007¢\u0006\u0002\u0010\t\u001aR\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b*\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H@¢\u0006\u0002\u0010\u0017\u001aY\u0010\u0018\u001a\u00020\u0010*\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u00102\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100\u0005H@ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001aÉ\u0001\u0010\"\u001a\u00020#*\u00020#2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020\u00102\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\b\b\u0002\u0010\u0011\u001a\u00020\u00102>\b\u0002\u0010*\u001a8\b\u0001\u0012\u0004\u0012\u00020,\u0012\u0013\u0012\u00110\r¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000700\u0012\u0006\u0012\u0004\u0018\u0001010+¢\u0006\u0002\b22>\b\u0002\u00103\u001a8\b\u0001\u0012\u0004\u0012\u00020,\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(4\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000700\u0012\u0006\u0012\u0004\u0018\u0001010+¢\u0006\u0002\b22\b\b\u0002\u0010\u001e\u001a\u00020\u0010¢\u0006\u0002\u00105\u001aG\u00106\u001a\u00020\u0010*\u00020\u000e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100\u00052\u0006\u00107\u001a\u0002082\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u0005H@ø\u0001\u0000¢\u0006\u0004\b:\u0010;\u001a\u001e\u0010<\u001a\u00020\u0006*\u00020\r2\u0006\u0010%\u001a\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a\u001e\u0010<\u001a\u00020\u0006*\u00020?2\u0006\u0010%\u001a\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\b@\u0010>\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006A"}, d2 = {"NoOpDragScope", "Landroidx/compose/foundation/gestures/DragScope;", "DraggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "onDelta", "Lkotlin/Function1;", "", "", "rememberDraggableState", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/DraggableState;", "awaitDownAndSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "canDrag", "", "startDragImmediately", "Lkotlin/Function0;", "velocityTracker", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "pointerDirectionConfig", "Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/input/pointer/util/VelocityTracker;Landroidx/compose/foundation/gestures/PointerDirectionConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDrag", "startEvent", "initialDelta", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "Landroidx/compose/foundation/gestures/DragEvent;", "reverseDirection", "hasDragged", "awaitDrag-Su4bsnU", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerInputChange;JLandroidx/compose/ui/input/pointer/util/VelocityTracker;Lkotlinx/coroutines/channels/SendChannel;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "draggable", "Landroidx/compose/ui/Modifier;", "state", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "onDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/ParameterName;", "name", "startedPosition", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "onDragStopped", "velocity", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/gestures/DraggableState;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)Landroidx/compose/ui/Modifier;", "onDragOrUp", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "onDrag", "onDragOrUp-Axegvzg", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/jvm/functions/Function1;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toFloat", "toFloat-3MmeM6k", "(JLandroidx/compose/foundation/gestures/Orientation;)F", "Landroidx/compose/ui/unit/Velocity;", "toFloat-sF-c-tU", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Draggable.kt */
public final class DraggableKt {
    /* access modifiers changed from: private */
    public static final DragScope NoOpDragScope = new DraggableKt$NoOpDragScope$1();

    public static final DraggableState DraggableState(Function1<? super Float, Unit> function1) {
        return new DefaultDraggableState(function1);
    }

    public static final DraggableState rememberDraggableState(Function1<? super Float, Unit> function1, Composer composer, int i) {
        composer.startReplaceableGroup(-183245213);
        ComposerKt.sourceInformation(composer, "C(rememberDraggableState)142@6209L29,143@6250L61:Draggable.kt#8bwon0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-183245213, i, -1, "androidx.compose.foundation.gestures.rememberDraggableState (Draggable.kt:141)");
        }
        State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composer, i & 14);
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = DraggableState(new DraggableKt$rememberDraggableState$1$1(rememberUpdatedState));
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        DraggableState draggableState = (DraggableState) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return draggableState;
    }

    public static /* synthetic */ Modifier draggable$default(Modifier modifier, DraggableState draggableState, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, boolean z2, Function3 function3, Function3 function32, boolean z3, int i, Object obj) {
        int i2 = i;
        return draggable(modifier, draggableState, orientation, (i2 & 4) != 0 ? true : z, (i2 & 8) != 0 ? null : mutableInteractionSource, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? new DraggableKt$draggable$1((Continuation<? super DraggableKt$draggable$1>) null) : function3, (i2 & 64) != 0 ? new DraggableKt$draggable$2((Continuation<? super DraggableKt$draggable$2>) null) : function32, (i2 & 128) != 0 ? false : z3);
    }

    public static final Modifier draggable(Modifier modifier, DraggableState draggableState, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, boolean z2, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> function32, boolean z3) {
        DraggableState draggableState2 = draggableState;
        Modifier modifier2 = modifier;
        return modifier.then(new DraggableElement(draggableState2, DraggableKt$draggable$3.INSTANCE, orientation, z, mutableInteractionSource, new DraggableKt$draggable$4(z2), function3, new DraggableKt$draggable$5(function32, orientation, (Continuation<? super DraggableKt$draggable$5>) null), z3));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x018f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x025f  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x027f  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x028a A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01c7 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object awaitDownAndSlop(androidx.compose.ui.input.pointer.AwaitPointerEventScope r20, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Boolean> r21, kotlin.jvm.functions.Function0<java.lang.Boolean> r22, androidx.compose.ui.input.pointer.util.VelocityTracker r23, androidx.compose.foundation.gestures.PointerDirectionConfig r24, kotlin.coroutines.Continuation<? super kotlin.Pair<androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.geometry.Offset>> r25) {
        /*
            r0 = r20
            r1 = r25
            boolean r2 = r1 instanceof androidx.compose.foundation.gestures.DraggableKt$awaitDownAndSlop$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            androidx.compose.foundation.gestures.DraggableKt$awaitDownAndSlop$1 r2 = (androidx.compose.foundation.gestures.DraggableKt$awaitDownAndSlop$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DraggableKt$awaitDownAndSlop$1 r2 = new androidx.compose.foundation.gestures.DraggableKt$awaitDownAndSlop$1
            r2.<init>(r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 0
            r9 = 1
            r10 = 0
            if (r4 == 0) goto L_0x00b4
            if (r4 == r9) goto L_0x009c
            if (r4 == r7) goto L_0x008b
            if (r4 == r6) goto L_0x0065
            if (r4 != r5) goto L_0x005d
            long r11 = r2.J$0
            float r0 = r2.F$0
            java.lang.Object r4 = r2.L$5
            androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
            java.lang.Object r7 = r2.L$4
            kotlin.jvm.internal.Ref$LongRef r7 = (kotlin.jvm.internal.Ref.LongRef) r7
            java.lang.Object r13 = r2.L$3
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
            java.lang.Object r14 = r2.L$2
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            java.lang.Object r15 = r2.L$1
            kotlin.jvm.internal.Ref$LongRef r15 = (kotlin.jvm.internal.Ref.LongRef) r15
            java.lang.Object r5 = r2.L$0
            androidx.compose.foundation.gestures.PointerDirectionConfig r5 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = r0
            r0 = r5
            r8 = r11
            r5 = r13
            r11 = r14
            r13 = r15
            r10 = 4
            goto L_0x0256
        L_0x005d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0065:
            long r4 = r2.J$0
            float r0 = r2.F$0
            java.lang.Object r7 = r2.L$4
            kotlin.jvm.internal.Ref$LongRef r7 = (kotlin.jvm.internal.Ref.LongRef) r7
            java.lang.Object r11 = r2.L$3
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
            java.lang.Object r12 = r2.L$2
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            java.lang.Object r13 = r2.L$1
            kotlin.jvm.internal.Ref$LongRef r13 = (kotlin.jvm.internal.Ref.LongRef) r13
            java.lang.Object r14 = r2.L$0
            androidx.compose.foundation.gestures.PointerDirectionConfig r14 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r14
            kotlin.ResultKt.throwOnFailure(r1)
            r18 = r2
            r2 = r0
            r0 = r14
            r14 = r4
            r5 = r11
            r11 = r12
        L_0x0087:
            r4 = r18
            goto L_0x0199
        L_0x008b:
            java.lang.Object r0 = r2.L$2
            androidx.compose.foundation.gestures.PointerDirectionConfig r0 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r0
            java.lang.Object r4 = r2.L$1
            androidx.compose.ui.input.pointer.util.VelocityTracker r4 = (androidx.compose.ui.input.pointer.util.VelocityTracker) r4
            java.lang.Object r5 = r2.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0134
        L_0x009c:
            java.lang.Object r0 = r2.L$4
            androidx.compose.foundation.gestures.PointerDirectionConfig r0 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r0
            java.lang.Object r4 = r2.L$3
            androidx.compose.ui.input.pointer.util.VelocityTracker r4 = (androidx.compose.ui.input.pointer.util.VelocityTracker) r4
            java.lang.Object r5 = r2.L$2
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            java.lang.Object r11 = r2.L$1
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            java.lang.Object r12 = r2.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r12 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r12
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x00de
        L_0x00b4:
            kotlin.ResultKt.throwOnFailure(r1)
            androidx.compose.ui.input.pointer.PointerEventPass r1 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
            r2.L$0 = r0
            r4 = r21
            r2.L$1 = r4
            r5 = r22
            r2.L$2 = r5
            r11 = r23
            r2.L$3 = r11
            r12 = r24
            r2.L$4 = r12
            r2.label = r9
            java.lang.Object r1 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(r0, r8, r1, r2)
            if (r1 != r3) goto L_0x00d4
            return r3
        L_0x00d4:
            r18 = r12
            r12 = r0
            r0 = r18
            r19 = r11
            r11 = r4
            r4 = r19
        L_0x00de:
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            java.lang.Object r11 = r11.invoke(r1)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 != 0) goto L_0x00ee
            goto L_0x028b
        L_0x00ee:
            java.lang.Object r5 = r5.invoke()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0110
            r1.consume()
            androidx.compose.ui.input.pointer.util.VelocityTrackerKt.addPointerInputChange(r4, r1)
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r2 = r0.m3578getZeroF1C5BW0()
            androidx.compose.ui.geometry.Offset r0 = androidx.compose.ui.geometry.Offset.m3551boximpl(r2)
            kotlin.Pair r10 = kotlin.TuplesKt.to(r1, r0)
            goto L_0x028b
        L_0x0110:
            r2.L$0 = r12
            r2.L$1 = r4
            r2.L$2 = r0
            r2.L$3 = r10
            r2.L$4 = r10
            r2.label = r7
            r1 = 0
            r5 = 0
            r7 = 2
            r11 = 0
            r20 = r12
            r21 = r1
            r22 = r5
            r23 = r2
            r24 = r7
            r25 = r11
            java.lang.Object r1 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r20, r21, r22, r23, r24, r25)
            if (r1 != r3) goto L_0x0133
            return r3
        L_0x0133:
            r5 = r12
        L_0x0134:
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            androidx.compose.ui.input.pointer.util.VelocityTrackerKt.addPointerInputChange(r4, r1)
            kotlin.jvm.internal.Ref$LongRef r7 = new kotlin.jvm.internal.Ref$LongRef
            r7.<init>()
            androidx.compose.ui.geometry.Offset$Companion r11 = androidx.compose.ui.geometry.Offset.Companion
            long r11 = r11.m3578getZeroF1C5BW0()
            r7.element = r11
            androidx.compose.foundation.gestures.DraggableKt$awaitDownAndSlop$postPointerSlop$1 r11 = new androidx.compose.foundation.gestures.DraggableKt$awaitDownAndSlop$postPointerSlop$1
            r11.<init>(r4, r7)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            long r12 = r1.m5111getIdJ3iCeTQ()
            int r1 = r1.m5116getTypeT8wyACA()
            androidx.compose.ui.input.pointer.PointerEvent r4 = r5.getCurrentEvent()
            boolean r4 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m375isPointerUpDmW0f2w(r4, r12)
            if (r4 == 0) goto L_0x0162
            r5 = r10
            goto L_0x027d
        L_0x0162:
            androidx.compose.ui.platform.ViewConfiguration r4 = r5.getViewConfiguration()
            float r1 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m376pointerSlopE8SPZFQ(r4, r1)
            kotlin.jvm.internal.Ref$LongRef r4 = new kotlin.jvm.internal.Ref$LongRef
            r4.<init>()
            r4.element = r12
            androidx.compose.ui.geometry.Offset$Companion r12 = androidx.compose.ui.geometry.Offset.Companion
            long r12 = r12.m3578getZeroF1C5BW0()
        L_0x0177:
            r2.L$0 = r0
            r2.L$1 = r7
            r2.L$2 = r11
            r2.L$3 = r5
            r2.L$4 = r4
            r2.L$5 = r10
            r2.F$0 = r1
            r2.J$0 = r12
            r2.label = r6
            java.lang.Object r14 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r5, r10, r2, r9, r10)
            if (r14 != r3) goto L_0x0190
            return r3
        L_0x0190:
            r18 = r2
            r2 = r1
            r1 = r14
            r14 = r12
            r13 = r7
            r7 = r4
            goto L_0x0087
        L_0x0199:
            androidx.compose.ui.input.pointer.PointerEvent r1 = (androidx.compose.ui.input.pointer.PointerEvent) r1
            java.util.List r12 = r1.getChanges()
            int r6 = r12.size()
        L_0x01a3:
            if (r8 >= r6) goto L_0x01c7
            java.lang.Object r16 = r12.get(r8)
            r17 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r17 = (androidx.compose.ui.input.pointer.PointerInputChange) r17
            long r9 = r17.m5111getIdJ3iCeTQ()
            r17 = r5
            r20 = r6
            long r5 = r7.element
            boolean r5 = androidx.compose.ui.input.pointer.PointerId.m5095equalsimpl0(r9, r5)
            if (r5 == 0) goto L_0x01be
            goto L_0x01cb
        L_0x01be:
            int r8 = r8 + 1
            r6 = r20
            r5 = r17
            r9 = 1
            r10 = 0
            goto L_0x01a3
        L_0x01c7:
            r17 = r5
            r16 = 0
        L_0x01cb:
            r5 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
            if (r5 != 0) goto L_0x01d3
            goto L_0x025c
        L_0x01d3:
            boolean r6 = r5.isConsumed()
            if (r6 == 0) goto L_0x01db
            goto L_0x025c
        L_0x01db:
            boolean r6 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r5)
            if (r6 == 0) goto L_0x0216
            java.util.List r1 = r1.getChanges()
            int r5 = r1.size()
            r6 = 0
        L_0x01ea:
            if (r6 >= r5) goto L_0x01fd
            java.lang.Object r8 = r1.get(r6)
            r9 = r8
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            boolean r9 = r9.getPressed()
            if (r9 == 0) goto L_0x01fa
            goto L_0x01fe
        L_0x01fa:
            int r6 = r6 + 1
            goto L_0x01ea
        L_0x01fd:
            r8 = 0
        L_0x01fe:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 != 0) goto L_0x0203
            goto L_0x025c
        L_0x0203:
            long r5 = r8.m5111getIdJ3iCeTQ()
            r7.element = r5
            r1 = r2
            r2 = r4
            r4 = r7
            r7 = r13
            r12 = r14
            r5 = r17
            r6 = 3
            r8 = 0
            r9 = 1
            r10 = 0
            goto L_0x0177
        L_0x0216:
            long r8 = r5.m5113getPositionF1C5BW0()
            r1 = r7
            long r6 = r5.m5114getPreviousPositionF1C5BW0()
            long r6 = androidx.compose.ui.geometry.Offset.m3566minusMKHz9U(r8, r6)
            long r6 = androidx.compose.ui.geometry.Offset.m3567plusMKHz9U(r14, r6)
            float r8 = r0.m406calculateDeltaChangek4lQ0M(r6)
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 >= 0) goto L_0x0268
            androidx.compose.ui.input.pointer.PointerEventPass r8 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r4.L$0 = r0
            r4.L$1 = r13
            r4.L$2 = r11
            r9 = r17
            r4.L$3 = r9
            r4.L$4 = r1
            r4.L$5 = r5
            r4.F$0 = r2
            r4.J$0 = r6
            r10 = 4
            r4.label = r10
            java.lang.Object r8 = r9.awaitPointerEvent(r8, r4)
            if (r8 != r3) goto L_0x024d
            return r3
        L_0x024d:
            r18 = r6
            r7 = r1
            r1 = r2
            r2 = r4
            r4 = r5
            r5 = r9
            r8 = r18
        L_0x0256:
            boolean r4 = r4.isConsumed()
            if (r4 == 0) goto L_0x025f
        L_0x025c:
            r7 = r13
            r5 = 0
            goto L_0x027d
        L_0x025f:
            r4 = r7
            r7 = r13
            r6 = 3
            r10 = 0
            r12 = r8
            r8 = 0
            r9 = 1
            goto L_0x0177
        L_0x0268:
            r9 = r17
            r10 = 4
            long r6 = r0.m407calculatePostSlopOffset8S9VItk(r6, r2)
            androidx.compose.ui.geometry.Offset r6 = androidx.compose.ui.geometry.Offset.m3551boximpl(r6)
            r11.invoke(r5, r6)
            boolean r6 = r5.isConsumed()
            if (r6 == 0) goto L_0x028c
            r7 = r13
        L_0x027d:
            if (r5 == 0) goto L_0x028a
            long r0 = r7.element
            androidx.compose.ui.geometry.Offset r0 = androidx.compose.ui.geometry.Offset.m3551boximpl(r0)
            kotlin.Pair r10 = kotlin.TuplesKt.to(r5, r0)
            goto L_0x028b
        L_0x028a:
            r10 = 0
        L_0x028b:
            return r10
        L_0x028c:
            androidx.compose.ui.geometry.Offset$Companion r5 = androidx.compose.ui.geometry.Offset.Companion
            long r5 = r5.m3578getZeroF1C5BW0()
            r7 = r13
            r8 = 0
            r10 = 0
            r12 = r5
            r5 = r9
            r6 = 3
            r9 = 1
            r18 = r4
            r4 = r1
            r1 = r2
            r2 = r18
            goto L_0x0177
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableKt.awaitDownAndSlop(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.ui.input.pointer.util.VelocityTracker, androidx.compose.foundation.gestures.PointerDirectionConfig, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* renamed from: awaitDrag-Su4bsnU  reason: not valid java name */
    public static final Object m398awaitDragSu4bsnU(AwaitPointerEventScope awaitPointerEventScope, PointerInputChange pointerInputChange, long j, VelocityTracker velocityTracker, SendChannel<? super DragEvent> sendChannel, boolean z, Function1<? super PointerInputChange, Boolean> function1, Continuation<? super Boolean> continuation) {
        long j2;
        SendChannel<? super DragEvent> sendChannel2 = sendChannel;
        boolean z2 = z;
        sendChannel.m8593trySendJP2dKIU(new DragEvent.DragStarted(Offset.m3566minusMKHz9U(pointerInputChange.m5113getPositionF1C5BW0(), OffsetKt.Offset(Offset.m3562getXimpl(j) * Math.signum(Offset.m3562getXimpl(pointerInputChange.m5113getPositionF1C5BW0())), Offset.m3563getYimpl(j) * Math.signum(Offset.m3563getYimpl(pointerInputChange.m5113getPositionF1C5BW0())))), (DefaultConstructorMarker) null));
        if (z2) {
            long j3 = j;
            j2 = Offset.m3569timestuRUvjQ(j, -1.0f);
        } else {
            j2 = j;
        }
        sendChannel.m8593trySendJP2dKIU(new DragEvent.DragDelta(j2, (DefaultConstructorMarker) null));
        VelocityTracker velocityTracker2 = velocityTracker;
        return m399onDragOrUpAxegvzg(awaitPointerEventScope, function1, pointerInputChange.m5111getIdJ3iCeTQ(), new DraggableKt$awaitDrag$2(velocityTracker, sendChannel, z), continuation);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f7, code lost:
        if (r1.invoke(r14).booleanValue() != false) goto L_0x00f9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0085 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b5 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* renamed from: onDragOrUp-Axegvzg  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m399onDragOrUpAxegvzg(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Boolean> r18, long r19, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r21, kotlin.coroutines.Continuation<? super java.lang.Boolean> r22) {
        /*
            r0 = r22
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.DraggableKt$onDragOrUp$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.DraggableKt$onDragOrUp$1 r1 = (androidx.compose.foundation.gestures.DraggableKt$onDragOrUp$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.DraggableKt$onDragOrUp$1 r1 = new androidx.compose.foundation.gestures.DraggableKt$onDragOrUp$1
            r1.<init>(r0)
        L_0x001b:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r5 = 1
            r6 = 0
            if (r3 == 0) goto L_0x0050
            if (r3 != r5) goto L_0x0048
            java.lang.Object r3 = r1.L$4
            kotlin.jvm.internal.Ref$LongRef r3 = (kotlin.jvm.internal.Ref.LongRef) r3
            java.lang.Object r7 = r1.L$3
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            java.lang.Object r8 = r1.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            java.lang.Object r9 = r1.L$1
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            java.lang.Object r10 = r1.L$0
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            kotlin.ResultKt.throwOnFailure(r0)
            r16 = r9
            r9 = r1
            r1 = r10
            r10 = r3
            r3 = r16
            goto L_0x008b
        L_0x0048:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0050:
            kotlin.ResultKt.throwOnFailure(r0)
            androidx.compose.ui.input.pointer.PointerEvent r0 = r17.getCurrentEvent()
            r7 = r19
            boolean r0 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m375isPointerUpDmW0f2w(r0, r7)
            if (r0 == 0) goto L_0x0064
            r3 = r21
            r14 = r6
            goto L_0x010a
        L_0x0064:
            r0 = r17
            r3 = r21
            r9 = r1
            r1 = r18
        L_0x006b:
            kotlin.jvm.internal.Ref$LongRef r10 = new kotlin.jvm.internal.Ref$LongRef
            r10.<init>()
            r10.element = r7
            r7 = r0
        L_0x0073:
            r9.L$0 = r1
            r9.L$1 = r3
            r9.L$2 = r0
            r9.L$3 = r7
            r9.L$4 = r10
            r9.label = r5
            java.lang.Object r8 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r7, r6, r9, r5, r6)
            if (r8 != r2) goto L_0x0086
            return r2
        L_0x0086:
            r16 = r8
            r8 = r0
            r0 = r16
        L_0x008b:
            androidx.compose.ui.input.pointer.PointerEvent r0 = (androidx.compose.ui.input.pointer.PointerEvent) r0
            java.util.List r11 = r0.getChanges()
            int r12 = r11.size()
            r13 = 0
        L_0x0096:
            if (r13 >= r12) goto L_0x00b5
            java.lang.Object r14 = r11.get(r13)
            r15 = r14
            androidx.compose.ui.input.pointer.PointerInputChange r15 = (androidx.compose.ui.input.pointer.PointerInputChange) r15
            long r4 = r15.m5111getIdJ3iCeTQ()
            r17 = r7
            long r6 = r10.element
            boolean r4 = androidx.compose.ui.input.pointer.PointerId.m5095equalsimpl0(r4, r6)
            if (r4 == 0) goto L_0x00ae
            goto L_0x00b8
        L_0x00ae:
            int r13 = r13 + 1
            r7 = r17
            r5 = 1
            r6 = 0
            goto L_0x0096
        L_0x00b5:
            r17 = r7
            r14 = 0
        L_0x00b8:
            androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.ui.input.pointer.PointerInputChange) r14
            if (r14 != 0) goto L_0x00be
            r14 = 0
            goto L_0x00f9
        L_0x00be:
            boolean r4 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r14)
            if (r4 == 0) goto L_0x00ed
            java.util.List r0 = r0.getChanges()
            int r4 = r0.size()
            r5 = 0
        L_0x00cd:
            if (r5 >= r4) goto L_0x00e0
            java.lang.Object r6 = r0.get(r5)
            r7 = r6
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            boolean r7 = r7.getPressed()
            if (r7 == 0) goto L_0x00dd
            goto L_0x00e1
        L_0x00dd:
            int r5 = r5 + 1
            goto L_0x00cd
        L_0x00e0:
            r6 = 0
        L_0x00e1:
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            if (r6 != 0) goto L_0x00e6
            goto L_0x00f9
        L_0x00e6:
            long r4 = r6.m5111getIdJ3iCeTQ()
            r10.element = r4
            goto L_0x012a
        L_0x00ed:
            java.lang.Object r0 = r1.invoke(r14)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x012a
        L_0x00f9:
            if (r14 != 0) goto L_0x00fd
        L_0x00fb:
            r14 = 0
            goto L_0x010a
        L_0x00fd:
            boolean r0 = r14.isConsumed()
            if (r0 == 0) goto L_0x0104
            goto L_0x00fb
        L_0x0104:
            boolean r0 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r14)
            if (r0 == 0) goto L_0x011d
        L_0x010a:
            if (r14 == 0) goto L_0x0112
            r3.invoke(r14)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            goto L_0x0113
        L_0x0112:
            r6 = 0
        L_0x0113:
            if (r6 == 0) goto L_0x0117
            r4 = 1
            goto L_0x0118
        L_0x0117:
            r4 = 0
        L_0x0118:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r0
        L_0x011d:
            r3.invoke(r14)
            long r4 = r14.m5111getIdJ3iCeTQ()
            r0 = r8
            r6 = 0
            r7 = r4
            r5 = 1
            goto L_0x006b
        L_0x012a:
            r7 = r17
            r0 = r8
            r5 = 1
            r6 = 0
            goto L_0x0073
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableKt.m399onDragOrUpAxegvzg(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.jvm.functions.Function1, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* renamed from: toFloat-3MmeM6k  reason: not valid java name */
    public static final float m400toFloat3MmeM6k(long j, Orientation orientation) {
        return orientation == Orientation.Vertical ? Offset.m3563getYimpl(j) : Offset.m3562getXimpl(j);
    }

    /* access modifiers changed from: private */
    /* renamed from: toFloat-sF-c-tU  reason: not valid java name */
    public static final float m401toFloatsFctU(long j, Orientation orientation) {
        return orientation == Orientation.Vertical ? Velocity.m6856getYimpl(j) : Velocity.m6855getXimpl(j);
    }
}
