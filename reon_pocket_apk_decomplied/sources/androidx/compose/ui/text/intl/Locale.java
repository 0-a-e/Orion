package androidx.compose.ui.text.intl;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0006\u0010\u0016\u001a\u00020\u0003J\b\u0010\u0017\u001a\u00020\u0003H\u0016R\u0011\u0010\b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0011\u0010\u000f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\n¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/text/intl/Locale;", "", "languageTag", "", "(Ljava/lang/String;)V", "platformLocale", "Landroidx/compose/ui/text/intl/PlatformLocale;", "(Landroidx/compose/ui/text/intl/PlatformLocale;)V", "language", "getLanguage", "()Ljava/lang/String;", "getPlatformLocale$ui_text_release", "()Landroidx/compose/ui/text/intl/PlatformLocale;", "region", "getRegion", "script", "getScript", "equals", "", "other", "hashCode", "", "toLanguageTag", "toString", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Locale.kt */
public final class Locale {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final PlatformLocale platformLocale;

    public Locale(PlatformLocale platformLocale2) {
        this.platformLocale = platformLocale2;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/intl/Locale$Companion;", "", "()V", "current", "Landroidx/compose/ui/text/intl/Locale;", "getCurrent", "()Landroidx/compose/ui/text/intl/Locale;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Locale.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Locale getCurrent() {
            return PlatformLocaleKt.getPlatformLocaleDelegate().getCurrent().get(0);
        }
    }

    public final PlatformLocale getPlatformLocale$ui_text_release() {
        return this.platformLocale;
    }

    public Locale(String str) {
        this(PlatformLocaleKt.getPlatformLocaleDelegate().parseLanguageTag(str));
    }

    public final String getLanguage() {
        return this.platformLocale.getLanguage();
    }

    public final String getScript() {
        return this.platformLocale.getScript();
    }

    public final String getRegion() {
        return this.platformLocale.getRegion();
    }

    public final String toLanguageTag() {
        return this.platformLocale.toLanguageTag();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Locale)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return Intrinsics.areEqual((Object) toLanguageTag(), (Object) ((Locale) obj).toLanguageTag());
    }

    public int hashCode() {
        return toLanguageTag().hashCode();
    }

    public String toString() {
        return toLanguageTag();
    }
}
