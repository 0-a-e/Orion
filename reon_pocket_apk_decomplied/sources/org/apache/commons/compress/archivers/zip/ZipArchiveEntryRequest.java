package org.apache.commons.compress.archivers.zip;

import java.io.InputStream;
import org.apache.commons.compress.parallel.InputStreamSupplier;

public class ZipArchiveEntryRequest {
    private final int method;
    private final InputStreamSupplier payloadSupplier;
    private final ZipArchiveEntry zipArchiveEntry;

    private ZipArchiveEntryRequest(ZipArchiveEntry zipArchiveEntry2, InputStreamSupplier inputStreamSupplier) {
        this.zipArchiveEntry = zipArchiveEntry2;
        this.payloadSupplier = inputStreamSupplier;
        this.method = zipArchiveEntry2.getMethod();
    }

    public static ZipArchiveEntryRequest createZipArchiveEntryRequest(ZipArchiveEntry zipArchiveEntry2, InputStreamSupplier inputStreamSupplier) {
        return new ZipArchiveEntryRequest(zipArchiveEntry2, inputStreamSupplier);
    }

    public InputStream getPayloadStream() {
        return this.payloadSupplier.get();
    }

    public int getMethod() {
        return this.method;
    }

    /* access modifiers changed from: package-private */
    public ZipArchiveEntry getZipArchiveEntry() {
        return this.zipArchiveEntry;
    }
}
