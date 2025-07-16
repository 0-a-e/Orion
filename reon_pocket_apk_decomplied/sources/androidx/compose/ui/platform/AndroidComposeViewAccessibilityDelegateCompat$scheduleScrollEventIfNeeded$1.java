package androidx.compose.ui.platform;

import android.view.accessibility.AccessibilityNodeInfo;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
final class AndroidComposeViewAccessibilityDelegateCompat$scheduleScrollEventIfNeeded$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ScrollObservationScope $scrollObservationScope;
    final /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidComposeViewAccessibilityDelegateCompat$scheduleScrollEventIfNeeded$1(ScrollObservationScope scrollObservationScope, AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat) {
        super(0);
        this.$scrollObservationScope = scrollObservationScope;
        this.this$0 = androidComposeViewAccessibilityDelegateCompat;
    }

    public final void invoke() {
        SemanticsNode semanticsNode;
        LayoutNode layoutNode$ui_release;
        ScrollAxisRange horizontalScrollAxisRange = this.$scrollObservationScope.getHorizontalScrollAxisRange();
        ScrollAxisRange verticalScrollAxisRange = this.$scrollObservationScope.getVerticalScrollAxisRange();
        Float oldXValue = this.$scrollObservationScope.getOldXValue();
        Float oldYValue = this.$scrollObservationScope.getOldYValue();
        float floatValue = (horizontalScrollAxisRange == null || oldXValue == null) ? 0.0f : horizontalScrollAxisRange.getValue().invoke().floatValue() - oldXValue.floatValue();
        float floatValue2 = (verticalScrollAxisRange == null || oldYValue == null) ? 0.0f : verticalScrollAxisRange.getValue().invoke().floatValue() - oldYValue.floatValue();
        if (!(floatValue == 0.0f && floatValue2 == 0.0f)) {
            int access$semanticsNodeIdToAccessibilityVirtualNodeId = this.this$0.semanticsNodeIdToAccessibilityVirtualNodeId(this.$scrollObservationScope.getSemanticsNodeId());
            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) this.this$0.getCurrentSemanticsNodes().get(Integer.valueOf(this.this$0.focusedVirtualViewId));
            if (semanticsNodeWithAdjustedBounds != null) {
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this.this$0;
                try {
                    AccessibilityNodeInfo access$getCurrentlyFocusedANI$p = androidComposeViewAccessibilityDelegateCompat.currentlyFocusedANI;
                    if (access$getCurrentlyFocusedANI$p != null) {
                        access$getCurrentlyFocusedANI$p.setBoundsInScreen(androidComposeViewAccessibilityDelegateCompat.boundsInScreen(semanticsNodeWithAdjustedBounds));
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (IllegalStateException unused) {
                    Unit unit2 = Unit.INSTANCE;
                }
            }
            this.this$0.getView().invalidate();
            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds2 = (SemanticsNodeWithAdjustedBounds) this.this$0.getCurrentSemanticsNodes().get(Integer.valueOf(access$semanticsNodeIdToAccessibilityVirtualNodeId));
            if (!(semanticsNodeWithAdjustedBounds2 == null || (semanticsNode = semanticsNodeWithAdjustedBounds2.getSemanticsNode()) == null || (layoutNode$ui_release = semanticsNode.getLayoutNode$ui_release()) == null)) {
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat2 = this.this$0;
                if (horizontalScrollAxisRange != null) {
                    androidComposeViewAccessibilityDelegateCompat2.pendingHorizontalScrollEvents.put(Integer.valueOf(access$semanticsNodeIdToAccessibilityVirtualNodeId), horizontalScrollAxisRange);
                }
                if (verticalScrollAxisRange != null) {
                    androidComposeViewAccessibilityDelegateCompat2.pendingVerticalScrollEvents.put(Integer.valueOf(access$semanticsNodeIdToAccessibilityVirtualNodeId), verticalScrollAxisRange);
                }
                androidComposeViewAccessibilityDelegateCompat2.notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode$ui_release);
            }
        }
        if (horizontalScrollAxisRange != null) {
            this.$scrollObservationScope.setOldXValue(horizontalScrollAxisRange.getValue().invoke());
        }
        if (verticalScrollAxisRange != null) {
            this.$scrollObservationScope.setOldYValue(verticalScrollAxisRange.getValue().invoke());
        }
    }
}
