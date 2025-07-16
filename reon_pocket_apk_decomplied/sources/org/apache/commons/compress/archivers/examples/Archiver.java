package org.apache.commons.compress.archivers.examples;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.SeekableByteChannel;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;

public class Archiver {

    private interface ArchiveEntryConsumer {
        void accept(File file, ArchiveEntry archiveEntry) throws IOException;
    }

    private interface ArchiveEntryCreator {
        ArchiveEntry create(File file, String str) throws IOException;
    }

    private interface Finisher {
        void finish() throws IOException;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0033, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        if (r5 != null) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        org.altbeacon.beacon.Beacon$$ExternalSyntheticApiModelOutline0.m((java.nio.channels.SeekableByteChannel) r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003b, code lost:
        r4.addSuppressed(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0056, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0057, code lost:
        if (r5 != null) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005d, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005e, code lost:
        r4.addSuppressed(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0061, code lost:
        throw r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void create(java.lang.String r4, java.io.File r5, java.io.File r6) throws java.io.IOException, org.apache.commons.compress.archivers.ArchiveException {
        /*
            r3 = this;
            boolean r0 = r3.prefersSeekableByteChannel(r4)
            r1 = 0
            if (r0 == 0) goto L_0x003f
            java.nio.file.Path r5 = r5.toPath()
            r0 = 3
            java.nio.file.OpenOption[] r0 = new java.nio.file.OpenOption[r0]
            java.nio.file.StandardOpenOption r2 = java.nio.file.StandardOpenOption.WRITE
            r0[r1] = r2
            r1 = 1
            java.nio.file.StandardOpenOption r2 = java.nio.file.StandardOpenOption.CREATE
            r0[r1] = r2
            r1 = 2
            java.nio.file.StandardOpenOption r2 = java.nio.file.StandardOpenOption.TRUNCATE_EXISTING
            r0[r1] = r2
            java.nio.channels.FileChannel r5 = org.altbeacon.beacon.Beacon$$ExternalSyntheticApiModelOutline0.m((java.nio.file.Path) r5, (java.nio.file.OpenOption[]) r0)
            org.apache.commons.compress.archivers.examples.CloseableConsumer r0 = org.apache.commons.compress.archivers.examples.CloseableConsumer.CLOSING_CONSUMER     // Catch:{ all -> 0x0031 }
            r3.create((java.lang.String) r4, (java.nio.channels.SeekableByteChannel) r5, (java.io.File) r6, (org.apache.commons.compress.archivers.examples.CloseableConsumer) r0)     // Catch:{ all -> 0x0031 }
            if (r5 == 0) goto L_0x0030
            org.altbeacon.beacon.Beacon$$ExternalSyntheticApiModelOutline0.m((java.nio.channels.SeekableByteChannel) r5)
        L_0x0030:
            return
        L_0x0031:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0033 }
        L_0x0033:
            r6 = move-exception
            if (r5 == 0) goto L_0x003e
            org.altbeacon.beacon.Beacon$$ExternalSyntheticApiModelOutline0.m((java.nio.channels.SeekableByteChannel) r5)     // Catch:{ all -> 0x003a }
            goto L_0x003e
        L_0x003a:
            r5 = move-exception
            r4.addSuppressed(r5)
        L_0x003e:
            throw r6
        L_0x003f:
            java.nio.file.Path r5 = r5.toPath()
            java.nio.file.OpenOption[] r0 = new java.nio.file.OpenOption[r1]
            java.io.OutputStream r5 = androidx.tracing.Trace$$ExternalSyntheticApiModelOutline0.m((java.nio.file.Path) r5, (java.nio.file.OpenOption[]) r0)
            org.apache.commons.compress.archivers.examples.CloseableConsumer r0 = org.apache.commons.compress.archivers.examples.CloseableConsumer.CLOSING_CONSUMER     // Catch:{ all -> 0x0054 }
            r3.create((java.lang.String) r4, (java.io.OutputStream) r5, (java.io.File) r6, (org.apache.commons.compress.archivers.examples.CloseableConsumer) r0)     // Catch:{ all -> 0x0054 }
            if (r5 == 0) goto L_0x0053
            r5.close()
        L_0x0053:
            return
        L_0x0054:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0056 }
        L_0x0056:
            r6 = move-exception
            if (r5 == 0) goto L_0x0061
            r5.close()     // Catch:{ all -> 0x005d }
            goto L_0x0061
        L_0x005d:
            r5 = move-exception
            r4.addSuppressed(r5)
        L_0x0061:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.examples.Archiver.create(java.lang.String, java.io.File, java.io.File):void");
    }

    @Deprecated
    public void create(String str, OutputStream outputStream, File file) throws IOException, ArchiveException {
        create(str, outputStream, file, CloseableConsumer.NULL_CONSUMER);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        r2.addSuppressed(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        r3 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void create(java.lang.String r2, java.io.OutputStream r3, java.io.File r4, org.apache.commons.compress.archivers.examples.CloseableConsumer r5) throws java.io.IOException, org.apache.commons.compress.archivers.ArchiveException {
        /*
            r1 = this;
            org.apache.commons.compress.archivers.examples.CloseableConsumerAdapter r0 = new org.apache.commons.compress.archivers.examples.CloseableConsumerAdapter
            r0.<init>(r5)
            org.apache.commons.compress.archivers.ArchiveStreamFactory r5 = new org.apache.commons.compress.archivers.ArchiveStreamFactory     // Catch:{ all -> 0x001b }
            r5.<init>()     // Catch:{ all -> 0x001b }
            org.apache.commons.compress.archivers.ArchiveOutputStream r2 = r5.createArchiveOutputStream(r2, r3)     // Catch:{ all -> 0x001b }
            java.io.Closeable r2 = r0.track(r2)     // Catch:{ all -> 0x001b }
            org.apache.commons.compress.archivers.ArchiveOutputStream r2 = (org.apache.commons.compress.archivers.ArchiveOutputStream) r2     // Catch:{ all -> 0x001b }
            r1.create((org.apache.commons.compress.archivers.ArchiveOutputStream) r2, (java.io.File) r4)     // Catch:{ all -> 0x001b }
            r0.close()
            return
        L_0x001b:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001d }
        L_0x001d:
            r3 = move-exception
            r0.close()     // Catch:{ all -> 0x0022 }
            goto L_0x0026
        L_0x0022:
            r4 = move-exception
            r2.addSuppressed(r4)
        L_0x0026:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.examples.Archiver.create(java.lang.String, java.io.OutputStream, java.io.File, org.apache.commons.compress.archivers.examples.CloseableConsumer):void");
    }

    @Deprecated
    public void create(String str, SeekableByteChannel seekableByteChannel, File file) throws IOException, ArchiveException {
        create(str, seekableByteChannel, file, CloseableConsumer.NULL_CONSUMER);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0060, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0065, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0066, code lost:
        r3.addSuppressed(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0069, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void create(java.lang.String r3, java.nio.channels.SeekableByteChannel r4, java.io.File r5, org.apache.commons.compress.archivers.examples.CloseableConsumer r6) throws java.io.IOException, org.apache.commons.compress.archivers.ArchiveException {
        /*
            r2 = this;
            java.lang.String r0 = "Don't know how to handle format "
            org.apache.commons.compress.archivers.examples.CloseableConsumerAdapter r1 = new org.apache.commons.compress.archivers.examples.CloseableConsumerAdapter
            r1.<init>(r6)
            boolean r6 = r2.prefersSeekableByteChannel(r3)     // Catch:{ all -> 0x005e }
            if (r6 != 0) goto L_0x001b
            java.io.OutputStream r4 = java.nio.channels.Channels.newOutputStream(r4)     // Catch:{ all -> 0x005e }
            java.io.Closeable r4 = r1.track(r4)     // Catch:{ all -> 0x005e }
            java.io.OutputStream r4 = (java.io.OutputStream) r4     // Catch:{ all -> 0x005e }
            r2.create((java.lang.String) r3, (java.io.OutputStream) r4, (java.io.File) r5)     // Catch:{ all -> 0x005e }
            goto L_0x0048
        L_0x001b:
            java.lang.String r6 = "zip"
            boolean r6 = r6.equalsIgnoreCase(r3)     // Catch:{ all -> 0x005e }
            if (r6 == 0) goto L_0x0032
            org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream r3 = new org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream     // Catch:{ all -> 0x005e }
            r3.<init>((java.nio.channels.SeekableByteChannel) r4)     // Catch:{ all -> 0x005e }
            java.io.Closeable r3 = r1.track(r3)     // Catch:{ all -> 0x005e }
            org.apache.commons.compress.archivers.ArchiveOutputStream r3 = (org.apache.commons.compress.archivers.ArchiveOutputStream) r3     // Catch:{ all -> 0x005e }
            r2.create((org.apache.commons.compress.archivers.ArchiveOutputStream) r3, (java.io.File) r5)     // Catch:{ all -> 0x005e }
            goto L_0x0048
        L_0x0032:
            java.lang.String r6 = "7z"
            boolean r6 = r6.equalsIgnoreCase(r3)     // Catch:{ all -> 0x005e }
            if (r6 == 0) goto L_0x004c
            org.apache.commons.compress.archivers.sevenz.SevenZOutputFile r3 = new org.apache.commons.compress.archivers.sevenz.SevenZOutputFile     // Catch:{ all -> 0x005e }
            r3.<init>((java.nio.channels.SeekableByteChannel) r4)     // Catch:{ all -> 0x005e }
            java.io.Closeable r3 = r1.track(r3)     // Catch:{ all -> 0x005e }
            org.apache.commons.compress.archivers.sevenz.SevenZOutputFile r3 = (org.apache.commons.compress.archivers.sevenz.SevenZOutputFile) r3     // Catch:{ all -> 0x005e }
            r2.create((org.apache.commons.compress.archivers.sevenz.SevenZOutputFile) r3, (java.io.File) r5)     // Catch:{ all -> 0x005e }
        L_0x0048:
            r1.close()
            return
        L_0x004c:
            org.apache.commons.compress.archivers.ArchiveException r4 = new org.apache.commons.compress.archivers.ArchiveException     // Catch:{ all -> 0x005e }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x005e }
            r5.<init>(r0)     // Catch:{ all -> 0x005e }
            r5.append(r3)     // Catch:{ all -> 0x005e }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x005e }
            r4.<init>(r3)     // Catch:{ all -> 0x005e }
            throw r4     // Catch:{ all -> 0x005e }
        L_0x005e:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0060 }
        L_0x0060:
            r4 = move-exception
            r1.close()     // Catch:{ all -> 0x0065 }
            goto L_0x0069
        L_0x0065:
            r5 = move-exception
            r3.addSuppressed(r5)
        L_0x0069:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.examples.Archiver.create(java.lang.String, java.nio.channels.SeekableByteChannel, java.io.File, org.apache.commons.compress.archivers.examples.CloseableConsumer):void");
    }

    public void create(final ArchiveOutputStream archiveOutputStream, File file) throws IOException, ArchiveException {
        create(file, (ArchiveEntryCreator) new ArchiveEntryCreator() {
            public ArchiveEntry create(File file, String str) throws IOException {
                return archiveOutputStream.createArchiveEntry(file, str);
            }
        }, (ArchiveEntryConsumer) new ArchiveEntryConsumer() {
            /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
                r3.close();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
                r3 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
                r2.addSuppressed(r3);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
                throw r0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
                r0 = move-exception;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void accept(java.io.File r2, org.apache.commons.compress.archivers.ArchiveEntry r3) throws java.io.IOException {
                /*
                    r1 = this;
                    org.apache.commons.compress.archivers.ArchiveOutputStream r0 = r4
                    r0.putArchiveEntry(r3)
                    boolean r3 = r3.isDirectory()
                    if (r3 != 0) goto L_0x0030
                    java.io.BufferedInputStream r3 = new java.io.BufferedInputStream
                    java.nio.file.Path r2 = r2.toPath()
                    r0 = 0
                    java.nio.file.OpenOption[] r0 = new java.nio.file.OpenOption[r0]
                    java.io.InputStream r2 = androidx.tracing.Trace$$ExternalSyntheticApiModelOutline0.m((java.nio.file.Path) r2, (java.nio.file.OpenOption[]) r0)
                    r3.<init>(r2)
                    org.apache.commons.compress.archivers.ArchiveOutputStream r2 = r4     // Catch:{ all -> 0x0024 }
                    org.apache.commons.compress.utils.IOUtils.copy(r3, r2)     // Catch:{ all -> 0x0024 }
                    r3.close()
                    goto L_0x0030
                L_0x0024:
                    r2 = move-exception
                    throw r2     // Catch:{ all -> 0x0026 }
                L_0x0026:
                    r0 = move-exception
                    r3.close()     // Catch:{ all -> 0x002b }
                    goto L_0x002f
                L_0x002b:
                    r3 = move-exception
                    r2.addSuppressed(r3)
                L_0x002f:
                    throw r0
                L_0x0030:
                    org.apache.commons.compress.archivers.ArchiveOutputStream r2 = r4
                    r2.closeArchiveEntry()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.examples.Archiver.AnonymousClass2.accept(java.io.File, org.apache.commons.compress.archivers.ArchiveEntry):void");
            }
        }, (Finisher) new Finisher() {
            public void finish() throws IOException {
                archiveOutputStream.finish();
            }
        });
    }

    public void create(final SevenZOutputFile sevenZOutputFile, File file) throws IOException {
        create(file, (ArchiveEntryCreator) new ArchiveEntryCreator() {
            public ArchiveEntry create(File file, String str) throws IOException {
                return sevenZOutputFile.createArchiveEntry(file, str);
            }
        }, (ArchiveEntryConsumer) new ArchiveEntryConsumer() {
            /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
                r5 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
                r0.close();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:14:0x0037, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
                r4.addSuppressed(r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
                throw r5;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void accept(java.io.File r4, org.apache.commons.compress.archivers.ArchiveEntry r5) throws java.io.IOException {
                /*
                    r3 = this;
                    org.apache.commons.compress.archivers.sevenz.SevenZOutputFile r0 = r4
                    r0.putArchiveEntry(r5)
                    boolean r5 = r5.isDirectory()
                    if (r5 != 0) goto L_0x003c
                    r5 = 8024(0x1f58, float:1.1244E-41)
                    byte[] r5 = new byte[r5]
                    java.io.BufferedInputStream r0 = new java.io.BufferedInputStream
                    java.nio.file.Path r4 = r4.toPath()
                    r1 = 0
                    java.nio.file.OpenOption[] r2 = new java.nio.file.OpenOption[r1]
                    java.io.InputStream r4 = androidx.tracing.Trace$$ExternalSyntheticApiModelOutline0.m((java.nio.file.Path) r4, (java.nio.file.OpenOption[]) r2)
                    r0.<init>(r4)
                L_0x001f:
                    int r4 = r0.read(r5)     // Catch:{ all -> 0x0030 }
                    r2 = -1
                    if (r2 == r4) goto L_0x002c
                    org.apache.commons.compress.archivers.sevenz.SevenZOutputFile r2 = r4     // Catch:{ all -> 0x0030 }
                    r2.write(r5, r1, r4)     // Catch:{ all -> 0x0030 }
                    goto L_0x001f
                L_0x002c:
                    r0.close()
                    goto L_0x003c
                L_0x0030:
                    r4 = move-exception
                    throw r4     // Catch:{ all -> 0x0032 }
                L_0x0032:
                    r5 = move-exception
                    r0.close()     // Catch:{ all -> 0x0037 }
                    goto L_0x003b
                L_0x0037:
                    r0 = move-exception
                    r4.addSuppressed(r0)
                L_0x003b:
                    throw r5
                L_0x003c:
                    org.apache.commons.compress.archivers.sevenz.SevenZOutputFile r4 = r4
                    r4.closeArchiveEntry()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.examples.Archiver.AnonymousClass5.accept(java.io.File, org.apache.commons.compress.archivers.ArchiveEntry):void");
            }
        }, (Finisher) new Finisher() {
            public void finish() throws IOException {
                sevenZOutputFile.finish();
            }
        });
    }

    private boolean prefersSeekableByteChannel(String str) {
        return ArchiveStreamFactory.ZIP.equalsIgnoreCase(str) || ArchiveStreamFactory.SEVEN_Z.equalsIgnoreCase(str);
    }

    private void create(File file, ArchiveEntryCreator archiveEntryCreator, ArchiveEntryConsumer archiveEntryConsumer, Finisher finisher) throws IOException {
        create("", file, archiveEntryCreator, archiveEntryConsumer);
        finisher.finish();
    }

    private void create(String str, File file, ArchiveEntryCreator archiveEntryCreator, ArchiveEntryConsumer archiveEntryConsumer) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(file2.getName());
                sb.append(file2.isDirectory() ? "/" : "");
                String sb2 = sb.toString();
                archiveEntryConsumer.accept(file2, archiveEntryCreator.create(file2, sb2));
                if (file2.isDirectory()) {
                    create(sb2, file2, archiveEntryCreator, archiveEntryConsumer);
                }
            }
        }
    }
}
