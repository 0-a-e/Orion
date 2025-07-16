package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Effects.kt */
final class EffectsKt$LaunchedEffect$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EffectsKt$LaunchedEffect$1(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, int i) {
        super(2);
        this.$block = function2;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        EffectsKt.LaunchedEffect(this.$block, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
