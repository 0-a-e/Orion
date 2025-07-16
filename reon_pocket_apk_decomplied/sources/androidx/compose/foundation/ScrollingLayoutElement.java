package androidx.compose.foundation;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\b\u0010\f\u001a\u00020\u0002H\u0016J\u0013\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\f\u0010\u0015\u001a\u00020\u0013*\u00020\u0016H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\tR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/ScrollingLayoutElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/ScrollingLayoutNode;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "isReversed", "", "isVertical", "(Landroidx/compose/foundation/ScrollState;ZZ)V", "()Z", "getScrollState", "()Landroidx/compose/foundation/ScrollState;", "create", "equals", "other", "", "hashCode", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scroll.kt */
public final class ScrollingLayoutElement extends ModifierNodeElement<ScrollingLayoutNode> {
    public static final int $stable = 0;
    private final boolean isReversed;
    private final boolean isVertical;
    private final ScrollState scrollState;

    public final ScrollState getScrollState() {
        return this.scrollState;
    }

    public final boolean isReversed() {
        return this.isReversed;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public ScrollingLayoutElement(ScrollState scrollState2, boolean z, boolean z2) {
        this.scrollState = scrollState2;
        this.isReversed = z;
        this.isVertical = z2;
    }

    public ScrollingLayoutNode create() {
        return new ScrollingLayoutNode(this.scrollState, this.isReversed, this.isVertical);
    }

    public void update(ScrollingLayoutNode scrollingLayoutNode) {
        scrollingLayoutNode.setScrollerState(this.scrollState);
        scrollingLayoutNode.setReversed(this.isReversed);
        scrollingLayoutNode.setVertical(this.isVertical);
    }

    public int hashCode() {
        return (((this.scrollState.hashCode() * 31) + UByte$$ExternalSyntheticBackport0.m(this.isReversed)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.isVertical);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ScrollingLayoutElement)) {
            return false;
        }
        ScrollingLayoutElement scrollingLayoutElement = (ScrollingLayoutElement) obj;
        if (Intrinsics.areEqual((Object) this.scrollState, (Object) scrollingLayoutElement.scrollState) && this.isReversed == scrollingLayoutElement.isReversed && this.isVertical == scrollingLayoutElement.isVertical) {
            return true;
        }
        return false;
    }

    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("layoutInScroll");
        inspectorInfo.getProperties().set("state", this.scrollState);
        inspectorInfo.getProperties().set("isReversed", Boolean.valueOf(this.isReversed));
        inspectorInfo.getProperties().set("isVertical", Boolean.valueOf(this.isVertical));
    }
}
