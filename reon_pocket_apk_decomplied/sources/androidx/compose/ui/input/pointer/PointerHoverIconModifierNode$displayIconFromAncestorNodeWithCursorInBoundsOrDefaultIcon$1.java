package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/input/pointer/PointerHoverIconModifierNode;", "invoke", "(Landroidx/compose/ui/input/pointer/PointerHoverIconModifierNode;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PointerIcon.kt */
final class PointerHoverIconModifierNode$displayIconFromAncestorNodeWithCursorInBoundsOrDefaultIcon$1 extends Lambda implements Function1<PointerHoverIconModifierNode, Boolean> {
    final /* synthetic */ Ref.ObjectRef<PointerHoverIconModifierNode> $pointerHoverIconModifierNode;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PointerHoverIconModifierNode$displayIconFromAncestorNodeWithCursorInBoundsOrDefaultIcon$1(Ref.ObjectRef<PointerHoverIconModifierNode> objectRef) {
        super(1);
        this.$pointerHoverIconModifierNode = objectRef;
    }

    public final Boolean invoke(PointerHoverIconModifierNode pointerHoverIconModifierNode) {
        if (this.$pointerHoverIconModifierNode.element == null && pointerHoverIconModifierNode.cursorInBoundsOfNode) {
            this.$pointerHoverIconModifierNode.element = pointerHoverIconModifierNode;
        } else if (this.$pointerHoverIconModifierNode.element != null && pointerHoverIconModifierNode.getOverrideDescendants() && pointerHoverIconModifierNode.cursorInBoundsOfNode) {
            this.$pointerHoverIconModifierNode.element = pointerHoverIconModifierNode;
        }
        return true;
    }
}
