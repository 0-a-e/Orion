package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0007\u0010\rB\u0011\b\u0002\u0012\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000fJ;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0011J\u0015\u0010 \u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b$\u0010\"J\u0013\u0010%\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010\u000fJ\u001b\u0010'\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010\rJ\u0010\u0010)\u001a\u00020*HÖ\u0001¢\u0006\u0004\b+\u0010,R\u0012\u0010\u0006\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0005\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0012\u0010\u0004\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0012\u0010\u0002\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\u000e\u001a\u00020\nX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015\u0001\u000e\u0001\u00020\n\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006-"}, d2 = {"Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "", "mainAxisMin", "", "mainAxisMax", "crossAxisMin", "crossAxisMax", "constructor-impl", "(IIII)J", "c", "Landroidx/compose/ui/unit/Constraints;", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "(JLandroidx/compose/foundation/layout/LayoutOrientation;)J", "value", "(J)J", "getCrossAxisMax-impl", "(J)I", "getCrossAxisMin-impl", "getMainAxisMax-impl", "getMainAxisMin-impl", "J", "copy", "copy-yUG9Ft0", "(JIIII)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "maxHeight", "maxHeight-impl", "(JLandroidx/compose/foundation/layout/LayoutOrientation;)I", "maxWidth", "maxWidth-impl", "stretchCrossAxis", "stretchCrossAxis-q4ezo7Y", "toBoxConstraints", "toBoxConstraints-OenEA2s", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: RowColumnImpl.kt */
public final class OrientationIndependentConstraints {
    private final long value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ OrientationIndependentConstraints m636boximpl(long j) {
        return new OrientationIndependentConstraints(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static long m638constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m642equalsimpl(long j, Object obj) {
        return (obj instanceof OrientationIndependentConstraints) && Constraints.m6519equalsimpl0(j, ((OrientationIndependentConstraints) obj).m654unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m643equalsimpl0(long j, long j2) {
        return Constraints.m6519equalsimpl0(j, j2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m648hashCodeimpl(long j) {
        return Constraints.m6529hashCodeimpl(j);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m653toStringimpl(long j) {
        return "OrientationIndependentConstraints(value=" + Constraints.m6531toStringimpl(j) + ')';
    }

    public boolean equals(Object obj) {
        return m642equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m648hashCodeimpl(this.value);
    }

    public String toString() {
        return m653toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m654unboximpl() {
        return this.value;
    }

    private /* synthetic */ OrientationIndependentConstraints(long j) {
        this.value = j;
    }

    /* renamed from: getMainAxisMin-impl  reason: not valid java name */
    public static final int m647getMainAxisMinimpl(long j) {
        return Constraints.m6528getMinWidthimpl(j);
    }

    /* renamed from: getMainAxisMax-impl  reason: not valid java name */
    public static final int m646getMainAxisMaximpl(long j) {
        return Constraints.m6526getMaxWidthimpl(j);
    }

    /* renamed from: getCrossAxisMin-impl  reason: not valid java name */
    public static final int m645getCrossAxisMinimpl(long j) {
        return Constraints.m6527getMinHeightimpl(j);
    }

    /* renamed from: getCrossAxisMax-impl  reason: not valid java name */
    public static final int m644getCrossAxisMaximpl(long j) {
        return Constraints.m6525getMaxHeightimpl(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m637constructorimpl(int i, int i2, int i3, int i4) {
        return m638constructorimpl(ConstraintsKt.Constraints(i, i2, i3, i4));
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m639constructorimpl(long j, LayoutOrientation layoutOrientation) {
        return m637constructorimpl(layoutOrientation == LayoutOrientation.Horizontal ? Constraints.m6528getMinWidthimpl(j) : Constraints.m6527getMinHeightimpl(j), layoutOrientation == LayoutOrientation.Horizontal ? Constraints.m6526getMaxWidthimpl(j) : Constraints.m6525getMaxHeightimpl(j), layoutOrientation == LayoutOrientation.Horizontal ? Constraints.m6527getMinHeightimpl(j) : Constraints.m6528getMinWidthimpl(j), layoutOrientation == LayoutOrientation.Horizontal ? Constraints.m6525getMaxHeightimpl(j) : Constraints.m6526getMaxWidthimpl(j));
    }

    /* renamed from: toBoxConstraints-OenEA2s  reason: not valid java name */
    public static final long m652toBoxConstraintsOenEA2s(long j, LayoutOrientation layoutOrientation) {
        if (layoutOrientation == LayoutOrientation.Horizontal) {
            return ConstraintsKt.Constraints(Constraints.m6528getMinWidthimpl(j), Constraints.m6526getMaxWidthimpl(j), Constraints.m6527getMinHeightimpl(j), Constraints.m6525getMaxHeightimpl(j));
        }
        return ConstraintsKt.Constraints(Constraints.m6527getMinHeightimpl(j), Constraints.m6525getMaxHeightimpl(j), Constraints.m6528getMinWidthimpl(j), Constraints.m6526getMaxWidthimpl(j));
    }

    /* renamed from: maxWidth-impl  reason: not valid java name */
    public static final int m650maxWidthimpl(long j, LayoutOrientation layoutOrientation) {
        if (layoutOrientation == LayoutOrientation.Horizontal) {
            return Constraints.m6526getMaxWidthimpl(j);
        }
        return Constraints.m6525getMaxHeightimpl(j);
    }

    /* renamed from: maxHeight-impl  reason: not valid java name */
    public static final int m649maxHeightimpl(long j, LayoutOrientation layoutOrientation) {
        if (layoutOrientation == LayoutOrientation.Horizontal) {
            return Constraints.m6525getMaxHeightimpl(j);
        }
        return Constraints.m6526getMaxWidthimpl(j);
    }

    /* renamed from: copy-yUG9Ft0  reason: not valid java name */
    public static final long m640copyyUG9Ft0(long j, int i, int i2, int i3, int i4) {
        return m637constructorimpl(i, i2, i3, i4);
    }

    /* renamed from: stretchCrossAxis-q4ezo7Y  reason: not valid java name */
    public static final long m651stretchCrossAxisq4ezo7Y(long j) {
        int i;
        int r0 = Constraints.m6528getMinWidthimpl(j);
        int r1 = Constraints.m6526getMaxWidthimpl(j);
        if (Constraints.m6525getMaxHeightimpl(j) != Integer.MAX_VALUE) {
            i = Constraints.m6525getMaxHeightimpl(j);
        } else {
            i = Constraints.m6527getMinHeightimpl(j);
        }
        return m637constructorimpl(r0, r1, i, Constraints.m6525getMaxHeightimpl(j));
    }

    /* renamed from: copy-yUG9Ft0$default  reason: not valid java name */
    public static /* synthetic */ long m641copyyUG9Ft0$default(long j, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = Constraints.m6528getMinWidthimpl(j);
        }
        int i6 = i;
        if ((i5 & 2) != 0) {
            i2 = Constraints.m6526getMaxWidthimpl(j);
        }
        int i7 = i2;
        if ((i5 & 4) != 0) {
            i3 = Constraints.m6527getMinHeightimpl(j);
        }
        int i8 = i3;
        if ((i5 & 8) != 0) {
            i4 = Constraints.m6525getMaxHeightimpl(j);
        }
        return m640copyyUG9Ft0(j, i6, i7, i8, i4);
    }
}
