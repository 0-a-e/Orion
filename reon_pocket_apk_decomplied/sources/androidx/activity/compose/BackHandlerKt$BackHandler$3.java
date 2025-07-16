package androidx.activity.compose;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BackHandler.kt */
final class BackHandlerKt$BackHandler$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function0<Unit> $onBack;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BackHandlerKt$BackHandler$3(boolean z, Function0<Unit> function0, int i, int i2) {
        super(2);
        this.$enabled = z;
        this.$onBack = function0;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        BackHandlerKt.BackHandler(this.$enabled, this.$onBack, composer, this.$$changed | 1, this.$$default);
    }
}
