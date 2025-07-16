package jp.co.sony.reonpocket.modules.quickMode.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import androidx.lifecycle.LifecycleOwnerKt;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.data.interactor.BleInteractor;
import jp.co.sony.reonpocket.databinding.ActivityQuickLaunchBinding;
import jp.co.sony.reonpocket.databinding.ViewPreferenceDescriptionBinding;
import jp.co.sony.reonpocket.modules.base.view.BaseActivity;
import jp.co.sony.reonpocket.modules.base.view.BaseViewOutput;
import jp.co.sony.reonpocket.modules.quickMode.viewmodel.QuickLaunchViewModel;
import jp.co.sony.reonpocket.util.AnalyticsUtil;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0002J\b\u0010\u0019\u001a\u00020\bH\u0002J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Ljp/co/sony/reonpocket/modules/quickMode/view/QuickLaunchActivity;", "Ljp/co/sony/reonpocket/modules/base/view/BaseActivity;", "()V", "binding", "Ljp/co/sony/reonpocket/databinding/ActivityQuickLaunchBinding;", "viewModel", "Ljp/co/sony/reonpocket/modules/quickMode/viewmodel/QuickLaunchViewModel;", "collectStates", "", "initPresenter", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewOutput;", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onSuccessUpdateSetting", "setupScreen", "updateQuickLaunchEnable", "isQuickLaunchEnable", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: QuickLaunchActivity.kt */
public final class QuickLaunchActivity extends BaseActivity {
    public static final int $stable = 8;
    private ActivityQuickLaunchBinding binding;
    /* access modifiers changed from: private */
    public final QuickLaunchViewModel viewModel = new QuickLaunchViewModel(this, (BleInteractor) null, 2, (DefaultConstructorMarker) null);

    public BaseViewOutput initPresenter() {
        getLifecycle().addObserver(this.viewModel);
        return this.viewModel;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupScreen();
        collectStates();
    }

    private final void setupScreen() {
        ActivityQuickLaunchBinding inflate = ActivityQuickLaunchBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        ActivityQuickLaunchBinding activityQuickLaunchBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView((View) inflate.getRoot());
        setToolbarTitle(R.string.setting_ql_title);
        setNavigationIcon(R.drawable.ic_close, this);
        ActivityQuickLaunchBinding activityQuickLaunchBinding2 = this.binding;
        if (activityQuickLaunchBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityQuickLaunchBinding2 = null;
        }
        activityQuickLaunchBinding2.headerDescriptionStub.setOnInflateListener(new QuickLaunchActivity$$ExternalSyntheticLambda0(this));
        ActivityQuickLaunchBinding activityQuickLaunchBinding3 = this.binding;
        if (activityQuickLaunchBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityQuickLaunchBinding3 = null;
        }
        activityQuickLaunchBinding3.headerDescriptionStub.inflate();
        ActivityQuickLaunchBinding activityQuickLaunchBinding4 = this.binding;
        if (activityQuickLaunchBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityQuickLaunchBinding4 = null;
        }
        activityQuickLaunchBinding4.quickLaunchSwitchEnable.listTitle.setText(getString(R.string.setting_ql_title));
        ActivityQuickLaunchBinding activityQuickLaunchBinding5 = this.binding;
        if (activityQuickLaunchBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityQuickLaunchBinding = activityQuickLaunchBinding5;
        }
        activityQuickLaunchBinding.quickLaunchSwitchEnable.listSubTitle.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public static final void setupScreen$lambda$1(QuickLaunchActivity quickLaunchActivity, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(quickLaunchActivity, "this$0");
        ViewPreferenceDescriptionBinding.bind(view).description.setText(quickLaunchActivity.getString(R.string.setting_ql_description));
    }

    private final void collectStates() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new QuickLaunchActivity$collectStates$1(this, (Continuation<? super QuickLaunchActivity$collectStates$1>) null), 3, (Object) null);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        if (isToolbar()) {
            getMenuInflater().inflate(R.menu.menu_done, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    /* access modifiers changed from: private */
    public final void onSuccessUpdateSetting() {
        AnalyticsUtil.logEventWithBundle$default(AnalyticsUtil.INSTANCE, this, getMFirebaseAnalytics(), AnalyticsUtil.EventName.SETUP_QUICK_LAUNCH, (Bundle) null, 8, (Object) null);
        finish();
    }

    public void onClick(View view) {
        super.onClick(view);
        if (view != null) {
            finish();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != R.id.action_done) {
            return super.onOptionsItemSelected(menuItem);
        }
        ActivityQuickLaunchBinding activityQuickLaunchBinding = this.binding;
        if (activityQuickLaunchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityQuickLaunchBinding = null;
        }
        this.viewModel.updateSettings(activityQuickLaunchBinding.quickLaunchSwitchEnable.listSwitch.isChecked());
        return true;
    }

    /* access modifiers changed from: private */
    public final void updateQuickLaunchEnable(boolean z) {
        ActivityQuickLaunchBinding activityQuickLaunchBinding = this.binding;
        if (activityQuickLaunchBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityQuickLaunchBinding = null;
        }
        activityQuickLaunchBinding.quickLaunchSwitchEnable.listSwitch.setChecked(z);
    }
}
