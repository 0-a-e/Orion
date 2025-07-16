package jp.co.sony.reonpocket.connection.ble.dfu;

import android.content.Context;
import java.util.ArrayList;
import jp.co.sony.reon.android.ble.constant.TagGattProfileConstant;
import jp.co.sony.reonpocket.constant.BleConnStatusCode;
import jp.co.sony.reonpocket.constant.ModelConstant;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import jp.co.sony.reonpocket.data.entity.tag.TagRequestDfuEntity;
import jp.co.sony.reonpocket.data.interactor.BleInteractor;
import jp.co.sony.reonpocket.data.interactor.BleInteractorInput;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\f\b\u0007\u0018\u00002\u00020\u0001:\u0003()*B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J6\u0010\u001b\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\u001a\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010 j\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`!H\u0002J\u0010\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0013H\u0002J\u0006\u0010'\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Ljp/co/sony/reonpocket/connection/ble/dfu/TagDfuInteractor;", "", "aContext", "Landroid/content/Context;", "aOutput", "Ljp/co/sony/reonpocket/connection/ble/dfu/TagDfuInteractor$TagDfuOutput;", "(Landroid/content/Context;Ljp/co/sony/reonpocket/connection/ble/dfu/TagDfuInteractor$TagDfuOutput;)V", "mBleInteractor", "Ljp/co/sony/reonpocket/data/interactor/BleInteractorInput;", "mConnectionMode", "Ljp/co/sony/reonpocket/connection/ble/dfu/TagDfuInteractor$ConnectionType;", "mDefaultDfuProgressListener", "jp/co/sony/reonpocket/connection/ble/dfu/TagDfuInteractor$mDefaultDfuProgressListener$1", "Ljp/co/sony/reonpocket/connection/ble/dfu/TagDfuInteractor$mDefaultDfuProgressListener$1;", "mDeviceName", "", "mIsTagDfuSuccess", "", "mTagDfuState", "Ljp/co/sony/reonpocket/connection/ble/dfu/TagDfuInteractor$DfuState;", "connectDFUTag", "", "connectTag", "handleConnectionError", "aErrorMessage", "handleDataError", "handleDfuProgressError", "onTagConnectionStatus", "aDeviceName", "aConnStatusCode", "Ljp/co/sony/reonpocket/constant/BleConnStatusCode;", "aServiceUuidList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onTagDataReceived", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "setTagDfuState", "aState", "startDfu", "ConnectionType", "DfuState", "TagDfuOutput", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagDfuInteractor.kt */
public final class TagDfuInteractor {
    public static final int $stable = 8;
    private final Context aContext;
    /* access modifiers changed from: private */
    public final TagDfuOutput aOutput;
    private BleInteractorInput mBleInteractor = new BleInteractor();
    private ConnectionType mConnectionMode = ConnectionType.NORMAL;
    private final TagDfuInteractor$mDefaultDfuProgressListener$1 mDefaultDfuProgressListener = new TagDfuInteractor$mDefaultDfuProgressListener$1(this);
    private String mDeviceName = "";
    /* access modifiers changed from: private */
    public boolean mIsTagDfuSuccess = true;
    private DfuState mTagDfuState = DfuState.NONE;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Ljp/co/sony/reonpocket/connection/ble/dfu/TagDfuInteractor$TagDfuOutput;", "", "onTagDfuComplete", "", "onTagDfuDeviceDisconnecting", "onTagDfuFailed", "aErrorMessage", "", "onTagDfuProcessStarting", "onTagDfuProgressChanged", "percent", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TagDfuInteractor.kt */
    public interface TagDfuOutput {
        void onTagDfuComplete();

        void onTagDfuDeviceDisconnecting();

        void onTagDfuFailed(String str);

        void onTagDfuProcessStarting();

        void onTagDfuProgressChanged(int i);
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TagDfuInteractor.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|(2:15|16)|17|19|20|21|22|23|24|25|26|27|29) */
        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|1|2|3|(2:5|6)|7|9|10|11|12|13|(2:15|16)|17|19|20|21|22|23|24|25|26|27|29) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005c */
        static {
            /*
                jp.co.sony.reonpocket.connection.ble.dfu.TagDfuInteractor$ConnectionType[] r0 = jp.co.sony.reonpocket.connection.ble.dfu.TagDfuInteractor.ConnectionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                jp.co.sony.reonpocket.connection.ble.dfu.TagDfuInteractor$ConnectionType r2 = jp.co.sony.reonpocket.connection.ble.dfu.TagDfuInteractor.ConnectionType.NORMAL     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                jp.co.sony.reonpocket.connection.ble.dfu.TagDfuInteractor$ConnectionType r3 = jp.co.sony.reonpocket.connection.ble.dfu.TagDfuInteractor.ConnectionType.DFU     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                jp.co.sony.reonpocket.connection.ble.dfu.TagDfuInteractor$DfuState[] r0 = jp.co.sony.reonpocket.connection.ble.dfu.TagDfuInteractor.DfuState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.connection.ble.dfu.TagDfuInteractor$DfuState r3 = jp.co.sony.reonpocket.connection.ble.dfu.TagDfuInteractor.DfuState.DFU_GOING     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                jp.co.sony.reonpocket.connection.ble.dfu.TagDfuInteractor$DfuState r3 = jp.co.sony.reonpocket.connection.ble.dfu.TagDfuInteractor.DfuState.DFU_VERIFYING     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                r3 = 3
                jp.co.sony.reonpocket.connection.ble.dfu.TagDfuInteractor$DfuState r4 = jp.co.sony.reonpocket.connection.ble.dfu.TagDfuInteractor.DfuState.DFU_VERIFY_DONE     // Catch:{ NoSuchFieldError -> 0x003b }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                $EnumSwitchMapping$1 = r0
                jp.co.sony.reonpocket.constant.BleConnStatusCode[] r0 = jp.co.sony.reonpocket.constant.BleConnStatusCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.BleConnStatusCode r4 = jp.co.sony.reonpocket.constant.BleConnStatusCode.CONNECTED     // Catch:{ NoSuchFieldError -> 0x004c }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                jp.co.sony.reonpocket.constant.BleConnStatusCode r1 = jp.co.sony.reonpocket.constant.BleConnStatusCode.SERVICE_DISCOVERED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                jp.co.sony.reonpocket.constant.BleConnStatusCode r1 = jp.co.sony.reonpocket.constant.BleConnStatusCode.CONNECT_SUSPENDED     // Catch:{ NoSuchFieldError -> 0x005c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x005c }
            L_0x005c:
                jp.co.sony.reonpocket.constant.BleConnStatusCode r1 = jp.co.sony.reonpocket.constant.BleConnStatusCode.CONNECT_FAILED     // Catch:{ NoSuchFieldError -> 0x0065 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0065 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0065 }
            L_0x0065:
                $EnumSwitchMapping$2 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.connection.ble.dfu.TagDfuInteractor.WhenMappings.<clinit>():void");
        }
    }

    public TagDfuInteractor(Context context, TagDfuOutput tagDfuOutput) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        this.aContext = context;
        this.aOutput = tagDfuOutput;
        this.mBleInteractor.onCreate(context);
        this.mBleInteractor.setTagDataReceivedCallbackListener(new Function1<BleDataEntity, Unit>(this) {
            final /* synthetic */ TagDfuInteractor this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((BleDataEntity) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(BleDataEntity bleDataEntity) {
                Intrinsics.checkNotNullParameter(bleDataEntity, "it");
                this.this$0.onTagDataReceived(bleDataEntity);
            }
        });
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reonpocket/connection/ble/dfu/TagDfuInteractor$ConnectionType;", "", "(Ljava/lang/String;I)V", "NORMAL", "DFU", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TagDfuInteractor.kt */
    public enum ConnectionType {
        NORMAL,
        DFU;

        public static EnumEntries<ConnectionType> getEntries() {
            return $ENTRIES;
        }

        static {
            ConnectionType[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Ljp/co/sony/reonpocket/connection/ble/dfu/TagDfuInteractor$DfuState;", "", "(Ljava/lang/String;I)V", "NONE", "DFU_FINISHED", "DFU_FAILED", "DFU_GOING", "DFU_VERIFYING", "DFU_VERIFY_DONE", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TagDfuInteractor.kt */
    public enum DfuState {
        NONE,
        DFU_FINISHED,
        DFU_FAILED,
        DFU_GOING,
        DFU_VERIFYING,
        DFU_VERIFY_DONE;

        public static EnumEntries<DfuState> getEntries() {
            return $ENTRIES;
        }

        static {
            DfuState[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    public final void startDfu() {
        if (this.mTagDfuState == DfuState.NONE || this.mTagDfuState == DfuState.DFU_FINISHED || this.mTagDfuState == DfuState.DFU_FAILED) {
            setTagDfuState(DfuState.NONE);
            BleInteractor.Companion.setMTagConnectCallbackListener(new TagDfuInteractor$startDfu$1(this));
            connectTag();
            return;
        }
        DebugLogUtil.INSTANCE.d("Tag dfu processing");
    }

    /* access modifiers changed from: private */
    public final void onTagConnectionStatus(String str, BleConnStatusCode bleConnStatusCode, ArrayList<String> arrayList) {
        int i = WhenMappings.$EnumSwitchMapping$2[bleConnStatusCode.ordinal()];
        if (i != 1) {
            if (i == 2) {
                int i2 = WhenMappings.$EnumSwitchMapping$0[this.mConnectionMode.ordinal()];
                if (i2 == 1) {
                    Thread.sleep(100);
                    byte[] bArr = new TagRequestDfuEntity(255).toByte();
                    Intrinsics.checkNotNull(bArr);
                    BleInteractorInput.DefaultImpls.tagWrite$default(this.mBleInteractor, TagGattProfileConstant.DeviceControlService.CHARACTERISTIC_REQUEST_DFU.getUuid(), (String) null, bArr, 2, (Object) null);
                } else if (i2 == 2) {
                    this.mBleInteractor.executeTagDfu(this.aContext, this.mDeviceName, this.mDefaultDfuProgressListener);
                }
            } else if (i == 3) {
                int i3 = WhenMappings.$EnumSwitchMapping$0[this.mConnectionMode.ordinal()];
                if (i3 != 1) {
                    if (i3 == 2) {
                        int i4 = WhenMappings.$EnumSwitchMapping$1[this.mTagDfuState.ordinal()];
                        if (i4 == 1 || i4 == 2 || i4 == 3) {
                            handleDfuProgressError("connect suspended");
                        }
                    }
                } else if (this.mTagDfuState == DfuState.DFU_FAILED) {
                    this.mBleInteractor.tagDFUProcessAbort();
                } else {
                    connectDFUTag();
                }
            } else if (i == 4) {
                int i5 = WhenMappings.$EnumSwitchMapping$0[this.mConnectionMode.ordinal()];
                if (i5 == 1) {
                    handleConnectionError("connect failed");
                } else if (i5 == 2) {
                    this.mConnectionMode = ConnectionType.NORMAL;
                    handleConnectionError("connect failed on dfu");
                }
                this.mBleInteractor.disconnectTag();
            }
        } else if (ArraysKt.contains((T[]) ModelConstant.INSTANCE.getTagModelNames(), str)) {
            if (str == null) {
                str = "";
            }
            this.mDeviceName = str;
        } else if (ArraysKt.contains((T[]) ModelConstant.INSTANCE.getDfuTagModelNames(), str) && this.mTagDfuState == DfuState.DFU_VERIFYING) {
            setTagDfuState(DfuState.DFU_VERIFY_DONE);
        }
    }

    private final void connectTag() {
        this.mConnectionMode = ConnectionType.NORMAL;
        BleInteractorInput.DefaultImpls.tagScanConnect$default(this.mBleInteractor, this.aContext, (String[]) null, 2, (Object) null);
    }

    private final void connectDFUTag() {
        this.mConnectionMode = ConnectionType.DFU;
        setTagDfuState(DfuState.DFU_VERIFYING);
        this.mBleInteractor.tagScanConnect(this.aContext, ModelConstant.INSTANCE.getDfuTagModelNames());
    }

    /* access modifiers changed from: private */
    public final void onTagDataReceived(BleDataEntity bleDataEntity) {
        if (bleDataEntity.getResult()) {
            Intrinsics.areEqual((Object) bleDataEntity.getCharacteristicUuid(), (Object) TagGattProfileConstant.DeviceControlService.CHARACTERISTIC_REQUEST_DFU.getUuid());
        } else if (Intrinsics.areEqual((Object) bleDataEntity.getCharacteristicUuid(), (Object) TagGattProfileConstant.DeviceControlService.CHARACTERISTIC_REQUEST_DFU.getUuid())) {
            handleDataError("request dfu");
        }
    }

    /* access modifiers changed from: private */
    public final void setTagDfuState(DfuState dfuState) {
        this.mTagDfuState = dfuState;
    }

    /* access modifiers changed from: private */
    public final void handleDfuProgressError(String str) {
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        debugLogUtil.e("dfu progress error:" + str);
        setTagDfuState(DfuState.DFU_FAILED);
        this.mBleInteractor.tagDFUProcessAbort();
        TagDfuOutput tagDfuOutput = this.aOutput;
        if (tagDfuOutput != null) {
            tagDfuOutput.onTagDfuFailed(str);
        }
    }

    private final void handleConnectionError(String str) {
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        debugLogUtil.e("connection error:" + str);
        setTagDfuState(DfuState.DFU_FAILED);
        this.mBleInteractor.tagDFUProcessAbort();
        TagDfuOutput tagDfuOutput = this.aOutput;
        if (tagDfuOutput != null) {
            tagDfuOutput.onTagDfuFailed(str);
        }
    }

    private final void handleDataError(String str) {
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        debugLogUtil.e("data error:" + str);
        setTagDfuState(DfuState.DFU_FAILED);
        this.mBleInteractor.tagDFUProcessAbort();
        TagDfuOutput tagDfuOutput = this.aOutput;
        if (tagDfuOutput != null) {
            tagDfuOutput.onTagDfuFailed(str);
        }
    }
}
