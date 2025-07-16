package androidx.compose.material3;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TabRow.kt */
final class TabIndicatorOffsetNode$measure$4 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ long $constraints;
    final /* synthetic */ float $offset;
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ MeasureScope $this_measure;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabIndicatorOffsetNode$measure$4(Placeable placeable, MeasureScope measureScope, float f, long j) {
        super(1);
        this.$placeable = placeable;
        this.$this_measure = measureScope;
        this.$offset = f;
        this.$constraints = j;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, this.$placeable, this.$this_measure.m6545roundToPx0680j_4(this.$offset), Constraints.m6525getMaxHeightimpl(this.$constraints) - this.$placeable.getHeight(), 0.0f, 4, (Object) null);
    }
}
