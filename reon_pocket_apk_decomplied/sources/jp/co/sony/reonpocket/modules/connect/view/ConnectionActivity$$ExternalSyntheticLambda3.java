package jp.co.sony.reonpocket.modules.connect.view;

import jp.co.sony.reonpocket.constant.BleConnStatusCode;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ConnectionActivity$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ ConnectionActivity f$0;
    public final /* synthetic */ BleConnStatusCode f$1;

    public /* synthetic */ ConnectionActivity$$ExternalSyntheticLambda3(ConnectionActivity connectionActivity, BleConnStatusCode bleConnStatusCode) {
        this.f$0 = connectionActivity;
        this.f$1 = bleConnStatusCode;
    }

    public final void run() {
        ConnectionActivity.requestPermissionDialog$lambda$12(this.f$0, this.f$1);
    }
}
