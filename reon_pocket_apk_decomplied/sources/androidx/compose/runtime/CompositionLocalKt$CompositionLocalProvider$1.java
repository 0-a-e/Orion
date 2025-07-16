package androidx.compose.runtime;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CompositionLocal.kt */
final class CompositionLocalKt$CompositionLocalProvider$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ ProvidedValue<?>[] $values;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CompositionLocalKt$CompositionLocalProvider$1(ProvidedValue<?>[] providedValueArr, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$values = providedValueArr;
        this.$content = function2;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ProvidedValue<?>[] providedValueArr = this.$values;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) (ProvidedValue[]) Arrays.copyOf(providedValueArr, providedValueArr.length), (Function2<? super Composer, ? super Integer, Unit>) this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
