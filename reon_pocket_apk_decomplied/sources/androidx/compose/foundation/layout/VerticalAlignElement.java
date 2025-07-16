package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\f\u0010\u0012\u001a\u00020\u0010*\u00020\u0013H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/layout/VerticalAlignElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/VerticalAlignNode;", "alignment", "Landroidx/compose/ui/Alignment$Vertical;", "(Landroidx/compose/ui/Alignment$Vertical;)V", "getAlignment", "()Landroidx/compose/ui/Alignment$Vertical;", "create", "equals", "", "other", "", "hashCode", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RowColumnImpl.kt */
public final class VerticalAlignElement extends ModifierNodeElement<VerticalAlignNode> {
    public static final int $stable = 0;
    private final Alignment.Vertical alignment;

    public final Alignment.Vertical getAlignment() {
        return this.alignment;
    }

    public VerticalAlignElement(Alignment.Vertical vertical) {
        this.alignment = vertical;
    }

    public VerticalAlignNode create() {
        return new VerticalAlignNode(this.alignment);
    }

    public void update(VerticalAlignNode verticalAlignNode) {
        verticalAlignNode.setVertical(this.alignment);
    }

    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("align");
        inspectorInfo.setValue(this.alignment);
    }

    public int hashCode() {
        return this.alignment.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        VerticalAlignElement verticalAlignElement = obj instanceof VerticalAlignElement ? (VerticalAlignElement) obj : null;
        if (verticalAlignElement == null) {
            return false;
        }
        return Intrinsics.areEqual((Object) this.alignment, (Object) verticalAlignElement.alignment);
    }
}
