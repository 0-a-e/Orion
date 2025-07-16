package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
final class zzgj implements Callable<List<zzks>> {
    final /* synthetic */ String zza;
    final /* synthetic */ zzgm zzb;

    zzgj(zzgm zzgm, String str) {
        this.zzb = zzgm;
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        this.zzb.zza.zzG();
        return this.zzb.zza.zzi().zzl(this.zza);
    }
}
