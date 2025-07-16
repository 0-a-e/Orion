package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AlignmentLine.kt */
final class AlignmentLineKt$alignmentLineOffsetMeasure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ AlignmentLine $alignmentLine;
    final /* synthetic */ float $before;
    final /* synthetic */ int $height;
    final /* synthetic */ int $paddingAfter;
    final /* synthetic */ int $paddingBefore;
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ int $width;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AlignmentLineKt$alignmentLineOffsetMeasure$1(AlignmentLine alignmentLine, float f, int i, int i2, int i3, Placeable placeable, int i4) {
        super(1);
        this.$alignmentLine = alignmentLine;
        this.$before = f;
        this.$paddingBefore = i;
        this.$width = i2;
        this.$paddingAfter = i3;
        this.$placeable = placeable;
        this.$height = i4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        int i;
        int i2;
        int i3 = 0;
        if (AlignmentLineKt.getHorizontal(this.$alignmentLine)) {
            i = 0;
        } else {
            if (!Dp.m6619equalsimpl0(this.$before, Dp.Companion.m6634getUnspecifiedD9Ej5fM())) {
                i2 = this.$paddingBefore;
            } else {
                i2 = (this.$width - this.$paddingAfter) - this.$placeable.getWidth();
            }
            i = i2;
        }
        if (AlignmentLineKt.getHorizontal(this.$alignmentLine)) {
            if (!Dp.m6619equalsimpl0(this.$before, Dp.Companion.m6634getUnspecifiedD9Ej5fM())) {
                i3 = this.$paddingBefore;
            } else {
                i3 = (this.$height - this.$paddingAfter) - this.$placeable.getHeight();
            }
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, this.$placeable, i, i3, 0.0f, 4, (Object) null);
    }
}
