package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.Selection;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionAdjustment.kt */
final class SelectionAdjustmentKt$updateSelectionBoundary$anchorSnappedToWordBoundary$2 extends Lambda implements Function0<Selection.AnchorInfo> {
    final /* synthetic */ Lazy<Integer> $currentRawLine$delegate;
    final /* synthetic */ int $currentRawOffset;
    final /* synthetic */ SelectableInfo $info;
    final /* synthetic */ int $otherRawOffset;
    final /* synthetic */ SelectionLayout $this_updateSelectionBoundary;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectionAdjustmentKt$updateSelectionBoundary$anchorSnappedToWordBoundary$2(SelectableInfo selectableInfo, int i, int i2, SelectionLayout selectionLayout, Lazy<Integer> lazy) {
        super(0);
        this.$info = selectableInfo;
        this.$currentRawOffset = i;
        this.$otherRawOffset = i2;
        this.$this_updateSelectionBoundary = selectionLayout;
        this.$currentRawLine$delegate = lazy;
    }

    public final Selection.AnchorInfo invoke() {
        return SelectionAdjustmentKt.snapToWordBoundary(this.$info, SelectionAdjustmentKt.updateSelectionBoundary$lambda$0(this.$currentRawLine$delegate), this.$currentRawOffset, this.$otherRawOffset, this.$this_updateSelectionBoundary.isStartHandle(), this.$this_updateSelectionBoundary.getCrossStatus() == CrossStatus.CROSSED);
    }
}
