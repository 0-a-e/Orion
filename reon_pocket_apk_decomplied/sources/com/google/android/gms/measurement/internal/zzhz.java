package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
final class zzhz implements Runnable {
    final /* synthetic */ zzia zza;
    private final URL zzb;
    private final String zzc;
    private final zzfs zzd;

    public zzhz(zzia zzia, String str, URL url, byte[] bArr, Map map, zzfs zzfs, byte[] bArr2) {
        this.zza = zzia;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzfs);
        this.zzb = url;
        this.zzd = zzfs;
        this.zzc = str;
    }

    private final void zzb(int i, Exception exc, byte[] bArr, Map<String, List<String>> map) {
        this.zza.zzs.zzav().zzh(new zzhy(this, i, exc, bArr, map));
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0046 A[SYNTHETIC, Splitter:B:27:0x0046] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r10 = this;
            com.google.android.gms.measurement.internal.zzia r0 = r10.zza
            r0.zzaw()
            r0 = 0
            r1 = 0
            com.google.android.gms.measurement.internal.zzia r2 = r10.zza     // Catch:{ IOException -> 0x006e, all -> 0x0060 }
            java.net.URL r3 = r10.zzb     // Catch:{ IOException -> 0x006e, all -> 0x0060 }
            java.net.HttpURLConnection r2 = r2.zzd(r3)     // Catch:{ IOException -> 0x006e, all -> 0x0060 }
            int r3 = r2.getResponseCode()     // Catch:{ IOException -> 0x005a, all -> 0x0054 }
            java.util.Map r4 = r2.getHeaderFields()     // Catch:{ IOException -> 0x0051, all -> 0x004e }
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0042 }
            r5.<init>()     // Catch:{ all -> 0x0042 }
            java.io.InputStream r6 = r2.getInputStream()     // Catch:{ all -> 0x0042 }
            r7 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x0040 }
        L_0x0024:
            int r8 = r6.read(r7)     // Catch:{ all -> 0x0040 }
            if (r8 <= 0) goto L_0x002e
            r5.write(r7, r0, r8)     // Catch:{ all -> 0x0040 }
            goto L_0x0024
        L_0x002e:
            byte[] r0 = r5.toByteArray()     // Catch:{ all -> 0x0040 }
            if (r6 == 0) goto L_0x0037
            r6.close()     // Catch:{ IOException -> 0x004c, all -> 0x004a }
        L_0x0037:
            if (r2 == 0) goto L_0x003c
            r2.disconnect()
        L_0x003c:
            r10.zzb(r3, r1, r0, r4)
            return
        L_0x0040:
            r0 = move-exception
            goto L_0x0044
        L_0x0042:
            r0 = move-exception
            r6 = r1
        L_0x0044:
            if (r6 == 0) goto L_0x0049
            r6.close()     // Catch:{ IOException -> 0x004c, all -> 0x004a }
        L_0x0049:
            throw r0     // Catch:{ IOException -> 0x004c, all -> 0x004a }
        L_0x004a:
            r0 = move-exception
            goto L_0x0065
        L_0x004c:
            r0 = move-exception
            goto L_0x0073
        L_0x004e:
            r0 = move-exception
            r4 = r1
            goto L_0x0065
        L_0x0051:
            r0 = move-exception
            r4 = r1
            goto L_0x0073
        L_0x0054:
            r3 = move-exception
            r4 = r1
            r9 = r3
            r3 = r0
            r0 = r9
            goto L_0x0065
        L_0x005a:
            r3 = move-exception
            r4 = r1
            r9 = r3
            r3 = r0
            r0 = r9
            goto L_0x0073
        L_0x0060:
            r2 = move-exception
            r3 = r0
            r4 = r1
            r0 = r2
            r2 = r4
        L_0x0065:
            if (r2 == 0) goto L_0x006a
            r2.disconnect()
        L_0x006a:
            r10.zzb(r3, r1, r1, r4)
            throw r0
        L_0x006e:
            r2 = move-exception
            r3 = r0
            r4 = r1
            r0 = r2
            r2 = r4
        L_0x0073:
            if (r2 == 0) goto L_0x0078
            r2.disconnect()
        L_0x0078:
            r10.zzb(r3, r0, r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhz.run():void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(int i, Exception exc, byte[] bArr, Map map) {
        this.zzd.zza(this.zzc, i, exc, bArr, map);
    }
}
