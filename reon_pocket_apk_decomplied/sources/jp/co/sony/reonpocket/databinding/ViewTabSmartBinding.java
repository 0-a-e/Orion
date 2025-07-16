package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;

public final class ViewTabSmartBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final ImageView tabIcon;

    private ViewTabSmartBinding(LinearLayout linearLayout, ImageView imageView) {
        this.rootView = linearLayout;
        this.tabIcon = imageView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewTabSmartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ViewTabSmartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_tab_smart, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewTabSmartBinding bind(View view) {
        int i = R.id.tab_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            return new ViewTabSmartBinding((LinearLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
