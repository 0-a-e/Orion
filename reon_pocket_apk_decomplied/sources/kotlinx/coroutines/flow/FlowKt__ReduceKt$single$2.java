package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: Reduce.kt */
final class FlowKt__ReduceKt$single$2<T> implements FlowCollector {
    final /* synthetic */ Ref.ObjectRef<Object> $result;

    FlowKt__ReduceKt$single$2(Ref.ObjectRef<Object> objectRef) {
        this.$result = objectRef;
    }

    public final Object emit(T t, Continuation<? super Unit> continuation) {
        if (this.$result.element == NullSurrogateKt.NULL) {
            this.$result.element = t;
            return Unit.INSTANCE;
        }
        throw new IllegalArgumentException("Flow has more than one element".toString());
    }
}
