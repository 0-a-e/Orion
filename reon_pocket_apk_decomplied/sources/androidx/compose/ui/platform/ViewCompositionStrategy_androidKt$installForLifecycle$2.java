package androidx.compose.ui.platform;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ViewCompositionStrategy.android.kt */
final class ViewCompositionStrategy_androidKt$installForLifecycle$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Lifecycle $lifecycle;
    final /* synthetic */ LifecycleEventObserver $observer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ViewCompositionStrategy_androidKt$installForLifecycle$2(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
        super(0);
        this.$lifecycle = lifecycle;
        this.$observer = lifecycleEventObserver;
    }

    public final void invoke() {
        this.$lifecycle.removeObserver(this.$observer);
    }
}
