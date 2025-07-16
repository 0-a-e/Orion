package jp.co.sony.reonpocket.data.entity.tag;

import jp.co.sony.reonpocket.data.entity.BaseEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/tag/TagRequestDfuEntity;", "Ljp/co/sony/reonpocket/data/entity/BaseEntity;", "request", "", "(I)V", "getRequest", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toByte", "", "toString", "", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagRequestDfuEntity.kt */
public final class TagRequestDfuEntity implements BaseEntity {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int REQUEST_CODE = 255;
    private final int request;

    public static /* synthetic */ TagRequestDfuEntity copy$default(TagRequestDfuEntity tagRequestDfuEntity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = tagRequestDfuEntity.request;
        }
        return tagRequestDfuEntity.copy(i);
    }

    public final int component1() {
        return this.request;
    }

    public final TagRequestDfuEntity copy(int i) {
        return new TagRequestDfuEntity(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TagRequestDfuEntity) && this.request == ((TagRequestDfuEntity) obj).request;
    }

    public int hashCode() {
        return this.request;
    }

    public String toString() {
        int i = this.request;
        return "TagRequestDfuEntity(request=" + i + ")";
    }

    public TagRequestDfuEntity(int i) {
        this.request = i;
    }

    public final int getRequest() {
        return this.request;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/tag/TagRequestDfuEntity$Companion;", "", "()V", "REQUEST_CODE", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TagRequestDfuEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public byte[] toByte() {
        int i = this.request;
        if (i != 255) {
            return null;
        }
        return new byte[]{(byte) i};
    }
}
