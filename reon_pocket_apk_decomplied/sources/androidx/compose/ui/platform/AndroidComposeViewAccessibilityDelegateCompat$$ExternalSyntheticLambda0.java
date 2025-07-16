package androidx.compose.ui.platform;

import android.view.accessibility.AccessibilityManager;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda0 implements AccessibilityManager.AccessibilityStateChangeListener {
    public final /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat f$0;

    public /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda0(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat) {
        this.f$0 = androidComposeViewAccessibilityDelegateCompat;
    }

    public final void onAccessibilityStateChanged(boolean z) {
        AndroidComposeViewAccessibilityDelegateCompat.enabledStateListener$lambda$0(this.f$0, z);
    }
}
