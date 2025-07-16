package androidx.compose.ui.platform;

import android.view.accessibility.AccessibilityEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/accessibility/AccessibilityEvent;", "invoke", "(Landroid/view/accessibility/AccessibilityEvent;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
final class AndroidComposeViewAccessibilityDelegateCompat$onSendAccessibilityEvent$1 extends Lambda implements Function1<AccessibilityEvent, Boolean> {
    final /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidComposeViewAccessibilityDelegateCompat$onSendAccessibilityEvent$1(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat) {
        super(1);
        this.this$0 = androidComposeViewAccessibilityDelegateCompat;
    }

    public final Boolean invoke(AccessibilityEvent accessibilityEvent) {
        return Boolean.valueOf(this.this$0.getView().getParent().requestSendAccessibilityEvent(this.this$0.getView(), accessibilityEvent));
    }
}
