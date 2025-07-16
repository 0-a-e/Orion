package jp.co.sony.reonpocket.modules.main.view;

import android.os.CountDownTimer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"jp/co/sony/reonpocket/modules/main/view/MainActivity$showModeChangeProgress$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainActivity.kt */
public final class MainActivity$showModeChangeProgress$1 extends CountDownTimer {
    final /* synthetic */ MainActivity this$0;

    public void onTick(long j) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainActivity$showModeChangeProgress$1(MainActivity mainActivity) {
        super(10000, 1000);
        this.this$0 = mainActivity;
    }

    public void onFinish() {
        this.this$0.hiddenProgress();
    }
}
