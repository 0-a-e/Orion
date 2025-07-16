package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Chip.kt */
final class ChipKt$SelectableChip$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $avatar;
    final /* synthetic */ SelectableChipColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ TextStyle $labelTextStyle;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ float $minHeight;
    final /* synthetic */ PaddingValues $paddingValues;
    final /* synthetic */ boolean $selected;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChipKt$SelectableChip$2(SelectableChipColors selectableChipColors, boolean z, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, float f, PaddingValues paddingValues) {
        super(2);
        this.$colors = selectableChipColors;
        this.$enabled = z;
        this.$selected = z2;
        this.$label = function2;
        this.$labelTextStyle = textStyle;
        this.$leadingIcon = function22;
        this.$avatar = function23;
        this.$trailingIcon = function24;
        this.$minHeight = f;
        this.$paddingValues = paddingValues;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        int i2 = i;
        ComposerKt.sourceInformation(composer, "C1920@95178L509:Chip.kt#uh7d8r");
        if ((i2 & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-577614814, i2, -1, "androidx.compose.material3.SelectableChip.<anonymous> (Chip.kt:1920)");
            }
            ChipKt.m1627ChipContentfe0OD_I(this.$label, this.$labelTextStyle, this.$colors.m2149labelColorWaAFU9c$material3_release(this.$enabled, this.$selected), this.$leadingIcon, this.$avatar, this.$trailingIcon, this.$colors.m2150leadingIconContentColorWaAFU9c$material3_release(this.$enabled, this.$selected), this.$colors.m2151trailingIconContentColorWaAFU9c$material3_release(this.$enabled, this.$selected), this.$minHeight, this.$paddingValues, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
