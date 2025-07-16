package jp.co.sony.reonpocket.modules.main.view;

import android.view.View;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.constant.ReonProductType;
import jp.co.sony.reonpocket.data.interactor.DeviceInfoInteractor;
import jp.co.sony.reonpocket.modules.main.view.MainActivity;
import jp.co.sony.reonpocket.view.CustomFontButton;
import jp.co.sony.reonpocket.view.CustomFontTextView;
import jp.co.sony.reonpocket.view.CustomImageView;
import jp.co.sony.reonpocket.view.fragment.BaseDialogFragment;
import jp.co.sony.reonpocket.view.fragment.DataDialogFragment;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"jp/co/sony/reonpocket/modules/main/view/MainActivity$showAutoStartNotification$2$1", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment$DialogFragmentLifecycleListener;", "onViewCreated", "", "aView", "Landroid/view/View;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainActivity.kt */
public final class MainActivity$showAutoStartNotification$2$1 implements BaseDialogFragment.DialogFragmentLifecycleListener {
    final /* synthetic */ MainActivity this$0;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                jp.co.sony.reonpocket.constant.ReonProductType[] r0 = jp.co.sony.reonpocket.constant.ReonProductType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.ReonProductType r1 = jp.co.sony.reonpocket.constant.ReonProductType.PRO     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                jp.co.sony.reonpocket.constant.ReonProductType r1 = jp.co.sony.reonpocket.constant.ReonProductType.ORIGINAL     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.main.view.MainActivity$showAutoStartNotification$2$1.WhenMappings.<clinit>():void");
        }
    }

    MainActivity$showAutoStartNotification$2$1(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    public void onViewCreated(View view) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(view, "aView");
        CustomFontTextView customFontTextView = (CustomFontTextView) view.findViewById(R.id.title);
        if (customFontTextView != null) {
            customFontTextView.setText(this.this$0.getString(R.string.mainview_auto_start_popup_title));
        }
        CustomImageView customImageView = (CustomImageView) view.findViewById(R.id.image_view);
        customImageView.setImageResource(R.drawable.img_guide_autostart);
        customImageView.setVisibility(0);
        CustomFontTextView customFontTextView2 = (CustomFontTextView) view.findViewById(R.id.description);
        ReonProductType reonProductType = ReonProductType.Companion.getReonProductType(new DeviceInfoInteractor().getPeripheralName(this.this$0));
        if (customFontTextView2 != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[reonProductType.ordinal()];
            if (i == 1) {
                charSequence = this.this$0.getString(R.string.mainview_auto_start_popup_description_pro);
            } else if (i == 2) {
                charSequence = this.this$0.getString(R.string.mainview_auto_start_popup_description_original);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            customFontTextView2.setText(charSequence);
        }
        CustomFontButton customFontButton = (CustomFontButton) view.findViewById(R.id.button_positive);
        if (customFontButton != null) {
            customFontButton.setText(this.this$0.getString(R.string.common_ok));
        }
        if (customFontButton != null) {
            customFontButton.setOnClickListener(new MainActivity$showAutoStartNotification$2$1$$ExternalSyntheticLambda0(this.this$0));
        }
        CustomFontButton customFontButton2 = (CustomFontButton) view.findViewById(R.id.button_negative);
        if (customFontButton2 != null) {
            customFontButton2.setText(this.this$0.getText(R.string.mainview_auto_start_popup_make_disabled));
        }
        if (customFontButton2 != null) {
            customFontButton2.setOnClickListener(new MainActivity$showAutoStartNotification$2$1$$ExternalSyntheticLambda1(this.this$0));
        }
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(MainActivity mainActivity, View view) {
        Intrinsics.checkNotNullParameter(mainActivity, "this$0");
        MainActivity.MainViewOutput access$getMOutput$p = mainActivity.mOutput;
        if (access$getMOutput$p != null) {
            access$getMOutput$p.markAutoStartPopupShown();
        }
        DataDialogFragment access$getMAutoDialogFragment$p = mainActivity.mAutoDialogFragment;
        if (access$getMAutoDialogFragment$p != null) {
            access$getMAutoDialogFragment$p.dismiss();
        }
        mainActivity.onResume();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(MainActivity mainActivity, View view) {
        Intrinsics.checkNotNullParameter(mainActivity, "this$0");
        MainActivity.MainViewOutput access$getMOutput$p = mainActivity.mOutput;
        if (access$getMOutput$p != null) {
            access$getMOutput$p.markAutoStartPopupShown();
        }
        MainActivity.MainViewOutput access$getMOutput$p2 = mainActivity.mOutput;
        if (access$getMOutput$p2 != null) {
            access$getMOutput$p2.setAutoStart(false);
        }
        DataDialogFragment access$getMAutoDialogFragment$p = mainActivity.mAutoDialogFragment;
        if (access$getMAutoDialogFragment$p != null) {
            access$getMAutoDialogFragment$p.dismiss();
        }
        mainActivity.onResume();
    }
}
