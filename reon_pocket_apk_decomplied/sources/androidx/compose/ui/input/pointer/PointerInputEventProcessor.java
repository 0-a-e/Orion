package androidx.compose.ui.input.pointer;

import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J-\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputEventProcessor;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "hitPathTracker", "Landroidx/compose/ui/input/pointer/HitPathTracker;", "hitResult", "Landroidx/compose/ui/node/HitTestResult;", "isProcessing", "", "pointerInputChangeEventProducer", "Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer;", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "process", "Landroidx/compose/ui/input/pointer/ProcessResult;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "positionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "isInBounds", "process-BIzXfog", "(Landroidx/compose/ui/input/pointer/PointerInputEvent;Landroidx/compose/ui/input/pointer/PositionCalculator;Z)I", "processCancel", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PointerInputEventProcessor.kt */
public final class PointerInputEventProcessor {
    public static final int $stable = 8;
    private final HitPathTracker hitPathTracker;
    private final HitTestResult hitResult = new HitTestResult();
    private boolean isProcessing;
    private final PointerInputChangeEventProducer pointerInputChangeEventProducer = new PointerInputChangeEventProducer();
    private final LayoutNode root;

    public PointerInputEventProcessor(LayoutNode layoutNode) {
        this.root = layoutNode;
        this.hitPathTracker = new HitPathTracker(layoutNode.getCoordinates());
    }

    public final LayoutNode getRoot() {
        return this.root;
    }

    /* renamed from: process-BIzXfog$default  reason: not valid java name */
    public static /* synthetic */ int m5134processBIzXfog$default(PointerInputEventProcessor pointerInputEventProcessor, PointerInputEvent pointerInputEvent, PositionCalculator positionCalculator, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return pointerInputEventProcessor.m5135processBIzXfog(pointerInputEvent, positionCalculator, z);
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: process-BIzXfog  reason: not valid java name */
    public final int m5135processBIzXfog(PointerInputEvent pointerInputEvent, PositionCalculator positionCalculator, boolean z) {
        boolean z2;
        if (this.isProcessing) {
            return PointerInputEventProcessorKt.ProcessResult(false, false);
        }
        boolean z3 = true;
        try {
            this.isProcessing = true;
            InternalPointerEvent produce = this.pointerInputChangeEventProducer.produce(pointerInputEvent, positionCalculator);
            int size = produce.getChanges().size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z2 = true;
                    break;
                }
                PointerInputChange valueAt = produce.getChanges().valueAt(i);
                if (valueAt.getPressed()) {
                    break;
                } else if (valueAt.getPreviousPressed()) {
                    break;
                } else {
                    i++;
                }
            }
            z2 = false;
            int size2 = produce.getChanges().size();
            for (int i2 = 0; i2 < size2; i2++) {
                PointerInputChange valueAt2 = produce.getChanges().valueAt(i2);
                if (z2 || PointerEventKt.changedToDownIgnoreConsumed(valueAt2)) {
                    LayoutNode.m5503hitTestM_7yMNQ$ui_release$default(this.root, valueAt2.m5113getPositionF1C5BW0(), this.hitResult, PointerType.m5189equalsimpl0(valueAt2.m5116getTypeT8wyACA(), PointerType.Companion.m5196getTouchT8wyACA()), false, 8, (Object) null);
                    if (!this.hitResult.isEmpty()) {
                        this.hitPathTracker.m5040addHitPathKNwqfcY(valueAt2.m5111getIdJ3iCeTQ(), this.hitResult);
                        this.hitResult.clear();
                    }
                }
            }
            this.hitPathTracker.removeDetachedPointerInputFilters();
            boolean dispatchChanges = this.hitPathTracker.dispatchChanges(produce, z);
            if (!produce.getSuppressMovementConsumption()) {
                int size3 = produce.getChanges().size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size3) {
                        break;
                    }
                    PointerInputChange valueAt3 = produce.getChanges().valueAt(i3);
                    if (PointerEventKt.positionChangedIgnoreConsumed(valueAt3) && valueAt3.isConsumed()) {
                        break;
                    }
                    i3++;
                }
            }
            z3 = false;
            int ProcessResult = PointerInputEventProcessorKt.ProcessResult(dispatchChanges, z3);
            this.isProcessing = false;
            return ProcessResult;
        } catch (Throwable th) {
            this.isProcessing = false;
            throw th;
        }
    }

    public final void processCancel() {
        if (!this.isProcessing) {
            this.pointerInputChangeEventProducer.clear();
            this.hitPathTracker.processCancel();
        }
    }
}
