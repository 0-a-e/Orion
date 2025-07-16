package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.CustomFontTextView;

public final class ViewDeviceInfoBinding implements ViewBinding {
    public final CustomFontTextView messageTitle;
    private final LinearLayout rootView;

    private ViewDeviceInfoBinding(LinearLayout linearLayout, CustomFontTextView customFontTextView) {
        this.rootView = linearLayout;
        this.messageTitle = customFontTextView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewDeviceInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ViewDeviceInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_device_info, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDeviceInfoBinding bind(View view) {
        int i = R.id.message_title;
        CustomFontTextView customFontTextView = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
        if (customFontTextView != null) {
            return new ViewDeviceInfoBinding((LinearLayout) view, customFontTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
