package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.CustomFontTextView;

public final class ViewPreferenceDescriptionBinding implements ViewBinding {
    public final CustomFontTextView description;
    public final ImageView imgDescription;
    private final LinearLayout rootView;
    public final CustomFontTextView subDescription;

    private ViewPreferenceDescriptionBinding(LinearLayout linearLayout, CustomFontTextView customFontTextView, ImageView imageView, CustomFontTextView customFontTextView2) {
        this.rootView = linearLayout;
        this.description = customFontTextView;
        this.imgDescription = imageView;
        this.subDescription = customFontTextView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewPreferenceDescriptionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ViewPreferenceDescriptionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_preference_description, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewPreferenceDescriptionBinding bind(View view) {
        int i = R.id.description;
        CustomFontTextView customFontTextView = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
        if (customFontTextView != null) {
            i = R.id.img_description;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.sub_description;
                CustomFontTextView customFontTextView2 = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
                if (customFontTextView2 != null) {
                    return new ViewPreferenceDescriptionBinding((LinearLayout) view, customFontTextView, imageView, customFontTextView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
