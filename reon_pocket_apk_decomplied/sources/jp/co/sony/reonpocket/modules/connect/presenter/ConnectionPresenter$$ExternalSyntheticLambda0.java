package jp.co.sony.reonpocket.modules.connect.presenter;

import jp.co.sony.reonpocket.data.entity.SensorDataEntity;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ConnectionPresenter$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ConnectionPresenter f$0;
    public final /* synthetic */ SensorDataEntity f$1;

    public /* synthetic */ ConnectionPresenter$$ExternalSyntheticLambda0(ConnectionPresenter connectionPresenter, SensorDataEntity sensorDataEntity) {
        this.f$0 = connectionPresenter;
        this.f$1 = sensorDataEntity;
    }

    public final void run() {
        ConnectionPresenter.handleDeviceTemp$lambda$23(this.f$0, this.f$1);
    }
}
