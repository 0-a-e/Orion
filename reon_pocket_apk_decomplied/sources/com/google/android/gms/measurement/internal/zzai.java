package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzov;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
final class zzai extends zzke {
    /* access modifiers changed from: private */
    public static final String[] zza = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzb = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zzc = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zzd = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zze = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */
    public static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */
    public static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzah zzj;
    /* access modifiers changed from: private */
    public final zzka zzk = new zzka(this.zzs.zzay());

    zzai(zzkn zzkn) {
        super(zzkn);
        this.zzs.zzc();
        this.zzj = new zzah(this, this.zzs.zzax(), "google_app_measurement.db");
    }

    static final void zzX(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty("value");
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put("value", (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    private final long zzab(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = zze().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            this.zzs.zzau().zzb().zzc("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long zzac(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = zze().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j2 = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j2;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return j;
        } catch (SQLiteException e) {
            this.zzs.zzau().zzb().zzc("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzA() {
        zzg();
        zzZ();
        if (zzM()) {
            long zza2 = this.zzf.zzn().zza.zza();
            long elapsedRealtime = this.zzs.zzay().elapsedRealtime();
            long abs = Math.abs(elapsedRealtime - zza2);
            this.zzs.zzc();
            if (abs > zzea.zzx.zzb(null).longValue()) {
                this.zzf.zzn().zza.zzb(elapsedRealtime);
                zzg();
                zzZ();
                if (zzM()) {
                    SQLiteDatabase zze2 = zze();
                    String valueOf = String.valueOf(this.zzs.zzay().currentTimeMillis());
                    this.zzs.zzc();
                    int delete = zze2.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{valueOf, String.valueOf(zzae.zzA())});
                    if (delete > 0) {
                        this.zzs.zzau().zzk().zzb("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzB(List<Long> list) {
        zzg();
        zzZ();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzM()) {
            String join = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 80);
            sb3.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb3.append(sb2);
            sb3.append(" AND retry_count =  2147483647 LIMIT 1");
            if (zzab(sb3.toString(), (String[]) null) > 0) {
                this.zzs.zzau().zze().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase zze2 = zze();
                StringBuilder sb4 = new StringBuilder(String.valueOf(sb2).length() + WorkQueueKt.MASK);
                sb4.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb4.append(sb2);
                sb4.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                zze2.execSQL(sb4.toString());
            } catch (SQLiteException e) {
                this.zzs.zzau().zzb().zzb("Error incrementing retry count. error", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Object zzC(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            this.zzs.zzau().zzb().zza("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i));
            }
            if (type == 3) {
                return cursor.getString(i);
            }
            if (type != 4) {
                this.zzs.zzau().zzb().zzb("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            this.zzs.zzau().zzb().zza("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    public final long zzD() {
        return zzac("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public final long zzE(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty("first_open_count");
        zzg();
        zzZ();
        SQLiteDatabase zze2 = zze();
        zze2.beginTransaction();
        long j = 0;
        try {
            StringBuilder sb = new StringBuilder(48);
            sb.append("select first_open_count from app2 where app_id=?");
            long zzac = zzac(sb.toString(), new String[]{str}, -1);
            if (zzac == -1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("first_open_count", 0);
                contentValues.put("previous_install_count", 0);
                if (zze2.insertWithOnConflict("app2", (String) null, contentValues, 5) == -1) {
                    this.zzs.zzau().zzb().zzc("Failed to insert column (got -1). appId", zzem.zzl(str), "first_open_count");
                    zze2.endTransaction();
                    return -1;
                }
                zzac = 0;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put("first_open_count", Long.valueOf(1 + zzac));
                if (((long) zze2.update("app2", contentValues2, "app_id = ?", new String[]{str})) == 0) {
                    this.zzs.zzau().zzb().zzc("Failed to update column (got 0). appId", zzem.zzl(str), "first_open_count");
                    zze2.endTransaction();
                    return -1;
                }
                zze2.setTransactionSuccessful();
                zze2.endTransaction();
                return zzac;
            } catch (SQLiteException e) {
                e = e;
                j = zzac;
                try {
                    this.zzs.zzau().zzb().zzd("Error inserting column. appId", zzem.zzl(str), "first_open_count", e);
                    zze2.endTransaction();
                    return j;
                } catch (Throwable th) {
                    zze2.endTransaction();
                    throw th;
                }
            }
        } catch (SQLiteException e2) {
            e = e2;
            this.zzs.zzau().zzb().zzd("Error inserting column. appId", zzem.zzl(str), "first_open_count", e);
            zze2.endTransaction();
            return j;
        }
    }

    public final long zzF() {
        return zzac("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public final boolean zzG() {
        return zzab("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean zzH() {
        return zzab("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    public final long zzI(String str) {
        Preconditions.checkNotEmpty(str);
        return zzac("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    public final boolean zzJ(String str, Long l, long j, zzfo zzfo) {
        zzg();
        zzZ();
        Preconditions.checkNotNull(zzfo);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] zzbp = zzfo.zzbp();
        this.zzs.zzau().zzk().zzc("Saving complex main event, appId, data size", this.zzs.zzm().zzc(str), Integer.valueOf(zzbp.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", zzbp);
        try {
            if (zze().insertWithOnConflict("main_event_params", (String) null, contentValues, 5) != -1) {
                return true;
            }
            this.zzs.zzau().zzb().zzb("Failed to insert complex main event (got -1). appId", zzem.zzl(str));
            return false;
        } catch (SQLiteException e) {
            this.zzs.zzau().zzb().zzc("Error storing complex main event. appId", zzem.zzl(str), e);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zzK(java.lang.String r8) {
        /*
            r7 = this;
            r7.zzg()
            r7.zzZ()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.zze()     // Catch:{ SQLiteException -> 0x00c3, all -> 0x00c1 }
            java.lang.String[] r2 = new java.lang.String[]{r8}     // Catch:{ SQLiteException -> 0x00c3, all -> 0x00c1 }
            java.lang.String r3 = "select parameters from default_event_params where app_id=?"
            android.database.Cursor r1 = r1.rawQuery(r3, r2)     // Catch:{ SQLiteException -> 0x00c3, all -> 0x00c1 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x00bf }
            if (r2 != 0) goto L_0x0030
            com.google.android.gms.measurement.internal.zzfu r8 = r7.zzs     // Catch:{ SQLiteException -> 0x00bf }
            com.google.android.gms.measurement.internal.zzem r8 = r8.zzau()     // Catch:{ SQLiteException -> 0x00bf }
            com.google.android.gms.measurement.internal.zzek r8 = r8.zzk()     // Catch:{ SQLiteException -> 0x00bf }
            java.lang.String r2 = "Default event parameters not found"
            r8.zza(r2)     // Catch:{ SQLiteException -> 0x00bf }
            if (r1 == 0) goto L_0x002f
            r1.close()
        L_0x002f:
            return r0
        L_0x0030:
            r2 = 0
            byte[] r2 = r1.getBlob(r2)     // Catch:{ SQLiteException -> 0x00bf }
            com.google.android.gms.internal.measurement.zzfn r3 = com.google.android.gms.internal.measurement.zzfo.zzk()     // Catch:{ IOException -> 0x00a5 }
            com.google.android.gms.internal.measurement.zzlh r2 = com.google.android.gms.measurement.internal.zzkp.zzt(r3, r2)     // Catch:{ IOException -> 0x00a5 }
            com.google.android.gms.internal.measurement.zzfn r2 = (com.google.android.gms.internal.measurement.zzfn) r2     // Catch:{ IOException -> 0x00a5 }
            com.google.android.gms.internal.measurement.zzkd r2 = r2.zzaA()     // Catch:{ IOException -> 0x00a5 }
            com.google.android.gms.internal.measurement.zzfo r2 = (com.google.android.gms.internal.measurement.zzfo) r2     // Catch:{ IOException -> 0x00a5 }
            com.google.android.gms.measurement.internal.zzkn r8 = r7.zzf     // Catch:{ SQLiteException -> 0x00bf }
            r8.zzm()     // Catch:{ SQLiteException -> 0x00bf }
            java.util.List r8 = r2.zza()     // Catch:{ SQLiteException -> 0x00bf }
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ SQLiteException -> 0x00bf }
            r2.<init>()     // Catch:{ SQLiteException -> 0x00bf }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ SQLiteException -> 0x00bf }
        L_0x0057:
            boolean r3 = r8.hasNext()     // Catch:{ SQLiteException -> 0x00bf }
            if (r3 == 0) goto L_0x009f
            java.lang.Object r3 = r8.next()     // Catch:{ SQLiteException -> 0x00bf }
            com.google.android.gms.internal.measurement.zzfs r3 = (com.google.android.gms.internal.measurement.zzfs) r3     // Catch:{ SQLiteException -> 0x00bf }
            java.lang.String r4 = r3.zzb()     // Catch:{ SQLiteException -> 0x00bf }
            boolean r5 = r3.zzi()     // Catch:{ SQLiteException -> 0x00bf }
            if (r5 == 0) goto L_0x0075
            double r5 = r3.zzj()     // Catch:{ SQLiteException -> 0x00bf }
            r2.putDouble(r4, r5)     // Catch:{ SQLiteException -> 0x00bf }
            goto L_0x0057
        L_0x0075:
            boolean r5 = r3.zzg()     // Catch:{ SQLiteException -> 0x00bf }
            if (r5 == 0) goto L_0x0083
            float r3 = r3.zzh()     // Catch:{ SQLiteException -> 0x00bf }
            r2.putFloat(r4, r3)     // Catch:{ SQLiteException -> 0x00bf }
            goto L_0x0057
        L_0x0083:
            boolean r5 = r3.zzc()     // Catch:{ SQLiteException -> 0x00bf }
            if (r5 == 0) goto L_0x0091
            java.lang.String r3 = r3.zzd()     // Catch:{ SQLiteException -> 0x00bf }
            r2.putString(r4, r3)     // Catch:{ SQLiteException -> 0x00bf }
            goto L_0x0057
        L_0x0091:
            boolean r5 = r3.zze()     // Catch:{ SQLiteException -> 0x00bf }
            if (r5 == 0) goto L_0x0057
            long r5 = r3.zzf()     // Catch:{ SQLiteException -> 0x00bf }
            r2.putLong(r4, r5)     // Catch:{ SQLiteException -> 0x00bf }
            goto L_0x0057
        L_0x009f:
            if (r1 == 0) goto L_0x00a4
            r1.close()
        L_0x00a4:
            return r2
        L_0x00a5:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzfu r3 = r7.zzs     // Catch:{ SQLiteException -> 0x00bf }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzau()     // Catch:{ SQLiteException -> 0x00bf }
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzb()     // Catch:{ SQLiteException -> 0x00bf }
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzem.zzl(r8)     // Catch:{ SQLiteException -> 0x00bf }
            r3.zzc(r4, r8, r2)     // Catch:{ SQLiteException -> 0x00bf }
            if (r1 == 0) goto L_0x00be
            r1.close()
        L_0x00be:
            return r0
        L_0x00bf:
            r8 = move-exception
            goto L_0x00c5
        L_0x00c1:
            r8 = move-exception
            goto L_0x00dc
        L_0x00c3:
            r8 = move-exception
            r1 = r0
        L_0x00c5:
            com.google.android.gms.measurement.internal.zzfu r2 = r7.zzs     // Catch:{ all -> 0x00da }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ all -> 0x00da }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ all -> 0x00da }
            java.lang.String r3 = "Error selecting default event parameters"
            r2.zzb(r3, r8)     // Catch:{ all -> 0x00da }
            if (r1 == 0) goto L_0x00d9
            r1.close()
        L_0x00d9:
            return r0
        L_0x00da:
            r8 = move-exception
            r0 = r1
        L_0x00dc:
            if (r0 == 0) goto L_0x00e1
            r0.close()
        L_0x00e1:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzK(java.lang.String):android.os.Bundle");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0334, code lost:
        r10.put("session_scoped", r11);
        r10.put(com.google.firebase.messaging.Constants.ScionAnalytics.MessageType.DATA_MESSAGE, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0348, code lost:
        if (zze().insertWithOnConflict("property_filters", (java.lang.String) null, r10, 5) != -1) goto L_0x035e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x034a, code lost:
        r1.zzs.zzau().zzb().zzb("Failed to insert property filter (got -1). appId", com.google.android.gms.measurement.internal.zzem.zzl(r26));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x035e, code lost:
        r0 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0362, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:?, code lost:
        r1.zzs.zzau().zzb().zzc("Error storing property filter. appId", com.google.android.gms.measurement.internal.zzem.zzl(r26), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x03a0, code lost:
        r3 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0178, code lost:
        r10 = r0.zzc().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0184, code lost:
        if (r10.hasNext() == false) goto L_0x01ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0190, code lost:
        if (r10.next().zza() != false) goto L_0x0180;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0192, code lost:
        r1.zzs.zzau().zze().zzc("Property filter with no ID. Audience definition ignored. appId, audienceId", com.google.android.gms.measurement.internal.zzem.zzl(r26), java.lang.Integer.valueOf(r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01ab, code lost:
        r10 = r0.zzf().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01c1, code lost:
        if (r10.hasNext() == false) goto L_0x0297;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r11 = r10.next();
        zzZ();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r26);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01dd, code lost:
        if (android.text.TextUtils.isEmpty(r11.zzc()) == false) goto L_0x0211;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01df, code lost:
        r0 = r1.zzs.zzau().zze();
        r10 = com.google.android.gms.measurement.internal.zzem.zzl(r26);
        r12 = java.lang.Integer.valueOf(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01f7, code lost:
        if (r11.zza() == false) goto L_0x0204;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01f9, code lost:
        r16 = java.lang.Integer.valueOf(r11.zzb());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0204, code lost:
        r16 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0206, code lost:
        r0.zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r10, r12, java.lang.String.valueOf(r16));
        r21 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0211, code lost:
        r3 = r11.zzbp();
        r21 = r7;
        r7 = new android.content.ContentValues();
        r7.put("app_id", r2);
        r7.put("audience_id", java.lang.Integer.valueOf(r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x022a, code lost:
        if (r11.zza() == false) goto L_0x0235;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x022c, code lost:
        r8 = java.lang.Integer.valueOf(r11.zzb());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0235, code lost:
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0236, code lost:
        r7.put("filter_id", r8);
        r7.put("event_name", r11.zzc());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0246, code lost:
        if (r11.zzk() == false) goto L_0x0251;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0248, code lost:
        r8 = java.lang.Boolean.valueOf(r11.zzm());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0251, code lost:
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0252, code lost:
        r7.put("session_scoped", r8);
        r7.put(com.google.firebase.messaging.Constants.ScionAnalytics.MessageType.DATA_MESSAGE, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0266, code lost:
        if (zze().insertWithOnConflict("event_filters", (java.lang.String) null, r7, 5) != -1) goto L_0x027b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0268, code lost:
        r1.zzs.zzau().zzb().zzb("Failed to insert event filter (got -1). appId", com.google.android.gms.measurement.internal.zzem.zzl(r26));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x027b, code lost:
        r3 = r27;
        r7 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0297, code lost:
        r21 = r7;
        r0 = r0.zzc().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x02a5, code lost:
        if (r0.hasNext() == false) goto L_0x03a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x02a7, code lost:
        r3 = r0.next();
        zzZ();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r26);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x02c1, code lost:
        if (android.text.TextUtils.isEmpty(r3.zzc()) == false) goto L_0x02f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02c3, code lost:
        r0 = r1.zzs.zzau().zze();
        r8 = com.google.android.gms.measurement.internal.zzem.zzl(r26);
        r10 = java.lang.Integer.valueOf(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x02db, code lost:
        if (r3.zza() == false) goto L_0x02e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x02dd, code lost:
        r16 = java.lang.Integer.valueOf(r3.zzb());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x02e8, code lost:
        r16 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x02ea, code lost:
        r0.zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r8, r10, java.lang.String.valueOf(r16));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x02f3, code lost:
        r7 = r3.zzbp();
        r10 = new android.content.ContentValues();
        r10.put("app_id", r2);
        r10.put("audience_id", java.lang.Integer.valueOf(r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x030a, code lost:
        if (r3.zza() == false) goto L_0x0315;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x030c, code lost:
        r11 = java.lang.Integer.valueOf(r3.zzb());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0315, code lost:
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0316, code lost:
        r10.put("filter_id", r11);
        r22 = r0;
        r10.put("property_name", r3.zzc());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0328, code lost:
        if (r3.zzg() == false) goto L_0x0333;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x032a, code lost:
        r11 = java.lang.Boolean.valueOf(r3.zzh());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0333, code lost:
        r11 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzL(java.lang.String r26, java.util.List<com.google.android.gms.internal.measurement.zzeh> r27) {
        /*
            r25 = this;
            r1 = r25
            r2 = r26
            r3 = r27
            java.lang.String r4 = "app_id=? and audience_id=?"
            java.lang.String r0 = "app_id=?"
            java.lang.String r5 = "event_filters"
            java.lang.String r6 = "property_filters"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r27)
            r8 = 0
        L_0x0012:
            int r9 = r27.size()
            if (r8 >= r9) goto L_0x00dc
            java.lang.Object r9 = r3.get(r8)
            com.google.android.gms.internal.measurement.zzeh r9 = (com.google.android.gms.internal.measurement.zzeh) r9
            com.google.android.gms.internal.measurement.zzjz r9 = r9.zzbu()
            com.google.android.gms.internal.measurement.zzeg r9 = (com.google.android.gms.internal.measurement.zzeg) r9
            int r10 = r9.zzd()
            if (r10 == 0) goto L_0x009d
            r10 = 0
        L_0x002b:
            int r11 = r9.zzd()
            if (r10 >= r11) goto L_0x009d
            com.google.android.gms.internal.measurement.zzej r11 = r9.zze(r10)
            com.google.android.gms.internal.measurement.zzjz r11 = r11.zzbu()
            com.google.android.gms.internal.measurement.zzei r11 = (com.google.android.gms.internal.measurement.zzei) r11
            com.google.android.gms.internal.measurement.zzjz r12 = r11.zzaq()
            com.google.android.gms.internal.measurement.zzei r12 = (com.google.android.gms.internal.measurement.zzei) r12
            java.lang.String r13 = r11.zza()
            java.lang.String r13 = com.google.android.gms.measurement.internal.zzgr.zzb(r13)
            if (r13 == 0) goto L_0x0050
            r12.zzb(r13)
            r13 = 1
            goto L_0x0051
        L_0x0050:
            r13 = 0
        L_0x0051:
            r15 = 0
        L_0x0052:
            int r14 = r11.zzc()
            if (r15 >= r14) goto L_0x0088
            com.google.android.gms.internal.measurement.zzel r14 = r11.zzd(r15)
            java.lang.String r7 = r14.zzh()
            r17 = r11
            java.lang.String[] r11 = com.google.android.gms.measurement.internal.zzgs.zza
            r18 = r4
            java.lang.String[] r4 = com.google.android.gms.measurement.internal.zzgs.zzb
            java.lang.String r4 = com.google.android.gms.measurement.internal.zzic.zzc(r7, r11, r4)
            if (r4 == 0) goto L_0x0081
            com.google.android.gms.internal.measurement.zzjz r7 = r14.zzbu()
            com.google.android.gms.internal.measurement.zzek r7 = (com.google.android.gms.internal.measurement.zzek) r7
            r7.zza(r4)
            com.google.android.gms.internal.measurement.zzkd r4 = r7.zzaA()
            com.google.android.gms.internal.measurement.zzel r4 = (com.google.android.gms.internal.measurement.zzel) r4
            r12.zze(r15, r4)
            r13 = 1
        L_0x0081:
            int r15 = r15 + 1
            r11 = r17
            r4 = r18
            goto L_0x0052
        L_0x0088:
            r18 = r4
            if (r13 == 0) goto L_0x0098
            r9.zzf(r10, r12)
            com.google.android.gms.internal.measurement.zzkd r4 = r9.zzaA()
            com.google.android.gms.internal.measurement.zzeh r4 = (com.google.android.gms.internal.measurement.zzeh) r4
            r3.set(r8, r4)
        L_0x0098:
            int r10 = r10 + 1
            r4 = r18
            goto L_0x002b
        L_0x009d:
            r18 = r4
            int r4 = r9.zza()
            if (r4 == 0) goto L_0x00d6
            r4 = 0
        L_0x00a6:
            int r7 = r9.zza()
            if (r4 >= r7) goto L_0x00d6
            com.google.android.gms.internal.measurement.zzes r7 = r9.zzb(r4)
            java.lang.String r10 = r7.zzc()
            java.lang.String[] r11 = com.google.android.gms.measurement.internal.zzgt.zza
            java.lang.String[] r12 = com.google.android.gms.measurement.internal.zzgt.zzb
            java.lang.String r10 = com.google.android.gms.measurement.internal.zzic.zzc(r10, r11, r12)
            if (r10 == 0) goto L_0x00d3
            com.google.android.gms.internal.measurement.zzjz r7 = r7.zzbu()
            com.google.android.gms.internal.measurement.zzer r7 = (com.google.android.gms.internal.measurement.zzer) r7
            r7.zza(r10)
            r9.zzc(r4, r7)
            com.google.android.gms.internal.measurement.zzkd r7 = r9.zzaA()
            com.google.android.gms.internal.measurement.zzeh r7 = (com.google.android.gms.internal.measurement.zzeh) r7
            r3.set(r8, r7)
        L_0x00d3:
            int r4 = r4 + 1
            goto L_0x00a6
        L_0x00d6:
            int r8 = r8 + 1
            r4 = r18
            goto L_0x0012
        L_0x00dc:
            r18 = r4
            r25.zzZ()
            r25.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r26)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r27)
            android.database.sqlite.SQLiteDatabase r4 = r25.zze()
            r4.beginTransaction()
            r25.zzZ()     // Catch:{ all -> 0x0495 }
            r25.zzg()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r26)     // Catch:{ all -> 0x0495 }
            android.database.sqlite.SQLiteDatabase r7 = r25.zze()     // Catch:{ all -> 0x0495 }
            java.lang.String[] r8 = new java.lang.String[]{r26}     // Catch:{ all -> 0x0495 }
            r7.delete(r6, r0, r8)     // Catch:{ all -> 0x0495 }
            java.lang.String[] r8 = new java.lang.String[]{r26}     // Catch:{ all -> 0x0495 }
            r7.delete(r5, r0, r8)     // Catch:{ all -> 0x0495 }
            java.util.Iterator r7 = r27.iterator()     // Catch:{ all -> 0x0495 }
        L_0x0110:
            boolean r0 = r7.hasNext()     // Catch:{ all -> 0x0495 }
            if (r0 == 0) goto L_0x03a6
            java.lang.Object r0 = r7.next()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.internal.measurement.zzeh r0 = (com.google.android.gms.internal.measurement.zzeh) r0     // Catch:{ all -> 0x0495 }
            r25.zzZ()     // Catch:{ all -> 0x0495 }
            r25.zzg()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r26)     // Catch:{ all -> 0x0495 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x0495 }
            boolean r9 = r0.zza()     // Catch:{ all -> 0x0495 }
            if (r9 != 0) goto L_0x0142
            com.google.android.gms.measurement.internal.zzfu r0 = r1.zzs     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zze()     // Catch:{ all -> 0x0495 }
            java.lang.String r8 = "Audience with no ID. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzem.zzl(r26)     // Catch:{ all -> 0x0495 }
            r0.zzb(r8, r9)     // Catch:{ all -> 0x0495 }
            goto L_0x0110
        L_0x0142:
            int r9 = r0.zzb()     // Catch:{ all -> 0x0495 }
            java.util.List r10 = r0.zzf()     // Catch:{ all -> 0x0495 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x0495 }
        L_0x014e:
            boolean r11 = r10.hasNext()     // Catch:{ all -> 0x0495 }
            if (r11 == 0) goto L_0x0178
            java.lang.Object r11 = r10.next()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.internal.measurement.zzej r11 = (com.google.android.gms.internal.measurement.zzej) r11     // Catch:{ all -> 0x0495 }
            boolean r11 = r11.zza()     // Catch:{ all -> 0x0495 }
            if (r11 != 0) goto L_0x014e
            com.google.android.gms.measurement.internal.zzfu r0 = r1.zzs     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zze()     // Catch:{ all -> 0x0495 }
            java.lang.String r8 = "Event filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzem.zzl(r26)     // Catch:{ all -> 0x0495 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0495 }
            r0.zzc(r8, r10, r9)     // Catch:{ all -> 0x0495 }
            goto L_0x0110
        L_0x0178:
            java.util.List r10 = r0.zzc()     // Catch:{ all -> 0x0495 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x0495 }
        L_0x0180:
            boolean r11 = r10.hasNext()     // Catch:{ all -> 0x0495 }
            if (r11 == 0) goto L_0x01ab
            java.lang.Object r11 = r10.next()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.internal.measurement.zzes r11 = (com.google.android.gms.internal.measurement.zzes) r11     // Catch:{ all -> 0x0495 }
            boolean r11 = r11.zza()     // Catch:{ all -> 0x0495 }
            if (r11 != 0) goto L_0x0180
            com.google.android.gms.measurement.internal.zzfu r0 = r1.zzs     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zze()     // Catch:{ all -> 0x0495 }
            java.lang.String r8 = "Property filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzem.zzl(r26)     // Catch:{ all -> 0x0495 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0495 }
            r0.zzc(r8, r10, r9)     // Catch:{ all -> 0x0495 }
            goto L_0x0110
        L_0x01ab:
            java.util.List r10 = r0.zzf()     // Catch:{ all -> 0x0495 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x0495 }
        L_0x01b3:
            boolean r11 = r10.hasNext()     // Catch:{ all -> 0x0495 }
            java.lang.String r15 = "data"
            java.lang.String r12 = "session_scoped"
            java.lang.String r13 = "filter_id"
            java.lang.String r8 = "audience_id"
            java.lang.String r14 = "app_id"
            if (r11 == 0) goto L_0x0297
            java.lang.Object r11 = r10.next()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.internal.measurement.zzej r11 = (com.google.android.gms.internal.measurement.zzej) r11     // Catch:{ all -> 0x0495 }
            r25.zzZ()     // Catch:{ all -> 0x0495 }
            r25.zzg()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r26)     // Catch:{ all -> 0x0495 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r11)     // Catch:{ all -> 0x0495 }
            java.lang.String r21 = r11.zzc()     // Catch:{ all -> 0x0495 }
            boolean r21 = android.text.TextUtils.isEmpty(r21)     // Catch:{ all -> 0x0495 }
            if (r21 == 0) goto L_0x0211
            com.google.android.gms.measurement.internal.zzfu r0 = r1.zzs     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zze()     // Catch:{ all -> 0x0495 }
            java.lang.String r8 = "Event filter had no event name. Audience definition ignored. appId, audienceId, filterId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzem.zzl(r26)     // Catch:{ all -> 0x0495 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0495 }
            boolean r13 = r11.zza()     // Catch:{ all -> 0x0495 }
            if (r13 == 0) goto L_0x0204
            int r11 = r11.zzb()     // Catch:{ all -> 0x0495 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0495 }
            r16 = r11
            goto L_0x0206
        L_0x0204:
            r16 = 0
        L_0x0206:
            java.lang.String r11 = java.lang.String.valueOf(r16)     // Catch:{ all -> 0x0495 }
            r0.zzd(r8, r10, r12, r11)     // Catch:{ all -> 0x0495 }
            r21 = r7
            goto L_0x0376
        L_0x0211:
            byte[] r3 = r11.zzbp()     // Catch:{ all -> 0x0495 }
            r21 = r7
            android.content.ContentValues r7 = new android.content.ContentValues     // Catch:{ all -> 0x0495 }
            r7.<init>()     // Catch:{ all -> 0x0495 }
            r7.put(r14, r2)     // Catch:{ all -> 0x0495 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0495 }
            r7.put(r8, r14)     // Catch:{ all -> 0x0495 }
            boolean r8 = r11.zza()     // Catch:{ all -> 0x0495 }
            if (r8 == 0) goto L_0x0235
            int r8 = r11.zzb()     // Catch:{ all -> 0x0495 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0495 }
            goto L_0x0236
        L_0x0235:
            r8 = 0
        L_0x0236:
            r7.put(r13, r8)     // Catch:{ all -> 0x0495 }
            java.lang.String r8 = "event_name"
            java.lang.String r13 = r11.zzc()     // Catch:{ all -> 0x0495 }
            r7.put(r8, r13)     // Catch:{ all -> 0x0495 }
            boolean r8 = r11.zzk()     // Catch:{ all -> 0x0495 }
            if (r8 == 0) goto L_0x0251
            boolean r8 = r11.zzm()     // Catch:{ all -> 0x0495 }
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch:{ all -> 0x0495 }
            goto L_0x0252
        L_0x0251:
            r8 = 0
        L_0x0252:
            r7.put(r12, r8)     // Catch:{ all -> 0x0495 }
            r7.put(r15, r3)     // Catch:{ all -> 0x0495 }
            android.database.sqlite.SQLiteDatabase r3 = r25.zze()     // Catch:{ SQLiteException -> 0x0281 }
            r8 = 5
            r11 = 0
            long r7 = r3.insertWithOnConflict(r5, r11, r7, r8)     // Catch:{ SQLiteException -> 0x0281 }
            r11 = -1
            int r3 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r3 != 0) goto L_0x027b
            com.google.android.gms.measurement.internal.zzfu r3 = r1.zzs     // Catch:{ SQLiteException -> 0x0281 }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzau()     // Catch:{ SQLiteException -> 0x0281 }
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzb()     // Catch:{ SQLiteException -> 0x0281 }
            java.lang.String r7 = "Failed to insert event filter (got -1). appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzem.zzl(r26)     // Catch:{ SQLiteException -> 0x0281 }
            r3.zzb(r7, r8)     // Catch:{ SQLiteException -> 0x0281 }
        L_0x027b:
            r3 = r27
            r7 = r21
            goto L_0x01b3
        L_0x0281:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfu r3 = r1.zzs     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzau()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzb()     // Catch:{ all -> 0x0495 }
            java.lang.String r7 = "Error storing event filter. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzem.zzl(r26)     // Catch:{ all -> 0x0495 }
            r3.zzc(r7, r8, r0)     // Catch:{ all -> 0x0495 }
            goto L_0x0376
        L_0x0297:
            r21 = r7
            java.util.List r0 = r0.zzc()     // Catch:{ all -> 0x0495 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0495 }
        L_0x02a1:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x0495 }
            if (r3 == 0) goto L_0x03a0
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.internal.measurement.zzes r3 = (com.google.android.gms.internal.measurement.zzes) r3     // Catch:{ all -> 0x0495 }
            r25.zzZ()     // Catch:{ all -> 0x0495 }
            r25.zzg()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r26)     // Catch:{ all -> 0x0495 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x0495 }
            java.lang.String r7 = r3.zzc()     // Catch:{ all -> 0x0495 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0495 }
            if (r7 == 0) goto L_0x02f3
            com.google.android.gms.measurement.internal.zzfu r0 = r1.zzs     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zze()     // Catch:{ all -> 0x0495 }
            java.lang.String r7 = "Property filter had no property name. Audience definition ignored. appId, audienceId, filterId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzem.zzl(r26)     // Catch:{ all -> 0x0495 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0495 }
            boolean r11 = r3.zza()     // Catch:{ all -> 0x0495 }
            if (r11 == 0) goto L_0x02e8
            int r3 = r3.zzb()     // Catch:{ all -> 0x0495 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0495 }
            r16 = r3
            goto L_0x02ea
        L_0x02e8:
            r16 = 0
        L_0x02ea:
            java.lang.String r3 = java.lang.String.valueOf(r16)     // Catch:{ all -> 0x0495 }
            r0.zzd(r7, r8, r10, r3)     // Catch:{ all -> 0x0495 }
            goto L_0x0376
        L_0x02f3:
            byte[] r7 = r3.zzbp()     // Catch:{ all -> 0x0495 }
            android.content.ContentValues r10 = new android.content.ContentValues     // Catch:{ all -> 0x0495 }
            r10.<init>()     // Catch:{ all -> 0x0495 }
            r10.put(r14, r2)     // Catch:{ all -> 0x0495 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0495 }
            r10.put(r8, r11)     // Catch:{ all -> 0x0495 }
            boolean r11 = r3.zza()     // Catch:{ all -> 0x0495 }
            if (r11 == 0) goto L_0x0315
            int r11 = r3.zzb()     // Catch:{ all -> 0x0495 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0495 }
            goto L_0x0316
        L_0x0315:
            r11 = 0
        L_0x0316:
            r10.put(r13, r11)     // Catch:{ all -> 0x0495 }
            java.lang.String r11 = "property_name"
            r22 = r0
            java.lang.String r0 = r3.zzc()     // Catch:{ all -> 0x0495 }
            r10.put(r11, r0)     // Catch:{ all -> 0x0495 }
            boolean r0 = r3.zzg()     // Catch:{ all -> 0x0495 }
            if (r0 == 0) goto L_0x0333
            boolean r0 = r3.zzh()     // Catch:{ all -> 0x0495 }
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x0495 }
            goto L_0x0334
        L_0x0333:
            r11 = 0
        L_0x0334:
            r10.put(r12, r11)     // Catch:{ all -> 0x0495 }
            r10.put(r15, r7)     // Catch:{ all -> 0x0495 }
            android.database.sqlite.SQLiteDatabase r0 = r25.zze()     // Catch:{ SQLiteException -> 0x0362 }
            r3 = 5
            r11 = 0
            long r23 = r0.insertWithOnConflict(r6, r11, r10, r3)     // Catch:{ SQLiteException -> 0x0362 }
            r19 = -1
            int r0 = (r23 > r19 ? 1 : (r23 == r19 ? 0 : -1))
            if (r0 != 0) goto L_0x035e
            com.google.android.gms.measurement.internal.zzfu r0 = r1.zzs     // Catch:{ SQLiteException -> 0x0362 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ SQLiteException -> 0x0362 }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzb()     // Catch:{ SQLiteException -> 0x0362 }
            java.lang.String r3 = "Failed to insert property filter (got -1). appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzem.zzl(r26)     // Catch:{ SQLiteException -> 0x0362 }
            r0.zzb(r3, r7)     // Catch:{ SQLiteException -> 0x0362 }
            goto L_0x0376
        L_0x035e:
            r0 = r22
            goto L_0x02a1
        L_0x0362:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfu r3 = r1.zzs     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzau()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzb()     // Catch:{ all -> 0x0495 }
            java.lang.String r7 = "Error storing property filter. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzem.zzl(r26)     // Catch:{ all -> 0x0495 }
            r3.zzc(r7, r8, r0)     // Catch:{ all -> 0x0495 }
        L_0x0376:
            r25.zzZ()     // Catch:{ all -> 0x0495 }
            r25.zzg()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r26)     // Catch:{ all -> 0x0495 }
            android.database.sqlite.SQLiteDatabase r0 = r25.zze()     // Catch:{ all -> 0x0495 }
            java.lang.String r3 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0495 }
            java.lang.String[] r3 = new java.lang.String[]{r2, r3}     // Catch:{ all -> 0x0495 }
            r7 = r18
            r0.delete(r6, r7, r3)     // Catch:{ all -> 0x0495 }
            java.lang.String r3 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0495 }
            java.lang.String[] r3 = new java.lang.String[]{r2, r3}     // Catch:{ all -> 0x0495 }
            r0.delete(r5, r7, r3)     // Catch:{ all -> 0x0495 }
            r3 = r27
            r18 = r7
            goto L_0x03a2
        L_0x03a0:
            r3 = r27
        L_0x03a2:
            r7 = r21
            goto L_0x0110
        L_0x03a6:
            r11 = 0
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0495 }
            r0.<init>()     // Catch:{ all -> 0x0495 }
            java.util.Iterator r3 = r27.iterator()     // Catch:{ all -> 0x0495 }
        L_0x03b0:
            boolean r5 = r3.hasNext()     // Catch:{ all -> 0x0495 }
            if (r5 == 0) goto L_0x03d0
            java.lang.Object r5 = r3.next()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.internal.measurement.zzeh r5 = (com.google.android.gms.internal.measurement.zzeh) r5     // Catch:{ all -> 0x0495 }
            boolean r6 = r5.zza()     // Catch:{ all -> 0x0495 }
            if (r6 == 0) goto L_0x03cb
            int r5 = r5.zzb()     // Catch:{ all -> 0x0495 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0495 }
            goto L_0x03cc
        L_0x03cb:
            r5 = r11
        L_0x03cc:
            r0.add(r5)     // Catch:{ all -> 0x0495 }
            goto L_0x03b0
        L_0x03d0:
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r26)     // Catch:{ all -> 0x0495 }
            r25.zzZ()     // Catch:{ all -> 0x0495 }
            r25.zzg()     // Catch:{ all -> 0x0495 }
            android.database.sqlite.SQLiteDatabase r3 = r25.zze()     // Catch:{ all -> 0x0495 }
            java.lang.String[] r5 = new java.lang.String[]{r26}     // Catch:{ SQLiteException -> 0x047a }
            java.lang.String r6 = "select count(1) from audience_filter_values where app_id=?"
            long r5 = r1.zzab(r6, r5)     // Catch:{ SQLiteException -> 0x047a }
            com.google.android.gms.measurement.internal.zzfu r7 = r1.zzs     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzae r7 = r7.zzc()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzea.zzE     // Catch:{ all -> 0x0495 }
            int r7 = r7.zzk(r2, r8)     // Catch:{ all -> 0x0495 }
            r8 = 2000(0x7d0, float:2.803E-42)
            int r7 = java.lang.Math.min(r8, r7)     // Catch:{ all -> 0x0495 }
            r8 = 0
            int r7 = java.lang.Math.max(r8, r7)     // Catch:{ all -> 0x0495 }
            long r9 = (long) r7     // Catch:{ all -> 0x0495 }
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 > 0) goto L_0x0405
            goto L_0x048e
        L_0x0405:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0495 }
            r5.<init>()     // Catch:{ all -> 0x0495 }
        L_0x040a:
            int r6 = r0.size()     // Catch:{ all -> 0x0495 }
            if (r8 >= r6) goto L_0x0426
            java.lang.Object r6 = r0.get(r8)     // Catch:{ all -> 0x0495 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ all -> 0x0495 }
            if (r6 == 0) goto L_0x048e
            int r6 = r6.intValue()     // Catch:{ all -> 0x0495 }
            java.lang.String r6 = java.lang.Integer.toString(r6)     // Catch:{ all -> 0x0495 }
            r5.add(r6)     // Catch:{ all -> 0x0495 }
            int r8 = r8 + 1
            goto L_0x040a
        L_0x0426:
            java.lang.String r0 = ","
            java.lang.String r0 = android.text.TextUtils.join(r0, r5)     // Catch:{ all -> 0x0495 }
            java.lang.String r5 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0495 }
            int r5 = r5.length()     // Catch:{ all -> 0x0495 }
            int r5 = r5 + 2
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0495 }
            r6.<init>(r5)     // Catch:{ all -> 0x0495 }
            java.lang.String r5 = "("
            r6.append(r5)     // Catch:{ all -> 0x0495 }
            r6.append(r0)     // Catch:{ all -> 0x0495 }
            java.lang.String r0 = ")"
            r6.append(r0)     // Catch:{ all -> 0x0495 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0495 }
            java.lang.String r5 = "audience_filter_values"
            java.lang.String r6 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0495 }
            int r6 = r6.length()     // Catch:{ all -> 0x0495 }
            int r6 = r6 + 140
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0495 }
            r8.<init>(r6)     // Catch:{ all -> 0x0495 }
            java.lang.String r6 = "audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in "
            r8.append(r6)     // Catch:{ all -> 0x0495 }
            r8.append(r0)     // Catch:{ all -> 0x0495 }
            java.lang.String r0 = " order by rowid desc limit -1 offset ?)"
            r8.append(r0)     // Catch:{ all -> 0x0495 }
            java.lang.String r0 = r8.toString()     // Catch:{ all -> 0x0495 }
            java.lang.String r6 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x0495 }
            java.lang.String[] r2 = new java.lang.String[]{r2, r6}     // Catch:{ all -> 0x0495 }
            r3.delete(r5, r0, r2)     // Catch:{ all -> 0x0495 }
            goto L_0x048e
        L_0x047a:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfu r3 = r1.zzs     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzau()     // Catch:{ all -> 0x0495 }
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzb()     // Catch:{ all -> 0x0495 }
            java.lang.String r5 = "Database error querying filters. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzem.zzl(r26)     // Catch:{ all -> 0x0495 }
            r3.zzc(r5, r2, r0)     // Catch:{ all -> 0x0495 }
        L_0x048e:
            r4.setTransactionSuccessful()     // Catch:{ all -> 0x0495 }
            r4.endTransaction()
            return
        L_0x0495:
            r0 = move-exception
            r4.endTransaction()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzL(java.lang.String, java.util.List):void");
    }

    /* access modifiers changed from: protected */
    public final boolean zzM() {
        Context zzax = this.zzs.zzax();
        this.zzs.zzc();
        return zzax.getDatabasePath("google_app_measurement.db").exists();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: type inference failed for: r3v16 */
    /* JADX WARNING: type inference failed for: r3v17 */
    /* JADX WARNING: type inference failed for: r3v18 */
    /* JADX WARNING: type inference failed for: r3v19 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:12:0x003b=Splitter:B:12:0x003b, B:29:0x008b=Splitter:B:29:0x008b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzW(java.lang.String r20, long r21, long r23, com.google.android.gms.measurement.internal.zzkm r25) {
        /*
            r19 = this;
            r1 = r19
            r2 = r25
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r25)
            r19.zzg()
            r19.zzZ()
            r3 = 0
            android.database.sqlite.SQLiteDatabase r0 = r19.zze()     // Catch:{ SQLiteException -> 0x0204, all -> 0x0202 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ SQLiteException -> 0x0204, all -> 0x0202 }
            r13 = 1
            java.lang.String r5 = ""
            r14 = -1
            r12 = 0
            if (r4 == 0) goto L_0x0076
            int r4 = (r23 > r14 ? 1 : (r23 == r14 ? 0 : -1))
            if (r4 == 0) goto L_0x002f
            java.lang.String r6 = java.lang.String.valueOf(r23)     // Catch:{ SQLiteException -> 0x0204, all -> 0x0202 }
            java.lang.String r7 = java.lang.String.valueOf(r21)     // Catch:{ SQLiteException -> 0x0204, all -> 0x0202 }
            java.lang.String[] r6 = new java.lang.String[]{r6, r7}     // Catch:{ SQLiteException -> 0x0204, all -> 0x0202 }
            goto L_0x0037
        L_0x002f:
            java.lang.String r6 = java.lang.String.valueOf(r21)     // Catch:{ SQLiteException -> 0x0204, all -> 0x0202 }
            java.lang.String[] r6 = new java.lang.String[]{r6}     // Catch:{ SQLiteException -> 0x0204, all -> 0x0202 }
        L_0x0037:
            if (r4 == 0) goto L_0x003b
            java.lang.String r5 = "rowid <= ? and "
        L_0x003b:
            int r4 = r5.length()     // Catch:{ SQLiteException -> 0x0204, all -> 0x0202 }
            int r4 = r4 + 148
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0204, all -> 0x0202 }
            r7.<init>(r4)     // Catch:{ SQLiteException -> 0x0204, all -> 0x0202 }
            java.lang.String r4 = "select app_id, metadata_fingerprint from raw_events where "
            r7.append(r4)     // Catch:{ SQLiteException -> 0x0204, all -> 0x0202 }
            r7.append(r5)     // Catch:{ SQLiteException -> 0x0204, all -> 0x0202 }
            java.lang.String r4 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r7.append(r4)     // Catch:{ SQLiteException -> 0x0204, all -> 0x0202 }
            java.lang.String r4 = r7.toString()     // Catch:{ SQLiteException -> 0x0204, all -> 0x0202 }
            android.database.Cursor r4 = r0.rawQuery(r4, r6)     // Catch:{ SQLiteException -> 0x0204, all -> 0x0202 }
            boolean r5 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0073 }
            if (r5 != 0) goto L_0x0067
            if (r4 == 0) goto L_0x0066
            r4.close()
        L_0x0066:
            return
        L_0x0067:
            java.lang.String r3 = r4.getString(r12)     // Catch:{ SQLiteException -> 0x0073 }
            java.lang.String r5 = r4.getString(r13)     // Catch:{ SQLiteException -> 0x0073 }
            r4.close()     // Catch:{ SQLiteException -> 0x0073 }
            goto L_0x00be
        L_0x0073:
            r0 = move-exception
            goto L_0x0206
        L_0x0076:
            int r4 = (r23 > r14 ? 1 : (r23 == r14 ? 0 : -1))
            if (r4 == 0) goto L_0x0083
            java.lang.String r6 = java.lang.String.valueOf(r23)     // Catch:{ SQLiteException -> 0x0204, all -> 0x0202 }
            java.lang.String[] r6 = new java.lang.String[]{r3, r6}     // Catch:{ SQLiteException -> 0x0204, all -> 0x0202 }
            goto L_0x0087
        L_0x0083:
            java.lang.String[] r6 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x0204, all -> 0x0202 }
        L_0x0087:
            if (r4 == 0) goto L_0x008b
            java.lang.String r5 = " and rowid <= ?"
        L_0x008b:
            int r4 = r5.length()     // Catch:{ SQLiteException -> 0x0204, all -> 0x0202 }
            int r4 = r4 + 84
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0204, all -> 0x0202 }
            r7.<init>(r4)     // Catch:{ SQLiteException -> 0x0204, all -> 0x0202 }
            java.lang.String r4 = "select metadata_fingerprint from raw_events where app_id = ?"
            r7.append(r4)     // Catch:{ SQLiteException -> 0x0204, all -> 0x0202 }
            r7.append(r5)     // Catch:{ SQLiteException -> 0x0204, all -> 0x0202 }
            java.lang.String r4 = " order by rowid limit 1;"
            r7.append(r4)     // Catch:{ SQLiteException -> 0x0204, all -> 0x0202 }
            java.lang.String r4 = r7.toString()     // Catch:{ SQLiteException -> 0x0204, all -> 0x0202 }
            android.database.Cursor r4 = r0.rawQuery(r4, r6)     // Catch:{ SQLiteException -> 0x0204, all -> 0x0202 }
            boolean r5 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0073 }
            if (r5 != 0) goto L_0x00b7
            if (r4 == 0) goto L_0x00b6
            r4.close()
        L_0x00b6:
            return
        L_0x00b7:
            java.lang.String r5 = r4.getString(r12)     // Catch:{ SQLiteException -> 0x0073 }
            r4.close()     // Catch:{ SQLiteException -> 0x0073 }
        L_0x00be:
            r16 = r4
            r11 = r5
            java.lang.String r4 = "metadata"
            java.lang.String[] r6 = new java.lang.String[]{r4}     // Catch:{ SQLiteException -> 0x01fe, all -> 0x01fa }
            java.lang.String[] r8 = new java.lang.String[]{r3, r11}     // Catch:{ SQLiteException -> 0x01fe, all -> 0x01fa }
            java.lang.String r5 = "raw_events_metadata"
            java.lang.String r7 = "app_id = ? and metadata_fingerprint = ?"
            java.lang.String r17 = "rowid"
            java.lang.String r18 = "2"
            r9 = 0
            r10 = 0
            r4 = r0
            r13 = r11
            r11 = r17
            r14 = r12
            r12 = r18
            android.database.Cursor r15 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ SQLiteException -> 0x01fe, all -> 0x01fa }
            boolean r4 = r15.moveToFirst()     // Catch:{ SQLiteException -> 0x01f7, all -> 0x01f4 }
            if (r4 != 0) goto L_0x00ff
            com.google.android.gms.measurement.internal.zzfu r0 = r1.zzs     // Catch:{ SQLiteException -> 0x01f7, all -> 0x01f4 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ SQLiteException -> 0x01f7, all -> 0x01f4 }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzb()     // Catch:{ SQLiteException -> 0x01f7, all -> 0x01f4 }
            java.lang.String r2 = "Raw event metadata record is missing. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzem.zzl(r3)     // Catch:{ SQLiteException -> 0x01f7, all -> 0x01f4 }
            r0.zzb(r2, r4)     // Catch:{ SQLiteException -> 0x01f7, all -> 0x01f4 }
            if (r15 == 0) goto L_0x00fe
            r15.close()
        L_0x00fe:
            return
        L_0x00ff:
            byte[] r4 = r15.getBlob(r14)     // Catch:{ SQLiteException -> 0x01f7, all -> 0x01f4 }
            com.google.android.gms.internal.measurement.zzfv r5 = com.google.android.gms.internal.measurement.zzfw.zzaj()     // Catch:{ IOException -> 0x01da }
            com.google.android.gms.internal.measurement.zzlh r4 = com.google.android.gms.measurement.internal.zzkp.zzt(r5, r4)     // Catch:{ IOException -> 0x01da }
            com.google.android.gms.internal.measurement.zzfv r4 = (com.google.android.gms.internal.measurement.zzfv) r4     // Catch:{ IOException -> 0x01da }
            com.google.android.gms.internal.measurement.zzkd r4 = r4.zzaA()     // Catch:{ IOException -> 0x01da }
            com.google.android.gms.internal.measurement.zzfw r4 = (com.google.android.gms.internal.measurement.zzfw) r4     // Catch:{ IOException -> 0x01da }
            boolean r5 = r15.moveToNext()     // Catch:{ SQLiteException -> 0x01f7, all -> 0x01f4 }
            if (r5 == 0) goto L_0x012c
            com.google.android.gms.measurement.internal.zzfu r5 = r1.zzs     // Catch:{ SQLiteException -> 0x01f7, all -> 0x01f4 }
            com.google.android.gms.measurement.internal.zzem r5 = r5.zzau()     // Catch:{ SQLiteException -> 0x01f7, all -> 0x01f4 }
            com.google.android.gms.measurement.internal.zzek r5 = r5.zze()     // Catch:{ SQLiteException -> 0x01f7, all -> 0x01f4 }
            java.lang.String r6 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzem.zzl(r3)     // Catch:{ SQLiteException -> 0x01f7, all -> 0x01f4 }
            r5.zzb(r6, r7)     // Catch:{ SQLiteException -> 0x01f7, all -> 0x01f4 }
        L_0x012c:
            r15.close()     // Catch:{ SQLiteException -> 0x01f7, all -> 0x01f4 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ SQLiteException -> 0x01f7, all -> 0x01f4 }
            r2.zza = r4     // Catch:{ SQLiteException -> 0x01f7, all -> 0x01f4 }
            r4 = -1
            int r4 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x0145
            java.lang.String r4 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            java.lang.String r5 = java.lang.String.valueOf(r23)     // Catch:{ SQLiteException -> 0x01f7, all -> 0x01f4 }
            java.lang.String[] r5 = new java.lang.String[]{r3, r13, r5}     // Catch:{ SQLiteException -> 0x01f7, all -> 0x01f4 }
            goto L_0x014b
        L_0x0145:
            java.lang.String r4 = "app_id = ? and metadata_fingerprint = ?"
            java.lang.String[] r5 = new java.lang.String[]{r3, r13}     // Catch:{ SQLiteException -> 0x01f7, all -> 0x01f4 }
        L_0x014b:
            r7 = r4
            r8 = r5
            java.lang.String r4 = "rowid"
            java.lang.String r5 = "name"
            java.lang.String r6 = "timestamp"
            java.lang.String r9 = "data"
            java.lang.String[] r6 = new java.lang.String[]{r4, r5, r6, r9}     // Catch:{ SQLiteException -> 0x01f7, all -> 0x01f4 }
            java.lang.String r5 = "raw_events"
            java.lang.String r11 = "rowid"
            r12 = 0
            r9 = 0
            r10 = 0
            r4 = r0
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ SQLiteException -> 0x01f7, all -> 0x01f4 }
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0073 }
            if (r0 == 0) goto L_0x01c1
        L_0x016b:
            long r5 = r4.getLong(r14)     // Catch:{ SQLiteException -> 0x0073 }
            r0 = 3
            byte[] r0 = r4.getBlob(r0)     // Catch:{ SQLiteException -> 0x0073 }
            com.google.android.gms.internal.measurement.zzfn r7 = com.google.android.gms.internal.measurement.zzfo.zzk()     // Catch:{ IOException -> 0x01a0 }
            com.google.android.gms.internal.measurement.zzlh r0 = com.google.android.gms.measurement.internal.zzkp.zzt(r7, r0)     // Catch:{ IOException -> 0x01a0 }
            com.google.android.gms.internal.measurement.zzfn r0 = (com.google.android.gms.internal.measurement.zzfn) r0     // Catch:{ IOException -> 0x01a0 }
            r7 = 1
            java.lang.String r8 = r4.getString(r7)     // Catch:{ SQLiteException -> 0x0073 }
            r0.zzl(r8)     // Catch:{ SQLiteException -> 0x0073 }
            r8 = 2
            long r8 = r4.getLong(r8)     // Catch:{ SQLiteException -> 0x0073 }
            r0.zzo(r8)     // Catch:{ SQLiteException -> 0x0073 }
            com.google.android.gms.internal.measurement.zzkd r0 = r0.zzaA()     // Catch:{ SQLiteException -> 0x0073 }
            com.google.android.gms.internal.measurement.zzfo r0 = (com.google.android.gms.internal.measurement.zzfo) r0     // Catch:{ SQLiteException -> 0x0073 }
            boolean r0 = r2.zza(r5, r0)     // Catch:{ SQLiteException -> 0x0073 }
            if (r0 != 0) goto L_0x01b5
            if (r4 == 0) goto L_0x019f
            r4.close()
        L_0x019f:
            return
        L_0x01a0:
            r0 = move-exception
            r7 = 1
            com.google.android.gms.measurement.internal.zzfu r5 = r1.zzs     // Catch:{ SQLiteException -> 0x0073 }
            com.google.android.gms.measurement.internal.zzem r5 = r5.zzau()     // Catch:{ SQLiteException -> 0x0073 }
            com.google.android.gms.measurement.internal.zzek r5 = r5.zzb()     // Catch:{ SQLiteException -> 0x0073 }
            java.lang.String r6 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzem.zzl(r3)     // Catch:{ SQLiteException -> 0x0073 }
            r5.zzc(r6, r8, r0)     // Catch:{ SQLiteException -> 0x0073 }
        L_0x01b5:
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x0073 }
            if (r0 != 0) goto L_0x016b
            if (r4 == 0) goto L_0x021e
            r4.close()
            return
        L_0x01c1:
            com.google.android.gms.measurement.internal.zzfu r0 = r1.zzs     // Catch:{ SQLiteException -> 0x0073 }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ SQLiteException -> 0x0073 }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zze()     // Catch:{ SQLiteException -> 0x0073 }
            java.lang.String r2 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzem.zzl(r3)     // Catch:{ SQLiteException -> 0x0073 }
            r0.zzb(r2, r5)     // Catch:{ SQLiteException -> 0x0073 }
            if (r4 == 0) goto L_0x01d9
            r4.close()
        L_0x01d9:
            return
        L_0x01da:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzs     // Catch:{ SQLiteException -> 0x01f7, all -> 0x01f4 }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ SQLiteException -> 0x01f7, all -> 0x01f4 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ SQLiteException -> 0x01f7, all -> 0x01f4 }
            java.lang.String r4 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzem.zzl(r3)     // Catch:{ SQLiteException -> 0x01f7, all -> 0x01f4 }
            r2.zzc(r4, r5, r0)     // Catch:{ SQLiteException -> 0x01f7, all -> 0x01f4 }
            if (r15 == 0) goto L_0x01f3
            r15.close()
        L_0x01f3:
            return
        L_0x01f4:
            r0 = move-exception
            r3 = r15
            goto L_0x0221
        L_0x01f7:
            r0 = move-exception
            r4 = r15
            goto L_0x0206
        L_0x01fa:
            r0 = move-exception
            r3 = r16
            goto L_0x0221
        L_0x01fe:
            r0 = move-exception
            r4 = r16
            goto L_0x0206
        L_0x0202:
            r0 = move-exception
            goto L_0x0221
        L_0x0204:
            r0 = move-exception
            r4 = r3
        L_0x0206:
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzs     // Catch:{ all -> 0x021f }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ all -> 0x021f }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ all -> 0x021f }
            java.lang.String r5 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzem.zzl(r3)     // Catch:{ all -> 0x021f }
            r2.zzc(r5, r3, r0)     // Catch:{ all -> 0x021f }
            if (r4 == 0) goto L_0x021e
            r4.close()
        L_0x021e:
            return
        L_0x021f:
            r0 = move-exception
            r3 = r4
        L_0x0221:
            if (r3 == 0) goto L_0x0226
            r3.close()
        L_0x0226:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzW(java.lang.String, long, long, com.google.android.gms.measurement.internal.zzkm):void");
    }

    /* access modifiers changed from: protected */
    public final boolean zzaA() {
        return false;
    }

    public final void zzb() {
        zzZ();
        zze().beginTransaction();
    }

    public final void zzc() {
        zzZ();
        zze().setTransactionSuccessful();
    }

    public final void zzd() {
        zzZ();
        zze().endTransaction();
    }

    /* access modifiers changed from: package-private */
    public final SQLiteDatabase zze() {
        zzg();
        try {
            return this.zzj.getWritableDatabase();
        } catch (SQLiteException e) {
            this.zzs.zzau().zze().zzb("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0137  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzao zzf(java.lang.String r30, java.lang.String r31) {
        /*
            r29 = this;
            r1 = r29
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r30)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r31)
            r29.zzg()
            r29.zzZ()
            java.util.ArrayList r0 = new java.util.ArrayList
            java.lang.String r9 = "last_exempt_from_sampling"
            java.lang.String r10 = "current_session_count"
            java.lang.String r2 = "lifetime_count"
            java.lang.String r3 = "current_bundle_count"
            java.lang.String r4 = "last_fire_timestamp"
            java.lang.String r5 = "last_bundled_timestamp"
            java.lang.String r6 = "last_bundled_day"
            java.lang.String r7 = "last_sampled_complex_event_id"
            java.lang.String r8 = "last_sampling_rate"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8, r9, r10}
            java.util.List r2 = java.util.Arrays.asList(r2)
            r0.<init>(r2)
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r29.zze()     // Catch:{ SQLiteException -> 0x010c, all -> 0x010a }
            r11 = 0
            java.lang.String[] r4 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x010c, all -> 0x010a }
            java.lang.Object[] r0 = r0.toArray(r4)     // Catch:{ SQLiteException -> 0x010c, all -> 0x010a }
            r5 = r0
            java.lang.String[] r5 = (java.lang.String[]) r5     // Catch:{ SQLiteException -> 0x010c, all -> 0x010a }
            java.lang.String[] r7 = new java.lang.String[]{r30, r31}     // Catch:{ SQLiteException -> 0x010c, all -> 0x010a }
            java.lang.String r4 = "events"
            java.lang.String r6 = "app_id=? and name=?"
            r9 = 0
            r10 = 0
            r8 = 0
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x010c, all -> 0x010a }
            boolean r0 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x0108 }
            if (r0 != 0) goto L_0x0057
            if (r3 == 0) goto L_0x0056
            r3.close()
        L_0x0056:
            return r2
        L_0x0057:
            long r15 = r3.getLong(r11)     // Catch:{ SQLiteException -> 0x0108 }
            r0 = 1
            long r17 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x0108 }
            r4 = 2
            long r21 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x0108 }
            r4 = 3
            boolean r5 = r3.isNull(r4)     // Catch:{ SQLiteException -> 0x0108 }
            r6 = 0
            if (r5 == 0) goto L_0x0071
            r23 = r6
            goto L_0x0077
        L_0x0071:
            long r4 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x0108 }
            r23 = r4
        L_0x0077:
            r4 = 4
            boolean r5 = r3.isNull(r4)     // Catch:{ SQLiteException -> 0x0108 }
            if (r5 == 0) goto L_0x0081
            r25 = r2
            goto L_0x008b
        L_0x0081:
            long r4 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x0108 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x0108 }
            r25 = r4
        L_0x008b:
            r4 = 5
            boolean r5 = r3.isNull(r4)     // Catch:{ SQLiteException -> 0x0108 }
            if (r5 == 0) goto L_0x0095
            r26 = r2
            goto L_0x009f
        L_0x0095:
            long r4 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x0108 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x0108 }
            r26 = r4
        L_0x009f:
            r4 = 6
            boolean r5 = r3.isNull(r4)     // Catch:{ SQLiteException -> 0x0108 }
            if (r5 == 0) goto L_0x00a9
            r27 = r2
            goto L_0x00b3
        L_0x00a9:
            long r4 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x0108 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x0108 }
            r27 = r4
        L_0x00b3:
            r4 = 7
            boolean r5 = r3.isNull(r4)     // Catch:{ SQLiteException -> 0x0108 }
            if (r5 != 0) goto L_0x00cc
            long r4 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x0108 }
            r8 = 1
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 != 0) goto L_0x00c5
            r11 = r0
        L_0x00c5:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r11)     // Catch:{ SQLiteException -> 0x0108 }
            r28 = r0
            goto L_0x00ce
        L_0x00cc:
            r28 = r2
        L_0x00ce:
            r0 = 8
            boolean r4 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x0108 }
            if (r4 == 0) goto L_0x00d9
            r19 = r6
            goto L_0x00df
        L_0x00d9:
            long r4 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x0108 }
            r19 = r4
        L_0x00df:
            com.google.android.gms.measurement.internal.zzao r0 = new com.google.android.gms.measurement.internal.zzao     // Catch:{ SQLiteException -> 0x0108 }
            r12 = r0
            r13 = r30
            r14 = r31
            r12.<init>(r13, r14, r15, r17, r19, r21, r23, r25, r26, r27, r28)     // Catch:{ SQLiteException -> 0x0108 }
            boolean r4 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x0108 }
            if (r4 == 0) goto L_0x0102
            com.google.android.gms.measurement.internal.zzfu r4 = r1.zzs     // Catch:{ SQLiteException -> 0x0108 }
            com.google.android.gms.measurement.internal.zzem r4 = r4.zzau()     // Catch:{ SQLiteException -> 0x0108 }
            com.google.android.gms.measurement.internal.zzek r4 = r4.zzb()     // Catch:{ SQLiteException -> 0x0108 }
            java.lang.String r5 = "Got multiple records for event aggregates, expected one. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzem.zzl(r30)     // Catch:{ SQLiteException -> 0x0108 }
            r4.zzb(r5, r6)     // Catch:{ SQLiteException -> 0x0108 }
        L_0x0102:
            if (r3 == 0) goto L_0x0107
            r3.close()
        L_0x0107:
            return r0
        L_0x0108:
            r0 = move-exception
            goto L_0x010e
        L_0x010a:
            r0 = move-exception
            goto L_0x0135
        L_0x010c:
            r0 = move-exception
            r3 = r2
        L_0x010e:
            com.google.android.gms.measurement.internal.zzfu r4 = r1.zzs     // Catch:{ all -> 0x0133 }
            com.google.android.gms.measurement.internal.zzem r4 = r4.zzau()     // Catch:{ all -> 0x0133 }
            com.google.android.gms.measurement.internal.zzek r4 = r4.zzb()     // Catch:{ all -> 0x0133 }
            java.lang.String r5 = "Error querying events. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzem.zzl(r30)     // Catch:{ all -> 0x0133 }
            com.google.android.gms.measurement.internal.zzfu r7 = r1.zzs     // Catch:{ all -> 0x0133 }
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzm()     // Catch:{ all -> 0x0133 }
            r8 = r31
            java.lang.String r7 = r7.zzc(r8)     // Catch:{ all -> 0x0133 }
            r4.zzd(r5, r6, r7, r0)     // Catch:{ all -> 0x0133 }
            if (r3 == 0) goto L_0x0132
            r3.close()
        L_0x0132:
            return r2
        L_0x0133:
            r0 = move-exception
            r2 = r3
        L_0x0135:
            if (r2 == 0) goto L_0x013a
            r2.close()
        L_0x013a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzf(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzao");
    }

    public final void zzh(zzao zzao) {
        Preconditions.checkNotNull(zzao);
        zzg();
        zzZ();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzao.zza);
        contentValues.put("name", zzao.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzao.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzao.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzao.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzao.zzg));
        contentValues.put("last_bundled_day", zzao.zzh);
        contentValues.put("last_sampled_complex_event_id", zzao.zzi);
        contentValues.put("last_sampling_rate", zzao.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzao.zze));
        Boolean bool = zzao.zzk;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (zze().insertWithOnConflict("events", (String) null, contentValues, 5) == -1) {
                this.zzs.zzau().zzb().zzb("Failed to insert/update event aggregates (got -1). appId", zzem.zzl(zzao.zza));
            }
        } catch (SQLiteException e) {
            this.zzs.zzau().zzb().zzc("Error storing event aggregates. appId", zzem.zzl(zzao.zza), e);
        }
    }

    public final void zzi(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzZ();
        try {
            zze().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            this.zzs.zzau().zzb().zzd("Error deleting user property. appId", zzem.zzl(str), this.zzs.zzm().zze(str2), e);
        }
    }

    public final boolean zzj(zzks zzks) {
        Preconditions.checkNotNull(zzks);
        zzg();
        zzZ();
        if (zzk(zzks.zza, zzks.zzc) == null) {
            if (zzku.zzh(zzks.zzc)) {
                if (zzab("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzks.zza}) >= ((long) this.zzs.zzc().zzl(zzks.zza, zzea.zzF, 25, 100))) {
                    return false;
                }
            } else if (!"_npa".equals(zzks.zzc)) {
                long zzab = zzab("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzks.zza, zzks.zzb});
                this.zzs.zzc();
                if (zzab >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzks.zza);
        contentValues.put("origin", zzks.zzb);
        contentValues.put("name", zzks.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zzks.zzd));
        zzX(contentValues, "value", zzks.zze);
        try {
            if (zze().insertWithOnConflict("user_attributes", (String) null, contentValues, 5) != -1) {
                return true;
            }
            this.zzs.zzau().zzb().zzb("Failed to insert/update user property (got -1). appId", zzem.zzl(zzks.zza));
            return true;
        } catch (SQLiteException e) {
            this.zzs.zzau().zzb().zzc("Error storing user property. appId", zzem.zzl(zzks.zza), e);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzks zzk(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r11)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            r10.zzg()
            r10.zzZ()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.zze()     // Catch:{ SQLiteException -> 0x0078, all -> 0x0076 }
            java.lang.String r2 = "set_timestamp"
            java.lang.String r3 = "value"
            java.lang.String r4 = "origin"
            java.lang.String[] r3 = new java.lang.String[]{r2, r3, r4}     // Catch:{ SQLiteException -> 0x0078, all -> 0x0076 }
            java.lang.String[] r5 = new java.lang.String[]{r11, r12}     // Catch:{ SQLiteException -> 0x0078, all -> 0x0076 }
            java.lang.String r2 = "user_attributes"
            java.lang.String r4 = "app_id=? and name=?"
            r7 = 0
            r8 = 0
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0078, all -> 0x0076 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0074 }
            if (r2 != 0) goto L_0x0036
            if (r1 == 0) goto L_0x0035
            r1.close()
        L_0x0035:
            return r0
        L_0x0036:
            r2 = 0
            long r7 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x0074 }
            r2 = 1
            java.lang.Object r9 = r10.zzC(r1, r2)     // Catch:{ SQLiteException -> 0x0074 }
            if (r9 != 0) goto L_0x0048
            if (r1 == 0) goto L_0x0047
            r1.close()
        L_0x0047:
            return r0
        L_0x0048:
            r2 = 2
            java.lang.String r5 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x0074 }
            com.google.android.gms.measurement.internal.zzks r2 = new com.google.android.gms.measurement.internal.zzks     // Catch:{ SQLiteException -> 0x0074 }
            r3 = r2
            r4 = r11
            r6 = r12
            r3.<init>(r4, r5, r6, r7, r9)     // Catch:{ SQLiteException -> 0x0074 }
            boolean r3 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0074 }
            if (r3 == 0) goto L_0x006e
            com.google.android.gms.measurement.internal.zzfu r3 = r10.zzs     // Catch:{ SQLiteException -> 0x0074 }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzau()     // Catch:{ SQLiteException -> 0x0074 }
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzb()     // Catch:{ SQLiteException -> 0x0074 }
            java.lang.String r4 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzem.zzl(r11)     // Catch:{ SQLiteException -> 0x0074 }
            r3.zzb(r4, r5)     // Catch:{ SQLiteException -> 0x0074 }
        L_0x006e:
            if (r1 == 0) goto L_0x0073
            r1.close()
        L_0x0073:
            return r2
        L_0x0074:
            r2 = move-exception
            goto L_0x007b
        L_0x0076:
            r11 = move-exception
            goto L_0x00a0
        L_0x0078:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L_0x007b:
            com.google.android.gms.measurement.internal.zzfu r3 = r10.zzs     // Catch:{ all -> 0x009e }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzau()     // Catch:{ all -> 0x009e }
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzb()     // Catch:{ all -> 0x009e }
            java.lang.String r4 = "Error querying user property. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzem.zzl(r11)     // Catch:{ all -> 0x009e }
            com.google.android.gms.measurement.internal.zzfu r5 = r10.zzs     // Catch:{ all -> 0x009e }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzm()     // Catch:{ all -> 0x009e }
            java.lang.String r12 = r5.zze(r12)     // Catch:{ all -> 0x009e }
            r3.zzd(r4, r11, r12, r2)     // Catch:{ all -> 0x009e }
            if (r1 == 0) goto L_0x009d
            r1.close()
        L_0x009d:
            return r0
        L_0x009e:
            r11 = move-exception
            r0 = r1
        L_0x00a0:
            if (r0 == 0) goto L_0x00a5
            r0.close()
        L_0x00a5:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzk(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzks");
    }

    public final List<zzks> zzl(String str) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzZ();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            this.zzs.zzc();
            Cursor query = zze().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, (String) null, (String) null, "rowid", "1000");
            if (query.moveToFirst()) {
                do {
                    String string = query.getString(0);
                    String string2 = query.getString(1);
                    if (string2 == null) {
                        string2 = "";
                    }
                    String str2 = string2;
                    long j = query.getLong(2);
                    Object zzC = zzC(query, 3);
                    if (zzC == null) {
                        this.zzs.zzau().zzb().zzb("Read invalid user property value, ignoring it. appId", zzem.zzl(str));
                    } else {
                        arrayList.add(new zzks(str, str2, string, j, zzC));
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return arrayList;
            }
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (SQLiteException e) {
            this.zzs.zzau().zzb().zzc("Error querying user properties. appId", zzem.zzl(str), e);
            List<zzks> emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0121 A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.zzks> zzm(java.lang.String r17, java.lang.String r18, java.lang.String r19) {
        /*
            r16 = this;
            r1 = r16
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r17)
            r16.zzg()
            r16.zzZ()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r10 = "1001"
            r11 = 0
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0103 }
            r12 = 3
            r2.<init>(r12)     // Catch:{ SQLiteException -> 0x0103 }
            r13 = r17
            r2.add(r13)     // Catch:{ SQLiteException -> 0x0101 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0101 }
            java.lang.String r4 = "app_id=?"
            r3.<init>(r4)     // Catch:{ SQLiteException -> 0x0101 }
            boolean r4 = android.text.TextUtils.isEmpty(r18)     // Catch:{ SQLiteException -> 0x0101 }
            if (r4 != 0) goto L_0x0036
            r14 = r18
            r2.add(r14)     // Catch:{ SQLiteException -> 0x00fd }
            java.lang.String r4 = " and origin=?"
            r3.append(r4)     // Catch:{ SQLiteException -> 0x00fd }
            goto L_0x0038
        L_0x0036:
            r14 = r18
        L_0x0038:
            boolean r4 = android.text.TextUtils.isEmpty(r19)     // Catch:{ SQLiteException -> 0x00fd }
            if (r4 != 0) goto L_0x0050
            java.lang.String r4 = java.lang.String.valueOf(r19)     // Catch:{ SQLiteException -> 0x00fd }
            java.lang.String r5 = "*"
            java.lang.String r4 = r4.concat(r5)     // Catch:{ SQLiteException -> 0x00fd }
            r2.add(r4)     // Catch:{ SQLiteException -> 0x00fd }
            java.lang.String r4 = " and name glob ?"
            r3.append(r4)     // Catch:{ SQLiteException -> 0x00fd }
        L_0x0050:
            int r4 = r2.size()     // Catch:{ SQLiteException -> 0x00fd }
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00fd }
            java.lang.Object[] r2 = r2.toArray(r4)     // Catch:{ SQLiteException -> 0x00fd }
            r6 = r2
            java.lang.String[] r6 = (java.lang.String[]) r6     // Catch:{ SQLiteException -> 0x00fd }
            android.database.sqlite.SQLiteDatabase r2 = r16.zze()     // Catch:{ SQLiteException -> 0x00fd }
            java.lang.String r4 = "user_attributes"
            java.lang.String r5 = "name"
            java.lang.String r7 = "set_timestamp"
            java.lang.String r8 = "value"
            java.lang.String r9 = "origin"
            java.lang.String[] r5 = new java.lang.String[]{r5, r7, r8, r9}     // Catch:{ SQLiteException -> 0x00fd }
            java.lang.String r7 = r3.toString()     // Catch:{ SQLiteException -> 0x00fd }
            java.lang.String r9 = "rowid"
            com.google.android.gms.measurement.internal.zzfu r3 = r1.zzs     // Catch:{ SQLiteException -> 0x00fd }
            r3.zzc()     // Catch:{ SQLiteException -> 0x00fd }
            r8 = 0
            r15 = 0
            r3 = r4
            r4 = r5
            r5 = r7
            r7 = r8
            r8 = r15
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x00fd }
            boolean r2 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x00fd }
            if (r2 != 0) goto L_0x0091
            if (r11 == 0) goto L_0x0090
            r11.close()
        L_0x0090:
            return r0
        L_0x0091:
            int r2 = r0.size()     // Catch:{ SQLiteException -> 0x00fd }
            com.google.android.gms.measurement.internal.zzfu r3 = r1.zzs     // Catch:{ SQLiteException -> 0x00fd }
            r3.zzc()     // Catch:{ SQLiteException -> 0x00fd }
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r2 < r3) goto L_0x00b7
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzs     // Catch:{ SQLiteException -> 0x00fd }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ SQLiteException -> 0x00fd }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ SQLiteException -> 0x00fd }
            java.lang.String r4 = "Read more than the max allowed user properties, ignoring excess"
            com.google.android.gms.measurement.internal.zzfu r5 = r1.zzs     // Catch:{ SQLiteException -> 0x00fd }
            r5.zzc()     // Catch:{ SQLiteException -> 0x00fd }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x00fd }
            r2.zzb(r4, r3)     // Catch:{ SQLiteException -> 0x00fd }
            goto L_0x00f7
        L_0x00b7:
            r2 = 0
            java.lang.String r6 = r11.getString(r2)     // Catch:{ SQLiteException -> 0x00fd }
            r2 = 1
            long r7 = r11.getLong(r2)     // Catch:{ SQLiteException -> 0x00fd }
            r2 = 2
            java.lang.Object r9 = r1.zzC(r11, r2)     // Catch:{ SQLiteException -> 0x00fd }
            java.lang.String r14 = r11.getString(r12)     // Catch:{ SQLiteException -> 0x00fd }
            if (r9 != 0) goto L_0x00e2
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzs     // Catch:{ SQLiteException -> 0x00fd }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ SQLiteException -> 0x00fd }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ SQLiteException -> 0x00fd }
            java.lang.String r3 = "(2)Read invalid user property value, ignoring it"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzem.zzl(r17)     // Catch:{ SQLiteException -> 0x00fd }
            r10 = r19
            r2.zzd(r3, r4, r14, r10)     // Catch:{ SQLiteException -> 0x00fd }
            goto L_0x00f0
        L_0x00e2:
            r10 = r19
            com.google.android.gms.measurement.internal.zzks r2 = new com.google.android.gms.measurement.internal.zzks     // Catch:{ SQLiteException -> 0x00fd }
            r3 = r2
            r4 = r17
            r5 = r14
            r3.<init>(r4, r5, r6, r7, r9)     // Catch:{ SQLiteException -> 0x00fd }
            r0.add(r2)     // Catch:{ SQLiteException -> 0x00fd }
        L_0x00f0:
            boolean r2 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x00fd }
            if (r2 == 0) goto L_0x00f7
            goto L_0x0091
        L_0x00f7:
            if (r11 == 0) goto L_0x00fc
            r11.close()
        L_0x00fc:
            return r0
        L_0x00fd:
            r0 = move-exception
            goto L_0x0108
        L_0x00ff:
            r0 = move-exception
            goto L_0x0125
        L_0x0101:
            r0 = move-exception
            goto L_0x0106
        L_0x0103:
            r0 = move-exception
            r13 = r17
        L_0x0106:
            r14 = r18
        L_0x0108:
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzs     // Catch:{ all -> 0x00ff }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ all -> 0x00ff }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ all -> 0x00ff }
            java.lang.String r3 = "(2)Error querying user properties"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzem.zzl(r17)     // Catch:{ all -> 0x00ff }
            r2.zzd(r3, r4, r14, r0)     // Catch:{ all -> 0x00ff }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x00ff }
            if (r11 == 0) goto L_0x0124
            r11.close()
        L_0x0124:
            return r0
        L_0x0125:
            if (r11 == 0) goto L_0x012a
            r11.close()
        L_0x012a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzm(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final boolean zzn(zzaa zzaa) {
        Preconditions.checkNotNull(zzaa);
        zzg();
        zzZ();
        String str = zzaa.zza;
        Preconditions.checkNotNull(str);
        if (zzk(str, zzaa.zzc.zzb) == null) {
            long zzab = zzab("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            this.zzs.zzc();
            if (zzab >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzaa.zzb);
        contentValues.put("name", zzaa.zzc.zzb);
        zzX(contentValues, "value", Preconditions.checkNotNull(zzaa.zzc.zza()));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(zzaa.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzaa.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzaa.zzh));
        contentValues.put("timed_out_event", this.zzs.zzl().zzX(zzaa.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzaa.zzd));
        contentValues.put("triggered_event", this.zzs.zzl().zzX(zzaa.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzaa.zzc.zzc));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzaa.zzj));
        contentValues.put("expired_event", this.zzs.zzl().zzX(zzaa.zzk));
        try {
            if (zze().insertWithOnConflict("conditional_properties", (String) null, contentValues, 5) != -1) {
                return true;
            }
            this.zzs.zzau().zzb().zzb("Failed to insert/update conditional user property (got -1)", zzem.zzl(str));
            return true;
        } catch (SQLiteException e) {
            this.zzs.zzau().zzb().zzc("Error storing conditional user property", zzem.zzl(str), e);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0124  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzaa zzo(java.lang.String r27, java.lang.String r28) {
        /*
            r26 = this;
            r1 = r26
            r8 = r28
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r27)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r28)
            r26.zzg()
            r26.zzZ()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r26.zze()     // Catch:{ SQLiteException -> 0x00fb, all -> 0x00f9 }
            java.lang.String r11 = "origin"
            java.lang.String r12 = "value"
            java.lang.String r13 = "active"
            java.lang.String r14 = "trigger_event_name"
            java.lang.String r15 = "trigger_timeout"
            java.lang.String r16 = "timed_out_event"
            java.lang.String r17 = "creation_timestamp"
            java.lang.String r18 = "triggered_event"
            java.lang.String r19 = "triggered_timestamp"
            java.lang.String r20 = "time_to_live"
            java.lang.String r21 = "expired_event"
            java.lang.String[] r12 = new java.lang.String[]{r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21}     // Catch:{ SQLiteException -> 0x00fb, all -> 0x00f9 }
            java.lang.String[] r14 = new java.lang.String[]{r27, r28}     // Catch:{ SQLiteException -> 0x00fb, all -> 0x00f9 }
            java.lang.String r11 = "conditional_properties"
            java.lang.String r13 = "app_id=? and name=?"
            r16 = 0
            r17 = 0
            r15 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x00fb, all -> 0x00f9 }
            boolean r0 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x00f7 }
            if (r0 != 0) goto L_0x004c
            if (r10 == 0) goto L_0x004b
            r10.close()
        L_0x004b:
            return r9
        L_0x004c:
            r0 = 0
            java.lang.String r13 = r10.getString(r0)     // Catch:{ SQLiteException -> 0x00f7 }
            r2 = 1
            java.lang.Object r6 = r1.zzC(r10, r2)     // Catch:{ SQLiteException -> 0x00f7 }
            r3 = 2
            int r3 = r10.getInt(r3)     // Catch:{ SQLiteException -> 0x00f7 }
            if (r3 == 0) goto L_0x0060
            r17 = r2
            goto L_0x0062
        L_0x0060:
            r17 = r0
        L_0x0062:
            r0 = 3
            java.lang.String r18 = r10.getString(r0)     // Catch:{ SQLiteException -> 0x00f7 }
            r0 = 4
            long r20 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x00f7 }
            com.google.android.gms.measurement.internal.zzkn r0 = r1.zzf     // Catch:{ SQLiteException -> 0x00f7 }
            com.google.android.gms.measurement.internal.zzkp r0 = r0.zzm()     // Catch:{ SQLiteException -> 0x00f7 }
            r2 = 5
            byte[] r2 = r10.getBlob(r2)     // Catch:{ SQLiteException -> 0x00f7 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzas> r3 = com.google.android.gms.measurement.internal.zzas.CREATOR     // Catch:{ SQLiteException -> 0x00f7 }
            android.os.Parcelable r0 = r0.zzk(r2, r3)     // Catch:{ SQLiteException -> 0x00f7 }
            r19 = r0
            com.google.android.gms.measurement.internal.zzas r19 = (com.google.android.gms.measurement.internal.zzas) r19     // Catch:{ SQLiteException -> 0x00f7 }
            r0 = 6
            long r15 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x00f7 }
            com.google.android.gms.measurement.internal.zzkn r0 = r1.zzf     // Catch:{ SQLiteException -> 0x00f7 }
            com.google.android.gms.measurement.internal.zzkp r0 = r0.zzm()     // Catch:{ SQLiteException -> 0x00f7 }
            r2 = 7
            byte[] r2 = r10.getBlob(r2)     // Catch:{ SQLiteException -> 0x00f7 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzas> r3 = com.google.android.gms.measurement.internal.zzas.CREATOR     // Catch:{ SQLiteException -> 0x00f7 }
            android.os.Parcelable r0 = r0.zzk(r2, r3)     // Catch:{ SQLiteException -> 0x00f7 }
            r22 = r0
            com.google.android.gms.measurement.internal.zzas r22 = (com.google.android.gms.measurement.internal.zzas) r22     // Catch:{ SQLiteException -> 0x00f7 }
            r0 = 8
            long r4 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x00f7 }
            r0 = 9
            long r23 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x00f7 }
            com.google.android.gms.measurement.internal.zzkn r0 = r1.zzf     // Catch:{ SQLiteException -> 0x00f7 }
            com.google.android.gms.measurement.internal.zzkp r0 = r0.zzm()     // Catch:{ SQLiteException -> 0x00f7 }
            r2 = 10
            byte[] r2 = r10.getBlob(r2)     // Catch:{ SQLiteException -> 0x00f7 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzas> r3 = com.google.android.gms.measurement.internal.zzas.CREATOR     // Catch:{ SQLiteException -> 0x00f7 }
            android.os.Parcelable r0 = r0.zzk(r2, r3)     // Catch:{ SQLiteException -> 0x00f7 }
            r25 = r0
            com.google.android.gms.measurement.internal.zzas r25 = (com.google.android.gms.measurement.internal.zzas) r25     // Catch:{ SQLiteException -> 0x00f7 }
            com.google.android.gms.measurement.internal.zzkq r14 = new com.google.android.gms.measurement.internal.zzkq     // Catch:{ SQLiteException -> 0x00f7 }
            r2 = r14
            r3 = r28
            r7 = r13
            r2.<init>(r3, r4, r6, r7)     // Catch:{ SQLiteException -> 0x00f7 }
            com.google.android.gms.measurement.internal.zzaa r0 = new com.google.android.gms.measurement.internal.zzaa     // Catch:{ SQLiteException -> 0x00f7 }
            r11 = r0
            r12 = r27
            r11.<init>(r12, r13, r14, r15, r17, r18, r19, r20, r22, r23, r25)     // Catch:{ SQLiteException -> 0x00f7 }
            boolean r2 = r10.moveToNext()     // Catch:{ SQLiteException -> 0x00f7 }
            if (r2 == 0) goto L_0x00f1
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzs     // Catch:{ SQLiteException -> 0x00f7 }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ SQLiteException -> 0x00f7 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ SQLiteException -> 0x00f7 }
            java.lang.String r3 = "Got multiple records for conditional property, expected one"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzem.zzl(r27)     // Catch:{ SQLiteException -> 0x00f7 }
            com.google.android.gms.measurement.internal.zzfu r5 = r1.zzs     // Catch:{ SQLiteException -> 0x00f7 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzm()     // Catch:{ SQLiteException -> 0x00f7 }
            java.lang.String r5 = r5.zze(r8)     // Catch:{ SQLiteException -> 0x00f7 }
            r2.zzc(r3, r4, r5)     // Catch:{ SQLiteException -> 0x00f7 }
        L_0x00f1:
            if (r10 == 0) goto L_0x00f6
            r10.close()
        L_0x00f6:
            return r0
        L_0x00f7:
            r0 = move-exception
            goto L_0x00fd
        L_0x00f9:
            r0 = move-exception
            goto L_0x0122
        L_0x00fb:
            r0 = move-exception
            r10 = r9
        L_0x00fd:
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzs     // Catch:{ all -> 0x0120 }
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch:{ all -> 0x0120 }
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch:{ all -> 0x0120 }
            java.lang.String r3 = "Error querying conditional property"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzem.zzl(r27)     // Catch:{ all -> 0x0120 }
            com.google.android.gms.measurement.internal.zzfu r5 = r1.zzs     // Catch:{ all -> 0x0120 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzm()     // Catch:{ all -> 0x0120 }
            java.lang.String r5 = r5.zze(r8)     // Catch:{ all -> 0x0120 }
            r2.zzd(r3, r4, r5, r0)     // Catch:{ all -> 0x0120 }
            if (r10 == 0) goto L_0x011f
            r10.close()
        L_0x011f:
            return r9
        L_0x0120:
            r0 = move-exception
            r9 = r10
        L_0x0122:
            if (r9 == 0) goto L_0x0127
            r9.close()
        L_0x0127:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzo(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzaa");
    }

    public final int zzp(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzZ();
        try {
            return zze().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            this.zzs.zzau().zzb().zzd("Error deleting conditional property", zzem.zzl(str), this.zzs.zzm().zze(str2), e);
            return 0;
        }
    }

    public final List<zzaa> zzq(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzZ();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zzr(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final List<zzaa> zzr(String str, String[] strArr) {
        zzg();
        zzZ();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase zze2 = zze();
            String[] strArr2 = {"app_id", "origin", "name", "value", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"};
            this.zzs.zzc();
            Cursor query = zze2.query("conditional_properties", strArr2, str, strArr, (String) null, (String) null, "rowid", "1001");
            if (query.moveToFirst()) {
                while (true) {
                    int size = arrayList.size();
                    this.zzs.zzc();
                    if (size < 1000) {
                        String string = query.getString(0);
                        String string2 = query.getString(1);
                        String string3 = query.getString(2);
                        Object zzC = zzC(query, 3);
                        boolean z = query.getInt(4) != 0;
                        String string4 = query.getString(5);
                        long j = query.getLong(6);
                        arrayList.add(new zzaa(string, string2, new zzkq(string3, query.getLong(10), zzC, string2), query.getLong(8), z, string4, (zzas) this.zzf.zzm().zzk(query.getBlob(7), zzas.CREATOR), j, (zzas) this.zzf.zzm().zzk(query.getBlob(9), zzas.CREATOR), query.getLong(11), (zzas) this.zzf.zzm().zzk(query.getBlob(12), zzas.CREATOR)));
                        if (!query.moveToNext()) {
                            break;
                        }
                    } else {
                        zzek zzb2 = this.zzs.zzau().zzb();
                        this.zzs.zzc();
                        zzb2.zzb("Read more than the max allowed conditional properties, ignoring extra", 1000);
                        break;
                    }
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            }
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (SQLiteException e) {
            this.zzs.zzau().zzb().zzb("Error querying conditional user property value", e);
            List<zzaa> emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0119 A[Catch:{ SQLiteException -> 0x01eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x011d A[Catch:{ SQLiteException -> 0x01eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0159 A[Catch:{ SQLiteException -> 0x01eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x018d A[Catch:{ SQLiteException -> 0x01eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x018e A[Catch:{ SQLiteException -> 0x01eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x019d A[Catch:{ SQLiteException -> 0x01eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x01c0 A[Catch:{ SQLiteException -> 0x01eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01d2 A[Catch:{ SQLiteException -> 0x01eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x020e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzg zzs(java.lang.String r34) {
        /*
            r33 = this;
            r1 = r33
            r2 = r34
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r34)
            r33.zzg()
            r33.zzZ()
            r3 = 0
            android.database.sqlite.SQLiteDatabase r4 = r33.zze()     // Catch:{ SQLiteException -> 0x01ef, all -> 0x01ed }
            java.lang.String r5 = "app_instance_id"
            java.lang.String r6 = "gmp_app_id"
            java.lang.String r7 = "resettable_device_id_hash"
            java.lang.String r8 = "last_bundle_index"
            java.lang.String r9 = "last_bundle_start_timestamp"
            java.lang.String r10 = "last_bundle_end_timestamp"
            java.lang.String r11 = "app_version"
            java.lang.String r12 = "app_store"
            java.lang.String r13 = "gmp_version"
            java.lang.String r14 = "dev_cert_hash"
            java.lang.String r15 = "measurement_enabled"
            java.lang.String r16 = "day"
            java.lang.String r17 = "daily_public_events_count"
            java.lang.String r18 = "daily_events_count"
            java.lang.String r19 = "daily_conversions_count"
            java.lang.String r20 = "config_fetched_time"
            java.lang.String r21 = "failed_config_fetch_time"
            java.lang.String r22 = "app_version_int"
            java.lang.String r23 = "firebase_instance_id"
            java.lang.String r24 = "daily_error_events_count"
            java.lang.String r25 = "daily_realtime_events_count"
            java.lang.String r26 = "health_monitor_sample"
            java.lang.String r27 = "android_id"
            java.lang.String r28 = "adid_reporting_enabled"
            java.lang.String r29 = "admob_app_id"
            java.lang.String r30 = "dynamite_version"
            java.lang.String r31 = "safelisted_events"
            java.lang.String r32 = "ga_app_id"
            java.lang.String[] r6 = new java.lang.String[]{r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32}     // Catch:{ SQLiteException -> 0x01ef, all -> 0x01ed }
            java.lang.String[] r8 = new java.lang.String[]{r34}     // Catch:{ SQLiteException -> 0x01ef, all -> 0x01ed }
            java.lang.String r5 = "apps"
            java.lang.String r7 = "app_id=?"
            r10 = 0
            r11 = 0
            r9 = 0
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x01ef, all -> 0x01ed }
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x01eb }
            if (r0 != 0) goto L_0x0069
            if (r4 == 0) goto L_0x0068
            r4.close()
        L_0x0068:
            return r3
        L_0x0069:
            com.google.android.gms.measurement.internal.zzg r0 = new com.google.android.gms.measurement.internal.zzg     // Catch:{ SQLiteException -> 0x01eb }
            com.google.android.gms.measurement.internal.zzkn r5 = r1.zzf     // Catch:{ SQLiteException -> 0x01eb }
            com.google.android.gms.measurement.internal.zzfu r5 = r5.zzN()     // Catch:{ SQLiteException -> 0x01eb }
            r0.<init>(r5, r2)     // Catch:{ SQLiteException -> 0x01eb }
            r5 = 0
            java.lang.String r6 = r4.getString(r5)     // Catch:{ SQLiteException -> 0x01eb }
            r0.zze(r6)     // Catch:{ SQLiteException -> 0x01eb }
            r6 = 1
            java.lang.String r7 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x01eb }
            r0.zzg(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r7 = 2
            java.lang.String r7 = r4.getString(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r0.zzm(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r7 = 3
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r0.zzH(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r7 = 4
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r0.zzq(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r7 = 5
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r0.zzs(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r7 = 6
            java.lang.String r7 = r4.getString(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r0.zzu(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r7 = 7
            java.lang.String r7 = r4.getString(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r0.zzy(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r7 = 8
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r0.zzA(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r7 = 9
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r0.zzC(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r7 = 10
            boolean r8 = r4.isNull(r7)     // Catch:{ SQLiteException -> 0x01eb }
            if (r8 != 0) goto L_0x00d7
            int r7 = r4.getInt(r7)     // Catch:{ SQLiteException -> 0x01eb }
            if (r7 == 0) goto L_0x00d5
            goto L_0x00d7
        L_0x00d5:
            r7 = r5
            goto L_0x00d8
        L_0x00d7:
            r7 = r6
        L_0x00d8:
            r0.zzG(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r7 = 11
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r0.zzP(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r7 = 12
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r0.zzR(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r7 = 13
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r0.zzT(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r7 = 14
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r0.zzV(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r7 = 15
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r0.zzK(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r7 = 16
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r0.zzM(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r7 = 17
            boolean r8 = r4.isNull(r7)     // Catch:{ SQLiteException -> 0x01eb }
            if (r8 == 0) goto L_0x011d
            r7 = -2147483648(0xffffffff80000000, double:NaN)
            goto L_0x0122
        L_0x011d:
            int r7 = r4.getInt(r7)     // Catch:{ SQLiteException -> 0x01eb }
            long r7 = (long) r7     // Catch:{ SQLiteException -> 0x01eb }
        L_0x0122:
            r0.zzw(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r7 = 18
            java.lang.String r7 = r4.getString(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r0.zzo(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r7 = 19
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r0.zzZ(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r7 = 20
            long r7 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r0.zzX(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r7 = 21
            java.lang.String r7 = r4.getString(r7)     // Catch:{ SQLiteException -> 0x01eb }
            r0.zzac(r7)     // Catch:{ SQLiteException -> 0x01eb }
            com.google.android.gms.measurement.internal.zzfu r7 = r1.zzs     // Catch:{ SQLiteException -> 0x01eb }
            com.google.android.gms.measurement.internal.zzae r7 = r7.zzc()     // Catch:{ SQLiteException -> 0x01eb }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzea.zzat     // Catch:{ SQLiteException -> 0x01eb }
            boolean r7 = r7.zzn(r3, r8)     // Catch:{ SQLiteException -> 0x01eb }
            r8 = 0
            if (r7 != 0) goto L_0x016a
            r7 = 22
            boolean r10 = r4.isNull(r7)     // Catch:{ SQLiteException -> 0x01eb }
            if (r10 == 0) goto L_0x0163
            r10 = r8
            goto L_0x0167
        L_0x0163:
            long r10 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x01eb }
        L_0x0167:
            r0.zzae(r10)     // Catch:{ SQLiteException -> 0x01eb }
        L_0x016a:
            r7 = 23
            boolean r10 = r4.isNull(r7)     // Catch:{ SQLiteException -> 0x01eb }
            if (r10 != 0) goto L_0x0178
            int r7 = r4.getInt(r7)     // Catch:{ SQLiteException -> 0x01eb }
            if (r7 == 0) goto L_0x0179
        L_0x0178:
            r5 = r6
        L_0x0179:
            r0.zzag(r5)     // Catch:{ SQLiteException -> 0x01eb }
            r5 = 24
            java.lang.String r5 = r4.getString(r5)     // Catch:{ SQLiteException -> 0x01eb }
            r0.zzi(r5)     // Catch:{ SQLiteException -> 0x01eb }
            r5 = 25
            boolean r6 = r4.isNull(r5)     // Catch:{ SQLiteException -> 0x01eb }
            if (r6 == 0) goto L_0x018e
            goto L_0x0192
        L_0x018e:
            long r8 = r4.getLong(r5)     // Catch:{ SQLiteException -> 0x01eb }
        L_0x0192:
            r0.zzE(r8)     // Catch:{ SQLiteException -> 0x01eb }
            r5 = 26
            boolean r6 = r4.isNull(r5)     // Catch:{ SQLiteException -> 0x01eb }
            if (r6 != 0) goto L_0x01af
            java.lang.String r5 = r4.getString(r5)     // Catch:{ SQLiteException -> 0x01eb }
            java.lang.String r6 = ","
            r7 = -1
            java.lang.String[] r5 = r5.split(r6, r7)     // Catch:{ SQLiteException -> 0x01eb }
            java.util.List r5 = java.util.Arrays.asList(r5)     // Catch:{ SQLiteException -> 0x01eb }
            r0.zzak(r5)     // Catch:{ SQLiteException -> 0x01eb }
        L_0x01af:
            com.google.android.gms.internal.measurement.zzov.zzb()     // Catch:{ SQLiteException -> 0x01eb }
            com.google.android.gms.measurement.internal.zzfu r5 = r1.zzs     // Catch:{ SQLiteException -> 0x01eb }
            com.google.android.gms.measurement.internal.zzae r5 = r5.zzc()     // Catch:{ SQLiteException -> 0x01eb }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzea.zzag     // Catch:{ SQLiteException -> 0x01eb }
            boolean r5 = r5.zzn(r2, r6)     // Catch:{ SQLiteException -> 0x01eb }
            if (r5 == 0) goto L_0x01c9
            r5 = 27
            java.lang.String r5 = r4.getString(r5)     // Catch:{ SQLiteException -> 0x01eb }
            r0.zzk(r5)     // Catch:{ SQLiteException -> 0x01eb }
        L_0x01c9:
            r0.zzb()     // Catch:{ SQLiteException -> 0x01eb }
            boolean r5 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x01eb }
            if (r5 == 0) goto L_0x01e5
            com.google.android.gms.measurement.internal.zzfu r5 = r1.zzs     // Catch:{ SQLiteException -> 0x01eb }
            com.google.android.gms.measurement.internal.zzem r5 = r5.zzau()     // Catch:{ SQLiteException -> 0x01eb }
            com.google.android.gms.measurement.internal.zzek r5 = r5.zzb()     // Catch:{ SQLiteException -> 0x01eb }
            java.lang.String r6 = "Got multiple records for app, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzem.zzl(r34)     // Catch:{ SQLiteException -> 0x01eb }
            r5.zzb(r6, r7)     // Catch:{ SQLiteException -> 0x01eb }
        L_0x01e5:
            if (r4 == 0) goto L_0x01ea
            r4.close()
        L_0x01ea:
            return r0
        L_0x01eb:
            r0 = move-exception
            goto L_0x01f1
        L_0x01ed:
            r0 = move-exception
            goto L_0x020c
        L_0x01ef:
            r0 = move-exception
            r4 = r3
        L_0x01f1:
            com.google.android.gms.measurement.internal.zzfu r5 = r1.zzs     // Catch:{ all -> 0x020a }
            com.google.android.gms.measurement.internal.zzem r5 = r5.zzau()     // Catch:{ all -> 0x020a }
            com.google.android.gms.measurement.internal.zzek r5 = r5.zzb()     // Catch:{ all -> 0x020a }
            java.lang.String r6 = "Error querying app. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzem.zzl(r34)     // Catch:{ all -> 0x020a }
            r5.zzc(r6, r2, r0)     // Catch:{ all -> 0x020a }
            if (r4 == 0) goto L_0x0209
            r4.close()
        L_0x0209:
            return r3
        L_0x020a:
            r0 = move-exception
            r3 = r4
        L_0x020c:
            if (r3 == 0) goto L_0x0211
            r3.close()
        L_0x0211:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzs(java.lang.String):com.google.android.gms.measurement.internal.zzg");
    }

    public final void zzt(zzg zzg2) {
        Preconditions.checkNotNull(zzg2);
        zzg();
        zzZ();
        String zzc2 = zzg2.zzc();
        Preconditions.checkNotNull(zzc2);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzc2);
        contentValues.put("app_instance_id", zzg2.zzd());
        contentValues.put("gmp_app_id", zzg2.zzf());
        contentValues.put("resettable_device_id_hash", zzg2.zzl());
        contentValues.put("last_bundle_index", Long.valueOf(zzg2.zzI()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzg2.zzp()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzg2.zzr()));
        contentValues.put("app_version", zzg2.zzt());
        contentValues.put("app_store", zzg2.zzx());
        contentValues.put("gmp_version", Long.valueOf(zzg2.zzz()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzg2.zzB()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzg2.zzF()));
        contentValues.put("day", Long.valueOf(zzg2.zzO()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzg2.zzQ()));
        contentValues.put("daily_events_count", Long.valueOf(zzg2.zzS()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzg2.zzU()));
        contentValues.put("config_fetched_time", Long.valueOf(zzg2.zzJ()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzg2.zzL()));
        contentValues.put("app_version_int", Long.valueOf(zzg2.zzv()));
        contentValues.put("firebase_instance_id", zzg2.zzn());
        contentValues.put("daily_error_events_count", Long.valueOf(zzg2.zzY()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzg2.zzW()));
        contentValues.put("health_monitor_sample", zzg2.zzaa());
        contentValues.put("android_id", Long.valueOf(zzg2.zzad()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzg2.zzaf()));
        contentValues.put("admob_app_id", zzg2.zzh());
        contentValues.put("dynamite_version", Long.valueOf(zzg2.zzD()));
        List<String> zzaj = zzg2.zzaj();
        if (zzaj != null) {
            if (zzaj.size() == 0) {
                this.zzs.zzau().zze().zzb("Safelisted events should not be an empty list. appId", zzc2);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", zzaj));
            }
        }
        zzov.zzb();
        if (this.zzs.zzc().zzn(zzc2, zzea.zzag)) {
            contentValues.put("ga_app_id", zzg2.zzj());
        }
        try {
            SQLiteDatabase zze2 = zze();
            if (((long) zze2.update("apps", contentValues, "app_id = ?", new String[]{zzc2})) == 0 && zze2.insertWithOnConflict("apps", (String) null, contentValues, 5) == -1) {
                this.zzs.zzau().zzb().zzb("Failed to insert/update app (got -1). appId", zzem.zzl(zzc2));
            }
        } catch (SQLiteException e) {
            this.zzs.zzau().zzb().zzc("Error storing app. appId", zzem.zzl(zzc2), e);
        }
    }

    public final zzag zzu(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return zzv(j, str, 1, false, false, z3, false, z5);
    }

    public final zzag zzv(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzZ();
        String[] strArr = {str};
        zzag zzag = new zzag();
        Cursor cursor = null;
        try {
            SQLiteDatabase zze2 = zze();
            cursor = zze2.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                this.zzs.zzau().zze().zzb("Not updating daily counts, app is not known. appId", zzem.zzl(str));
                if (cursor != null) {
                    cursor.close();
                }
                return zzag;
            }
            if (cursor.getLong(0) == j) {
                zzag.zzb = cursor.getLong(1);
                zzag.zza = cursor.getLong(2);
                zzag.zzc = cursor.getLong(3);
                zzag.zzd = cursor.getLong(4);
                zzag.zze = cursor.getLong(5);
            }
            if (z) {
                zzag.zzb += j2;
            }
            if (z2) {
                zzag.zza += j2;
            }
            if (z3) {
                zzag.zzc += j2;
            }
            if (z4) {
                zzag.zzd += j2;
            }
            if (z5) {
                zzag.zze += j2;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("day", Long.valueOf(j));
            contentValues.put("daily_public_events_count", Long.valueOf(zzag.zza));
            contentValues.put("daily_events_count", Long.valueOf(zzag.zzb));
            contentValues.put("daily_conversions_count", Long.valueOf(zzag.zzc));
            contentValues.put("daily_error_events_count", Long.valueOf(zzag.zzd));
            contentValues.put("daily_realtime_events_count", Long.valueOf(zzag.zze));
            zze2.update("apps", contentValues, "app_id=?", strArr);
            if (cursor != null) {
                cursor.close();
            }
            return zzag;
        } catch (SQLiteException e) {
            this.zzs.zzau().zzb().zzc("Error updating daily counts. appId", zzem.zzl(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return zzag;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void zzw(String str, byte[] bArr, String str2) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzZ();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        contentValues.put("config_last_modified_time", str2);
        try {
            if (((long) zze().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                this.zzs.zzau().zzb().zzb("Failed to update remote config (got 0). appId", zzem.zzl(str));
            }
        } catch (SQLiteException e) {
            this.zzs.zzau().zzb().zzc("Error storing remote config. appId", zzem.zzl(str), e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0047, code lost:
        if (r2 > (com.google.android.gms.measurement.internal.zzae.zzA() + r0)) goto L_0x0049;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzx(com.google.android.gms.internal.measurement.zzfw r7, boolean r8) {
        /*
            r6 = this;
            r6.zzg()
            r6.zzZ()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)
            java.lang.String r0 = r7.zzA()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r0)
            boolean r0 = r7.zzn()
            com.google.android.gms.common.internal.Preconditions.checkState(r0)
            r6.zzA()
            com.google.android.gms.measurement.internal.zzfu r0 = r6.zzs
            com.google.android.gms.common.util.Clock r0 = r0.zzay()
            long r0 = r0.currentTimeMillis()
            long r2 = r7.zzo()
            com.google.android.gms.measurement.internal.zzfu r4 = r6.zzs
            r4.zzc()
            long r4 = com.google.android.gms.measurement.internal.zzae.zzA()
            long r4 = r0 - r4
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x0049
            long r2 = r7.zzo()
            com.google.android.gms.measurement.internal.zzfu r4 = r6.zzs
            r4.zzc()
            long r4 = com.google.android.gms.measurement.internal.zzae.zzA()
            long r4 = r4 + r0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x006c
        L_0x0049:
            com.google.android.gms.measurement.internal.zzfu r2 = r6.zzs
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()
            com.google.android.gms.measurement.internal.zzek r2 = r2.zze()
            java.lang.String r3 = r7.zzA()
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzem.zzl(r3)
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            long r4 = r7.zzo()
            java.lang.Long r1 = java.lang.Long.valueOf(r4)
            java.lang.String r4 = "Storing bundle outside of the max uploading time span. appId, now, timestamp"
            r2.zzd(r4, r3, r0, r1)
        L_0x006c:
            byte[] r0 = r7.zzbp()
            r1 = 0
            com.google.android.gms.measurement.internal.zzkn r2 = r6.zzf     // Catch:{ IOException -> 0x010f }
            com.google.android.gms.measurement.internal.zzkp r2 = r2.zzm()     // Catch:{ IOException -> 0x010f }
            byte[] r0 = r2.zzs(r0)     // Catch:{ IOException -> 0x010f }
            com.google.android.gms.measurement.internal.zzfu r2 = r6.zzs
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzk()
            int r3 = r0.length
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "Saving bundle, size"
            r2.zzb(r4, r3)
            android.content.ContentValues r2 = new android.content.ContentValues
            r2.<init>()
            java.lang.String r3 = "app_id"
            java.lang.String r4 = r7.zzA()
            r2.put(r3, r4)
            long r3 = r7.zzo()
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "bundle_end_timestamp"
            r2.put(r4, r3)
            java.lang.String r3 = "data"
            r2.put(r3, r0)
            java.lang.String r0 = "has_realtime"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r2.put(r0, r8)
            boolean r8 = r7.zzab()
            if (r8 == 0) goto L_0x00cb
            int r8 = r7.zzac()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.String r0 = "retry_count"
            r2.put(r0, r8)
        L_0x00cb:
            android.database.sqlite.SQLiteDatabase r8 = r6.zze()     // Catch:{ SQLiteException -> 0x00f6 }
            java.lang.String r0 = "queue"
            r3 = 0
            long r2 = r8.insert(r0, r3, r2)     // Catch:{ SQLiteException -> 0x00f6 }
            r4 = -1
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 != 0) goto L_0x00f4
            com.google.android.gms.measurement.internal.zzfu r8 = r6.zzs     // Catch:{ SQLiteException -> 0x00f6 }
            com.google.android.gms.measurement.internal.zzem r8 = r8.zzau()     // Catch:{ SQLiteException -> 0x00f6 }
            com.google.android.gms.measurement.internal.zzek r8 = r8.zzb()     // Catch:{ SQLiteException -> 0x00f6 }
            java.lang.String r0 = "Failed to insert bundle (got -1). appId"
            java.lang.String r2 = r7.zzA()     // Catch:{ SQLiteException -> 0x00f6 }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzem.zzl(r2)     // Catch:{ SQLiteException -> 0x00f6 }
            r8.zzb(r0, r2)     // Catch:{ SQLiteException -> 0x00f6 }
            return r1
        L_0x00f4:
            r7 = 1
            return r7
        L_0x00f6:
            r8 = move-exception
            com.google.android.gms.measurement.internal.zzfu r0 = r6.zzs
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzb()
            java.lang.String r7 = r7.zzA()
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzem.zzl(r7)
            java.lang.String r2 = "Error storing bundle. appId"
            r0.zzc(r2, r7, r8)
            return r1
        L_0x010f:
            r8 = move-exception
            com.google.android.gms.measurement.internal.zzfu r0 = r6.zzs
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzb()
            java.lang.String r7 = r7.zzA()
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzem.zzl(r7)
            java.lang.String r2 = "Data loss. Failed to serialize bundle. appId"
            r0.zzc(r2, r7, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzx(com.google.android.gms.internal.measurement.zzfw, boolean):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzy() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.zze()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch:{ SQLiteException -> 0x0026, all -> 0x0024 }
            boolean r2 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x0022 }
            if (r2 == 0) goto L_0x001c
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x0022 }
            if (r0 == 0) goto L_0x001b
            r0.close()
        L_0x001b:
            return r1
        L_0x001c:
            if (r0 == 0) goto L_0x0021
            r0.close()
        L_0x0021:
            return r1
        L_0x0022:
            r2 = move-exception
            goto L_0x0029
        L_0x0024:
            r0 = move-exception
            goto L_0x0042
        L_0x0026:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L_0x0029:
            com.google.android.gms.measurement.internal.zzfu r3 = r6.zzs     // Catch:{ all -> 0x003e }
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzau()     // Catch:{ all -> 0x003e }
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzb()     // Catch:{ all -> 0x003e }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zzb(r4, r2)     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x003d
            r0.close()
        L_0x003d:
            return r1
        L_0x003e:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L_0x0042:
            if (r1 == 0) goto L_0x0047
            r1.close()
        L_0x0047:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzy():java.lang.String");
    }

    public final boolean zzz() {
        return zzab("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }
}
