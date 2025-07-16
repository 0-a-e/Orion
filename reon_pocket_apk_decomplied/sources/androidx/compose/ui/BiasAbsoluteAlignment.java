package androidx.compose.ui;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001aB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u000f\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÂ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/BiasAbsoluteAlignment;", "Landroidx/compose/ui/Alignment;", "horizontalBias", "", "verticalBias", "(FF)V", "align", "Landroidx/compose/ui/unit/IntOffset;", "size", "Landroidx/compose/ui/unit/IntSize;", "space", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "align-KFBX0sM", "(JJLandroidx/compose/ui/unit/LayoutDirection;)J", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Horizontal", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Alignment.kt */
public final class BiasAbsoluteAlignment implements Alignment {
    public static final int $stable = 0;
    private final float horizontalBias;
    private final float verticalBias;

    private final float component1() {
        return this.horizontalBias;
    }

    private final float component2() {
        return this.verticalBias;
    }

    public static /* synthetic */ BiasAbsoluteAlignment copy$default(BiasAbsoluteAlignment biasAbsoluteAlignment, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = biasAbsoluteAlignment.horizontalBias;
        }
        if ((i & 2) != 0) {
            f2 = biasAbsoluteAlignment.verticalBias;
        }
        return biasAbsoluteAlignment.copy(f, f2);
    }

    public final BiasAbsoluteAlignment copy(float f, float f2) {
        return new BiasAbsoluteAlignment(f, f2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BiasAbsoluteAlignment)) {
            return false;
        }
        BiasAbsoluteAlignment biasAbsoluteAlignment = (BiasAbsoluteAlignment) obj;
        return Float.compare(this.horizontalBias, biasAbsoluteAlignment.horizontalBias) == 0 && Float.compare(this.verticalBias, biasAbsoluteAlignment.verticalBias) == 0;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.horizontalBias) * 31) + Float.floatToIntBits(this.verticalBias);
    }

    public String toString() {
        return "BiasAbsoluteAlignment(horizontalBias=" + this.horizontalBias + ", verticalBias=" + this.verticalBias + ')';
    }

    public BiasAbsoluteAlignment(float f, float f2) {
        this.horizontalBias = f;
        this.verticalBias = f2;
    }

    /* renamed from: align-KFBX0sM  reason: not valid java name */
    public long m3418alignKFBX0sM(long j, long j2, LayoutDirection layoutDirection) {
        long IntSize = IntSizeKt.IntSize(IntSize.m6790getWidthimpl(j2) - IntSize.m6790getWidthimpl(j), IntSize.m6789getHeightimpl(j2) - IntSize.m6789getHeightimpl(j));
        float f = (float) 1;
        return IntOffsetKt.IntOffset(MathKt.roundToInt((((float) IntSize.m6790getWidthimpl(IntSize)) / 2.0f) * (this.horizontalBias + f)), MathKt.roundToInt((((float) IntSize.m6789getHeightimpl(IntSize)) / 2.0f) * (f + this.verticalBias)));
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/BiasAbsoluteAlignment$Horizontal;", "Landroidx/compose/ui/Alignment$Horizontal;", "bias", "", "(F)V", "align", "", "size", "space", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Alignment.kt */
    public static final class Horizontal implements Alignment.Horizontal {
        public static final int $stable = 0;
        private final float bias;

        private final float component1() {
            return this.bias;
        }

        public static /* synthetic */ Horizontal copy$default(Horizontal horizontal, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = horizontal.bias;
            }
            return horizontal.copy(f);
        }

        public final Horizontal copy(float f) {
            return new Horizontal(f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Horizontal) && Float.compare(this.bias, ((Horizontal) obj).bias) == 0;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.bias);
        }

        public String toString() {
            return "Horizontal(bias=" + this.bias + ')';
        }

        public Horizontal(float f) {
            this.bias = f;
        }

        public int align(int i, int i2, LayoutDirection layoutDirection) {
            return MathKt.roundToInt((((float) (i2 - i)) / 2.0f) * (((float) 1) + this.bias));
        }
    }
}
