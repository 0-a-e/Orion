package org.altbeacon.beacon.service;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.Region;
import org.altbeacon.beacon.logging.LogManager;

public class MonitoringStatus {
    private static final int MAX_REGIONS_FOR_STATUS_PRESERVATION = 50;
    private static final int MAX_STATUS_PRESERVATION_FILE_AGE_TO_RESTORE_SECS = 900;
    private static final Object SINGLETON_LOCK = new Object();
    public static final String STATUS_PRESERVATION_FILE_NAME = "org.altbeacon.beacon.service.monitoring_status_state";
    private static final String TAG = "MonitoringStatus";
    private static volatile MonitoringStatus sInstance;
    private Context mContext;
    private Map<Region, RegionMonitoringState> mRegionsStatesMap;
    private boolean mStatePreservationIsOn = true;

    public static MonitoringStatus getInstanceForApplication(Context context) {
        MonitoringStatus monitoringStatus = sInstance;
        if (monitoringStatus == null) {
            synchronized (SINGLETON_LOCK) {
                monitoringStatus = sInstance;
                if (monitoringStatus == null) {
                    monitoringStatus = new MonitoringStatus(context.getApplicationContext());
                    sInstance = monitoringStatus;
                }
            }
        }
        return monitoringStatus;
    }

    public MonitoringStatus(Context context) {
        this.mContext = context;
    }

    public synchronized void addRegion(Region region, Callback callback) {
        addLocalRegion(region, callback);
        saveMonitoringStatusIfOn();
    }

    public synchronized void removeRegion(Region region) {
        removeLocalRegion(region);
        saveMonitoringStatusIfOn();
    }

    public synchronized Set<Region> regions() {
        return getRegionsStateMap().keySet();
    }

    public synchronized int regionsCount() {
        return regions().size();
    }

    public synchronized RegionMonitoringState stateOf(Region region) {
        return getRegionsStateMap().get(region);
    }

    public synchronized void updateNewlyOutside() {
        boolean z = false;
        for (Region next : regions()) {
            RegionMonitoringState stateOf = stateOf(next);
            if (stateOf.markOutsideIfExpired()) {
                LogManager.d(TAG, "found a monitor that expired: %s", next);
                stateOf.getCallback().call(this.mContext, "monitoringData", new MonitoringData(stateOf.getInside(), next).toBundle());
                z = true;
            }
        }
        if (z) {
            saveMonitoringStatusIfOn();
        } else {
            updateMonitoringStatusTime(System.currentTimeMillis());
        }
    }

    public synchronized boolean insideAnyRegion() {
        for (Region stateOf : regions()) {
            RegionMonitoringState stateOf2 = stateOf(stateOf);
            if (stateOf2 != null && stateOf2.getInside()) {
                return true;
            }
        }
        return false;
    }

    public synchronized void updateNewlyInsideInRegionsContaining(Beacon beacon) {
        boolean z = false;
        for (Region next : regionsMatchingTo(beacon)) {
            RegionMonitoringState regionMonitoringState = getRegionsStateMap().get(next);
            if (regionMonitoringState != null && regionMonitoringState.markInside()) {
                regionMonitoringState.getCallback().call(this.mContext, "monitoringData", new MonitoringData(regionMonitoringState.getInside(), next).toBundle());
                z = true;
            }
        }
        if (z) {
            saveMonitoringStatusIfOn();
        } else {
            updateMonitoringStatusTime(System.currentTimeMillis());
        }
    }

    private Map<Region, RegionMonitoringState> getRegionsStateMap() {
        if (this.mRegionsStatesMap == null) {
            restoreOrInitializeMonitoringStatus();
        }
        return this.mRegionsStatesMap;
    }

