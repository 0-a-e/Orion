package kotlinx.coroutines.flow;

import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\b\u0012\u0004\u0012\u0002H\u00010\u0006B\r\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001c\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H@¢\u0006\u0002\u0010\u001aJ\u001d\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u0003H\u0014J\u001d\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\"2\u0006\u0010#\u001a\u00020\u0011H\u0014¢\u0006\u0002\u0010$J\u0016\u0010%\u001a\u00020&2\u0006\u0010\u0012\u001a\u00028\u0000H@¢\u0006\u0002\u0010'J&\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020&H\u0016J\u0015\u00100\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\u001a\u00102\u001a\u00020\u001c2\b\u00103\u001a\u0004\u0018\u00010\b2\u0006\u00104\u001a\u00020\bH\u0002R\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000bX\u0004R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u00008V@VX\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\t¨\u00065"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "initialState", "", "(Ljava/lang/Object;)V", "_state", "Lkotlinx/atomicfu/AtomicRef;", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "sequence", "", "value", "getValue", "()Ljava/lang/Object;", "setValue", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compareAndSet", "", "expect", "update", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "createSlot", "createSlotArray", "", "size", "(I)[Lkotlinx/coroutines/flow/StateFlowSlot;", "emit", "", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fuse", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "resetReplayCache", "tryEmit", "(Ljava/lang/Object;)Z", "updateState", "expectedState", "newState", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: StateFlow.kt */
final class StateFlowImpl<T> extends AbstractSharedFlow<StateFlowSlot> implements MutableStateFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    /* access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater _state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;
    private int sequence;

    private final /* synthetic */ Object get_state$volatile() {
        return this._state$volatile;
    }

    private final /* synthetic */ void set_state$volatile(Object obj) {
        this._state$volatile = obj;
    }

    public StateFlowImpl(Object obj) {
        this._state$volatile = obj;
    }

    public T getValue() {
        T t = NullSurrogateKt.NULL;
        T t2 = _state$volatile$FU.get(this);
        if (t2 == t) {
            return null;
        }
        return t2;
    }

    public void setValue(T t) {
        if (t == null) {
            t = NullSurrogateKt.NULL;
        }
        updateState((Object) null, t);
    }

    public boolean compareAndSet(T t, T t2) {
        if (t == null) {
            t = NullSurrogateKt.NULL;
        }
        if (t2 == null) {
            t2 = NullSurrogateKt.NULL;
        }
        return updateState(t, t2);
    }

    public List<T> getReplayCache() {
        return CollectionsKt.listOf(getValue());
    }

    public boolean tryEmit(T t) {
        setValue(t);
        return true;
    }

    public Object emit(T t, Continuation<? super Unit> continuation) {
        setValue(t);
        return Unit.INSTANCE;
    }

    public void resetReplayCache() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: kotlinx.coroutines.flow.StateFlowSlot} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: kotlinx.coroutines.flow.StateFlowImpl} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b3 A[Catch:{ all -> 0x0074 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c2 A[Catch:{ all -> 0x0074 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c4 A[Catch:{ all -> 0x0074 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d7 A[Catch:{ all -> 0x0074 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d8 A[Catch:{ all -> 0x0074 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00df A[Catch:{ all -> 0x0074 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector<? super T> r11, kotlin.coroutines.Continuation<?> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof kotlinx.coroutines.flow.StateFlowImpl$collect$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            kotlinx.coroutines.flow.StateFlowImpl$collect$1 r0 = (kotlinx.coroutines.flow.StateFlowImpl$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.flow.StateFlowImpl$collect$1 r0 = new kotlinx.coroutines.flow.StateFlowImpl$collect$1
            r0.<init>(r10, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0077
            if (r2 == r6) goto L_0x0062
            if (r2 == r5) goto L_0x004b
            if (r2 != r4) goto L_0x0043
            java.lang.Object r11 = r0.L$4
            java.lang.Object r2 = r0.L$3
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.flow.StateFlowSlot r6 = (kotlinx.coroutines.flow.StateFlowSlot) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.flow.StateFlowImpl r8 = (kotlinx.coroutines.flow.StateFlowImpl) r8
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0074 }
            goto L_0x00a9
        L_0x0043:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x004b:
            java.lang.Object r11 = r0.L$4
            java.lang.Object r2 = r0.L$3
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.flow.StateFlowSlot r6 = (kotlinx.coroutines.flow.StateFlowSlot) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.flow.StateFlowImpl r8 = (kotlinx.coroutines.flow.StateFlowImpl) r8
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0074 }
            goto L_0x00d9
        L_0x0062:
            java.lang.Object r11 = r0.L$2
            r6 = r11
            kotlinx.coroutines.flow.StateFlowSlot r6 = (kotlinx.coroutines.flow.StateFlowSlot) r6
            java.lang.Object r11 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
            java.lang.Object r2 = r0.L$0
            r8 = r2
            kotlinx.coroutines.flow.StateFlowImpl r8 = (kotlinx.coroutines.flow.StateFlowImpl) r8
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0074 }
            goto L_0x0098
        L_0x0074:
            r11 = move-exception
            goto L_0x00f5
        L_0x0077:
            kotlin.ResultKt.throwOnFailure(r12)
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot r12 = r10.allocateSlot()
            kotlinx.coroutines.flow.StateFlowSlot r12 = (kotlinx.coroutines.flow.StateFlowSlot) r12
            boolean r2 = r11 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector     // Catch:{ all -> 0x00f2 }
            if (r2 == 0) goto L_0x0096
            r2 = r11
            kotlinx.coroutines.flow.SubscribedFlowCollector r2 = (kotlinx.coroutines.flow.SubscribedFlowCollector) r2     // Catch:{ all -> 0x00f2 }
            r0.L$0 = r10     // Catch:{ all -> 0x00f2 }
            r0.L$1 = r11     // Catch:{ all -> 0x00f2 }
            r0.L$2 = r12     // Catch:{ all -> 0x00f2 }
            r0.label = r6     // Catch:{ all -> 0x00f2 }
            java.lang.Object r2 = r2.onSubscription(r0)     // Catch:{ all -> 0x00f2 }
            if (r2 != r1) goto L_0x0096
            return r1
        L_0x0096:
            r8 = r10
            r6 = r12
        L_0x0098:
            kotlin.coroutines.CoroutineContext r12 = r0.getContext()     // Catch:{ all -> 0x0074 }
            kotlinx.coroutines.Job$Key r2 = kotlinx.coroutines.Job.Key     // Catch:{ all -> 0x0074 }
            kotlin.coroutines.CoroutineContext$Key r2 = (kotlin.coroutines.CoroutineContext.Key) r2     // Catch:{ all -> 0x0074 }
            kotlin.coroutines.CoroutineContext$Element r12 = r12.get(r2)     // Catch:{ all -> 0x0074 }
            kotlinx.coroutines.Job r12 = (kotlinx.coroutines.Job) r12     // Catch:{ all -> 0x0074 }
            r7 = r11
            r2 = r12
            r11 = r3
        L_0x00a9:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = _state$volatile$FU     // Catch:{ all -> 0x0074 }
            java.lang.Object r12 = r12.get(r8)     // Catch:{ all -> 0x0074 }
            if (r2 == 0) goto L_0x00b6
            kotlinx.coroutines.JobKt.ensureActive((kotlinx.coroutines.Job) r2)     // Catch:{ all -> 0x0074 }
        L_0x00b6:
            if (r11 == 0) goto L_0x00be
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r12)     // Catch:{ all -> 0x0074 }
            if (r9 != 0) goto L_0x00d9
        L_0x00be:
            kotlinx.coroutines.internal.Symbol r11 = kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL     // Catch:{ all -> 0x0074 }
            if (r12 != r11) goto L_0x00c4
            r11 = r3
            goto L_0x00c5
        L_0x00c4:
            r11 = r12
        L_0x00c5:
            r0.L$0 = r8     // Catch:{ all -> 0x0074 }
            r0.L$1 = r7     // Catch:{ all -> 0x0074 }
            r0.L$2 = r6     // Catch:{ all -> 0x0074 }
            r0.L$3 = r2     // Catch:{ all -> 0x0074 }
            r0.L$4 = r12     // Catch:{ all -> 0x0074 }
            r0.label = r5     // Catch:{ all -> 0x0074 }
            java.lang.Object r11 = r7.emit(r11, r0)     // Catch:{ all -> 0x0074 }
            if (r11 != r1) goto L_0x00d8
            return r1
        L_0x00d8:
            r11 = r12
        L_0x00d9:
            boolean r12 = r6.takePending()     // Catch:{ all -> 0x0074 }
            if (r12 != 0) goto L_0x00a9
            r0.L$0 = r8     // Catch:{ all -> 0x0074 }
            r0.L$1 = r7     // Catch:{ all -> 0x0074 }
            r0.L$2 = r6     // Catch:{ all -> 0x0074 }
            r0.L$3 = r2     // Catch:{ all -> 0x0074 }
            r0.L$4 = r11     // Catch:{ all -> 0x0074 }
            r0.label = r4     // Catch:{ all -> 0x0074 }
            java.lang.Object r12 = r6.awaitPending(r0)     // Catch:{ all -> 0x0074 }
            if (r12 != r1) goto L_0x00a9
            return r1
        L_0x00f2:
            r11 = move-exception
            r8 = r10
            r6 = r12
        L_0x00f5:
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot r6 = (kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot) r6
            r8.freeSlot(r6)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public StateFlowSlot createSlot() {
        return new StateFlowSlot();
    }

    /* access modifiers changed from: protected */
    public StateFlowSlot[] createSlotArray(int i) {
        return new StateFlowSlot[i];
    }

    public Flow<T> fuse(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return StateFlowKt.fuseStateFlow(this, coroutineContext, i, bufferOverflow);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
        r8 = (kotlinx.coroutines.flow.StateFlowSlot[]) r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0036, code lost:
        if (r8 == null) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0038, code lost:
        r2 = r8.length;
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
        if (r3 >= r2) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003c, code lost:
        r4 = r8[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003e, code lost:
        if (r4 == null) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
        r4.makePending();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0043, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0046, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r8 = r6.sequence;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0049, code lost:
        if (r8 != r7) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004b, code lost:
        r6.sequence = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004e, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x004f, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r7 = getSlots();
        r2 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0056, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0057, code lost:
        r5 = r8;
        r8 = r7;
        r7 = r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean updateState(java.lang.Object r7, java.lang.Object r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = _state$volatile$FU     // Catch:{ all -> 0x0064 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0064 }
            r1 = 0
            if (r7 == 0) goto L_0x0014
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r7)     // Catch:{ all -> 0x0064 }
            if (r7 != 0) goto L_0x0014
            monitor-exit(r6)
            return r1
        L_0x0014:
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r8)     // Catch:{ all -> 0x0064 }
            r0 = 1
            if (r7 == 0) goto L_0x001d
            monitor-exit(r6)
            return r0
        L_0x001d:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = _state$volatile$FU     // Catch:{ all -> 0x0064 }
            r7.set(r6, r8)     // Catch:{ all -> 0x0064 }
            int r7 = r6.sequence     // Catch:{ all -> 0x0064 }
            r8 = r7 & 1
            if (r8 != 0) goto L_0x005e
            int r7 = r7 + r0
            r6.sequence = r7     // Catch:{ all -> 0x0064 }
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] r8 = r6.getSlots()     // Catch:{ all -> 0x0064 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0064 }
            monitor-exit(r6)
        L_0x0034:
            kotlinx.coroutines.flow.StateFlowSlot[] r8 = (kotlinx.coroutines.flow.StateFlowSlot[]) r8
            if (r8 == 0) goto L_0x0046
            int r2 = r8.length
            r3 = r1
        L_0x003a:
            if (r3 >= r2) goto L_0x0046
            r4 = r8[r3]
            if (r4 == 0) goto L_0x0043
            r4.makePending()
        L_0x0043:
            int r3 = r3 + 1
            goto L_0x003a
        L_0x0046:
            monitor-enter(r6)
            int r8 = r6.sequence     // Catch:{ all -> 0x005b }
            if (r8 != r7) goto L_0x0050
            int r7 = r7 + r0
            r6.sequence = r7     // Catch:{ all -> 0x005b }
            monitor-exit(r6)
            return r0
        L_0x0050:
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] r7 = r6.getSlots()     // Catch:{ all -> 0x005b }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005b }
            monitor-exit(r6)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L_0x0034
        L_0x005b:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        L_0x005e:
            int r7 = r7 + 2
            r6.sequence = r7     // Catch:{ all -> 0x0064 }
            monitor-exit(r6)
            return r0
        L_0x0064:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.updateState(java.lang.Object, java.lang.Object):boolean");
    }
}
