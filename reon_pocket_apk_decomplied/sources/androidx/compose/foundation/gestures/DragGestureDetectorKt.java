package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a5\u0010\u0015\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00180\u0017HHø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a!\u0010\u001b\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0014\u001aa\u0010\u001d\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f26\u0010 \u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\r¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&0!H@ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001aY\u0010)\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u001226\u0010*\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\r¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&0!H@ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a!\u0010-\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0004\b.\u0010\u0014\u001aK\u0010/\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u00012\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020&0!HHø\u0001\u0000¢\u0006\u0004\b2\u00103\u001aY\u00104\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u001226\u0010*\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&0!H@ø\u0001\u0000¢\u0006\u0004\b5\u0010,\u001a!\u00106\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0004\b7\u0010\u0014\u001aa\u00108\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f26\u0010*\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\r¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&0!H@ø\u0001\u0000¢\u0006\u0004\b9\u0010(\u001aY\u0010:\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u001226\u0010*\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\r¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&0!H@ø\u0001\u0000¢\u0006\u0004\b;\u0010,\u001a\u0001\u0010<\u001a\u00020&*\u00020=2\u0014\b\u0002\u0010>\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020&0\u00172\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020&0@2\u000e\b\u0002\u0010A\u001a\b\u0012\u0004\u0012\u00020&0@26\u0010B\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020&0!H@¢\u0006\u0002\u0010D\u001a\u0001\u0010E\u001a\u00020&*\u00020=2\u0014\b\u0002\u0010>\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020&0\u00172\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020&0@2\u000e\b\u0002\u0010A\u001a\b\u0012\u0004\u0012\u00020&0@26\u0010B\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020&0!H@¢\u0006\u0002\u0010D\u001a\u0001\u0010F\u001a\u00020&*\u00020=2\u0014\b\u0002\u0010>\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020&0\u00172\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020&0@2\u000e\b\u0002\u0010A\u001a\b\u0012\u0004\u0012\u00020&0@26\u0010G\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\r¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020&0!H@¢\u0006\u0002\u0010D\u001a\u0001\u0010H\u001a\u00020&*\u00020=2\u0014\b\u0002\u0010>\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020&0\u00172\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020&0@2\u000e\b\u0002\u0010A\u001a\b\u0012\u0004\u0012\u00020&0@26\u0010I\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\r¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020&0!H@¢\u0006\u0002\u0010D\u001a3\u0010J\u001a\u00020\u0018*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020&0\u0017H@ø\u0001\u0000¢\u0006\u0004\bK\u0010\u001a\u001a]\u0010J\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020&0\u00172\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00180\u00172\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00180\u0017HHø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001a3\u0010O\u001a\u00020\u0018*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020&0\u0017H@ø\u0001\u0000¢\u0006\u0004\bP\u0010\u001a\u001a\u001e\u0010Q\u001a\u00020\u0018*\u00020R2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a\u001e\u0010U\u001a\u00020\r*\u00020V2\u0006\u0010\u001e\u001a\u00020\u001fH\u0000ø\u0001\u0000¢\u0006\u0004\bW\u0010X\u001a\f\u0010Y\u001a\u00020\u0001*\u00020ZH\u0000\u001a3\u0010[\u001a\u00020\u0018*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020&0\u0017H@ø\u0001\u0000¢\u0006\u0004\b\\\u0010\u001a\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0014\u0010\u0006\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003\"\u0010\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0004\n\u0002\u0010\n\"\u0010\u0010\u000b\u001a\u00020\tX\u0004¢\u0006\u0004\n\u0002\u0010\n\"\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006]"}, d2 = {"BidirectionalPointerDirectionConfig", "Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "getBidirectionalPointerDirectionConfig", "()Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "HorizontalPointerDirectionConfig", "getHorizontalPointerDirectionConfig", "VerticalPointerDirectionConfig", "getVerticalPointerDirectionConfig", "defaultTouchSlop", "Landroidx/compose/ui/unit/Dp;", "F", "mouseSlop", "mouseToTouchSlopRatio", "", "awaitDragOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "awaitDragOrCancellation-rnUCldI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDragOrUp", "hasDragged", "Lkotlin/Function1;", "", "awaitDragOrUp-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitHorizontalDragOrCancellation", "awaitHorizontalDragOrCancellation-rnUCldI", "awaitHorizontalPointerSlopOrCancellation", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "change", "overSlop", "", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitHorizontalTouchSlopOrCancellation", "onTouchSlopReached", "awaitHorizontalTouchSlopOrCancellation-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitLongPressOrCancellation", "awaitLongPressOrCancellation-rnUCldI", "awaitPointerSlopOrCancellation", "pointerDirectionConfig", "Landroidx/compose/ui/geometry/Offset;", "awaitPointerSlopOrCancellation-pn7EDYM", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILandroidx/compose/foundation/gestures/PointerDirectionConfig;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitTouchSlopOrCancellation", "awaitTouchSlopOrCancellation-jO51t88", "awaitVerticalDragOrCancellation", "awaitVerticalDragOrCancellation-rnUCldI", "awaitVerticalPointerSlopOrCancellation", "awaitVerticalPointerSlopOrCancellation-gDDlDlE", "awaitVerticalTouchSlopOrCancellation", "awaitVerticalTouchSlopOrCancellation-jO51t88", "detectDragGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDragStart", "onDragEnd", "Lkotlin/Function0;", "onDragCancel", "onDrag", "dragAmount", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectDragGesturesAfterLongPress", "detectHorizontalDragGestures", "onHorizontalDrag", "detectVerticalDragGestures", "onVerticalDrag", "drag", "drag-jO51t88", "motionConsumed", "drag-VnAYq1g", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "horizontalDrag", "horizontalDrag-jO51t88", "isPointerUp", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "toPointerDirectionConfig", "Landroidx/compose/foundation/gestures/Orientation;", "verticalDrag", "verticalDrag-jO51t88", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DragGestureDetector.kt */
public final class DragGestureDetectorKt {
    private static final PointerDirectionConfig BidirectionalPointerDirectionConfig = new DragGestureDetectorKt$BidirectionalPointerDirectionConfig$1();
    private static final PointerDirectionConfig HorizontalPointerDirectionConfig = new DragGestureDetectorKt$HorizontalPointerDirectionConfig$1();
    private static final PointerDirectionConfig VerticalPointerDirectionConfig = new DragGestureDetectorKt$VerticalPointerDirectionConfig$1();
    private static final float defaultTouchSlop;
    private static final float mouseSlop;
    private static final float mouseToTouchSlopRatio;

    /* JADX WARNING: Removed duplicated region for block: B:14:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00fe A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0133 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* renamed from: awaitTouchSlopOrCancellation-jO51t88  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m367awaitTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r21, long r22, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit> r24, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r25) {
        /*
            r0 = r22
            r2 = r25
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitTouchSlopOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitTouchSlopOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitTouchSlopOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitTouchSlopOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitTouchSlopOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r7 = 1
            r8 = 0
            if (r5 == 0) goto L_0x007c
            if (r5 == r7) goto L_0x005a
            if (r5 != r6) goto L_0x0052
            long r0 = r3.J$0
            float r5 = r3.F$0
            java.lang.Object r9 = r3.L$4
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            java.lang.Object r10 = r3.L$3
            kotlin.jvm.internal.Ref$LongRef r10 = (kotlin.jvm.internal.Ref.LongRef) r10
            java.lang.Object r11 = r3.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
            java.lang.Object r12 = r3.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r12 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r12
            java.lang.Object r13 = r3.L$0
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            kotlin.ResultKt.throwOnFailure(r2)
            r8 = r6
            r6 = r3
            r2 = r0
            r0 = r11
            r1 = r13
            r11 = r10
            r10 = r12
            goto L_0x0184
        L_0x0052:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x005a:
            long r0 = r3.J$0
            float r5 = r3.F$0
            java.lang.Object r9 = r3.L$3
            kotlin.jvm.internal.Ref$LongRef r9 = (kotlin.jvm.internal.Ref.LongRef) r9
            java.lang.Object r10 = r3.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            java.lang.Object r11 = r3.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r11 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r11
            java.lang.Object r12 = r3.L$0
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            kotlin.ResultKt.throwOnFailure(r2)
            r18 = r12
            r12 = r9
            r19 = r0
            r0 = r10
            r9 = r19
            r1 = r18
            goto L_0x00d0
        L_0x007c:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.ui.input.pointer.PointerType$Companion r2 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r2 = r2.m5196getTouchT8wyACA()
            androidx.compose.foundation.gestures.PointerDirectionConfig r5 = BidirectionalPointerDirectionConfig
            androidx.compose.ui.input.pointer.PointerEvent r9 = r21.getCurrentEvent()
            boolean r9 = m375isPointerUpDmW0f2w(r9, r0)
            if (r9 == 0) goto L_0x0093
            goto L_0x01a5
        L_0x0093:
            androidx.compose.ui.platform.ViewConfiguration r9 = r21.getViewConfiguration()
            float r2 = m376pointerSlopE8SPZFQ(r9, r2)
            kotlin.jvm.internal.Ref$LongRef r9 = new kotlin.jvm.internal.Ref$LongRef
            r9.<init>()
            r9.element = r0
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r0.m3578getZeroF1C5BW0()
            r10 = r5
            r11 = r9
            r5 = r2
            r9 = r3
            r2 = r0
            r0 = r21
            r1 = r24
        L_0x00b1:
            r9.L$0 = r1
            r9.L$1 = r10
            r9.L$2 = r0
            r9.L$3 = r11
            r9.L$4 = r8
            r9.F$0 = r5
            r9.J$0 = r2
            r9.label = r7
            java.lang.Object r12 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r0, r8, r9, r7, r8)
            if (r12 != r4) goto L_0x00c8
            return r4
        L_0x00c8:
            r18 = r2
            r3 = r9
            r2 = r12
            r12 = r11
            r11 = r10
            r9 = r18
        L_0x00d0:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r13 = r2.getChanges()
            int r14 = r13.size()
            r15 = 0
            r7 = r15
        L_0x00dc:
            if (r7 >= r14) goto L_0x00fe
            java.lang.Object r16 = r13.get(r7)
            r17 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r17 = (androidx.compose.ui.input.pointer.PointerInputChange) r17
            r21 = r9
            long r8 = r17.m5111getIdJ3iCeTQ()
            r17 = r7
            long r6 = r12.element
            boolean r6 = androidx.compose.ui.input.pointer.PointerId.m5095equalsimpl0(r8, r6)
            if (r6 == 0) goto L_0x00f7
            goto L_0x0102
        L_0x00f7:
            int r7 = r17 + 1
            r9 = r21
            r6 = 2
            r8 = 0
            goto L_0x00dc
        L_0x00fe:
            r21 = r9
            r16 = 0
        L_0x0102:
            r9 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            if (r9 != 0) goto L_0x010a
            goto L_0x018a
        L_0x010a:
            boolean r6 = r9.isConsumed()
            if (r6 == 0) goto L_0x0112
            goto L_0x018a
        L_0x0112:
            boolean r6 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r9)
            if (r6 == 0) goto L_0x0149
            java.util.List r2 = r2.getChanges()
            int r6 = r2.size()
        L_0x0120:
            if (r15 >= r6) goto L_0x0133
            java.lang.Object r7 = r2.get(r15)
            r8 = r7
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            boolean r8 = r8.getPressed()
            if (r8 == 0) goto L_0x0130
            goto L_0x0134
        L_0x0130:
            int r15 = r15 + 1
            goto L_0x0120
        L_0x0133:
            r7 = 0
        L_0x0134:
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            if (r7 != 0) goto L_0x0139
            goto L_0x018a
        L_0x0139:
            long r6 = r7.m5111getIdJ3iCeTQ()
            r12.element = r6
            r9 = r3
            r10 = r11
            r11 = r12
            r6 = 2
            r7 = 1
            r8 = 0
            r2 = r21
            goto L_0x00b1
        L_0x0149:
            long r6 = r9.m5113getPositionF1C5BW0()
            long r13 = r9.m5114getPreviousPositionF1C5BW0()
            long r6 = androidx.compose.ui.geometry.Offset.m3566minusMKHz9U(r6, r13)
            r13 = r21
            long r6 = androidx.compose.ui.geometry.Offset.m3567plusMKHz9U(r13, r6)
            float r2 = r11.m406calculateDeltaChangek4lQ0M(r6)
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x0192
            androidx.compose.ui.input.pointer.PointerEventPass r2 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r3.L$0 = r1
            r3.L$1 = r11
            r3.L$2 = r0
            r3.L$3 = r12
            r3.L$4 = r9
            r3.F$0 = r5
            r3.J$0 = r6
            r8 = 2
            r3.label = r8
            java.lang.Object r2 = r0.awaitPointerEvent(r2, r3)
            if (r2 != r4) goto L_0x017d
            return r4
        L_0x017d:
            r10 = r11
            r11 = r12
            r18 = r6
            r6 = r3
            r2 = r18
        L_0x0184:
            boolean r7 = r9.isConsumed()
            if (r7 == 0) goto L_0x018c
        L_0x018a:
            r8 = 0
            goto L_0x01a5
        L_0x018c:
            r9 = r6
            r6 = r8
        L_0x018e:
            r7 = 1
            r8 = 0
            goto L_0x00b1
        L_0x0192:
            r8 = 2
            long r6 = r11.m407calculatePostSlopOffset8S9VItk(r6, r5)
            androidx.compose.ui.geometry.Offset r2 = androidx.compose.ui.geometry.Offset.m3551boximpl(r6)
            r1.invoke(r9, r2)
            boolean r2 = r9.isConsumed()
            if (r2 == 0) goto L_0x01a6
            r8 = r9
        L_0x01a5:
            return r8
        L_0x01a6:
            androidx.compose.ui.geometry.Offset$Companion r2 = androidx.compose.ui.geometry.Offset.Companion
            long r6 = r2.m3578getZeroF1C5BW0()
            r9 = r3
            r2 = r6
            r6 = r8
            r10 = r11
            r11 = r12
            goto L_0x018e
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m367awaitTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: drag-jO51t88  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m373dragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r4, long r5, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1 r0 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1 r0 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1
            r0.<init>(r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r4 = r0.L$1
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            java.lang.Object r5 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
            kotlin.ResultKt.throwOnFailure(r8)
            r7 = r4
            r4 = r5
            goto L_0x004c
        L_0x0034:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r8)
        L_0x003f:
            r0.L$0 = r4
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r8 = m359awaitDragOrCancellationrnUCldI(r4, r5, r0)
            if (r8 != r1) goto L_0x004c
            return r1
        L_0x004c:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 != 0) goto L_0x0056
            r4 = 0
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r4
        L_0x0056:
            boolean r5 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r8)
            if (r5 == 0) goto L_0x0061
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r4
        L_0x0061:
            r7.invoke(r8)
            long r5 = r8.m5111getIdJ3iCeTQ()
            goto L_0x003f
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m373dragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00cb, code lost:
        if (androidx.compose.ui.input.pointer.PointerEventKt.positionChangedIgnoreConsumed(r11) != false) goto L_0x00cd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0092 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* renamed from: awaitDragOrCancellation-rnUCldI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m359awaitDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r20) {
        /*
            r0 = r18
            r2 = r20
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitDragOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitDragOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitDragOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitDragOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitDragOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 1
            r7 = 0
            if (r5 == 0) goto L_0x0044
            if (r5 != r6) goto L_0x003c
            java.lang.Object r0 = r3.L$1
            kotlin.jvm.internal.Ref$LongRef r0 = (kotlin.jvm.internal.Ref.LongRef) r0
            java.lang.Object r1 = r3.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r2)
            r16 = r1
            r1 = r0
            r0 = r16
            goto L_0x006d
        L_0x003c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.ui.input.pointer.PointerEvent r2 = r17.getCurrentEvent()
            boolean r2 = m375isPointerUpDmW0f2w(r2, r0)
            if (r2 == 0) goto L_0x0052
            return r7
        L_0x0052:
            kotlin.jvm.internal.Ref$LongRef r2 = new kotlin.jvm.internal.Ref$LongRef
            r2.<init>()
            r2.element = r0
            r0 = r17
        L_0x005b:
            r3.L$0 = r0
            r3.L$1 = r2
            r3.label = r6
            java.lang.Object r1 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r0, r7, r3, r6, r7)
            if (r1 != r4) goto L_0x0068
            return r4
        L_0x0068:
            r16 = r2
            r2 = r1
            r1 = r16
        L_0x006d:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r5 = r2.getChanges()
            int r8 = r5.size()
            r9 = 0
            r10 = r9
        L_0x0079:
            if (r10 >= r8) goto L_0x0092
            java.lang.Object r11 = r5.get(r10)
            r12 = r11
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            long r12 = r12.m5111getIdJ3iCeTQ()
            long r14 = r1.element
            boolean r12 = androidx.compose.ui.input.pointer.PointerId.m5095equalsimpl0(r12, r14)
            if (r12 == 0) goto L_0x008f
            goto L_0x0093
        L_0x008f:
            int r10 = r10 + 1
            goto L_0x0079
        L_0x0092:
            r11 = r7
        L_0x0093:
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            if (r11 != 0) goto L_0x0099
            r11 = r7
            goto L_0x00cd
        L_0x0099:
            boolean r5 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r11)
            if (r5 == 0) goto L_0x00c7
            java.util.List r2 = r2.getChanges()
            int r5 = r2.size()
        L_0x00a7:
            if (r9 >= r5) goto L_0x00ba
            java.lang.Object r8 = r2.get(r9)
            r10 = r8
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            boolean r10 = r10.getPressed()
            if (r10 == 0) goto L_0x00b7
            goto L_0x00bb
        L_0x00b7:
            int r9 = r9 + 1
            goto L_0x00a7
        L_0x00ba:
            r8 = r7
        L_0x00bb:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 != 0) goto L_0x00c0
            goto L_0x00cd
        L_0x00c0:
            long r8 = r8.m5111getIdJ3iCeTQ()
            r1.element = r8
            goto L_0x00d7
        L_0x00c7:
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangedIgnoreConsumed(r11)
            if (r2 == 0) goto L_0x00d7
        L_0x00cd:
            if (r11 == 0) goto L_0x00d6
            boolean r0 = r11.isConsumed()
            if (r0 != 0) goto L_0x00d6
            r7 = r11
        L_0x00d6:
            return r7
        L_0x00d7:
            r2 = r1
            goto L_0x005b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m359awaitDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object detectDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = DragGestureDetectorKt$detectDragGestures$2.INSTANCE;
        }
        Function1 function12 = function1;
        if ((i & 2) != 0) {
            function0 = DragGestureDetectorKt$detectDragGestures$3.INSTANCE;
        }
        Function0 function03 = function0;
        if ((i & 4) != 0) {
            function02 = DragGestureDetectorKt$detectDragGestures$4.INSTANCE;
        }
        return detectDragGestures(pointerInputScope, function12, function03, function02, function2, continuation);
    }

    public static final Object detectDragGestures(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new DragGestureDetectorKt$detectDragGestures$5(function1, function2, function02, function0, (Continuation<? super DragGestureDetectorKt$detectDragGestures$5>) null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    public static /* synthetic */ Object detectDragGesturesAfterLongPress$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = DragGestureDetectorKt$detectDragGesturesAfterLongPress$2.INSTANCE;
        }
        Function1 function12 = function1;
        if ((i & 2) != 0) {
            function0 = DragGestureDetectorKt$detectDragGesturesAfterLongPress$3.INSTANCE;
        }
        Function0 function03 = function0;
        if ((i & 4) != 0) {
            function02 = DragGestureDetectorKt$detectDragGesturesAfterLongPress$4.INSTANCE;
        }
        return detectDragGesturesAfterLongPress(pointerInputScope, function12, function03, function02, function2, continuation);
    }

    public static final Object detectDragGesturesAfterLongPress(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(function1, function0, function02, function2, (Continuation<? super DragGestureDetectorKt$detectDragGesturesAfterLongPress$5>) null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00fe A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0133 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* renamed from: awaitVerticalTouchSlopOrCancellation-jO51t88  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m370awaitVerticalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r21, long r22, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r24, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r25) {
        /*
            r0 = r22
            r2 = r25
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r7 = 1
            r8 = 0
            if (r5 == 0) goto L_0x007c
            if (r5 == r7) goto L_0x005a
            if (r5 != r6) goto L_0x0052
            long r0 = r3.J$0
            float r5 = r3.F$0
            java.lang.Object r9 = r3.L$4
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            java.lang.Object r10 = r3.L$3
            kotlin.jvm.internal.Ref$LongRef r10 = (kotlin.jvm.internal.Ref.LongRef) r10
            java.lang.Object r11 = r3.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
            java.lang.Object r12 = r3.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r12 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r12
            java.lang.Object r13 = r3.L$0
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            kotlin.ResultKt.throwOnFailure(r2)
            r8 = r6
            r6 = r3
            r2 = r0
            r0 = r11
            r1 = r13
            r11 = r10
            r10 = r12
            goto L_0x0184
        L_0x0052:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x005a:
            long r0 = r3.J$0
            float r5 = r3.F$0
            java.lang.Object r9 = r3.L$3
            kotlin.jvm.internal.Ref$LongRef r9 = (kotlin.jvm.internal.Ref.LongRef) r9
            java.lang.Object r10 = r3.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            java.lang.Object r11 = r3.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r11 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r11
            java.lang.Object r12 = r3.L$0
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            kotlin.ResultKt.throwOnFailure(r2)
            r18 = r12
            r12 = r9
            r19 = r0
            r0 = r10
            r9 = r19
            r1 = r18
            goto L_0x00d0
        L_0x007c:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.ui.input.pointer.PointerType$Companion r2 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r2 = r2.m5196getTouchT8wyACA()
            androidx.compose.foundation.gestures.PointerDirectionConfig r5 = VerticalPointerDirectionConfig
            androidx.compose.ui.input.pointer.PointerEvent r9 = r21.getCurrentEvent()
            boolean r9 = m375isPointerUpDmW0f2w(r9, r0)
            if (r9 == 0) goto L_0x0093
            goto L_0x01a9
        L_0x0093:
            androidx.compose.ui.platform.ViewConfiguration r9 = r21.getViewConfiguration()
            float r2 = m376pointerSlopE8SPZFQ(r9, r2)
            kotlin.jvm.internal.Ref$LongRef r9 = new kotlin.jvm.internal.Ref$LongRef
            r9.<init>()
            r9.element = r0
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r0.m3578getZeroF1C5BW0()
            r10 = r5
            r11 = r9
            r5 = r2
            r9 = r3
            r2 = r0
            r0 = r21
            r1 = r24
        L_0x00b1:
            r9.L$0 = r1
            r9.L$1 = r10
            r9.L$2 = r0
            r9.L$3 = r11
            r9.L$4 = r8
            r9.F$0 = r5
            r9.J$0 = r2
            r9.label = r7
            java.lang.Object r12 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r0, r8, r9, r7, r8)
            if (r12 != r4) goto L_0x00c8
            return r4
        L_0x00c8:
            r18 = r2
            r3 = r9
            r2 = r12
            r12 = r11
            r11 = r10
            r9 = r18
        L_0x00d0:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r13 = r2.getChanges()
            int r14 = r13.size()
            r15 = 0
            r7 = r15
        L_0x00dc:
            if (r7 >= r14) goto L_0x00fe
            java.lang.Object r16 = r13.get(r7)
            r17 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r17 = (androidx.compose.ui.input.pointer.PointerInputChange) r17
            r21 = r9
            long r8 = r17.m5111getIdJ3iCeTQ()
            r17 = r7
            long r6 = r12.element
            boolean r6 = androidx.compose.ui.input.pointer.PointerId.m5095equalsimpl0(r8, r6)
            if (r6 == 0) goto L_0x00f7
            goto L_0x0102
        L_0x00f7:
            int r7 = r17 + 1
            r9 = r21
            r6 = 2
            r8 = 0
            goto L_0x00dc
        L_0x00fe:
            r21 = r9
            r16 = 0
        L_0x0102:
            r9 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            if (r9 != 0) goto L_0x010a
            goto L_0x018a
        L_0x010a:
            boolean r6 = r9.isConsumed()
            if (r6 == 0) goto L_0x0112
            goto L_0x018a
        L_0x0112:
            boolean r6 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r9)
            if (r6 == 0) goto L_0x0149
            java.util.List r2 = r2.getChanges()
            int r6 = r2.size()
        L_0x0120:
            if (r15 >= r6) goto L_0x0133
            java.lang.Object r7 = r2.get(r15)
            r8 = r7
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            boolean r8 = r8.getPressed()
            if (r8 == 0) goto L_0x0130
            goto L_0x0134
        L_0x0130:
            int r15 = r15 + 1
            goto L_0x0120
        L_0x0133:
            r7 = 0
        L_0x0134:
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            if (r7 != 0) goto L_0x0139
            goto L_0x018a
        L_0x0139:
            long r6 = r7.m5111getIdJ3iCeTQ()
            r12.element = r6
            r9 = r3
            r10 = r11
            r11 = r12
            r6 = 2
            r7 = 1
            r8 = 0
            r2 = r21
            goto L_0x00b1
        L_0x0149:
            long r6 = r9.m5113getPositionF1C5BW0()
            long r13 = r9.m5114getPreviousPositionF1C5BW0()
            long r6 = androidx.compose.ui.geometry.Offset.m3566minusMKHz9U(r6, r13)
            r13 = r21
            long r6 = androidx.compose.ui.geometry.Offset.m3567plusMKHz9U(r13, r6)
            float r2 = r11.m406calculateDeltaChangek4lQ0M(r6)
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x0192
            androidx.compose.ui.input.pointer.PointerEventPass r2 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r3.L$0 = r1
            r3.L$1 = r11
            r3.L$2 = r0
            r3.L$3 = r12
            r3.L$4 = r9
            r3.F$0 = r5
            r3.J$0 = r6
            r8 = 2
            r3.label = r8
            java.lang.Object r2 = r0.awaitPointerEvent(r2, r3)
            if (r2 != r4) goto L_0x017d
            return r4
        L_0x017d:
            r10 = r11
            r11 = r12
            r18 = r6
            r6 = r3
            r2 = r18
        L_0x0184:
            boolean r7 = r9.isConsumed()
            if (r7 == 0) goto L_0x018c
        L_0x018a:
            r8 = 0
            goto L_0x01a9
        L_0x018c:
            r9 = r6
            r6 = r8
        L_0x018e:
            r7 = 1
            r8 = 0
            goto L_0x00b1
        L_0x0192:
            r8 = 2
            long r6 = r11.m407calculatePostSlopOffset8S9VItk(r6, r5)
            float r2 = androidx.compose.ui.geometry.Offset.m3563getYimpl(r6)
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2)
            r1.invoke(r9, r2)
            boolean r2 = r9.isConsumed()
            if (r2 == 0) goto L_0x01aa
            r8 = r9
        L_0x01a9:
            return r8
        L_0x01aa:
            androidx.compose.ui.geometry.Offset$Companion r2 = androidx.compose.ui.geometry.Offset.Companion
            long r6 = r2.m3578getZeroF1C5BW0()
            r9 = r3
            r2 = r6
            r6 = r8
            r10 = r11
            r11 = r12
            goto L_0x018e
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m370awaitVerticalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0100 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0135 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* renamed from: awaitVerticalPointerSlopOrCancellation-gDDlDlE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m369awaitVerticalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope r22, long r23, int r25, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r26, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r27) {
        /*
            r0 = r23
            r2 = r27
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r7 = 1
            r8 = 0
            if (r5 == 0) goto L_0x0082
            if (r5 == r7) goto L_0x005b
            if (r5 != r6) goto L_0x0053
            long r0 = r3.J$0
            float r5 = r3.F$0
            java.lang.Object r9 = r3.L$4
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            java.lang.Object r10 = r3.L$3
            kotlin.jvm.internal.Ref$LongRef r10 = (kotlin.jvm.internal.Ref.LongRef) r10
            java.lang.Object r11 = r3.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
            java.lang.Object r12 = r3.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r12 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r12
            java.lang.Object r13 = r3.L$0
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            kotlin.ResultKt.throwOnFailure(r2)
            r8 = r6
            r6 = r3
            r2 = r0
            r0 = r11
            r1 = r13
            r11 = r10
            r10 = r5
            r5 = r12
            goto L_0x0186
        L_0x0053:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x005b:
            long r0 = r3.J$0
            float r5 = r3.F$0
            java.lang.Object r9 = r3.L$3
            kotlin.jvm.internal.Ref$LongRef r9 = (kotlin.jvm.internal.Ref.LongRef) r9
            java.lang.Object r10 = r3.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            java.lang.Object r11 = r3.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r11 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r11
            java.lang.Object r12 = r3.L$0
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            kotlin.ResultKt.throwOnFailure(r2)
            r18 = r11
            r11 = r5
            r5 = r18
            r19 = r12
            r12 = r9
            r20 = r0
            r0 = r10
            r9 = r20
            r1 = r19
            goto L_0x00d2
        L_0x0082:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.foundation.gestures.PointerDirectionConfig r2 = VerticalPointerDirectionConfig
            androidx.compose.ui.input.pointer.PointerEvent r5 = r22.getCurrentEvent()
            boolean r5 = m375isPointerUpDmW0f2w(r5, r0)
            if (r5 == 0) goto L_0x0093
            goto L_0x01ab
        L_0x0093:
            androidx.compose.ui.platform.ViewConfiguration r5 = r22.getViewConfiguration()
            r9 = r25
            float r5 = m376pointerSlopE8SPZFQ(r5, r9)
            kotlin.jvm.internal.Ref$LongRef r9 = new kotlin.jvm.internal.Ref$LongRef
            r9.<init>()
            r9.element = r0
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r0.m3578getZeroF1C5BW0()
            r10 = r5
            r11 = r9
            r5 = r2
            r9 = r3
            r2 = r0
            r0 = r22
            r1 = r26
        L_0x00b3:
            r9.L$0 = r1
            r9.L$1 = r5
            r9.L$2 = r0
            r9.L$3 = r11
            r9.L$4 = r8
            r9.F$0 = r10
            r9.J$0 = r2
            r9.label = r7
            java.lang.Object r12 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r0, r8, r9, r7, r8)
            if (r12 != r4) goto L_0x00ca
            return r4
        L_0x00ca:
            r18 = r2
            r3 = r9
            r2 = r12
            r12 = r11
            r11 = r10
            r9 = r18
        L_0x00d2:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r13 = r2.getChanges()
            int r14 = r13.size()
            r15 = 0
            r7 = r15
        L_0x00de:
            if (r7 >= r14) goto L_0x0100
            java.lang.Object r16 = r13.get(r7)
            r17 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r17 = (androidx.compose.ui.input.pointer.PointerInputChange) r17
            r22 = r9
            long r8 = r17.m5111getIdJ3iCeTQ()
            r17 = r7
            long r6 = r12.element
            boolean r6 = androidx.compose.ui.input.pointer.PointerId.m5095equalsimpl0(r8, r6)
            if (r6 == 0) goto L_0x00f9
            goto L_0x0104
        L_0x00f9:
            int r7 = r17 + 1
            r9 = r22
            r6 = 2
            r8 = 0
            goto L_0x00de
        L_0x0100:
            r22 = r9
            r16 = 0
        L_0x0104:
            r9 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            if (r9 != 0) goto L_0x010c
            goto L_0x018c
        L_0x010c:
            boolean r6 = r9.isConsumed()
            if (r6 == 0) goto L_0x0114
            goto L_0x018c
        L_0x0114:
            boolean r6 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r9)
            if (r6 == 0) goto L_0x014b
            java.util.List r2 = r2.getChanges()
            int r6 = r2.size()
        L_0x0122:
            if (r15 >= r6) goto L_0x0135
            java.lang.Object r7 = r2.get(r15)
            r8 = r7
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            boolean r8 = r8.getPressed()
            if (r8 == 0) goto L_0x0132
            goto L_0x0136
        L_0x0132:
            int r15 = r15 + 1
            goto L_0x0122
        L_0x0135:
            r7 = 0
        L_0x0136:
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            if (r7 != 0) goto L_0x013b
            goto L_0x018c
        L_0x013b:
            long r6 = r7.m5111getIdJ3iCeTQ()
            r12.element = r6
            r9 = r3
            r10 = r11
            r11 = r12
            r6 = 2
            r7 = 1
            r8 = 0
            r2 = r22
            goto L_0x00b3
        L_0x014b:
            long r6 = r9.m5113getPositionF1C5BW0()
            long r13 = r9.m5114getPreviousPositionF1C5BW0()
            long r6 = androidx.compose.ui.geometry.Offset.m3566minusMKHz9U(r6, r13)
            r13 = r22
            long r6 = androidx.compose.ui.geometry.Offset.m3567plusMKHz9U(r13, r6)
            float r2 = r5.m406calculateDeltaChangek4lQ0M(r6)
            int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r2 >= 0) goto L_0x0194
            androidx.compose.ui.input.pointer.PointerEventPass r2 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r3.L$0 = r1
            r3.L$1 = r5
            r3.L$2 = r0
            r3.L$3 = r12
            r3.L$4 = r9
            r3.F$0 = r11
            r3.J$0 = r6
            r8 = 2
            r3.label = r8
            java.lang.Object r2 = r0.awaitPointerEvent(r2, r3)
            if (r2 != r4) goto L_0x017f
            return r4
        L_0x017f:
            r10 = r11
            r11 = r12
            r18 = r6
            r6 = r3
            r2 = r18
        L_0x0186:
            boolean r7 = r9.isConsumed()
            if (r7 == 0) goto L_0x018e
        L_0x018c:
            r8 = 0
            goto L_0x01ab
        L_0x018e:
            r9 = r6
            r6 = r8
        L_0x0190:
            r7 = 1
            r8 = 0
            goto L_0x00b3
        L_0x0194:
            r8 = 2
            long r6 = r5.m407calculatePostSlopOffset8S9VItk(r6, r11)
            float r2 = androidx.compose.ui.geometry.Offset.m3563getYimpl(r6)
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2)
            r1.invoke(r9, r2)
            boolean r2 = r9.isConsumed()
            if (r2 == 0) goto L_0x01ac
            r8 = r9
        L_0x01ab:
            return r8
        L_0x01ac:
            androidx.compose.ui.geometry.Offset$Companion r2 = androidx.compose.ui.geometry.Offset.Companion
            long r6 = r2.m3578getZeroF1C5BW0()
            r9 = r3
            r2 = r6
            r6 = r8
            r10 = r11
            r11 = r12
            goto L_0x0190
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m369awaitVerticalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00eb, code lost:
        if ((!(androidx.compose.ui.geometry.Offset.m3563getYimpl(androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r13)) == 0.0f)) != false) goto L_0x00ed;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0079 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00a4 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* renamed from: verticalDrag-jO51t88  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m377verticalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r20, kotlin.coroutines.Continuation<? super java.lang.Boolean> r21) {
        /*
            r0 = r21
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$verticalDrag$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.DragGestureDetectorKt$verticalDrag$1 r1 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$verticalDrag$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$verticalDrag$1 r1 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$verticalDrag$1
            r1.<init>(r0)
        L_0x001b:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r5 = 0
            r6 = 1
            if (r3 == 0) goto L_0x004b
            if (r3 != r6) goto L_0x0043
            java.lang.Object r3 = r1.L$3
            kotlin.jvm.internal.Ref$LongRef r3 = (kotlin.jvm.internal.Ref.LongRef) r3
            java.lang.Object r7 = r1.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            java.lang.Object r8 = r1.L$1
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            java.lang.Object r9 = r1.L$0
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            kotlin.ResultKt.throwOnFailure(r0)
            r16 = r3
            r3 = r1
            r1 = r9
            r9 = r16
            goto L_0x007f
        L_0x0043:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004b:
            kotlin.ResultKt.throwOnFailure(r0)
            androidx.compose.ui.input.pointer.PointerEvent r0 = r17.getCurrentEvent()
            r7 = r18
            boolean r0 = m375isPointerUpDmW0f2w(r0, r7)
            if (r0 == 0) goto L_0x005c
            goto L_0x00ff
        L_0x005c:
            r0 = r17
            r3 = r1
            r1 = r20
        L_0x0061:
            kotlin.jvm.internal.Ref$LongRef r9 = new kotlin.jvm.internal.Ref$LongRef
            r9.<init>()
            r9.element = r7
            r7 = r0
        L_0x0069:
            r3.L$0 = r1
            r3.L$1 = r0
            r3.L$2 = r7
            r3.L$3 = r9
            r3.label = r6
            java.lang.Object r8 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r7, r5, r3, r6, r5)
            if (r8 != r2) goto L_0x007a
            return r2
        L_0x007a:
            r16 = r8
            r8 = r0
            r0 = r16
        L_0x007f:
            androidx.compose.ui.input.pointer.PointerEvent r0 = (androidx.compose.ui.input.pointer.PointerEvent) r0
            java.util.List r10 = r0.getChanges()
            int r11 = r10.size()
            r12 = 0
        L_0x008a:
            if (r12 >= r11) goto L_0x00a4
            java.lang.Object r13 = r10.get(r12)
            r14 = r13
            androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.ui.input.pointer.PointerInputChange) r14
            long r14 = r14.m5111getIdJ3iCeTQ()
            long r4 = r9.element
            boolean r4 = androidx.compose.ui.input.pointer.PointerId.m5095equalsimpl0(r14, r4)
            if (r4 == 0) goto L_0x00a0
            goto L_0x00a5
        L_0x00a0:
            int r12 = r12 + 1
            r5 = 0
            goto L_0x008a
        L_0x00a4:
            r13 = 0
        L_0x00a5:
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            if (r13 != 0) goto L_0x00ab
            r13 = 0
            goto L_0x00ed
        L_0x00ab:
            boolean r4 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r13)
            if (r4 == 0) goto L_0x00da
            java.util.List r0 = r0.getChanges()
            int r4 = r0.size()
            r5 = 0
        L_0x00ba:
            if (r5 >= r4) goto L_0x00cd
            java.lang.Object r10 = r0.get(r5)
            r11 = r10
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            boolean r11 = r11.getPressed()
            if (r11 == 0) goto L_0x00ca
            goto L_0x00ce
        L_0x00ca:
            int r5 = r5 + 1
            goto L_0x00ba
        L_0x00cd:
            r10 = 0
        L_0x00ce:
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            if (r10 != 0) goto L_0x00d3
            goto L_0x00ed
        L_0x00d3:
            long r4 = r10.m5111getIdJ3iCeTQ()
            r9.element = r4
            goto L_0x0115
        L_0x00da:
            long r4 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r13)
            float r0 = androidx.compose.ui.geometry.Offset.m3563getYimpl(r4)
            r4 = 0
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x00e9
            r0 = r6
            goto L_0x00ea
        L_0x00e9:
            r0 = 0
        L_0x00ea:
            r0 = r0 ^ r6
            if (r0 == 0) goto L_0x0115
        L_0x00ed:
            if (r13 != 0) goto L_0x00f1
        L_0x00ef:
            r5 = 0
            goto L_0x00ff
        L_0x00f1:
            boolean r0 = r13.isConsumed()
            if (r0 == 0) goto L_0x00f8
            goto L_0x00ef
        L_0x00f8:
            boolean r0 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r13)
            if (r0 == 0) goto L_0x0109
            r5 = r13
        L_0x00ff:
            if (r5 == 0) goto L_0x0103
            r4 = r6
            goto L_0x0104
        L_0x0103:
            r4 = 0
        L_0x0104:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r0
        L_0x0109:
            r1.invoke(r13)
            long r4 = r13.m5111getIdJ3iCeTQ()
            r0 = r8
            r7 = r4
            r5 = 0
            goto L_0x0061
        L_0x0115:
            r0 = r8
            r5 = 0
            goto L_0x0069
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m377verticalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d7, code lost:
        if ((r9 ^ 1) != 0) goto L_0x00d9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0092 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* renamed from: awaitVerticalDragOrCancellation-rnUCldI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m368awaitVerticalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r20) {
        /*
            r0 = r18
            r2 = r20
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalDragOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalDragOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalDragOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalDragOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalDragOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 0
            r7 = 1
            if (r5 == 0) goto L_0x0044
            if (r5 != r7) goto L_0x003c
            java.lang.Object r0 = r3.L$1
            kotlin.jvm.internal.Ref$LongRef r0 = (kotlin.jvm.internal.Ref.LongRef) r0
            java.lang.Object r1 = r3.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r2)
            r16 = r1
            r1 = r0
            r0 = r16
            goto L_0x006d
        L_0x003c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.ui.input.pointer.PointerEvent r2 = r17.getCurrentEvent()
            boolean r2 = m375isPointerUpDmW0f2w(r2, r0)
            if (r2 == 0) goto L_0x0052
            return r6
        L_0x0052:
            kotlin.jvm.internal.Ref$LongRef r2 = new kotlin.jvm.internal.Ref$LongRef
            r2.<init>()
            r2.element = r0
            r0 = r17
        L_0x005b:
            r3.L$0 = r0
            r3.L$1 = r2
            r3.label = r7
            java.lang.Object r1 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r0, r6, r3, r7, r6)
            if (r1 != r4) goto L_0x0068
            return r4
        L_0x0068:
            r16 = r2
            r2 = r1
            r1 = r16
        L_0x006d:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r5 = r2.getChanges()
            int r8 = r5.size()
            r9 = 0
            r10 = r9
        L_0x0079:
            if (r10 >= r8) goto L_0x0092
            java.lang.Object r11 = r5.get(r10)
            r12 = r11
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            long r12 = r12.m5111getIdJ3iCeTQ()
            long r14 = r1.element
            boolean r12 = androidx.compose.ui.input.pointer.PointerId.m5095equalsimpl0(r12, r14)
            if (r12 == 0) goto L_0x008f
            goto L_0x0093
        L_0x008f:
            int r10 = r10 + 1
            goto L_0x0079
        L_0x0092:
            r11 = r6
        L_0x0093:
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            if (r11 != 0) goto L_0x0099
            r11 = r6
            goto L_0x00d9
        L_0x0099:
            boolean r5 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r11)
            if (r5 == 0) goto L_0x00c7
            java.util.List r2 = r2.getChanges()
            int r5 = r2.size()
        L_0x00a7:
            if (r9 >= r5) goto L_0x00ba
            java.lang.Object r8 = r2.get(r9)
            r10 = r8
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            boolean r10 = r10.getPressed()
            if (r10 == 0) goto L_0x00b7
            goto L_0x00bb
        L_0x00b7:
            int r9 = r9 + 1
            goto L_0x00a7
        L_0x00ba:
            r8 = r6
        L_0x00bb:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 != 0) goto L_0x00c0
            goto L_0x00d9
        L_0x00c0:
            long r8 = r8.m5111getIdJ3iCeTQ()
            r1.element = r8
            goto L_0x00e3
        L_0x00c7:
            long r12 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r11)
            float r2 = androidx.compose.ui.geometry.Offset.m3563getYimpl(r12)
            r5 = 0
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x00d5
            r9 = r7
        L_0x00d5:
            r2 = r9 ^ 1
            if (r2 == 0) goto L_0x00e3
        L_0x00d9:
            if (r11 == 0) goto L_0x00e2
            boolean r0 = r11.isConsumed()
            if (r0 != 0) goto L_0x00e2
            r6 = r11
        L_0x00e2:
            return r6
        L_0x00e3:
            r2 = r1
            goto L_0x005b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m368awaitVerticalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object detectVerticalDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = DragGestureDetectorKt$detectVerticalDragGestures$2.INSTANCE;
        }
        Function1 function12 = function1;
        if ((i & 2) != 0) {
            function0 = DragGestureDetectorKt$detectVerticalDragGestures$3.INSTANCE;
        }
        Function0 function03 = function0;
        if ((i & 4) != 0) {
            function02 = DragGestureDetectorKt$detectVerticalDragGestures$4.INSTANCE;
        }
        return detectVerticalDragGestures(pointerInputScope, function12, function03, function02, function2, continuation);
    }

    public static final Object detectVerticalDragGestures(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new DragGestureDetectorKt$detectVerticalDragGestures$5(function1, function2, function0, function02, (Continuation<? super DragGestureDetectorKt$detectVerticalDragGestures$5>) null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00fe A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0133 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* renamed from: awaitHorizontalTouchSlopOrCancellation-jO51t88  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m363awaitHorizontalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r21, long r22, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r24, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r25) {
        /*
            r0 = r22
            r2 = r25
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r7 = 1
            r8 = 0
            if (r5 == 0) goto L_0x007c
            if (r5 == r7) goto L_0x005a
            if (r5 != r6) goto L_0x0052
            long r0 = r3.J$0
            float r5 = r3.F$0
            java.lang.Object r9 = r3.L$4
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            java.lang.Object r10 = r3.L$3
            kotlin.jvm.internal.Ref$LongRef r10 = (kotlin.jvm.internal.Ref.LongRef) r10
            java.lang.Object r11 = r3.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
            java.lang.Object r12 = r3.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r12 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r12
            java.lang.Object r13 = r3.L$0
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            kotlin.ResultKt.throwOnFailure(r2)
            r8 = r6
            r6 = r3
            r2 = r0
            r0 = r11
            r1 = r13
            r11 = r10
            r10 = r12
            goto L_0x0184
        L_0x0052:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x005a:
            long r0 = r3.J$0
            float r5 = r3.F$0
            java.lang.Object r9 = r3.L$3
            kotlin.jvm.internal.Ref$LongRef r9 = (kotlin.jvm.internal.Ref.LongRef) r9
            java.lang.Object r10 = r3.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            java.lang.Object r11 = r3.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r11 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r11
            java.lang.Object r12 = r3.L$0
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            kotlin.ResultKt.throwOnFailure(r2)
            r18 = r12
            r12 = r9
            r19 = r0
            r0 = r10
            r9 = r19
            r1 = r18
            goto L_0x00d0
        L_0x007c:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.ui.input.pointer.PointerType$Companion r2 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r2 = r2.m5196getTouchT8wyACA()
            androidx.compose.foundation.gestures.PointerDirectionConfig r5 = HorizontalPointerDirectionConfig
            androidx.compose.ui.input.pointer.PointerEvent r9 = r21.getCurrentEvent()
            boolean r9 = m375isPointerUpDmW0f2w(r9, r0)
            if (r9 == 0) goto L_0x0093
            goto L_0x01a9
        L_0x0093:
            androidx.compose.ui.platform.ViewConfiguration r9 = r21.getViewConfiguration()
            float r2 = m376pointerSlopE8SPZFQ(r9, r2)
            kotlin.jvm.internal.Ref$LongRef r9 = new kotlin.jvm.internal.Ref$LongRef
            r9.<init>()
            r9.element = r0
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r0.m3578getZeroF1C5BW0()
            r10 = r5
            r11 = r9
            r5 = r2
            r9 = r3
            r2 = r0
            r0 = r21
            r1 = r24
        L_0x00b1:
            r9.L$0 = r1
            r9.L$1 = r10
            r9.L$2 = r0
            r9.L$3 = r11
            r9.L$4 = r8
            r9.F$0 = r5
            r9.J$0 = r2
            r9.label = r7
            java.lang.Object r12 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r0, r8, r9, r7, r8)
            if (r12 != r4) goto L_0x00c8
            return r4
        L_0x00c8:
            r18 = r2
            r3 = r9
            r2 = r12
            r12 = r11
            r11 = r10
            r9 = r18
        L_0x00d0:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r13 = r2.getChanges()
            int r14 = r13.size()
            r15 = 0
            r7 = r15
        L_0x00dc:
            if (r7 >= r14) goto L_0x00fe
            java.lang.Object r16 = r13.get(r7)
            r17 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r17 = (androidx.compose.ui.input.pointer.PointerInputChange) r17
            r21 = r9
            long r8 = r17.m5111getIdJ3iCeTQ()
            r17 = r7
            long r6 = r12.element
            boolean r6 = androidx.compose.ui.input.pointer.PointerId.m5095equalsimpl0(r8, r6)
            if (r6 == 0) goto L_0x00f7
            goto L_0x0102
        L_0x00f7:
            int r7 = r17 + 1
            r9 = r21
            r6 = 2
            r8 = 0
            goto L_0x00dc
        L_0x00fe:
            r21 = r9
            r16 = 0
        L_0x0102:
            r9 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            if (r9 != 0) goto L_0x010a
            goto L_0x018a
        L_0x010a:
            boolean r6 = r9.isConsumed()
            if (r6 == 0) goto L_0x0112
            goto L_0x018a
        L_0x0112:
            boolean r6 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r9)
            if (r6 == 0) goto L_0x0149
            java.util.List r2 = r2.getChanges()
            int r6 = r2.size()
        L_0x0120:
            if (r15 >= r6) goto L_0x0133
            java.lang.Object r7 = r2.get(r15)
            r8 = r7
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            boolean r8 = r8.getPressed()
            if (r8 == 0) goto L_0x0130
            goto L_0x0134
        L_0x0130:
            int r15 = r15 + 1
            goto L_0x0120
        L_0x0133:
            r7 = 0
        L_0x0134:
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            if (r7 != 0) goto L_0x0139
            goto L_0x018a
        L_0x0139:
            long r6 = r7.m5111getIdJ3iCeTQ()
            r12.element = r6
            r9 = r3
            r10 = r11
            r11 = r12
            r6 = 2
            r7 = 1
            r8 = 0
            r2 = r21
            goto L_0x00b1
        L_0x0149:
            long r6 = r9.m5113getPositionF1C5BW0()
            long r13 = r9.m5114getPreviousPositionF1C5BW0()
            long r6 = androidx.compose.ui.geometry.Offset.m3566minusMKHz9U(r6, r13)
            r13 = r21
            long r6 = androidx.compose.ui.geometry.Offset.m3567plusMKHz9U(r13, r6)
            float r2 = r11.m406calculateDeltaChangek4lQ0M(r6)
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x0192
            androidx.compose.ui.input.pointer.PointerEventPass r2 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r3.L$0 = r1
            r3.L$1 = r11
            r3.L$2 = r0
            r3.L$3 = r12
            r3.L$4 = r9
            r3.F$0 = r5
            r3.J$0 = r6
            r8 = 2
            r3.label = r8
            java.lang.Object r2 = r0.awaitPointerEvent(r2, r3)
            if (r2 != r4) goto L_0x017d
            return r4
        L_0x017d:
            r10 = r11
            r11 = r12
            r18 = r6
            r6 = r3
            r2 = r18
        L_0x0184:
            boolean r7 = r9.isConsumed()
            if (r7 == 0) goto L_0x018c
        L_0x018a:
            r8 = 0
            goto L_0x01a9
        L_0x018c:
            r9 = r6
            r6 = r8
        L_0x018e:
            r7 = 1
            r8 = 0
            goto L_0x00b1
        L_0x0192:
            r8 = 2
            long r6 = r11.m407calculatePostSlopOffset8S9VItk(r6, r5)
            float r2 = androidx.compose.ui.geometry.Offset.m3562getXimpl(r6)
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2)
            r1.invoke(r9, r2)
            boolean r2 = r9.isConsumed()
            if (r2 == 0) goto L_0x01aa
            r8 = r9
        L_0x01a9:
            return r8
        L_0x01aa:
            androidx.compose.ui.geometry.Offset$Companion r2 = androidx.compose.ui.geometry.Offset.Companion
            long r6 = r2.m3578getZeroF1C5BW0()
            r9 = r3
            r2 = r6
            r6 = r8
            r10 = r11
            r11 = r12
            goto L_0x018e
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m363awaitHorizontalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0100 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0135 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m362awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope r22, long r23, int r25, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r26, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r27) {
        /*
            r0 = r23
            r2 = r27
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r7 = 1
            r8 = 0
            if (r5 == 0) goto L_0x0082
            if (r5 == r7) goto L_0x005b
            if (r5 != r6) goto L_0x0053
            long r0 = r3.J$0
            float r5 = r3.F$0
            java.lang.Object r9 = r3.L$4
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            java.lang.Object r10 = r3.L$3
            kotlin.jvm.internal.Ref$LongRef r10 = (kotlin.jvm.internal.Ref.LongRef) r10
            java.lang.Object r11 = r3.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
            java.lang.Object r12 = r3.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r12 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r12
            java.lang.Object r13 = r3.L$0
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            kotlin.ResultKt.throwOnFailure(r2)
            r8 = r6
            r6 = r3
            r2 = r0
            r0 = r11
            r1 = r13
            r11 = r10
            r10 = r5
            r5 = r12
            goto L_0x0186
        L_0x0053:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x005b:
            long r0 = r3.J$0
            float r5 = r3.F$0
            java.lang.Object r9 = r3.L$3
            kotlin.jvm.internal.Ref$LongRef r9 = (kotlin.jvm.internal.Ref.LongRef) r9
            java.lang.Object r10 = r3.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            java.lang.Object r11 = r3.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r11 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r11
            java.lang.Object r12 = r3.L$0
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            kotlin.ResultKt.throwOnFailure(r2)
            r18 = r11
            r11 = r5
            r5 = r18
            r19 = r12
            r12 = r9
            r20 = r0
            r0 = r10
            r9 = r20
            r1 = r19
            goto L_0x00d2
        L_0x0082:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.foundation.gestures.PointerDirectionConfig r2 = HorizontalPointerDirectionConfig
            androidx.compose.ui.input.pointer.PointerEvent r5 = r22.getCurrentEvent()
            boolean r5 = m375isPointerUpDmW0f2w(r5, r0)
            if (r5 == 0) goto L_0x0093
            goto L_0x01ab
        L_0x0093:
            androidx.compose.ui.platform.ViewConfiguration r5 = r22.getViewConfiguration()
            r9 = r25
            float r5 = m376pointerSlopE8SPZFQ(r5, r9)
            kotlin.jvm.internal.Ref$LongRef r9 = new kotlin.jvm.internal.Ref$LongRef
            r9.<init>()
            r9.element = r0
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r0.m3578getZeroF1C5BW0()
            r10 = r5
            r11 = r9
            r5 = r2
            r9 = r3
            r2 = r0
            r0 = r22
            r1 = r26
        L_0x00b3:
            r9.L$0 = r1
            r9.L$1 = r5
            r9.L$2 = r0
            r9.L$3 = r11
            r9.L$4 = r8
            r9.F$0 = r10
            r9.J$0 = r2
            r9.label = r7
            java.lang.Object r12 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r0, r8, r9, r7, r8)
            if (r12 != r4) goto L_0x00ca
            return r4
        L_0x00ca:
            r18 = r2
            r3 = r9
            r2 = r12
            r12 = r11
            r11 = r10
            r9 = r18
        L_0x00d2:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r13 = r2.getChanges()
            int r14 = r13.size()
            r15 = 0
            r7 = r15
        L_0x00de:
            if (r7 >= r14) goto L_0x0100
            java.lang.Object r16 = r13.get(r7)
            r17 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r17 = (androidx.compose.ui.input.pointer.PointerInputChange) r17
            r22 = r9
            long r8 = r17.m5111getIdJ3iCeTQ()
            r17 = r7
            long r6 = r12.element
            boolean r6 = androidx.compose.ui.input.pointer.PointerId.m5095equalsimpl0(r8, r6)
            if (r6 == 0) goto L_0x00f9
            goto L_0x0104
        L_0x00f9:
            int r7 = r17 + 1
            r9 = r22
            r6 = 2
            r8 = 0
            goto L_0x00de
        L_0x0100:
            r22 = r9
            r16 = 0
        L_0x0104:
            r9 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            if (r9 != 0) goto L_0x010c
            goto L_0x018c
        L_0x010c:
            boolean r6 = r9.isConsumed()
            if (r6 == 0) goto L_0x0114
            goto L_0x018c
        L_0x0114:
            boolean r6 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r9)
            if (r6 == 0) goto L_0x014b
            java.util.List r2 = r2.getChanges()
            int r6 = r2.size()
        L_0x0122:
            if (r15 >= r6) goto L_0x0135
            java.lang.Object r7 = r2.get(r15)
            r8 = r7
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            boolean r8 = r8.getPressed()
            if (r8 == 0) goto L_0x0132
            goto L_0x0136
        L_0x0132:
            int r15 = r15 + 1
            goto L_0x0122
        L_0x0135:
            r7 = 0
        L_0x0136:
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            if (r7 != 0) goto L_0x013b
            goto L_0x018c
        L_0x013b:
            long r6 = r7.m5111getIdJ3iCeTQ()
            r12.element = r6
            r9 = r3
            r10 = r11
            r11 = r12
            r6 = 2
            r7 = 1
            r8 = 0
            r2 = r22
            goto L_0x00b3
        L_0x014b:
            long r6 = r9.m5113getPositionF1C5BW0()
            long r13 = r9.m5114getPreviousPositionF1C5BW0()
            long r6 = androidx.compose.ui.geometry.Offset.m3566minusMKHz9U(r6, r13)
            r13 = r22
            long r6 = androidx.compose.ui.geometry.Offset.m3567plusMKHz9U(r13, r6)
            float r2 = r5.m406calculateDeltaChangek4lQ0M(r6)
            int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r2 >= 0) goto L_0x0194
            androidx.compose.ui.input.pointer.PointerEventPass r2 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r3.L$0 = r1
            r3.L$1 = r5
            r3.L$2 = r0
            r3.L$3 = r12
            r3.L$4 = r9
            r3.F$0 = r11
            r3.J$0 = r6
            r8 = 2
            r3.label = r8
            java.lang.Object r2 = r0.awaitPointerEvent(r2, r3)
            if (r2 != r4) goto L_0x017f
            return r4
        L_0x017f:
            r10 = r11
            r11 = r12
            r18 = r6
            r6 = r3
            r2 = r18
        L_0x0186:
            boolean r7 = r9.isConsumed()
            if (r7 == 0) goto L_0x018e
        L_0x018c:
            r8 = 0
            goto L_0x01ab
        L_0x018e:
            r9 = r6
            r6 = r8
        L_0x0190:
            r7 = 1
            r8 = 0
            goto L_0x00b3
        L_0x0194:
            r8 = 2
            long r6 = r5.m407calculatePostSlopOffset8S9VItk(r6, r11)
            float r2 = androidx.compose.ui.geometry.Offset.m3562getXimpl(r6)
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2)
            r1.invoke(r9, r2)
            boolean r2 = r9.isConsumed()
            if (r2 == 0) goto L_0x01ac
            r8 = r9
        L_0x01ab:
            return r8
        L_0x01ac:
            androidx.compose.ui.geometry.Offset$Companion r2 = androidx.compose.ui.geometry.Offset.Companion
            long r6 = r2.m3578getZeroF1C5BW0()
            r9 = r3
            r2 = r6
            r6 = r8
            r10 = r11
            r11 = r12
            goto L_0x0190
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m362awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00eb, code lost:
        if ((!(androidx.compose.ui.geometry.Offset.m3562getXimpl(androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r13)) == 0.0f)) != false) goto L_0x00ed;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0079 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00a4 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* renamed from: horizontalDrag-jO51t88  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m374horizontalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r20, kotlin.coroutines.Continuation<? super java.lang.Boolean> r21) {
        /*
            r0 = r21
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$horizontalDrag$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.DragGestureDetectorKt$horizontalDrag$1 r1 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$horizontalDrag$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$horizontalDrag$1 r1 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$horizontalDrag$1
            r1.<init>(r0)
        L_0x001b:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r5 = 0
            r6 = 1
            if (r3 == 0) goto L_0x004b
            if (r3 != r6) goto L_0x0043
            java.lang.Object r3 = r1.L$3
            kotlin.jvm.internal.Ref$LongRef r3 = (kotlin.jvm.internal.Ref.LongRef) r3
            java.lang.Object r7 = r1.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            java.lang.Object r8 = r1.L$1
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            java.lang.Object r9 = r1.L$0
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            kotlin.ResultKt.throwOnFailure(r0)
            r16 = r3
            r3 = r1
            r1 = r9
            r9 = r16
            goto L_0x007f
        L_0x0043:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004b:
            kotlin.ResultKt.throwOnFailure(r0)
            androidx.compose.ui.input.pointer.PointerEvent r0 = r17.getCurrentEvent()
            r7 = r18
            boolean r0 = m375isPointerUpDmW0f2w(r0, r7)
            if (r0 == 0) goto L_0x005c
            goto L_0x00ff
        L_0x005c:
            r0 = r17
            r3 = r1
            r1 = r20
        L_0x0061:
            kotlin.jvm.internal.Ref$LongRef r9 = new kotlin.jvm.internal.Ref$LongRef
            r9.<init>()
            r9.element = r7
            r7 = r0
        L_0x0069:
            r3.L$0 = r1
            r3.L$1 = r0
            r3.L$2 = r7
            r3.L$3 = r9
            r3.label = r6
            java.lang.Object r8 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r7, r5, r3, r6, r5)
            if (r8 != r2) goto L_0x007a
            return r2
        L_0x007a:
            r16 = r8
            r8 = r0
            r0 = r16
        L_0x007f:
            androidx.compose.ui.input.pointer.PointerEvent r0 = (androidx.compose.ui.input.pointer.PointerEvent) r0
            java.util.List r10 = r0.getChanges()
            int r11 = r10.size()
            r12 = 0
        L_0x008a:
            if (r12 >= r11) goto L_0x00a4
            java.lang.Object r13 = r10.get(r12)
            r14 = r13
            androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.ui.input.pointer.PointerInputChange) r14
            long r14 = r14.m5111getIdJ3iCeTQ()
            long r4 = r9.element
            boolean r4 = androidx.compose.ui.input.pointer.PointerId.m5095equalsimpl0(r14, r4)
            if (r4 == 0) goto L_0x00a0
            goto L_0x00a5
        L_0x00a0:
            int r12 = r12 + 1
            r5 = 0
            goto L_0x008a
        L_0x00a4:
            r13 = 0
        L_0x00a5:
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            if (r13 != 0) goto L_0x00ab
            r13 = 0
            goto L_0x00ed
        L_0x00ab:
            boolean r4 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r13)
            if (r4 == 0) goto L_0x00da
            java.util.List r0 = r0.getChanges()
            int r4 = r0.size()
            r5 = 0
        L_0x00ba:
            if (r5 >= r4) goto L_0x00cd
            java.lang.Object r10 = r0.get(r5)
            r11 = r10
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            boolean r11 = r11.getPressed()
            if (r11 == 0) goto L_0x00ca
            goto L_0x00ce
        L_0x00ca:
            int r5 = r5 + 1
            goto L_0x00ba
        L_0x00cd:
            r10 = 0
        L_0x00ce:
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            if (r10 != 0) goto L_0x00d3
            goto L_0x00ed
        L_0x00d3:
            long r4 = r10.m5111getIdJ3iCeTQ()
            r9.element = r4
            goto L_0x0115
        L_0x00da:
            long r4 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r13)
            float r0 = androidx.compose.ui.geometry.Offset.m3562getXimpl(r4)
            r4 = 0
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x00e9
            r0 = r6
            goto L_0x00ea
        L_0x00e9:
            r0 = 0
        L_0x00ea:
            r0 = r0 ^ r6
            if (r0 == 0) goto L_0x0115
        L_0x00ed:
            if (r13 != 0) goto L_0x00f1
        L_0x00ef:
            r5 = 0
            goto L_0x00ff
        L_0x00f1:
            boolean r0 = r13.isConsumed()
            if (r0 == 0) goto L_0x00f8
            goto L_0x00ef
        L_0x00f8:
            boolean r0 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r13)
            if (r0 == 0) goto L_0x0109
            r5 = r13
        L_0x00ff:
            if (r5 == 0) goto L_0x0103
            r4 = r6
            goto L_0x0104
        L_0x0103:
            r4 = 0
        L_0x0104:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r0
        L_0x0109:
            r1.invoke(r13)
            long r4 = r13.m5111getIdJ3iCeTQ()
            r0 = r8
            r7 = r4
            r5 = 0
            goto L_0x0061
        L_0x0115:
            r0 = r8
            r5 = 0
            goto L_0x0069
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m374horizontalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d7, code lost:
        if ((r9 ^ 1) != 0) goto L_0x00d9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0092 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* renamed from: awaitHorizontalDragOrCancellation-rnUCldI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m361awaitHorizontalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r20) {
        /*
            r0 = r18
            r2 = r20
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 0
            r7 = 1
            if (r5 == 0) goto L_0x0044
            if (r5 != r7) goto L_0x003c
            java.lang.Object r0 = r3.L$1
            kotlin.jvm.internal.Ref$LongRef r0 = (kotlin.jvm.internal.Ref.LongRef) r0
            java.lang.Object r1 = r3.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r2)
            r16 = r1
            r1 = r0
            r0 = r16
            goto L_0x006d
        L_0x003c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.ui.input.pointer.PointerEvent r2 = r17.getCurrentEvent()
            boolean r2 = m375isPointerUpDmW0f2w(r2, r0)
            if (r2 == 0) goto L_0x0052
            return r6
        L_0x0052:
            kotlin.jvm.internal.Ref$LongRef r2 = new kotlin.jvm.internal.Ref$LongRef
            r2.<init>()
            r2.element = r0
            r0 = r17
        L_0x005b:
            r3.L$0 = r0
            r3.L$1 = r2
            r3.label = r7
            java.lang.Object r1 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r0, r6, r3, r7, r6)
            if (r1 != r4) goto L_0x0068
            return r4
        L_0x0068:
            r16 = r2
            r2 = r1
            r1 = r16
        L_0x006d:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r5 = r2.getChanges()
            int r8 = r5.size()
            r9 = 0
            r10 = r9
        L_0x0079:
            if (r10 >= r8) goto L_0x0092
            java.lang.Object r11 = r5.get(r10)
            r12 = r11
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            long r12 = r12.m5111getIdJ3iCeTQ()
            long r14 = r1.element
            boolean r12 = androidx.compose.ui.input.pointer.PointerId.m5095equalsimpl0(r12, r14)
            if (r12 == 0) goto L_0x008f
            goto L_0x0093
        L_0x008f:
            int r10 = r10 + 1
            goto L_0x0079
        L_0x0092:
            r11 = r6
        L_0x0093:
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            if (r11 != 0) goto L_0x0099
            r11 = r6
            goto L_0x00d9
        L_0x0099:
            boolean r5 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r11)
            if (r5 == 0) goto L_0x00c7
            java.util.List r2 = r2.getChanges()
            int r5 = r2.size()
        L_0x00a7:
            if (r9 >= r5) goto L_0x00ba
            java.lang.Object r8 = r2.get(r9)
            r10 = r8
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            boolean r10 = r10.getPressed()
            if (r10 == 0) goto L_0x00b7
            goto L_0x00bb
        L_0x00b7:
            int r9 = r9 + 1
            goto L_0x00a7
        L_0x00ba:
            r8 = r6
        L_0x00bb:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 != 0) goto L_0x00c0
            goto L_0x00d9
        L_0x00c0:
            long r8 = r8.m5111getIdJ3iCeTQ()
            r1.element = r8
            goto L_0x00e3
        L_0x00c7:
            long r12 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r11)
            float r2 = androidx.compose.ui.geometry.Offset.m3562getXimpl(r12)
            r5 = 0
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x00d5
            r9 = r7
        L_0x00d5:
            r2 = r9 ^ 1
            if (r2 == 0) goto L_0x00e3
        L_0x00d9:
            if (r11 == 0) goto L_0x00e2
            boolean r0 = r11.isConsumed()
            if (r0 != 0) goto L_0x00e2
            r6 = r11
        L_0x00e2:
            return r6
        L_0x00e3:
            r2 = r1
            goto L_0x005b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m361awaitHorizontalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object detectHorizontalDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = DragGestureDetectorKt$detectHorizontalDragGestures$2.INSTANCE;
        }
        Function1 function12 = function1;
        if ((i & 2) != 0) {
            function0 = DragGestureDetectorKt$detectHorizontalDragGestures$3.INSTANCE;
        }
        Function0 function03 = function0;
        if ((i & 4) != 0) {
            function02 = DragGestureDetectorKt$detectHorizontalDragGestures$4.INSTANCE;
        }
        return detectHorizontalDragGestures(pointerInputScope, function12, function03, function02, function2, continuation);
    }

    public static final Object detectHorizontalDragGestures(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new DragGestureDetectorKt$detectHorizontalDragGestures$5(function1, function2, function0, function02, (Continuation<? super DragGestureDetectorKt$detectHorizontalDragGestures$5>) null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00fd, code lost:
        if (r3.invoke(r15).booleanValue() != false) goto L_0x00ff;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00bd A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* renamed from: drag-VnAYq1g  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m371dragVnAYq1g(androidx.compose.ui.input.pointer.AwaitPointerEventScope r19, long r20, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r22, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Boolean> r23, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Boolean> r24, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r25) {
        /*
            r0 = r25
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$2
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$2 r1 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$2) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$2 r1 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$2
            r1.<init>(r0)
        L_0x001b:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L_0x0058
            if (r3 != r4) goto L_0x0050
            java.lang.Object r3 = r1.L$5
            kotlin.jvm.internal.Ref$LongRef r3 = (kotlin.jvm.internal.Ref.LongRef) r3
            java.lang.Object r6 = r1.L$4
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r6 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r6
            java.lang.Object r7 = r1.L$3
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r8 = r1.L$2
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            java.lang.Object r9 = r1.L$1
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            java.lang.Object r10 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r10 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r10
            kotlin.ResultKt.throwOnFailure(r0)
            r17 = r9
            r9 = r1
            r1 = r17
            r18 = r7
            r7 = r3
            r3 = r8
            r8 = r18
            goto L_0x0094
        L_0x0050:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r0)
            androidx.compose.ui.input.pointer.PointerEvent r0 = r19.getCurrentEvent()
            r6 = r20
            boolean r0 = m375isPointerUpDmW0f2w(r0, r6)
            if (r0 == 0) goto L_0x0068
            return r5
        L_0x0068:
            r0 = r19
            r3 = r23
            r8 = r24
            r9 = r1
            r1 = r22
        L_0x0071:
            kotlin.jvm.internal.Ref$LongRef r10 = new kotlin.jvm.internal.Ref$LongRef
            r10.<init>()
            r10.element = r6
            r6 = r0
        L_0x0079:
            r9.L$0 = r0
            r9.L$1 = r1
            r9.L$2 = r3
            r9.L$3 = r8
            r9.L$4 = r6
            r9.L$5 = r10
            r9.label = r4
            java.lang.Object r7 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r6, r5, r9, r4, r5)
            if (r7 != r2) goto L_0x008e
            return r2
        L_0x008e:
            r17 = r10
            r10 = r0
            r0 = r7
            r7 = r17
        L_0x0094:
            androidx.compose.ui.input.pointer.PointerEvent r0 = (androidx.compose.ui.input.pointer.PointerEvent) r0
            java.util.List r11 = r0.getChanges()
            int r12 = r11.size()
            r14 = 0
        L_0x009f:
            if (r14 >= r12) goto L_0x00bd
            java.lang.Object r15 = r11.get(r14)
            r16 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r16 = (androidx.compose.ui.input.pointer.PointerInputChange) r16
            long r4 = r16.m5111getIdJ3iCeTQ()
            r16 = r14
            long r13 = r7.element
            boolean r4 = androidx.compose.ui.input.pointer.PointerId.m5095equalsimpl0(r4, r13)
            if (r4 == 0) goto L_0x00b8
            goto L_0x00be
        L_0x00b8:
            int r14 = r16 + 1
            r4 = 1
            r5 = 0
            goto L_0x009f
        L_0x00bd:
            r15 = 0
        L_0x00be:
            androidx.compose.ui.input.pointer.PointerInputChange r15 = (androidx.compose.ui.input.pointer.PointerInputChange) r15
            if (r15 != 0) goto L_0x00c4
            r15 = 0
            goto L_0x00ff
        L_0x00c4:
            boolean r4 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r15)
            if (r4 == 0) goto L_0x00f3
            java.util.List r0 = r0.getChanges()
            int r4 = r0.size()
            r13 = 0
        L_0x00d3:
            if (r13 >= r4) goto L_0x00e6
            java.lang.Object r5 = r0.get(r13)
            r11 = r5
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            boolean r11 = r11.getPressed()
            if (r11 == 0) goto L_0x00e3
            goto L_0x00e7
        L_0x00e3:
            int r13 = r13 + 1
            goto L_0x00d3
        L_0x00e6:
            r5 = 0
        L_0x00e7:
            androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
            if (r5 != 0) goto L_0x00ec
            goto L_0x00ff
        L_0x00ec:
            long r4 = r5.m5111getIdJ3iCeTQ()
            r7.element = r4
            goto L_0x0124
        L_0x00f3:
            java.lang.Object r0 = r3.invoke(r15)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0124
        L_0x00ff:
            if (r15 != 0) goto L_0x0103
            r0 = 0
            return r0
        L_0x0103:
            r0 = 0
            java.lang.Object r4 = r8.invoke(r15)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0111
            return r0
        L_0x0111:
            boolean r4 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r15)
            if (r4 == 0) goto L_0x0118
            return r15
        L_0x0118:
            r1.invoke(r15)
            long r6 = r15.m5111getIdJ3iCeTQ()
            r5 = r0
            r0 = r10
            r4 = 1
            goto L_0x0071
        L_0x0124:
            r0 = 0
            r5 = r0
            r0 = r10
            r4 = 1
            r10 = r7
            goto L_0x0079
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m371dragVnAYq1g(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: drag-VnAYq1g$$forInline  reason: not valid java name */
    private static final Object m372dragVnAYq1g$$forInline(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Unit> function1, Function1<? super PointerInputChange, Boolean> function12, Function1<? super PointerInputChange, Boolean> function13, Continuation<? super PointerInputChange> continuation) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        PointerInputChange pointerInputChange3;
        long j2 = j;
        if (m375isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j2)) {
            return null;
        }
        while (true) {
            Ref.LongRef longRef = new Ref.LongRef();
            longRef.element = j2;
            while (true) {
                int i = 0;
                InlineMarker.mark(0);
                AwaitPointerEventScope awaitPointerEventScope2 = awaitPointerEventScope;
                Object awaitPointerEvent$default = AwaitPointerEventScope.CC.awaitPointerEvent$default(awaitPointerEventScope, (PointerEventPass) null, continuation, 1, (Object) null);
                InlineMarker.mark(1);
                PointerEvent pointerEvent = (PointerEvent) awaitPointerEvent$default;
                List<PointerInputChange> changes = pointerEvent.getChanges();
                int size = changes.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        pointerInputChange = null;
                        break;
                    }
                    pointerInputChange = changes.get(i2);
                    Boolean valueOf = Boolean.valueOf(PointerId.m5095equalsimpl0(pointerInputChange.m5111getIdJ3iCeTQ(), longRef.element));
                    Boolean bool = valueOf;
                    if (valueOf.booleanValue()) {
                        break;
                    }
                    i2++;
                }
                pointerInputChange2 = pointerInputChange;
                if (pointerInputChange2 == null) {
                    Function1<? super PointerInputChange, Boolean> function14 = function12;
                    pointerInputChange2 = null;
                    break;
                } else if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    int size2 = changes2.size();
                    while (true) {
                        if (i >= size2) {
                            pointerInputChange3 = null;
                            break;
                        }
                        pointerInputChange3 = changes2.get(i);
                        Boolean valueOf2 = Boolean.valueOf(pointerInputChange3.getPressed());
                        Boolean bool2 = valueOf2;
                        if (valueOf2.booleanValue()) {
                            break;
                        }
                        i++;
                    }
                    PointerInputChange pointerInputChange4 = pointerInputChange3;
                    if (pointerInputChange4 == null) {
                        Function1<? super PointerInputChange, Boolean> function15 = function12;
                        break;
                    }
                    longRef.element = pointerInputChange4.m5111getIdJ3iCeTQ();
                    Function1<? super PointerInputChange, Boolean> function16 = function12;
                } else if (function12.invoke(pointerInputChange2).booleanValue()) {
                    break;
                }
            }
            PointerInputChange pointerInputChange5 = pointerInputChange2;
            if (pointerInputChange2 == null || function13.invoke(pointerInputChange2).booleanValue()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                return pointerInputChange2;
            }
            function1.invoke(pointerInputChange2);
            j2 = pointerInputChange2.m5111getIdJ3iCeTQ();
        }
    }

    /* renamed from: awaitDragOrUp-jO51t88  reason: not valid java name */
    private static final Object m360awaitDragOrUpjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Boolean> function1, Continuation<? super PointerInputChange> continuation) {
        PointerInputChange pointerInputChange;
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = j;
        while (true) {
            int i = 0;
            InlineMarker.mark(0);
            PointerInputChange pointerInputChange2 = null;
            Object awaitPointerEvent$default = AwaitPointerEventScope.CC.awaitPointerEvent$default(awaitPointerEventScope, (PointerEventPass) null, continuation, 1, (Object) null);
            InlineMarker.mark(1);
            PointerEvent pointerEvent = (PointerEvent) awaitPointerEvent$default;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i2);
                Boolean valueOf = Boolean.valueOf(PointerId.m5095equalsimpl0(pointerInputChange.m5111getIdJ3iCeTQ(), longRef.element));
                Boolean bool = valueOf;
                if (valueOf.booleanValue()) {
                    break;
                }
                i2++;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 == null) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                while (true) {
                    if (i >= size2) {
                        break;
                    }
                    PointerInputChange pointerInputChange4 = changes2.get(i);
                    Boolean valueOf2 = Boolean.valueOf(pointerInputChange4.getPressed());
                    Boolean bool2 = valueOf2;
                    if (valueOf2.booleanValue()) {
                        pointerInputChange2 = pointerInputChange4;
                        break;
                    }
                    i++;
                }
                PointerInputChange pointerInputChange5 = pointerInputChange2;
                if (pointerInputChange5 == null) {
                    return pointerInputChange3;
                }
                longRef.element = pointerInputChange5.m5111getIdJ3iCeTQ();
            } else if (function1.invoke(pointerInputChange3).booleanValue()) {
                return pointerInputChange3;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v1, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v3, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0114 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0105 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* renamed from: awaitPointerSlopOrCancellation-pn7EDYM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m365awaitPointerSlopOrCancellationpn7EDYM(androidx.compose.ui.input.pointer.AwaitPointerEventScope r21, long r22, int r24, androidx.compose.foundation.gestures.PointerDirectionConfig r25, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit> r26, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r27) {
        /*
            r0 = r22
            r2 = r27
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitPointerSlopOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitPointerSlopOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitPointerSlopOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitPointerSlopOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitPointerSlopOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r7 = 1
            r8 = 0
            if (r5 == 0) goto L_0x0087
            if (r5 == r7) goto L_0x0064
            if (r5 != r6) goto L_0x005c
            long r0 = r3.J$0
            float r5 = r3.F$0
            java.lang.Object r9 = r3.L$4
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            java.lang.Object r10 = r3.L$3
            kotlin.jvm.internal.Ref$LongRef r10 = (kotlin.jvm.internal.Ref.LongRef) r10
            java.lang.Object r11 = r3.L$2
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            java.lang.Object r12 = r3.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r12 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r12
            java.lang.Object r13 = r3.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
            kotlin.ResultKt.throwOnFailure(r2)
            r18 = r5
            r5 = r3
            r3 = r18
            r19 = r12
            r12 = r6
            r6 = r0
            r1 = r19
            r0 = r13
            r20 = r11
            r11 = r10
            r10 = r20
            goto L_0x0183
        L_0x005c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0064:
            long r0 = r3.J$0
            float r5 = r3.F$0
            java.lang.Object r9 = r3.L$3
            kotlin.jvm.internal.Ref$LongRef r9 = (kotlin.jvm.internal.Ref.LongRef) r9
            java.lang.Object r10 = r3.L$2
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            java.lang.Object r11 = r3.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r11 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r11
            java.lang.Object r12 = r3.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r12 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r12
            kotlin.ResultKt.throwOnFailure(r2)
            r18 = r5
            r5 = r3
            r3 = r18
            r19 = r0
            r1 = r11
            r0 = r12
            r11 = r19
            goto L_0x00d4
        L_0x0087:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.ui.input.pointer.PointerEvent r2 = r21.getCurrentEvent()
            boolean r2 = m375isPointerUpDmW0f2w(r2, r0)
            if (r2 == 0) goto L_0x0095
            return r8
        L_0x0095:
            androidx.compose.ui.platform.ViewConfiguration r2 = r21.getViewConfiguration()
            r5 = r24
            float r2 = m376pointerSlopE8SPZFQ(r2, r5)
            kotlin.jvm.internal.Ref$LongRef r5 = new kotlin.jvm.internal.Ref$LongRef
            r5.<init>()
            r5.element = r0
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r0.m3578getZeroF1C5BW0()
            r9 = r0
            r11 = r5
            r0 = r21
            r1 = r25
            r5 = r3
            r3 = r2
            r2 = r26
        L_0x00b6:
            r5.L$0 = r0
            r5.L$1 = r1
            r5.L$2 = r2
            r5.L$3 = r11
            r5.L$4 = r8
            r5.F$0 = r3
            r5.J$0 = r9
            r5.label = r7
            java.lang.Object r12 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r0, r8, r5, r7, r8)
            if (r12 != r4) goto L_0x00cd
            return r4
        L_0x00cd:
            r18 = r9
            r10 = r2
            r9 = r11
            r2 = r12
            r11 = r18
        L_0x00d4:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r13 = r2.getChanges()
            int r14 = r13.size()
            r15 = 0
            r7 = r15
        L_0x00e0:
            if (r7 >= r14) goto L_0x0105
            java.lang.Object r16 = r13.get(r7)
            r17 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r17 = (androidx.compose.ui.input.pointer.PointerInputChange) r17
            r21 = r7
            long r6 = r17.m5111getIdJ3iCeTQ()
            r22 = r13
            r23 = r14
            long r13 = r9.element
            boolean r6 = androidx.compose.ui.input.pointer.PointerId.m5095equalsimpl0(r6, r13)
            if (r6 == 0) goto L_0x00fd
            goto L_0x0107
        L_0x00fd:
            int r7 = r21 + 1
            r13 = r22
            r14 = r23
            r6 = 2
            goto L_0x00e0
        L_0x0105:
            r16 = r8
        L_0x0107:
            r6 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            if (r6 != 0) goto L_0x010e
            return r8
        L_0x010e:
            boolean r7 = r6.isConsumed()
            if (r7 == 0) goto L_0x0115
            return r8
        L_0x0115:
            boolean r7 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r6)
            if (r7 == 0) goto L_0x014a
            java.util.List r2 = r2.getChanges()
            int r6 = r2.size()
        L_0x0123:
            if (r15 >= r6) goto L_0x0136
            java.lang.Object r7 = r2.get(r15)
            r13 = r7
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            boolean r13 = r13.getPressed()
            if (r13 == 0) goto L_0x0133
            goto L_0x0137
        L_0x0133:
            int r15 = r15 + 1
            goto L_0x0123
        L_0x0136:
            r7 = r8
        L_0x0137:
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            if (r7 != 0) goto L_0x013c
            return r8
        L_0x013c:
            long r6 = r7.m5111getIdJ3iCeTQ()
            r9.element = r6
            r2 = r10
            r6 = 2
            r7 = 1
            r18 = r11
            r11 = r9
            goto L_0x01b3
        L_0x014a:
            long r13 = r6.m5113getPositionF1C5BW0()
            r7 = r9
            long r8 = r6.m5114getPreviousPositionF1C5BW0()
            long r8 = androidx.compose.ui.geometry.Offset.m3566minusMKHz9U(r13, r8)
            long r8 = androidx.compose.ui.geometry.Offset.m3567plusMKHz9U(r11, r8)
            float r11 = r1.m406calculateDeltaChangek4lQ0M(r8)
            int r11 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r11 >= 0) goto L_0x0192
            androidx.compose.ui.input.pointer.PointerEventPass r11 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r5.L$0 = r0
            r5.L$1 = r1
            r5.L$2 = r10
            r5.L$3 = r7
            r5.L$4 = r6
            r5.F$0 = r3
            r5.J$0 = r8
            r12 = 2
            r5.label = r12
            java.lang.Object r11 = r0.awaitPointerEvent(r11, r5)
            if (r11 != r4) goto L_0x017d
            return r4
        L_0x017d:
            r11 = r7
            r18 = r8
            r9 = r6
            r6 = r18
        L_0x0183:
            boolean r8 = r9.isConsumed()
            r2 = 0
            if (r8 == 0) goto L_0x018b
            return r2
        L_0x018b:
            r8 = r2
            r2 = r10
            r9 = r6
            r6 = r12
            r7 = 1
            goto L_0x00b6
        L_0x0192:
            r2 = 0
            r12 = 2
            long r8 = r1.m407calculatePostSlopOffset8S9VItk(r8, r3)
            androidx.compose.ui.geometry.Offset r8 = androidx.compose.ui.geometry.Offset.m3551boximpl(r8)
            r10.invoke(r6, r8)
            boolean r8 = r6.isConsumed()
            if (r8 == 0) goto L_0x01a6
            return r6
        L_0x01a6:
            androidx.compose.ui.geometry.Offset$Companion r6 = androidx.compose.ui.geometry.Offset.Companion
            long r8 = r6.m3578getZeroF1C5BW0()
            r11 = r7
            r6 = r12
            r7 = 1
            r18 = r8
            r8 = r2
            r2 = r10
        L_0x01b3:
            r9 = r18
            goto L_0x00b6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m365awaitPointerSlopOrCancellationpn7EDYM(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, androidx.compose.foundation.gestures.PointerDirectionConfig, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: awaitPointerSlopOrCancellation-pn7EDYM$$forInline  reason: not valid java name */
    private static final Object m366awaitPointerSlopOrCancellationpn7EDYM$$forInline(AwaitPointerEventScope awaitPointerEventScope, long j, int i, PointerDirectionConfig pointerDirectionConfig, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        PointerInputChange pointerInputChange;
        long j2;
        PointerInputChange pointerInputChange2;
        AwaitPointerEventScope awaitPointerEventScope2 = awaitPointerEventScope;
        long j3 = j;
        PointerDirectionConfig pointerDirectionConfig2 = pointerDirectionConfig;
        Continuation<? super PointerInputChange> continuation2 = continuation;
        if (m375isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j3)) {
            return null;
        }
        float r5 = m376pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = j3;
        long r1 = Offset.Companion.m3578getZeroF1C5BW0();
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
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i2);
                List<PointerInputChange> list = changes;
                int i3 = size;
                Boolean valueOf = Boolean.valueOf(PointerId.m5095equalsimpl0(pointerInputChange.m5111getIdJ3iCeTQ(), longRef.element));
                Boolean bool = valueOf;
                if (valueOf.booleanValue()) {
                    break;
                }
                i2++;
                changes = list;
                size = i3;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 == null || pointerInputChange3.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size2) {
                        pointerInputChange2 = null;
                        break;
                    }
                    pointerInputChange2 = changes2.get(i4);
                    Boolean valueOf2 = Boolean.valueOf(pointerInputChange2.getPressed());
                    Boolean bool2 = valueOf2;
                    if (valueOf2.booleanValue()) {
                        break;
                    }
                    i4++;
                }
                PointerInputChange pointerInputChange4 = pointerInputChange2;
                if (pointerInputChange4 == null) {
                    return null;
                }
                longRef.element = pointerInputChange4.m5111getIdJ3iCeTQ();
            } else {
                r1 = Offset.m3567plusMKHz9U(r1, Offset.m3566minusMKHz9U(pointerInputChange3.m5113getPositionF1C5BW0(), pointerInputChange3.m5114getPreviousPositionF1C5BW0()));
                if (pointerDirectionConfig2.m406calculateDeltaChangek4lQ0M(r1) < r5) {
                    PointerEventPass pointerEventPass = PointerEventPass.Final;
                    InlineMarker.mark(0);
                    awaitPointerEventScope2.awaitPointerEvent(pointerEventPass, continuation2);
                    InlineMarker.mark(1);
                    if (pointerInputChange3.isConsumed()) {
                        return null;
                    }
                } else {
                    function2.invoke(pointerInputChange3, Offset.m3551boximpl(pointerDirectionConfig2.m407calculatePostSlopOffset8S9VItk(r1, r5)));
                    if (pointerInputChange3.isConsumed()) {
                        return pointerInputChange3;
                    }
                    j2 = Offset.Companion.m3578getZeroF1C5BW0();
                    r1 = j2;
                }
            }
            j2 = r1;
            Function2<? super PointerInputChange, ? super Offset, Unit> function22 = function2;
            r1 = j2;
        }
    }

    static {
        float r0 = Dp.m6614constructorimpl((float) 0.125d);
        mouseSlop = r0;
        float r1 = Dp.m6614constructorimpl((float) 18);
        defaultTouchSlop = r1;
        mouseToTouchSlopRatio = r0 / r1;
    }

    public static final PointerDirectionConfig getHorizontalPointerDirectionConfig() {
        return HorizontalPointerDirectionConfig;
    }

    public static final PointerDirectionConfig getVerticalPointerDirectionConfig() {
        return VerticalPointerDirectionConfig;
    }

    public static final PointerDirectionConfig getBidirectionalPointerDirectionConfig() {
        return BidirectionalPointerDirectionConfig;
    }

    public static final PointerDirectionConfig toPointerDirectionConfig(Orientation orientation) {
        if (orientation == Orientation.Vertical) {
            return VerticalPointerDirectionConfig;
        }
        return HorizontalPointerDirectionConfig;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: awaitLongPressOrCancellation-rnUCldI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m364awaitLongPressOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r9, long r10, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r12) {
        /*
            boolean r0 = r12 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1 r0 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1 r0 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1
            r0.<init>(r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r9 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r0.L$0
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ PointerEventTimeoutCancellationException -> 0x009e }
            goto L_0x00a7
        L_0x0034:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r12)
            androidx.compose.ui.input.pointer.PointerEvent r12 = r9.getCurrentEvent()
            boolean r12 = m375isPointerUpDmW0f2w(r12, r10)
            if (r12 == 0) goto L_0x004a
            return r4
        L_0x004a:
            androidx.compose.ui.input.pointer.PointerEvent r12 = r9.getCurrentEvent()
            java.util.List r12 = r12.getChanges()
            int r2 = r12.size()
            r5 = 0
        L_0x0057:
            if (r5 >= r2) goto L_0x006e
            java.lang.Object r6 = r12.get(r5)
            r7 = r6
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            long r7 = r7.m5111getIdJ3iCeTQ()
            boolean r7 = androidx.compose.ui.input.pointer.PointerId.m5095equalsimpl0(r7, r10)
            if (r7 == 0) goto L_0x006b
            goto L_0x006f
        L_0x006b:
            int r5 = r5 + 1
            goto L_0x0057
        L_0x006e:
            r6 = r4
        L_0x006f:
            r10 = r6
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            if (r10 != 0) goto L_0x0075
            return r4
        L_0x0075:
            kotlin.jvm.internal.Ref$ObjectRef r11 = new kotlin.jvm.internal.Ref$ObjectRef
            r11.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r12 = new kotlin.jvm.internal.Ref$ObjectRef
            r12.<init>()
            r12.element = r10
            androidx.compose.ui.platform.ViewConfiguration r2 = r9.getViewConfiguration()
            long r5 = r2.getLongPressTimeoutMillis()
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2 r2 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2     // Catch:{ PointerEventTimeoutCancellationException -> 0x009d }
            r2.<init>(r12, r11, r4)     // Catch:{ PointerEventTimeoutCancellationException -> 0x009d }
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2     // Catch:{ PointerEventTimeoutCancellationException -> 0x009d }
            r0.L$0 = r10     // Catch:{ PointerEventTimeoutCancellationException -> 0x009d }
            r0.L$1 = r11     // Catch:{ PointerEventTimeoutCancellationException -> 0x009d }
            r0.label = r3     // Catch:{ PointerEventTimeoutCancellationException -> 0x009d }
            java.lang.Object r9 = r9.withTimeout(r5, r2, r0)     // Catch:{ PointerEventTimeoutCancellationException -> 0x009d }
            if (r9 != r1) goto L_0x00a7
            return r1
        L_0x009d:
            r9 = r11
        L_0x009e:
            T r9 = r9.element
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            if (r9 != 0) goto L_0x00a6
            r4 = r10
            goto L_0x00a7
        L_0x00a6:
            r4 = r9
        L_0x00a7:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m364awaitLongPressOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* renamed from: isPointerUp-DmW0f2w  reason: not valid java name */
    public static final boolean m375isPointerUpDmW0f2w(PointerEvent pointerEvent, long j) {
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
    public static final float m376pointerSlopE8SPZFQ(ViewConfiguration viewConfiguration, int i) {
        if (PointerType.m5189equalsimpl0(i, PointerType.Companion.m5194getMouseT8wyACA())) {
            return viewConfiguration.getTouchSlop() * mouseToTouchSlopRatio;
        }
        return viewConfiguration.getTouchSlop();
    }
}
