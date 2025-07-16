package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H@¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tJ\u0006\u0010\n\u001a\u00020\u0005R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/compose/runtime/ProduceFrameSignal;", "", "()V", "pendingFrameContinuation", "awaitFrameRequest", "", "lock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestFrameLocked", "Lkotlin/coroutines/Continuation;", "takeFrameRequestLocked", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Recomposer.kt */
final class ProduceFrameSignal {
    /* access modifiers changed from: private */
    public Object pendingFrameContinuation;

    public final void takeFrameRequestLocked() {
        if (this.pendingFrameContinuation == RecomposerKt.FramePending) {
            this.pendingFrameContinuation = null;
            return;
        }
        throw new IllegalStateException("frame not pending".toString());
    }

    public final Continuation<Unit> requestFrameLocked() {
        Object obj = this.pendingFrameContinuation;
        if (obj instanceof Continuation) {
            this.pendingFrameContinuation = RecomposerKt.FramePending;
            return (Continuation) obj;
        }
        if (!(Intrinsics.areEqual(obj, RecomposerKt.ProduceAnotherFrame) ? true : Intrinsics.areEqual(obj, RecomposerKt.FramePending))) {
            if (obj == null) {
                this.pendingFrameContinuation = RecomposerKt.ProduceAnotherFrame;
            } else {
                throw new IllegalStateException(("invalid pendingFrameContinuation " + obj).toString());
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        r0 = new kotlinx.coroutines.CancellableContinuationImpl(kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r6), 1);
        r0.initCancellability();
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        if (access$getPendingFrameContinuation$p(r4) != androidx.compose.runtime.RecomposerKt.access$getProduceAnotherFrame$p()) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        access$setPendingFrameContinuation$p(r4, androidx.compose.runtime.RecomposerKt.access$getFramePending$p());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        access$setPendingFrameContinuation$p(r4, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003e, code lost:
        if (r1 == null) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0040, code lost:
        r5 = kotlin.Result.Companion;
        r1.resumeWith(kotlin.Result.m7042constructorimpl(kotlin.Unit.INSTANCE));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
        r5 = r0.getResult();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0055, code lost:
        if (r5 != kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0057, code lost:
        kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005e, code lost:
        if (r5 != kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0060, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0063, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object awaitFrameRequest(java.lang.Object r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            monitor-enter(r5)
            java.lang.Object r0 = r4.pendingFrameContinuation     // Catch:{ all -> 0x0067 }
            java.lang.Object r1 = androidx.compose.runtime.RecomposerKt.ProduceAnotherFrame     // Catch:{ all -> 0x0067 }
            if (r0 != r1) goto L_0x0013
            java.lang.Object r6 = androidx.compose.runtime.RecomposerKt.FramePending     // Catch:{ all -> 0x0067 }
            r4.pendingFrameContinuation = r6     // Catch:{ all -> 0x0067 }
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0067 }
            monitor-exit(r5)
            return r6
        L_0x0013:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0067 }
            monitor-exit(r5)
            kotlinx.coroutines.CancellableContinuationImpl r0 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r6)
            r2 = 1
            r0.<init>(r1, r2)
            r0.initCancellability()
            r1 = r0
            kotlinx.coroutines.CancellableContinuation r1 = (kotlinx.coroutines.CancellableContinuation) r1
            monitor-enter(r5)
            java.lang.Object r2 = r4.pendingFrameContinuation     // Catch:{ all -> 0x0064 }
            java.lang.Object r3 = androidx.compose.runtime.RecomposerKt.ProduceAnotherFrame     // Catch:{ all -> 0x0064 }
            if (r2 != r3) goto L_0x0039
            java.lang.Object r2 = androidx.compose.runtime.RecomposerKt.FramePending     // Catch:{ all -> 0x0064 }
            r4.pendingFrameContinuation = r2     // Catch:{ all -> 0x0064 }
            goto L_0x003d
        L_0x0039:
            r4.pendingFrameContinuation = r1     // Catch:{ all -> 0x0064 }
            r1 = 0
        L_0x003d:
            monitor-exit(r5)
            if (r1 == 0) goto L_0x004d
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            java.lang.Object r5 = kotlin.Result.m7042constructorimpl(r5)
            r1.resumeWith(r5)
        L_0x004d:
            java.lang.Object r5 = r0.getResult()
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r5 != r0) goto L_0x005a
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r6)
        L_0x005a:
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r5 != r6) goto L_0x0061
            return r5
        L_0x0061:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0064:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        L_0x0067:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ProduceFrameSignal.awaitFrameRequest(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
