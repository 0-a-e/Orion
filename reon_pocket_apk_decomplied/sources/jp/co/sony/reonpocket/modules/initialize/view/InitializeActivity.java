package jp.co.sony.reonpocket.modules.initialize.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.connection.aws.UserInfoEntity;
import jp.co.sony.reonpocket.modules.base.view.BaseActivity;
import jp.co.sony.reonpocket.modules.base.view.BaseViewOutput;
import jp.co.sony.reonpocket.modules.initialize.view.InitUserInfoFragment;
import jp.co.sony.reonpocket.modules.initialize.view.InitWelcomeFragment;
import jp.co.sony.reonpocket.modules.settings.view.SettingActivityKt;
import jp.co.sony.reonpocket.util.DialogHelperUtil;
import jp.co.sony.reonpocket.view.fragment.BaseDialogFragment;
import jp.co.sony.reonpocket.view.fragment.DataDialogFragment;
import jp.co.sony.reonpocket.view.fragment.ProgressDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u0000 -2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002-.B\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0014J\u0012\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J \u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0016J\u0018\u0010 \u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0010H\u0016J0\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020#H\u0016J\b\u0010+\u001a\u00020\u0010H\u0016J\b\u0010,\u001a\u00020\u0010H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Ljp/co/sony/reonpocket/modules/initialize/view/InitializeActivity;", "Ljp/co/sony/reonpocket/modules/base/view/BaseActivity;", "Ljp/co/sony/reonpocket/modules/initialize/view/InitializeViewInput;", "Ljp/co/sony/reonpocket/modules/initialize/view/InitWelcomeFragment$OnNextStepListener;", "Ljp/co/sony/reonpocket/modules/initialize/view/InitUserInfoFragment$OnSendUserInfoListener;", "Ljp/co/sony/reonpocket/view/fragment/DataDialogFragment$Callback;", "()V", "mDialogHelper", "Ljp/co/sony/reonpocket/util/DialogHelperUtil;", "mEulaPpDialog", "Ljp/co/sony/reonpocket/view/fragment/DataDialogFragment;", "mOutput", "Ljp/co/sony/reonpocket/modules/initialize/view/InitializeActivity$InitializeViewOutput;", "mProgressDialog", "Ljp/co/sony/reonpocket/view/fragment/ProgressDialogFragment;", "changeNextBtnState", "", "aIsEnable", "", "initPresenter", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewOutput;", "isToolbar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDataDialogCancelled", "aDialog", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment;", "aRequestCode", "", "onDataDialogSucceeded", "aResultCode", "onDismiss", "onFail", "aErrorMessage", "", "onNextStep", "onSend", "aGender", "aAge", "aHeight", "aWeight", "aAddress", "showEulaPpDialog", "showProgressDialog", "Companion", "InitializeViewOutput", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: InitializeActivity.kt */
public final class InitializeActivity extends BaseActivity implements InitializeViewInput, InitWelcomeFragment.OnNextStepListener, InitUserInfoFragment.OnSendUserInfoListener, DataDialogFragment.Callback {
    public static final int $stable = 8;
    private static final String BUNDLE_KEY_EULA = "bundle_key_eula";
    private static final String BUNDLE_KEY_PRIVACY_POLICY = "bundle_key_privacy_policy";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String PROGRESS_DIALOG_TAG_REMOTE_CONFIG = "progress_dialog_tag_remote_config";
    private DialogHelperUtil mDialogHelper = DialogHelperUtil.Companion.newInstance((FragmentActivity) this);
    private DataDialogFragment mEulaPpDialog;
    private InitializeViewOutput mOutput;
    private ProgressDialogFragment mProgressDialog;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/modules/initialize/view/InitializeActivity$InitializeViewOutput;", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewOutput;", "registerUserInfo", "", "aUserInfoEntity", "Ljp/co/sony/reonpocket/connection/aws/UserInfoEntity;", "tapNextStep", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: InitializeActivity.kt */
    public interface InitializeViewOutput extends BaseViewOutput {
        void registerUserInfo(UserInfoEntity userInfoEntity);

        void tapNextStep();
    }

    /* access modifiers changed from: protected */
    public boolean isToolbar() {
        return false;
    }

    public void onDataDialogCancelled(BaseDialogFragment baseDialogFragment, int i) {
        Intrinsics.checkNotNullParameter(baseDialogFragment, "aDialog");
    }

    public void onDataDialogSucceeded(BaseDialogFragment baseDialogFragment, int i, int i2) {
        Intrinsics.checkNotNullParameter(baseDialogFragment, "aDialog");
    }

