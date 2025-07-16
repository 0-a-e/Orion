package org.apache.commons.compress.compressors.pack200;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import org.apache.commons.compress.compressors.CompressorOutputStream;

public class Pack200CompressorOutputStream extends CompressorOutputStream {
    private boolean finished;
    private final OutputStream originalOutput;
    private final Map<String, String> properties;
    private final StreamBridge streamBridge;

    public Pack200CompressorOutputStream(OutputStream outputStream) throws IOException {
        this(outputStream, Pack200Strategy.IN_MEMORY);
    }

    public Pack200CompressorOutputStream(OutputStream outputStream, Pack200Strategy pack200Strategy) throws IOException {
        this(outputStream, pack200Strategy, (Map<String, String>) null);
    }

    public Pack200CompressorOutputStream(OutputStream outputStream, Map<String, String> map) throws IOException {
        this(outputStream, Pack200Strategy.IN_MEMORY, map);
    }

    public Pack200CompressorOutputStream(OutputStream outputStream, Pack200Strategy pack200Strategy, Map<String, String> map) throws IOException {
        this.finished = false;
        this.originalOutput = outputStream;
        this.streamBridge = pack200Strategy.newStreamBridge();
        this.properties = map;
    }

    public void write(int i) throws IOException {
        this.streamBridge.write(i);
    }

    public void write(byte[] bArr) throws IOException {
        this.streamBridge.write(bArr);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.streamBridge.write(bArr, i, i2);
    }

    public void close() throws IOException {
        try {
            finish();
            try {
                this.streamBridge.stop();
            } finally {
                this.originalOutput.close();
            }
        } catch (Throwable th) {
            this.streamBridge.stop();
            throw th;
        } finally {
            this.originalOutput.close();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0033, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
        r0.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void finish() throws java.io.IOException {
        /*
            r3 = this;
            boolean r0 = r3.finished
            if (r0 != 0) goto L_0x0038
            r0 = 1
            r3.finished = r0
            java.util.jar.Pack200$Packer r0 = java.util.jar.Pack200.newPacker()
            java.util.Map<java.lang.String, java.lang.String> r1 = r3.properties
            if (r1 == 0) goto L_0x0018
            java.util.SortedMap r1 = r0.properties()
            java.util.Map<java.lang.String, java.lang.String> r2 = r3.properties
            r1.putAll(r2)
        L_0x0018:
            java.util.jar.JarInputStream r1 = new java.util.jar.JarInputStream
            org.apache.commons.compress.compressors.pack200.StreamBridge r2 = r3.streamBridge
            java.io.InputStream r2 = r2.getInput()
            r1.<init>(r2)
            java.io.OutputStream r2 = r3.originalOutput     // Catch:{ all -> 0x002c }
            r0.pack(r1, r2)     // Catch:{ all -> 0x002c }
            r1.close()
            goto L_0x0038
        L_0x002c:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x002e }
        L_0x002e:
            r2 = move-exception
            r1.close()     // Catch:{ all -> 0x0033 }
            goto L_0x0037
        L_0x0033:
            r1 = move-exception
            r0.addSuppressed(r1)
        L_0x0037:
            throw r2
        L_0x0038:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream.finish():void");
    }
}
