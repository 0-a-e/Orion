package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
final class zzhv implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ zzhw zza;

    /* synthetic */ zzhv(zzhw zzhw, zzhi zzhi) {
        this.zza = zzhw;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zzfu zzfu;
        try {
            this.zza.zzs.zzau().zzk().zza("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent == null) {
                zzfu = this.zza.zzs;
            } else {
                Uri data = intent.getData();
                if (data != null) {
                    if (data.isHierarchical()) {
                        this.zza.zzs.zzl();
                        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                        this.zza.zzs.zzav().zzh(new zzhu(this, bundle == null, data, ("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra)) ? "gs" : DebugKt.DEBUG_PROPERTY_VALUE_AUTO, data.getQueryParameter("referrer")));
                        zzfu = this.zza.zzs;
                    }
                }
                zzfu = this.zza.zzs;
            }
        } catch (RuntimeException e) {
            this.zza.zzs.zzau().zzb().zzb("Throwable caught in onActivityCreated", e);
            zzfu = this.zza.zzs;
        } catch (Throwable th) {
            this.zza.zzs.zzx().zzo(activity, bundle);
            throw th;
        }
        zzfu.zzx().zzo(activity, bundle);
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzs.zzx().zzt(activity);
    }

    public final void onActivityPaused(Activity activity) {
        this.zza.zzs.zzx().zzr(activity);
        zzjz zzh = this.zza.zzs.zzh();
        zzh.zzs.zzav().zzh(new zzjs(zzh, zzh.zzs.zzay().elapsedRealtime()));
    }

    public final void onActivityResumed(Activity activity) {
        zzjz zzh = this.zza.zzs.zzh();
        zzh.zzs.zzav().zzh(new zzjr(zzh, zzh.zzs.zzay().elapsedRealtime()));
        this.zza.zzs.zzx().zzq(activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzs.zzx().zzs(activity, bundle);
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
