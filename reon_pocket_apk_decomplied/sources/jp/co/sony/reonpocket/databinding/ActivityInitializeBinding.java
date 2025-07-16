package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import jp.co.sony.reonpocket.R;

public final class ActivityInitializeBinding implements ViewBinding {
    public final FrameLayout fragmentContainer;
    private final FrameLayout rootView;

    private ActivityInitializeBinding(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.fragmentContainer = frameLayout2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivityInitializeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityInitializeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_initialize, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityInitializeBinding bind(View view) {
        if (view != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            return new ActivityInitializeBinding(frameLayout, frameLayout);
        }
        throw new NullPointerException("rootView");
    }
}
