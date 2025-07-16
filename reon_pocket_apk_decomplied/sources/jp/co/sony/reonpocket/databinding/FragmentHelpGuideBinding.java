package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.CustomFontTextView;

public final class FragmentHelpGuideBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final CustomFontTextView supportDescription;
    public final CustomFontTextView supportTitle;

    private FragmentHelpGuideBinding(LinearLayout linearLayout, CustomFontTextView customFontTextView, CustomFontTextView customFontTextView2) {
        this.rootView = linearLayout;
        this.supportDescription = customFontTextView;
        this.supportTitle = customFontTextView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHelpGuideBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentHelpGuideBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_help_guide, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentHelpGuideBinding bind(View view) {
        int i = R.id.support_description;
        CustomFontTextView customFontTextView = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
        if (customFontTextView != null) {
            i = R.id.support_title;
            CustomFontTextView customFontTextView2 = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
            if (customFontTextView2 != null) {
                return new FragmentHelpGuideBinding((LinearLayout) view, customFontTextView, customFontTextView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
