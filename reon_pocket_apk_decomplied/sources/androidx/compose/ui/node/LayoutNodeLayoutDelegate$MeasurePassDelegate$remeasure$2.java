package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutNodeLayoutDelegate.kt */
final class LayoutNodeLayoutDelegate$MeasurePassDelegate$remeasure$2 extends Lambda implements Function1<AlignmentLinesOwner, Unit> {
    public static final LayoutNodeLayoutDelegate$MeasurePassDelegate$remeasure$2 INSTANCE = new LayoutNodeLayoutDelegate$MeasurePassDelegate$remeasure$2();

    LayoutNodeLayoutDelegate$MeasurePassDelegate$remeasure$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AlignmentLinesOwner) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(AlignmentLinesOwner alignmentLinesOwner) {
        alignmentLinesOwner.getAlignmentLines().setUsedDuringParentMeasurement$ui_release(false);
    }
}
