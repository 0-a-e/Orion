package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u000f\u001a\u00020\u0010H\u0016R&\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0011"}, d2 = {"androidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResultKt$EmptyLazyStaggeredGridLayoutInfo$1", "Landroidx/compose/ui/layout/MeasureResult;", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getAlignmentLines$annotations", "()V", "getAlignmentLines", "()Ljava/util/Map;", "height", "getHeight", "()I", "width", "getWidth", "placeChildren", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridMeasureResult.kt */
public final class LazyStaggeredGridMeasureResultKt$EmptyLazyStaggeredGridLayoutInfo$1 implements MeasureResult {
    private final Map<AlignmentLine, Integer> alignmentLines = MapsKt.emptyMap();
    private final int height;
    private final int width;

    public static /* synthetic */ void getAlignmentLines$annotations() {
    }

    public void placeChildren() {
    }

    LazyStaggeredGridMeasureResultKt$EmptyLazyStaggeredGridLayoutInfo$1() {
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
}
