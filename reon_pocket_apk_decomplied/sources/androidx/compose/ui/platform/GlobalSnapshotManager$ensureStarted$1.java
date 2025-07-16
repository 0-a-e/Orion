package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$1", f = "GlobalSnapshotManager.android.kt", i = {0}, l = {67}, m = "invokeSuspend", n = {"$this$consume$iv$iv"}, s = {"L$0"})
/* compiled from: GlobalSnapshotManager.android.kt */
final class GlobalSnapshotManager$ensureStarted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<Unit> $channel;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalSnapshotManager$ensureStarted$1(Channel<Unit> channel, Continuation<? super GlobalSnapshotManager$ensureStarted$1> continuation) {
        super(2, continuation);
        this.$channel = channel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GlobalSnapshotManager$ensureStarted$1(this.$channel, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GlobalSnapshotManager$ensureStarted$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0060, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0061, code lost:
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0064, code lost:
        throw r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0042 A[Catch:{ all -> 0x0060 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0020
            if (r1 != r3) goto L_0x0018
            java.lang.Object r1 = r6.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r6.L$0
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x005e }
            goto L_0x003a
        L_0x0018:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0020:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.channels.Channel<kotlin.Unit> r7 = r6.$channel
            r4 = r7
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
            kotlinx.coroutines.channels.ChannelIterator r7 = r4.iterator()     // Catch:{ all -> 0x005e }
            r1 = r7
        L_0x002d:
            r6.L$0 = r4     // Catch:{ all -> 0x005e }
            r6.L$1 = r1     // Catch:{ all -> 0x005e }
            r6.label = r3     // Catch:{ all -> 0x005e }
            java.lang.Object r7 = r1.hasNext(r6)     // Catch:{ all -> 0x005e }
            if (r7 != r0) goto L_0x003a
            return r0
        L_0x003a:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x005e }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x005e }
            if (r7 == 0) goto L_0x0056
            java.lang.Object r7 = r1.next()     // Catch:{ all -> 0x005e }
            kotlin.Unit r7 = (kotlin.Unit) r7     // Catch:{ all -> 0x005e }
            java.util.concurrent.atomic.AtomicBoolean r7 = androidx.compose.ui.platform.GlobalSnapshotManager.sent     // Catch:{ all -> 0x005e }
            r5 = 0
            r7.set(r5)     // Catch:{ all -> 0x005e }
            androidx.compose.runtime.snapshots.Snapshot$Companion r7 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x005e }
            r7.sendApplyNotifications()     // Catch:{ all -> 0x005e }
            goto L_0x002d
        L_0x0056:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005e }
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r4, r2)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x005e:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0060 }
        L_0x0060:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r4, r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
