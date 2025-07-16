package jp.co.sony.reonpocket.data.interactor;

import android.content.Context;
import java.util.Date;
import java.util.Set;
import jp.co.sony.reonpocket.connection.aws.UserInfoEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0017\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u000eJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u000eJ\u0017\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u000eJ\u0017\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u000eJ\u0017\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u000eJ\u0017\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\bJ\u0017\u0010\u0019\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u000eJ\u0017\u0010\u001a\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u001bJ\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u001eJ\u0017\u0010\u001f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u000eJ\u0017\u0010 \u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u001bJ\u0017\u0010!\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u001eJ\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010%\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0007H&J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010(\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\fH&J\u0018\u0010*\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\fH&J\u0018\u0010+\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\fH&J\u0018\u0010,\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\fH&J\u0018\u0010-\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\fH&J\u0018\u0010.\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\fH&J\u0018\u0010/\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00100\u001a\u000201H&J\u0018\u00102\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0016H&J\u0018\u00104\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00105\u001a\u00020\fH&J\u0018\u00106\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0007H&J\u0018\u00107\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\fH&J\u0018\u00108\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00109\u001a\u00020\nH&J\u0018\u0010:\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u001dH&J\u0018\u0010;\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\fH&J\u0018\u0010<\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00109\u001a\u00020\nH&J\u0018\u0010=\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u001dH&J\u0018\u0010>\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u0016H&JK\u0010@\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010A\u001a\u0004\u0018\u00010$2\u0006\u0010B\u001a\u00020\f2%\b\u0002\u0010C\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020\u0003\u0018\u00010DH&¨\u0006H"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/UserInfoInteractorInput;", "Ljp/co/sony/reonpocket/data/interactor/BaseInteractorInput;", "clearOperationTimeSet", "", "aContext", "Landroid/content/Context;", "getAutoStopTime", "", "(Landroid/content/Context;)Ljava/lang/Long;", "getConnectionErrorTime", "", "getIsAlreadyUserInfoSetup", "", "getIsNextShowAutoStopMessage", "(Landroid/content/Context;)Ljava/lang/Boolean;", "getIsShownAutoStartPopup", "getIsShownLocationPopup", "getIsShownSmartCoolBefore", "getIsShownSmartWarmBefore", "getIsShownWavePopup", "getOperationTimeSet", "", "", "getOwnerID", "getReviewPopupTime", "getSmartCoachingAnimeIsDisplay", "getSmartCoolPreference", "(Landroid/content/Context;)Ljava/lang/Integer;", "getSmartCoolTempSwitchThreshold", "", "(Landroid/content/Context;)Ljava/lang/Double;", "getSmartMixPreference", "getSmartWarmPreference", "getSmartWarmTempSwitchThreshold", "getTopic", "getUserInfo", "Ljp/co/sony/reonpocket/connection/aws/UserInfoEntity;", "saveAutoStopTime", "aValue", "saveConnectionError", "saveIsNeedAutoStartPopup", "isNeedInitialSetup", "saveIsNeedLocationPopup", "saveIsNeedWavePopup", "saveIsNextShowAutoStopMessage", "saveIsShownSmartCoolBefore", "saveIsShownSmartWarmBefore", "saveOperationTime", "aTime", "Ljava/util/Date;", "saveOwnerID", "ownerID", "saveReonInitializeFlag", "isInitialized", "saveReviewPopupTime", "saveSmartCoachingAnimeIsDisplay", "saveSmartCoolPreference", "aPreferenceCode", "saveSmartCoolTempSwitchThreshold", "saveSmartMixPreference", "saveSmartWarmPreference", "saveSmartWarmTempSwitchThreshold", "saveTopic", "aTopic", "saveUserInfo", "aUserInfoEntity", "aIsCreate", "aCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "aResult", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: UserInfoInteractorInput.kt */
public interface UserInfoInteractorInput extends BaseInteractorInput {
    void clearOperationTimeSet(Context context);

    Long getAutoStopTime(Context context);

    int getConnectionErrorTime(Context context);

    boolean getIsAlreadyUserInfoSetup(Context context);

    Boolean getIsNextShowAutoStopMessage(Context context);

    Boolean getIsShownAutoStartPopup(Context context);

    Boolean getIsShownLocationPopup(Context context);

    Boolean getIsShownSmartCoolBefore(Context context);

    Boolean getIsShownSmartWarmBefore(Context context);

    Boolean getIsShownWavePopup(Context context);

    Set<String> getOperationTimeSet(Context context);

    String getOwnerID(Context context);

    Long getReviewPopupTime(Context context);

    Boolean getSmartCoachingAnimeIsDisplay(Context context);

    Integer getSmartCoolPreference(Context context);

    Double getSmartCoolTempSwitchThreshold(Context context);

    Boolean getSmartMixPreference(Context context);

    Integer getSmartWarmPreference(Context context);

    Double getSmartWarmTempSwitchThreshold(Context context);

    String getTopic(Context context);

    UserInfoEntity getUserInfo(Context context);

    void saveAutoStopTime(Context context, long j);

    void saveConnectionError(Context context);

    void saveIsNeedAutoStartPopup(Context context, boolean z);

    void saveIsNeedLocationPopup(Context context, boolean z);

    void saveIsNeedWavePopup(Context context, boolean z);

    void saveIsNextShowAutoStopMessage(Context context, boolean z);

    void saveIsShownSmartCoolBefore(Context context, boolean z);

    void saveIsShownSmartWarmBefore(Context context, boolean z);

    void saveOperationTime(Context context, Date date);

    void saveOwnerID(Context context, String str);

    void saveReonInitializeFlag(Context context, boolean z);

    void saveReviewPopupTime(Context context, long j);

    void saveSmartCoachingAnimeIsDisplay(Context context, boolean z);

    void saveSmartCoolPreference(Context context, int i);

    void saveSmartCoolTempSwitchThreshold(Context context, double d);

    void saveSmartMixPreference(Context context, boolean z);

    void saveSmartWarmPreference(Context context, int i);

    void saveSmartWarmTempSwitchThreshold(Context context, double d);

    void saveTopic(Context context, String str);

    void saveUserInfo(Context context, UserInfoEntity userInfoEntity, boolean z, Function1<? super Boolean, Unit> function1);

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: UserInfoInteractorInput.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void saveUserInfo$default(UserInfoInteractorInput userInfoInteractorInput, Context context, UserInfoEntity userInfoEntity, boolean z, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    userInfoEntity = null;
                }
                if ((i & 8) != 0) {
                    function1 = null;
                }
                userInfoInteractorInput.saveUserInfo(context, userInfoEntity, z, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveUserInfo");
        }
    }
}
