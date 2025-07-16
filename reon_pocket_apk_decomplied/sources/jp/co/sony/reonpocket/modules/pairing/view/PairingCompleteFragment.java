package jp.co.sony.reonpocket.modules.pairing.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.data.interactor.DeviceInfoInteractor;
import jp.co.sony.reonpocket.databinding.FragmentPairingCompleteBinding;
import jp.co.sony.reonpocket.modules.base.view.BaseFragment;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.view.CustomFontButton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J$\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Ljp/co/sony/reonpocket/modules/pairing/view/PairingCompleteFragment;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment;", "()V", "binding", "Ljp/co/sony/reonpocket/databinding/FragmentPairingCompleteBinding;", "mModelName", "", "changeOkBtnState", "", "aIsActive", "", "onAttach", "context", "Landroid/content/Context;", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "setProductImage", "Companion", "OnPairingCompleteListener", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PairingCompleteFragment.kt */
public final class PairingCompleteFragment extends BaseFragment {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private FragmentPairingCompleteBinding binding;
    private String mModelName;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Ljp/co/sony/reonpocket/modules/pairing/view/PairingCompleteFragment$OnPairingCompleteListener;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment$Callback;", "onComplete", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PairingCompleteFragment.kt */
    public interface OnPairingCompleteListener extends BaseFragment.Callback {
        void onComplete();
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PairingCompleteFragment.kt */
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
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.pairing.view.PairingCompleteFragment.WhenMappings.<clinit>():void");
        }
    }

    @JvmStatic
    public static final PairingCompleteFragment newInstance(String str) {
        return Companion.newInstance(str);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mModelName = arguments.getString("model_name");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        isShowHomeAsUpButton(false);
        FragmentPairingCompleteBinding inflate = FragmentPairingCompleteBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        inflate.okBtn.setOnClickListener(this);
        inflate.modelName.setText(getString(R.string.pairing_complete_model_name, this.mModelName));
        setProductImage();
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (!(context instanceof OnPairingCompleteListener)) {
            throw new RuntimeException(context + " must implement OnPairingCompleteListener");
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    public void onClick(View view) {
        OnPairingCompleteListener onPairingCompleteListener;
        super.onClick(view);
        if (view == null) {
            return;
        }
        if (!isPassedEnoughTime()) {
            DebugLogUtil.INSTANCE.e("Not enough time has passed");
        } else if (view.getId() == R.id.okBtn && (onPairingCompleteListener = (OnPairingCompleteListener) getCallback$app_prodRelease()) != null) {
            onPairingCompleteListener.onComplete();
        }
    }

    public final void changeOkBtnState(boolean z) {
        FragmentPairingCompleteBinding fragmentPairingCompleteBinding = this.binding;
        CustomFontButton customFontButton = fragmentPairingCompleteBinding != null ? fragmentPairingCompleteBinding.okBtn : null;
        if (customFontButton != null) {
            customFontButton.setEnabled(z);
        }
    }

    private final void setProductImage() {
        ImageView imageView;
        FragmentPairingCompleteBinding fragmentPairingCompleteBinding;
        ImageView imageView2;
        DeviceInfoInteractor deviceInfoInteractor = new DeviceInfoInteractor();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        int i = WhenMappings.$EnumSwitchMapping$0[deviceInfoInteractor.getReonProductType(requireContext).ordinal()];
        if (i == 1) {
            FragmentPairingCompleteBinding fragmentPairingCompleteBinding2 = this.binding;
            if (fragmentPairingCompleteBinding2 != null && (imageView = fragmentPairingCompleteBinding2.product) != null) {
                imageView.setImageResource(R.drawable.img_pairing_complete_normal);
            }
        } else if (i == 2 && (fragmentPairingCompleteBinding = this.binding) != null && (imageView2 = fragmentPairingCompleteBinding.product) != null) {
            imageView2.setImageResource(R.drawable.complete_img_pro);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/modules/pairing/view/PairingCompleteFragment$Companion;", "", "()V", "newInstance", "Ljp/co/sony/reonpocket/modules/pairing/view/PairingCompleteFragment;", "aModelName", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PairingCompleteFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PairingCompleteFragment newInstance(String str) {
            PairingCompleteFragment pairingCompleteFragment = new PairingCompleteFragment();
            if (str != null) {
                Bundle bundle = new Bundle();
                bundle.putString("model_name", str);
                pairingCompleteFragment.setArguments(bundle);
            }
            return pairingCompleteFragment;
        }
    }
}
