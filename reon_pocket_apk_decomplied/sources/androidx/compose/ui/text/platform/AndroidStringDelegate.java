package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.PlatformStringDelegate;
import androidx.compose.ui.text.intl.AndroidLocale;
import androidx.compose.ui.text.intl.PlatformLocale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/platform/AndroidStringDelegate;", "Landroidx/compose/ui/text/PlatformStringDelegate;", "()V", "capitalize", "", "string", "locale", "Landroidx/compose/ui/text/intl/PlatformLocale;", "decapitalize", "toLowerCase", "toUpperCase", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidStringDelegate.android.kt */
public final class AndroidStringDelegate implements PlatformStringDelegate {
    public static final int $stable = 0;

    public String toUpperCase(String str, PlatformLocale platformLocale) {
        Intrinsics.checkNotNull(platformLocale, "null cannot be cast to non-null type androidx.compose.ui.text.intl.AndroidLocale");
        String upperCase = str.toUpperCase(((AndroidLocale) platformLocale).getJavaLocale());
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    public String toLowerCase(String str, PlatformLocale platformLocale) {
        Intrinsics.checkNotNull(platformLocale, "null cannot be cast to non-null type androidx.compose.ui.text.intl.AndroidLocale");
        String lowerCase = str.toLowerCase(((AndroidLocale) platformLocale).getJavaLocale());
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    public String capitalize(String str, PlatformLocale platformLocale) {
        String str2;
        if (str.length() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char charAt = str.charAt(0);
        if (Character.isLowerCase(charAt)) {
            Intrinsics.checkNotNull(platformLocale, "null cannot be cast to non-null type androidx.compose.ui.text.intl.AndroidLocale");
            str2 = CharsKt.titlecase(charAt, ((AndroidLocale) platformLocale).getJavaLocale());
        } else {
            str2 = String.valueOf(charAt);
        }
        sb.append(str2);
        String substring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        sb.append(substring);
        return sb.toString();
    }

    public String decapitalize(String str, PlatformLocale platformLocale) {
        if (str.length() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char charAt = str.charAt(0);
        Intrinsics.checkNotNull(platformLocale, "null cannot be cast to non-null type androidx.compose.ui.text.intl.AndroidLocale");
        sb.append(CharsKt.lowercase(charAt, ((AndroidLocale) platformLocale).getJavaLocale()));
        String substring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        sb.append(substring);
        return sb.toString();
    }
}
