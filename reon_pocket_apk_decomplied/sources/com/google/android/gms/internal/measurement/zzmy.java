package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
public enum zzmy {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzjd.zzb),
    ENUM((String) null),
    MESSAGE((String) null);
    
    private final Object zzj;

    private zzmy(Object obj) {
        this.zzj = obj;
    }
}
