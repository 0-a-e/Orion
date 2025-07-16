package androidx.compose.ui.platform;

import android.util.LongSparseArray;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AndroidComposeViewAccessibilityDelegateCompat$ViewTranslationHelperMethodsS$$ExternalSyntheticLambda10 implements Runnable {
    public final /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat f$0;
    public final /* synthetic */ LongSparseArray f$1;

    public /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat$ViewTranslationHelperMethodsS$$ExternalSyntheticLambda10(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, LongSparseArray longSparseArray) {
        this.f$0 = androidComposeViewAccessibilityDelegateCompat;
        this.f$1 = longSparseArray;
    }

    public final void run() {
        AndroidComposeViewAccessibilityDelegateCompat.ViewTranslationHelperMethodsS.onVirtualViewTranslationResponses$lambda$1(this.f$0, this.f$1);
    }
}
