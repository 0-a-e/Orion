package androidx.compose.ui.focus;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\f\u0010\r\u001a\u00020\u000b*\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"androidx/compose/ui/focus/FocusOwnerImpl$modifier$1", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/focus/FocusTargetNode;", "create", "equals", "", "other", "", "hashCode", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusOwnerImpl.kt */
public final class FocusOwnerImpl$modifier$1 extends ModifierNodeElement<FocusTargetNode> {
    final /* synthetic */ FocusOwnerImpl this$0;

    public boolean equals(Object obj) {
        return obj == this;
    }

    public void update(FocusTargetNode focusTargetNode) {
    }

    FocusOwnerImpl$modifier$1(FocusOwnerImpl focusOwnerImpl) {
        this.this$0 = focusOwnerImpl;
    }

    public FocusTargetNode create() {
        return this.this$0.getRootFocusNode$ui_release();
    }

    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("RootFocusTarget");
    }

    public int hashCode() {
        return this.this$0.getRootFocusNode$ui_release().hashCode();
    }
}
