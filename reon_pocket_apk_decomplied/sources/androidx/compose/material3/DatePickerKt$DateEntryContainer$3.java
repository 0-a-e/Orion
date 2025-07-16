package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$DateEntryContainer$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ float $headerMinHeight;
    final /* synthetic */ Function2<Composer, Integer, Unit> $headline;
    final /* synthetic */ TextStyle $headlineTextStyle;
    final /* synthetic */ Function2<Composer, Integer, Unit> $modeToggleButton;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function2<Composer, Integer, Unit> $title;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$DateEntryContainer$3(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, DatePickerColors datePickerColors, TextStyle textStyle, float f, Function2<? super Composer, ? super Integer, Unit> function24, int i) {
        super(2);
        this.$modifier = modifier;
        this.$title = function2;
        this.$headline = function22;
        this.$modeToggleButton = function23;
        this.$colors = datePickerColors;
        this.$headlineTextStyle = textStyle;
        this.$headerMinHeight = f;
        this.$content = function24;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        DatePickerKt.m1767DateEntryContainerau3_HiA(this.$modifier, this.$title, this.$headline, this.$modeToggleButton, this.$colors, this.$headlineTextStyle, this.$headerMinHeight, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
