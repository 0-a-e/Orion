package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimationSpecsNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004¢\u0006\u0002\u0010\bJ\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004HÆ\u0001J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\f\u0010\u001b\u001a\u00020\u0019*\u00020\u001cH\u0016R\u0019\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/lazy/AnimateItemElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimationSpecsNode;", "appearanceSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "placementSpec", "Landroidx/compose/ui/unit/IntOffset;", "(Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "getAppearanceSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "getPlacementSpec", "component1", "component2", "copy", "create", "equals", "", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyItemScopeImpl.kt */
final class AnimateItemElement extends ModifierNodeElement<LazyLayoutAnimationSpecsNode> {
    private final FiniteAnimationSpec<Float> appearanceSpec;
    private final FiniteAnimationSpec<IntOffset> placementSpec;

    public static /* synthetic */ AnimateItemElement copy$default(AnimateItemElement animateItemElement, FiniteAnimationSpec<Float> finiteAnimationSpec, FiniteAnimationSpec<IntOffset> finiteAnimationSpec2, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = animateItemElement.appearanceSpec;
        }
        if ((i & 2) != 0) {
            finiteAnimationSpec2 = animateItemElement.placementSpec;
        }
        return animateItemElement.copy(finiteAnimationSpec, finiteAnimationSpec2);
    }

    public final FiniteAnimationSpec<Float> component1() {
        return this.appearanceSpec;
    }

    public final FiniteAnimationSpec<IntOffset> component2() {
        return this.placementSpec;
    }

    public final AnimateItemElement copy(FiniteAnimationSpec<Float> finiteAnimationSpec, FiniteAnimationSpec<IntOffset> finiteAnimationSpec2) {
        return new AnimateItemElement(finiteAnimationSpec, finiteAnimationSpec2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnimateItemElement)) {
            return false;
        }
        AnimateItemElement animateItemElement = (AnimateItemElement) obj;
        return Intrinsics.areEqual((Object) this.appearanceSpec, (Object) animateItemElement.appearanceSpec) && Intrinsics.areEqual((Object) this.placementSpec, (Object) animateItemElement.placementSpec);
    }

    public int hashCode() {
        FiniteAnimationSpec<Float> finiteAnimationSpec = this.appearanceSpec;
        int i = 0;
        int hashCode = (finiteAnimationSpec == null ? 0 : finiteAnimationSpec.hashCode()) * 31;
        FiniteAnimationSpec<IntOffset> finiteAnimationSpec2 = this.placementSpec;
        if (finiteAnimationSpec2 != null) {
            i = finiteAnimationSpec2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "AnimateItemElement(appearanceSpec=" + this.appearanceSpec + ", placementSpec=" + this.placementSpec + ')';
    }

    public final FiniteAnimationSpec<Float> getAppearanceSpec() {
        return this.appearanceSpec;
    }

    public final FiniteAnimationSpec<IntOffset> getPlacementSpec() {
        return this.placementSpec;
    }

    public AnimateItemElement(FiniteAnimationSpec<Float> finiteAnimationSpec, FiniteAnimationSpec<IntOffset> finiteAnimationSpec2) {
        this.appearanceSpec = finiteAnimationSpec;
        this.placementSpec = finiteAnimationSpec2;
    }

    public LazyLayoutAnimationSpecsNode create() {
        return new LazyLayoutAnimationSpecsNode(this.appearanceSpec, this.placementSpec);
    }

    public void update(LazyLayoutAnimationSpecsNode lazyLayoutAnimationSpecsNode) {
        lazyLayoutAnimationSpecsNode.setAppearanceSpec(this.appearanceSpec);
        lazyLayoutAnimationSpecsNode.setPlacementSpec(this.placementSpec);
    }

    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("animateItemPlacement");
        inspectorInfo.setValue(this.placementSpec);
    }
}
