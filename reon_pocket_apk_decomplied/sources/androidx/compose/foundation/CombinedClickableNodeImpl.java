package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002Ba\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011Jl\u0010\u001a\u001a\u00020\u00052\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016ø\u0001\u0000¢\u0006\u0002\b\u001bR\u0014\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/CombinedClickableNodeImpl;", "Landroidx/compose/foundation/CombinedClickableNode;", "Landroidx/compose/foundation/AbstractClickableNode;", "onClick", "Lkotlin/Function0;", "", "onLongClickLabel", "", "onLongClick", "onDoubleClick", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "enabled", "", "onClickLabel", "role", "Landroidx/compose/ui/semantics/Role;", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/MutableInteractionSource;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "clickablePointerInputNode", "Landroidx/compose/foundation/CombinedClickablePointerInputNode;", "getClickablePointerInputNode", "()Landroidx/compose/foundation/CombinedClickablePointerInputNode;", "clickableSemanticsNode", "Landroidx/compose/foundation/ClickableSemanticsNode;", "getClickableSemanticsNode", "()Landroidx/compose/foundation/ClickableSemanticsNode;", "update", "update-xpl5gLE", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Clickable.kt */
final class CombinedClickableNodeImpl extends AbstractClickableNode implements CombinedClickableNode {
    private final CombinedClickablePointerInputNode clickablePointerInputNode;
    private final ClickableSemanticsNode clickableSemanticsNode;
    private Function0<Unit> onLongClick;

    public /* synthetic */ CombinedClickableNodeImpl(Function0 function0, String str, Function0 function02, Function0 function03, MutableInteractionSource mutableInteractionSource, boolean z, String str2, Role role, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, str, function02, function03, mutableInteractionSource, z, str2, role);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private CombinedClickableNodeImpl(Function0<Unit> function0, String str, Function0<Unit> function02, Function0<Unit> function03, MutableInteractionSource mutableInteractionSource, boolean z, String str2, Role role) {
        super(mutableInteractionSource, z, str2, role, function0, (DefaultConstructorMarker) null);
        this.onLongClick = function02;
        boolean z2 = z;
        this.clickableSemanticsNode = (ClickableSemanticsNode) delegate(new ClickableSemanticsNode(z2, str2, role, function0, str, function02, (DefaultConstructorMarker) null));
        this.clickablePointerInputNode = (CombinedClickablePointerInputNode) delegate(new CombinedClickablePointerInputNode(z2, mutableInteractionSource, function0, getInteractionData(), this.onLongClick, function03));
    }

    public ClickableSemanticsNode getClickableSemanticsNode() {
        return this.clickableSemanticsNode;
    }

    public CombinedClickablePointerInputNode getClickablePointerInputNode() {
        return this.clickablePointerInputNode;
    }

    /* renamed from: update-xpl5gLE  reason: not valid java name */
    public void m267updatexpl5gLE(Function0<Unit> function0, String str, Function0<Unit> function02, Function0<Unit> function03, MutableInteractionSource mutableInteractionSource, boolean z, String str2, Role role) {
        Function0<Unit> function04 = function02;
        boolean z2 = true;
        boolean z3 = this.onLongClick == null;
        if (function04 != null) {
            z2 = false;
        }
        if (z3 != z2) {
            disposeInteractionSource();
        }
        this.onLongClick = function04;
        m184updateCommonXHw0xAI(mutableInteractionSource, z, str2, role, function0);
        getClickableSemanticsNode().m260updateUMe6uN4(z, str2, role, function0, str, function02);
        getClickablePointerInputNode().update(z, mutableInteractionSource, function0, function02, function03);
    }
}
