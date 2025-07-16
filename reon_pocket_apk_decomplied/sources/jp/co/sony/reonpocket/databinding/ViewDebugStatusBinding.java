package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;

public final class ViewDebugStatusBinding implements ViewBinding {
    public final TextView clothesHumi;
    public final TextView clothesTemp;
    public final LinearLayout debugStatusViewLinearLayout;
    public final TextView fanOutput;
    public final TextView finTemp;
    public final TextView peltierOutput;
    private final LinearLayout rootView;
    public final TextView tagALS;
    public final TextView tagPS;
    public final TextView tecTemp;

    private ViewDebugStatusBinding(LinearLayout linearLayout, TextView textView, TextView textView2, LinearLayout linearLayout2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.rootView = linearLayout;
        this.clothesHumi = textView;
        this.clothesTemp = textView2;
        this.debugStatusViewLinearLayout = linearLayout2;
        this.fanOutput = textView3;
        this.finTemp = textView4;
        this.peltierOutput = textView5;
        this.tagALS = textView6;
        this.tagPS = textView7;
        this.tecTemp = textView8;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewDebugStatusBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ViewDebugStatusBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_debug_status, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDebugStatusBinding bind(View view) {
        int i = R.id.clothesHumi;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.clothesTemp;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                i = R.id.fan_output;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = R.id.finTemp;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView4 != null) {
                        i = R.id.peltier_output;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView5 != null) {
                            i = R.id.tagALS;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView6 != null) {
                                i = R.id.tagPS;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView7 != null) {
                                    i = R.id.tecTemp;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView8 != null) {
                                        return new ViewDebugStatusBinding(linearLayout, textView, textView2, linearLayout, textView3, textView4, textView5, textView6, textView7, textView8);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
