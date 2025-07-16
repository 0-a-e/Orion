package org.apache.commons.compress.utils;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CloseShieldFilterInputStream extends FilterInputStream {
    public void close() throws IOException {
    }

    public CloseShieldFilterInputStream(InputStream inputStream) {
        super(inputStream);
    }
}
