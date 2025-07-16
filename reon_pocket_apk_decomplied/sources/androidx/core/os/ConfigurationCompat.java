package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;

public final class ConfigurationCompat {
    private ConfigurationCompat() {
    }

    public static LocaleListCompat getLocales(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            return LocaleListCompat.wrap(Api24Impl.getLocales(configuration));
        }
        return LocaleListCompat.create(configuration.locale);
    }

    public static void setLocales(Configuration configuration, LocaleListCompat localeListCompat) {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.setLocales(configuration, localeListCompat);
        } else if (!localeListCompat.isEmpty()) {
            configuration.setLocale(localeListCompat.get(0));
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static LocaleList getLocales(Configuration configuration) {
            return configuration.getLocales();
        }

        static void setLocales(Configuration configuration, LocaleListCompat localeListCompat) {
            configuration.setLocales((LocaleList) localeListCompat.unwrap());
        }
    }
}
