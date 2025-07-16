package jp.co.sony.reonpocket.util;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005HÆ\u0003J/\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Ljp/co/sony/reonpocket/util/Configuration;", "", "app", "Ljp/co/sony/reonpocket/util/Configuration$App;", "localeDataMap", "", "", "Ljp/co/sony/reonpocket/util/Configuration$LocaleData;", "(Ljp/co/sony/reonpocket/util/Configuration$App;Ljava/util/Map;)V", "getApp", "()Ljp/co/sony/reonpocket/util/Configuration$App;", "getLocaleDataMap", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "App", "LocaleData", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RemoteConfigUtil.kt */
public final class Configuration {
    public static final int $stable = 8;
    private final App app;
    private final Map<String, LocaleData> localeDataMap;

    public Configuration() {
        this((App) null, (Map) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Configuration copy$default(Configuration configuration, App app2, Map<String, LocaleData> map, int i, Object obj) {
        if ((i & 1) != 0) {
            app2 = configuration.app;
        }
        if ((i & 2) != 0) {
            map = configuration.localeDataMap;
        }
        return configuration.copy(app2, map);
    }

    public final App component1() {
        return this.app;
    }

    public final Map<String, LocaleData> component2() {
        return this.localeDataMap;
    }

    public final Configuration copy(App app2, Map<String, LocaleData> map) {
        return new Configuration(app2, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Configuration)) {
            return false;
        }
        Configuration configuration = (Configuration) obj;
        return Intrinsics.areEqual((Object) this.app, (Object) configuration.app) && Intrinsics.areEqual((Object) this.localeDataMap, (Object) configuration.localeDataMap);
    }

    public int hashCode() {
        App app2 = this.app;
        int i = 0;
        int hashCode = (app2 == null ? 0 : app2.hashCode()) * 31;
        Map<String, LocaleData> map = this.localeDataMap;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        App app2 = this.app;
        Map<String, LocaleData> map = this.localeDataMap;
        return "Configuration(app=" + app2 + ", localeDataMap=" + map + ")";
    }

    public Configuration(App app2, Map<String, LocaleData> map) {
        this.app = app2;
        this.localeDataMap = map;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Configuration(App app2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : app2, (i & 2) != 0 ? null : map);
    }

    public final App getApp() {
        return this.app;
    }

    public final Map<String, LocaleData> getLocaleDataMap() {
        return this.localeDataMap;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Ljp/co/sony/reonpocket/util/Configuration$App;", "", "version", "", "(Ljava/lang/String;)V", "getVersion", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: RemoteConfigUtil.kt */
    public static final class App {
        public static final int $stable = 0;
        private final String version;

        public App() {
            this((String) null, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ App copy$default(App app, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = app.version;
            }
            return app.copy(str);
        }

        public final String component1() {
            return this.version;
        }

        public final App copy(String str) {
            return new App(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof App) && Intrinsics.areEqual((Object) this.version, (Object) ((App) obj).version);
        }

        public int hashCode() {
            String str = this.version;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            String str = this.version;
            return "App(version=" + str + ")";
        }

        public App(String str) {
            this.version = str;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ App(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        public final String getVersion() {
            return this.version;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001:\u0004#$%&BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u000bHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006'"}, d2 = {"Ljp/co/sony/reonpocket/util/Configuration$LocaleData;", "", "name", "", "facebook", "Ljp/co/sony/reonpocket/util/Configuration$LocaleData$Facebook;", "notification", "Ljp/co/sony/reonpocket/util/Configuration$LocaleData$Notification;", "eula", "Ljp/co/sony/reonpocket/util/Configuration$LocaleData$Eula;", "privacyPolicy", "Ljp/co/sony/reonpocket/util/Configuration$LocaleData$PrivacyPolicy;", "(Ljava/lang/String;Ljp/co/sony/reonpocket/util/Configuration$LocaleData$Facebook;Ljp/co/sony/reonpocket/util/Configuration$LocaleData$Notification;Ljp/co/sony/reonpocket/util/Configuration$LocaleData$Eula;Ljp/co/sony/reonpocket/util/Configuration$LocaleData$PrivacyPolicy;)V", "getEula", "()Ljp/co/sony/reonpocket/util/Configuration$LocaleData$Eula;", "getFacebook", "()Ljp/co/sony/reonpocket/util/Configuration$LocaleData$Facebook;", "getName", "()Ljava/lang/String;", "getNotification", "()Ljp/co/sony/reonpocket/util/Configuration$LocaleData$Notification;", "getPrivacyPolicy", "()Ljp/co/sony/reonpocket/util/Configuration$LocaleData$PrivacyPolicy;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Eula", "Facebook", "Notification", "PrivacyPolicy", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: RemoteConfigUtil.kt */
    public static final class LocaleData {
        public static final int $stable = 0;
        private final Eula eula;
        private final Facebook facebook;
        private final String name;
        private final Notification notification;
        private final PrivacyPolicy privacyPolicy;

        public LocaleData() {
            this((String) null, (Facebook) null, (Notification) null, (Eula) null, (PrivacyPolicy) null, 31, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ LocaleData copy$default(LocaleData localeData, String str, Facebook facebook2, Notification notification2, Eula eula2, PrivacyPolicy privacyPolicy2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = localeData.name;
            }
            if ((i & 2) != 0) {
                facebook2 = localeData.facebook;
            }
            Facebook facebook3 = facebook2;
            if ((i & 4) != 0) {
                notification2 = localeData.notification;
            }
            Notification notification3 = notification2;
            if ((i & 8) != 0) {
                eula2 = localeData.eula;
            }
            Eula eula3 = eula2;
            if ((i & 16) != 0) {
                privacyPolicy2 = localeData.privacyPolicy;
            }
            return localeData.copy(str, facebook3, notification3, eula3, privacyPolicy2);
        }

        public final String component1() {
            return this.name;
        }

        public final Facebook component2() {
            return this.facebook;
        }

        public final Notification component3() {
            return this.notification;
        }

        public final Eula component4() {
            return this.eula;
        }

        public final PrivacyPolicy component5() {
            return this.privacyPolicy;
        }

        public final LocaleData copy(String str, Facebook facebook2, Notification notification2, Eula eula2, PrivacyPolicy privacyPolicy2) {
            return new LocaleData(str, facebook2, notification2, eula2, privacyPolicy2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LocaleData)) {
                return false;
            }
            LocaleData localeData = (LocaleData) obj;
            return Intrinsics.areEqual((Object) this.name, (Object) localeData.name) && Intrinsics.areEqual((Object) this.facebook, (Object) localeData.facebook) && Intrinsics.areEqual((Object) this.notification, (Object) localeData.notification) && Intrinsics.areEqual((Object) this.eula, (Object) localeData.eula) && Intrinsics.areEqual((Object) this.privacyPolicy, (Object) localeData.privacyPolicy);
        }

        public int hashCode() {
            String str = this.name;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Facebook facebook2 = this.facebook;
            int hashCode2 = (hashCode + (facebook2 == null ? 0 : facebook2.hashCode())) * 31;
            Notification notification2 = this.notification;
            int hashCode3 = (hashCode2 + (notification2 == null ? 0 : notification2.hashCode())) * 31;
            Eula eula2 = this.eula;
            int hashCode4 = (hashCode3 + (eula2 == null ? 0 : eula2.hashCode())) * 31;
            PrivacyPolicy privacyPolicy2 = this.privacyPolicy;
            if (privacyPolicy2 != null) {
                i = privacyPolicy2.hashCode();
            }
            return hashCode4 + i;
        }

        public String toString() {
            String str = this.name;
            Facebook facebook2 = this.facebook;
            Notification notification2 = this.notification;
            Eula eula2 = this.eula;
            PrivacyPolicy privacyPolicy2 = this.privacyPolicy;
            return "LocaleData(name=" + str + ", facebook=" + facebook2 + ", notification=" + notification2 + ", eula=" + eula2 + ", privacyPolicy=" + privacyPolicy2 + ")";
        }

        public LocaleData(String str, Facebook facebook2, Notification notification2, Eula eula2, PrivacyPolicy privacyPolicy2) {
            this.name = str;
            this.facebook = facebook2;
            this.notification = notification2;
            this.eula = eula2;
            this.privacyPolicy = privacyPolicy2;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ LocaleData(java.lang.String r5, jp.co.sony.reonpocket.util.Configuration.LocaleData.Facebook r6, jp.co.sony.reonpocket.util.Configuration.LocaleData.Notification r7, jp.co.sony.reonpocket.util.Configuration.LocaleData.Eula r8, jp.co.sony.reonpocket.util.Configuration.LocaleData.PrivacyPolicy r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
            /*
                r4 = this;
                r11 = r10 & 1
                r0 = 0
                if (r11 == 0) goto L_0x0007
                r11 = r0
                goto L_0x0008
            L_0x0007:
                r11 = r5
            L_0x0008:
                r5 = r10 & 2
                if (r5 == 0) goto L_0x000e
                r1 = r0
                goto L_0x000f
            L_0x000e:
                r1 = r6
            L_0x000f:
                r5 = r10 & 4
                if (r5 == 0) goto L_0x0015
                r2 = r0
                goto L_0x0016
            L_0x0015:
                r2 = r7
            L_0x0016:
                r5 = r10 & 8
                if (r5 == 0) goto L_0x001c
                r3 = r0
                goto L_0x001d
            L_0x001c:
                r3 = r8
            L_0x001d:
                r5 = r10 & 16
                if (r5 == 0) goto L_0x0023
                r10 = r0
                goto L_0x0024
            L_0x0023:
                r10 = r9
            L_0x0024:
                r5 = r4
                r6 = r11
                r7 = r1
                r8 = r2
                r9 = r3
                r5.<init>(r6, r7, r8, r9, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.util.Configuration.LocaleData.<init>(java.lang.String, jp.co.sony.reonpocket.util.Configuration$LocaleData$Facebook, jp.co.sony.reonpocket.util.Configuration$LocaleData$Notification, jp.co.sony.reonpocket.util.Configuration$LocaleData$Eula, jp.co.sony.reonpocket.util.Configuration$LocaleData$PrivacyPolicy, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final String getName() {
            return this.name;
        }

        public final Facebook getFacebook() {
            return this.facebook;
        }

        public final Notification getNotification() {
            return this.notification;
        }

        public final Eula getEula() {
            return this.eula;
        }

        public final PrivacyPolicy getPrivacyPolicy() {
            return this.privacyPolicy;
        }

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Ljp/co/sony/reonpocket/util/Configuration$LocaleData$Facebook;", "", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* compiled from: RemoteConfigUtil.kt */
        public static final class Facebook {
            public static final int $stable = 0;
            private final String url;

            public Facebook() {
                this((String) null, 1, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ Facebook copy$default(Facebook facebook, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = facebook.url;
                }
                return facebook.copy(str);
            }

            public final String component1() {
                return this.url;
            }

            public final Facebook copy(String str) {
                return new Facebook(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Facebook) && Intrinsics.areEqual((Object) this.url, (Object) ((Facebook) obj).url);
            }

            public int hashCode() {
                String str = this.url;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                String str = this.url;
                return "Facebook(url=" + str + ")";
            }

            public Facebook(String str) {
                this.url = str;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Facebook(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }

            public final String getUrl() {
                return this.url;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jn\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016¨\u0006'"}, d2 = {"Ljp/co/sony/reonpocket/util/Configuration$LocaleData$Notification;", "", "version", "", "buttonPreference", "", "date", "title", "subtitle", "url", "description", "imagePath", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getButtonPreference", "()Ljava/lang/String;", "getDate", "getDescription", "getImagePath", "getSubtitle", "getTitle", "getUrl", "getVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljp/co/sony/reonpocket/util/Configuration$LocaleData$Notification;", "equals", "", "other", "hashCode", "toString", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* compiled from: RemoteConfigUtil.kt */
        public static final class Notification {
            public static final int $stable = 0;
            private final String buttonPreference;
            private final String date;
            private final String description;
            private final String imagePath;
            private final String subtitle;
            private final String title;
            private final String url;
            private final Integer version;

            public Notification() {
                this((Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 255, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ Notification copy$default(Notification notification, Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
                Notification notification2 = notification;
                int i2 = i;
                return notification.copy((i2 & 1) != 0 ? notification2.version : num, (i2 & 2) != 0 ? notification2.buttonPreference : str, (i2 & 4) != 0 ? notification2.date : str2, (i2 & 8) != 0 ? notification2.title : str3, (i2 & 16) != 0 ? notification2.subtitle : str4, (i2 & 32) != 0 ? notification2.url : str5, (i2 & 64) != 0 ? notification2.description : str6, (i2 & 128) != 0 ? notification2.imagePath : str7);
            }

            public final Integer component1() {
                return this.version;
            }

            public final String component2() {
                return this.buttonPreference;
            }

            public final String component3() {
                return this.date;
            }

            public final String component4() {
                return this.title;
            }

            public final String component5() {
                return this.subtitle;
            }

            public final String component6() {
                return this.url;
            }

            public final String component7() {
                return this.description;
            }

            public final String component8() {
                return this.imagePath;
            }

            public final Notification copy(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
                return new Notification(num, str, str2, str3, str4, str5, str6, str7);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Notification)) {
                    return false;
                }
                Notification notification = (Notification) obj;
                return Intrinsics.areEqual((Object) this.version, (Object) notification.version) && Intrinsics.areEqual((Object) this.buttonPreference, (Object) notification.buttonPreference) && Intrinsics.areEqual((Object) this.date, (Object) notification.date) && Intrinsics.areEqual((Object) this.title, (Object) notification.title) && Intrinsics.areEqual((Object) this.subtitle, (Object) notification.subtitle) && Intrinsics.areEqual((Object) this.url, (Object) notification.url) && Intrinsics.areEqual((Object) this.description, (Object) notification.description) && Intrinsics.areEqual((Object) this.imagePath, (Object) notification.imagePath);
            }

            public int hashCode() {
                Integer num = this.version;
                int i = 0;
                int hashCode = (num == null ? 0 : num.hashCode()) * 31;
                String str = this.buttonPreference;
                int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.date;
                int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.title;
                int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.subtitle;
                int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
                String str5 = this.url;
                int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
                String str6 = this.description;
                int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
                String str7 = this.imagePath;
                if (str7 != null) {
                    i = str7.hashCode();
                }
                return hashCode7 + i;
            }

            public String toString() {
                Integer num = this.version;
                String str = this.buttonPreference;
                String str2 = this.date;
                String str3 = this.title;
                String str4 = this.subtitle;
                String str5 = this.url;
                String str6 = this.description;
                String str7 = this.imagePath;
                return "Notification(version=" + num + ", buttonPreference=" + str + ", date=" + str2 + ", title=" + str3 + ", subtitle=" + str4 + ", url=" + str5 + ", description=" + str6 + ", imagePath=" + str7 + ")";
            }

            public Notification(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
                this.version = num;
                this.buttonPreference = str;
                this.date = str2;
                this.title = str3;
                this.subtitle = str4;
                this.url = str5;
                this.description = str6;
                this.imagePath = str7;
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public /* synthetic */ Notification(java.lang.Integer r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
                /*
                    r9 = this;
                    r0 = r18
                    r1 = r0 & 1
                    r2 = 0
                    if (r1 == 0) goto L_0x0009
                    r1 = r2
                    goto L_0x000a
                L_0x0009:
                    r1 = r10
                L_0x000a:
                    r3 = r0 & 2
                    if (r3 == 0) goto L_0x0010
                    r3 = r2
                    goto L_0x0011
                L_0x0010:
                    r3 = r11
                L_0x0011:
                    r4 = r0 & 4
                    if (r4 == 0) goto L_0x0017
                    r4 = r2
                    goto L_0x0018
                L_0x0017:
                    r4 = r12
                L_0x0018:
                    r5 = r0 & 8
                    if (r5 == 0) goto L_0x001e
                    r5 = r2
                    goto L_0x001f
                L_0x001e:
                    r5 = r13
                L_0x001f:
                    r6 = r0 & 16
                    if (r6 == 0) goto L_0x0025
                    r6 = r2
                    goto L_0x0026
                L_0x0025:
                    r6 = r14
                L_0x0026:
                    r7 = r0 & 32
                    if (r7 == 0) goto L_0x002c
                    r7 = r2
                    goto L_0x002d
                L_0x002c:
                    r7 = r15
                L_0x002d:
                    r8 = r0 & 64
                    if (r8 == 0) goto L_0x0033
                    r8 = r2
                    goto L_0x0035
                L_0x0033:
                    r8 = r16
                L_0x0035:
                    r0 = r0 & 128(0x80, float:1.794E-43)
                    if (r0 == 0) goto L_0x003a
                    goto L_0x003c
                L_0x003a:
                    r2 = r17
                L_0x003c:
                    r10 = r9
                    r11 = r1
                    r12 = r3
                    r13 = r4
                    r14 = r5
                    r15 = r6
                    r16 = r7
                    r17 = r8
                    r18 = r2
                    r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.util.Configuration.LocaleData.Notification.<init>(java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
            }

            public final Integer getVersion() {
                return this.version;
            }

            public final String getButtonPreference() {
                return this.buttonPreference;
            }

            public final String getDate() {
                return this.date;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getSubtitle() {
                return this.subtitle;
            }

            public final String getUrl() {
                return this.url;
            }

            public final String getDescription() {
                return this.description;
            }

            public final String getImagePath() {
                return this.imagePath;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Ljp/co/sony/reonpocket/util/Configuration$LocaleData$Eula;", "", "version", "", "date", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "getVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Ljp/co/sony/reonpocket/util/Configuration$LocaleData$Eula;", "equals", "", "other", "hashCode", "toString", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* compiled from: RemoteConfigUtil.kt */
        public static final class Eula {
            public static final int $stable = 0;
            private final String date;
            private final Integer version;

            public Eula() {
                this((Integer) null, (String) null, 3, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ Eula copy$default(Eula eula, Integer num, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    num = eula.version;
                }
                if ((i & 2) != 0) {
                    str = eula.date;
                }
                return eula.copy(num, str);
            }

            public final Integer component1() {
                return this.version;
            }

            public final String component2() {
                return this.date;
            }

            public final Eula copy(Integer num, String str) {
                return new Eula(num, str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Eula)) {
                    return false;
                }
                Eula eula = (Eula) obj;
                return Intrinsics.areEqual((Object) this.version, (Object) eula.version) && Intrinsics.areEqual((Object) this.date, (Object) eula.date);
            }

            public int hashCode() {
                Integer num = this.version;
                int i = 0;
                int hashCode = (num == null ? 0 : num.hashCode()) * 31;
                String str = this.date;
                if (str != null) {
                    i = str.hashCode();
                }
                return hashCode + i;
            }

            public String toString() {
                Integer num = this.version;
                String str = this.date;
                return "Eula(version=" + num + ", date=" + str + ")";
            }

            public Eula(Integer num, String str) {
                this.version = num;
                this.date = str;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Eula(Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str);
            }

            public final Integer getVersion() {
                return this.version;
            }

            public final String getDate() {
                return this.date;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Ljp/co/sony/reonpocket/util/Configuration$LocaleData$PrivacyPolicy;", "", "version", "", "date", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "getVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Ljp/co/sony/reonpocket/util/Configuration$LocaleData$PrivacyPolicy;", "equals", "", "other", "hashCode", "toString", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* compiled from: RemoteConfigUtil.kt */
        public static final class PrivacyPolicy {
            public static final int $stable = 0;
            private final String date;
            private final Integer version;

            public PrivacyPolicy() {
                this((Integer) null, (String) null, 3, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ PrivacyPolicy copy$default(PrivacyPolicy privacyPolicy, Integer num, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    num = privacyPolicy.version;
                }
                if ((i & 2) != 0) {
                    str = privacyPolicy.date;
                }
                return privacyPolicy.copy(num, str);
            }

            public final Integer component1() {
                return this.version;
            }

            public final String component2() {
                return this.date;
            }

            public final PrivacyPolicy copy(Integer num, String str) {
                return new PrivacyPolicy(num, str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof PrivacyPolicy)) {
                    return false;
                }
                PrivacyPolicy privacyPolicy = (PrivacyPolicy) obj;
                return Intrinsics.areEqual((Object) this.version, (Object) privacyPolicy.version) && Intrinsics.areEqual((Object) this.date, (Object) privacyPolicy.date);
            }

            public int hashCode() {
                Integer num = this.version;
                int i = 0;
                int hashCode = (num == null ? 0 : num.hashCode()) * 31;
                String str = this.date;
                if (str != null) {
                    i = str.hashCode();
                }
                return hashCode + i;
            }

            public String toString() {
                Integer num = this.version;
                String str = this.date;
                return "PrivacyPolicy(version=" + num + ", date=" + str + ")";
            }

            public PrivacyPolicy(Integer num, String str) {
                this.version = num;
                this.date = str;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ PrivacyPolicy(Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str);
            }

            public final Integer getVersion() {
                return this.version;
            }

            public final String getDate() {
                return this.date;
            }
        }
    }
}
