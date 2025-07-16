package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a2\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a*\u0010\u0010\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a2\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a!\u0010\u0017\u001a\u00020\u0006*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u001b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"BigConstraintValue", "", "MediumConstraintValue", "SmallConstraintValue", "TinyConstraintValue", "finalConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxIntrinsicWidth", "", "finalConstraints-tfFHcEY", "(JZIF)J", "finalMaxLines", "maxLinesIn", "finalMaxLines-xdlQI24", "(ZII)I", "finalMaxWidth", "finalMaxWidth-tfFHcEY", "(JZIF)I", "fixedCoerceHeightAndWidthForBits", "Landroidx/compose/ui/unit/Constraints$Companion;", "width", "height", "(Landroidx/compose/ui/unit/Constraints$Companion;II)J", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutUtils.kt */
public final class LayoutUtilsKt {
    private static final int BigConstraintValue = 262143;
    private static final int MediumConstraintValue = 65535;
    private static final int SmallConstraintValue = 32767;
    private static final int TinyConstraintValue = 8191;

    /* renamed from: finalConstraints-tfFHcEY  reason: not valid java name */
    public static final long m1173finalConstraintstfFHcEY(long j, boolean z, int i, float f) {
        return ConstraintsKt.Constraints$default(0, m1175finalMaxWidthtfFHcEY(j, z, i, f), 0, Constraints.m6525getMaxHeightimpl(j), 5, (Object) null);
    }

    /* renamed from: finalMaxWidth-tfFHcEY  reason: not valid java name */
    public static final int m1175finalMaxWidthtfFHcEY(long j, boolean z, int i, float f) {
        int i2;
        if ((z || TextOverflow.m6504equalsimpl0(i, TextOverflow.Companion.m6512getEllipsisgIe3tQ8())) && Constraints.m6522getHasBoundedWidthimpl(j)) {
            i2 = Constraints.m6526getMaxWidthimpl(j);
        } else {
            i2 = Integer.MAX_VALUE;
        }
        return Constraints.m6528getMinWidthimpl(j) == i2 ? i2 : RangesKt.coerceIn(TextDelegateKt.ceilToIntPx(f), Constraints.m6528getMinWidthimpl(j), i2);
    }

    /* renamed from: finalMaxLines-xdlQI24  reason: not valid java name */
    public static final int m1174finalMaxLinesxdlQI24(boolean z, int i, int i2) {
        if (z || !TextOverflow.m6504equalsimpl0(i, TextOverflow.Companion.m6512getEllipsisgIe3tQ8())) {
            return RangesKt.coerceAtLeast(i2, 1);
        }
        return 1;
    }

    public static final long fixedCoerceHeightAndWidthForBits(Constraints.Companion companion, int i, int i2) {
        int i3;
        int min = Math.min(i, 262142);
        if (min < TinyConstraintValue) {
            i3 = Math.min(i2, 262142);
        } else if (min < 32767) {
            i3 = Math.min(i2, 65534);
        } else if (min < 65535) {
            i3 = Math.min(i2, 32766);
        } else {
            i3 = Math.min(i2, 8190);
        }
        return companion.m6534fixedJhjzzOo(min, i3);
    }
}
