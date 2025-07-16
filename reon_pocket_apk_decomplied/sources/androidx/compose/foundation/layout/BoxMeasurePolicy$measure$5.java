package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Box.kt */
final class BoxMeasurePolicy$measure$5 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ Ref.IntRef $boxHeight;
    final /* synthetic */ Ref.IntRef $boxWidth;
    final /* synthetic */ List<Measurable> $measurables;
    final /* synthetic */ Placeable[] $placeables;
    final /* synthetic */ MeasureScope $this_measure;
    final /* synthetic */ BoxMeasurePolicy this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BoxMeasurePolicy$measure$5(Placeable[] placeableArr, List<? extends Measurable> list, MeasureScope measureScope, Ref.IntRef intRef, Ref.IntRef intRef2, BoxMeasurePolicy boxMeasurePolicy) {
        super(1);
        this.$placeables = placeableArr;
        this.$measurables = list;
        this.$this_measure = measureScope;
        this.$boxWidth = intRef;
        this.$boxHeight = intRef2;
        this.this$0 = boxMeasurePolicy;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Placeable[] placeableArr = this.$placeables;
        List<Measurable> list = this.$measurables;
        MeasureScope measureScope = this.$this_measure;
        Ref.IntRef intRef = this.$boxWidth;
        Ref.IntRef intRef2 = this.$boxHeight;
        BoxMeasurePolicy boxMeasurePolicy = this.this$0;
        int length = placeableArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            Placeable placeable = placeableArr[i];
            Intrinsics.checkNotNull(placeable, "null cannot be cast to non-null type androidx.compose.ui.layout.Placeable");
            BoxKt.placeInBox(placementScope, placeable, list.get(i2), measureScope.getLayoutDirection(), intRef.element, intRef2.element, boxMeasurePolicy.alignment);
            i++;
            i2++;
        }
    }
}
