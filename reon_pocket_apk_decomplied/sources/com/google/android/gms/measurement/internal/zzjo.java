package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
final class zzjo implements Runnable {
    final /* synthetic */ zzkn zza;
    final /* synthetic */ Runnable zzb;

    zzjo(zzjq zzjq, zzkn zzkn, Runnable runnable) {
        this.zza = zzkn;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzG();
        this.zza.zzF(this.zzb);
        this.zza.zzB();
    }
}
