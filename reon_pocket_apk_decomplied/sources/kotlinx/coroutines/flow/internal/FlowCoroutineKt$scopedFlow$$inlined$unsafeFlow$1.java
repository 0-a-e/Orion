package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SafeCollector.common.kt */
public final class FlowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1 implements Flow<R> {
    final /* synthetic */ Function3 $block$inlined;

    public FlowCoroutineKt$scopedFlow$$inlined$unsafeFlow$1(Function3 function3) {
        this.$block$inlined = function3;
    }

    public Object collect(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
        Object flowScope = FlowCoroutineKt.flowScope(new FlowCoroutineKt$scopedFlow$1$1(this.$block$inlined, flowCollector, (Continuation<? super FlowCoroutineKt$scopedFlow$1$1>) null), continuation);
        return flowScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? flowScope : Unit.INSTANCE;
    }
}
