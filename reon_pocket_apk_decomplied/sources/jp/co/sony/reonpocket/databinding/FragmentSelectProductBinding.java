package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.CustomFontTextView;

public final class FragmentSelectProductBinding implements ViewBinding {
    public final LinearLayout originalArea;
    public final CustomFontTextView originalDescription;
    public final LinearLayout proArea;
    public final CustomFontTextView proDescription;
    private final ConstraintLayout rootView;
    public final TextView textView;

    private FragmentSelectProductBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, CustomFontTextView customFontTextView, LinearLayout linearLayout2, CustomFontTextView customFontTextView2, TextView textView2) {
        this.rootView = constraintLayout;
        this.originalArea = linearLayout;
        this.originalDescription = customFontTextView;
        this.proArea = linearLayout2;
        this.proDescription = customFontTextView2;
        this.textView = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSelectProductBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentSelectProductBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_select_product, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentSelectProductBinding bind(View view) {
        int i = R.id.originalArea;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.originalDescription;
            CustomFontTextView customFontTextView = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
            if (customFontTextView != null) {
                i = R.id.proArea;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout2 != null) {
                    i = R.id.proDescription;
                    CustomFontTextView customFontTextView2 = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
                    if (customFontTextView2 != null) {
                        i = R.id.textView;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            return new FragmentSelectProductBinding((ConstraintLayout) view, linearLayout, customFontTextView, linearLayout2, customFontTextView2, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
