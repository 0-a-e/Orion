package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.CustomFontButton;
import jp.co.sony.reonpocket.view.CustomFontTextView;

public final class ActivityLocationSettingBinding implements ViewBinding {
    public final CustomFontTextView permissionDisabled;
    public final CustomFontTextView permissionEnabled;
    private final LinearLayout rootView;
    public final CustomFontButton transitSetting;

    private ActivityLocationSettingBinding(LinearLayout linearLayout, CustomFontTextView customFontTextView, CustomFontTextView customFontTextView2, CustomFontButton customFontButton) {
        this.rootView = linearLayout;
        this.permissionDisabled = customFontTextView;
        this.permissionEnabled = customFontTextView2;
        this.transitSetting = customFontButton;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityLocationSettingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityLocationSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_location_setting, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityLocationSettingBinding bind(View view) {
        int i = R.id.permission_disabled;
        CustomFontTextView customFontTextView = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
        if (customFontTextView != null) {
            i = R.id.permission_enabled;
            CustomFontTextView customFontTextView2 = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
            if (customFontTextView2 != null) {
                i = R.id.transit_setting;
                CustomFontButton customFontButton = (CustomFontButton) ViewBindings.findChildViewById(view, i);
                if (customFontButton != null) {
                    return new ActivityLocationSettingBinding((LinearLayout) view, customFontTextView, customFontTextView2, customFontButton);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
