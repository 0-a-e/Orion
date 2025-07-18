package com.amazonaws.internal;

import com.amazonaws.AbortedException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SdkFilterInputStream extends FilterInputStream implements MetricAware {
    /* access modifiers changed from: protected */
    public void abort() {
    }

    protected SdkFilterInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Deprecated
    public boolean isMetricActivated() {
        if (this.in instanceof MetricAware) {
            return ((MetricAware) this.in).isMetricActivated();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final void abortIfNeeded() {
        if (Thread.interrupted()) {
            abort();
            throw new AbortedException();
        }
    }

    public int read() throws IOException {
        abortIfNeeded();
        return this.in.read();
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        abortIfNeeded();
        return this.in.read(bArr, i, i2);
    }

    public long skip(long j) throws IOException {
        abortIfNeeded();
        return this.in.skip(j);
    }

    public int available() throws IOException {
        abortIfNeeded();
        return this.in.available();
    }

    public void close() throws IOException {
        this.in.close();
        abortIfNeeded();
    }

    public synchronized void mark(int i) {
        abortIfNeeded();
        this.in.mark(i);
    }

    public synchronized void reset() throws IOException {
        abortIfNeeded();
        this.in.reset();
    }

    public boolean markSupported() {
        abortIfNeeded();
        return this.in.markSupported();
    }
}
