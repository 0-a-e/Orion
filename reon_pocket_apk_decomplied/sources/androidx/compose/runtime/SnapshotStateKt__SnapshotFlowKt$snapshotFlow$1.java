package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1", f = "SnapshotFlow.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {144, 148, 170}, m = "invokeSuspend", n = {"$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue", "$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue", "found", "$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* compiled from: SnapshotFlow.kt */
final class SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<T> $block;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1(Function0<? extends T> function0, Continuation<? super SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1> continuation) {
        super(2, continuation);
        this.$block = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1 snapshotStateKt__SnapshotFlowKt$snapshotFlow$1 = new SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1(this.$block, continuation);
        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$0 = obj;
        return snapshotStateKt__SnapshotFlowKt$snapshotFlow$1;
    }

    public final Object invoke(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        return ((SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v19, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00eb A[Catch:{ all -> 0x0052 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0103 A[Catch:{ all -> 0x0052 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            r2 = 3
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L_0x006d
            if (r1 == r5) goto L_0x0056
            if (r1 == r3) goto L_0x0035
            if (r1 != r2) goto L_0x002d
            java.lang.Object r1 = r13.L$5
            java.lang.Object r6 = r13.L$4
            androidx.compose.runtime.snapshots.ObserverHandle r6 = (androidx.compose.runtime.snapshots.ObserverHandle) r6
            java.lang.Object r7 = r13.L$3
            kotlinx.coroutines.channels.Channel r7 = (kotlinx.coroutines.channels.Channel) r7
            java.lang.Object r8 = r13.L$2
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            java.lang.Object r9 = r13.L$1
            androidx.collection.MutableScatterSet r9 = (androidx.collection.MutableScatterSet) r9
            java.lang.Object r10 = r13.L$0
            kotlinx.coroutines.flow.FlowCollector r10 = (kotlinx.coroutines.flow.FlowCollector) r10
        L_0x0028:
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0156 }
            goto L_0x00c6
        L_0x002d:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x0035:
            int r1 = r13.I$0
            java.lang.Object r6 = r13.L$5
            java.lang.Object r7 = r13.L$4
            androidx.compose.runtime.snapshots.ObserverHandle r7 = (androidx.compose.runtime.snapshots.ObserverHandle) r7
            java.lang.Object r8 = r13.L$3
            kotlinx.coroutines.channels.Channel r8 = (kotlinx.coroutines.channels.Channel) r8
            java.lang.Object r9 = r13.L$2
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            java.lang.Object r10 = r13.L$1
            androidx.collection.MutableScatterSet r10 = (androidx.collection.MutableScatterSet) r10
            java.lang.Object r11 = r13.L$0
            kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0052 }
            goto L_0x00e7
        L_0x0052:
            r14 = move-exception
            r6 = r7
            goto L_0x0157
        L_0x0056:
            java.lang.Object r1 = r13.L$5
            java.lang.Object r6 = r13.L$4
            androidx.compose.runtime.snapshots.ObserverHandle r6 = (androidx.compose.runtime.snapshots.ObserverHandle) r6
            java.lang.Object r7 = r13.L$3
            kotlinx.coroutines.channels.Channel r7 = (kotlinx.coroutines.channels.Channel) r7
            java.lang.Object r8 = r13.L$2
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            java.lang.Object r9 = r13.L$1
            androidx.collection.MutableScatterSet r9 = (androidx.collection.MutableScatterSet) r9
            java.lang.Object r10 = r13.L$0
            kotlinx.coroutines.flow.FlowCollector r10 = (kotlinx.coroutines.flow.FlowCollector) r10
            goto L_0x0028
        L_0x006d:
            kotlin.ResultKt.throwOnFailure(r14)
            java.lang.Object r14 = r13.L$0
            r10 = r14
            kotlinx.coroutines.flow.FlowCollector r10 = (kotlinx.coroutines.flow.FlowCollector) r10
            androidx.collection.MutableScatterSet r9 = new androidx.collection.MutableScatterSet
            r14 = 0
            r9.<init>(r4, r5, r14)
            androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$readObserver$1 r1 = new androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$readObserver$1
            r1.<init>(r9)
            r8 = r1
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r1 = 2147483647(0x7fffffff, float:NaN)
            r6 = 6
            kotlinx.coroutines.channels.Channel r7 = kotlinx.coroutines.channels.ChannelKt.Channel$default(r1, r14, r14, r6, r14)
            androidx.compose.runtime.snapshots.Snapshot$Companion r14 = androidx.compose.runtime.snapshots.Snapshot.Companion
            androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$unregisterApplyObserver$1 r1 = new androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$unregisterApplyObserver$1
            r1.<init>(r7)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            androidx.compose.runtime.snapshots.ObserverHandle r6 = r14.registerApplyObserver(r1)
            androidx.compose.runtime.snapshots.Snapshot$Companion r14 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x0156 }
            androidx.compose.runtime.snapshots.Snapshot r14 = r14.takeSnapshot(r8)     // Catch:{ all -> 0x0156 }
            kotlin.jvm.functions.Function0<T> r1 = r13.$block     // Catch:{ all -> 0x0156 }
            androidx.compose.runtime.snapshots.Snapshot r11 = r14.makeCurrent()     // Catch:{ all -> 0x0151 }
            java.lang.Object r1 = r1.invoke()     // Catch:{ all -> 0x014c }
            r14.restoreCurrent(r11)     // Catch:{ all -> 0x0151 }
            r14.dispose()     // Catch:{ all -> 0x0156 }
            r14 = r13
            kotlin.coroutines.Continuation r14 = (kotlin.coroutines.Continuation) r14     // Catch:{ all -> 0x0156 }
            r13.L$0 = r10     // Catch:{ all -> 0x0156 }
            r13.L$1 = r9     // Catch:{ all -> 0x0156 }
            r13.L$2 = r8     // Catch:{ all -> 0x0156 }
            r13.L$3 = r7     // Catch:{ all -> 0x0156 }
            r13.L$4 = r6     // Catch:{ all -> 0x0156 }
            r13.L$5 = r1     // Catch:{ all -> 0x0156 }
            r13.label = r5     // Catch:{ all -> 0x0156 }
            java.lang.Object r14 = r10.emit(r1, r14)     // Catch:{ all -> 0x0156 }
            if (r14 != r0) goto L_0x00c6
            return r0
        L_0x00c6:
            r14 = r13
            kotlin.coroutines.Continuation r14 = (kotlin.coroutines.Continuation) r14     // Catch:{ all -> 0x0156 }
            r13.L$0 = r10     // Catch:{ all -> 0x0156 }
            r13.L$1 = r9     // Catch:{ all -> 0x0156 }
            r13.L$2 = r8     // Catch:{ all -> 0x0156 }
            r13.L$3 = r7     // Catch:{ all -> 0x0156 }
            r13.L$4 = r6     // Catch:{ all -> 0x0156 }
            r13.L$5 = r1     // Catch:{ all -> 0x0156 }
            r13.I$0 = r4     // Catch:{ all -> 0x0156 }
            r13.label = r3     // Catch:{ all -> 0x0156 }
            java.lang.Object r14 = r7.receive(r14)     // Catch:{ all -> 0x0156 }
            if (r14 != r0) goto L_0x00e0
            return r0
        L_0x00e0:
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r1
            r1 = r4
        L_0x00e7:
            java.util.Set r14 = (java.util.Set) r14     // Catch:{ all -> 0x0052 }
        L_0x00e9:
            if (r1 != 0) goto L_0x00f4
            boolean r14 = androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt.intersects$SnapshotStateKt__SnapshotFlowKt(r10, r14)     // Catch:{ all -> 0x0052 }
            if (r14 == 0) goto L_0x00f2
            goto L_0x00f4
        L_0x00f2:
            r1 = r4
            goto L_0x00f5
        L_0x00f4:
            r1 = r5
        L_0x00f5:
            java.lang.Object r14 = r8.m8592tryReceivePtdJZtk()     // Catch:{ all -> 0x0052 }
            java.lang.Object r14 = kotlinx.coroutines.channels.ChannelResult.m8575getOrNullimpl(r14)     // Catch:{ all -> 0x0052 }
            java.util.Set r14 = (java.util.Set) r14     // Catch:{ all -> 0x0052 }
            if (r14 != 0) goto L_0x00e9
            if (r1 == 0) goto L_0x0144
            r10.clear()     // Catch:{ all -> 0x0052 }
            androidx.compose.runtime.snapshots.Snapshot$Companion r14 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x0052 }
            androidx.compose.runtime.snapshots.Snapshot r14 = r14.takeSnapshot(r9)     // Catch:{ all -> 0x0052 }
            kotlin.jvm.functions.Function0<T> r1 = r13.$block     // Catch:{ all -> 0x0052 }
            androidx.compose.runtime.snapshots.Snapshot r12 = r14.makeCurrent()     // Catch:{ all -> 0x013f }
            java.lang.Object r1 = r1.invoke()     // Catch:{ all -> 0x013a }
            r14.restoreCurrent(r12)     // Catch:{ all -> 0x013f }
            r14.dispose()     // Catch:{ all -> 0x0052 }
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r6)     // Catch:{ all -> 0x0052 }
            if (r14 != 0) goto L_0x0144
            r14 = r13
            kotlin.coroutines.Continuation r14 = (kotlin.coroutines.Continuation) r14     // Catch:{ all -> 0x0052 }
            r13.L$0 = r11     // Catch:{ all -> 0x0052 }
            r13.L$1 = r10     // Catch:{ all -> 0x0052 }
            r13.L$2 = r9     // Catch:{ all -> 0x0052 }
            r13.L$3 = r8     // Catch:{ all -> 0x0052 }
            r13.L$4 = r7     // Catch:{ all -> 0x0052 }
            r13.L$5 = r1     // Catch:{ all -> 0x0052 }
            r13.label = r2     // Catch:{ all -> 0x0052 }
            java.lang.Object r14 = r11.emit(r1, r14)     // Catch:{ all -> 0x0052 }
            if (r14 != r0) goto L_0x0145
            return r0
        L_0x013a:
            r0 = move-exception
            r14.restoreCurrent(r12)     // Catch:{ all -> 0x013f }
            throw r0     // Catch:{ all -> 0x013f }
        L_0x013f:
            r0 = move-exception
            r14.dispose()     // Catch:{ all -> 0x0052 }
            throw r0     // Catch:{ all -> 0x0052 }
        L_0x0144:
            r1 = r6
        L_0x0145:
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            goto L_0x00c6
        L_0x014c:
            r0 = move-exception
            r14.restoreCurrent(r11)     // Catch:{ all -> 0x0151 }
            throw r0     // Catch:{ all -> 0x0151 }
        L_0x0151:
            r0 = move-exception
            r14.dispose()     // Catch:{ all -> 0x0156 }
            throw r0     // Catch:{ all -> 0x0156 }
        L_0x0156:
            r14 = move-exception
        L_0x0157:
            r6.dispose()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
