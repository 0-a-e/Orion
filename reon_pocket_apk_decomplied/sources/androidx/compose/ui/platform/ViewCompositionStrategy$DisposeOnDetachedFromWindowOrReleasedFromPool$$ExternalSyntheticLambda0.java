package androidx.compose.ui.platform;

import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.customview.poolingcontainer.PoolingContainerListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 implements PoolingContainerListener {
    public final /* synthetic */ AbstractComposeView f$0;

    public /* synthetic */ ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0(AbstractComposeView abstractComposeView) {
        this.f$0 = abstractComposeView;
    }

    public final void onRelease() {
        ViewCompositionStrategy.DisposeOnDetachedFromWindowOrReleasedFromPool.installFor$lambda$0(this.f$0);
    }
}
