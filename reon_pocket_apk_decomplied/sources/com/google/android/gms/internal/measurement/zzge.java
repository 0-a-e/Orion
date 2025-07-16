package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
public final class zzge extends zzjz<zzgf, zzge> implements zzlj {
    private zzge() {
        super(zzgf.zzg);
    }

    public final zzge zza(int i) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzgf.zzh((zzgf) this.zza, i);
        return this;
    }

    public final zzge zzb(Iterable<? extends Long> iterable) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzgf.zzi((zzgf) this.zza, iterable);
        return this;
    }

    /* synthetic */ zzge(zzff zzff) {
        super(zzgf.zzg);
    }
}
