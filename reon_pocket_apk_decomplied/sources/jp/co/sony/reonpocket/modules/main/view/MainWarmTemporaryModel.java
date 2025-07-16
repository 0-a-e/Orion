package jp.co.sony.reonpocket.modules.main.view;

import android.graphics.Typeface;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.core.content.ContextCompat;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.constant.DeviceModeActionCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J>\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n¨\u0006\u0014"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainWarmTemporaryModel;", "", "()V", "setUpAutoButton", "", "deviceModeActionCode", "Ljp/co/sony/reonpocket/constant/DeviceModeActionCode;", "autoButton", "Landroidx/appcompat/widget/AppCompatToggleButton;", "autoButtonOnCheckedChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "setUpSmartButton", "smartButton", "Landroidx/appcompat/widget/AppCompatButton;", "smartButtonOnClickListener", "Landroid/view/View$OnClickListener;", "switchSmartAutoButtonVisibility", "isSmartSupported", "", "isAutoSupported", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainWarmTemporaryModel.kt */
public final class MainWarmTemporaryModel {
    public static final int $stable = 0;
    public static final MainWarmTemporaryModel INSTANCE = new MainWarmTemporaryModel();

    private MainWarmTemporaryModel() {
    }

    public final void switchSmartAutoButtonVisibility(boolean z, boolean z2, AppCompatToggleButton appCompatToggleButton, AppCompatButton appCompatButton, DeviceModeActionCode deviceModeActionCode, View.OnClickListener onClickListener, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        Intrinsics.checkNotNullParameter(appCompatToggleButton, "autoButton");
        Intrinsics.checkNotNullParameter(appCompatButton, "smartButton");
        Intrinsics.checkNotNullParameter(deviceModeActionCode, "deviceModeActionCode");
        Intrinsics.checkNotNullParameter(onClickListener, "smartButtonOnClickListener");
        Intrinsics.checkNotNullParameter(onCheckedChangeListener, "autoButtonOnCheckedChangeListener");
        appCompatButton.setOnClickListener((View.OnClickListener) null);
        appCompatToggleButton.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        appCompatButton.setVisibility(8);
        appCompatToggleButton.setVisibility(8);
        if (z) {
            setUpSmartButton(appCompatButton, onClickListener);
        } else if (z2) {
            setUpAutoButton(deviceModeActionCode, appCompatToggleButton, onCheckedChangeListener);
        }
    }

    public final void setUpSmartButton(AppCompatButton appCompatButton, View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(appCompatButton, "smartButton");
        Intrinsics.checkNotNullParameter(onClickListener, "smartButtonOnClickListener");
        appCompatButton.setVisibility(0);
        appCompatButton.setOnClickListener(onClickListener);
    }

    public final void setUpAutoButton(DeviceModeActionCode deviceModeActionCode, AppCompatToggleButton appCompatToggleButton, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        Typeface typeface;
        Intrinsics.checkNotNullParameter(deviceModeActionCode, "deviceModeActionCode");
        Intrinsics.checkNotNullParameter(appCompatToggleButton, "autoButton");
        Intrinsics.checkNotNullParameter(onCheckedChangeListener, "autoButtonOnCheckedChangeListener");
        boolean z = false;
        appCompatToggleButton.setVisibility(0);
        if (deviceModeActionCode == DeviceModeActionCode.AUTO) {
            z = true;
        }
        appCompatToggleButton.setChecked(z);
        appCompatToggleButton.setOnCheckedChangeListener(onCheckedChangeListener);
        if (deviceModeActionCode == DeviceModeActionCode.AUTO) {
            typeface = Typeface.DEFAULT_BOLD;
        } else {
            typeface = Typeface.DEFAULT;
        }
        appCompatToggleButton.setTypeface(typeface);
        appCompatToggleButton.setTextColor(ContextCompat.getColorStateList(appCompatToggleButton.getContext(), R.color.main_warm_toggle_text_color));
    }
}
