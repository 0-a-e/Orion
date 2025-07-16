package androidx.compose.material3;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextField.kt */
final class TextFieldMeasurePolicy$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ Placeable $containerPlaceable;
    final /* synthetic */ Placeable $labelPlaceable;
    final /* synthetic */ Placeable $leadingPlaceable;
    final /* synthetic */ Placeable $placeholderPlaceable;
    final /* synthetic */ Placeable $prefixPlaceable;
    final /* synthetic */ Placeable $suffixPlaceable;
    final /* synthetic */ Placeable $supportingPlaceable;
    final /* synthetic */ Placeable $textFieldPlaceable;
    final /* synthetic */ MeasureScope $this_measure;
    final /* synthetic */ int $topPaddingValue;
    final /* synthetic */ int $totalHeight;
    final /* synthetic */ Placeable $trailingPlaceable;
    final /* synthetic */ int $width;
    final /* synthetic */ TextFieldMeasurePolicy this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldMeasurePolicy$measure$1(Placeable placeable, int i, int i2, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, Placeable placeable9, TextFieldMeasurePolicy textFieldMeasurePolicy, int i3, MeasureScope measureScope) {
        super(1);
        this.$labelPlaceable = placeable;
        this.$width = i;
        this.$totalHeight = i2;
        this.$textFieldPlaceable = placeable2;
        this.$placeholderPlaceable = placeable3;
        this.$leadingPlaceable = placeable4;
        this.$trailingPlaceable = placeable5;
        this.$prefixPlaceable = placeable6;
        this.$suffixPlaceable = placeable7;
        this.$containerPlaceable = placeable8;
        this.$supportingPlaceable = placeable9;
        this.this$0 = textFieldMeasurePolicy;
        this.$topPaddingValue = i3;
        this.$this_measure = measureScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Placeable placeable = this.$labelPlaceable;
        if (placeable != null) {
            int i = this.$width;
            int i2 = this.$totalHeight;
            Placeable placeable2 = this.$textFieldPlaceable;
            Placeable placeable3 = this.$placeholderPlaceable;
            Placeable placeable4 = this.$leadingPlaceable;
            Placeable placeable5 = this.$trailingPlaceable;
            Placeable placeable6 = this.$prefixPlaceable;
            Placeable placeable7 = this.$suffixPlaceable;
            Placeable placeable8 = this.$containerPlaceable;
            Placeable placeable9 = this.$supportingPlaceable;
            boolean access$getSingleLine$p = this.this$0.singleLine;
            int i3 = this.$topPaddingValue;
            TextFieldKt.placeWithLabel(placementScope, i, i2, placeable2, placeable, placeable3, placeable4, placeable5, placeable6, placeable7, placeable8, placeable9, access$getSingleLine$p, i3, this.$labelPlaceable.getHeight() + i3, this.this$0.animationProgress, this.$this_measure.getDensity());
            return;
        }
        int i4 = this.$width;
        int i5 = this.$totalHeight;
        Placeable placeable10 = this.$textFieldPlaceable;
        Placeable placeable11 = this.$placeholderPlaceable;
        Placeable placeable12 = this.$leadingPlaceable;
        Placeable placeable13 = this.$trailingPlaceable;
        Placeable placeable14 = this.$prefixPlaceable;
        Placeable placeable15 = this.$suffixPlaceable;
        Placeable placeable16 = this.$containerPlaceable;
        TextFieldKt.placeWithoutLabel(placementScope, i4, i5, placeable10, placeable11, placeable12, placeable13, placeable14, placeable15, placeable16, this.$supportingPlaceable, this.this$0.singleLine, this.$this_measure.getDensity(), this.this$0.paddingValues);
    }
}
