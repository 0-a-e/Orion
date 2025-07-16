package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Recomposer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"androidx/compose/ui/platform/WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowRecomposer.android.kt */
public final class WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ Recomposer $recomposer;
    final /* synthetic */ View $this_createLifecycleAwareWindowRecomposer;

    public void onViewAttachedToWindow(View view) {
    }

    WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$1(View view, Recomposer recomposer) {
        this.$this_createLifecycleAwareWindowRecomposer = view;
        this.$recomposer = recomposer;
    }

    public void onViewDetachedFromWindow(View view) {
        this.$this_createLifecycleAwareWindowRecomposer.removeOnAttachStateChangeListener(this);
        this.$recomposer.cancel();
    }
}
