package androidx.compose.material3;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: OutlinedTextField.kt */
final class OutlinedTextFieldMeasurePolicy$measure$2 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ Placeable $containerPlaceable;
    final /* synthetic */ Placeable $labelPlaceable;
    final /* synthetic */ Placeable $leadingPlaceable;
    final /* synthetic */ Placeable $placeholderPlaceable;
    final /* synthetic */ Placeable $prefixPlaceable;
    final /* synthetic */ Placeable $suffixPlaceable;
    final /* synthetic */ Placeable $supportingPlaceable;
    final /* synthetic */ Placeable $textFieldPlaceable;
    final /* synthetic */ MeasureScope $this_measure;
    final /* synthetic */ int $totalHeight;
    final /* synthetic */ Placeable $trailingPlaceable;
    final /* synthetic */ int $width;
    final /* synthetic */ OutlinedTextFieldMeasurePolicy this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutlinedTextFieldMeasurePolicy$measure$2(int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, Placeable placeable9, OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy, MeasureScope measureScope) {
        super(1);
        this.$totalHeight = i;
        this.$width = i2;
        this.$leadingPlaceable = placeable;
        this.$trailingPlaceable = placeable2;
        this.$prefixPlaceable = placeable3;
        this.$suffixPlaceable = placeable4;
        this.$textFieldPlaceable = placeable5;
        this.$labelPlaceable = placeable6;
        this.$placeholderPlaceable = placeable7;
        this.$containerPlaceable = placeable8;
        this.$supportingPlaceable = placeable9;
        this.this$0 = outlinedTextFieldMeasurePolicy;
        this.$this_measure = measureScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope placementScope2 = placementScope;
        OutlinedTextFieldKt.place(placementScope, this.$totalHeight, this.$width, this.$leadingPlaceable, this.$trailingPlaceable, this.$prefixPlaceable, this.$suffixPlaceable, this.$textFieldPlaceable, this.$labelPlaceable, this.$placeholderPlaceable, this.$containerPlaceable, this.$supportingPlaceable, this.this$0.animationProgress, this.this$0.singleLine, this.$this_measure.getDensity(), this.$this_measure.getLayoutDirection(), this.this$0.paddingValues);
    }
}
