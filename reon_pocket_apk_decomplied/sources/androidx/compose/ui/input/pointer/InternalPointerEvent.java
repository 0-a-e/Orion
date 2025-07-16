package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import androidx.collection.LongSparseArray;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "", "changes", "Landroidx/collection/LongSparseArray;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "pointerInputEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "(Landroidx/collection/LongSparseArray;Landroidx/compose/ui/input/pointer/PointerInputEvent;)V", "getChanges", "()Landroidx/collection/LongSparseArray;", "motionEvent", "Landroid/view/MotionEvent;", "getMotionEvent", "()Landroid/view/MotionEvent;", "getPointerInputEvent", "()Landroidx/compose/ui/input/pointer/PointerInputEvent;", "suppressMovementConsumption", "", "getSuppressMovementConsumption", "()Z", "setSuppressMovementConsumption", "(Z)V", "issuesEnterExitEvent", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "issuesEnterExitEvent-0FcD4WY", "(J)Z", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InternalPointerEvent.android.kt */
public final class InternalPointerEvent {
    public static final int $stable = 8;
    private final LongSparseArray<PointerInputChange> changes;
    private final PointerInputEvent pointerInputEvent;
    private boolean suppressMovementConsumption;

    public InternalPointerEvent(LongSparseArray<PointerInputChange> longSparseArray, PointerInputEvent pointerInputEvent2) {
        this.changes = longSparseArray;
        this.pointerInputEvent = pointerInputEvent2;
    }

    public final LongSparseArray<PointerInputChange> getChanges() {
        return this.changes;
    }

    public final PointerInputEvent getPointerInputEvent() {
        return this.pointerInputEvent;
    }

    public final MotionEvent getMotionEvent() {
        return this.pointerInputEvent.getMotionEvent();
    }

    /* renamed from: issuesEnterExitEvent-0FcD4WY  reason: not valid java name */
    public final boolean m5041issuesEnterExitEvent0FcD4WY(long j) {
        PointerInputEventData pointerInputEventData;
        List<PointerInputEventData> pointers = this.pointerInputEvent.getPointers();
        int size = pointers.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                pointerInputEventData = null;
                break;
            }
            pointerInputEventData = pointers.get(i);
            if (PointerId.m5095equalsimpl0(pointerInputEventData.m5128getIdJ3iCeTQ(), j)) {
                break;
            }
            i++;
        }
        PointerInputEventData pointerInputEventData2 = pointerInputEventData;
        if (pointerInputEventData2 != null) {
            return pointerInputEventData2.getIssuesEnterExit();
        }
        return false;
    }

    public final boolean getSuppressMovementConsumption() {
        return this.suppressMovementConsumption;
    }

    public final void setSuppressMovementConsumption(boolean z) {
        this.suppressMovementConsumption = z;
    }
}
