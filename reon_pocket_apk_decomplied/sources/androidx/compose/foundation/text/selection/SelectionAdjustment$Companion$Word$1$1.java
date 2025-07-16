package androidx.compose.foundation.text.selection;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/TextRange;", "Landroidx/compose/foundation/text/selection/SelectableInfo;", "it", "", "getBoundary-fzxv0v0", "(Landroidx/compose/foundation/text/selection/SelectableInfo;I)J"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionAdjustment.kt */
final class SelectionAdjustment$Companion$Word$1$1 implements BoundaryFunction {
    public static final SelectionAdjustment$Companion$Word$1$1 INSTANCE = new SelectionAdjustment$Companion$Word$1$1();

    SelectionAdjustment$Companion$Word$1$1() {
    }

    /* renamed from: getBoundary-fzxv0v0  reason: not valid java name */
    public final long m1228getBoundaryfzxv0v0(SelectableInfo selectableInfo, int i) {
        return selectableInfo.getTextLayoutResult().m6016getWordBoundaryjx7JFs(i);
    }
}
