package jp.co.sony.reonpocket.modules.pairing.view;

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

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"jp/co/sony/reonpocket/modules/pairing/view/PairingActivity$showNotification$2", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$DialogFragmentLifecycleListener;", "onViewCreated", "", "aView", "Landroid/view/View;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PairingActivity.kt */
public final class PairingActivity$showNotification$2 implements BaseDialogFragment.DialogFragmentLifecycleListener {
    final /* synthetic */ Bitmap $aBitMap;
    final /* synthetic */ String $aDescription;
    final /* synthetic */ String $aSubtitle;
    final /* synthetic */ String $aUrl;
    final /* synthetic */ PairingActivity this$0;

    PairingActivity$showNotification$2(String str, String str2, String str3, PairingActivity pairingActivity, Bitmap bitmap) {
        this.$aSubtitle = str;
        this.$aDescription = str2;
        this.$aUrl = str3;
        this.this$0 = pairingActivity;
        this.$aBitMap = bitmap;
    }

    public void onViewCreated(View view) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(view, "aView");
        CustomFontTextView customFontTextView = (CustomFontTextView) view.findViewById(R.id.subtitle);
        if (customFontTextView != null) {
            customFontTextView.setText(this.$aSubtitle);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
        if (!(imageView == null || (bitmap = this.$aBitMap) == null)) {
            imageView.setImageBitmap(bitmap);
            imageView.setVisibility(0);
        }
        CustomFontTextView customFontTextView2 = (CustomFontTextView) view.findViewById(R.id.description);
        if (customFontTextView2 != null) {
            customFontTextView2.setText(this.$aDescription);
        }
        CustomFontTextView customFontTextView3 = (CustomFontTextView) view.findViewById(R.id.url);
        String str = this.$aUrl;
        Unit unit = null;
        if (str != null) {
            PairingActivity pairingActivity = this.this$0;
            if (customFontTextView3 != null) {
                customFontTextView3.setText(Html.fromHtml("<a href=\"" + str + "\">" + str + "<\\a>"));
            }
            if (customFontTextView3 != null) {
                customFontTextView3.setMovementMethod(LinkMovementMethod.getInstance());
            }
            if (customFontTextView3 != null) {
                customFontTextView3.setOnClickListener(new PairingActivity$showNotification$2$$ExternalSyntheticLambda0(pairingActivity));
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                pairingActivity.noticeAnalyticsSend(AnalyticsUtil.ParameterConstants.NO_ID.getValue());
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null && customFontTextView3 != null) {
            customFontTextView3.setVisibility(8);
        }
        this.this$0.hiddenProgressDialog();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$5$lambda$3(PairingActivity pairingActivity, View view) {
        Intrinsics.checkNotNullParameter(pairingActivity, "this$0");
        NotificationEntity mNotificationEntity = RemoteConfigUtil.INSTANCE.getMNotificationEntity();
        if (mNotificationEntity != null) {
            pairingActivity.noticeAnalyticsSend(String.valueOf(mNotificationEntity.getVersion()));
        }
    }
}
