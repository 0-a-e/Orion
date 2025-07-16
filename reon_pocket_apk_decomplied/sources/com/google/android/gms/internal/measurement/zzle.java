package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
final class zzle {
    private static final zzld zza;
    private static final zzld zzb = new zzld();

    static {
        zzld zzld = null;
        try {
            zzld = (zzld) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
        }
        zza = zzld;
    }

    static zzld zza() {
        return zza;
    }

    static zzld zzb() {
        return zzb;
    }
}
