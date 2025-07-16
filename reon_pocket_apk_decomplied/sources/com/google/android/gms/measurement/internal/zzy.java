package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
final class zzy extends zzke {
    private String zza;
    private Set<Integer> zzb;
    private Map<Integer, zzt> zzc;
    private Long zzd;
    private Long zze;

    zzy(zzkn zzkn) {
        super(zzkn);
    }

    private final zzt zzc(Integer num) {
        if (this.zzc.containsKey(num)) {
            return this.zzc.get(num);
        }
        zzt zzt = new zzt(this, this.zza, (zzs) null);
        this.zzc.put(num, zzt);
        return zzt;
    }

    private final boolean zzd(int i, int i2) {
        zzt zzt = this.zzc.get(Integer.valueOf(i));
        if (zzt == null) {
            return false;
        }
        return zzt.zze.get(i2);
    }

    /* access modifiers changed from: protected */
    public final boolean zzaA() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02d2, code lost:
        if (r5 != null) goto L_0x02d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02d4, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02dc, code lost:
        if (r5 != null) goto L_0x02d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0301, code lost:
        if (r5 != null) goto L_0x02d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0304, code lost:
        r1 = r13.keySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0310, code lost:
        if (r1.hasNext() == false) goto L_0x03c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0312, code lost:
        r4 = (java.lang.Integer) r1.next();
        r4.intValue();
        r5 = (com.google.android.gms.internal.measurement.zzgd) r13.get(r4);
        r6 = (java.util.List) r0.get(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0327, code lost:
        if (r6 == null) goto L_0x03b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x032d, code lost:
        if (r6.isEmpty() == false) goto L_0x0331;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0331, code lost:
        r16 = r0;
        r0 = r10.zzf.zzm().zzo(r5.zzc(), r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0345, code lost:
        if (r0.isEmpty() != false) goto L_0x03b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0347, code lost:
        r7 = (com.google.android.gms.internal.measurement.zzgc) r5.zzbu();
        r7.zzd();
        r7.zzc(r0);
        r17 = r1;
        r0 = r10.zzf.zzm().zzo(r5.zza(), r6);
        r7.zzb();
        r7.zza(r0);
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x036e, code lost:
        if (r0 >= r5.zzf()) goto L_0x0388;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0380, code lost:
        if (r6.contains(java.lang.Integer.valueOf(r5.zzg(r0).zzb())) == false) goto L_0x0385;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0382, code lost:
        r7.zzf(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0385, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0388, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x038d, code lost:
        if (r0 >= r5.zzi()) goto L_0x03a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x039f, code lost:
        if (r6.contains(java.lang.Integer.valueOf(r5.zzj(r0).zzb())) == false) goto L_0x03a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x03a1, code lost:
        r7.zzh(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03a4, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03a7, code lost:
        r3.put(r4, (com.google.android.gms.internal.measurement.zzgd) r7.zzaA());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03b1, code lost:
        r0 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03b5, code lost:
        r16 = r0;
        r17 = r1;
        r3.put(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x03bc, code lost:
        r0 = r16;
        r1 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x0702, code lost:
        if (r11 != null) goto L_0x0704;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x0704, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x0718, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x0719, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:298:0x071b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x071c, code lost:
        r29 = r2;
        r27 = r4;
        r25 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x073a, code lost:
        if (r11 != null) goto L_0x0704;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x0745, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:368:0x08c0, code lost:
        if (r13 != null) goto L_0x08c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:369:0x08c2, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:379:0x08e8, code lost:
        if (r13 == null) goto L_0x08eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:413:0x09ec, code lost:
        if (r8.zza() == false) goto L_0x09f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:414:0x09ee, code lost:
        r7 = java.lang.Integer.valueOf(r8.zzb());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:415:0x09f7, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:416:0x09f8, code lost:
        r0.zzc("Invalid property filter ID. appId, id", r6, java.lang.String.valueOf(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x014f, code lost:
        if (r5 != null) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0151, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0173, code lost:
        if (r5 != null) goto L_0x0151;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x025f  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x03c6  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x0582  */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x0718 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:248:0x066a] */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x0745  */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x07fe  */
    /* JADX WARNING: Removed duplicated region for block: B:384:0x08f3  */
    /* JADX WARNING: Removed duplicated region for block: B:425:0x0a31  */
    /* JADX WARNING: Removed duplicated region for block: B:442:0x0ac1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01ae A[Catch:{ SQLiteException -> 0x0222 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01be A[SYNTHETIC, Splitter:B:70:0x01be] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.internal.measurement.zzfk> zzb(java.lang.String r66, java.util.List<com.google.android.gms.internal.measurement.zzfo> r67, java.util.List<com.google.android.gms.internal.measurement.zzgh> r68, java.lang.Long r69, java.lang.Long r70) {
        /*
            r65 = this;
            r10 = r65
            java.lang.String r11 = "current_results"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r66)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r67)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r68)
            r0 = r66
            r10.zza = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r10.zzb = r0
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            r10.zzc = r0
            r0 = r69
            r10.zzd = r0
            r0 = r70
            r10.zze = r0
            java.util.Iterator r0 = r67.iterator()
        L_0x002b:
            boolean r1 = r0.hasNext()
            r12 = 0
            r13 = 1
            if (r1 == 0) goto L_0x0047
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzfo r1 = (com.google.android.gms.internal.measurement.zzfo) r1
            java.lang.String r1 = r1.zzd()
            java.lang.String r2 = "_s"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x002b
            r1 = r13
            goto L_0x0048
        L_0x0047:
            r1 = r12
        L_0x0048:
            com.google.android.gms.internal.measurement.zzog.zzb()
            com.google.android.gms.measurement.internal.zzfu r0 = r10.zzs
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc()
            java.lang.String r2 = r10.zza
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzea.zzZ
            boolean r14 = r0.zzn(r2, r3)
            com.google.android.gms.internal.measurement.zzog.zzb()
            com.google.android.gms.measurement.internal.zzfu r0 = r10.zzs
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc()
            java.lang.String r2 = r10.zza
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzea.zzY
            boolean r15 = r0.zzn(r2, r3)
            if (r1 == 0) goto L_0x00af
            com.google.android.gms.measurement.internal.zzkn r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzai r2 = r0.zzi()
            java.lang.String r3 = r10.zza
            r2.zzZ()
            r2.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.String r4 = "current_session_count"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r12)
            r0.put(r4, r5)
            android.database.sqlite.SQLiteDatabase r4 = r2.zze()     // Catch:{ SQLiteException -> 0x009b }
            java.lang.String[] r5 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x009b }
            java.lang.String r6 = "events"
            java.lang.String r7 = "app_id = ?"
            r4.update(r6, r0, r7, r5)     // Catch:{ SQLiteException -> 0x009b }
            goto L_0x00af
        L_0x009b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfu r2 = r2.zzs
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()
            java.lang.String r4 = "Error resetting session-scoped event counts. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzem.zzl(r3)
            r2.zzc(r4, r3, r0)
        L_0x00af:
            java.util.Map r0 = java.util.Collections.emptyMap()
            java.lang.String r9 = "Failed to merge filter. appId"
            java.lang.String r8 = "Database error querying filters. appId"
            java.lang.String r7 = "data"
            java.lang.String r6 = "audience_id"
            if (r15 == 0) goto L_0x017c
            if (r14 == 0) goto L_0x017c
            com.google.android.gms.measurement.internal.zzkn r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzai r2 = r0.zzi()
            java.lang.String r3 = r10.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap
            r4.<init>()
            android.database.sqlite.SQLiteDatabase r16 = r2.zze()
            java.lang.String[] r18 = new java.lang.String[]{r6, r7}     // Catch:{ SQLiteException -> 0x015c, all -> 0x0159 }
            java.lang.String[] r20 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x015c, all -> 0x0159 }
            java.lang.String r17 = "event_filters"
            java.lang.String r19 = "app_id=?"
            r22 = 0
            r23 = 0
            r21 = 0
            android.database.Cursor r5 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x015c, all -> 0x0159 }
            boolean r0 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0157 }
            if (r0 == 0) goto L_0x014b
        L_0x00ef:
            byte[] r0 = r5.getBlob(r13)     // Catch:{ SQLiteException -> 0x0157 }
            com.google.android.gms.internal.measurement.zzei r13 = com.google.android.gms.internal.measurement.zzej.zzn()     // Catch:{ IOException -> 0x0129 }
            com.google.android.gms.internal.measurement.zzlh r0 = com.google.android.gms.measurement.internal.zzkp.zzt(r13, r0)     // Catch:{ IOException -> 0x0129 }
            com.google.android.gms.internal.measurement.zzei r0 = (com.google.android.gms.internal.measurement.zzei) r0     // Catch:{ IOException -> 0x0129 }
            com.google.android.gms.internal.measurement.zzkd r0 = r0.zzaA()     // Catch:{ IOException -> 0x0129 }
            com.google.android.gms.internal.measurement.zzej r0 = (com.google.android.gms.internal.measurement.zzej) r0     // Catch:{ IOException -> 0x0129 }
            boolean r13 = r0.zzg()     // Catch:{ SQLiteException -> 0x0157 }
            if (r13 != 0) goto L_0x010a
            goto L_0x013b
        L_0x010a:
            int r13 = r5.getInt(r12)     // Catch:{ SQLiteException -> 0x0157 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ SQLiteException -> 0x0157 }
            java.lang.Object r16 = r4.get(r13)     // Catch:{ SQLiteException -> 0x0157 }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x0157 }
            if (r16 != 0) goto L_0x0123
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0157 }
            r12.<init>()     // Catch:{ SQLiteException -> 0x0157 }
            r4.put(r13, r12)     // Catch:{ SQLiteException -> 0x0157 }
            goto L_0x0125
        L_0x0123:
            r12 = r16
        L_0x0125:
            r12.add(r0)     // Catch:{ SQLiteException -> 0x0157 }
            goto L_0x013b
        L_0x0129:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfu r12 = r2.zzs     // Catch:{ SQLiteException -> 0x0157 }
            com.google.android.gms.measurement.internal.zzem r12 = r12.zzau()     // Catch:{ SQLiteException -> 0x0157 }
            com.google.android.gms.measurement.internal.zzek r12 = r12.zzb()     // Catch:{ SQLiteException -> 0x0157 }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzem.zzl(r3)     // Catch:{ SQLiteException -> 0x0157 }
            r12.zzc(r9, r13, r0)     // Catch:{ SQLiteException -> 0x0157 }
        L_0x013b:
            boolean r0 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x0157 }
            if (r0 != 0) goto L_0x0148
            if (r5 == 0) goto L_0x0146
            r5.close()
        L_0x0146:
            r12 = r4
            goto L_0x017d
        L_0x0148:
            r12 = 0
            r13 = 1
            goto L_0x00ef
        L_0x014b:
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0157 }
            if (r5 == 0) goto L_0x017c
        L_0x0151:
            r5.close()
            goto L_0x017c
        L_0x0155:
            r0 = move-exception
            goto L_0x0176
        L_0x0157:
            r0 = move-exception
            goto L_0x015e
        L_0x0159:
            r0 = move-exception
            r5 = 0
            goto L_0x0176
        L_0x015c:
            r0 = move-exception
            r5 = 0
        L_0x015e:
            com.google.android.gms.measurement.internal.zzfu r2 = r2.zzs     // Catch:{ all -> 0x0155 }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ all -> 0x0155 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ all -> 0x0155 }
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzem.zzl(r3)     // Catch:{ all -> 0x0155 }
            r2.zzc(r8, r3, r0)     // Catch:{ all -> 0x0155 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0155 }
            if (r5 == 0) goto L_0x017c
            goto L_0x0151
        L_0x0176:
            if (r5 == 0) goto L_0x017b
            r5.close()
        L_0x017b:
            throw r0
        L_0x017c:
            r12 = r0
        L_0x017d:
            com.google.android.gms.measurement.internal.zzkn r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzai r2 = r0.zzi()
            java.lang.String r3 = r10.zza
            r2.zzZ()
            r2.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            android.database.sqlite.SQLiteDatabase r16 = r2.zze()
            java.lang.String[] r18 = new java.lang.String[]{r6, r11}     // Catch:{ SQLiteException -> 0x022c, all -> 0x0228 }
            java.lang.String[] r20 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x022c, all -> 0x0228 }
            java.lang.String r17 = "audience_filter_values"
            java.lang.String r19 = "app_id=?"
            r22 = 0
            r23 = 0
            r21 = 0
            android.database.Cursor r4 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x022c, all -> 0x0228 }
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0222 }
            if (r0 != 0) goto L_0x01be
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0222 }
            if (r4 == 0) goto L_0x01b7
            r4.close()
        L_0x01b7:
            r13 = r0
            r18 = r6
            r19 = r7
            goto L_0x024f
        L_0x01be:
            androidx.collection.ArrayMap r5 = new androidx.collection.ArrayMap     // Catch:{ SQLiteException -> 0x0222 }
            r5.<init>()     // Catch:{ SQLiteException -> 0x0222 }
        L_0x01c3:
            r13 = 0
            int r16 = r4.getInt(r13)     // Catch:{ SQLiteException -> 0x0222 }
            r13 = 1
            byte[] r0 = r4.getBlob(r13)     // Catch:{ SQLiteException -> 0x0222 }
            com.google.android.gms.internal.measurement.zzgc r13 = com.google.android.gms.internal.measurement.zzgd.zzk()     // Catch:{ IOException -> 0x01eb }
            com.google.android.gms.internal.measurement.zzlh r0 = com.google.android.gms.measurement.internal.zzkp.zzt(r13, r0)     // Catch:{ IOException -> 0x01eb }
            com.google.android.gms.internal.measurement.zzgc r0 = (com.google.android.gms.internal.measurement.zzgc) r0     // Catch:{ IOException -> 0x01eb }
            com.google.android.gms.internal.measurement.zzkd r0 = r0.zzaA()     // Catch:{ IOException -> 0x01eb }
            com.google.android.gms.internal.measurement.zzgd r0 = (com.google.android.gms.internal.measurement.zzgd) r0     // Catch:{ IOException -> 0x01eb }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x0222 }
            r5.put(r13, r0)     // Catch:{ SQLiteException -> 0x0222 }
            r17 = r5
            r18 = r6
            r19 = r7
            goto L_0x0209
        L_0x01eb:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfu r13 = r2.zzs     // Catch:{ SQLiteException -> 0x0222 }
            com.google.android.gms.measurement.internal.zzem r13 = r13.zzau()     // Catch:{ SQLiteException -> 0x0222 }
            com.google.android.gms.measurement.internal.zzek r13 = r13.zzb()     // Catch:{ SQLiteException -> 0x0222 }
            r17 = r5
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            r18 = r6
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzem.zzl(r3)     // Catch:{ SQLiteException -> 0x0220 }
            r19 = r7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x021e }
            r13.zzd(r5, r6, r7, r0)     // Catch:{ SQLiteException -> 0x021e }
        L_0x0209:
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x021e }
            if (r0 != 0) goto L_0x0217
            if (r4 == 0) goto L_0x0214
            r4.close()
        L_0x0214:
            r13 = r17
            goto L_0x024f
        L_0x0217:
            r5 = r17
            r6 = r18
            r7 = r19
            goto L_0x01c3
        L_0x021e:
            r0 = move-exception
            goto L_0x0232
        L_0x0220:
            r0 = move-exception
            goto L_0x0225
        L_0x0222:
            r0 = move-exception
            r18 = r6
        L_0x0225:
            r19 = r7
            goto L_0x0232
        L_0x0228:
            r0 = move-exception
            r5 = 0
            goto L_0x0abf
        L_0x022c:
            r0 = move-exception
            r18 = r6
            r19 = r7
            r4 = 0
        L_0x0232:
            com.google.android.gms.measurement.internal.zzfu r2 = r2.zzs     // Catch:{ all -> 0x0abd }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ all -> 0x0abd }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ all -> 0x0abd }
            java.lang.String r5 = "Database error querying filter results. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzem.zzl(r3)     // Catch:{ all -> 0x0abd }
            r2.zzc(r5, r3, r0)     // Catch:{ all -> 0x0abd }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0abd }
            if (r4 == 0) goto L_0x024e
            r4.close()
        L_0x024e:
            r13 = r0
        L_0x024f:
            boolean r0 = r13.isEmpty()
            if (r0 == 0) goto L_0x025f
        L_0x0255:
            r12 = r8
            r30 = r9
            r27 = r18
            r29 = r19
            r13 = 0
            goto L_0x0576
        L_0x025f:
            java.util.HashSet r2 = new java.util.HashSet
            java.util.Set r0 = r13.keySet()
            r2.<init>(r0)
            if (r1 == 0) goto L_0x03ca
            java.lang.String r1 = r10.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r1)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)
            androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap
            r3.<init>()
            boolean r0 = r13.isEmpty()
            if (r0 == 0) goto L_0x027f
            goto L_0x03c2
        L_0x027f:
            com.google.android.gms.measurement.internal.zzkn r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzai r4 = r0.zzi()
            r4.zzZ()
            r4.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r1)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r5 = r4.zze()
            java.lang.String[] r6 = new java.lang.String[]{r1, r1}     // Catch:{ SQLiteException -> 0x02e8, all -> 0x02e4 }
            java.lang.String r7 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            android.database.Cursor r5 = r5.rawQuery(r7, r6)     // Catch:{ SQLiteException -> 0x02e8, all -> 0x02e4 }
            boolean r6 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x02e2 }
            if (r6 == 0) goto L_0x02d8
        L_0x02a7:
            r6 = 0
            int r7 = r5.getInt(r6)     // Catch:{ SQLiteException -> 0x02e2 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)     // Catch:{ SQLiteException -> 0x02e2 }
            java.lang.Object r7 = r0.get(r6)     // Catch:{ SQLiteException -> 0x02e2 }
            java.util.List r7 = (java.util.List) r7     // Catch:{ SQLiteException -> 0x02e2 }
            if (r7 != 0) goto L_0x02c0
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x02e2 }
            r7.<init>()     // Catch:{ SQLiteException -> 0x02e2 }
            r0.put(r6, r7)     // Catch:{ SQLiteException -> 0x02e2 }
        L_0x02c0:
            r6 = 1
            int r16 = r5.getInt(r6)     // Catch:{ SQLiteException -> 0x02e2 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x02e2 }
            r7.add(r6)     // Catch:{ SQLiteException -> 0x02e2 }
            boolean r6 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x02e2 }
            if (r6 != 0) goto L_0x02a7
            if (r5 == 0) goto L_0x0304
        L_0x02d4:
            r5.close()
            goto L_0x0304
        L_0x02d8:
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x02e2 }
            if (r5 == 0) goto L_0x0304
            goto L_0x02d4
        L_0x02df:
            r0 = move-exception
            goto L_0x03c4
        L_0x02e2:
            r0 = move-exception
            goto L_0x02ea
        L_0x02e4:
            r0 = move-exception
            r5 = 0
            goto L_0x03c4
        L_0x02e8:
            r0 = move-exception
            r5 = 0
        L_0x02ea:
            com.google.android.gms.measurement.internal.zzfu r4 = r4.zzs     // Catch:{ all -> 0x02df }
            com.google.android.gms.measurement.internal.zzem r4 = r4.zzau()     // Catch:{ all -> 0x02df }
            com.google.android.gms.measurement.internal.zzek r4 = r4.zzb()     // Catch:{ all -> 0x02df }
            java.lang.String r6 = "Database error querying scoped filters. appId"
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzem.zzl(r1)     // Catch:{ all -> 0x02df }
            r4.zzc(r6, r1, r0)     // Catch:{ all -> 0x02df }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x02df }
            if (r5 == 0) goto L_0x0304
            goto L_0x02d4
        L_0x0304:
            java.util.Set r1 = r13.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x030c:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x03c2
            java.lang.Object r4 = r1.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            r4.intValue()
            java.lang.Object r5 = r13.get(r4)
            com.google.android.gms.internal.measurement.zzgd r5 = (com.google.android.gms.internal.measurement.zzgd) r5
            java.lang.Object r6 = r0.get(r4)
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L_0x03b5
            boolean r7 = r6.isEmpty()
            if (r7 == 0) goto L_0x0331
            goto L_0x03b5
        L_0x0331:
            com.google.android.gms.measurement.internal.zzkn r7 = r10.zzf
            com.google.android.gms.measurement.internal.zzkp r7 = r7.zzm()
            r16 = r0
            java.util.List r0 = r5.zzc()
            java.util.List r0 = r7.zzo(r0, r6)
            boolean r7 = r0.isEmpty()
            if (r7 != 0) goto L_0x03b1
            com.google.android.gms.internal.measurement.zzjz r7 = r5.zzbu()
            com.google.android.gms.internal.measurement.zzgc r7 = (com.google.android.gms.internal.measurement.zzgc) r7
            r7.zzd()
            r7.zzc(r0)
            com.google.android.gms.measurement.internal.zzkn r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzkp r0 = r0.zzm()
            r17 = r1
            java.util.List r1 = r5.zza()
            java.util.List r0 = r0.zzo(r1, r6)
            r7.zzb()
            r7.zza(r0)
            r0 = 0
        L_0x036a:
            int r1 = r5.zzf()
            if (r0 >= r1) goto L_0x0388
            com.google.android.gms.internal.measurement.zzfm r1 = r5.zzg(r0)
            int r1 = r1.zzb()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            boolean r1 = r6.contains(r1)
            if (r1 == 0) goto L_0x0385
            r7.zzf(r0)
        L_0x0385:
            int r0 = r0 + 1
            goto L_0x036a
        L_0x0388:
            r0 = 0
        L_0x0389:
            int r1 = r5.zzi()
            if (r0 >= r1) goto L_0x03a7
            com.google.android.gms.internal.measurement.zzgf r1 = r5.zzj(r0)
            int r1 = r1.zzb()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            boolean r1 = r6.contains(r1)
            if (r1 == 0) goto L_0x03a4
            r7.zzh(r0)
        L_0x03a4:
            int r0 = r0 + 1
            goto L_0x0389
        L_0x03a7:
            com.google.android.gms.internal.measurement.zzkd r0 = r7.zzaA()
            com.google.android.gms.internal.measurement.zzgd r0 = (com.google.android.gms.internal.measurement.zzgd) r0
            r3.put(r4, r0)
            goto L_0x03bc
        L_0x03b1:
            r0 = r16
            goto L_0x030c
        L_0x03b5:
            r16 = r0
            r17 = r1
            r3.put(r4, r5)
        L_0x03bc:
            r0 = r16
            r1 = r17
            goto L_0x030c
        L_0x03c2:
            r0 = r3
            goto L_0x03cb
        L_0x03c4:
            if (r5 == 0) goto L_0x03c9
            r5.close()
        L_0x03c9:
            throw r0
        L_0x03ca:
            r0 = r13
        L_0x03cb:
            java.util.Iterator r16 = r2.iterator()
        L_0x03cf:
            boolean r1 = r16.hasNext()
            if (r1 == 0) goto L_0x0255
            java.lang.Object r1 = r16.next()
            r7 = r1
            java.lang.Integer r7 = (java.lang.Integer) r7
            r7.intValue()
            java.lang.Object r1 = r0.get(r7)
            com.google.android.gms.internal.measurement.zzgd r1 = (com.google.android.gms.internal.measurement.zzgd) r1
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            java.util.BitSet r6 = new java.util.BitSet
            r6.<init>()
            androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap
            r4.<init>()
            if (r1 == 0) goto L_0x0437
            int r2 = r1.zzf()
            if (r2 != 0) goto L_0x03fd
            goto L_0x0437
        L_0x03fd:
            java.util.List r2 = r1.zze()
            java.util.Iterator r2 = r2.iterator()
        L_0x0405:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0437
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzfm r3 = (com.google.android.gms.internal.measurement.zzfm) r3
            boolean r17 = r3.zza()
            if (r17 == 0) goto L_0x0405
            int r17 = r3.zzb()
            r20 = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r17)
            boolean r17 = r3.zzc()
            if (r17 == 0) goto L_0x0430
            long r21 = r3.zzd()
            java.lang.Long r3 = java.lang.Long.valueOf(r21)
            goto L_0x0431
        L_0x0430:
            r3 = 0
        L_0x0431:
            r4.put(r0, r3)
            r0 = r20
            goto L_0x0405
        L_0x0437:
            r20 = r0
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            if (r1 == 0) goto L_0x0489
            int r2 = r1.zzi()
            if (r2 != 0) goto L_0x0447
            goto L_0x0489
        L_0x0447:
            java.util.List r2 = r1.zzh()
            java.util.Iterator r2 = r2.iterator()
        L_0x044f:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0489
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzgf r3 = (com.google.android.gms.internal.measurement.zzgf) r3
            boolean r17 = r3.zza()
            if (r17 == 0) goto L_0x044f
            int r17 = r3.zzd()
            if (r17 <= 0) goto L_0x044f
            int r17 = r3.zzb()
            r21 = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r17)
            int r17 = r3.zzd()
            r22 = r8
            int r8 = r17 + -1
            long r23 = r3.zze(r8)
            java.lang.Long r3 = java.lang.Long.valueOf(r23)
            r0.put(r2, r3)
            r2 = r21
            r8 = r22
            goto L_0x044f
        L_0x0489:
            r22 = r8
            if (r1 == 0) goto L_0x04d4
            r2 = 0
        L_0x048e:
            int r3 = r1.zzb()
            int r3 = r3 * 64
            if (r2 >= r3) goto L_0x04d4
            java.util.List r3 = r1.zza()
            boolean r3 = com.google.android.gms.measurement.internal.zzkp.zzm(r3, r2)
            if (r3 == 0) goto L_0x04c6
            com.google.android.gms.measurement.internal.zzfu r3 = r10.zzs
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzau()
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzk()
            java.lang.String r8 = "Filter already evaluated. audience ID, filter ID"
            r17 = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r2)
            r3.zzc(r8, r7, r9)
            r6.set(r2)
            java.util.List r3 = r1.zzc()
            boolean r3 = com.google.android.gms.measurement.internal.zzkp.zzm(r3, r2)
            if (r3 == 0) goto L_0x04c8
            r5.set(r2)
            goto L_0x04cf
        L_0x04c6:
            r17 = r9
        L_0x04c8:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r4.remove(r3)
        L_0x04cf:
            int r2 = r2 + 1
            r9 = r17
            goto L_0x048e
        L_0x04d4:
            r17 = r9
            java.lang.Object r1 = r13.get(r7)
            r8 = r1
            com.google.android.gms.internal.measurement.zzgd r8 = (com.google.android.gms.internal.measurement.zzgd) r8
            if (r15 == 0) goto L_0x053d
            if (r14 == 0) goto L_0x053d
            java.lang.Object r1 = r12.get(r7)
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x053d
            java.lang.Long r2 = r10.zze
            if (r2 == 0) goto L_0x053d
            java.lang.Long r2 = r10.zzd
            if (r2 != 0) goto L_0x04f2
            goto L_0x053d
        L_0x04f2:
            java.util.Iterator r1 = r1.iterator()
        L_0x04f6:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x053d
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.measurement.zzej r2 = (com.google.android.gms.internal.measurement.zzej) r2
            int r3 = r2.zzb()
            java.lang.Long r9 = r10.zze
            long r23 = r9.longValue()
            r25 = 1000(0x3e8, double:4.94E-321)
            long r23 = r23 / r25
            boolean r2 = r2.zzj()
            if (r2 == 0) goto L_0x051e
            java.lang.Long r2 = r10.zzd
            long r23 = r2.longValue()
            long r23 = r23 / r25
        L_0x051e:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            boolean r3 = r4.containsKey(r2)
            if (r3 == 0) goto L_0x052f
            java.lang.Long r3 = java.lang.Long.valueOf(r23)
            r4.put(r2, r3)
        L_0x052f:
            boolean r3 = r0.containsKey(r2)
            if (r3 == 0) goto L_0x04f6
            java.lang.Long r3 = java.lang.Long.valueOf(r23)
            r0.put(r2, r3)
            goto L_0x04f6
        L_0x053d:
            com.google.android.gms.measurement.internal.zzt r9 = new com.google.android.gms.measurement.internal.zzt
            java.lang.String r3 = r10.zza
            r21 = 0
            r1 = r9
            r2 = r65
            r23 = r4
            r4 = r8
            r8 = 0
            r27 = r18
            r28 = r7
            r29 = r19
            r7 = r23
            r18 = r12
            r66 = r13
            r12 = r22
            r13 = r8
            r8 = r0
            r0 = r9
            r30 = r17
            r9 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            java.util.Map<java.lang.Integer, com.google.android.gms.measurement.internal.zzt> r1 = r10.zzc
            r2 = r28
            r1.put(r2, r0)
            r13 = r66
            r8 = r12
            r12 = r18
            r0 = r20
            r18 = r27
            r9 = r30
            goto L_0x03cf
        L_0x0576:
            boolean r0 = r67.isEmpty()
            java.lang.String r1 = "Skipping failed audience ID"
            if (r0 == 0) goto L_0x0582
        L_0x057e:
            r25 = r11
            goto L_0x07f4
        L_0x0582:
            com.google.android.gms.measurement.internal.zzu r2 = new com.google.android.gms.measurement.internal.zzu
            r2.<init>(r10, r13)
            androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap
            r3.<init>()
            java.util.Iterator r4 = r67.iterator()
        L_0x0590:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x057e
            java.lang.Object r0 = r4.next()
            com.google.android.gms.internal.measurement.zzfo r0 = (com.google.android.gms.internal.measurement.zzfo) r0
            java.lang.String r5 = r10.zza
            com.google.android.gms.internal.measurement.zzfo r5 = r2.zza(r5, r0)
            if (r5 == 0) goto L_0x07f1
            com.google.android.gms.measurement.internal.zzkn r6 = r10.zzf
            com.google.android.gms.measurement.internal.zzai r6 = r6.zzi()
            java.lang.String r7 = r10.zza
            java.lang.String r8 = r5.zzd()
            java.lang.String r9 = r0.zzd()
            com.google.android.gms.measurement.internal.zzao r9 = r6.zzf(r7, r9)
            if (r9 != 0) goto L_0x05f9
            com.google.android.gms.measurement.internal.zzfu r9 = r6.zzs
            com.google.android.gms.measurement.internal.zzem r9 = r9.zzau()
            com.google.android.gms.measurement.internal.zzek r9 = r9.zze()
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzem.zzl(r7)
            com.google.android.gms.measurement.internal.zzfu r6 = r6.zzs
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzm()
            java.lang.String r6 = r6.zzc(r8)
            java.lang.String r8 = "Event aggregate wasn't created during raw event logging. appId, event"
            r9.zzc(r8, r14, r6)
            com.google.android.gms.measurement.internal.zzao r6 = new com.google.android.gms.measurement.internal.zzao
            r31 = r6
            java.lang.String r33 = r0.zzd()
            long r40 = r0.zzf()
            r46 = 0
            r47 = 0
            r34 = 1
            r36 = 1
            r38 = 1
            r42 = 0
            r44 = 0
            r45 = 0
            r32 = r7
            r31.<init>(r32, r33, r34, r36, r38, r40, r42, r44, r45, r46, r47)
            goto L_0x062e
        L_0x05f9:
            com.google.android.gms.measurement.internal.zzao r6 = new com.google.android.gms.measurement.internal.zzao
            r48 = r6
            java.lang.String r0 = r9.zza
            r49 = r0
            java.lang.String r0 = r9.zzb
            r50 = r0
            long r7 = r9.zzc
            r14 = 1
            long r51 = r7 + r14
            long r7 = r9.zzd
            long r53 = r7 + r14
            long r7 = r9.zze
            long r55 = r7 + r14
            long r7 = r9.zzf
            r57 = r7
            long r7 = r9.zzg
            r59 = r7
            java.lang.Long r0 = r9.zzh
            r61 = r0
            java.lang.Long r0 = r9.zzi
            r62 = r0
            java.lang.Long r0 = r9.zzj
            r63 = r0
            java.lang.Boolean r0 = r9.zzk
            r64 = r0
            r48.<init>(r49, r50, r51, r53, r55, r57, r59, r61, r62, r63, r64)
        L_0x062e:
            com.google.android.gms.measurement.internal.zzkn r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzai r0 = r0.zzi()
            r0.zzh(r6)
            long r7 = r6.zzc
            java.lang.String r9 = r5.zzd()
            java.lang.Object r0 = r3.get(r9)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L_0x0749
            com.google.android.gms.measurement.internal.zzkn r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzai r14 = r0.zzi()
            java.lang.String r15 = r10.zza
            r14.zzZ()
            r14.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            androidx.collection.ArrayMap r13 = new androidx.collection.ArrayMap
            r13.<init>()
            android.database.sqlite.SQLiteDatabase r16 = r14.zze()
            r24 = r2
            r67 = r4
            r4 = r27
            r2 = r29
            java.lang.String[] r18 = new java.lang.String[]{r4, r2}     // Catch:{ SQLiteException -> 0x071b, all -> 0x0718 }
            java.lang.String[] r20 = new java.lang.String[]{r15, r9}     // Catch:{ SQLiteException -> 0x071b, all -> 0x0718 }
            java.lang.String r17 = "event_filters"
            java.lang.String r19 = "app_id=? AND event_name=?"
            r22 = 0
            r23 = 0
            r21 = 0
            r25 = r11
            android.database.Cursor r11 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x0712, all -> 0x0718 }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x070a }
            if (r0 == 0) goto L_0x06f8
            r29 = r2
        L_0x068a:
            r2 = 1
            byte[] r0 = r11.getBlob(r2)     // Catch:{ SQLiteException -> 0x06f6 }
            com.google.android.gms.internal.measurement.zzei r2 = com.google.android.gms.internal.measurement.zzej.zzn()     // Catch:{ IOException -> 0x06c7 }
            com.google.android.gms.internal.measurement.zzlh r0 = com.google.android.gms.measurement.internal.zzkp.zzt(r2, r0)     // Catch:{ IOException -> 0x06c7 }
            com.google.android.gms.internal.measurement.zzei r0 = (com.google.android.gms.internal.measurement.zzei) r0     // Catch:{ IOException -> 0x06c7 }
            com.google.android.gms.internal.measurement.zzkd r0 = r0.zzaA()     // Catch:{ IOException -> 0x06c7 }
            com.google.android.gms.internal.measurement.zzej r0 = (com.google.android.gms.internal.measurement.zzej) r0     // Catch:{ IOException -> 0x06c7 }
            r2 = 0
            int r16 = r11.getInt(r2)     // Catch:{ SQLiteException -> 0x06f6 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x06f6 }
            java.lang.Object r16 = r13.get(r2)     // Catch:{ SQLiteException -> 0x06f6 }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x06f6 }
            if (r16 != 0) goto L_0x06bb
            r27 = r4
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x06f4 }
            r4.<init>()     // Catch:{ SQLiteException -> 0x06f4 }
            r13.put(r2, r4)     // Catch:{ SQLiteException -> 0x06f4 }
            goto L_0x06bf
        L_0x06bb:
            r27 = r4
            r4 = r16
        L_0x06bf:
            r4.add(r0)     // Catch:{ SQLiteException -> 0x06f4 }
            r16 = r13
            r13 = r30
            goto L_0x06df
        L_0x06c7:
            r0 = move-exception
            r27 = r4
            com.google.android.gms.measurement.internal.zzfu r2 = r14.zzs     // Catch:{ SQLiteException -> 0x06f4 }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ SQLiteException -> 0x06f4 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ SQLiteException -> 0x06f4 }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzem.zzl(r15)     // Catch:{ SQLiteException -> 0x06f4 }
            r16 = r13
            r13 = r30
            r2.zzc(r13, r4, r0)     // Catch:{ SQLiteException -> 0x0708 }
        L_0x06df:
            boolean r0 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x0708 }
            if (r0 != 0) goto L_0x06ed
            if (r11 == 0) goto L_0x06ea
            r11.close()
        L_0x06ea:
            r0 = r16
            goto L_0x073d
        L_0x06ed:
            r30 = r13
            r13 = r16
            r4 = r27
            goto L_0x068a
        L_0x06f4:
            r0 = move-exception
            goto L_0x070f
        L_0x06f6:
            r0 = move-exception
            goto L_0x070d
        L_0x06f8:
            r29 = r2
            r27 = r4
            r13 = r30
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0708 }
            if (r11 == 0) goto L_0x073d
        L_0x0704:
            r11.close()
            goto L_0x073d
        L_0x0708:
            r0 = move-exception
            goto L_0x0725
        L_0x070a:
            r0 = move-exception
            r29 = r2
        L_0x070d:
            r27 = r4
        L_0x070f:
            r13 = r30
            goto L_0x0725
        L_0x0712:
            r0 = move-exception
            r29 = r2
            r27 = r4
            goto L_0x0722
        L_0x0718:
            r0 = move-exception
            r5 = 0
            goto L_0x0743
        L_0x071b:
            r0 = move-exception
            r29 = r2
            r27 = r4
            r25 = r11
        L_0x0722:
            r13 = r30
            r11 = 0
        L_0x0725:
            com.google.android.gms.measurement.internal.zzfu r2 = r14.zzs     // Catch:{ all -> 0x0741 }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ all -> 0x0741 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ all -> 0x0741 }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzem.zzl(r15)     // Catch:{ all -> 0x0741 }
            r2.zzc(r12, r4, r0)     // Catch:{ all -> 0x0741 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0741 }
            if (r11 == 0) goto L_0x073d
            goto L_0x0704
        L_0x073d:
            r3.put(r9, r0)
            goto L_0x0751
        L_0x0741:
            r0 = move-exception
            r5 = r11
        L_0x0743:
            if (r5 == 0) goto L_0x0748
            r5.close()
        L_0x0748:
            throw r0
        L_0x0749:
            r24 = r2
            r67 = r4
            r25 = r11
            r13 = r30
        L_0x0751:
            java.util.Set r2 = r0.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0759:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x07e9
            java.lang.Object r4 = r2.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r9 = r4.intValue()
            java.util.Set<java.lang.Integer> r11 = r10.zzb
            boolean r11 = r11.contains(r4)
            if (r11 == 0) goto L_0x077f
            com.google.android.gms.measurement.internal.zzfu r9 = r10.zzs
            com.google.android.gms.measurement.internal.zzem r9 = r9.zzau()
            com.google.android.gms.measurement.internal.zzek r9 = r9.zzk()
            r9.zzb(r1, r4)
            goto L_0x0759
        L_0x077f:
            java.lang.Object r11 = r0.get(r4)
            java.util.List r11 = (java.util.List) r11
            java.util.Iterator r11 = r11.iterator()
            r14 = 1
        L_0x078a:
            boolean r15 = r11.hasNext()
            if (r15 == 0) goto L_0x07d4
            java.lang.Object r14 = r11.next()
            com.google.android.gms.internal.measurement.zzej r14 = (com.google.android.gms.internal.measurement.zzej) r14
            com.google.android.gms.measurement.internal.zzv r15 = new com.google.android.gms.measurement.internal.zzv
            r22 = r0
            java.lang.String r0 = r10.zza
            r15.<init>(r10, r0, r9, r14)
            java.lang.Long r0 = r10.zzd
            r23 = r2
            java.lang.Long r2 = r10.zze
            int r14 = r14.zzb()
            boolean r21 = r10.zzd(r9, r14)
            r14 = r15
            r26 = r3
            r3 = r15
            r15 = r0
            r16 = r2
            r17 = r5
            r18 = r7
            r20 = r6
            boolean r14 = r14.zzd(r15, r16, r17, r18, r20, r21)
            if (r14 == 0) goto L_0x07ce
            com.google.android.gms.measurement.internal.zzt r0 = r10.zzc(r4)
            r0.zza(r3)
            r0 = r22
            r2 = r23
            r3 = r26
            goto L_0x078a
        L_0x07ce:
            java.util.Set<java.lang.Integer> r0 = r10.zzb
            r0.add(r4)
            goto L_0x07da
        L_0x07d4:
            r22 = r0
            r23 = r2
            r26 = r3
        L_0x07da:
            if (r14 != 0) goto L_0x07e1
            java.util.Set<java.lang.Integer> r0 = r10.zzb
            r0.add(r4)
        L_0x07e1:
            r0 = r22
            r2 = r23
            r3 = r26
            goto L_0x0759
        L_0x07e9:
            r4 = r67
            r30 = r13
            r2 = r24
            r11 = r25
        L_0x07f1:
            r13 = 0
            goto L_0x0590
        L_0x07f4:
            boolean r0 = r68.isEmpty()
            if (r0 == 0) goto L_0x07fe
        L_0x07fa:
            r11 = r27
            goto L_0x0a17
        L_0x07fe:
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap
            r2.<init>()
            java.util.Iterator r3 = r68.iterator()
        L_0x0807:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x07fa
            java.lang.Object r0 = r3.next()
            r4 = r0
            com.google.android.gms.internal.measurement.zzgh r4 = (com.google.android.gms.internal.measurement.zzgh) r4
            java.lang.String r5 = r4.zzc()
            java.lang.Object r0 = r2.get(r5)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L_0x08f7
            com.google.android.gms.measurement.internal.zzkn r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzai r6 = r0.zzi()
            java.lang.String r7 = r10.zza
            r6.zzZ()
            r6.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap
            r8.<init>()
            android.database.sqlite.SQLiteDatabase r13 = r6.zze()
            r11 = r27
            r9 = r29
            java.lang.String[] r15 = new java.lang.String[]{r11, r9}     // Catch:{ SQLiteException -> 0x08cf, all -> 0x08cc }
            java.lang.String[] r17 = new java.lang.String[]{r7, r5}     // Catch:{ SQLiteException -> 0x08cf, all -> 0x08cc }
            java.lang.String r14 = "property_filters"
            java.lang.String r16 = "app_id=? AND property_name=?"
            r19 = 0
            r20 = 0
            r18 = 0
            android.database.Cursor r13 = r13.query(r14, r15, r16, r17, r18, r19, r20)     // Catch:{ SQLiteException -> 0x08cf, all -> 0x08cc }
            boolean r0 = r13.moveToFirst()     // Catch:{ SQLiteException -> 0x08c8 }
            if (r0 == 0) goto L_0x08ba
        L_0x085d:
            r14 = 1
            byte[] r0 = r13.getBlob(r14)     // Catch:{ SQLiteException -> 0x08c8 }
            com.google.android.gms.internal.measurement.zzer r15 = com.google.android.gms.internal.measurement.zzes.zzi()     // Catch:{ IOException -> 0x0894 }
            com.google.android.gms.internal.measurement.zzlh r0 = com.google.android.gms.measurement.internal.zzkp.zzt(r15, r0)     // Catch:{ IOException -> 0x0894 }
            com.google.android.gms.internal.measurement.zzer r0 = (com.google.android.gms.internal.measurement.zzer) r0     // Catch:{ IOException -> 0x0894 }
            com.google.android.gms.internal.measurement.zzkd r0 = r0.zzaA()     // Catch:{ IOException -> 0x0894 }
            com.google.android.gms.internal.measurement.zzes r0 = (com.google.android.gms.internal.measurement.zzes) r0     // Catch:{ IOException -> 0x0894 }
            r15 = 0
            int r16 = r13.getInt(r15)     // Catch:{ SQLiteException -> 0x08c8 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x08c8 }
            java.lang.Object r16 = r8.get(r14)     // Catch:{ SQLiteException -> 0x08c8 }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x08c8 }
            if (r16 != 0) goto L_0x088c
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x08c8 }
            r15.<init>()     // Catch:{ SQLiteException -> 0x08c8 }
            r8.put(r14, r15)     // Catch:{ SQLiteException -> 0x08c8 }
            goto L_0x088e
        L_0x088c:
            r15 = r16
        L_0x088e:
            r15.add(r0)     // Catch:{ SQLiteException -> 0x08c8 }
            r67 = r3
            goto L_0x08aa
        L_0x0894:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfu r14 = r6.zzs     // Catch:{ SQLiteException -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzem r14 = r14.zzau()     // Catch:{ SQLiteException -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzek r14 = r14.zzb()     // Catch:{ SQLiteException -> 0x08c8 }
            java.lang.String r15 = "Failed to merge filter"
            r67 = r3
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzem.zzl(r7)     // Catch:{ SQLiteException -> 0x08c6 }
            r14.zzc(r15, r3, r0)     // Catch:{ SQLiteException -> 0x08c6 }
        L_0x08aa:
            boolean r0 = r13.moveToNext()     // Catch:{ SQLiteException -> 0x08c6 }
            if (r0 != 0) goto L_0x08b7
            if (r13 == 0) goto L_0x08b5
            r13.close()
        L_0x08b5:
            r0 = r8
            goto L_0x08eb
        L_0x08b7:
            r3 = r67
            goto L_0x085d
        L_0x08ba:
            r67 = r3
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x08c6 }
            if (r13 == 0) goto L_0x08eb
        L_0x08c2:
            r13.close()
            goto L_0x08eb
        L_0x08c6:
            r0 = move-exception
            goto L_0x08d3
        L_0x08c8:
            r0 = move-exception
            r67 = r3
            goto L_0x08d3
        L_0x08cc:
            r0 = move-exception
            r5 = 0
            goto L_0x08f1
        L_0x08cf:
            r0 = move-exception
            r67 = r3
            r13 = 0
        L_0x08d3:
            com.google.android.gms.measurement.internal.zzfu r3 = r6.zzs     // Catch:{ all -> 0x08ef }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzau()     // Catch:{ all -> 0x08ef }
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzb()     // Catch:{ all -> 0x08ef }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzem.zzl(r7)     // Catch:{ all -> 0x08ef }
            r3.zzc(r12, r6, r0)     // Catch:{ all -> 0x08ef }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x08ef }
            if (r13 == 0) goto L_0x08eb
            goto L_0x08c2
        L_0x08eb:
            r2.put(r5, r0)
            goto L_0x08fd
        L_0x08ef:
            r0 = move-exception
            r5 = r13
        L_0x08f1:
            if (r5 == 0) goto L_0x08f6
            r5.close()
        L_0x08f6:
            throw r0
        L_0x08f7:
            r67 = r3
            r11 = r27
            r9 = r29
        L_0x08fd:
            java.util.Set r3 = r0.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x0905:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0a0f
            java.lang.Object r5 = r3.next()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r6 = r5.intValue()
            java.util.Set<java.lang.Integer> r7 = r10.zzb
            boolean r7 = r7.contains(r5)
            if (r7 == 0) goto L_0x092c
            com.google.android.gms.measurement.internal.zzfu r0 = r10.zzs
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzk()
            r0.zzb(r1, r5)
            goto L_0x0a0f
        L_0x092c:
            java.lang.Object r7 = r0.get(r5)
            java.util.List r7 = (java.util.List) r7
            java.util.Iterator r7 = r7.iterator()
            r13 = 1
        L_0x0937:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0a02
            java.lang.Object r8 = r7.next()
            com.google.android.gms.internal.measurement.zzes r8 = (com.google.android.gms.internal.measurement.zzes) r8
            com.google.android.gms.measurement.internal.zzfu r13 = r10.zzs
            com.google.android.gms.measurement.internal.zzem r13 = r13.zzau()
            java.lang.String r13 = r13.zzn()
            r14 = 2
            boolean r13 = android.util.Log.isLoggable(r13, r14)
            if (r13 == 0) goto L_0x099d
            com.google.android.gms.measurement.internal.zzfu r13 = r10.zzs
            com.google.android.gms.measurement.internal.zzem r13 = r13.zzau()
            com.google.android.gms.measurement.internal.zzek r13 = r13.zzk()
            boolean r14 = r8.zza()
            if (r14 == 0) goto L_0x096d
            int r14 = r8.zzb()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            goto L_0x096e
        L_0x096d:
            r14 = 0
        L_0x096e:
            com.google.android.gms.measurement.internal.zzfu r15 = r10.zzs
            com.google.android.gms.measurement.internal.zzeh r15 = r15.zzm()
            r68 = r0
            java.lang.String r0 = r8.zzc()
            java.lang.String r0 = r15.zze(r0)
            java.lang.String r15 = "Evaluating filter. audience, filter, property"
            r13.zzd(r15, r5, r14, r0)
            com.google.android.gms.measurement.internal.zzfu r0 = r10.zzs
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzk()
            com.google.android.gms.measurement.internal.zzkn r13 = r10.zzf
            com.google.android.gms.measurement.internal.zzkp r13 = r13.zzm()
            java.lang.String r13 = r13.zzj(r8)
            java.lang.String r14 = "Filter definition"
            r0.zzb(r14, r13)
            goto L_0x099f
        L_0x099d:
            r68 = r0
        L_0x099f:
            boolean r0 = r8.zza()
            if (r0 == 0) goto L_0x09d8
            int r0 = r8.zzb()
            r13 = 256(0x100, float:3.59E-43)
            if (r0 <= r13) goto L_0x09ae
            goto L_0x09d8
        L_0x09ae:
            com.google.android.gms.measurement.internal.zzx r0 = new com.google.android.gms.measurement.internal.zzx
            java.lang.String r13 = r10.zza
            r0.<init>(r10, r13, r6, r8)
            java.lang.Long r13 = r10.zzd
            java.lang.Long r14 = r10.zze
            int r8 = r8.zzb()
            boolean r8 = r10.zzd(r6, r8)
            boolean r13 = r0.zzd(r13, r14, r4, r8)
            if (r13 == 0) goto L_0x09d2
            com.google.android.gms.measurement.internal.zzt r8 = r10.zzc(r5)
            r8.zza(r0)
            r0 = r68
            goto L_0x0937
        L_0x09d2:
            java.util.Set<java.lang.Integer> r0 = r10.zzb
            r0.add(r5)
            goto L_0x0a04
        L_0x09d8:
            com.google.android.gms.measurement.internal.zzfu r0 = r10.zzs
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()
            com.google.android.gms.measurement.internal.zzek r0 = r0.zze()
            java.lang.String r6 = r10.zza
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzem.zzl(r6)
            boolean r7 = r8.zza()
            if (r7 == 0) goto L_0x09f7
            int r7 = r8.zzb()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L_0x09f8
        L_0x09f7:
            r7 = 0
        L_0x09f8:
            java.lang.String r8 = "Invalid property filter ID. appId, id"
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r0.zzc(r8, r6, r7)
            goto L_0x0a06
        L_0x0a02:
            r68 = r0
        L_0x0a04:
            if (r13 != 0) goto L_0x0a0b
        L_0x0a06:
            java.util.Set<java.lang.Integer> r0 = r10.zzb
            r0.add(r5)
        L_0x0a0b:
            r0 = r68
            goto L_0x0905
        L_0x0a0f:
            r3 = r67
            r29 = r9
            r27 = r11
            goto L_0x0807
        L_0x0a17:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Map<java.lang.Integer, com.google.android.gms.measurement.internal.zzt> r0 = r10.zzc
            java.util.Set r0 = r0.keySet()
            java.util.Set<java.lang.Integer> r2 = r10.zzb
            r0.removeAll(r2)
            java.util.Iterator r2 = r0.iterator()
        L_0x0a2b:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0abc
            java.lang.Object r0 = r2.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r3 = r0.intValue()
            java.util.Map<java.lang.Integer, com.google.android.gms.measurement.internal.zzt> r4 = r10.zzc
            java.lang.Object r4 = r4.get(r0)
            com.google.android.gms.measurement.internal.zzt r4 = (com.google.android.gms.measurement.internal.zzt) r4
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            com.google.android.gms.internal.measurement.zzfk r3 = r4.zzb(r3)
            r1.add(r3)
            com.google.android.gms.measurement.internal.zzkn r4 = r10.zzf
            com.google.android.gms.measurement.internal.zzai r4 = r4.zzi()
            java.lang.String r5 = r10.zza
            com.google.android.gms.internal.measurement.zzgd r3 = r3.zzc()
            r4.zzZ()
            r4.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)
            byte[] r3 = r3.zzbp()
            android.content.ContentValues r6 = new android.content.ContentValues
            r6.<init>()
            java.lang.String r7 = "app_id"
            r6.put(r7, r5)
            r6.put(r11, r0)
            r7 = r25
            r6.put(r7, r3)
            android.database.sqlite.SQLiteDatabase r0 = r4.zze()     // Catch:{ SQLiteException -> 0x0aa3 }
            java.lang.String r3 = "audience_filter_values"
            r8 = 5
            r9 = 0
            long r12 = r0.insertWithOnConflict(r3, r9, r6, r8)     // Catch:{ SQLiteException -> 0x0aa1 }
            r14 = -1
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 != 0) goto L_0x0ab8
            com.google.android.gms.measurement.internal.zzfu r0 = r4.zzs     // Catch:{ SQLiteException -> 0x0aa1 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ SQLiteException -> 0x0aa1 }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzb()     // Catch:{ SQLiteException -> 0x0aa1 }
            java.lang.String r3 = "Failed to insert filter results (got -1). appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzem.zzl(r5)     // Catch:{ SQLiteException -> 0x0aa1 }
            r0.zzb(r3, r6)     // Catch:{ SQLiteException -> 0x0aa1 }
            goto L_0x0ab8
        L_0x0aa1:
            r0 = move-exception
            goto L_0x0aa5
        L_0x0aa3:
            r0 = move-exception
            r9 = 0
        L_0x0aa5:
            com.google.android.gms.measurement.internal.zzfu r3 = r4.zzs
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzau()
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzb()
            java.lang.String r4 = "Error storing filter results. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzem.zzl(r5)
            r3.zzc(r4, r5, r0)
        L_0x0ab8:
            r25 = r7
            goto L_0x0a2b
        L_0x0abc:
            return r1
        L_0x0abd:
            r0 = move-exception
            r5 = r4
        L_0x0abf:
            if (r5 == 0) goto L_0x0ac4
            r5.close()
        L_0x0ac4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzy.zzb(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }
}
