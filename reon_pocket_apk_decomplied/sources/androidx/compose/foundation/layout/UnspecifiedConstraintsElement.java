package androidx.compose.foundation.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\f\u0010\u0015\u001a\u00020\u0013*\u00020\u0016H\u0016R\u0019\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/layout/UnspecifiedConstraintsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/UnspecifiedConstraintsNode;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMinHeight-D9Ej5fM", "()F", "F", "getMinWidth-D9Ej5fM", "create", "equals", "", "other", "", "hashCode", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Size.kt */
final class UnspecifiedConstraintsElement extends ModifierNodeElement<UnspecifiedConstraintsNode> {
    private final float minHeight;
    private final float minWidth;

    public /* synthetic */ UnspecifiedConstraintsElement(float f, float f2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UnspecifiedConstraintsElement(float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dp.Companion.m6634getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? Dp.Companion.m6634getUnspecifiedD9Ej5fM() : f2, (DefaultConstructorMarker) null);
    }

    /* renamed from: getMinWidth-D9Ej5fM  reason: not valid java name */
    public final float m762getMinWidthD9Ej5fM() {
        return this.minWidth;
    }

    /* renamed from: getMinHeight-D9Ej5fM  reason: not valid java name */
    public final float m761getMinHeightD9Ej5fM() {
        return this.minHeight;
    }

    private UnspecifiedConstraintsElement(float f, float f2) {
        this.minWidth = f;
        this.minHeight = f2;
    }

    public UnspecifiedConstraintsNode create() {
        return new UnspecifiedConstraintsNode(this.minWidth, this.minHeight, (DefaultConstructorMarker) null);
    }

    public void update(UnspecifiedConstraintsNode unspecifiedConstraintsNode) {
        unspecifiedConstraintsNode.m767setMinWidth0680j_4(this.minWidth);
        unspecifiedConstraintsNode.m766setMinHeight0680j_4(this.minHeight);
    }

    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("defaultMinSize");
        inspectorInfo.getProperties().set("minWidth", Dp.m6612boximpl(this.minWidth));
        inspectorInfo.getProperties().set("minHeight", Dp.m6612boximpl(this.minHeight));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof UnspecifiedConstraintsElement)) {
            return false;
        }
        UnspecifiedConstraintsElement unspecifiedConstraintsElement = (UnspecifiedConstraintsElement) obj;
        if (!Dp.m6619equalsimpl0(this.minWidth, unspecifiedConstraintsElement.minWidth) || !Dp.m6619equalsimpl0(this.minHeight, unspecifiedConstraintsElement.minHeight)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (Dp.m6620hashCodeimpl(this.minWidth) * 31) + Dp.m6620hashCodeimpl(this.minHeight);
    }
}
