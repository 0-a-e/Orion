package org.apache.commons.compress.compressors.pack200;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Pack200Utils {
    private Pack200Utils() {
    }

    public static void normalize(File file) throws IOException {
        normalize(file, file, (Map<String, String>) null);
    }

    public static void normalize(File file, Map<String, String> map) throws IOException {
        normalize(file, file, map);
    }

    public static void normalize(File file, File file2) throws IOException {
        normalize(file, file2, (Map<String, String>) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0054, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005d, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0060, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0065, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r4.addSuppressed(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0069, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006c, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0075, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void normalize(java.io.File r4, java.io.File r5, java.util.Map<java.lang.String, java.lang.String> r6) throws java.io.IOException {
        /*
            if (r6 != 0) goto L_0x0007
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
        L_0x0007:
            java.lang.String r0 = "pack.segment.limit"
            java.lang.String r1 = "-1"
            r6.put(r0, r1)
            java.lang.String r0 = "commons-compress"
            java.lang.String r1 = "pack200normalize"
            java.io.File r0 = java.io.File.createTempFile(r0, r1)
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x0076 }
            r1.<init>(r0)     // Catch:{ all -> 0x0076 }
            java.util.jar.JarFile r2 = new java.util.jar.JarFile     // Catch:{ all -> 0x006a }
            r2.<init>(r4)     // Catch:{ all -> 0x006a }
            java.util.jar.Pack200$Packer r4 = java.util.jar.Pack200.newPacker()     // Catch:{ all -> 0x005e }
            java.util.SortedMap r3 = r4.properties()     // Catch:{ all -> 0x005e }
            r3.putAll(r6)     // Catch:{ all -> 0x005e }
            r4.pack(r2, r1)     // Catch:{ all -> 0x005e }
            r2.close()     // Catch:{ all -> 0x006a }
            r1.close()     // Catch:{ all -> 0x0076 }
            java.util.jar.Pack200$Unpacker r4 = java.util.jar.Pack200.newUnpacker()     // Catch:{ all -> 0x0076 }
            java.util.jar.JarOutputStream r6 = new java.util.jar.JarOutputStream     // Catch:{ all -> 0x0076 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x0076 }
            r1.<init>(r5)     // Catch:{ all -> 0x0076 }
            r6.<init>(r1)     // Catch:{ all -> 0x0076 }
            r4.unpack(r0, r6)     // Catch:{ all -> 0x0052 }
            r6.close()     // Catch:{ all -> 0x0076 }
            boolean r4 = r0.delete()
            if (r4 != 0) goto L_0x0051
            r0.deleteOnExit()
        L_0x0051:
            return
        L_0x0052:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0054 }
        L_0x0054:
            r5 = move-exception
            r6.close()     // Catch:{ all -> 0x0059 }
            goto L_0x005d
        L_0x0059:
            r6 = move-exception
            r4.addSuppressed(r6)     // Catch:{ all -> 0x0076 }
        L_0x005d:
            throw r5     // Catch:{ all -> 0x0076 }
        L_0x005e:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0060 }
        L_0x0060:
            r5 = move-exception
            r2.close()     // Catch:{ all -> 0x0065 }
            goto L_0x0069
        L_0x0065:
            r6 = move-exception
            r4.addSuppressed(r6)     // Catch:{ all -> 0x006a }
        L_0x0069:
            throw r5     // Catch:{ all -> 0x006a }
        L_0x006a:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x006c }
        L_0x006c:
            r5 = move-exception
            r1.close()     // Catch:{ all -> 0x0071 }
            goto L_0x0075
        L_0x0071:
            r6 = move-exception
            r4.addSuppressed(r6)     // Catch:{ all -> 0x0076 }
        L_0x0075:
            throw r5     // Catch:{ all -> 0x0076 }
        L_0x0076:
            r4 = move-exception
            boolean r5 = r0.delete()
            if (r5 != 0) goto L_0x0080
            r0.deleteOnExit()
        L_0x0080:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.compressors.pack200.Pack200Utils.normalize(java.io.File, java.io.File, java.util.Map):void");
    }
}
