package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.CustomFontTextView;

public final class ItemViewDurationBinding implements ViewBinding {
    public final CustomFontTextView duration;
    public final RadioButton radioButton;
    private final LinearLayout rootView;

    private ItemViewDurationBinding(LinearLayout linearLayout, CustomFontTextView customFontTextView, RadioButton radioButton2) {
        this.rootView = linearLayout;
        this.duration = customFontTextView;
        this.radioButton = radioButton2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemViewDurationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemViewDurationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_view_duration, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemViewDurationBinding bind(View view) {
        int i = R.id.duration;
        CustomFontTextView customFontTextView = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
        if (customFontTextView != null) {
            i = R.id.radioButton;
            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, i);
            if (radioButton2 != null) {
                return new ItemViewDurationBinding((LinearLayout) view, customFontTextView, radioButton2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
