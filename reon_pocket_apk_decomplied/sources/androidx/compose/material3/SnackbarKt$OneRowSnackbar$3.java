package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snackbar.kt */
final class SnackbarKt$OneRowSnackbar$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function2<Composer, Integer, Unit> $action;
    final /* synthetic */ long $actionTextColor;
    final /* synthetic */ TextStyle $actionTextStyle;
    final /* synthetic */ Function2<Composer, Integer, Unit> $dismissAction;
    final /* synthetic */ long $dismissActionColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnackbarKt$OneRowSnackbar$3(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, TextStyle textStyle, long j, long j2, int i) {
        super(2);
        this.$text = function2;
        this.$action = function22;
        this.$dismissAction = function23;
        this.$actionTextStyle = textStyle;
        this.$actionTextColor = j;
        this.$dismissActionColor = j2;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        SnackbarKt.m2217OneRowSnackbarkKq0p4A(this.$text, this.$action, this.$dismissAction, this.$actionTextStyle, this.$actionTextColor, this.$dismissActionColor, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
