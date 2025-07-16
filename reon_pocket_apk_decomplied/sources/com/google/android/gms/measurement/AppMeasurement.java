package com.google.android.gms.measurement;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzfu;
import com.google.android.gms.measurement.internal.zzgq;
import com.google.android.gms.measurement.internal.zzgu;
import com.google.android.gms.measurement.internal.zzgv;
import com.google.android.gms.measurement.internal.zzhx;
import com.google.android.gms.measurement.internal.zzic;
import com.google.android.gms.measurement.internal.zzkq;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Deprecated
/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
public class AppMeasurement {
    public static final String CRASH_ORIGIN = "crash";
    public static final String FCM_ORIGIN = "fcm";
    public static final String FIAM_ORIGIN = "fiam";
    private static volatile AppMeasurement zza;
    private final zzfu zzb;
    private final zzhx zzc;

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
    public interface EventInterceptor extends zzgu {
        void interceptEvent(String str, String str2, Bundle bundle, long j);
    }

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
    public interface OnEventListener extends zzgv {
        void onEvent(String str, String str2, Bundle bundle, long j);
    }

    public AppMeasurement(zzfu zzfu) {
        Preconditions.checkNotNull(zzfu);
        this.zzb = zzfu;
        this.zzc = null;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.measurement.AppMeasurement getInstance(android.content.Context r14) {
        /*
            com.google.android.gms.measurement.AppMeasurement r0 = zza
            if (r0 != 0) goto L_0x005d
            java.lang.Class<com.google.android.gms.measurement.AppMeasurement> r0 = com.google.android.gms.measurement.AppMeasurement.class
            monitor-enter(r0)
            com.google.android.gms.measurement.AppMeasurement r1 = zza     // Catch:{ all -> 0x005a }
            if (r1 != 0) goto L_0x0058
            r1 = 0
            java.lang.String r2 = "com.google.firebase.analytics.FirebaseAnalytics"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x0032 }
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{  }
            java.lang.Class<android.content.Context> r5 = android.content.Context.class
            r6 = 0
            r4[r6] = r5     // Catch:{  }
            java.lang.Class<android.os.Bundle> r5 = android.os.Bundle.class
            r7 = 1
            r4[r7] = r5     // Catch:{  }
            java.lang.String r5 = "getScionFrontendApiImplementation"
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r5, r4)     // Catch:{  }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{  }
            r3[r6] = r14     // Catch:{  }
            r3[r7] = r1     // Catch:{  }
            java.lang.Object r2 = r2.invoke(r1, r3)     // Catch:{  }
            com.google.android.gms.measurement.internal.zzhx r2 = (com.google.android.gms.measurement.internal.zzhx) r2     // Catch:{  }
            goto L_0x0033
        L_0x0032:
            r2 = r1
        L_0x0033:
            if (r2 == 0) goto L_0x003d
            com.google.android.gms.measurement.AppMeasurement r14 = new com.google.android.gms.measurement.AppMeasurement     // Catch:{ all -> 0x005a }
            r14.<init>((com.google.android.gms.measurement.internal.zzhx) r2)     // Catch:{ all -> 0x005a }
            zza = r14     // Catch:{ all -> 0x005a }
            goto L_0x0058
        L_0x003d:
            com.google.android.gms.internal.measurement.zzcl r13 = new com.google.android.gms.internal.measurement.zzcl     // Catch:{ all -> 0x005a }
            r11 = 0
            r12 = 0
            r3 = 0
            r5 = 0
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 0
            r2 = r13
            r2.<init>(r3, r5, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x005a }
            com.google.android.gms.measurement.internal.zzfu r14 = com.google.android.gms.measurement.internal.zzfu.zzC(r14, r13, r1)     // Catch:{ all -> 0x005a }
            com.google.android.gms.measurement.AppMeasurement r1 = new com.google.android.gms.measurement.AppMeasurement     // Catch:{ all -> 0x005a }
            r1.<init>((com.google.android.gms.measurement.internal.zzfu) r14)     // Catch:{ all -> 0x005a }
            zza = r1     // Catch:{ all -> 0x005a }
        L_0x0058:
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            goto L_0x005d
        L_0x005a:
            r14 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            throw r14
        L_0x005d:
            com.google.android.gms.measurement.AppMeasurement r14 = zza
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.AppMeasurement.getInstance(android.content.Context):com.google.android.gms.measurement.AppMeasurement");
    }

    public void beginAdUnitExposure(String str) {
        zzhx zzhx = this.zzc;
        if (zzhx != null) {
            zzhx.zzl(str);
            return;
        }
        Preconditions.checkNotNull(this.zzb);
        this.zzb.zzB().zza(str, this.zzb.zzay().elapsedRealtime());
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        zzhx zzhx = this.zzc;
        if (zzhx != null) {
            zzhx.zzo(str, str2, bundle);
            return;
        }
        Preconditions.checkNotNull(this.zzb);
        this.zzb.zzk().zzO(str, str2, bundle);
    }

    public void endAdUnitExposure(String str) {
        zzhx zzhx = this.zzc;
        if (zzhx != null) {
            zzhx.zzm(str);
            return;
        }
        Preconditions.checkNotNull(this.zzb);
        this.zzb.zzB().zzb(str, this.zzb.zzay().elapsedRealtime());
    }

    public long generateEventId() {
        zzhx zzhx = this.zzc;
        if (zzhx != null) {
            return zzhx.zzk();
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzl().zzd();
    }

    public String getAppInstanceId() {
        zzhx zzhx = this.zzc;
        if (zzhx != null) {
            return zzhx.zzi();
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzk().zzD();
    }

    public Boolean getBoolean() {
        zzhx zzhx = this.zzc;
        if (zzhx != null) {
            return (Boolean) zzhx.zzr(4);
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzk().zzi();
    }

    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        List<Bundle> list;
        int i;
        zzhx zzhx = this.zzc;
        if (zzhx != null) {
            list = zzhx.zzp(str, str2);
        } else {
            Preconditions.checkNotNull(this.zzb);
            list = this.zzb.zzk().zzP(str, str2);
        }
        if (list == null) {
            i = 0;
        } else {
            i = list.size();
        }
        ArrayList arrayList = new ArrayList(i);
        for (Bundle conditionalUserProperty : list) {
            arrayList.add(new ConditionalUserProperty(conditionalUserProperty));
        }
        return arrayList;
    }

    public String getCurrentScreenClass() {
        zzhx zzhx = this.zzc;
        if (zzhx != null) {
            return zzhx.zzh();
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzk().zzS();
    }

    public String getCurrentScreenName() {
        zzhx zzhx = this.zzc;
        if (zzhx != null) {
            return zzhx.zzg();
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzk().zzR();
    }

    public Double getDouble() {
        zzhx zzhx = this.zzc;
        if (zzhx != null) {
            return (Double) zzhx.zzr(2);
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzk().zzm();
    }

    public String getGmpAppId() {
        zzhx zzhx = this.zzc;
        if (zzhx != null) {
            return zzhx.zzj();
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzk().zzT();
    }

    public Integer getInteger() {
        zzhx zzhx = this.zzc;
        if (zzhx != null) {
            return (Integer) zzhx.zzr(3);
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzk().zzl();
    }

    public Long getLong() {
        zzhx zzhx = this.zzc;
        if (zzhx != null) {
            return (Long) zzhx.zzr(1);
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzk().zzk();
    }

    public int getMaxUserProperties(String str) {
        zzhx zzhx = this.zzc;
        if (zzhx != null) {
            return zzhx.zzq(str);
        }
        Preconditions.checkNotNull(this.zzb);
        this.zzb.zzk().zzL(str);
        return 25;
    }

    public String getString() {
        zzhx zzhx = this.zzc;
        if (zzhx != null) {
            return (String) zzhx.zzr(0);
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzk().zzj();
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        zzhx zzhx = this.zzc;
        if (zzhx != null) {
            return zzhx.zzc(str, str2, z);
        }
        Preconditions.checkNotNull(this.zzb);
        return this.zzb.zzk().zzQ(str, str2, z);
    }

    public void logEventInternal(String str, String str2, Bundle bundle) {
        zzhx zzhx = this.zzc;
        if (zzhx != null) {
            zzhx.zza(str, str2, bundle);
            return;
        }
        Preconditions.checkNotNull(this.zzb);
        this.zzb.zzk().zzs(str, str2, bundle);
    }

    public void logEventInternalNoInterceptor(String str, String str2, Bundle bundle, long j) {
        zzhx zzhx = this.zzc;
        if (zzhx != null) {
            zzhx.zzb(str, str2, bundle, j);
            return;
        }
        Preconditions.checkNotNull(this.zzb);
        this.zzb.zzk().zzv(str, str2, bundle, true, false, j);
    }

    public void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        zzhx zzhx = this.zzc;
        if (zzhx != null) {
            zzhx.zze(onEventListener);
            return;
        }
        Preconditions.checkNotNull(this.zzb);
        this.zzb.zzk().zzJ(onEventListener);
    }

    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        zzhx zzhx = this.zzc;
        if (zzhx != null) {
            zzhx.zzn(conditionalUserProperty.zza());
            return;
        }
        Preconditions.checkNotNull(this.zzb);
        this.zzb.zzk().zzM(conditionalUserProperty.zza());
    }

    public void setEventInterceptor(EventInterceptor eventInterceptor) {
        zzhx zzhx = this.zzc;
        if (zzhx != null) {
            zzhx.zzd(eventInterceptor);
            return;
        }
        Preconditions.checkNotNull(this.zzb);
        this.zzb.zzk().zzI(eventInterceptor);
    }

    public void unregisterOnMeasurementEventListener(OnEventListener onEventListener) {
        zzhx zzhx = this.zzc;
        if (zzhx != null) {
            zzhx.zzf(onEventListener);
            return;
        }
        Preconditions.checkNotNull(this.zzb);
        this.zzb.zzk().zzK(onEventListener);
    }

    public AppMeasurement(zzhx zzhx) {
        Preconditions.checkNotNull(zzhx);
        this.zzc = zzhx;
        this.zzb = null;
    }

    public Map<String, Object> getUserProperties(boolean z) {
        zzhx zzhx = this.zzc;
        if (zzhx != null) {
            return zzhx.zzc((String) null, (String) null, z);
        }
        Preconditions.checkNotNull(this.zzb);
        List<zzkq> zzC = this.zzb.zzk().zzC(z);
        ArrayMap arrayMap = new ArrayMap(zzC.size());
        for (zzkq next : zzC) {
            Object zza2 = next.zza();
            if (zza2 != null) {
                arrayMap.put(next.zzb, zza2);
            }
        }
        return arrayMap;
    }

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
    public static class ConditionalUserProperty {
        public boolean mActive;
        public String mAppId;
        public long mCreationTimestamp;
        public String mExpiredEventName;
        public Bundle mExpiredEventParams;
        public String mName;
        public String mOrigin;
        public long mTimeToLive;
        public String mTimedOutEventName;
        public Bundle mTimedOutEventParams;
        public String mTriggerEventName;
        public long mTriggerTimeout;
        public String mTriggeredEventName;
        public Bundle mTriggeredEventParams;
        public long mTriggeredTimestamp;
        public Object mValue;

        public ConditionalUserProperty() {
        }

        ConditionalUserProperty(Bundle bundle) {
            Preconditions.checkNotNull(bundle);
            this.mAppId = (String) zzgq.zzb(bundle, "app_id", String.class, null);
            this.mOrigin = (String) zzgq.zzb(bundle, "origin", String.class, null);
            this.mName = (String) zzgq.zzb(bundle, "name", String.class, null);
            this.mValue = zzgq.zzb(bundle, "value", Object.class, null);
            this.mTriggerEventName = (String) zzgq.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
            this.mTriggerTimeout = ((Long) zzgq.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L)).longValue();
            this.mTimedOutEventName = (String) zzgq.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
            this.mTimedOutEventParams = (Bundle) zzgq.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
            this.mTriggeredEventName = (String) zzgq.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
            this.mTriggeredEventParams = (Bundle) zzgq.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
            this.mTimeToLive = ((Long) zzgq.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L)).longValue();
            this.mExpiredEventName = (String) zzgq.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
            this.mExpiredEventParams = (Bundle) zzgq.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
            this.mActive = ((Boolean) zzgq.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.class, false)).booleanValue();
            this.mCreationTimestamp = ((Long) zzgq.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.class, 0L)).longValue();
            this.mTriggeredTimestamp = ((Long) zzgq.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.class, 0L)).longValue();
        }

        /* access modifiers changed from: package-private */
        public final Bundle zza() {
            Bundle bundle = new Bundle();
            String str = this.mAppId;
            if (str != null) {
                bundle.putString("app_id", str);
            }
            String str2 = this.mOrigin;
            if (str2 != null) {
                bundle.putString("origin", str2);
            }
            String str3 = this.mName;
            if (str3 != null) {
                bundle.putString("name", str3);
            }
            Object obj = this.mValue;
            if (obj != null) {
                zzgq.zza(bundle, obj);
            }
            String str4 = this.mTriggerEventName;
            if (str4 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, str4);
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, this.mTriggerTimeout);
            String str5 = this.mTimedOutEventName;
            if (str5 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, str5);
            }
            Bundle bundle2 = this.mTimedOutEventParams;
            if (bundle2 != null) {
                bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, bundle2);
            }
            String str6 = this.mTriggeredEventName;
            if (str6 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, str6);
            }
            Bundle bundle3 = this.mTriggeredEventParams;
            if (bundle3 != null) {
                bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, bundle3);
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, this.mTimeToLive);
            String str7 = this.mExpiredEventName;
            if (str7 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str7);
            }
            Bundle bundle4 = this.mExpiredEventParams;
            if (bundle4 != null) {
                bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle4);
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, this.mCreationTimestamp);
            bundle.putBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, this.mActive);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, this.mTriggeredTimestamp);
            return bundle;
        }

        public ConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
            Preconditions.checkNotNull(conditionalUserProperty);
            this.mAppId = conditionalUserProperty.mAppId;
            this.mOrigin = conditionalUserProperty.mOrigin;
            this.mCreationTimestamp = conditionalUserProperty.mCreationTimestamp;
            this.mName = conditionalUserProperty.mName;
            Object obj = conditionalUserProperty.mValue;
            if (obj != null) {
                Object zzb = zzic.zzb(obj);
                this.mValue = zzb;
                if (zzb == null) {
                    this.mValue = conditionalUserProperty.mValue;
                }
            }
            this.mActive = conditionalUserProperty.mActive;
            this.mTriggerEventName = conditionalUserProperty.mTriggerEventName;
            this.mTriggerTimeout = conditionalUserProperty.mTriggerTimeout;
            this.mTimedOutEventName = conditionalUserProperty.mTimedOutEventName;
            Bundle bundle = conditionalUserProperty.mTimedOutEventParams;
            if (bundle != null) {
                this.mTimedOutEventParams = new Bundle(bundle);
            }
            this.mTriggeredEventName = conditionalUserProperty.mTriggeredEventName;
            Bundle bundle2 = conditionalUserProperty.mTriggeredEventParams;
            if (bundle2 != null) {
                this.mTriggeredEventParams = new Bundle(bundle2);
            }
            this.mTriggeredTimestamp = conditionalUserProperty.mTriggeredTimestamp;
            this.mTimeToLive = conditionalUserProperty.mTimeToLive;
            this.mExpiredEventName = conditionalUserProperty.mExpiredEventName;
            Bundle bundle3 = conditionalUserProperty.mExpiredEventParams;
            if (bundle3 != null) {
                this.mExpiredEventParams = new Bundle(bundle3);
            }
        }
    }
}
