package com.google.android.gms.stats;

import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.providers.PooledExecutorsProvider;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.WorkSourceUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class WakeLock {
    private static ScheduledExecutorService zzn;
    private static volatile zza zzo = new zza();
    private final Object zza;
    private final PowerManager.WakeLock zzb;
    private WorkSource zzc;
    private final int zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;
    private final Context zzh;
    private boolean zzi;
    private final Map<String, Integer[]> zzj;
    private final Set<Future<?>> zzk;
    private int zzl;
    private AtomicInteger zzm;

    public interface zza {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WakeLock(Context context, int i, String str) {
        this(context, i, str, (String) null, context == null ? null : context.getPackageName());
    }

    private WakeLock(Context context, int i, String str, String str2, String str3) {
        this(context, i, str, (String) null, str3, (String) null);
    }

    private WakeLock(Context context, int i, String str, String str2, String str3, String str4) {
        this.zza = this;
        this.zzi = true;
        this.zzj = new HashMap();
        this.zzk = Collections.synchronizedSet(new HashSet());
        this.zzm = new AtomicInteger(0);
        Preconditions.checkNotNull(context, "WakeLock: context must not be null");
        Preconditions.checkNotEmpty(str, "WakeLock: wakeLockName must not be empty");
        this.zzd = i;
        this.zzf = null;
        this.zzg = null;
        Context applicationContext = context.getApplicationContext();
        this.zzh = applicationContext;
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String valueOf = String.valueOf(str);
            this.zze = valueOf.length() != 0 ? "*gcore*:".concat(valueOf) : new String("*gcore*:");
        } else {
            this.zze = str;
        }
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        this.zzb = newWakeLock;
        if (WorkSourceUtil.hasWorkSourcePermission(context)) {
            WorkSource fromPackage = WorkSourceUtil.fromPackage(context, Strings.isEmptyOrWhitespace(str3) ? context.getPackageName() : str3);
            this.zzc = fromPackage;
            if (fromPackage != null && WorkSourceUtil.hasWorkSourcePermission(applicationContext)) {
                WorkSource workSource = this.zzc;
                if (workSource != null) {
                    workSource.add(fromPackage);
                } else {
                    this.zzc = fromPackage;
                }
                try {
                    newWakeLock.setWorkSource(this.zzc);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
                    Log.wtf("WakeLock", e.toString());
                }
            }
        }
        if (zzn == null) {
            zzn = PooledExecutorsProvider.getInstance().newSingleThreadScheduledExecutor();
        }
    }

    private final List<String> zza() {
        return WorkSourceUtil.getNames(this.zzc);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0059, code lost:
        if (r13.zzl == 0) goto L_0x005b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void acquire(long r14) {
        /*
            r13 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = r13.zzm
            r0.incrementAndGet()
            r0 = 0
            java.lang.String r6 = r13.zza((java.lang.String) r0)
            java.lang.Object r0 = r13.zza
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.zzj     // Catch:{ all -> 0x0093 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0093 }
            r2 = 0
            if (r1 == 0) goto L_0x001a
            int r1 = r13.zzl     // Catch:{ all -> 0x0093 }
            if (r1 <= 0) goto L_0x0029
        L_0x001a:
            android.os.PowerManager$WakeLock r1 = r13.zzb     // Catch:{ all -> 0x0093 }
            boolean r1 = r1.isHeld()     // Catch:{ all -> 0x0093 }
            if (r1 != 0) goto L_0x0029
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.zzj     // Catch:{ all -> 0x0093 }
            r1.clear()     // Catch:{ all -> 0x0093 }
            r13.zzl = r2     // Catch:{ all -> 0x0093 }
        L_0x0029:
            boolean r1 = r13.zzi     // Catch:{ all -> 0x0093 }
            r12 = 1
            if (r1 == 0) goto L_0x0053
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.zzj     // Catch:{ all -> 0x0093 }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ all -> 0x0093 }
            java.lang.Integer[] r1 = (java.lang.Integer[]) r1     // Catch:{ all -> 0x0093 }
            if (r1 != 0) goto L_0x0046
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.zzj     // Catch:{ all -> 0x0093 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x0093 }
            java.lang.Integer[] r4 = new java.lang.Integer[r12]     // Catch:{ all -> 0x0093 }
            r4[r2] = r3     // Catch:{ all -> 0x0093 }
            r1.put(r6, r4)     // Catch:{ all -> 0x0093 }
            goto L_0x005b
        L_0x0046:
            r3 = r1[r2]     // Catch:{ all -> 0x0093 }
            int r3 = r3.intValue()     // Catch:{ all -> 0x0093 }
            int r3 = r3 + r12
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0093 }
            r1[r2] = r3     // Catch:{ all -> 0x0093 }
        L_0x0053:
            boolean r1 = r13.zzi     // Catch:{ all -> 0x0093 }
            if (r1 != 0) goto L_0x007a
            int r1 = r13.zzl     // Catch:{ all -> 0x0093 }
            if (r1 != 0) goto L_0x007a
        L_0x005b:
            com.google.android.gms.common.stats.WakeLockTracker r1 = com.google.android.gms.common.stats.WakeLockTracker.getInstance()     // Catch:{ all -> 0x0093 }
            android.content.Context r2 = r13.zzh     // Catch:{ all -> 0x0093 }
            android.os.PowerManager$WakeLock r3 = r13.zzb     // Catch:{ all -> 0x0093 }
            java.lang.String r3 = com.google.android.gms.common.stats.StatsUtils.getEventKey(r3, r6)     // Catch:{ all -> 0x0093 }
            java.lang.String r5 = r13.zze     // Catch:{ all -> 0x0093 }
            int r8 = r13.zzd     // Catch:{ all -> 0x0093 }
            java.util.List r9 = r13.zza()     // Catch:{ all -> 0x0093 }
            r4 = 7
            r7 = 0
            r10 = r14
            r1.registerEvent(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0093 }
            int r1 = r13.zzl     // Catch:{ all -> 0x0093 }
            int r1 = r1 + r12
            r13.zzl = r1     // Catch:{ all -> 0x0093 }
        L_0x007a:
            monitor-exit(r0)     // Catch:{ all -> 0x0093 }
            android.os.PowerManager$WakeLock r0 = r13.zzb
            r0.acquire()
            r0 = 0
            int r0 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0092
            java.util.concurrent.ScheduledExecutorService r0 = zzn
            com.google.android.gms.stats.zzb r1 = new com.google.android.gms.stats.zzb
            r1.<init>(r13)
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS
            r0.schedule(r1, r14, r2)
        L_0x0092:
            return
        L_0x0093:
            r14 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0093 }
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.stats.WakeLock.acquire(long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0053, code lost:
        if (r12.zzl == 1) goto L_0x0055;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void release() {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = r12.zzm
            int r0 = r0.decrementAndGet()
            if (r0 >= 0) goto L_0x0019
            java.lang.String r0 = "WakeLock"
            java.lang.String r1 = r12.zze
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = " release without a matched acquire!"
            java.lang.String r1 = r1.concat(r2)
            android.util.Log.e(r0, r1)
        L_0x0019:
            r0 = 0
            java.lang.String r6 = r12.zza((java.lang.String) r0)
            java.lang.Object r0 = r12.zza
            monitor-enter(r0)
            boolean r1 = r12.zzi     // Catch:{ all -> 0x0079 }
            r10 = 0
            r11 = 1
            if (r1 == 0) goto L_0x004d
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.zzj     // Catch:{ all -> 0x0079 }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ all -> 0x0079 }
            java.lang.Integer[] r1 = (java.lang.Integer[]) r1     // Catch:{ all -> 0x0079 }
            if (r1 != 0) goto L_0x0032
            goto L_0x004d
        L_0x0032:
            r2 = r1[r10]     // Catch:{ all -> 0x0079 }
            int r2 = r2.intValue()     // Catch:{ all -> 0x0079 }
            if (r2 != r11) goto L_0x0040
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.zzj     // Catch:{ all -> 0x0079 }
            r1.remove(r6)     // Catch:{ all -> 0x0079 }
            goto L_0x0055
        L_0x0040:
            r2 = r1[r10]     // Catch:{ all -> 0x0079 }
            int r2 = r2.intValue()     // Catch:{ all -> 0x0079 }
            int r2 = r2 - r11
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0079 }
            r1[r10] = r2     // Catch:{ all -> 0x0079 }
        L_0x004d:
            boolean r1 = r12.zzi     // Catch:{ all -> 0x0079 }
            if (r1 != 0) goto L_0x0074
            int r1 = r12.zzl     // Catch:{ all -> 0x0079 }
            if (r1 != r11) goto L_0x0074
        L_0x0055:
            com.google.android.gms.common.stats.WakeLockTracker r1 = com.google.android.gms.common.stats.WakeLockTracker.getInstance()     // Catch:{ all -> 0x0079 }
            android.content.Context r2 = r12.zzh     // Catch:{ all -> 0x0079 }
            android.os.PowerManager$WakeLock r3 = r12.zzb     // Catch:{ all -> 0x0079 }
            java.lang.String r3 = com.google.android.gms.common.stats.StatsUtils.getEventKey(r3, r6)     // Catch:{ all -> 0x0079 }
            java.lang.String r5 = r12.zze     // Catch:{ all -> 0x0079 }
            int r8 = r12.zzd     // Catch:{ all -> 0x0079 }
            java.util.List r9 = r12.zza()     // Catch:{ all -> 0x0079 }
            r4 = 8
            r7 = 0
            r1.registerEvent(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0079 }
            int r1 = r12.zzl     // Catch:{ all -> 0x0079 }
            int r1 = r1 - r11
            r12.zzl = r1     // Catch:{ all -> 0x0079 }
        L_0x0074:
            monitor-exit(r0)     // Catch:{ all -> 0x0079 }
            r12.zza((int) r10)
            return
        L_0x0079:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0079 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.stats.WakeLock.release():void");
    }

    /* access modifiers changed from: private */
    public final void zza(int i) {
        if (this.zzb.isHeld()) {
            try {
                this.zzb.release();
            } catch (RuntimeException e) {
                if (e.getClass().equals(RuntimeException.class)) {
                    Log.e("WakeLock", String.valueOf(this.zze).concat(" was already released!"), e);
                } else {
                    throw e;
                }
            }
            this.zzb.isHeld();
        }
    }

    private final String zza(String str) {
        if (this.zzi) {
            return !TextUtils.isEmpty(str) ? str : this.zzf;
        }
        return this.zzf;
    }

    public void setReferenceCounted(boolean z) {
        this.zzb.setReferenceCounted(z);
        this.zzi = z;
    }

    public boolean isHeld() {
        return this.zzb.isHeld();
    }
}
