package jp.co.sony.reonpocket.modules.pairing.view;

import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.util.DialogDoubleActionListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"jp/co/sony/reonpocket/modules/pairing/view/PairingActivity$showTagFoundDialog$1", "Ljp/co/sony/reonpocket/util/DialogDoubleActionListener;", "negativeButtonAction", "", "positiveButtonAction", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PairingActivity.kt */
public final class PairingActivity$showTagFoundDialog$1 implements DialogDoubleActionListener {
    final /* synthetic */ TagDataEntity $aTagInfo;
    final /* synthetic */ String $aTagModelName;
    final /* synthetic */ Function0<Unit> $positiveCompletion;
    final /* synthetic */ PairingActivity this$0;

    public void negativeButtonAction() {
    }

    PairingActivity$showTagFoundDialog$1(Function0<Unit> function0, PairingActivity pairingActivity, TagDataEntity tagDataEntity, String str) {
        this.$positiveCompletion = function0;
        this.this$0 = pairingActivity;
        this.$aTagInfo = tagDataEntity;
        this.$aTagModelName = str;
    }

    public void positiveButtonAction() {
        this.$positiveCompletion.invoke();
        this.this$0.showTagRegisteredDialog(this.$aTagInfo, this.$aTagModelName);
    }
}
