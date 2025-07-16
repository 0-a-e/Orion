package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.CustomFontButton;
import jp.co.sony.reonpocket.view.CustomFontTextView;
import jp.co.sony.reonpocket.view.DeviceTemperatureView;

public final class ActivityDeviceInfoBinding implements ViewBinding {
    public final CustomFontButton close;
    public final ViewStub commonLayout;
    public final DeviceTemperatureView deviceTempView;
    public final ViewStub errorLayout;
    public final LinearLayout helpContentLayout;
    public final CustomFontTextView helpInfoContentTitle;
    private final LinearLayout rootView;
    public final CustomFontButton support;

    private ActivityDeviceInfoBinding(LinearLayout linearLayout, CustomFontButton customFontButton, ViewStub viewStub, DeviceTemperatureView deviceTemperatureView, ViewStub viewStub2, LinearLayout linearLayout2, CustomFontTextView customFontTextView, CustomFontButton customFontButton2) {
        this.rootView = linearLayout;
        this.close = customFontButton;
        this.commonLayout = viewStub;
        this.deviceTempView = deviceTemperatureView;
        this.errorLayout = viewStub2;
        this.helpContentLayout = linearLayout2;
        this.helpInfoContentTitle = customFontTextView;
        this.support = customFontButton2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityDeviceInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityDeviceInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_device_info, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityDeviceInfoBinding bind(View view) {
        int i = R.id.close;
        CustomFontButton customFontButton = (CustomFontButton) ViewBindings.findChildViewById(view, i);
        if (customFontButton != null) {
            i = R.id.common_layout;
            ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, i);
            if (viewStub != null) {
                i = R.id.device_temp_view;
                DeviceTemperatureView deviceTemperatureView = (DeviceTemperatureView) ViewBindings.findChildViewById(view, i);
                if (deviceTemperatureView != null) {
                    i = R.id.error_layout;
                    ViewStub viewStub2 = (ViewStub) ViewBindings.findChildViewById(view, i);
                    if (viewStub2 != null) {
                        i = R.id.help_content_layout;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = R.id.help_info_content_title;
                            CustomFontTextView customFontTextView = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
                            if (customFontTextView != null) {
                                i = R.id.support;
                                CustomFontButton customFontButton2 = (CustomFontButton) ViewBindings.findChildViewById(view, i);
                                if (customFontButton2 != null) {
                                    return new ActivityDeviceInfoBinding((LinearLayout) view, customFontButton, viewStub, deviceTemperatureView, viewStub2, linearLayout, customFontTextView, customFontButton2);
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
