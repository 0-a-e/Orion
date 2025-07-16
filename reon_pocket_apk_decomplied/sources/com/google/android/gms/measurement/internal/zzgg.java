package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
final class zzgg implements Runnable {
    final /* synthetic */ zzas zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzgm zzc;

    zzgg(zzgm zzgm, zzas zzas, String str) {
        this.zzc = zzgm;
        this.zza = zzas;
        this.zzb = str;
    }

    public final void run() {
        this.zzc.zza.zzG();
        this.zzc.zza.zzv(this.zza, this.zzb);
    }
}
