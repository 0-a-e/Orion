package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.CustomFontButton;
import jp.co.sony.reonpocket.view.CustomFontTextView;

public final class FragmentWelcomeBinding implements ViewBinding {
    public final CustomFontButton acceptBtn;
    private final LinearLayout rootView;
    public final CheckBox welcomeCheckbox;
    public final CustomFontTextView welcomeConfirm;

    private FragmentWelcomeBinding(LinearLayout linearLayout, CustomFontButton customFontButton, CheckBox checkBox, CustomFontTextView customFontTextView) {
        this.rootView = linearLayout;
        this.acceptBtn = customFontButton;
        this.welcomeCheckbox = checkBox;
        this.welcomeConfirm = customFontTextView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentWelcomeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentWelcomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_welcome, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentWelcomeBinding bind(View view) {
        int i = R.id.acceptBtn;
        CustomFontButton customFontButton = (CustomFontButton) ViewBindings.findChildViewById(view, i);
        if (customFontButton != null) {
            i = R.id.welcome_checkbox;
            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
            if (checkBox != null) {
                i = R.id.welcome_confirm;
                CustomFontTextView customFontTextView = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
                if (customFontTextView != null) {
                    return new FragmentWelcomeBinding((LinearLayout) view, customFontButton, checkBox, customFontTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
