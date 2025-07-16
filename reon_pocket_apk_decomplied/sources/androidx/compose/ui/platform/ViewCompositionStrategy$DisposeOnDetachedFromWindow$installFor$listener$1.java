package androidx.compose.ui.platform;

import android.view.View;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"androidx/compose/ui/platform/ViewCompositionStrategy$DisposeOnDetachedFromWindow$installFor$listener$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ViewCompositionStrategy.android.kt */
public final class ViewCompositionStrategy$DisposeOnDetachedFromWindow$installFor$listener$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ AbstractComposeView $view;

    public void onViewAttachedToWindow(View view) {
    }

    ViewCompositionStrategy$DisposeOnDetachedFromWindow$installFor$listener$1(AbstractComposeView abstractComposeView) {
        this.$view = abstractComposeView;
    }

    public void onViewDetachedFromWindow(View view) {
        this.$view.disposeComposition();
    }
}
