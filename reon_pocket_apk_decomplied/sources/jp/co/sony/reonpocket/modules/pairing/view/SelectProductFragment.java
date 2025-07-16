package jp.co.sony.reonpocket.modules.pairing.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.constant.ReonProductType;
import jp.co.sony.reonpocket.databinding.FragmentSelectProductBinding;
import jp.co.sony.reonpocket.modules.base.view.BaseFragment;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Ljp/co/sony/reonpocket/modules/pairing/view/SelectProductFragment;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment;", "()V", "binding", "Ljp/co/sony/reonpocket/databinding/FragmentSelectProductBinding;", "initUI", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onClick", "v", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "Companion", "OnSelectProductListener", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SelectProductFragment.kt */
public final class SelectProductFragment extends BaseFragment {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private FragmentSelectProductBinding binding;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/modules/pairing/view/SelectProductFragment$OnSelectProductListener;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment$Callback;", "onNextPage", "", "reonProductType", "Ljp/co/sony/reonpocket/constant/ReonProductType;", "requestPermission", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: SelectProductFragment.kt */
    public interface OnSelectProductListener extends BaseFragment.Callback {
        void onNextPage(ReonProductType reonProductType);

        void requestPermission();
    }

    @JvmStatic
    public static final SelectProductFragment newInstance() {
        return Companion.newInstance();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        isShowHomeAsUpButton(false);
        FragmentSelectProductBinding inflate = FragmentSelectProductBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        View.OnClickListener onClickListener = this;
        inflate.originalArea.setOnClickListener(onClickListener);
        inflate.proArea.setOnClickListener(onClickListener);
        initUI();
        ConstraintLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    private final void initUI() {
        setActionBarTitle(R.string.pairing_start_title);
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (!(context instanceof OnSelectProductListener)) {
            throw new RuntimeException(context + " must implement OnSelectProductListener");
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        OnSelectProductListener onSelectProductListener = (OnSelectProductListener) getCallback$app_prodRelease();
        if (onSelectProductListener != null) {
            onSelectProductListener.requestPermission();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    public void onClick(View view) {
        super.onClick(view);
        if (view != null) {
            if (!isPassedEnoughTime()) {
                DebugLogUtil.INSTANCE.e("Not enough time has passed");
                return;
            }
            OnSelectProductListener onSelectProductListener = (OnSelectProductListener) getCallback$app_prodRelease();
            if (onSelectProductListener != null) {
                int id = view.getId();
                if (id == R.id.originalArea) {
                    onSelectProductListener.onNextPage(ReonProductType.ORIGINAL);
                } else if (id == R.id.proArea) {
                    onSelectProductListener.onNextPage(ReonProductType.PRO);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reonpocket/modules/pairing/view/SelectProductFragment$Companion;", "", "()V", "newInstance", "Ljp/co/sony/reonpocket/modules/pairing/view/SelectProductFragment;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: SelectProductFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SelectProductFragment newInstance() {
            return new SelectProductFragment();
        }
    }
}
