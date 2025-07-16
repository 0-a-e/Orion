package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
final class zzhl implements zzkt {
    final /* synthetic */ zzhw zza;

    zzhl(zzhw zzhw) {
        this.zza = zzhw;
    }

    public final void zza(String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            zzhw zzhw = this.zza;
            zzfu.zzP();
            zzhw.zzx(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_err", zzhw.zzs.zzay().currentTimeMillis(), bundle, false, true, false, str);
            return;
        }
        this.zza.zzs(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_err", bundle);
    }
}
