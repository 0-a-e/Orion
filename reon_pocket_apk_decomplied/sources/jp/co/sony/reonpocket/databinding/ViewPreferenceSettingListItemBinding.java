package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.CustomFontTextView;

public final class ViewPreferenceSettingListItemBinding implements ViewBinding {
    public final LinearLayout contentLayout;
    public final ImageView rightIcon;
    private final ConstraintLayout rootView;
    public final CustomFontTextView summary;
    public final CustomFontTextView title;

    private ViewPreferenceSettingListItemBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, ImageView imageView, CustomFontTextView customFontTextView, CustomFontTextView customFontTextView2) {
        this.rootView = constraintLayout;
        this.contentLayout = linearLayout;
        this.rightIcon = imageView;
        this.summary = customFontTextView;
        this.title = customFontTextView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewPreferenceSettingListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ViewPreferenceSettingListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_preference_setting_list_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewPreferenceSettingListItemBinding bind(View view) {
        int i = R.id.content_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.right_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.summary;
                CustomFontTextView customFontTextView = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
                if (customFontTextView != null) {
                    i = R.id.title;
                    CustomFontTextView customFontTextView2 = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
                    if (customFontTextView2 != null) {
                        return new ViewPreferenceSettingListItemBinding((ConstraintLayout) view, linearLayout, imageView, customFontTextView, customFontTextView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
