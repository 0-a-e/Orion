package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {215, 418}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "timeoutMillis", "downstream", "values", "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
/* compiled from: Delay.kt */
final class FlowKt__DelayKt$debounceInternal$1 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<T> $this_debounceInternal;
    final /* synthetic */ Function1<T, Long> $timeoutMillisSelector;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$debounceInternal$1(Function1<? super T, Long> function1, Flow<? extends T> flow, Continuation<? super FlowKt__DelayKt$debounceInternal$1> continuation) {
        super(3, continuation);
        this.$timeoutMillisSelector = function1;
        this.$this_debounceInternal = flow;
    }

    public final Object invoke(CoroutineScope coroutineScope, FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new FlowKt__DelayKt$debounceInternal$1(this.$timeoutMillisSelector, this.$this_debounceInternal, continuation);
        flowKt__DelayKt$debounceInternal$1.L$0 = coroutineScope;
        flowKt__DelayKt$debounceInternal$1.L$1 = flowCollector;
        return flowKt__DelayKt$debounceInternal$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0115 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            r2 = 2
            r3 = 1
            r4 = 0
            r6 = 0
            if (r1 == 0) goto L_0x0041
            if (r1 == r3) goto L_0x002c
            if (r1 != r2) goto L_0x0024
            java.lang.Object r1 = r13.L$2
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r7 = r13.L$1
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r8 = r13.L$0
            kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
            kotlin.ResultKt.throwOnFailure(r14)
        L_0x0020:
            r9 = r8
            r8 = r7
            r7 = r1
            goto L_0x0066
        L_0x0024:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x002c:
            java.lang.Object r1 = r13.L$3
            kotlin.jvm.internal.Ref$LongRef r1 = (kotlin.jvm.internal.Ref.LongRef) r1
            java.lang.Object r7 = r13.L$2
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            java.lang.Object r8 = r13.L$1
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            java.lang.Object r9 = r13.L$0
            kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00b1
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r14)
            java.lang.Object r14 = r13.L$0
            r7 = r14
            kotlinx.coroutines.CoroutineScope r7 = (kotlinx.coroutines.CoroutineScope) r7
            java.lang.Object r14 = r13.L$1
            kotlinx.coroutines.flow.FlowCollector r14 = (kotlinx.coroutines.flow.FlowCollector) r14
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1 r1 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1
            kotlinx.coroutines.flow.Flow<T> r8 = r13.$this_debounceInternal
            r1.<init>(r8, r6)
            r10 = r1
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r11 = 3
            r12 = 0
            r8 = 0
            r9 = 0
            kotlinx.coroutines.channels.ReceiveChannel r1 = kotlinx.coroutines.channels.ProduceKt.produce$default(r7, r8, r9, r10, r11, r12)
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            r9 = r14
            r8 = r1
        L_0x0066:
            T r14 = r7.element
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.flow.internal.NullSurrogateKt.DONE
            if (r14 == r1) goto L_0x0116
            kotlin.jvm.internal.Ref$LongRef r1 = new kotlin.jvm.internal.Ref$LongRef
            r1.<init>()
            T r14 = r7.element
            if (r14 == 0) goto L_0x00b3
            kotlin.jvm.functions.Function1<T, java.lang.Long> r14 = r13.$timeoutMillisSelector
            kotlinx.coroutines.internal.Symbol r10 = kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL
            T r11 = r7.element
            if (r11 != r10) goto L_0x007e
            r11 = r6
        L_0x007e:
            java.lang.Object r14 = r14.invoke(r11)
            java.lang.Number r14 = (java.lang.Number) r14
            long r10 = r14.longValue()
            r1.element = r10
            long r10 = r1.element
            int r14 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r14 < 0) goto L_0x00b8
            long r10 = r1.element
            int r14 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r14 != 0) goto L_0x00b3
            kotlinx.coroutines.internal.Symbol r14 = kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL
            T r10 = r7.element
            if (r10 != r14) goto L_0x009d
            r10 = r6
        L_0x009d:
            r14 = r13
            kotlin.coroutines.Continuation r14 = (kotlin.coroutines.Continuation) r14
            r13.L$0 = r9
            r13.L$1 = r8
            r13.L$2 = r7
            r13.L$3 = r1
            r13.label = r3
            java.lang.Object r14 = r9.emit(r10, r14)
            if (r14 != r0) goto L_0x00b1
            return r0
        L_0x00b1:
            r7.element = r6
        L_0x00b3:
            r14 = r1
            r1 = r7
            r7 = r8
            r8 = r9
            goto L_0x00c4
        L_0x00b8:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Debounce timeout should not be negative"
            java.lang.String r0 = r0.toString()
            r14.<init>(r0)
            throw r14
        L_0x00c4:
            boolean r9 = kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED()
            if (r9 == 0) goto L_0x00db
            T r9 = r1.element
            if (r9 == 0) goto L_0x00db
            long r9 = r14.element
            int r9 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r9 <= 0) goto L_0x00d5
            goto L_0x00db
        L_0x00d5:
            java.lang.AssertionError r14 = new java.lang.AssertionError
            r14.<init>()
            throw r14
        L_0x00db:
            kotlinx.coroutines.selects.SelectImplementation r9 = new kotlinx.coroutines.selects.SelectImplementation
            kotlin.coroutines.CoroutineContext r10 = r13.getContext()
            r9.<init>(r10)
            r10 = r9
            kotlinx.coroutines.selects.SelectBuilder r10 = (kotlinx.coroutines.selects.SelectBuilder) r10
            T r11 = r1.element
            if (r11 == 0) goto L_0x00f7
            long r11 = r14.element
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1 r14 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1
            r14.<init>(r8, r1, r6)
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            kotlinx.coroutines.selects.OnTimeoutKt.onTimeout(r10, r11, r14)
        L_0x00f7:
            kotlinx.coroutines.selects.SelectClause1 r14 = r7.getOnReceiveCatching()
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2 r11 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2
            r11.<init>(r1, r8, r6)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.invoke(r14, r11)
            r13.L$0 = r8
            r13.L$1 = r7
            r13.L$2 = r1
            r13.L$3 = r6
            r13.label = r2
            java.lang.Object r14 = r9.doSelect(r13)
            if (r14 != r0) goto L_0x0020
            return r0
        L_0x0116:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
