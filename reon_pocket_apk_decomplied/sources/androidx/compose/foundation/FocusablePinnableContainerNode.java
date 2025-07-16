package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.PinnableContainer;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/FocusablePinnableContainerNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "()V", "isFocused", "", "pinnedHandle", "Landroidx/compose/ui/layout/PinnableContainer$PinnedHandle;", "onObservedReadsChanged", "", "onReset", "retrievePinnableContainer", "Landroidx/compose/ui/layout/PinnableContainer;", "setFocus", "focused", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Focusable.kt */
final class FocusablePinnableContainerNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, ObserverModifierNode {
    private boolean isFocused;
    private PinnableContainer.PinnedHandle pinnedHandle;

    private final PinnableContainer retrievePinnableContainer() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ObserverModifierNodeKt.observeReads(this, new FocusablePinnableContainerNode$retrievePinnableContainer$1(objectRef, this));
        return (PinnableContainer) objectRef.element;
    }

    public final void setFocus(boolean z) {
        PinnableContainer.PinnedHandle pinnedHandle2 = null;
        if (z) {
            PinnableContainer retrievePinnableContainer = retrievePinnableContainer();
            if (retrievePinnableContainer != null) {
                pinnedHandle2 = retrievePinnableContainer.pin();
            }
            this.pinnedHandle = pinnedHandle2;
        } else {
            PinnableContainer.PinnedHandle pinnedHandle3 = this.pinnedHandle;
            if (pinnedHandle3 != null) {
                pinnedHandle3.release();
            }
            this.pinnedHandle = null;
        }
        this.isFocused = z;
    }

    public void onReset() {
        PinnableContainer.PinnedHandle pinnedHandle2 = this.pinnedHandle;
        if (pinnedHandle2 != null) {
            pinnedHandle2.release();
        }
        this.pinnedHandle = null;
    }

    public void onObservedReadsChanged() {
        PinnableContainer retrievePinnableContainer = retrievePinnableContainer();
        if (this.isFocused) {
            PinnableContainer.PinnedHandle pinnedHandle2 = this.pinnedHandle;
            if (pinnedHandle2 != null) {
                pinnedHandle2.release();
            }
            this.pinnedHandle = retrievePinnableContainer != null ? retrievePinnableContainer.pin() : null;
        }
    }
}
