package com.google.android.gms.common.internal;

import java.util.concurrent.ConcurrentHashMap;

@Deprecated
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class LibraryVersion {
    private static final GmsLogger zza = new GmsLogger("LibraryVersion", "");
    private static LibraryVersion zzb = new LibraryVersion();
    private ConcurrentHashMap zzc = new ConcurrentHashMap();

    protected LibraryVersion() {
    }

    public static LibraryVersion getInstance() {
        return zzb;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r4v13 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a5  */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getVersion(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "LibraryVersion"
            java.lang.String r1 = "Failed to get app version for libraryName: "
            java.lang.String r2 = "Please provide a valid libraryName"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9, r2)
            java.util.concurrent.ConcurrentHashMap r2 = r8.zzc
            boolean r2 = r2.containsKey(r9)
            if (r2 == 0) goto L_0x001a
            java.util.concurrent.ConcurrentHashMap r0 = r8.zzc
            java.lang.Object r9 = r0.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            return r9
        L_0x001a:
            java.util.Properties r2 = new java.util.Properties
            r2.<init>()
            r3 = 1
            r4 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ IOException -> 0x0076 }
            r5 = 0
            r3[r5] = r9     // Catch:{ IOException -> 0x0076 }
            java.lang.Class<com.google.android.gms.common.internal.LibraryVersion> r5 = com.google.android.gms.common.internal.LibraryVersion.class
            java.lang.String r6 = "/%s.properties"
            java.lang.String r3 = java.lang.String.format(r6, r3)     // Catch:{ IOException -> 0x0076 }
            java.io.InputStream r3 = r5.getResourceAsStream(r3)     // Catch:{ IOException -> 0x0076 }
            if (r3 == 0) goto L_0x0057
            r2.load(r3)     // Catch:{ IOException -> 0x0071, all -> 0x006e }
            java.lang.String r5 = "version"
            java.lang.String r4 = r2.getProperty(r5, r4)     // Catch:{ IOException -> 0x0071, all -> 0x006e }
            com.google.android.gms.common.internal.GmsLogger r2 = zza     // Catch:{ IOException -> 0x0071, all -> 0x006e }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0071, all -> 0x006e }
            r5.<init>()     // Catch:{ IOException -> 0x0071, all -> 0x006e }
            r5.append(r9)     // Catch:{ IOException -> 0x0071, all -> 0x006e }
            java.lang.String r6 = " version is "
            r5.append(r6)     // Catch:{ IOException -> 0x0071, all -> 0x006e }
            r5.append(r4)     // Catch:{ IOException -> 0x0071, all -> 0x006e }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x0071, all -> 0x006e }
            r2.v(r0, r5)     // Catch:{ IOException -> 0x0071, all -> 0x006e }
            goto L_0x0068
        L_0x0057:
            com.google.android.gms.common.internal.GmsLogger r2 = zza     // Catch:{ IOException -> 0x0071, all -> 0x006e }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0071, all -> 0x006e }
            r5.<init>(r1)     // Catch:{ IOException -> 0x0071, all -> 0x006e }
            r5.append(r9)     // Catch:{ IOException -> 0x0071, all -> 0x006e }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x0071, all -> 0x006e }
            r2.w(r0, r5)     // Catch:{ IOException -> 0x0071, all -> 0x006e }
        L_0x0068:
            if (r3 == 0) goto L_0x0092
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r3)
            goto L_0x0092
        L_0x006e:
            r9 = move-exception
            r4 = r3
            goto L_0x00a3
        L_0x0071:
            r2 = move-exception
            r7 = r4
            r4 = r3
            r3 = r7
            goto L_0x007b
        L_0x0076:
            r2 = move-exception
            goto L_0x007a
        L_0x0078:
            r9 = move-exception
            goto L_0x00a3
        L_0x007a:
            r3 = r4
        L_0x007b:
            com.google.android.gms.common.internal.GmsLogger r5 = zza     // Catch:{ all -> 0x0078 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0078 }
            r6.<init>(r1)     // Catch:{ all -> 0x0078 }
            r6.append(r9)     // Catch:{ all -> 0x0078 }
            java.lang.String r1 = r6.toString()     // Catch:{ all -> 0x0078 }
            r5.e(r0, r1, r2)     // Catch:{ all -> 0x0078 }
            if (r4 == 0) goto L_0x0091
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r4)
        L_0x0091:
            r4 = r3
        L_0x0092:
            if (r4 != 0) goto L_0x009d
            com.google.android.gms.common.internal.GmsLogger r1 = zza
            java.lang.String r2 = ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used"
            r1.d(r0, r2)
            java.lang.String r4 = "UNKNOWN"
        L_0x009d:
            java.util.concurrent.ConcurrentHashMap r0 = r8.zzc
            r0.put(r9, r4)
            return r4
        L_0x00a3:
            if (r4 == 0) goto L_0x00a8
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r4)
        L_0x00a8:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.LibraryVersion.getVersion(java.lang.String):java.lang.String");
    }
}
