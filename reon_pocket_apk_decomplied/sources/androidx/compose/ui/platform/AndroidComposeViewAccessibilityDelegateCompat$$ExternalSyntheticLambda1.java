package androidx.compose.ui.platform;

import android.view.accessibility.AccessibilityManager;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda1 implements AccessibilityManager.TouchExplorationStateChangeListener {
    public final /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat f$0;

    public /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda1(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat) {
        this.f$0 = androidComposeViewAccessibilityDelegateCompat;
    }

    public final void onTouchExplorationStateChanged(boolean z) {
        AndroidComposeViewAccessibilityDelegateCompat.touchExplorationStateListener$lambda$1(this.f$0, z);
    }
}
