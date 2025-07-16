package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.CustomFontButton;
import jp.co.sony.reonpocket.view.CustomFontTextView;

public final class FragmentConnectStartBinding implements ViewBinding {
    public final CustomFontButton changeBtn;
    public final CustomFontTextView description;
    public final CustomFontButton nextBtn;
    public final ImageView product;
    private final LinearLayout rootView;

    private FragmentConnectStartBinding(LinearLayout linearLayout, CustomFontButton customFontButton, CustomFontTextView customFontTextView, CustomFontButton customFontButton2, ImageView imageView) {
        this.rootView = linearLayout;
        this.changeBtn = customFontButton;
        this.description = customFontTextView;
        this.nextBtn = customFontButton2;
        this.product = imageView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentConnectStartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentConnectStartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_connect_start, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentConnectStartBinding bind(View view) {
        int i = R.id.changeBtn;
        CustomFontButton customFontButton = (CustomFontButton) ViewBindings.findChildViewById(view, i);
        if (customFontButton != null) {
            i = R.id.description;
            CustomFontTextView customFontTextView = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
            if (customFontTextView != null) {
                i = R.id.nextBtn;
                CustomFontButton customFontButton2 = (CustomFontButton) ViewBindings.findChildViewById(view, i);
                if (customFontButton2 != null) {
                    i = R.id.product;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        return new FragmentConnectStartBinding((LinearLayout) view, customFontButton, customFontTextView, customFontButton2, imageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
