package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
final class zzbe implements zzbf {
    private final zzg zza;
    private final String zzb;

    public zzbe(zzg zzg, String str) {
        this.zza = zzg;
        this.zzb = str;
    }

    public final zzg zza(zzap zzap) {
        zzg zzc = this.zza.zzc();
        zzc.zzf(this.zzb, zzap);
        return zzc;
    }
}
