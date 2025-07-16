package androidx.compose.material3;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeToDismissBox.kt */
final class SwipeToDismissAnchorsNode$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ MeasureScope $this_measure;
    final /* synthetic */ SwipeToDismissAnchorsNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeToDismissAnchorsNode$measure$1(MeasureScope measureScope, SwipeToDismissAnchorsNode swipeToDismissAnchorsNode, Placeable placeable) {
        super(1);
        this.$this_measure = measureScope;
        this.this$0 = swipeToDismissAnchorsNode;
        this.$placeable = placeable;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        float f;
        if (this.$this_measure.isLookingAhead()) {
            f = this.this$0.getState().getAnchoredDraggableState$material3_release().getAnchors().positionOf(this.this$0.getState().getTargetValue());
        } else {
            f = this.this$0.getState().requireOffset();
        }
        Placeable.PlacementScope.place$default(placementScope, this.$placeable, MathKt.roundToInt(f), 0, 0.0f, 4, (Object) null);
    }
}
