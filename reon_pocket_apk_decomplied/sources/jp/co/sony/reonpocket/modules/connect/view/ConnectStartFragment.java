package jp.co.sony.reonpocket.modules.connect.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.constant.ModelConstant;
import jp.co.sony.reonpocket.constant.ReonProductType;
import jp.co.sony.reonpocket.data.interactor.DeviceInfoInteractor;
import jp.co.sony.reonpocket.databinding.FragmentConnectStartBinding;
import jp.co.sony.reonpocket.modules.base.view.BaseFragment;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.view.CustomFontButton;
import jp.co.sony.reonpocket.view.CustomFontTextView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Ljp/co/sony/reonpocket/modules/connect/view/ConnectStartFragment;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment;", "()V", "binding", "Ljp/co/sony/reonpocket/databinding/FragmentConnectStartBinding;", "changeDescriptionState", "", "aIsConnecting", "", "changeNextBtnState", "aIsVisible", "currentNextBtnState", "getReonProductType", "Ljp/co/sony/reonpocket/constant/ReonProductType;", "initUI", "onAttach", "context", "Landroid/content/Context;", "onClick", "v", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "Companion", "OnConnectStartListener", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ConnectStartFragment.kt */
public final class ConnectStartFragment extends BaseFragment {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private FragmentConnectStartBinding binding;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Ljp/co/sony/reonpocket/modules/connect/view/ConnectStartFragment$OnConnectStartListener;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment$Callback;", "onNextHelpGuide", "", "onNextStep", "onReset", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ConnectStartFragment.kt */
    public interface OnConnectStartListener extends BaseFragment.Callback {
        void onNextHelpGuide();

        void onNextStep();

