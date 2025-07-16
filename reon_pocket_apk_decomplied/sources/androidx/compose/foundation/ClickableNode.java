package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ@\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bø\u0001\u0000¢\u0006\u0002\b\u0017R\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"Landroidx/compose/foundation/ClickableNode;", "Landroidx/compose/foundation/AbstractClickableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "clickablePointerInputNode", "Landroidx/compose/foundation/ClickablePointerInputNode;", "getClickablePointerInputNode", "()Landroidx/compose/foundation/ClickablePointerInputNode;", "clickableSemanticsNode", "Landroidx/compose/foundation/ClickableSemanticsNode;", "getClickableSemanticsNode", "()Landroidx/compose/foundation/ClickableSemanticsNode;", "update", "update-XHw0xAI", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Clickable.kt */
final class ClickableNode extends AbstractClickableNode {
    private final ClickablePointerInputNode clickablePointerInputNode;
    private final ClickableSemanticsNode clickableSemanticsNode;

    public /* synthetic */ ClickableNode(MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(mutableInteractionSource, z, str, role, function0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ClickableNode(MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role, Function0<Unit> function0) {
        super(mutableInteractionSource, z, str, role, function0, (DefaultConstructorMarker) null);
        this.clickableSemanticsNode = (ClickableSemanticsNode) delegate(new ClickableSemanticsNode(z, str, role, function0, (String) null, (Function0) null, (DefaultConstructorMarker) null));
        boolean z2 = z;
        this.clickablePointerInputNode = (ClickablePointerInputNode) delegate(new ClickablePointerInputNode(z2, mutableInteractionSource, function0, getInteractionData()));
    }

    public ClickableSemanticsNode getClickableSemanticsNode() {
        return this.clickableSemanticsNode;
    }

    public ClickablePointerInputNode getClickablePointerInputNode() {
        return this.clickablePointerInputNode;
    }

    /* renamed from: update-XHw0xAI  reason: not valid java name */
    public final void m257updateXHw0xAI(MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role, Function0<Unit> function0) {
        m184updateCommonXHw0xAI(mutableInteractionSource, z, str, role, function0);
        getClickableSemanticsNode().m260updateUMe6uN4(z, str, role, function0, (String) null, (Function0<Unit>) null);
        getClickablePointerInputNode().update(z, mutableInteractionSource, function0);
    }
}
