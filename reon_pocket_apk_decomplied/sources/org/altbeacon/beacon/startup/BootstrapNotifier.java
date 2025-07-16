package org.altbeacon.beacon.startup;

import android.content.Context;
import org.altbeacon.beacon.MonitorNotifier;

@Deprecated
public interface BootstrapNotifier extends MonitorNotifier {
    Context getApplicationContext();
}
