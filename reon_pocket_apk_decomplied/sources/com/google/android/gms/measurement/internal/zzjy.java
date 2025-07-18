package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzoa;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
final class zzjy {
    final /* synthetic */ zzjz zza;

    zzjy(zzjz zzjz) {
        this.zza = zzjz;
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zza.zzg();
        if (this.zza.zzs.zzd().zzl(this.zza.zzs.zzay().currentTimeMillis())) {
            this.zza.zzs.zzd().zzg.zzb(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.zza.zzs.zzau().zzk().zza("Detected application was in foreground");
                zzc(this.zza.zzs.zzay().currentTimeMillis(), false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(long j, boolean z) {
        this.zza.zzg();
        this.zza.zzl();
        if (this.zza.zzs.zzd().zzl(j)) {
            this.zza.zzs.zzd().zzg.zzb(true);
        }
        this.zza.zzs.zzd().zzj.zzb(j);
        if (this.zza.zzs.zzd().zzg.zza()) {
            zzc(j, z);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc(long j, boolean z) {
        this.zza.zzg();
        if (this.zza.zzs.zzF()) {
            this.zza.zzs.zzd().zzj.zzb(j);
            this.zza.zzs.zzau().zzk().zzb("Session started, time", Long.valueOf(this.zza.zzs.zzay().elapsedRealtime()));
            long j2 = j / 1000;
            Long valueOf = Long.valueOf(j2);
            this.zza.zzs.zzk().zzB(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_sid", valueOf, j);
            this.zza.zzs.zzd().zzg.zzb(false);
            Bundle bundle = new Bundle();
            valueOf.getClass();
            bundle.putLong("_sid", j2);
            if (this.zza.zzs.zzc().zzn((String) null, zzea.zzah) && z) {
                bundle.putLong("_aib", 1);
            }
            this.zza.zzs.zzk().zzt(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_s", j, bundle);
            zzoa.zzb();
            if (this.zza.zzs.zzc().zzn((String) null, zzea.zzam)) {
                String zza2 = this.zza.zzs.zzd().zzo.zza();
                if (!TextUtils.isEmpty(zza2)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("_ffr", zza2);
                    this.zza.zzs.zzk().zzt(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ssr", j, bundle2);
                }
            }
        }
    }
}
