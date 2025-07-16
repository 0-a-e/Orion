package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.CustomFontTextView;

public final class ViewInformationEulaUpdatedBinding implements ViewBinding {
    public final LinearLayout contentView;
    public final CustomFontTextView description;
    public final Button okButton;
    private final LinearLayout rootView;
    public final CustomFontTextView subtitle;

    private ViewInformationEulaUpdatedBinding(LinearLayout linearLayout, LinearLayout linearLayout2, CustomFontTextView customFontTextView, Button button, CustomFontTextView customFontTextView2) {
        this.rootView = linearLayout;
        this.contentView = linearLayout2;
        this.description = customFontTextView;
        this.okButton = button;
        this.subtitle = customFontTextView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewInformationEulaUpdatedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ViewInformationEulaUpdatedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_information_eula_updated, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewInformationEulaUpdatedBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.description;
        CustomFontTextView customFontTextView = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
        if (customFontTextView != null) {
            i = R.id.ok_button;
            Button button = (Button) ViewBindings.findChildViewById(view, i);
            if (button != null) {
                i = R.id.subtitle;
                CustomFontTextView customFontTextView2 = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
                if (customFontTextView2 != null) {
                    return new ViewInformationEulaUpdatedBinding(linearLayout, linearLayout, customFontTextView, button, customFontTextView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
