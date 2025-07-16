package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteDatabase;
import java.io.File;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
public final class zzaj {
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        if (r2 == false) goto L_0x003b;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0078 A[Catch:{ all -> 0x00de, SQLiteException -> 0x00e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b3 A[Catch:{ all -> 0x00de, SQLiteException -> 0x00e3 }, LOOP:1: B:31:0x00b3->B:36:0x00c5, LOOP_START, PHI: r1 
      PHI: (r1v8 int) = (r1v7 int), (r1v9 int) binds: [B:30:0x00b1, B:36:0x00c5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ce A[Catch:{ all -> 0x00de, SQLiteException -> 0x00e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[Catch:{  }, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void zza(com.google.android.gms.measurement.internal.zzem r10, android.database.sqlite.SQLiteDatabase r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String[] r15) throws android.database.sqlite.SQLiteException {
        /*
            if (r10 == 0) goto L_0x00f6
            r0 = 0
            java.lang.String r1 = "name"
            java.lang.String[] r4 = new java.lang.String[]{r1}     // Catch:{ SQLiteException -> 0x002a, all -> 0x0027 }
            java.lang.String[] r6 = new java.lang.String[]{r12}     // Catch:{ SQLiteException -> 0x002a, all -> 0x0027 }
            java.lang.String r3 = "SQLITE_MASTER"
            java.lang.String r5 = "name=?"
            r8 = 0
            r9 = 0
            r7 = 0
            r2 = r11
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x002a, all -> 0x0027 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0025 }
            if (r1 == 0) goto L_0x0022
            r1.close()
        L_0x0022:
            if (r2 != 0) goto L_0x003e
            goto L_0x003b
        L_0x0025:
            r2 = move-exception
            goto L_0x002d
        L_0x0027:
            r10 = move-exception
            goto L_0x00f0
        L_0x002a:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L_0x002d:
            com.google.android.gms.measurement.internal.zzek r3 = r10.zze()     // Catch:{ all -> 0x00ee }
            java.lang.String r4 = "Error querying for table"
            r3.zzc(r4, r12, r2)     // Catch:{ all -> 0x00ee }
            if (r1 == 0) goto L_0x003b
            r1.close()
        L_0x003b:
            r11.execSQL(r13)
        L_0x003e:
            java.util.HashSet r13 = new java.util.HashSet     // Catch:{ SQLiteException -> 0x00e3 }
            r13.<init>()     // Catch:{ SQLiteException -> 0x00e3 }
            int r1 = r12.length()     // Catch:{ SQLiteException -> 0x00e3 }
            int r1 = r1 + 22
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00e3 }
            r2.<init>(r1)     // Catch:{ SQLiteException -> 0x00e3 }
            java.lang.String r1 = "SELECT * FROM "
            r2.append(r1)     // Catch:{ SQLiteException -> 0x00e3 }
            r2.append(r12)     // Catch:{ SQLiteException -> 0x00e3 }
            java.lang.String r1 = " LIMIT 0"
            r2.append(r1)     // Catch:{ SQLiteException -> 0x00e3 }
            java.lang.String r1 = r2.toString()     // Catch:{ SQLiteException -> 0x00e3 }
            android.database.Cursor r0 = r11.rawQuery(r1, r0)     // Catch:{ SQLiteException -> 0x00e3 }
            java.lang.String[] r1 = r0.getColumnNames()     // Catch:{ all -> 0x00de }
            java.util.Collections.addAll(r13, r1)     // Catch:{ all -> 0x00de }
            r0.close()     // Catch:{ SQLiteException -> 0x00e3 }
            java.lang.String r0 = ","
            java.lang.String[] r14 = r14.split(r0)     // Catch:{ SQLiteException -> 0x00e3 }
            int r0 = r14.length     // Catch:{ SQLiteException -> 0x00e3 }
            r1 = 0
            r2 = r1
        L_0x0076:
            if (r2 >= r0) goto L_0x00b1
            r3 = r14[r2]     // Catch:{ SQLiteException -> 0x00e3 }
            boolean r4 = r13.remove(r3)     // Catch:{ SQLiteException -> 0x00e3 }
            if (r4 == 0) goto L_0x0083
            int r2 = r2 + 1
            goto L_0x0076
        L_0x0083:
            android.database.sqlite.SQLiteException r11 = new android.database.sqlite.SQLiteException     // Catch:{ SQLiteException -> 0x00e3 }
            int r13 = r12.length()     // Catch:{ SQLiteException -> 0x00e3 }
            int r13 = r13 + 35
            java.lang.String r14 = java.lang.String.valueOf(r3)     // Catch:{ SQLiteException -> 0x00e3 }
            int r14 = r14.length()     // Catch:{ SQLiteException -> 0x00e3 }
            int r13 = r13 + r14
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00e3 }
            r14.<init>(r13)     // Catch:{ SQLiteException -> 0x00e3 }
            java.lang.String r13 = "Table "
            r14.append(r13)     // Catch:{ SQLiteException -> 0x00e3 }
            r14.append(r12)     // Catch:{ SQLiteException -> 0x00e3 }
            java.lang.String r13 = " is missing required column: "
            r14.append(r13)     // Catch:{ SQLiteException -> 0x00e3 }
            r14.append(r3)     // Catch:{ SQLiteException -> 0x00e3 }
            java.lang.String r13 = r14.toString()     // Catch:{ SQLiteException -> 0x00e3 }
            r11.<init>(r13)     // Catch:{ SQLiteException -> 0x00e3 }
            throw r11     // Catch:{ SQLiteException -> 0x00e3 }
        L_0x00b1:
            if (r15 == 0) goto L_0x00c8
        L_0x00b3:
            int r14 = r15.length     // Catch:{ SQLiteException -> 0x00e3 }
            if (r1 >= r14) goto L_0x00c8
            r14 = r15[r1]     // Catch:{ SQLiteException -> 0x00e3 }
            boolean r14 = r13.remove(r14)     // Catch:{ SQLiteException -> 0x00e3 }
            if (r14 != 0) goto L_0x00c5
            int r14 = r1 + 1
            r14 = r15[r14]     // Catch:{ SQLiteException -> 0x00e3 }
            r11.execSQL(r14)     // Catch:{ SQLiteException -> 0x00e3 }
        L_0x00c5:
            int r1 = r1 + 2
            goto L_0x00b3
        L_0x00c8:
            boolean r11 = r13.isEmpty()     // Catch:{ SQLiteException -> 0x00e3 }
            if (r11 != 0) goto L_0x00dd
            com.google.android.gms.measurement.internal.zzek r11 = r10.zze()     // Catch:{ SQLiteException -> 0x00e3 }
            java.lang.String r14 = "Table has extra columns. table, columns"
            java.lang.String r15 = ", "
            java.lang.String r13 = android.text.TextUtils.join(r15, r13)     // Catch:{ SQLiteException -> 0x00e3 }
            r11.zzc(r14, r12, r13)     // Catch:{ SQLiteException -> 0x00e3 }
        L_0x00dd:
            return
        L_0x00de:
            r11 = move-exception
            r0.close()     // Catch:{ SQLiteException -> 0x00e3 }
            throw r11     // Catch:{ SQLiteException -> 0x00e3 }
        L_0x00e3:
            r11 = move-exception
            com.google.android.gms.measurement.internal.zzek r10 = r10.zzb()
            java.lang.String r13 = "Failed to verify columns on table that was just created"
            r10.zzb(r13, r12)
            throw r11
        L_0x00ee:
            r10 = move-exception
            r0 = r1
        L_0x00f0:
            if (r0 == 0) goto L_0x00f5
            r0.close()
        L_0x00f5:
            throw r10
        L_0x00f6:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "Monitor must not be null"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaj.zza(com.google.android.gms.measurement.internal.zzem, android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    static void zzb(zzem zzem, SQLiteDatabase sQLiteDatabase) {
        if (zzem != null) {
            File file = new File(sQLiteDatabase.getPath());
            if (!file.setReadable(false, false)) {
                zzem.zze().zza("Failed to turn off database read permission");
            }
            if (!file.setWritable(false, false)) {
                zzem.zze().zza("Failed to turn off database write permission");
            }
            if (!file.setReadable(true, true)) {
                zzem.zze().zza("Failed to turn on database read permission for owner");
            }
            if (!file.setWritable(true, true)) {
                zzem.zze().zza("Failed to turn on database write permission for owner");
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Monitor must not be null");
    }
}
