package androidx.compose.ui.text.intl;

import java.util.Locale;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\n¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/text/intl/AndroidLocale;", "Landroidx/compose/ui/text/intl/PlatformLocale;", "javaLocale", "Ljava/util/Locale;", "(Ljava/util/Locale;)V", "getJavaLocale", "()Ljava/util/Locale;", "language", "", "getLanguage", "()Ljava/lang/String;", "region", "getRegion", "script", "getScript", "toLanguageTag", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidLocaleDelegate.android.kt */
public final class AndroidLocale implements PlatformLocale {
    public static final int $stable = 8;
    private final Locale javaLocale;

    public AndroidLocale(Locale locale) {
        this.javaLocale = locale;
    }

    public final Locale getJavaLocale() {
        return this.javaLocale;
    }

    public String getLanguage() {
        return this.javaLocale.getLanguage();
    }

    public String getScript() {
        return this.javaLocale.getScript();
    }

    public String getRegion() {
        return this.javaLocale.getCountry();
    }

    public String toLanguageTag() {
        return this.javaLocale.toLanguageTag();
    }
}
