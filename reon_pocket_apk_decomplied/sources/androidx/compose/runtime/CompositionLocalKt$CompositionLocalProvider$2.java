package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CompositionLocal.kt */
final class CompositionLocalKt$CompositionLocalProvider$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ ProvidedValue<?> $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CompositionLocalKt$CompositionLocalProvider$2(ProvidedValue<?> providedValue, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$value = providedValue;
        this.$content = function2;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        CompositionLocalKt.CompositionLocalProvider(this.$value, (Function2<? super Composer, ? super Integer, Unit>) this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
