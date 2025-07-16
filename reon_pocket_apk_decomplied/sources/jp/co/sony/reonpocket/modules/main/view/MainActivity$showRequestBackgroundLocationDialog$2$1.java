package jp.co.sony.reonpocket.modules.main.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import androidx.core.app.ActivityCompat;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.modules.main.view.MainActivity;
import jp.co.sony.reonpocket.view.CustomFontButton;
import jp.co.sony.reonpocket.view.CustomFontTextView;
import jp.co.sony.reonpocket.view.CustomImageView;
import jp.co.sony.reonpocket.view.fragment.BaseDialogFragment;
import jp.co.sony.reonpocket.view.fragment.DataDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"jp/co/sony/reonpocket/modules/main/view/MainActivity$showRequestBackgroundLocationDialog$2$1", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$DialogFragmentLifecycleListener;", "onViewCreated", "", "aView", "Landroid/view/View;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainActivity.kt */
public final class MainActivity$showRequestBackgroundLocationDialog$2$1 implements BaseDialogFragment.DialogFragmentLifecycleListener {
    final /* synthetic */ boolean $aIsRequestPermission;
    final /* synthetic */ MainActivity this$0;

    MainActivity$showRequestBackgroundLocationDialog$2$1(MainActivity mainActivity, boolean z) {
        this.this$0 = mainActivity;
        this.$aIsRequestPermission = z;
    }

    public void onViewCreated(View view) {
        Intrinsics.checkNotNullParameter(view, "aView");
        CustomFontTextView customFontTextView = (CustomFontTextView) view.findViewById(R.id.title);
        if (customFontTextView != null) {
            customFontTextView.setText(this.this$0.getString(R.string.mainview_battery_notification_popup_title));
        }
        CustomImageView customImageView = (CustomImageView) view.findViewById(R.id.image_view);
        customImageView.setImageResource(R.drawable.img_battery_level_infomation);
        customImageView.setVisibility(0);
        CustomFontTextView customFontTextView2 = (CustomFontTextView) view.findViewById(R.id.description);
        if (customFontTextView2 != null) {
            customFontTextView2.setText(this.this$0.getString(R.string.mainview_battery_notification_popup_description));
        }
        CustomFontButton customFontButton = (CustomFontButton) view.findViewById(R.id.button_positive);
        if (customFontButton != null) {
            customFontButton.setText(this.this$0.getString(R.string.common_setup));
        }
        if (customFontButton != null) {
            customFontButton.setOnClickListener(this.$aIsRequestPermission ? new MainActivity$showRequestBackgroundLocationDialog$2$1$$ExternalSyntheticLambda0(this.this$0) : new MainActivity$showRequestBackgroundLocationDialog$2$1$$ExternalSyntheticLambda1(this.this$0));
        }
        CustomFontButton customFontButton2 = (CustomFontButton) view.findViewById(R.id.button_negative);
        if (customFontButton2 != null) {
            customFontButton2.setText(this.this$0.getText(R.string.common_later));
        }
        if (customFontButton2 != null) {
            customFontButton2.setOnClickListener(new MainActivity$showRequestBackgroundLocationDialog$2$1$$ExternalSyntheticLambda2(this.this$0));
        }
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(MainActivity mainActivity, View view) {
        Intrinsics.checkNotNullParameter(mainActivity, "this$0");
        if (Build.VERSION.SDK_INT >= 29) {
            ActivityCompat.requestPermissions(mainActivity, new String[]{"android.permission.ACCESS_BACKGROUND_LOCATION"}, 2);
        }
        DataDialogFragment access$getMRequestLocationDialog$p = mainActivity.mRequestLocationDialog;
        if (access$getMRequestLocationDialog$p != null) {
            access$getMRequestLocationDialog$p.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(MainActivity mainActivity, View view) {
        Intrinsics.checkNotNullParameter(mainActivity, "this$0");
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", mainActivity.getPackageName(), (String) null));
        mainActivity.startActivity(intent);
        DataDialogFragment access$getMRequestLocationDialog$p = mainActivity.mRequestLocationDialog;
        if (access$getMRequestLocationDialog$p != null) {
            access$getMRequestLocationDialog$p.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(MainActivity mainActivity, View view) {
        Intrinsics.checkNotNullParameter(mainActivity, "this$0");
        MainActivity.MainViewOutput access$getMOutput$p = mainActivity.mOutput;
        if (access$getMOutput$p != null) {
            access$getMOutput$p.markLocationPopup(false);
        }
        DataDialogFragment access$getMRequestLocationDialog$p = mainActivity.mRequestLocationDialog;
        if (access$getMRequestLocationDialog$p != null) {
            access$getMRequestLocationDialog$p.dismiss();
        }
        mainActivity.onResume();
    }
}
