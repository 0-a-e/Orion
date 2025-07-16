package org.altbeacon.beacon.startup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import java.util.ArrayList;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.logging.LogManager;
import org.altbeacon.beacon.service.ScanJobScheduler;

public class StartupBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "StartupBroadcastReceiver";

    public void onReceive(Context context, Intent intent) {
        LogManager.d(TAG, "onReceive called in startup broadcast receiver", new Object[0]);
        BeaconManager instanceForApplication = BeaconManager.getInstanceForApplication(context.getApplicationContext());
        if (instanceForApplication.isAnyConsumerBound() || instanceForApplication.getScheduledScanJobsEnabled() || instanceForApplication.getIntentScanStrategyCoordinator() != null) {
            int intExtra = intent.getIntExtra("android.bluetooth.le.extra.CALLBACK_TYPE", -1);
            if (intExtra != -1) {
                LogManager.d(TAG, "Passive background scan callback type: " + intExtra, new Object[0]);
                LogManager.d(TAG, "got Android O background scan via intent", new Object[0]);
                int intExtra2 = intent.getIntExtra("android.bluetooth.le.extra.ERROR_CODE", -1);
                if (intExtra2 != -1) {
                    LogManager.w(TAG, "Passive background scan failed.  Code; " + intExtra2, new Object[0]);
                }
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("android.bluetooth.le.extra.LIST_SCAN_RESULT");
                if (instanceForApplication.getIntentScanStrategyCoordinator() != null && Build.VERSION.SDK_INT >= 26) {
                    instanceForApplication.getIntentScanStrategyCoordinator().processScanResults(parcelableArrayListExtra);
                } else if (instanceForApplication.getScheduledScanJobsEnabled()) {
                    ScanJobScheduler.getInstance().scheduleAfterBackgroundWakeup(context, parcelableArrayListExtra);
                }
            } else if (intent.getBooleanExtra("wakeup", false)) {
                LogManager.d(TAG, "got wake up intent", new Object[0]);
            } else {
                LogManager.d(TAG, "Already started.  Ignoring intent: %s of type: %s", intent, intent.getStringExtra("wakeup"));
            }
        } else {
            LogManager.d(TAG, "No consumers are bound.  Ignoring broadcast receiver.", new Object[0]);
        }
    }
}
