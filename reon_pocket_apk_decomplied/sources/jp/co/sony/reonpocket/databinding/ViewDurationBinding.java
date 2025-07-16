package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;

public final class ViewDurationBinding implements ViewBinding {
    public final RecyclerView recyclerView;
    private final LinearLayout rootView;

    private ViewDurationBinding(LinearLayout linearLayout, RecyclerView recyclerView2) {
        this.rootView = linearLayout;
        this.recyclerView = recyclerView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewDurationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ViewDurationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_duration, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDurationBinding bind(View view) {
        int i = R.id.recyclerView;
        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView2 != null) {
            return new ViewDurationBinding((LinearLayout) view, recyclerView2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
