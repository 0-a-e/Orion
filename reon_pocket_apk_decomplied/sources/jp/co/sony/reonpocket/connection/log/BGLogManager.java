package jp.co.sony.reonpocket.connection.log;

import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.math.BigInteger;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import jp.co.sony.reonpocket.ReonPocketApplication;
import jp.co.sony.reonpocket.connection.log.entity.LogEntity;
import jp.co.sony.reonpocket.connection.log.job.ReadLogJobTask;
import jp.co.sony.reonpocket.constant.GattProfileConstant;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import jp.co.sony.reonpocket.data.entity.Capability1$$ExternalSyntheticBackport0;
import jp.co.sony.reonpocket.data.interactor.BleInteractor;
import jp.co.sony.reonpocket.data.interactor.BleInteractorInput;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.util.MyContentUtil;
import jp.co.sony.reonpocket.util.UuidHelperUtil;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 )2\u00020\u0001:\u0002)*B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00020\u000e\"\u00020\u000fH\u0002J \u0010\u0010\u001a\u00020\u00112\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0002J\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0013\u001a\u00020\fH\u0002J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0011H\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010\u001e\u001a\u00020\u0011J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!H\u0002J\u000e\u0010\"\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!J\b\u0010#\u001a\u00020\u0011H\u0002J\u0006\u0010$\u001a\u00020\u0011J\u0006\u0010%\u001a\u00020\u0011J\b\u0010&\u001a\u00020\fH\u0002J\u0006\u0010'\u001a\u00020\u0011J\b\u0010(\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/BGLogManager;", "", "()V", "aLogUpload", "Ljp/co/sony/reonpocket/connection/log/LogUpload;", "mBleInteractor", "Ljp/co/sony/reonpocket/data/interactor/BleInteractorInput;", "mLogContentList", "Ljava/util/ArrayList;", "Ljp/co/sony/reonpocket/connection/log/BGLogManager$LogContent;", "Lkotlin/collections/ArrayList;", "byteArrayOfInts", "", "ints", "", "", "createCSVFile", "", "createCallbackListener", "createDeviceLogEntity", "createLogEntity", "Ljp/co/sony/reonpocket/connection/log/entity/LogEntity;", "content", "Ljp/co/sony/reonpocket/connection/log/job/ReadLogJobTask$LogContent;", "deviceLogStop", "deviceLogWrite", "getLogFilePath", "", "getUnixTime", "", "initContentList", "logAddList", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "onDataReceived", "openDeviceLogNotification", "registerActionCallbackListener", "requestLog", "stopDeviceLogEntity", "stopRequestLog", "uploadLog", "Companion", "LogContent", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BGLogManager.kt */
public final class BGLogManager {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static String mOwnerId;
    private final LogUpload aLogUpload = new LogUpload();
    private BleInteractorInput mBleInteractor = new BleInteractor();
    private ArrayList<LogContent> mLogContentList = new ArrayList<>();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/BGLogManager$Companion;", "", "()V", "mOwnerId", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BGLogManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/BGLogManager$LogContent;", "", "()V", "mInfo", "", "getMInfo", "()[B", "setMInfo", "([B)V", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BGLogManager.kt */
    public static final class LogContent {
        public static final int $stable = 8;
        private byte[] mInfo;

        public final byte[] getMInfo() {
            return this.mInfo;
        }

        public final void setMInfo(byte[] bArr) {
            this.mInfo = bArr;
        }
    }

    public final void createCallbackListener() {
        if (MyContentUtil.isSupportLog$default(MyContentUtil.INSTANCE, ReonPocketApplication.Companion.getApplicationContext(), (String) null, 2, (Object) null)) {
            this.mBleInteractor.onCreate(ReonPocketApplication.Companion.getApplicationContext());
            registerActionCallbackListener();
        }
    }

    public final void registerActionCallbackListener() {
        this.mBleInteractor.setDataReceivedCallbackListener(new BGLogManager$registerActionCallbackListener$1(this));
    }

