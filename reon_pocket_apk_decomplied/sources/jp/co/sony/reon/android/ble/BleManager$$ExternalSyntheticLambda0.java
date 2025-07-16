package jp.co.sony.reon.android.ble;

import android.content.Context;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleManager$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ BleManager f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ BleManager$$ExternalSyntheticLambda0(Context context, BleManager bleManager, String str) {
        this.f$0 = context;
        this.f$1 = bleManager;
        this.f$2 = str;
    }

    public final void run() {
        BleManager.startScanning$lambda$12(this.f$0, this.f$1, this.f$2);
    }
}
