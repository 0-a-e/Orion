package jp.co.sony.reonpocket.modules.settings.view;

import jp.co.sony.reonpocket.modules.settings.view.SettingFragment;
import jp.co.sony.reonpocket.view.adapter.SettingItemAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "item", "Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$SettingListItem;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: SettingFragment.kt */
final class SettingFragment$initUI$3$1 extends Lambda implements Function1<SettingItemAdapter.SettingListItem, Unit> {
    final /* synthetic */ SettingFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingFragment$initUI$3$1(SettingFragment settingFragment) {
        super(1);
        this.this$0 = settingFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SettingItemAdapter.SettingListItem) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SettingItemAdapter.SettingListItem settingListItem) {
        Intrinsics.checkNotNullParameter(settingListItem, "item");
        SettingFragment.OnSettingListener onSettingListener = (SettingFragment.OnSettingListener) this.this$0.getCallback$app_prodRelease();
        if (onSettingListener != null) {
            onSettingListener.onItemSelect(settingListItem);
        }
    }
}
