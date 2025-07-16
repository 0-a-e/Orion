package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/layout/RowColumnParentData;", "", "weight", "", "fill", "", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "(FZLandroidx/compose/foundation/layout/CrossAxisAlignment;)V", "getCrossAxisAlignment", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "setCrossAxisAlignment", "(Landroidx/compose/foundation/layout/CrossAxisAlignment;)V", "getFill", "()Z", "setFill", "(Z)V", "getWeight", "()F", "setWeight", "(F)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RowColumnImpl.kt */
public final class RowColumnParentData {
    public static final int $stable = 8;
    private CrossAxisAlignment crossAxisAlignment;
    private boolean fill;
    private float weight;

    public RowColumnParentData() {
        this(0.0f, false, (CrossAxisAlignment) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RowColumnParentData copy$default(RowColumnParentData rowColumnParentData, float f, boolean z, CrossAxisAlignment crossAxisAlignment2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = rowColumnParentData.weight;
        }
        if ((i & 2) != 0) {
            z = rowColumnParentData.fill;
        }
        if ((i & 4) != 0) {
            crossAxisAlignment2 = rowColumnParentData.crossAxisAlignment;
        }
        return rowColumnParentData.copy(f, z, crossAxisAlignment2);
    }

    public final float component1() {
        return this.weight;
    }

    public final boolean component2() {
        return this.fill;
    }

    public final CrossAxisAlignment component3() {
        return this.crossAxisAlignment;
    }

    public final RowColumnParentData copy(float f, boolean z, CrossAxisAlignment crossAxisAlignment2) {
        return new RowColumnParentData(f, z, crossAxisAlignment2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RowColumnParentData)) {
            return false;
        }
        RowColumnParentData rowColumnParentData = (RowColumnParentData) obj;
        return Float.compare(this.weight, rowColumnParentData.weight) == 0 && this.fill == rowColumnParentData.fill && Intrinsics.areEqual((Object) this.crossAxisAlignment, (Object) rowColumnParentData.crossAxisAlignment);
    }

    public int hashCode() {
        int floatToIntBits = ((Float.floatToIntBits(this.weight) * 31) + UByte$$ExternalSyntheticBackport0.m(this.fill)) * 31;
        CrossAxisAlignment crossAxisAlignment2 = this.crossAxisAlignment;
        return floatToIntBits + (crossAxisAlignment2 == null ? 0 : crossAxisAlignment2.hashCode());
    }

    public String toString() {
        return "RowColumnParentData(weight=" + this.weight + ", fill=" + this.fill + ", crossAxisAlignment=" + this.crossAxisAlignment + ')';
    }

    public RowColumnParentData(float f, boolean z, CrossAxisAlignment crossAxisAlignment2) {
        this.weight = f;
        this.fill = z;
        this.crossAxisAlignment = crossAxisAlignment2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RowColumnParentData(float f, boolean z, CrossAxisAlignment crossAxisAlignment2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0f : f, (i & 2) != 0 ? true : z, (i & 4) != 0 ? null : crossAxisAlignment2);
    }

    public final float getWeight() {
        return this.weight;
    }

    public final void setWeight(float f) {
        this.weight = f;
    }

    public final boolean getFill() {
        return this.fill;
    }

    public final void setFill(boolean z) {
        this.fill = z;
    }

    public final CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    public final void setCrossAxisAlignment(CrossAxisAlignment crossAxisAlignment2) {
        this.crossAxisAlignment = crossAxisAlignment2;
    }
}
