package org.altbeacon.beacon.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.logging.LogManager;

public class RangeState implements Serializable {
    private static final String TAG = "RangeState";
    private static boolean sUseTrackingCache = false;
    private Callback mCallback;
    private Map<Beacon, RangedBeacon> mRangedBeacons = new HashMap();

    public RangeState(Callback callback) {
        this.mCallback = callback;
    }

    public Callback getCallback() {
        return this.mCallback;
    }

    public void addBeacon(Beacon beacon) {
        RangedBeacon rangedBeacon = this.mRangedBeacons.get(beacon);
        if (rangedBeacon != null) {
            if (LogManager.isVerboseLoggingEnabled()) {
                LogManager.d(TAG, "adding %s to existing range for: %s", beacon, rangedBeacon);
            }
            rangedBeacon.updateBeacon(beacon);
            return;
        }
        if (LogManager.isVerboseLoggingEnabled()) {
            LogManager.d(TAG, "adding %s to new rangedBeacon", beacon);
        }
        this.mRangedBeacons.put(beacon, new RangedBeacon(beacon));
    }

    public int count() {
        int size;
        synchronized (this.mRangedBeacons) {
            size = this.mRangedBeacons.size();
        }
        return size;
    }

    public synchronized Collection<Beacon> finalizeBeacons() {
        ArrayList arrayList;
        HashMap hashMap = new HashMap();
        arrayList = new ArrayList();
        synchronized (this.mRangedBeacons) {
            for (Beacon next : this.mRangedBeacons.keySet()) {
                RangedBeacon rangedBeacon = this.mRangedBeacons.get(next);
                if (rangedBeacon != null) {
                    if (rangedBeacon.isTracked()) {
                        rangedBeacon.commitMeasurements();
                        if (!rangedBeacon.noMeasurementsAvailable()) {
                            arrayList.add(rangedBeacon.getBeacon());
                        }
                    }
                    if (!rangedBeacon.noMeasurementsAvailable()) {
                        if (!sUseTrackingCache || rangedBeacon.isExpired()) {
                            rangedBeacon.setTracked(false);
                        }
                        hashMap.put(next, rangedBeacon);
                    } else {
                        LogManager.d(TAG, "Dumping beacon from RangeState because it has no recent measurements.", new Object[0]);
                    }
                }
            }
            this.mRangedBeacons = hashMap;
        }
        return arrayList;
    }

    public static void setUseTrackingCache(boolean z) {
        sUseTrackingCache = z;
    }

    public static boolean getUseTrackingCache() {
        return sUseTrackingCache;
    }
}
