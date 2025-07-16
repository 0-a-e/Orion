package jp.co.sony.reonpocket.modules.pairing.view;

import jp.co.sony.reonpocket.modules.pairing.view.PairingActivity;
import jp.co.sony.reonpocket.util.DialogSingleActionListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"jp/co/sony/reonpocket/modules/pairing/view/PairingActivity$showTagRegisteredDialog$1", "Ljp/co/sony/reonpocket/util/DialogSingleActionListener;", "positiveButtonAction", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PairingActivity.kt */
public final class PairingActivity$showTagRegisteredDialog$1 implements DialogSingleActionListener {
    final /* synthetic */ PairingActivity this$0;

    PairingActivity$showTagRegisteredDialog$1(PairingActivity pairingActivity) {
        this.this$0 = pairingActivity;
    }

    public void positiveButtonAction() {
        this.this$0.startTagScan();
        PairingActivity.PairingViewOutput access$getMOutput$p = this.this$0.mOutput;
        if (access$getMOutput$p != null) {
            access$getMOutput$p.updateDialogStatus(false);
        }
    }
}
