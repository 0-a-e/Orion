package jp.co.sony.reonpocket.data.interactor;

import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import jp.co.sony.reonpocket.connection.aws.AWSManager;
import jp.co.sony.reonpocket.connection.aws.UserInfoEntity;
import jp.co.sony.reonpocket.util.SimpleStorageUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 L2\u00020\u0001:\u0001LB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0017\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\nH\u0016J\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u0013J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u0013J\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u0013J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u0013J\u0017\u0010\u0017\u001a\u0004\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u0013J\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0017\u0010\u001d\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\rJ\u0017\u0010\u001e\u001a\u0004\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u0013J\u0017\u0010\u001f\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010 J\u0015\u0010!\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010#J\u0017\u0010$\u001a\u0004\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u0013J\u0017\u0010%\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010 J\u0015\u0010&\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010#J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010)\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010*\u001a\u00020\fH\u0016J\u0010\u0010+\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010,\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u0011H\u0016J\u0018\u0010.\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u0011H\u0016J\u0018\u0010/\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u0011H\u0016J\u0018\u00100\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u0011H\u0016J\u0018\u00101\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u0011H\u0016J\u0018\u00102\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u0011H\u0016J\u0018\u00103\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u00104\u001a\u000205H\u0016J\u0018\u00106\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u00107\u001a\u00020\u001bH\u0016J\u0018\u00108\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u00109\u001a\u00020\u0011H\u0016J\u0018\u0010:\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u00104\u001a\u00020\fH\u0016J\u0018\u0010;\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u0011H\u0016J\u0018\u0010<\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010=\u001a\u00020\u000fH\u0016J\u0018\u0010>\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010*\u001a\u00020\"H\u0016J\u0018\u0010?\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u0011H\u0016J\u0018\u0010@\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010=\u001a\u00020\u000fH\u0016J\u0018\u0010A\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010*\u001a\u00020\"H\u0016J\u0018\u0010B\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010C\u001a\u00020\u001bH\u0016JG\u0010D\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010E\u001a\u0004\u0018\u00010\u00062\u0006\u0010F\u001a\u00020\u00112#\u0010G\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\b\u0018\u00010HH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/UserInfoInteractor;", "Ljp/co/sony/reonpocket/data/interactor/UserInfoInteractorInput;", "()V", "mDayFormat", "Ljava/text/SimpleDateFormat;", "mUserInfoEntityUndefined", "Ljp/co/sony/reonpocket/connection/aws/UserInfoEntity;", "clearOperationTimeSet", "", "aContext", "Landroid/content/Context;", "getAutoStopTime", "", "(Landroid/content/Context;)Ljava/lang/Long;", "getConnectionErrorTime", "", "getIsAlreadyUserInfoSetup", "", "getIsNextShowAutoStopMessage", "(Landroid/content/Context;)Ljava/lang/Boolean;", "getIsShownAutoStartPopup", "getIsShownLocationPopup", "getIsShownSmartCoolBefore", "getIsShownSmartWarmBefore", "getIsShownWavePopup", "getOperationTimeSet", "", "", "getOwnerID", "getReviewPopupTime", "getSmartCoachingAnimeIsDisplay", "getSmartCoolPreference", "(Landroid/content/Context;)Ljava/lang/Integer;", "getSmartCoolTempSwitchThreshold", "", "(Landroid/content/Context;)Ljava/lang/Double;", "getSmartMixPreference", "getSmartWarmPreference", "getSmartWarmTempSwitchThreshold", "getTopic", "getUserInfo", "saveAutoStopTime", "aValue", "saveConnectionError", "saveIsNeedAutoStartPopup", "isNeedInitialSetup", "saveIsNeedLocationPopup", "saveIsNeedWavePopup", "saveIsNextShowAutoStopMessage", "saveIsShownSmartCoolBefore", "saveIsShownSmartWarmBefore", "saveOperationTime", "aTime", "Ljava/util/Date;", "saveOwnerID", "ownerID", "saveReonInitializeFlag", "isInitialized", "saveReviewPopupTime", "saveSmartCoachingAnimeIsDisplay", "saveSmartCoolPreference", "aPreferenceCode", "saveSmartCoolTempSwitchThreshold", "saveSmartMixPreference", "saveSmartWarmPreference", "saveSmartWarmTempSwitchThreshold", "saveTopic", "aTopic", "saveUserInfo", "aUserInfoEntity", "aIsCreate", "aCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "aResult", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: UserInfoInteractor.kt */
public final class UserInfoInteractor implements UserInfoInteractorInput {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long ZERO_NUMBER = 0;
    private final SimpleDateFormat mDayFormat = new SimpleDateFormat("yyyy/MM/dd");
    private final UserInfoEntity mUserInfoEntityUndefined = new UserInfoEntity("Unknown", "Unknown", "Unknown", "Unknown", "Japan", "Unknown");

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/UserInfoInteractor$Companion;", "", "()V", "ZERO_NUMBER", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: UserInfoInteractor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void saveOwnerID(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "ownerID");
        SimpleStorageUtil.INSTANCE.setStringValue(context, SimpleStorageUtil.REON_OWNER_ID, str);
    }

    public void saveReonInitializeFlag(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        SimpleStorageUtil.INSTANCE.setBooleanValue(context, SimpleStorageUtil.REON_INITIALIZE_FLAG, z);
    }

    public void saveIsNeedWavePopup(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        SimpleStorageUtil.INSTANCE.setBooleanValue(context, SimpleStorageUtil.REON_WAVE_GUIDE_FLAG, false);
    }

    public void saveIsNeedLocationPopup(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        SimpleStorageUtil.INSTANCE.setBooleanValue(context, SimpleStorageUtil.REON_LOCATION_GUIDE_FLAG, false);
    }

    public void saveIsNeedAutoStartPopup(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        SimpleStorageUtil.INSTANCE.setBooleanValue(context, SimpleStorageUtil.REON_AUTO_START_GUIDE_FLAG, z);
    }

    public void saveUserInfo(Context context, UserInfoEntity userInfoEntity, boolean z, Function1<? super Boolean, Unit> function1) {
        Unit unit;
        Intrinsics.checkNotNullParameter(context, "aContext");
        if (userInfoEntity != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SimpleStorageUtil.REON_USER_INFO_KEY_GENDER, userInfoEntity.getGender());
            jSONObject.put(SimpleStorageUtil.REON_USER_INFO_KEY_AGE, userInfoEntity.getAge());
            jSONObject.put(SimpleStorageUtil.REON_USER_INFO_KEY_HEIGHT, userInfoEntity.getHeight());
            jSONObject.put(SimpleStorageUtil.REON_USER_INFO_KEY_WEIGHT, userInfoEntity.getWight());
            jSONObject.put(SimpleStorageUtil.REON_USER_INFO_KEY_STATE, userInfoEntity.getState());
            jSONObject.put(SimpleStorageUtil.REON_USER_INFO_KEY_COUNTRY, userInfoEntity.getCountry());
            SimpleStorageUtil simpleStorageUtil = SimpleStorageUtil.INSTANCE;
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
            simpleStorageUtil.setStringValue(context, SimpleStorageUtil.REON_USER_INFO_CONTENT, jSONObject2);
            AWSManager.INSTANCE.registerUserInfo(context, userInfoEntity, z, function1);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            AWSManager.INSTANCE.registerUserInfo(context, this.mUserInfoEntityUndefined, z, function1);
        }
    }

    public String getOwnerID(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        return SimpleStorageUtil.INSTANCE.getStringValue(context, SimpleStorageUtil.REON_OWNER_ID);
    }

    public Boolean getIsShownWavePopup(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        return SimpleStorageUtil.INSTANCE.getBooleanValue(context, SimpleStorageUtil.REON_WAVE_GUIDE_FLAG);
    }

    public Boolean getIsShownLocationPopup(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        return SimpleStorageUtil.INSTANCE.getBooleanValue(context, SimpleStorageUtil.REON_LOCATION_GUIDE_FLAG);
    }

    public Boolean getIsShownAutoStartPopup(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        return SimpleStorageUtil.INSTANCE.getBooleanValue(context, SimpleStorageUtil.REON_AUTO_START_GUIDE_FLAG);
    }

    public boolean getIsAlreadyUserInfoSetup(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        return SimpleStorageUtil.INSTANCE.getBooleanValue(context, SimpleStorageUtil.REON_INITIALIZE_FLAG, false);
    }

    public UserInfoEntity getUserInfo(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        String stringValue = SimpleStorageUtil.INSTANCE.getStringValue(context, SimpleStorageUtil.REON_USER_INFO_CONTENT);
        if (stringValue == null) {
            return this.mUserInfoEntityUndefined;
        }
        try {
            JSONObject jSONObject = new JSONObject(stringValue);
            String string = jSONObject.getString(SimpleStorageUtil.REON_USER_INFO_KEY_GENDER);
            String string2 = jSONObject.getString(SimpleStorageUtil.REON_USER_INFO_KEY_AGE);
            String string3 = jSONObject.getString(SimpleStorageUtil.REON_USER_INFO_KEY_HEIGHT);
            String string4 = jSONObject.getString(SimpleStorageUtil.REON_USER_INFO_KEY_WEIGHT);
            String string5 = jSONObject.getString(SimpleStorageUtil.REON_USER_INFO_KEY_STATE);
            String string6 = jSONObject.getString(SimpleStorageUtil.REON_USER_INFO_KEY_COUNTRY);
            Intrinsics.checkNotNull(string);
            Intrinsics.checkNotNull(string2);
            Intrinsics.checkNotNull(string3);
            Intrinsics.checkNotNull(string4);
            Intrinsics.checkNotNull(string6);
            Intrinsics.checkNotNull(string5);
            return new UserInfoEntity(string, string2, string3, string4, string6, string5);
        } catch (JSONException e) {
            e.printStackTrace();
            return this.mUserInfoEntityUndefined;
        }
    }

    public void saveOperationTime(Context context, Date date) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(date, "aTime");
        Set<String> stringSet = SimpleStorageUtil.INSTANCE.getStringSet(context, SimpleStorageUtil.REON_USER_USES_DAY_TIMES);
        if (stringSet == null) {
            stringSet = new LinkedHashSet<>();
        }
        String format = this.mDayFormat.format(date);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        stringSet.add(format);
        SimpleStorageUtil.INSTANCE.setStringSet(context, SimpleStorageUtil.REON_USER_USES_DAY_TIMES, stringSet);
    }

    public Set<String> getOperationTimeSet(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Set<String> stringSet = SimpleStorageUtil.INSTANCE.getStringSet(context, SimpleStorageUtil.REON_USER_USES_DAY_TIMES);
        return stringSet == null ? new LinkedHashSet<>() : stringSet;
    }

    public void saveConnectionError(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Integer intValue = SimpleStorageUtil.INSTANCE.getIntValue(context, SimpleStorageUtil.REON_USER_CONNECTION_ERROR_TIME);
        int intValue2 = intValue != null ? intValue.intValue() : 0;
        SimpleStorageUtil simpleStorageUtil = SimpleStorageUtil.INSTANCE;
        int i = 1;
        if (intValue2 > 0) {
            i = 1 + intValue2;
        }
        simpleStorageUtil.setIntValue(context, SimpleStorageUtil.REON_USER_CONNECTION_ERROR_TIME, i);
    }

    public int getConnectionErrorTime(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Integer intValue = SimpleStorageUtil.INSTANCE.getIntValue(context, SimpleStorageUtil.REON_USER_CONNECTION_ERROR_TIME);
        if (intValue != null) {
            return intValue.intValue();
        }
        return 0;
    }

    public void clearOperationTimeSet(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        SimpleStorageUtil.INSTANCE.setStringSet(context, SimpleStorageUtil.REON_USER_USES_DAY_TIMES, new LinkedHashSet());
    }

    public Long getReviewPopupTime(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        return SimpleStorageUtil.INSTANCE.getLongValue(context, SimpleStorageUtil.REON_USER_STORE_REVIEW_POPUP_TIME);
    }

    public void saveReviewPopupTime(Context context, long j) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        SimpleStorageUtil.INSTANCE.setLongValue(context, SimpleStorageUtil.REON_USER_STORE_REVIEW_POPUP_TIME, j);
    }

    public String getTopic(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        String stringValue = SimpleStorageUtil.INSTANCE.getStringValue(context, SimpleStorageUtil.REON_NOTIFICATION_TOPIC);
        return stringValue == null ? "" : stringValue;
    }

    public void saveTopic(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aTopic");
        SimpleStorageUtil.INSTANCE.setStringValue(context, SimpleStorageUtil.REON_NOTIFICATION_TOPIC, str);
    }

    public void saveIsNextShowAutoStopMessage(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        SimpleStorageUtil.INSTANCE.setStringValue(context, SimpleStorageUtil.REON_NEXT_SHOW_AUTO_MESSAGE_FLAG, String.valueOf(z));
    }

    public void saveAutoStopTime(Context context, long j) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        SimpleStorageUtil.INSTANCE.setLongValue(context, SimpleStorageUtil.REON_AUTO_STOP_TIME, j);
    }

    public Boolean getIsNextShowAutoStopMessage(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        String stringValue = SimpleStorageUtil.INSTANCE.getStringValue(context, SimpleStorageUtil.REON_NEXT_SHOW_AUTO_MESSAGE_FLAG);
        CharSequence charSequence = stringValue;
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        return Boolean.valueOf(Boolean.parseBoolean(stringValue));
    }

    public Long getAutoStopTime(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        return SimpleStorageUtil.INSTANCE.getLongValue(context, SimpleStorageUtil.REON_AUTO_STOP_TIME);
    }

    public void saveIsShownSmartCoolBefore(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        SimpleStorageUtil.INSTANCE.setBooleanValue(context, SimpleStorageUtil.REON_IS_SHOWN_SMART_COOL_BEFORE, z);
    }

    public Boolean getIsShownSmartCoolBefore(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        return SimpleStorageUtil.INSTANCE.getBooleanValue(context, SimpleStorageUtil.REON_IS_SHOWN_SMART_COOL_BEFORE);
    }

    public void saveIsShownSmartWarmBefore(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        SimpleStorageUtil.INSTANCE.setBooleanValue(context, SimpleStorageUtil.REON_IS_SHOWN_SMART_WARM_BEFORE, z);
    }

    public Boolean getIsShownSmartWarmBefore(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        return SimpleStorageUtil.INSTANCE.getBooleanValue(context, SimpleStorageUtil.REON_IS_SHOWN_SMART_WARM_BEFORE);
    }

    public void saveSmartCoolPreference(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        SimpleStorageUtil.INSTANCE.setIntValue(context, SimpleStorageUtil.REON_SMART_PREFERENCE_CODE, i);
    }

    public Integer getSmartCoolPreference(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        return SimpleStorageUtil.INSTANCE.getIntValue(context, SimpleStorageUtil.REON_SMART_PREFERENCE_CODE);
    }

    public void saveSmartWarmPreference(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        SimpleStorageUtil.INSTANCE.setIntValue(context, SimpleStorageUtil.REON_SMART_WARM_PREFERENCE_CODE, i);
    }

    public Integer getSmartWarmPreference(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        return SimpleStorageUtil.INSTANCE.getIntValue(context, SimpleStorageUtil.REON_SMART_WARM_PREFERENCE_CODE);
    }

    public void saveSmartMixPreference(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        SimpleStorageUtil.INSTANCE.setBooleanValue(context, SimpleStorageUtil.REON_SMART_MIX_PREFERENCE_CODE, z);
    }

    public Boolean getSmartMixPreference(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        return SimpleStorageUtil.INSTANCE.getBooleanValue(context, SimpleStorageUtil.REON_SMART_MIX_PREFERENCE_CODE);
    }

    public void saveSmartCoolTempSwitchThreshold(Context context, double d) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        SimpleStorageUtil.INSTANCE.setStringValue(context, SimpleStorageUtil.REON_SMART_COOL_TEMP_SWITCH_THRESHOLD_CODE, String.valueOf(d));
    }

    public Double getSmartCoolTempSwitchThreshold(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        String stringValue = SimpleStorageUtil.INSTANCE.getStringValue(context, SimpleStorageUtil.REON_SMART_COOL_TEMP_SWITCH_THRESHOLD_CODE);
        CharSequence charSequence = stringValue;
        return Double.valueOf((charSequence == null || charSequence.length() == 0) ? 25.0d : Double.parseDouble(stringValue));
    }

    public void saveSmartWarmTempSwitchThreshold(Context context, double d) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        SimpleStorageUtil.INSTANCE.setStringValue(context, SimpleStorageUtil.REON_SMART_WARM_TEMP_SWITCH_THRESHOLD_CODE, String.valueOf(d));
    }

    public Double getSmartWarmTempSwitchThreshold(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        String stringValue = SimpleStorageUtil.INSTANCE.getStringValue(context, SimpleStorageUtil.REON_SMART_WARM_TEMP_SWITCH_THRESHOLD_CODE);
        CharSequence charSequence = stringValue;
        return Double.valueOf((charSequence == null || charSequence.length() == 0) ? 25.0d : Double.parseDouble(stringValue));
    }

    public void saveSmartCoachingAnimeIsDisplay(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        SimpleStorageUtil.INSTANCE.setBooleanValue(context, SimpleStorageUtil.REON_SMART_COACHING_ANIME_IS_DISPLAY, z);
    }

    public Boolean getSmartCoachingAnimeIsDisplay(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        return SimpleStorageUtil.INSTANCE.getBooleanValue(context, SimpleStorageUtil.REON_SMART_COACHING_ANIME_IS_DISPLAY);
    }
}
