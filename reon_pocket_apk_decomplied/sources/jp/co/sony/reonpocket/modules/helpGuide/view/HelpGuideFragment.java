package jp.co.sony.reonpocket.modules.helpGuide.view;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import java.io.Serializable;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.constant.ReonProductType;
import jp.co.sony.reonpocket.databinding.FragmentHelpGuideBinding;
import jp.co.sony.reonpocket.modules.base.view.BaseFragment;
import jp.co.sony.reonpocket.view.CustomFontTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ljp/co/sony/reonpocket/modules/helpGuide/view/HelpGuideFragment;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment;", "()V", "binding", "Ljp/co/sony/reonpocket/databinding/FragmentHelpGuideBinding;", "changeDescription", "", "Landroidx/viewbinding/ViewBinding;", "bundle", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "onDestroy", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: HelpGuideFragment.kt */
public final class HelpGuideFragment extends BaseFragment {
    public static final int $stable = 8;
    private static final String BUNDLE_KEY_PRODUCT_TYPE = "bundle_key_product_type";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private FragmentHelpGuideBinding binding;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: HelpGuideFragment.kt */
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
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.helpGuide.view.HelpGuideFragment.WhenMappings.<clinit>():void");
        }
    }

    @JvmStatic
    public static final HelpGuideFragment newInstance(ReonProductType reonProductType) {
        return Companion.newInstance(reonProductType);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentHelpGuideBinding inflate = FragmentHelpGuideBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        changeDescription(inflate, getArguments());
        return inflate.getRoot();
    }

    public void onDestroy() {
        super.onDestroy();
        this.binding = null;
    }

    private final void changeDescription(ViewBinding viewBinding, Bundle bundle) {
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
        Intrinsics.checkNotNull(viewBinding, "null cannot be cast to non-null type jp.co.sony.reonpocket.databinding.FragmentHelpGuideBinding");
        FragmentHelpGuideBinding fragmentHelpGuideBinding = (FragmentHelpGuideBinding) viewBinding;
        int i = WhenMappings.$EnumSwitchMapping$0[((ReonProductType) obj).ordinal()];
        if (i == 1) {
            CustomFontTextView customFontTextView = fragmentHelpGuideBinding.supportTitle;
            if (customFontTextView != null) {
                customFontTextView.setText(getString(R.string.pairing_support_title_original));
            }
            CustomFontTextView customFontTextView2 = fragmentHelpGuideBinding.supportDescription;
            if (customFontTextView2 != null) {
                customFontTextView2.setText(getString(R.string.pairing_support_description_original));
            }
        } else if (i == 2) {
            CustomFontTextView customFontTextView3 = fragmentHelpGuideBinding.supportTitle;
            if (customFontTextView3 != null) {
                customFontTextView3.setText(getString(R.string.pairing_support_title_pro));
            }
            CustomFontTextView customFontTextView4 = fragmentHelpGuideBinding.supportDescription;
            if (customFontTextView4 != null) {
                customFontTextView4.setText(getString(R.string.pairing_support_description_pro));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ljp/co/sony/reonpocket/modules/helpGuide/view/HelpGuideFragment$Companion;", "", "()V", "BUNDLE_KEY_PRODUCT_TYPE", "", "newInstance", "Ljp/co/sony/reonpocket/modules/helpGuide/view/HelpGuideFragment;", "peonProductType", "Ljp/co/sony/reonpocket/constant/ReonProductType;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: HelpGuideFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final HelpGuideFragment newInstance(ReonProductType reonProductType) {
            Intrinsics.checkNotNullParameter(reonProductType, "peonProductType");
            HelpGuideFragment helpGuideFragment = new HelpGuideFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(HelpGuideFragment.BUNDLE_KEY_PRODUCT_TYPE, reonProductType);
            helpGuideFragment.setArguments(bundle);
            return helpGuideFragment;
        }
    }
}
