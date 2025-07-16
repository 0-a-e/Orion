package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ\u001a\u0010\u000b\u001a\u00020\f*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0017J\u0014\u0010\u0010\u001a\u00020\f*\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0014\u0010\u0013\u001a\u00020\f*\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0014\u0010\u0014\u001a\u00020\f*\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/lazy/LazyItemScopeImpl;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "()V", "maxHeightState", "Landroidx/compose/runtime/MutableIntState;", "maxWidthState", "setMaxSize", "", "width", "", "height", "animateItemPlacement", "Landroidx/compose/ui/Modifier;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntOffset;", "fillParentMaxHeight", "fraction", "", "fillParentMaxSize", "fillParentMaxWidth", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyItemScopeImpl.kt */
public final class LazyItemScopeImpl implements LazyItemScope {
    public static final int $stable = 0;
    private MutableIntState maxHeightState = SnapshotIntStateKt.mutableIntStateOf(Integer.MAX_VALUE);
    private MutableIntState maxWidthState = SnapshotIntStateKt.mutableIntStateOf(Integer.MAX_VALUE);

    public final void setMaxSize(int i, int i2) {
        this.maxWidthState.setIntValue(i);
        this.maxHeightState.setIntValue(i2);
    }

    public Modifier fillParentMaxSize(Modifier modifier, float f) {
        return modifier.then(new ParentSizeElement(f, this.maxWidthState, this.maxHeightState, "fillParentMaxSize"));
    }

    public Modifier fillParentMaxWidth(Modifier modifier, float f) {
        return modifier.then(new ParentSizeElement(f, this.maxWidthState, (State) null, "fillParentMaxWidth", 4, (DefaultConstructorMarker) null));
    }

    public Modifier fillParentMaxHeight(Modifier modifier, float f) {
        return modifier.then(new ParentSizeElement(f, (State) null, this.maxHeightState, "fillParentMaxHeight", 2, (DefaultConstructorMarker) null));
    }

    public Modifier animateItemPlacement(Modifier modifier, FiniteAnimationSpec<IntOffset> finiteAnimationSpec) {
        return LazyItemScopeImplKt.animateItem(modifier, (FiniteAnimationSpec<Float>) null, finiteAnimationSpec);
    }
}
