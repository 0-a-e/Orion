package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;

public final class ActivitySettingTopBinding implements ViewBinding {
    public final NestedScrollView contentFrame;
    public final FrameLayout fragmentContainer;
    private final LinearLayout rootView;
    public final Toolbar toolbar;
    public final ViewStub twitterRibbon;

    private ActivitySettingTopBinding(LinearLayout linearLayout, NestedScrollView nestedScrollView, FrameLayout frameLayout, Toolbar toolbar2, ViewStub viewStub) {
        this.rootView = linearLayout;
        this.contentFrame = nestedScrollView;
        this.fragmentContainer = frameLayout;
        this.toolbar = toolbar2;
        this.twitterRibbon = viewStub;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySettingTopBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivitySettingTopBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_setting_top, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivitySettingTopBinding bind(View view) {
        int i = R.id.contentFrame;
        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i);
        if (nestedScrollView != null) {
            i = R.id.fragment_container;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = R.id.toolbar;
                Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view, i);
                if (toolbar2 != null) {
                    i = R.id.twitter_ribbon;
                    ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, i);
                    if (viewStub != null) {
                        return new ActivitySettingTopBinding((LinearLayout) view, nestedScrollView, frameLayout, toolbar2, viewStub);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
