package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
public final class zzf {
    final zzax zza;
    final zzg zzb;
    final zzg zzc;
    final zzj zzd;

    public zzf() {
        zzax zzax = new zzax();
        this.zza = zzax;
        zzg zzg = new zzg((zzg) null, zzax);
        this.zzc = zzg;
        this.zzb = zzg.zzc();
        zzj zzj = new zzj();
        this.zzd = zzj;
        zzg.zze("require", new zzv(zzj));
        zzj.zza("internal.platform", zze.zza);
        zzg.zze("runtime.counter", new zzah(Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)));
    }

    public final zzap zza(zzg zzg, zzgt... zzgtArr) {
        zzap zzap = zzap.zzf;
        for (zzgt zzb2 : zzgtArr) {
            zzap = zzi.zzb(zzb2);
            zzh.zzk(this.zzc);
            if ((zzap instanceof zzaq) || (zzap instanceof zzao)) {
                zzap = this.zza.zzb(zzg, zzap);
            }
        }
        return zzap;
    }
}
