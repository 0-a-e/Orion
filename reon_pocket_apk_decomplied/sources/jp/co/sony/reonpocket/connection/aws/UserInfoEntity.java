package jp.co.sony.reonpocket.connection.aws;

import androidx.autofill.HintConstants;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003JE\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR \u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u0016\u0010\u0017\u001a\u00020\u00038\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000bR \u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000b\"\u0004\b\u001b\u0010\rR \u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000b\"\u0004\b\u001e\u0010\rR\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000b\"\u0004\b \u0010\rR \u0010!\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000b\"\u0004\b#\u0010\rR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000b\"\u0004\b%\u0010\r¨\u00063"}, d2 = {"Ljp/co/sony/reonpocket/connection/aws/UserInfoEntity;", "", "gender", "", "age", "height", "wight", "country", "state", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAge", "()Ljava/lang/String;", "setAge", "(Ljava/lang/String;)V", "getCountry", "setCountry", "created", "getCreated", "setCreated", "getGender", "setGender", "getHeight", "setHeight", "os", "getOs", "osVersion", "getOsVersion", "setOsVersion", "ownerId", "getOwnerId", "setOwnerId", "getState", "setState", "updated", "getUpdated", "setUpdated", "getWight", "setWight", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@DynamoDBTable(tableName = "rnp-prod-UserInfo")
/* compiled from: DynamoDBManager.kt */
public final class UserInfoEntity {
    public static final int $stable = 8;
    @DynamoDBAttribute(attributeName = "Age")
    private String age;
    @DynamoDBAttribute(attributeName = "Country")
    private String country;
    @DynamoDBAttribute(attributeName = "Created")
    private String created;
    @DynamoDBAttribute(attributeName = "Gender")
    private String gender;
    @DynamoDBAttribute(attributeName = "Height")
    private String height;
    @DynamoDBAttribute(attributeName = "OS")
    private final String os = "Android";
    @DynamoDBAttribute(attributeName = "OS ver")
    private String osVersion;
    @DynamoDBAttribute(attributeName = "Owner ID")
    @DynamoDBHashKey(attributeName = "Owner ID")
    private String ownerId;
    @DynamoDBAttribute(attributeName = "State")
    private String state;
    @DynamoDBAttribute(attributeName = "Updated")
    private String updated;
    @DynamoDBAttribute(attributeName = "Weight")
    private String wight;

    public static /* synthetic */ UserInfoEntity copy$default(UserInfoEntity userInfoEntity, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userInfoEntity.gender;
        }
        if ((i & 2) != 0) {
            str2 = userInfoEntity.age;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = userInfoEntity.height;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = userInfoEntity.wight;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = userInfoEntity.country;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = userInfoEntity.state;
        }
        return userInfoEntity.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.gender;
    }

    public final String component2() {
        return this.age;
    }

    public final String component3() {
        return this.height;
    }

    public final String component4() {
        return this.wight;
    }

    public final String component5() {
        return this.country;
    }

    public final String component6() {
        return this.state;
    }

    public final UserInfoEntity copy(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, HintConstants.AUTOFILL_HINT_GENDER);
        Intrinsics.checkNotNullParameter(str2, "age");
        Intrinsics.checkNotNullParameter(str3, "height");
        Intrinsics.checkNotNullParameter(str4, "wight");
        Intrinsics.checkNotNullParameter(str5, "country");
        Intrinsics.checkNotNullParameter(str6, "state");
        return new UserInfoEntity(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserInfoEntity)) {
            return false;
        }
        UserInfoEntity userInfoEntity = (UserInfoEntity) obj;
        return Intrinsics.areEqual((Object) this.gender, (Object) userInfoEntity.gender) && Intrinsics.areEqual((Object) this.age, (Object) userInfoEntity.age) && Intrinsics.areEqual((Object) this.height, (Object) userInfoEntity.height) && Intrinsics.areEqual((Object) this.wight, (Object) userInfoEntity.wight) && Intrinsics.areEqual((Object) this.country, (Object) userInfoEntity.country) && Intrinsics.areEqual((Object) this.state, (Object) userInfoEntity.state);
    }

    public int hashCode() {
        return (((((((((this.gender.hashCode() * 31) + this.age.hashCode()) * 31) + this.height.hashCode()) * 31) + this.wight.hashCode()) * 31) + this.country.hashCode()) * 31) + this.state.hashCode();
    }

    public String toString() {
        String str = this.gender;
        String str2 = this.age;
        String str3 = this.height;
        String str4 = this.wight;
        String str5 = this.country;
        String str6 = this.state;
        return "UserInfoEntity(gender=" + str + ", age=" + str2 + ", height=" + str3 + ", wight=" + str4 + ", country=" + str5 + ", state=" + str6 + ")";
    }

    public UserInfoEntity(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, HintConstants.AUTOFILL_HINT_GENDER);
        Intrinsics.checkNotNullParameter(str2, "age");
        Intrinsics.checkNotNullParameter(str3, "height");
        Intrinsics.checkNotNullParameter(str4, "wight");
        Intrinsics.checkNotNullParameter(str5, "country");
        Intrinsics.checkNotNullParameter(str6, "state");
        this.gender = str;
        this.age = str2;
        this.height = str3;
        this.wight = str4;
        this.country = str5;
        this.state = str6;
    }

    public final String getGender() {
        return this.gender;
    }

    public final void setGender(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gender = str;
    }

    public final String getAge() {
        return this.age;
    }

    public final void setAge(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.age = str;
    }

    public final String getHeight() {
        return this.height;
    }

    public final void setHeight(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.height = str;
    }

    public final String getWight() {
        return this.wight;
    }

    public final void setWight(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.wight = str;
    }

    public final String getCountry() {
        return this.country;
    }

    public final void setCountry(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.country = str;
    }

    public final String getState() {
        return this.state;
    }

    public final void setState(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.state = str;
    }

    public final String getOwnerId() {
        return this.ownerId;
    }

    public final void setOwnerId(String str) {
        this.ownerId = str;
    }

    public final String getOs() {
        return this.os;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final void setOsVersion(String str) {
        this.osVersion = str;
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
