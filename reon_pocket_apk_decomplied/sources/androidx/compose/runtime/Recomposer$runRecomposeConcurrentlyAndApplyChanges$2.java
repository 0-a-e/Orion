package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2", f = "Recomposer.kt", i = {0, 0, 0, 1}, l = {840, 860, 861}, m = "invokeSuspend", n = {"recomposeCoroutineScope", "frameSignal", "frameLoop", "frameLoop"}, s = {"L$0", "L$1", "L$2", "L$0"})
/* compiled from: Recomposer.kt */
final class Recomposer$runRecomposeConcurrentlyAndApplyChanges$2 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineContext $recomposeCoroutineContext;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Recomposer$runRecomposeConcurrentlyAndApplyChanges$2(CoroutineContext coroutineContext, Recomposer recomposer, Continuation<? super Recomposer$runRecomposeConcurrentlyAndApplyChanges$2> continuation) {
        super(3, continuation);
        this.$recomposeCoroutineContext = coroutineContext;
        this.this$0 = recomposer;
    }

    public final Object invoke(CoroutineScope coroutineScope, MonotonicFrameClock monotonicFrameClock, Continuation<? super Unit> continuation) {
        Recomposer$runRecomposeConcurrentlyAndApplyChanges$2 recomposer$runRecomposeConcurrentlyAndApplyChanges$2 = new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2(this.$recomposeCoroutineContext, this.this$0, continuation);
        recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$0 = coroutineScope;
        recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$1 = monotonicFrameClock;
        return recomposer$runRecomposeConcurrentlyAndApplyChanges$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0129, code lost:
        r17 = r14;
        r17.compositionInvalidations.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0136, code lost:
        if (r17.deriveStateLocked() != null) goto L_0x0161;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0138, code lost:
        r5 = r1.this$0.stateLock;
        r9 = r1.this$0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0140, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0145, code lost:
        if (r9.getHasConcurrentFrameWorkLocked() == false) goto L_0x014c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0147, code lost:
        r9 = r8.requestFrameLocked();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x014c, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x014d, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x014e, code lost:
        if (r9 == null) goto L_0x015b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0150, code lost:
        r5 = kotlin.Result.Companion;
        r9.resumeWith(kotlin.Result.m7042constructorimpl(kotlin.Unit.INSTANCE));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x015b, code lost:
        r9 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x016c, code lost:
        throw new java.lang.IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0186 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0194 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            r20 = this;
            r1 = r20
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r3 = 3
            r4 = 2
            r6 = 0
            r7 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 == r7) goto L_0x002a
            if (r2 == r4) goto L_0x0021
            if (r2 != r3) goto L_0x0019
            kotlin.ResultKt.throwOnFailure(r21)
            goto L_0x0195
        L_0x0019:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0021:
            java.lang.Object r2 = r1.L$0
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
            kotlin.ResultKt.throwOnFailure(r21)
            goto L_0x0187
        L_0x002a:
            java.lang.Object r2 = r1.L$2
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
            java.lang.Object r8 = r1.L$1
            androidx.compose.runtime.ProduceFrameSignal r8 = (androidx.compose.runtime.ProduceFrameSignal) r8
            java.lang.Object r9 = r1.L$0
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            kotlin.ResultKt.throwOnFailure(r21)
        L_0x0039:
            r15 = r9
            goto L_0x00b0
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r21)
            java.lang.Object r2 = r1.L$0
            r8 = r2
            kotlinx.coroutines.CoroutineScope r8 = (kotlinx.coroutines.CoroutineScope) r8
            java.lang.Object r2 = r1.L$1
            androidx.compose.runtime.MonotonicFrameClock r2 = (androidx.compose.runtime.MonotonicFrameClock) r2
            kotlin.coroutines.CoroutineContext r9 = r1.$recomposeCoroutineContext
            kotlinx.coroutines.Job$Key r10 = kotlinx.coroutines.Job.Key
            kotlin.coroutines.CoroutineContext$Key r10 = (kotlin.coroutines.CoroutineContext.Key) r10
            kotlin.coroutines.CoroutineContext$Element r9 = r9.get(r10)
            if (r9 != 0) goto L_0x0056
            r9 = r7
            goto L_0x0057
        L_0x0056:
            r9 = 0
        L_0x0057:
            kotlin.coroutines.CoroutineContext r10 = r1.$recomposeCoroutineContext
            if (r9 == 0) goto L_0x0198
            kotlin.coroutines.CoroutineContext r9 = r8.getCoroutineContext()
            kotlin.coroutines.CoroutineContext r10 = r1.$recomposeCoroutineContext
            kotlin.coroutines.CoroutineContext r9 = r9.plus(r10)
            kotlin.coroutines.CoroutineContext r10 = r8.getCoroutineContext()
            kotlinx.coroutines.Job r10 = kotlinx.coroutines.JobKt.getJob(r10)
            kotlinx.coroutines.CompletableJob r10 = kotlinx.coroutines.JobKt.Job((kotlinx.coroutines.Job) r10)
            kotlin.coroutines.CoroutineContext r10 = (kotlin.coroutines.CoroutineContext) r10
            kotlin.coroutines.CoroutineContext r9 = r9.plus(r10)
            kotlinx.coroutines.CoroutineScope r14 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r9)
            androidx.compose.runtime.ProduceFrameSignal r15 = new androidx.compose.runtime.ProduceFrameSignal
            r15.<init>()
            androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1 r9 = new androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1
            androidx.compose.runtime.Recomposer r10 = r1.this$0
            r9.<init>(r10, r2, r15, r6)
            r11 = r9
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r12 = 3
            r13 = 0
            r9 = 0
            r10 = 0
            kotlinx.coroutines.Job r2 = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r8, r9, r10, r11, r12, r13)
            r9 = r14
            r8 = r15
        L_0x0094:
            androidx.compose.runtime.Recomposer r10 = r1.this$0
            boolean r10 = r10.getShouldKeepRecomposing()
            if (r10 == 0) goto L_0x016d
            androidx.compose.runtime.Recomposer r10 = r1.this$0
            r11 = r1
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
            r1.L$0 = r9
            r1.L$1 = r8
            r1.L$2 = r2
            r1.label = r7
            java.lang.Object r10 = r10.awaitWorkAvailable(r11)
            if (r10 != r0) goto L_0x0039
            return r0
        L_0x00b0:
            androidx.compose.runtime.Recomposer r14 = r1.this$0
            androidx.compose.runtime.collection.IdentityArraySet r9 = r14.snapshotInvalidations
            boolean r10 = r9.isNotEmpty()
            if (r10 == 0) goto L_0x00de
            java.util.List r10 = r14.getKnownCompositions()
            int r11 = r10.size()
            r12 = 0
        L_0x00c5:
            if (r12 >= r11) goto L_0x00d6
            java.lang.Object r13 = r10.get(r12)
            androidx.compose.runtime.ControlledComposition r13 = (androidx.compose.runtime.ControlledComposition) r13
            r5 = r9
            java.util.Set r5 = (java.util.Set) r5
            r13.recordModificationsOf(r5)
            int r12 = r12 + 1
            goto L_0x00c5
        L_0x00d6:
            androidx.compose.runtime.collection.IdentityArraySet r5 = new androidx.compose.runtime.collection.IdentityArraySet
            r5.<init>()
            r14.snapshotInvalidations = r5
        L_0x00de:
            java.util.List r5 = r14.compositionInvalidations
            int r13 = r5.size()
            r12 = 0
        L_0x00e7:
            if (r12 >= r13) goto L_0x0129
            java.lang.Object r9 = r5.get(r12)
            androidx.compose.runtime.ControlledComposition r9 = (androidx.compose.runtime.ControlledComposition) r9
            java.lang.Object r10 = r14.stateLock
            monitor-enter(r10)
            int r11 = r14.concurrentCompositionsOutstanding     // Catch:{ all -> 0x0126 }
            int r11 = r11 + r7
            r14.concurrentCompositionsOutstanding = r11     // Catch:{ all -> 0x0126 }
            monitor-exit(r10)
            kotlin.coroutines.CoroutineContext r10 = androidx.compose.runtime.CompositionKt.getRecomposeCoroutineContext(r9)
            androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2 r11 = new androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2
            r11.<init>(r14, r9, r6)
            r16 = r11
            kotlin.jvm.functions.Function2 r16 = (kotlin.jvm.functions.Function2) r16
            r17 = 2
            r18 = 0
            r11 = 0
            r9 = r15
            r19 = r12
            r12 = r16
            r16 = r13
            r13 = r17
            r17 = r14
            r14 = r18
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r9, r10, r11, r12, r13, r14)
            int r12 = r19 + 1
            r13 = r16
            r14 = r17
            goto L_0x00e7
        L_0x0126:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        L_0x0129:
            r17 = r14
            java.util.List r5 = r17.compositionInvalidations
            r5.clear()
            kotlinx.coroutines.CancellableContinuation r5 = r17.deriveStateLocked()
            if (r5 != 0) goto L_0x0161
            androidx.compose.runtime.Recomposer r5 = r1.this$0
            java.lang.Object r5 = r5.stateLock
            androidx.compose.runtime.Recomposer r9 = r1.this$0
            monitor-enter(r5)
            boolean r9 = r9.getHasConcurrentFrameWorkLocked()     // Catch:{ all -> 0x015e }
            if (r9 == 0) goto L_0x014c
            kotlin.coroutines.Continuation r9 = r8.requestFrameLocked()     // Catch:{ all -> 0x015e }
            goto L_0x014d
        L_0x014c:
            r9 = r6
        L_0x014d:
            monitor-exit(r5)
            if (r9 == 0) goto L_0x015b
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            java.lang.Object r5 = kotlin.Result.m7042constructorimpl(r5)
            r9.resumeWith(r5)
        L_0x015b:
            r9 = r15
            goto L_0x0094
        L_0x015e:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        L_0x0161:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "called outside of runRecomposeAndApplyChanges"
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x016d:
            kotlin.coroutines.CoroutineContext r5 = r9.getCoroutineContext()
            kotlinx.coroutines.Job r5 = kotlinx.coroutines.JobKt.getJob(r5)
            r7 = r1
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r1.L$0 = r2
            r1.L$1 = r6
            r1.L$2 = r6
            r1.label = r4
            java.lang.Object r4 = kotlinx.coroutines.JobKt.cancelAndJoin(r5, r7)
            if (r4 != r0) goto L_0x0187
            return r0
        L_0x0187:
            r4 = r1
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r1.L$0 = r6
            r1.label = r3
            java.lang.Object r2 = kotlinx.coroutines.JobKt.cancelAndJoin(r2, r4)
            if (r2 != r0) goto L_0x0195
            return r0
        L_0x0195:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0198:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "recomposeCoroutineContext may not contain a Job; found "
            r0.<init>(r2)
            kotlinx.coroutines.Job$Key r2 = kotlinx.coroutines.Job.Key
            kotlin.coroutines.CoroutineContext$Key r2 = (kotlin.coroutines.CoroutineContext.Key) r2
            kotlin.coroutines.CoroutineContext$Element r2 = r10.get(r2)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
