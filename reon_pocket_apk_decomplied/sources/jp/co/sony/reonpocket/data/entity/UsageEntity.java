package jp.co.sony.reonpocket.data.entity;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/UsageEntity;", "", "coolCount", "", "warmCount", "coolRatio", "", "warmRatio", "(IIFF)V", "getCoolCount", "()I", "getCoolRatio", "()F", "getWarmCount", "getWarmRatio", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: UsageEntity.kt */
public final class UsageEntity {
    public static final int $stable = 0;
    private final int coolCount;
    private final float coolRatio;
    private final int warmCount;
    private final float warmRatio;

    public static /* synthetic */ UsageEntity copy$default(UsageEntity usageEntity, int i, int i2, float f, float f2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = usageEntity.coolCount;
        }
        if ((i3 & 2) != 0) {
            i2 = usageEntity.warmCount;
        }
        if ((i3 & 4) != 0) {
            f = usageEntity.coolRatio;
        }
        if ((i3 & 8) != 0) {
            f2 = usageEntity.warmRatio;
        }
        return usageEntity.copy(i, i2, f, f2);
    }

    public final int component1() {
        return this.coolCount;
    }

    public final int component2() {
        return this.warmCount;
    }

    public final float component3() {
        return this.coolRatio;
    }

    public final float component4() {
        return this.warmRatio;
    }

    public final UsageEntity copy(int i, int i2, float f, float f2) {
        return new UsageEntity(i, i2, f, f2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UsageEntity)) {
            return false;
        }
        UsageEntity usageEntity = (UsageEntity) obj;
        return this.coolCount == usageEntity.coolCount && this.warmCount == usageEntity.warmCount && Float.compare(this.coolRatio, usageEntity.coolRatio) == 0 && Float.compare(this.warmRatio, usageEntity.warmRatio) == 0;
    }

    public int hashCode() {
        return (((((this.coolCount * 31) + this.warmCount) * 31) + Float.floatToIntBits(this.coolRatio)) * 31) + Float.floatToIntBits(this.warmRatio);
    }

    public String toString() {
        int i = this.coolCount;
        int i2 = this.warmCount;
        float f = this.coolRatio;
        float f2 = this.warmRatio;
        return "UsageEntity(coolCount=" + i + ", warmCount=" + i2 + ", coolRatio=" + f + ", warmRatio=" + f2 + ")";
    }

    public UsageEntity(int i, int i2, float f, float f2) {
        this.coolCount = i;
        this.warmCount = i2;
        this.coolRatio = f;
        this.warmRatio = f2;
    }

    public final int getCoolCount() {
        return this.coolCount;
    }

    public final int getWarmCount() {
        return this.warmCount;
    }

    public final float getCoolRatio() {
        return this.coolRatio;
    }

    public final float getWarmRatio() {
        return this.warmRatio;
    }
}
