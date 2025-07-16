package jp.co.sony.reonpocket.modules.settings.view;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.adapter.GenderSelectAdapter;
import jp.co.sony.reonpocket.view.fragment.BaseDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"jp/co/sony/reonpocket/modules/settings/view/ChangeUserInfoFragment$showListDialog$1", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$DialogFragmentLifecycleListener;", "onViewCreated", "", "aView", "Landroid/view/View;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ChangeUserInfoFragment.kt */
public final class ChangeUserInfoFragment$showListDialog$1 implements BaseDialogFragment.DialogFragmentLifecycleListener {
    final /* synthetic */ ChangeUserInfoFragment this$0;

    ChangeUserInfoFragment$showListDialog$1(ChangeUserInfoFragment changeUserInfoFragment) {
        this.this$0 = changeUserInfoFragment;
    }

    public void onViewCreated(View view) {
        Intrinsics.checkNotNullParameter(view, "aView");
        View findViewById = view.findViewById(R.id.recyclerView);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.this$0.getContext()));
        Context requireContext = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        recyclerView.setAdapter(new GenderSelectAdapter(requireContext, this.this$0.mLastGenderSelectedValue, new ChangeUserInfoFragment$showListDialog$1$onViewCreated$dataSelectAdapter$1(this.this$0)));
    }
}
