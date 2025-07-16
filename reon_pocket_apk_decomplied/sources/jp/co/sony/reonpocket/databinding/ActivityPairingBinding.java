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
import jp.co.sony.reonpocket.view.TagMiniInfoView;

public final class ActivityPairingBinding implements ViewBinding {
    public final NestedScrollView contentFrame;
    public final FrameLayout fragmentContainer;
    private final LinearLayout rootView;
    public final TagMiniInfoView tagMiniInfo;

    private ActivityPairingBinding(LinearLayout linearLayout, NestedScrollView nestedScrollView, FrameLayout frameLayout, TagMiniInfoView tagMiniInfoView) {
        this.rootView = linearLayout;
        this.contentFrame = nestedScrollView;
        this.fragmentContainer = frameLayout;
        this.tagMiniInfo = tagMiniInfoView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPairingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityPairingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_pairing, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityPairingBinding bind(View view) {
        int i = R.id.contentFrame;
        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i);
        if (nestedScrollView != null) {
            i = R.id.fragment_container;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = R.id.tag_mini_info;
                TagMiniInfoView tagMiniInfoView = (TagMiniInfoView) ViewBindings.findChildViewById(view, i);
                if (tagMiniInfoView != null) {
                    return new ActivityPairingBinding((LinearLayout) view, nestedScrollView, frameLayout, tagMiniInfoView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
