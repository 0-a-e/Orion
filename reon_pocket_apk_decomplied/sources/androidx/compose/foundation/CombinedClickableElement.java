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

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bc\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\f\u0010\u001a\u001a\u00020\r*\u00020\u001bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/CombinedClickableElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/CombinedClickableNodeImpl;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "onLongClickLabel", "onLongClick", "onDoubleClick", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "create", "equals", "other", "", "hashCode", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Clickable.kt */
final class CombinedClickableElement extends ModifierNodeElement<CombinedClickableNodeImpl> {
    private final boolean enabled;
    private final MutableInteractionSource interactionSource;
    private final Function0<Unit> onClick;
    private final String onClickLabel;
    private final Function0<Unit> onDoubleClick;
    private final Function0<Unit> onLongClick;
    private final String onLongClickLabel;
    private final Role role;

    public /* synthetic */ CombinedClickableElement(MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role2, Function0 function0, String str2, Function0 function02, Function0 function03, DefaultConstructorMarker defaultConstructorMarker) {
        this(mutableInteractionSource, z, str, role2, function0, str2, function02, function03);
    }

    public void inspectableProperties(InspectorInfo inspectorInfo) {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CombinedClickableElement(MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role2, Function0 function0, String str2, Function0 function02, Function0 function03, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(mutableInteractionSource, z, str, (i & 8) != 0 ? null : role2, function0, str2, function02, function03, (DefaultConstructorMarker) null);
    }

    private CombinedClickableElement(MutableInteractionSource mutableInteractionSource, boolean z, String str, Role role2, Function0<Unit> function0, String str2, Function0<Unit> function02, Function0<Unit> function03) {
        this.interactionSource = mutableInteractionSource;
        this.enabled = z;
        this.onClickLabel = str;
        this.role = role2;
        this.onClick = function0;
        this.onLongClickLabel = str2;
        this.onLongClick = function02;
        this.onDoubleClick = function03;
    }

    public CombinedClickableNodeImpl create() {
        return new CombinedClickableNodeImpl(this.onClick, this.onLongClickLabel, this.onLongClick, this.onDoubleClick, this.interactionSource, this.enabled, this.onClickLabel, this.role, (DefaultConstructorMarker) null);
    }

    public void update(CombinedClickableNodeImpl combinedClickableNodeImpl) {
        combinedClickableNodeImpl.m267updatexpl5gLE(this.onClick, this.onLongClickLabel, this.onLongClick, this.onDoubleClick, this.interactionSource, this.enabled, this.onClickLabel, this.role);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CombinedClickableElement combinedClickableElement = (CombinedClickableElement) obj;
        return Intrinsics.areEqual((Object) this.interactionSource, (Object) combinedClickableElement.interactionSource) && this.enabled == combinedClickableElement.enabled && Intrinsics.areEqual((Object) this.onClickLabel, (Object) combinedClickableElement.onClickLabel) && Intrinsics.areEqual((Object) this.role, (Object) combinedClickableElement.role) && Intrinsics.areEqual((Object) this.onClick, (Object) combinedClickableElement.onClick) && Intrinsics.areEqual((Object) this.onLongClickLabel, (Object) combinedClickableElement.onLongClickLabel) && Intrinsics.areEqual((Object) this.onLongClick, (Object) combinedClickableElement.onLongClick) && Intrinsics.areEqual((Object) this.onDoubleClick, (Object) combinedClickableElement.onDoubleClick);
    }

    public int hashCode() {
        int hashCode = ((this.interactionSource.hashCode() * 31) + UByte$$ExternalSyntheticBackport0.m(this.enabled)) * 31;
        String str = this.onClickLabel;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Role role2 = this.role;
        int r0 = (((hashCode2 + (role2 != null ? Role.m5861hashCodeimpl(role2.m5863unboximpl()) : 0)) * 31) + this.onClick.hashCode()) * 31;
        String str2 = this.onLongClickLabel;
        int hashCode3 = (r0 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Function0<Unit> function0 = this.onLongClick;
        int hashCode4 = (hashCode3 + (function0 != null ? function0.hashCode() : 0)) * 31;
        Function0<Unit> function02 = this.onDoubleClick;
        if (function02 != null) {
            i = function02.hashCode();
        }
        return hashCode4 + i;
    }
}
