package jp.co.sony.reonpocket.modules.pairing.view;

import jp.co.sony.reonpocket.constant.BleConnStatusCode;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PairingActivity$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ PairingActivity f$0;
    public final /* synthetic */ BleConnStatusCode f$1;

    public /* synthetic */ PairingActivity$$ExternalSyntheticLambda1(PairingActivity pairingActivity, BleConnStatusCode bleConnStatusCode) {
        this.f$0 = pairingActivity;
        this.f$1 = bleConnStatusCode;
    }

    public final void run() {
        PairingActivity.requestPermissionDialog$lambda$5(this.f$0, this.f$1);
    }
}
