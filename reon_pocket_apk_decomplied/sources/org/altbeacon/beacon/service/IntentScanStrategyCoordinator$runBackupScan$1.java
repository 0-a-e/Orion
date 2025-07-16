package org.altbeacon.beacon.service;

import android.content.Context;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: IntentScanStrategyCoordinator.kt */
final class IntentScanStrategyCoordinator$runBackupScan$1 implements Runnable {
    final /* synthetic */ Context $context;
    final /* synthetic */ IntentScanStrategyCoordinator this$0;

    IntentScanStrategyCoordinator$runBackupScan$1(IntentScanStrategyCoordinator intentScanStrategyCoordinator, Context context) {
        this.this$0 = intentScanStrategyCoordinator;
        this.$context = context;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:9|10|11|12|13|14|(1:39)(3:17|(1:40)(4:19|(1:21)|22|41)|38)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0047 */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0063 A[Catch:{ IllegalStateException -> 0x00af, NullPointerException -> 0x009e }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0052 A[EDGE_INSN: B:39:0x0052->B:16:0x0052 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r10 = this;
            org.altbeacon.beacon.service.IntentScanStrategyCoordinator$Companion r0 = org.altbeacon.beacon.service.IntentScanStrategyCoordinator.Companion
            java.lang.String r0 = r0.getTAG()
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "Starting backup scan"
            org.altbeacon.beacon.logging.LogManager.i(r0, r3, r2)
            android.content.Context r0 = r10.$context
            java.lang.String r2 = "bluetooth"
            java.lang.Object r0 = r0.getSystemService(r2)
            if (r0 == 0) goto L_0x0101
            android.bluetooth.BluetoothManager r0 = (android.bluetooth.BluetoothManager) r0
            android.bluetooth.BluetoothAdapter r0 = r0.getAdapter()
            long r2 = java.lang.System.currentTimeMillis()
            if (r0 == 0) goto L_0x00ca
            android.bluetooth.le.BluetoothLeScanner r0 = r0.getBluetoothLeScanner()
            if (r0 == 0) goto L_0x00bd
            org.altbeacon.beacon.service.IntentScanStrategyCoordinator$runBackupScan$1$callback$1 r4 = new org.altbeacon.beacon.service.IntentScanStrategyCoordinator$runBackupScan$1$callback$1
            r4.<init>(r10, r0)
            android.bluetooth.le.ScanCallback r4 = (android.bluetooth.le.ScanCallback) r4
            r5 = 1
            r0.startScan(r4)     // Catch:{ IllegalStateException -> 0x00af, NullPointerException -> 0x009e }
        L_0x0035:
            org.altbeacon.beacon.service.IntentScanStrategyCoordinator$Companion r6 = org.altbeacon.beacon.service.IntentScanStrategyCoordinator.Companion     // Catch:{ IllegalStateException -> 0x00af, NullPointerException -> 0x009e }
            java.lang.String r6 = r6.getTAG()     // Catch:{ IllegalStateException -> 0x00af, NullPointerException -> 0x009e }
            java.lang.String r7 = "Waiting for beacon detection..."
            java.lang.Object[] r8 = new java.lang.Object[r1]     // Catch:{ IllegalStateException -> 0x00af, NullPointerException -> 0x009e }
            org.altbeacon.beacon.logging.LogManager.d(r6, r7, r8)     // Catch:{ IllegalStateException -> 0x00af, NullPointerException -> 0x009e }
            r6 = 1000(0x3e8, double:4.94E-321)
            java.lang.Thread.sleep(r6)     // Catch:{ InterruptedException -> 0x0047 }
        L_0x0047:
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ IllegalStateException -> 0x00af, NullPointerException -> 0x009e }
            long r6 = r6 - r2
            r8 = 30000(0x7530, double:1.4822E-319)
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x0063
            org.altbeacon.beacon.service.IntentScanStrategyCoordinator$Companion r2 = org.altbeacon.beacon.service.IntentScanStrategyCoordinator.Companion     // Catch:{ IllegalStateException -> 0x00af, NullPointerException -> 0x009e }
            java.lang.String r2 = r2.getTAG()     // Catch:{ IllegalStateException -> 0x00af, NullPointerException -> 0x009e }
            java.lang.String r3 = "Timeout running backup scan to look for beacons"
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ IllegalStateException -> 0x00af, NullPointerException -> 0x009e }
            org.altbeacon.beacon.logging.LogManager.d(r2, r3, r6)     // Catch:{ IllegalStateException -> 0x00af, NullPointerException -> 0x009e }
            r0.stopScan(r4)     // Catch:{ IllegalStateException -> 0x00af, NullPointerException -> 0x009e }
            goto L_0x00ca
        L_0x0063:
            org.altbeacon.beacon.service.IntentScanStrategyCoordinator r6 = r10.this$0     // Catch:{ IllegalStateException -> 0x00af, NullPointerException -> 0x009e }
            org.altbeacon.beacon.service.ScanHelper r6 = org.altbeacon.beacon.service.IntentScanStrategyCoordinator.access$getScanHelper$p(r6)     // Catch:{ IllegalStateException -> 0x00af, NullPointerException -> 0x009e }
            boolean r6 = r6.anyBeaconsDetectedThisCycle()     // Catch:{ IllegalStateException -> 0x00af, NullPointerException -> 0x009e }
            if (r6 == 0) goto L_0x0035
            org.altbeacon.beacon.service.IntentScanStrategyCoordinator r6 = r10.this$0     // Catch:{ IllegalStateException -> 0x00af, NullPointerException -> 0x009e }
            int r6 = r6.getStrategyFailureDetectionCount()     // Catch:{ IllegalStateException -> 0x00af, NullPointerException -> 0x009e }
            org.altbeacon.beacon.service.IntentScanStrategyCoordinator r7 = r10.this$0     // Catch:{ IllegalStateException -> 0x00af, NullPointerException -> 0x009e }
            int r7 = r7.getLastStrategyFailureDetectionCount()     // Catch:{ IllegalStateException -> 0x00af, NullPointerException -> 0x009e }
            if (r6 != r7) goto L_0x008a
            org.altbeacon.beacon.service.IntentScanStrategyCoordinator$Companion r6 = org.altbeacon.beacon.service.IntentScanStrategyCoordinator.Companion     // Catch:{ IllegalStateException -> 0x00af, NullPointerException -> 0x009e }
            java.lang.String r6 = r6.getTAG()     // Catch:{ IllegalStateException -> 0x00af, NullPointerException -> 0x009e }
            java.lang.String r7 = "We have detected a beacon with the backup scan without a filter.  We never detected one with the intent scan with a filter.  This technique will not work."
            java.lang.Object[] r8 = new java.lang.Object[r1]     // Catch:{ IllegalStateException -> 0x00af, NullPointerException -> 0x009e }
            org.altbeacon.beacon.logging.LogManager.e(r6, r7, r8)     // Catch:{ IllegalStateException -> 0x00af, NullPointerException -> 0x009e }
        L_0x008a:
            org.altbeacon.beacon.service.IntentScanStrategyCoordinator r6 = r10.this$0     // Catch:{ IllegalStateException -> 0x00af, NullPointerException -> 0x009e }
            int r7 = r6.getStrategyFailureDetectionCount()     // Catch:{ IllegalStateException -> 0x00af, NullPointerException -> 0x009e }
            r6.setLastStrategyFailureDetectionCount(r7)     // Catch:{ IllegalStateException -> 0x00af, NullPointerException -> 0x009e }
            org.altbeacon.beacon.service.IntentScanStrategyCoordinator r6 = r10.this$0     // Catch:{ IllegalStateException -> 0x00af, NullPointerException -> 0x009e }
            int r7 = r6.getStrategyFailureDetectionCount()     // Catch:{ IllegalStateException -> 0x00af, NullPointerException -> 0x009e }
            int r7 = r7 + r5
            r6.setStrategyFailureDetectionCount(r7)     // Catch:{ IllegalStateException -> 0x00af, NullPointerException -> 0x009e }
            goto L_0x0035
        L_0x009e:
            r0 = move-exception
            org.altbeacon.beacon.service.IntentScanStrategyCoordinator$Companion r2 = org.altbeacon.beacon.service.IntentScanStrategyCoordinator.Companion
            java.lang.String r2 = r2.getTAG()
            java.lang.Object[] r3 = new java.lang.Object[r5]
            r3[r1] = r0
            java.lang.String r0 = "NullPointerException. Cannot run backup scan"
            org.altbeacon.beacon.logging.LogManager.e(r2, r0, r3)
            goto L_0x00ca
        L_0x00af:
            org.altbeacon.beacon.service.IntentScanStrategyCoordinator$Companion r0 = org.altbeacon.beacon.service.IntentScanStrategyCoordinator.Companion
            java.lang.String r0 = r0.getTAG()
            java.lang.String r2 = "Bluetooth is off.  Cannot run backup scan"
            java.lang.Object[] r3 = new java.lang.Object[r1]
            org.altbeacon.beacon.logging.LogManager.d(r0, r2, r3)
            goto L_0x00ca
        L_0x00bd:
            org.altbeacon.beacon.service.IntentScanStrategyCoordinator$Companion r0 = org.altbeacon.beacon.service.IntentScanStrategyCoordinator.Companion
            java.lang.String r0 = r0.getTAG()
            java.lang.String r2 = "Cannot get scanner"
            java.lang.Object[] r3 = new java.lang.Object[r1]
            org.altbeacon.beacon.logging.LogManager.d(r0, r2, r3)
        L_0x00ca:
            org.altbeacon.beacon.service.IntentScanStrategyCoordinator$Companion r0 = org.altbeacon.beacon.service.IntentScanStrategyCoordinator.Companion
            java.lang.String r0 = r0.getTAG()
            java.lang.String r2 = "backup scan complete"
            java.lang.Object[] r1 = new java.lang.Object[r1]
            org.altbeacon.beacon.logging.LogManager.d(r0, r2, r1)
            org.altbeacon.beacon.service.IntentScanStrategyCoordinator r0 = r10.this$0
            boolean r0 = r0.getDisableOnFailure()
            if (r0 == 0) goto L_0x00f0
            org.altbeacon.beacon.service.IntentScanStrategyCoordinator r0 = r10.this$0
            int r0 = r0.getStrategyFailureDetectionCount()
            if (r0 <= 0) goto L_0x00f0
            android.content.Context r0 = r10.$context
            org.altbeacon.beacon.BeaconManager r0 = org.altbeacon.beacon.BeaconManager.getInstanceForApplication(r0)
            r0.handleStategyFailover()
        L_0x00f0:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 < r1) goto L_0x0100
            org.altbeacon.beacon.service.IntentScanStrategyCoordinator r0 = r10.this$0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r0.processScanResults(r1)
        L_0x0100:
            return
        L_0x0101:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type android.bluetooth.BluetoothManager"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.altbeacon.beacon.service.IntentScanStrategyCoordinator$runBackupScan$1.run():void");
    }
}
