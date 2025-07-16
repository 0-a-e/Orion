package com.google.android.gms.internal.firebase_messaging;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
final class zzq extends zzn {
    private final zzp zza = new zzp();

    zzq() {
    }

    public final void zza(Throwable th, Throwable th2) {
        if (th2 != th) {
            this.zza.zza(th, true).add(th2);
            return;
        }
        throw new IllegalArgumentException("Self suppression is not allowed.", th2);
    }
}
