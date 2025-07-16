package jp.co.sony.reonpocket.util;

import android.content.Context;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004J\"\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004J\"\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u0004H\u0002J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0004J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0004J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006J$\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u0004H\u0002¨\u0006\u0015"}, d2 = {"Ljp/co/sony/reonpocket/util/MyContentUtil;", "", "()V", "getEulaURL", "", "aContext", "Landroid/content/Context;", "aCountryCode", "aEnv", "getPrivacyURL", "getSupportURL", "isJaJP", "", "aLanguageCode", "isShowTwitter", "isSupportEula", "isSupportFeedback", "isSupportLog", "isSupportPrivacyPolicy", "isValidUserInfo", "isZhHK", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MyContentUtil.kt */
public final class MyContentUtil {
    public static final int $stable = 0;
    public static final MyContentUtil INSTANCE = new MyContentUtil();

    private MyContentUtil() {
    }

    public static /* synthetic */ String getEulaURL$default(MyContentUtil myContentUtil, Context context, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = LocaleUtil.INSTANCE.getLocale(context).getCountry();
            Intrinsics.checkNotNullExpressionValue(str, "getCountry(...)");
        }
        if ((i & 4) != 0) {
            str2 = "";
        }
        return myContentUtil.getEulaURL(context, str, str2);
    }

    public final String getEulaURL(Context context, String str, String str2) {
        String str3;
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aCountryCode");
        Intrinsics.checkNotNullParameter(str2, "aEnv");
        if (isSupportEula(str)) {
            str3 = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str3, "toLowerCase(...)");
        } else {
            str3 = "other";
        }
        return "https://" + str2 + "reonpocket.sony.com/app/" + str3 + "/eula/eula-" + str3 + ".html";
    }

    public static /* synthetic */ String getPrivacyURL$default(MyContentUtil myContentUtil, Context context, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = LocaleUtil.INSTANCE.getLocale(context).getCountry();
            Intrinsics.checkNotNullExpressionValue(str, "getCountry(...)");
        }
        if ((i & 4) != 0) {
            str2 = "";
        }
        return myContentUtil.getPrivacyURL(context, str, str2);
    }

    public final String getPrivacyURL(Context context, String str, String str2) {
        String str3;
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aCountryCode");
        Intrinsics.checkNotNullParameter(str2, "aEnv");
        if (isSupportPrivacyPolicy(str)) {
            str3 = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str3, "toLowerCase(...)");
        } else {
            str3 = "other";
        }
        return "https://" + str2 + "reonpocket.sony.com/app/" + str3 + "/privacy/privacy_" + str3 + ".html";
    }

    public static /* synthetic */ String getSupportURL$default(MyContentUtil myContentUtil, Context context, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = LocaleUtil.INSTANCE.getLocale(context).getCountry();
            Intrinsics.checkNotNullExpressionValue(str, "getCountry(...)");
        }
        if ((i & 4) != 0) {
            str2 = "";
        }
        return myContentUtil.getSupportURL(context, str, str2);
    }

    public final String getSupportURL(Context context, String str, String str2) {
        String str3 = str;
        String str4 = str2;
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str3, "aCountryCode");
        Intrinsics.checkNotNullParameter(str4, "aEnv");
        if (Intrinsics.areEqual((Object) str3, (Object) "JP")) {
            return "https://" + str4 + "reonpocket.sony.co.jp/support/index.html";
        } else if (CollectionsKt.listOf("HK", "GB", "SG", "MY", "TH", "VN", "KR", "TW", "AE", "SA", "BH", "OM", "QA", "KW", "FR", "DE", "IT", "ES", "CH", "AT", "IE").contains(str3)) {
            String lowerCase = str3.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return "https://" + str4 + "reonpocket.sony.com/" + lowerCase + "/support/index.html";
        } else {
            return "https://" + str4 + "reonpocket.sony.com/other/support/index.html";
        }
    }

    public final boolean isShowTwitter(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        return isJaJP$default(this, context, (String) null, (String) null, 6, (Object) null);
    }

    public final boolean isValidUserInfo(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        return isJaJP$default(this, context, (String) null, (String) null, 6, (Object) null) || isZhHK$default(this, context, (String) null, (String) null, 6, (Object) null);
    }

    static /* synthetic */ boolean isJaJP$default(MyContentUtil myContentUtil, Context context, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = LocaleUtil.INSTANCE.getLocale(context).getCountry();
            Intrinsics.checkNotNullExpressionValue(str, "getCountry(...)");
        }
        if ((i & 4) != 0) {
            str2 = LocaleUtil.INSTANCE.getLocale(context).getLanguage();
            Intrinsics.checkNotNullExpressionValue(str2, "getLanguage(...)");
        }
        return myContentUtil.isJaJP(context, str, str2);
    }

    private final boolean isJaJP(Context context, String str, String str2) {
        return Intrinsics.areEqual((Object) str, (Object) "JP") && Intrinsics.areEqual((Object) str2, (Object) "ja");
    }

    static /* synthetic */ boolean isZhHK$default(MyContentUtil myContentUtil, Context context, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = LocaleUtil.INSTANCE.getLocale(context).getCountry();
            Intrinsics.checkNotNullExpressionValue(str, "getCountry(...)");
        }
        if ((i & 4) != 0) {
            str2 = LocaleUtil.INSTANCE.getLocale(context).getLanguage();
            Intrinsics.checkNotNullExpressionValue(str2, "getLanguage(...)");
        }
        return myContentUtil.isZhHK(context, str, str2);
    }

    private final boolean isZhHK(Context context, String str, String str2) {
        return Intrinsics.areEqual((Object) str, (Object) "HK") && Intrinsics.areEqual((Object) str2, (Object) "zh");
    }

    public static /* synthetic */ boolean isSupportLog$default(MyContentUtil myContentUtil, Context context, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = LocaleUtil.INSTANCE.getLocale(context).getCountry();
            Intrinsics.checkNotNullExpressionValue(str, "getCountry(...)");
        }
        return myContentUtil.isSupportLog(context, str);
    }

    public final boolean isSupportLog(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aCountryCode");
        return CollectionsKt.listOf("JP", "HK").contains(str);
    }

    public static /* synthetic */ boolean isSupportFeedback$default(MyContentUtil myContentUtil, Context context, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = LocaleUtil.INSTANCE.getLocale(context).getCountry();
            Intrinsics.checkNotNullExpressionValue(str, "getCountry(...)");
        }
        return myContentUtil.isSupportFeedback(context, str);
    }

    public final boolean isSupportFeedback(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aCountryCode");
        return Intrinsics.areEqual((Object) str, (Object) "JP");
    }

    public final boolean isSupportEula(String str) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "aCountryCode");
        return CollectionsKt.listOf("JP", "HK", "GB", "SG", "MY", "TH", "VN", "KR", "TW", "AE", "SA", "BH", "OM", "QA", "KW", "FR", "DE", "IT", "ES", "CH", "AT", "IE").contains(str2);
    }

    public final boolean isSupportPrivacyPolicy(String str) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "aCountryCode");
        return CollectionsKt.listOf("JP", "HK", "GB", "SG", "MY", "TH", "VN", "KR", "TW", "AE", "SA", "BH", "OM", "QA", "KW", "FR", "DE", "IT", "ES", "CH", "AT", "IE").contains(str2);
    }
}
