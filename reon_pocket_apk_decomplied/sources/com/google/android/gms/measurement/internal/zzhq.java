package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
final class zzhq implements Runnable {
    final /* synthetic */ Boolean zza;
    final /* synthetic */ zzhw zzb;

    zzhq(zzhw zzhw, Boolean bool) {
        this.zzb = zzhw;
        this.zza = bool;
    }

    public final void run() {
        this.zzb.zzY(this.zza, true);
    }
}
