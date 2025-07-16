package no.nordicsemi.android.dfu.internal.scanner;

import no.nordicsemi.android.dfu.DfuDeviceSelector;

public interface BootloaderScanner {
    String searchUsing(DfuDeviceSelector dfuDeviceSelector, long j);
}