        void onReset();
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ConnectStartFragment.kt */
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
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.connect.view.ConnectStartFragment.WhenMappings.<clinit>():void");
        }
    }

    @JvmStatic
    public static final ConnectStartFragment newInstance() {
        return Companion.newInstance();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentConnectStartBinding inflate = FragmentConnectStartBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        View.OnClickListener onClickListener = this;
        inflate.nextBtn.setOnClickListener(onClickListener);
        inflate.changeBtn.setOnClickListener(onClickListener);
        changeNextBtnState(true);
        initUI();
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    private final void initUI() {
        ImageView imageView;
        CustomFontTextView customFontTextView;
        ImageView imageView2;
        CustomFontTextView customFontTextView2;
        int i = WhenMappings.$EnumSwitchMapping$0[getReonProductType().ordinal()];
        if (i == 1) {
            FragmentConnectStartBinding fragmentConnectStartBinding = this.binding;
            if (!(fragmentConnectStartBinding == null || (customFontTextView = fragmentConnectStartBinding.description) == null)) {
                customFontTextView.setText(R.string.connect_start_description_original);
            }
            FragmentConnectStartBinding fragmentConnectStartBinding2 = this.binding;
            if (fragmentConnectStartBinding2 != null && (imageView = fragmentConnectStartBinding2.product) != null) {
                imageView.setImageResource(R.drawable.img_pairing_normal);
            }
        } else if (i == 2) {
            FragmentConnectStartBinding fragmentConnectStartBinding3 = this.binding;
            if (!(fragmentConnectStartBinding3 == null || (customFontTextView2 = fragmentConnectStartBinding3.description) == null)) {
                customFontTextView2.setText(R.string.connect_start_description_pro);
            }
            FragmentConnectStartBinding fragmentConnectStartBinding4 = this.binding;
            if (fragmentConnectStartBinding4 != null && (imageView2 = fragmentConnectStartBinding4.product) != null) {
                imageView2.setImageResource(R.drawable.pairing_img_pro);
            }
        }
    }

    private final ReonProductType getReonProductType() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        DeviceInfoInteractor deviceInfoInteractor = new DeviceInfoInteractor();
        Context context = getContext();
        String peripheralName = context != null ? deviceInfoInteractor.getPeripheralName(context) : null;
        if (Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_P1.getModel())) {
            return ReonProductType.PRO;
        }
        boolean z6 = true;
        if (Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_1.getModel())) {
            z = true;
        } else {
            z = Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_1A.getModel());
        }
        if (z) {
            z2 = true;
        } else {
            z2 = Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_1L.getModel());
        }
        if (z2) {
            z3 = true;
        } else {
            z3 = Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_2.getModel());
        }
        if (z3) {
            z4 = true;
        } else {
            z4 = Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_3.getModel());
        }
        if (z4) {
            z5 = true;
        } else {
            z5 = Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_4.getModel());
        }
        if (!z5) {
            z6 = Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_5.getModel());
        }
        if (z6) {
            return ReonProductType.ORIGINAL;
        }
        DebugLogUtil.INSTANCE.e("unknown type");
        return ReonProductType.ORIGINAL;
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (!(context instanceof OnConnectStartListener)) {
            throw new RuntimeException(context + " must implement OnConnectStartListener");
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    public void onClick(View view) {
        OnConnectStartListener onConnectStartListener;
        super.onClick(view);
        if (view == null) {
            return;
        }
        if (!isPassedEnoughTime()) {
            DebugLogUtil.INSTANCE.e("Not enough time has passed");
            return;
        }
        int id = view.getId();
        if (id == R.id.nextBtn) {
            OnConnectStartListener onConnectStartListener2 = (OnConnectStartListener) getCallback$app_prodRelease();
            if (onConnectStartListener2 != null) {
                onConnectStartListener2.onNextStep();
            }
        } else if (id == R.id.changeBtn && (onConnectStartListener = (OnConnectStartListener) getCallback$app_prodRelease()) != null) {
            onConnectStartListener.onReset();
        }
    }

    public final void changeNextBtnState(boolean z) {
        FragmentConnectStartBinding fragmentConnectStartBinding = this.binding;
        CustomFontButton customFontButton = null;
        CustomFontButton customFontButton2 = fragmentConnectStartBinding != null ? fragmentConnectStartBinding.nextBtn : null;
        int i = 0;
        if (customFontButton2 != null) {
            customFontButton2.setVisibility(z ? 0 : 4);
        }
        FragmentConnectStartBinding fragmentConnectStartBinding2 = this.binding;
        if (fragmentConnectStartBinding2 != null) {
            customFontButton = fragmentConnectStartBinding2.changeBtn;
        }
        if (customFontButton != null) {
            if (!z) {
                i = 4;
            }
            customFontButton.setVisibility(i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.nextBtn;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean currentNextBtnState() {
        /*
            r2 = this;
            jp.co.sony.reonpocket.databinding.FragmentConnectStartBinding r0 = r2.binding
            r1 = 0
            if (r0 == 0) goto L_0x0010
            jp.co.sony.reonpocket.view.CustomFontButton r0 = r0.nextBtn
            if (r0 == 0) goto L_0x0010
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0010
            r1 = 1
        L_0x0010:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.connect.view.ConnectStartFragment.currentNextBtnState():boolean");
    }

    public final void changeDescriptionState(boolean z) {
        CharSequence charSequence;
        String str;
        FragmentConnectStartBinding fragmentConnectStartBinding = this.binding;
        CustomFontTextView customFontTextView = fragmentConnectStartBinding != null ? fragmentConnectStartBinding.description : null;
        if (customFontTextView != null) {
            if (z) {
                charSequence = getString(R.string.connect_on_going_description);
            } else {
                int i = WhenMappings.$EnumSwitchMapping$0[getReonProductType().ordinal()];
                if (i == 1) {
                    str = getString(R.string.connect_start_description_original);
                } else if (i == 2) {
                    str = getString(R.string.connect_start_description_pro);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                charSequence = str;
            }
            customFontTextView.setText(charSequence);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reonpocket/modules/connect/view/ConnectStartFragment$Companion;", "", "()V", "newInstance", "Ljp/co/sony/reonpocket/modules/connect/view/ConnectStartFragment;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ConnectStartFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ConnectStartFragment newInstance() {
            return new ConnectStartFragment();
        }
    }
}
