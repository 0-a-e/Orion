package org.altbeacon.beacon.service;

import org.altbeacon.beacon.logging.LogManager;

public class ArmaRssiFilter implements RssiFilter {
    private static double DEFAULT_ARMA_SPEED = 0.1d;
    private static final String TAG = "ArmaRssiFilter";
    private int armaMeasurement;
    private double armaSpeed = DEFAULT_ARMA_SPEED;
    private boolean isInitialized = false;

    public int getMeasurementCount() {
        return 0;
    }

    public boolean noMeasurementsAvailable() {
        return false;
    }

    public void addMeasurement(Integer num) {
        LogManager.d(TAG, "adding rssi: %s", num);
        if (!this.isInitialized) {
            this.armaMeasurement = num.intValue();
            this.isInitialized = true;
        }
        int i = this.armaMeasurement;
        int intValue = Double.valueOf(((double) i) - (this.armaSpeed * ((double) (i - num.intValue())))).intValue();
        this.armaMeasurement = intValue;
        LogManager.d(TAG, "armaMeasurement: %s", Integer.valueOf(intValue));
    }

    public double calculateRssi() {
        return (double) this.armaMeasurement;
    }

    public static void setDEFAULT_ARMA_SPEED(double d) {
        DEFAULT_ARMA_SPEED = d;
    }
}
