package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SegmentedButton.kt */
final class SegmentedButtonContentMeasurePolicy$measure$2 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ List<Placeable> $contentPlaceables;
    final /* synthetic */ int $height;
    final /* synthetic */ List<Placeable> $iconPlaceables;
    final /* synthetic */ int $offsetX;
    final /* synthetic */ MeasureScope $this_measure;
    final /* synthetic */ SegmentedButtonContentMeasurePolicy this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SegmentedButtonContentMeasurePolicy$measure$2(List<? extends Placeable> list, MeasureScope measureScope, SegmentedButtonContentMeasurePolicy segmentedButtonContentMeasurePolicy, int i, List<? extends Placeable> list2, int i2) {
        super(1);
        this.$iconPlaceables = list;
        this.$this_measure = measureScope;
        this.this$0 = segmentedButtonContentMeasurePolicy;
        this.$offsetX = i;
        this.$contentPlaceables = list2;
        this.$height = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        List<Placeable> list = this.$iconPlaceables;
        int i = this.$height;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Placeable placeable = list.get(i2);
            Placeable.PlacementScope.place$default(placementScope, placeable, 0, (i - placeable.getHeight()) / 2, 0.0f, 4, (Object) null);
        }
        int r0 = this.$this_measure.m6545roundToPx0680j_4(SegmentedButtonDefaults.INSTANCE.m2143getIconSizeD9Ej5fM()) + this.$this_measure.m6545roundToPx0680j_4(SegmentedButtonKt.IconSpacing);
        Animatable<Integer, AnimationVector1D> animatable = this.this$0.getAnimatable();
        int intValue = r0 + (animatable != null ? animatable.getValue().intValue() : this.$offsetX);
        List<Placeable> list2 = this.$contentPlaceables;
        int i3 = this.$height;
        int size2 = list2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            Placeable placeable2 = list2.get(i4);
            Placeable.PlacementScope.place$default(placementScope, placeable2, intValue, (i3 - placeable2.getHeight()) / 2, 0.0f, 4, (Object) null);
        }
    }
}
