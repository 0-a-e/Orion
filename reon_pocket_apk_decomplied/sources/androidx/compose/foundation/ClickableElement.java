package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\f\u0010\u0017\u001a\u00020\r*\u00020\u0018H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/ClickableElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/ClickableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "create", "equals", "other", "", "hashCode", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Clickable.kt */
final class ClickableElement extends ModifierNodeElement<ClickableNode> {
    private final boolean enabled;
    private final MutableInteractionSource interactionSource;
    private final Function0<Unit> onClick;
    private final String onClickLabel;
    private final Role role;

    public /* synthetic */ ClickableElement(MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role2, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(mutableInteractionSource, z, str, role2, function0);
    }

    public void inspectableProperties(InspectorInfo inspectorInfo) {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ClickableElement(MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role2, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(mutableInteractionSource, z, str, (i & 8) != 0 ? null : role2, function0, (DefaultConstructorMarker) null);
    }

    private ClickableElement(MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role2, Function0<Unit> function0) {
        this.interactionSource = mutableInteractionSource;
        this.enabled = z;
        this.onClickLabel = str;
        this.role = role2;
        this.onClick = function0;
    }

    public ClickableNode create() {
        return new ClickableNode(this.interactionSource, this.enabled, this.onClickLabel, this.role, this.onClick, (DefaultConstructorMarker) null);
    }

    public void update(ClickableNode clickableNode) {
        clickableNode.m257updateXHw0xAI(this.interactionSource, this.enabled, this.onClickLabel, this.role, this.onClick);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ClickableElement clickableElement = (ClickableElement) obj;
        return Intrinsics.areEqual((Object) this.interactionSource, (Object) clickableElement.interactionSource) && this.enabled == clickableElement.enabled && Intrinsics.areEqual((Object) this.onClickLabel, (Object) clickableElement.onClickLabel) && Intrinsics.areEqual((Object) this.role, (Object) clickableElement.role) && Intrinsics.areEqual((Object) this.onClick, (Object) clickableElement.onClick);
    }

    public int hashCode() {
        int hashCode = ((this.interactionSource.hashCode() * 31) + UByte$$ExternalSyntheticBackport0.m(this.enabled)) * 31;
        String str = this.onClickLabel;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Role role2 = this.role;
        if (role2 != null) {
            i = Role.m5861hashCodeimpl(role2.m5863unboximpl());
        }
        return ((hashCode2 + i) * 31) + this.onClick.hashCode();
    }
}
