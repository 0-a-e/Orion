package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.tabs.TabLayout;
import jp.co.sony.reonpocket.R;

public final class CommonBaseBinding implements ViewBinding {
    public final NestedScrollView contentFrame;
    private final CoordinatorLayout rootView;
    public final TabLayout tabLayout;
    public final Toolbar toolbar;

    private CommonBaseBinding(CoordinatorLayout coordinatorLayout, NestedScrollView nestedScrollView, TabLayout tabLayout2, Toolbar toolbar2) {
        this.rootView = coordinatorLayout;
        this.contentFrame = nestedScrollView;
        this.tabLayout = tabLayout2;
        this.toolbar = toolbar2;
    }

    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static CommonBaseBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static CommonBaseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.common_base, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CommonBaseBinding bind(View view) {
        int i = R.id.contentFrame;
        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i);
        if (nestedScrollView != null) {
            i = R.id.tabLayout;
            TabLayout tabLayout2 = (TabLayout) ViewBindings.findChildViewById(view, i);
            if (tabLayout2 != null) {
                i = R.id.toolbar;
                Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view, i);
                if (toolbar2 != null) {
                    return new CommonBaseBinding((CoordinatorLayout) view, nestedScrollView, tabLayout2, toolbar2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
