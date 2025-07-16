package com.google.android.gms.internal.measurement;

import androidx.core.app.NotificationCompat;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
public final class zzt extends zzai {
    /* access modifiers changed from: private */
    public final zzr zza;

    public zzt(zzr zzr) {
        super("internal.logger");
        this.zza = zzr;
        this.zze.put("log", new zzs(this, false, true));
        this.zze.put(NotificationCompat.GROUP_KEY_SILENT, new zzp(this, NotificationCompat.GROUP_KEY_SILENT));
        ((zzai) this.zze.get(NotificationCompat.GROUP_KEY_SILENT)).zzm("log", new zzs(this, true, true));
        this.zze.put("unmonitored", new zzq(this, "unmonitored"));
        ((zzai) this.zze.get("unmonitored")).zzm("log", new zzs(this, false, false));
    }

    public final zzap zza(zzg zzg, List<zzap> list) {
        return zzap.zzf;
    }
}
