package androidx.compose.ui.platform;

import android.view.View;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"androidx/compose/ui/platform/WindowRecomposerPolicy$createAndInstallWindowRecomposer$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowRecomposer.android.kt */
public final class WindowRecomposerPolicy$createAndInstallWindowRecomposer$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ Job $unsetJob;

    public void onViewAttachedToWindow(View view) {
    }

    WindowRecomposerPolicy$createAndInstallWindowRecomposer$1(Job job) {
        this.$unsetJob = job;
    }

    public void onViewDetachedFromWindow(View view) {
        view.removeOnAttachStateChangeListener(this);
        Job.DefaultImpls.cancel$default(this.$unsetJob, (CancellationException) null, 1, (Object) null);
    }
}
