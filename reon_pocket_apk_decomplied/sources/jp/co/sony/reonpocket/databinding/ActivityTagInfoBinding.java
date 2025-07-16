package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;

public final class ActivityTagInfoBinding implements ViewBinding {
    public final NestedScrollView contentFrame;
    public final FrameLayout fragmentContainer;
    private final LinearLayout rootView;

    private ActivityTagInfoBinding(LinearLayout linearLayout, NestedScrollView nestedScrollView, FrameLayout frameLayout) {
        this.rootView = linearLayout;
        this.contentFrame = nestedScrollView;
        this.fragmentContainer = frameLayout;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityTagInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityTagInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_tag_info, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityTagInfoBinding bind(View view) {
        int i = R.id.contentFrame;
        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i);
        if (nestedScrollView != null) {
            i = R.id.fragment_container;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                return new ActivityTagInfoBinding((LinearLayout) view, nestedScrollView, frameLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
