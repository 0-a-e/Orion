package androidx.compose.foundation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\f\u0010\u0014\u001a\u00020\u0012*\u00020\u0015H\u0016R\u001f\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/PreferKeepClearElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/PreferKeepClearNode;", "clearRect", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Rect;", "(Lkotlin/jvm/functions/Function1;)V", "getClearRect", "()Lkotlin/jvm/functions/Function1;", "create", "equals", "", "other", "", "hashCode", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PreferKeepClear.android.kt */
final class PreferKeepClearElement extends ModifierNodeElement<PreferKeepClearNode> {
    private final Function1<LayoutCoordinates, Rect> clearRect;

    public final Function1<LayoutCoordinates, Rect> getClearRect() {
        return this.clearRect;
    }

    public PreferKeepClearElement(Function1<? super LayoutCoordinates, Rect> function1) {
        this.clearRect = function1;
    }

    public PreferKeepClearNode create() {
        return new PreferKeepClearNode(this.clearRect);
    }

    public void update(PreferKeepClearNode preferKeepClearNode) {
        preferKeepClearNode.setRect(this.clearRect);
    }

    public int hashCode() {
        Function1<LayoutCoordinates, Rect> function1 = this.clearRect;
        if (function1 != null) {
            return function1.hashCode();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PreferKeepClearNode)) {
            return false;
        }
        return Intrinsics.areEqual((Object) this.clearRect, (Object) ((PreferKeepClearNode) obj).getRect());
    }

    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("preferKeepClearBounds");
        if (this.clearRect != null) {
            inspectorInfo.getProperties().set("clearRect", this.clearRect);
        }
    }
}
