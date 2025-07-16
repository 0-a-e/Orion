package jp.co.sony.reonpocket.modules.connect.view;

import jp.co.sony.reonpocket.modules.connect.view.ConnectionActivity;
import jp.co.sony.reonpocket.util.DialogSelectActionListener;
import jp.co.sony.reonpocket.view.adapter.SettingItemAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"jp/co/sony/reonpocket/modules/connect/view/ConnectionActivity$showSettingMenuDialog$1", "Ljp/co/sony/reonpocket/util/DialogSelectActionListener;", "Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$SettingListItem;", "itemSelect", "", "item", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ConnectionActivity.kt */
public final class ConnectionActivity$showSettingMenuDialog$1 implements DialogSelectActionListener<SettingItemAdapter.SettingListItem> {
    final /* synthetic */ ConnectionActivity this$0;

    ConnectionActivity$showSettingMenuDialog$1(ConnectionActivity connectionActivity) {
        this.this$0 = connectionActivity;
    }

    public void itemSelect(SettingItemAdapter.SettingListItem settingListItem) {
        Intrinsics.checkNotNullParameter(settingListItem, "item");
        ConnectionActivity.ConnectionViewOutput access$getMOutput$p = this.this$0.mOutput;
        if (access$getMOutput$p != null) {
            access$getMOutput$p.handleSettingMenuTapItem(settingListItem);
        }
    }
}
