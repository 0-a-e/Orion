package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
final class zzij extends zzig {
    private final zzii zza = new zzii();

    zzij() {
    }

    public final void zza(Throwable th, Throwable th2) {
        if (th2 != th) {
            this.zza.zza(th, true).add(th2);
            return;
        }
        throw new IllegalArgumentException("Self suppression is not allowed.", th2);
    }
}
