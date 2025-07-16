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

public final class ViewInformationAutoStartBinding implements ViewBinding {
    public final CustomFontButton buttonNegative;
    public final CustomFontButton buttonPositive;
    public final LinearLayout contentView;
    public final CustomFontTextView description;
    public final CustomImageView imageView;
    private final LinearLayout rootView;
    public final CustomFontTextView title;

    private ViewInformationAutoStartBinding(LinearLayout linearLayout, CustomFontButton customFontButton, CustomFontButton customFontButton2, LinearLayout linearLayout2, CustomFontTextView customFontTextView, CustomImageView customImageView, CustomFontTextView customFontTextView2) {
        this.rootView = linearLayout;
        this.buttonNegative = customFontButton;
        this.buttonPositive = customFontButton2;
        this.contentView = linearLayout2;
        this.description = customFontTextView;
        this.imageView = customImageView;
        this.title = customFontTextView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewInformationAutoStartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ViewInformationAutoStartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_information_auto_start, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewInformationAutoStartBinding bind(View view) {
        int i = R.id.button_negative;
        CustomFontButton customFontButton = (CustomFontButton) ViewBindings.findChildViewById(view, i);
        if (customFontButton != null) {
            i = R.id.button_positive;
            CustomFontButton customFontButton2 = (CustomFontButton) ViewBindings.findChildViewById(view, i);
            if (customFontButton2 != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                i = R.id.description;
                CustomFontTextView customFontTextView = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
                if (customFontTextView != null) {
                    i = R.id.image_view;
                    CustomImageView customImageView = (CustomImageView) ViewBindings.findChildViewById(view, i);
                    if (customImageView != null) {
                        i = R.id.title;
                        CustomFontTextView customFontTextView2 = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
                        if (customFontTextView2 != null) {
                            return new ViewInformationAutoStartBinding(linearLayout, customFontButton, customFontButton2, linearLayout, customFontTextView, customImageView, customFontTextView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
