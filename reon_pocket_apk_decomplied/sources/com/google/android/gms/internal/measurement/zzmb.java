package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
final class zzmb implements Iterator<Map.Entry> {
    final /* synthetic */ zzmd zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator<Map.Entry> zzd;

    /* synthetic */ zzmb(zzmd zzmd, zzlw zzlw) {
        this.zza = zzmd;
    }

    private final Iterator<Map.Entry> zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzc.entrySet().iterator();
        }
        return this.zzd;
    }

    public final boolean hasNext() {
        if (this.zzb + 1 < this.zza.zzb.size()) {
            return true;
        }
        if (this.zza.zzc.isEmpty()) {
            return false;
        }
        if (zza().hasNext()) {
            return true;
        }
        return false;
    }

    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        if (i < this.zza.zzb.size()) {
            return (Map.Entry) this.zza.zzb.get(this.zzb);
        }
        return zza().next();
    }

    public final void remove() {
        if (this.zzc) {
            this.zzc = false;
            this.zza.zzm();
            if (this.zzb < this.zza.zzb.size()) {
                zzmd zzmd = this.zza;
                int i = this.zzb;
                this.zzb = i - 1;
                Object unused = zzmd.zzk(i);
                return;
            }
            zza().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
