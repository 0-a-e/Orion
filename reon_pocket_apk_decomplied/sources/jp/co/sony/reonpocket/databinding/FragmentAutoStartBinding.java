package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import jp.co.sony.reonpocket.R;

public final class FragmentAutoStartBinding implements ViewBinding {
    public final ImageView asMyDivider;
    public final ViewStub headerDescriptionStub;
    public final ViewPreferenceSwitchBinding lastModeItem;
    private final LinearLayout rootView;

    private FragmentAutoStartBinding(LinearLayout linearLayout, ImageView imageView, ViewStub viewStub, ViewPreferenceSwitchBinding viewPreferenceSwitchBinding) {
        this.rootView = linearLayout;
        this.asMyDivider = imageView;
        this.headerDescriptionStub = viewStub;
        this.lastModeItem = viewPreferenceSwitchBinding;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAutoStartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentAutoStartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_auto_start, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r0 = jp.co.sony.reonpocket.R.id.last_mode_item;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static jp.co.sony.reonpocket.databinding.FragmentAutoStartBinding bind(android.view.View r4) {
        /*
            int r0 = jp.co.sony.reonpocket.R.id.as_my_divider
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x0028
            int r0 = jp.co.sony.reonpocket.R.id.headerDescriptionStub
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            android.view.ViewStub r2 = (android.view.ViewStub) r2
            if (r2 == 0) goto L_0x0028
            int r0 = jp.co.sony.reonpocket.R.id.last_mode_item
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            if (r3 == 0) goto L_0x0028
            jp.co.sony.reonpocket.databinding.ViewPreferenceSwitchBinding r0 = jp.co.sony.reonpocket.databinding.ViewPreferenceSwitchBinding.bind(r3)
            jp.co.sony.reonpocket.databinding.FragmentAutoStartBinding r3 = new jp.co.sony.reonpocket.databinding.FragmentAutoStartBinding
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            r3.<init>(r4, r1, r2, r0)
            return r3
        L_0x0028:
            android.content.res.Resources r4 = r4.getResources()
            java.lang.String r4 = r4.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r4 = r1.concat(r4)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.databinding.FragmentAutoStartBinding.bind(android.view.View):jp.co.sony.reonpocket.databinding.FragmentAutoStartBinding");
    }
}
