package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import jp.co.sony.reonpocket.R;

public final class ViewPreferenceRibbonBinding implements ViewBinding {
    private final LinearLayout rootView;

    private ViewPreferenceRibbonBinding(LinearLayout linearLayout) {
        this.rootView = linearLayout;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewPreferenceRibbonBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ViewPreferenceRibbonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_preference_ribbon, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewPreferenceRibbonBinding bind(View view) {
        if (view != null) {
            return new ViewPreferenceRibbonBinding((LinearLayout) view);
        }
        throw new NullPointerException("rootView");
    }
}
