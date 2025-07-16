package org.apache.commons.compress.compressors.zstandard;

public class ZstdUtils {
    private static final byte[] SKIPPABLE_FRAME_MAGIC = {42, 77, 24};
    private static final byte[] ZSTANDARD_FRAME_MAGIC = {40, -75, 47, -3};
    private static volatile CachedAvailability cachedZstdAvailability = CachedAvailability.DONT_CACHE;

    enum CachedAvailability {
        DONT_CACHE,
        CACHED_AVAILABLE,
        CACHED_UNAVAILABLE
    }

    static {
        try {
            Class.forName("org.osgi.framework.BundleEvent");
        } catch (Exception unused) {
            setCacheZstdAvailablity(true);
        }
    }

    private ZstdUtils() {
    }

    public static boolean isZstdCompressionAvailable() {
        CachedAvailability cachedAvailability = cachedZstdAvailability;
        if (cachedAvailability != CachedAvailability.DONT_CACHE) {
            return cachedAvailability == CachedAvailability.CACHED_AVAILABLE;
        }
        return internalIsZstdCompressionAvailable();
    }

    private static boolean internalIsZstdCompressionAvailable() {
        try {
            Class.forName("com.github.luben.zstd.ZstdInputStream");
            return true;
        } catch (Exception | NoClassDefFoundError unused) {
            return false;
        }
    }

    public static void setCacheZstdAvailablity(boolean z) {
        if (!z) {
            cachedZstdAvailability = CachedAvailability.DONT_CACHE;
        } else if (cachedZstdAvailability == CachedAvailability.DONT_CACHE) {
            cachedZstdAvailability = internalIsZstdCompressionAvailable() ? CachedAvailability.CACHED_AVAILABLE : CachedAvailability.CACHED_UNAVAILABLE;
        }
    }

    public static boolean matches(byte[] bArr, int i) {
        if (i < ZSTANDARD_FRAME_MAGIC.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr2 = ZSTANDARD_FRAME_MAGIC;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i2] == bArr2[i2]) {
                i2++;
            } else if (80 != (bArr[0] & 240)) {
                return false;
            } else {
                int i3 = 0;
                while (true) {
                    byte[] bArr3 = SKIPPABLE_FRAME_MAGIC;
                    if (i3 >= bArr3.length) {
                        return true;
                    }
                    int i4 = i3 + 1;
                    if (bArr[i4] != bArr3[i3]) {
                        return false;
                    }
                    i3 = i4;
                }
            }
        }
    }

    static CachedAvailability getCachedZstdAvailability() {
        return cachedZstdAvailability;
    }
}
