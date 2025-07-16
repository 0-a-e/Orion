package jp.co.sony.reonpocket.modules.main.presenter;

import jp.co.sony.reonpocket.data.entity.SensorDataEntity;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MainPresenter$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ MainPresenter f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ SensorDataEntity f$2;

    public /* synthetic */ MainPresenter$$ExternalSyntheticLambda3(MainPresenter mainPresenter, boolean z, SensorDataEntity sensorDataEntity) {
        this.f$0 = mainPresenter;
        this.f$1 = z;
        this.f$2 = sensorDataEntity;
    }

    public final void run() {
        MainPresenter.handleDeviceTemp$lambda$60(this.f$0, this.f$1, this.f$2);
    }
}
