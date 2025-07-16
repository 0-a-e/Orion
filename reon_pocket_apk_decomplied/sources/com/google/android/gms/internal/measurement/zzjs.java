package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
final class zzjs {
    private static final zzjq<?> zza = new zzjr();
    private static final zzjq<?> zzb;

    static {
        zzjq<?> zzjq = null;
        try {
            zzjq = (zzjq) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
        }
        zzb = zzjq;
    }

    static zzjq<?> zza() {
        return zza;
    }

    static zzjq<?> zzb() {
        zzjq<?> zzjq = zzb;
        if (zzjq != null) {
            return zzjq;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
