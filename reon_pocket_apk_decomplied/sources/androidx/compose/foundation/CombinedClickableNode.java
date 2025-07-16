package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001Jl\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&ø\u0001\u0000¢\u0006\u0002\b\u0011\u0001\u0001\u0012ø\u0001\u0001\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/CombinedClickableNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "update", "", "onClick", "Lkotlin/Function0;", "onLongClickLabel", "", "onLongClick", "onDoubleClick", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "enabled", "", "onClickLabel", "role", "Landroidx/compose/ui/semantics/Role;", "update-xpl5gLE", "Landroidx/compose/foundation/CombinedClickableNodeImpl;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Clickable.kt */
public interface CombinedClickableNode extends PointerInputModifierNode {
    /* renamed from: update-xpl5gLE  reason: not valid java name */
    void m266updatexpl5gLE(Function0<Unit> function0, String str, Function0<Unit> function02, Function0<Unit> function03, MutableInteractionSource mutableInteractionSource, boolean z, String str2, Role role);
}
