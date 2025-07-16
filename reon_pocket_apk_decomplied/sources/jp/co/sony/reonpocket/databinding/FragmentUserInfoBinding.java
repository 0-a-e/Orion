package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.CustomFontButton;

public final class FragmentUserInfoBinding implements ViewBinding {
    public final ViewStub addressItemStub;
    public final ViewStub ageItemStub;
    public final ViewStub genderItemStub;
    public final ViewStub heightItemStub;
    public final CustomFontButton nextBtn;
    private final LinearLayout rootView;
    public final Toolbar toolbar;
    public final LinearLayout userInfoDescription;
    public final ViewStub weightItemStub;

    private FragmentUserInfoBinding(LinearLayout linearLayout, ViewStub viewStub, ViewStub viewStub2, ViewStub viewStub3, ViewStub viewStub4, CustomFontButton customFontButton, Toolbar toolbar2, LinearLayout linearLayout2, ViewStub viewStub5) {
        this.rootView = linearLayout;
        this.addressItemStub = viewStub;
        this.ageItemStub = viewStub2;
        this.genderItemStub = viewStub3;
        this.heightItemStub = viewStub4;
        this.nextBtn = customFontButton;
        this.toolbar = toolbar2;
        this.userInfoDescription = linearLayout2;
        this.weightItemStub = viewStub5;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentUserInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentUserInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_user_info, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentUserInfoBinding bind(View view) {
        int i = R.id.addressItemStub;
        ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, i);
        if (viewStub != null) {
            i = R.id.ageItemStub;
            ViewStub viewStub2 = (ViewStub) ViewBindings.findChildViewById(view, i);
            if (viewStub2 != null) {
                i = R.id.genderItemStub;
                ViewStub viewStub3 = (ViewStub) ViewBindings.findChildViewById(view, i);
                if (viewStub3 != null) {
                    i = R.id.heightItemStub;
                    ViewStub viewStub4 = (ViewStub) ViewBindings.findChildViewById(view, i);
                    if (viewStub4 != null) {
                        i = R.id.nextBtn;
                        CustomFontButton customFontButton = (CustomFontButton) ViewBindings.findChildViewById(view, i);
                        if (customFontButton != null) {
                            i = R.id.toolbar;
                            Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view, i);
                            if (toolbar2 != null) {
                                i = R.id.user_info_description;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null) {
                                    i = R.id.weightItemStub;
                                    ViewStub viewStub5 = (ViewStub) ViewBindings.findChildViewById(view, i);
                                    if (viewStub5 != null) {
                                        return new FragmentUserInfoBinding((LinearLayout) view, viewStub, viewStub2, viewStub3, viewStub4, customFontButton, toolbar2, linearLayout, viewStub5);
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
