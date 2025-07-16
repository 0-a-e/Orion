package androidx.compose.material3;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationBar.kt */
final class NavigationBarKt$placeIcon$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ int $height;
    final /* synthetic */ Placeable $iconPlaceable;
    final /* synthetic */ int $iconX;
    final /* synthetic */ int $iconY;
    final /* synthetic */ Placeable $indicatorPlaceable;
    final /* synthetic */ Placeable $indicatorRipplePlaceable;
    final /* synthetic */ int $rippleX;
    final /* synthetic */ int $rippleY;
    final /* synthetic */ int $width;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationBarKt$placeIcon$1(Placeable placeable, Placeable placeable2, int i, int i2, Placeable placeable3, int i3, int i4, int i5, int i6) {
        super(1);
        this.$indicatorPlaceable = placeable;
        this.$iconPlaceable = placeable2;
        this.$iconX = i;
        this.$iconY = i2;
        this.$indicatorRipplePlaceable = placeable3;
        this.$rippleX = i3;
        this.$rippleY = i4;
        this.$width = i5;
        this.$height = i6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Placeable placeable = this.$indicatorPlaceable;
        if (placeable != null) {
            int i = this.$width;
            int i2 = this.$height;
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, (i - placeable.getWidth()) / 2, (i2 - placeable.getHeight()) / 2, 0.0f, 4, (Object) null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, this.$iconPlaceable, this.$iconX, this.$iconY, 0.0f, 4, (Object) null);
        Placeable.PlacementScope.placeRelative$default(placementScope, this.$indicatorRipplePlaceable, this.$rippleX, this.$rippleY, 0.0f, 4, (Object) null);
    }
}
