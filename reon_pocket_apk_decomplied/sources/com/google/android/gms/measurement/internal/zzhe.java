package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
final class zzhe implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzhw zzc;

    zzhe(zzhw zzhw, AtomicReference atomicReference, boolean z) {
        this.zzc = zzhw;
        this.zza = atomicReference;
        this.zzb = z;
    }

    public final void run() {
        this.zzc.zzs.zzy().zzt(this.zza, this.zzb);
    }
}
