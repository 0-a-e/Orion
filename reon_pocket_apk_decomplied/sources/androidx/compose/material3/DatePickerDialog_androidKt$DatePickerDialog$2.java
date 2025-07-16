package androidx.compose.material3;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.window.DialogProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePickerDialog.android.kt */
final class DatePickerDialog_androidKt$DatePickerDialog$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ Function2<Composer, Integer, Unit> $confirmButton;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;
    final /* synthetic */ Function2<Composer, Integer, Unit> $dismissButton;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    final /* synthetic */ DialogProperties $properties;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ float $tonalElevation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerDialog_androidKt$DatePickerDialog$2(Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Shape shape, float f, DatePickerColors datePickerColors, DialogProperties dialogProperties, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i, int i2) {
        super(2);
        this.$onDismissRequest = function0;
        this.$confirmButton = function2;
        this.$modifier = modifier;
        this.$dismissButton = function22;
        this.$shape = shape;
        this.$tonalElevation = f;
        this.$colors = datePickerColors;
        this.$properties = dialogProperties;
        this.$content = function3;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        DatePickerDialog_androidKt.m1766DatePickerDialogGmEhDVc(this.$onDismissRequest, this.$confirmButton, this.$modifier, this.$dismissButton, this.$shape, this.$tonalElevation, this.$colors, this.$properties, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
