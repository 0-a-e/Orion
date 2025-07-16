package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Box.kt */
final class BoxMeasurePolicy$measure$2 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ int $boxHeight;
    final /* synthetic */ int $boxWidth;
    final /* synthetic */ Measurable $measurable;
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ MeasureScope $this_measure;
    final /* synthetic */ BoxMeasurePolicy this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BoxMeasurePolicy$measure$2(Placeable placeable, Measurable measurable, MeasureScope measureScope, int i, int i2, BoxMeasurePolicy boxMeasurePolicy) {
        super(1);
        this.$placeable = placeable;
        this.$measurable = measurable;
        this.$this_measure = measureScope;
        this.$boxWidth = i;
        this.$boxHeight = i2;
        this.this$0 = boxMeasurePolicy;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        BoxKt.placeInBox(placementScope, this.$placeable, this.$measurable, this.$this_measure.getLayoutDirection(), this.$boxWidth, this.$boxHeight, this.this$0.alignment);
    }
}
