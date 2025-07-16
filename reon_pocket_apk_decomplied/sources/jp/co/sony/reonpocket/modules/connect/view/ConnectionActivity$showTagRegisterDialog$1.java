package jp.co.sony.reonpocket.modules.connect.view;

import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.modules.connect.view.ConnectionActivity;
import jp.co.sony.reonpocket.util.DialogDoubleActionListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"jp/co/sony/reonpocket/modules/connect/view/ConnectionActivity$showTagRegisterDialog$1", "Ljp/co/sony/reonpocket/util/DialogDoubleActionListener;", "negativeButtonAction", "", "positiveButtonAction", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ConnectionActivity.kt */
public final class ConnectionActivity$showTagRegisterDialog$1 implements DialogDoubleActionListener {
    final /* synthetic */ ConnectionActivity this$0;

    public void negativeButtonAction() {
    }

    ConnectionActivity$showTagRegisterDialog$1(ConnectionActivity connectionActivity) {
        this.this$0 = connectionActivity;
    }

    public void positiveButtonAction() {
        ConnectionActivity connectionActivity = this.this$0;
        String string = connectionActivity.getString(R.string.common_searching);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        connectionActivity.showProgressDialog(string);
        ConnectionActivity.ConnectionViewOutput access$getMOutput$p = this.this$0.mOutput;
        if (access$getMOutput$p != null) {
            access$getMOutput$p.tagScan();
        }
    }
}
