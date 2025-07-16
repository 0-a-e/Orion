package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$DatePickerHeader$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ long $headlineContentColor;
    final /* synthetic */ float $minHeight;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function2<Composer, Integer, Unit> $title;
    final /* synthetic */ long $titleContentColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$DatePickerHeader$2(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, long j, long j2, float f, Function2<? super Composer, ? super Integer, Unit> function22, int i) {
        super(2);
        this.$modifier = modifier;
        this.$title = function2;
        this.$titleContentColor = j;
        this.$headlineContentColor = j2;
        this.$minHeight = f;
        this.$content = function22;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        DatePickerKt.m1768DatePickerHeaderpc5RIQQ(this.$modifier, this.$title, this.$titleContentColor, this.$headlineContentColor, this.$minHeight, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
