package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.CustomFontTextView;
import jp.co.sony.reonpocket.view.CustomSlideView;

public final class FragmentMainWarmBinding implements ViewBinding {
    public final ConstraintLayout coolBottomGroup;
    public final AppCompatToggleButton level1ToggleButton;
    public final AppCompatToggleButton level2ToggleButton;
    public final AppCompatToggleButton level3ToggleButton;
    public final LinearLayout level4TextLayout;
    public final AppCompatToggleButton level4ToggleButton;
    public final AppCompatToggleButton mainWarmAuto;
    public final FrameLayout mainWarmAutoSmartLayout;
    public final AppCompatToggleButton mainWarmLeftButtonDummy;
    public final AppCompatButton mainWarmOff;
    public final AppCompatButton mainWarmSmart;
    private final LinearLayout rootView;
    public final LinearLayout warmBackground1;
    public final LinearLayout warmBackground2;
    public final LinearLayout warmBackground3;
    public final LinearLayout warmBackground4;
    public final CustomFontTextView warmCountdown;
    public final FrameLayout warmFrame;
    public final LinearLayout warmLevelContainer;
    public final CustomSlideView warmSlideView;
    public final LinearLayout warmTextContainer;

    private FragmentMainWarmBinding(LinearLayout linearLayout, ConstraintLayout constraintLayout, AppCompatToggleButton appCompatToggleButton, AppCompatToggleButton appCompatToggleButton2, AppCompatToggleButton appCompatToggleButton3, LinearLayout linearLayout2, AppCompatToggleButton appCompatToggleButton4, AppCompatToggleButton appCompatToggleButton5, FrameLayout frameLayout, AppCompatToggleButton appCompatToggleButton6, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, CustomFontTextView customFontTextView, FrameLayout frameLayout2, LinearLayout linearLayout7, CustomSlideView customSlideView, LinearLayout linearLayout8) {
        this.rootView = linearLayout;
        this.coolBottomGroup = constraintLayout;
        this.level1ToggleButton = appCompatToggleButton;
        this.level2ToggleButton = appCompatToggleButton2;
        this.level3ToggleButton = appCompatToggleButton3;
        this.level4TextLayout = linearLayout2;
        this.level4ToggleButton = appCompatToggleButton4;
        this.mainWarmAuto = appCompatToggleButton5;
        this.mainWarmAutoSmartLayout = frameLayout;
        this.mainWarmLeftButtonDummy = appCompatToggleButton6;
        this.mainWarmOff = appCompatButton;
        this.mainWarmSmart = appCompatButton2;
        this.warmBackground1 = linearLayout3;
        this.warmBackground2 = linearLayout4;
        this.warmBackground3 = linearLayout5;
        this.warmBackground4 = linearLayout6;
        this.warmCountdown = customFontTextView;
        this.warmFrame = frameLayout2;
        this.warmLevelContainer = linearLayout7;
        this.warmSlideView = customSlideView;
        this.warmTextContainer = linearLayout8;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentMainWarmBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentMainWarmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_main_warm, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentMainWarmBinding bind(View view) {
        View view2 = view;
        int i = R.id.cool_bottom_group;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
        if (constraintLayout != null) {
            i = R.id.level1_toggle_button;
            AppCompatToggleButton appCompatToggleButton = (AppCompatToggleButton) ViewBindings.findChildViewById(view2, i);
            if (appCompatToggleButton != null) {
                i = R.id.level2_toggle_button;
                AppCompatToggleButton appCompatToggleButton2 = (AppCompatToggleButton) ViewBindings.findChildViewById(view2, i);
                if (appCompatToggleButton2 != null) {
                    i = R.id.level3_toggle_button;
                    AppCompatToggleButton appCompatToggleButton3 = (AppCompatToggleButton) ViewBindings.findChildViewById(view2, i);
                    if (appCompatToggleButton3 != null) {
                        i = R.id.level4_text_layout;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                        if (linearLayout != null) {
                            i = R.id.level4_toggle_button;
                            AppCompatToggleButton appCompatToggleButton4 = (AppCompatToggleButton) ViewBindings.findChildViewById(view2, i);
                            if (appCompatToggleButton4 != null) {
                                i = R.id.main_warm_auto;
                                AppCompatToggleButton appCompatToggleButton5 = (AppCompatToggleButton) ViewBindings.findChildViewById(view2, i);
                                if (appCompatToggleButton5 != null) {
                                    i = R.id.main_warm_auto_smart_layout;
                                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, i);
                                    if (frameLayout != null) {
                                        i = R.id.main_warm_left_button_dummy;
                                        AppCompatToggleButton appCompatToggleButton6 = (AppCompatToggleButton) ViewBindings.findChildViewById(view2, i);
                                        if (appCompatToggleButton6 != null) {
                                            i = R.id.main_warm_off;
                                            AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view2, i);
                                            if (appCompatButton != null) {
                                                i = R.id.main_warm_smart;
                                                AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view2, i);
                                                if (appCompatButton2 != null) {
                                                    i = R.id.warm_background_1;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                    if (linearLayout2 != null) {
                                                        i = R.id.warm_background_2;
                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                        if (linearLayout3 != null) {
                                                            i = R.id.warm_background_3;
                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                            if (linearLayout4 != null) {
                                                                i = R.id.warm_background_4;
                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                                if (linearLayout5 != null) {
                                                                    i = R.id.warm_countdown;
                                                                    CustomFontTextView customFontTextView = (CustomFontTextView) ViewBindings.findChildViewById(view2, i);
                                                                    if (customFontTextView != null) {
                                                                        i = R.id.warm_frame;
                                                                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view2, i);
                                                                        if (frameLayout2 != null) {
                                                                            i = R.id.warm_level_container;
                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                                            if (linearLayout6 != null) {
                                                                                i = R.id.warm_slideView;
                                                                                CustomSlideView customSlideView = (CustomSlideView) ViewBindings.findChildViewById(view2, i);
                                                                                if (customSlideView != null) {
                                                                                    i = R.id.warm_text_container;
                                                                                    LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                                                    if (linearLayout7 != null) {
                                                                                        return new FragmentMainWarmBinding((LinearLayout) view2, constraintLayout, appCompatToggleButton, appCompatToggleButton2, appCompatToggleButton3, linearLayout, appCompatToggleButton4, appCompatToggleButton5, frameLayout, appCompatToggleButton6, appCompatButton, appCompatButton2, linearLayout2, linearLayout3, linearLayout4, linearLayout5, customFontTextView, frameLayout2, linearLayout6, customSlideView, linearLayout7);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
