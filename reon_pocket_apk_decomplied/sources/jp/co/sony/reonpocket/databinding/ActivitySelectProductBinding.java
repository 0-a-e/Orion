package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.TagMiniInfoView;

public final class ActivitySelectProductBinding implements ViewBinding {
    public final ScrollView contentFrame;
    public final FrameLayout fragmentContainer;
    private final ConstraintLayout rootView;
    public final TagMiniInfoView tagMiniInfo;

    private ActivitySelectProductBinding(ConstraintLayout constraintLayout, ScrollView scrollView, FrameLayout frameLayout, TagMiniInfoView tagMiniInfoView) {
        this.rootView = constraintLayout;
        this.contentFrame = scrollView;
        this.fragmentContainer = frameLayout;
        this.tagMiniInfo = tagMiniInfoView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySelectProductBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivitySelectProductBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_select_product, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivitySelectProductBinding bind(View view) {
        int i = R.id.contentFrame;
        ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
        if (scrollView != null) {
            i = R.id.fragment_container;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = R.id.tag_mini_info;
                TagMiniInfoView tagMiniInfoView = (TagMiniInfoView) ViewBindings.findChildViewById(view, i);
                if (tagMiniInfoView != null) {
                    return new ActivitySelectProductBinding((ConstraintLayout) view, scrollView, frameLayout, tagMiniInfoView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
