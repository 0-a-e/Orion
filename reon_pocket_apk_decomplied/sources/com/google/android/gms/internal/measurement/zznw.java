package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
public final class zznw implements zznv {
    public static final zzht<Boolean> zza;
    public static final zzht<Boolean> zzb;

    static {
        zzhr zzhr = new zzhr(zzhk.zza("com.google.android.gms.measurement"));
        zza = zzhr.zzb("measurement.euid.client.dev", false);
        zzb = zzhr.zzb("measurement.euid.service", false);
    }

    public final boolean zza() {
        return zza.zze().booleanValue();
    }

    public final boolean zzb() {
        return zzb.zze().booleanValue();
    }
}
