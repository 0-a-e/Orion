package org.altbeacon.beacon.service;

import android.content.Context;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.Region;
import org.altbeacon.beacon.logging.LogManager;

public class ScanState implements Serializable {
    public static int MIN_SCAN_JOB_INTERVAL_MILLIS = 300000;
    private static final String STATUS_PRESERVATION_FILE_NAME = "android-beacon-library-scan-state";
    private static final String TAG = "ScanState";
    private static final String TEMP_STATUS_PRESERVATION_FILE_NAME = "android-beacon-library-scan-state-temp";
    private long mBackgroundBetweenScanPeriod;
    private boolean mBackgroundMode;
    private long mBackgroundScanPeriod;
    private Set<BeaconParser> mBeaconParsers = new HashSet();
    private transient Context mContext;
    private ExtraDataBeaconTracker mExtraBeaconDataTracker = new ExtraDataBeaconTracker();
    private long mForegroundBetweenScanPeriod;
    private long mForegroundScanPeriod;
    private long mLastScanStartTimeMillis = 0;
    private transient MonitoringStatus mMonitoringStatus;
    private Map<Region, RangeState> mRangedRegionState = new HashMap();

    public Boolean getBackgroundMode() {
        return Boolean.valueOf(this.mBackgroundMode);
    }

    public void setBackgroundMode(Boolean bool) {
        this.mBackgroundMode = bool.booleanValue();
    }

    public Long getBackgroundBetweenScanPeriod() {
        return Long.valueOf(this.mBackgroundBetweenScanPeriod);
    }

    public void setBackgroundBetweenScanPeriod(Long l) {
        this.mBackgroundBetweenScanPeriod = l.longValue();
    }

    public Long getBackgroundScanPeriod() {
        return Long.valueOf(this.mBackgroundScanPeriod);
    }

    public void setBackgroundScanPeriod(Long l) {
        this.mBackgroundScanPeriod = l.longValue();
    }

    public Long getForegroundBetweenScanPeriod() {
        return Long.valueOf(this.mForegroundBetweenScanPeriod);
    }

    public void setForegroundBetweenScanPeriod(Long l) {
        this.mForegroundBetweenScanPeriod = l.longValue();
    }

    public Long getForegroundScanPeriod() {
        return Long.valueOf(this.mForegroundScanPeriod);
    }

    public void setForegroundScanPeriod(Long l) {
        this.mForegroundScanPeriod = l.longValue();
    }

    public ScanState(Context context) {
        this.mContext = context;
    }

    public MonitoringStatus getMonitoringStatus() {
        return this.mMonitoringStatus;
    }

    public void setMonitoringStatus(MonitoringStatus monitoringStatus) {
        this.mMonitoringStatus = monitoringStatus;
    }

    public Map<Region, RangeState> getRangedRegionState() {
        return this.mRangedRegionState;
    }

    public void setRangedRegionState(Map<Region, RangeState> map) {
        this.mRangedRegionState = map;
    }

    public ExtraDataBeaconTracker getExtraBeaconDataTracker() {
        return this.mExtraBeaconDataTracker;
    }

    public void setExtraBeaconDataTracker(ExtraDataBeaconTracker extraDataBeaconTracker) {
        this.mExtraBeaconDataTracker = extraDataBeaconTracker;
    }

    public Set<BeaconParser> getBeaconParsers() {
        return this.mBeaconParsers;
    }

    public void setBeaconParsers(Set<BeaconParser> set) {
        this.mBeaconParsers = set;
    }

    public long getLastScanStartTimeMillis() {
        return this.mLastScanStartTimeMillis;
    }

