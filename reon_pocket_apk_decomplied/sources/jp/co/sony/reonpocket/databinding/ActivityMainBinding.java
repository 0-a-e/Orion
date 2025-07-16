package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.CustomDebugStatusView;
import jp.co.sony.reonpocket.view.CustomFontTextView;
import jp.co.sony.reonpocket.view.CustomImageView;
import jp.co.sony.reonpocket.view.CustomViewPager;
import jp.co.sony.reonpocket.view.TagMiniInfoView;

public final class ActivityMainBinding implements ViewBinding {
    public final CustomImageView actionAutoStart;
    public final CustomImageView actionBattery;
    public final CustomImageView actionBatteryFull;
    public final CustomFontTextView actionBatteryRemain;
    public final CustomImageView actionCooling;
    public final CustomImageView actionDevice;
    public final CustomImageView actionPlug;
    public final AppCompatImageButton actionSetting;
    public final AppBarLayout appbar;
    public final FrameLayout bottomSheet;
    public final CustomViewPager container;
    public final LinearLayout deviceInfoLayout;
    public final FrameLayout deviceTempView;
    public final FrameLayout mainContent;
    private final FrameLayout rootView;
    public final CustomDebugStatusView statusView;
    public final TabLayout tabs;
    public final TagMiniInfoView tagMiniInfo;
    public final FrameLayout tagMiniInfoWrap;
    public final Toolbar toolbar;

    private ActivityMainBinding(FrameLayout frameLayout, CustomImageView customImageView, CustomImageView customImageView2, CustomImageView customImageView3, CustomFontTextView customFontTextView, CustomImageView customImageView4, CustomImageView customImageView5, CustomImageView customImageView6, AppCompatImageButton appCompatImageButton, AppBarLayout appBarLayout, FrameLayout frameLayout2, CustomViewPager customViewPager, LinearLayout linearLayout, FrameLayout frameLayout3, FrameLayout frameLayout4, CustomDebugStatusView customDebugStatusView, TabLayout tabLayout, TagMiniInfoView tagMiniInfoView, FrameLayout frameLayout5, Toolbar toolbar2) {
        this.rootView = frameLayout;
        this.actionAutoStart = customImageView;
        this.actionBattery = customImageView2;
        this.actionBatteryFull = customImageView3;
        this.actionBatteryRemain = customFontTextView;
        this.actionCooling = customImageView4;
        this.actionDevice = customImageView5;
        this.actionPlug = customImageView6;
        this.actionSetting = appCompatImageButton;
        this.appbar = appBarLayout;
        this.bottomSheet = frameLayout2;
        this.container = customViewPager;
        this.deviceInfoLayout = linearLayout;
        this.deviceTempView = frameLayout3;
        this.mainContent = frameLayout4;
        this.statusView = customDebugStatusView;
        this.tabs = tabLayout;
        this.tagMiniInfo = tagMiniInfoView;
        this.tagMiniInfoWrap = frameLayout5;
        this.toolbar = toolbar2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityMainBinding bind(View view) {
        View view2 = view;
        int i = R.id.action_auto_start;
        CustomImageView customImageView = (CustomImageView) ViewBindings.findChildViewById(view2, i);
        if (customImageView != null) {
            i = R.id.action_battery;
            CustomImageView customImageView2 = (CustomImageView) ViewBindings.findChildViewById(view2, i);
            if (customImageView2 != null) {
                i = R.id.action_battery_full;
                CustomImageView customImageView3 = (CustomImageView) ViewBindings.findChildViewById(view2, i);
                if (customImageView3 != null) {
                    i = R.id.action_battery_remain;
                    CustomFontTextView customFontTextView = (CustomFontTextView) ViewBindings.findChildViewById(view2, i);
                    if (customFontTextView != null) {
                        i = R.id.action_cooling;
                        CustomImageView customImageView4 = (CustomImageView) ViewBindings.findChildViewById(view2, i);
                        if (customImageView4 != null) {
                            i = R.id.action_device;
                            CustomImageView customImageView5 = (CustomImageView) ViewBindings.findChildViewById(view2, i);
                            if (customImageView5 != null) {
                                i = R.id.action_plug;
                                CustomImageView customImageView6 = (CustomImageView) ViewBindings.findChildViewById(view2, i);
                                if (customImageView6 != null) {
                                    i = R.id.action_setting;
                                    AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view2, i);
                                    if (appCompatImageButton != null) {
                                        i = R.id.appbar;
                                        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view2, i);
                                        if (appBarLayout != null) {
                                            i = R.id.bottom_sheet;
                                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, i);
                                            if (frameLayout != null) {
                                                i = R.id.container;
                                                CustomViewPager customViewPager = (CustomViewPager) ViewBindings.findChildViewById(view2, i);
                                                if (customViewPager != null) {
                                                    i = R.id.device_info_layout;
                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                    if (linearLayout != null) {
                                                        i = R.id.device_temp_view;
                                                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view2, i);
                                                        if (frameLayout2 != null) {
                                                            FrameLayout frameLayout3 = (FrameLayout) view2;
                                                            i = R.id.status_view;
                                                            CustomDebugStatusView customDebugStatusView = (CustomDebugStatusView) ViewBindings.findChildViewById(view2, i);
                                                            if (customDebugStatusView != null) {
                                                                i = R.id.tabs;
                                                                TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view2, i);
                                                                if (tabLayout != null) {
                                                                    i = R.id.tag_mini_info;
                                                                    TagMiniInfoView tagMiniInfoView = (TagMiniInfoView) ViewBindings.findChildViewById(view2, i);
                                                                    if (tagMiniInfoView != null) {
                                                                        i = R.id.tag_mini_info_wrap;
                                                                        FrameLayout frameLayout4 = (FrameLayout) ViewBindings.findChildViewById(view2, i);
                                                                        if (frameLayout4 != null) {
                                                                            i = R.id.toolbar;
                                                                            Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view2, i);
                                                                            if (toolbar2 != null) {
                                                                                return new ActivityMainBinding(frameLayout3, customImageView, customImageView2, customImageView3, customFontTextView, customImageView4, customImageView5, customImageView6, appCompatImageButton, appBarLayout, frameLayout, customViewPager, linearLayout, frameLayout2, frameLayout3, customDebugStatusView, tabLayout, tagMiniInfoView, frameLayout4, toolbar2);
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
