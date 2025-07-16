package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
final class zzkg implements Runnable {
    final /* synthetic */ zzko zza;
    final /* synthetic */ zzkn zzb;

    zzkg(zzkn zzkn, zzko zzko) {
        this.zzb = zzkn;
        this.zza = zzko;
    }

    public final void run() {
        zzkn.zzW(this.zzb, this.zza);
        this.zzb.zzc();
    }
}
