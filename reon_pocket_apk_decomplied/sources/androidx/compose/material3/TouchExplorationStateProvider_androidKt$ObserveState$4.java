package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TouchExplorationStateProvider.android.kt */
final class TouchExplorationStateProvider_androidKt$ObserveState$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function1<Lifecycle.Event, Unit> $handleEvent;
    final /* synthetic */ Function0<Unit> $onDispose;
    final /* synthetic */ Lifecycle $this_ObserveState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TouchExplorationStateProvider_androidKt$ObserveState$4(Lifecycle lifecycle, Function1<? super Lifecycle.Event, Unit> function1, Function0<Unit> function0, int i, int i2) {
        super(2);
        this.$this_ObserveState = lifecycle;
        this.$handleEvent = function1;
        this.$onDispose = function0;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        TouchExplorationStateProvider_androidKt.ObserveState(this.$this_ObserveState, this.$handleEvent, this.$onDispose, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
