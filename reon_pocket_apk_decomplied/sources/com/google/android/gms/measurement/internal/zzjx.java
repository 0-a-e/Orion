package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzom;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
final class zzjx {
    protected long zza;
    protected long zzb;
    final /* synthetic */ zzjz zzc;
    private final zzal zzd;

    public zzjx(zzjz zzjz) {
        this.zzc = zzjz;
        this.zzd = new zzjw(this, zzjz.zzs);
        long elapsedRealtime = zzjz.zzs.zzay().elapsedRealtime();
        this.zza = elapsedRealtime;
        this.zzb = elapsedRealtime;
    }

    /* access modifiers changed from: package-private */
    public final void zza(long j) {
        this.zzc.zzg();
        this.zzd.zzd();
        this.zza = j;
        this.zzb = j;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(long j) {
        this.zzd.zzd();
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        this.zzd.zzd();
        this.zza = 0;
        this.zzb = 0;
    }

    public final boolean zzd(boolean z, boolean z2, long j) {
        this.zzc.zzg();
        this.zzc.zzb();
        zzom.zzb();
        if (!this.zzc.zzs.zzc().zzn((String) null, zzea.zzan)) {
            this.zzc.zzs.zzd().zzj.zzb(this.zzc.zzs.zzay().currentTimeMillis());
        } else if (this.zzc.zzs.zzF()) {
            this.zzc.zzs.zzd().zzj.zzb(this.zzc.zzs.zzay().currentTimeMillis());
        }
        long j2 = j - this.zza;
        if (z || j2 >= 1000) {
            if (!z2) {
                j2 = j - this.zzb;
                this.zzb = j;
            }
            this.zzc.zzs.zzau().zzk().zzb("Recording user engagement, ms", Long.valueOf(j2));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j2);
            zzik.zzm(this.zzc.zzs.zzx().zzh(!this.zzc.zzs.zzc().zzt()), bundle, true);
            if (!this.zzc.zzs.zzc().zzn((String) null, zzea.zzT) && z2) {
                bundle.putLong("_fr", 1);
            }
            if (!this.zzc.zzs.zzc().zzn((String) null, zzea.zzT) || !z2) {
                this.zzc.zzs.zzk().zzs(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_e", bundle);
            }
            this.zza = j;
            this.zzd.zzd();
            this.zzd.zzb(3600000);
            return true;
        }
        this.zzc.zzs.zzau().zzk().zzb("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j2));
        return false;
    }
}
