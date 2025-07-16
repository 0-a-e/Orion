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
import jp.co.sony.reonpocket.view.CustomImageView;

public final class ViewDeviceErrorInfoBinding implements ViewBinding {
    public final CustomFontTextView errorDescription;
    public final CustomImageView errorImg;
    public final CustomFontButton errorSupportButton;
    public final CustomFontTextView errorTitle;
    private final LinearLayout rootView;

    private ViewDeviceErrorInfoBinding(LinearLayout linearLayout, CustomFontTextView customFontTextView, CustomImageView customImageView, CustomFontButton customFontButton, CustomFontTextView customFontTextView2) {
        this.rootView = linearLayout;
        this.errorDescription = customFontTextView;
        this.errorImg = customImageView;
        this.errorSupportButton = customFontButton;
        this.errorTitle = customFontTextView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewDeviceErrorInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ViewDeviceErrorInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_device_error_info, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDeviceErrorInfoBinding bind(View view) {
        int i = R.id.error_description;
        CustomFontTextView customFontTextView = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
        if (customFontTextView != null) {
            i = R.id.error_img;
            CustomImageView customImageView = (CustomImageView) ViewBindings.findChildViewById(view, i);
            if (customImageView != null) {
                i = R.id.error_support_button;
                CustomFontButton customFontButton = (CustomFontButton) ViewBindings.findChildViewById(view, i);
                if (customFontButton != null) {
                    i = R.id.error_title;
                    CustomFontTextView customFontTextView2 = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
                    if (customFontTextView2 != null) {
                        return new ViewDeviceErrorInfoBinding((LinearLayout) view, customFontTextView, customImageView, customFontButton, customFontTextView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
