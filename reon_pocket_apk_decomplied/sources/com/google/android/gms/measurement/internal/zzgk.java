package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
final class zzgk implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzgm zzb;

    zzgk(zzgm zzgm, zzp zzp) {
        this.zzb = zzgm;
        this.zza = zzp;
    }

    public final void run() {
        this.zzb.zza.zzG();
        this.zzb.zza.zzO(this.zza);
    }
}
