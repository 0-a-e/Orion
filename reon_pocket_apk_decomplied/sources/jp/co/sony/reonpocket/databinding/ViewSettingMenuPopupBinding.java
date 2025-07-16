package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;

public final class ViewSettingMenuPopupBinding implements ViewBinding {
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;

    private ViewSettingMenuPopupBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView2) {
        this.rootView = constraintLayout;
        this.recyclerView = recyclerView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewSettingMenuPopupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ViewSettingMenuPopupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_setting_menu_popup, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewSettingMenuPopupBinding bind(View view) {
        int i = R.id.recyclerView;
        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView2 != null) {
            return new ViewSettingMenuPopupBinding((ConstraintLayout) view, recyclerView2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
