package androidx.compose.foundation.shape;

import androidx.compose.ui.platform.InspectableValue;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.sequences.Sequence;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, d2 = {"androidx/compose/foundation/shape/CornerSizeKt$ZeroCornerSize$1", "Landroidx/compose/foundation/shape/CornerSize;", "Landroidx/compose/ui/platform/InspectableValue;", "valueOverride", "", "getValueOverride", "()Ljava/lang/String;", "toPx", "", "shapeSize", "Landroidx/compose/ui/geometry/Size;", "density", "Landroidx/compose/ui/unit/Density;", "toPx-TmRCtEA", "(JLandroidx/compose/ui/unit/Density;)F", "toString", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CornerSize.kt */
public final class CornerSizeKt$ZeroCornerSize$1 implements CornerSize, InspectableValue {
    public /* synthetic */ Sequence getInspectableElements() {
        return InspectableValue.CC.$default$getInspectableElements(this);
    }

    public /* synthetic */ String getNameFallback() {
        return InspectableValue.CC.$default$getNameFallback(this);
    }

    /* renamed from: toPx-TmRCtEA  reason: not valid java name */
    public float m1025toPxTmRCtEA(long j, Density density) {
        return 0.0f;
    }

    CornerSizeKt$ZeroCornerSize$1() {
    }

    public String toString() {
        return "ZeroCornerSize";
    }

    public String getValueOverride() {
        return "ZeroCornerSize";
    }
}
