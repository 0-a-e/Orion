package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Switch;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.CustomFontTextView;

public final class ViewPreferenceSwitchBinding implements ViewBinding {
    public final CustomFontTextView listSubTitle;
    public final Switch listSwitch;
    public final CustomFontTextView listTitle;
    private final LinearLayout rootView;

    private ViewPreferenceSwitchBinding(LinearLayout linearLayout, CustomFontTextView customFontTextView, Switch switchR, CustomFontTextView customFontTextView2) {
        this.rootView = linearLayout;
        this.listSubTitle = customFontTextView;
        this.listSwitch = switchR;
        this.listTitle = customFontTextView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewPreferenceSwitchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ViewPreferenceSwitchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_preference_switch, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewPreferenceSwitchBinding bind(View view) {
        int i = R.id.listSubTitle;
        CustomFontTextView customFontTextView = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
        if (customFontTextView != null) {
            i = R.id.listSwitch;
            Switch switchR = (Switch) ViewBindings.findChildViewById(view, i);
            if (switchR != null) {
                i = R.id.listTitle;
                CustomFontTextView customFontTextView2 = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
                if (customFontTextView2 != null) {
                    return new ViewPreferenceSwitchBinding((LinearLayout) view, customFontTextView, switchR, customFontTextView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
