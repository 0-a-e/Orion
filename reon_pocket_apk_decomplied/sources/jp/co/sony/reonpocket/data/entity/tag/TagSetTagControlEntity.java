package jp.co.sony.reonpocket.data.entity.tag;

import jp.co.sony.reonpocket.constant.TagSetTagControlType;
import jp.co.sony.reonpocket.data.entity.BaseEntity;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006#"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/tag/TagSetTagControlEntity;", "Ljp/co/sony/reonpocket/data/entity/BaseEntity;", "setTagControlType", "Ljp/co/sony/reonpocket/constant/TagSetTagControlType;", "tagUtcTimeSetting", "Ljp/co/sony/reonpocket/data/entity/tag/TagUtcTimeSetting;", "tagConfigurationSetting", "Ljp/co/sony/reonpocket/data/entity/tag/TagConfigurationSetting;", "tagTagReadSetting", "Ljp/co/sony/reonpocket/data/entity/tag/TagReadSetting;", "(Ljp/co/sony/reonpocket/constant/TagSetTagControlType;Ljp/co/sony/reonpocket/data/entity/tag/TagUtcTimeSetting;Ljp/co/sony/reonpocket/data/entity/tag/TagConfigurationSetting;Ljp/co/sony/reonpocket/data/entity/tag/TagReadSetting;)V", "getSetTagControlType", "()Ljp/co/sony/reonpocket/constant/TagSetTagControlType;", "getTagConfigurationSetting", "()Ljp/co/sony/reonpocket/data/entity/tag/TagConfigurationSetting;", "getTagTagReadSetting", "()Ljp/co/sony/reonpocket/data/entity/tag/TagReadSetting;", "getTagUtcTimeSetting", "()Ljp/co/sony/reonpocket/data/entity/tag/TagUtcTimeSetting;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toByte", "", "toString", "", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagSetTagControlEntity.kt */
public final class TagSetTagControlEntity implements BaseEntity {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int INITIALIZATION_CODE = 255;
    private final TagSetTagControlType setTagControlType;
    private final TagConfigurationSetting tagConfigurationSetting;
    private final TagReadSetting tagTagReadSetting;
    private final TagUtcTimeSetting tagUtcTimeSetting;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TagSetTagControlEntity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                jp.co.sony.reonpocket.constant.TagSetTagControlType[] r0 = jp.co.sony.reonpocket.constant.TagSetTagControlType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.TagSetTagControlType r1 = jp.co.sony.reonpocket.constant.TagSetTagControlType.READ_SETTING     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                jp.co.sony.reonpocket.constant.TagSetTagControlType r1 = jp.co.sony.reonpocket.constant.TagSetTagControlType.TIME_SETTING     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                jp.co.sony.reonpocket.constant.TagSetTagControlType r1 = jp.co.sony.reonpocket.constant.TagSetTagControlType.CONFIGURATION_SETTING     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                jp.co.sony.reonpocket.constant.TagSetTagControlType r1 = jp.co.sony.reonpocket.constant.TagSetTagControlType.TAG_INITIALIZATION     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.data.entity.tag.TagSetTagControlEntity.WhenMappings.<clinit>():void");
        }
    }

    public static /* synthetic */ TagSetTagControlEntity copy$default(TagSetTagControlEntity tagSetTagControlEntity, TagSetTagControlType tagSetTagControlType, TagUtcTimeSetting tagUtcTimeSetting2, TagConfigurationSetting tagConfigurationSetting2, TagReadSetting tagReadSetting, int i, Object obj) {
        if ((i & 1) != 0) {
            tagSetTagControlType = tagSetTagControlEntity.setTagControlType;
        }
        if ((i & 2) != 0) {
            tagUtcTimeSetting2 = tagSetTagControlEntity.tagUtcTimeSetting;
        }
        if ((i & 4) != 0) {
            tagConfigurationSetting2 = tagSetTagControlEntity.tagConfigurationSetting;
        }
        if ((i & 8) != 0) {
            tagReadSetting = tagSetTagControlEntity.tagTagReadSetting;
        }
        return tagSetTagControlEntity.copy(tagSetTagControlType, tagUtcTimeSetting2, tagConfigurationSetting2, tagReadSetting);
    }

    public final TagSetTagControlType component1() {
        return this.setTagControlType;
    }

    public final TagUtcTimeSetting component2() {
        return this.tagUtcTimeSetting;
    }

    public final TagConfigurationSetting component3() {
        return this.tagConfigurationSetting;
    }

    public final TagReadSetting component4() {
        return this.tagTagReadSetting;
    }

    public final TagSetTagControlEntity copy(TagSetTagControlType tagSetTagControlType, TagUtcTimeSetting tagUtcTimeSetting2, TagConfigurationSetting tagConfigurationSetting2, TagReadSetting tagReadSetting) {
        Intrinsics.checkNotNullParameter(tagSetTagControlType, "setTagControlType");
        return new TagSetTagControlEntity(tagSetTagControlType, tagUtcTimeSetting2, tagConfigurationSetting2, tagReadSetting);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TagSetTagControlEntity)) {
            return false;
        }
        TagSetTagControlEntity tagSetTagControlEntity = (TagSetTagControlEntity) obj;
        return this.setTagControlType == tagSetTagControlEntity.setTagControlType && Intrinsics.areEqual((Object) this.tagUtcTimeSetting, (Object) tagSetTagControlEntity.tagUtcTimeSetting) && Intrinsics.areEqual((Object) this.tagConfigurationSetting, (Object) tagSetTagControlEntity.tagConfigurationSetting) && Intrinsics.areEqual((Object) this.tagTagReadSetting, (Object) tagSetTagControlEntity.tagTagReadSetting);
    }

    public int hashCode() {
        int hashCode = this.setTagControlType.hashCode() * 31;
        TagUtcTimeSetting tagUtcTimeSetting2 = this.tagUtcTimeSetting;
        int i = 0;
        int hashCode2 = (hashCode + (tagUtcTimeSetting2 == null ? 0 : tagUtcTimeSetting2.hashCode())) * 31;
        TagConfigurationSetting tagConfigurationSetting2 = this.tagConfigurationSetting;
        int hashCode3 = (hashCode2 + (tagConfigurationSetting2 == null ? 0 : tagConfigurationSetting2.hashCode())) * 31;
        TagReadSetting tagReadSetting = this.tagTagReadSetting;
        if (tagReadSetting != null) {
            i = tagReadSetting.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        TagSetTagControlType tagSetTagControlType = this.setTagControlType;
        TagUtcTimeSetting tagUtcTimeSetting2 = this.tagUtcTimeSetting;
        TagConfigurationSetting tagConfigurationSetting2 = this.tagConfigurationSetting;
        TagReadSetting tagReadSetting = this.tagTagReadSetting;
        return "TagSetTagControlEntity(setTagControlType=" + tagSetTagControlType + ", tagUtcTimeSetting=" + tagUtcTimeSetting2 + ", tagConfigurationSetting=" + tagConfigurationSetting2 + ", tagTagReadSetting=" + tagReadSetting + ")";
    }

    public TagSetTagControlEntity(TagSetTagControlType tagSetTagControlType, TagUtcTimeSetting tagUtcTimeSetting2, TagConfigurationSetting tagConfigurationSetting2, TagReadSetting tagReadSetting) {
        Intrinsics.checkNotNullParameter(tagSetTagControlType, "setTagControlType");
        this.setTagControlType = tagSetTagControlType;
        this.tagUtcTimeSetting = tagUtcTimeSetting2;
        this.tagConfigurationSetting = tagConfigurationSetting2;
        this.tagTagReadSetting = tagReadSetting;
    }

    public final TagSetTagControlType getSetTagControlType() {
        return this.setTagControlType;
    }

    public final TagUtcTimeSetting getTagUtcTimeSetting() {
        return this.tagUtcTimeSetting;
    }

    public final TagConfigurationSetting getTagConfigurationSetting() {
        return this.tagConfigurationSetting;
    }

    public final TagReadSetting getTagTagReadSetting() {
        return this.tagTagReadSetting;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/tag/TagSetTagControlEntity$Companion;", "", "()V", "INITIALIZATION_CODE", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TagSetTagControlEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public byte[] toByte() {
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4 = {(byte) this.setTagControlType.getCode()};
        int i = WhenMappings.$EnumSwitchMapping$0[this.setTagControlType.ordinal()];
        if (i == 1) {
            TagReadSetting tagReadSetting = this.tagTagReadSetting;
            if (tagReadSetting == null || (bArr = tagReadSetting.toByte()) == null) {
                return null;
            }
            return ArraysKt.plus(bArr4, bArr);
        } else if (i == 2) {
            TagUtcTimeSetting tagUtcTimeSetting2 = this.tagUtcTimeSetting;
            if (tagUtcTimeSetting2 == null || (bArr2 = tagUtcTimeSetting2.toByte()) == null) {
                return null;
            }
            return ArraysKt.plus(bArr4, bArr2);
        } else if (i == 3) {
            TagConfigurationSetting tagConfigurationSetting2 = this.tagConfigurationSetting;
            if (tagConfigurationSetting2 == null || (bArr3 = tagConfigurationSetting2.toByte()) == null) {
                return null;
            }
            return ArraysKt.plus(bArr4, bArr3);
        } else if (i == 4) {
            return ArraysKt.plus(bArr4, (byte) -1);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
