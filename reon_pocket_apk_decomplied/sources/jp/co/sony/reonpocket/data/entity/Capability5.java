package jp.co.sony.reonpocket.data.entity;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0006HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\t\"\u0004\b\f\u0010\u000b¨\u0006\u0015"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/Capability5;", "", "value", "", "(I)V", "isSupportVisualizationServiceMode", "", "isSupportEnvironmentalTempHumiditySensor", "(ZZ)V", "()Z", "setSupportEnvironmentalTempHumiditySensor", "(Z)V", "setSupportVisualizationServiceMode", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CapabilityEntity.kt */
public final class Capability5 {
    public static final int $stable = 8;
    private boolean isSupportEnvironmentalTempHumiditySensor;
    private boolean isSupportVisualizationServiceMode;

    public static /* synthetic */ Capability5 copy$default(Capability5 capability5, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = capability5.isSupportVisualizationServiceMode;
        }
        if ((i & 2) != 0) {
            z2 = capability5.isSupportEnvironmentalTempHumiditySensor;
        }
        return capability5.copy(z, z2);
    }

    public final boolean component1() {
        return this.isSupportVisualizationServiceMode;
    }

    public final boolean component2() {
        return this.isSupportEnvironmentalTempHumiditySensor;
    }

    public final Capability5 copy(boolean z, boolean z2) {
        return new Capability5(z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Capability5)) {
            return false;
        }
        Capability5 capability5 = (Capability5) obj;
        return this.isSupportVisualizationServiceMode == capability5.isSupportVisualizationServiceMode && this.isSupportEnvironmentalTempHumiditySensor == capability5.isSupportEnvironmentalTempHumiditySensor;
    }

    public int hashCode() {
        return (Capability1$$ExternalSyntheticBackport0.m(this.isSupportVisualizationServiceMode) * 31) + Capability1$$ExternalSyntheticBackport0.m(this.isSupportEnvironmentalTempHumiditySensor);
    }

    public String toString() {
        boolean z = this.isSupportVisualizationServiceMode;
        boolean z2 = this.isSupportEnvironmentalTempHumiditySensor;
        return "Capability5(isSupportVisualizationServiceMode=" + z + ", isSupportEnvironmentalTempHumiditySensor=" + z2 + ")";
    }

    public Capability5(boolean z, boolean z2) {
        this.isSupportVisualizationServiceMode = z;
        this.isSupportEnvironmentalTempHumiditySensor = z2;
    }

    public final boolean isSupportVisualizationServiceMode() {
        return this.isSupportVisualizationServiceMode;
    }

    public final void setSupportVisualizationServiceMode(boolean z) {
        this.isSupportVisualizationServiceMode = z;
    }

    public final boolean isSupportEnvironmentalTempHumiditySensor() {
        return this.isSupportEnvironmentalTempHumiditySensor;
    }

    public final void setSupportEnvironmentalTempHumiditySensor(boolean z) {
        this.isSupportEnvironmentalTempHumiditySensor = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Capability5(int i) {
        this(false, false);
        boolean z = false;
        this.isSupportVisualizationServiceMode = (i & 1) != 0;
        this.isSupportEnvironmentalTempHumiditySensor = (i & 2) != 0 ? true : z;
    }
}
