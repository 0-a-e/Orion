package androidx.compose.ui.layout;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.NodeCoordinator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\r\u001a\u00020\u000eH\u0016R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u000f"}, d2 = {"androidx/compose/ui/layout/IntermediateLayoutModifierNode$IntermediateMeasureScopeImpl$layout$1", "Landroidx/compose/ui/layout/MeasureResult;", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getAlignmentLines", "()Ljava/util/Map;", "height", "getHeight", "()I", "width", "getWidth", "placeChildren", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IntermediateLayoutModifierNode.kt */
public final class IntermediateLayoutModifierNode$IntermediateMeasureScopeImpl$layout$1 implements MeasureResult {
    final /* synthetic */ Function1<Placeable.PlacementScope, Unit> $placementBlock;
    private final Map<AlignmentLine, Integer> alignmentLines;
    private final int height;
    final /* synthetic */ IntermediateLayoutModifierNode this$0;
    private final int width;

    IntermediateLayoutModifierNode$IntermediateMeasureScopeImpl$layout$1(int i, int i2, Map<AlignmentLine, Integer> map, Function1<? super Placeable.PlacementScope, Unit> function1, IntermediateLayoutModifierNode intermediateLayoutModifierNode) {
        this.$placementBlock = function1;
        this.this$0 = intermediateLayoutModifierNode;
        this.width = i;
        this.height = i2;
        this.alignmentLines = map;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.alignmentLines;
    }

    public void placeChildren() {
        Function1<Placeable.PlacementScope, Unit> function1 = this.$placementBlock;
        NodeCoordinator coordinator$ui_release = this.this$0.getCoordinator$ui_release();
        Intrinsics.checkNotNull(coordinator$ui_release);
        function1.invoke(coordinator$ui_release.getPlacementScope());
    }
}
