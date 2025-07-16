package androidx.compose.ui.platform;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"androidx/compose/ui/platform/ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$listener$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ViewCompositionStrategy.android.kt */
public final class ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$listener$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ Ref.ObjectRef<Function0<Unit>> $disposer;
    final /* synthetic */ AbstractComposeView $view;

    public void onViewDetachedFromWindow(View view) {
    }

    ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$listener$1(AbstractComposeView abstractComposeView, Ref.ObjectRef<Function0<Unit>> objectRef) {
        this.$view = abstractComposeView;
        this.$disposer = objectRef;
    }

    public void onViewAttachedToWindow(View view) {
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(this.$view);
        AbstractComposeView abstractComposeView = this.$view;
        if (lifecycleOwner != null) {
            this.$disposer.element = ViewCompositionStrategy_androidKt.installForLifecycle(abstractComposeView, lifecycleOwner.getLifecycle());
            this.$view.removeOnAttachStateChangeListener(this);
            return;
        }
        throw new IllegalStateException(("View tree for " + abstractComposeView + " has no ViewTreeLifecycleOwner").toString());
    }
}
