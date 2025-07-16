package androidx.compose.material3;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: InteractiveComponentSize.kt */
final class MinimumInteractiveModifierNode$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ int $height;
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ int $width;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MinimumInteractiveModifierNode$measure$1(int i, Placeable placeable, int i2) {
        super(1);
        this.$width = i;
        this.$placeable = placeable;
        this.$height = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope placementScope2 = placementScope;
        Placeable.PlacementScope.place$default(placementScope2, this.$placeable, MathKt.roundToInt(((float) (this.$width - this.$placeable.getWidth())) / 2.0f), MathKt.roundToInt(((float) (this.$height - this.$placeable.getHeight())) / 2.0f), 0.0f, 4, (Object) null);
    }
}
