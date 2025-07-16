package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H@¢\u0006\u0002\u0010\u0012J6\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019H@¢\u0006\u0002\u0010\u001aR/\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/SnackbarHostState;", "", "()V", "<set-?>", "Landroidx/compose/material3/SnackbarData;", "currentSnackbarData", "getCurrentSnackbarData", "()Landroidx/compose/material3/SnackbarData;", "setCurrentSnackbarData", "(Landroidx/compose/material3/SnackbarData;)V", "currentSnackbarData$delegate", "Landroidx/compose/runtime/MutableState;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "showSnackbar", "Landroidx/compose/material3/SnackbarResult;", "visuals", "Landroidx/compose/material3/SnackbarVisuals;", "(Landroidx/compose/material3/SnackbarVisuals;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "message", "", "actionLabel", "withDismissAction", "", "duration", "Landroidx/compose/material3/SnackbarDuration;", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/material3/SnackbarDuration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SnackbarDataImpl", "SnackbarVisualsImpl", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnackbarHost.kt */
public final class SnackbarHostState {
    public static final int $stable = 0;
    private final MutableState currentSnackbarData$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, (Object) null);

    /* access modifiers changed from: private */
    public final void setCurrentSnackbarData(SnackbarData snackbarData) {
        this.currentSnackbarData$delegate.setValue(snackbarData);
    }

    public final SnackbarData getCurrentSnackbarData() {
        return (SnackbarData) this.currentSnackbarData$delegate.getValue();
    }

    public static /* synthetic */ Object showSnackbar$default(SnackbarHostState snackbarHostState, String str, String str2, boolean z, SnackbarDuration snackbarDuration, Continuation continuation, int i, Object obj) {
        SnackbarDuration snackbarDuration2;
        if ((i & 2) != 0) {
            str2 = null;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            if (str3 == null) {
                snackbarDuration2 = SnackbarDuration.Short;
            } else {
                snackbarDuration2 = SnackbarDuration.Indefinite;
            }
            snackbarDuration = snackbarDuration2;
        }
        return snackbarHostState.showSnackbar(str, str3, z2, snackbarDuration, continuation);
    }

    public final Object showSnackbar(String str, String str2, boolean z, SnackbarDuration snackbarDuration, Continuation<? super SnackbarResult> continuation) {
        return showSnackbar(new SnackbarVisualsImpl(str, str2, z, snackbarDuration), continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a1 A[Catch:{ all -> 0x00b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:34:0x00b9=Splitter:B:34:0x00b9, B:28:0x00ad=Splitter:B:28:0x00ad} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object showSnackbar(androidx.compose.material3.SnackbarVisuals r9, kotlin.coroutines.Continuation<? super androidx.compose.material3.SnackbarResult> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.compose.material3.SnackbarHostState$showSnackbar$2
            if (r0 == 0) goto L_0x0014
            r0 = r10
            androidx.compose.material3.SnackbarHostState$showSnackbar$2 r0 = (androidx.compose.material3.SnackbarHostState$showSnackbar$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            androidx.compose.material3.SnackbarHostState$showSnackbar$2 r0 = new androidx.compose.material3.SnackbarHostState$showSnackbar$2
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x005c
            if (r2 == r4) goto L_0x004a
            if (r2 != r3) goto L_0x0042
            java.lang.Object r9 = r0.L$3
            androidx.compose.material3.SnackbarHostState$showSnackbar$2 r9 = (androidx.compose.material3.SnackbarHostState$showSnackbar$2) r9
            java.lang.Object r9 = r0.L$2
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            java.lang.Object r1 = r0.L$1
            androidx.compose.material3.SnackbarVisuals r1 = (androidx.compose.material3.SnackbarVisuals) r1
            java.lang.Object r0 = r0.L$0
            androidx.compose.material3.SnackbarHostState r0 = (androidx.compose.material3.SnackbarHostState) r0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x003f }
            goto L_0x00ad
        L_0x003f:
            r10 = move-exception
            goto L_0x00b9
        L_0x0042:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x004a:
            java.lang.Object r9 = r0.L$2
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            java.lang.Object r2 = r0.L$1
            androidx.compose.material3.SnackbarVisuals r2 = (androidx.compose.material3.SnackbarVisuals) r2
            java.lang.Object r6 = r0.L$0
            androidx.compose.material3.SnackbarHostState r6 = (androidx.compose.material3.SnackbarHostState) r6
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r9
            r9 = r2
            goto L_0x0071
        L_0x005c:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.sync.Mutex r10 = r8.mutex
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.label = r4
            java.lang.Object r2 = r10.lock(r5, r0)
            if (r2 != r1) goto L_0x0070
            return r1
        L_0x0070:
            r6 = r8
        L_0x0071:
            r0.L$0 = r6     // Catch:{ all -> 0x00b4 }
            r0.L$1 = r9     // Catch:{ all -> 0x00b4 }
            r0.L$2 = r10     // Catch:{ all -> 0x00b4 }
            r0.L$3 = r0     // Catch:{ all -> 0x00b4 }
            r0.label = r3     // Catch:{ all -> 0x00b4 }
            r2 = r0
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2     // Catch:{ all -> 0x00b4 }
            kotlinx.coroutines.CancellableContinuationImpl r3 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch:{ all -> 0x00b4 }
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r2)     // Catch:{ all -> 0x00b4 }
            r3.<init>(r2, r4)     // Catch:{ all -> 0x00b4 }
            r3.initCancellability()     // Catch:{ all -> 0x00b4 }
            r2 = r3
            kotlinx.coroutines.CancellableContinuation r2 = (kotlinx.coroutines.CancellableContinuation) r2     // Catch:{ all -> 0x00b4 }
            androidx.compose.material3.SnackbarHostState$SnackbarDataImpl r4 = new androidx.compose.material3.SnackbarHostState$SnackbarDataImpl     // Catch:{ all -> 0x00b4 }
            r4.<init>(r9, r2)     // Catch:{ all -> 0x00b4 }
            androidx.compose.material3.SnackbarData r4 = (androidx.compose.material3.SnackbarData) r4     // Catch:{ all -> 0x00b4 }
            r6.setCurrentSnackbarData(r4)     // Catch:{ all -> 0x00b4 }
            java.lang.Object r9 = r3.getResult()     // Catch:{ all -> 0x00b4 }
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x00b4 }
            if (r9 != r2) goto L_0x00a6
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0     // Catch:{ all -> 0x00b4 }
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)     // Catch:{ all -> 0x00b4 }
        L_0x00a6:
            if (r9 != r1) goto L_0x00a9
            return r1
        L_0x00a9:
            r0 = r6
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x00ad:
            r0.setCurrentSnackbarData(r5)     // Catch:{ all -> 0x00bd }
            r9.unlock(r5)
            return r10
        L_0x00b4:
            r9 = move-exception
            r0 = r6
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x00b9:
            r0.setCurrentSnackbarData(r5)     // Catch:{ all -> 0x00bd }
            throw r10     // Catch:{ all -> 0x00bd }
        L_0x00bd:
            r10 = move-exception
            r9.unlock(r5)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnackbarHostState.showSnackbar(androidx.compose.material3.SnackbarVisuals, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Landroidx/compose/material3/SnackbarHostState$SnackbarVisualsImpl;", "Landroidx/compose/material3/SnackbarVisuals;", "message", "", "actionLabel", "withDismissAction", "", "duration", "Landroidx/compose/material3/SnackbarDuration;", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/material3/SnackbarDuration;)V", "getActionLabel", "()Ljava/lang/String;", "getDuration", "()Landroidx/compose/material3/SnackbarDuration;", "getMessage", "getWithDismissAction", "()Z", "equals", "other", "", "hashCode", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SnackbarHost.kt */
    private static final class SnackbarVisualsImpl implements SnackbarVisuals {
        private final String actionLabel;
        private final SnackbarDuration duration;
        private final String message;
        private final boolean withDismissAction;

        public SnackbarVisualsImpl(String str, String str2, boolean z, SnackbarDuration snackbarDuration) {
            this.message = str;
            this.actionLabel = str2;
            this.withDismissAction = z;
            this.duration = snackbarDuration;
        }

        public String getMessage() {
            return this.message;
        }

        public String getActionLabel() {
            return this.actionLabel;
        }

        public boolean getWithDismissAction() {
            return this.withDismissAction;
        }

        public SnackbarDuration getDuration() {
            return this.duration;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SnackbarVisualsImpl snackbarVisualsImpl = (SnackbarVisualsImpl) obj;
            return Intrinsics.areEqual((Object) getMessage(), (Object) snackbarVisualsImpl.getMessage()) && Intrinsics.areEqual((Object) getActionLabel(), (Object) snackbarVisualsImpl.getActionLabel()) && getWithDismissAction() == snackbarVisualsImpl.getWithDismissAction() && getDuration() == snackbarVisualsImpl.getDuration();
        }

        public int hashCode() {
            int hashCode = getMessage().hashCode() * 31;
            String actionLabel2 = getActionLabel();
            return ((((hashCode + (actionLabel2 != null ? actionLabel2.hashCode() : 0)) * 31) + UByte$$ExternalSyntheticBackport0.m(getWithDismissAction())) * 31) + getDuration().hashCode();
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Landroidx/compose/material3/SnackbarHostState$SnackbarDataImpl;", "Landroidx/compose/material3/SnackbarData;", "visuals", "Landroidx/compose/material3/SnackbarVisuals;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Landroidx/compose/material3/SnackbarResult;", "(Landroidx/compose/material3/SnackbarVisuals;Lkotlinx/coroutines/CancellableContinuation;)V", "getVisuals", "()Landroidx/compose/material3/SnackbarVisuals;", "dismiss", "", "equals", "", "other", "", "hashCode", "", "performAction", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SnackbarHost.kt */
    private static final class SnackbarDataImpl implements SnackbarData {
        private final CancellableContinuation<SnackbarResult> continuation;
        private final SnackbarVisuals visuals;

        public SnackbarDataImpl(SnackbarVisuals snackbarVisuals, CancellableContinuation<? super SnackbarResult> cancellableContinuation) {
            this.visuals = snackbarVisuals;
            this.continuation = cancellableContinuation;
        }

        public SnackbarVisuals getVisuals() {
            return this.visuals;
        }

        public void performAction() {
            if (this.continuation.isActive()) {
                Result.Companion companion = Result.Companion;
                this.continuation.resumeWith(Result.m7042constructorimpl(SnackbarResult.ActionPerformed));
            }
        }

        public void dismiss() {
            if (this.continuation.isActive()) {
                Result.Companion companion = Result.Companion;
                this.continuation.resumeWith(Result.m7042constructorimpl(SnackbarResult.Dismissed));
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SnackbarDataImpl snackbarDataImpl = (SnackbarDataImpl) obj;
            return Intrinsics.areEqual((Object) getVisuals(), (Object) snackbarDataImpl.getVisuals()) && Intrinsics.areEqual((Object) this.continuation, (Object) snackbarDataImpl.continuation);
        }

        public int hashCode() {
            return (getVisuals().hashCode() * 31) + this.continuation.hashCode();
        }
    }
}
