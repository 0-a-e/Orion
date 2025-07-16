package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.CustomFontTextView;

public final class ViewInformationWithButtonBinding implements ViewBinding {
    public final LinearLayout contentView;
    public final CustomFontTextView description;
    public final ImageView imageView;
    public final AppCompatImageButton infoClose;
    private final LinearLayout rootView;
    public final CustomFontTextView subtitle;
    public final CustomFontTextView title;
    public final CustomFontTextView url;

    private ViewInformationWithButtonBinding(LinearLayout linearLayout, LinearLayout linearLayout2, CustomFontTextView customFontTextView, ImageView imageView2, AppCompatImageButton appCompatImageButton, CustomFontTextView customFontTextView2, CustomFontTextView customFontTextView3, CustomFontTextView customFontTextView4) {
        this.rootView = linearLayout;
        this.contentView = linearLayout2;
        this.description = customFontTextView;
        this.imageView = imageView2;
        this.infoClose = appCompatImageButton;
        this.subtitle = customFontTextView2;
        this.title = customFontTextView3;
        this.url = customFontTextView4;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewInformationWithButtonBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ViewInformationWithButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_information_with_button, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewInformationWithButtonBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.description;
        CustomFontTextView customFontTextView = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
        if (customFontTextView != null) {
            i = R.id.image_view;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.info_close;
                AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
                if (appCompatImageButton != null) {
                    i = R.id.subtitle;
                    CustomFontTextView customFontTextView2 = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
                    if (customFontTextView2 != null) {
                        i = R.id.title;
                        CustomFontTextView customFontTextView3 = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
                        if (customFontTextView3 != null) {
                            i = R.id.url;
                            CustomFontTextView customFontTextView4 = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
                            if (customFontTextView4 != null) {
                                return new ViewInformationWithButtonBinding(linearLayout, linearLayout, customFontTextView, imageView2, appCompatImageButton, customFontTextView2, customFontTextView3, customFontTextView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
