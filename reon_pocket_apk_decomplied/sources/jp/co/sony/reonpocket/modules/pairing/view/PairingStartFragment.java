package jp.co.sony.reonpocket.modules.pairing.view;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import java.io.Serializable;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.constant.ReonProductType;
import jp.co.sony.reonpocket.databinding.FragmentPairingStartBinding;
import jp.co.sony.reonpocket.modules.base.view.BaseFragment;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.util.PermissionUtil;
import jp.co.sony.reonpocket.view.CustomFontButton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Ljp/co/sony/reonpocket/modules/pairing/view/PairingStartFragment;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment;", "()V", "binding", "Ljp/co/sony/reonpocket/databinding/FragmentPairingStartBinding;", "mIsNextBtnActive", "", "productType", "Ljp/co/sony/reonpocket/constant/ReonProductType;", "changeButtonState", "", "changeHelpGuideBtnState", "aIsActive", "changeNextBtnState", "initUI", "Landroidx/viewbinding/ViewBinding;", "bundle", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onClick", "v", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "onDestroyView", "Companion", "OnPairingStartListener", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PairingStartFragment.kt */
public final class PairingStartFragment extends BaseFragment {
    public static final int $stable = 8;
    private static final String BUNDLE_KEY_PRODUCT_TYPE = "bundle_key_product_type";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private FragmentPairingStartBinding binding;
    private boolean mIsNextBtnActive;
    private ReonProductType productType = ReonProductType.ORIGINAL;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/modules/pairing/view/PairingStartFragment$OnPairingStartListener;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment$Callback;", "onNextHelpGuide", "", "reonProductType", "Ljp/co/sony/reonpocket/constant/ReonProductType;", "onNextStep", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PairingStartFragment.kt */
    public interface OnPairingStartListener extends BaseFragment.Callback {
        void onNextHelpGuide(ReonProductType reonProductType);

        void onNextStep();
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PairingStartFragment.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                jp.co.sony.reonpocket.constant.ReonProductType[] r0 = jp.co.sony.reonpocket.constant.ReonProductType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.ReonProductType r1 = jp.co.sony.reonpocket.constant.ReonProductType.ORIGINAL     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                jp.co.sony.reonpocket.constant.ReonProductType r1 = jp.co.sony.reonpocket.constant.ReonProductType.PRO     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.pairing.view.PairingStartFragment.WhenMappings.<clinit>():void");
        }
    }

    @JvmStatic
    public static final PairingStartFragment newInstance(ReonProductType reonProductType) {
        return Companion.newInstance(reonProductType);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        isShowHomeAsUpButton(true);
        FragmentPairingStartBinding inflate = FragmentPairingStartBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        View.OnClickListener onClickListener = this;
        inflate.pairingStartButton.setOnClickListener(onClickListener);
        inflate.helpGuideBtn.setOnClickListener(onClickListener);
        if (this.mIsNextBtnActive) {
            inflate.pairingStartButton.setEnabled(true);
            inflate.helpGuideBtn.setEnabled(true);
        }
        initUI(inflate, getArguments());
        changeButtonState();
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    private final void initUI(ViewBinding viewBinding, Bundle bundle) {
        Object obj = null;
        if (Build.VERSION.SDK_INT >= 33) {
            if (bundle != null) {
                obj = (ReonProductType) bundle.getSerializable(BUNDLE_KEY_PRODUCT_TYPE, ReonProductType.class);
            }
            obj = (Serializable) obj;
        } else if (bundle != null) {
            obj = bundle.getSerializable(BUNDLE_KEY_PRODUCT_TYPE);
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type jp.co.sony.reonpocket.constant.ReonProductType");
        ReonProductType reonProductType = (ReonProductType) obj;
        this.productType = reonProductType;
        Intrinsics.checkNotNull(viewBinding, "null cannot be cast to non-null type jp.co.sony.reonpocket.databinding.FragmentPairingStartBinding");
        FragmentPairingStartBinding fragmentPairingStartBinding = (FragmentPairingStartBinding) viewBinding;
        int i = WhenMappings.$EnumSwitchMapping$0[reonProductType.ordinal()];
        if (i == 1) {
            setActionBarTitle(R.string.pairing_start_title_original);
            fragmentPairingStartBinding.description.setText(R.string.pairing_start_description_original);
            fragmentPairingStartBinding.product.setImageResource(R.drawable.img_pairing_normal);
        } else if (i == 2) {
            setActionBarTitle(R.string.pairing_start_title_pro);
            fragmentPairingStartBinding.description.setText(R.string.pairing_start_description_pro);
            fragmentPairingStartBinding.product.setImageResource(R.drawable.pairing_img_pro);
        }
    }

    private final void changeButtonState() {
        Context context = getContext();
        if (context != null) {
            boolean isLocationEnabled = PermissionUtil.INSTANCE.isLocationEnabled(context);
            changeNextBtnState(isLocationEnabled);
            changeHelpGuideBtnState(isLocationEnabled);
        }
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (!(context instanceof OnPairingStartListener)) {
            throw new RuntimeException(context + " must implement OnPairingCompleteListener");
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    public void onClick(View view) {
        OnPairingStartListener onPairingStartListener;
        super.onClick(view);
        if (view == null) {
            return;
        }
        if (!isPassedEnoughTime()) {
            DebugLogUtil.INSTANCE.e("Not enough time has passed");
            return;
        }
        int id = view.getId();
        if (id == R.id.pairingStartButton) {
            OnPairingStartListener onPairingStartListener2 = (OnPairingStartListener) getCallback$app_prodRelease();
            if (onPairingStartListener2 != null) {
                onPairingStartListener2.onNextStep();
            }
        } else if (id == R.id.helpGuideBtn && (onPairingStartListener = (OnPairingStartListener) getCallback$app_prodRelease()) != null) {
            onPairingStartListener.onNextHelpGuide(this.productType);
        }
    }

    public final void changeNextBtnState(boolean z) {
        FragmentPairingStartBinding fragmentPairingStartBinding = this.binding;
        CustomFontButton customFontButton = fragmentPairingStartBinding != null ? fragmentPairingStartBinding.pairingStartButton : null;
        if (customFontButton != null) {
            customFontButton.setEnabled(z);
        }
        this.mIsNextBtnActive = z;
    }

    public final void changeHelpGuideBtnState(boolean z) {
        FragmentPairingStartBinding fragmentPairingStartBinding = this.binding;
        CustomFontButton customFontButton = fragmentPairingStartBinding != null ? fragmentPairingStartBinding.helpGuideBtn : null;
        if (customFontButton != null) {
            customFontButton.setEnabled(z);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ljp/co/sony/reonpocket/modules/pairing/view/PairingStartFragment$Companion;", "", "()V", "BUNDLE_KEY_PRODUCT_TYPE", "", "newInstance", "Ljp/co/sony/reonpocket/modules/pairing/view/PairingStartFragment;", "peonProductType", "Ljp/co/sony/reonpocket/constant/ReonProductType;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PairingStartFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PairingStartFragment newInstance(ReonProductType reonProductType) {
            Intrinsics.checkNotNullParameter(reonProductType, "peonProductType");
            PairingStartFragment pairingStartFragment = new PairingStartFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(PairingStartFragment.BUNDLE_KEY_PRODUCT_TYPE, reonProductType);
            pairingStartFragment.setArguments(bundle);
            return pairingStartFragment;
        }
    }
}
