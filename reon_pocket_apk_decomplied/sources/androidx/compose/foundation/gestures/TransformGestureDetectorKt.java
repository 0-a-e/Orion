package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function4;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u0002*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\t\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b\u001a\u000f\u0010\u000b\u001a\u00020\u0002*\u00020\u0006¢\u0006\u0002\u0010\f\u001a\n\u0010\r\u001a\u00020\u0001*\u00020\u0006\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\u0006\u001a~\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\b2`\u0010\u0013\u001a\\\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00100\u0014H@¢\u0006\u0002\u0010\u001b\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"angle", "", "Landroidx/compose/ui/geometry/Offset;", "angle-k-4lQ0M", "(J)F", "calculateCentroid", "Landroidx/compose/ui/input/pointer/PointerEvent;", "useCurrent", "", "(Landroidx/compose/ui/input/pointer/PointerEvent;Z)J", "calculateCentroidSize", "calculatePan", "(Landroidx/compose/ui/input/pointer/PointerEvent;)J", "calculateRotation", "calculateZoom", "detectTransformGestures", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "panZoomLock", "onGesture", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "centroid", "pan", "zoom", "rotation", "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TransformGestureDetector.kt */
public final class TransformGestureDetectorKt {
    public static /* synthetic */ Object detectTransformGestures$default(PointerInputScope pointerInputScope, boolean z, Function4 function4, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return detectTransformGestures(pointerInputScope, z, function4, continuation);
    }

    public static final Object detectTransformGestures(PointerInputScope pointerInputScope, boolean z, Function4<? super Offset, ? super Offset, ? super Float, ? super Float, Unit> function4, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new TransformGestureDetectorKt$detectTransformGestures$2(z, function4, (Continuation<? super TransformGestureDetectorKt$detectTransformGestures$2>) null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    public static final float calculateRotation(PointerEvent pointerEvent) {
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = 1;
            if (i >= size) {
                break;
            }
            PointerInputChange pointerInputChange = changes.get(i);
            if (!pointerInputChange.getPreviousPressed() || !pointerInputChange.getPressed()) {
                i3 = 0;
            }
            i2 += i3;
            i++;
        }
        if (i2 < 2) {
            return 0.0f;
        }
        long calculateCentroid = calculateCentroid(pointerEvent, true);
        long calculateCentroid2 = calculateCentroid(pointerEvent, false);
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size2 = changes2.size();
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i4 = 0; i4 < size2; i4++) {
            PointerInputChange pointerInputChange2 = changes2.get(i4);
            if (pointerInputChange2.getPressed() && pointerInputChange2.getPreviousPressed()) {
                long r10 = pointerInputChange2.m5113getPositionF1C5BW0();
                long r12 = Offset.m3566minusMKHz9U(pointerInputChange2.m5114getPreviousPositionF1C5BW0(), calculateCentroid2);
                long r9 = Offset.m3566minusMKHz9U(r10, calculateCentroid);
                float r14 = m481anglek4lQ0M(r9) - m481anglek4lQ0M(r12);
                float r92 = Offset.m3560getDistanceimpl(Offset.m3567plusMKHz9U(r9, r12)) / 2.0f;
                if (r14 > 180.0f) {
                    r14 -= 360.0f;
                } else if (r14 < -180.0f) {
                    r14 += 360.0f;
                }
                f2 += r14 * r92;
                f += r92;
            }
        }
        if (f == 0.0f) {
            return 0.0f;
        }
        return f2 / f;
    }

    /* renamed from: angle-k-4lQ0M  reason: not valid java name */
    private static final float m481anglek4lQ0M(long j) {
        if (Offset.m3562getXimpl(j) == 0.0f && Offset.m3563getYimpl(j) == 0.0f) {
            return 0.0f;
        }
        return ((-((float) Math.atan2((double) Offset.m3562getXimpl(j), (double) Offset.m3563getYimpl(j)))) * 180.0f) / 3.1415927f;
    }

    public static final float calculateZoom(PointerEvent pointerEvent) {
        float calculateCentroidSize = calculateCentroidSize(pointerEvent, true);
        float calculateCentroidSize2 = calculateCentroidSize(pointerEvent, false);
        if (calculateCentroidSize == 0.0f || calculateCentroidSize2 == 0.0f) {
            return 1.0f;
        }
        return calculateCentroidSize / calculateCentroidSize2;
    }

    public static final long calculatePan(PointerEvent pointerEvent) {
        long calculateCentroid = calculateCentroid(pointerEvent, true);
        if (Offset.m3559equalsimpl0(calculateCentroid, Offset.Companion.m3577getUnspecifiedF1C5BW0())) {
            return Offset.Companion.m3578getZeroF1C5BW0();
        }
        return Offset.m3566minusMKHz9U(calculateCentroid, calculateCentroid(pointerEvent, false));
    }

    public static /* synthetic */ float calculateCentroidSize$default(PointerEvent pointerEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return calculateCentroidSize(pointerEvent, z);
    }

    public static final float calculateCentroidSize(PointerEvent pointerEvent, boolean z) {
        long calculateCentroid = calculateCentroid(pointerEvent, z);
        float f = 0.0f;
        if (Offset.m3559equalsimpl0(calculateCentroid, Offset.Companion.m3577getUnspecifiedF1C5BW0())) {
            return 0.0f;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            PointerInputChange pointerInputChange = changes.get(i2);
            if (pointerInputChange.getPressed() && pointerInputChange.getPreviousPressed()) {
                f += Offset.m3560getDistanceimpl(Offset.m3566minusMKHz9U(z ? pointerInputChange.m5113getPositionF1C5BW0() : pointerInputChange.m5114getPreviousPositionF1C5BW0(), calculateCentroid));
                i++;
            }
        }
        return f / ((float) i);
    }

    public static /* synthetic */ long calculateCentroid$default(PointerEvent pointerEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return calculateCentroid(pointerEvent, z);
    }

    public static final long calculateCentroid(PointerEvent pointerEvent, boolean z) {
        long r0 = Offset.Companion.m3578getZeroF1C5BW0();
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            PointerInputChange pointerInputChange = changes.get(i2);
            if (pointerInputChange.getPressed() && pointerInputChange.getPreviousPressed()) {
                r0 = Offset.m3567plusMKHz9U(r0, z ? pointerInputChange.m5113getPositionF1C5BW0() : pointerInputChange.m5114getPreviousPositionF1C5BW0());
                i++;
            }
        }
        if (i == 0) {
            return Offset.Companion.m3577getUnspecifiedF1C5BW0();
        }
        return Offset.m3557divtuRUvjQ(r0, (float) i);
    }
}
