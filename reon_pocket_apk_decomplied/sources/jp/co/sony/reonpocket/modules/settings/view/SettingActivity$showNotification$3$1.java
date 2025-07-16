package jp.co.sony.reonpocket.modules.settings.view;

import android.graphics.Bitmap;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.data.entity.NotificationEntity;
import jp.co.sony.reonpocket.util.AnalyticsUtil;
import jp.co.sony.reonpocket.util.RemoteConfigUtil;
import jp.co.sony.reonpocket.view.CustomFontTextView;
import jp.co.sony.reonpocket.view.fragment.BaseDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"jp/co/sony/reonpocket/modules/settings/view/SettingActivity$showNotification$3$1", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$DialogFragmentLifecycleListener;", "onViewCreated", "", "aView", "Landroid/view/View;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SettingActivity.kt */
public final class SettingActivity$showNotification$3$1 implements BaseDialogFragment.DialogFragmentLifecycleListener {
    final /* synthetic */ Bitmap $aBitMap;
    final /* synthetic */ String $aDescription;
    final /* synthetic */ String $aSubtitle;
    final /* synthetic */ String $aTitle;
    final /* synthetic */ String $aUrl;
    final /* synthetic */ SettingActivity this$0;

    SettingActivity$showNotification$3$1(String str, String str2, SettingActivity settingActivity, String str3, String str4, Bitmap bitmap) {
        this.$aTitle = str;
        this.$aSubtitle = str2;
        this.this$0 = settingActivity;
        this.$aDescription = str3;
        this.$aUrl = str4;
        this.$aBitMap = bitmap;
    }

    public void onViewCreated(View view) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(view, "aView");
        CustomFontTextView customFontTextView = (CustomFontTextView) view.findViewById(R.id.title);
        if (customFontTextView != null) {
            customFontTextView.setText(this.$aTitle);
        }
        CustomFontTextView customFontTextView2 = (CustomFontTextView) view.findViewById(R.id.subtitle);
        if (customFontTextView2 != null) {
            customFontTextView2.setText(this.$aSubtitle);
        }
        this.this$0.mImageView = (ImageView) view.findViewById(R.id.image_view);
        ImageView access$getMImageView$p = this.this$0.mImageView;
        if (!(access$getMImageView$p == null || (bitmap = this.$aBitMap) == null)) {
            access$getMImageView$p.setImageBitmap(bitmap);
            access$getMImageView$p.setVisibility(0);
        }
        CustomFontTextView customFontTextView3 = (CustomFontTextView) view.findViewById(R.id.description);
        if (customFontTextView3 != null) {
            customFontTextView3.setText(this.$aDescription);
        }
        CustomFontTextView customFontTextView4 = (CustomFontTextView) view.findViewById(R.id.url);
        String str = this.$aUrl;
        Unit unit = null;
        if (str != null) {
            SettingActivity settingActivity = this.this$0;
            if (customFontTextView4 != null) {
                customFontTextView4.setText(Html.fromHtml("<a href=\"" + str + "\">" + str + "<\\a>"));
            }
            if (customFontTextView4 != null) {
                customFontTextView4.setMovementMethod(LinkMovementMethod.getInstance());
            }
            if (customFontTextView4 != null) {
                customFontTextView4.setOnClickListener(new SettingActivity$showNotification$3$1$$ExternalSyntheticLambda0(settingActivity));
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                AnalyticsUtil.INSTANCE.logEventWithString(settingActivity, settingActivity.getMFirebaseAnalytics(), AnalyticsUtil.EventName.INFORMATION_LINK_TAP, AnalyticsUtil.EventParameter.NOTIFICATION_ID, AnalyticsUtil.ParameterConstants.NO_ID.getValue());
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null && customFontTextView4 != null) {
            customFontTextView4.setVisibility(8);
        }
        this.this$0.hideProgressDialog();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$5$lambda$3(SettingActivity settingActivity, View view) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        NotificationEntity mNotificationEntity = RemoteConfigUtil.INSTANCE.getMNotificationEntity();
        if (mNotificationEntity != null) {
            AnalyticsUtil.INSTANCE.logEventWithString(settingActivity, settingActivity.getMFirebaseAnalytics(), AnalyticsUtil.EventName.INFORMATION_LINK_TAP, AnalyticsUtil.EventParameter.NOTIFICATION_ID, String.valueOf(mNotificationEntity.getVersion()));
        }
    }
}
