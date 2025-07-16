package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/platform/ScrollObservationScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
final class AndroidComposeViewAccessibilityDelegateCompat$scheduleScrollEventIfNeededLambda$1 extends Lambda implements Function1<ScrollObservationScope, Unit> {
    final /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidComposeViewAccessibilityDelegateCompat$scheduleScrollEventIfNeededLambda$1(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat) {
        super(1);
        this.this$0 = androidComposeViewAccessibilityDelegateCompat;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ScrollObservationScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ScrollObservationScope scrollObservationScope) {
        this.this$0.scheduleScrollEventIfNeeded(scrollObservationScope);
    }
}
