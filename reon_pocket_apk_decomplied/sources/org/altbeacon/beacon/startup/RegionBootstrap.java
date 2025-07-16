package org.altbeacon.beacon.startup;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;
import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.MonitorNotifier;
import org.altbeacon.beacon.Region;
import org.altbeacon.beacon.logging.LogManager;

@Deprecated
public class RegionBootstrap {
    protected static final String TAG = "AppStarter";
    private BeaconConsumer beaconConsumer;
    /* access modifiers changed from: private */
    public BeaconManager beaconManager;
    /* access modifiers changed from: private */
    public Context context;
    private boolean disabled = false;
    /* access modifiers changed from: private */
    public MonitorNotifier monitorNotifier;
    /* access modifiers changed from: private */
    public List<Region> regions;
    /* access modifiers changed from: private */
    public boolean serviceConnected = false;

    public RegionBootstrap(Context context2, MonitorNotifier monitorNotifier2, Region region) {
        if (context2 != null) {
            this.context = context2.getApplicationContext();
            this.monitorNotifier = monitorNotifier2;
            ArrayList arrayList = new ArrayList();
            this.regions = arrayList;
            arrayList.add(region);
            this.beaconManager = BeaconManager.getInstanceForApplication(context2);
            this.beaconConsumer = new InternalBeaconConsumer();
            if (this.beaconManager.isBackgroundModeUninitialized()) {
                this.beaconManager.setBackgroundMode(true);
            }
            this.beaconManager.bind(this.beaconConsumer);
            LogManager.d(TAG, "Waiting for BeaconService connection", new Object[0]);
            return;
        }
        throw new NullPointerException("Application Context should not be null");
    }

    public RegionBootstrap(Context context2, MonitorNotifier monitorNotifier2, List<Region> list) {
        if (context2 != null) {
            this.context = context2.getApplicationContext();
            this.monitorNotifier = monitorNotifier2;
            this.regions = list;
            this.beaconManager = BeaconManager.getInstanceForApplication(context2);
            this.beaconConsumer = new InternalBeaconConsumer();
            if (this.beaconManager.isBackgroundModeUninitialized()) {
                this.beaconManager.setBackgroundMode(true);
            }
            this.beaconManager.bind(this.beaconConsumer);
            LogManager.d(TAG, "Waiting for BeaconService connection", new Object[0]);
            return;
        }
        throw new NullPointerException("Application Context should not be null");
    }

    public RegionBootstrap(BootstrapNotifier bootstrapNotifier, Region region) {
        if (bootstrapNotifier.getApplicationContext() != null) {
            this.context = bootstrapNotifier.getApplicationContext();
            ArrayList arrayList = new ArrayList();
            this.regions = arrayList;
            arrayList.add(region);
            this.monitorNotifier = bootstrapNotifier;
            this.beaconManager = BeaconManager.getInstanceForApplication(this.context);
            this.beaconConsumer = new InternalBeaconConsumer();
            if (this.beaconManager.isBackgroundModeUninitialized()) {
                this.beaconManager.setBackgroundMode(true);
            }
            this.beaconManager.bind(this.beaconConsumer);
            LogManager.d(TAG, "Waiting for BeaconService connection", new Object[0]);
            return;
        }
        throw new NullPointerException("The BootstrapNotifier instance is returning null from its getApplicationContext() method.  Have you implemented this method?");
    }

    public RegionBootstrap(BootstrapNotifier bootstrapNotifier, List<Region> list) {
        if (bootstrapNotifier.getApplicationContext() != null) {
            Context applicationContext = bootstrapNotifier.getApplicationContext();
            this.context = applicationContext;
            this.regions = list;
            this.monitorNotifier = bootstrapNotifier;
            this.beaconManager = BeaconManager.getInstanceForApplication(applicationContext);
            this.beaconConsumer = new InternalBeaconConsumer();
            if (this.beaconManager.isBackgroundModeUninitialized()) {
                this.beaconManager.setBackgroundMode(true);
            }
            this.beaconManager.bind(this.beaconConsumer);
            LogManager.d(TAG, "Waiting for BeaconService connection", new Object[0]);
            return;
        }
        throw new NullPointerException("The BootstrapNotifier instance is returning null from its getApplicationContext() method.  Have you implemented this method?");
    }

    public void disable() {
        if (!this.disabled) {
            this.disabled = true;
            try {
                for (Region stopMonitoringBeaconsInRegion : this.regions) {
                    this.beaconManager.stopMonitoringBeaconsInRegion(stopMonitoringBeaconsInRegion);
                }
            } catch (RemoteException e) {
                LogManager.e(e, TAG, "Can't stop bootstrap regions", new Object[0]);
            }
            this.beaconManager.unbind(this.beaconConsumer);
        }
    }

    public void addRegion(Region region) {
        if (!this.regions.contains(region)) {
            if (this.serviceConnected) {
                try {
                    this.beaconManager.startMonitoringBeaconsInRegion(region);
                } catch (RemoteException e) {
                    LogManager.e(e, TAG, "Can't add bootstrap region", new Object[0]);
                }
            } else {
                LogManager.w(TAG, "Adding a region: service not yet Connected", new Object[0]);
            }
            this.regions.add(region);
        }
    }

    public void removeRegion(Region region) {
        if (this.regions.contains(region)) {
            if (this.serviceConnected) {
                try {
                    this.beaconManager.stopMonitoringBeaconsInRegion(region);
                } catch (RemoteException e) {
                    LogManager.e(e, TAG, "Can't stop bootstrap region", new Object[0]);
                }
            } else {
                LogManager.w(TAG, "Removing a region: service not yet Connected", new Object[0]);
            }
            this.regions.remove(region);
        }
    }

    private class InternalBeaconConsumer implements BeaconConsumer {
        private Intent serviceIntent;

        private InternalBeaconConsumer() {
        }

        public void onBeaconServiceConnect() {
            LogManager.d(RegionBootstrap.TAG, "Activating background region monitoring", new Object[0]);
            RegionBootstrap.this.beaconManager.addMonitorNotifier(RegionBootstrap.this.monitorNotifier);
            boolean unused = RegionBootstrap.this.serviceConnected = true;
            try {
                for (Region region : RegionBootstrap.this.regions) {
                    LogManager.d(RegionBootstrap.TAG, "Background region monitoring activated for region %s", region);
                    RegionBootstrap.this.beaconManager.startMonitoringBeaconsInRegion(region);
                }
            } catch (RemoteException e) {
                LogManager.e(e, RegionBootstrap.TAG, "Can't set up bootstrap regions", new Object[0]);
            }
        }

        public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
            this.serviceIntent = intent;
            RegionBootstrap.this.context.startService(intent);
            return RegionBootstrap.this.context.bindService(intent, serviceConnection, i);
        }

        public Context getApplicationContext() {
            return RegionBootstrap.this.context;
        }

        public void unbindService(ServiceConnection serviceConnection) {
            RegionBootstrap.this.context.unbindService(serviceConnection);
            RegionBootstrap.this.context.stopService(this.serviceIntent);
            boolean unused = RegionBootstrap.this.serviceConnected = false;
        }
    }
}
