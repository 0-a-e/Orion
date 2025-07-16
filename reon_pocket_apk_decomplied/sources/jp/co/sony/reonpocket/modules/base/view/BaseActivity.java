package jp.co.sony.reonpocket.modules.base.view;

import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.transition.TransitionSet;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.databinding.CommonBaseBinding;
import jp.co.sony.reonpocket.modules.main.presenter.MainPresenterKt;
import jp.co.sony.reonpocket.util.AnalyticsUtil;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.util.DialogHelperUtil;
import jp.co.sony.reonpocket.util.MyContentUtil;
import jp.co.sony.reonpocket.util.PermissionUtil;
import jp.co.sony.reonpocket.view.fragment.AlertDialogFragment;
import jp.co.sony.reonpocket.view.fragment.BaseDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001xB\u0005¢\u0006\u0002\u0010\u0005J\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0002J\u0016\u00109\u001a\u0002062\f\u0010:\u001a\b\u0012\u0004\u0012\u0002060;H\u0004J\b\u0010<\u001a\u000206H\u0004J\b\u0010=\u001a\u00020+H&J\b\u0010>\u001a\u00020%H\u0004J\b\u0010?\u001a\u00020%H\u0014J\b\u0010@\u001a\u00020%H\u0014J\u0010\u0010A\u001a\u0002062\u0006\u0010B\u001a\u00020\u0017H\u0004J\u0018\u0010C\u001a\u0002062\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0016J \u0010H\u001a\u0002062\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0006\u0010I\u001a\u00020GH\u0016J\u0012\u0010J\u001a\u0002062\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\u0012\u0010M\u001a\u0002062\b\u0010N\u001a\u0004\u0018\u00010OH\u0014J\b\u0010P\u001a\u000206H\u0014J\u0010\u0010Q\u001a\u0002062\u0006\u0010D\u001a\u00020EH\u0016J\b\u0010R\u001a\u000206H\u0014J\b\u0010S\u001a\u000206H\u0014J\b\u0010T\u001a\u000206H\u0014J\b\u0010U\u001a\u000206H\u0014J\u0012\u0010V\u001a\u0002062\b\u0010W\u001a\u0004\u0018\u00010LH\u0016J\u0010\u0010V\u001a\u0002062\u0006\u0010X\u001a\u00020GH\u0016J\b\u0010Y\u001a\u000206H\u0002J\u0010\u0010Z\u001a\u0002062\u0006\u0010[\u001a\u00020\u0017H\u0004J\u0010\u0010\\\u001a\u0002062\u0006\u0010]\u001a\u00020%H\u0004J\u001c\u0010^\u001a\u0002062\u0006\u0010_\u001a\u00020G2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u0003H\u0004J\u0010\u0010a\u001a\u0002062\u0006\u0010]\u001a\u00020%H\u0004J\u0010\u0010b\u001a\u0002062\u0006\u0010c\u001a\u00020GH\u0004J\b\u0010d\u001a\u000206H\u0002J\u0010\u0010e\u001a\u0002062\u0006\u0010[\u001a\u00020\u0017H\u0004J.\u0010f\u001a\u0002062\b\b\u0001\u0010g\u001a\u00020G2\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020%2\n\b\u0002\u0010k\u001a\u0004\u0018\u00010lH\u0014J\b\u0010m\u001a\u000206H\u0004J\u0010\u0010n\u001a\u0002062\b\b\u0001\u0010o\u001a\u00020GJ\u0010\u0010p\u001a\u0002062\u0006\u0010q\u001a\u00020GH\u0004J\u0010\u0010p\u001a\u0002062\u0006\u0010r\u001a\u00020\u0017H\u0004J\u001e\u0010s\u001a\u0002062\n\u0010t\u001a\u0006\u0012\u0002\b\u00030u2\n\b\u0002\u0010v\u001a\u0004\u0018\u00010OJ\u001e\u0010w\u001a\u0002062\n\u0010t\u001a\u0006\u0012\u0002\b\u00030u2\n\b\u0002\u0010v\u001a\u0004\u0018\u00010OR\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\tX\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0010\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000¨\u0006y"}, d2 = {"Ljp/co/sony/reonpocket/modules/base/view/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lkotlinx/coroutines/CoroutineScope;", "Landroid/view/View$OnClickListener;", "Ljp/co/sony/reonpocket/view/fragment/AlertDialogFragment$Callback;", "()V", "binding", "Ljp/co/sony/reonpocket/databinding/CommonBaseBinding;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "mActionBar", "Landroidx/appcompat/app/ActionBar;", "getMActionBar", "()Landroidx/appcompat/app/ActionBar;", "setMActionBar", "(Landroidx/appcompat/app/ActionBar;)V", "mDialogHelper", "Ljp/co/sony/reonpocket/util/DialogHelperUtil;", "mErrorDialog", "Ljp/co/sony/reonpocket/view/fragment/AlertDialogFragment;", "mErrorReason", "", "mFirebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "getMFirebaseAnalytics", "()Lcom/google/firebase/analytics/FirebaseAnalytics;", "setMFirebaseAnalytics", "(Lcom/google/firebase/analytics/FirebaseAnalytics;)V", "mFirebaseRemoteConfig", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "getMFirebaseRemoteConfig", "()Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "setMFirebaseRemoteConfig", "(Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;)V", "mIsPaused", "", "getMIsPaused", "()Z", "setMIsPaused", "(Z)V", "mOutput", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewOutput;", "mPermissionDialog", "mRootToolbar", "Landroidx/appcompat/widget/Toolbar;", "getMRootToolbar", "()Landroidx/appcompat/widget/Toolbar;", "setMRootToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "mSnackBar", "Lcom/google/android/material/snackbar/Snackbar;", "adjustFontScale", "", "aConfiguration", "Landroid/content/res/Configuration;", "checkBTConnect", "callback", "Lkotlin/Function0;", "hideErrorDialog", "initPresenter", "isAppOnForeground", "isTabLayout", "isToolbar", "jump2Url", "aUrl", "onAlertDialogCancelled", "aDialog", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment;", "aRequestCode", "", "onAlertDialogSucceeded", "aResultCode", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDismiss", "onPause", "onResume", "onStart", "onStop", "setContentView", "view", "layoutResID", "setDisplayCommonSettings", "setErrorReason", "aErrorReason", "setMenuIconVisibility", "isVisible", "setNavigationIcon", "aIconResId", "aListener", "setNavigationIconStatus", "setToolbarTitle", "aTitleId", "showBluetoothPermissionCheckDialog", "showErrorDialog", "showFragment", "aContainerId", "aFragment", "Landroidx/fragment/app/Fragment;", "aAddToBackStack", "aTs", "Landroidx/transition/TransitionSet;", "showLocationPermissionCheckDialog", "showSnackBar", "aContent", "showToast", "aMessageResId", "aMessage", "transitAndClear", "aClass", "Ljava/lang/Class;", "aBundle", "transitToActivity", "ActivityReferenceUtil", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseActivity.kt */
public abstract class BaseActivity extends AppCompatActivity implements CoroutineScope, View.OnClickListener, AlertDialogFragment.Callback {
    public static final int $stable = 8;
    private final /* synthetic */ CoroutineScope $$delegate_0 = CoroutineScopeKt.MainScope();
    private CommonBaseBinding binding;
    private ActionBar mActionBar;
    private DialogHelperUtil mDialogHelper;
    private AlertDialogFragment mErrorDialog;
    private String mErrorReason;
    protected FirebaseAnalytics mFirebaseAnalytics;
    protected FirebaseRemoteConfig mFirebaseRemoteConfig;
    private boolean mIsPaused = true;
    private BaseViewOutput mOutput;
    private AlertDialogFragment mPermissionDialog;
    private Toolbar mRootToolbar;
    private Snackbar mSnackBar;

    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public abstract BaseViewOutput initPresenter();

    /* access modifiers changed from: protected */
    public boolean isTabLayout() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isToolbar() {
        return true;
    }

    public void onAlertDialogCancelled(BaseDialogFragment baseDialogFragment, int i) {
        Intrinsics.checkNotNullParameter(baseDialogFragment, "aDialog");
    }

    public void onClick(View view) {
    }

    public void onDismiss(BaseDialogFragment baseDialogFragment) {
        Intrinsics.checkNotNullParameter(baseDialogFragment, "aDialog");
    }

    /* access modifiers changed from: protected */
    public final ActionBar getMActionBar() {
        return this.mActionBar;
    }

    /* access modifiers changed from: protected */
    public final void setMActionBar(ActionBar actionBar) {
        this.mActionBar = actionBar;
    }

    /* access modifiers changed from: protected */
    public final Toolbar getMRootToolbar() {
        return this.mRootToolbar;
    }

    /* access modifiers changed from: protected */
    public final void setMRootToolbar(Toolbar toolbar) {
        this.mRootToolbar = toolbar;
    }

    /* access modifiers changed from: protected */
    public final FirebaseRemoteConfig getMFirebaseRemoteConfig() {
        FirebaseRemoteConfig firebaseRemoteConfig = this.mFirebaseRemoteConfig;
        if (firebaseRemoteConfig != null) {
            return firebaseRemoteConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mFirebaseRemoteConfig");
        return null;
    }

    /* access modifiers changed from: protected */
    public final void setMFirebaseRemoteConfig(FirebaseRemoteConfig firebaseRemoteConfig) {
        Intrinsics.checkNotNullParameter(firebaseRemoteConfig, "<set-?>");
        this.mFirebaseRemoteConfig = firebaseRemoteConfig;
    }

    /* access modifiers changed from: protected */
    public final boolean getMIsPaused() {
        return this.mIsPaused;
    }

    /* access modifiers changed from: protected */
    public final void setMIsPaused(boolean z) {
        this.mIsPaused = z;
    }

    /* access modifiers changed from: protected */
    public final FirebaseAnalytics getMFirebaseAnalytics() {
        FirebaseAnalytics firebaseAnalytics = this.mFirebaseAnalytics;
        if (firebaseAnalytics != null) {
            return firebaseAnalytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mFirebaseAnalytics");
        return null;
    }

    /* access modifiers changed from: protected */
    public final void setMFirebaseAnalytics(FirebaseAnalytics firebaseAnalytics) {
        Intrinsics.checkNotNullParameter(firebaseAnalytics, "<set-?>");
        this.mFirebaseAnalytics = firebaseAnalytics;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Configuration configuration = getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "getConfiguration(...)");
        adjustFontScale(configuration);
        setDisplayCommonSettings();
        CommonBaseBinding inflate = CommonBaseBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        FirebaseRemoteConfig instance = FirebaseRemoteConfig.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(...)");
        setMFirebaseRemoteConfig(instance);
        FirebaseAnalytics instance2 = FirebaseAnalytics.getInstance(this);
        Intrinsics.checkNotNullExpressionValue(instance2, "getInstance(...)");
        setMFirebaseAnalytics(instance2);
        BaseViewOutput initPresenter = initPresenter();
        this.mOutput = initPresenter;
        if (initPresenter != null) {
            initPresenter.onCreate();
        }
        this.mDialogHelper = DialogHelperUtil.Companion.newInstance((FragmentActivity) this);
        ActivityReferenceUtil.INSTANCE.addActivity(this);
    }

    private final void adjustFontScale(Configuration configuration) {
        configuration.fontScale = Settings.System.getFloat(getContentResolver(), "font_scale", 1.0f);
        if (configuration.fontScale > 1.0f) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            Object systemService = getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
            displayMetrics.scaledDensity = configuration.fontScale * displayMetrics.density;
            getBaseContext().getResources().updateConfiguration(configuration, displayMetrics);
        }
    }

    public void setContentView(View view) {
        if (isToolbar()) {
            CommonBaseBinding commonBaseBinding = this.binding;
            CommonBaseBinding commonBaseBinding2 = null;
            if (commonBaseBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                commonBaseBinding = null;
            }
            super.setContentView((View) commonBaseBinding.getRoot());
            CommonBaseBinding commonBaseBinding3 = this.binding;
            if (commonBaseBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                commonBaseBinding3 = null;
            }
            Toolbar toolbar = commonBaseBinding3.toolbar;
            this.mRootToolbar = toolbar;
            setSupportActionBar(toolbar);
            ActionBar supportActionBar = getSupportActionBar();
            this.mActionBar = supportActionBar;
            if (supportActionBar != null) {
                supportActionBar.setDisplayShowTitleEnabled(false);
            }
            CommonBaseBinding commonBaseBinding4 = this.binding;
            if (commonBaseBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                commonBaseBinding2 = commonBaseBinding4;
            }
            NestedScrollView nestedScrollView = commonBaseBinding2.contentFrame;
            Intrinsics.checkNotNullExpressionValue(nestedScrollView, "contentFrame");
            if (nestedScrollView.getChildCount() > 0) {
                nestedScrollView.removeAllViews();
            }
            nestedScrollView.addView(view, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        super.setContentView(view);
    }

    public void setContentView(int i) {
        if (isToolbar()) {
            super.setContentView(R.layout.common_base);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mRootToolbar = toolbar;
            setSupportActionBar(toolbar);
            ActionBar supportActionBar = getSupportActionBar();
            this.mActionBar = supportActionBar;
            if (supportActionBar != null) {
                supportActionBar.setDisplayShowTitleEnabled(false);
            }
            View inflate = LayoutInflater.from(this).inflate(i, (ViewGroup) null);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.contentFrame);
            if (viewGroup.getChildCount() > 0) {
                viewGroup.removeAllViews();
            }
            viewGroup.addView(inflate, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        super.setContentView(i);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        BaseViewOutput baseViewOutput = this.mOutput;
        if (baseViewOutput != null) {
            baseViewOutput.onStart();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mIsPaused = false;
        CharSequence charSequence = this.mErrorReason;
        if (!(charSequence == null || charSequence.length() == 0)) {
            String str = this.mErrorReason;
            Intrinsics.checkNotNull(str);
            showErrorDialog(str);
            this.mErrorReason = null;
        }
        BaseViewOutput baseViewOutput = this.mOutput;
        if (baseViewOutput != null) {
            baseViewOutput.onResume();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mIsPaused = true;
        BaseViewOutput baseViewOutput = this.mOutput;
        if (baseViewOutput != null) {
            baseViewOutput.onPause();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        BaseViewOutput baseViewOutput = this.mOutput;
        if (baseViewOutput != null) {
            baseViewOutput.onStop();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        BaseViewOutput baseViewOutput = this.mOutput;
        if (baseViewOutput != null) {
            baseViewOutput.onDestroy();
        }
        ActivityReferenceUtil.INSTANCE.checkWeakReference();
        ActivityReferenceUtil.INSTANCE.removeActivity(getClass());
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public final void setToolbarTitle(int i) {
        ActionBar actionBar = this.mActionBar;
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
        }
        ActionBar actionBar2 = this.mActionBar;
        if (actionBar2 != null) {
            actionBar2.setTitle(i);
        }
    }

    public static /* synthetic */ void setNavigationIcon$default(BaseActivity baseActivity, int i, View.OnClickListener onClickListener, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                onClickListener = null;
            }
            baseActivity.setNavigationIcon(i, onClickListener);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setNavigationIcon");
    }

    /* access modifiers changed from: protected */
    public final void setNavigationIcon(int i, View.OnClickListener onClickListener) {
        Toolbar toolbar;
        ActionBar actionBar = this.mActionBar;
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        Toolbar toolbar2 = this.mRootToolbar;
        if (toolbar2 != null) {
            toolbar2.setNavigationIcon(i);
        }
        if (onClickListener != null && (toolbar = this.mRootToolbar) != null) {
            toolbar.setNavigationOnClickListener(onClickListener);
        }
    }

    /* access modifiers changed from: protected */
    public final void setNavigationIconStatus(boolean z) {
        Drawable navigationIcon;
        ActionBar actionBar = this.mActionBar;
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(z);
        }
        Toolbar toolbar = this.mRootToolbar;
        if (toolbar != null && (navigationIcon = toolbar.getNavigationIcon()) != null) {
            navigationIcon.setVisible(z, false);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getMenu();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setMenuIconVisibility(boolean r3) {
        /*
            r2 = this;
            androidx.appcompat.widget.Toolbar r0 = r2.mRootToolbar
            if (r0 == 0) goto L_0x0010
            android.view.Menu r0 = r0.getMenu()
            if (r0 == 0) goto L_0x0010
            r1 = 0
            android.view.MenuItem r0 = r0.getItem(r1)
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            if (r0 != 0) goto L_0x0014
            goto L_0x0017
        L_0x0014:
            r0.setVisible(r3)
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.base.view.BaseActivity.setMenuIconVisibility(boolean):void");
    }

    private final void setDisplayCommonSettings() {
        setRequestedOrientation(1);
    }

    public static /* synthetic */ void transitToActivity$default(BaseActivity baseActivity, Class cls, Bundle bundle, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                bundle = null;
            }
            baseActivity.transitToActivity(cls, bundle);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: transitToActivity");
    }

    public final void transitToActivity(Class<?> cls, Bundle bundle) {
        Intrinsics.checkNotNullParameter(cls, "aClass");
        Intent intent = new Intent(this, cls);
        intent.setFlags(335544320);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public static /* synthetic */ void transitAndClear$default(BaseActivity baseActivity, Class cls, Bundle bundle, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                bundle = null;
            }
            baseActivity.transitAndClear(cls, bundle);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: transitAndClear");
    }

    public final void transitAndClear(Class<?> cls, Bundle bundle) {
        Intrinsics.checkNotNullParameter(cls, "aClass");
        Intent intent = new Intent(this, cls);
        intent.setFlags(268468224);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public final void showToast(int i) {
        Toast.makeText(this, i, 0).show();
    }

    public final void showSnackBar(int i) {
        View findViewById = findViewById(16908290);
        if (findViewById != null) {
            Snackbar snackbar = this.mSnackBar;
            if (snackbar == null) {
                this.mSnackBar = Snackbar.make(findViewById, i, -1);
            } else {
                Intrinsics.checkNotNull(snackbar);
                snackbar.setText(i);
            }
            Snackbar snackbar2 = this.mSnackBar;
            Intrinsics.checkNotNull(snackbar2);
            TextView textView = (TextView) snackbar2.getView().findViewById(com.google.android.material.R.id.snackbar_text);
            if (textView != null) {
                textView.setMaxLines(5);
            }
            Snackbar snackbar3 = this.mSnackBar;
            Intrinsics.checkNotNull(snackbar3);
            snackbar3.show();
        }
    }

    /* access modifiers changed from: protected */
    public final void showToast(String str) {
        Intrinsics.checkNotNullParameter(str, "aMessage");
        Toast.makeText(this, str, 0).show();
    }

    public void onAlertDialogSucceeded(BaseDialogFragment baseDialogFragment, int i, int i2) {
        Intrinsics.checkNotNullParameter(baseDialogFragment, "aDialog");
        if (i == DialogHelperUtil.RequestCode.WITH_SUPPORT.ordinal() && i2 == -1) {
            jump2Url(MyContentUtil.getSupportURL$default(MyContentUtil.INSTANCE, this, (String) null, (String) null, 6, (Object) null));
        }
    }

    /* access modifiers changed from: protected */
    public final boolean isAppOnForeground() {
        Object systemService = getApplicationContext().getSystemService("activity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        String packageName = getApplicationContext().getPackageName();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.processName.equals(packageName) && next.importance == 100) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final void setErrorReason(String str) {
        Intrinsics.checkNotNullParameter(str, "aErrorReason");
        this.mErrorReason = str;
    }

    /* access modifiers changed from: protected */
    public final void showErrorDialog(String str) {
        int i;
        int i2;
        Unit unit;
        Dialog dialog;
        Intrinsics.checkNotNullParameter(str, "aErrorReason");
        if (!isAppOnForeground()) {
            this.mErrorReason = str;
        } else if (!this.mIsPaused) {
            int ordinal = DialogHelperUtil.RequestCode.NO_REQUEST.ordinal();
            int i3 = R.string.common_ok;
            int i4 = 0;
            switch (str.hashCode()) {
                case -1952776069:
                    if (str.equals(BaseActivityKt.ERROR_DEVICE_COULD_NOT_CHARGE_UNKNOWN)) {
                        i = R.string.help_info_message_unexpected_not_charge_error_title;
                        i2 = R.string.help_info_message_unexpected_not_charge_error_description;
                        break;
                    } else {
                        return;
                    }
                case -1845830655:
                    if (str.equals(BaseActivityKt.ERROR_DFU_FAIL)) {
                        i = R.string.bterror_update_title;
                        i2 = R.string.bterror_update_description;
                        ordinal = DialogHelperUtil.RequestCode.CONNECT_FAILED.ordinal();
                        break;
                    } else {
                        return;
                    }
                case -1754850584:
                    if (str.equals(BaseActivityKt.ERROR_UNEXPECTED)) {
                        i = R.string.bterror_connect_title;
                        i2 = R.string.bterror_connect_description;
                        i4 = R.string.common_close;
                        break;
                    } else {
                        return;
                    }
                case -1539836935:
                    if (str.equals(BaseActivityKt.ERROR_DEVICE_FAN_INVALID)) {
                        AnalyticsUtil.logEventWithBundle$default(AnalyticsUtil.INSTANCE, this, getMFirebaseAnalytics(), AnalyticsUtil.EventName.SHOW_SUPPORT_ERROR, (Bundle) null, 8, (Object) null);
                        i = R.string.dev_stop_error_title;
                        i2 = R.string.dev_fan_error_description;
                        ordinal = DialogHelperUtil.RequestCode.WITH_SUPPORT.ordinal();
                        i4 = R.string.common_support;
                        i3 = R.string.common_close;
                        break;
                    } else {
                        return;
                    }
                case -1255027189:
                    if (str.equals(BaseActivityKt.ERROR_CONNECTION_STATE_WITHOUT_UNREGISTER)) {
                        i = R.string.bterror_connect_title;
                        i2 = R.string.bterror_connect_description;
                        ordinal = DialogHelperUtil.RequestCode.CONNECT_FAILED.ordinal();
                        i4 = R.string.common_close;
                        break;
                    } else {
                        return;
                    }
                case -1039242937:
                    if (str.equals(BaseActivityKt.ERROR_CONNECTION_STATE)) {
                        i = R.string.bterror_connect_title;
                        i2 = R.string.bterror_connect_description;
                        ordinal = DialogHelperUtil.RequestCode.CONNECT_FAILED.ordinal();
                        i4 = R.string.setting_unregister_buttun;
                        i3 = R.string.common_close;
                        break;
                    } else {
                        return;
                    }
                case -299397996:
                    if (str.equals(BaseActivityKt.ERROR_DEVICE_STOP)) {
                        i = R.string.dev_stop_error_title;
                        i2 = R.string.dev_stop_error_description;
                        ordinal = DialogHelperUtil.RequestCode.WITH_SUPPORT.ordinal();
                        i4 = R.string.common_support;
                        i3 = R.string.common_close;
                        break;
                    } else {
                        return;
                    }
                case -114594730:
                    if (str.equals(BaseActivityKt.ERROR_DEVICE_OVERHEAT)) {
                        i = R.string.dev_work_error_title;
                        i2 = R.string.dev_overheat_error_description;
                        break;
                    } else {
                        return;
                    }
                case 18386023:
                    if (str.equals(BaseActivityKt.ERROR_OPERATE_WHEN_CHARGE)) {
                        i = R.string.ope_in_charging_error_title;
                        i2 = R.string.ope_in_charging_error_description;
                        break;
                    } else {
                        return;
                    }
                case 48938092:
                    str.equals(MainPresenterKt.BUNDLE_SHUTDOWN_BY_LOW_BATTERY);
                    return;
                case 167848052:
                    if (str.equals(BaseActivityKt.ERROR_INVALID_OWNER)) {
                        AnalyticsUtil.logEventWithBundle$default(AnalyticsUtil.INSTANCE, this, getMFirebaseAnalytics(), AnalyticsUtil.EventName.SHOW_REGISTERED_DEVICE_ERROR, (Bundle) null, 8, (Object) null);
                        i = R.string.change_bt_device_title;
                        i2 = R.string.change_bt_device_description;
                        ordinal = DialogHelperUtil.RequestCode.CONNECT_FAILED.ordinal();
                        break;
                    } else {
                        return;
                    }
                case 327294320:
                    if (str.equals(BaseActivityKt.ERROR_DEVICE_COULD_NOT_CHARGE)) {
                        i = R.string.dev_charging_error_title;
                        i2 = R.string.dev_charging_error_description;
                        break;
                    } else {
                        return;
                    }
                case 849572615:
                    if (str.equals(BaseActivityKt.ERROR_DFU_FAIL_DUE_TO_LOW_BATTERY)) {
                        i = R.string.bterror_not_battery_title;
                        i2 = R.string.bterror_not_battery_description;
                        break;
                    } else {
                        return;
                    }
                case 1582892475:
                    if (str.equals(BaseActivityKt.USB_AROUND_OVER_HEAT)) {
                        i = R.string.dev_around_usb_heat_alert_dialog_title;
                        i2 = R.string.dev_around_usb_heat_alert_dialog_description;
                        break;
                    } else {
                        return;
                    }
                case 1636183979:
                    if (str.equals(BaseActivityKt.ERROR_TEMP)) {
                        i = R.string.dev_work_error_title;
                        i2 = R.string.dev_overheat_error_description;
                        break;
                    } else {
                        return;
                    }
                case 1797919570:
                    if (str.equals(BaseActivityKt.USB_WATER_WET_DETECTION)) {
                        i = R.string.dev_usb_water_alert_dialog_title;
                        i2 = R.string.dev_usb_water_alert_dialog_description;
                        break;
                    } else {
                        return;
                    }
                case 1827486065:
                    if (str.equals(BaseActivityKt.ERROR_DEVICE_LOWTEMP)) {
                        i = R.string.dev_work_error_title;
                        i2 = R.string.dev_lowtemp_error_description;
                        break;
                    } else {
                        return;
                    }
                case 1844352730:
                    if (str.equals(BaseActivityKt.VBUS_VOLTAGE_ABNORMALITY_DETECTED)) {
                        i = R.string.dev_vbus_voltage_alert_dialog_title;
                        i2 = R.string.dev_vbus_voltage_alert_dialog_description;
                        break;
                    } else {
                        return;
                    }
                case 1912314269:
                    if (str.equals(BaseActivityKt.ERROR_INTERNET_CONNECTION_INVALID)) {
                        i = R.string.server_connect_error_title;
                        i2 = R.string.server_connect_error_description;
                        break;
                    } else {
                        return;
                    }
                case 1918323945:
                    if (str.equals(BaseActivityKt.ERROR_OPERATE_WHEN_NO_ENOUGH_BATTERY)) {
                        i = R.string.dev_low_battery_error_title;
                        i2 = R.string.dev_low_battery_error_description;
                        break;
                    } else {
                        return;
                    }
                case 2121796383:
                    if (str.equals(BaseActivityKt.USB_AROUND_WATER_WET_DETECTION)) {
                        i = R.string.dev_around_usb_water_alert_dialog_title;
                        i2 = R.string.dev_around_usb_water_alert_dialog_description;
                        break;
                    } else {
                        return;
                    }
                default:
                    return;
            }
            AlertDialogFragment alertDialogFragment = this.mErrorDialog;
            if (alertDialogFragment == null || (dialog = alertDialogFragment.getDialog()) == null) {
                unit = null;
            } else {
                if (!dialog.isShowing()) {
                    DialogHelperUtil dialogHelperUtil = this.mDialogHelper;
                    if (dialogHelperUtil == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
                        dialogHelperUtil = null;
                    }
                    this.mErrorDialog = dialogHelperUtil.showConfirmationDialog(i, i2, 0, ordinal, Integer.valueOf(i4), Integer.valueOf(i3));
                }
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                DialogHelperUtil dialogHelperUtil2 = this.mDialogHelper;
                if (dialogHelperUtil2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
                    dialogHelperUtil2 = null;
                }
                this.mErrorDialog = dialogHelperUtil2.showConfirmationDialog(i, i2, 0, ordinal, Integer.valueOf(i4), Integer.valueOf(i3));
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void hideErrorDialog() {
        Dialog dialog;
        AlertDialogFragment alertDialogFragment = this.mErrorDialog;
        if (alertDialogFragment != null && (dialog = alertDialogFragment.getDialog()) != null) {
            dialog.dismiss();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u000bJ\u0012\u0010\u000e\u001a\u00020\u000b2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010J\u0012\u0010\u0011\u001a\u00020\u000b2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010R(\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Ljp/co/sony/reonpocket/modules/base/view/BaseActivity$ActivityReferenceUtil;", "", "()V", "activityStack", "Ljava/util/Stack;", "Ljava/lang/ref/WeakReference;", "Ljp/co/sony/reonpocket/modules/base/view/BaseActivity;", "getActivityStack$annotations", "getActivityStack", "()Ljava/util/Stack;", "addActivity", "", "aActivity", "checkWeakReference", "finishOtherActivity", "aClass", "Ljava/lang/Class;", "removeActivity", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BaseActivity.kt */
    public static final class ActivityReferenceUtil {
        public static final int $stable = 8;
        public static final ActivityReferenceUtil INSTANCE = new ActivityReferenceUtil();
        private static final Stack<WeakReference<BaseActivity>> activityStack = new Stack<>();

        @JvmStatic
        public static /* synthetic */ void getActivityStack$annotations() {
        }

        private ActivityReferenceUtil() {
        }

        public static final Stack<WeakReference<BaseActivity>> getActivityStack() {
            return activityStack;
        }

        public final void addActivity(BaseActivity baseActivity) {
            Intrinsics.checkNotNullParameter(baseActivity, "aActivity");
            activityStack.add(new WeakReference(baseActivity));
        }

        public final void checkWeakReference() {
            Iterator it = activityStack.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                if (((BaseActivity) ((WeakReference) it.next()).get()) == null) {
                    it.remove();
                }
            }
        }

        public final void removeActivity(Class<?> cls) {
            Intrinsics.checkNotNullParameter(cls, "aClass");
            Iterator it = activityStack.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                BaseActivity baseActivity = (BaseActivity) ((WeakReference) it.next()).get();
                if (baseActivity == null) {
                    it.remove();
                } else if (Intrinsics.areEqual((Object) baseActivity.getClass(), (Object) cls)) {
                    it.remove();
                }
            }
        }

        public final void finishOtherActivity(Class<?> cls) {
            Intrinsics.checkNotNullParameter(cls, "aClass");
            Iterator it = activityStack.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                BaseActivity baseActivity = (BaseActivity) ((WeakReference) it.next()).get();
                if (baseActivity == null) {
                    it.remove();
                } else if (!Intrinsics.areEqual((Object) baseActivity.getClass(), (Object) cls)) {
                    it.remove();
                    baseActivity.finish();
                    DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
                    String simpleName = baseActivity.getClass().getSimpleName();
                    debugLogUtil.d("killed: " + simpleName);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void jump2Url(String str) {
        Intrinsics.checkNotNullParameter(str, "aUrl");
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public static /* synthetic */ void showFragment$default(BaseActivity baseActivity, int i, Fragment fragment, boolean z, TransitionSet transitionSet, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 8) != 0) {
                transitionSet = null;
            }
            baseActivity.showFragment(i, fragment, z, transitionSet);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showFragment");
    }

    /* access modifiers changed from: protected */
    public void showFragment(int i, Fragment fragment, boolean z, TransitionSet transitionSet) {
        Intrinsics.checkNotNullParameter(fragment, "aFragment");
        if (transitionSet != null) {
            fragment.setEnterTransition(transitionSet);
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
        beginTransaction.replace(i, fragment);
        if (z) {
            beginTransaction.addToBackStack((String) null);
        }
        beginTransaction.commit();
    }

    /* access modifiers changed from: protected */
    public final void showLocationPermissionCheckDialog() {
        DialogHelperUtil dialogHelperUtil = this.mDialogHelper;
        if (dialogHelperUtil == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil = null;
        }
        this.mPermissionDialog = dialogHelperUtil.showConfirmationDialog(R.string.bterror_location_error_title, R.string.bterror_location_error_description, 0, DialogHelperUtil.RequestCode.LOCATION_NOT_SETTING.ordinal(), Integer.valueOf(R.string.common_ok), Integer.valueOf(R.string.common_cancel));
    }

    /* access modifiers changed from: protected */
    public final void checkBTConnect(Function0<Unit> function0) {
        Dialog dialog;
        Intrinsics.checkNotNullParameter(function0, "callback");
        PermissionUtil permissionUtil = PermissionUtil.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        if (!permissionUtil.isBleEnabled(applicationContext)) {
            showBluetoothPermissionCheckDialog();
        } else if (!PermissionUtil.INSTANCE.isLocationEnabled(this)) {
            showLocationPermissionCheckDialog();
        } else {
            AlertDialogFragment alertDialogFragment = this.mPermissionDialog;
            if (!(alertDialogFragment == null || (dialog = alertDialogFragment.getDialog()) == null || !dialog.isShowing())) {
                dialog.dismiss();
            }
            function0.invoke();
        }
    }

    private final void showBluetoothPermissionCheckDialog() {
        DialogHelperUtil dialogHelperUtil;
        DialogHelperUtil dialogHelperUtil2;
        if (Build.VERSION.SDK_INT < 31) {
            DialogHelperUtil dialogHelperUtil3 = this.mDialogHelper;
            if (dialogHelperUtil3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
                dialogHelperUtil2 = null;
            } else {
                dialogHelperUtil2 = dialogHelperUtil3;
            }
            this.mPermissionDialog = dialogHelperUtil2.showConfirmationDialog(R.string.bterror_disable_title, R.string.bterror_disable_description, 0, DialogHelperUtil.RequestCode.BLUETOOTH_NOT_SETTING.ordinal(), Integer.valueOf(R.string.common_ok), Integer.valueOf(R.string.common_cancel));
            return;
        }
        DialogHelperUtil dialogHelperUtil4 = this.mDialogHelper;
        if (dialogHelperUtil4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil = null;
        } else {
            dialogHelperUtil = dialogHelperUtil4;
        }
        this.mPermissionDialog = DialogHelperUtil.showConfirmationDialog$default(dialogHelperUtil, R.string.bterror_disable_title, R.string.bterror_disable_android_api33_description, 0, DialogHelperUtil.RequestCode.BLUETOOTH_NOT_SETTING.ordinal(), Integer.valueOf(R.string.common_settings), (Integer) null, 32, (Object) null);
    }
}
