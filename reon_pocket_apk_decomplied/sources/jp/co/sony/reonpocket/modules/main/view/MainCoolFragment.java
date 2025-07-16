package jp.co.sony.reonpocket.modules.main.view;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatToggleButton;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.constant.ContinuousOperationStatus;
import jp.co.sony.reonpocket.constant.CoolHeatTypeCode;
import jp.co.sony.reonpocket.constant.DeviceCoolingCode;
import jp.co.sony.reonpocket.constant.DeviceModeActionCode;
import jp.co.sony.reonpocket.constant.DeviceModeSettingTriggerCode;
import jp.co.sony.reonpocket.constant.FanStepCode;
import jp.co.sony.reonpocket.constant.ModeCommonSettingOperation;
import jp.co.sony.reonpocket.constant.MyModeActionType;
import jp.co.sony.reonpocket.constant.MyModeOperationCode;
import jp.co.sony.reonpocket.constant.MyModeSpecialSubMode;
import jp.co.sony.reonpocket.constant.MyModeTypeCode;
import jp.co.sony.reonpocket.constant.MyTempStepCode;
import jp.co.sony.reonpocket.constant.SwitchCoolHeatWaitStatus;
import jp.co.sony.reonpocket.constant.TempBoostOption;
import jp.co.sony.reonpocket.constant.TempStepCode;
import jp.co.sony.reonpocket.constant.TempWaveOption;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import jp.co.sony.reonpocket.data.entity.CapabilityEntity;
import jp.co.sony.reonpocket.data.entity.DeviceModeEntity;
import jp.co.sony.reonpocket.modules.base.view.BaseFragment;
import jp.co.sony.reonpocket.util.AnalyticsUtil;
import jp.co.sony.reonpocket.util.DialogHelperUtil;
import jp.co.sony.reonpocket.view.CustomFontTextView;
import jp.co.sony.reonpocket.view.CustomSlideView;
import jp.co.sony.reonpocket.view.fragment.BaseDialogFragment;
import jp.co.sony.reonpocket.view.fragment.DataDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 ^2\u00020\u00012\u00020\u0002:\u0006^_`abcB\u0005¢\u0006\u0002\u0010\u0003J\u000e\u00102\u001a\u0002032\u0006\u00104\u001a\u000205J\u0010\u00106\u001a\u0002032\u0006\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u0002032\u0006\u00107\u001a\u000208H\u0016J\u0010\u0010:\u001a\u0002032\u0006\u0010;\u001a\u00020\u0019H\u0002J\u0010\u0010<\u001a\u0002032\u0006\u0010=\u001a\u00020>H\u0003J\u0012\u0010?\u001a\u0002032\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J&\u0010B\u001a\u0004\u0018\u00010>2\u0006\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010F2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010G\u001a\u000203H\u0016J\b\u0010H\u001a\u000203H\u0016J\u0010\u0010I\u001a\u0002032\u0006\u0010J\u001a\u000208H\u0016J\b\u0010K\u001a\u000203H\u0016J\u001a\u0010L\u001a\u0002032\u0006\u0010M\u001a\u00020>2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u0006\u0010N\u001a\u000203J\b\u0010O\u001a\u000203H\u0016J\u0010\u0010P\u001a\u0002032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010Q\u001a\u0002032\u0006\u0010R\u001a\u00020,H\u0016J\u0017\u0010S\u001a\u0002032\b\u0010T\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010UJ\u0010\u0010V\u001a\u0002032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010W\u001a\u0002032\u0006\u0010X\u001a\u00020YH\u0002J\b\u0010Z\u001a\u000203H\u0016J\u0010\u0010[\u001a\u0002032\u0006\u0010\\\u001a\u00020]H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0018\u00010\u000eR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001dj\b\u0012\u0004\u0012\u00020\u0007`\u001eX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020#0\u001dj\b\u0012\u0004\u0012\u00020#`\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X.¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u001dj\b\u0012\u0004\u0012\u00020\u000b`\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainCoolFragment;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment;", "Ljp/co/sony/reonpocket/modules/main/view/MainCoolViewInput;", "()V", "aDeviceModeActionCode", "Ljp/co/sony/reonpocket/constant/DeviceModeActionCode;", "aInitLevel", "", "aTempWaveOption", "Ljp/co/sony/reonpocket/constant/TempWaveOption;", "mAutoButton", "Landroidx/appcompat/widget/AppCompatToggleButton;", "mCoolWaveOption", "mCountDown", "Ljp/co/sony/reonpocket/modules/main/view/MainCoolFragment$CustomCountDown;", "mCountDownTextView", "Ljp/co/sony/reonpocket/view/CustomFontTextView;", "mCurrentLevel", "mDataFormat", "Ljava/text/SimpleDateFormat;", "mDialogHelper", "Ljp/co/sony/reonpocket/util/DialogHelperUtil;", "mImageView", "Landroid/widget/ImageView;", "mIsCharging", "", "mLevel4Button", "mLevel5Button", "mLevelBackgroundList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mMainActivity", "Ljava/lang/ref/WeakReference;", "Ljp/co/sony/reonpocket/modules/main/view/MainActivity;", "mOffBackgroundList", "Landroid/widget/LinearLayout;", "mOffButton", "Landroidx/appcompat/widget/AppCompatButton;", "mOutput", "Ljp/co/sony/reonpocket/modules/main/view/MainCoolViewOutput;", "mSlideView", "Ljp/co/sony/reonpocket/view/CustomSlideView;", "mSmartButton", "mTempBoostOption", "Ljp/co/sony/reonpocket/constant/TempBoostOption;", "mTempSettingValue", "mToggleButtonList", "mWaveButton", "mWaveDialogFragment", "Ljp/co/sony/reonpocket/view/fragment/DataDialogFragment;", "applyBleDataEntity", "", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "changeLevel4Text", "aText", "", "changeLevel5Text", "changeOffBg", "aIsOff", "initView", "aView", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onFail", "aReason", "onResume", "onViewCreated", "view", "readDeviceMode", "showWaveGuide", "updateActionMode", "updateBoost", "aTempBoostOption", "updateCoolTimer", "aRemainTime", "(Ljava/lang/Integer;)V", "updateCoolWave", "updateDeviceModeInfo", "aDeviceModeEntity", "Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity;", "updateOff", "updateTemp", "aTemp", "Ljp/co/sony/reonpocket/constant/TempStepCode;", "Companion", "CoolHiBoostInitLevel", "CoolHiBoostLevel", "CoolInitLevel", "CoolLevel", "CustomCountDown", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainCoolFragment.kt */
public final class MainCoolFragment extends BaseFragment implements MainCoolViewInput {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DEVICE_MODE_ACTION_CODE = "deviceModeActionCode";
    private static final String INIT_LEVEL = "initLevel";
    private static final String TEMP_WAVE_OPTION = "tempWaveOption";
    private DeviceModeActionCode aDeviceModeActionCode = DeviceModeActionCode.MANUAL;
    private int aInitLevel = TempStepCode.OFF.ordinal();
    private TempWaveOption aTempWaveOption = TempWaveOption.WAVE_OFF;
    private AppCompatToggleButton mAutoButton;
    /* access modifiers changed from: private */
    public TempWaveOption mCoolWaveOption = TempWaveOption.WAVE_OFF;
    private CustomCountDown mCountDown;
    /* access modifiers changed from: private */
    public CustomFontTextView mCountDownTextView;
    /* access modifiers changed from: private */
    public int mCurrentLevel;
    private final SimpleDateFormat mDataFormat = new SimpleDateFormat("m:ss");
    private DialogHelperUtil mDialogHelper;
    /* access modifiers changed from: private */
    public ImageView mImageView;
    private boolean mIsCharging;
    private AppCompatToggleButton mLevel4Button;
    private AppCompatToggleButton mLevel5Button;
    private ArrayList<Integer> mLevelBackgroundList = new ArrayList<>();
    private WeakReference<MainActivity> mMainActivity;
    private ArrayList<LinearLayout> mOffBackgroundList = new ArrayList<>();
    private AppCompatButton mOffButton;
    /* access modifiers changed from: private */
    public MainCoolViewOutput mOutput;
    private CustomSlideView mSlideView;
    private AppCompatButton mSmartButton;
    /* access modifiers changed from: private */
    public TempBoostOption mTempBoostOption = TempBoostOption.NONE;
    /* access modifiers changed from: private */
    public int mTempSettingValue = TempStepCode.STEP_1.getCode();
    /* access modifiers changed from: private */
    public ArrayList<AppCompatToggleButton> mToggleButtonList = new ArrayList<>();
    private AppCompatToggleButton mWaveButton;
    private DataDialogFragment mWaveDialogFragment;

