package androidx.compose.material3;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationBar.kt */
final class NavigationBarKt$placeLabelAndIcon$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ boolean $alwaysShowLabel;
    final /* synthetic */ float $animationProgress;
    final /* synthetic */ int $containerWidth;
    final /* synthetic */ Placeable $iconPlaceable;
    final /* synthetic */ int $iconX;
    final /* synthetic */ Placeable $indicatorPlaceable;
    final /* synthetic */ Placeable $indicatorRipplePlaceable;
    final /* synthetic */ Placeable $labelPlaceable;
    final /* synthetic */ int $labelX;
    final /* synthetic */ float $labelY;
    final /* synthetic */ float $offset;
    final /* synthetic */ int $rippleX;
    final /* synthetic */ float $rippleY;
    final /* synthetic */ float $selectedIconY;
    final /* synthetic */ MeasureScope $this_placeLabelAndIcon;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationBarKt$placeLabelAndIcon$1(Placeable placeable, boolean z, float f, Placeable placeable2, int i, float f2, float f3, Placeable placeable3, int i2, float f4, Placeable placeable4, int i3, float f5, int i4, MeasureScope measureScope) {
        super(1);
        this.$indicatorPlaceable = placeable;
        this.$alwaysShowLabel = z;
        this.$animationProgress = f;
        this.$labelPlaceable = placeable2;
        this.$labelX = i;
        this.$labelY = f2;
        this.$offset = f3;
        this.$iconPlaceable = placeable3;
        this.$iconX = i2;
        this.$selectedIconY = f4;
        this.$indicatorRipplePlaceable = placeable4;
        this.$rippleX = i3;
        this.$rippleY = f5;
        this.$containerWidth = i4;
        this.$this_placeLabelAndIcon = measureScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Placeable placeable = this.$indicatorPlaceable;
        if (placeable != null) {
            int i = this.$containerWidth;
            float f = this.$selectedIconY;
            MeasureScope measureScope = this.$this_placeLabelAndIcon;
            float f2 = this.$offset;
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, (i - placeable.getWidth()) / 2, MathKt.roundToInt((f - ((float) measureScope.m6545roundToPx0680j_4(NavigationBarKt.getIndicatorVerticalPadding()))) + f2), 0.0f, 4, (Object) null);
        }
        if (this.$alwaysShowLabel || this.$animationProgress != 0.0f) {
            Placeable.PlacementScope.placeRelative$default(placementScope, this.$labelPlaceable, this.$labelX, MathKt.roundToInt(this.$labelY + this.$offset), 0.0f, 4, (Object) null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, this.$iconPlaceable, this.$iconX, MathKt.roundToInt(this.$selectedIconY + this.$offset), 0.0f, 4, (Object) null);
        Placeable.PlacementScope.placeRelative$default(placementScope, this.$indicatorRipplePlaceable, this.$rippleX, MathKt.roundToInt(this.$rippleY + this.$offset), 0.0f, 4, (Object) null);
    }
}
