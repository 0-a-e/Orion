package androidx.activity.compose;

import androidx.activity.BackEventCompat;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.Flow;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PredictiveBackHandler.kt */
final class PredictiveBackHandlerKt$PredictiveBackHandler$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Flow<BackEventCompat>, Continuation<Unit>, Object> $onBack;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PredictiveBackHandlerKt$PredictiveBackHandler$3(boolean z, Function2<Flow<BackEventCompat>, ? super Continuation<Unit>, ? extends Object> function2, int i, int i2) {
        super(2);
        this.$enabled = z;
        this.$onBack = function2;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        PredictiveBackHandlerKt.PredictiveBackHandler(this.$enabled, this.$onBack, composer, this.$$changed | 1, this.$$default);
    }
}