    private final void openDeviceLogNotification() {
        BleInteractorInput.DefaultImpls.toggleNotification$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_LOG_NOTIFY_DATA, (String) null, true, 2, (Object) null);
    }

    private final void deviceLogWrite() {
        BleInteractorInput.DefaultImpls.write$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_REQUEST_LOG, (String) null, createDeviceLogEntity(), 2, (Object) null);
    }

    private final void deviceLogStop() {
        initContentList();
        byte[] stopDeviceLogEntity = stopDeviceLogEntity();
        if (MyContentUtil.isSupportLog$default(MyContentUtil.INSTANCE, ReonPocketApplication.Companion.getApplicationContext(), (String) null, 2, (Object) null)) {
            BleInteractorInput.DefaultImpls.write$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_REQUEST_LOG, (String) null, stopDeviceLogEntity, 2, (Object) null);
        }
    }

    public final void onDataReceived(BleDataEntity bleDataEntity) {
        Integer intValue$default;
        Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
        String characteristicUuid = bleDataEntity.getCharacteristicUuid();
        switch (characteristicUuid.hashCode()) {
            case 1512477:
                if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_TEMPERATURE_HUMIDUTY)) {
                    Log.d("request log:", bleDataEntity.getCharacteristicUuid());
                    return;
                }
                return;
            case 1513778:
                if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_REQUEST_LOG)) {
                    Log.d("request log:", bleDataEntity.getCharacteristicUuid());
                    return;
                }
                return;
            case 1513779:
                if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_LOG_NOTIFY_DATA)) {
                    logAddList(bleDataEntity);
                    Log.d("notify log:", bleDataEntity.getCharacteristicUuid());
                    if (this.mLogContentList.size() != 0 && (intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 0, (ByteOrder) null, 4, (Object) null)) != null && intValue$default.intValue() == 255) {
                        createCSVFile(this.mLogContentList);
                        Log.d("finish log:", String.valueOf(this.mLogContentList.size()));
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:13|14|15|16|30) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0088, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0089, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008c, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004f, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x006c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void createCSVFile(java.util.ArrayList<jp.co.sony.reonpocket.connection.log.BGLogManager.LogContent> r7) {
        /*
            r6 = this;
            java.lang.String r0 = "TAG"
            java.lang.String r1 = r6.getLogFilePath()
            java.io.File r2 = new java.io.File
            r2.<init>(r1)
            java.nio.charset.Charset r1 = kotlin.text.Charsets.UTF_8
            java.io.OutputStreamWriter r3 = new java.io.OutputStreamWriter
            java.io.FileOutputStream r4 = new java.io.FileOutputStream
            r4.<init>(r2)
            java.io.OutputStream r4 = (java.io.OutputStream) r4
            r3.<init>(r4, r1)
            java.io.Writer r3 = (java.io.Writer) r3
            boolean r1 = r3 instanceof java.io.BufferedWriter
            if (r1 == 0) goto L_0x0022
            java.io.BufferedWriter r3 = (java.io.BufferedWriter) r3
            goto L_0x002a
        L_0x0022:
            java.io.BufferedWriter r1 = new java.io.BufferedWriter
            r2 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r3, r2)
            r3 = r1
        L_0x002a:
            java.io.Closeable r3 = (java.io.Closeable) r3
            r1 = r3
            java.io.BufferedWriter r1 = (java.io.BufferedWriter) r1     // Catch:{ all -> 0x0086 }
            jp.co.sony.reonpocket.util.DebugLogUtil r2 = jp.co.sony.reonpocket.util.DebugLogUtil.INSTANCE     // Catch:{ all -> 0x0086 }
            java.lang.String r4 = "Start create CSV file"
            r2.d((java.lang.String) r0, (java.lang.String) r4)     // Catch:{ all -> 0x0086 }
            jp.co.sony.reonpocket.connection.log.csv.LogWriter r2 = new jp.co.sony.reonpocket.connection.log.csv.LogWriter     // Catch:{ all -> 0x0086 }
            java.io.Writer r1 = (java.io.Writer) r1     // Catch:{ all -> 0x0086 }
            r2.<init>(r1)     // Catch:{ all -> 0x0086 }
            java.lang.Iterable r7 = (java.lang.Iterable) r7     // Catch:{ all -> 0x0086 }
            r1 = 2
            java.util.List r7 = kotlin.collections.CollectionsKt.drop(r7, r1)     // Catch:{ all -> 0x0086 }
            r1 = 1
            java.util.List r7 = kotlin.collections.CollectionsKt.dropLast(r7, r1)     // Catch:{ all -> 0x0086 }
            java.lang.Iterable r7 = (java.lang.Iterable) r7     // Catch:{ all -> 0x0086 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x0086 }
        L_0x004f:
            boolean r1 = r7.hasNext()     // Catch:{ all -> 0x0086 }
            r4 = 0
            if (r1 == 0) goto L_0x0076
            java.lang.Object r1 = r7.next()     // Catch:{ all -> 0x0086 }
            jp.co.sony.reonpocket.connection.log.BGLogManager$LogContent r1 = (jp.co.sony.reonpocket.connection.log.BGLogManager.LogContent) r1     // Catch:{ all -> 0x0086 }
            java.lang.String r5 = mOwnerId     // Catch:{ all -> 0x0086 }
            if (r5 == 0) goto L_0x0066
            jp.co.sony.reonpocket.connection.log.entity.LogEntity$Companion r4 = jp.co.sony.reonpocket.connection.log.entity.LogEntity.Companion     // Catch:{ all -> 0x0086 }
            jp.co.sony.reonpocket.connection.log.entity.LogEntity r4 = r4.create((jp.co.sony.reonpocket.connection.log.BGLogManager.LogContent) r1, (java.lang.String) r5)     // Catch:{ all -> 0x0086 }
        L_0x0066:
            if (r4 == 0) goto L_0x004f
            r2.write(r4)     // Catch:{ Exception -> 0x006c }
            goto L_0x004f
        L_0x006c:
            jp.co.sony.reonpocket.util.DebugLogUtil r1 = jp.co.sony.reonpocket.util.DebugLogUtil.INSTANCE     // Catch:{ all -> 0x0086 }
            java.lang.String r4 = "ReadLogJobTask.TAG"
            java.lang.String r5 = "Write log to csv file, failed"
            r1.e(r4, r5)     // Catch:{ all -> 0x0086 }
            goto L_0x004f
        L_0x0076:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0086 }
            kotlin.io.CloseableKt.closeFinally(r3, r4)
            jp.co.sony.reonpocket.util.DebugLogUtil r7 = jp.co.sony.reonpocket.util.DebugLogUtil.INSTANCE
            java.lang.String r1 = "End create CSV file"
            r7.d((java.lang.String) r0, (java.lang.String) r1)
            r6.uploadLog()
            return
        L_0x0086:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0088 }
        L_0x0088:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.connection.log.BGLogManager.createCSVFile(java.util.ArrayList):void");
    }

    public final LogEntity createLogEntity(ReadLogJobTask.LogContent logContent) {
        Intrinsics.checkNotNullParameter(logContent, FirebaseAnalytics.Param.CONTENT);
        String str = mOwnerId;
        if (str != null) {
            return LogEntity.Companion.create(logContent, str);
        }
        return null;
    }

    private final void logAddList(BleDataEntity bleDataEntity) {
        LogContent logContent = new LogContent();
        byte[] data = bleDataEntity.getData();
        logContent.setMInfo(data != null ? ArraysKt.copyOfRange(data, 1, bleDataEntity.getData().length) : null);
        this.mLogContentList.add(logContent);
    }

    private final void uploadLog() {
        File filesDir = ReonPocketApplication.Companion.getApplicationContext().getFilesDir();
        String str = File.separator;
        this.aLogUpload.uploadLog(ReonPocketApplication.Companion.getApplicationContext(), new File(filesDir + str + "log"));
    }

    private final String getLogFilePath() {
        String str;
        File file = new File(ReonPocketApplication.Companion.getApplicationContext().getFilesDir() + File.separator + "log");
        if (!file.exists()) {
            file.mkdirs();
        }
        String format = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date());
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            byte[] bytes = String.valueOf(System.currentTimeMillis()).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] digest = instance.digest(bytes);
            Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
            str = String.format("%040x", new Object[]{new BigInteger(1, digest)});
        } catch (Exception unused) {
            DebugLogUtil.INSTANCE.e("tag", "create hash value failed");
            str = String.format("%040x", new Object[]{Integer.valueOf(Capability1$$ExternalSyntheticBackport0.m(System.currentTimeMillis()))});
        }
        String uUIDFromByteArray = UuidHelperUtil.INSTANCE.getUUIDFromByteArray(UuidHelperUtil.INSTANCE.getOwnIdByteArray(ReonPocketApplication.Companion.getApplicationContext()));
        mOwnerId = uUIDFromByteArray;
        String str2 = format + "_" + uUIDFromByteArray + "_" + str + "_android.csv";
        return file + File.separator + str2;
    }

    private final byte[] createDeviceLogEntity() {
        byte[] createWriteBytes$default = BleDataEntity.Companion.createWriteBytes$default(BleDataEntity.Companion, RequestLogAction.START.getCode(), 17, (ByteOrder) null, 4, (Object) null);
        byte[] createWriteBytes$default2 = BleDataEntity.Companion.createWriteBytes$default(BleDataEntity.Companion, (int) (getUnixTime() - 1000), 20, (ByteOrder) null, 4, (Object) null);
        return ArraysKt.plus(ArraysKt.plus(createWriteBytes$default, createWriteBytes$default2), byteArrayOfInts(255, 255, 255, 255));
    }

    private final byte[] stopDeviceLogEntity() {
        byte[] createWriteBytes$default = BleDataEntity.Companion.createWriteBytes$default(BleDataEntity.Companion, RequestLogAction.STOP.getCode(), 17, (ByteOrder) null, 4, (Object) null);
        byte[] byteArrayOfInts = byteArrayOfInts(1, 2, 3, 4);
        return ArraysKt.plus(ArraysKt.plus(createWriteBytes$default, byteArrayOfInts), byteArrayOfInts);
    }

    private final long getUnixTime() {
        return System.currentTimeMillis() / ((long) 1000);
    }

    private final byte[] byteArrayOfInts(int... iArr) {
        int length = iArr.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) iArr[i];
        }
        return bArr;
    }

    public final void requestLog() {
        if (MyContentUtil.isSupportLog$default(MyContentUtil.INSTANCE, ReonPocketApplication.Companion.getApplicationContext(), (String) null, 2, (Object) null)) {
            openDeviceLogNotification();
            deviceLogWrite();
        }
    }

    public final void stopRequestLog() {
        deviceLogStop();
    }

    public final void initContentList() {
        this.mLogContentList = new ArrayList<>();
    }
}