    public void setLastScanStartTimeMillis(long j) {
        this.mLastScanStartTimeMillis = j;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:64|(0)|(0)|73|74) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:2|(5:3|4|5|6|(5:7|8|9|10|(2:12|13)))|14|15|(2:56|57)|58|(1:60)|61|62) */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0073, code lost:
        if (r5 != null) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0089, code lost:
        if (r5 != null) goto L_0x001f;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x001f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x00e7 */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0056 A[Catch:{ all -> 0x0076 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0060 A[Catch:{ all -> 0x0076 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0070 A[SYNTHETIC, Splitter:B:39:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0086 A[SYNTHETIC, Splitter:B:50:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00dc A[SYNTHETIC, Splitter:B:66:0x00dc] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00e4 A[SYNTHETIC, Splitter:B:71:0x00e4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.altbeacon.beacon.service.ScanState restore(android.content.Context r11) {
        /*
            java.lang.String r0 = "Scan state restore regions: monitored="
            java.lang.Class<org.altbeacon.beacon.service.ScanState> r1 = org.altbeacon.beacon.service.ScanState.class
            monitor-enter(r1)
            r2 = 0
            r3 = 0
            java.lang.String r4 = "android-beacon-library-scan-state"
            java.io.FileInputStream r4 = r11.openFileInput(r4)     // Catch:{ FileNotFoundException -> 0x0079, IOException -> 0x004d, ClassNotFoundException -> 0x004b, ClassCastException -> 0x0049, all -> 0x0045 }
            java.io.ObjectInputStream r5 = new java.io.ObjectInputStream     // Catch:{ FileNotFoundException -> 0x0041, IOException -> 0x003c, ClassNotFoundException -> 0x003a, ClassCastException -> 0x0038, all -> 0x0035 }
            r5.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0041, IOException -> 0x003c, ClassNotFoundException -> 0x003a, ClassCastException -> 0x0038, all -> 0x0035 }
            java.lang.Object r6 = r5.readObject()     // Catch:{ FileNotFoundException -> 0x0033, IOException -> 0x002e, ClassNotFoundException -> 0x002c, ClassCastException -> 0x002a }
            org.altbeacon.beacon.service.ScanState r6 = (org.altbeacon.beacon.service.ScanState) r6     // Catch:{ FileNotFoundException -> 0x0033, IOException -> 0x002e, ClassNotFoundException -> 0x002c, ClassCastException -> 0x002a }
            r6.mContext = r11     // Catch:{ FileNotFoundException -> 0x0043, IOException -> 0x0028, ClassNotFoundException -> 0x0026, ClassCastException -> 0x0024 }
            if (r4 == 0) goto L_0x001f
            r4.close()     // Catch:{ IOException -> 0x001f }
        L_0x001f:
            r5.close()     // Catch:{ IOException -> 0x008c }
            goto L_0x008c
        L_0x0024:
            r3 = move-exception
            goto L_0x0052
        L_0x0026:
            r3 = move-exception
            goto L_0x0052
        L_0x0028:
            r3 = move-exception
            goto L_0x0052
        L_0x002a:
            r6 = move-exception
            goto L_0x002f
        L_0x002c:
            r6 = move-exception
            goto L_0x002f
        L_0x002e:
            r6 = move-exception
        L_0x002f:
            r10 = r6
            r6 = r3
            r3 = r10
            goto L_0x0052
        L_0x0033:
            r6 = r3
            goto L_0x0043
        L_0x0035:
            r11 = move-exception
            r5 = r3
            goto L_0x0077
        L_0x0038:
            r5 = move-exception
            goto L_0x003d
        L_0x003a:
            r5 = move-exception
            goto L_0x003d
        L_0x003c:
            r5 = move-exception
        L_0x003d:
            r6 = r3
            r3 = r5
            r5 = r6
            goto L_0x0052
        L_0x0041:
            r5 = r3
            r6 = r5
        L_0x0043:
            r3 = r4
            goto L_0x007b
        L_0x0045:
            r11 = move-exception
            r5 = r3
            goto L_0x00da
        L_0x0049:
            r4 = move-exception
            goto L_0x004e
        L_0x004b:
            r4 = move-exception
            goto L_0x004e
        L_0x004d:
            r4 = move-exception
        L_0x004e:
            r5 = r3
            r6 = r5
            r3 = r4
            r4 = r6
        L_0x0052:
            boolean r7 = r3 instanceof java.io.InvalidClassException     // Catch:{ all -> 0x0076 }
            if (r7 == 0) goto L_0x0060
            java.lang.String r3 = TAG     // Catch:{ all -> 0x0076 }
            java.lang.String r7 = "Serialized ScanState has wrong class. Just ignoring saved state..."
            java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch:{ all -> 0x0076 }
            org.altbeacon.beacon.logging.LogManager.d(r3, r7, r8)     // Catch:{ all -> 0x0076 }
            goto L_0x006e
        L_0x0060:
            java.lang.String r7 = TAG     // Catch:{ all -> 0x0076 }
            java.lang.String r8 = "Deserialization exception"
            java.lang.Object[] r9 = new java.lang.Object[r2]     // Catch:{ all -> 0x0076 }
            org.altbeacon.beacon.logging.LogManager.e(r7, r8, r9)     // Catch:{ all -> 0x0076 }
            java.lang.String r8 = "error: "
            android.util.Log.e(r7, r8, r3)     // Catch:{ all -> 0x0076 }
        L_0x006e:
            if (r4 == 0) goto L_0x0073
            r4.close()     // Catch:{ IOException -> 0x0073 }
        L_0x0073:
            if (r5 == 0) goto L_0x008c
            goto L_0x001f
        L_0x0076:
            r11 = move-exception
        L_0x0077:
            r3 = r4
            goto L_0x00da
        L_0x0079:
            r5 = r3
            r6 = r5
        L_0x007b:
            java.lang.String r4 = TAG     // Catch:{ all -> 0x00d9 }
            java.lang.String r7 = "Serialized ScanState does not exist.  This may be normal on first run."
            java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch:{ all -> 0x00d9 }
            org.altbeacon.beacon.logging.LogManager.w(r4, r7, r8)     // Catch:{ all -> 0x00d9 }
            if (r3 == 0) goto L_0x0089
            r3.close()     // Catch:{ IOException -> 0x0089 }
        L_0x0089:
            if (r5 == 0) goto L_0x008c
            goto L_0x001f
        L_0x008c:
            if (r6 != 0) goto L_0x0093
            org.altbeacon.beacon.service.ScanState r6 = new org.altbeacon.beacon.service.ScanState     // Catch:{ all -> 0x00e0 }
            r6.<init>(r11)     // Catch:{ all -> 0x00e0 }
        L_0x0093:
            org.altbeacon.beacon.service.ExtraDataBeaconTracker r3 = r6.mExtraBeaconDataTracker     // Catch:{ all -> 0x00e0 }
            if (r3 != 0) goto L_0x009e
            org.altbeacon.beacon.service.ExtraDataBeaconTracker r3 = new org.altbeacon.beacon.service.ExtraDataBeaconTracker     // Catch:{ all -> 0x00e0 }
            r3.<init>()     // Catch:{ all -> 0x00e0 }
            r6.mExtraBeaconDataTracker = r3     // Catch:{ all -> 0x00e0 }
        L_0x009e:
            org.altbeacon.beacon.service.MonitoringStatus r11 = org.altbeacon.beacon.service.MonitoringStatus.getInstanceForApplication(r11)     // Catch:{ all -> 0x00e0 }
            r6.mMonitoringStatus = r11     // Catch:{ all -> 0x00e0 }
            java.lang.String r11 = TAG     // Catch:{ all -> 0x00e0 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e0 }
            r3.<init>(r0)     // Catch:{ all -> 0x00e0 }
            org.altbeacon.beacon.service.MonitoringStatus r0 = r6.getMonitoringStatus()     // Catch:{ all -> 0x00e0 }
            java.util.Set r0 = r0.regions()     // Catch:{ all -> 0x00e0 }
            int r0 = r0.size()     // Catch:{ all -> 0x00e0 }
            r3.append(r0)     // Catch:{ all -> 0x00e0 }
            java.lang.String r0 = " ranged="
            r3.append(r0)     // Catch:{ all -> 0x00e0 }
            java.util.Map r0 = r6.getRangedRegionState()     // Catch:{ all -> 0x00e0 }
            java.util.Set r0 = r0.keySet()     // Catch:{ all -> 0x00e0 }
            int r0 = r0.size()     // Catch:{ all -> 0x00e0 }
            r3.append(r0)     // Catch:{ all -> 0x00e0 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00e0 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x00e0 }
            org.altbeacon.beacon.logging.LogManager.d(r11, r0, r2)     // Catch:{ all -> 0x00e0 }
            monitor-exit(r1)     // Catch:{ all -> 0x00e0 }
            return r6
        L_0x00d9:
            r11 = move-exception
        L_0x00da:
            if (r3 == 0) goto L_0x00e2
            r3.close()     // Catch:{ IOException -> 0x00e2 }
            goto L_0x00e2
        L_0x00e0:
            r11 = move-exception
            goto L_0x00e8
        L_0x00e2:
            if (r5 == 0) goto L_0x00e7
            r5.close()     // Catch:{ IOException -> 0x00e7 }
        L_0x00e7:
            throw r11     // Catch:{ all -> 0x00e0 }
        L_0x00e8:
            monitor-exit(r1)     // Catch:{ all -> 0x00e0 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.altbeacon.beacon.service.ScanState.restore(android.content.Context):org.altbeacon.beacon.service.ScanState");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:2|(3:3|4|(5:5|6|7|8|(2:10|11)))|12|13|30|31|(1:33)|34|(1:36)|37|38) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:40|41|(2:43|44)|(2:48|49)|50|51) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004a, code lost:
        if (r6 == null) goto L_0x004d;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x001e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x004d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:50:0x00c3 */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0047 A[SYNTHETIC, Splitter:B:26:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b8 A[SYNTHETIC, Splitter:B:43:0x00b8] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c0 A[SYNTHETIC, Splitter:B:48:0x00c0] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:50:0x00c3=Splitter:B:50:0x00c3, B:30:0x004d=Splitter:B:30:0x004d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void save() {
        /*
            r11 = this;
            java.lang.String r0 = "Perm file is "
            java.lang.String r1 = "Temp file is "
            java.lang.Class<org.altbeacon.beacon.service.ScanState> r2 = org.altbeacon.beacon.service.ScanState.class
            monitor-enter(r2)
            r3 = 0
            r4 = 0
            android.content.Context r5 = r11.mContext     // Catch:{ IOException -> 0x0031, all -> 0x002d }
            java.lang.String r6 = "android-beacon-library-scan-state-temp"
            java.io.FileOutputStream r5 = r5.openFileOutput(r6, r3)     // Catch:{ IOException -> 0x0031, all -> 0x002d }
            java.io.ObjectOutputStream r6 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0028, all -> 0x0024 }
            r6.<init>(r5)     // Catch:{ IOException -> 0x0028, all -> 0x0024 }
            r6.writeObject(r11)     // Catch:{ IOException -> 0x0022 }
            if (r5 == 0) goto L_0x001e
            r5.close()     // Catch:{ IOException -> 0x001e }
        L_0x001e:
            r6.close()     // Catch:{ IOException -> 0x004d }
            goto L_0x004d
        L_0x0022:
            r4 = move-exception
            goto L_0x0035
        L_0x0024:
            r0 = move-exception
            r6 = r4
            goto L_0x00b5
        L_0x0028:
            r6 = move-exception
            r10 = r6
            r6 = r4
            r4 = r10
            goto L_0x0035
        L_0x002d:
            r0 = move-exception
            r6 = r4
            goto L_0x00b6
        L_0x0031:
            r5 = move-exception
            r6 = r4
            r4 = r5
            r5 = r6
        L_0x0035:
            java.lang.String r7 = TAG     // Catch:{ all -> 0x00b4 }
            java.lang.String r8 = "Error while saving scan status to file: "
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x00b4 }
            r9 = 1
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ all -> 0x00b4 }
            r9[r3] = r4     // Catch:{ all -> 0x00b4 }
            org.altbeacon.beacon.logging.LogManager.e(r7, r8, r9)     // Catch:{ all -> 0x00b4 }
            if (r5 == 0) goto L_0x004a
            r5.close()     // Catch:{ IOException -> 0x004a }
        L_0x004a:
            if (r6 == 0) goto L_0x004d
            goto L_0x001e
        L_0x004d:
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x00bc }
            android.content.Context r5 = r11.mContext     // Catch:{ all -> 0x00bc }
            java.io.File r5 = r5.getFilesDir()     // Catch:{ all -> 0x00bc }
            java.lang.String r6 = "android-beacon-library-scan-state"
            r4.<init>(r5, r6)     // Catch:{ all -> 0x00bc }
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x00bc }
            android.content.Context r6 = r11.mContext     // Catch:{ all -> 0x00bc }
            java.io.File r6 = r6.getFilesDir()     // Catch:{ all -> 0x00bc }
            java.lang.String r7 = "android-beacon-library-scan-state-temp"
            r5.<init>(r6, r7)     // Catch:{ all -> 0x00bc }
            java.lang.String r6 = TAG     // Catch:{ all -> 0x00bc }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bc }
            r7.<init>(r1)     // Catch:{ all -> 0x00bc }
            java.lang.String r1 = r5.getAbsolutePath()     // Catch:{ all -> 0x00bc }
            r7.append(r1)     // Catch:{ all -> 0x00bc }
            java.lang.String r1 = r7.toString()     // Catch:{ all -> 0x00bc }
            java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch:{ all -> 0x00bc }
            org.altbeacon.beacon.logging.LogManager.d(r6, r1, r7)     // Catch:{ all -> 0x00bc }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bc }
            r1.<init>(r0)     // Catch:{ all -> 0x00bc }
            java.lang.String r0 = r4.getAbsolutePath()     // Catch:{ all -> 0x00bc }
            r1.append(r0)     // Catch:{ all -> 0x00bc }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x00bc }
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ all -> 0x00bc }
            org.altbeacon.beacon.logging.LogManager.d(r6, r0, r1)     // Catch:{ all -> 0x00bc }
            boolean r0 = r4.delete()     // Catch:{ all -> 0x00bc }
            if (r0 != 0) goto L_0x00a0
            java.lang.String r0 = "Error while saving scan status to file: Cannot delete existing file."
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ all -> 0x00bc }
            org.altbeacon.beacon.logging.LogManager.e(r6, r0, r1)     // Catch:{ all -> 0x00bc }
        L_0x00a0:
            boolean r0 = r5.renameTo(r4)     // Catch:{ all -> 0x00bc }
            if (r0 != 0) goto L_0x00ad
            java.lang.String r0 = "Error while saving scan status to file: Cannot rename temp file."
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ all -> 0x00bc }
            org.altbeacon.beacon.logging.LogManager.e(r6, r0, r1)     // Catch:{ all -> 0x00bc }
        L_0x00ad:
            org.altbeacon.beacon.service.MonitoringStatus r0 = r11.mMonitoringStatus     // Catch:{ all -> 0x00bc }
            r0.saveMonitoringStatusIfOn()     // Catch:{ all -> 0x00bc }
            monitor-exit(r2)     // Catch:{ all -> 0x00bc }
            return
        L_0x00b4:
            r0 = move-exception
        L_0x00b5:
            r4 = r5
        L_0x00b6:
            if (r4 == 0) goto L_0x00be
            r4.close()     // Catch:{ IOException -> 0x00be }
            goto L_0x00be
        L_0x00bc:
            r0 = move-exception
            goto L_0x00c4
        L_0x00be:
            if (r6 == 0) goto L_0x00c3
            r6.close()     // Catch:{ IOException -> 0x00c3 }
        L_0x00c3:
            throw r0     // Catch:{ all -> 0x00bc }
        L_0x00c4:
            monitor-exit(r2)     // Catch:{ all -> 0x00bc }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.altbeacon.beacon.service.ScanState.save():void");
    }

    public int getScanJobIntervalMillis() {
        long j;
        long j2;
        if (getBackgroundMode().booleanValue()) {
            j2 = getBackgroundScanPeriod().longValue();
            j = getBackgroundBetweenScanPeriod().longValue();
        } else {
            j2 = getForegroundScanPeriod().longValue();
            j = getForegroundBetweenScanPeriod().longValue();
        }
        long j3 = j2 + j;
        int i = MIN_SCAN_JOB_INTERVAL_MILLIS;
        return j3 > ((long) i) ? (int) j3 : i;
    }

    public int getScanJobRuntimeMillis() {
        long j;
        String str = TAG;
        LogManager.d(str, "ScanState says background mode for ScanJob is " + getBackgroundMode(), new Object[0]);
        if (getBackgroundMode().booleanValue()) {
            j = getBackgroundScanPeriod().longValue();
        } else {
            j = getForegroundScanPeriod().longValue();
        }
        if (!getBackgroundMode().booleanValue()) {
            int i = MIN_SCAN_JOB_INTERVAL_MILLIS;
            if (j < ((long) i)) {
                return i;
            }
        }
        return (int) j;
    }

    public void applyChanges(BeaconManager beaconManager) {
        this.mBeaconParsers = new HashSet(beaconManager.getBeaconParsers());
        this.mForegroundScanPeriod = beaconManager.getForegroundScanPeriod();
        this.mForegroundBetweenScanPeriod = beaconManager.getForegroundBetweenScanPeriod();
        this.mBackgroundScanPeriod = beaconManager.getBackgroundScanPeriod();
        this.mBackgroundBetweenScanPeriod = beaconManager.getBackgroundBetweenScanPeriod();
        this.mBackgroundMode = beaconManager.getBackgroundMode();
        ArrayList arrayList = new ArrayList(this.mMonitoringStatus.regions());
        ArrayList arrayList2 = new ArrayList(this.mRangedRegionState.keySet());
        ArrayList arrayList3 = new ArrayList(beaconManager.getMonitoredRegions());
        ArrayList arrayList4 = new ArrayList(beaconManager.getRangedRegions());
        String str = TAG;
        LogManager.d(str, "ranged regions: old=" + arrayList2.size() + " new=" + arrayList4.size(), new Object[0]);
        LogManager.d(str, "monitored regions: old=" + arrayList.size() + " new=" + arrayList3.size(), new Object[0]);
        Iterator it = arrayList4.iterator();
        while (it.hasNext()) {
            Region region = (Region) it.next();
            if (!arrayList2.contains(region)) {
                String str2 = TAG;
                LogManager.d(str2, "Starting ranging region: " + region, new Object[0]);
                this.mRangedRegionState.put(region, new RangeState(new Callback(this.mContext.getPackageName())));
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            Region region2 = (Region) it2.next();
            if (!arrayList4.contains(region2)) {
                String str3 = TAG;
                LogManager.d(str3, "Stopping ranging region: " + region2, new Object[0]);
                this.mRangedRegionState.remove(region2);
            }
        }
        String str4 = TAG;
        LogManager.d(str4, "Updated state with " + arrayList4.size() + " ranging regions and " + arrayList3.size() + " monitoring regions.", new Object[0]);
        save();
    }
}
