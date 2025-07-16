package jp.co.sony.reonpocket.modules.main.view;

import jp.co.sony.reonpocket.util.DialogDoubleActionListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"jp/co/sony/reonpocket/modules/main/view/MainActivity$showTagRegistrationFailedDialog$1", "Ljp/co/sony/reonpocket/util/DialogDoubleActionListener;", "negativeButtonAction", "", "positiveButtonAction", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainActivity.kt */
public final class MainActivity$showTagRegistrationFailedDialog$1 implements DialogDoubleActionListener {
    final /* synthetic */ MainActivity this$0;

    public void negativeButtonAction() {
    }

    MainActivity$showTagRegistrationFailedDialog$1(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    public void positiveButtonAction() {
        this.this$0.showTagRegisterDialog();
    }
}
