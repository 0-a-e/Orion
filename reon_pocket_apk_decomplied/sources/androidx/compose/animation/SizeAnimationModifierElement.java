package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BM\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00128\u0010\u0006\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007¢\u0006\u0002\u0010\rJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J;\u0010\u0013\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007HÆ\u0003JU\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042:\b\u0002\u0010\u0006\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007HÆ\u0001J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u0002H\u0016J\f\u0010 \u001a\u00020\f*\u00020!H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fRC\u0010\u0006\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\""}, d2 = {"Landroidx/compose/animation/SizeAnimationModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/animation/SizeAnimationModifierNode;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntSize;", "finishedListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "initialValue", "targetValue", "", "(Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function2;)V", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "getFinishedListener", "()Lkotlin/jvm/functions/Function2;", "component1", "component2", "copy", "create", "equals", "", "other", "", "hashCode", "", "toString", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimationModifier.kt */
final class SizeAnimationModifierElement extends ModifierNodeElement<SizeAnimationModifierNode> {
    private final FiniteAnimationSpec<IntSize> animationSpec;
    private final Function2<IntSize, IntSize, Unit> finishedListener;

    public static /* synthetic */ SizeAnimationModifierElement copy$default(SizeAnimationModifierElement sizeAnimationModifierElement, FiniteAnimationSpec<IntSize> finiteAnimationSpec, Function2<IntSize, IntSize, Unit> function2, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = sizeAnimationModifierElement.animationSpec;
        }
        if ((i & 2) != 0) {
            function2 = sizeAnimationModifierElement.finishedListener;
        }
        return sizeAnimationModifierElement.copy(finiteAnimationSpec, function2);
    }

    public final FiniteAnimationSpec<IntSize> component1() {
        return this.animationSpec;
    }

    public final Function2<IntSize, IntSize, Unit> component2() {
        return this.finishedListener;
    }

    public final SizeAnimationModifierElement copy(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Function2<? super IntSize, ? super IntSize, Unit> function2) {
        return new SizeAnimationModifierElement(finiteAnimationSpec, function2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SizeAnimationModifierElement)) {
            return false;
        }
        SizeAnimationModifierElement sizeAnimationModifierElement = (SizeAnimationModifierElement) obj;
        return Intrinsics.areEqual((Object) this.animationSpec, (Object) sizeAnimationModifierElement.animationSpec) && Intrinsics.areEqual((Object) this.finishedListener, (Object) sizeAnimationModifierElement.finishedListener);
    }

    public int hashCode() {
        int hashCode = this.animationSpec.hashCode() * 31;
        Function2<IntSize, IntSize, Unit> function2 = this.finishedListener;
        return hashCode + (function2 == null ? 0 : function2.hashCode());
    }

    public String toString() {
        return "SizeAnimationModifierElement(animationSpec=" + this.animationSpec + ", finishedListener=" + this.finishedListener + ')';
    }

    public final FiniteAnimationSpec<IntSize> getAnimationSpec() {
        return this.animationSpec;
    }

    public final Function2<IntSize, IntSize, Unit> getFinishedListener() {
        return this.finishedListener;
    }

    public SizeAnimationModifierElement(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Function2<? super IntSize, ? super IntSize, Unit> function2) {
        this.animationSpec = finiteAnimationSpec;
        this.finishedListener = function2;
    }

    public SizeAnimationModifierNode create() {
        return new SizeAnimationModifierNode(this.animationSpec, this.finishedListener);
    }

    public void update(SizeAnimationModifierNode sizeAnimationModifierNode) {
        sizeAnimationModifierNode.setAnimationSpec(this.animationSpec);
        sizeAnimationModifierNode.setListener(this.finishedListener);
    }

    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("animateContentSize");
        inspectorInfo.getProperties().set("animationSpec", this.animationSpec);
        inspectorInfo.getProperties().set("finishedListener", this.finishedListener);
    }
}
