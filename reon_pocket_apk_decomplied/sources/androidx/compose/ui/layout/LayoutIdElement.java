package androidx.compose.ui.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0004HÂ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\f\u0010\u0013\u001a\u00020\u0011*\u00020\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/layout/LayoutIdElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/layout/LayoutIdModifier;", "layoutId", "", "(Ljava/lang/Object;)V", "component1", "copy", "create", "equals", "", "other", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutId.kt */
final class LayoutIdElement extends ModifierNodeElement<LayoutIdModifier> {
    private final Object layoutId;

    private final Object component1() {
        return this.layoutId;
    }

    public static /* synthetic */ LayoutIdElement copy$default(LayoutIdElement layoutIdElement, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = layoutIdElement.layoutId;
        }
        return layoutIdElement.copy(obj);
    }

    public final LayoutIdElement copy(Object obj) {
        return new LayoutIdElement(obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LayoutIdElement) && Intrinsics.areEqual(this.layoutId, ((LayoutIdElement) obj).layoutId);
    }

    public int hashCode() {
        return this.layoutId.hashCode();
    }

    public String toString() {
        return "LayoutIdElement(layoutId=" + this.layoutId + ')';
    }

    public LayoutIdElement(Object obj) {
        this.layoutId = obj;
    }

    public LayoutIdModifier create() {
        return new LayoutIdModifier(this.layoutId);
    }

    public void update(LayoutIdModifier layoutIdModifier) {
        layoutIdModifier.setLayoutId$ui_release(this.layoutId);
    }

    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("layoutId");
        inspectorInfo.setValue(this.layoutId);
    }
}
