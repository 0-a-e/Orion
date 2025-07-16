package org.apache.commons.compress.archivers.examples;

import java.io.Closeable;
import java.io.IOException;

final class CloseableConsumerAdapter implements Closeable {
    private Closeable closeable;
    private final CloseableConsumer consumer;

    CloseableConsumerAdapter(CloseableConsumer closeableConsumer) {
        if (closeableConsumer != null) {
            this.consumer = closeableConsumer;
            return;
        }
        throw new NullPointerException("consumer must not be null");
    }

    /* access modifiers changed from: package-private */
    public <C extends Closeable> C track(C c) {
        this.closeable = c;
        return c;
    }

    public void close() throws IOException {
        Closeable closeable2 = this.closeable;
        if (closeable2 != null) {
            this.consumer.accept(closeable2);
        }
    }
}
