package androidx.compose.ui.node;

import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0005"}, d2 = {"calculateAlignmentAndPlaceChildAsNeeded", "", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutModifierNodeCoordinator.kt */
public final class LayoutModifierNodeCoordinatorKt {
    /* access modifiers changed from: private */
    public static final int calculateAlignmentAndPlaceChildAsNeeded(LookaheadCapablePlaceable lookaheadCapablePlaceable, AlignmentLine alignmentLine) {
        int i;
        LookaheadCapablePlaceable child = lookaheadCapablePlaceable.getChild();
        if (child == null) {
            throw new IllegalStateException(("Child of " + lookaheadCapablePlaceable + " cannot be null when calculating alignment line").toString());
        } else if (lookaheadCapablePlaceable.getMeasureResult$ui_release().getAlignmentLines().containsKey(alignmentLine)) {
            Integer num = lookaheadCapablePlaceable.getMeasureResult$ui_release().getAlignmentLines().get(alignmentLine);
            if (num != null) {
                return num.intValue();
            }
            return Integer.MIN_VALUE;
        } else {
            int i2 = child.get(alignmentLine);
            if (i2 == Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            child.setShallowPlacing$ui_release(true);
            lookaheadCapablePlaceable.setPlacingForAlignment$ui_release(true);
            lookaheadCapablePlaceable.replace$ui_release();
            child.setShallowPlacing$ui_release(false);
            lookaheadCapablePlaceable.setPlacingForAlignment$ui_release(false);
            if (alignmentLine instanceof HorizontalAlignmentLine) {
                i = IntOffset.m6749getYimpl(child.m5567getPositionnOccac());
            } else {
                i = IntOffset.m6748getXimpl(child.m5567getPositionnOccac());
            }
            return i2 + i;
        }
    }
}
