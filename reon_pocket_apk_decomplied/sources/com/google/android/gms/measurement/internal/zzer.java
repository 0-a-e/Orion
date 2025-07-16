package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
final class zzer implements Runnable {
    final /* synthetic */ zzes zza;
    private final URL zzb;
    private final byte[] zzc;
    private final zzep zzd;
    private final String zze;
    private final Map<String, String> zzf;

    public zzer(zzes zzes, String str, URL url, byte[] bArr, Map<String, String> map, zzep zzep) {
        this.zza = zzes;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzep);
        this.zzb = url;
        this.zzc = bArr;
        this.zzd = zzep;
        this.zze = str;
        this.zzf = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d5 A[SYNTHETIC, Splitter:B:44:0x00d5] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f2 A[SYNTHETIC, Splitter:B:62:0x00f2] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0132 A[SYNTHETIC, Splitter:B:74:0x0132] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x014e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r13 = this;
            java.lang.String r0 = "Error closing HTTP compressed POST connection output stream. appId"
            com.google.android.gms.measurement.internal.zzes r1 = r13.zza
            r1.zzaw()
            r1 = 0
            r2 = 0
            com.google.android.gms.measurement.internal.zzes r3 = r13.zza     // Catch:{ IOException -> 0x012a, all -> 0x00eb }
            java.net.URL r4 = r13.zzb     // Catch:{ IOException -> 0x012a, all -> 0x00eb }
            java.net.HttpURLConnection r3 = r3.zzc(r4)     // Catch:{ IOException -> 0x012a, all -> 0x00eb }
            java.util.Map<java.lang.String, java.lang.String> r4 = r13.zzf     // Catch:{ IOException -> 0x00e7, all -> 0x00e3 }
            if (r4 == 0) goto L_0x0039
            java.util.Set r4 = r4.entrySet()     // Catch:{ IOException -> 0x00e7, all -> 0x00e3 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ IOException -> 0x00e7, all -> 0x00e3 }
        L_0x001d:
            boolean r5 = r4.hasNext()     // Catch:{ IOException -> 0x00e7, all -> 0x00e3 }
            if (r5 == 0) goto L_0x0039
            java.lang.Object r5 = r4.next()     // Catch:{ IOException -> 0x00e7, all -> 0x00e3 }
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ IOException -> 0x00e7, all -> 0x00e3 }
            java.lang.Object r6 = r5.getKey()     // Catch:{ IOException -> 0x00e7, all -> 0x00e3 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ IOException -> 0x00e7, all -> 0x00e3 }
            java.lang.Object r5 = r5.getValue()     // Catch:{ IOException -> 0x00e7, all -> 0x00e3 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x00e7, all -> 0x00e3 }
            r3.addRequestProperty(r6, r5)     // Catch:{ IOException -> 0x00e7, all -> 0x00e3 }
            goto L_0x001d
        L_0x0039:
            byte[] r4 = r13.zzc     // Catch:{ IOException -> 0x00e7, all -> 0x00e3 }
            if (r4 == 0) goto L_0x008a
            com.google.android.gms.measurement.internal.zzes r4 = r13.zza     // Catch:{ IOException -> 0x00e7, all -> 0x00e3 }
            com.google.android.gms.measurement.internal.zzkn r4 = r4.zzf     // Catch:{ IOException -> 0x00e7, all -> 0x00e3 }
            com.google.android.gms.measurement.internal.zzkp r4 = r4.zzm()     // Catch:{ IOException -> 0x00e7, all -> 0x00e3 }
            byte[] r5 = r13.zzc     // Catch:{ IOException -> 0x00e7, all -> 0x00e3 }
            byte[] r4 = r4.zzs(r5)     // Catch:{ IOException -> 0x00e7, all -> 0x00e3 }
            com.google.android.gms.measurement.internal.zzes r5 = r13.zza     // Catch:{ IOException -> 0x00e7, all -> 0x00e3 }
            com.google.android.gms.measurement.internal.zzfu r5 = r5.zzs     // Catch:{ IOException -> 0x00e7, all -> 0x00e3 }
            com.google.android.gms.measurement.internal.zzem r5 = r5.zzau()     // Catch:{ IOException -> 0x00e7, all -> 0x00e3 }
            com.google.android.gms.measurement.internal.zzek r5 = r5.zzk()     // Catch:{ IOException -> 0x00e7, all -> 0x00e3 }
            int r6 = r4.length     // Catch:{ IOException -> 0x00e7, all -> 0x00e3 }
            java.lang.String r7 = "Uploading data. size"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)     // Catch:{ IOException -> 0x00e7, all -> 0x00e3 }
            r5.zzb(r7, r8)     // Catch:{ IOException -> 0x00e7, all -> 0x00e3 }
            r5 = 1
            r3.setDoOutput(r5)     // Catch:{ IOException -> 0x00e7, all -> 0x00e3 }
            java.lang.String r5 = "Content-Encoding"
            java.lang.String r7 = "gzip"
            r3.addRequestProperty(r5, r7)     // Catch:{ IOException -> 0x00e7, all -> 0x00e3 }
            r3.setFixedLengthStreamingMode(r6)     // Catch:{ IOException -> 0x00e7, all -> 0x00e3 }
            r3.connect()     // Catch:{ IOException -> 0x00e7, all -> 0x00e3 }
            java.io.OutputStream r5 = r3.getOutputStream()     // Catch:{ IOException -> 0x00e7, all -> 0x00e3 }
            r5.write(r4)     // Catch:{ IOException -> 0x0083, all -> 0x007d }
            r5.close()     // Catch:{ IOException -> 0x0083, all -> 0x007d }
            goto L_0x008a
        L_0x007d:
            r4 = move-exception
            r8 = r1
            r11 = r2
            r2 = r5
            goto L_0x00f0
        L_0x0083:
            r4 = move-exception
            r8 = r1
            r11 = r2
            r9 = r4
            r2 = r5
            goto L_0x0130
        L_0x008a:
            int r8 = r3.getResponseCode()     // Catch:{ IOException -> 0x00e7, all -> 0x00e3 }
            java.util.Map r11 = r3.getHeaderFields()     // Catch:{ IOException -> 0x00e1, all -> 0x00df }
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x00d1 }
            r4.<init>()     // Catch:{ all -> 0x00d1 }
            java.io.InputStream r5 = r3.getInputStream()     // Catch:{ all -> 0x00d1 }
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x00cf }
        L_0x009f:
            int r7 = r5.read(r6)     // Catch:{ all -> 0x00cf }
            if (r7 <= 0) goto L_0x00a9
            r4.write(r6, r1, r7)     // Catch:{ all -> 0x00cf }
            goto L_0x009f
        L_0x00a9:
            byte[] r10 = r4.toByteArray()     // Catch:{ all -> 0x00cf }
            if (r5 == 0) goto L_0x00b2
            r5.close()     // Catch:{ IOException -> 0x00dc, all -> 0x00d9 }
        L_0x00b2:
            if (r3 == 0) goto L_0x00b7
            r3.disconnect()
        L_0x00b7:
            com.google.android.gms.measurement.internal.zzes r0 = r13.zza
            com.google.android.gms.measurement.internal.zzfu r0 = r0.zzs
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzav()
            com.google.android.gms.measurement.internal.zzeq r1 = new com.google.android.gms.measurement.internal.zzeq
            java.lang.String r6 = r13.zze
            com.google.android.gms.measurement.internal.zzep r7 = r13.zzd
            r9 = 0
            r12 = 0
            r5 = r1
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
        L_0x00cb:
            r0.zzh(r1)
            return
        L_0x00cf:
            r1 = move-exception
            goto L_0x00d3
        L_0x00d1:
            r1 = move-exception
            r5 = r2
        L_0x00d3:
            if (r5 == 0) goto L_0x00d8
            r5.close()     // Catch:{ IOException -> 0x00dc, all -> 0x00d9 }
        L_0x00d8:
            throw r1     // Catch:{ IOException -> 0x00dc, all -> 0x00d9 }
        L_0x00d9:
            r1 = move-exception
            r4 = r1
            goto L_0x00f0
        L_0x00dc:
            r1 = move-exception
            r4 = r1
            goto L_0x012f
        L_0x00df:
            r4 = move-exception
            goto L_0x00e5
        L_0x00e1:
            r4 = move-exception
            goto L_0x00e9
        L_0x00e3:
            r4 = move-exception
            r8 = r1
        L_0x00e5:
            r11 = r2
            goto L_0x00f0
        L_0x00e7:
            r4 = move-exception
            r8 = r1
        L_0x00e9:
            r11 = r2
            goto L_0x012f
        L_0x00eb:
            r3 = move-exception
            r4 = r3
            r8 = r1
            r3 = r2
            r11 = r3
        L_0x00f0:
            if (r2 == 0) goto L_0x010c
            r2.close()     // Catch:{ IOException -> 0x00f6 }
            goto L_0x010c
        L_0x00f6:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzes r2 = r13.zza
            com.google.android.gms.measurement.internal.zzfu r2 = r2.zzs
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()
            java.lang.String r5 = r13.zze
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzem.zzl(r5)
            r2.zzc(r0, r5, r1)
        L_0x010c:
            if (r3 == 0) goto L_0x0111
            r3.disconnect()
        L_0x0111:
            com.google.android.gms.measurement.internal.zzes r0 = r13.zza
            com.google.android.gms.measurement.internal.zzfu r0 = r0.zzs
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzav()
            com.google.android.gms.measurement.internal.zzeq r1 = new com.google.android.gms.measurement.internal.zzeq
            java.lang.String r6 = r13.zze
            com.google.android.gms.measurement.internal.zzep r7 = r13.zzd
            r10 = 0
            r12 = 0
            r9 = 0
            r5 = r1
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            r0.zzh(r1)
            throw r4
        L_0x012a:
            r3 = move-exception
            r4 = r3
            r8 = r1
            r3 = r2
            r11 = r3
        L_0x012f:
            r9 = r4
        L_0x0130:
            if (r2 == 0) goto L_0x014c
            r2.close()     // Catch:{ IOException -> 0x0136 }
            goto L_0x014c
        L_0x0136:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzes r2 = r13.zza
            com.google.android.gms.measurement.internal.zzfu r2 = r2.zzs
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()
            java.lang.String r4 = r13.zze
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzem.zzl(r4)
            r2.zzc(r0, r4, r1)
        L_0x014c:
            if (r3 == 0) goto L_0x0151
            r3.disconnect()
        L_0x0151:
            com.google.android.gms.measurement.internal.zzes r0 = r13.zza
            com.google.android.gms.measurement.internal.zzfu r0 = r0.zzs
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzav()
            com.google.android.gms.measurement.internal.zzeq r1 = new com.google.android.gms.measurement.internal.zzeq
            java.lang.String r6 = r13.zze
            com.google.android.gms.measurement.internal.zzep r7 = r13.zzd
            r10 = 0
            r12 = 0
            r5 = r1
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            goto L_0x00cb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzer.run():void");
    }
}
