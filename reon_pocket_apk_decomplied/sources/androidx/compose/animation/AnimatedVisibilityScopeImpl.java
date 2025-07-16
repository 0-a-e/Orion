package androidx.compose.animation;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0005¨\u0006\u000e"}, d2 = {"Landroidx/compose/animation/AnimatedVisibilityScopeImpl;", "Landroidx/compose/animation/AnimatedVisibilityScope;", "transition", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "(Landroidx/compose/animation/core/Transition;)V", "targetSize", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/unit/IntSize;", "getTargetSize$animation_release", "()Landroidx/compose/runtime/MutableState;", "getTransition", "()Landroidx/compose/animation/core/Transition;", "setTransition", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedVisibility.kt */
public final class AnimatedVisibilityScopeImpl implements AnimatedVisibilityScope {
    public static final int $stable = 8;
    private final MutableState<IntSize> targetSize = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m6782boximpl(IntSize.Companion.m6795getZeroYbymL2g()), (SnapshotMutationPolicy) null, 2, (Object) null);
    private Transition<EnterExitState> transition;

    public /* synthetic */ Modifier animateEnterExit(Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str) {
        return AnimatedVisibilityScope.CC.$default$animateEnterExit(this, modifier, enterTransition, exitTransition, str);
    }

    public AnimatedVisibilityScopeImpl(Transition<EnterExitState> transition2) {
        this.transition = transition2;
    }

    public Transition<EnterExitState> getTransition() {
        return this.transition;
    }

    public void setTransition(Transition<EnterExitState> transition2) {
        this.transition = transition2;
    }

    public final MutableState<IntSize> getTargetSize$animation_release() {
        return this.targetSize;
    }
}
