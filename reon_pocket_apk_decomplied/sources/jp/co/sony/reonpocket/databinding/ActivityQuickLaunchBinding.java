package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import jp.co.sony.reonpocket.R;

public final class ActivityQuickLaunchBinding implements ViewBinding {
    public final ViewStub headerDescriptionStub;
    public final ViewPreferenceSwitchBinding quickLaunchSwitchEnable;
    private final LinearLayout rootView;

    private ActivityQuickLaunchBinding(LinearLayout linearLayout, ViewStub viewStub, ViewPreferenceSwitchBinding viewPreferenceSwitchBinding) {
        this.rootView = linearLayout;
        this.headerDescriptionStub = viewStub;
        this.quickLaunchSwitchEnable = viewPreferenceSwitchBinding;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityQuickLaunchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityQuickLaunchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_quick_launch, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = jp.co.sony.reonpocket.R.id.quick_launch_switch_enable;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static jp.co.sony.reonpocket.databinding.ActivityQuickLaunchBinding bind(android.view.View r3) {
        /*
            int r0 = jp.co.sony.reonpocket.R.id.headerDescriptionStub
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r3, r0)
            android.view.ViewStub r1 = (android.view.ViewStub) r1
            if (r1 == 0) goto L_0x001e
            int r0 = jp.co.sony.reonpocket.R.id.quick_launch_switch_enable
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r3, r0)
            if (r2 == 0) goto L_0x001e
            jp.co.sony.reonpocket.databinding.ViewPreferenceSwitchBinding r0 = jp.co.sony.reonpocket.databinding.ViewPreferenceSwitchBinding.bind(r2)
            jp.co.sony.reonpocket.databinding.ActivityQuickLaunchBinding r2 = new jp.co.sony.reonpocket.databinding.ActivityQuickLaunchBinding
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r2.<init>(r3, r1, r0)
            return r2
        L_0x001e:
            android.content.res.Resources r3 = r3.getResources()
            java.lang.String r3 = r3.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r3 = r1.concat(r3)
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.databinding.ActivityQuickLaunchBinding.bind(android.view.View):jp.co.sony.reonpocket.databinding.ActivityQuickLaunchBinding");
    }
}
