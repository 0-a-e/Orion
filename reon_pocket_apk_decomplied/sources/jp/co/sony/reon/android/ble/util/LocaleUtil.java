package jp.co.sony.reon.android.ble.util;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Ljp/co/sony/reon/android/ble/util/LocaleUtil;", "", "()V", "isSupportLog", "", "LocaleType", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocaleUtil.kt */
public final class LocaleUtil {
    public static final LocaleUtil INSTANCE = new LocaleUtil();

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: LocaleUtil.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(2:17|18)|19|21) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|21) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                jp.co.sony.reon.android.ble.util.LocaleUtil$LocaleType[] r0 = jp.co.sony.reon.android.ble.util.LocaleUtil.LocaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reon.android.ble.util.LocaleUtil$LocaleType r1 = jp.co.sony.reon.android.ble.util.LocaleUtil.LocaleType.JP     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                jp.co.sony.reon.android.ble.util.LocaleUtil$LocaleType r1 = jp.co.sony.reon.android.ble.util.LocaleUtil.LocaleType.HK_EN     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                jp.co.sony.reon.android.ble.util.LocaleUtil$LocaleType r1 = jp.co.sony.reon.android.ble.util.LocaleUtil.LocaleType.HK_ZH     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                jp.co.sony.reon.android.ble.util.LocaleUtil$LocaleType r1 = jp.co.sony.reon.android.ble.util.LocaleUtil.LocaleType.GB     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                jp.co.sony.reon.android.ble.util.LocaleUtil$LocaleType r1 = jp.co.sony.reon.android.ble.util.LocaleUtil.LocaleType.SG     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                jp.co.sony.reon.android.ble.util.LocaleUtil$LocaleType r1 = jp.co.sony.reon.android.ble.util.LocaleUtil.LocaleType.MY     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                jp.co.sony.reon.android.ble.util.LocaleUtil$LocaleType r1 = jp.co.sony.reon.android.ble.util.LocaleUtil.LocaleType.TH     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                jp.co.sony.reon.android.ble.util.LocaleUtil$LocaleType r1 = jp.co.sony.reon.android.ble.util.LocaleUtil.LocaleType.VN     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                jp.co.sony.reon.android.ble.util.LocaleUtil$LocaleType r1 = jp.co.sony.reon.android.ble.util.LocaleUtil.LocaleType.OTHER     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reon.android.ble.util.LocaleUtil.WhenMappings.<clinit>():void");
        }
    }

    private LocaleUtil() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0003\f\r\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000f"}, d2 = {"Ljp/co/sony/reon/android/ble/util/LocaleUtil$LocaleType;", "", "(Ljava/lang/String;I)V", "JP", "HK_EN", "HK_ZH", "GB", "SG", "MY", "TH", "VN", "OTHER", "Companion", "LocaleCountryCode", "LocaleLanguageCode", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: LocaleUtil.kt */
    public enum LocaleType {
        JP,
        HK_EN,
        HK_ZH,
        GB,
        SG,
        MY,
        TH,
        VN,
        OTHER;
        
        public static final Companion Companion = null;

        public static EnumEntries<LocaleType> getEntries() {
            return $ENTRIES;
        }

        static {
            LocaleType[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reon/android/ble/util/LocaleUtil$LocaleType$Companion;", "", "()V", "getDefault", "Ljp/co/sony/reon/android/ble/util/LocaleUtil$LocaleType;", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* compiled from: LocaleUtil.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final LocaleType getDefault() {
                Locale locale = Locale.getDefault();
                String language = locale.getLanguage();
                Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
                String country = locale.getCountry();
                Intrinsics.checkNotNullExpressionValue(country, "getCountry(...)");
                if (Intrinsics.areEqual((Object) language, (Object) LocaleLanguageCode.JAPANESE.getCode())) {
                    return LocaleType.JP;
                }
                if (Intrinsics.areEqual((Object) language, (Object) LocaleLanguageCode.ENGLISH.getCode()) && Intrinsics.areEqual((Object) country, (Object) LocaleCountryCode.HONGKONG.getCode())) {
                    return LocaleType.HK_EN;
                }
                if (Intrinsics.areEqual((Object) language, (Object) LocaleLanguageCode.CHINESE.getCode()) && Intrinsics.areEqual((Object) country, (Object) LocaleCountryCode.HONGKONG.getCode())) {
                    return LocaleType.HK_ZH;
                }
                if (Intrinsics.areEqual((Object) language, (Object) LocaleLanguageCode.ENGLISH.getCode()) && Intrinsics.areEqual((Object) country, (Object) LocaleCountryCode.GB.getCode())) {
                    return LocaleType.GB;
                }
                if (Intrinsics.areEqual((Object) country, (Object) LocaleCountryCode.SINGAPORE.getCode())) {
                    return LocaleType.SG;
                }
                if (Intrinsics.areEqual((Object) country, (Object) LocaleCountryCode.MALAYSIA.getCode())) {
                    return LocaleType.MY;
                }
                if (Intrinsics.areEqual((Object) country, (Object) LocaleCountryCode.THAILAND.getCode())) {
                    return LocaleType.TH;
                }
                if (Intrinsics.areEqual((Object) country, (Object) LocaleCountryCode.VIETNAM.getCode())) {
                    return LocaleType.VN;
                }
                return LocaleType.OTHER;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Ljp/co/sony/reon/android/ble/util/LocaleUtil$LocaleType$LocaleLanguageCode;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "JAPANESE", "CHINESE", "ENGLISH", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* compiled from: LocaleUtil.kt */
        public enum LocaleLanguageCode {
            JAPANESE("ja"),
            CHINESE("zh"),
            ENGLISH("en");
            
            private final String code;

            public static EnumEntries<LocaleLanguageCode> getEntries() {
                return $ENTRIES;
            }

            private LocaleLanguageCode(String str) {
                this.code = str;
            }

            public final String getCode() {
                return this.code;
            }

            static {
                LocaleLanguageCode[] $values;
                $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Ljp/co/sony/reon/android/ble/util/LocaleUtil$LocaleType$LocaleCountryCode;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "HONGKONG", "GB", "SINGAPORE", "MALAYSIA", "THAILAND", "VIETNAM", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* compiled from: LocaleUtil.kt */
        public enum LocaleCountryCode {
            HONGKONG("HK"),
            GB("GB"),
            SINGAPORE("SG"),
            MALAYSIA("MY"),
            THAILAND("TH"),
            VIETNAM("VN");
            
            private final String code;

            public static EnumEntries<LocaleCountryCode> getEntries() {
                return $ENTRIES;
            }

            private LocaleCountryCode(String str) {
                this.code = str;
            }

            public final String getCode() {
                return this.code;
            }

            static {
                LocaleCountryCode[] $values;
                $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
            }
        }
    }

    public final boolean isSupportLog() {
        switch (WhenMappings.$EnumSwitchMapping$0[LocaleType.Companion.getDefault().ordinal()]) {
            case 1:
            case 2:
            case 3:
                return true;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
