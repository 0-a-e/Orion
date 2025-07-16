package androidx.core.os;

import android.os.LocaleList;
import androidx.core.app.NotificationCompat$$ExternalSyntheticApiModelOutline0;
import androidx.core.graphics.ColorKt$$ExternalSyntheticApiModelOutline0;
import java.util.Locale;

final class LocaleListPlatformWrapper implements LocaleListInterface {
    private final LocaleList mLocaleList;

    LocaleListPlatformWrapper(Object obj) {
        this.mLocaleList = ColorKt$$ExternalSyntheticApiModelOutline0.m(obj);
    }

    public Object getLocaleList() {
        return this.mLocaleList;
    }

    public Locale get(int i) {
        return this.mLocaleList.get(i);
    }

    public boolean isEmpty() {
        return ColorKt$$ExternalSyntheticApiModelOutline0.m(this.mLocaleList);
    }

    public int size() {
        return NotificationCompat$$ExternalSyntheticApiModelOutline0.m(this.mLocaleList);
    }

    public int indexOf(Locale locale) {
        return this.mLocaleList.indexOf(locale);
    }

    public boolean equals(Object obj) {
        return this.mLocaleList.equals(((LocaleListInterface) obj).getLocaleList());
    }

    public int hashCode() {
        return ColorKt$$ExternalSyntheticApiModelOutline0.m(this.mLocaleList);
    }

    public String toString() {
        return this.mLocaleList.toString();
    }

    public String toLanguageTags() {
        return ColorKt$$ExternalSyntheticApiModelOutline0.m(this.mLocaleList);
    }

    public Locale getFirstMatch(String[] strArr) {
        return this.mLocaleList.getFirstMatch(strArr);
    }
}
