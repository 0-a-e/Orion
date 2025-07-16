package jp.co.sony.reonpocket.data.interactor;

import jp.co.sony.reonpocket.data.interactor.SettingInfoInteractor;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/SettingInfoInteractorInput;", "", "compareFirmRevisionWithServer", "", "aListener", "Ljp/co/sony/reonpocket/data/interactor/SettingInfoInteractorInput$OnCompleteListener;", "OnCompleteListener", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SettingInfoInteractorInput.kt */
public interface SettingInfoInteractorInput {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/SettingInfoInteractorInput$OnCompleteListener;", "", "onFail", "", "onSuccess", "result", "Ljp/co/sony/reonpocket/data/interactor/SettingInfoInteractor$AppVersionComparisonResult;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: SettingInfoInteractorInput.kt */
    public interface OnCompleteListener {
        void onFail();

        void onSuccess(SettingInfoInteractor.AppVersionComparisonResult appVersionComparisonResult);
    }

    void compareFirmRevisionWithServer(OnCompleteListener onCompleteListener);
}
