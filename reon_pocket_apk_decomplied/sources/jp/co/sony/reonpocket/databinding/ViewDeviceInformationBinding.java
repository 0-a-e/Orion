package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.CustomFontTextView;
import jp.co.sony.reonpocket.view.CustomImageView;

public final class ViewDeviceInformationBinding implements ViewBinding {
    public final CustomImageView bar;
    public final CustomImageView barFanTemp;
    public final Barrier barrier;
    public final ConstraintLayout content;
    public final CustomFontTextView deviceInfoName;
    public final TextView exhaustTemperatureText;
    public final CustomImageView imgFanTempArrow;
    private final ConstraintLayout rootView;
    public final View separatorLine;
    public final View surfaceColorView;
    public final LinearLayout surfaceTemperatureGraphLayout;
    public final TextView surfaceTemperatureText;

    private ViewDeviceInformationBinding(ConstraintLayout constraintLayout, CustomImageView customImageView, CustomImageView customImageView2, Barrier barrier2, ConstraintLayout constraintLayout2, CustomFontTextView customFontTextView, TextView textView, CustomImageView customImageView3, View view, View view2, LinearLayout linearLayout, TextView textView2) {
        this.rootView = constraintLayout;
        this.bar = customImageView;
        this.barFanTemp = customImageView2;
        this.barrier = barrier2;
        this.content = constraintLayout2;
        this.deviceInfoName = customFontTextView;
        this.exhaustTemperatureText = textView;
        this.imgFanTempArrow = customImageView3;
        this.separatorLine = view;
        this.surfaceColorView = view2;
        this.surfaceTemperatureGraphLayout = linearLayout;
        this.surfaceTemperatureText = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewDeviceInformationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ViewDeviceInformationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_device_information, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004d, code lost:
        r0 = jp.co.sony.reonpocket.R.id.separator_line;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0055, code lost:
        r0 = jp.co.sony.reonpocket.R.id.surface_color_view;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static jp.co.sony.reonpocket.databinding.ViewDeviceInformationBinding bind(android.view.View r15) {
        /*
            int r0 = jp.co.sony.reonpocket.R.id.bar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r4 = r1
            jp.co.sony.reonpocket.view.CustomImageView r4 = (jp.co.sony.reonpocket.view.CustomImageView) r4
            if (r4 == 0) goto L_0x007d
            int r0 = jp.co.sony.reonpocket.R.id.bar_fan_temp
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r5 = r1
            jp.co.sony.reonpocket.view.CustomImageView r5 = (jp.co.sony.reonpocket.view.CustomImageView) r5
            if (r5 == 0) goto L_0x007d
            int r0 = jp.co.sony.reonpocket.R.id.barrier
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r6 = r1
            androidx.constraintlayout.widget.Barrier r6 = (androidx.constraintlayout.widget.Barrier) r6
            if (r6 == 0) goto L_0x007d
            int r0 = jp.co.sony.reonpocket.R.id.content
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r7 = r1
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            if (r7 == 0) goto L_0x007d
            int r0 = jp.co.sony.reonpocket.R.id.device_info_name
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r8 = r1
            jp.co.sony.reonpocket.view.CustomFontTextView r8 = (jp.co.sony.reonpocket.view.CustomFontTextView) r8
            if (r8 == 0) goto L_0x007d
            int r0 = jp.co.sony.reonpocket.R.id.exhaust_temperature_text
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x007d
            int r0 = jp.co.sony.reonpocket.R.id.img_fan_temp_arrow
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r10 = r1
            jp.co.sony.reonpocket.view.CustomImageView r10 = (jp.co.sony.reonpocket.view.CustomImageView) r10
            if (r10 == 0) goto L_0x007d
            int r0 = jp.co.sony.reonpocket.R.id.separator_line
            android.view.View r11 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            if (r11 == 0) goto L_0x007d
            int r0 = jp.co.sony.reonpocket.R.id.surface_color_view
            android.view.View r12 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            if (r12 == 0) goto L_0x007d
            int r0 = jp.co.sony.reonpocket.R.id.surface_temperature_graph_layout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r13 = r1
            android.widget.LinearLayout r13 = (android.widget.LinearLayout) r13
            if (r13 == 0) goto L_0x007d
            int r0 = jp.co.sony.reonpocket.R.id.surface_temperature_text
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r14 = r1
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x007d
            jp.co.sony.reonpocket.databinding.ViewDeviceInformationBinding r0 = new jp.co.sony.reonpocket.databinding.ViewDeviceInformationBinding
            r3 = r15
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r0
        L_0x007d:
            android.content.res.Resources r15 = r15.getResources()
            java.lang.String r15 = r15.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r15 = r1.concat(r15)
            r0.<init>(r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.databinding.ViewDeviceInformationBinding.bind(android.view.View):jp.co.sony.reonpocket.databinding.ViewDeviceInformationBinding");
    }
}