    public void onDismiss(BaseDialogFragment baseDialogFragment, int i) {
        Intrinsics.checkNotNullParameter(baseDialogFragment, "aDialog");
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ljp/co/sony/reonpocket/modules/initialize/view/InitializeActivity$Companion;", "", "()V", "BUNDLE_KEY_EULA", "", "BUNDLE_KEY_PRIVACY_POLICY", "PROGRESS_DIALOG_TAG_REMOTE_CONFIG", "createIntent", "Landroid/content/Intent;", "aContext", "Landroid/content/Context;", "aEula", "Ljp/co/sony/reonpocket/modules/initialize/view/InitWelcomeFragment$Eula;", "aPrivacyPolicy", "Ljp/co/sony/reonpocket/modules/initialize/view/InitWelcomeFragment$PrivacyPolicy;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: InitializeActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent createIntent(Context context, InitWelcomeFragment.Eula eula) {
            Intrinsics.checkNotNullParameter(context, "aContext");
            Intrinsics.checkNotNullParameter(eula, "aEula");
            Intent intent = new Intent(context, InitializeActivity.class);
            intent.putExtra(InitializeActivity.BUNDLE_KEY_EULA, eula);
            return intent;
        }

        public final Intent createIntent(Context context, InitWelcomeFragment.PrivacyPolicy privacyPolicy) {
            Intrinsics.checkNotNullParameter(context, "aContext");
            Intrinsics.checkNotNullParameter(privacyPolicy, "aPrivacyPolicy");
            Intent intent = new Intent(context, InitializeActivity.class);
            intent.putExtra(InitializeActivity.BUNDLE_KEY_PRIVACY_POLICY, privacyPolicy);
            return intent;
        }

        public final Intent createIntent(Context context, InitWelcomeFragment.Eula eula, InitWelcomeFragment.PrivacyPolicy privacyPolicy) {
            Intrinsics.checkNotNullParameter(context, "aContext");
            Intrinsics.checkNotNullParameter(eula, "aEula");
            Intrinsics.checkNotNullParameter(privacyPolicy, "aPrivacyPolicy");
            Intent intent = new Intent(context, InitializeActivity.class);
            intent.putExtra(InitializeActivity.BUNDLE_KEY_EULA, eula);
            intent.putExtra(InitializeActivity.BUNDLE_KEY_PRIVACY_POLICY, privacyPolicy);
            return intent;
        }
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [java.io.Serializable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public jp.co.sony.reonpocket.modules.base.view.BaseViewOutput initPresenter() {
        /*
            r9 = this;
            android.content.Intent r0 = r9.getIntent()
            java.lang.String r1 = "bundle_key_eula"
            java.io.Serializable r0 = r0.getSerializableExtra(r1)
            boolean r1 = r0 instanceof jp.co.sony.reonpocket.modules.initialize.view.InitWelcomeFragment.Eula
            r2 = 0
            if (r1 == 0) goto L_0x0013
            jp.co.sony.reonpocket.modules.initialize.view.InitWelcomeFragment$Eula r0 = (jp.co.sony.reonpocket.modules.initialize.view.InitWelcomeFragment.Eula) r0
            r7 = r0
            goto L_0x0014
        L_0x0013:
            r7 = r2
        L_0x0014:
            android.content.Intent r0 = r9.getIntent()
            java.lang.String r1 = "bundle_key_privacy_policy"
            java.io.Serializable r0 = r0.getSerializableExtra(r1)
            boolean r1 = r0 instanceof jp.co.sony.reonpocket.modules.initialize.view.InitWelcomeFragment.PrivacyPolicy
            if (r1 == 0) goto L_0x0025
            r2 = r0
            jp.co.sony.reonpocket.modules.initialize.view.InitWelcomeFragment$PrivacyPolicy r2 = (jp.co.sony.reonpocket.modules.initialize.view.InitWelcomeFragment.PrivacyPolicy) r2
        L_0x0025:
            r8 = r2
            jp.co.sony.reonpocket.modules.initialize.router.InitializeRouter r6 = new jp.co.sony.reonpocket.modules.initialize.router.InitializeRouter
            r6.<init>(r9)
            jp.co.sony.reonpocket.modules.initialize.presenter.InitializePresenter r0 = new jp.co.sony.reonpocket.modules.initialize.presenter.InitializePresenter
            r4 = r9
            android.content.Context r4 = (android.content.Context) r4
            r5 = r9
            jp.co.sony.reonpocket.modules.initialize.view.InitializeViewInput r5 = (jp.co.sony.reonpocket.modules.initialize.view.InitializeViewInput) r5
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8)
            jp.co.sony.reonpocket.modules.initialize.view.InitializeActivity$InitializeViewOutput r0 = (jp.co.sony.reonpocket.modules.initialize.view.InitializeActivity.InitializeViewOutput) r0
            r9.mOutput = r0
            java.lang.String r1 = "null cannot be cast to non-null type jp.co.sony.reonpocket.modules.initialize.presenter.InitializePresenter"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            jp.co.sony.reonpocket.modules.initialize.presenter.InitializePresenter r0 = (jp.co.sony.reonpocket.modules.initialize.presenter.InitializePresenter) r0
            jp.co.sony.reonpocket.modules.base.view.BaseViewOutput r0 = (jp.co.sony.reonpocket.modules.base.view.BaseViewOutput) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.initialize.view.InitializeActivity.initPresenter():jp.co.sony.reonpocket.modules.base.view.BaseViewOutput");
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_initialize);
        if (bundle == null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
            beginTransaction.replace(R.id.fragment_container, InitWelcomeFragment.Companion.newInstance());
            beginTransaction.commit();
        }
    }

    public void onNextStep() {
        InitializeViewOutput initializeViewOutput = this.mOutput;
        if (initializeViewOutput != null) {
            initializeViewOutput.tapNextStep();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSend(java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15) {
        /*
            r10 = this;
            java.lang.String r0 = "aGender"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "aAge"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "aHeight"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "aWeight"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "aAddress"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            android.content.res.Resources r0 = android.content.res.Resources.getSystem()
            android.content.res.Configuration r0 = r0.getConfiguration()
            androidx.core.os.LocaleListCompat r0 = androidx.core.os.ConfigurationCompat.getLocales(r0)
            r1 = 0
            java.util.Locale r0 = r0.get(r1)
            if (r0 == 0) goto L_0x0031
            java.lang.String r2 = r0.getLanguage()
            goto L_0x0032
        L_0x0031:
            r2 = 0
        L_0x0032:
            java.util.Locale r3 = java.util.Locale.JAPANESE
            java.lang.String r3 = r3.toString()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0042
            java.lang.String r0 = "Japan"
        L_0x0040:
            r7 = r0
            goto L_0x0061
        L_0x0042:
            java.util.Locale r3 = java.util.Locale.CHINESE
            java.lang.String r3 = r3.toString()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            java.lang.String r3 = "Other"
            if (r2 == 0) goto L_0x0060
            java.lang.String r0 = r0.getCountry()
            java.lang.String r2 = "hk"
            r4 = 1
            boolean r0 = kotlin.text.StringsKt.equals(r0, r2, r4)
            if (r0 == 0) goto L_0x0060
            java.lang.String r0 = "HongKong"
            goto L_0x0040
        L_0x0060:
            r7 = r3
        L_0x0061:
            jp.co.sony.reonpocket.modules.initialize.view.InitializeActivity$InitializeViewOutput r0 = r10.mOutput
            if (r0 == 0) goto L_0x0073
            jp.co.sony.reonpocket.connection.aws.UserInfoEntity r9 = new jp.co.sony.reonpocket.connection.aws.UserInfoEntity
            r2 = r9
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r8 = r15
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r0.registerUserInfo(r9)
        L_0x0073:
            r10.changeNextBtnState(r1)
            r10.showProgressDialog()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.initialize.view.InitializeActivity.onSend(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public void showEulaPpDialog() {
        Dialog dialog;
        DataDialogFragment dataDialogFragment = this.mEulaPpDialog;
        Unit unit = null;
        if (!(dataDialogFragment == null || (dialog = dataDialogFragment.getDialog()) == null)) {
            if (!dialog.isShowing()) {
                dialog.show();
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            this.mEulaPpDialog = DialogHelperUtil.showDataDialog$default(this.mDialogHelper, 0, BaseDialogFragment.Builder.DialogType.EULA_PP, DialogHelperUtil.RequestCode.EULA.ordinal(), 0, 0, 0, 32, (Object) null);
        }
    }

    public void onFail(String str) {
        Intrinsics.checkNotNullParameter(str, "aErrorMessage");
        showErrorDialog(str);
    }

    private final void showProgressDialog() {
        hideErrorDialog();
        DialogInterface showProgressDialog = this.mDialogHelper.showProgressDialog(0, SettingActivityKt.PROGRESS_DIALOG_TAG, false);
        Intrinsics.checkNotNull(showProgressDialog, "null cannot be cast to non-null type jp.co.sony.reonpocket.view.fragment.ProgressDialogFragment");
        this.mProgressDialog = (ProgressDialogFragment) showProgressDialog;
    }

    private final void changeNextBtnState(boolean z) {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (findFragmentById instanceof InitUserInfoFragment) {
            ((InitUserInfoFragment) findFragmentById).changeNextBtnState(z);
        }
    }
}
