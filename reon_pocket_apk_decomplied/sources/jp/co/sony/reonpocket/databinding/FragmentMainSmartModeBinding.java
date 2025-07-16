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

public final class FragmentMainSmartModeBinding implements ViewBinding {
    public final ConstraintLayout coolBottomGroup;
    public final AppCompatButton mainRightButtonDummy;
    public final AppCompatButton mainSmartOff;
    public final AppCompatButton mainSmartSetting;
    private final FrameLayout rootView;
    public final FrameLayout scaleView;
    public final TemperatureSurfaceView smartIndicator;
    public final ConstraintLayout smartModeOffView;
    public final AppCompatImageButton smartModeStartButton;
    public final CustomFontTextView smartWarmModeOffViewDescription;
    public final CustomFontTextView smartWarmModeOffViewTitle;
    public final LinearLayout toastCool;
    public final TextView toastCoolMsg;
    public final LinearLayout toastWarm;
    public final TextView toastWarmMsg;

    private FragmentMainSmartModeBinding(FrameLayout frameLayout, ConstraintLayout constraintLayout, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, AppCompatButton appCompatButton3, FrameLayout frameLayout2, TemperatureSurfaceView temperatureSurfaceView, ConstraintLayout constraintLayout2, AppCompatImageButton appCompatImageButton, CustomFontTextView customFontTextView, CustomFontTextView customFontTextView2, LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, TextView textView2) {
        this.rootView = frameLayout;
        this.coolBottomGroup = constraintLayout;
        this.mainRightButtonDummy = appCompatButton;
        this.mainSmartOff = appCompatButton2;
        this.mainSmartSetting = appCompatButton3;
        this.scaleView = frameLayout2;
        this.smartIndicator = temperatureSurfaceView;
        this.smartModeOffView = constraintLayout2;
        this.smartModeStartButton = appCompatImageButton;
        this.smartWarmModeOffViewDescription = customFontTextView;
        this.smartWarmModeOffViewTitle = customFontTextView2;
        this.toastCool = linearLayout;
        this.toastCoolMsg = textView;
        this.toastWarm = linearLayout2;
        this.toastWarmMsg = textView2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentMainSmartModeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentMainSmartModeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_main_smart_mode, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentMainSmartModeBinding bind(View view) {
        View view2 = view;
        int i = R.id.cool_bottom_group;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
        if (constraintLayout != null) {
            i = R.id.main_right_button_dummy;
            AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view2, i);
            if (appCompatButton != null) {
                i = R.id.main_smart_off;
                AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view2, i);
                if (appCompatButton2 != null) {
                    i = R.id.main_smart_setting;
                    AppCompatButton appCompatButton3 = (AppCompatButton) ViewBindings.findChildViewById(view2, i);
                    if (appCompatButton3 != null) {
                        i = R.id.scale_view;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, i);
                        if (frameLayout != null) {
                            i = R.id.smart_indicator;
                            TemperatureSurfaceView temperatureSurfaceView = (TemperatureSurfaceView) ViewBindings.findChildViewById(view2, i);
                            if (temperatureSurfaceView != null) {
                                i = R.id.smart_mode_off_view;
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                if (constraintLayout2 != null) {
                                    i = R.id.smart_mode_start_button;
                                    AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view2, i);
                                    if (appCompatImageButton != null) {
                                        i = R.id.smart_warm_mode_off_view_description;
                                        CustomFontTextView customFontTextView = (CustomFontTextView) ViewBindings.findChildViewById(view2, i);
                                        if (customFontTextView != null) {
                                            i = R.id.smart_warm_mode_off_view_title;
                                            CustomFontTextView customFontTextView2 = (CustomFontTextView) ViewBindings.findChildViewById(view2, i);
                                            if (customFontTextView2 != null) {
                                                i = R.id.toast_cool;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                if (linearLayout != null) {
                                                    i = R.id.toast_cool_msg;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
                                                    if (textView != null) {
                                                        i = R.id.toast_warm;
                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                        if (linearLayout2 != null) {
                                                            i = R.id.toast_warm_msg;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                            if (textView2 != null) {
                                                                return new FragmentMainSmartModeBinding((FrameLayout) view2, constraintLayout, appCompatButton, appCompatButton2, appCompatButton3, frameLayout, temperatureSurfaceView, constraintLayout2, appCompatImageButton, customFontTextView, customFontTextView2, linearLayout, textView, linearLayout2, textView2);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
