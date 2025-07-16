package jp.co.sony.reonpocket.modules.settings.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.databinding.FragmentSettingLegalBinding;
import jp.co.sony.reonpocket.modules.base.view.BaseFragment;
import jp.co.sony.reonpocket.view.adapter.SettingItemAdapter;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u001b"}, d2 = {"Ljp/co/sony/reonpocket/modules/settings/view/LegalFragment;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment;", "()V", "binding", "Ljp/co/sony/reonpocket/databinding/FragmentSettingLegalBinding;", "mLegalListItems", "", "Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$SettingListItem;", "[Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$SettingListItem;", "initArray", "", "initUI", "Landroidx/viewbinding/ViewBinding;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "Companion", "OnLegalItemSelectListener", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LegalFragment.kt */
public final class LegalFragment extends BaseFragment {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private FragmentSettingLegalBinding binding;
    private SettingItemAdapter.SettingListItem[] mLegalListItems;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Ljp/co/sony/reonpocket/modules/settings/view/LegalFragment$OnLegalItemSelectListener;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment$Callback;", "onLegalItemSelect", "", "item", "Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$SettingListItem;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: LegalFragment.kt */
    public interface OnLegalItemSelectListener extends BaseFragment.Callback {
        void onLegalItemSelect(SettingItemAdapter.SettingListItem settingListItem);
    }

    @JvmStatic
    public static final LegalFragment newInstance() {
        return Companion.newInstance();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reonpocket/modules/settings/view/LegalFragment$Companion;", "", "()V", "newInstance", "Ljp/co/sony/reonpocket/modules/settings/view/LegalFragment;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: LegalFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final LegalFragment newInstance() {
            return new LegalFragment();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        isShowHomeAsUpButton(true);
        FragmentSettingLegalBinding inflate = FragmentSettingLegalBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        initArray();
        initUI(inflate);
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (!(context instanceof OnLegalItemSelectListener)) {
            throw new RuntimeException(context + " must implement OnSettingListener");
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    private final void initUI(ViewBinding viewBinding) {
        setActionBarTitle(R.string.setting_top_legal);
        Intrinsics.checkNotNull(viewBinding, "null cannot be cast to non-null type jp.co.sony.reonpocket.databinding.FragmentSettingLegalBinding");
        RecyclerView recyclerView = ((FragmentSettingLegalBinding) viewBinding).legalList;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "legalList");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        SettingItemAdapter.SettingListItem[] settingListItemArr = this.mLegalListItems;
        if (settingListItemArr != null) {
            recyclerView.setAdapter(new SettingItemAdapter(settingListItemArr, new LegalFragment$initUI$1$1(this)));
        }
    }

    private final void initArray() {
        SettingItemAdapter.SettingItem settingItem = SettingItemAdapter.SettingItem.LICENSE;
        String string = getString(R.string.setting_top_eula);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        SettingItemAdapter.SettingItem settingItem2 = SettingItemAdapter.SettingItem.PRIVACY_POLICY;
        String string2 = getString(R.string.setting_top_privacy_policy);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        SettingItemAdapter.SettingItem settingItem3 = SettingItemAdapter.SettingItem.OPEN_SOURCE;
        String string3 = getString(R.string.setting_top_license);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        this.mLegalListItems = new SettingItemAdapter.SettingListItem[]{new SettingItemAdapter.SettingListItem(settingItem, string, (String) null, (Class) null, false, 16, (DefaultConstructorMarker) null), new SettingItemAdapter.SettingListItem(settingItem2, string2, (String) null, (Class) null, false, 16, (DefaultConstructorMarker) null), new SettingItemAdapter.SettingListItem(settingItem3, string3, (String) null, (Class) null, false, 16, (DefaultConstructorMarker) null)};
    }
}
