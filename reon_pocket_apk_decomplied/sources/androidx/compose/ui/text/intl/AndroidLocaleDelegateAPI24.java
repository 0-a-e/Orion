package androidx.compose.ui.text.intl;

import android.os.LocaleList;
import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import androidx.core.app.NotificationCompat$$ExternalSyntheticApiModelOutline0;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/text/intl/AndroidLocaleDelegateAPI24;", "Landroidx/compose/ui/text/intl/PlatformLocaleDelegate;", "()V", "current", "Landroidx/compose/ui/text/intl/LocaleList;", "getCurrent", "()Landroidx/compose/ui/text/intl/LocaleList;", "lastLocaleList", "lastPlatformLocaleList", "Landroid/os/LocaleList;", "lock", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "parseLanguageTag", "Landroidx/compose/ui/text/intl/PlatformLocale;", "languageTag", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidLocaleDelegate.android.kt */
public final class AndroidLocaleDelegateAPI24 implements PlatformLocaleDelegate {
    public static final int $stable = 8;
    private LocaleList lastLocaleList;
    private LocaleList lastPlatformLocaleList;
    private final SynchronizedObject lock = Synchronization_jvmKt.createSynchronizedObject();

    public LocaleList getCurrent() {
        LocaleList m = NotificationCompat$$ExternalSyntheticApiModelOutline0.m();
        synchronized (this.lock) {
            LocaleList localeList = this.lastLocaleList;
            if (localeList != null && m == this.lastPlatformLocaleList) {
                return localeList;
            }
            int m2 = NotificationCompat$$ExternalSyntheticApiModelOutline0.m(m);
            ArrayList arrayList = new ArrayList(m2);
            for (int i = 0; i < m2; i++) {
                arrayList.add(new Locale((PlatformLocale) new AndroidLocale(m.get(i))));
            }
            LocaleList localeList2 = new LocaleList((List<Locale>) arrayList);
            this.lastPlatformLocaleList = m;
            this.lastLocaleList = localeList2;
            return localeList2;
        }
    }

    public PlatformLocale parseLanguageTag(String str) {
        return new AndroidLocale(Locale.forLanguageTag(str));
    }
}
