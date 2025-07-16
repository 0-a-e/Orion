package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;

public final class ActivityAutoStartBinding implements ViewBinding {
    public final FrameLayout fragmentContainer;
    private final LinearLayout rootView;

    private ActivityAutoStartBinding(LinearLayout linearLayout, FrameLayout frameLayout) {
        this.rootView = linearLayout;
        this.fragmentContainer = frameLayout;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityAutoStartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityAutoStartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_auto_start, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityAutoStartBinding bind(View view) {
        int i = R.id.fragment_container;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            return new ActivityAutoStartBinding((LinearLayout) view, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
