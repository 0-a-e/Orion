package jp.co.sony.reonpocket.modules.main.view;

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

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"jp/co/sony/reonpocket/modules/main/view/MainActivity$showNotification$4$2", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$DialogFragmentLifecycleListener;", "onViewCreated", "", "aView", "Landroid/view/View;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainActivity.kt */
public final class MainActivity$showNotification$4$2 implements BaseDialogFragment.DialogFragmentLifecycleListener {
    final /* synthetic */ Bitmap $aBitMap;
    final /* synthetic */ String $aDescription;
    final /* synthetic */ String $aSubtitle;
    final /* synthetic */ String $aUrl;
    final /* synthetic */ MainActivity this$0;

    MainActivity$showNotification$4$2(String str, MainActivity mainActivity, String str2, String str3, Bitmap bitmap) {
        this.$aSubtitle = str;
        this.this$0 = mainActivity;
        this.$aDescription = str2;
        this.$aUrl = str3;
        this.$aBitMap = bitmap;
    }

    public void onViewCreated(View view) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(view, "aView");
        CustomFontTextView customFontTextView = (CustomFontTextView) view.findViewById(R.id.subtitle);
        if (customFontTextView != null) {
            customFontTextView.setText(this.$aSubtitle);
        }
        this.this$0.mImageView = (ImageView) view.findViewById(R.id.image_view);
        ImageView access$getMImageView$p = this.this$0.mImageView;
        if (!(access$getMImageView$p == null || (bitmap = this.$aBitMap) == null)) {
            access$getMImageView$p.setImageBitmap(bitmap);
            access$getMImageView$p.setVisibility(0);
        }
        CustomFontTextView customFontTextView2 = (CustomFontTextView) view.findViewById(R.id.description);
        if (customFontTextView2 != null) {
            customFontTextView2.setText(this.$aDescription);
        }
        CustomFontTextView customFontTextView3 = (CustomFontTextView) view.findViewById(R.id.url);
        String str = this.$aUrl;
        Unit unit = null;
        if (str != null) {
            MainActivity mainActivity = this.this$0;
            if (customFontTextView3 != null) {
                customFontTextView3.setText(Html.fromHtml("<a href=\"" + str + "\">" + str + "<\\a>"));
            }
            if (customFontTextView3 != null) {
                customFontTextView3.setMovementMethod(LinkMovementMethod.getInstance());
            }
            if (customFontTextView3 != null) {
                customFontTextView3.setOnClickListener(new MainActivity$showNotification$4$2$$ExternalSyntheticLambda0(mainActivity));
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                AnalyticsUtil.INSTANCE.logEventWithString(mainActivity, mainActivity.getMFirebaseAnalytics(), AnalyticsUtil.EventName.INFORMATION_LINK_TAP, AnalyticsUtil.EventParameter.NOTIFICATION_ID, AnalyticsUtil.ParameterConstants.NO_ID.getValue());
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null && customFontTextView3 != null) {
            customFontTextView3.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$5$lambda$3(MainActivity mainActivity, View view) {
        Intrinsics.checkNotNullParameter(mainActivity, "this$0");
        NotificationEntity mNotificationEntity = RemoteConfigUtil.INSTANCE.getMNotificationEntity();
        if (mNotificationEntity != null) {
            AnalyticsUtil.INSTANCE.logEventWithString(mainActivity, mainActivity.getMFirebaseAnalytics(), AnalyticsUtil.EventName.INFORMATION_LINK_TAP, AnalyticsUtil.EventParameter.NOTIFICATION_ID, String.valueOf(mNotificationEntity.getVersion()));
        }
    }
}
