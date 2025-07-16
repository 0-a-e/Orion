package jp.co.sony.reonpocket.modules.tagInfo.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.connection.aws.UserInfoEntity;
import jp.co.sony.reonpocket.data.entity.NotificationEntity;
import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.modules.base.view.BaseActivity;
import jp.co.sony.reonpocket.modules.base.view.BaseViewOutput;
import jp.co.sony.reonpocket.modules.connect.view.ConnectionActivity;
import jp.co.sony.reonpocket.modules.main.router.MainRouterKt;
import jp.co.sony.reonpocket.modules.main.view.MainActivityKt;
import jp.co.sony.reonpocket.modules.settings.view.ChangeUserInfoFragment;
import jp.co.sony.reonpocket.modules.settings.view.LegalFragment;
import jp.co.sony.reonpocket.modules.settings.view.OssContentFragment;
import jp.co.sony.reonpocket.modules.tagInfo.presenter.TagInfoPresenter;
import jp.co.sony.reonpocket.util.AnalyticsUtil;
import jp.co.sony.reonpocket.util.DialogBuilderUtil;
import jp.co.sony.reonpocket.util.DialogHelperUtil;
import jp.co.sony.reonpocket.util.RemoteConfigUtil;
import jp.co.sony.reonpocket.view.adapter.SettingItemAdapter;
import jp.co.sony.reonpocket.view.fragment.AlertDialogFragment;
import jp.co.sony.reonpocket.view.fragment.BaseDialogFragment;
import jp.co.sony.reonpocket.view.fragment.DataDialogFragment;
import jp.co.sony.reonpocket.view.fragment.ProgressDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 a2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002abB\u0005¢\u0006\u0002\u0010\u0006J(\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J0\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u001fH\u0002J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002J\b\u0010)\u001a\u00020\u0019H\u0002J\b\u0010*\u001a\u00020\u0019H\u0016J\b\u0010+\u001a\u00020\u0019H\u0002J\b\u0010,\u001a\u00020-H\u0016J\u0012\u0010.\u001a\u00020\u00192\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u0012\u00101\u001a\u00020\u00192\b\u00102\u001a\u0004\u0018\u00010\u001fH\u0002J\b\u00103\u001a\u00020\u0019H\u0016J\b\u00104\u001a\u00020\u0019H\u0016J\u0012\u00105\u001a\u00020\u00192\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0012\u00108\u001a\u00020\u00192\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\u0012\u00109\u001a\u00020\n2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u0018\u0010<\u001a\u00020\u00192\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0016J \u0010A\u001a\u00020\u00192\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010B\u001a\u00020@H\u0016J\u0018\u0010C\u001a\u00020\u00192\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0016J\b\u0010D\u001a\u00020\u0019H\u0016J\b\u0010E\u001a\u00020\u0019H\u0016J\u0010\u0010F\u001a\u00020\u00192\u0006\u0010G\u001a\u00020HH\u0016J\u0010\u0010I\u001a\u00020\n2\u0006\u0010G\u001a\u00020JH\u0016J0\u0010K\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u001f2\u0006\u0010L\u001a\u00020\u001fH\u0016J0\u0010M\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u001fH\u0016J\u0010\u0010N\u001a\u00020\u00192\u0006\u0010O\u001a\u00020@H\u0016J\b\u0010P\u001a\u00020\u0019H\u0016J>\u0010Q\u001a\u00020\u00192\b\u0010R\u001a\u0004\u0018\u00010\u001f2\u0006\u0010S\u001a\u00020\u001f2\u0006\u0010T\u001a\u00020\u001f2\u0006\u0010U\u001a\u00020\u001f2\b\u0010V\u001a\u0004\u0018\u00010\u001f2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J\u0012\u0010Y\u001a\u00020\u00192\b\b\u0002\u00102\u001a\u00020\u001fH\u0002J\b\u0010Z\u001a\u00020\u0019H\u0002J\b\u0010[\u001a\u00020\u0019H\u0016J\u0006\u0010\\\u001a\u00020\u0019J\u0006\u0010]\u001a\u00020\u0019J\u0006\u0010^\u001a\u00020\u0019J\b\u0010_\u001a\u00020\u0019H\u0002J\b\u0010`\u001a\u00020\u0019H\u0016R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"Ljp/co/sony/reonpocket/modules/tagInfo/view/TagInfoActivity;", "Ljp/co/sony/reonpocket/modules/base/view/BaseActivity;", "Ljp/co/sony/reonpocket/modules/tagInfo/view/TagInfoViewInput;", "Ljp/co/sony/reonpocket/modules/settings/view/LegalFragment$OnLegalItemSelectListener;", "Ljp/co/sony/reonpocket/modules/settings/view/ChangeUserInfoFragment$OnChangeUserInfoListener;", "Ljp/co/sony/reonpocket/view/fragment/DataDialogFragment$Callback;", "()V", "mDialogHelper", "Ljp/co/sony/reonpocket/util/DialogHelperUtil;", "mGetValue", "", "mIsNoAmbientTemp", "mIsReceiving", "mIsUseDeviceReadSensor", "mOptionsMenu", "Ljp/co/sony/reonpocket/modules/connect/view/ConnectionActivity$OptionsMenu;", "mOutput", "Ljp/co/sony/reonpocket/modules/tagInfo/view/TagInfoActivity$TagInfoViewOutput;", "mProgressDialog", "Ljp/co/sony/reonpocket/view/fragment/ProgressDialogFragment;", "mSettingMenuDialog", "Ljp/co/sony/reonpocket/view/fragment/DataDialogFragment;", "mTagUnRegisterDialog", "Ljp/co/sony/reonpocket/view/fragment/AlertDialogFragment;", "analyticsSend", "", "aEventName", "Ljp/co/sony/reonpocket/util/AnalyticsUtil$EventName;", "aParamName", "Ljp/co/sony/reonpocket/util/AnalyticsUtil$EventParameter;", "aParam", "", "doUserInfoInit", "aGender", "aAge", "aHeight", "aWeight", "aState", "formatFirstDecimal", "", "value", "hiddenProgressDialog", "hiddenSettingMenuDialog", "hiddenTagUnRegisterDialog", "initPresenter", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewOutput;", "initView", "savedInstanceState", "Landroid/os/Bundle;", "noticeAnalyticsSend", "aMessage", "onBackPressed", "onCancelUserInfo", "onClick", "v", "Landroid/view/View;", "onCreate", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onDataDialogCancelled", "aDialog", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment;", "aRequestCode", "", "onDataDialogSucceeded", "aResultCode", "onDismiss", "onFinishSend", "onInitUserInfo", "onLegalItemSelect", "item", "Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$SettingListItem;", "onOptionsItemSelected", "Landroid/view/MenuItem;", "onSend", "aAddress", "onUserInfoInit", "showErrorMessage", "aStringResId", "showNoMessageProgress", "showNotification", "aButtonPreference", "aTitle", "aSubtitle", "aDescription", "aUrl", "aBitMap", "Landroid/graphics/Bitmap;", "showProgressDialog", "showSettingMenuDialog", "showTagUnRegisterDialog", "transitToChangeUserInfo", "transitToLegalFragment", "transitToOssContentFragment", "transitToStartFragment", "unRegisterTagStatus", "Companion", "TagInfoViewOutput", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagInfoActivity.kt */
public final class TagInfoActivity extends BaseActivity implements TagInfoViewInput, LegalFragment.OnLegalItemSelectListener, ChangeUserInfoFragment.OnChangeUserInfoListener, DataDialogFragment.Callback {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String PROGRESS_DIALOG_TAG = "progress_dialog_tag";
    private DialogHelperUtil mDialogHelper;
    private boolean mGetValue;
    private boolean mIsNoAmbientTemp;
    private boolean mIsReceiving;
    private boolean mIsUseDeviceReadSensor;
    private ConnectionActivity.OptionsMenu mOptionsMenu = ConnectionActivity.OptionsMenu.NONE;
    /* access modifiers changed from: private */
    public TagInfoViewOutput mOutput;
    private ProgressDialogFragment mProgressDialog;
    private DataDialogFragment mSettingMenuDialog;
    private AlertDialogFragment mTagUnRegisterDialog;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u0007H&J\b\u0010\u000f\u001a\u00020\u0007H&J\b\u0010\u0010\u001a\u00020\u0007H&J\b\u0010\u0011\u001a\u00020\u0007H&J\b\u0010\u0012\u001a\u00020\u0007H&¨\u0006\u0013"}, d2 = {"Ljp/co/sony/reonpocket/modules/tagInfo/view/TagInfoActivity$TagInfoViewOutput;", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewOutput;", "getIsTagRegistered", "", "getTagSerialNo", "", "handleSettingMenuTapItem", "", "item", "Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$SettingListItem;", "initUserInfo", "registerUserInfo", "aUserInfoEntity", "Ljp/co/sony/reonpocket/connection/aws/UserInfoEntity;", "showNotification", "transitToEula", "transitToOss", "transitToPrivacy", "unRegisterTag", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TagInfoActivity.kt */
    public interface TagInfoViewOutput extends BaseViewOutput {
        boolean getIsTagRegistered();

        String getTagSerialNo();

        void handleSettingMenuTapItem(SettingItemAdapter.SettingListItem settingListItem);

        void initUserInfo();

        void registerUserInfo(UserInfoEntity userInfoEntity);

        void showNotification();

        void transitToEula();

        void transitToOss();

        void transitToPrivacy();

        void unRegisterTag();
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TagInfoActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|17) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0032 */
        static {
            /*
                jp.co.sony.reonpocket.modules.connect.view.ConnectionActivity$OptionsMenu[] r0 = jp.co.sony.reonpocket.modules.connect.view.ConnectionActivity.OptionsMenu.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                jp.co.sony.reonpocket.modules.connect.view.ConnectionActivity$OptionsMenu r2 = jp.co.sony.reonpocket.modules.connect.view.ConnectionActivity.OptionsMenu.TAG_POPUP     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                jp.co.sony.reonpocket.modules.connect.view.ConnectionActivity$OptionsMenu r3 = jp.co.sony.reonpocket.modules.connect.view.ConnectionActivity.OptionsMenu.OK     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem[] r0 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r3 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.LICENSE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r1 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.PRIVACY_POLICY     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r1 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.OPEN_SOURCE     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.tagInfo.view.TagInfoActivity.WhenMappings.<clinit>():void");
        }
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

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reonpocket/modules/tagInfo/view/TagInfoActivity$Companion;", "", "()V", "PROGRESS_DIALOG_TAG", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TagInfoActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public BaseViewOutput initPresenter() {
        TagInfoViewOutput tagInfoPresenter = new TagInfoPresenter(this, this);
        this.mOutput = tagInfoPresenter;
        Intrinsics.checkNotNull(tagInfoPresenter, "null cannot be cast to non-null type jp.co.sony.reonpocket.modules.tagInfo.presenter.TagInfoPresenter");
        return (TagInfoPresenter) tagInfoPresenter;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Transition inflateTransition = TransitionInflater.from(this).inflateTransition(R.transition.bottom_top_transition);
        Window window = getWindow();
        Intrinsics.checkNotNull(inflateTransition);
        window.setEnterTransition(inflateTransition);
        setContentView(R.layout.activity_tag_info);
        setMRootToolbar((Toolbar) findViewById(R.id.toolbar));
        setSupportActionBar(getMRootToolbar());
        setMActionBar(getSupportActionBar());
        ActionBar mActionBar = getMActionBar();
        if (mActionBar != null) {
            mActionBar.setDisplayShowTitleEnabled(false);
        }
        setNavigationIcon(R.drawable.ic_close, this);
        this.mDialogHelper = DialogHelperUtil.Companion.newInstance((FragmentActivity) this);
        initView(bundle);
    }

    private final void initView(Bundle bundle) {
        ConnectionActivity.OptionsMenu optionsMenu;
        TagInfoViewOutput tagInfoViewOutput = this.mOutput;
        String tagSerialNo = tagInfoViewOutput != null ? tagInfoViewOutput.getTagSerialNo() : null;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.mIsReceiving = extras.getBoolean(MainRouterKt.MAIN_VIEW_TAG_INFO_RECEIVING, false);
            this.mIsNoAmbientTemp = extras.getBoolean(MainRouterKt.MAIN_VIEW_TAG_NO_AMBIENT_TEMP, false);
            float formatFirstDecimal = formatFirstDecimal(extras.getFloat(MainRouterKt.MAIN_VIEW_TAG_INFO_TEMP, 0.0f));
            float formatFirstDecimal2 = formatFirstDecimal(extras.getFloat(MainRouterKt.MAIN_VIEW_TAG_INFO_HUMI, 0.0f));
            int i = extras.getInt(MainRouterKt.MAIN_VIEW_BATTERY_REMAINING, 0);
            this.mGetValue = extras.getBoolean(MainRouterKt.MAIN_VIEW_TAG_INFO_GET_VALUE, false);
            this.mIsUseDeviceReadSensor = extras.getBoolean(MainRouterKt.MAIN_VIEW_IS_USE_DEVICE_READ_SENSOR, false);
            if (bundle == null) {
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
                if (this.mGetValue) {
                    beginTransaction.replace(R.id.fragment_container, TagInfoFragment.Companion.newInstance(this.mIsReceiving, this.mIsNoAmbientTemp, tagSerialNo, formatFirstDecimal, formatFirstDecimal2, i, this.mIsUseDeviceReadSensor));
                } else {
                    beginTransaction.replace(R.id.fragment_container, TagInfoFragment.Companion.newInstance(this.mIsReceiving, this.mIsNoAmbientTemp, tagSerialNo, 0.0f, 0.0f, 0, false));
                }
                beginTransaction.commit();
                TagInfoViewOutput tagInfoViewOutput2 = this.mOutput;
                if (tagInfoViewOutput2 == null || !tagInfoViewOutput2.getIsTagRegistered()) {
                    optionsMenu = ConnectionActivity.OptionsMenu.NONE;
                } else {
                    optionsMenu = ConnectionActivity.OptionsMenu.TAG_POPUP;
                }
                this.mOptionsMenu = optionsMenu;
            }
        }
    }

    private final float formatFirstDecimal(float f) {
        return ((float) MathKt.roundToInt(f * 10.0f)) / 10.0f;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        int i = WhenMappings.$EnumSwitchMapping$0[this.mOptionsMenu.ordinal()];
        if (i == 1) {
            showSettingMenuDialog();
        } else if (i == 2) {
            Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
            if (findFragmentById instanceof ChangeUserInfoFragment) {
                ((ChangeUserInfoFragment) findFragmentById).sendUserInfo();
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onBackPressed() {
        super.onBackPressed();
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (findFragmentById instanceof TagInfoFragment) {
            ActionBar mActionBar = getMActionBar();
            if (mActionBar != null) {
                mActionBar.setDisplayShowTitleEnabled(false);
            }
            setMenuIconVisibility(true);
        }
        if (findFragmentById instanceof LegalFragment) {
            setToolbarTitle(R.string.setting_top_legal);
        }
        if (findFragmentById instanceof OssContentFragment) {
            setToolbarTitle(R.string.setting_top_license);
        }
        invalidateOptionsMenu();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (isToolbar()) {
            getMenuInflater().inflate(this.mOptionsMenu.getId(), menu);
            setMenuIconVisibility(this.mOptionsMenu != ConnectionActivity.OptionsMenu.NONE);
        }
        return super.onCreateOptionsMenu(menu);
    }

    private final void showSettingMenuDialog() {
        this.mSettingMenuDialog = DialogBuilderUtil.INSTANCE.showSettingMenuDialog(this, new TagInfoActivity$showSettingMenuDialog$1(this));
    }

    public void hiddenSettingMenuDialog() {
        Dialog dialog;
        DataDialogFragment dataDialogFragment = this.mSettingMenuDialog;
        if (dataDialogFragment != null && (dialog = dataDialogFragment.getDialog()) != null) {
            dialog.dismiss();
        }
    }

    public void showNotification(String str, String str2, String str3, String str4, String str5, Bitmap bitmap) {
        String str6;
        DialogHelperUtil dialogHelperUtil;
        DialogHelperUtil dialogHelperUtil2;
        String str7 = str;
        Intrinsics.checkNotNullParameter(str2, "aTitle");
        Intrinsics.checkNotNullParameter(str3, "aSubtitle");
        Intrinsics.checkNotNullParameter(str4, "aDescription");
        NotificationEntity mNotificationEntity = RemoteConfigUtil.INSTANCE.getMNotificationEntity();
        if (mNotificationEntity == null || (str6 = Integer.valueOf(mNotificationEntity.getVersion()).toString()) == null) {
            str6 = AnalyticsUtil.ParameterConstants.NO_ID.getValue();
        }
        noticeAnalyticsSend(str6);
        if (str7 == null || !Intrinsics.areEqual((Object) str7, (Object) MainActivityKt.BUTTON_PREFERENCE_TOP_LEFT)) {
            DialogHelperUtil dialogHelperUtil3 = this.mDialogHelper;
            if (dialogHelperUtil3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
                dialogHelperUtil = null;
            } else {
                dialogHelperUtil = dialogHelperUtil3;
            }
            dialogHelperUtil.showDataDialog(str2, BaseDialogFragment.Builder.DialogType.INFORMATION, DialogHelperUtil.RequestCode.INFORMATION.ordinal(), R.string.common_ok, 0).setLifecycleListener(new TagInfoActivity$showNotification$2(str3, str4, str5, this, bitmap));
            return;
        }
        DialogHelperUtil dialogHelperUtil4 = this.mDialogHelper;
        if (dialogHelperUtil4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil2 = null;
        } else {
            dialogHelperUtil2 = dialogHelperUtil4;
        }
        DialogHelperUtil.showDataDialog$default(dialogHelperUtil2, 0, BaseDialogFragment.Builder.DialogType.INFORMATION_PATTERN_2, DialogHelperUtil.RequestCode.INFORMATION.ordinal(), 0, 0, 0, 32, (Object) null).setLifecycleListener(new TagInfoActivity$showNotification$1$1(str2, str3, str4, str5, this, bitmap));
    }

    /* access modifiers changed from: private */
    public final void noticeAnalyticsSend(String str) {
        analyticsSend(AnalyticsUtil.EventName.SHOW_INFORMATION, AnalyticsUtil.EventParameter.NOTIFICATION_ID, str);
    }

    static /* synthetic */ void analyticsSend$default(TagInfoActivity tagInfoActivity, AnalyticsUtil.EventName eventName, AnalyticsUtil.EventParameter eventParameter, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            eventParameter = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        tagInfoActivity.analyticsSend(eventName, eventParameter, str);
    }

    private final void analyticsSend(AnalyticsUtil.EventName eventName, AnalyticsUtil.EventParameter eventParameter, String str) {
        AnalyticsUtil.INSTANCE.logEventWithString(this, getMFirebaseAnalytics(), eventName, eventParameter, str);
    }

    public final void transitToLegalFragment() {
        setToolbarTitle(R.string.setting_top_legal);
        setNavigationIcon(R.drawable.ic_back, this);
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
        invalidateOptionsMenu();
        this.mOptionsMenu = ConnectionActivity.OptionsMenu.NONE;
    }

    public final void transitToChangeUserInfo() {
        setToolbarTitle(R.string.user_info_title);
        setNavigationIcon(R.drawable.ic_back, this);
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
        invalidateOptionsMenu();
        this.mOptionsMenu = ConnectionActivity.OptionsMenu.OK;
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
        invalidateOptionsMenu();
        this.mOptionsMenu = ConnectionActivity.OptionsMenu.NONE;
    }

    public void showTagUnRegisterDialog() {
        DialogBuilderUtil.INSTANCE.showTagUnRegisterDialog(this, (TagDataEntity) null, new TagInfoActivity$showTagUnRegisterDialog$1(this));
    }

    public void unRegisterTagStatus() {
        TagInfoViewOutput tagInfoViewOutput = this.mOutput;
        if (tagInfoViewOutput != null) {
            tagInfoViewOutput.unRegisterTag();
        }
    }

    /* access modifiers changed from: private */
    public final void hiddenTagUnRegisterDialog() {
        Dialog dialog;
        AlertDialogFragment alertDialogFragment = this.mTagUnRegisterDialog;
        if (alertDialogFragment != null && (dialog = alertDialogFragment.getDialog()) != null) {
            dialog.dismiss();
        }
    }

    public void showNoMessageProgress() {
        showProgressDialog("");
    }

    public void showErrorMessage(int i) {
        DialogHelperUtil dialogHelperUtil = this.mDialogHelper;
        if (dialogHelperUtil == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil = null;
        }
        dialogHelperUtil.showConfirmationDialog(i, 0, 0, DialogHelperUtil.RequestCode.NO_REQUEST.ordinal(), Integer.valueOf(R.string.common_ok), (Integer) 0);
    }

    public void onUserInfoInit(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "aGender");
        Intrinsics.checkNotNullParameter(str2, "aAge");
        Intrinsics.checkNotNullParameter(str3, "aHeight");
        Intrinsics.checkNotNullParameter(str4, "aWeight");
        Intrinsics.checkNotNullParameter(str5, "aState");
        doUserInfoInit(str, str2, str3, str4, str5);
    }

    public void onFinishSend() {
        if (getSupportFragmentManager().findFragmentById(R.id.fragment_container) instanceof ChangeUserInfoFragment) {
            transitToStartFragment();
            invalidateOptionsMenu();
        }
        hiddenProgressDialog();
    }

    private final void doUserInfoInit(String str, String str2, String str3, String str4, String str5) {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (findFragmentById instanceof ChangeUserInfoFragment) {
            ((ChangeUserInfoFragment) findFragmentById).doInitDataSetting(str, str2, str3, str4, str5);
        }
    }

    static /* synthetic */ void showProgressDialog$default(TagInfoActivity tagInfoActivity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tagInfoActivity.getString(R.string.connect_on_going_title);
            Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
        }
        tagInfoActivity.showProgressDialog(str);
    }

    private final void showProgressDialog(String str) {
        hideErrorDialog();
        DialogHelperUtil dialogHelperUtil = this.mDialogHelper;
        if (dialogHelperUtil == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil = null;
        }
        DialogInterface showProgressDialog = dialogHelperUtil.showProgressDialog(str, "progress_dialog_tag", false);
        Intrinsics.checkNotNull(showProgressDialog, "null cannot be cast to non-null type jp.co.sony.reonpocket.view.fragment.ProgressDialogFragment");
        this.mProgressDialog = (ProgressDialogFragment) showProgressDialog;
    }

    /* access modifiers changed from: private */
    public final void hiddenProgressDialog() {
        Dialog dialog;
        ProgressDialogFragment progressDialogFragment = this.mProgressDialog;
        if (progressDialogFragment != null && (dialog = progressDialogFragment.getDialog()) != null) {
            dialog.dismiss();
        }
    }

    public void onLegalItemSelect(SettingItemAdapter.SettingListItem settingListItem) {
        TagInfoViewOutput tagInfoViewOutput;
        Intrinsics.checkNotNullParameter(settingListItem, "item");
        int i = WhenMappings.$EnumSwitchMapping$1[settingListItem.getType().ordinal()];
        if (i == 1) {
            TagInfoViewOutput tagInfoViewOutput2 = this.mOutput;
            if (tagInfoViewOutput2 != null) {
                tagInfoViewOutput2.transitToEula();
            }
        } else if (i == 2) {
            TagInfoViewOutput tagInfoViewOutput3 = this.mOutput;
            if (tagInfoViewOutput3 != null) {
                tagInfoViewOutput3.transitToPrivacy();
            }
        } else if (i == 3 && (tagInfoViewOutput = this.mOutput) != null) {
            tagInfoViewOutput.transitToOss();
        }
    }

    public void onInitUserInfo() {
        TagInfoViewOutput tagInfoViewOutput = this.mOutput;
        if (tagInfoViewOutput != null) {
            tagInfoViewOutput.initUserInfo();
        }
    }

    public void onCancelUserInfo() {
        if (getSupportFragmentManager().findFragmentById(R.id.fragment_container) instanceof ChangeUserInfoFragment) {
            transitToStartFragment();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSend(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /*
            r9 = this;
            java.lang.String r0 = "aGender"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "aAge"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "aHeight"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "aWeight"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "aAddress"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            android.content.res.Resources r0 = android.content.res.Resources.getSystem()
            android.content.res.Configuration r0 = r0.getConfiguration()
            androidx.core.os.LocaleListCompat r0 = androidx.core.os.ConfigurationCompat.getLocales(r0)
            r1 = 0
            java.util.Locale r0 = r0.get(r1)
            if (r0 == 0) goto L_0x0031
            java.lang.String r1 = r0.getLanguage()
            goto L_0x0032
        L_0x0031:
            r1 = 0
        L_0x0032:
            java.util.Locale r2 = java.util.Locale.JAPANESE
            java.lang.String r2 = r2.toString()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x0042
            java.lang.String r0 = "Japan"
        L_0x0040:
            r6 = r0
            goto L_0x0061
        L_0x0042:
            java.util.Locale r2 = java.util.Locale.CHINESE
            java.lang.String r2 = r2.toString()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            java.lang.String r2 = "Other"
            if (r1 == 0) goto L_0x0060
            java.lang.String r0 = r0.getCountry()
            java.lang.String r1 = "hk"
            r3 = 1
            boolean r0 = kotlin.text.StringsKt.equals(r0, r1, r3)
            if (r0 == 0) goto L_0x0060
            java.lang.String r0 = "HongKong"
            goto L_0x0040
        L_0x0060:
            r6 = r2
        L_0x0061:
            jp.co.sony.reonpocket.modules.tagInfo.view.TagInfoActivity$TagInfoViewOutput r0 = r9.mOutput
            if (r0 == 0) goto L_0x0073
            jp.co.sony.reonpocket.connection.aws.UserInfoEntity r8 = new jp.co.sony.reonpocket.connection.aws.UserInfoEntity
            r1 = r8
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r7 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r0.registerUserInfo(r8)
        L_0x0073:
            java.lang.String r10 = ""
            r9.showProgressDialog(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.tagInfo.view.TagInfoActivity.onSend(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public void onClick(View view) {
        super.onClick(view);
        if (view != null) {
            Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
            if (findFragmentById instanceof LegalFragment) {
                ActionBar mActionBar = getMActionBar();
                if (mActionBar != null) {
                    mActionBar.setDisplayShowTitleEnabled(false);
                }
                getSupportFragmentManager().popBackStack();
                this.mOptionsMenu = ConnectionActivity.OptionsMenu.TAG_POPUP;
                invalidateOptionsMenu();
            } else if (findFragmentById instanceof ChangeUserInfoFragment) {
                ActionBar mActionBar2 = getMActionBar();
                if (mActionBar2 != null) {
                    mActionBar2.setDisplayShowTitleEnabled(false);
                }
                getSupportFragmentManager().popBackStack();
                this.mOptionsMenu = ConnectionActivity.OptionsMenu.TAG_POPUP;
                invalidateOptionsMenu();
            } else if (findFragmentById instanceof OssContentFragment) {
                setToolbarTitle(R.string.setting_top_legal);
                getSupportFragmentManager().popBackStack();
                setMenuIconVisibility(false);
            } else {
                finish();
            }
        }
    }

    private final void transitToStartFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            ActionBar mActionBar = getMActionBar();
            if (mActionBar != null) {
                mActionBar.setDisplayShowTitleEnabled(false);
            }
            setNavigationIcon(R.drawable.ic_close, this);
            this.mOptionsMenu = ConnectionActivity.OptionsMenu.TAG_POPUP;
            setMenuIconVisibility(true);
            getSupportFragmentManager().popBackStack((String) null, 1);
            setNavigationIconStatus(true);
            invalidateOptionsMenu();
        }
    }
}
