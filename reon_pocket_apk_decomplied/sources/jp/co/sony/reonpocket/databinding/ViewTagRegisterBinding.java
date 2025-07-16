package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.CustomImageView;

public final class ViewTagRegisterBinding implements ViewBinding {
    public final Button negativeButton;
    public final Button positiveButton;
    private final LinearLayout rootView;
    public final CustomImageView tagDialogImage;
    public final TextView tagDialogMessage;
    public final TextView tagDialogModel;
    public final LinearLayout tagDialogModelLayout;
    public final TextView tagDialogSerialNo;
    public final LinearLayout tagDialogSerialNoLayout;
    public final LinearLayout tagDialogSubtitle;
    public final TextView tagDialogTitle;
    public final LinearLayout tagDialogTitleLayout;

    private ViewTagRegisterBinding(LinearLayout linearLayout, Button button, Button button2, CustomImageView customImageView, TextView textView, TextView textView2, LinearLayout linearLayout2, TextView textView3, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView4, LinearLayout linearLayout5) {
        this.rootView = linearLayout;
        this.negativeButton = button;
        this.positiveButton = button2;
        this.tagDialogImage = customImageView;
        this.tagDialogMessage = textView;
        this.tagDialogModel = textView2;
        this.tagDialogModelLayout = linearLayout2;
        this.tagDialogSerialNo = textView3;
        this.tagDialogSerialNoLayout = linearLayout3;
        this.tagDialogSubtitle = linearLayout4;
        this.tagDialogTitle = textView4;
        this.tagDialogTitleLayout = linearLayout5;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewTagRegisterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ViewTagRegisterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_tag_register, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewTagRegisterBinding bind(View view) {
        int i = R.id.negative_button;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.positive_button;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                i = R.id.tag_dialog_image;
                CustomImageView customImageView = (CustomImageView) ViewBindings.findChildViewById(view, i);
                if (customImageView != null) {
                    i = R.id.tag_dialog_message;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.tag_dialog_model;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.tag_dialog_model_layout;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout != null) {
                                i = R.id.tag_dialog_serial_no;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.tag_dialog_serial_no_layout;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout2 != null) {
                                        i = R.id.tag_dialog_subtitle;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout3 != null) {
                                            i = R.id.tag_dialog_title;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView4 != null) {
                                                i = R.id.tag_dialog_title_layout;
                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout4 != null) {
                                                    return new ViewTagRegisterBinding((LinearLayout) view, button, button2, customImageView, textView, textView2, linearLayout, textView3, linearLayout2, linearLayout3, textView4, linearLayout4);
                                                }
                                            }
                                        }
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
