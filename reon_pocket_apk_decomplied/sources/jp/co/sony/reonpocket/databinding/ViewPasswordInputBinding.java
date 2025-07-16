package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;

public final class ViewPasswordInputBinding implements ViewBinding {
    public final EditText etPassword;
    private final LinearLayout rootView;

    private ViewPasswordInputBinding(LinearLayout linearLayout, EditText editText) {
        this.rootView = linearLayout;
        this.etPassword = editText;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewPasswordInputBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ViewPasswordInputBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_password_input, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewPasswordInputBinding bind(View view) {
        int i = R.id.etPassword;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
        if (editText != null) {
            return new ViewPasswordInputBinding((LinearLayout) view, editText);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
