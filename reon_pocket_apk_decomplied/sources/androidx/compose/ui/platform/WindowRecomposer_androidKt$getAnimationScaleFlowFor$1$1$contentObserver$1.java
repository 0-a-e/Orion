package androidx.compose.ui.platform;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.channels.Channel;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"androidx/compose/ui/platform/WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1", "Landroid/database/ContentObserver;", "onChange", "", "selfChange", "", "uri", "Landroid/net/Uri;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowRecomposer.android.kt */
public final class WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1 extends ContentObserver {
    final /* synthetic */ Channel<Unit> $channel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1(Channel<Unit> channel, Handler handler) {
        super(handler);
        this.$channel = channel;
    }

    public void onChange(boolean z, Uri uri) {
        this.$channel.m8593trySendJP2dKIU(Unit.INSTANCE);
    }
}
