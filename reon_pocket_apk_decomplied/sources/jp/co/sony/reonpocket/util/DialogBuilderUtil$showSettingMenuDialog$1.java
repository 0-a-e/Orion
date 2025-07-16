package jp.co.sony.reonpocket.util;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.adapter.SettingItemAdapter;
import jp.co.sony.reonpocket.view.fragment.BaseDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"jp/co/sony/reonpocket/util/DialogBuilderUtil$showSettingMenuDialog$1", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$DialogFragmentLifecycleListener;", "onViewCreated", "", "aView", "Landroid/view/View;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DialogBuilderUtil.kt */
public final class DialogBuilderUtil$showSettingMenuDialog$1 implements BaseDialogFragment.DialogFragmentLifecycleListener {
    final /* synthetic */ FragmentActivity $aActivity;
    final /* synthetic */ DialogSelectActionListener<SettingItemAdapter.SettingListItem> $callback;

    DialogBuilderUtil$showSettingMenuDialog$1(FragmentActivity fragmentActivity, DialogSelectActionListener<SettingItemAdapter.SettingListItem> dialogSelectActionListener) {
        this.$aActivity = fragmentActivity;
        this.$callback = dialogSelectActionListener;
    }

    public void onViewCreated(View view) {
        Intrinsics.checkNotNullParameter(view, "aView");
        View findViewById = view.findViewById(R.id.recyclerView);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.$aActivity));
        recyclerView.setAdapter(new SettingItemAdapter(SettingItemAdapter.Companion.getMenuPopupList(this.$aActivity), new DialogBuilderUtil$showSettingMenuDialog$1$onViewCreated$1(this.$callback)));
    }
}
