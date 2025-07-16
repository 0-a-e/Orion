package jp.co.sony.reonpocket.modules.main.view;

import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.data.interactor.TagScanInteractor;
import jp.co.sony.reonpocket.modules.main.view.MainActivity;
import jp.co.sony.reonpocket.util.DialogDoubleActionListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"jp/co/sony/reonpocket/modules/main/view/MainActivity$showTagRegisterDialog$1", "Ljp/co/sony/reonpocket/util/DialogDoubleActionListener;", "negativeButtonAction", "", "positiveButtonAction", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainActivity.kt */
public final class MainActivity$showTagRegisterDialog$1 implements DialogDoubleActionListener {
    final /* synthetic */ TagDataEntity $aTagInfo;
    final /* synthetic */ String $aTagModelName;
    final /* synthetic */ String $bdAddress;
    final /* synthetic */ MainActivity this$0;

    MainActivity$showTagRegisterDialog$1(MainActivity mainActivity, String str, TagDataEntity tagDataEntity, String str2) {
        this.this$0 = mainActivity;
        this.$bdAddress = str;
        this.$aTagInfo = tagDataEntity;
        this.$aTagModelName = str2;
    }

    public void positiveButtonAction() {
        this.this$0.isFoundDialogDisplay = false;
        MainActivity.MainViewOutput access$getMOutput$p = this.this$0.mOutput;
        if (access$getMOutput$p != null) {
            access$getMOutput$p.registerTag(this.$bdAddress, this.$aTagInfo, this.$aTagModelName);
        }
        this.this$0.showTagRegisteredDialog(this.$aTagInfo, this.$aTagModelName);
    }

    public void negativeButtonAction() {
        this.this$0.isFoundDialogDisplay = false;
        String serialNo = this.$aTagInfo.getSerialNo();
        if (serialNo == null) {
            serialNo = "";
        }
        MainActivity.MainViewOutput access$getMOutput$p = this.this$0.mOutput;
        if (access$getMOutput$p != null) {
            access$getMOutput$p.setTagScanListener(new TagScanInteractor.TagInfo(this.$aTagModelName, serialNo));
        }
        MainActivity.MainViewOutput access$getMOutput$p2 = this.this$0.mOutput;
        if (access$getMOutput$p2 != null) {
            access$getMOutput$p2.tagScan();
        }
    }
}
