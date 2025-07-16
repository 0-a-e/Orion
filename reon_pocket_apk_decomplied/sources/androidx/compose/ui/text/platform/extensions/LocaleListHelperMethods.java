package androidx.compose.ui.text.platform.extensions;

import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.core.app.NotificationCompat$$ExternalSyntheticApiModelOutline0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0007J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\n"}, d2 = {"Landroidx/compose/ui/text/platform/extensions/LocaleListHelperMethods;", "", "()V", "localeSpan", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "setTextLocales", "", "textPaint", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LocaleExtensions.android.kt */
public final class LocaleListHelperMethods {
    public static final int $stable = 0;
    public static final LocaleListHelperMethods INSTANCE = new LocaleListHelperMethods();

    private LocaleListHelperMethods() {
    }

    public final Object localeSpan(LocaleList localeList) {
        Iterable<Locale> iterable = localeList;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Locale javaLocale : iterable) {
            arrayList.add(LocaleExtensions_androidKt.toJavaLocale(javaLocale));
        }
        java.util.Locale[] localeArr = (java.util.Locale[]) ((List) arrayList).toArray(new java.util.Locale[0]);
        return NotificationCompat$$ExternalSyntheticApiModelOutline0.m(NotificationCompat$$ExternalSyntheticApiModelOutline0.m((java.util.Locale[]) Arrays.copyOf(localeArr, localeArr.length)));
    }

    public final void setTextLocales(AndroidTextPaint androidTextPaint, LocaleList localeList) {
        Iterable<Locale> iterable = localeList;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Locale javaLocale : iterable) {
            arrayList.add(LocaleExtensions_androidKt.toJavaLocale(javaLocale));
        }
        java.util.Locale[] localeArr = (java.util.Locale[]) ((List) arrayList).toArray(new java.util.Locale[0]);
        androidTextPaint.setTextLocales(NotificationCompat$$ExternalSyntheticApiModelOutline0.m((java.util.Locale[]) Arrays.copyOf(localeArr, localeArr.length)));
    }
}
