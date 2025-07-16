package org.apache.commons.compress.archivers.sevenz;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

abstract class CoderBase {
    private static final byte[] NONE = new byte[0];
    private final Class<?>[] acceptableOptions;

    /* access modifiers changed from: package-private */
    public abstract InputStream decode(String str, InputStream inputStream, long j, Coder coder, byte[] bArr, int i) throws IOException;

    /* access modifiers changed from: package-private */
    public Object getOptionsFromCoder(Coder coder, InputStream inputStream) throws IOException {
        return null;
    }

    protected CoderBase(Class<?>... clsArr) {
        this.acceptableOptions = clsArr;
    }

    /* access modifiers changed from: package-private */
    public boolean canAcceptOptions(Object obj) {
        for (Class<?> isInstance : this.acceptableOptions) {
            if (isInstance.isInstance(obj)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public byte[] getOptionsAsProperties(Object obj) throws IOException {
        return NONE;
    }

    /* access modifiers changed from: package-private */
    public OutputStream encode(OutputStream outputStream, Object obj) throws IOException {
        throw new UnsupportedOperationException("Method doesn't support writing");
    }

    protected static int numberOptionOrDefault(Object obj, int i) {
        return obj instanceof Number ? ((Number) obj).intValue() : i;
    }
}
