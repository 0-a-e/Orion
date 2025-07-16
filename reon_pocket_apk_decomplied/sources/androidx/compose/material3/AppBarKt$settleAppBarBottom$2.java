package androidx.compose.material3;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationVector1D;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/animation/core/AnimationScope;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppBar.kt */
final class AppBarKt$settleAppBarBottom$2 extends Lambda implements Function1<AnimationScope<Float, AnimationVector1D>, Unit> {
    final /* synthetic */ Ref.FloatRef $lastValue;
    final /* synthetic */ Ref.FloatRef $remainingVelocity;
    final /* synthetic */ BottomAppBarState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppBarKt$settleAppBarBottom$2(Ref.FloatRef floatRef, BottomAppBarState bottomAppBarState, Ref.FloatRef floatRef2) {
        super(1);
        this.$lastValue = floatRef;
        this.$state = bottomAppBarState;
        this.$remainingVelocity = floatRef2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AnimationScope<Float, AnimationVector1D>) (AnimationScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
        float floatValue = animationScope.getValue().floatValue() - this.$lastValue.element;
        float heightOffset = this.$state.getHeightOffset();
        this.$state.setHeightOffset(heightOffset + floatValue);
        float abs = Math.abs(heightOffset - this.$state.getHeightOffset());
        this.$lastValue.element = animationScope.getValue().floatValue();
        this.$remainingVelocity.element = animationScope.getVelocity().floatValue();
        if (Math.abs(floatValue - abs) > 0.5f) {
            animationScope.cancelAnimation();
        }
    }
}
