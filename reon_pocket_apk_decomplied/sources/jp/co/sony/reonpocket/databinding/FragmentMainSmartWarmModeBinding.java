package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.CustomFontTextView;
import jp.co.sony.reonpocket.view.TemperatureSurfaceView;

public final class FragmentMainSmartWarmModeBinding implements ViewBinding {
    public final ConstraintLayout coolBottomGroup;
    public final AppCompatButton mainSmartWarmLegacy;
    public final AppCompatButton mainSmartWarmOff;
    public final AppCompatButton mainSmartWarmSetting;
    private final FrameLayout rootView;
    public final FrameLayout scaleView;
    public final TemperatureSurfaceView smartWarmModeIndicator;
    public final ConstraintLayout smartWarmModeOffView;
    public final CustomFontTextView smartWarmModeOffViewDescription;
    public final CustomFontTextView smartWarmModeOffViewTitle;
    public final AppCompatImageButton smartWarmModeStartButton;
    public final TextView toastMsg;
    public final LinearLayout toastPause;

    private FragmentMainSmartWarmModeBinding(FrameLayout frameLayout, ConstraintLayout constraintLayout, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, AppCompatButton appCompatButton3, FrameLayout frameLayout2, TemperatureSurfaceView temperatureSurfaceView, ConstraintLayout constraintLayout2, CustomFontTextView customFontTextView, CustomFontTextView customFontTextView2, AppCompatImageButton appCompatImageButton, TextView textView, LinearLayout linearLayout) {
        this.rootView = frameLayout;
        this.coolBottomGroup = constraintLayout;
        this.mainSmartWarmLegacy = appCompatButton;
        this.mainSmartWarmOff = appCompatButton2;
        this.mainSmartWarmSetting = appCompatButton3;
        this.scaleView = frameLayout2;
        this.smartWarmModeIndicator = temperatureSurfaceView;
        this.smartWarmModeOffView = constraintLayout2;
        this.smartWarmModeOffViewDescription = customFontTextView;
        this.smartWarmModeOffViewTitle = customFontTextView2;
        this.smartWarmModeStartButton = appCompatImageButton;
        this.toastMsg = textView;
        this.toastPause = linearLayout;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentMainSmartWarmModeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentMainSmartWarmModeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_main_smart_warm_mode, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentMainSmartWarmModeBinding bind(View view) {
        View view2 = view;
        int i = R.id.cool_bottom_group;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
        if (constraintLayout != null) {
            i = R.id.main_smart_warm_legacy;
            AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view2, i);
            if (appCompatButton != null) {
                i = R.id.main_smart_warm_off;
                AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view2, i);
                if (appCompatButton2 != null) {
                    i = R.id.main_smart_warm_setting;
                    AppCompatButton appCompatButton3 = (AppCompatButton) ViewBindings.findChildViewById(view2, i);
                    if (appCompatButton3 != null) {
                        i = R.id.scale_view;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, i);
                        if (frameLayout != null) {
                            i = R.id.smart_warm_mode_indicator;
                            TemperatureSurfaceView temperatureSurfaceView = (TemperatureSurfaceView) ViewBindings.findChildViewById(view2, i);
                            if (temperatureSurfaceView != null) {
                                i = R.id.smart_warm_mode_off_view;
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                if (constraintLayout2 != null) {
                                    i = R.id.smart_warm_mode_off_view_description;
                                    CustomFontTextView customFontTextView = (CustomFontTextView) ViewBindings.findChildViewById(view2, i);
                                    if (customFontTextView != null) {
                                        i = R.id.smart_warm_mode_off_view_title;
                                        CustomFontTextView customFontTextView2 = (CustomFontTextView) ViewBindings.findChildViewById(view2, i);
                                        if (customFontTextView2 != null) {
                                            i = R.id.smart_warm_mode_start_button;
                                            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view2, i);
                                            if (appCompatImageButton != null) {
                                                i = R.id.toast_msg;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
                                                if (textView != null) {
                                                    i = R.id.toast_pause;
                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                    if (linearLayout != null) {
                                                        return new FragmentMainSmartWarmModeBinding((FrameLayout) view2, constraintLayout, appCompatButton, appCompatButton2, appCompatButton3, frameLayout, temperatureSurfaceView, constraintLayout2, customFontTextView, customFontTextView2, appCompatImageButton, textView, linearLayout);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
