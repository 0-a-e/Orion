package com.google.android.gms.measurement.internal;

import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzc;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
final class zzfi extends LruCache<String, zzc> {
    final /* synthetic */ zzfl zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfi(zzfl zzfl, int i) {
        super(20);
        this.zza = zzfl;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        String str = (String) obj;
        Preconditions.checkNotEmpty(str);
        return zzfl.zzo(this.zza, str);
    }
}
