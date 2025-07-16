package androidx.compose.material3;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$ToggleItem$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ boolean $checked;
    final /* synthetic */ TimePickerColors $colors;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $content;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ Shape $shape;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$ToggleItem$2(boolean z, Shape shape, Function0<Unit> function0, TimePickerColors timePickerColors, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i) {
        super(2);
        this.$checked = z;
        this.$shape = shape;
        this.$onClick = function0;
        this.$colors = timePickerColors;
        this.$content = function3;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        TimePickerKt.ToggleItem(this.$checked, this.$shape, this.$onClick, this.$colors, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
