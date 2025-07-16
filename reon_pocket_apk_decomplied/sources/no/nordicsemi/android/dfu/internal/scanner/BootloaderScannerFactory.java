package no.nordicsemi.android.dfu.internal.scanner;

import java.util.Locale;

public final class BootloaderScannerFactory {
    private static final int ADDRESS_DIFF = 1;

    private BootloaderScannerFactory() {
    }

    public static String getIncrementedAddress(String str) {
        String substring = str.substring(0, 15);
        String substring2 = str.substring(15);
        String format = String.format(Locale.US, "%02X", new Object[]{Integer.valueOf((Integer.valueOf(substring2, 16).intValue() + 1) & 255)});
        return substring + format;
    }

    public static BootloaderScanner getScanner(String str) {
        return new BootloaderScannerLollipop(str, getIncrementedAddress(str));
    }
}
