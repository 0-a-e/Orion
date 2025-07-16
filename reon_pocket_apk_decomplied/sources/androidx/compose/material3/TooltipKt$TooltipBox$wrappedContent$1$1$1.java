package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/layout/LayoutCoordinates;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tooltip.kt */
final class TooltipKt$TooltipBox$wrappedContent$1$1$1 extends Lambda implements Function1<LayoutCoordinates, Unit> {
    final /* synthetic */ MutableState<LayoutCoordinates> $anchorBounds$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TooltipKt$TooltipBox$wrappedContent$1$1$1(MutableState<LayoutCoordinates> mutableState) {
        super(1);
        this.$anchorBounds$delegate = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutCoordinates) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LayoutCoordinates layoutCoordinates) {
        TooltipKt.TooltipBox$lambda$2(this.$anchorBounds$delegate, layoutCoordinates);
    }
}
