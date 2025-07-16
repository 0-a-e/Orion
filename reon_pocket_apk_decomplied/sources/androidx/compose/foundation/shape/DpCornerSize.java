package androidx.compose.foundation.shape;

import androidx.compose.ui.platform.InspectableValue;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.Sequence;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\n\u001a\u00020\u0004HÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\tJ\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u0016\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00048VX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/shape/DpCornerSize;", "Landroidx/compose/foundation/shape/CornerSize;", "Landroidx/compose/ui/platform/InspectableValue;", "size", "Landroidx/compose/ui/unit/Dp;", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "valueOverride", "getValueOverride-D9Ej5fM", "()F", "component1", "component1-D9Ej5fM", "copy", "copy-0680j_4", "(F)Landroidx/compose/foundation/shape/DpCornerSize;", "equals", "", "other", "", "hashCode", "", "toPx", "", "shapeSize", "Landroidx/compose/ui/geometry/Size;", "density", "Landroidx/compose/ui/unit/Density;", "toPx-TmRCtEA", "(JLandroidx/compose/ui/unit/Density;)F", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CornerSize.kt */
final class DpCornerSize implements CornerSize, InspectableValue {
    private final float size;

    public /* synthetic */ DpCornerSize(float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(f);
    }

    /* renamed from: component1-D9Ej5fM  reason: not valid java name */
    private final float m1030component1D9Ej5fM() {
        return this.size;
    }

    /* renamed from: copy-0680j_4$default  reason: not valid java name */
    public static /* synthetic */ DpCornerSize m1031copy0680j_4$default(DpCornerSize dpCornerSize, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = dpCornerSize.size;
        }
        return dpCornerSize.m1032copy0680j_4(f);
    }

    /* renamed from: copy-0680j_4  reason: not valid java name */
    public final DpCornerSize m1032copy0680j_4(float f) {
        return new DpCornerSize(f, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DpCornerSize) && Dp.m6619equalsimpl0(this.size, ((DpCornerSize) obj).size);
    }

    public /* synthetic */ Sequence getInspectableElements() {
        return InspectableValue.CC.$default$getInspectableElements(this);
    }

    public /* synthetic */ String getNameFallback() {
        return InspectableValue.CC.$default$getNameFallback(this);
    }

    public int hashCode() {
        return Dp.m6620hashCodeimpl(this.size);
    }

    private DpCornerSize(float f) {
        this.size = f;
    }

    public /* bridge */ /* synthetic */ Object getValueOverride() {
        return Dp.m6612boximpl(m1033getValueOverrideD9Ej5fM());
    }

    /* renamed from: toPx-TmRCtEA  reason: not valid java name */
    public float m1034toPxTmRCtEA(long j, Density density) {
        return density.m6550toPx0680j_4(this.size);
    }

    public String toString() {
        return "CornerSize(size = " + this.size + ".dp)";
    }

    /* renamed from: getValueOverride-D9Ej5fM  reason: not valid java name */
    public float m1033getValueOverrideD9Ej5fM() {
        return this.size;
    }
}
