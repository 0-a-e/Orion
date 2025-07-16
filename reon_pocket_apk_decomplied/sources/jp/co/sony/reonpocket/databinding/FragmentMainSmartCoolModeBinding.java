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

public final class FragmentMainSmartCoolModeBinding implements ViewBinding {
    public final ConstraintLayout coolBottomGroup;
    public final AppCompatButton mainSmartCoolOff;
    public final AppCompatButton mainSmartCoolSetting;
    public final AppCompatButton mainSmartLegacy;
    private final FrameLayout rootView;
    public final FrameLayout scaleView;
    public final ConstraintLayout smartCoolModeOffView;
    public final AppCompatImageButton smartCoolModeStartButton;
    public final TemperatureSurfaceView smartModeIndicator;
    public final CustomFontTextView smartWarmModeOffViewDescription;
    public final CustomFontTextView smartWarmModeOffViewTitle;
    public final TextView toastMsg;
    public final LinearLayout toastPause;

    private FragmentMainSmartCoolModeBinding(FrameLayout frameLayout, ConstraintLayout constraintLayout, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, AppCompatButton appCompatButton3, FrameLayout frameLayout2, ConstraintLayout constraintLayout2, AppCompatImageButton appCompatImageButton, TemperatureSurfaceView temperatureSurfaceView, CustomFontTextView customFontTextView, CustomFontTextView customFontTextView2, TextView textView, LinearLayout linearLayout) {
        this.rootView = frameLayout;
        this.coolBottomGroup = constraintLayout;
        this.mainSmartCoolOff = appCompatButton;
        this.mainSmartCoolSetting = appCompatButton2;
        this.mainSmartLegacy = appCompatButton3;
        this.scaleView = frameLayout2;
        this.smartCoolModeOffView = constraintLayout2;
        this.smartCoolModeStartButton = appCompatImageButton;
        this.smartModeIndicator = temperatureSurfaceView;
        this.smartWarmModeOffViewDescription = customFontTextView;
        this.smartWarmModeOffViewTitle = customFontTextView2;
        this.toastMsg = textView;
        this.toastPause = linearLayout;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentMainSmartCoolModeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentMainSmartCoolModeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_main_smart_cool_mode, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentMainSmartCoolModeBinding bind(View view) {
        View view2 = view;
        int i = R.id.cool_bottom_group;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
        if (constraintLayout != null) {
            i = R.id.main_smart_cool_off;
            AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view2, i);
            if (appCompatButton != null) {
                i = R.id.main_smart_cool_setting;
                AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view2, i);
                if (appCompatButton2 != null) {
                    i = R.id.main_smart_legacy;
                    AppCompatButton appCompatButton3 = (AppCompatButton) ViewBindings.findChildViewById(view2, i);
                    if (appCompatButton3 != null) {
                        i = R.id.scale_view;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, i);
                        if (frameLayout != null) {
                            i = R.id.smart_cool_mode_off_view;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                            if (constraintLayout2 != null) {
                                i = R.id.smart_cool_mode_start_button;
                                AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view2, i);
                                if (appCompatImageButton != null) {
                                    i = R.id.smart_mode_indicator;
                                    TemperatureSurfaceView temperatureSurfaceView = (TemperatureSurfaceView) ViewBindings.findChildViewById(view2, i);
                                    if (temperatureSurfaceView != null) {
                                        i = R.id.smart_warm_mode_off_view_description;
                                        CustomFontTextView customFontTextView = (CustomFontTextView) ViewBindings.findChildViewById(view2, i);
                                        if (customFontTextView != null) {
                                            i = R.id.smart_warm_mode_off_view_title;
                                            CustomFontTextView customFontTextView2 = (CustomFontTextView) ViewBindings.findChildViewById(view2, i);
                                            if (customFontTextView2 != null) {
                                                i = R.id.toast_msg;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
                                                if (textView != null) {
                                                    i = R.id.toast_pause;
                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                    if (linearLayout != null) {
                                                        return new FragmentMainSmartCoolModeBinding((FrameLayout) view2, constraintLayout, appCompatButton, appCompatButton2, appCompatButton3, frameLayout, constraintLayout2, appCompatImageButton, temperatureSurfaceView, customFontTextView, customFontTextView2, textView, linearLayout);
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
