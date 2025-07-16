package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import androidx.viewbinding.ViewBinding;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.CustomFontButton;
import jp.co.sony.reonpocket.view.CustomFontTextView;

public final class FragmentSmartSettingBinding implements ViewBinding {
    public final CustomFontButton doSetting;
    public final NumberPicker numberPicker;
    private final LinearLayout rootView;
    public final CustomFontTextView smartSettingDesc;
    public final View smartSettingSpace;

    private FragmentSmartSettingBinding(LinearLayout linearLayout, CustomFontButton customFontButton, NumberPicker numberPicker2, CustomFontTextView customFontTextView, View view) {
        this.rootView = linearLayout;
        this.doSetting = customFontButton;
        this.numberPicker = numberPicker2;
        this.smartSettingDesc = customFontTextView;
        this.smartSettingSpace = view;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSmartSettingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentSmartSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_smart_setting, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = jp.co.sony.reonpocket.R.id.smart_setting_space;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static jp.co.sony.reonpocket.databinding.FragmentSmartSettingBinding bind(android.view.View r8) {
        /*
            int r0 = jp.co.sony.reonpocket.R.id.do_setting
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r4 = r1
            jp.co.sony.reonpocket.view.CustomFontButton r4 = (jp.co.sony.reonpocket.view.CustomFontButton) r4
            if (r4 == 0) goto L_0x0033
            int r0 = jp.co.sony.reonpocket.R.id.numberPicker
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r5 = r1
            android.widget.NumberPicker r5 = (android.widget.NumberPicker) r5
            if (r5 == 0) goto L_0x0033
            int r0 = jp.co.sony.reonpocket.R.id.smart_setting_desc
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r6 = r1
            jp.co.sony.reonpocket.view.CustomFontTextView r6 = (jp.co.sony.reonpocket.view.CustomFontTextView) r6
            if (r6 == 0) goto L_0x0033
            int r0 = jp.co.sony.reonpocket.R.id.smart_setting_space
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            if (r7 == 0) goto L_0x0033
            jp.co.sony.reonpocket.databinding.FragmentSmartSettingBinding r0 = new jp.co.sony.reonpocket.databinding.FragmentSmartSettingBinding
            r3 = r8
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            return r0
        L_0x0033:
            android.content.res.Resources r8 = r8.getResources()
            java.lang.String r8 = r8.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r8 = r1.concat(r8)
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.databinding.FragmentSmartSettingBinding.bind(android.view.View):jp.co.sony.reonpocket.databinding.FragmentSmartSettingBinding");
    }
}
