package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
final class zzml implements Iterator<String> {
    final Iterator<String> zza;
    final /* synthetic */ zzmm zzb;

    zzml(zzmm zzmm) {
        this.zzb = zzmm;
        this.zza = zzmm.zza.iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return this.zza.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
