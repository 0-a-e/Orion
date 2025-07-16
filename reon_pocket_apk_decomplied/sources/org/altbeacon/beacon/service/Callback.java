package org.altbeacon.beacon.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.IntentHandler;
import org.altbeacon.beacon.logging.LogManager;

public class Callback implements Serializable {
    private static final String TAG = "Callback";

    public Callback(String str) {
    }

    public boolean call(Context context, String str, Bundle bundle) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context.getPackageName(), "org.altbeacon.beacon.BeaconIntentProcessor"));
        intent.putExtra(str, bundle);
        if (BeaconManager.getInstanceForApplication(context).isScannerInDifferentProcess()) {
            LogManager.d(TAG, "attempting callback via global broadcast intent: %s", intent.getComponent());
            try {
                context.startService(intent);
                return true;
            } catch (Exception e) {
                LogManager.e(TAG, "Failed attempting to start service: " + intent.getComponent().flattenToString(), e);
                return false;
            }
        } else {
            LogManager.d(TAG, "attempting callback via direct method call", new Object[0]);
            new IntentHandler().convertIntentsToCallbacks(context, intent);
            return false;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
    }
}
