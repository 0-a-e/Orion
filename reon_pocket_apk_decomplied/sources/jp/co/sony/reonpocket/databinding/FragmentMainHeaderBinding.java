package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import jp.co.sony.reonpocket.R;

public final class FragmentMainHeaderBinding implements ViewBinding {
    private final ConstraintLayout rootView;

    private FragmentMainHeaderBinding(ConstraintLayout constraintLayout) {
        this.rootView = constraintLayout;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentMainHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentMainHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_main_header, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentMainHeaderBinding bind(View view) {
        if (view != null) {
            return new FragmentMainHeaderBinding((ConstraintLayout) view);
        }
        throw new NullPointerException("rootView");
    }
}
