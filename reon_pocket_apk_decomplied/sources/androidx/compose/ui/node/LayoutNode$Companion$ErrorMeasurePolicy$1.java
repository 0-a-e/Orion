package androidx.compose.ui.node;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.LayoutNode;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"androidx/compose/ui/node/LayoutNode$Companion$ErrorMeasurePolicy$1", "Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "measure", "", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Ljava/lang/Void;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutNode.kt */
public final class LayoutNode$Companion$ErrorMeasurePolicy$1 extends LayoutNode.NoIntrinsicsMeasurePolicy {
    LayoutNode$Companion$ErrorMeasurePolicy$1() {
        super("Undefined intrinsics block and it is required");
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public Void m5513measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        throw new IllegalStateException("Undefined measure and it is required".toString());
    }
}
