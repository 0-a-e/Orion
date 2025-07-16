package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;

public final class ViewTimerBinding implements ViewBinding {
    public final NumberPicker numberPicker;
    private final LinearLayout rootView;

    private ViewTimerBinding(LinearLayout linearLayout, NumberPicker numberPicker2) {
        this.rootView = linearLayout;
        this.numberPicker = numberPicker2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewTimerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ViewTimerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_timer, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewTimerBinding bind(View view) {
        int i = R.id.numberPicker;
        NumberPicker numberPicker2 = (NumberPicker) ViewBindings.findChildViewById(view, i);
        if (numberPicker2 != null) {
            return new ViewTimerBinding((LinearLayout) view, numberPicker2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
