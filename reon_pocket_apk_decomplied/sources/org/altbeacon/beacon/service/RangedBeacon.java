package org.altbeacon.beacon.service;

import android.os.SystemClock;
import java.io.Serializable;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.logging.LogManager;

public class RangedBeacon implements Serializable {
    public static final long DEFAULT_MAX_TRACKING_AGE = 5000;
    public static final long DEFAULT_SAMPLE_EXPIRATION_MILLISECONDS = 20000;
    private static final String TAG = "RangedBeacon";
    public static long maxTrackingAge = 5000;
    private static long sampleExpirationMilliseconds = 20000;
    private long firstCycleDetectionTimestamp = 0;
    private long lastCycleDetectionTimestamp = 0;
    protected long lastTrackedTimeMillis = 0;
    Beacon mBeacon;
    protected transient RssiFilter mFilter = null;
    private boolean mTracked = true;
    private int packetCount = 0;

    public RangedBeacon(Beacon beacon) {
        updateBeacon(beacon);
    }

    public void updateBeacon(Beacon beacon) {
        this.packetCount++;
        this.mBeacon = beacon;
        if (this.firstCycleDetectionTimestamp == 0) {
            this.firstCycleDetectionTimestamp = beacon.getFirstCycleDetectionTimestamp();
        }
        this.lastCycleDetectionTimestamp = beacon.getLastCycleDetectionTimestamp();
        addMeasurement(Integer.valueOf(this.mBeacon.getRssi()));
    }

    public boolean isTracked() {
        return this.mTracked;
    }

    public void setTracked(boolean z) {
        this.mTracked = z;
    }

    public Beacon getBeacon() {
        return this.mBeacon;
    }

    public void commitMeasurements() {
        if (!getFilter().noMeasurementsAvailable()) {
            double calculateRssi = getFilter().calculateRssi();
            this.mBeacon.setRunningAverageRssi(calculateRssi);
            this.mBeacon.setRssiMeasurementCount(getFilter().getMeasurementCount());
            LogManager.d(TAG, "calculated new runningAverageRssi: %s", Double.valueOf(calculateRssi));
        } else {
            LogManager.d(TAG, "No measurements available to calculate running average", new Object[0]);
        }
        this.mBeacon.setPacketCount(this.packetCount);
        this.mBeacon.setFirstCycleDetectionTimestamp(this.firstCycleDetectionTimestamp);
        this.mBeacon.setLastCycleDetectionTimestamp(this.lastCycleDetectionTimestamp);
        this.packetCount = 0;
        this.firstCycleDetectionTimestamp = 0;
        this.lastCycleDetectionTimestamp = 0;
    }

    public void addMeasurement(Integer num) {
        if (num.intValue() != 127) {
            this.mTracked = true;
            this.lastTrackedTimeMillis = SystemClock.elapsedRealtime();
            getFilter().addMeasurement(num);
        }
    }

    public static void setSampleExpirationMilliseconds(long j) {
        sampleExpirationMilliseconds = j;
        RunningAverageRssiFilter.setSampleExpirationMilliseconds(j);
    }

    public static void setMaxTrackinAge(int i) {
        maxTrackingAge = (long) i;
    }

    public boolean noMeasurementsAvailable() {
        return getFilter().noMeasurementsAvailable();
    }

    public long getTrackingAge() {
        return SystemClock.elapsedRealtime() - this.lastTrackedTimeMillis;
    }

    public boolean isExpired() {
        return getTrackingAge() > maxTrackingAge;
    }

    private RssiFilter getFilter() {
        if (this.mFilter == null) {
            try {
                this.mFilter = (RssiFilter) BeaconManager.getRssiFilterImplClass().getConstructors()[0].newInstance((Object[]) null);
            } catch (Exception unused) {
                LogManager.e(TAG, "Could not construct RssiFilterImplClass %s", BeaconManager.getRssiFilterImplClass().getName());
            }
        }
        return this.mFilter;
    }
}
