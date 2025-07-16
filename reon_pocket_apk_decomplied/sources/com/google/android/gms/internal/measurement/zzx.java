package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
final class zzx extends zzai {
    zzx(zzy zzy, String str) {
        super("getVersion");
    }

    public final zzap zza(zzg zzg, List<zzap> list) {
        return new zzah(Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
    }
}
