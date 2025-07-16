package androidx.compose.foundation;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicMarquee.kt */
final class MarqueeModifierNode$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ MarqueeModifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MarqueeModifierNode$measure$1(Placeable placeable, MarqueeModifierNode marqueeModifierNode) {
        super(1);
        this.$placeable = placeable;
        this.this$0 = marqueeModifierNode;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeWithLayer$default(placementScope, this.$placeable, MathKt.roundToInt((-((Number) this.this$0.offset.getValue()).floatValue()) * this.this$0.getDirection()), 0, 0.0f, (Function1) null, 12, (Object) null);
    }
}
