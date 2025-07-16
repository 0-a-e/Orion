package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ListItem.kt */
final class ListItemKt$place$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ Placeable $headlinePlaceable;
    final /* synthetic */ int $height;
    final /* synthetic */ boolean $isThreeLine;
    final /* synthetic */ LayoutDirection $layoutDirection;
    final /* synthetic */ Placeable $leadingPlaceable;
    final /* synthetic */ Placeable $overlinePlaceable;
    final /* synthetic */ PaddingValues $paddingValues;
    final /* synthetic */ Placeable $supportingPlaceable;
    final /* synthetic */ MeasureScope $this_place;
    final /* synthetic */ Placeable $trailingPlaceable;
    final /* synthetic */ int $width;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ListItemKt$place$1(MeasureScope measureScope, PaddingValues paddingValues, LayoutDirection layoutDirection, Placeable placeable, Placeable placeable2, boolean z, Placeable placeable3, Placeable placeable4, Placeable placeable5, int i, int i2) {
        super(1);
        this.$this_place = measureScope;
        this.$paddingValues = paddingValues;
        this.$layoutDirection = layoutDirection;
        this.$leadingPlaceable = placeable;
        this.$trailingPlaceable = placeable2;
        this.$isThreeLine = z;
        this.$headlinePlaceable = placeable3;
        this.$overlinePlaceable = placeable4;
        this.$supportingPlaceable = placeable5;
        this.$height = i;
        this.$width = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        int i;
        int i2;
        int r1 = this.$this_place.m6545roundToPx0680j_4(PaddingKt.calculateStartPadding(this.$paddingValues, this.$layoutDirection));
        int r2 = this.$this_place.m6545roundToPx0680j_4(PaddingKt.calculateEndPadding(this.$paddingValues, this.$layoutDirection));
        int r10 = this.$this_place.m6545roundToPx0680j_4(this.$paddingValues.m687calculateTopPaddingD9Ej5fM());
        Placeable placeable = this.$leadingPlaceable;
        if (placeable != null) {
            boolean z = this.$isThreeLine;
            int i3 = this.$height;
            if (z) {
                i2 = r10;
            } else {
                i2 = Alignment.Companion.getCenterVertically().align(placeable.getHeight(), i3);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, r1, i2, 0.0f, 4, (Object) null);
        }
        Placeable placeable2 = this.$trailingPlaceable;
        if (placeable2 != null) {
            int i4 = this.$width;
            boolean z2 = this.$isThreeLine;
            int i5 = this.$height;
            int width = (i4 - r2) - placeable2.getWidth();
            if (z2) {
                i = r10;
            } else {
                i = Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), i5);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, width, i, 0.0f, 4, (Object) null);
        }
        int widthOrZero = r1 + TextFieldImplKt.widthOrZero(this.$leadingPlaceable);
        if (!this.$isThreeLine) {
            r10 = Alignment.Companion.getCenterVertically().align(TextFieldImplKt.heightOrZero(this.$headlinePlaceable) + TextFieldImplKt.heightOrZero(this.$overlinePlaceable) + TextFieldImplKt.heightOrZero(this.$supportingPlaceable), this.$height);
        }
        Placeable placeable3 = this.$overlinePlaceable;
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, widthOrZero, r10, 0.0f, 4, (Object) null);
        }
        int heightOrZero = r10 + TextFieldImplKt.heightOrZero(this.$overlinePlaceable);
        Placeable placeable4 = this.$headlinePlaceable;
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, widthOrZero, heightOrZero, 0.0f, 4, (Object) null);
        }
        int heightOrZero2 = heightOrZero + TextFieldImplKt.heightOrZero(this.$headlinePlaceable);
        Placeable placeable5 = this.$supportingPlaceable;
        if (placeable5 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, widthOrZero, heightOrZero2, 0.0f, 4, (Object) null);
        }
    }
}
