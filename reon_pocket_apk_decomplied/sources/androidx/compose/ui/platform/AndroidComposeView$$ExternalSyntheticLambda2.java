package androidx.compose.ui.platform;

import android.view.ViewTreeObserver;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AndroidComposeView$$ExternalSyntheticLambda2 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ AndroidComposeView f$0;

    public /* synthetic */ AndroidComposeView$$ExternalSyntheticLambda2(AndroidComposeView androidComposeView) {
        this.f$0 = androidComposeView;
    }

    public final void onGlobalLayout() {
        AndroidComposeView.globalLayoutListener$lambda$1(this.f$0);
    }
}
