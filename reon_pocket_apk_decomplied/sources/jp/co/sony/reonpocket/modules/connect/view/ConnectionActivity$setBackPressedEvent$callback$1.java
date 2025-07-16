package jp.co.sony.reonpocket.modules.connect.view;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.ActionBar;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.modules.helpGuide.view.HelpGuideFragment;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"jp/co/sony/reonpocket/modules/connect/view/ConnectionActivity$setBackPressedEvent$callback$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ConnectionActivity.kt */
public final class ConnectionActivity$setBackPressedEvent$callback$1 extends OnBackPressedCallback {
    final /* synthetic */ ConnectionActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConnectionActivity$setBackPressedEvent$callback$1(ConnectionActivity connectionActivity) {
        super(true);
        this.this$0 = connectionActivity;
    }

    public void handleOnBackPressed() {
        if (this.this$0.getSupportFragmentManager().findFragmentById(R.id.fragment_container) instanceof HelpGuideFragment) {
            ActionBar access$getMActionBar = this.this$0.getMActionBar();
            if (access$getMActionBar != null) {
                access$getMActionBar.setDisplayShowTitleEnabled(true);
            }
            this.this$0.setNavigationIconStatus(false);
        }
        this.this$0.getSupportFragmentManager().popBackStack((String) null, 1);
    }
}
