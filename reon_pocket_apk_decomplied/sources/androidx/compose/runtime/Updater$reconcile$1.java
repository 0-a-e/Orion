package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0002H\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "it", "invoke", "(Ljava/lang/Object;Lkotlin/Unit;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Composer.kt */
final class Updater$reconcile$1 extends Lambda implements Function2<T, Unit, Unit> {
    final /* synthetic */ Function1<T, Unit> $block;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Updater$reconcile$1(Function1<? super T, Unit> function1) {
        super(2);
        this.$block = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(obj, (Unit) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(T t, Unit unit) {
        this.$block.invoke(t);
    }
}
