package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;

public interface UnparseableExtraFieldBehavior {
    ZipExtraField onUnparseableExtraField(byte[] bArr, int i, int i2, boolean z, int i3) throws ZipException;
}
