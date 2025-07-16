package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.BringIntoViewSpec;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"androidx/compose/foundation/gestures/BringIntoViewSpec$Companion$DefaultBringIntoViewSpec$1", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "scrollAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "getScrollAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "calculateScrollDistance", "offset", "size", "containerSize", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scrollable.kt */
public final class BringIntoViewSpec$Companion$DefaultBringIntoViewSpec$1 implements BringIntoViewSpec {
    private final AnimationSpec<Float> scrollAnimationSpec = BringIntoViewSpec.Companion.$$INSTANCE.getDefaultScrollAnimationSpec();

    BringIntoViewSpec$Companion$DefaultBringIntoViewSpec$1() {
    }

    public AnimationSpec<Float> getScrollAnimationSpec() {
        return this.scrollAnimationSpec;
    }

    public float calculateScrollDistance(float f, float f2, float f3) {
        float f4 = f2 + f;
        if ((f >= 0.0f && f4 <= f3) || (f < 0.0f && f4 > f3)) {
            return 0.0f;
        }
        float f5 = f4 - f3;
        return Math.abs(f) < Math.abs(f5) ? f : f5;
    }
}
