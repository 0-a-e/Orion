package org.apache.commons.compress.archivers.examples;

import java.io.Closeable;
import java.io.IOException;

public interface CloseableConsumer {
    public static final CloseableConsumer CLOSING_CONSUMER = new CloseableConsumer() {
        public void accept(Closeable closeable) throws IOException {
            closeable.close();
        }
    };
    public static final CloseableConsumer NULL_CONSUMER = new CloseableConsumer() {
        public void accept(Closeable closeable) {
        }
    };

    void accept(Closeable closeable) throws IOException;
}
