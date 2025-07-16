package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import androidx.viewbinding.ViewBinding;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.CustomFontButton;
import jp.co.sony.reonpocket.view.CustomFontTextView;

public final class FragmentSmartSettingButtonSwitchBinding implements ViewBinding {
    public final CustomFontButton doSetting;
    public final NumberPicker numberPicker;
    private final LinearLayout rootView;
    public final Button smartCoolSettingButton;
    public final LinearLayout smartSettingButton;
    public final CustomFontTextView smartSettingDesc;
    public final View smartSettingSpace;
    public final Button smartWarmSettingButton;

    private FragmentSmartSettingButtonSwitchBinding(LinearLayout linearLayout, CustomFontButton customFontButton, NumberPicker numberPicker2, Button button, LinearLayout linearLayout2, CustomFontTextView customFontTextView, View view, Button button2) {
        this.rootView = linearLayout;
        this.doSetting = customFontButton;
        this.numberPicker = numberPicker2;
        this.smartCoolSettingButton = button;
        this.smartSettingButton = linearLayout2;
        this.smartSettingDesc = customFontTextView;
        this.smartSettingSpace = view;
        this.smartWarmSettingButton = button2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSmartSettingButtonSwitchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentSmartSettingButtonSwitchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_smart_setting_button_switch, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        r0 = jp.co.sony.reonpocket.R.id.smart_setting_space;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static jp.co.sony.reonpocket.databinding.FragmentSmartSettingButtonSwitchBinding bind(android.view.View r11) {
        /*
            int r0 = jp.co.sony.reonpocket.R.id.do_setting
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r4 = r1
            jp.co.sony.reonpocket.view.CustomFontButton r4 = (jp.co.sony.reonpocket.view.CustomFontButton) r4
            if (r4 == 0) goto L_0x0054
            int r0 = jp.co.sony.reonpocket.R.id.numberPicker
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r5 = r1
            android.widget.NumberPicker r5 = (android.widget.NumberPicker) r5
            if (r5 == 0) goto L_0x0054
            int r0 = jp.co.sony.reonpocket.R.id.smart_cool_setting_button
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r6 = r1
            android.widget.Button r6 = (android.widget.Button) r6
            if (r6 == 0) goto L_0x0054
            int r0 = jp.co.sony.reonpocket.R.id.smart_setting_button
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r7 = r1
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            if (r7 == 0) goto L_0x0054
            int r0 = jp.co.sony.reonpocket.R.id.smart_setting_desc
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r8 = r1
            jp.co.sony.reonpocket.view.CustomFontTextView r8 = (jp.co.sony.reonpocket.view.CustomFontTextView) r8
            if (r8 == 0) goto L_0x0054
            int r0 = jp.co.sony.reonpocket.R.id.smart_setting_space
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r9 == 0) goto L_0x0054
            int r0 = jp.co.sony.reonpocket.R.id.smart_warm_setting_button
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r10 = r1
            android.widget.Button r10 = (android.widget.Button) r10
            if (r10 == 0) goto L_0x0054
            jp.co.sony.reonpocket.databinding.FragmentSmartSettingButtonSwitchBinding r0 = new jp.co.sony.reonpocket.databinding.FragmentSmartSettingButtonSwitchBinding
            r3 = r11
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        L_0x0054:
            android.content.res.Resources r11 = r11.getResources()
            java.lang.String r11 = r11.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.databinding.FragmentSmartSettingButtonSwitchBinding.bind(android.view.View):jp.co.sony.reonpocket.databinding.FragmentSmartSettingButtonSwitchBinding");
    }
}
