package jp.co.sony.reonpocket.data.interactor;

import java.util.Map;
import jp.co.sony.reon.android.ble.listener.NotificationCallbackListener;
import jp.co.sony.reonpocket.constant.BleActionCode;
import jp.co.sony.reonpocket.constant.ResponseCode;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"jp/co/sony/reonpocket/data/interactor/BleInteractor$toggleNotification$1", "Ljp/co/sony/reon/android/ble/listener/NotificationCallbackListener;", "onNotify", "", "aResponseCode", "", "aCharacteristicUuid", "", "aServiceUuid", "aData", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BleInteractor.kt */
public final class BleInteractor$toggleNotification$1 implements NotificationCallbackListener {
    final /* synthetic */ BleInteractor this$0;

    BleInteractor$toggleNotification$1(BleInteractor bleInteractor) {
        this.this$0 = bleInteractor;
    }

    public void onNotify(int i, String str, String str2, byte[] bArr) {
        BleDataEntity bleDataEntity;
        ResponseCode responseCode;
        Intrinsics.checkNotNullParameter(str, "aCharacteristicUuid");
        Intrinsics.checkNotNullParameter(str2, "aServiceUuid");
        String access$getShortUuidByLongUuid = this.this$0.getShortUuidByLongUuid(str2, str);
        String shortUuidByLongUuid$default = BleInteractor.getShortUuidByLongUuid$default(this.this$0, str2, (String) null, 2, (Object) null);
        if (i == ResponseCode.SUCCESS.getCode()) {
            bleDataEntity = new BleDataEntity(BleActionCode.NOTIFY, access$getShortUuidByLongUuid, shortUuidByLongUuid$default, bArr, true, (ResponseCode) null, 32, (DefaultConstructorMarker) null);
        } else {
            ResponseCode[] values = ResponseCode.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    responseCode = null;
                    break;
                }
                ResponseCode responseCode2 = values[i2];
                if (responseCode2.getCode() == i) {
                    responseCode = responseCode2;
                    break;
                }
                i2++;
            }
            if (responseCode != null) {
                bleDataEntity = new BleDataEntity(BleActionCode.NOTIFY, access$getShortUuidByLongUuid, shortUuidByLongUuid$default, (byte[]) null, false, responseCode, 24, (DefaultConstructorMarker) null);
            } else {
                bleDataEntity = new BleDataEntity(BleActionCode.NOTIFY, access$getShortUuidByLongUuid, shortUuidByLongUuid$default, (byte[]) null, false, ResponseCode.CUSTOM_UNKNOWN_RESPONSE_CODE, 24, (DefaultConstructorMarker) null);
            }
        }
        DebugLogUtil.INSTANCE.v("[" + access$getShortUuidByLongUuid + "] notify value:" + bleDataEntity);
        if (!BleInteractor.Companion.getMDataReceivedCallbackMap().isEmpty()) {
            for (Map.Entry value : BleInteractor.Companion.getMDataReceivedCallbackMap().entrySet()) {
                Function1 function1 = (Function1) value.getValue();
                if (function1 != null) {
                    function1.invoke(bleDataEntity);
                }
            }
        }
    }
}
