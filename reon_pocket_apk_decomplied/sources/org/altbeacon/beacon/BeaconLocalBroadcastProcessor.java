package org.altbeacon.beacon;

import android.content.Context;
import android.content.Intent;
import org.altbeacon.beacon.logging.LogManager;

public class BeaconLocalBroadcastProcessor {
    public static final String MONITOR_NOTIFICATION = "org.altbeacon.beacon.monitor_notification";
    public static final String RANGE_NOTIFICATION = "org.altbeacon.beacon.range_notification";
    private static final String TAG = "BeaconLocalBroadcastProcessor";
    private static BeaconLocalBroadcastProcessor mInstance;
    private Context mContext;
    int registerCallCount = 0;

    public static synchronized BeaconLocalBroadcastProcessor getInstance(Context context) {
        BeaconLocalBroadcastProcessor beaconLocalBroadcastProcessor;
        synchronized (BeaconLocalBroadcastProcessor.class) {
            if (mInstance == null) {
                mInstance = new BeaconLocalBroadcastProcessor(context);
            }
            beaconLocalBroadcastProcessor = mInstance;
        }
        return beaconLocalBroadcastProcessor;
    }

    private BeaconLocalBroadcastProcessor() {
    }

    private BeaconLocalBroadcastProcessor(Context context) {
        this.mContext = context;
    }

    public void register() {
        this.registerCallCount++;
        LogManager.d(TAG, "Register calls: global=" + this.registerCallCount, new Object[0]);
        unregister();
    }

    public void unregister() {
        this.registerCallCount--;
    }

    public void onReceive(Context context, Intent intent) {
        if (this.registerCallCount > 0) {
            new IntentHandler().convertIntentsToCallbacks(context, intent);
        }
    }
}
