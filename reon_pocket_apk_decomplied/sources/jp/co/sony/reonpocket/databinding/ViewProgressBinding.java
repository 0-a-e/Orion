package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.CustomFontTextView;

public final class ViewProgressBinding implements ViewBinding {
    public final CustomFontTextView requestDfuPercent;
    public final ProgressBar requestDfuProgress;
    private final LinearLayout rootView;

    private ViewProgressBinding(LinearLayout linearLayout, CustomFontTextView customFontTextView, ProgressBar progressBar) {
        this.rootView = linearLayout;
        this.requestDfuPercent = customFontTextView;
        this.requestDfuProgress = progressBar;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewProgressBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ViewProgressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_progress, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewProgressBinding bind(View view) {
        int i = R.id.requestDfuPercent;
        CustomFontTextView customFontTextView = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
        if (customFontTextView != null) {
            i = R.id.requestDfuProgress;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
            if (progressBar != null) {
                return new ViewProgressBinding((LinearLayout) view, customFontTextView, progressBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
