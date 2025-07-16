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

public final class FragmentPairingStartBinding implements ViewBinding {
    public final CustomFontTextView description;
    public final CustomFontButton helpGuideBtn;
    public final CustomFontButton pairingStartButton;
    public final ImageView product;
    private final LinearLayout rootView;

    private FragmentPairingStartBinding(LinearLayout linearLayout, CustomFontTextView customFontTextView, CustomFontButton customFontButton, CustomFontButton customFontButton2, ImageView imageView) {
        this.rootView = linearLayout;
        this.description = customFontTextView;
        this.helpGuideBtn = customFontButton;
        this.pairingStartButton = customFontButton2;
        this.product = imageView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentPairingStartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentPairingStartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_pairing_start, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentPairingStartBinding bind(View view) {
        int i = R.id.description;
        CustomFontTextView customFontTextView = (CustomFontTextView) ViewBindings.findChildViewById(view, i);
        if (customFontTextView != null) {
            i = R.id.helpGuideBtn;
            CustomFontButton customFontButton = (CustomFontButton) ViewBindings.findChildViewById(view, i);
            if (customFontButton != null) {
                i = R.id.pairingStartButton;
                CustomFontButton customFontButton2 = (CustomFontButton) ViewBindings.findChildViewById(view, i);
                if (customFontButton2 != null) {
                    i = R.id.product;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        return new FragmentPairingStartBinding((LinearLayout) view, customFontTextView, customFontButton, customFontButton2, imageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
