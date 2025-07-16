package jp.co.sony.reonpocket.modules.main.presenter;

import jp.co.sony.reonpocket.util.RemoteConfigUtil;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"jp/co/sony/reonpocket/modules/main/presenter/MainPresenter$onResume$2", "Ljp/co/sony/reonpocket/util/RemoteConfigUtil$OnFetchFinishListener;", "onFetchFinish", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainPresenter.kt */
public final class MainPresenter$onResume$2 implements RemoteConfigUtil.OnFetchFinishListener {
    final /* synthetic */ MainPresenter this$0;

    MainPresenter$onResume$2(MainPresenter mainPresenter) {
        this.this$0 = mainPresenter;
    }

    public void onFetchFinish() {
        this.this$0.checkRemoteConfig();
    }
}
