package org.altbeacon.beacon;

import android.content.Context;
import android.content.Intent;
import java.util.Collection;
import java.util.Set;
import org.altbeacon.beacon.logging.LogManager;
import org.altbeacon.beacon.service.MonitoringData;
import org.altbeacon.beacon.service.MonitoringStatus;
import org.altbeacon.beacon.service.RangingData;

public class IntentHandler {
    private static final String TAG = "IntentHandler";

    public void convertIntentsToCallbacks(Context context, Intent intent) {
        MonitoringData monitoringData;
        RangingData rangingData = null;
        if (intent == null || intent.getExtras() == null) {
            monitoringData = null;
        } else {
            monitoringData = intent.getExtras().getBundle("monitoringData") != null ? MonitoringData.fromBundle(intent.getExtras().getBundle("monitoringData")) : null;
            if (intent.getExtras().getBundle("rangingData") != null) {
                rangingData = RangingData.fromBundle(intent.getExtras().getBundle("rangingData"));
            }
        }
        if (rangingData != null) {
            String str = TAG;
            LogManager.d(str, "got ranging data", new Object[0]);
            if (rangingData.getBeacons() == null) {
                LogManager.w(str, "Ranging data has a null beacons collection", new Object[0]);
            }
            Set<RangeNotifier> rangingNotifiers = BeaconManager.getInstanceForApplication(context).getRangingNotifiers();
            Collection<Beacon> beacons = rangingData.getBeacons();
            if (rangingNotifiers != null) {
                for (RangeNotifier didRangeBeaconsInRegion : rangingNotifiers) {
                    didRangeBeaconsInRegion.didRangeBeaconsInRegion(beacons, rangingData.getRegion());
                }
            } else {
                LogManager.d(str, "but ranging notifier is null, so we're dropping it.", new Object[0]);
            }
            RangeNotifier dataRequestNotifier = BeaconManager.getInstanceForApplication(context).getDataRequestNotifier();
            if (dataRequestNotifier != null) {
                dataRequestNotifier.didRangeBeaconsInRegion(beacons, rangingData.getRegion());
            }
            if (BeaconManager.getInstanceForApplication(context).isRegionViewModelInitialized(rangingData.getRegion())) {
                BeaconManager.getInstanceForApplication(context).getRegionViewModel(rangingData.getRegion()).getRangedBeacons().postValue(rangingData.getBeacons());
            }
        }
        if (monitoringData != null) {
            LogManager.d(TAG, "got monitoring data", new Object[0]);
            Set<MonitorNotifier> monitoringNotifiers = BeaconManager.getInstanceForApplication(context).getMonitoringNotifiers();
            Region region = monitoringData.getRegion();
            boolean isInside = monitoringData.isInside();
            Integer valueOf = Integer.valueOf(isInside ? 1 : 0);
            if (monitoringNotifiers != null) {
                for (MonitorNotifier next : monitoringNotifiers) {
                    LogManager.d(TAG, "Calling monitoring notifier: %s", next);
                    valueOf.getClass();
                    next.didDetermineStateForRegion(isInside, region);
                    MonitoringStatus.getInstanceForApplication(context).updateLocalState(region, valueOf);
                    if (monitoringData.isInside()) {
                        next.didEnterRegion(monitoringData.getRegion());
                    } else {
                        next.didExitRegion(monitoringData.getRegion());
                    }
                }
            }
            if (BeaconManager.getInstanceForApplication(context).isRegionViewModelInitialized(monitoringData.getRegion())) {
                BeaconManager.getInstanceForApplication(context).getRegionViewModel(monitoringData.getRegion()).getRegionState().postValue(valueOf);
            }
        }
    }
}