    /* access modifiers changed from: private */
    public static final boolean initView$lambda$10(View view, MotionEvent motionEvent) {
        return false;
    }

    /* access modifiers changed from: private */
    public static final boolean initView$lambda$11(View view, MotionEvent motionEvent) {
        return false;
    }

    /* access modifiers changed from: private */
    public static final boolean initView$lambda$7(View view, MotionEvent motionEvent) {
        return false;
    }

    /* access modifiers changed from: private */
    public static final boolean initView$lambda$8(View view, MotionEvent motionEvent) {
        return false;
    }

    /* access modifiers changed from: private */
    public static final boolean initView$lambda$9(View view, MotionEvent motionEvent) {
        return false;
    }

    @JvmStatic
    public static final MainCoolFragment newInstance(int i, DeviceModeActionCode deviceModeActionCode, TempWaveOption tempWaveOption) {
        return Companion.newInstance(i, deviceModeActionCode, tempWaveOption);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainCoolFragment$Companion;", "", "()V", "DEVICE_MODE_ACTION_CODE", "", "INIT_LEVEL", "TEMP_WAVE_OPTION", "newInstance", "Ljp/co/sony/reonpocket/modules/main/view/MainCoolFragment;", "initLevel", "", "deviceModeActionCode", "Ljp/co/sony/reonpocket/constant/DeviceModeActionCode;", "tempWaveOption", "Ljp/co/sony/reonpocket/constant/TempWaveOption;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainCoolFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ MainCoolFragment newInstance$default(Companion companion, int i, DeviceModeActionCode deviceModeActionCode, TempWaveOption tempWaveOption, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = TempStepCode.OFF.ordinal();
            }
            if ((i2 & 2) != 0) {
                deviceModeActionCode = DeviceModeActionCode.MANUAL;
            }
            if ((i2 & 4) != 0) {
                tempWaveOption = TempWaveOption.WAVE_OFF;
            }
            return companion.newInstance(i, deviceModeActionCode, tempWaveOption);
        }

