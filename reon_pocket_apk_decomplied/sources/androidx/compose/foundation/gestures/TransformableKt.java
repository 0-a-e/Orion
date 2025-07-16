package androidx.compose.foundation.gestures;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a<\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\tH@¢\u0006\u0002\u0010\u000b\u001a<\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0004H\u0007\u001a&\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0004¨\u0006\u0012"}, d2 = {"detectZoom", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "panZoomLock", "", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/TransformEvent;", "canPan", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transformable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/TransformableState;", "lockRotationOnZoomPan", "enabled", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Transformable.kt */
public final class TransformableKt {
    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, z, z2);
    }

    public static final Modifier transformable(Modifier modifier, TransformableState transformableState, boolean z, boolean z2) {
        return transformable(modifier, transformableState, TransformableKt$transformable$1.INSTANCE, z, z2);
    }

    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, Function1 function1, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, function1, z, z2);
    }

    public static final Modifier transformable(Modifier modifier, TransformableState transformableState, Function1<? super Offset, Boolean> function1, boolean z, boolean z2) {
        return modifier.then(new TransformableElement(transformableState, function1, z, z2));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01f1, code lost:
        if (r13.invoke(androidx.compose.ui.geometry.Offset.m3551boximpl(r1)).booleanValue() != false) goto L_0x01ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x029c, code lost:
        if (r5 != 0) goto L_0x02a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x029e, code lost:
        r2 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x02a3 A[EDGE_INSN: B:102:0x02a3->B:85:0x02a3 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x02d0 A[EDGE_INSN: B:103:0x02d0->B:94:0x02d0 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0290  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x02b3  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0144 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object detectZoom(androidx.compose.ui.input.pointer.AwaitPointerEventScope r29, boolean r30, kotlinx.coroutines.channels.Channel<androidx.compose.foundation.gestures.TransformEvent> r31, kotlin.jvm.functions.Function1<? super androidx.compose.ui.geometry.Offset, java.lang.Boolean> r32, kotlin.coroutines.Continuation<? super kotlin.Unit> r33) {
        /*
            r0 = r33
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.TransformableKt$detectZoom$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.TransformableKt$detectZoom$1 r1 = (androidx.compose.foundation.gestures.TransformableKt$detectZoom$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.TransformableKt$detectZoom$1 r1 = new androidx.compose.foundation.gestures.TransformableKt$detectZoom$1
            r1.<init>(r0)
        L_0x001b:
            java.lang.Object r0 = r1.result
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r10 = 3
            r11 = 2
            r14 = 1
            if (r2 == 0) goto L_0x00b3
            if (r2 == r14) goto L_0x008f
            if (r2 == r11) goto L_0x0067
            if (r2 != r10) goto L_0x005f
            int r2 = r1.I$2
            int r3 = r1.I$1
            float r4 = r1.F$2
            int r5 = r1.I$0
            long r6 = r1.J$0
            float r15 = r1.F$1
            float r10 = r1.F$0
            boolean r11 = r1.Z$0
            java.lang.Object r14 = r1.L$3
            androidx.compose.ui.input.pointer.PointerEvent r14 = (androidx.compose.ui.input.pointer.PointerEvent) r14
            java.lang.Object r13 = r1.L$2
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            java.lang.Object r9 = r1.L$1
            kotlinx.coroutines.channels.Channel r9 = (kotlinx.coroutines.channels.Channel) r9
            java.lang.Object r12 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r12 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r12
            kotlin.ResultKt.throwOnFailure(r0)
            r19 = r11
            r16 = 0
            r18 = 1065353216(0x3f800000, float:1.0)
            r11 = r10
            r10 = r9
            r9 = r15
            r15 = r2
            r2 = r0
            r0 = 3
            goto L_0x0281
        L_0x005f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0067:
            int r2 = r1.I$1
            float r3 = r1.F$2
            int r4 = r1.I$0
            long r5 = r1.J$0
            float r7 = r1.F$1
            float r9 = r1.F$0
            boolean r10 = r1.Z$0
            java.lang.Object r11 = r1.L$2
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            java.lang.Object r12 = r1.L$1
            kotlinx.coroutines.channels.Channel r12 = (kotlinx.coroutines.channels.Channel) r12
            java.lang.Object r13 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
            kotlin.ResultKt.throwOnFailure(r0)
            r14 = r10
            r10 = 2
            r28 = r11
            r11 = r9
            r9 = r12
            r12 = r13
            r13 = r28
            goto L_0x0124
        L_0x008f:
            int r2 = r1.I$1
            float r3 = r1.F$2
            int r4 = r1.I$0
            long r5 = r1.J$0
            float r7 = r1.F$1
            float r9 = r1.F$0
            boolean r10 = r1.Z$0
            java.lang.Object r11 = r1.L$2
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            java.lang.Object r12 = r1.L$1
            kotlinx.coroutines.channels.Channel r12 = (kotlinx.coroutines.channels.Channel) r12
            java.lang.Object r13 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
            kotlin.ResultKt.throwOnFailure(r0)
            r14 = r10
            r28 = r13
            r13 = r11
            r11 = r28
            goto L_0x00fc
        L_0x00b3:
            kotlin.ResultKt.throwOnFailure(r0)
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r9 = r0.m3578getZeroF1C5BW0()
            androidx.compose.ui.platform.ViewConfiguration r0 = r29.getViewConfiguration()
            float r0 = r0.getTouchSlop()
            r11 = r29
            r1.L$0 = r11
            r12 = r31
            r1.L$1 = r12
            r13 = r32
            r1.L$2 = r13
            r14 = r30
            r1.Z$0 = r14
            r2 = 0
            r1.F$0 = r2
            r2 = 1065353216(0x3f800000, float:1.0)
            r1.F$1 = r2
            r1.J$0 = r9
            r2 = 0
            r1.I$0 = r2
            r1.F$2 = r0
            r1.I$1 = r2
            r2 = 1
            r1.label = r2
            r3 = 0
            r4 = 0
            r6 = 2
            r7 = 0
            r2 = r29
            r5 = r1
            java.lang.Object r2 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r2, r3, r4, r5, r6, r7)
            if (r2 != r8) goto L_0x00f5
            return r8
        L_0x00f5:
            r3 = r0
            r5 = r9
            r2 = 0
            r4 = 0
            r7 = 1065353216(0x3f800000, float:1.0)
            r9 = 0
        L_0x00fc:
            r1.L$0 = r11
            r1.L$1 = r12
            r1.L$2 = r13
            r0 = 0
            r1.L$3 = r0
            r1.Z$0 = r14
            r1.F$0 = r9
            r1.F$1 = r7
            r1.J$0 = r5
            r1.I$0 = r4
            r1.F$2 = r3
            r1.I$1 = r2
            r10 = 2
            r1.label = r10
            r15 = 1
            java.lang.Object r0 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r11, r0, r1, r15, r0)
            if (r0 != r8) goto L_0x011e
            return r8
        L_0x011e:
            r28 = r11
            r11 = r9
            r9 = r12
            r12 = r28
        L_0x0124:
            androidx.compose.ui.input.pointer.PointerEvent r0 = (androidx.compose.ui.input.pointer.PointerEvent) r0
            java.util.List r15 = r0.getChanges()
            int r10 = r15.size()
            r29 = r2
            r2 = 0
        L_0x0131:
            if (r2 >= r10) goto L_0x0144
            java.lang.Object r20 = r15.get(r2)
            androidx.compose.ui.input.pointer.PointerInputChange r20 = (androidx.compose.ui.input.pointer.PointerInputChange) r20
            boolean r20 = r20.isConsumed()
            if (r20 == 0) goto L_0x0141
            r2 = 1
            goto L_0x0145
        L_0x0141:
            int r2 = r2 + 1
            goto L_0x0131
        L_0x0144:
            r2 = 0
        L_0x0145:
            if (r2 != 0) goto L_0x0238
            float r21 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateZoom(r0)
            float r10 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateRotation(r0)
            r15 = r1
            r30 = r2
            long r1 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculatePan(r0)
            if (r4 != 0) goto L_0x01b6
            float r7 = r7 * r21
            float r11 = r11 + r10
            long r5 = androidx.compose.ui.geometry.Offset.m3567plusMKHz9U(r5, r1)
            r31 = r4
            r4 = 0
            float r17 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateCentroidSize(r0, r4)
            r16 = r10
            r4 = 1
            float r10 = (float) r4
            float r10 = r10 - r7
            float r10 = java.lang.Math.abs(r10)
            float r10 = r10 * r17
            r20 = 1078530011(0x40490fdb, float:3.1415927)
            float r20 = r20 * r11
            float r20 = r20 * r17
            r17 = 1127481344(0x43340000, float:180.0)
            float r20 = r20 / r17
            float r17 = java.lang.Math.abs(r20)
            float r20 = androidx.compose.ui.geometry.Offset.m3560getDistanceimpl(r5)
            int r10 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r10 > 0) goto L_0x01a6
            int r10 = (r17 > r3 ? 1 : (r17 == r3 ? 0 : -1))
            if (r10 > 0) goto L_0x01a6
            int r10 = (r20 > r3 ? 1 : (r20 == r3 ? 0 : -1))
            if (r10 <= 0) goto L_0x01a1
            androidx.compose.ui.geometry.Offset r10 = androidx.compose.ui.geometry.Offset.m3551boximpl(r1)
            java.lang.Object r10 = r13.invoke(r10)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x01a1
            goto L_0x01a6
        L_0x01a1:
            r10 = r29
            r4 = r31
            goto L_0x01bc
        L_0x01a6:
            if (r14 == 0) goto L_0x01ae
            int r10 = (r17 > r3 ? 1 : (r17 == r3 ? 0 : -1))
            if (r10 >= 0) goto L_0x01ae
            r10 = r4
            goto L_0x01af
        L_0x01ae:
            r10 = 0
        L_0x01af:
            androidx.compose.foundation.gestures.TransformEvent$TransformStarted r4 = androidx.compose.foundation.gestures.TransformEvent.TransformStarted.INSTANCE
            r9.m8593trySendJP2dKIU(r4)
            r4 = 1
            goto L_0x01bc
        L_0x01b6:
            r31 = r4
            r16 = r10
            r10 = r29
        L_0x01bc:
            if (r4 == 0) goto L_0x022a
            if (r10 == 0) goto L_0x01c5
            r16 = 0
            r24 = 0
            goto L_0x01c9
        L_0x01c5:
            r24 = r16
            r16 = 0
        L_0x01c9:
            int r19 = (r24 > r16 ? 1 : (r24 == r16 ? 0 : -1))
            if (r19 != 0) goto L_0x01f9
            r18 = 1065353216(0x3f800000, float:1.0)
            int r19 = (r21 > r18 ? 1 : (r21 == r18 ? 0 : -1))
            if (r19 != 0) goto L_0x01f4
            androidx.compose.ui.geometry.Offset$Companion r19 = androidx.compose.ui.geometry.Offset.Companion
            r29 = r4
            r26 = r5
            long r4 = r19.m3578getZeroF1C5BW0()
            boolean r4 = androidx.compose.ui.geometry.Offset.m3559equalsimpl0(r1, r4)
            if (r4 != 0) goto L_0x020d
            androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.m3551boximpl(r1)
            java.lang.Object r4 = r13.invoke(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x020d
            goto L_0x01ff
        L_0x01f4:
            r29 = r4
            r26 = r5
            goto L_0x01ff
        L_0x01f9:
            r29 = r4
            r26 = r5
            r18 = 1065353216(0x3f800000, float:1.0)
        L_0x01ff:
            androidx.compose.foundation.gestures.TransformEvent$TransformDelta r4 = new androidx.compose.foundation.gestures.TransformEvent$TransformDelta
            r25 = 0
            r20 = r4
            r22 = r1
            r20.<init>(r21, r22, r24, r25)
            r9.m8593trySendJP2dKIU(r4)
        L_0x020d:
            java.util.List r1 = r0.getChanges()
            int r2 = r1.size()
            r4 = 0
        L_0x0216:
            if (r4 >= r2) goto L_0x0232
            java.lang.Object r5 = r1.get(r4)
            androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
            boolean r6 = androidx.compose.ui.input.pointer.PointerEventKt.positionChanged(r5)
            if (r6 == 0) goto L_0x0227
            r5.consume()
        L_0x0227:
            int r4 = r4 + 1
            goto L_0x0216
        L_0x022a:
            r29 = r4
            r26 = r5
            r16 = 0
            r18 = 1065353216(0x3f800000, float:1.0)
        L_0x0232:
            r5 = r29
            r1 = r7
            r6 = r26
            goto L_0x024c
        L_0x0238:
            r15 = r1
            r30 = r2
            r31 = r4
            r16 = 0
            r18 = 1065353216(0x3f800000, float:1.0)
            androidx.compose.foundation.gestures.TransformEvent$TransformStopped r1 = androidx.compose.foundation.gestures.TransformEvent.TransformStopped.INSTANCE
            r9.m8593trySendJP2dKIU(r1)
            r10 = r29
            r1 = r7
            r6 = r5
            r5 = r31
        L_0x024c:
            androidx.compose.ui.input.pointer.PointerEventPass r2 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r4 = r15
            r4.L$0 = r12
            r4.L$1 = r9
            r4.L$2 = r13
            r4.L$3 = r0
            r4.Z$0 = r14
            r4.F$0 = r11
            r4.F$1 = r1
            r4.J$0 = r6
            r4.I$0 = r5
            r4.F$2 = r3
            r4.I$1 = r10
            r15 = r30
            r4.I$2 = r15
            r29 = r0
            r0 = 3
            r4.label = r0
            java.lang.Object r2 = r12.awaitPointerEvent(r2, r4)
            if (r2 != r8) goto L_0x0275
            return r8
        L_0x0275:
            r19 = r14
            r14 = r29
            r28 = r9
            r9 = r1
            r1 = r4
            r4 = r3
            r3 = r10
            r10 = r28
        L_0x0281:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r2 = r2.getChanges()
            int r0 = r2.size()
            r29 = r1
            r1 = 0
        L_0x028e:
            if (r1 >= r0) goto L_0x02a3
            java.lang.Object r20 = r2.get(r1)
            androidx.compose.ui.input.pointer.PointerInputChange r20 = (androidx.compose.ui.input.pointer.PointerInputChange) r20
            boolean r20 = r20.isConsumed()
            if (r20 == 0) goto L_0x02a0
            if (r5 != 0) goto L_0x02a3
            r2 = 1
            goto L_0x02a4
        L_0x02a0:
            int r1 = r1 + 1
            goto L_0x028e
        L_0x02a3:
            r2 = 0
        L_0x02a4:
            if (r15 != 0) goto L_0x02d0
            if (r2 != 0) goto L_0x02d0
            java.util.List r0 = r14.getChanges()
            int r1 = r0.size()
            r2 = 0
        L_0x02b1:
            if (r2 >= r1) goto L_0x02d0
            java.lang.Object r14 = r0.get(r2)
            androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.ui.input.pointer.PointerInputChange) r14
            boolean r14 = r14.getPressed()
            if (r14 == 0) goto L_0x02cd
            r1 = r29
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r7 = r9
            r9 = r11
            r11 = r12
            r14 = r19
            r12 = r10
            goto L_0x00fc
        L_0x02cd:
            int r2 = r2 + 1
            goto L_0x02b1
        L_0x02d0:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt.detectZoom(androidx.compose.ui.input.pointer.AwaitPointerEventScope, boolean, kotlinx.coroutines.channels.Channel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
