package androidx.compose.ui.platform;

import androidx.compose.runtime.snapshots.Snapshot;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/compose/ui/platform/GlobalSnapshotManager;", "", "()V", "sent", "Ljava/util/concurrent/atomic/AtomicBoolean;", "started", "ensureStarted", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GlobalSnapshotManager.android.kt */
public final class GlobalSnapshotManager {
    public static final int $stable = 8;
    public static final GlobalSnapshotManager INSTANCE = new GlobalSnapshotManager();
    /* access modifiers changed from: private */
    public static final AtomicBoolean sent = new AtomicBoolean(false);
    private static final AtomicBoolean started = new AtomicBoolean(false);

    private GlobalSnapshotManager() {
    }

    public final void ensureStarted() {
        if (started.compareAndSet(false, true)) {
            Channel Channel$default = ChannelKt.Channel$default(1, (BufferOverflow) null, (Function1) null, 6, (Object) null);
            Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(AndroidUiDispatcher.Companion.getMain()), (CoroutineContext) null, (CoroutineStart) null, new GlobalSnapshotManager$ensureStarted$1(Channel$default, (Continuation<? super GlobalSnapshotManager$ensureStarted$1>) null), 3, (Object) null);
            Snapshot.Companion.registerGlobalWriteObserver(new GlobalSnapshotManager$ensureStarted$2(Channel$default));
        }
    }
}
