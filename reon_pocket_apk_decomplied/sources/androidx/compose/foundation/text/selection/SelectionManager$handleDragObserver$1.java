package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\tJ\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\tJ\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"androidx/compose/foundation/text/selection/SelectionManager$handleDragObserver$1", "Landroidx/compose/foundation/text/TextDragObserver;", "done", "", "onCancel", "onDown", "point", "Landroidx/compose/ui/geometry/Offset;", "onDown-k-4lQ0M", "(J)V", "onDrag", "delta", "onDrag-k-4lQ0M", "onStart", "startPoint", "onStart-k-4lQ0M", "onStop", "onUp", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionManager.kt */
public final class SelectionManager$handleDragObserver$1 implements TextDragObserver {
    final /* synthetic */ boolean $isStartHandle;
    final /* synthetic */ SelectionManager this$0;

    SelectionManager$handleDragObserver$1(boolean z, SelectionManager selectionManager) {
        this.$isStartHandle = z;
        this.this$0 = selectionManager;
    }

    /* renamed from: onDown-k-4lQ0M  reason: not valid java name */
    public void m1271onDownk4lQ0M(long j) {
        LayoutCoordinates layoutCoordinates;
        Offset r4 = this.$isStartHandle ? this.this$0.m1266getStartHandlePosition_m7T9E() : this.this$0.m1265getEndHandlePosition_m7T9E();
        if (r4 != null) {
            r4.m3572unboximpl();
            Selection selection = this.this$0.getSelection();
            if (selection != null) {
                Selectable anchorSelectable$foundation_release = this.this$0.getAnchorSelectable$foundation_release(this.$isStartHandle ? selection.getStart() : selection.getEnd());
                if (anchorSelectable$foundation_release != null && (layoutCoordinates = anchorSelectable$foundation_release.getLayoutCoordinates()) != null) {
                    long r42 = anchorSelectable$foundation_release.m1223getHandlePositiondBAh8RU(selection, this.$isStartHandle);
                    if (!OffsetKt.m3583isUnspecifiedk4lQ0M(r42)) {
                        long r43 = SelectionHandlesKt.m1237getAdjustedCoordinatesk4lQ0M(r42);
                        SelectionManager selectionManager = this.this$0;
                        selectionManager.m1255setCurrentDragPosition_kEHs6E(Offset.m3551boximpl(selectionManager.requireContainerCoordinates$foundation_release().m5319localPositionOfR5De75A(layoutCoordinates, r43)));
                        this.this$0.setDraggingHandle(this.$isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd);
                        this.this$0.setShowToolbar$foundation_release(false);
                    }
                }
            }
        }
    }

    /* renamed from: onStart-k-4lQ0M  reason: not valid java name */
    public void m1273onStartk4lQ0M(long j) {
        if (this.this$0.getDraggingHandle() != null) {
            Selection selection = this.this$0.getSelection();
            Intrinsics.checkNotNull(selection);
            Selectable selectable = this.this$0.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf((this.$isStartHandle ? selection.getStart() : selection.getEnd()).getSelectableId()));
            if (selectable != null) {
                Selectable selectable2 = selectable;
                LayoutCoordinates layoutCoordinates = selectable2.getLayoutCoordinates();
                if (layoutCoordinates != null) {
                    long r4 = selectable2.m1223getHandlePositiondBAh8RU(selection, this.$isStartHandle);
                    if (!OffsetKt.m3583isUnspecifiedk4lQ0M(r4)) {
                        long r42 = SelectionHandlesKt.m1237getAdjustedCoordinatesk4lQ0M(r4);
                        SelectionManager selectionManager = this.this$0;
                        selectionManager.m1256setDragBeginPositionk4lQ0M(selectionManager.requireContainerCoordinates$foundation_release().m5319localPositionOfR5De75A(layoutCoordinates, r42));
                        this.this$0.m1257setDragTotalDistancek4lQ0M(Offset.Companion.m3578getZeroF1C5BW0());
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("Current selectable should have layout coordinates.".toString());
            }
            throw new IllegalStateException("SelectionRegistrar should contain the current selection's selectableIds".toString());
        }
    }

    /* renamed from: onDrag-k-4lQ0M  reason: not valid java name */
    public void m1272onDragk4lQ0M(long j) {
        if (this.this$0.getDraggingHandle() != null) {
            SelectionManager selectionManager = this.this$0;
            selectionManager.m1257setDragTotalDistancek4lQ0M(Offset.m3567plusMKHz9U(selectionManager.m1264getDragTotalDistanceF1C5BW0$foundation_release(), j));
            long r7 = Offset.m3567plusMKHz9U(this.this$0.m1263getDragBeginPositionF1C5BW0$foundation_release(), this.this$0.m1264getDragTotalDistanceF1C5BW0$foundation_release());
            if (this.this$0.m1268updateSelectionqNKwrvQ$foundation_release(Offset.m3551boximpl(r7), this.this$0.m1263getDragBeginPositionF1C5BW0$foundation_release(), this.$isStartHandle, SelectionAdjustment.Companion.getCharacterWithWordAccelerate())) {
                this.this$0.m1256setDragBeginPositionk4lQ0M(r7);
                this.this$0.m1257setDragTotalDistancek4lQ0M(Offset.Companion.m3578getZeroF1C5BW0());
            }
        }
    }

    private final void done() {
        this.this$0.setShowToolbar$foundation_release(true);
        this.this$0.setDraggingHandle((Handle) null);
        this.this$0.m1255setCurrentDragPosition_kEHs6E((Offset) null);
    }

    public void onUp() {
        done();
    }

    public void onStop() {
        done();
    }

    public void onCancel() {
        done();
    }
}
