package jp.co.sony.reonpocket.modules.settings.view;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.util.MyContentUtil;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"jp/co/sony/reonpocket/modules/settings/view/SettingActivity$setOnBackPressedEvent$callback$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SettingActivity.kt */
public final class SettingActivity$setOnBackPressedEvent$callback$1 extends OnBackPressedCallback {
    final /* synthetic */ SettingActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingActivity$setOnBackPressedEvent$callback$1(SettingActivity settingActivity) {
        super(true);
        this.this$0 = settingActivity;
    }

    public void handleOnBackPressed() {
        Fragment findFragmentById = this.this$0.getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (findFragmentById instanceof SettingFragment) {
            this.this$0.setToolbarTitle(R.string.setting_top_title);
            this.this$0.isShowTwitterView(MyContentUtil.INSTANCE.isShowTwitter(this.this$0));
        }
        if (findFragmentById instanceof LegalFragment) {
            this.this$0.setToolbarTitle(R.string.setting_top_legal);
        }
        if (findFragmentById instanceof OssContentFragment) {
            this.this$0.setToolbarTitle(R.string.setting_top_license);
        }
        this.this$0.mIsUserInfo = false;
        this.this$0.invalidateOptionsMenu();
    }
}
