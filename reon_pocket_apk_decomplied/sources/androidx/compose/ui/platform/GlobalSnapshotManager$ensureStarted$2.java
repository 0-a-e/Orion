package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.Channel;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: GlobalSnapshotManager.android.kt */
final class GlobalSnapshotManager$ensureStarted$2 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ Channel<Unit> $channel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalSnapshotManager$ensureStarted$2(Channel<Unit> channel) {
        super(1);
        this.$channel = channel;
    }

    public final void invoke(Object obj) {
        if (GlobalSnapshotManager.sent.compareAndSet(false, true)) {
            this.$channel.m8593trySendJP2dKIU(Unit.INSTANCE);
        }
    }
}
