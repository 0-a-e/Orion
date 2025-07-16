package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import jp.co.sony.reonpocket.R;

public final class ViewProgressingBinding implements ViewBinding {
    private final LinearLayout rootView;

    private ViewProgressingBinding(LinearLayout linearLayout) {
        this.rootView = linearLayout;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewProgressingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ViewProgressingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_progressing, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewProgressingBinding bind(View view) {
        if (view != null) {
            return new ViewProgressingBinding((LinearLayout) view);
        }
        throw new NullPointerException("rootView");
    }
}
