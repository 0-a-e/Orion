package jp.co.sony.reonpocket.modules.pairing.presenter;

import jp.co.sony.reonpocket.data.entity.SensorDataEntity;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PairingPresenter$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ PairingPresenter f$0;
    public final /* synthetic */ SensorDataEntity f$1;

    public /* synthetic */ PairingPresenter$$ExternalSyntheticLambda0(PairingPresenter pairingPresenter, SensorDataEntity sensorDataEntity) {
        this.f$0 = pairingPresenter;
        this.f$1 = sensorDataEntity;
    }

    public final void run() {
        PairingPresenter.handleDeviceTemp$lambda$24(this.f$0, this.f$1);
    }
}
