package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
final class zzft implements Runnable {
    final /* synthetic */ zzgw zza;
    final /* synthetic */ zzfu zzb;

    zzft(zzfu zzfu, zzgw zzgw) {
        this.zzb = zzfu;
        this.zza = zzgw;
    }

    public final void run() {
        zzfu.zzO(this.zzb, this.zza);
        this.zzb.zza(this.zza.zzg);
    }
}