        @JvmStatic
        public final MainCoolFragment newInstance(int i, DeviceModeActionCode deviceModeActionCode, TempWaveOption tempWaveOption) {
            Intrinsics.checkNotNullParameter(deviceModeActionCode, MainCoolFragment.DEVICE_MODE_ACTION_CODE);
            Intrinsics.checkNotNullParameter(tempWaveOption, MainCoolFragment.TEMP_WAVE_OPTION);
            MainCoolFragment mainCoolFragment = new MainCoolFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(MainCoolFragment.INIT_LEVEL, i);
            bundle.putInt(MainCoolFragment.DEVICE_MODE_ACTION_CODE, deviceModeActionCode.getCode());
            bundle.putInt(MainCoolFragment.TEMP_WAVE_OPTION, tempWaveOption.getCode());
            mainCoolFragment.setArguments(bundle);
            return mainCoolFragment;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainCoolFragment$CoolInitLevel;", "", "(Ljava/lang/String;I)V", "BOOST", "Level_3", "Level_2", "Level_1", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainCoolFragment.kt */
    public enum CoolInitLevel {
        BOOST,
        Level_3,
        Level_2,
        Level_1;

        public static EnumEntries<CoolInitLevel> getEntries() {
            return $ENTRIES;
        }

        static {
            CoolInitLevel[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainCoolFragment$CoolHiBoostInitLevel;", "", "(Ljava/lang/String;I)V", "Level_4", "Level_3", "Level_2", "Level_1", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainCoolFragment.kt */
    public enum CoolHiBoostInitLevel {
        Level_4,
        Level_3,
        Level_2,
        Level_1;

        public static EnumEntries<CoolHiBoostInitLevel> getEntries() {
            return $ENTRIES;
        }

        static {
            CoolHiBoostInitLevel[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainCoolFragment$CoolLevel;", "", "(Ljava/lang/String;I)V", "Level_1", "Level_2", "Level_3", "BOOST", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainCoolFragment.kt */
    public enum CoolLevel {
        Level_1,
        Level_2,
        Level_3,
        BOOST;

        public static EnumEntries<CoolLevel> getEntries() {
            return $ENTRIES;
        }

        static {
            CoolLevel[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainCoolFragment$CoolHiBoostLevel;", "", "(Ljava/lang/String;I)V", "Level_1", "Level_2", "Level_3", "Level_4", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainCoolFragment.kt */
    public enum CoolHiBoostLevel {
        Level_1,
        Level_2,
        Level_3,
        Level_4;

        public static EnumEntries<CoolHiBoostLevel> getEntries() {
            return $ENTRIES;
        }

        static {
            CoolHiBoostLevel[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: jp.co.sony.reonpocket.constant.TempWaveOption} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: jp.co.sony.reonpocket.constant.TempWaveOption} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: jp.co.sony.reonpocket.constant.TempWaveOption} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: jp.co.sony.reonpocket.constant.TempWaveOption} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r6) {
        /*
            r5 = this;
            super.onCreate(r6)
            android.os.Bundle r6 = r5.getArguments()
            if (r6 != 0) goto L_0x000a
            return
        L_0x000a:
            java.lang.String r0 = "initLevel"
            int r0 = r6.getInt(r0)
            r5.aInitLevel = r0
            kotlin.enums.EnumEntries r0 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.getEntries()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x001c:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x0037
            java.lang.Object r1 = r0.next()
            r3 = r1
            jp.co.sony.reonpocket.constant.DeviceModeActionCode r3 = (jp.co.sony.reonpocket.constant.DeviceModeActionCode) r3
            int r3 = r3.getCode()
            java.lang.String r4 = "deviceModeActionCode"
            int r4 = r6.getInt(r4)
            if (r3 != r4) goto L_0x001c
            goto L_0x0038
        L_0x0037:
            r1 = r2
        L_0x0038:
            jp.co.sony.reonpocket.constant.DeviceModeActionCode r1 = (jp.co.sony.reonpocket.constant.DeviceModeActionCode) r1
            if (r1 != 0) goto L_0x003e
            jp.co.sony.reonpocket.constant.DeviceModeActionCode r1 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.MANUAL
        L_0x003e:
            r5.aDeviceModeActionCode = r1
            kotlin.enums.EnumEntries r0 = jp.co.sony.reonpocket.constant.TempWaveOption.getEntries()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x004a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0064
            java.lang.Object r1 = r0.next()
            r3 = r1
            jp.co.sony.reonpocket.constant.TempWaveOption r3 = (jp.co.sony.reonpocket.constant.TempWaveOption) r3
            int r3 = r3.getCode()
            java.lang.String r4 = "tempWaveOption"
            int r4 = r6.getInt(r4)
            if (r3 != r4) goto L_0x004a
            r2 = r1
        L_0x0064:
            jp.co.sony.reonpocket.constant.TempWaveOption r2 = (jp.co.sony.reonpocket.constant.TempWaveOption) r2
            if (r2 != 0) goto L_0x006a
            jp.co.sony.reonpocket.constant.TempWaveOption r2 = jp.co.sony.reonpocket.constant.TempWaveOption.WAVE_OFF
        L_0x006a:
            r5.aTempWaveOption = r2
            java.lang.ref.WeakReference r6 = new java.lang.ref.WeakReference
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()
            java.lang.String r1 = "null cannot be cast to non-null type jp.co.sony.reonpocket.modules.main.view.MainActivity"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            jp.co.sony.reonpocket.modules.main.view.MainActivity r0 = (jp.co.sony.reonpocket.modules.main.view.MainActivity) r0
            r6.<init>(r0)
            r5.mMainActivity = r6
            jp.co.sony.reonpocket.util.DialogHelperUtil$Companion r6 = jp.co.sony.reonpocket.util.DialogHelperUtil.Companion
            r0 = r5
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            jp.co.sony.reonpocket.util.DialogHelperUtil r6 = r6.newInstance((androidx.fragment.app.Fragment) r0)
            r5.mDialogHelper = r6
            jp.co.sony.reonpocket.modules.main.presenter.MainCoolPresenter r6 = new jp.co.sony.reonpocket.modules.main.presenter.MainCoolPresenter
            android.content.Context r0 = r5.requireContext()
            java.lang.String r1 = "requireContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r1 = r5
            jp.co.sony.reonpocket.modules.main.view.MainCoolViewInput r1 = (jp.co.sony.reonpocket.modules.main.view.MainCoolViewInput) r1
            r6.<init>(r0, r1)
            jp.co.sony.reonpocket.modules.main.view.MainCoolViewOutput r6 = (jp.co.sony.reonpocket.modules.main.view.MainCoolViewOutput) r6
            r5.mOutput = r6
            r6.onCreate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.main.view.MainCoolFragment.onCreate(android.os.Bundle):void");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ArrayList<Integer> arrayList;
        ArrayList<LinearLayout> arrayList2;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_main_cool, viewGroup, false);
        MainCoolViewOutput mainCoolViewOutput = this.mOutput;
        if (mainCoolViewOutput == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainCoolViewOutput = null;
        }
        CapabilityEntity capability = mainCoolViewOutput.getCapability();
        if (capability.getCapability3().isSupportCoolStep5()) {
            arrayList = CollectionsKt.arrayListOf(Integer.valueOf(R.color.LevelBackgroundCool1), Integer.valueOf(R.color.LevelBackgroundCool2), Integer.valueOf(R.color.LevelBackgroundCool3), Integer.valueOf(R.color.LevelBackgroundCool4), Integer.valueOf(R.color.LevelBackgroundCool4));
        } else {
            arrayList = CollectionsKt.arrayListOf(Integer.valueOf(R.color.LevelBackgroundCool1), Integer.valueOf(R.color.LevelBackgroundCool2), Integer.valueOf(R.color.LevelBackgroundCool3), Integer.valueOf(R.color.LevelBackgroundCool4));
        }
        this.mLevelBackgroundList = arrayList;
        if (capability.getCapability3().isSupportCoolStep5()) {
            View findViewById = inflate.findViewById(R.id.cool_background_5);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            View findViewById2 = inflate.findViewById(R.id.cool_background_4);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            View findViewById3 = inflate.findViewById(R.id.cool_background_3);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            View findViewById4 = inflate.findViewById(R.id.cool_background_2);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            View findViewById5 = inflate.findViewById(R.id.cool_background_1);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
            arrayList2 = CollectionsKt.arrayListOf(findViewById, findViewById2, findViewById3, findViewById4, findViewById5);
        } else {
            View findViewById6 = inflate.findViewById(R.id.cool_background_4);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
            View findViewById7 = inflate.findViewById(R.id.cool_background_3);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
            View findViewById8 = inflate.findViewById(R.id.cool_background_2);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
            View findViewById9 = inflate.findViewById(R.id.cool_background_1);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
            arrayList2 = CollectionsKt.arrayListOf(findViewById6, findViewById7, findViewById8, findViewById9);
        }
        this.mOffBackgroundList = arrayList2;
        Intrinsics.checkNotNull(inflate);
        initView(inflate);
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        MainCoolViewOutput mainCoolViewOutput = this.mOutput;
        if (mainCoolViewOutput == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainCoolViewOutput = null;
        }
        mainCoolViewOutput.onViewCreated();
    }

    public void onResume() {
        MainActivity mainActivity;
        super.onResume();
        WeakReference<MainActivity> weakReference = this.mMainActivity;
        if (weakReference != null && (mainActivity = (MainActivity) weakReference.get()) != null) {
            mainActivity.setIsShownSmartCoolBefore(false);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        MainCoolViewOutput mainCoolViewOutput = this.mOutput;
        if (mainCoolViewOutput == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainCoolViewOutput = null;
        }
        mainCoolViewOutput.onViewDestroyed();
    }

    public void onDestroy() {
        super.onDestroy();
        MainCoolViewOutput mainCoolViewOutput = this.mOutput;
        if (mainCoolViewOutput == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainCoolViewOutput = null;
        }
        mainCoolViewOutput.onDestroy();
    }

    public final void applyBleDataEntity(BleDataEntity bleDataEntity) {
        Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
        MainCoolViewOutput mainCoolViewOutput = this.mOutput;
        if (mainCoolViewOutput == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainCoolViewOutput = null;
        }
        mainCoolViewOutput.applyBleDataEntity(bleDataEntity);
    }

    private final void initView(View view) {
        CharSequence charSequence;
        CharSequence charSequence2;
        AppCompatButton appCompatButton;
        AppCompatToggleButton appCompatToggleButton;
        if (this.mMainActivity != null) {
            CustomSlideView customSlideView = (CustomSlideView) view.findViewById(R.id.cool_slideView);
            this.mSlideView = customSlideView;
            if (customSlideView != null) {
                customSlideView.setGradientColor(R.color.LevelAutoTopCool, R.color.LevelAutoBottomCool);
            }
            this.mCountDownTextView = (CustomFontTextView) view.findViewById(R.id.cool_countdown);
            MainCoolViewOutput mainCoolViewOutput = this.mOutput;
            AppCompatToggleButton appCompatToggleButton2 = null;
            if (mainCoolViewOutput == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOutput");
                mainCoolViewOutput = null;
            }
            CapabilityEntity capability = mainCoolViewOutput.getCapability();
            ((FrameLayout) view.findViewById(R.id.cool_frame)).setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 9.5f));
            View findViewById = view.findViewById(R.id.level5_toggle_button);
            AppCompatToggleButton appCompatToggleButton3 = (AppCompatToggleButton) findViewById;
            if (capability.getCapability3().isSupportCoolStep5()) {
                charSequence = appCompatToggleButton3.getResources().getString(R.string.accessibility_common_level_5);
            } else {
                ((LinearLayout) view.findViewById(R.id.cool_background_1)).setVisibility(8);
                charSequence = null;
            }
            appCompatToggleButton3.setContentDescription(charSequence);
            appCompatToggleButton3.setClickable(false);
            Intrinsics.checkNotNullExpressionValue(findViewById, "apply(...)");
            this.mLevel5Button = appCompatToggleButton3;
            View findViewById2 = view.findViewById(R.id.level4_toggle_button);
            AppCompatToggleButton appCompatToggleButton4 = (AppCompatToggleButton) findViewById2;
            if (capability.getCapability3().isSupportCoolStep4()) {
                charSequence2 = appCompatToggleButton4.getResources().getString(R.string.accessibility_common_level_4);
            } else if (!capability.getCapability3().isSupportCoolStep4() && !capability.getCapability3().isSupportCoolStep5()) {
                charSequence2 = appCompatToggleButton4.getResources().getString(R.string.accessibility_common_boost);
            }
            appCompatToggleButton4.setContentDescription(charSequence2);
            appCompatToggleButton4.setClickable(false);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "apply(...)");
            this.mLevel4Button = appCompatToggleButton4;
            AppCompatToggleButton appCompatToggleButton5 = (AppCompatToggleButton) view.findViewById(R.id.level3_toggle_button);
            appCompatToggleButton5.setContentDescription(appCompatToggleButton5.getResources().getString(R.string.accessibility_common_level_3));
            appCompatToggleButton5.setClickable(false);
            AppCompatToggleButton appCompatToggleButton6 = (AppCompatToggleButton) view.findViewById(R.id.level2_toggle_button);
            appCompatToggleButton6.setContentDescription(appCompatToggleButton6.getResources().getString(R.string.accessibility_common_level_2));
            appCompatToggleButton6.setClickable(false);
            AppCompatToggleButton appCompatToggleButton7 = (AppCompatToggleButton) view.findViewById(R.id.level1_toggle_button);
            appCompatToggleButton7.setContentDescription(appCompatToggleButton7.getResources().getString(R.string.accessibility_common_level_1));
            appCompatToggleButton7.setClickable(false);
            boolean isSupportCoolStep4 = capability.getCapability3().isSupportCoolStep4();
            if (isSupportCoolStep4) {
                AppCompatToggleButton appCompatToggleButton8 = this.mLevel4Button;
                if (appCompatToggleButton8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLevel4Button");
                    appCompatToggleButton8 = null;
                }
                appCompatToggleButton8.setText(getString(R.string.mainview_content_level_4_indicator));
                AppCompatToggleButton appCompatToggleButton9 = this.mLevel4Button;
                if (appCompatToggleButton9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLevel4Button");
                    appCompatToggleButton9 = null;
                }
                appCompatToggleButton9.setTextOn(getString(R.string.mainview_content_level_4_indicator));
                AppCompatToggleButton appCompatToggleButton10 = this.mLevel4Button;
                if (appCompatToggleButton10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLevel4Button");
                    appCompatToggleButton10 = null;
                }
                appCompatToggleButton10.setTextOff(getString(R.string.mainview_content_level_4_indicator));
            } else if (!capability.getCapability3().isSupportCoolStep4() && !capability.getCapability3().isSupportCoolStep5()) {
                AppCompatToggleButton appCompatToggleButton11 = this.mLevel4Button;
                if (appCompatToggleButton11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLevel4Button");
                    appCompatToggleButton11 = null;
                }
                appCompatToggleButton11.setText(getString(R.string.mainview_content_boost_indicator));
                AppCompatToggleButton appCompatToggleButton12 = this.mLevel4Button;
                if (appCompatToggleButton12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLevel4Button");
                    appCompatToggleButton12 = null;
                }
                appCompatToggleButton12.setTextOn(getString(R.string.mainview_content_boost_indicator));
                AppCompatToggleButton appCompatToggleButton13 = this.mLevel4Button;
                if (appCompatToggleButton13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLevel4Button");
                    appCompatToggleButton13 = null;
                }
                appCompatToggleButton13.setTextOff(getString(R.string.mainview_content_boost_indicator));
            }
            boolean isSupportCoolStep5 = capability.getCapability3().isSupportCoolStep5();
            if (isSupportCoolStep5) {
                AppCompatToggleButton appCompatToggleButton14 = this.mLevel5Button;
                if (appCompatToggleButton14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLevel5Button");
                    appCompatToggleButton14 = null;
                }
                appCompatToggleButton14.setText(getString(R.string.mainview_content_level_5_indicator));
                AppCompatToggleButton appCompatToggleButton15 = this.mLevel5Button;
                if (appCompatToggleButton15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLevel5Button");
                    appCompatToggleButton15 = null;
                }
                appCompatToggleButton15.setTextOn(getString(R.string.mainview_content_level_5_indicator));
                AppCompatToggleButton appCompatToggleButton16 = this.mLevel5Button;
                if (appCompatToggleButton16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLevel5Button");
                    appCompatToggleButton16 = null;
                }
                appCompatToggleButton16.setTextOff(getString(R.string.mainview_content_level_5_indicator));
                AppCompatToggleButton appCompatToggleButton17 = this.mLevel5Button;
                if (appCompatToggleButton17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLevel5Button");
                    appCompatToggleButton17 = null;
                }
                appCompatToggleButton17.setVisibility(0);
            } else {
                AppCompatToggleButton appCompatToggleButton18 = this.mLevel5Button;
                if (appCompatToggleButton18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLevel5Button");
                    appCompatToggleButton18 = null;
                }
                appCompatToggleButton18.setVisibility(8);
            }
            AppCompatToggleButton appCompatToggleButton19 = this.mLevel5Button;
            if (appCompatToggleButton19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLevel5Button");
                appCompatToggleButton19 = null;
            }
            appCompatToggleButton19.setTextColor(getResources().getColorStateList(R.color.main_cool_level_text_color));
            AppCompatToggleButton appCompatToggleButton20 = this.mLevel4Button;
            if (appCompatToggleButton20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLevel4Button");
                appCompatToggleButton20 = null;
            }
            appCompatToggleButton20.setTextColor(getResources().getColorStateList(R.color.main_cool_level_text_color));
            appCompatToggleButton5.setTextColor(getResources().getColorStateList(R.color.main_cool_level_text_color));
            appCompatToggleButton6.setTextColor(getResources().getColorStateList(R.color.main_cool_level_text_color));
            appCompatToggleButton7.setTextColor(getResources().getColorStateList(R.color.main_cool_level_text_color));
            AppCompatToggleButton appCompatToggleButton21 = this.mLevel5Button;
            if (appCompatToggleButton21 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLevel5Button");
                appCompatToggleButton21 = null;
            }
            appCompatToggleButton21.setOnTouchListener(new MainCoolFragment$$ExternalSyntheticLambda0());
            AppCompatToggleButton appCompatToggleButton22 = this.mLevel4Button;
            if (appCompatToggleButton22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLevel4Button");
                appCompatToggleButton22 = null;
            }
            appCompatToggleButton22.setOnTouchListener(new MainCoolFragment$$ExternalSyntheticLambda4());
            appCompatToggleButton5.setOnTouchListener(new MainCoolFragment$$ExternalSyntheticLambda5());
            appCompatToggleButton6.setOnTouchListener(new MainCoolFragment$$ExternalSyntheticLambda6());
            appCompatToggleButton7.setOnTouchListener(new MainCoolFragment$$ExternalSyntheticLambda7());
            this.mToggleButtonList.clear();
            this.mToggleButtonList.add(appCompatToggleButton7);
            this.mToggleButtonList.add(appCompatToggleButton6);
            this.mToggleButtonList.add(appCompatToggleButton5);
            ArrayList<AppCompatToggleButton> arrayList = this.mToggleButtonList;
            AppCompatToggleButton appCompatToggleButton23 = this.mLevel4Button;
            if (appCompatToggleButton23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLevel4Button");
                appCompatToggleButton23 = null;
            }
            arrayList.add(appCompatToggleButton23);
            if (isSupportCoolStep5) {
                ArrayList<AppCompatToggleButton> arrayList2 = this.mToggleButtonList;
                AppCompatToggleButton appCompatToggleButton24 = this.mLevel5Button;
                if (appCompatToggleButton24 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLevel5Button");
                } else {
                    appCompatToggleButton2 = appCompatToggleButton24;
                }
                arrayList2.add(appCompatToggleButton2);
            }
            CustomSlideView customSlideView2 = this.mSlideView;
            if (customSlideView2 != null) {
                customSlideView2.setMaxLevel(this.mToggleButtonList.size());
            }
            int i = this.aInitLevel;
            this.mCurrentLevel = i;
            if (i != 0) {
                CustomSlideView customSlideView3 = this.mSlideView;
                if (customSlideView3 != null) {
                    customSlideView3.setCurrentLevel(i, false);
                }
                changeOffBg(false);
                int size = this.mToggleButtonList.size();
                int i2 = 0;
                while (i2 < size) {
                    this.mToggleButtonList.get(i2).setChecked(this.mCurrentLevel > i2);
                    i2++;
                }
            } else {
                CustomSlideView customSlideView4 = this.mSlideView;
                if (customSlideView4 != null) {
                    customSlideView4.setToOff(false);
                }
                changeOffBg(true);
            }
            CustomSlideView customSlideView5 = this.mSlideView;
            if (customSlideView5 != null) {
                customSlideView5.setOnSlideListener(new MainCoolFragment$initView$8(this, isSupportCoolStep4));
            }
            AppCompatButton appCompatButton2 = (AppCompatButton) view.findViewById(R.id.main_cool_off);
            this.mOffButton = appCompatButton2;
            if (appCompatButton2 != null) {
                appCompatButton2.setOnClickListener(new MainCoolFragment$$ExternalSyntheticLambda8(this));
            }
            this.mWaveButton = (AppCompatToggleButton) view.findViewById(R.id.main_cool_wave);
            if (capability.getCapability1().isSupportManualWaveMode()) {
                AppCompatToggleButton appCompatToggleButton25 = this.mWaveButton;
                if (appCompatToggleButton25 != null) {
                    appCompatToggleButton25.setVisibility(0);
                }
            } else {
                AppCompatToggleButton appCompatToggleButton26 = this.mWaveButton;
                if (appCompatToggleButton26 != null) {
                    appCompatToggleButton26.setVisibility(4);
                }
            }
            AppCompatToggleButton appCompatToggleButton27 = this.mWaveButton;
            if (appCompatToggleButton27 != null) {
                appCompatToggleButton27.setOnCheckedChangeListener(new MainCoolFragment$$ExternalSyntheticLambda9(this));
            }
            AppCompatToggleButton appCompatToggleButton28 = this.mWaveButton;
            if (appCompatToggleButton28 != null) {
                appCompatToggleButton28.setTextColor(getResources().getColorStateList(R.color.main_cool_toggle_text_color));
            }
            this.mAutoButton = (AppCompatToggleButton) view.findViewById(R.id.main_cool_auto);
            this.mSmartButton = (AppCompatButton) view.findViewById(R.id.main_cool_smart);
            WeakReference<MainActivity> weakReference = this.mMainActivity;
            Intrinsics.checkNotNull(weakReference);
            Object obj = weakReference.get();
            Intrinsics.checkNotNull(obj);
            if (((MainActivity) obj).getMIsSupportCoolAuto() && (appCompatToggleButton = this.mAutoButton) != null) {
                appCompatToggleButton.setVisibility(0);
            }
            updateActionMode(this.aDeviceModeActionCode);
            updateCoolWave(this.aTempWaveOption);
            AppCompatToggleButton appCompatToggleButton29 = this.mAutoButton;
            if (appCompatToggleButton29 != null) {
                appCompatToggleButton29.setOnCheckedChangeListener(new MainCoolFragment$$ExternalSyntheticLambda10(this));
            }
            WeakReference<MainActivity> weakReference2 = this.mMainActivity;
            Intrinsics.checkNotNull(weakReference2);
            Object obj2 = weakReference2.get();
            Intrinsics.checkNotNull(obj2);
            if (((MainActivity) obj2).getMIsSupportSmart() && (appCompatButton = this.mSmartButton) != null) {
                appCompatButton.setVisibility(0);
            }
            AppCompatButton appCompatButton3 = this.mSmartButton;
            if (appCompatButton3 != null) {
                appCompatButton3.setOnClickListener(new MainCoolFragment$$ExternalSyntheticLambda11(this));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$12(MainCoolFragment mainCoolFragment, View view) {
        MainCoolFragment mainCoolFragment2 = mainCoolFragment;
        Intrinsics.checkNotNullParameter(mainCoolFragment2, "this$0");
        CustomFontTextView customFontTextView = mainCoolFragment2.mCountDownTextView;
        if (customFontTextView != null) {
            customFontTextView.setVisibility(4);
        }
        MainCoolViewOutput mainCoolViewOutput = mainCoolFragment2.mOutput;
        if (mainCoolViewOutput == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainCoolViewOutput = null;
        }
        mainCoolViewOutput.setCoolOff();
        mainCoolFragment2.updateDeviceModeInfo(new DeviceModeEntity(DeviceModeActionCode.MANUAL, DeviceModeSettingTriggerCode.SET_DEVICE_MODE, (DeviceCoolingCode) null, (ContinuousOperationStatus) null, (SwitchCoolHeatWaitStatus) null, CoolHeatTypeCode.COOL, (DeviceModeEntity.Temperature) null, (ModeCommonSettingOperation) null, (Integer) null, TempStepCode.OFF, TempBoostOption.BOOST, mainCoolFragment2.mCoolWaveOption, 0, 0, 0, (MyModeActionType) null, (MyModeSpecialSubMode) null, (Integer) null, (Integer) null, (MyModeOperationCode) null, (Integer) null, (MyModeTypeCode) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyTempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (FanStepCode) null, -32292, 63, (DefaultConstructorMarker) null));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$13(MainCoolFragment mainCoolFragment, CompoundButton compoundButton, boolean z) {
        TempWaveOption tempWaveOption;
        Intrinsics.checkNotNullParameter(mainCoolFragment, "this$0");
        MainCoolViewOutput mainCoolViewOutput = mainCoolFragment.mOutput;
        if (mainCoolViewOutput == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainCoolViewOutput = null;
        }
        int i = mainCoolFragment.mCurrentLevel;
        if (z) {
            tempWaveOption = TempWaveOption.WAVE_ON;
        } else {
            tempWaveOption = TempWaveOption.WAVE_OFF;
        }
        mainCoolViewOutput.setCoolWave(i, tempWaveOption);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$14(MainCoolFragment mainCoolFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(mainCoolFragment, "this$0");
        MainCoolViewOutput mainCoolViewOutput = mainCoolFragment.mOutput;
        if (mainCoolViewOutput == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainCoolViewOutput = null;
        }
        mainCoolViewOutput.setCoolAuto(z);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$15(MainCoolFragment mainCoolFragment, View view) {
        Intrinsics.checkNotNullParameter(mainCoolFragment, "this$0");
        WeakReference<MainActivity> weakReference = mainCoolFragment.mMainActivity;
        Intrinsics.checkNotNull(weakReference);
        Object obj = weakReference.get();
        Intrinsics.checkNotNull(obj);
        ((MainActivity) obj).transitToSmartCool(mainCoolFragment.mCurrentLevel != TempStepCode.OFF.ordinal());
    }

    public void onFail(String str) {
        MainActivity mainActivity;
        Intrinsics.checkNotNullParameter(str, "aReason");
        WeakReference<MainActivity> weakReference = this.mMainActivity;
        if (weakReference != null && (mainActivity = (MainActivity) weakReference.get()) != null) {
            mainActivity.onFail(str);
        }
    }

    public void changeLevel4Text(String str) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(str, "aText");
        AppCompatToggleButton appCompatToggleButton = this.mLevel4Button;
        AppCompatToggleButton appCompatToggleButton2 = null;
        if (appCompatToggleButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLevel4Button");
            appCompatToggleButton = null;
        }
        CharSequence charSequence2 = str;
        appCompatToggleButton.setText(charSequence2);
        AppCompatToggleButton appCompatToggleButton3 = this.mLevel4Button;
        if (appCompatToggleButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLevel4Button");
            appCompatToggleButton3 = null;
        }
        appCompatToggleButton3.setTextOff(charSequence2);
        AppCompatToggleButton appCompatToggleButton4 = this.mLevel4Button;
        if (appCompatToggleButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLevel4Button");
            appCompatToggleButton4 = null;
        }
        appCompatToggleButton4.setTextOn(charSequence2);
        AppCompatToggleButton appCompatToggleButton5 = this.mLevel4Button;
        if (appCompatToggleButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLevel4Button");
        } else {
            appCompatToggleButton2 = appCompatToggleButton5;
        }
        if (Intrinsics.areEqual((Object) str, (Object) getString(R.string.mainview_content_level_4_plus_indicator))) {
            charSequence = getString(R.string.accessibility_common_level_4_plus);
        } else if (Intrinsics.areEqual((Object) str, (Object) getString(R.string.mainview_content_level_4_indicator))) {
            charSequence = getString(R.string.accessibility_common_level_4);
        } else {
            charSequence = getString(R.string.accessibility_common_boost);
        }
        appCompatToggleButton2.setContentDescription(charSequence);
    }

    public void changeLevel5Text(String str) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(str, "aText");
        AppCompatToggleButton appCompatToggleButton = this.mLevel5Button;
        AppCompatToggleButton appCompatToggleButton2 = null;
        if (appCompatToggleButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLevel5Button");
            appCompatToggleButton = null;
        }
        CharSequence charSequence2 = str;
        appCompatToggleButton.setText(charSequence2);
        AppCompatToggleButton appCompatToggleButton3 = this.mLevel5Button;
        if (appCompatToggleButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLevel5Button");
            appCompatToggleButton3 = null;
        }
        appCompatToggleButton3.setTextOff(charSequence2);
        AppCompatToggleButton appCompatToggleButton4 = this.mLevel5Button;
        if (appCompatToggleButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLevel5Button");
            appCompatToggleButton4 = null;
        }
        appCompatToggleButton4.setTextOn(charSequence2);
        AppCompatToggleButton appCompatToggleButton5 = this.mLevel5Button;
        if (appCompatToggleButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLevel5Button");
        } else {
            appCompatToggleButton2 = appCompatToggleButton5;
        }
        if (Intrinsics.areEqual((Object) str, (Object) getString(R.string.mainview_content_level_5_plus_indicator))) {
            charSequence = getString(R.string.accessibility_common_level_5_plus);
        } else if (Intrinsics.areEqual((Object) str, (Object) getString(R.string.mainview_content_level_5_indicator))) {
            charSequence = getString(R.string.accessibility_common_level_5);
        } else {
            charSequence = getString(R.string.accessibility_common_level_4);
        }
        appCompatToggleButton2.setContentDescription(charSequence);
    }

    /* access modifiers changed from: private */
    public final void updateDeviceModeInfo(DeviceModeEntity deviceModeEntity) {
        String str;
        if (getContext() != null && deviceModeEntity.getTemperature() != null && deviceModeEntity.getBoostOption() != null) {
            Bundle bundle = new Bundle();
            bundle.putString(AnalyticsUtil.EventParameter.COOL_WARM.getValue(), AnalyticsUtil.ParameterConstants.COOL.getValue());
            TempStepCode temperature = deviceModeEntity.getTemperature();
            Intrinsics.checkNotNull(temperature);
            if (temperature == TempStepCode.OFF) {
                bundle.putString(AnalyticsUtil.EventParameter.TEMP.getValue(), AnalyticsUtil.ParameterConstants.LEVEl_OFF.getValue());
            } else {
                String value = AnalyticsUtil.EventParameter.TEMP.getValue();
                TempBoostOption boostOption = deviceModeEntity.getBoostOption();
                Intrinsics.checkNotNull(boostOption);
                if (boostOption == TempBoostOption.BOOST) {
                    str = AnalyticsUtil.ParameterConstants.BOOST.getValue();
                } else {
                    TempStepCode temperature2 = deviceModeEntity.getTemperature();
                    Intrinsics.checkNotNull(temperature2);
                    str = String.valueOf(temperature2.getCode() + 1);
                }
                bundle.putString(value, str);
            }
            AnalyticsUtil analyticsUtil = AnalyticsUtil.INSTANCE;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            FirebaseAnalytics instance = FirebaseAnalytics.getInstance(requireContext());
            Intrinsics.checkNotNullExpressionValue(instance, "getInstance(...)");
            analyticsUtil.logEventWithBundle(requireContext, instance, AnalyticsUtil.EventName.MANUAL_COOL_WARM_CHANGE, bundle);
        }
    }

    public void updateBoost(TempBoostOption tempBoostOption) {
        Intrinsics.checkNotNullParameter(tempBoostOption, "aTempBoostOption");
        this.mTempBoostOption = tempBoostOption;
        if (tempBoostOption != TempBoostOption.NONE) {
            AppCompatToggleButton appCompatToggleButton = this.mWaveButton;
            if (appCompatToggleButton != null) {
                appCompatToggleButton.setEnabled(true);
            }
            CustomSlideView customSlideView = this.mSlideView;
            if (customSlideView != null) {
                customSlideView.setToMax();
            }
            int size = this.mToggleButtonList.size();
            for (int i = 0; i < size; i++) {
                this.mToggleButtonList.get(i).setChecked(true);
            }
        }
    }

    public void updateCoolTimer(Integer num) {
        if (num != null) {
            num.intValue();
            CustomCountDown customCountDown = this.mCountDown;
            if (customCountDown != null) {
                customCountDown.cancel();
            }
            CustomCountDown customCountDown2 = new CustomCountDown(1000 * ((long) num.intValue()), 1000);
            this.mCountDown = customCountDown2;
            customCountDown2.start();
            CustomFontTextView customFontTextView = this.mCountDownTextView;
            if (customFontTextView != null) {
                customFontTextView.setVisibility((this.mTempBoostOption == TempBoostOption.BOOST || this.mCurrentLevel == CoolLevel.values().length) ? 0 : 4);
                return;
            }
            return;
        }
        CustomCountDown customCountDown3 = this.mCountDown;
        if (customCountDown3 != null) {
            customCountDown3.onFinish();
        }
        CustomCountDown customCountDown4 = this.mCountDown;
        if (customCountDown4 != null) {
            customCountDown4.cancel();
        }
    }

    public void updateCoolWave(TempWaveOption tempWaveOption) {
        Typeface typeface;
        Intrinsics.checkNotNullParameter(tempWaveOption, "aTempWaveOption");
        AppCompatToggleButton appCompatToggleButton = this.mWaveButton;
        if (appCompatToggleButton != null) {
            appCompatToggleButton.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        }
        AppCompatToggleButton appCompatToggleButton2 = this.mWaveButton;
        if (appCompatToggleButton2 != null) {
            appCompatToggleButton2.setChecked(tempWaveOption == TempWaveOption.WAVE_ON);
        }
        AppCompatToggleButton appCompatToggleButton3 = this.mWaveButton;
        if (appCompatToggleButton3 != null) {
            appCompatToggleButton3.setOnCheckedChangeListener(new MainCoolFragment$$ExternalSyntheticLambda3(this));
        }
        AppCompatToggleButton appCompatToggleButton4 = this.mWaveButton;
        if (appCompatToggleButton4 != null) {
            if (tempWaveOption == TempWaveOption.WAVE_ON) {
                typeface = Typeface.DEFAULT_BOLD;
            } else {
                typeface = Typeface.DEFAULT;
            }
            appCompatToggleButton4.setTypeface(typeface);
        }
    }

    /* access modifiers changed from: private */
    public static final void updateCoolWave$lambda$18(MainCoolFragment mainCoolFragment, CompoundButton compoundButton, boolean z) {
        TempWaveOption tempWaveOption;
        Intrinsics.checkNotNullParameter(mainCoolFragment, "this$0");
        MainCoolViewOutput mainCoolViewOutput = mainCoolFragment.mOutput;
        if (mainCoolViewOutput == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainCoolViewOutput = null;
        }
        int i = mainCoolFragment.mCurrentLevel;
        if (z) {
            tempWaveOption = TempWaveOption.WAVE_ON;
        } else {
            tempWaveOption = TempWaveOption.WAVE_OFF;
        }
        mainCoolViewOutput.setCoolWave(i, tempWaveOption);
    }

    public void updateOff() {
        changeOffBg(true);
        AppCompatToggleButton appCompatToggleButton = this.mWaveButton;
        if (appCompatToggleButton != null) {
            appCompatToggleButton.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        }
        AppCompatToggleButton appCompatToggleButton2 = this.mWaveButton;
        if (appCompatToggleButton2 != null) {
            appCompatToggleButton2.setChecked(false);
        }
        AppCompatToggleButton appCompatToggleButton3 = this.mWaveButton;
        if (appCompatToggleButton3 != null) {
            appCompatToggleButton3.setTypeface(Typeface.DEFAULT);
        }
        AppCompatToggleButton appCompatToggleButton4 = this.mWaveButton;
        if (appCompatToggleButton4 != null) {
            appCompatToggleButton4.setOnCheckedChangeListener(new MainCoolFragment$$ExternalSyntheticLambda1(this));
        }
        AppCompatToggleButton appCompatToggleButton5 = this.mWaveButton;
        if (appCompatToggleButton5 != null) {
            appCompatToggleButton5.setEnabled(false);
        }
        AppCompatToggleButton appCompatToggleButton6 = this.mAutoButton;
        if (appCompatToggleButton6 != null) {
            appCompatToggleButton6.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        }
        AppCompatToggleButton appCompatToggleButton7 = this.mAutoButton;
        if (appCompatToggleButton7 != null) {
            appCompatToggleButton7.setChecked(false);
        }
        AppCompatToggleButton appCompatToggleButton8 = this.mAutoButton;
        if (appCompatToggleButton8 != null) {
            appCompatToggleButton8.setOnCheckedChangeListener(new MainCoolFragment$$ExternalSyntheticLambda2(this));
        }
        AppCompatToggleButton appCompatToggleButton9 = this.mAutoButton;
        if (appCompatToggleButton9 != null) {
            appCompatToggleButton9.setTypeface(Typeface.DEFAULT);
        }
        CustomSlideView customSlideView = this.mSlideView;
        if (customSlideView != null) {
            CustomSlideView.setToOff$default(customSlideView, false, 1, (Object) null);
        }
        this.mCurrentLevel = 0;
        int size = this.mToggleButtonList.size();
        for (int i = 0; i < size; i++) {
            this.mToggleButtonList.get(i).setChecked(false);
        }
        CustomCountDown customCountDown = this.mCountDown;
        if (customCountDown != null) {
            customCountDown.onFinish();
        }
        CustomCountDown customCountDown2 = this.mCountDown;
        if (customCountDown2 != null) {
            customCountDown2.cancel();
        }
    }

    /* access modifiers changed from: private */
    public static final void updateOff$lambda$19(MainCoolFragment mainCoolFragment, CompoundButton compoundButton, boolean z) {
        TempWaveOption tempWaveOption;
        Intrinsics.checkNotNullParameter(mainCoolFragment, "this$0");
        MainCoolViewOutput mainCoolViewOutput = mainCoolFragment.mOutput;
        if (mainCoolViewOutput == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainCoolViewOutput = null;
        }
        int i = mainCoolFragment.mCurrentLevel;
        if (z) {
            tempWaveOption = TempWaveOption.WAVE_ON;
        } else {
            tempWaveOption = TempWaveOption.WAVE_OFF;
        }
        mainCoolViewOutput.setCoolWave(i, tempWaveOption);
    }

    /* access modifiers changed from: private */
    public static final void updateOff$lambda$20(MainCoolFragment mainCoolFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(mainCoolFragment, "this$0");
        MainCoolViewOutput mainCoolViewOutput = mainCoolFragment.mOutput;
        if (mainCoolViewOutput == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainCoolViewOutput = null;
        }
        mainCoolViewOutput.setCoolAuto(z);
    }

    public void updateTemp(TempStepCode tempStepCode) {
        CustomSlideView customSlideView;
        Intrinsics.checkNotNullParameter(tempStepCode, "aTemp");
        boolean z = this.mCurrentLevel != tempStepCode.ordinal();
        changeOffBg(false);
        this.mCurrentLevel = tempStepCode.ordinal();
        AppCompatToggleButton appCompatToggleButton = this.mWaveButton;
        if (appCompatToggleButton != null) {
            appCompatToggleButton.setEnabled(true);
        }
        if (this.mToggleButtonList.size() - tempStepCode.ordinal() >= 0) {
            int size = this.mToggleButtonList.size();
            int i = 0;
            while (i < size) {
                this.mToggleButtonList.get(i).setChecked(this.mCurrentLevel > i);
                i++;
            }
            if (z && (customSlideView = this.mSlideView) != null) {
                CustomSlideView.setCurrentLevel$default(customSlideView, tempStepCode.ordinal(), false, 2, (Object) null);
            }
        }
    }

    public void updateActionMode(DeviceModeActionCode deviceModeActionCode) {
        Typeface typeface;
        Intrinsics.checkNotNullParameter(deviceModeActionCode, "aDeviceModeActionCode");
        AppCompatToggleButton appCompatToggleButton = this.mAutoButton;
        if (appCompatToggleButton != null) {
            appCompatToggleButton.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        }
        AppCompatToggleButton appCompatToggleButton2 = this.mAutoButton;
        if (appCompatToggleButton2 != null) {
            appCompatToggleButton2.setChecked(deviceModeActionCode == DeviceModeActionCode.AUTO);
        }
        AppCompatToggleButton appCompatToggleButton3 = this.mAutoButton;
        if (appCompatToggleButton3 != null) {
            appCompatToggleButton3.setOnCheckedChangeListener(new MainCoolFragment$$ExternalSyntheticLambda12(this));
        }
        AppCompatToggleButton appCompatToggleButton4 = this.mAutoButton;
        if (appCompatToggleButton4 != null) {
            if (deviceModeActionCode == DeviceModeActionCode.AUTO) {
                typeface = Typeface.DEFAULT_BOLD;
            } else {
                typeface = Typeface.DEFAULT;
            }
            appCompatToggleButton4.setTypeface(typeface);
        }
    }

    /* access modifiers changed from: private */
    public static final void updateActionMode$lambda$21(MainCoolFragment mainCoolFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(mainCoolFragment, "this$0");
        MainCoolViewOutput mainCoolViewOutput = mainCoolFragment.mOutput;
        if (mainCoolViewOutput == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainCoolViewOutput = null;
        }
        mainCoolViewOutput.setCoolAuto(z);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainCoolFragment$CustomCountDown;", "Landroid/os/CountDownTimer;", "millisInFuture", "", "countDownInterval", "(Ljp/co/sony/reonpocket/modules/main/view/MainCoolFragment;JJ)V", "mDataFormat", "Ljava/text/SimpleDateFormat;", "onFinish", "", "onTick", "millisUntilFinished", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainCoolFragment.kt */
    public final class CustomCountDown extends CountDownTimer {
        private final SimpleDateFormat mDataFormat = new SimpleDateFormat("m:ss");

        public CustomCountDown(long j, long j2) {
            super(j, j2);
        }

        public void onFinish() {
            CustomFontTextView access$getMCountDownTextView$p = MainCoolFragment.this.mCountDownTextView;
            if (access$getMCountDownTextView$p != null) {
                access$getMCountDownTextView$p.setText("");
            }
            CustomFontTextView access$getMCountDownTextView$p2 = MainCoolFragment.this.mCountDownTextView;
            if (access$getMCountDownTextView$p2 != null) {
                access$getMCountDownTextView$p2.setVisibility(4);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x001a, code lost:
            if (jp.co.sony.reonpocket.modules.main.view.MainCoolFragment.access$getMCurrentLevel$p(r3.this$0) == 4) goto L_0x001c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onTick(long r4) {
            /*
                r3 = this;
                jp.co.sony.reonpocket.modules.main.view.MainCoolFragment r0 = jp.co.sony.reonpocket.modules.main.view.MainCoolFragment.this
                jp.co.sony.reonpocket.view.CustomFontTextView r0 = r0.mCountDownTextView
                if (r0 != 0) goto L_0x0009
                goto L_0x0020
            L_0x0009:
                jp.co.sony.reonpocket.modules.main.view.MainCoolFragment r1 = jp.co.sony.reonpocket.modules.main.view.MainCoolFragment.this
                jp.co.sony.reonpocket.constant.TempBoostOption r1 = r1.mTempBoostOption
                jp.co.sony.reonpocket.constant.TempBoostOption r2 = jp.co.sony.reonpocket.constant.TempBoostOption.BOOST
                if (r1 == r2) goto L_0x001c
                jp.co.sony.reonpocket.modules.main.view.MainCoolFragment r1 = jp.co.sony.reonpocket.modules.main.view.MainCoolFragment.this
                int r1 = r1.mCurrentLevel
                r2 = 4
                if (r1 != r2) goto L_0x001d
            L_0x001c:
                r2 = 0
            L_0x001d:
                r0.setVisibility(r2)
            L_0x0020:
                jp.co.sony.reonpocket.modules.main.view.MainCoolFragment r0 = jp.co.sony.reonpocket.modules.main.view.MainCoolFragment.this
                jp.co.sony.reonpocket.view.CustomFontTextView r0 = r0.mCountDownTextView
                if (r0 != 0) goto L_0x0029
                goto L_0x0038
            L_0x0029:
                java.text.SimpleDateFormat r1 = r3.mDataFormat
                java.lang.Long r4 = java.lang.Long.valueOf(r4)
                java.lang.String r4 = r1.format(r4)
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                r0.setText(r4)
            L_0x0038:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.main.view.MainCoolFragment.CustomCountDown.onTick(long):void");
        }
    }

    private final void changeOffBg(boolean z) {
        if (getContext() != null) {
            if (z) {
                for (LinearLayout backgroundColor : this.mOffBackgroundList) {
                    backgroundColor.setBackgroundColor(getResources().getColor(R.color.LevelBackgroundCoolOff));
                }
                return;
            }
            int size = this.mOffBackgroundList.size();
            for (int i = 0; i < size; i++) {
                Resources resources = getResources();
                Integer num = this.mLevelBackgroundList.get(i);
                Intrinsics.checkNotNullExpressionValue(num, "get(...)");
                this.mOffBackgroundList.get(i).setBackgroundColor(resources.getColor(num.intValue()));
            }
        }
    }

    public void showWaveGuide() {
        DialogHelperUtil dialogHelperUtil;
        Unit unit;
        DataDialogFragment dataDialogFragment = this.mWaveDialogFragment;
        if (dataDialogFragment != null) {
            Dialog dialog = dataDialogFragment.getDialog();
            if (dialog != null) {
                if (!dialog.isShowing()) {
                    dialog.show();
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        DialogHelperUtil dialogHelperUtil2 = this.mDialogHelper;
        if (dialogHelperUtil2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil = null;
        } else {
            dialogHelperUtil = dialogHelperUtil2;
        }
        String string = getString(R.string.mainview_wave_guide_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        DataDialogFragment showDataDialog = dialogHelperUtil.showDataDialog(string, BaseDialogFragment.Builder.DialogType.INFORMATION, DialogHelperUtil.RequestCode.INFORMATION.ordinal(), R.string.common_ok, 0);
        this.mWaveDialogFragment = showDataDialog;
        if (showDataDialog != null) {
            showDataDialog.setLifecycleListener(new MainCoolFragment$showWaveGuide$2$1(this));
            Unit unit2 = Unit.INSTANCE;
        }
    }

    public final void readDeviceMode() {
        MainCoolViewOutput mainCoolViewOutput = this.mOutput;
        if (mainCoolViewOutput == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainCoolViewOutput = null;
        }
        mainCoolViewOutput.readDeviceMode();
    }
}
