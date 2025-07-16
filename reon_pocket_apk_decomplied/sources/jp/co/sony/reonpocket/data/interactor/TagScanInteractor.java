package jp.co.sony.reonpocket.data.interactor;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.Date;
import jp.co.sony.reon.android.ble.listener.TagScanNoReceivingCallback;
import jp.co.sony.reon.android.ble.listener.TagScanRegisterCallback;
import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0014\b\u0007\u0018\u0000 02\u00020\u0001:\u000201B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010!\u001a\u00020\u001d2\b\u0010\u0007\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u0019H\u0016J\b\u0010%\u001a\u00020\u001dH\u0016J\b\u0010&\u001a\u00020\u001dH\u0016J\u000e\u0010'\u001a\u00020\u001dH@¢\u0006\u0002\u0010(J\u0018\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0002J\u000e\u0010/\u001a\u00020\u001dH@¢\u0006\u0002\u0010(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/TagScanInteractor;", "Ljp/co/sony/reonpocket/data/interactor/TagScanInteractorInput;", "aContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getAContext", "()Landroid/content/Context;", "callback", "Ljp/co/sony/reonpocket/data/interactor/TagScanInteractorCallbackListener;", "callbackNoReceiving", "Ljp/co/sony/reonpocket/data/interactor/TagScanNoReceivingInteractorCallbackListener;", "doNotShowPopupTime", "Ljava/util/Date;", "mBleInteractor", "Ljp/co/sony/reonpocket/data/interactor/BleInteractor;", "mNoReceivingScanCallback", "Ljp/co/sony/reon/android/ble/listener/TagScanNoReceivingCallback;", "mNoReceivingScanHandler", "Landroid/os/Handler;", "mNoReceivingScanRunnable", "jp/co/sony/reonpocket/data/interactor/TagScanInteractor$mNoReceivingScanRunnable$1", "Ljp/co/sony/reonpocket/data/interactor/TagScanInteractor$mNoReceivingScanRunnable$1;", "mTagInfoInteractor", "Ljp/co/sony/reonpocket/data/interactor/TagInfoInteractor;", "notScanTagInfo", "Ljp/co/sony/reonpocket/data/interactor/TagScanInteractor$TagInfo;", "tagScanHandler", "Ljp/co/sony/reon/android/ble/listener/TagScanRegisterCallback;", "execute", "", "executeNoReceiving", "release", "setListener", "setNoReceivingListener", "setNotShowPopupTime", "date", "tagInfo", "startNoReceiving", "stopNoReceiving", "tagScan", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tagScanCheck", "", "deviceName", "", "aData", "Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity;", "tagScanNoReceiving", "Companion", "TagInfo", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagScanInteractor.kt */
public final class TagScanInteractor implements TagScanInteractorInput {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String LOG_TAG = "TagScanInteractor";
    public static final long NO_RECEIVING_SCAN_INTERVAL = 6000;
    public static final long NO_RECEIVING_SCAN_WAIT = 100;
    public static final int WAIT_TIME_MINUTE = 1;
    private final Context aContext;
    /* access modifiers changed from: private */
    public TagScanInteractorCallbackListener callback;
    /* access modifiers changed from: private */
    public TagScanNoReceivingInteractorCallbackListener callbackNoReceiving;
    private Date doNotShowPopupTime;
    /* access modifiers changed from: private */
    public BleInteractor mBleInteractor = new BleInteractor();
    /* access modifiers changed from: private */
    public TagScanNoReceivingCallback mNoReceivingScanCallback = new TagScanInteractor$mNoReceivingScanCallback$1(this);
    /* access modifiers changed from: private */
    public final Handler mNoReceivingScanHandler = new Handler(Looper.getMainLooper());
    private final TagScanInteractor$mNoReceivingScanRunnable$1 mNoReceivingScanRunnable = new TagScanInteractor$mNoReceivingScanRunnable$1(this);
    /* access modifiers changed from: private */
    public TagInfoInteractor mTagInfoInteractor = new TagInfoInteractor();
    private TagInfo notScanTagInfo;
    /* access modifiers changed from: private */
    public TagScanRegisterCallback tagScanHandler = new TagScanInteractor$tagScanHandler$1(this);

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/TagScanInteractor$Companion;", "", "()V", "LOG_TAG", "", "NO_RECEIVING_SCAN_INTERVAL", "", "NO_RECEIVING_SCAN_WAIT", "WAIT_TIME_MINUTE", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TagScanInteractor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public TagScanInteractor(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        this.aContext = context;
        this.mBleInteractor.onCreate(context);
    }

    public final Context getAContext() {
        return this.aContext;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/TagScanInteractor$TagInfo;", "", "model", "", "serialNo", "(Ljava/lang/String;Ljava/lang/String;)V", "getModel", "()Ljava/lang/String;", "getSerialNo", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TagScanInteractor.kt */
    public static final class TagInfo {
        public static final int $stable = 0;
        private final String model;
        private final String serialNo;

        public static /* synthetic */ TagInfo copy$default(TagInfo tagInfo, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tagInfo.model;
            }
            if ((i & 2) != 0) {
                str2 = tagInfo.serialNo;
            }
            return tagInfo.copy(str, str2);
        }

        public final String component1() {
            return this.model;
        }

        public final String component2() {
            return this.serialNo;
        }

        public final TagInfo copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "model");
            Intrinsics.checkNotNullParameter(str2, "serialNo");
            return new TagInfo(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TagInfo)) {
                return false;
            }
            TagInfo tagInfo = (TagInfo) obj;
            return Intrinsics.areEqual((Object) this.model, (Object) tagInfo.model) && Intrinsics.areEqual((Object) this.serialNo, (Object) tagInfo.serialNo);
        }

        public int hashCode() {
            return (this.model.hashCode() * 31) + this.serialNo.hashCode();
        }

        public String toString() {
            String str = this.model;
            String str2 = this.serialNo;
            return "TagInfo(model=" + str + ", serialNo=" + str2 + ")";
        }

        public TagInfo(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "model");
            Intrinsics.checkNotNullParameter(str2, "serialNo");
            this.model = str;
            this.serialNo = str2;
        }

        public final String getModel() {
            return this.model;
        }

        public final String getSerialNo() {
            return this.serialNo;
        }
    }

    public void release() {
        stopNoReceiving();
        this.mBleInteractor.onDestroy(this.aContext);
        this.callback = null;
        this.callbackNoReceiving = null;
    }

    /* access modifiers changed from: private */
    public final Object tagScan(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new TagScanInteractor$tagScan$2(this, (Continuation<? super TagScanInteractor$tagScan$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object tagScanNoReceiving(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new TagScanInteractor$tagScanNoReceiving$2(this, (Continuation<? super TagScanInteractor$tagScanNoReceiving$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final boolean tagScanCheck(String str, TagDataEntity tagDataEntity) {
        TagInfo tagInfo;
        if (!(this.doNotShowPopupTime == null || (tagInfo = this.notScanTagInfo) == null || tagInfo == null || tagInfo.getSerialNo() == null)) {
            Date date = this.doNotShowPopupTime;
            if (date != null) {
                if (date.compareTo(new Date()) > 0) {
                    DebugLogUtil.INSTANCE.d(LOG_TAG, "re scan for restricted");
                } else {
                    this.doNotShowPopupTime = null;
                    return true;
                }
            }
            TagInfo tagInfo2 = this.notScanTagInfo;
            if (tagInfo2 != null) {
                if (Intrinsics.areEqual((Object) str, (Object) tagInfo2.getModel()) && StringsKt.equals$default(tagDataEntity.getSerialNo(), tagInfo2.getSerialNo(), false, 2, (Object) null)) {
                    return false;
                }
                this.notScanTagInfo = null;
            }
        }
        return true;
    }

    public void execute() {
        DebugLogUtil.INSTANCE.d(LOG_TAG, "execute start");
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new TagScanInteractor$execute$1(this, (Continuation<? super TagScanInteractor$execute$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void executeNoReceiving() {
        DebugLogUtil.INSTANCE.d(LOG_TAG, "executeNoReceiving start");
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new TagScanInteractor$executeNoReceiving$1(this, (Continuation<? super TagScanInteractor$executeNoReceiving$1>) null), 3, (Object) null);
    }

    public void startNoReceiving() {
        stopNoReceiving();
        DebugLogUtil.INSTANCE.d(LOG_TAG, "Start Tag NoReceivingScan");
        this.mNoReceivingScanHandler.post(this.mNoReceivingScanRunnable);
    }

    public void stopNoReceiving() {
        DebugLogUtil.INSTANCE.d(LOG_TAG, "Stop Tag NoReceivingScan");
        this.mNoReceivingScanHandler.removeCallbacks(this.mNoReceivingScanRunnable);
    }

    public void setNotShowPopupTime(Date date, TagInfo tagInfo) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(tagInfo, "tagInfo");
        this.doNotShowPopupTime = date;
        this.notScanTagInfo = tagInfo;
    }

    public void setListener(TagScanInteractorCallbackListener tagScanInteractorCallbackListener) {
        Intrinsics.checkNotNullParameter(tagScanInteractorCallbackListener, "callback");
        this.callback = tagScanInteractorCallbackListener;
    }

    public void setNoReceivingListener(TagScanNoReceivingInteractorCallbackListener tagScanNoReceivingInteractorCallbackListener) {
        this.callbackNoReceiving = tagScanNoReceivingInteractorCallbackListener;
    }
}
