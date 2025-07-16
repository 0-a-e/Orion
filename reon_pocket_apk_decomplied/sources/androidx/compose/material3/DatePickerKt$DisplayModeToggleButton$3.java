package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$DisplayModeToggleButton$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $displayMode;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<DisplayMode, Unit> $onDisplayModeChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$DisplayModeToggleButton$3(Modifier modifier, int i, Function1<? super DisplayMode, Unit> function1, int i2) {
        super(2);
        this.$modifier = modifier;
        this.$displayMode = i;
        this.$onDisplayModeChange = function1;
        this.$$changed = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        DatePickerKt.m1771DisplayModeToggleButtontER2X8s(this.$modifier, this.$displayMode, this.$onDisplayModeChange, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
