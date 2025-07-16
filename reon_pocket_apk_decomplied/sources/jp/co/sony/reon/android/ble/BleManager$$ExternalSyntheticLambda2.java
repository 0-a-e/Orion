package jp.co.sony.reon.android.ble;

import android.content.Context;
import jp.co.sony.reon.android.ble.listener.ScanCallbackListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleManager$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ BleManager f$0;
    public final /* synthetic */ Context f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ String[] f$3;
    public final /* synthetic */ String[] f$4;
    public final /* synthetic */ String f$5;
    public final /* synthetic */ String f$6;
    public final /* synthetic */ ScanCallbackListener f$7;

    public /* synthetic */ BleManager$$ExternalSyntheticLambda2(BleManager bleManager, Context context, int i, String[] strArr, String[] strArr2, String str, String str2, ScanCallbackListener scanCallbackListener) {
        this.f$0 = bleManager;
        this.f$1 = context;
        this.f$2 = i;
        this.f$3 = strArr;
        this.f$4 = strArr2;
        this.f$5 = str;
        this.f$6 = str2;
        this.f$7 = scanCallbackListener;
    }

    public final void run() {
        BleManager.startRssiScanning$lambda$8(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7);
    }
}
