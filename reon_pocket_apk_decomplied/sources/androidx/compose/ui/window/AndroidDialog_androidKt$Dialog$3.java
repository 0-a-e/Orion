package androidx.compose.ui.window;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidDialog.android.kt */
final class AndroidDialog_androidKt$Dialog$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    final /* synthetic */ DialogProperties $properties;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidDialog_androidKt$Dialog$3(Function0<Unit> function0, DialogProperties dialogProperties, Function2<? super Composer, ? super Integer, Unit> function2, int i, int i2) {
        super(2);
        this.$onDismissRequest = function0;
        this.$properties = dialogProperties;
        this.$content = function2;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        AndroidDialog_androidKt.Dialog(this.$onDismissRequest, this.$properties, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
