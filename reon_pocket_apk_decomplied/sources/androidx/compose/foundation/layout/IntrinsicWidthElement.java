package androidx.compose.foundation.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B.\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\f\u0010\u001b\u001a\u00020\n*\u00020\tH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/layout/IntrinsicWidthElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/IntrinsicWidthNode;", "width", "Landroidx/compose/foundation/layout/IntrinsicSize;", "enforceIncoming", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/layout/IntrinsicSize;ZLkotlin/jvm/functions/Function1;)V", "getEnforceIncoming", "()Z", "getInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "getWidth", "()Landroidx/compose/foundation/layout/IntrinsicSize;", "create", "equals", "other", "", "hashCode", "", "update", "node", "inspectableProperties", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Intrinsic.kt */
final class IntrinsicWidthElement extends ModifierNodeElement<IntrinsicWidthNode> {
    private final boolean enforceIncoming;
    private final Function1<InspectorInfo, Unit> inspectorInfo;
    private final IntrinsicSize width;

    public final IntrinsicSize getWidth() {
        return this.width;
    }

    public final boolean getEnforceIncoming() {
        return this.enforceIncoming;
    }

    public final Function1<InspectorInfo, Unit> getInspectorInfo() {
        return this.inspectorInfo;
    }

    public IntrinsicWidthElement(IntrinsicSize intrinsicSize, boolean z, Function1<? super InspectorInfo, Unit> function1) {
        this.width = intrinsicSize;
        this.enforceIncoming = z;
        this.inspectorInfo = function1;
    }

    public IntrinsicWidthNode create() {
        return new IntrinsicWidthNode(this.width, this.enforceIncoming);
    }

    public void update(IntrinsicWidthNode intrinsicWidthNode) {
        intrinsicWidthNode.setWidth(this.width);
        intrinsicWidthNode.setEnforceIncoming(this.enforceIncoming);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        IntrinsicWidthElement intrinsicWidthElement = obj instanceof IntrinsicWidthElement ? (IntrinsicWidthElement) obj : null;
        if (intrinsicWidthElement == null) {
            return false;
        }
        if (this.width == intrinsicWidthElement.width && this.enforceIncoming == intrinsicWidthElement.enforceIncoming) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.width.hashCode() * 31) + UByte$$ExternalSyntheticBackport0.m(this.enforceIncoming);
    }

    public void inspectableProperties(InspectorInfo inspectorInfo2) {
        this.inspectorInfo.invoke(inspectorInfo2);
    }
}
