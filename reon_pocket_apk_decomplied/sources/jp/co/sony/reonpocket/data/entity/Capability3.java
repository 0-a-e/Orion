package jp.co.sony.reonpocket.data.entity;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B-\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\f\"\u0004\b\u000f\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\u0012\u0010\u000e¨\u0006\u001e"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/Capability3;", "", "value", "", "(I)V", "isSupportCoolStep4", "", "isSupportCoolStep4Plus", "isSupportCoolStep5", "isSupportCoolStep5Plus", "isSupportWarmStep4", "(ZZZZZ)V", "()Z", "setSupportCoolStep4", "(Z)V", "setSupportCoolStep4Plus", "setSupportCoolStep5", "setSupportCoolStep5Plus", "setSupportWarmStep4", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CapabilityEntity.kt */
public final class Capability3 {
    public static final int $stable = 8;
    private boolean isSupportCoolStep4;
    private boolean isSupportCoolStep4Plus;
    private boolean isSupportCoolStep5;
    private boolean isSupportCoolStep5Plus;
    private boolean isSupportWarmStep4;

    public static /* synthetic */ Capability3 copy$default(Capability3 capability3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, Object obj) {
        if ((i & 1) != 0) {
            z = capability3.isSupportCoolStep4;
        }
        if ((i & 2) != 0) {
            z2 = capability3.isSupportCoolStep4Plus;
        }
        boolean z6 = z2;
        if ((i & 4) != 0) {
            z3 = capability3.isSupportCoolStep5;
        }
        boolean z7 = z3;
        if ((i & 8) != 0) {
            z4 = capability3.isSupportCoolStep5Plus;
        }
        boolean z8 = z4;
        if ((i & 16) != 0) {
            z5 = capability3.isSupportWarmStep4;
        }
        return capability3.copy(z, z6, z7, z8, z5);
    }

    public final boolean component1() {
        return this.isSupportCoolStep4;
    }

    public final boolean component2() {
        return this.isSupportCoolStep4Plus;
    }

    public final boolean component3() {
        return this.isSupportCoolStep5;
    }

    public final boolean component4() {
        return this.isSupportCoolStep5Plus;
    }

    public final boolean component5() {
        return this.isSupportWarmStep4;
    }

    public final Capability3 copy(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return new Capability3(z, z2, z3, z4, z5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Capability3)) {
            return false;
        }
        Capability3 capability3 = (Capability3) obj;
        return this.isSupportCoolStep4 == capability3.isSupportCoolStep4 && this.isSupportCoolStep4Plus == capability3.isSupportCoolStep4Plus && this.isSupportCoolStep5 == capability3.isSupportCoolStep5 && this.isSupportCoolStep5Plus == capability3.isSupportCoolStep5Plus && this.isSupportWarmStep4 == capability3.isSupportWarmStep4;
    }

    public int hashCode() {
        return (((((((Capability1$$ExternalSyntheticBackport0.m(this.isSupportCoolStep4) * 31) + Capability1$$ExternalSyntheticBackport0.m(this.isSupportCoolStep4Plus)) * 31) + Capability1$$ExternalSyntheticBackport0.m(this.isSupportCoolStep5)) * 31) + Capability1$$ExternalSyntheticBackport0.m(this.isSupportCoolStep5Plus)) * 31) + Capability1$$ExternalSyntheticBackport0.m(this.isSupportWarmStep4);
    }

    public String toString() {
        boolean z = this.isSupportCoolStep4;
        boolean z2 = this.isSupportCoolStep4Plus;
        boolean z3 = this.isSupportCoolStep5;
        boolean z4 = this.isSupportCoolStep5Plus;
        boolean z5 = this.isSupportWarmStep4;
        return "Capability3(isSupportCoolStep4=" + z + ", isSupportCoolStep4Plus=" + z2 + ", isSupportCoolStep5=" + z3 + ", isSupportCoolStep5Plus=" + z4 + ", isSupportWarmStep4=" + z5 + ")";
    }

    public Capability3(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.isSupportCoolStep4 = z;
        this.isSupportCoolStep4Plus = z2;
        this.isSupportCoolStep5 = z3;
        this.isSupportCoolStep5Plus = z4;
        this.isSupportWarmStep4 = z5;
    }

    public final boolean isSupportCoolStep4() {
        return this.isSupportCoolStep4;
    }

    public final void setSupportCoolStep4(boolean z) {
        this.isSupportCoolStep4 = z;
    }

    public final boolean isSupportCoolStep4Plus() {
        return this.isSupportCoolStep4Plus;
    }

    public final void setSupportCoolStep4Plus(boolean z) {
        this.isSupportCoolStep4Plus = z;
    }

    public final boolean isSupportCoolStep5() {
        return this.isSupportCoolStep5;
    }

    public final void setSupportCoolStep5(boolean z) {
        this.isSupportCoolStep5 = z;
    }

    public final boolean isSupportCoolStep5Plus() {
        return this.isSupportCoolStep5Plus;
    }

    public final void setSupportCoolStep5Plus(boolean z) {
        this.isSupportCoolStep5Plus = z;
    }

    public final boolean isSupportWarmStep4() {
        return this.isSupportWarmStep4;
    }

    public final void setSupportWarmStep4(boolean z) {
        this.isSupportWarmStep4 = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Capability3(int i) {
        this(false, false, false, false, false);
        boolean z = false;
        this.isSupportCoolStep4 = (i & 1) != 0;
        this.isSupportCoolStep4Plus = (i & 2) != 0;
        this.isSupportCoolStep5 = (i & 4) != 0;
        this.isSupportCoolStep5Plus = (i & 8) != 0;
        this.isSupportWarmStep4 = (i & 16) != 0 ? true : z;
    }
}
