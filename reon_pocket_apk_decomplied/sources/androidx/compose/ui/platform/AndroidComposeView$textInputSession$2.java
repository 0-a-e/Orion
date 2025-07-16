package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/platform/AndroidPlatformTextInputSession;", "it", "Lkotlinx/coroutines/CoroutineScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeView.android.kt */
final class AndroidComposeView$textInputSession$2 extends Lambda implements Function1<CoroutineScope, AndroidPlatformTextInputSession> {
    final /* synthetic */ AndroidComposeView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidComposeView$textInputSession$2(AndroidComposeView androidComposeView) {
        super(1);
        this.this$0 = androidComposeView;
    }

    public final AndroidPlatformTextInputSession invoke(CoroutineScope coroutineScope) {
        AndroidComposeView androidComposeView = this.this$0;
        return new AndroidPlatformTextInputSession(androidComposeView, androidComposeView.getTextInputService(), coroutineScope);
    }
}
