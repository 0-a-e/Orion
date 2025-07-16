package jp.co.sony.reonpocket.connection.log.logcat;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: LogCatLogActivity.kt */
final class LogCatLogActivityKt$Content$8 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ LogCatLogPresenter $presenter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LogCatLogActivityKt$Content$8(LogCatLogPresenter logCatLogPresenter, int i) {
        super(2);
        this.$presenter = logCatLogPresenter;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        LogCatLogActivityKt.Content(this.$presenter, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
