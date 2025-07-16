package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.CustomFontTextView;
import jp.co.sony.reonpocket.view.CustomImageView;

public final class ViewHelpGuideBinding implements ViewBinding {
    public final CustomFontTextView helpGuideDescription;
    public final CustomImageView helpGuideImage;
    public final CustomFontTextView helpGuideTitle;
    private final FrameLayout rootView;

    private ViewHelpGuideBinding(FrameLayout frameLayout, CustomFontTextView customFontTextView, CustomImageView customImageView, CustomFontTextView customFontTextView2) {
        this.rootView = frameLayout;
        this.helpGuideDescription = customFontTextView;
        this.helpGuideImage = customImageView;
        this.helpGuideTitle = customFontTextView2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ViewHelpGuideBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ViewHelpGuideBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_help_guide, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewHelpGuideBinding bind(View view) {
        int i = R.id.help_guide_description;
        CustomFontTextView customFontTextView = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
        if (customFontTextView != null) {
            i = R.id.help_guide_image;
            CustomImageView customImageView = (CustomImageView) ViewBindings.findChildViewById(view, i);
            if (customImageView != null) {
                i = R.id.help_guide_title;
                CustomFontTextView customFontTextView2 = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
                if (customFontTextView2 != null) {
                    return new ViewHelpGuideBinding((FrameLayout) view, customFontTextView, customImageView, customFontTextView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
