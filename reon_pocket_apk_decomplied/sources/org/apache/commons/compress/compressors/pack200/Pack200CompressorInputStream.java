package org.apache.commons.compress.compressors.pack200;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.IOUtils;

public class Pack200CompressorInputStream extends CompressorInputStream {
    private static final byte[] CAFE_DOOD;
    private static final int SIG_LENGTH;
    private final InputStream originalInput;
    private final StreamBridge streamBridge;

    public Pack200CompressorInputStream(InputStream inputStream) throws IOException {
        this(inputStream, Pack200Strategy.IN_MEMORY);
    }

    public Pack200CompressorInputStream(InputStream inputStream, Pack200Strategy pack200Strategy) throws IOException {
        this(inputStream, (File) null, pack200Strategy, (Map<String, String>) null);
    }

    public Pack200CompressorInputStream(InputStream inputStream, Map<String, String> map) throws IOException {
        this(inputStream, Pack200Strategy.IN_MEMORY, map);
    }

    public Pack200CompressorInputStream(InputStream inputStream, Pack200Strategy pack200Strategy, Map<String, String> map) throws IOException {
        this(inputStream, (File) null, pack200Strategy, map);
    }

    public Pack200CompressorInputStream(File file) throws IOException {
        this(file, Pack200Strategy.IN_MEMORY);
    }

    public Pack200CompressorInputStream(File file, Pack200Strategy pack200Strategy) throws IOException {
        this((InputStream) null, file, pack200Strategy, (Map<String, String>) null);
    }

    public Pack200CompressorInputStream(File file, Map<String, String> map) throws IOException {
        this(file, Pack200Strategy.IN_MEMORY, map);
    }

    public Pack200CompressorInputStream(File file, Pack200Strategy pack200Strategy, Map<String, String> map) throws IOException {
        this((InputStream) null, file, pack200Strategy, map);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
        r3.addSuppressed(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Pack200CompressorInputStream(java.io.InputStream r3, java.io.File r4, org.apache.commons.compress.compressors.pack200.Pack200Strategy r5, java.util.Map<java.lang.String, java.lang.String> r6) throws java.io.IOException {
        /*
            r2 = this;
            r2.<init>()
            r2.originalInput = r3
            org.apache.commons.compress.compressors.pack200.StreamBridge r5 = r5.newStreamBridge()
            r2.streamBridge = r5
            java.util.jar.JarOutputStream r0 = new java.util.jar.JarOutputStream
            r0.<init>(r5)
            java.util.jar.Pack200$Unpacker r5 = java.util.jar.Pack200.newUnpacker()     // Catch:{ all -> 0x002f }
            if (r6 == 0) goto L_0x001d
            java.util.SortedMap r1 = r5.properties()     // Catch:{ all -> 0x002f }
            r1.putAll(r6)     // Catch:{ all -> 0x002f }
        L_0x001d:
            if (r4 != 0) goto L_0x0028
            org.apache.commons.compress.compressors.pack200.Pack200CompressorInputStream$1 r4 = new org.apache.commons.compress.compressors.pack200.Pack200CompressorInputStream$1     // Catch:{ all -> 0x002f }
            r4.<init>(r3)     // Catch:{ all -> 0x002f }
            r5.unpack(r4, r0)     // Catch:{ all -> 0x002f }
            goto L_0x002b
        L_0x0028:
            r5.unpack(r4, r0)     // Catch:{ all -> 0x002f }
        L_0x002b:
            r0.close()
            return
        L_0x002f:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0031 }
        L_0x0031:
            r4 = move-exception
            r0.close()     // Catch:{ all -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r5 = move-exception
            r3.addSuppressed(r5)
        L_0x003a:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.compressors.pack200.Pack200CompressorInputStream.<init>(java.io.InputStream, java.io.File, org.apache.commons.compress.compressors.pack200.Pack200Strategy, java.util.Map):void");
    }

    public int read() throws IOException {
        return this.streamBridge.getInput().read();
    }

    public int read(byte[] bArr) throws IOException {
        return this.streamBridge.getInput().read(bArr);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.streamBridge.getInput().read(bArr, i, i2);
    }

    public int available() throws IOException {
        return this.streamBridge.getInput().available();
    }

    public boolean markSupported() {
        try {
            return this.streamBridge.getInput().markSupported();
        } catch (IOException unused) {
            return false;
        }
    }

    public void mark(int i) {
        try {
            this.streamBridge.getInput().mark(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void reset() throws IOException {
        this.streamBridge.getInput().reset();
    }

    public long skip(long j) throws IOException {
        return IOUtils.skip(this.streamBridge.getInput(), j);
    }

    public void close() throws IOException {
        try {
            this.streamBridge.stop();
        } finally {
            InputStream inputStream = this.originalInput;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    static {
        byte[] bArr = {-54, -2, -48, 13};
        CAFE_DOOD = bArr;
        SIG_LENGTH = bArr.length;
    }

    public static boolean matches(byte[] bArr, int i) {
        if (i < SIG_LENGTH) {
            return false;
        }
        for (int i2 = 0; i2 < SIG_LENGTH; i2++) {
            if (bArr[i2] != CAFE_DOOD[i2]) {
                return false;
            }
        }
        return true;
    }
}
