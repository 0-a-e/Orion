package jp.co.sony.reonpocket.modules.settings.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.transition.Slide;
import androidx.transition.TransitionSet;
import java.util.ArrayList;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.connection.aws.UserInfoEntity;
import jp.co.sony.reonpocket.constant.BleConnStatusCode;
import jp.co.sony.reonpocket.constant.IntentExtraConstant;
import jp.co.sony.reonpocket.constant.UpdateVersionConstant;
import jp.co.sony.reonpocket.data.entity.CapabilityEntity;
import jp.co.sony.reonpocket.data.entity.NotificationEntity;
import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.modules.autoStart.view.AutoStartActivity;
import jp.co.sony.reonpocket.modules.base.view.BaseActivity;
import jp.co.sony.reonpocket.modules.base.view.BaseViewOutput;
import jp.co.sony.reonpocket.modules.connect.view.ConnectionActivity;
import jp.co.sony.reonpocket.modules.locationSetting.view.LocationSettingActivity;
import jp.co.sony.reonpocket.modules.main.view.MainActivityKt;
import jp.co.sony.reonpocket.modules.quickMode.view.QuickLaunchActivity;
import jp.co.sony.reonpocket.modules.settings.presenter.SettingPresenter;
import jp.co.sony.reonpocket.modules.settings.view.ChangeUserInfoFragment;
import jp.co.sony.reonpocket.modules.settings.view.LegalFragment;
import jp.co.sony.reonpocket.modules.settings.view.SettingFragment;
import jp.co.sony.reonpocket.modules.splash.view.SplashActivity;
import jp.co.sony.reonpocket.util.AnalyticsUtil;
import jp.co.sony.reonpocket.util.DialogBuilderUtil;
import jp.co.sony.reonpocket.util.DialogHelperUtil;
import jp.co.sony.reonpocket.util.MyContentUtil;
import jp.co.sony.reonpocket.util.RemoteConfigUtil;
import jp.co.sony.reonpocket.view.adapter.SettingItemAdapter;
import jp.co.sony.reonpocket.view.fragment.AlertDialogFragment;
import jp.co.sony.reonpocket.view.fragment.BaseDialogFragment;
import jp.co.sony.reonpocket.view.fragment.DataDialogFragment;
import jp.co.sony.reonpocket.view.fragment.ProgressDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0002\u0001B\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0014H\u0016J\u0010\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020\u0014H\u0002J\u0010\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020\u0014H\u0002J0\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u00020\u0014H\u0002J\n\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u00106\u001a\u0004\u0018\u00010\u0014J\b\u00107\u001a\u00020\u0014H\u0016J\b\u00108\u001a\u00020\u0014H\u0016J\b\u00109\u001a\u00020'H\u0016J\b\u0010:\u001a\u00020'H\u0002J\b\u0010;\u001a\u00020'H\u0002J\b\u0010<\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u00020'2\u0006\u0010?\u001a\u00020\tH\u0002J\b\u0010@\u001a\u00020\tH\u0016J\b\u0010A\u001a\u00020\tH\u0014J \u0010B\u001a\u00020'2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020FH\u0016J\b\u0010H\u001a\u00020'H\u0016J\b\u0010I\u001a\u00020'H\u0016J\u0012\u0010J\u001a\u00020'2\b\u0010K\u001a\u0004\u0018\u00010\u001fH\u0016J,\u0010L\u001a\u00020'2\u0006\u0010M\u001a\u00020N2\u001a\u0010O\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010Pj\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`QH\u0016J\u0012\u0010R\u001a\u00020'2\b\u0010S\u001a\u0004\u0018\u00010TH\u0014J\u0012\u0010U\u001a\u00020\t2\b\u0010V\u001a\u0004\u0018\u00010WH\u0016J\u0018\u0010X\u001a\u00020'2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0016J \u0010Y\u001a\u00020'2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020FH\u0016J\u0018\u0010Z\u001a\u00020'2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010[\u001a\u00020'2\u0006\u0010\\\u001a\u00020\u0014H\u0016J\b\u0010]\u001a\u00020'H\u0016J\b\u0010^\u001a\u00020'H\u0016J\u0010\u0010_\u001a\u00020'2\u0006\u0010`\u001a\u00020aH\u0016J\u0010\u0010b\u001a\u00020'2\u0006\u0010`\u001a\u00020aH\u0016J\u0014\u0010c\u001a\u00020'2\n\u0010d\u001a\u0006\u0012\u0002\b\u00030eH\u0002J\b\u0010f\u001a\u00020'H\u0016J\b\u0010g\u001a\u00020'H\u0014J0\u0010h\u001a\u00020'2\u0006\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u00020\u00142\u0006\u0010i\u001a\u00020\u0014H\u0016J\b\u0010j\u001a\u00020'H\u0016J\b\u0010k\u001a\u00020'H\u0016J0\u0010l\u001a\u00020'2\u0006\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u00020\u0014H\u0016J\b\u0010m\u001a\u00020'H\u0002J\u0010\u0010n\u001a\u00020'2\u0006\u0010o\u001a\u00020FH\u0016J\b\u0010p\u001a\u00020'H\u0002J>\u0010q\u001a\u00020'2\b\u0010r\u001a\u0004\u0018\u00010\u00142\u0006\u0010s\u001a\u00020\u00142\u0006\u0010t\u001a\u00020\u00142\u0006\u0010u\u001a\u00020\u00142\b\u0010)\u001a\u0004\u0018\u00010\u00142\b\u0010v\u001a\u0004\u0018\u00010wH\u0016J\u0012\u0010x\u001a\u00020'2\b\b\u0002\u0010y\u001a\u00020\u0014H\u0002J&\u0010z\u001a\u00020'2\u0006\u0010{\u001a\u00020#2\u0006\u0010|\u001a\u00020\u00142\f\u0010}\u001a\b\u0012\u0004\u0012\u00020'0&H\u0016J\b\u0010~\u001a\u00020'H\u0002J\b\u0010\u001a\u00020'H\u0016J\t\u0010\u0001\u001a\u00020'H\u0002J\u0019\u0010\u0001\u001a\u00020'2\u0006\u0010{\u001a\u00020#2\u0006\u0010|\u001a\u00020\u0014H\u0002J\t\u0010\u0001\u001a\u00020'H\u0016J\t\u0010\u0001\u001a\u00020'H\u0002J\t\u0010\u0001\u001a\u00020'H\u0016J\t\u0010\u0001\u001a\u00020'H\u0016J\u0007\u0010\u0001\u001a\u00020'J\u0007\u0010\u0001\u001a\u00020'J\u0007\u0010\u0001\u001a\u00020'J\u0011\u0010\u0001\u001a\u00020'2\u0006\u0010+\u001a\u00020\u0014H\u0016J\u0011\u0010\u0001\u001a\u00020'2\u0006\u0010-\u001a\u00020\u0014H\u0016R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0014XD¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X.¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Ljp/co/sony/reonpocket/modules/settings/view/SettingActivity;", "Ljp/co/sony/reonpocket/modules/base/view/BaseActivity;", "Ljp/co/sony/reonpocket/modules/settings/view/SettingViewInput;", "Ljp/co/sony/reonpocket/modules/settings/view/SettingFragment$OnSettingListener;", "Ljp/co/sony/reonpocket/modules/settings/view/LegalFragment$OnLegalItemSelectListener;", "Ljp/co/sony/reonpocket/view/fragment/DataDialogFragment$Callback;", "Ljp/co/sony/reonpocket/modules/settings/view/ChangeUserInfoFragment$OnChangeUserInfoListener;", "()V", "isFoundDialogDisplay", "", "isSettingConfiguration", "mDialogHelper", "Ljp/co/sony/reonpocket/util/DialogHelperUtil;", "mImageView", "Landroid/widget/ImageView;", "mInitDialog", "Ljp/co/sony/reonpocket/view/fragment/AlertDialogFragment;", "mIsTransit", "mIsUserInfo", "mMessage", "", "mOutput", "Ljp/co/sony/reonpocket/modules/settings/view/SettingActivity$SettingViewOutput;", "mProgressDialog", "Ljp/co/sony/reonpocket/view/fragment/ProgressDialogFragment;", "mSuspendReason", "Ljp/co/sony/reonpocket/modules/settings/presenter/SettingPresenter$SuspendReason;", "mTagRegisterSuccessDialog", "Ljp/co/sony/reonpocket/view/fragment/DataDialogFragment;", "mTagUnRegisterDialog", "mTwitterView", "Landroid/view/View;", "mUnregisterDialog", "progressDialogDefaultMessage", "scanTagInfo", "Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity;", "scanTagModelName", "setConfigurationCompletionProcess", "Lkotlin/Function0;", "", "clickUserFeedBack", "aUrl", "doUpdateFirmwareReversion", "aFirmwareReversion", "doUpdateModelName", "aModelName", "doUserInfoInit", "aGender", "aAge", "aHeight", "aWeight", "aState", "getCapability", "Ljp/co/sony/reonpocket/data/entity/CapabilityEntity;", "getFeedbackUrl", "getTagFwVersion", "getTagModelName", "hideProgress", "hideProgressDialog", "hideTagUnRegisterDialog", "initPresenter", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewOutput;", "isShowTwitterView", "isShow", "isTagRegistered", "isToolbar", "onAlertDialogSucceeded", "aDialog", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment;", "aRequestCode", "", "aResultCode", "onCancelUserInfo", "onChangeUserSelected", "onClick", "v", "onConnectionStatus", "aConnStatusCode", "Ljp/co/sony/reonpocket/constant/BleConnStatusCode;", "aServiceUuidList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onDataDialogCancelled", "onDataDialogSucceeded", "onDismiss", "onFail", "aErrorMessage", "onFinishSend", "onInitUserInfo", "onItemSelect", "item", "Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$SettingListItem;", "onLegalItemSelect", "onNextPage", "aClass", "Ljava/lang/Class;", "onRequestDataInit", "onResume", "onSend", "aAddress", "onSuccess", "onUnregisteredTag", "onUserInfoInit", "setOnBackPressedEvent", "showErrorMessage", "aStringResId", "showNoMessageProgressDialog", "showNotification", "aButtonPreference", "aTitle", "aSubtitle", "aDescription", "aBitMap", "Landroid/graphics/Bitmap;", "showProgressDialog", "aMessage", "showTagFoundDialog", "aTagInfo", "aTagModelName", "positiveCompletion", "showTagNotFoundDialog", "showTagNotFoundPopup", "showTagRegisterDialog", "showTagRegisteredDialog", "showTagRegistrationFailedDialog", "showTagUnRegisterDialog", "tagRegisteredFailed", "tagRegisteredSuccess", "transitToChangeUserInfo", "transitToLegalFragment", "transitToOssContentFragment", "updateFirmwareReversion", "updateModelName", "SettingViewOutput", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SettingActivity.kt */
public final class SettingActivity extends BaseActivity implements SettingViewInput, SettingFragment.OnSettingListener, LegalFragment.OnLegalItemSelectListener, DataDialogFragment.Callback, ChangeUserInfoFragment.OnChangeUserInfoListener {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public boolean isFoundDialogDisplay;
    /* access modifiers changed from: private */
    public boolean isSettingConfiguration;
    private DialogHelperUtil mDialogHelper;
    /* access modifiers changed from: private */
    public ImageView mImageView;
    private AlertDialogFragment mInitDialog;
    private boolean mIsTransit;
    /* access modifiers changed from: private */
    public boolean mIsUserInfo;
    private String mMessage;
    /* access modifiers changed from: private */
    public SettingViewOutput mOutput;
    private ProgressDialogFragment mProgressDialog;
    private SettingPresenter.SuspendReason mSuspendReason = SettingPresenter.SuspendReason.NONE;
    private DataDialogFragment mTagRegisterSuccessDialog;
    private AlertDialogFragment mTagUnRegisterDialog;
    private View mTwitterView;
    private AlertDialogFragment mUnregisterDialog;
    private final String progressDialogDefaultMessage = "";
    /* access modifiers changed from: private */
    public TagDataEntity scanTagInfo;
    /* access modifiers changed from: private */
    public String scanTagModelName;
    /* access modifiers changed from: private */
    public Function0<Unit> setConfigurationCompletionProcess;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\u000bH&J\n\u0010\f\u001a\u0004\u0018\u00010\rH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000bH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0003H&J\b\u0010\u0017\u001a\u00020\u0003H&J\b\u0010\u0018\u001a\u00020\u0003H&J\b\u0010\u0019\u001a\u00020\u0003H&J\b\u0010\u001a\u001a\u00020\u0003H&J\b\u0010\u001b\u001a\u00020\u0003H&J\b\u0010\u001c\u001a\u00020\u0003H&J\b\u0010\u001d\u001a\u00020\u0003H&J\b\u0010\u001e\u001a\u00020\u0003H&J\b\u0010\u001f\u001a\u00020\u0003H&J\b\u0010 \u001a\u00020\u0003H&J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u000bH&J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u000bH&J\b\u0010$\u001a\u00020\u0003H&J\b\u0010%\u001a\u00020\u0003H&¨\u0006&"}, d2 = {"Ljp/co/sony/reonpocket/modules/settings/view/SettingActivity$SettingViewOutput;", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewOutput;", "disConnect", "", "doDeviceUnregister", "getCapability", "Ljp/co/sony/reonpocket/data/entity/CapabilityEntity;", "getIsTagRegistered", "", "getOnWriteSetTagControlResult", "getTagFwVersion", "", "getTagInfo", "Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity;", "getTagModelName", "getUserFeedbackUrl", "initData", "initUserInfo", "onTagWriteFailed", "registerUserInfo", "aUserInfoEntity", "Ljp/co/sony/reonpocket/connection/aws/UserInfoEntity;", "showNotification", "tagScan", "transitToAutoStart", "transitToBatteryNotification", "transitToChangeUserInfo", "transitToEula", "transitToLegal", "transitToOss", "transitToPrivacy", "transitToQuickLaunch", "transitToSupport", "transitToTwitter", "aUrl", "transitToUserFeedback", "unregisterTag", "writeInitialize", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: SettingActivity.kt */
    public interface SettingViewOutput extends BaseViewOutput {
        void disConnect();

        void doDeviceUnregister();

        CapabilityEntity getCapability();

        boolean getIsTagRegistered();

        boolean getOnWriteSetTagControlResult();

        String getTagFwVersion();

        TagDataEntity getTagInfo();

        String getTagModelName();

        String getUserFeedbackUrl();

        void initData();

        void initUserInfo();

        void onTagWriteFailed();

        void registerUserInfo(UserInfoEntity userInfoEntity);

        void showNotification();

        void tagScan();

        void transitToAutoStart();

        void transitToBatteryNotification();

        void transitToChangeUserInfo();

        void transitToEula();

        void transitToLegal();

        void transitToOss();

        void transitToPrivacy();

        void transitToQuickLaunch();

        void transitToSupport();

        void transitToTwitter(String str);

        void transitToUserFeedback(String str);

        void unregisterTag();

        void writeInitialize();
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: SettingActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(2:19|20)|21|23) */
        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|23) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem[] r0 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r1 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.UNREGISTER_DEVICE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r1 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.INITIALIZE_DEVICE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r1 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.LEGAL     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r1 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.INFORMATION     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r1 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.SUPPORT_PAGE     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r1 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.TAG_REGISTER     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r1 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.TAG_UNREGISTER     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r1 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.LICENSE     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r1 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.PRIVACY_POLICY     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r1 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.OPEN_SOURCE     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.settings.view.SettingActivity.WhenMappings.<clinit>():void");
        }
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

    public BaseViewOutput initPresenter() {
        SettingViewOutput settingPresenter = new SettingPresenter(this, this);
        this.mOutput = settingPresenter;
        Intrinsics.checkNotNull(settingPresenter, "null cannot be cast to non-null type jp.co.sony.reonpocket.modules.settings.presenter.SettingPresenter");
        return (SettingPresenter) settingPresenter;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_setting_top);
        setMRootToolbar((Toolbar) findViewById(R.id.toolbar));
        setSupportActionBar(getMRootToolbar());
        setMActionBar(getSupportActionBar());
        ActionBar mActionBar = getMActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayShowTitleEnabled(false);
        }
        setToolbarTitle(R.string.setting_top_title);
        setNavigationIcon(R.drawable.ic_back, this);
        this.mDialogHelper = DialogHelperUtil.Companion.newInstance((FragmentActivity) this);
        if (bundle == null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
            beginTransaction.replace(R.id.fragment_container, SettingFragment.Companion.newInstance());
            beginTransaction.commit();
            this.mIsUserInfo = false;
            isShowTwitterView(MyContentUtil.INSTANCE.isShowTwitter(this));
        }
        RemoteConfigUtil.INSTANCE.fetchAndActivate(this, getMFirebaseRemoteConfig(), new SettingActivity$onCreate$1());
        setOnBackPressedEvent();
    }

    private final void setOnBackPressedEvent() {
        getOnBackPressedDispatcher().addCallback(new SettingActivity$setOnBackPressedEvent$callback$1(this));
    }

    /* access modifiers changed from: private */
    public final void isShowTwitterView(boolean z) {
        if (z) {
            if (this.mTwitterView == null) {
                View inflate = ((ViewStub) findViewById(R.id.twitter_ribbon)).inflate();
                this.mTwitterView = inflate;
                if (inflate != null) {
                    inflate.setOnClickListener(new SettingActivity$$ExternalSyntheticLambda1(this));
                    Unit unit = Unit.INSTANCE;
                }
            }
            View view = this.mTwitterView;
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        View view2 = this.mTwitterView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public static final void isShowTwitterView$lambda$1$lambda$0(SettingActivity settingActivity, View view) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        SettingViewOutput settingViewOutput = settingActivity.mOutput;
        if (settingViewOutput != null) {
            String string = settingActivity.getString(R.string.app_twitter_url);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            settingViewOutput.transitToTwitter(string);
        }
        AnalyticsUtil.logEventWithString$default(AnalyticsUtil.INSTANCE, settingActivity, settingActivity.getMFirebaseAnalytics(), AnalyticsUtil.EventName.TWITTER_LINK_TAP, (AnalyticsUtil.EventParameter) null, (String) null, 24, (Object) null);
    }

    private final void onNextPage(Class<?> cls) {
        SettingViewOutput settingViewOutput;
        if (Intrinsics.areEqual((Object) cls, (Object) AutoStartActivity.class)) {
            SettingViewOutput settingViewOutput2 = this.mOutput;
            if (settingViewOutput2 != null) {
                settingViewOutput2.transitToAutoStart();
            }
        } else if (Intrinsics.areEqual((Object) cls, (Object) QuickLaunchActivity.class)) {
            SettingViewOutput settingViewOutput3 = this.mOutput;
            if (settingViewOutput3 != null) {
                settingViewOutput3.transitToQuickLaunch();
            }
        } else if (Intrinsics.areEqual((Object) cls, (Object) LocationSettingActivity.class) && (settingViewOutput = this.mOutput) != null) {
            settingViewOutput.transitToBatteryNotification();
        }
    }

    public void onItemSelect(SettingItemAdapter.SettingListItem settingListItem) {
        DialogHelperUtil dialogHelperUtil;
        DialogHelperUtil dialogHelperUtil2;
        Intrinsics.checkNotNullParameter(settingListItem, "item");
        switch (WhenMappings.$EnumSwitchMapping$0[settingListItem.getType().ordinal()]) {
            case 1:
                DialogHelperUtil dialogHelperUtil3 = this.mDialogHelper;
                if (dialogHelperUtil3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
                    dialogHelperUtil = null;
                } else {
                    dialogHelperUtil = dialogHelperUtil3;
                }
                this.mUnregisterDialog = dialogHelperUtil.showConfirmationDialog(R.string.setting_unregister_title, R.string.setting_unregister_subtitle, 0, DialogHelperUtil.RequestCode.SETTING_UNREGISTER.ordinal(), Integer.valueOf(R.string.setting_unregister_buttun), Integer.valueOf(R.string.common_cancel));
                return;
            case 2:
                DialogHelperUtil dialogHelperUtil4 = this.mDialogHelper;
                if (dialogHelperUtil4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
                    dialogHelperUtil2 = null;
                } else {
                    dialogHelperUtil2 = dialogHelperUtil4;
                }
                this.mInitDialog = dialogHelperUtil2.showConfirmationDialog(R.string.setting_initialize_subtitle, R.string.setting_initialize_description, 0, DialogHelperUtil.RequestCode.SETTING_INITIALIZE.ordinal(), Integer.valueOf(R.string.common_ok), Integer.valueOf(R.string.common_cancel));
                return;
            case 3:
                SettingViewOutput settingViewOutput = this.mOutput;
                if (settingViewOutput != null) {
                    settingViewOutput.transitToLegal();
                    return;
                }
                return;
            case 4:
                showNoMessageProgressDialog();
                SettingViewOutput settingViewOutput2 = this.mOutput;
                if (settingViewOutput2 != null) {
                    settingViewOutput2.showNotification();
                    return;
                }
                return;
            case 5:
                SettingViewOutput settingViewOutput3 = this.mOutput;
                if (settingViewOutput3 != null) {
                    settingViewOutput3.transitToSupport();
                    return;
                }
                return;
            case 6:
                showTagRegisterDialog();
                return;
            case 7:
                showTagUnRegisterDialog();
                return;
            default:
                Class<?> view = settingListItem.getView();
                if (view != null) {
                    onNextPage(view);
                    return;
                }
                return;
        }
    }

    /* access modifiers changed from: private */
    public final void showTagRegisterDialog() {
        if (!getMIsPaused()) {
            DialogBuilderUtil.INSTANCE.showTagRegisterDialog(this, new SettingActivity$showTagRegisterDialog$1(this));
        }
    }

    private final void showTagNotFoundDialog() {
        DialogBuilderUtil.INSTANCE.showTagNotFoundDialog(this, new SettingActivity$showTagNotFoundDialog$1(this));
    }

    /* access modifiers changed from: private */
    public final void showTagRegisteredDialog(TagDataEntity tagDataEntity, String str) {
        if (!getMIsPaused()) {
            this.mTagRegisterSuccessDialog = DialogBuilderUtil.INSTANCE.showTagRegisteredDialog(this, tagDataEntity, str, new SettingActivity$showTagRegisteredDialog$1(this));
            if (tagDataEntity.getFwVersionCode() < Integer.parseInt(UpdateVersionConstant.TAG_FIRMWARE_VERSION_CODE)) {
                tagDataEntity.getFwVersionCode();
            }
        }
    }

    private final void showTagUnRegisterDialog() {
        SettingViewOutput settingViewOutput = this.mOutput;
        DialogBuilderUtil.INSTANCE.showTagUnRegisterDialog(this, settingViewOutput != null ? settingViewOutput.getTagInfo() : null, new SettingActivity$showTagUnRegisterDialog$1(this));
    }

    private final void hideTagUnRegisterDialog() {
        Dialog dialog;
        AlertDialogFragment alertDialogFragment = this.mTagUnRegisterDialog;
        if (alertDialogFragment != null && (dialog = alertDialogFragment.getDialog()) != null) {
            dialog.dismiss();
        }
    }

    public void showTagRegistrationFailedDialog() {
        DialogBuilderUtil.INSTANCE.showTagRegistrationFailedDialog(this, new SettingActivity$showTagRegistrationFailedDialog$1(this));
    }

    public void showTagFoundDialog(TagDataEntity tagDataEntity, String str, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(tagDataEntity, "aTagInfo");
        Intrinsics.checkNotNullParameter(str, "aTagModelName");
        Intrinsics.checkNotNullParameter(function0, "positiveCompletion");
        if (!this.isFoundDialogDisplay) {
            this.isFoundDialogDisplay = true;
            if (!getMIsPaused()) {
                DialogBuilderUtil.INSTANCE.showTagFoundDialog(this, tagDataEntity, str, new SettingActivity$showTagFoundDialog$1(this, tagDataEntity, str, function0));
            }
        }
    }

    public void tagRegisteredSuccess() {
        String str;
        if (this.isSettingConfiguration) {
            this.isSettingConfiguration = false;
            TagDataEntity tagDataEntity = this.scanTagInfo;
            if (tagDataEntity != null && (str = this.scanTagModelName) != null) {
                showTagRegisteredDialog(tagDataEntity, str);
            }
        }
    }

    public void tagRegisteredFailed() {
        if (this.isSettingConfiguration) {
            this.isSettingConfiguration = false;
            showTagRegistrationFailedDialog();
        }
    }

    public void onUnregisteredTag() {
        finish();
    }

    public final void transitToLegalFragment() {
        isShowTwitterView(false);
        setToolbarTitle(R.string.setting_top_legal);
        TransitionSet transitionSet = new TransitionSet();
        Slide slide = new Slide();
        slide.setSlideEdge(GravityCompat.END);
        transitionSet.addTransition(slide);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
        beginTransaction.addToBackStack((String) null);
        LegalFragment newInstance = LegalFragment.Companion.newInstance();
        newInstance.setEnterTransition(transitionSet);
        beginTransaction.replace(R.id.fragment_container, newInstance);
        beginTransaction.commit();
        this.mIsUserInfo = false;
        invalidateOptionsMenu();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem item;
        getMenuInflater().inflate(R.menu.menu_ok, menu);
        Toolbar mRootToolbar = getMRootToolbar();
        if (mRootToolbar != null) {
            mRootToolbar.setPadding(0, 0, getResources().getDimensionPixelSize(R.dimen.settingChangeUserInfoOkButtonRightMargin), 0);
        }
        if (menu == null || (item = menu.getItem(0)) == null) {
            return true;
        }
        item.setOnMenuItemClickListener(new SettingActivity$$ExternalSyntheticLambda0(this));
        item.setVisible(this.mIsUserInfo);
        return true;
    }

    /* access modifiers changed from: private */
    public static final boolean onCreateOptionsMenu$lambda$6$lambda$5(SettingActivity settingActivity, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(settingActivity, "this$0");
        Intrinsics.checkNotNullParameter(menuItem, "it");
        Fragment findFragmentById = settingActivity.getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (!(findFragmentById instanceof ChangeUserInfoFragment)) {
            return true;
        }
        ((ChangeUserInfoFragment) findFragmentById).sendUserInfo();
        return true;
    }

    public final void transitToChangeUserInfo() {
        setToolbarTitle(R.string.user_info_title);
        isShowTwitterView(false);
        TransitionSet transitionSet = new TransitionSet();
        Slide slide = new Slide();
        slide.setSlideEdge(GravityCompat.END);
        transitionSet.addTransition(slide);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
        beginTransaction.addToBackStack((String) null);
        ChangeUserInfoFragment newInstance = ChangeUserInfoFragment.Companion.newInstance();
        newInstance.setEnterTransition(transitionSet);
        beginTransaction.replace(R.id.fragment_container, newInstance);
        beginTransaction.commit();
        this.mIsUserInfo = true;
        invalidateOptionsMenu();
    }

    public void onLegalItemSelect(SettingItemAdapter.SettingListItem settingListItem) {
        Intrinsics.checkNotNullParameter(settingListItem, "item");
        switch (WhenMappings.$EnumSwitchMapping$0[settingListItem.getType().ordinal()]) {
            case 8:
                SettingViewOutput settingViewOutput = this.mOutput;
                if (settingViewOutput != null) {
                    settingViewOutput.transitToEula();
                    return;
                }
                return;
            case 9:
                SettingViewOutput settingViewOutput2 = this.mOutput;
                if (settingViewOutput2 != null) {
                    settingViewOutput2.transitToPrivacy();
                    return;
                }
                return;
            case 10:
                SettingViewOutput settingViewOutput3 = this.mOutput;
                if (settingViewOutput3 != null) {
                    settingViewOutput3.transitToOss();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void transitToOssContentFragment() {
        setToolbarTitle(R.string.setting_top_license);
        TransitionSet transitionSet = new TransitionSet();
        Slide slide = new Slide();
        slide.setSlideEdge(GravityCompat.END);
        transitionSet.addTransition(slide);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
        beginTransaction.addToBackStack((String) null);
        OssContentFragment newInstance = OssContentFragment.Companion.newInstance();
        newInstance.setEnterTransition(transitionSet);
        beginTransaction.replace(R.id.fragment_container, newInstance);
        beginTransaction.commit();
        this.mIsUserInfo = false;
        invalidateOptionsMenu();
    }

    public void onFail(String str) {
        Intrinsics.checkNotNullParameter(str, "aErrorMessage");
        this.mMessage = str;
        showErrorDialog(str);
    }

    public void onSuccess() {
        AnalyticsUtil.logEventWithBundle$default(AnalyticsUtil.INSTANCE, this, getMFirebaseAnalytics(), AnalyticsUtil.EventName.DEVICE_INITIALIZE, (Bundle) null, 8, (Object) null);
        showProgressDialog$default(this, (String) null, 1, (Object) null);
        this.mMessage = SettingActivityKt.BUNDLE_BY_INITIALIZE;
    }

    public void updateFirmwareReversion(String str) {
        Intrinsics.checkNotNullParameter(str, "aFirmwareReversion");
        doUpdateFirmwareReversion(str);
    }

    public void updateModelName(String str) {
        Intrinsics.checkNotNullParameter(str, "aModelName");
        doUpdateModelName(str);
    }

    public void onRequestDataInit() {
        SettingViewOutput settingViewOutput = this.mOutput;
        if (settingViewOutput != null) {
            settingViewOutput.initData();
        }
    }

    public void onClick(View view) {
        super.onClick(view);
        if (view != null) {
            this.mIsUserInfo = false;
            invalidateOptionsMenu();
            Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
            if (findFragmentById instanceof LegalFragment) {
                setToolbarTitle(R.string.setting_top_title);
                isShowTwitterView(MyContentUtil.INSTANCE.isShowTwitter(this));
                getSupportFragmentManager().popBackStack();
            } else if (findFragmentById instanceof OssContentFragment) {
                setToolbarTitle(R.string.setting_top_legal);
                getSupportFragmentManager().popBackStack();
            } else if (findFragmentById instanceof ChangeUserInfoFragment) {
                setToolbarTitle(R.string.setting_top_title);
                isShowTwitterView(MyContentUtil.INSTANCE.isShowTwitter(this));
                getSupportFragmentManager().popBackStack();
            } else {
                finish();
            }
        }
    }

    private final void doUpdateModelName(String str) {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (findFragmentById instanceof SettingFragment) {
            ((SettingFragment) findFragmentById).updateModelName(str);
        }
    }

    private final void doUpdateFirmwareReversion(String str) {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (findFragmentById instanceof SettingFragment) {
            ((SettingFragment) findFragmentById).updateFirmwareReversion(str);
        }
    }

    public void onAlertDialogSucceeded(BaseDialogFragment baseDialogFragment, int i, int i2) {
        Intrinsics.checkNotNullParameter(baseDialogFragment, "aDialog");
        super.onAlertDialogSucceeded(baseDialogFragment, i, i2);
        if (i == DialogHelperUtil.RequestCode.NO_REQUEST.ordinal()) {
            hideProgressDialog();
        } else if (i == DialogHelperUtil.RequestCode.SETTING_INITIALIZE.ordinal()) {
            if (i2 == -1) {
                SettingViewOutput settingViewOutput = this.mOutput;
                if (settingViewOutput != null) {
                    settingViewOutput.writeInitialize();
                }
                this.mSuspendReason = SettingPresenter.SuspendReason.INITIALIZATION;
            }
        } else if (i == DialogHelperUtil.RequestCode.SETTING_UNREGISTER.ordinal()) {
            if (i2 == -1) {
                this.mSuspendReason = SettingPresenter.SuspendReason.UNREGISTER;
                SettingViewOutput settingViewOutput2 = this.mOutput;
                if (settingViewOutput2 != null) {
                    settingViewOutput2.doDeviceUnregister();
                }
                BaseActivity.transitAndClear$default(this, SplashActivity.class, (Bundle) null, 2, (Object) null);
                finish();
            }
        } else if (i != DialogHelperUtil.RequestCode.TAG_UNREGISTER.ordinal()) {
        } else {
            if (i2 == -1) {
                SettingViewOutput settingViewOutput3 = this.mOutput;
                if (settingViewOutput3 != null) {
                    settingViewOutput3.unregisterTag();
                }
                hideTagUnRegisterDialog();
                finish();
                return;
            }
            hideTagUnRegisterDialog();
        }
    }

    static /* synthetic */ void showProgressDialog$default(SettingActivity settingActivity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = settingActivity.progressDialogDefaultMessage;
        }
        settingActivity.showProgressDialog(str);
    }

    /* access modifiers changed from: private */
    public final void showProgressDialog(String str) {
        DialogHelperUtil dialogHelperUtil = this.mDialogHelper;
        if (dialogHelperUtil == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil = null;
        }
        DialogInterface showProgressDialog = dialogHelperUtil.showProgressDialog(str, SettingActivityKt.PROGRESS_DIALOG_TAG, false);
        Intrinsics.checkNotNull(showProgressDialog, "null cannot be cast to non-null type jp.co.sony.reonpocket.view.fragment.ProgressDialogFragment");
        this.mProgressDialog = (ProgressDialogFragment) showProgressDialog;
    }

    private final void showNoMessageProgressDialog() {
        showProgressDialog("");
    }

    /* access modifiers changed from: private */
    public final void hideProgressDialog() {
        Dialog dialog;
        ProgressDialogFragment progressDialogFragment = this.mProgressDialog;
        if (progressDialogFragment != null && (dialog = progressDialogFragment.getDialog()) != null) {
            dialog.dismiss();
        }
    }

    public void showNotification(String str, String str2, String str3, String str4, String str5, Bitmap bitmap) {
        Unit unit;
        DialogHelperUtil dialogHelperUtil;
        DialogHelperUtil dialogHelperUtil2;
        String str6 = str;
        Intrinsics.checkNotNullParameter(str2, "aTitle");
        Intrinsics.checkNotNullParameter(str3, "aSubtitle");
        Intrinsics.checkNotNullParameter(str4, "aDescription");
        NotificationEntity mNotificationEntity = RemoteConfigUtil.INSTANCE.getMNotificationEntity();
        if (mNotificationEntity != null) {
            AnalyticsUtil.INSTANCE.logEventWithString(this, getMFirebaseAnalytics(), AnalyticsUtil.EventName.SHOW_INFORMATION, AnalyticsUtil.EventParameter.NOTIFICATION_ID, String.valueOf(mNotificationEntity.getVersion()));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            AnalyticsUtil.INSTANCE.logEventWithString(this, getMFirebaseAnalytics(), AnalyticsUtil.EventName.SHOW_INFORMATION, AnalyticsUtil.EventParameter.NOTIFICATION_ID, AnalyticsUtil.ParameterConstants.NO_ID.getValue());
        }
        if (str6 == null || !Intrinsics.areEqual((Object) str6, (Object) MainActivityKt.BUTTON_PREFERENCE_TOP_LEFT)) {
            DialogHelperUtil dialogHelperUtil3 = this.mDialogHelper;
            if (dialogHelperUtil3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
                dialogHelperUtil = null;
            } else {
                dialogHelperUtil = dialogHelperUtil3;
            }
            dialogHelperUtil.showDataDialog(str2, BaseDialogFragment.Builder.DialogType.INFORMATION, DialogHelperUtil.RequestCode.INFORMATION.ordinal(), R.string.common_ok, 0).setLifecycleListener(new SettingActivity$showNotification$4(str3, this, str4, str5, bitmap));
            return;
        }
        DialogHelperUtil dialogHelperUtil4 = this.mDialogHelper;
        if (dialogHelperUtil4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil2 = null;
        } else {
            dialogHelperUtil2 = dialogHelperUtil4;
        }
        DialogHelperUtil.showDataDialog$default(dialogHelperUtil2, 0, BaseDialogFragment.Builder.DialogType.INFORMATION_PATTERN_2, DialogHelperUtil.RequestCode.INFORMATION.ordinal(), 0, 0, 0, 32, (Object) null).setLifecycleListener(new SettingActivity$showNotification$3$1(str2, str3, this, str4, str5, bitmap));
    }

    public void onChangeUserSelected() {
        SettingViewOutput settingViewOutput = this.mOutput;
        if (settingViewOutput != null) {
            settingViewOutput.transitToChangeUserInfo();
        }
    }

    public void onInitUserInfo() {
        SettingViewOutput settingViewOutput = this.mOutput;
        if (settingViewOutput != null) {
            settingViewOutput.initUserInfo();
        }
    }

    private final void doUserInfoInit(String str, String str2, String str3, String str4, String str5) {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (findFragmentById instanceof ChangeUserInfoFragment) {
            ((ChangeUserInfoFragment) findFragmentById).doInitDataSetting(str, str2, str3, str4, str5);
        }
    }

    public void onUserInfoInit(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "aGender");
        Intrinsics.checkNotNullParameter(str2, "aAge");
        Intrinsics.checkNotNullParameter(str3, "aHeight");
        Intrinsics.checkNotNullParameter(str4, "aWeight");
        Intrinsics.checkNotNullParameter(str5, "aState");
        doUserInfoInit(str, str2, str3, str4, str5);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSend(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17) {
        /*
            r12 = this;
            r0 = r12
            java.lang.String r1 = "aGender"
            r3 = r13
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r1)
            java.lang.String r1 = "aAge"
            r4 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r1)
            java.lang.String r1 = "aHeight"
            r5 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r1)
            java.lang.String r1 = "aWeight"
            r6 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)
            java.lang.String r1 = "aAddress"
            r8 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
            android.content.res.Resources r1 = android.content.res.Resources.getSystem()
            android.content.res.Configuration r1 = r1.getConfiguration()
            androidx.core.os.LocaleListCompat r1 = androidx.core.os.ConfigurationCompat.getLocales(r1)
            r2 = 0
            java.util.Locale r1 = r1.get(r2)
            r9 = 0
            if (r1 == 0) goto L_0x003a
            java.lang.String r2 = r1.getLanguage()
            goto L_0x003b
        L_0x003a:
            r2 = r9
        L_0x003b:
            java.util.Locale r7 = java.util.Locale.JAPANESE
            java.lang.String r7 = r7.toString()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r7)
            r10 = 1
            if (r7 == 0) goto L_0x004c
            java.lang.String r1 = "Japan"
        L_0x004a:
            r7 = r1
            goto L_0x0069
        L_0x004c:
            java.util.Locale r7 = java.util.Locale.CHINESE
            java.lang.String r7 = r7.toString()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r7)
            java.lang.String r7 = "Other"
            if (r2 == 0) goto L_0x0069
            java.lang.String r1 = r1.getCountry()
            java.lang.String r2 = "hk"
            boolean r1 = kotlin.text.StringsKt.equals(r1, r2, r10)
            if (r1 == 0) goto L_0x0069
            java.lang.String r1 = "HongKong"
            goto L_0x004a
        L_0x0069:
            jp.co.sony.reonpocket.modules.settings.view.SettingActivity$SettingViewOutput r1 = r0.mOutput
            if (r1 == 0) goto L_0x007d
            jp.co.sony.reonpocket.connection.aws.UserInfoEntity r11 = new jp.co.sony.reonpocket.connection.aws.UserInfoEntity
            r2 = r11
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r8 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r1.registerUserInfo(r11)
        L_0x007d:
            showProgressDialog$default(r12, r9, r10, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.settings.view.SettingActivity.onSend(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public void onFinishSend() {
        if (getSupportFragmentManager().findFragmentById(R.id.fragment_container) instanceof ChangeUserInfoFragment) {
            setToolbarTitle(R.string.setting_top_title);
            getSupportFragmentManager().popBackStack();
            this.mIsUserInfo = false;
            invalidateOptionsMenu();
        }
        hideProgressDialog();
    }

    public void onCancelUserInfo() {
        if (getSupportFragmentManager().findFragmentById(R.id.fragment_container) instanceof ChangeUserInfoFragment) {
            setToolbarTitle(R.string.setting_top_title);
            getSupportFragmentManager().popBackStack();
        }
    }

    public void onConnectionStatus(BleConnStatusCode bleConnStatusCode, ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(bleConnStatusCode, "aConnStatusCode");
        if (!isAppOnForeground()) {
            this.mIsTransit = true;
            BaseActivity.ActivityReferenceUtil.INSTANCE.finishOtherActivity(getClass());
        } else if (this.mSuspendReason != SettingPresenter.SuspendReason.UNREGISTER) {
            Bundle bundle = new Bundle();
            bundle.putString(MainActivityKt.MAIN_ACTIVITY_ERROR_REASON, this.mMessage);
            if (this.mSuspendReason == SettingPresenter.SuspendReason.INITIALIZATION) {
                bundle.putBoolean(IntentExtraConstant.FromSplash.IS_CONNECT_WHEN_ON_CREATE.getKey(), false);
            } else {
                bundle.putBoolean(IntentExtraConstant.FromSplash.IS_CONNECT_WHEN_ON_CREATE.getKey(), true);
            }
            transitAndClear(ConnectionActivity.class, bundle);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.mIsTransit) {
            Bundle bundle = new Bundle();
            bundle.putString(MainActivityKt.MAIN_ACTIVITY_ERROR_REASON, this.mMessage);
            bundle.putBoolean(IntentExtraConstant.FromSplash.IS_CONNECT_WHEN_ON_CREATE.getKey(), false);
            transitAndClear(ConnectionActivity.class, bundle);
            finish();
        }
    }

    public void showErrorMessage(int i) {
        DialogHelperUtil dialogHelperUtil = this.mDialogHelper;
        if (dialogHelperUtil == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil = null;
        }
        dialogHelperUtil.showConfirmationDialog(i, 0, 0, DialogHelperUtil.RequestCode.NO_REQUEST.ordinal(), Integer.valueOf(R.string.common_ok), (Integer) 0);
    }

    public void clickUserFeedBack(String str) {
        Intrinsics.checkNotNullParameter(str, "aUrl");
        SettingViewOutput settingViewOutput = this.mOutput;
        if (settingViewOutput != null) {
            settingViewOutput.transitToUserFeedback(str);
        }
    }

    public final String getFeedbackUrl() {
        SettingViewOutput settingViewOutput = this.mOutput;
        if (settingViewOutput != null) {
            return settingViewOutput.getUserFeedbackUrl();
        }
        return null;
    }

    public boolean isTagRegistered() {
        SettingViewOutput settingViewOutput = this.mOutput;
        if (settingViewOutput != null) {
            return settingViewOutput.getIsTagRegistered();
        }
        return false;
    }

    public void hideProgress() {
        hideProgressDialog();
    }

    public void showTagNotFoundPopup() {
        showTagNotFoundDialog();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getTagModelName();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getTagModelName() {
        /*
            r1 = this;
            jp.co.sony.reonpocket.modules.settings.view.SettingActivity$SettingViewOutput r0 = r1.mOutput
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = r0.getTagModelName()
            if (r0 != 0) goto L_0x000c
        L_0x000a:
            java.lang.String r0 = ""
        L_0x000c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.settings.view.SettingActivity.getTagModelName():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getTagFwVersion();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getTagFwVersion() {
        /*
            r1 = this;
            jp.co.sony.reonpocket.modules.settings.view.SettingActivity$SettingViewOutput r0 = r1.mOutput
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = r0.getTagFwVersion()
            if (r0 != 0) goto L_0x000b
            goto L_0x000c
        L_0x000b:
            return r0
        L_0x000c:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.settings.view.SettingActivity.getTagFwVersion():java.lang.String");
    }

    public CapabilityEntity getCapability() {
        SettingViewOutput settingViewOutput = this.mOutput;
        if (settingViewOutput != null) {
            return settingViewOutput.getCapability();
        }
        return null;
    }
}
