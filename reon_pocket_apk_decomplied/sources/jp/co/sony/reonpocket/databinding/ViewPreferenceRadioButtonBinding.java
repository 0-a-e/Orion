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

public final class ViewPreferenceRadioButtonBinding implements ViewBinding {
    public final RadioButton listRadioButton;
    public final CustomFontTextView listTitle;
    private final LinearLayout rootView;

    private ViewPreferenceRadioButtonBinding(LinearLayout linearLayout, RadioButton radioButton, CustomFontTextView customFontTextView) {
        this.rootView = linearLayout;
        this.listRadioButton = radioButton;
        this.listTitle = customFontTextView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewPreferenceRadioButtonBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ViewPreferenceRadioButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_preference_radio_button, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewPreferenceRadioButtonBinding bind(View view) {
        int i = R.id.listRadioButton;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i);
        if (radioButton != null) {
            i = R.id.listTitle;
            CustomFontTextView customFontTextView = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
            if (customFontTextView != null) {
                return new ViewPreferenceRadioButtonBinding((LinearLayout) view, radioButton, customFontTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
