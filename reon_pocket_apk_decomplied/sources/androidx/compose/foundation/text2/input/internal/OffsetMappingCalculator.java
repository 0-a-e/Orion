package androidx.compose.foundation.text2.input.internal;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J%\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0011J=\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007R\u0016\u0010\u0003\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/OffsetMappingCalculator;", "", "()V", "ops", "Landroidx/compose/foundation/text2/input/internal/OpArray;", "[I", "opsSize", "", "map", "Landroidx/compose/ui/text/TextRange;", "offset", "fromSource", "", "map-fzxv0v0", "(IZ)J", "mapFromDest", "mapFromDest--jx7JFs", "(I)J", "mapFromSource", "mapFromSource--jx7JFs", "mapStep", "opOffset", "untransformedLen", "transformedLen", "mapStep-C6u-MEY", "(IIIIZ)J", "recordEditOperation", "", "sourceStart", "sourceEnd", "newLength", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: OffsetMappingCalculator.kt */
public final class OffsetMappingCalculator {
    public static final int $stable = 8;
    private int[] ops = OpArray.m1377constructorimpl(10);
    private int opsSize;

    public final void recordEditOperation(int i, int i2, int i3) {
        if (i3 >= 0) {
            int min = Math.min(i, i2);
            int max = Math.max(min, i2) - min;
            if (max >= 2 || max != i3) {
                int i4 = this.opsSize + 1;
                if (i4 > OpArray.m1384getSizeimpl(this.ops)) {
                    this.ops = OpArray.m1379copyOfS4kM8k(this.ops, Math.max(i4 * 2, OpArray.m1384getSizeimpl(this.ops) * 2));
                }
                OpArray.m1386setimpl(this.ops, this.opsSize, min, max, i3);
                this.opsSize = i4;
                return;
            }
            return;
        }
        throw new IllegalArgumentException(("Expected newLen to be ≥ 0, was " + i3).toString());
    }

    /* renamed from: mapFromSource--jx7JFs  reason: not valid java name */
    public final long m1375mapFromSourcejx7JFs(int i) {
        return m1372mapfzxv0v0(i, true);
    }

    /* renamed from: mapFromDest--jx7JFs  reason: not valid java name */
    public final long m1374mapFromDestjx7JFs(int i) {
        return m1372mapfzxv0v0(i, false);
    }

    /* renamed from: map-fzxv0v0  reason: not valid java name */
    private final long m1372mapfzxv0v0(int i, boolean z) {
        int i2;
        int[] iArr = this.ops;
        int i3 = this.opsSize;
        boolean z2 = !z;
        if (i3 < 0) {
            i2 = i;
        } else if (z2) {
            int i4 = i3 - 1;
            int i5 = i;
            while (-1 < i4) {
                int i6 = i4 * 3;
                int i7 = iArr[i6];
                int i8 = iArr[i6 + 1];
                int i9 = iArr[i6 + 2];
                long r2 = m1373mapStepC6uMEY(i5, i7, i8, i9, z);
                long r4 = m1373mapStepC6uMEY(i, i7, i8, i9, z);
                i4--;
                i5 = Math.min(TextRange.m6042getStartimpl(r2), TextRange.m6042getStartimpl(r4));
                i = Math.max(TextRange.m6037getEndimpl(r2), TextRange.m6037getEndimpl(r4));
            }
            i2 = i;
            i = i5;
        } else {
            int i10 = 0;
            int i11 = i;
            while (i10 < i3) {
                int i12 = i10 * 3;
                int i13 = iArr[i12];
                int i14 = iArr[i12 + 1];
                int i15 = iArr[i12 + 2];
                long r3 = m1373mapStepC6uMEY(i11, i13, i14, i15, z);
                long r5 = m1373mapStepC6uMEY(i, i13, i14, i15, z);
                i10++;
                i11 = Math.min(TextRange.m6042getStartimpl(r3), TextRange.m6042getStartimpl(r5));
                i = Math.max(TextRange.m6037getEndimpl(r3), TextRange.m6037getEndimpl(r5));
            }
            i2 = i;
            i = i11;
        }
        return TextRangeKt.TextRange(i, i2);
    }

    /* renamed from: mapStep-C6u-MEY  reason: not valid java name */
    private final long m1373mapStepC6uMEY(int i, int i2, int i3, int i4, boolean z) {
        int i5 = z ? i3 : i4;
        if (z) {
            i3 = i4;
        }
        if (i < i2) {
            return TextRangeKt.TextRange(i);
        }
        if (i == i2) {
            if (i5 == 0) {
                return TextRangeKt.TextRange(i2, i3 + i2);
            }
            return TextRangeKt.TextRange(i2);
        } else if (i >= i2 + i5) {
            return TextRangeKt.TextRange((i - i5) + i3);
        } else {
            if (i3 == 0) {
                return TextRangeKt.TextRange(i2);
            }
            return TextRangeKt.TextRange(i2, i3 + i2);
        }
    }
}
