package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.Snapshot;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$recompositionRunner$2", f = "Recomposer.kt", i = {0, 0}, l = {1003}, m = "invokeSuspend", n = {"callingJob", "unregisterApplyObserver"}, s = {"L$0", "L$1"})
/* compiled from: Recomposer.kt */
final class Recomposer$recompositionRunner$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ MonotonicFrameClock $parentFrameClock;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Recomposer$recompositionRunner$2(Recomposer recomposer, Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, MonotonicFrameClock monotonicFrameClock, Continuation<? super Recomposer$recompositionRunner$2> continuation) {
        super(2, continuation);
        this.this$0 = recomposer;
        this.$block = function3;
        this.$parentFrameClock = monotonicFrameClock;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Recomposer$recompositionRunner$2 recomposer$recompositionRunner$2 = new Recomposer$recompositionRunner$2(this.this$0, this.$block, this.$parentFrameClock, continuation);
        recomposer$recompositionRunner$2.L$0 = obj;
        return recomposer$recompositionRunner$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Recomposer$recompositionRunner$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Throwable th;
        Job job;
        ObserverHandle observerHandle;
        List access$getKnownCompositions;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            job = JobKt.getJob(((CoroutineScope) this.L$0).getCoroutineContext());
            this.this$0.registerRunnerJob(job);
            ObserverHandle registerApplyObserver = Snapshot.Companion.registerApplyObserver(new Recomposer$recompositionRunner$2$unregisterApplyObserver$1(this.this$0));
            Recomposer.Companion.addRunning(this.this$0.recomposerInfo);
            try {
                Object access$getStateLock$p = this.this$0.stateLock;
                Recomposer recomposer = this.this$0;
                synchronized (access$getStateLock$p) {
                    access$getKnownCompositions = recomposer.getKnownCompositions();
                }
                int size = access$getKnownCompositions.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((ControlledComposition) access$getKnownCompositions.get(i2)).invalidateAll();
                }
                final Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> function3 = this.$block;
                final MonotonicFrameClock monotonicFrameClock = this.$parentFrameClock;
                this.L$0 = job;
                this.L$1 = registerApplyObserver;
                this.label = 1;
                if (CoroutineScopeKt.coroutineScope(new AnonymousClass3((Continuation<? super AnonymousClass3>) null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                observerHandle = registerApplyObserver;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                observerHandle = registerApplyObserver;
                th = th3;
                observerHandle.dispose();
                Object access$getStateLock$p2 = this.this$0.stateLock;
                Recomposer recomposer2 = this.this$0;
                synchronized (access$getStateLock$p2) {
                    if (recomposer2.runnerJob == job) {
                        recomposer2.runnerJob = null;
                    }
                    CancellableContinuation unused = recomposer2.deriveStateLocked();
                }
                Recomposer.Companion.removeRunning(this.this$0.recomposerInfo);
                throw th;
            }
        } else if (i == 1) {
            observerHandle = (ObserverHandle) this.L$1;
            job = (Job) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th4) {
                th = th4;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        observerHandle.dispose();
        Object access$getStateLock$p3 = this.this$0.stateLock;
        Recomposer recomposer3 = this.this$0;
        synchronized (access$getStateLock$p3) {
            if (recomposer3.runnerJob == job) {
                recomposer3.runnerJob = null;
            }
            CancellableContinuation unused2 = recomposer3.deriveStateLocked();
        }
        Recomposer.Companion.removeRunning(this.this$0.recomposerInfo);
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.Recomposer$recompositionRunner$2$3", f = "Recomposer.kt", i = {}, l = {1004}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.runtime.Recomposer$recompositionRunner$2$3  reason: invalid class name */
    /* compiled from: Recomposer.kt */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 r0 = new AnonymousClass3(function3, monotonicFrameClock, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> function3 = function3;
                MonotonicFrameClock monotonicFrameClock = monotonicFrameClock;
                this.label = 1;
                if (function3.invoke((CoroutineScope) this.L$0, monotonicFrameClock, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }
}
