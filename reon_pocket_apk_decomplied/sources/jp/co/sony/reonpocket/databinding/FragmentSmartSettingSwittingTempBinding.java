package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.CustomFontButton;
import jp.co.sony.reonpocket.view.CustomFontTextView;
import jp.co.sony.reonpocket.view.SmartSettingCoolTempView;
import jp.co.sony.reonpocket.view.SmartSettingWarmTempView;

public final class FragmentSmartSettingSwittingTempBinding implements ViewBinding {
    public final ImageView coachingIcon;
    public final TextView coolTempInitialTextView;
    public final ConstraintLayout coolTempInitialView;
    public final View coolTempInitialViewBar;
    public final SmartSettingCoolTempView coolTempTextView;
    public final TextView coolTempTextViewPop;
    public final CustomFontButton doSetting;
    public final LinearLayout gradeLinearLayout;
    private final LinearLayout rootView;
    public final CustomFontTextView smartSettingDesc;
    public final View smartSettingSpace;
    public final View tempView1;
    public final View tempView2;
    public final View tempView3;
    public final View tempView4;
    public final TextView warmTempInitialTextView;
    public final ConstraintLayout warmTempInitialView;
    public final View warmTempInitialViewBar;
    public final SmartSettingWarmTempView warmTempTextView;
    public final TextView warmTempTextViewPop;

    private FragmentSmartSettingSwittingTempBinding(LinearLayout linearLayout, ImageView imageView, TextView textView, ConstraintLayout constraintLayout, View view, SmartSettingCoolTempView smartSettingCoolTempView, TextView textView2, CustomFontButton customFontButton, LinearLayout linearLayout2, CustomFontTextView customFontTextView, View view2, View view3, View view4, View view5, View view6, TextView textView3, ConstraintLayout constraintLayout2, View view7, SmartSettingWarmTempView smartSettingWarmTempView, TextView textView4) {
        this.rootView = linearLayout;
        this.coachingIcon = imageView;
        this.coolTempInitialTextView = textView;
        this.coolTempInitialView = constraintLayout;
        this.coolTempInitialViewBar = view;
        this.coolTempTextView = smartSettingCoolTempView;
        this.coolTempTextViewPop = textView2;
        this.doSetting = customFontButton;
        this.gradeLinearLayout = linearLayout2;
        this.smartSettingDesc = customFontTextView;
        this.smartSettingSpace = view2;
        this.tempView1 = view3;
        this.tempView2 = view4;
        this.tempView3 = view5;
        this.tempView4 = view6;
        this.warmTempInitialTextView = textView3;
        this.warmTempInitialView = constraintLayout2;
        this.warmTempInitialViewBar = view7;
        this.warmTempTextView = smartSettingWarmTempView;
        this.warmTempTextViewPop = textView4;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSmartSettingSwittingTempBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentSmartSettingSwittingTempBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_smart_setting_switting_temp, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0062, code lost:
        r1 = jp.co.sony.reonpocket.R.id.smart_setting_space;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006a, code lost:
        r1 = jp.co.sony.reonpocket.R.id.temp_view1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0072, code lost:
        r1 = jp.co.sony.reonpocket.R.id.temp_view2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007a, code lost:
        r1 = jp.co.sony.reonpocket.R.id.temp_view3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0082, code lost:
        r1 = jp.co.sony.reonpocket.R.id.temp_view4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a2, code lost:
        r1 = jp.co.sony.reonpocket.R.id.warm_temp_initial_view_bar;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        r1 = jp.co.sony.reonpocket.R.id.cool_temp_initial_view_bar;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static jp.co.sony.reonpocket.databinding.FragmentSmartSettingSwittingTempBinding bind(android.view.View r24) {
        /*
            r0 = r24
            int r1 = jp.co.sony.reonpocket.R.id.coaching_icon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x00cc
            int r1 = jp.co.sony.reonpocket.R.id.cool_temp_initial_text_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x00cc
            int r1 = jp.co.sony.reonpocket.R.id.cool_temp_initial_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            if (r7 == 0) goto L_0x00cc
            int r1 = jp.co.sony.reonpocket.R.id.cool_temp_initial_view_bar
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r8 == 0) goto L_0x00cc
            int r1 = jp.co.sony.reonpocket.R.id.cool_temp_text_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            jp.co.sony.reonpocket.view.SmartSettingCoolTempView r9 = (jp.co.sony.reonpocket.view.SmartSettingCoolTempView) r9
            if (r9 == 0) goto L_0x00cc
            int r1 = jp.co.sony.reonpocket.R.id.cool_temp_text_view_pop
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x00cc
            int r1 = jp.co.sony.reonpocket.R.id.do_setting
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            jp.co.sony.reonpocket.view.CustomFontButton r11 = (jp.co.sony.reonpocket.view.CustomFontButton) r11
            if (r11 == 0) goto L_0x00cc
            int r1 = jp.co.sony.reonpocket.R.id.gradeLinearLayout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
            if (r12 == 0) goto L_0x00cc
            int r1 = jp.co.sony.reonpocket.R.id.smart_setting_desc
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            jp.co.sony.reonpocket.view.CustomFontTextView r13 = (jp.co.sony.reonpocket.view.CustomFontTextView) r13
            if (r13 == 0) goto L_0x00cc
            int r1 = jp.co.sony.reonpocket.R.id.smart_setting_space
            android.view.View r14 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r14 == 0) goto L_0x00cc
            int r1 = jp.co.sony.reonpocket.R.id.temp_view1
            android.view.View r15 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r15 == 0) goto L_0x00cc
            int r1 = jp.co.sony.reonpocket.R.id.temp_view2
            android.view.View r16 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r16 == 0) goto L_0x00cc
            int r1 = jp.co.sony.reonpocket.R.id.temp_view3
            android.view.View r17 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r17 == 0) goto L_0x00cc
            int r1 = jp.co.sony.reonpocket.R.id.temp_view4
            android.view.View r18 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r18 == 0) goto L_0x00cc
            int r1 = jp.co.sony.reonpocket.R.id.warm_temp_initial_text_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00cc
            int r1 = jp.co.sony.reonpocket.R.id.warm_temp_initial_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            androidx.constraintlayout.widget.ConstraintLayout r20 = (androidx.constraintlayout.widget.ConstraintLayout) r20
            if (r20 == 0) goto L_0x00cc
            int r1 = jp.co.sony.reonpocket.R.id.warm_temp_initial_view_bar
            android.view.View r21 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r21 == 0) goto L_0x00cc
            int r1 = jp.co.sony.reonpocket.R.id.warm_temp_text_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            jp.co.sony.reonpocket.view.SmartSettingWarmTempView r22 = (jp.co.sony.reonpocket.view.SmartSettingWarmTempView) r22
            if (r22 == 0) goto L_0x00cc
            int r1 = jp.co.sony.reonpocket.R.id.warm_temp_text_view_pop
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            android.widget.TextView r23 = (android.widget.TextView) r23
            if (r23 == 0) goto L_0x00cc
            jp.co.sony.reonpocket.databinding.FragmentSmartSettingSwittingTempBinding r1 = new jp.co.sony.reonpocket.databinding.FragmentSmartSettingSwittingTempBinding
            r3 = r1
            r4 = r0
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return r1
        L_0x00cc:
            android.content.res.Resources r0 = r24.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.databinding.FragmentSmartSettingSwittingTempBinding.bind(android.view.View):jp.co.sony.reonpocket.databinding.FragmentSmartSettingSwittingTempBinding");
    }
}
