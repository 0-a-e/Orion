package jp.co.sony.reonpocket.modules.connect.view;

import android.view.View;
import android.widget.ProgressBar;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.CustomFontTextView;
import jp.co.sony.reonpocket.view.fragment.BaseDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"jp/co/sony/reonpocket/modules/connect/view/ConnectionActivity$showTagDfuDialog$1", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$DialogFragmentLifecycleListener;", "onViewCreated", "", "aView", "Landroid/view/View;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ConnectionActivity.kt */
public final class ConnectionActivity$showTagDfuDialog$1 implements BaseDialogFragment.DialogFragmentLifecycleListener {
    final /* synthetic */ ConnectionActivity this$0;

    ConnectionActivity$showTagDfuDialog$1(ConnectionActivity connectionActivity) {
        this.this$0 = connectionActivity;
    }

    public void onViewCreated(View view) {
        Intrinsics.checkNotNullParameter(view, "aView");
        this.this$0.mProgressBar = (ProgressBar) view.findViewById(R.id.requestDfuProgress);
        this.this$0.mPercentTextView = (CustomFontTextView) view.findViewById(R.id.requestDfuPercent);
    }
}
