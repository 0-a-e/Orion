package jp.co.sony.reonpocket.connection.log;

import android.content.Context;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceCommManager$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ DeviceCommManager f$0;
    public final /* synthetic */ Context f$1;

    public /* synthetic */ DeviceCommManager$$ExternalSyntheticLambda0(DeviceCommManager deviceCommManager, Context context) {
        this.f$0 = deviceCommManager;
        this.f$1 = context;
    }

    public final void run() {
        DeviceCommManager.connect$lambda$2(this.f$0, this.f$1);
    }
}
