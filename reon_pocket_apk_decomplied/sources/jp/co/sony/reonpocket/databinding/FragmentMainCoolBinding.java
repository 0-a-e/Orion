package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.CustomFontTextView;
import jp.co.sony.reonpocket.view.CustomSlideView;

public final class FragmentMainCoolBinding implements ViewBinding {
    public final TextView boostText;
    public final LinearLayout coolBackground1;
    public final LinearLayout coolBackground2;
    public final LinearLayout coolBackground3;
    public final LinearLayout coolBackground4;
    public final LinearLayout coolBackground5;
    public final ConstraintLayout coolBottomGroup;
    public final CustomFontTextView coolCountdown;
    public final FrameLayout coolFrame;
    public final LinearLayout coolLevelContainer;
    public final CustomSlideView coolSlideView;
    public final LinearLayout coolTextContainer;
    public final AppCompatToggleButton level1ToggleButton;
    public final AppCompatToggleButton level2ToggleButton;
    public final AppCompatToggleButton level3ToggleButton;
    public final AppCompatToggleButton level4ToggleButton;
    public final ConstraintLayout level4View;
    public final AppCompatToggleButton level5ToggleButton;
    public final AppCompatToggleButton mainCoolAuto;
    public final FrameLayout mainCoolAutoSmartLayout;
    public final AppCompatButton mainCoolOff;
    public final AppCompatButton mainCoolSmart;
    public final AppCompatToggleButton mainCoolWave;
    private final LinearLayout rootView;

    private FragmentMainCoolBinding(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, ConstraintLayout constraintLayout, CustomFontTextView customFontTextView, FrameLayout frameLayout, LinearLayout linearLayout7, CustomSlideView customSlideView, LinearLayout linearLayout8, AppCompatToggleButton appCompatToggleButton, AppCompatToggleButton appCompatToggleButton2, AppCompatToggleButton appCompatToggleButton3, AppCompatToggleButton appCompatToggleButton4, ConstraintLayout constraintLayout2, AppCompatToggleButton appCompatToggleButton5, AppCompatToggleButton appCompatToggleButton6, FrameLayout frameLayout2, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, AppCompatToggleButton appCompatToggleButton7) {
        this.rootView = linearLayout;
        this.boostText = textView;
        this.coolBackground1 = linearLayout2;
        this.coolBackground2 = linearLayout3;
        this.coolBackground3 = linearLayout4;
        this.coolBackground4 = linearLayout5;
        this.coolBackground5 = linearLayout6;
        this.coolBottomGroup = constraintLayout;
        this.coolCountdown = customFontTextView;
        this.coolFrame = frameLayout;
        this.coolLevelContainer = linearLayout7;
        this.coolSlideView = customSlideView;
        this.coolTextContainer = linearLayout8;
        this.level1ToggleButton = appCompatToggleButton;
        this.level2ToggleButton = appCompatToggleButton2;
        this.level3ToggleButton = appCompatToggleButton3;
        this.level4ToggleButton = appCompatToggleButton4;
        this.level4View = constraintLayout2;
        this.level5ToggleButton = appCompatToggleButton5;
        this.mainCoolAuto = appCompatToggleButton6;
        this.mainCoolAutoSmartLayout = frameLayout2;
        this.mainCoolOff = appCompatButton;
        this.mainCoolSmart = appCompatButton2;
        this.mainCoolWave = appCompatToggleButton7;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentMainCoolBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentMainCoolBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_main_cool, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentMainCoolBinding bind(View view) {
        View view2 = view;
        int i = R.id.boostText;
        TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
        if (textView != null) {
            i = R.id.cool_background_1;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, i);
            if (linearLayout != null) {
                i = R.id.cool_background_2;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                if (linearLayout2 != null) {
                    i = R.id.cool_background_3;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                    if (linearLayout3 != null) {
                        i = R.id.cool_background_4;
                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                        if (linearLayout4 != null) {
                            i = R.id.cool_background_5;
                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                            if (linearLayout5 != null) {
                                i = R.id.cool_bottom_group;
                                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                if (constraintLayout != null) {
                                    i = R.id.cool_countdown;
                                    CustomFontTextView customFontTextView = (CustomFontTextView) ViewBindings.findChildViewById(view2, i);
                                    if (customFontTextView != null) {
                                        i = R.id.cool_frame;
                                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, i);
                                        if (frameLayout != null) {
                                            i = R.id.cool_level_container;
                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                            if (linearLayout6 != null) {
                                                i = R.id.cool_slideView;
                                                CustomSlideView customSlideView = (CustomSlideView) ViewBindings.findChildViewById(view2, i);
                                                if (customSlideView != null) {
                                                    i = R.id.cool_text_container;
                                                    LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                    if (linearLayout7 != null) {
                                                        i = R.id.level1_toggle_button;
                                                        AppCompatToggleButton appCompatToggleButton = (AppCompatToggleButton) ViewBindings.findChildViewById(view2, i);
                                                        if (appCompatToggleButton != null) {
                                                            i = R.id.level2_toggle_button;
                                                            AppCompatToggleButton appCompatToggleButton2 = (AppCompatToggleButton) ViewBindings.findChildViewById(view2, i);
                                                            if (appCompatToggleButton2 != null) {
                                                                i = R.id.level3_toggle_button;
                                                                AppCompatToggleButton appCompatToggleButton3 = (AppCompatToggleButton) ViewBindings.findChildViewById(view2, i);
                                                                if (appCompatToggleButton3 != null) {
                                                                    i = R.id.level4_toggle_button;
                                                                    AppCompatToggleButton appCompatToggleButton4 = (AppCompatToggleButton) ViewBindings.findChildViewById(view2, i);
                                                                    if (appCompatToggleButton4 != null) {
                                                                        i = R.id.level4_view;
                                                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                                                        if (constraintLayout2 != null) {
                                                                            i = R.id.level5_toggle_button;
                                                                            AppCompatToggleButton appCompatToggleButton5 = (AppCompatToggleButton) ViewBindings.findChildViewById(view2, i);
                                                                            if (appCompatToggleButton5 != null) {
                                                                                i = R.id.main_cool_auto;
                                                                                AppCompatToggleButton appCompatToggleButton6 = (AppCompatToggleButton) ViewBindings.findChildViewById(view2, i);
                                                                                if (appCompatToggleButton6 != null) {
                                                                                    i = R.id.main_cool_auto_smart_layout;
                                                                                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view2, i);
                                                                                    if (frameLayout2 != null) {
                                                                                        i = R.id.main_cool_off;
                                                                                        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view2, i);
                                                                                        if (appCompatButton != null) {
                                                                                            i = R.id.main_cool_smart;
                                                                                            AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view2, i);
                                                                                            if (appCompatButton2 != null) {
                                                                                                i = R.id.main_cool_wave;
                                                                                                AppCompatToggleButton appCompatToggleButton7 = (AppCompatToggleButton) ViewBindings.findChildViewById(view2, i);
                                                                                                if (appCompatToggleButton7 != null) {
                                                                                                    return new FragmentMainCoolBinding((LinearLayout) view2, textView, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, constraintLayout, customFontTextView, frameLayout, linearLayout6, customSlideView, linearLayout7, appCompatToggleButton, appCompatToggleButton2, appCompatToggleButton3, appCompatToggleButton4, constraintLayout2, appCompatToggleButton5, appCompatToggleButton6, frameLayout2, appCompatButton, appCompatButton2, appCompatToggleButton7);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
