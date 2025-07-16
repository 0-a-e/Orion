package com.google.android.gms.common.util;

import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class ProcessUtils {
    @Nullable
    private static String zza;
    private static int zzb;

    private ProcessUtils() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getMyProcessName() {
        /*
            java.lang.String r0 = "/proc/"
            java.lang.String r1 = zza
            if (r1 != 0) goto L_0x0055
            int r1 = zzb
            if (r1 != 0) goto L_0x0010
            int r1 = android.os.Process.myPid()
            zzb = r1
        L_0x0010:
            r2 = 0
            if (r1 > 0) goto L_0x0014
            goto L_0x0053
        L_0x0014:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            r3.<init>(r0)     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            r3.append(r1)     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            java.lang.String r0 = "/cmdline"
            r3.append(r0)     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            java.lang.String r0 = r3.toString()     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            android.os.StrictMode$ThreadPolicy r1 = android.os.StrictMode.allowThreadDiskReads()     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x0045 }
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ all -> 0x0045 }
            r4.<init>(r0)     // Catch:{ all -> 0x0045 }
            r3.<init>(r4)     // Catch:{ all -> 0x0045 }
            android.os.StrictMode.setThreadPolicy(r1)     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            java.lang.String r0 = r3.readLine()     // Catch:{ IOException -> 0x0050, all -> 0x0042 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ IOException -> 0x0050, all -> 0x0042 }
            java.lang.String r2 = r0.trim()     // Catch:{ IOException -> 0x0050, all -> 0x0042 }
            goto L_0x0050
        L_0x0042:
            r0 = move-exception
            r2 = r3
            goto L_0x004b
        L_0x0045:
            r0 = move-exception
            android.os.StrictMode.setThreadPolicy(r1)     // Catch:{ IOException -> 0x004f, all -> 0x004a }
            throw r0     // Catch:{ IOException -> 0x004f, all -> 0x004a }
        L_0x004a:
            r0 = move-exception
        L_0x004b:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2)
            throw r0
        L_0x004f:
            r3 = r2
        L_0x0050:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r3)
        L_0x0053:
            zza = r2
        L_0x0055:
            java.lang.String r0 = zza
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.ProcessUtils.getMyProcessName():java.lang.String");
    }
}
