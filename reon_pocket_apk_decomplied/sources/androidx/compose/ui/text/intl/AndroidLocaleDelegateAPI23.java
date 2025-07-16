package androidx.compose.ui.text.intl;

import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/intl/AndroidLocaleDelegateAPI23;", "Landroidx/compose/ui/text/intl/PlatformLocaleDelegate;", "()V", "current", "Landroidx/compose/ui/text/intl/LocaleList;", "getCurrent", "()Landroidx/compose/ui/text/intl/LocaleList;", "parseLanguageTag", "Landroidx/compose/ui/text/intl/PlatformLocale;", "languageTag", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidLocaleDelegate.android.kt */
public final class AndroidLocaleDelegateAPI23 implements PlatformLocaleDelegate {
    public static final int $stable = 0;

    public LocaleList getCurrent() {
        return new LocaleList((List<Locale>) CollectionsKt.listOf(new Locale((PlatformLocale) new AndroidLocale(Locale.getDefault()))));
    }

    public PlatformLocale parseLanguageTag(String str) {
        return new AndroidLocale(Locale.forLanguageTag(str));
    }
}
