package jp.co.sony.reonpocket.modules.locationSetting.view;

import android.os.Bundle;
import android.view.View;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.modules.base.view.BaseActivity;
import jp.co.sony.reonpocket.modules.base.view.BaseViewOutput;
import jp.co.sony.reonpocket.modules.locationSetting.presenter.LocationSettingPresenter;
import jp.co.sony.reonpocket.view.CustomFontButton;
import jp.co.sony.reonpocket.view.CustomFontTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001%B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u001c2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Ljp/co/sony/reonpocket/modules/locationSetting/view/LocationSettingActivity;", "Ljp/co/sony/reonpocket/modules/base/view/BaseActivity;", "Ljp/co/sony/reonpocket/modules/locationSetting/view/LocationSettingViewInput;", "()V", "mDisabledTextView", "Ljp/co/sony/reonpocket/view/CustomFontTextView;", "getMDisabledTextView", "()Ljp/co/sony/reonpocket/view/CustomFontTextView;", "setMDisabledTextView", "(Ljp/co/sony/reonpocket/view/CustomFontTextView;)V", "mEnabledTextView", "getMEnabledTextView", "setMEnabledTextView", "mOutput", "Ljp/co/sony/reonpocket/modules/locationSetting/view/LocationSettingActivity$LocationSettingViewOutput;", "getMOutput", "()Ljp/co/sony/reonpocket/modules/locationSetting/view/LocationSettingActivity$LocationSettingViewOutput;", "setMOutput", "(Ljp/co/sony/reonpocket/modules/locationSetting/view/LocationSettingActivity$LocationSettingViewOutput;)V", "mSettingButton", "Ljp/co/sony/reonpocket/view/CustomFontButton;", "getMSettingButton", "()Ljp/co/sony/reonpocket/view/CustomFontButton;", "setMSettingButton", "(Ljp/co/sony/reonpocket/view/CustomFontButton;)V", "initPresenter", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewOutput;", "onClick", "", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "updatePermissionView", "isPermitted", "", "LocationSettingViewOutput", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocationSettingActivity.kt */
public final class LocationSettingActivity extends BaseActivity implements LocationSettingViewInput {
    public static final int $stable = 8;
    public CustomFontTextView mDisabledTextView;
    public CustomFontTextView mEnabledTextView;
    public LocationSettingViewOutput mOutput;
    public CustomFontButton mSettingButton;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Ljp/co/sony/reonpocket/modules/locationSetting/view/LocationSettingActivity$LocationSettingViewOutput;", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewOutput;", "checkBackgroundPermission", "", "transitToSetting", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: LocationSettingActivity.kt */
    public interface LocationSettingViewOutput extends BaseViewOutput {
        boolean checkBackgroundPermission();

        void transitToSetting();
    }

    public final LocationSettingViewOutput getMOutput() {
        LocationSettingViewOutput locationSettingViewOutput = this.mOutput;
        if (locationSettingViewOutput != null) {
            return locationSettingViewOutput;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mOutput");
        return null;
    }

    public final void setMOutput(LocationSettingViewOutput locationSettingViewOutput) {
        Intrinsics.checkNotNullParameter(locationSettingViewOutput, "<set-?>");
        this.mOutput = locationSettingViewOutput;
    }

    public final CustomFontButton getMSettingButton() {
        CustomFontButton customFontButton = this.mSettingButton;
        if (customFontButton != null) {
            return customFontButton;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mSettingButton");
        return null;
    }

    public final void setMSettingButton(CustomFontButton customFontButton) {
        Intrinsics.checkNotNullParameter(customFontButton, "<set-?>");
        this.mSettingButton = customFontButton;
    }

    public final CustomFontTextView getMEnabledTextView() {
        CustomFontTextView customFontTextView = this.mEnabledTextView;
        if (customFontTextView != null) {
            return customFontTextView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mEnabledTextView");
        return null;
    }

    public final void setMEnabledTextView(CustomFontTextView customFontTextView) {
        Intrinsics.checkNotNullParameter(customFontTextView, "<set-?>");
        this.mEnabledTextView = customFontTextView;
    }

    public final CustomFontTextView getMDisabledTextView() {
        CustomFontTextView customFontTextView = this.mDisabledTextView;
        if (customFontTextView != null) {
            return customFontTextView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDisabledTextView");
        return null;
    }

    public final void setMDisabledTextView(CustomFontTextView customFontTextView) {
        Intrinsics.checkNotNullParameter(customFontTextView, "<set-?>");
        this.mDisabledTextView = customFontTextView;
    }

    public BaseViewOutput initPresenter() {
        setMOutput(new LocationSettingPresenter(this, this));
        return getMOutput();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_location_setting);
        setToolbarTitle(R.string.setting_top_remaining_battery_notification);
        setNavigationIcon(R.drawable.ic_close, this);
        View findViewById = findViewById(R.id.permission_enabled);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        setMEnabledTextView((CustomFontTextView) findViewById);
        View findViewById2 = findViewById(R.id.permission_disabled);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        setMDisabledTextView((CustomFontTextView) findViewById2);
        View findViewById3 = findViewById(R.id.transit_setting);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        setMSettingButton((CustomFontButton) findViewById3);
        updatePermissionView(getMOutput().checkBackgroundPermission());
        getMSettingButton().setOnClickListener(new LocationSettingActivity$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$0(LocationSettingActivity locationSettingActivity, View view) {
        Intrinsics.checkNotNullParameter(locationSettingActivity, "this$0");
        locationSettingActivity.getMOutput().transitToSetting();
    }

    public void updatePermissionView(boolean z) {
        if (z) {
            getMEnabledTextView().setVisibility(0);
            getMDisabledTextView().setVisibility(8);
            getMSettingButton().setVisibility(8);
            return;
        }
        getMEnabledTextView().setVisibility(8);
        getMDisabledTextView().setVisibility(0);
        getMSettingButton().setVisibility(0);
    }

    public void onClick(View view) {
        super.onClick(view);
        if (view != null) {
            finish();
        }
    }
}