    private void restoreOrInitializeMonitoringStatus() {
        long currentTimeMillis = System.currentTimeMillis() - getLastMonitoringStatusUpdateTime();
        this.mRegionsStatesMap = new ConcurrentHashMap();
        if (!this.mStatePreservationIsOn) {
            LogManager.d(TAG, "Not restoring monitoring state because persistence is disabled", new Object[0]);
        } else if (currentTimeMillis > 900000) {
            String str = TAG;
            LogManager.d(str, "Not restoring monitoring state because it was recorded too many milliseconds ago: " + currentTimeMillis, new Object[0]);
        } else {
            restoreMonitoringStatus();
            LogManager.d(TAG, "Done restoring monitoring status", new Object[0]);
        }
    }

    private List<Region> regionsMatchingTo(Beacon beacon) {
        ArrayList arrayList = new ArrayList();
        for (Region next : regions()) {
            if (next.matchesBeacon(beacon)) {
                arrayList.add(next);
            } else {
                LogManager.d(TAG, "This region (%s) does not match beacon: %s", next, beacon);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:6|7|8|(8:9|10|11|12|(2:15|13)|49|16|(2:18|19))|20|21|53) */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0066 */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0091 A[SYNTHETIC, Splitter:B:34:0x0091] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009b A[SYNTHETIC, Splitter:B:41:0x009b] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a0 A[SYNTHETIC, Splitter:B:45:0x00a0] */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void saveMonitoringStatusIfOn() {
        /*
            r9 = this;
            boolean r0 = r9.mStatePreservationIsOn
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.String r0 = TAG
            java.lang.String r1 = "saveMonitoringStatusIfOn()"
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            org.altbeacon.beacon.logging.LogManager.d(r0, r1, r3)
            java.util.Map r1 = r9.getRegionsStateMap()
            int r1 = r1.size()
            r3 = 50
            java.lang.String r4 = "org.altbeacon.beacon.service.monitoring_status_state"
            if (r1 <= r3) goto L_0x002b
            java.lang.String r1 = "Too many regions being monitored.  Will not persist region state"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            org.altbeacon.beacon.logging.LogManager.w(r0, r1, r2)
            android.content.Context r0 = r9.mContext
            r0.deleteFile(r4)
            goto L_0x0097
        L_0x002b:
            r0 = 0
            android.content.Context r1 = r9.mContext     // Catch:{ IOException -> 0x007a, all -> 0x0075 }
            java.io.FileOutputStream r1 = r1.openFileOutput(r4, r2)     // Catch:{ IOException -> 0x007a, all -> 0x0075 }
            java.io.ObjectOutputStream r3 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0070, all -> 0x006c }
            r3.<init>(r1)     // Catch:{ IOException -> 0x0070, all -> 0x006c }
            java.util.Map r0 = r9.getRegionsStateMap()     // Catch:{ IOException -> 0x006a }
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ IOException -> 0x006a }
            r4.<init>()     // Catch:{ IOException -> 0x006a }
            java.util.Set r5 = r0.keySet()     // Catch:{ IOException -> 0x006a }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IOException -> 0x006a }
        L_0x0048:
            boolean r6 = r5.hasNext()     // Catch:{ IOException -> 0x006a }
            if (r6 == 0) goto L_0x005e
            java.lang.Object r6 = r5.next()     // Catch:{ IOException -> 0x006a }
            org.altbeacon.beacon.Region r6 = (org.altbeacon.beacon.Region) r6     // Catch:{ IOException -> 0x006a }
            java.lang.Object r7 = r0.get(r6)     // Catch:{ IOException -> 0x006a }
            org.altbeacon.beacon.service.RegionMonitoringState r7 = (org.altbeacon.beacon.service.RegionMonitoringState) r7     // Catch:{ IOException -> 0x006a }
            r4.put(r6, r7)     // Catch:{ IOException -> 0x006a }
            goto L_0x0048
        L_0x005e:
            r3.writeObject(r4)     // Catch:{ IOException -> 0x006a }
            if (r1 == 0) goto L_0x0066
            r1.close()     // Catch:{ IOException -> 0x0066 }
        L_0x0066:
            r3.close()     // Catch:{ IOException -> 0x0097 }
            goto L_0x0097
        L_0x006a:
            r0 = move-exception
            goto L_0x007e
        L_0x006c:
            r2 = move-exception
            r3 = r0
            r0 = r2
            goto L_0x0099
        L_0x0070:
            r3 = move-exception
            r8 = r3
            r3 = r0
            r0 = r8
            goto L_0x007e
        L_0x0075:
            r1 = move-exception
            r3 = r0
            r0 = r1
            r1 = r3
            goto L_0x0099
        L_0x007a:
            r1 = move-exception
            r3 = r0
            r0 = r1
            r1 = r3
        L_0x007e:
            java.lang.String r4 = TAG     // Catch:{ all -> 0x0098 }
            java.lang.String r5 = "Error while saving monitored region states to file "
            r6 = 1
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x0098 }
            r6[r2] = r0     // Catch:{ all -> 0x0098 }
            org.altbeacon.beacon.logging.LogManager.e(r4, r5, r6)     // Catch:{ all -> 0x0098 }
            java.io.PrintStream r2 = java.lang.System.err     // Catch:{ all -> 0x0098 }
            r0.printStackTrace(r2)     // Catch:{ all -> 0x0098 }
            if (r1 == 0) goto L_0x0094
            r1.close()     // Catch:{ IOException -> 0x0094 }
        L_0x0094:
            if (r3 == 0) goto L_0x0097
            goto L_0x0066
        L_0x0097:
            return
        L_0x0098:
            r0 = move-exception
        L_0x0099:
            if (r1 == 0) goto L_0x009e
            r1.close()     // Catch:{ IOException -> 0x009e }
        L_0x009e:
            if (r3 == 0) goto L_0x00a3
            r3.close()     // Catch:{ IOException -> 0x00a3 }
        L_0x00a3:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.altbeacon.beacon.service.MonitoringStatus.saveMonitoringStatusIfOn():void");
    }

    /* access modifiers changed from: protected */
    public void updateMonitoringStatusTime(long j) {
        this.mContext.getFileStreamPath(STATUS_PRESERVATION_FILE_NAME).setLastModified(j);
    }

    /* access modifiers changed from: protected */
    public long getLastMonitoringStatusUpdateTime() {
        return this.mContext.getFileStreamPath(STATUS_PRESERVATION_FILE_NAME).lastModified();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|4|5|6|(2:9|7)|55|10|(4:13|(2:15|59)(1:58)|56|11)|57|16|(2:18|19)|20|21|62) */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x00a0 */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c5 A[Catch:{ all -> 0x00e8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00cf A[Catch:{ all -> 0x00e8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e1 A[SYNTHETIC, Splitter:B:40:0x00e1] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00eb A[SYNTHETIC, Splitter:B:47:0x00eb] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f0 A[SYNTHETIC, Splitter:B:51:0x00f0] */
    /* JADX WARNING: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void restoreMonitoringStatus() {
        /*
            r9 = this;
            java.lang.String r0 = "Restored region monitoring state for "
            r1 = 0
            r2 = 0
            android.content.Context r3 = r9.mContext     // Catch:{ IOException -> 0x00bf, ClassNotFoundException -> 0x00bd, ClassCastException -> 0x00bb, all -> 0x00b8 }
            java.lang.String r4 = "org.altbeacon.beacon.service.monitoring_status_state"
            java.io.FileInputStream r3 = r3.openFileInput(r4)     // Catch:{ IOException -> 0x00bf, ClassNotFoundException -> 0x00bd, ClassCastException -> 0x00bb, all -> 0x00b8 }
            java.io.ObjectInputStream r4 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x00b4, ClassNotFoundException -> 0x00b2, ClassCastException -> 0x00b0, all -> 0x00ac }
            r4.<init>(r3)     // Catch:{ IOException -> 0x00b4, ClassNotFoundException -> 0x00b2, ClassCastException -> 0x00b0, all -> 0x00ac }
            java.lang.Object r2 = r4.readObject()     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            java.lang.String r5 = TAG     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            r6.<init>(r0)     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            int r0 = r2.size()     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            r6.append(r0)     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            java.lang.String r0 = " regions."
            r6.append(r0)     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            java.lang.String r0 = r6.toString()     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            org.altbeacon.beacon.logging.LogManager.d(r5, r0, r6)     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            java.util.Set r0 = r2.keySet()     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
        L_0x003b:
            boolean r5 = r0.hasNext()     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            if (r5 == 0) goto L_0x0078
            java.lang.Object r5 = r0.next()     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            org.altbeacon.beacon.Region r5 = (org.altbeacon.beacon.Region) r5     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            java.lang.String r6 = TAG     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            r7.<init>()     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            java.lang.String r8 = "Region  "
            r7.append(r8)     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            r7.append(r5)     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            java.lang.String r8 = " uniqueId: "
            r7.append(r8)     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            java.lang.String r8 = r5.getUniqueId()     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            r7.append(r8)     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            java.lang.String r8 = " state: "
            r7.append(r8)     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            java.lang.Object r5 = r2.get(r5)     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            r7.append(r5)     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            java.lang.String r5 = r7.toString()     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            org.altbeacon.beacon.logging.LogManager.d(r6, r5, r7)     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            goto L_0x003b
        L_0x0078:
            java.util.Collection r0 = r2.values()     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
        L_0x0080:
            boolean r5 = r0.hasNext()     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            if (r5 == 0) goto L_0x0096
            java.lang.Object r5 = r0.next()     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            org.altbeacon.beacon.service.RegionMonitoringState r5 = (org.altbeacon.beacon.service.RegionMonitoringState) r5     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            boolean r6 = r5.getInside()     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            if (r6 == 0) goto L_0x0080
            r5.markInside()     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            goto L_0x0080
        L_0x0096:
            java.util.Map<org.altbeacon.beacon.Region, org.altbeacon.beacon.service.RegionMonitoringState> r0 = r9.mRegionsStatesMap     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            r0.putAll(r2)     // Catch:{ IOException -> 0x00aa, ClassNotFoundException -> 0x00a8, ClassCastException -> 0x00a6, all -> 0x00a4 }
            if (r3 == 0) goto L_0x00a0
            r3.close()     // Catch:{ IOException -> 0x00a0 }
        L_0x00a0:
            r4.close()     // Catch:{ IOException -> 0x00e7 }
            goto L_0x00e7
        L_0x00a4:
            r0 = move-exception
            goto L_0x00ae
        L_0x00a6:
            r0 = move-exception
            goto L_0x00b6
        L_0x00a8:
            r0 = move-exception
            goto L_0x00b6
        L_0x00aa:
            r0 = move-exception
            goto L_0x00b6
        L_0x00ac:
            r0 = move-exception
            r4 = r2
        L_0x00ae:
            r2 = r3
            goto L_0x00e9
        L_0x00b0:
            r0 = move-exception
            goto L_0x00b5
        L_0x00b2:
            r0 = move-exception
            goto L_0x00b5
        L_0x00b4:
            r0 = move-exception
        L_0x00b5:
            r4 = r2
        L_0x00b6:
            r2 = r3
            goto L_0x00c1
        L_0x00b8:
            r0 = move-exception
            r4 = r2
            goto L_0x00e9
        L_0x00bb:
            r0 = move-exception
            goto L_0x00c0
        L_0x00bd:
            r0 = move-exception
            goto L_0x00c0
        L_0x00bf:
            r0 = move-exception
        L_0x00c0:
            r4 = r2
        L_0x00c1:
            boolean r3 = r0 instanceof java.io.InvalidClassException     // Catch:{ all -> 0x00e8 }
            if (r3 == 0) goto L_0x00cf
            java.lang.String r0 = TAG     // Catch:{ all -> 0x00e8 }
            java.lang.String r3 = "Serialized Monitoring State has wrong class. Just ignoring saved state..."
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x00e8 }
            org.altbeacon.beacon.logging.LogManager.d(r0, r3, r1)     // Catch:{ all -> 0x00e8 }
            goto L_0x00df
        L_0x00cf:
            java.lang.String r3 = TAG     // Catch:{ all -> 0x00e8 }
            java.lang.String r5 = "Deserialization exception, message: %s"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00e8 }
            r6 = 1
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x00e8 }
            r6[r1] = r0     // Catch:{ all -> 0x00e8 }
            org.altbeacon.beacon.logging.LogManager.e(r3, r5, r6)     // Catch:{ all -> 0x00e8 }
        L_0x00df:
            if (r2 == 0) goto L_0x00e4
            r2.close()     // Catch:{ IOException -> 0x00e4 }
        L_0x00e4:
            if (r4 == 0) goto L_0x00e7
            goto L_0x00a0
        L_0x00e7:
            return
        L_0x00e8:
            r0 = move-exception
        L_0x00e9:
            if (r2 == 0) goto L_0x00ee
            r2.close()     // Catch:{ IOException -> 0x00ee }
        L_0x00ee:
            if (r4 == 0) goto L_0x00f3
            r4.close()     // Catch:{ IOException -> 0x00f3 }
        L_0x00f3:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.altbeacon.beacon.service.MonitoringStatus.restoreMonitoringStatus():void");
    }

    public synchronized void stopStatusPreservation() {
        this.mContext.deleteFile(STATUS_PRESERVATION_FILE_NAME);
        this.mStatePreservationIsOn = false;
    }

    public synchronized void startStatusPreservation() {
        if (!this.mStatePreservationIsOn) {
            this.mStatePreservationIsOn = true;
            saveMonitoringStatusIfOn();
        }
    }

    public boolean isStatePreservationOn() {
        return this.mStatePreservationIsOn;
    }

    public synchronized void clear() {
        this.mContext.deleteFile(STATUS_PRESERVATION_FILE_NAME);
        getRegionsStateMap().clear();
    }

    public void updateLocalState(Region region, Integer num) {
        RegionMonitoringState regionMonitoringState = getRegionsStateMap().get(region);
        if (regionMonitoringState == null) {
            regionMonitoringState = addLocalRegion(region);
        }
        if (num != null) {
            if (num.intValue() == 0) {
                regionMonitoringState.markOutside();
            }
            if (num.intValue() == 1) {
                regionMonitoringState.markInside();
            }
        }
    }

    public void removeLocalRegion(Region region) {
        getRegionsStateMap().remove(region);
    }

    public RegionMonitoringState addLocalRegion(Region region) {
        return addLocalRegion(region, new Callback((String) null));
    }

    private RegionMonitoringState addLocalRegion(Region region, Callback callback) {
        if (getRegionsStateMap().containsKey(region)) {
            Iterator<Region> it = getRegionsStateMap().keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Region next = it.next();
                if (next.equals(region)) {
                    if (next.hasSameIdentifiers(region)) {
                        return getRegionsStateMap().get(next);
                    }
                    String str = TAG;
                    LogManager.d(str, "Replacing region with unique identifier " + region.getUniqueId(), new Object[0]);
                    LogManager.d(str, "Old definition: " + next, new Object[0]);
                    LogManager.d(str, "New definition: " + region, new Object[0]);
                    LogManager.d(str, "clearing state", new Object[0]);
                    getRegionsStateMap().remove(region);
                }
            }
        }
        RegionMonitoringState regionMonitoringState = new RegionMonitoringState(callback);
        getRegionsStateMap().put(region, regionMonitoringState);
        return regionMonitoringState;
    }
}
