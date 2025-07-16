package jp.co.sony.reonpocket.modules.main.view;

import android.view.View;
import android.widget.EditText;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.fragment.BaseDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"jp/co/sony/reonpocket/modules/main/view/MainActivity$showPassCheckDialog$2$1", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$DialogFragmentLifecycleListener;", "onViewCreated", "", "aView", "Landroid/view/View;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainActivity.kt */
public final class MainActivity$showPassCheckDialog$2$1 implements BaseDialogFragment.DialogFragmentLifecycleListener {
    final /* synthetic */ MainActivity this$0;

    MainActivity$showPassCheckDialog$2$1(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    public void onViewCreated(View view) {
        Intrinsics.checkNotNullParameter(view, "aView");
        this.this$0.mPasswordEditText = (EditText) view.findViewById(R.id.etPassword);
    }
}
