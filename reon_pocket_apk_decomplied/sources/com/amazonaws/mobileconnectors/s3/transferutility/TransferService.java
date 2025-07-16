package com.amazonaws.mobileconnectors.s3.transferutility;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Map;

public class TransferService extends Service {
    private static final int ANDROID_OREO = 26;
    public static final String INTENT_KEY_NOTIFICATION = "notification";
    public static final String INTENT_KEY_NOTIFICATION_ID = "ongoing-notification-id";
    public static final String INTENT_KEY_REMOVE_NOTIFICATION = "remove-notification";
    private static final Log LOGGER = LogFactory.getLog((Class<?>) TransferService.class);
    static TransferNetworkLossHandler transferNetworkLossHandler;
    boolean isReceiverNotRegistered = true;
    private int ongoingNotificationId = 3462;
    private boolean removeNotification = true;

    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Can't bind to TransferService");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x002e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate() {
        /*
            r3 = this;
            super.onCreate()
            com.amazonaws.logging.Log r0 = LOGGER
            java.lang.String r1 = "Starting Transfer Service to listen for network connectivity changes."
            r0.info(r1)
            android.content.Context r1 = r3.getApplicationContext()
            com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkLossHandler r1 = com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkLossHandler.getInstance(r1)
            transferNetworkLossHandler = r1
            monitor-enter(r3)
            boolean r1 = r3.isReceiverNotRegistered     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x003d
            java.lang.String r1 = "Registering the network receiver"
            r0.info(r1)     // Catch:{ IllegalArgumentException -> 0x0036, IllegalStateException -> 0x002e }
            com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkLossHandler r0 = transferNetworkLossHandler     // Catch:{ IllegalArgumentException -> 0x0036, IllegalStateException -> 0x002e }
            android.content.IntentFilter r1 = new android.content.IntentFilter     // Catch:{ IllegalArgumentException -> 0x0036, IllegalStateException -> 0x002e }
            java.lang.String r2 = "android.net.conn.CONNECTIVITY_CHANGE"
            r1.<init>(r2)     // Catch:{ IllegalArgumentException -> 0x0036, IllegalStateException -> 0x002e }
            r3.registerReceiver(r0, r1)     // Catch:{ IllegalArgumentException -> 0x0036, IllegalStateException -> 0x002e }
            r0 = 0
            r3.isReceiverNotRegistered = r0     // Catch:{ IllegalArgumentException -> 0x0036, IllegalStateException -> 0x002e }
            goto L_0x003d
        L_0x002e:
            com.amazonaws.logging.Log r0 = LOGGER     // Catch:{ all -> 0x003f }
            java.lang.String r1 = "Ignoring the leak in registering the receiver."
            r0.warn(r1)     // Catch:{ all -> 0x003f }
            goto L_0x003d
        L_0x0036:
            com.amazonaws.logging.Log r0 = LOGGER     // Catch:{ all -> 0x003f }
            java.lang.String r1 = "Ignoring the exception trying to register the receiver for connectivity change."
            r0.warn(r1)     // Catch:{ all -> 0x003f }
        L_0x003d:
            monitor-exit(r3)     // Catch:{ all -> 0x003f }
            return
        L_0x003f:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x003f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.s3.transferutility.TransferService.onCreate():void");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public int onStartCommand(android.content.Intent r3, int r4, int r5) {
        /*
            r2 = this;
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 26
            r0 = 1
            if (r4 < r5) goto L_0x005f
            monitor-enter(r2)     // Catch:{ Exception -> 0x004b }
            java.lang.String r4 = "notification"
            android.os.Parcelable r4 = r3.getParcelableExtra(r4)     // Catch:{ all -> 0x0048 }
            android.app.Notification r4 = (android.app.Notification) r4     // Catch:{ all -> 0x0048 }
            if (r4 == 0) goto L_0x003f
            java.lang.String r5 = "ongoing-notification-id"
            int r1 = r2.ongoingNotificationId     // Catch:{ all -> 0x0048 }
            int r5 = r3.getIntExtra(r5, r1)     // Catch:{ all -> 0x0048 }
            r2.ongoingNotificationId = r5     // Catch:{ all -> 0x0048 }
            java.lang.String r5 = "remove-notification"
            boolean r1 = r2.removeNotification     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.getBooleanExtra(r5, r1)     // Catch:{ all -> 0x0048 }
            r2.removeNotification = r3     // Catch:{ all -> 0x0048 }
            com.amazonaws.logging.Log r3 = LOGGER     // Catch:{ all -> 0x0048 }
            java.lang.String r5 = "Putting the service in Foreground state."
            r3.info(r5)     // Catch:{ all -> 0x0048 }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0048 }
            r5 = 34
            if (r3 < r5) goto L_0x0039
            int r3 = r2.ongoingNotificationId     // Catch:{ all -> 0x0048 }
            r2.startForeground(r3, r4, r0)     // Catch:{ all -> 0x0048 }
            goto L_0x0046
        L_0x0039:
            int r3 = r2.ongoingNotificationId     // Catch:{ all -> 0x0048 }
            r2.startForeground(r3, r4)     // Catch:{ all -> 0x0048 }
            goto L_0x0046
        L_0x003f:
            com.amazonaws.logging.Log r3 = LOGGER     // Catch:{ all -> 0x0048 }
            java.lang.String r4 = "No notification is passed in the intent. Unable to transition to foreground."
            r3.error(r4)     // Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r2)     // Catch:{ all -> 0x0048 }
            goto L_0x005f
        L_0x0048:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0048 }
            throw r3     // Catch:{ Exception -> 0x004b }
        L_0x004b:
            r3 = move-exception
            com.amazonaws.logging.Log r4 = LOGGER
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r1 = "Error in moving the service to foreground state: "
            r5.<init>(r1)
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r4.error(r3)
        L_0x005f:
            monitor-enter(r2)
            boolean r3 = r2.isReceiverNotRegistered     // Catch:{ all -> 0x008c }
            if (r3 == 0) goto L_0x008a
            com.amazonaws.logging.Log r3 = LOGGER     // Catch:{ IllegalArgumentException -> 0x0083, IllegalStateException -> 0x007b }
            java.lang.String r4 = "Registering the network receiver"
            r3.info(r4)     // Catch:{ IllegalArgumentException -> 0x0083, IllegalStateException -> 0x007b }
            com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkLossHandler r3 = transferNetworkLossHandler     // Catch:{ IllegalArgumentException -> 0x0083, IllegalStateException -> 0x007b }
            android.content.IntentFilter r4 = new android.content.IntentFilter     // Catch:{ IllegalArgumentException -> 0x0083, IllegalStateException -> 0x007b }
            java.lang.String r5 = "android.net.conn.CONNECTIVITY_CHANGE"
            r4.<init>(r5)     // Catch:{ IllegalArgumentException -> 0x0083, IllegalStateException -> 0x007b }
            r2.registerReceiver(r3, r4)     // Catch:{ IllegalArgumentException -> 0x0083, IllegalStateException -> 0x007b }
            r3 = 0
            r2.isReceiverNotRegistered = r3     // Catch:{ IllegalArgumentException -> 0x0083, IllegalStateException -> 0x007b }
            goto L_0x008a
        L_0x007b:
            com.amazonaws.logging.Log r3 = LOGGER     // Catch:{ all -> 0x008c }
            java.lang.String r4 = "Ignoring the leak in registering the receiver."
            r3.warn(r4)     // Catch:{ all -> 0x008c }
            goto L_0x008a
        L_0x0083:
            com.amazonaws.logging.Log r3 = LOGGER     // Catch:{ all -> 0x008c }
            java.lang.String r4 = "Ignoring the exception trying to register the receiver for connectivity change."
            r3.warn(r4)     // Catch:{ all -> 0x008c }
        L_0x008a:
            monitor-exit(r2)     // Catch:{ all -> 0x008c }
            return r0
        L_0x008c:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x008c }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.s3.transferutility.TransferService.onStartCommand(android.content.Intent, int, int):int");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public void onDestroy() {
        /*
            r4 = this;
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0018 }
            r1 = 26
            if (r0 < r1) goto L_0x002c
            com.amazonaws.logging.Log r0 = LOGGER     // Catch:{ Exception -> 0x0018 }
            java.lang.String r1 = "Moving the service out of the Foreground state."
            r0.info(r1)     // Catch:{ Exception -> 0x0018 }
            monitor-enter(r4)     // Catch:{ Exception -> 0x0018 }
            boolean r0 = r4.removeNotification     // Catch:{ all -> 0x0015 }
            r4.stopForeground(r0)     // Catch:{ all -> 0x0015 }
            monitor-exit(r4)     // Catch:{ all -> 0x0015 }
            goto L_0x002c
        L_0x0015:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0015 }
            throw r0     // Catch:{ Exception -> 0x0018 }
        L_0x0018:
            r0 = move-exception
            com.amazonaws.logging.Log r1 = LOGGER
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Error in moving the service out of the foreground state: "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.error(r0)
        L_0x002c:
            com.amazonaws.logging.Log r0 = LOGGER     // Catch:{ IllegalArgumentException -> 0x0048 }
            java.lang.String r1 = "De-registering the network receiver."
            r0.info(r1)     // Catch:{ IllegalArgumentException -> 0x0048 }
            monitor-enter(r4)     // Catch:{ IllegalArgumentException -> 0x0048 }
            boolean r0 = r4.isReceiverNotRegistered     // Catch:{ all -> 0x0045 }
            if (r0 != 0) goto L_0x0043
            com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkLossHandler r0 = transferNetworkLossHandler     // Catch:{ all -> 0x0045 }
            r4.unregisterReceiver(r0)     // Catch:{ all -> 0x0045 }
            r0 = 1
            r4.isReceiverNotRegistered = r0     // Catch:{ all -> 0x0045 }
            r0 = 0
            transferNetworkLossHandler = r0     // Catch:{ all -> 0x0045 }
        L_0x0043:
            monitor-exit(r4)     // Catch:{ all -> 0x0045 }
            goto L_0x004f
        L_0x0045:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0045 }
            throw r0     // Catch:{ IllegalArgumentException -> 0x0048 }
        L_0x0048:
            com.amazonaws.logging.Log r0 = LOGGER
            java.lang.String r1 = "Exception trying to de-register the network receiver"
            r0.warn(r1)
        L_0x004f:
            super.onDestroy()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.s3.transferutility.TransferService.onDestroy():void");
    }

    /* access modifiers changed from: protected */
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if ((getApplicationInfo().flags & 2) != 0) {
            printWriter.printf("network status: %s\n", new Object[]{Boolean.valueOf(transferNetworkLossHandler.isNetworkConnected())});
            Map<Integer, TransferRecord> transfers = TransferStatusUpdater.getInstance(this).getTransfers();
            printWriter.printf("# of active transfers: %d\n", new Object[]{Integer.valueOf(transfers.size())});
            for (TransferRecord next : transfers.values()) {
                printWriter.printf("bucket: %s, key: %s, status: %s, total size: %d, current: %d\n", new Object[]{next.bucketName, next.key, next.state, Long.valueOf(next.bytesTotal), Long.valueOf(next.bytesCurrent)});
            }
            printWriter.flush();
        }
    }
}
