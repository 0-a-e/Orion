package androidx.compose.material3;

import android.view.accessibility.AccessibilityManager;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "event", "Landroidx/lifecycle/Lifecycle$Event;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TouchExplorationStateProvider.android.kt */
final class TouchExplorationStateProvider_androidKt$touchExplorationState$1$1 extends Lambda implements Function1<Lifecycle.Event, Unit> {
    final /* synthetic */ AccessibilityManager $accessibilityManager;
    final /* synthetic */ Listener $listener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TouchExplorationStateProvider_androidKt$touchExplorationState$1$1(Listener listener, AccessibilityManager accessibilityManager) {
        super(1);
        this.$listener = listener;
        this.$accessibilityManager = accessibilityManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Lifecycle.Event) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_RESUME) {
            this.$listener.register(this.$accessibilityManager);
        }
    }
}
