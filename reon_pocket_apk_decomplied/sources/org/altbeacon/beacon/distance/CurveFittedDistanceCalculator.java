package org.altbeacon.beacon.distance;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.altbeacon.beacon.logging.LogManager;

public class CurveFittedDistanceCalculator implements DistanceCalculator {
    public static final String TAG = "CurveFittedDistanceCalculator";
    private double mCoefficient1;
    private double mCoefficient2;
    private double mCoefficient3;

    public CurveFittedDistanceCalculator(double d, double d2, double d3) {
        this.mCoefficient1 = d;
        this.mCoefficient2 = d2;
        this.mCoefficient3 = d3;
    }

    public double calculateDistance(int i, double d) {
        double d2;
        if (d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return -1.0d;
        }
        LogManager.d(TAG, "calculating distance based on mRssi of %s and txPower of %s", Double.valueOf(d), Integer.valueOf(i));
        double d3 = (d * 1.0d) / ((double) i);
        if (d3 < 1.0d) {
            d2 = Math.pow(d3, 10.0d);
        } else {
            d2 = (this.mCoefficient1 * Math.pow(d3, this.mCoefficient2)) + this.mCoefficient3;
        }
        LogManager.d(TAG, "avg mRssi: %s distance: %s", Double.valueOf(d), Double.valueOf(d2));
        return d2;
    }
}
