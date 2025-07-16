package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
final class zzhb implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzhw zzb;

    zzhb(zzhw zzhw, long j) {
        this.zzb = zzhw;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzs.zzd().zzf.zzb(this.zza);
        this.zzb.zzs.zzau().zzj().zzb("Session timeout duration set", Long.valueOf(this.zza));
    }
}
