package jp.co.sony.reonpocket.connection.aws;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\tR \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR \u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\t¨\u0006\u001e"}, d2 = {"Ljp/co/sony/reonpocket/connection/aws/DeviceInfoEntity;", "", "modelName", "", "boardId", "(Ljava/lang/String;Ljava/lang/String;)V", "getBoardId", "()Ljava/lang/String;", "setBoardId", "(Ljava/lang/String;)V", "created", "getCreated", "setCreated", "getModelName", "setModelName", "ownerId", "getOwnerId", "setOwnerId", "updated", "getUpdated", "setUpdated", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@DynamoDBTable(tableName = "rnp-prod-DeviceInfo")
/* compiled from: DynamoDBManager.kt */
public final class DeviceInfoEntity {
    public static final int $stable = 8;
    @DynamoDBAttribute(attributeName = "Board ID")
    private String boardId;
    @DynamoDBAttribute(attributeName = "Created")
    private String created;
    @DynamoDBAttribute(attributeName = "Model Name")
    private String modelName;
    @DynamoDBAttribute(attributeName = "Owner ID")
    @DynamoDBHashKey(attributeName = "Owner ID")
    private String ownerId;
    @DynamoDBAttribute(attributeName = "Updated")
    private String updated;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DeviceInfoEntity(String str) {
        this(str, (String) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "modelName");
    }

    public static /* synthetic */ DeviceInfoEntity copy$default(DeviceInfoEntity deviceInfoEntity, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceInfoEntity.modelName;
        }
        if ((i & 2) != 0) {
            str2 = deviceInfoEntity.boardId;
        }
        return deviceInfoEntity.copy(str, str2);
    }

    public final String component1() {
        return this.modelName;
    }

    public final String component2() {
        return this.boardId;
    }

    public final DeviceInfoEntity copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "modelName");
        return new DeviceInfoEntity(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInfoEntity)) {
            return false;
        }
        DeviceInfoEntity deviceInfoEntity = (DeviceInfoEntity) obj;
        return Intrinsics.areEqual((Object) this.modelName, (Object) deviceInfoEntity.modelName) && Intrinsics.areEqual((Object) this.boardId, (Object) deviceInfoEntity.boardId);
    }

    public int hashCode() {
        int hashCode = this.modelName.hashCode() * 31;
        String str = this.boardId;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str = this.modelName;
        String str2 = this.boardId;
        return "DeviceInfoEntity(modelName=" + str + ", boardId=" + str2 + ")";
    }

    public DeviceInfoEntity(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "modelName");
        this.modelName = str;
        this.boardId = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeviceInfoEntity(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2);
    }

    public final String getModelName() {
        return this.modelName;
    }

    public final void setModelName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.modelName = str;
    }

    public final String getBoardId() {
        return this.boardId;
    }

    public final void setBoardId(String str) {
        this.boardId = str;
    }

    public final String getOwnerId() {
        return this.ownerId;
    }

    public final void setOwnerId(String str) {
        this.ownerId = str;
    }

    public final String getCreated() {
        return this.created;
    }

    public final void setCreated(String str) {
        this.created = str;
    }

    public final String getUpdated() {
        return this.updated;
    }

    public final void setUpdated(String str) {
        this.updated = str;
    }
}
