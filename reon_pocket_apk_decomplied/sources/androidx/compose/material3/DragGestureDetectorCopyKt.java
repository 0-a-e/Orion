package androidx.compose.material3;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aa\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f26\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\u000eH@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001aW\u0010\u0016\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u000e2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00050\u0018HHø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001e\u0010\u001c\u001a\u00020\u001d*\u00020\u001e2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u001e\u0010!\u001a\u00020\u0005*\u00020\"2\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b#\u0010$\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006%"}, d2 = {"defaultTouchSlop", "Landroidx/compose/ui/unit/Dp;", "F", "mouseSlop", "mouseToTouchSlopRatio", "", "awaitHorizontalPointerSlopOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "change", "overSlop", "", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitPointerSlopOrCancellation", "getDragDirectionValue", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "awaitPointerSlopOrCancellation-pn7EDYM", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isPointerUp", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DragGestureDetectorCopy.kt */
public final class DragGestureDetectorCopyKt {
    private static final float defaultTouchSlop;
    private static final float mouseSlop;
    private static final float mouseToTouchSlopRatio;

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e3 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m1819awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope r20, long r21, int r23, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r24, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r25) {
        /*
            r0 = r21
            r2 = r25
            boolean r3 = r2 instanceof androidx.compose.material3.DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.material3.DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1 r3 = (androidx.compose.material3.DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.material3.DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1 r3 = new androidx.compose.material3.DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r7 = 2
            r8 = 1
            r9 = 0
            if (r5 == 0) goto L_0x0075
            if (r5 == r8) goto L_0x0055
            if (r5 != r7) goto L_0x004d
            float r0 = r3.F$1
            float r1 = r3.F$0
            java.lang.Object r5 = r3.L$3
            androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
            java.lang.Object r10 = r3.L$2
            kotlin.jvm.internal.Ref$LongRef r10 = (kotlin.jvm.internal.Ref.LongRef) r10
            java.lang.Object r11 = r3.L$1
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
            java.lang.Object r12 = r3.L$0
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r0
            r0 = r11
            r11 = r10
            r10 = r3
            r3 = r1
            r1 = r12
            goto L_0x015b
        L_0x004d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0055:
            float r0 = r3.F$1
            float r1 = r3.F$0
            java.lang.Object r5 = r3.L$2
            kotlin.jvm.internal.Ref$LongRef r5 = (kotlin.jvm.internal.Ref.LongRef) r5
            java.lang.Object r10 = r3.L$1
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            java.lang.Object r11 = r3.L$0
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            kotlin.ResultKt.throwOnFailure(r2)
            r18 = r3
            r3 = r0
            r0 = r10
            r10 = r18
            r19 = r5
            r5 = r1
            r1 = r11
            r11 = r19
            goto L_0x00ba
        L_0x0075:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.ui.input.pointer.PointerEvent r2 = r20.getCurrentEvent()
            boolean r2 = m1821isPointerUpDmW0f2w(r2, r0)
            if (r2 == 0) goto L_0x0084
            goto L_0x017e
        L_0x0084:
            androidx.compose.ui.platform.ViewConfiguration r2 = r20.getViewConfiguration()
            r5 = r23
            float r2 = m1822pointerSlopE8SPZFQ(r2, r5)
            kotlin.jvm.internal.Ref$LongRef r5 = new kotlin.jvm.internal.Ref$LongRef
            r5.<init>()
            r5.element = r0
            r0 = r20
            r1 = r24
            r10 = r5
            r5 = r3
            r3 = r2
            r2 = 0
        L_0x009d:
            r5.L$0 = r1
            r5.L$1 = r0
            r5.L$2 = r10
            r5.L$3 = r9
            r5.F$0 = r3
            r5.F$1 = r2
            r5.label = r8
            java.lang.Object r11 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r0, r9, r5, r8, r9)
            if (r11 != r4) goto L_0x00b2
            return r4
        L_0x00b2:
            r18 = r3
            r3 = r2
            r2 = r11
            r11 = r10
            r10 = r5
            r5 = r18
        L_0x00ba:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r12 = r2.getChanges()
            int r13 = r12.size()
            r14 = 0
            r15 = r14
        L_0x00c6:
            if (r15 >= r13) goto L_0x00e3
            java.lang.Object r16 = r12.get(r15)
            r17 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r17 = (androidx.compose.ui.input.pointer.PointerInputChange) r17
            long r8 = r17.m5111getIdJ3iCeTQ()
            long r6 = r11.element
            boolean r6 = androidx.compose.ui.input.pointer.PointerId.m5095equalsimpl0(r8, r6)
            if (r6 == 0) goto L_0x00dd
            goto L_0x00e5
        L_0x00dd:
            int r15 = r15 + 1
            r7 = 2
            r8 = 1
            r9 = 0
            goto L_0x00c6
        L_0x00e3:
            r16 = 0
        L_0x00e5:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r16)
            r6 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            boolean r7 = r6.isConsumed()
            if (r7 == 0) goto L_0x00f4
            goto L_0x0161
        L_0x00f4:
            boolean r7 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r6)
            if (r7 == 0) goto L_0x0127
            java.util.List r2 = r2.getChanges()
            int r6 = r2.size()
        L_0x0102:
            if (r14 >= r6) goto L_0x0115
            java.lang.Object r7 = r2.get(r14)
            r8 = r7
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            boolean r8 = r8.getPressed()
            if (r8 == 0) goto L_0x0112
            goto L_0x0116
        L_0x0112:
            int r14 = r14 + 1
            goto L_0x0102
        L_0x0115:
            r7 = 0
        L_0x0116:
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            if (r7 != 0) goto L_0x011b
            goto L_0x0161
        L_0x011b:
            long r6 = r7.m5111getIdJ3iCeTQ()
            r11.element = r6
            r2 = r3
            r3 = r5
            r5 = r10
            r10 = r11
            r7 = 2
            goto L_0x0165
        L_0x0127:
            long r7 = r6.m5113getPositionF1C5BW0()
            long r12 = r6.m5114getPreviousPositionF1C5BW0()
            float r2 = androidx.compose.ui.geometry.Offset.m3562getXimpl(r7)
            float r7 = androidx.compose.ui.geometry.Offset.m3562getXimpl(r12)
            float r2 = r2 - r7
            float r2 = r2 + r3
            float r3 = java.lang.Math.abs(r2)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x0169
            androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r10.L$0 = r1
            r10.L$1 = r0
            r10.L$2 = r11
            r10.L$3 = r6
            r10.F$0 = r5
            r10.F$1 = r2
            r7 = 2
            r10.label = r7
            java.lang.Object r3 = r0.awaitPointerEvent(r3, r10)
            if (r3 != r4) goto L_0x0159
            return r4
        L_0x0159:
            r3 = r5
            r5 = r6
        L_0x015b:
            boolean r5 = r5.isConsumed()
            if (r5 == 0) goto L_0x0163
        L_0x0161:
            r9 = 0
            goto L_0x017e
        L_0x0163:
            r5 = r10
            r10 = r11
        L_0x0165:
            r8 = 1
            r9 = 0
            goto L_0x009d
        L_0x0169:
            r7 = 2
            float r3 = java.lang.Math.signum(r2)
            float r3 = r3 * r5
            float r2 = r2 - r3
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2)
            r1.invoke(r6, r2)
            boolean r2 = r6.isConsumed()
            if (r2 == 0) goto L_0x017f
            r9 = r6
        L_0x017e:
            return r9
        L_0x017f:
            r3 = r5
            r5 = r10
            r10 = r11
            r2 = 0
            goto L_0x0165
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DragGestureDetectorCopyKt.m1819awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: awaitPointerSlopOrCancellation-pn7EDYM  reason: not valid java name */
    private static final Object m1820awaitPointerSlopOrCancellationpn7EDYM(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Function2<? super PointerInputChange, ? super Float, Unit> function2, Function1<? super Offset, Float> function1, Continuation<? super PointerInputChange> continuation) {
        float f;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        AwaitPointerEventScope awaitPointerEventScope2 = awaitPointerEventScope;
        long j2 = j;
        Function1<? super Offset, Float> function12 = function1;
        Continuation<? super PointerInputChange> continuation2 = continuation;
        if (m1821isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j2)) {
            return null;
        }
        float r5 = m1822pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = j2;
        float f2 = 0.0f;
        while (true) {
            InlineMarker.mark(0);
            Object awaitPointerEvent$default = AwaitPointerEventScope.CC.awaitPointerEvent$default(awaitPointerEventScope2, (PointerEventPass) null, continuation2, 1, (Object) null);
            InlineMarker.mark(1);
            PointerEvent pointerEvent = (PointerEvent) awaitPointerEvent$default;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    f = f2;
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i2);
                f = f2;
                Boolean valueOf = Boolean.valueOf(PointerId.m5095equalsimpl0(pointerInputChange.m5111getIdJ3iCeTQ(), longRef.element));
                Boolean bool = valueOf;
                if (valueOf.booleanValue()) {
                    break;
                }
                i2++;
                f2 = f;
            }
            Intrinsics.checkNotNull(pointerInputChange);
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size2) {
                        pointerInputChange2 = null;
                        break;
                    }
                    pointerInputChange2 = changes2.get(i3);
                    Boolean valueOf2 = Boolean.valueOf(pointerInputChange2.getPressed());
                    Boolean bool2 = valueOf2;
                    if (valueOf2.booleanValue()) {
                        break;
                    }
                    i3++;
                }
                PointerInputChange pointerInputChange4 = pointerInputChange2;
                if (pointerInputChange4 == null) {
                    return null;
                }
                longRef.element = pointerInputChange4.m5111getIdJ3iCeTQ();
            } else {
                float floatValue = f + (function12.invoke(Offset.m3551boximpl(pointerInputChange3.m5113getPositionF1C5BW0())).floatValue() - function12.invoke(Offset.m3551boximpl(pointerInputChange3.m5114getPreviousPositionF1C5BW0())).floatValue());
                if (Math.abs(floatValue) < r5) {
                    PointerEventPass pointerEventPass = PointerEventPass.Final;
                    InlineMarker.mark(0);
                    awaitPointerEventScope2.awaitPointerEvent(pointerEventPass, continuation2);
                    InlineMarker.mark(1);
                    if (pointerInputChange3.isConsumed()) {
                        return null;
                    }
                    f = floatValue;
                } else {
                    function2.invoke(pointerInputChange3, Float.valueOf(floatValue - (Math.signum(floatValue) * r5)));
                    if (pointerInputChange3.isConsumed()) {
                        return pointerInputChange3;
                    }
                    f = 0.0f;
                    f2 = f;
                }
            }
            Function2<? super PointerInputChange, ? super Float, Unit> function22 = function2;
            f2 = f;
        }
    }

    /* renamed from: isPointerUp-DmW0f2w  reason: not valid java name */
    private static final boolean m1821isPointerUpDmW0f2w(PointerEvent pointerEvent, long j) {
        PointerInputChange pointerInputChange;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                pointerInputChange = null;
                break;
            }
            pointerInputChange = changes.get(i);
            if (PointerId.m5095equalsimpl0(pointerInputChange.m5111getIdJ3iCeTQ(), j)) {
                break;
            }
            i++;
        }
        PointerInputChange pointerInputChange2 = pointerInputChange;
        if (pointerInputChange2 != null && pointerInputChange2.getPressed()) {
            z = true;
        }
        return true ^ z;
    }

    /* renamed from: pointerSlop-E8SPZFQ  reason: not valid java name */
    public static final float m1822pointerSlopE8SPZFQ(ViewConfiguration viewConfiguration, int i) {
        if (PointerType.m5189equalsimpl0(i, PointerType.Companion.m5194getMouseT8wyACA())) {
            return viewConfiguration.getTouchSlop() * mouseToTouchSlopRatio;
        }
        return viewConfiguration.getTouchSlop();
    }

    static {
        float r0 = Dp.m6614constructorimpl((float) 0.125d);
        mouseSlop = r0;
        float r1 = Dp.m6614constructorimpl((float) 18);
        defaultTouchSlop = r1;
        mouseToTouchSlopRatio = r0 / r1;
    }
}
