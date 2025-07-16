package jp.co.sony.reonpocket.data.entity.tag;

import jp.co.sony.reonpocket.constant.TagReadStatus;
import jp.co.sony.reonpocket.data.entity.BaseEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/tag/TagReadSetting;", "Ljp/co/sony/reonpocket/data/entity/BaseEntity;", "tagReadStatus", "Ljp/co/sony/reonpocket/constant/TagReadStatus;", "(Ljp/co/sony/reonpocket/constant/TagReadStatus;)V", "getTagReadStatus", "()Ljp/co/sony/reonpocket/constant/TagReadStatus;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toByte", "", "toString", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagSetTagControlEntity.kt */
public final class TagReadSetting implements BaseEntity {
    public static final int $stable = 0;
    private final TagReadStatus tagReadStatus;

    public static /* synthetic */ TagReadSetting copy$default(TagReadSetting tagReadSetting, TagReadStatus tagReadStatus2, int i, Object obj) {
        if ((i & 1) != 0) {
            tagReadStatus2 = tagReadSetting.tagReadStatus;
        }
        return tagReadSetting.copy(tagReadStatus2);
    }

    public final TagReadStatus component1() {
        return this.tagReadStatus;
    }

    public final TagReadSetting copy(TagReadStatus tagReadStatus2) {
        Intrinsics.checkNotNullParameter(tagReadStatus2, "tagReadStatus");
        return new TagReadSetting(tagReadStatus2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TagReadSetting) && this.tagReadStatus == ((TagReadSetting) obj).tagReadStatus;
    }

    public int hashCode() {
        return this.tagReadStatus.hashCode();
    }

    public String toString() {
        TagReadStatus tagReadStatus2 = this.tagReadStatus;
        return "TagReadSetting(tagReadStatus=" + tagReadStatus2 + ")";
    }

    public TagReadSetting(TagReadStatus tagReadStatus2) {
        Intrinsics.checkNotNullParameter(tagReadStatus2, "tagReadStatus");
        this.tagReadStatus = tagReadStatus2;
    }

    public final TagReadStatus getTagReadStatus() {
        return this.tagReadStatus;
    }

    public byte[] toByte() {
        return new byte[]{(byte) this.tagReadStatus.getCode()};
    }
}
