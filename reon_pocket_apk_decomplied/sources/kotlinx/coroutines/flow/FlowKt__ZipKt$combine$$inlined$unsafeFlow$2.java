package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.internal.CombineKt;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 176)
/* compiled from: SafeCollector.common.kt */
public final class FlowKt__ZipKt$combine$$inlined$unsafeFlow$2 implements Flow<R> {
    final /* synthetic */ Flow[] $flows$inlined;
    final /* synthetic */ Function2 $transform$inlined;

    public FlowKt__ZipKt$combine$$inlined$unsafeFlow$2(Flow[] flowArr, Function2 function2) {
        this.$flows$inlined = flowArr;
        this.$transform$inlined = function2;
    }

    public Object collect(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
        Flow[] flowArr = this.$flows$inlined;
        Intrinsics.needClassReification();
        Intrinsics.needClassReification();
        Object combineInternal = CombineKt.combineInternal(flowCollector, flowArr, new FlowKt__ZipKt$combine$5$1(this.$flows$inlined), new FlowKt__ZipKt$combine$5$2(this.$transform$inlined, (Continuation<? super FlowKt__ZipKt$combine$5$2>) null), continuation);
        return combineInternal == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? combineInternal : Unit.INSTANCE;
    }

    public Object collect$$forInline(FlowCollector flowCollector, Continuation continuation) {
        InlineMarker.mark(4);
        new ContinuationImpl(this, continuation) {
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ FlowKt__ZipKt$combine$$inlined$unsafeFlow$2 this$0;

            {
                this.this$0 = r1;
            }

            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.collect((FlowCollector) null, this);
            }
        };
        InlineMarker.mark(5);
        Flow[] flowArr = this.$flows$inlined;
        Intrinsics.needClassReification();
        Intrinsics.needClassReification();
        InlineMarker.mark(0);
        CombineKt.combineInternal(flowCollector, flowArr, new FlowKt__ZipKt$combine$5$1(this.$flows$inlined), new FlowKt__ZipKt$combine$5$2(this.$transform$inlined, (Continuation<? super FlowKt__ZipKt$combine$5$2>) null), continuation);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
