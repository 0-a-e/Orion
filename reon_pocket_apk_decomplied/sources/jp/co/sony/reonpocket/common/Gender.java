package jp.co.sony.reonpocket.common;

import android.content.Context;
import jp.co.sony.reonpocket.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Ljp/co/sony/reonpocket/common/Gender;", "", "()V", "getGender", "", "", "aContext", "Landroid/content/Context;", "(Landroid/content/Context;)[Ljava/lang/String;", "getGenderValue", "()[Ljava/lang/String;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: Gender.kt */
public final class Gender {
    public static final int $stable = 0;
    public static final Gender INSTANCE = new Gender();

    private Gender() {
    }

    public final String[] getGender(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        String string = context.getString(R.string.user_info_gender_male);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = context.getString(R.string.user_info_gender_female);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = context.getString(R.string.user_info_gender_other);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        return new String[]{string, string2, string3};
    }

    public final String[] getGenderValue() {
        return new String[]{"Male", "Female", "Unknown"};
    }
}
