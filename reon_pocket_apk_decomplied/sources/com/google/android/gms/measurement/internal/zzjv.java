package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
final class zzjv {
    final /* synthetic */ zzjz zza;
    private zzju zzb;

    zzjv(zzjz zzjz) {
        this.zza = zzjz;
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zza.zzg();
        if (this.zzb != null) {
            this.zza.zzd.removeCallbacks(this.zzb);
        }
        if (this.zza.zzs.zzc().zzn((String) null, zzea.zzar)) {
            this.zza.zzs.zzd().zzl.zzb(false);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(long j) {
        this.zzb = new zzju(this, this.zza.zzs.zzay().currentTimeMillis(), j);
        this.zza.zzd.postDelayed(this.zzb, 2000);
    }
}
