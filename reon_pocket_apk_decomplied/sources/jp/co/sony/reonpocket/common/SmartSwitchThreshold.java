package jp.co.sony.reonpocket.common;

import android.content.Context;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.List;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.data.interactor.UserInfoInteractor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0004J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0004J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0004J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Ljp/co/sony/reonpocket/common/SmartSwitchThreshold;", "", "()V", "CHECK_DECIMAL_POINT", "", "DEFAULT_SWITCH_TEMP", "", "INIT_SWITCH_TEMP_COOL", "INIT_SWITCH_TEMP_WARM", "mUserInfoInteractor", "Ljp/co/sony/reonpocket/data/interactor/UserInfoInteractor;", "getMUserInfoInteractor", "()Ljp/co/sony/reonpocket/data/interactor/UserInfoInteractor;", "getSmartCoolTempSwitchThreshold", "", "aContext", "Landroid/content/Context;", "getSmartWarmTempSwitchThreshold", "getSwitchThresholdTempCool", "", "tempString", "getSwitchThresholdTempDurationCool", "Ljp/co/sony/reonpocket/common/SmartSwitchThreshold$Duration;", "getSwitchThresholdTempDurationWarm", "getSwitchThresholdTempWarm", "Duration", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SmartSwithThreshold.kt */
public final class SmartSwitchThreshold {
    public static final int $stable = 8;
    public static final String CHECK_DECIMAL_POINT = "5";
    public static final double DEFAULT_SWITCH_TEMP = 25.0d;
    public static final double INIT_SWITCH_TEMP_COOL = 25.0d;
    public static final double INIT_SWITCH_TEMP_WARM = 20.0d;
    public static final SmartSwitchThreshold INSTANCE = new SmartSwitchThreshold();
    private static final UserInfoInteractor mUserInfoInteractor = new UserInfoInteractor();

    private SmartSwitchThreshold() {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ljp/co/sony/reonpocket/common/SmartSwitchThreshold$Duration;", "", "description", "", "value", "", "(Ljava/lang/String;D)V", "getDescription", "()Ljava/lang/String;", "getValue", "()D", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: SmartSwithThreshold.kt */
    public static final class Duration {
        public static final int $stable = 0;
        private final String description;
        private final double value;

        public Duration(String str, double d) {
            Intrinsics.checkNotNullParameter(str, "description");
            this.description = str;
            this.value = d;
        }

        public final String getDescription() {
            return this.description;
        }

        public final double getValue() {
            return this.value;
        }
    }

    public final UserInfoInteractor getMUserInfoInteractor() {
        return mUserInfoInteractor;
    }

    public final float getSmartCoolTempSwitchThreshold(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        return (float) mUserInfoInteractor.getSmartCoolTempSwitchThreshold(context).doubleValue();
    }

    public final float getSmartWarmTempSwitchThreshold(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        return (float) mUserInfoInteractor.getSmartWarmTempSwitchThreshold(context).doubleValue();
    }

    public final List<String> getSwitchThresholdTempWarm(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "tempString");
        String substring = str.substring(str.length() - 1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        boolean areEqual = Intrinsics.areEqual((Object) substring, (Object) CHECK_DECIMAL_POINT);
        String substring2 = str.substring(0, 2);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        int parseInt = Integer.parseInt(substring2) + 1;
        List<String> arrayList = new ArrayList<>();
        for (int i = 10; i < parseInt; i++) {
            float f = (float) i;
            String string = context.getString(R.string.common_celsius);
            arrayList.add((0.0f + f) + string);
            String string2 = context.getString(R.string.common_celsius);
            arrayList.add((f + 0.5f) + string2);
        }
        if (!areEqual) {
            arrayList.remove(arrayList.size() - 1);
        }
        return arrayList;
    }

    public final List<Duration> getSwitchThresholdTempDurationWarm(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "tempString");
        String substring = str.substring(str.length() - 1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        boolean areEqual = Intrinsics.areEqual((Object) substring, (Object) CHECK_DECIMAL_POINT);
        String substring2 = str.substring(0, 2);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        int parseInt = Integer.parseInt(substring2) + 1;
        List<Duration> arrayList = new ArrayList<>();
        for (int i = 10; i < parseInt; i++) {
            float f = (float) i;
            String string = context.getString(R.string.common_celsius);
            double d = (double) i;
            arrayList.add(new Duration((0.0f + f) + string, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE + d));
            String string2 = context.getString(R.string.common_celsius);
            arrayList.add(new Duration((f + 0.5f) + string2, d + 0.5d));
        }
        if (!areEqual) {
            arrayList.remove(arrayList.size() - 1);
        }
        return arrayList;
    }

    public final List<String> getSwitchThresholdTempCool(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "tempString");
        String substring = str.substring(str.length() - 1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        boolean areEqual = Intrinsics.areEqual((Object) substring, (Object) CHECK_DECIMAL_POINT);
        String substring2 = str.substring(0, 2);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        List<String> arrayList = new ArrayList<>();
        for (int parseInt = Integer.parseInt(substring2); parseInt < 31; parseInt++) {
            float f = (float) parseInt;
            String string = context.getString(R.string.common_celsius);
            arrayList.add((0.0f + f) + string);
            String string2 = context.getString(R.string.common_celsius);
            arrayList.add((f + 0.5f) + string2);
        }
        if (areEqual) {
            arrayList.remove(0);
        }
        arrayList.remove(arrayList.size() - 1);
        return arrayList;
    }

    public final List<Duration> getSwitchThresholdTempDurationCool(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "tempString");
        String substring = str.substring(str.length() - 1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        boolean areEqual = Intrinsics.areEqual((Object) substring, (Object) CHECK_DECIMAL_POINT);
        String substring2 = str.substring(0, 2);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        List<Duration> arrayList = new ArrayList<>();
        for (int parseInt = Integer.parseInt(substring2); parseInt < 31; parseInt++) {
            float f = (float) parseInt;
            String string = context.getString(R.string.common_celsius);
            double d = (double) parseInt;
            arrayList.add(new Duration((0.0f + f) + string, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE + d));
            String string2 = context.getString(R.string.common_celsius);
            arrayList.add(new Duration((f + 0.5f) + string2, d + 0.5d));
        }
        if (areEqual) {
            arrayList.remove(0);
        }
        arrayList.remove(arrayList.size() - 1);
        return arrayList;
    }
}
