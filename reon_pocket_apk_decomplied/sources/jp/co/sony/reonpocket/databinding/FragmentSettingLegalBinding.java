package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;

public final class FragmentSettingLegalBinding implements ViewBinding {
    public final RecyclerView legalList;
    private final LinearLayout rootView;

    private FragmentSettingLegalBinding(LinearLayout linearLayout, RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.legalList = recyclerView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSettingLegalBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentSettingLegalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_setting_legal, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentSettingLegalBinding bind(View view) {
        int i = R.id.legal_list;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            return new FragmentSettingLegalBinding((LinearLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
