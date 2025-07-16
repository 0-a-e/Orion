package androidx.compose.ui.platform;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"installForLifecycle", "Lkotlin/Function0;", "", "view", "Landroidx/compose/ui/platform/AbstractComposeView;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ViewCompositionStrategy.android.kt */
public final class ViewCompositionStrategy_androidKt {
    /* access modifiers changed from: private */
    public static final Function0<Unit> installForLifecycle(AbstractComposeView abstractComposeView, Lifecycle lifecycle) {
        if (lifecycle.getCurrentState().compareTo(Lifecycle.State.DESTROYED) > 0) {
            ViewCompositionStrategy_androidKt$$ExternalSyntheticLambda0 viewCompositionStrategy_androidKt$$ExternalSyntheticLambda0 = new ViewCompositionStrategy_androidKt$$ExternalSyntheticLambda0(abstractComposeView);
            lifecycle.addObserver(viewCompositionStrategy_androidKt$$ExternalSyntheticLambda0);
            return new ViewCompositionStrategy_androidKt$installForLifecycle$2(lifecycle, viewCompositionStrategy_androidKt$$ExternalSyntheticLambda0);
        }
        throw new IllegalStateException(("Cannot configure " + abstractComposeView + " to disposeComposition at Lifecycle ON_DESTROY: " + lifecycle + "is already destroyed").toString());
    }

    /* access modifiers changed from: private */
    public static final void installForLifecycle$lambda$1(AbstractComposeView abstractComposeView, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            abstractComposeView.disposeComposition();
        }
    }
}
