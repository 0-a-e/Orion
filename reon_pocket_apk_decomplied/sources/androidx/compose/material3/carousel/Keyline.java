package androidx.compose.material3.carousel;

import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003JO\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006 "}, d2 = {"Landroidx/compose/material3/carousel/Keyline;", "", "size", "", "offset", "unadjustedOffset", "isFocal", "", "isAnchor", "isPivot", "cutoff", "(FFFZZZF)V", "getCutoff", "()F", "()Z", "getOffset", "getSize", "getUnadjustedOffset", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Keyline.kt */
public final class Keyline {
    public static final int $stable = 0;
    private final float cutoff;
    private final boolean isAnchor;
    private final boolean isFocal;
    private final boolean isPivot;
    private final float offset;
    private final float size;
    private final float unadjustedOffset;

    public static /* synthetic */ Keyline copy$default(Keyline keyline, float f, float f2, float f3, boolean z, boolean z2, boolean z3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = keyline.size;
        }
        if ((i & 2) != 0) {
            f2 = keyline.offset;
        }
        float f5 = f2;
        if ((i & 4) != 0) {
            f3 = keyline.unadjustedOffset;
        }
        float f6 = f3;
        if ((i & 8) != 0) {
            z = keyline.isFocal;
        }
        boolean z4 = z;
        if ((i & 16) != 0) {
            z2 = keyline.isAnchor;
        }
        boolean z5 = z2;
        if ((i & 32) != 0) {
            z3 = keyline.isPivot;
        }
        boolean z6 = z3;
        if ((i & 64) != 0) {
            f4 = keyline.cutoff;
        }
        return keyline.copy(f, f5, f6, z4, z5, z6, f4);
    }

    public final float component1() {
        return this.size;
    }

    public final float component2() {
        return this.offset;
    }

    public final float component3() {
        return this.unadjustedOffset;
    }

    public final boolean component4() {
        return this.isFocal;
    }

    public final boolean component5() {
        return this.isAnchor;
    }

    public final boolean component6() {
        return this.isPivot;
    }

    public final float component7() {
        return this.cutoff;
    }

    public final Keyline copy(float f, float f2, float f3, boolean z, boolean z2, boolean z3, float f4) {
        return new Keyline(f, f2, f3, z, z2, z3, f4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Keyline)) {
            return false;
        }
        Keyline keyline = (Keyline) obj;
        return Float.compare(this.size, keyline.size) == 0 && Float.compare(this.offset, keyline.offset) == 0 && Float.compare(this.unadjustedOffset, keyline.unadjustedOffset) == 0 && this.isFocal == keyline.isFocal && this.isAnchor == keyline.isAnchor && this.isPivot == keyline.isPivot && Float.compare(this.cutoff, keyline.cutoff) == 0;
    }

    public int hashCode() {
        return (((((((((((Float.floatToIntBits(this.size) * 31) + Float.floatToIntBits(this.offset)) * 31) + Float.floatToIntBits(this.unadjustedOffset)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.isFocal)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.isAnchor)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.isPivot)) * 31) + Float.floatToIntBits(this.cutoff);
    }

    public String toString() {
        return "Keyline(size=" + this.size + ", offset=" + this.offset + ", unadjustedOffset=" + this.unadjustedOffset + ", isFocal=" + this.isFocal + ", isAnchor=" + this.isAnchor + ", isPivot=" + this.isPivot + ", cutoff=" + this.cutoff + ')';
    }

    public Keyline(float f, float f2, float f3, boolean z, boolean z2, boolean z3, float f4) {
        this.size = f;
        this.offset = f2;
        this.unadjustedOffset = f3;
        this.isFocal = z;
        this.isAnchor = z2;
        this.isPivot = z3;
        this.cutoff = f4;
    }

    public final float getSize() {
        return this.size;
    }

    public final float getOffset() {
        return this.offset;
    }

    public final float getUnadjustedOffset() {
        return this.unadjustedOffset;
    }

    public final boolean isFocal() {
        return this.isFocal;
    }

    public final boolean isAnchor() {
        return this.isAnchor;
    }

    public final boolean isPivot() {
        return this.isPivot;
    }

    public final float getCutoff() {
        return this.cutoff;
    }
}
