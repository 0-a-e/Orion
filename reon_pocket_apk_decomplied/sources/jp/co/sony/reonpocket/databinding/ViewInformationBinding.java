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

public final class ViewInformationBinding implements ViewBinding {
    public final LinearLayout contentView;
    public final CustomFontTextView description;
    public final ImageView imageView;
    private final LinearLayout rootView;
    public final CustomFontTextView subtitle;
    public final CustomFontTextView url;

    private ViewInformationBinding(LinearLayout linearLayout, LinearLayout linearLayout2, CustomFontTextView customFontTextView, ImageView imageView2, CustomFontTextView customFontTextView2, CustomFontTextView customFontTextView3) {
        this.rootView = linearLayout;
        this.contentView = linearLayout2;
        this.description = customFontTextView;
        this.imageView = imageView2;
        this.subtitle = customFontTextView2;
        this.url = customFontTextView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewInformationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ViewInformationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_information, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewInformationBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.description;
        CustomFontTextView customFontTextView = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
        if (customFontTextView != null) {
            i = R.id.image_view;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.subtitle;
                CustomFontTextView customFontTextView2 = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
                if (customFontTextView2 != null) {
                    i = R.id.url;
                    CustomFontTextView customFontTextView3 = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
                    if (customFontTextView3 != null) {
                        return new ViewInformationBinding(linearLayout, linearLayout, customFontTextView, imageView2, customFontTextView2, customFontTextView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
