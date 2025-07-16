package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
public final class zzee extends zzf {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private final long zzg;
    private List<String> zzh;
    private int zzi;
    private String zzj;
    private String zzk;
    private String zzl;

    zzee(zzfu zzfu, long j) {
        super(zzfu);
        this.zzg = j;
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x018e A[Catch:{ IllegalStateException -> 0x0231 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0190 A[Catch:{ IllegalStateException -> 0x0231 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01a6 A[SYNTHETIC, Splitter:B:56:0x01a6] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01e6 A[Catch:{ IllegalStateException -> 0x0231 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0212 A[Catch:{ IllegalStateException -> 0x0231 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02a1  */
    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"appId", "appStore", "appName", "gmpAppId", "gaAppId"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzf() {
        /*
            r13 = this;
            com.google.android.gms.measurement.internal.zzfu r0 = r13.zzs
            android.content.Context r0 = r0.zzax()
            java.lang.String r0 = r0.getPackageName()
            com.google.android.gms.measurement.internal.zzfu r1 = r13.zzs
            android.content.Context r1 = r1.zzax()
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 0
            java.lang.String r4 = ""
            java.lang.String r5 = "unknown"
            java.lang.String r6 = "Unknown"
            if (r1 != 0) goto L_0x0035
            com.google.android.gms.measurement.internal.zzfu r7 = r13.zzs
            com.google.android.gms.measurement.internal.zzem r7 = r7.zzau()
            com.google.android.gms.measurement.internal.zzek r7 = r7.zzb()
            java.lang.String r8 = "PackageManager is null, app identity information might be inaccurate. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzem.zzl(r0)
            r7.zzb(r8, r9)
        L_0x0032:
            r8 = r6
            goto L_0x009b
        L_0x0035:
            java.lang.String r5 = r1.getInstallerPackageName(r0)     // Catch:{ IllegalArgumentException -> 0x003a }
            goto L_0x004d
        L_0x003a:
            com.google.android.gms.measurement.internal.zzfu r7 = r13.zzs
            com.google.android.gms.measurement.internal.zzem r7 = r7.zzau()
            com.google.android.gms.measurement.internal.zzek r7 = r7.zzb()
            java.lang.String r8 = "Error retrieving app installer package name. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzem.zzl(r0)
            r7.zzb(r8, r9)
        L_0x004d:
            if (r5 != 0) goto L_0x0052
            java.lang.String r5 = "manual_install"
            goto L_0x005b
        L_0x0052:
            java.lang.String r7 = "com.android.vending"
            boolean r7 = r7.equals(r5)
            if (r7 == 0) goto L_0x005b
            r5 = r4
        L_0x005b:
            com.google.android.gms.measurement.internal.zzfu r7 = r13.zzs     // Catch:{ NameNotFoundException -> 0x0085 }
            android.content.Context r7 = r7.zzax()     // Catch:{ NameNotFoundException -> 0x0085 }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ NameNotFoundException -> 0x0085 }
            android.content.pm.PackageInfo r7 = r1.getPackageInfo(r7, r3)     // Catch:{ NameNotFoundException -> 0x0085 }
            if (r7 == 0) goto L_0x0032
            android.content.pm.ApplicationInfo r8 = r7.applicationInfo     // Catch:{ NameNotFoundException -> 0x0085 }
            java.lang.CharSequence r8 = r1.getApplicationLabel(r8)     // Catch:{ NameNotFoundException -> 0x0085 }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ NameNotFoundException -> 0x0085 }
            if (r9 != 0) goto L_0x007c
            java.lang.String r8 = r8.toString()     // Catch:{ NameNotFoundException -> 0x0085 }
            goto L_0x007d
        L_0x007c:
            r8 = r6
        L_0x007d:
            java.lang.String r6 = r7.versionName     // Catch:{ NameNotFoundException -> 0x0082 }
            int r2 = r7.versionCode     // Catch:{ NameNotFoundException -> 0x0082 }
            goto L_0x009b
        L_0x0082:
            r7 = r6
            r6 = r8
            goto L_0x0086
        L_0x0085:
            r7 = r6
        L_0x0086:
            com.google.android.gms.measurement.internal.zzfu r8 = r13.zzs
            com.google.android.gms.measurement.internal.zzem r8 = r8.zzau()
            com.google.android.gms.measurement.internal.zzek r8 = r8.zzb()
            java.lang.String r9 = "Error retrieving package info. appId, appName"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzem.zzl(r0)
            r8.zzc(r9, r10, r6)
            r8 = r6
            r6 = r7
        L_0x009b:
            r13.zza = r0
            r13.zzd = r5
            r13.zzb = r6
            r13.zzc = r2
            r13.zze = r8
            r5 = 0
            r13.zzf = r5
            com.google.android.gms.measurement.internal.zzfu r2 = r13.zzs
            java.lang.String r2 = r2.zzr()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            r5 = 1
            if (r2 != 0) goto L_0x00c6
            com.google.android.gms.measurement.internal.zzfu r2 = r13.zzs
            java.lang.String r2 = r2.zzs()
            java.lang.String r6 = "am"
            boolean r2 = r6.equals(r2)
            if (r2 == 0) goto L_0x00c6
            r2 = r5
            goto L_0x00c7
        L_0x00c6:
            r2 = r3
        L_0x00c7:
            com.google.android.gms.measurement.internal.zzfu r6 = r13.zzs
            int r6 = r6.zzG()
            switch(r6) {
                case 0: goto L_0x0151;
                case 1: goto L_0x0141;
                case 2: goto L_0x0131;
                case 3: goto L_0x0121;
                case 4: goto L_0x0111;
                case 5: goto L_0x0101;
                case 6: goto L_0x00f1;
                case 7: goto L_0x00e1;
                default: goto L_0x00d0;
            }
        L_0x00d0:
            com.google.android.gms.measurement.internal.zzfu r7 = r13.zzs
            com.google.android.gms.measurement.internal.zzem r7 = r7.zzau()
            com.google.android.gms.measurement.internal.zzek r7 = r7.zzi()
            java.lang.String r8 = "App measurement disabled due to denied storage consent"
            r7.zza(r8)
            goto L_0x0160
        L_0x00e1:
            com.google.android.gms.measurement.internal.zzfu r7 = r13.zzs
            com.google.android.gms.measurement.internal.zzem r7 = r7.zzau()
            com.google.android.gms.measurement.internal.zzek r7 = r7.zzi()
            java.lang.String r8 = "App measurement disabled via the global data collection setting"
            r7.zza(r8)
            goto L_0x0160
        L_0x00f1:
            com.google.android.gms.measurement.internal.zzfu r7 = r13.zzs
            com.google.android.gms.measurement.internal.zzem r7 = r7.zzau()
            com.google.android.gms.measurement.internal.zzek r7 = r7.zzh()
            java.lang.String r8 = "App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics"
            r7.zza(r8)
            goto L_0x0160
        L_0x0101:
            com.google.android.gms.measurement.internal.zzfu r7 = r13.zzs
            com.google.android.gms.measurement.internal.zzem r7 = r7.zzau()
            com.google.android.gms.measurement.internal.zzek r7 = r7.zzk()
            java.lang.String r8 = "App measurement disabled via the init parameters"
            r7.zza(r8)
            goto L_0x0160
        L_0x0111:
            com.google.android.gms.measurement.internal.zzfu r7 = r13.zzs
            com.google.android.gms.measurement.internal.zzem r7 = r7.zzau()
            com.google.android.gms.measurement.internal.zzek r7 = r7.zzi()
            java.lang.String r8 = "App measurement disabled via the manifest"
            r7.zza(r8)
            goto L_0x0160
        L_0x0121:
            com.google.android.gms.measurement.internal.zzfu r7 = r13.zzs
            com.google.android.gms.measurement.internal.zzem r7 = r7.zzau()
            com.google.android.gms.measurement.internal.zzek r7 = r7.zzi()
            java.lang.String r8 = "App measurement disabled by setAnalyticsCollectionEnabled(false)"
            r7.zza(r8)
            goto L_0x0160
        L_0x0131:
            com.google.android.gms.measurement.internal.zzfu r7 = r13.zzs
            com.google.android.gms.measurement.internal.zzem r7 = r7.zzau()
            com.google.android.gms.measurement.internal.zzek r7 = r7.zzk()
            java.lang.String r8 = "App measurement deactivated via the init parameters"
            r7.zza(r8)
            goto L_0x0160
        L_0x0141:
            com.google.android.gms.measurement.internal.zzfu r7 = r13.zzs
            com.google.android.gms.measurement.internal.zzem r7 = r7.zzau()
            com.google.android.gms.measurement.internal.zzek r7 = r7.zzi()
            java.lang.String r8 = "App measurement deactivated via the manifest"
            r7.zza(r8)
            goto L_0x0160
        L_0x0151:
            com.google.android.gms.measurement.internal.zzfu r7 = r13.zzs
            com.google.android.gms.measurement.internal.zzem r7 = r7.zzau()
            com.google.android.gms.measurement.internal.zzek r7 = r7.zzk()
            java.lang.String r8 = "App measurement collection enabled"
            r7.zza(r8)
        L_0x0160:
            r13.zzj = r4
            r13.zzk = r4
            r13.zzl = r4
            com.google.android.gms.measurement.internal.zzfu r7 = r13.zzs
            r7.zzat()
            if (r2 == 0) goto L_0x0175
            com.google.android.gms.measurement.internal.zzfu r2 = r13.zzs
            java.lang.String r2 = r2.zzr()
            r13.zzk = r2
        L_0x0175:
            r2 = 0
            com.google.android.gms.measurement.internal.zzfu r7 = r13.zzs     // Catch:{ IllegalStateException -> 0x0231 }
            android.content.Context r7 = r7.zzax()     // Catch:{ IllegalStateException -> 0x0231 }
            com.google.android.gms.measurement.internal.zzfu r8 = r13.zzs     // Catch:{ IllegalStateException -> 0x0231 }
            java.lang.String r8 = r8.zzv()     // Catch:{ IllegalStateException -> 0x0231 }
            java.lang.String r9 = "google_app_id"
            java.lang.String r7 = com.google.android.gms.measurement.internal.zzic.zza(r7, r9, r8)     // Catch:{ IllegalStateException -> 0x0231 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x0231 }
            if (r5 == r8) goto L_0x0190
            r8 = r7
            goto L_0x0191
        L_0x0190:
            r8 = r4
        L_0x0191:
            r13.zzj = r8     // Catch:{ IllegalStateException -> 0x0231 }
            com.google.android.gms.internal.measurement.zzov.zzb()     // Catch:{ IllegalStateException -> 0x0231 }
            com.google.android.gms.measurement.internal.zzfu r8 = r13.zzs     // Catch:{ IllegalStateException -> 0x0231 }
            com.google.android.gms.measurement.internal.zzae r8 = r8.zzc()     // Catch:{ IllegalStateException -> 0x0231 }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzea.zzag     // Catch:{ IllegalStateException -> 0x0231 }
            boolean r8 = r8.zzn(r2, r9)     // Catch:{ IllegalStateException -> 0x0231 }
            java.lang.String r9 = "admob_app_id"
            if (r8 == 0) goto L_0x01e6
            com.google.android.gms.measurement.internal.zzfu r8 = r13.zzs     // Catch:{ IllegalStateException -> 0x0231 }
            android.content.Context r8 = r8.zzax()     // Catch:{ IllegalStateException -> 0x0231 }
            com.google.android.gms.measurement.internal.zzfu r10 = r13.zzs     // Catch:{ IllegalStateException -> 0x0231 }
            java.lang.String r10 = r10.zzv()     // Catch:{ IllegalStateException -> 0x0231 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ IllegalStateException -> 0x0231 }
            android.content.res.Resources r11 = r8.getResources()     // Catch:{ IllegalStateException -> 0x0231 }
            boolean r12 = android.text.TextUtils.isEmpty(r10)     // Catch:{ IllegalStateException -> 0x0231 }
            if (r12 != 0) goto L_0x01c0
            goto L_0x01c4
        L_0x01c0:
            java.lang.String r10 = com.google.android.gms.measurement.internal.zzfm.zza(r8)     // Catch:{ IllegalStateException -> 0x0231 }
        L_0x01c4:
            java.lang.String r8 = "ga_app_id"
            java.lang.String r8 = com.google.android.gms.measurement.internal.zzfm.zzb(r8, r11, r10)     // Catch:{ IllegalStateException -> 0x0231 }
            boolean r12 = android.text.TextUtils.isEmpty(r8)     // Catch:{ IllegalStateException -> 0x0231 }
            if (r5 == r12) goto L_0x01d1
            r4 = r8
        L_0x01d1:
            r13.zzl = r4     // Catch:{ IllegalStateException -> 0x0231 }
            boolean r4 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x0231 }
            if (r4 == 0) goto L_0x01df
            boolean r4 = android.text.TextUtils.isEmpty(r8)     // Catch:{ IllegalStateException -> 0x0231 }
            if (r4 != 0) goto L_0x0210
        L_0x01df:
            java.lang.String r4 = com.google.android.gms.measurement.internal.zzfm.zzb(r9, r11, r10)     // Catch:{ IllegalStateException -> 0x0231 }
            r13.zzk = r4     // Catch:{ IllegalStateException -> 0x0231 }
            goto L_0x0210
        L_0x01e6:
            boolean r4 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x0231 }
            if (r4 != 0) goto L_0x0210
            com.google.android.gms.measurement.internal.zzfu r4 = r13.zzs     // Catch:{ IllegalStateException -> 0x0231 }
            android.content.Context r4 = r4.zzax()     // Catch:{ IllegalStateException -> 0x0231 }
            com.google.android.gms.measurement.internal.zzfu r5 = r13.zzs     // Catch:{ IllegalStateException -> 0x0231 }
            java.lang.String r5 = r5.zzv()     // Catch:{ IllegalStateException -> 0x0231 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ IllegalStateException -> 0x0231 }
            android.content.res.Resources r7 = r4.getResources()     // Catch:{ IllegalStateException -> 0x0231 }
            boolean r8 = android.text.TextUtils.isEmpty(r5)     // Catch:{ IllegalStateException -> 0x0231 }
            if (r8 != 0) goto L_0x0206
            goto L_0x020a
        L_0x0206:
            java.lang.String r5 = com.google.android.gms.measurement.internal.zzfm.zza(r4)     // Catch:{ IllegalStateException -> 0x0231 }
        L_0x020a:
            java.lang.String r4 = com.google.android.gms.measurement.internal.zzfm.zzb(r9, r7, r5)     // Catch:{ IllegalStateException -> 0x0231 }
            r13.zzk = r4     // Catch:{ IllegalStateException -> 0x0231 }
        L_0x0210:
            if (r6 != 0) goto L_0x0245
            com.google.android.gms.measurement.internal.zzfu r4 = r13.zzs     // Catch:{ IllegalStateException -> 0x0231 }
            com.google.android.gms.measurement.internal.zzem r4 = r4.zzau()     // Catch:{ IllegalStateException -> 0x0231 }
            com.google.android.gms.measurement.internal.zzek r4 = r4.zzk()     // Catch:{ IllegalStateException -> 0x0231 }
            java.lang.String r5 = "App measurement enabled for app package, google app id"
            java.lang.String r6 = r13.zza     // Catch:{ IllegalStateException -> 0x0231 }
            java.lang.String r7 = r13.zzj     // Catch:{ IllegalStateException -> 0x0231 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x0231 }
            if (r7 == 0) goto L_0x022b
            java.lang.String r7 = r13.zzk     // Catch:{ IllegalStateException -> 0x0231 }
            goto L_0x022d
        L_0x022b:
            java.lang.String r7 = r13.zzj     // Catch:{ IllegalStateException -> 0x0231 }
        L_0x022d:
            r4.zzc(r5, r6, r7)     // Catch:{ IllegalStateException -> 0x0231 }
            goto L_0x0245
        L_0x0231:
            r4 = move-exception
            com.google.android.gms.measurement.internal.zzfu r5 = r13.zzs
            com.google.android.gms.measurement.internal.zzem r5 = r5.zzau()
            com.google.android.gms.measurement.internal.zzek r5 = r5.zzb()
            java.lang.String r6 = "Fetching Google App Id failed with exception. appId"
            java.lang.Object r0 = com.google.android.gms.measurement.internal.zzem.zzl(r0)
            r5.zzc(r6, r0, r4)
        L_0x0245:
            r13.zzh = r2
            com.google.android.gms.measurement.internal.zzfu r0 = r13.zzs
            r0.zzat()
            com.google.android.gms.measurement.internal.zzfu r0 = r13.zzs
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc()
            java.lang.String r2 = "analytics.safelisted_events"
            java.util.List r0 = r0.zzq(r2)
            if (r0 != 0) goto L_0x025b
            goto L_0x0290
        L_0x025b:
            int r2 = r0.size()
            if (r2 != 0) goto L_0x0271
            com.google.android.gms.measurement.internal.zzfu r0 = r13.zzs
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzh()
            java.lang.String r2 = "Safelisted event list is empty. Ignoring"
            r0.zza(r2)
            goto L_0x0292
        L_0x0271:
            java.util.Iterator r2 = r0.iterator()
        L_0x0275:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0290
            java.lang.Object r4 = r2.next()
            java.lang.String r4 = (java.lang.String) r4
            com.google.android.gms.measurement.internal.zzfu r5 = r13.zzs
            com.google.android.gms.measurement.internal.zzku r5 = r5.zzl()
            java.lang.String r6 = "safelisted event"
            boolean r4 = r5.zzk(r6, r4)
            if (r4 != 0) goto L_0x0275
            goto L_0x0292
        L_0x0290:
            r13.zzh = r0
        L_0x0292:
            if (r1 == 0) goto L_0x02a1
            com.google.android.gms.measurement.internal.zzfu r0 = r13.zzs
            android.content.Context r0 = r0.zzax()
            boolean r0 = com.google.android.gms.common.wrappers.InstantApps.isInstantApp(r0)
            r13.zzi = r0
            return
        L_0x02a1:
            r13.zzi = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzee.zzf():void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0207  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzp zzh(java.lang.String r35) {
        /*
            r34 = this;
            r1 = r34
            r34.zzg()
            com.google.android.gms.measurement.internal.zzp r31 = new com.google.android.gms.measurement.internal.zzp
            java.lang.String r3 = r34.zzi()
            java.lang.String r4 = r34.zzj()
            r34.zzb()
            java.lang.String r5 = r1.zzb
            r34.zzb()
            int r0 = r1.zzc
            long r6 = (long) r0
            r34.zzb()
            java.lang.String r0 = r1.zzd
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            java.lang.String r8 = r1.zzd
            com.google.android.gms.measurement.internal.zzfu r0 = r1.zzs
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc()
            r0.zzf()
            r34.zzb()
            r34.zzg()
            long r9 = r1.zzf
            r11 = 0
            int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            r2 = 0
            if (r0 != 0) goto L_0x00d4
            com.google.android.gms.measurement.internal.zzfu r0 = r1.zzs
            com.google.android.gms.measurement.internal.zzku r9 = r0.zzl()
            com.google.android.gms.measurement.internal.zzfu r0 = r1.zzs
            android.content.Context r0 = r0.zzax()
            com.google.android.gms.measurement.internal.zzfu r10 = r1.zzs
            android.content.Context r10 = r10.zzax()
            java.lang.String r10 = r10.getPackageName()
            r9.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            android.content.pm.PackageManager r13 = r0.getPackageManager()
            java.security.MessageDigest r14 = com.google.android.gms.measurement.internal.zzku.zzN()
            r15 = -1
            if (r14 != 0) goto L_0x0078
            com.google.android.gms.measurement.internal.zzfu r0 = r9.zzs
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzb()
            java.lang.String r9 = "Could not get MD5 instance"
            r0.zza(r9)
        L_0x0076:
            r9 = r15
            goto L_0x00d2
        L_0x0078:
            if (r13 == 0) goto L_0x00d1
            boolean r10 = r9.zzW(r0, r10)     // Catch:{ NameNotFoundException -> 0x00c1 }
            if (r10 != 0) goto L_0x00bf
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x00c1 }
            com.google.android.gms.measurement.internal.zzfu r10 = r9.zzs     // Catch:{ NameNotFoundException -> 0x00c1 }
            android.content.Context r10 = r10.zzax()     // Catch:{ NameNotFoundException -> 0x00c1 }
            java.lang.String r10 = r10.getPackageName()     // Catch:{ NameNotFoundException -> 0x00c1 }
            r13 = 64
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r10, r13)     // Catch:{ NameNotFoundException -> 0x00c1 }
            android.content.pm.Signature[] r10 = r0.signatures     // Catch:{ NameNotFoundException -> 0x00c1 }
            if (r10 == 0) goto L_0x00af
            android.content.pm.Signature[] r10 = r0.signatures     // Catch:{ NameNotFoundException -> 0x00c1 }
            int r10 = r10.length     // Catch:{ NameNotFoundException -> 0x00c1 }
            if (r10 <= 0) goto L_0x00af
            android.content.pm.Signature[] r0 = r0.signatures     // Catch:{ NameNotFoundException -> 0x00c1 }
            r0 = r0[r2]     // Catch:{ NameNotFoundException -> 0x00c1 }
            byte[] r0 = r0.toByteArray()     // Catch:{ NameNotFoundException -> 0x00c1 }
            byte[] r0 = r14.digest(r0)     // Catch:{ NameNotFoundException -> 0x00c1 }
            long r9 = com.google.android.gms.measurement.internal.zzku.zzO(r0)     // Catch:{ NameNotFoundException -> 0x00c1 }
            r15 = r9
            goto L_0x0076
        L_0x00af:
            com.google.android.gms.measurement.internal.zzfu r0 = r9.zzs     // Catch:{ NameNotFoundException -> 0x00c1 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ NameNotFoundException -> 0x00c1 }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zze()     // Catch:{ NameNotFoundException -> 0x00c1 }
            java.lang.String r10 = "Could not get signatures"
            r0.zza(r10)     // Catch:{ NameNotFoundException -> 0x00c1 }
            goto L_0x0076
        L_0x00bf:
            r15 = r11
            goto L_0x0076
        L_0x00c1:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfu r9 = r9.zzs
            com.google.android.gms.measurement.internal.zzem r9 = r9.zzau()
            com.google.android.gms.measurement.internal.zzek r9 = r9.zzb()
            java.lang.String r10 = "Package name not found"
            r9.zzb(r10, r0)
        L_0x00d1:
            r9 = r11
        L_0x00d2:
            r1.zzf = r9
        L_0x00d4:
            r13 = r9
            com.google.android.gms.measurement.internal.zzfu r0 = r1.zzs
            boolean r0 = r0.zzF()
            com.google.android.gms.measurement.internal.zzfu r9 = r1.zzs
            com.google.android.gms.measurement.internal.zzfb r9 = r9.zzd()
            boolean r9 = r9.zzk
            r10 = 1
            r15 = r9 ^ 1
            r34.zzg()
            com.google.android.gms.measurement.internal.zzfu r9 = r1.zzs
            boolean r9 = r9.zzF()
            r11 = 0
            if (r9 != 0) goto L_0x00f8
        L_0x00f2:
            r20 = r11
            r19 = r15
            goto L_0x0183
        L_0x00f8:
            com.google.android.gms.internal.measurement.zzqi.zzb()
            com.google.android.gms.measurement.internal.zzfu r9 = r1.zzs
            com.google.android.gms.measurement.internal.zzae r9 = r9.zzc()
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzea.zzai
            boolean r9 = r9.zzn(r11, r12)
            if (r9 == 0) goto L_0x0119
            com.google.android.gms.measurement.internal.zzfu r9 = r1.zzs
            com.google.android.gms.measurement.internal.zzem r9 = r9.zzau()
            com.google.android.gms.measurement.internal.zzek r9 = r9.zzk()
            java.lang.String r12 = "Disabled IID for tests."
            r9.zza(r12)
            goto L_0x00f2
        L_0x0119:
            com.google.android.gms.measurement.internal.zzfu r9 = r1.zzs     // Catch:{ ClassNotFoundException -> 0x017f }
            android.content.Context r9 = r9.zzax()     // Catch:{ ClassNotFoundException -> 0x017f }
            java.lang.ClassLoader r9 = r9.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x017f }
            java.lang.String r12 = "com.google.firebase.analytics.FirebaseAnalytics"
            java.lang.Class r9 = r9.loadClass(r12)     // Catch:{ ClassNotFoundException -> 0x017f }
            if (r9 != 0) goto L_0x012c
            goto L_0x00f2
        L_0x012c:
            java.lang.Class[] r12 = new java.lang.Class[r10]     // Catch:{ Exception -> 0x016d }
            java.lang.Class<android.content.Context> r18 = android.content.Context.class
            r12[r2] = r18     // Catch:{ Exception -> 0x016d }
            java.lang.String r11 = "getInstance"
            java.lang.reflect.Method r11 = r9.getDeclaredMethod(r11, r12)     // Catch:{ Exception -> 0x016d }
            com.google.android.gms.measurement.internal.zzfu r12 = r1.zzs     // Catch:{ Exception -> 0x016d }
            android.content.Context r12 = r12.zzax()     // Catch:{ Exception -> 0x016d }
            r19 = r15
            java.lang.Object[] r15 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x016f }
            r15[r2] = r12     // Catch:{ Exception -> 0x016f }
            r12 = 0
            java.lang.Object r11 = r11.invoke(r12, r15)     // Catch:{ Exception -> 0x016f }
            if (r11 != 0) goto L_0x014e
            r20 = r12
            goto L_0x0183
        L_0x014e:
            java.lang.String r15 = "getFirebaseInstanceId"
            java.lang.reflect.Method r9 = r9.getDeclaredMethod(r15, r12)     // Catch:{ Exception -> 0x015d }
            java.lang.Object r9 = r9.invoke(r11, r12)     // Catch:{ Exception -> 0x015d }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x015d }
            r20 = r9
            goto L_0x0183
        L_0x015d:
            com.google.android.gms.measurement.internal.zzfu r9 = r1.zzs
            com.google.android.gms.measurement.internal.zzem r9 = r9.zzau()
            com.google.android.gms.measurement.internal.zzek r9 = r9.zzh()
            java.lang.String r11 = "Failed to retrieve Firebase Instance Id"
            r9.zza(r11)
            goto L_0x0181
        L_0x016d:
            r19 = r15
        L_0x016f:
            com.google.android.gms.measurement.internal.zzfu r9 = r1.zzs
            com.google.android.gms.measurement.internal.zzem r9 = r9.zzau()
            com.google.android.gms.measurement.internal.zzek r9 = r9.zzf()
            java.lang.String r11 = "Failed to obtain Firebase Analytics instance"
            r9.zza(r11)
            goto L_0x0181
        L_0x017f:
            r19 = r15
        L_0x0181:
            r20 = 0
        L_0x0183:
            com.google.android.gms.measurement.internal.zzfu r9 = r1.zzs
            com.google.android.gms.measurement.internal.zzfb r11 = r9.zzd()
            com.google.android.gms.measurement.internal.zzey r11 = r11.zzc
            long r11 = r11.zza()
            r15 = 0
            int r15 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r15 != 0) goto L_0x019b
            long r11 = r9.zzc
            r15 = r3
            r21 = r11
            goto L_0x01a4
        L_0x019b:
            r15 = r3
            long r2 = r9.zzc
            long r2 = java.lang.Math.min(r2, r11)
            r21 = r2
        L_0x01a4:
            r34.zzb()
            int r11 = r1.zzi
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzs
            com.google.android.gms.measurement.internal.zzae r2 = r2.zzc()
            boolean r23 = r2.zzs()
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzs
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzd()
            r2.zzg()
            android.content.SharedPreferences r2 = r2.zzd()
            java.lang.String r3 = "deferred_analytics_collection"
            r9 = 0
            boolean r24 = r2.getBoolean(r3, r9)
            r34.zzb()
            java.lang.String r12 = r1.zzk
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzs
            com.google.android.gms.measurement.internal.zzae r2 = r2.zzc()
            java.lang.String r3 = "google_analytics_default_allow_ad_personalization_signals"
            java.lang.Boolean r2 = r2.zzp(r3)
            if (r2 != 0) goto L_0x01dd
            r25 = 0
            goto L_0x01e8
        L_0x01dd:
            boolean r2 = r2.booleanValue()
            r2 = r2 ^ r10
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r25 = r2
        L_0x01e8:
            long r2 = r1.zzg
            java.util.List<java.lang.String> r9 = r1.zzh
            com.google.android.gms.internal.measurement.zzov.zzb()
            com.google.android.gms.measurement.internal.zzfu r10 = r1.zzs
            com.google.android.gms.measurement.internal.zzae r10 = r10.zzc()
            r26 = r2
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzea.zzag
            r3 = 0
            boolean r2 = r10.zzn(r3, r2)
            if (r2 == 0) goto L_0x0207
            java.lang.String r2 = r34.zzl()
            r29 = r2
            goto L_0x0209
        L_0x0207:
            r29 = r3
        L_0x0209:
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzs
            com.google.android.gms.measurement.internal.zzfb r2 = r2.zzd()
            com.google.android.gms.measurement.internal.zzaf r2 = r2.zzi()
            java.lang.String r30 = r2.zzd()
            r2 = 42004(0xa414, double:2.07527E-319)
            r28 = r9
            r9 = r2
            r17 = 0
            r2 = r31
            r3 = r15
            r32 = r11
            r33 = r12
            r11 = r13
            r13 = r35
            r14 = r0
            r15 = r19
            r16 = r20
            r19 = r21
            r21 = r32
            r22 = r23
            r23 = r24
            r24 = r33
            r2.<init>((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (long) r6, (java.lang.String) r8, (long) r9, (long) r11, (java.lang.String) r13, (boolean) r14, (boolean) r15, (java.lang.String) r16, (long) r17, (long) r19, (int) r21, (boolean) r22, (boolean) r23, (java.lang.String) r24, (java.lang.Boolean) r25, (long) r26, (java.util.List<java.lang.String>) r28, (java.lang.String) r29, (java.lang.String) r30)
            return r31
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzee.zzh(java.lang.String):com.google.android.gms.measurement.internal.zzp");
    }

    /* access modifiers changed from: package-private */
    public final String zzi() {
        zzb();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final String zzj() {
        zzb();
        Preconditions.checkNotNull(this.zzj);
        return this.zzj;
    }

    /* access modifiers changed from: package-private */
    public final String zzk() {
        zzb();
        return this.zzk;
    }

    /* access modifiers changed from: package-private */
    public final String zzl() {
        zzb();
        Preconditions.checkNotNull(this.zzl);
        return this.zzl;
    }

    /* access modifiers changed from: package-private */
    public final int zzm() {
        zzb();
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zzn() {
        zzb();
        return this.zzi;
    }

    /* access modifiers changed from: package-private */
    public final List<String> zzo() {
        return this.zzh;
    }
}
