package jp.co.sony.reonpocket.data.interactor;

import jp.co.sony.reon.android.ble.listener.WriteCallbackListener;
import jp.co.sony.reonpocket.constant.BleActionCode;
import jp.co.sony.reonpocket.constant.ResponseCode;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"jp/co/sony/reonpocket/data/interactor/BleInteractor$write$1", "Ljp/co/sony/reon/android/ble/listener/WriteCallbackListener;", "onWrite", "", "aResponseCode", "", "aCharacteristicUuid", "", "aServiceUuid", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BleInteractor.kt */
public final class BleInteractor$write$1 implements WriteCallbackListener {
    final /* synthetic */ byte[] $aData;
    final /* synthetic */ BleInteractor this$0;

    BleInteractor$write$1(BleInteractor bleInteractor, byte[] bArr) {
        this.this$0 = bleInteractor;
        this.$aData = bArr;
    }

    public void onWrite(int i, String str, String str2) {
        BleDataEntity bleDataEntity;
        ResponseCode responseCode;
        Intrinsics.checkNotNullParameter(str, "aCharacteristicUuid");
        Intrinsics.checkNotNullParameter(str2, "aServiceUuid");
        String access$getShortUuidByLongUuid = this.this$0.getShortUuidByLongUuid(str2, str);
        String shortUuidByLongUuid$default = BleInteractor.getShortUuidByLongUuid$default(this.this$0, str2, (String) null, 2, (Object) null);
        if (i == ResponseCode.SUCCESS.getCode()) {
            bleDataEntity = new BleDataEntity(BleActionCode.WRITE, access$getShortUuidByLongUuid, shortUuidByLongUuid$default, this.$aData, true, (ResponseCode) null, 32, (DefaultConstructorMarker) null);
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
                bleDataEntity = new BleDataEntity(BleActionCode.WRITE, access$getShortUuidByLongUuid, shortUuidByLongUuid$default, this.$aData, false, responseCode, 16, (DefaultConstructorMarker) null);
            } else {
                bleDataEntity = new BleDataEntity(BleActionCode.WRITE, access$getShortUuidByLongUuid, shortUuidByLongUuid$default, this.$aData, false, ResponseCode.CUSTOM_UNKNOWN_RESPONSE_CODE, 16, (DefaultConstructorMarker) null);
            }
        }
        Function1<BleDataEntity, Unit> mDataReceivedCallbackListener = this.this$0.getMDataReceivedCallbackListener();
        if (mDataReceivedCallbackListener != null) {
            mDataReceivedCallbackListener.invoke(bleDataEntity);
        }
    }
}
