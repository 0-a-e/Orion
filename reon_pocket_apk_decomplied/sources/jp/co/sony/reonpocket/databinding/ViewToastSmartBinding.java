package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;

public final class ViewToastSmartBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView toastMsg;

    private ViewToastSmartBinding(LinearLayout linearLayout, TextView textView) {
        this.rootView = linearLayout;
        this.toastMsg = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewToastSmartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ViewToastSmartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_toast_smart, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewToastSmartBinding bind(View view) {
        int i = R.id.toast_msg;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            return new ViewToastSmartBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
