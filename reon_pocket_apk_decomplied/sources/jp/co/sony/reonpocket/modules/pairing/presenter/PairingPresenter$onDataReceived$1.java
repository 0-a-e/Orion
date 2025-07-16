package jp.co.sony.reonpocket.modules.pairing.presenter;

import android.os.Bundle;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import jp.co.sony.reonpocket.data.interactor.SettingInfoInteractor;
import jp.co.sony.reonpocket.data.interactor.SettingInfoInteractorInput;
import jp.co.sony.reonpocket.modules.base.view.BaseActivityKt;
import jp.co.sony.reonpocket.modules.pairing.presenter.PairingPresenter;
import jp.co.sony.reonpocket.modules.pairing.view.PairingViewInput;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"jp/co/sony/reonpocket/modules/pairing/presenter/PairingPresenter$onDataReceived$1", "Ljp/co/sony/reonpocket/data/interactor/SettingInfoInteractorInput$OnCompleteListener;", "onFail", "", "onSuccess", "result", "Ljp/co/sony/reonpocket/data/interactor/SettingInfoInteractor$AppVersionComparisonResult;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PairingPresenter.kt */
public final class PairingPresenter$onDataReceived$1 implements SettingInfoInteractorInput.OnCompleteListener {
    final /* synthetic */ BleDataEntity $aBleDataEntity;
    final /* synthetic */ PairingPresenter this$0;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PairingPresenter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                jp.co.sony.reonpocket.data.interactor.SettingInfoInteractor$AppVersionComparisonResult[] r0 = jp.co.sony.reonpocket.data.interactor.SettingInfoInteractor.AppVersionComparisonResult.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.data.interactor.SettingInfoInteractor$AppVersionComparisonResult r1 = jp.co.sony.reonpocket.data.interactor.SettingInfoInteractor.AppVersionComparisonResult.OLDER_APP     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                jp.co.sony.reonpocket.data.interactor.SettingInfoInteractor$AppVersionComparisonResult r1 = jp.co.sony.reonpocket.data.interactor.SettingInfoInteractor.AppVersionComparisonResult.LATEST_APP     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.pairing.presenter.PairingPresenter$onDataReceived$1.WhenMappings.<clinit>():void");
        }
    }

    PairingPresenter$onDataReceived$1(PairingPresenter pairingPresenter, BleDataEntity bleDataEntity) {
        this.this$0 = pairingPresenter;
        this.$aBleDataEntity = bleDataEntity;
    }

    public void onSuccess(SettingInfoInteractor.AppVersionComparisonResult appVersionComparisonResult) {
        Intrinsics.checkNotNullParameter(appVersionComparisonResult, "result");
        this.this$0.setDfuState(PairingPresenter.DfuState.DFU_VERIFY_DONE);
        int i = WhenMappings.$EnumSwitchMapping$0[appVersionComparisonResult.ordinal()];
        if (i == 1) {
            this.this$0.mSuspendReason = PairingPresenter.SuspendReason.FORCE_UPDATE;
            this.this$0.disconnect();
            PairingViewInput access$getAView$p = this.this$0.aView;
            if (access$getAView$p != null) {
                access$getAView$p.requestForAppUpdate();
            }
        } else if (i == 2) {
            PairingViewInput access$getAView$p2 = this.this$0.aView;
            if (access$getAView$p2 != null) {
                PairingViewInput.DefaultImpls.onNextPage$default(access$getAView$p2, PairingPresenter.NextPage.DFU_GOING.ordinal(), (String) null, (Bundle) null, 6, (Object) null);
            }
            this.this$0.handleDfuModelName(this.$aBleDataEntity);
        }
    }

    public void onFail() {
        this.this$0.setDfuState(PairingPresenter.DfuState.DFU_VERIFY_DONE);
        this.this$0.disconnect();
        PairingViewInput access$getAView$p = this.this$0.aView;
        if (access$getAView$p != null) {
            access$getAView$p.onFail(BaseActivityKt.ERROR_INTERNET_CONNECTION_INVALID);
        }
    }
}
