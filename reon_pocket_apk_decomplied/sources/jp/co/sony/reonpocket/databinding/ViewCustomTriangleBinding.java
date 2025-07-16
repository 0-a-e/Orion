package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;

public final class ViewCustomTriangleBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final View viewSpace;

    private ViewCustomTriangleBinding(ConstraintLayout constraintLayout, View view) {
        this.rootView = constraintLayout;
        this.viewSpace = view;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewCustomTriangleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ViewCustomTriangleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_custom_triangle, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewCustomTriangleBinding bind(View view) {
        int i = R.id.view_space;
        View findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            return new ViewCustomTriangleBinding((ConstraintLayout) view, findChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
