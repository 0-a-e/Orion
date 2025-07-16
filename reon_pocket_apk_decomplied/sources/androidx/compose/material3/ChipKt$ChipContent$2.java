package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Chip.kt */
final class ChipKt$ChipContent$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function2<Composer, Integer, Unit> $avatar;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ long $labelColor;
    final /* synthetic */ TextStyle $labelTextStyle;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ long $leadingIconColor;
    final /* synthetic */ float $minHeight;
    final /* synthetic */ PaddingValues $paddingValues;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;
    final /* synthetic */ long $trailingIconColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChipKt$ChipContent$2(Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, long j, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, long j2, long j3, float f, PaddingValues paddingValues, int i) {
        super(2);
        this.$label = function2;
        this.$labelTextStyle = textStyle;
        this.$labelColor = j;
        this.$leadingIcon = function22;
        this.$avatar = function23;
        this.$trailingIcon = function24;
        this.$leadingIconColor = j2;
        this.$trailingIconColor = j3;
        this.$minHeight = f;
        this.$paddingValues = paddingValues;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ChipKt.m1627ChipContentfe0OD_I(this.$label, this.$labelTextStyle, this.$labelColor, this.$leadingIcon, this.$avatar, this.$trailingIcon, this.$leadingIconColor, this.$trailingIconColor, this.$minHeight, this.$paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
