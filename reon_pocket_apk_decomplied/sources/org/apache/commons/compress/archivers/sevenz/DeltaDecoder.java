package org.apache.commons.compress.archivers.sevenz;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.tukaani.xz.DeltaOptions;
import org.tukaani.xz.FinishableWrapperOutputStream;
import org.tukaani.xz.UnsupportedOptionsException;

class DeltaDecoder extends CoderBase {
    DeltaDecoder() {
        super(Number.class);
    }

    /* access modifiers changed from: package-private */
    public InputStream decode(String str, InputStream inputStream, long j, Coder coder, byte[] bArr, int i) throws IOException {
        return new DeltaOptions(getOptionsFromCoder(coder)).getInputStream(inputStream);
    }

    /* access modifiers changed from: package-private */
    public OutputStream encode(OutputStream outputStream, Object obj) throws IOException {
        try {
            return new DeltaOptions(numberOptionOrDefault(obj, 1)).getOutputStream(new FinishableWrapperOutputStream(outputStream));
        } catch (UnsupportedOptionsException e) {
            throw new IOException(e.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public byte[] getOptionsAsProperties(Object obj) {
        return new byte[]{(byte) (numberOptionOrDefault(obj, 1) - 1)};
    }

    /* access modifiers changed from: package-private */
    public Object getOptionsFromCoder(Coder coder, InputStream inputStream) {
        return Integer.valueOf(getOptionsFromCoder(coder));
    }

    private int getOptionsFromCoder(Coder coder) {
        if (coder.properties == null || coder.properties.length == 0) {
            return 1;
        }
        return (coder.properties[0] & 255) + 1;
    }
}
