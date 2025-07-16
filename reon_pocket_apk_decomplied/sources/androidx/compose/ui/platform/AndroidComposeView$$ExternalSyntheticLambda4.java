package androidx.compose.ui.platform;

import android.view.ViewTreeObserver;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AndroidComposeView$$ExternalSyntheticLambda4 implements ViewTreeObserver.OnTouchModeChangeListener {
    public final /* synthetic */ AndroidComposeView f$0;

    public /* synthetic */ AndroidComposeView$$ExternalSyntheticLambda4(AndroidComposeView androidComposeView) {
        this.f$0 = androidComposeView;
    }

    public final void onTouchModeChanged(boolean z) {
        AndroidComposeView.touchModeChangeListener$lambda$3(this.f$0, z);
    }
}
