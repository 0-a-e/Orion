package com.google.android.gms.internal.firebase_messaging;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
final class zzk extends FilterInputStream {
    private long zza;
    private long zzb = -1;

    zzk(InputStream inputStream, long j) {
        super(inputStream);
        inputStream.getClass();
        this.zza = 1048577;
    }

    public final int available() throws IOException {
        return (int) Math.min((long) this.in.available(), this.zza);
    }

    public final synchronized void mark(int i) {
        this.in.mark(i);
        this.zzb = this.zza;
    }

    public final int read() throws IOException {
        if (this.zza == 0) {
            return -1;
        }
        int read = this.in.read();
        if (read != -1) {
            this.zza--;
        }
        return read;
    }

    public final synchronized void reset() throws IOException {
        if (!this.in.markSupported()) {
            throw new IOException("Mark not supported");
        } else if (this.zzb != -1) {
            this.in.reset();
            this.zza = this.zzb;
        } else {
            throw new IOException("Mark not set");
        }
    }

    public final long skip(long j) throws IOException {
        long skip = this.in.skip(Math.min(j, this.zza));
        this.zza -= skip;
        return skip;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.zza;
        if (j == 0) {
            return -1;
        }
        int read = this.in.read(bArr, i, (int) Math.min((long) i2, j));
        if (read != -1) {
            this.zza -= (long) read;
        }
        return read;
    }
}
