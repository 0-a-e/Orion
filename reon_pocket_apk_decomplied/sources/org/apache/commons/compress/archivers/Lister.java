package org.apache.commons.compress.archivers;

import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;

public final class Lister {
    private static final ArchiveStreamFactory factory = new ArchiveStreamFactory();

    public static void main(String[] strArr) throws Exception {
        if (strArr.length == 0) {
            usage();
            return;
        }
        PrintStream printStream = System.out;
        printStream.println("Analysing " + strArr[0]);
        File file = new File(strArr[0]);
        if (!file.isFile()) {
            PrintStream printStream2 = System.err;
            printStream2.println(file + " doesn't exist or is a directory");
        }
        String detectFormat = strArr.length > 1 ? strArr[1] : detectFormat(file);
        if (ArchiveStreamFactory.SEVEN_Z.equalsIgnoreCase(detectFormat)) {
            list7z(file);
        } else if ("zipfile".equals(detectFormat)) {
            listZipUsingZipFile(file);
        } else {
            listStream(file, strArr);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0047, code lost:
        if (r3 != null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004d, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r4.addSuppressed(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0051, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0054, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0059, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005a, code lost:
        r3.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005d, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void listStream(java.io.File r3, java.lang.String[] r4) throws org.apache.commons.compress.archivers.ArchiveException, java.io.IOException {
        /*
            java.lang.String r0 = "Created "
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream
            java.nio.file.Path r3 = r3.toPath()
            r2 = 0
            java.nio.file.OpenOption[] r2 = new java.nio.file.OpenOption[r2]
            java.io.InputStream r3 = androidx.tracing.Trace$$ExternalSyntheticApiModelOutline0.m((java.nio.file.Path) r3, (java.nio.file.OpenOption[]) r2)
            r1.<init>(r3)
            org.apache.commons.compress.archivers.ArchiveInputStream r3 = createArchiveInputStream(r4, r1)     // Catch:{ all -> 0x0052 }
            java.io.PrintStream r4 = java.lang.System.out     // Catch:{ all -> 0x0044 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0044 }
            r2.<init>(r0)     // Catch:{ all -> 0x0044 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0044 }
            r2.append(r0)     // Catch:{ all -> 0x0044 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0044 }
            r4.println(r0)     // Catch:{ all -> 0x0044 }
        L_0x002b:
            org.apache.commons.compress.archivers.ArchiveEntry r4 = r3.getNextEntry()     // Catch:{ all -> 0x0044 }
            if (r4 == 0) goto L_0x003b
            java.io.PrintStream r0 = java.lang.System.out     // Catch:{ all -> 0x0044 }
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x0044 }
            r0.println(r4)     // Catch:{ all -> 0x0044 }
            goto L_0x002b
        L_0x003b:
            if (r3 == 0) goto L_0x0040
            r3.close()     // Catch:{ all -> 0x0052 }
        L_0x0040:
            r1.close()
            return
        L_0x0044:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0046 }
        L_0x0046:
            r0 = move-exception
            if (r3 == 0) goto L_0x0051
            r3.close()     // Catch:{ all -> 0x004d }
            goto L_0x0051
        L_0x004d:
            r3 = move-exception
            r4.addSuppressed(r3)     // Catch:{ all -> 0x0052 }
        L_0x0051:
            throw r0     // Catch:{ all -> 0x0052 }
        L_0x0052:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0054 }
        L_0x0054:
            r4 = move-exception
            r1.close()     // Catch:{ all -> 0x0059 }
            goto L_0x005d
        L_0x0059:
            r0 = move-exception
            r3.addSuppressed(r0)
        L_0x005d:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.Lister.listStream(java.io.File, java.lang.String[]):void");
    }

    private static ArchiveInputStream createArchiveInputStream(String[] strArr, InputStream inputStream) throws ArchiveException {
        if (strArr.length > 1) {
            return factory.createArchiveInputStream(strArr[1], inputStream);
        }
        return factory.createArchiveInputStream(inputStream);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        r2.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r1 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String detectFormat(java.io.File r2) throws org.apache.commons.compress.archivers.ArchiveException, java.io.IOException {
        /*
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream
            java.nio.file.Path r2 = r2.toPath()
            r1 = 0
            java.nio.file.OpenOption[] r1 = new java.nio.file.OpenOption[r1]
            java.io.InputStream r2 = androidx.tracing.Trace$$ExternalSyntheticApiModelOutline0.m((java.nio.file.Path) r2, (java.nio.file.OpenOption[]) r1)
            r0.<init>(r2)
            java.lang.String r2 = org.apache.commons.compress.archivers.ArchiveStreamFactory.detect(r0)     // Catch:{ all -> 0x0018 }
            r0.close()
            return r2
        L_0x0018:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001a }
        L_0x001a:
            r1 = move-exception
            r0.close()     // Catch:{ all -> 0x001f }
            goto L_0x0023
        L_0x001f:
            r0 = move-exception
            r2.addSuppressed(r0)
        L_0x0023:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.Lister.detectFormat(java.io.File):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0053, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0054, code lost:
        r3.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0057, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void list7z(java.io.File r3) throws org.apache.commons.compress.archivers.ArchiveException, java.io.IOException {
        /*
            java.lang.String r0 = "Created "
            org.apache.commons.compress.archivers.sevenz.SevenZFile r1 = new org.apache.commons.compress.archivers.sevenz.SevenZFile
            r1.<init>((java.io.File) r3)
            java.io.PrintStream r3 = java.lang.System.out     // Catch:{ all -> 0x004c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x004c }
            r2.<init>(r0)     // Catch:{ all -> 0x004c }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x004c }
            r2.append(r0)     // Catch:{ all -> 0x004c }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x004c }
            r3.println(r0)     // Catch:{ all -> 0x004c }
        L_0x001c:
            org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry r3 = r1.getNextEntry()     // Catch:{ all -> 0x004c }
            if (r3 == 0) goto L_0x0048
            java.lang.String r0 = r3.getName()     // Catch:{ all -> 0x004c }
            if (r0 != 0) goto L_0x003e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x004c }
            r3.<init>()     // Catch:{ all -> 0x004c }
            java.lang.String r0 = r1.getDefaultName()     // Catch:{ all -> 0x004c }
            r3.append(r0)     // Catch:{ all -> 0x004c }
            java.lang.String r0 = " (entry name was null)"
            r3.append(r0)     // Catch:{ all -> 0x004c }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x004c }
            goto L_0x0042
        L_0x003e:
            java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x004c }
        L_0x0042:
            java.io.PrintStream r0 = java.lang.System.out     // Catch:{ all -> 0x004c }
            r0.println(r3)     // Catch:{ all -> 0x004c }
            goto L_0x001c
        L_0x0048:
            r1.close()
            return
        L_0x004c:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x004e }
        L_0x004e:
            r0 = move-exception
            r1.close()     // Catch:{ all -> 0x0053 }
            goto L_0x0057
        L_0x0053:
            r1 = move-exception
            r3.addSuppressed(r1)
        L_0x0057:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.Lister.list7z(java.io.File):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0041, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0042, code lost:
        r3.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0045, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void listZipUsingZipFile(java.io.File r3) throws org.apache.commons.compress.archivers.ArchiveException, java.io.IOException {
        /*
            java.lang.String r0 = "Created "
            org.apache.commons.compress.archivers.zip.ZipFile r1 = new org.apache.commons.compress.archivers.zip.ZipFile
            r1.<init>((java.io.File) r3)
            java.io.PrintStream r3 = java.lang.System.out     // Catch:{ all -> 0x003a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x003a }
            r2.<init>(r0)     // Catch:{ all -> 0x003a }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x003a }
            r2.append(r0)     // Catch:{ all -> 0x003a }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x003a }
            r3.println(r0)     // Catch:{ all -> 0x003a }
            java.util.Enumeration r3 = r1.getEntries()     // Catch:{ all -> 0x003a }
        L_0x0020:
            boolean r0 = r3.hasMoreElements()     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x0036
            java.io.PrintStream r0 = java.lang.System.out     // Catch:{ all -> 0x003a }
            java.lang.Object r2 = r3.nextElement()     // Catch:{ all -> 0x003a }
            org.apache.commons.compress.archivers.zip.ZipArchiveEntry r2 = (org.apache.commons.compress.archivers.zip.ZipArchiveEntry) r2     // Catch:{ all -> 0x003a }
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x003a }
            r0.println(r2)     // Catch:{ all -> 0x003a }
            goto L_0x0020
        L_0x0036:
            r1.close()
            return
        L_0x003a:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x003c }
        L_0x003c:
            r0 = move-exception
            r1.close()     // Catch:{ all -> 0x0041 }
            goto L_0x0045
        L_0x0041:
            r1 = move-exception
            r3.addSuppressed(r1)
        L_0x0045:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.Lister.listZipUsingZipFile(java.io.File):void");
    }

    private static void usage() {
        System.out.println("Parameters: archive-name [archive-type]\n");
        System.out.println("the magic archive-type 'zipfile' prefers ZipFile over ZipArchiveInputStream");
    }
}
