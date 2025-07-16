package androidx.compose.foundation;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BD\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000f¢\u0006\u0002\u0010\u0010J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\f\u0010\u001b\u001a\u00020\u000e*\u00020\rH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0011R\u001f\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/BackgroundElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/BackgroundNode;", "color", "Landroidx/compose/ui/graphics/Color;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(JLandroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "create", "equals", "", "other", "", "hashCode", "", "update", "node", "inspectableProperties", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Background.kt */
final class BackgroundElement extends ModifierNodeElement<BackgroundNode> {
    private final float alpha;
    private final Brush brush;
    private final long color;
    private final Function1<InspectorInfo, Unit> inspectorInfo;
    private final Shape shape;

    public /* synthetic */ BackgroundElement(long j, Brush brush2, float f, Shape shape2, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, brush2, f, shape2, function1);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BackgroundElement(long j, Brush brush2, float f, Shape shape2, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Color.Companion.m3852getUnspecified0d7_KjU() : j, (i & 2) != 0 ? null : brush2, f, shape2, function1, (DefaultConstructorMarker) null);
    }

    private BackgroundElement(long j, Brush brush2, float f, Shape shape2, Function1<? super InspectorInfo, Unit> function1) {
        this.color = j;
        this.brush = brush2;
        this.alpha = f;
        this.shape = shape2;
        this.inspectorInfo = function1;
    }

    public BackgroundNode create() {
        return new BackgroundNode(this.color, this.brush, this.alpha, this.shape, (DefaultConstructorMarker) null);
    }

    public void update(BackgroundNode backgroundNode) {
        backgroundNode.m216setColor8_81llA(this.color);
        backgroundNode.setBrush(this.brush);
        backgroundNode.setAlpha(this.alpha);
        backgroundNode.setShape(this.shape);
    }

    public void inspectableProperties(InspectorInfo inspectorInfo2) {
        this.inspectorInfo.invoke(inspectorInfo2);
    }

    public int hashCode() {
        int r0 = Color.m3823hashCodeimpl(this.color) * 31;
        Brush brush2 = this.brush;
        return ((((r0 + (brush2 != null ? brush2.hashCode() : 0)) * 31) + Float.floatToIntBits(this.alpha)) * 31) + this.shape.hashCode();
    }

    public boolean equals(Object obj) {
        BackgroundElement backgroundElement = obj instanceof BackgroundElement ? (BackgroundElement) obj : null;
        if (backgroundElement != null && Color.m3817equalsimpl0(this.color, backgroundElement.color) && Intrinsics.areEqual((Object) this.brush, (Object) backgroundElement.brush) && this.alpha == backgroundElement.alpha && Intrinsics.areEqual((Object) this.shape, (Object) backgroundElement.shape)) {
            return true;
        }
        return false;
    }
}
