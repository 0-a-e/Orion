package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzfo;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
final class zzu {
    final /* synthetic */ zzy zza;
    private zzfo zzb;
    private Long zzc;
    private long zzd;

    /* synthetic */ zzu(zzy zzy, zzs zzs) {
        this.zza = zzy;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d9, code lost:
        if (r8 == null) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f3, code lost:
        if (r8 != null) goto L_0x00f5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzfo zza(java.lang.String r14, com.google.android.gms.internal.measurement.zzfo r15) {
        /*
            r13 = this;
            java.lang.String r0 = r15.zzd()
            java.util.List r1 = r15.zza()
            com.google.android.gms.measurement.internal.zzy r2 = r13.zza
            com.google.android.gms.measurement.internal.zzkn r2 = r2.zzf
            r2.zzm()
            java.lang.String r2 = "_eid"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzkp.zzB(r15, r2)
            r6 = r3
            java.lang.Long r6 = (java.lang.Long) r6
            if (r6 == 0) goto L_0x022a
            java.lang.String r3 = "_ep"
            boolean r3 = r0.equals(r3)
            r4 = 0
            if (r3 == 0) goto L_0x01de
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)
            com.google.android.gms.measurement.internal.zzy r0 = r13.zza
            com.google.android.gms.measurement.internal.zzkn r0 = r0.zzf
            r0.zzm()
            java.lang.String r0 = "_en"
            java.lang.Object r0 = com.google.android.gms.measurement.internal.zzkp.zzB(r15, r0)
            java.lang.String r0 = (java.lang.String) r0
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            r7 = 0
            if (r3 == 0) goto L_0x004f
            com.google.android.gms.measurement.internal.zzy r14 = r13.zza
            com.google.android.gms.measurement.internal.zzfu r14 = r14.zzs
            com.google.android.gms.measurement.internal.zzem r14 = r14.zzau()
            com.google.android.gms.measurement.internal.zzek r14 = r14.zzc()
            java.lang.String r15 = "Extra parameter without an event name. eventId"
            r14.zzb(r15, r6)
            return r7
        L_0x004f:
            com.google.android.gms.internal.measurement.zzfo r3 = r13.zzb
            if (r3 == 0) goto L_0x0065
            java.lang.Long r3 = r13.zzc
            if (r3 == 0) goto L_0x0065
            long r8 = r6.longValue()
            java.lang.Long r3 = r13.zzc
            long r10 = r3.longValue()
            int r3 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r3 == 0) goto L_0x0122
        L_0x0065:
            com.google.android.gms.measurement.internal.zzy r3 = r13.zza
            com.google.android.gms.measurement.internal.zzkn r3 = r3.zzf
            com.google.android.gms.measurement.internal.zzai r3 = r3.zzi()
            r3.zzg()
            r3.zzZ()
            android.database.sqlite.SQLiteDatabase r8 = r3.zze()     // Catch:{ SQLiteException -> 0x00e1, all -> 0x00de }
            java.lang.String r9 = java.lang.String.valueOf(r6)     // Catch:{ SQLiteException -> 0x00e1, all -> 0x00de }
            java.lang.String[] r9 = new java.lang.String[]{r14, r9}     // Catch:{ SQLiteException -> 0x00e1, all -> 0x00de }
            java.lang.String r10 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            android.database.Cursor r8 = r8.rawQuery(r10, r9)     // Catch:{ SQLiteException -> 0x00e1, all -> 0x00de }
            boolean r9 = r8.moveToFirst()     // Catch:{ SQLiteException -> 0x00dc }
            if (r9 != 0) goto L_0x009d
            com.google.android.gms.measurement.internal.zzfu r9 = r3.zzs     // Catch:{ SQLiteException -> 0x00dc }
            com.google.android.gms.measurement.internal.zzem r9 = r9.zzau()     // Catch:{ SQLiteException -> 0x00dc }
            com.google.android.gms.measurement.internal.zzek r9 = r9.zzk()     // Catch:{ SQLiteException -> 0x00dc }
            java.lang.String r10 = "Main event not found"
            r9.zza(r10)     // Catch:{ SQLiteException -> 0x00dc }
            if (r8 == 0) goto L_0x00f8
            goto L_0x00f5
        L_0x009d:
            r9 = 0
            byte[] r9 = r8.getBlob(r9)     // Catch:{ SQLiteException -> 0x00dc }
            r10 = 1
            long r10 = r8.getLong(r10)     // Catch:{ SQLiteException -> 0x00dc }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ SQLiteException -> 0x00dc }
            com.google.android.gms.internal.measurement.zzfn r11 = com.google.android.gms.internal.measurement.zzfo.zzk()     // Catch:{ IOException -> 0x00c5 }
            com.google.android.gms.internal.measurement.zzlh r9 = com.google.android.gms.measurement.internal.zzkp.zzt(r11, r9)     // Catch:{ IOException -> 0x00c5 }
            com.google.android.gms.internal.measurement.zzfn r9 = (com.google.android.gms.internal.measurement.zzfn) r9     // Catch:{ IOException -> 0x00c5 }
            com.google.android.gms.internal.measurement.zzkd r9 = r9.zzaA()     // Catch:{ IOException -> 0x00c5 }
            com.google.android.gms.internal.measurement.zzfo r9 = (com.google.android.gms.internal.measurement.zzfo) r9     // Catch:{ IOException -> 0x00c5 }
            android.util.Pair r3 = android.util.Pair.create(r9, r10)     // Catch:{ SQLiteException -> 0x00dc }
            if (r8 == 0) goto L_0x00f9
            r8.close()
            goto L_0x00f9
        L_0x00c5:
            r9 = move-exception
            com.google.android.gms.measurement.internal.zzfu r10 = r3.zzs     // Catch:{ SQLiteException -> 0x00dc }
            com.google.android.gms.measurement.internal.zzem r10 = r10.zzau()     // Catch:{ SQLiteException -> 0x00dc }
            com.google.android.gms.measurement.internal.zzek r10 = r10.zzb()     // Catch:{ SQLiteException -> 0x00dc }
            java.lang.String r11 = "Failed to merge main event. appId, eventId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzem.zzl(r14)     // Catch:{ SQLiteException -> 0x00dc }
            r10.zzd(r11, r12, r6, r9)     // Catch:{ SQLiteException -> 0x00dc }
            if (r8 == 0) goto L_0x00f8
            goto L_0x00f5
        L_0x00dc:
            r9 = move-exception
            goto L_0x00e4
        L_0x00de:
            r14 = move-exception
            goto L_0x01d8
        L_0x00e1:
            r8 = move-exception
            r9 = r8
            r8 = r7
        L_0x00e4:
            com.google.android.gms.measurement.internal.zzfu r3 = r3.zzs     // Catch:{ all -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzau()     // Catch:{ all -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzb()     // Catch:{ all -> 0x01d6 }
            java.lang.String r10 = "Error selecting main event"
            r3.zzb(r10, r9)     // Catch:{ all -> 0x01d6 }
            if (r8 == 0) goto L_0x00f8
        L_0x00f5:
            r8.close()
        L_0x00f8:
            r3 = r7
        L_0x00f9:
            if (r3 == 0) goto L_0x01c4
            java.lang.Object r8 = r3.first
            if (r8 != 0) goto L_0x0101
            goto L_0x01c4
        L_0x0101:
            java.lang.Object r7 = r3.first
            com.google.android.gms.internal.measurement.zzfo r7 = (com.google.android.gms.internal.measurement.zzfo) r7
            r13.zzb = r7
            java.lang.Object r3 = r3.second
            java.lang.Long r3 = (java.lang.Long) r3
            long r7 = r3.longValue()
            r13.zzd = r7
            com.google.android.gms.measurement.internal.zzy r3 = r13.zza
            com.google.android.gms.measurement.internal.zzkn r3 = r3.zzf
            r3.zzm()
            com.google.android.gms.internal.measurement.zzfo r3 = r13.zzb
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzkp.zzB(r3, r2)
            java.lang.Long r2 = (java.lang.Long) r2
            r13.zzc = r2
        L_0x0122:
            long r2 = r13.zzd
            r7 = -1
            long r2 = r2 + r7
            r13.zzd = r2
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x0166
            com.google.android.gms.measurement.internal.zzy r2 = r13.zza
            com.google.android.gms.measurement.internal.zzkn r2 = r2.zzf
            com.google.android.gms.measurement.internal.zzai r2 = r2.zzi()
            r2.zzg()
            com.google.android.gms.measurement.internal.zzfu r3 = r2.zzs
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzau()
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzk()
            java.lang.String r4 = "Clearing complex main event info. appId"
            r3.zzb(r4, r14)
            android.database.sqlite.SQLiteDatabase r3 = r2.zze()     // Catch:{ SQLiteException -> 0x0155 }
            java.lang.String[] r14 = new java.lang.String[]{r14}     // Catch:{ SQLiteException -> 0x0155 }
            java.lang.String r4 = "delete from main_event_params where app_id=?"
            r3.execSQL(r4, r14)     // Catch:{ SQLiteException -> 0x0155 }
            goto L_0x0176
        L_0x0155:
            r14 = move-exception
            com.google.android.gms.measurement.internal.zzfu r2 = r2.zzs
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()
            java.lang.String r3 = "Error clearing complex main event"
            r2.zzb(r3, r14)
            goto L_0x0176
        L_0x0166:
            com.google.android.gms.measurement.internal.zzy r2 = r13.zza
            com.google.android.gms.measurement.internal.zzkn r2 = r2.zzf
            com.google.android.gms.measurement.internal.zzai r4 = r2.zzi()
            long r7 = r13.zzd
            com.google.android.gms.internal.measurement.zzfo r9 = r13.zzb
            r5 = r14
            r4.zzJ(r5, r6, r7, r9)
        L_0x0176:
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            com.google.android.gms.internal.measurement.zzfo r2 = r13.zzb
            java.util.List r2 = r2.zza()
            java.util.Iterator r2 = r2.iterator()
        L_0x0185:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x01a6
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzfs r3 = (com.google.android.gms.internal.measurement.zzfs) r3
            com.google.android.gms.measurement.internal.zzy r4 = r13.zza
            com.google.android.gms.measurement.internal.zzkn r4 = r4.zzf
            r4.zzm()
            java.lang.String r4 = r3.zzb()
            com.google.android.gms.internal.measurement.zzfs r4 = com.google.android.gms.measurement.internal.zzkp.zzA(r15, r4)
            if (r4 != 0) goto L_0x0185
            r14.add(r3)
            goto L_0x0185
        L_0x01a6:
            boolean r2 = r14.isEmpty()
            if (r2 != 0) goto L_0x01b2
            r14.addAll(r1)
            r1 = r14
            goto L_0x022a
        L_0x01b2:
            com.google.android.gms.measurement.internal.zzy r14 = r13.zza
            com.google.android.gms.measurement.internal.zzfu r14 = r14.zzs
            com.google.android.gms.measurement.internal.zzem r14 = r14.zzau()
            com.google.android.gms.measurement.internal.zzek r14 = r14.zzc()
            java.lang.String r2 = "No unique parameters in main event. eventName"
            r14.zzb(r2, r0)
            goto L_0x022a
        L_0x01c4:
            com.google.android.gms.measurement.internal.zzy r14 = r13.zza
            com.google.android.gms.measurement.internal.zzfu r14 = r14.zzs
            com.google.android.gms.measurement.internal.zzem r14 = r14.zzau()
            com.google.android.gms.measurement.internal.zzek r14 = r14.zzc()
            java.lang.String r15 = "Extra parameter without existing main event. eventName, eventId"
            r14.zzc(r15, r0, r6)
            return r7
        L_0x01d6:
            r14 = move-exception
            r7 = r8
        L_0x01d8:
            if (r7 == 0) goto L_0x01dd
            r7.close()
        L_0x01dd:
            throw r14
        L_0x01de:
            r13.zzc = r6
            r13.zzb = r15
            com.google.android.gms.measurement.internal.zzy r2 = r13.zza
            com.google.android.gms.measurement.internal.zzkn r2 = r2.zzf
            r2.zzm()
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            java.lang.String r3 = "_epc"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzkp.zzB(r15, r3)
            if (r3 == 0) goto L_0x01f6
            r2 = r3
        L_0x01f6:
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r13.zzd = r2
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x0214
            com.google.android.gms.measurement.internal.zzy r14 = r13.zza
            com.google.android.gms.measurement.internal.zzfu r14 = r14.zzs
            com.google.android.gms.measurement.internal.zzem r14 = r14.zzau()
            com.google.android.gms.measurement.internal.zzek r14 = r14.zzc()
            java.lang.String r2 = "Complex event with zero extra param count. eventName"
            r14.zzb(r2, r0)
            goto L_0x022a
        L_0x0214:
            com.google.android.gms.measurement.internal.zzy r2 = r13.zza
            com.google.android.gms.measurement.internal.zzkn r2 = r2.zzf
            com.google.android.gms.measurement.internal.zzai r7 = r2.zzi()
            java.lang.Object r2 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)
            r9 = r2
            java.lang.Long r9 = (java.lang.Long) r9
            long r10 = r13.zzd
            r8 = r14
            r12 = r15
            r7.zzJ(r8, r9, r10, r12)
        L_0x022a:
            com.google.android.gms.internal.measurement.zzjz r14 = r15.zzbu()
            com.google.android.gms.internal.measurement.zzfn r14 = (com.google.android.gms.internal.measurement.zzfn) r14
            r14.zzl(r0)
            r14.zzi()
            r14.zzh(r1)
            com.google.android.gms.internal.measurement.zzkd r14 = r14.zzaA()
            com.google.android.gms.internal.measurement.zzfo r14 = (com.google.android.gms.internal.measurement.zzfo) r14
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzu.zza(java.lang.String, com.google.android.gms.internal.measurement.zzfo):com.google.android.gms.internal.measurement.zzfo");
    }
}
