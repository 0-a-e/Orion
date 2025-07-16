package jp.co.sony.reonpocket.data.entity.tag;

import jp.co.sony.reonpocket.data.entity.BaseEntity;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0015"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/tag/TagUtcTimeSetting;", "Ljp/co/sony/reonpocket/data/entity/BaseEntity;", "utcTime", "", "utcTimeDifference", "(II)V", "getUtcTime", "()I", "getUtcTimeDifference", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toByte", "", "toString", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagSetTagControlEntity.kt */
public final class TagUtcTimeSetting implements BaseEntity {
    public static final int $stable = 0;
    private final int utcTime;
    private final int utcTimeDifference;

    public static /* synthetic */ TagUtcTimeSetting copy$default(TagUtcTimeSetting tagUtcTimeSetting, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = tagUtcTimeSetting.utcTime;
        }
        if ((i3 & 2) != 0) {
            i2 = tagUtcTimeSetting.utcTimeDifference;
        }
        return tagUtcTimeSetting.copy(i, i2);
    }

    public final int component1() {
        return this.utcTime;
    }

    public final int component2() {
        return this.utcTimeDifference;
    }

    public final TagUtcTimeSetting copy(int i, int i2) {
        return new TagUtcTimeSetting(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TagUtcTimeSetting)) {
            return false;
        }
        TagUtcTimeSetting tagUtcTimeSetting = (TagUtcTimeSetting) obj;
        return this.utcTime == tagUtcTimeSetting.utcTime && this.utcTimeDifference == tagUtcTimeSetting.utcTimeDifference;
    }

    public int hashCode() {
        return (this.utcTime * 31) + this.utcTimeDifference;
    }

    public String toString() {
        int i = this.utcTime;
        int i2 = this.utcTimeDifference;
        return "TagUtcTimeSetting(utcTime=" + i + ", utcTimeDifference=" + i2 + ")";
    }

    public TagUtcTimeSetting(int i, int i2) {
        this.utcTime = i;
        this.utcTimeDifference = i2;
    }

    public final int getUtcTime() {
        return this.utcTime;
    }

    public final int getUtcTimeDifference() {
        return this.utcTimeDifference;
    }

    public byte[] toByte() {
        int i = this.utcTime;
        int i2 = this.utcTimeDifference;
        return ArraysKt.reversedArray(new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255), (byte) ((i2 >> 8) & 255), (byte) (i2 & 255)});
    }
}
