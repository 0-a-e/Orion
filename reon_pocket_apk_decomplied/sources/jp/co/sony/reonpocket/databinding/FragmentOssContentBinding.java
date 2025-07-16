package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;

public final class FragmentOssContentBinding implements ViewBinding {
    public final LinearLayout licenseHolder;
    private final LinearLayout rootView;

    private FragmentOssContentBinding(LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.licenseHolder = linearLayout2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentOssContentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentOssContentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_oss_content, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentOssContentBinding bind(View view) {
        int i = R.id.license_holder;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            return new FragmentOssContentBinding((LinearLayout) view, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
