package jp.co.sony.reonpocket.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.view.CustomFontTextView;

public final class FragmentSettingTopBinding implements ViewBinding {
    public final RecyclerView appList;
    public final LinearLayout feedbackContainer;
    public final ViewStub itemChangeUserInfo;
    public final RecyclerView operationList;
    public final RecyclerView reonList;
    private final LinearLayout rootView;
    public final CustomFontTextView twitterDescription;
    public final ViewPreferenceSettingListItemBinding userFeedbackLayout;

    private FragmentSettingTopBinding(LinearLayout linearLayout, RecyclerView recyclerView, LinearLayout linearLayout2, ViewStub viewStub, RecyclerView recyclerView2, RecyclerView recyclerView3, CustomFontTextView customFontTextView, ViewPreferenceSettingListItemBinding viewPreferenceSettingListItemBinding) {
        this.rootView = linearLayout;
        this.appList = recyclerView;
        this.feedbackContainer = linearLayout2;
        this.itemChangeUserInfo = viewStub;
        this.operationList = recyclerView2;
        this.reonList = recyclerView3;
        this.twitterDescription = customFontTextView;
        this.userFeedbackLayout = viewPreferenceSettingListItemBinding;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSettingTopBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentSettingTopBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_setting_top, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0042, code lost:
        r0 = jp.co.sony.reonpocket.R.id.user_feedback_layout;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static jp.co.sony.reonpocket.databinding.FragmentSettingTopBinding bind(android.view.View r11) {
        /*
            int r0 = jp.co.sony.reonpocket.R.id.app_list
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r4 = r1
            androidx.recyclerview.widget.RecyclerView r4 = (androidx.recyclerview.widget.RecyclerView) r4
            if (r4 == 0) goto L_0x0058
            int r0 = jp.co.sony.reonpocket.R.id.feedback_container
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r5 = r1
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            if (r5 == 0) goto L_0x0058
            int r0 = jp.co.sony.reonpocket.R.id.item_change_user_info
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r6 = r1
            android.view.ViewStub r6 = (android.view.ViewStub) r6
            if (r6 == 0) goto L_0x0058
            int r0 = jp.co.sony.reonpocket.R.id.operation_list
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r7 = r1
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            if (r7 == 0) goto L_0x0058
            int r0 = jp.co.sony.reonpocket.R.id.reon_list
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r8 = r1
            androidx.recyclerview.widget.RecyclerView r8 = (androidx.recyclerview.widget.RecyclerView) r8
            if (r8 == 0) goto L_0x0058
            int r0 = jp.co.sony.reonpocket.R.id.twitter_description
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r9 = r1
            jp.co.sony.reonpocket.view.CustomFontTextView r9 = (jp.co.sony.reonpocket.view.CustomFontTextView) r9
            if (r9 == 0) goto L_0x0058
            int r0 = jp.co.sony.reonpocket.R.id.user_feedback_layout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r1 == 0) goto L_0x0058
            jp.co.sony.reonpocket.databinding.ViewPreferenceSettingListItemBinding r10 = jp.co.sony.reonpocket.databinding.ViewPreferenceSettingListItemBinding.bind(r1)
            jp.co.sony.reonpocket.databinding.FragmentSettingTopBinding r0 = new jp.co.sony.reonpocket.databinding.FragmentSettingTopBinding
            r3 = r11
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        L_0x0058:
            android.content.res.Resources r11 = r11.getResources()
            java.lang.String r11 = r11.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.databinding.FragmentSettingTopBinding.bind(android.view.View):jp.co.sony.reonpocket.databinding.FragmentSettingTopBinding");
    }
}
