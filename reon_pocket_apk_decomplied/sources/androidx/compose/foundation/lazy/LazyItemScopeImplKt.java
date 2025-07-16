package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u0001¨\u0006\u0007"}, d2 = {"animateItem", "Landroidx/compose/ui/Modifier;", "appearanceSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "placementSpec", "Landroidx/compose/ui/unit/IntOffset;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyItemScopeImpl.kt */
public final class LazyItemScopeImplKt {
    public static /* synthetic */ Modifier animateItem$default(Modifier modifier, FiniteAnimationSpec finiteAnimationSpec, FiniteAnimationSpec finiteAnimationSpec2, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.tween$default(220, 0, (Easing) null, 6, (Object) null);
        }
        if ((i & 2) != 0) {
            finiteAnimationSpec2 = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m6739boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        return animateItem(modifier, finiteAnimationSpec, finiteAnimationSpec2);
    }

    public static final Modifier animateItem(Modifier modifier, FiniteAnimationSpec<Float> finiteAnimationSpec, FiniteAnimationSpec<IntOffset> finiteAnimationSpec2) {
        return (finiteAnimationSpec == null && finiteAnimationSpec2 == null) ? modifier : modifier.then(new AnimateItemElement(finiteAnimationSpec, finiteAnimationSpec2));
    }
}
