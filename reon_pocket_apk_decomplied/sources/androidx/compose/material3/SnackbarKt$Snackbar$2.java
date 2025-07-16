package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snackbar.kt */
final class SnackbarKt$Snackbar$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function2<Composer, Integer, Unit> $action;
    final /* synthetic */ long $actionContentColor;
    final /* synthetic */ boolean $actionOnNewLine;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $dismissAction;
    final /* synthetic */ long $dismissActionContentColor;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Shape $shape;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnackbarKt$Snackbar$2(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, boolean z, Shape shape, long j, long j2, long j3, long j4, Function2<? super Composer, ? super Integer, Unit> function23, int i, int i2) {
        super(2);
        this.$modifier = modifier;
        this.$action = function2;
        this.$dismissAction = function22;
        this.$actionOnNewLine = z;
        this.$shape = shape;
        this.$containerColor = j;
        this.$contentColor = j2;
        this.$actionContentColor = j3;
        this.$dismissActionContentColor = j4;
        this.$content = function23;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        Modifier modifier = this.$modifier;
        Modifier modifier2 = modifier;
        SnackbarKt.m2218SnackbareQBnUkQ(modifier2, this.$action, this.$dismissAction, this.$actionOnNewLine, this.$shape, this.$containerColor, this.$contentColor, this.$actionContentColor, this.$dismissActionContentColor, this.$content, composer2, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
