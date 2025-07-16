package jp.co.sony.reonpocket.data.entity;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B=\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u000e\"\u0004\b\u0011\u0010\u0010R\u001a\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001a\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u000e\"\u0004\b\u0015\u0010\u0010R\u001a\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000e\"\u0004\b\u0016\u0010\u0010¨\u0006$"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/Capability4;", "", "value", "", "(I)V", "isSupportGolfMorningCool", "", "isSupportGolfDaytimeCool", "isSupportWorkMidCool", "isSupportWorkHiCool", "isSupportWorkMidHeat", "isSupportWorkHiHeat", "isSupportLevel3PlusCool", "(ZZZZZZZ)V", "()Z", "setSupportGolfDaytimeCool", "(Z)V", "setSupportGolfMorningCool", "setSupportLevel3PlusCool", "setSupportWorkHiCool", "setSupportWorkHiHeat", "setSupportWorkMidCool", "setSupportWorkMidHeat", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CapabilityEntity.kt */
public final class Capability4 {
    public static final int $stable = 8;
    private boolean isSupportGolfDaytimeCool;
    private boolean isSupportGolfMorningCool;
    private boolean isSupportLevel3PlusCool;
    private boolean isSupportWorkHiCool;
    private boolean isSupportWorkHiHeat;
    private boolean isSupportWorkMidCool;
    private boolean isSupportWorkMidHeat;

    public static /* synthetic */ Capability4 copy$default(Capability4 capability4, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, Object obj) {
        if ((i & 1) != 0) {
            z = capability4.isSupportGolfMorningCool;
        }
        if ((i & 2) != 0) {
            z2 = capability4.isSupportGolfDaytimeCool;
        }
        boolean z8 = z2;
        if ((i & 4) != 0) {
            z3 = capability4.isSupportWorkMidCool;
        }
        boolean z9 = z3;
        if ((i & 8) != 0) {
            z4 = capability4.isSupportWorkHiCool;
        }
        boolean z10 = z4;
        if ((i & 16) != 0) {
            z5 = capability4.isSupportWorkMidHeat;
        }
        boolean z11 = z5;
        if ((i & 32) != 0) {
            z6 = capability4.isSupportWorkHiHeat;
        }
        boolean z12 = z6;
        if ((i & 64) != 0) {
            z7 = capability4.isSupportLevel3PlusCool;
        }
        return capability4.copy(z, z8, z9, z10, z11, z12, z7);
    }

    public final boolean component1() {
        return this.isSupportGolfMorningCool;
    }

    public final boolean component2() {
        return this.isSupportGolfDaytimeCool;
    }

    public final boolean component3() {
        return this.isSupportWorkMidCool;
    }

    public final boolean component4() {
        return this.isSupportWorkHiCool;
    }

    public final boolean component5() {
        return this.isSupportWorkMidHeat;
    }

    public final boolean component6() {
        return this.isSupportWorkHiHeat;
    }

    public final boolean component7() {
        return this.isSupportLevel3PlusCool;
    }

