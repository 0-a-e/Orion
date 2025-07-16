package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.CustomFontTextView;

public final class ViewPreferenceListBinding implements ViewBinding {
    public final CustomFontTextView listTitle;
    public final CustomFontTextView listValue;
    private final LinearLayout rootView;

    private ViewPreferenceListBinding(LinearLayout linearLayout, CustomFontTextView customFontTextView, CustomFontTextView customFontTextView2) {
        this.rootView = linearLayout;
        this.listTitle = customFontTextView;
        this.listValue = customFontTextView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewPreferenceListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ViewPreferenceListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_preference_list, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewPreferenceListBinding bind(View view) {
        int i = R.id.listTitle;
        CustomFontTextView customFontTextView = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
        if (customFontTextView != null) {
            i = R.id.listValue;
            CustomFontTextView customFontTextView2 = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
            if (customFontTextView2 != null) {
                return new ViewPreferenceListBinding((LinearLayout) view, customFontTextView, customFontTextView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
