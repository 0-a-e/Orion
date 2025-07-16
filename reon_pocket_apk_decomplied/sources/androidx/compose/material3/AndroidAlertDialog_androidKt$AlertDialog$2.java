package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.window.DialogProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidAlertDialog.android.kt */
final class AndroidAlertDialog_androidKt$AlertDialog$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function2<Composer, Integer, Unit> $confirmButton;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $dismissButton;
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ long $iconContentColor;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    final /* synthetic */ DialogProperties $properties;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;
    final /* synthetic */ long $textContentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $title;
    final /* synthetic */ long $titleContentColor;
    final /* synthetic */ float $tonalElevation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidAlertDialog_androidKt$AlertDialog$2(Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Shape shape, long j, long j2, long j3, long j4, float f, DialogProperties dialogProperties, int i, int i2, int i3) {
        super(2);
        this.$onDismissRequest = function0;
        this.$confirmButton = function2;
        this.$modifier = modifier;
        this.$dismissButton = function22;
        this.$icon = function23;
        this.$title = function24;
        this.$text = function25;
        this.$shape = shape;
        this.$containerColor = j;
        this.$iconContentColor = j2;
        this.$titleContentColor = j3;
        this.$textContentColor = j4;
        this.$tonalElevation = f;
        this.$properties = dialogProperties;
        this.$$changed = i;
        this.$$changed1 = i2;
        this.$$default = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        Function0<Unit> function0 = this.$onDismissRequest;
        Function0<Unit> function02 = function0;
        AndroidAlertDialog_androidKt.m1504AlertDialogOix01E0(function02, this.$confirmButton, this.$modifier, this.$dismissButton, this.$icon, this.$title, this.$text, this.$shape, this.$containerColor, this.$iconContentColor, this.$titleContentColor, this.$textContentColor, this.$tonalElevation, this.$properties, composer2, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
    }
}