    public final Capability4 copy(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        return new Capability4(z, z2, z3, z4, z5, z6, z7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Capability4)) {
            return false;
        }
        Capability4 capability4 = (Capability4) obj;
        return this.isSupportGolfMorningCool == capability4.isSupportGolfMorningCool && this.isSupportGolfDaytimeCool == capability4.isSupportGolfDaytimeCool && this.isSupportWorkMidCool == capability4.isSupportWorkMidCool && this.isSupportWorkHiCool == capability4.isSupportWorkHiCool && this.isSupportWorkMidHeat == capability4.isSupportWorkMidHeat && this.isSupportWorkHiHeat == capability4.isSupportWorkHiHeat && this.isSupportLevel3PlusCool == capability4.isSupportLevel3PlusCool;
    }

    public int hashCode() {
        return (((((((((((Capability1$$ExternalSyntheticBackport0.m(this.isSupportGolfMorningCool) * 31) + Capability1$$ExternalSyntheticBackport0.m(this.isSupportGolfDaytimeCool)) * 31) + Capability1$$ExternalSyntheticBackport0.m(this.isSupportWorkMidCool)) * 31) + Capability1$$ExternalSyntheticBackport0.m(this.isSupportWorkHiCool)) * 31) + Capability1$$ExternalSyntheticBackport0.m(this.isSupportWorkMidHeat)) * 31) + Capability1$$ExternalSyntheticBackport0.m(this.isSupportWorkHiHeat)) * 31) + Capability1$$ExternalSyntheticBackport0.m(this.isSupportLevel3PlusCool);
    }

    public String toString() {
        boolean z = this.isSupportGolfMorningCool;
        boolean z2 = this.isSupportGolfDaytimeCool;
        boolean z3 = this.isSupportWorkMidCool;
        boolean z4 = this.isSupportWorkHiCool;
        boolean z5 = this.isSupportWorkMidHeat;
        boolean z6 = this.isSupportWorkHiHeat;
        boolean z7 = this.isSupportLevel3PlusCool;
        return "Capability4(isSupportGolfMorningCool=" + z + ", isSupportGolfDaytimeCool=" + z2 + ", isSupportWorkMidCool=" + z3 + ", isSupportWorkHiCool=" + z4 + ", isSupportWorkMidHeat=" + z5 + ", isSupportWorkHiHeat=" + z6 + ", isSupportLevel3PlusCool=" + z7 + ")";
    }

    public Capability4(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.isSupportGolfMorningCool = z;
        this.isSupportGolfDaytimeCool = z2;
        this.isSupportWorkMidCool = z3;
        this.isSupportWorkHiCool = z4;
        this.isSupportWorkMidHeat = z5;
        this.isSupportWorkHiHeat = z6;
        this.isSupportLevel3PlusCool = z7;
    }

    public final boolean isSupportGolfMorningCool() {
        return this.isSupportGolfMorningCool;
    }

    public final void setSupportGolfMorningCool(boolean z) {
        this.isSupportGolfMorningCool = z;
    }

    public final boolean isSupportGolfDaytimeCool() {
        return this.isSupportGolfDaytimeCool;
    }

    public final void setSupportGolfDaytimeCool(boolean z) {
        this.isSupportGolfDaytimeCool = z;
    }

    public final boolean isSupportWorkMidCool() {
        return this.isSupportWorkMidCool;
    }

    public final void setSupportWorkMidCool(boolean z) {
        this.isSupportWorkMidCool = z;
    }

    public final boolean isSupportWorkHiCool() {
        return this.isSupportWorkHiCool;
    }

    public final void setSupportWorkHiCool(boolean z) {
        this.isSupportWorkHiCool = z;
    }

    public final boolean isSupportWorkMidHeat() {
        return this.isSupportWorkMidHeat;
    }

    public final void setSupportWorkMidHeat(boolean z) {
        this.isSupportWorkMidHeat = z;
    }

    public final boolean isSupportWorkHiHeat() {
        return this.isSupportWorkHiHeat;
    }

    public final void setSupportWorkHiHeat(boolean z) {
        this.isSupportWorkHiHeat = z;
    }

    public final boolean isSupportLevel3PlusCool() {
        return this.isSupportLevel3PlusCool;
    }

    public final void setSupportLevel3PlusCool(boolean z) {
        this.isSupportLevel3PlusCool = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Capability4(int i) {
        this(false, false, false, false, false, false, false);
        boolean z = false;
        this.isSupportGolfMorningCool = (i & 1) != 0;
        this.isSupportGolfDaytimeCool = (i & 2) != 0;
        this.isSupportWorkMidCool = (i & 4) != 0;
        this.isSupportWorkHiCool = (i & 8) != 0;
        this.isSupportWorkMidHeat = (i & 16) != 0;
        this.isSupportWorkHiHeat = (i & 32) != 0;
        this.isSupportLevel3PlusCool = (i & 64) != 0 ? true : z;
    }
}
