package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0007J\u001a\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0007J\u001a\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0007J\b\u0010\u0017\u001a\u00020\rH\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016R\"\u0010\u0002\u001a\u00020\u0003X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u00020\u0003X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"androidx/compose/foundation/text/modifiers/SelectionControllerKt$makeSelectionModifier$longPressDragObserver$1", "Landroidx/compose/foundation/text/TextDragObserver;", "dragTotalDistance", "Landroidx/compose/ui/geometry/Offset;", "getDragTotalDistance", "()J", "setDragTotalDistance", "(J)V", "J", "lastPosition", "getLastPosition", "setLastPosition", "onCancel", "", "onDown", "point", "onDown-k-4lQ0M", "onDrag", "delta", "onDrag-k-4lQ0M", "onStart", "startPoint", "onStart-k-4lQ0M", "onStop", "onUp", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionController.kt */
public final class SelectionControllerKt$makeSelectionModifier$longPressDragObserver$1 implements TextDragObserver {
    final /* synthetic */ Function0<LayoutCoordinates> $layoutCoordinates;
    final /* synthetic */ long $selectableId;
    final /* synthetic */ SelectionRegistrar $this_makeSelectionModifier;
    private long dragTotalDistance = Offset.Companion.m3578getZeroF1C5BW0();
    private long lastPosition = Offset.Companion.m3578getZeroF1C5BW0();

    /* renamed from: onDown-k-4lQ0M  reason: not valid java name */
    public void m1195onDownk4lQ0M(long j) {
    }

    public void onUp() {
    }

    SelectionControllerKt$makeSelectionModifier$longPressDragObserver$1(Function0<? extends LayoutCoordinates> function0, SelectionRegistrar selectionRegistrar, long j) {
        this.$layoutCoordinates = function0;
        this.$this_makeSelectionModifier = selectionRegistrar;
        this.$selectableId = j;
    }

    public final long getLastPosition() {
        return this.lastPosition;
    }

    public final void setLastPosition(long j) {
        this.lastPosition = j;
    }

    public final long getDragTotalDistance() {
        return this.dragTotalDistance;
    }

    public final void setDragTotalDistance(long j) {
        this.dragTotalDistance = j;
    }

    /* renamed from: onStart-k-4lQ0M  reason: not valid java name */
    public void m1197onStartk4lQ0M(long j) {
        LayoutCoordinates invoke = this.$layoutCoordinates.invoke();
        if (invoke != null) {
            SelectionRegistrar selectionRegistrar = this.$this_makeSelectionModifier;
            if (invoke.isAttached()) {
                selectionRegistrar.m1289notifySelectionUpdateStartubNVwUQ(invoke, j, SelectionAdjustment.Companion.getWord(), true);
                this.lastPosition = j;
            } else {
                return;
            }
        }
        if (SelectionRegistrarKt.hasSelection(this.$this_makeSelectionModifier, this.$selectableId)) {
            this.dragTotalDistance = Offset.Companion.m3578getZeroF1C5BW0();
        }
    }

    /* renamed from: onDrag-k-4lQ0M  reason: not valid java name */
    public void m1196onDragk4lQ0M(long j) {
        LayoutCoordinates invoke = this.$layoutCoordinates.invoke();
        if (invoke != null) {
            SelectionRegistrar selectionRegistrar = this.$this_makeSelectionModifier;
            long j2 = this.$selectableId;
            if (invoke.isAttached() && SelectionRegistrarKt.hasSelection(selectionRegistrar, j2)) {
                long r11 = Offset.m3567plusMKHz9U(this.dragTotalDistance, j);
                this.dragTotalDistance = r11;
                long r112 = Offset.m3567plusMKHz9U(this.lastPosition, r11);
                if (selectionRegistrar.m1288notifySelectionUpdatenjBpvok(invoke, r112, this.lastPosition, false, SelectionAdjustment.Companion.getCharacterWithWordAccelerate(), true)) {
                    this.lastPosition = r112;
                    this.dragTotalDistance = Offset.Companion.m3578getZeroF1C5BW0();
                }
            }
        }
    }

    public void onStop() {
        if (SelectionRegistrarKt.hasSelection(this.$this_makeSelectionModifier, this.$selectableId)) {
            this.$this_makeSelectionModifier.notifySelectionUpdateEnd();
        }
    }

    public void onCancel() {
        if (SelectionRegistrarKt.hasSelection(this.$this_makeSelectionModifier, this.$selectableId)) {
            this.$this_makeSelectionModifier.notifySelectionUpdateEnd();
        }
    }
}
