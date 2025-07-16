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

public final class FragmentPairingCompleteBinding implements ViewBinding {
    public final CustomFontTextView description;
    public final CustomFontTextView modelName;
    public final CustomFontButton okBtn;
    public final ImageView product;
    private final LinearLayout rootView;

    private FragmentPairingCompleteBinding(LinearLayout linearLayout, CustomFontTextView customFontTextView, CustomFontTextView customFontTextView2, CustomFontButton customFontButton, ImageView imageView) {
        this.rootView = linearLayout;
        this.description = customFontTextView;
        this.modelName = customFontTextView2;
        this.okBtn = customFontButton;
        this.product = imageView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentPairingCompleteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentPairingCompleteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_pairing_complete, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentPairingCompleteBinding bind(View view) {
        int i = R.id.description;
        CustomFontTextView customFontTextView = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
        if (customFontTextView != null) {
            i = R.id.modelName;
            CustomFontTextView customFontTextView2 = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
            if (customFontTextView2 != null) {
                i = R.id.okBtn;
                CustomFontButton customFontButton = (CustomFontButton) ViewBindings.findChildViewById(view, i);
                if (customFontButton != null) {
                    i = R.id.product;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        return new FragmentPairingCompleteBinding((LinearLayout) view, customFontTextView, customFontTextView2, customFontButton, imageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
