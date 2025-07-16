package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0015J\"\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u000fR\"\u0010\u0002\u001a\u00020\u0003X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, d2 = {"androidx/compose/foundation/text/modifiers/SelectionControllerKt$makeSelectionModifier$mouseSelectionObserver$1", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "lastPosition", "Landroidx/compose/ui/geometry/Offset;", "getLastPosition", "()J", "setLastPosition", "(J)V", "J", "onDrag", "", "dragPosition", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "onDrag-3MmeM6k", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "onDragDone", "", "onExtend", "downPosition", "onExtend-k-4lQ0M", "(J)Z", "onExtendDrag", "onExtendDrag-k-4lQ0M", "onStart", "onStart-3MmeM6k", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionController.kt */
public final class SelectionControllerKt$makeSelectionModifier$mouseSelectionObserver$1 implements MouseSelectionObserver {
    final /* synthetic */ Function0<LayoutCoordinates> $layoutCoordinates;
    final /* synthetic */ long $selectableId;
    final /* synthetic */ SelectionRegistrar $this_makeSelectionModifier;
    private long lastPosition = Offset.Companion.m3578getZeroF1C5BW0();

    SelectionControllerKt$makeSelectionModifier$mouseSelectionObserver$1(Function0<? extends LayoutCoordinates> function0, SelectionRegistrar selectionRegistrar, long j) {
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

    /* renamed from: onExtend-k-4lQ0M  reason: not valid java name */
    public boolean m1199onExtendk4lQ0M(long j) {
        LayoutCoordinates invoke = this.$layoutCoordinates.invoke();
        if (invoke == null) {
            return false;
        }
        SelectionRegistrar selectionRegistrar = this.$this_makeSelectionModifier;
        long j2 = this.$selectableId;
        if (!invoke.isAttached()) {
            return false;
        }
        if (selectionRegistrar.m1288notifySelectionUpdatenjBpvok(invoke, j, this.lastPosition, false, SelectionAdjustment.Companion.getNone(), false)) {
            this.lastPosition = j;
        }
        return SelectionRegistrarKt.hasSelection(selectionRegistrar, j2);
    }

    /* renamed from: onExtendDrag-k-4lQ0M  reason: not valid java name */
    public boolean m1200onExtendDragk4lQ0M(long j) {
        LayoutCoordinates invoke = this.$layoutCoordinates.invoke();
        if (invoke == null) {
            return true;
        }
        SelectionRegistrar selectionRegistrar = this.$this_makeSelectionModifier;
        long j2 = this.$selectableId;
        if (!invoke.isAttached() || !SelectionRegistrarKt.hasSelection(selectionRegistrar, j2)) {
            return false;
        }
        if (!selectionRegistrar.m1288notifySelectionUpdatenjBpvok(invoke, j, this.lastPosition, false, SelectionAdjustment.Companion.getNone(), false)) {
            return true;
        }
        this.lastPosition = j;
        return true;
    }

    /* renamed from: onStart-3MmeM6k  reason: not valid java name */
    public boolean m1201onStart3MmeM6k(long j, SelectionAdjustment selectionAdjustment) {
        LayoutCoordinates invoke = this.$layoutCoordinates.invoke();
        if (invoke == null) {
            return false;
        }
        SelectionRegistrar selectionRegistrar = this.$this_makeSelectionModifier;
        long j2 = this.$selectableId;
        if (!invoke.isAttached()) {
            return false;
        }
        selectionRegistrar.m1289notifySelectionUpdateStartubNVwUQ(invoke, j, selectionAdjustment, false);
        this.lastPosition = j;
        return SelectionRegistrarKt.hasSelection(selectionRegistrar, j2);
    }

    /* renamed from: onDrag-3MmeM6k  reason: not valid java name */
    public boolean m1198onDrag3MmeM6k(long j, SelectionAdjustment selectionAdjustment) {
        LayoutCoordinates invoke = this.$layoutCoordinates.invoke();
        if (invoke == null) {
            return true;
        }
        SelectionRegistrar selectionRegistrar = this.$this_makeSelectionModifier;
        long j2 = this.$selectableId;
        if (!invoke.isAttached() || !SelectionRegistrarKt.hasSelection(selectionRegistrar, j2)) {
            return false;
        }
        if (!selectionRegistrar.m1288notifySelectionUpdatenjBpvok(invoke, j, this.lastPosition, false, selectionAdjustment, false)) {
            return true;
        }
        this.lastPosition = j;
        return true;
    }

    public void onDragDone() {
        this.$this_makeSelectionModifier.notifySelectionUpdateEnd();
    }
}
