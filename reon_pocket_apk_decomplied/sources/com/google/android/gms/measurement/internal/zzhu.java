package com.google.android.gms.measurement.internal;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
final class zzhu implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ Uri zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzhv zze;

    zzhu(zzhv zzhv, boolean z, Uri uri, String str, String str2) {
        this.zze = zzhv;
        this.zza = z;
        this.zzb = uri;
        this.zzc = str;
        this.zzd = str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004c, code lost:
        if (r2.zza.zzs.zzc().zzn((java.lang.String) null, com.google.android.gms.measurement.internal.zzea.zzac) == false) goto L_0x005c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00af A[SYNTHETIC, Splitter:B:31:0x00af] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0102 A[Catch:{ RuntimeException -> 0x01da }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0115 A[SYNTHETIC, Splitter:B:47:0x0115] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0147 A[Catch:{ RuntimeException -> 0x01da }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0149 A[Catch:{ RuntimeException -> 0x01da }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r17 = this;
            r1 = r17
            com.google.android.gms.measurement.internal.zzhv r2 = r1.zze
            boolean r0 = r1.zza
            android.net.Uri r3 = r1.zzb
            java.lang.String r4 = r1.zzc
            java.lang.String r5 = r1.zzd
            com.google.android.gms.measurement.internal.zzhw r6 = r2.zza
            r6.zzg()
            com.google.android.gms.measurement.internal.zzhw r6 = r2.zza     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzfu r6 = r6.zzs     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzae r6 = r6.zzc()     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzea.zzab     // Catch:{ RuntimeException -> 0x01da }
            r8 = 0
            boolean r6 = r6.zzn(r8, r7)     // Catch:{ RuntimeException -> 0x01da }
            java.lang.String r7 = "Activity created with data 'referrer' without required params"
            java.lang.String r9 = "_cis"
            java.lang.String r10 = "utm_medium"
            java.lang.String r11 = "utm_source"
            java.lang.String r12 = "utm_campaign"
            java.lang.String r13 = "gclid"
            if (r6 != 0) goto L_0x004e
            com.google.android.gms.measurement.internal.zzhw r6 = r2.zza     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzfu r6 = r6.zzs     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzae r6 = r6.zzc()     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzea.zzad     // Catch:{ RuntimeException -> 0x01da }
            boolean r6 = r6.zzn(r8, r14)     // Catch:{ RuntimeException -> 0x01da }
            if (r6 != 0) goto L_0x004e
            com.google.android.gms.measurement.internal.zzhw r6 = r2.zza     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzfu r6 = r6.zzs     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzae r6 = r6.zzc()     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzea.zzac     // Catch:{ RuntimeException -> 0x01da }
            boolean r6 = r6.zzn(r8, r14)     // Catch:{ RuntimeException -> 0x01da }
            if (r6 == 0) goto L_0x005c
        L_0x004e:
            com.google.android.gms.measurement.internal.zzhw r6 = r2.zza     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzfu r6 = r6.zzs     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzku r6 = r6.zzl()     // Catch:{ RuntimeException -> 0x01da }
            boolean r14 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x01da }
            if (r14 == 0) goto L_0x005e
        L_0x005c:
            r6 = r8
            goto L_0x00aa
        L_0x005e:
            boolean r14 = r5.contains(r13)     // Catch:{ RuntimeException -> 0x01da }
            if (r14 != 0) goto L_0x0084
            boolean r14 = r5.contains(r12)     // Catch:{ RuntimeException -> 0x01da }
            if (r14 != 0) goto L_0x0084
            boolean r14 = r5.contains(r11)     // Catch:{ RuntimeException -> 0x01da }
            if (r14 != 0) goto L_0x0084
            boolean r14 = r5.contains(r10)     // Catch:{ RuntimeException -> 0x01da }
            if (r14 != 0) goto L_0x0084
            com.google.android.gms.measurement.internal.zzfu r6 = r6.zzs     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzem r6 = r6.zzau()     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzek r6 = r6.zzj()     // Catch:{ RuntimeException -> 0x01da }
            r6.zza(r7)     // Catch:{ RuntimeException -> 0x01da }
            goto L_0x005c
        L_0x0084:
            java.lang.String r14 = "https://google.com/search?"
            java.lang.String r15 = java.lang.String.valueOf(r5)     // Catch:{ RuntimeException -> 0x01da }
            int r16 = r15.length()     // Catch:{ RuntimeException -> 0x01da }
            if (r16 == 0) goto L_0x0095
            java.lang.String r14 = r14.concat(r15)     // Catch:{ RuntimeException -> 0x01da }
            goto L_0x009b
        L_0x0095:
            java.lang.String r15 = new java.lang.String     // Catch:{ RuntimeException -> 0x01da }
            r15.<init>(r14)     // Catch:{ RuntimeException -> 0x01da }
            r14 = r15
        L_0x009b:
            android.net.Uri r14 = android.net.Uri.parse(r14)     // Catch:{ RuntimeException -> 0x01da }
            android.os.Bundle r6 = r6.zzi(r14)     // Catch:{ RuntimeException -> 0x01da }
            if (r6 == 0) goto L_0x00aa
            java.lang.String r14 = "referrer"
            r6.putString(r9, r14)     // Catch:{ RuntimeException -> 0x01da }
        L_0x00aa:
            java.lang.String r14 = "_cmp"
            r15 = 1
            if (r0 == 0) goto L_0x0102
            com.google.android.gms.measurement.internal.zzhw r0 = r2.zza     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzfu r0 = r0.zzs     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzku r0 = r0.zzl()     // Catch:{ RuntimeException -> 0x01da }
            android.os.Bundle r0 = r0.zzi(r3)     // Catch:{ RuntimeException -> 0x01da }
            if (r0 == 0) goto L_0x0103
            java.lang.String r3 = "intent"
            r0.putString(r9, r3)     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzhw r3 = r2.zza     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzfu r3 = r3.zzs     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzae r3 = r3.zzc()     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzea.zzab     // Catch:{ RuntimeException -> 0x01da }
            boolean r3 = r3.zzn(r8, r9)     // Catch:{ RuntimeException -> 0x01da }
            if (r3 == 0) goto L_0x00f5
            boolean r3 = r0.containsKey(r13)     // Catch:{ RuntimeException -> 0x01da }
            if (r3 != 0) goto L_0x00f5
            if (r6 == 0) goto L_0x00f5
            boolean r3 = r6.containsKey(r13)     // Catch:{ RuntimeException -> 0x01da }
            if (r3 == 0) goto L_0x00f5
            java.lang.String r3 = r6.getString(r13)     // Catch:{ RuntimeException -> 0x01da }
            java.lang.Object[] r9 = new java.lang.Object[r15]     // Catch:{ RuntimeException -> 0x01da }
            r16 = 0
            r9[r16] = r3     // Catch:{ RuntimeException -> 0x01da }
            java.lang.String r3 = "_cer"
            java.lang.String r15 = "gclid=%s"
            java.lang.String r9 = java.lang.String.format(r15, r9)     // Catch:{ RuntimeException -> 0x01da }
            r0.putString(r3, r9)     // Catch:{ RuntimeException -> 0x01da }
        L_0x00f5:
            com.google.android.gms.measurement.internal.zzhw r3 = r2.zza     // Catch:{ RuntimeException -> 0x01da }
            r3.zzs(r4, r14, r0)     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzhw r3 = r2.zza     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzr r3 = r3.zzb     // Catch:{ RuntimeException -> 0x01da }
            r3.zzb(r4, r0)     // Catch:{ RuntimeException -> 0x01da }
            goto L_0x0103
        L_0x0102:
            r0 = r8
        L_0x0103:
            com.google.android.gms.measurement.internal.zzhw r3 = r2.zza     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzfu r3 = r3.zzs     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzae r3 = r3.zzc()     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzea.zzad     // Catch:{ RuntimeException -> 0x01da }
            boolean r3 = r3.zzn(r8, r9)     // Catch:{ RuntimeException -> 0x01da }
            java.lang.String r9 = "auto"
            if (r3 == 0) goto L_0x0141
            com.google.android.gms.measurement.internal.zzhw r3 = r2.zza     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzfu r3 = r3.zzs     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzae r3 = r3.zzc()     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.zzea.zzac     // Catch:{ RuntimeException -> 0x01da }
            boolean r3 = r3.zzn(r8, r15)     // Catch:{ RuntimeException -> 0x01da }
            if (r3 != 0) goto L_0x0141
            if (r6 == 0) goto L_0x0141
            boolean r3 = r6.containsKey(r13)     // Catch:{ RuntimeException -> 0x01da }
            if (r3 == 0) goto L_0x0141
            if (r0 == 0) goto L_0x0135
            boolean r0 = r0.containsKey(r13)     // Catch:{ RuntimeException -> 0x01da }
            if (r0 != 0) goto L_0x0141
        L_0x0135:
            com.google.android.gms.measurement.internal.zzhw r0 = r2.zza     // Catch:{ RuntimeException -> 0x01da }
            java.lang.String r3 = "_lgclid"
            java.lang.String r15 = r6.getString(r13)     // Catch:{ RuntimeException -> 0x01da }
            r8 = 1
            r0.zzy(r9, r3, r15, r8)     // Catch:{ RuntimeException -> 0x01da }
        L_0x0141:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x01da }
            if (r0 == 0) goto L_0x0149
            goto L_0x01c9
        L_0x0149:
            com.google.android.gms.measurement.internal.zzhw r0 = r2.zza     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzfu r0 = r0.zzs     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzj()     // Catch:{ RuntimeException -> 0x01da }
            java.lang.String r3 = "Activity created with referrer"
            r0.zzb(r3, r5)     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzhw r0 = r2.zza     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzfu r0 = r0.zzs     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc()     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzea.zzac     // Catch:{ RuntimeException -> 0x01da }
            r8 = 0
            boolean r0 = r0.zzn(r8, r3)     // Catch:{ RuntimeException -> 0x01da }
            java.lang.String r3 = "_ldl"
            if (r0 == 0) goto L_0x0195
            if (r6 == 0) goto L_0x017c
            com.google.android.gms.measurement.internal.zzhw r0 = r2.zza     // Catch:{ RuntimeException -> 0x01da }
            r0.zzs(r4, r14, r6)     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzhw r0 = r2.zza     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzr r0 = r0.zzb     // Catch:{ RuntimeException -> 0x01da }
            r0.zzb(r4, r6)     // Catch:{ RuntimeException -> 0x01da }
            goto L_0x018d
        L_0x017c:
            com.google.android.gms.measurement.internal.zzhw r0 = r2.zza     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzfu r0 = r0.zzs     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzj()     // Catch:{ RuntimeException -> 0x01da }
            java.lang.String r4 = "Referrer does not contain valid parameters"
            r0.zzb(r4, r5)     // Catch:{ RuntimeException -> 0x01da }
        L_0x018d:
            com.google.android.gms.measurement.internal.zzhw r0 = r2.zza     // Catch:{ RuntimeException -> 0x01da }
            r4 = 1
            r5 = 0
            r0.zzy(r9, r3, r5, r4)     // Catch:{ RuntimeException -> 0x01da }
            return
        L_0x0195:
            boolean r0 = r5.contains(r13)     // Catch:{ RuntimeException -> 0x01da }
            if (r0 == 0) goto L_0x01ca
            boolean r0 = r5.contains(r12)     // Catch:{ RuntimeException -> 0x01da }
            if (r0 != 0) goto L_0x01bd
            boolean r0 = r5.contains(r11)     // Catch:{ RuntimeException -> 0x01da }
            if (r0 != 0) goto L_0x01bd
            boolean r0 = r5.contains(r10)     // Catch:{ RuntimeException -> 0x01da }
            if (r0 != 0) goto L_0x01bd
            java.lang.String r0 = "utm_term"
            boolean r0 = r5.contains(r0)     // Catch:{ RuntimeException -> 0x01da }
            if (r0 != 0) goto L_0x01bd
            java.lang.String r0 = "utm_content"
            boolean r0 = r5.contains(r0)     // Catch:{ RuntimeException -> 0x01da }
            if (r0 == 0) goto L_0x01ca
        L_0x01bd:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x01da }
            if (r0 != 0) goto L_0x01c9
            com.google.android.gms.measurement.internal.zzhw r0 = r2.zza     // Catch:{ RuntimeException -> 0x01da }
            r4 = 1
            r0.zzy(r9, r3, r5, r4)     // Catch:{ RuntimeException -> 0x01da }
        L_0x01c9:
            return
        L_0x01ca:
            com.google.android.gms.measurement.internal.zzhw r0 = r2.zza     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzfu r0 = r0.zzs     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ RuntimeException -> 0x01da }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzj()     // Catch:{ RuntimeException -> 0x01da }
            r0.zza(r7)     // Catch:{ RuntimeException -> 0x01da }
            return
        L_0x01da:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzhw r2 = r2.zza
            com.google.android.gms.measurement.internal.zzfu r2 = r2.zzs
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()
            java.lang.String r3 = "Throwable caught in handleReferrerForOnActivityCreated"
            r2.zzb(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhu.run():void");
    }
}
