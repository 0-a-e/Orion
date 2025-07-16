package androidx.compose.animation;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: EnterExitTransition.kt */
final class EnterExitTransitionModifierNode$measure$2 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ Function1<GraphicsLayerScope, Unit> $layerBlock;
    final /* synthetic */ long $offset;
    final /* synthetic */ long $offsetDelta;
    final /* synthetic */ Placeable $placeable;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EnterExitTransitionModifierNode$measure$2(Placeable placeable, long j, long j2, Function1<? super GraphicsLayerScope, Unit> function1) {
        super(1);
        this.$placeable = placeable;
        this.$offset = j;
        this.$offsetDelta = j2;
        this.$layerBlock = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope placementScope2 = placementScope;
        placementScope2.placeWithLayer(this.$placeable, IntOffset.m6748getXimpl(this.$offsetDelta) + IntOffset.m6748getXimpl(this.$offset), IntOffset.m6749getYimpl(this.$offsetDelta) + IntOffset.m6749getYimpl(this.$offset), 0.0f, this.$layerBlock);
    }
}
