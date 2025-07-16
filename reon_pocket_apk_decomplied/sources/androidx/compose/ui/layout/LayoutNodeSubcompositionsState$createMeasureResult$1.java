package androidx.compose.ui.layout;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\r\u001a\u00020\u000eH\u0016R\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u0005X\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\u0005X\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\n¨\u0006\u000f"}, d2 = {"androidx/compose/ui/layout/LayoutNodeSubcompositionsState$createMeasureResult$1", "Landroidx/compose/ui/layout/MeasureResult;", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getAlignmentLines", "()Ljava/util/Map;", "height", "getHeight", "()I", "width", "getWidth", "placeChildren", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SubcomposeLayout.kt */
public final class LayoutNodeSubcompositionsState$createMeasureResult$1 implements MeasureResult {
    private final /* synthetic */ MeasureResult $$delegate_0;
    final /* synthetic */ Function0<Unit> $placeChildrenBlock;

    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.$$delegate_0.getAlignmentLines();
    }

    public int getHeight() {
        return this.$$delegate_0.getHeight();
    }

    public int getWidth() {
        return this.$$delegate_0.getWidth();
    }

    public LayoutNodeSubcompositionsState$createMeasureResult$1(MeasureResult measureResult, Function0<Unit> function0) {
        this.$placeChildrenBlock = function0;
        this.$$delegate_0 = measureResult;
    }

    public void placeChildren() {
        this.$placeChildrenBlock.invoke();
    }
}
