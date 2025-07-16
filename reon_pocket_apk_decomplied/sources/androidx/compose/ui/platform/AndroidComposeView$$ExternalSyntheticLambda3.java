package androidx.compose.ui.platform;

import android.view.ViewTreeObserver;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AndroidComposeView$$ExternalSyntheticLambda3 implements ViewTreeObserver.OnScrollChangedListener {
    public final /* synthetic */ AndroidComposeView f$0;

    public /* synthetic */ AndroidComposeView$$ExternalSyntheticLambda3(AndroidComposeView androidComposeView) {
        this.f$0 = androidComposeView;
    }

    public final void onScrollChanged() {
        AndroidComposeView.scrollChangedListener$lambda$2(this.f$0);
    }
}
