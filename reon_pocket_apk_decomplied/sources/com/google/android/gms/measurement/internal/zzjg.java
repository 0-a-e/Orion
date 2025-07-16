package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
final class zzjg implements Runnable {
    final /* synthetic */ zzed zza;
    final /* synthetic */ zzjj zzb;

    zzjg(zzjj zzjj, zzed zzed) {
        this.zzb = zzjj;
        this.zza = zzed;
    }

    public final void run() {
        synchronized (this.zzb) {
            boolean unused = this.zzb.zzb = false;
            if (!this.zzb.zza.zzh()) {
                this.zzb.zza.zzs.zzau().zzj().zza("Connected to remote service");
                this.zzb.zza.zzE(this.zza);
            }
        }
    }
}
