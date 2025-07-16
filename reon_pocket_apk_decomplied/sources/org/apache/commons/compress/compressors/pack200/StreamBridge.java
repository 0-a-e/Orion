package org.apache.commons.compress.compressors.pack200;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

abstract class StreamBridge extends FilterOutputStream {
    private InputStream input;
    private final Object inputLock;

    /* access modifiers changed from: package-private */
    public abstract InputStream getInputView() throws IOException;

    protected StreamBridge(OutputStream outputStream) {
        super(outputStream);
        this.inputLock = new Object();
    }

    protected StreamBridge() {
        this((OutputStream) null);
    }

    /* access modifiers changed from: package-private */
    public InputStream getInput() throws IOException {
        synchronized (this.inputLock) {
            if (this.input == null) {
                this.input = getInputView();
            }
        }
        return this.input;
    }

    /* access modifiers changed from: package-private */
    public void stop() throws IOException {
        close();
        synchronized (this.inputLock) {
            InputStream inputStream = this.input;
            if (inputStream != null) {
                inputStream.close();
                this.input = null;
            }
        }
    }
}
