package jp.co.sony.reonpocket.modules.main.view;

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
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.fragment.app.FragmentActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
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
import jp.co.sony.reonpocket.data.entity.Capability3;
import jp.co.sony.reonpocket.data.entity.CapabilityEntity;
import jp.co.sony.reonpocket.data.entity.DeviceModeEntity;
import jp.co.sony.reonpocket.modules.base.view.BaseFragment;
import jp.co.sony.reonpocket.modules.main.presenter.MainWarmPresenter;
import jp.co.sony.reonpocket.util.AnalyticsUtil;
import jp.co.sony.reonpocket.view.CustomFontTextView;
import jp.co.sony.reonpocket.view.CustomSlideView;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0004KLMNB\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u0010\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020,H\u0002J\u0012\u0010-\u001a\u00020$2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J&\u00100\u001a\u0004\u0018\u00010,2\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00105\u001a\u00020$H\u0016J\b\u00106\u001a\u00020$H\u0016J\u0010\u00107\u001a\u00020$2\u0006\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020$H\u0016J\u001a\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020,2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u0010=\u001a\u00020$H\u0002J\u0010\u0010>\u001a\u00020$2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020\u001fH\u0016J\u0010\u0010A\u001a\u00020$2\u0006\u0010B\u001a\u00020CH\u0002J\b\u0010D\u001a\u00020$H\u0016J\u0010\u0010E\u001a\u00020$2\u0006\u0010F\u001a\u00020GH\u0016J\u0017\u0010H\u001a\u00020$2\b\u0010I\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010JR\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0018\u00010\u000eR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0005j\b\u0012\u0004\u0012\u00020\u0016`\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0005j\b\u0012\u0004\u0012\u00020\f`\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainWarmFragment;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment;", "Ljp/co/sony/reonpocket/modules/main/view/MainWarmViewInput;", "()V", "LevelBackgroundList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "aDeviceModeActionCode", "Ljp/co/sony/reonpocket/constant/DeviceModeActionCode;", "aInitLevel", "mAutoButton", "Landroidx/appcompat/widget/AppCompatToggleButton;", "mCountDown", "Ljp/co/sony/reonpocket/modules/main/view/MainWarmFragment$CustomCountDown;", "mCountDownTextView", "Ljp/co/sony/reonpocket/view/CustomFontTextView;", "mCurrentLevel", "mMainActivity", "Ljava/lang/ref/WeakReference;", "Ljp/co/sony/reonpocket/modules/main/view/MainActivity;", "mOffBackgroundList", "Landroid/widget/LinearLayout;", "mOffButton", "Landroidx/appcompat/widget/AppCompatButton;", "mOutput", "Ljp/co/sony/reonpocket/modules/main/view/MainWarmViewOutput;", "mSlideView", "Ljp/co/sony/reonpocket/view/CustomSlideView;", "mSmartButton", "mTempBoostOption", "Ljp/co/sony/reonpocket/constant/TempBoostOption;", "mTempSettingValue", "mToggleButtonList", "mWaveButton", "applyBleDataEntity", "", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "changeOffBg", "aIsOff", "", "initView", "aView", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onFail", "aReason", "", "onResume", "onViewCreated", "view", "switchSmartAutoButtonVisibility", "updateActionMode", "updateBoost", "aTempBoostOption", "updateDeviceModeInfo", "aDeviceModeEntity", "Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity;", "updateOff", "updateTemp", "aTemp", "Ljp/co/sony/reonpocket/constant/TempStepCode;", "updateWarmTimer", "aRemainTime", "(Ljava/lang/Integer;)V", "Companion", "CustomCountDown", "WarmInitLevel", "WarmLevel", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainWarmFragment.kt */
public final class MainWarmFragment extends BaseFragment implements MainWarmViewInput {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DEVICE_MODE_ACTION_CODE = "deviceModeActionCode";
    private static final String INIT_LEVEL = "initLevel";
    private final ArrayList<Integer> LevelBackgroundList = CollectionsKt.arrayListOf(Integer.valueOf(R.color.LevelBackgroundWarm1), Integer.valueOf(R.color.LevelBackgroundWarm2), Integer.valueOf(R.color.LevelBackgroundWarm3), Integer.valueOf(R.color.LevelBackgroundWarm4));
    private DeviceModeActionCode aDeviceModeActionCode = DeviceModeActionCode.MANUAL;
    private int aInitLevel = TempStepCode.OFF.ordinal();
    private AppCompatToggleButton mAutoButton;
    private CustomCountDown mCountDown;
    /* access modifiers changed from: private */
    public CustomFontTextView mCountDownTextView;
    /* access modifiers changed from: private */
    public int mCurrentLevel;
    private WeakReference<MainActivity> mMainActivity;
    private ArrayList<LinearLayout> mOffBackgroundList = new ArrayList<>();
    private AppCompatButton mOffButton;
    /* access modifiers changed from: private */
    public MainWarmViewOutput mOutput;
    private CustomSlideView mSlideView;
    private AppCompatButton mSmartButton;
    /* access modifiers changed from: private */
    public TempBoostOption mTempBoostOption = TempBoostOption.NONE;
    /* access modifiers changed from: private */
    public int mTempSettingValue = TempStepCode.STEP_1.getCode();
    /* access modifiers changed from: private */
    public ArrayList<AppCompatToggleButton> mToggleButtonList = new ArrayList<>();
    private AppCompatToggleButton mWaveButton;

    /* access modifiers changed from: private */
    public static final boolean initView$lambda$5(View view, MotionEvent motionEvent) {
        return false;
    }

    /* access modifiers changed from: private */
    public static final boolean initView$lambda$6(View view, MotionEvent motionEvent) {
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

    @JvmStatic
    public static final MainWarmFragment newInstance(int i, DeviceModeActionCode deviceModeActionCode) {
        return Companion.newInstance(i, deviceModeActionCode);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainWarmFragment$Companion;", "", "()V", "DEVICE_MODE_ACTION_CODE", "", "INIT_LEVEL", "newInstance", "Ljp/co/sony/reonpocket/modules/main/view/MainWarmFragment;", "initLevel", "", "deviceModeActionCode", "Ljp/co/sony/reonpocket/constant/DeviceModeActionCode;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainWarmFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ MainWarmFragment newInstance$default(Companion companion, int i, DeviceModeActionCode deviceModeActionCode, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = TempStepCode.OFF.ordinal();
            }
            if ((i2 & 2) != 0) {
                deviceModeActionCode = DeviceModeActionCode.MANUAL;
            }
            return companion.newInstance(i, deviceModeActionCode);
        }

        @JvmStatic
        public final MainWarmFragment newInstance(int i, DeviceModeActionCode deviceModeActionCode) {
            Intrinsics.checkNotNullParameter(deviceModeActionCode, MainWarmFragment.DEVICE_MODE_ACTION_CODE);
            MainWarmFragment mainWarmFragment = new MainWarmFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(MainWarmFragment.INIT_LEVEL, i);
            bundle.putInt(MainWarmFragment.DEVICE_MODE_ACTION_CODE, deviceModeActionCode.getCode());
            mainWarmFragment.setArguments(bundle);
            return mainWarmFragment;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainWarmFragment$WarmInitLevel;", "", "(Ljava/lang/String;I)V", "BOOST", "Level_3", "Level_2", "Level_1", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainWarmFragment.kt */
    public enum WarmInitLevel {
        BOOST,
        Level_3,
        Level_2,
        Level_1;

        public static EnumEntries<WarmInitLevel> getEntries() {
            return $ENTRIES;
        }

        static {
            WarmInitLevel[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainWarmFragment$WarmLevel;", "", "(Ljava/lang/String;I)V", "Level_1", "Level_2", "Level_3", "BOOST", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainWarmFragment.kt */
    public enum WarmLevel {
        Level_1,
        Level_2,
        Level_3,
        BOOST;

        public static EnumEntries<WarmLevel> getEntries() {
            return $ENTRIES;
        }

        static {
            WarmLevel[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    public void onCreate(Bundle bundle) {
        Object obj;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.aInitLevel = arguments.getInt(INIT_LEVEL);
            Iterator it = DeviceModeActionCode.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((DeviceModeActionCode) obj).getCode() == arguments.getInt(DEVICE_MODE_ACTION_CODE)) {
                    break;
                }
            }
            DeviceModeActionCode deviceModeActionCode = (DeviceModeActionCode) obj;
            if (deviceModeActionCode == null) {
                deviceModeActionCode = DeviceModeActionCode.MANUAL;
            }
            this.aDeviceModeActionCode = deviceModeActionCode;
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type jp.co.sony.reonpocket.modules.main.view.MainActivity");
            this.mMainActivity = new WeakReference<>((MainActivity) activity);
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            MainWarmViewOutput mainWarmPresenter = new MainWarmPresenter(requireContext, this);
            this.mOutput = mainWarmPresenter;
            mainWarmPresenter.onCreate();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_main_warm, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.warm_background_4);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        View findViewById2 = inflate.findViewById(R.id.warm_background_3);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        View findViewById3 = inflate.findViewById(R.id.warm_background_2);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        View findViewById4 = inflate.findViewById(R.id.warm_background_1);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.mOffBackgroundList = CollectionsKt.arrayListOf(findViewById, findViewById2, findViewById3, findViewById4);
        Intrinsics.checkNotNull(inflate);
        initView(inflate);
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        MainWarmViewOutput mainWarmViewOutput = this.mOutput;
        if (mainWarmViewOutput == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainWarmViewOutput = null;
        }
        mainWarmViewOutput.onViewCreated();
    }

    public void onResume() {
        MainActivity mainActivity;
        super.onResume();
        WeakReference<MainActivity> weakReference = this.mMainActivity;
        if (weakReference != null && (mainActivity = (MainActivity) weakReference.get()) != null) {
            mainActivity.setIsShownSmartWarmBefore(false);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        MainWarmViewOutput mainWarmViewOutput = this.mOutput;
        if (mainWarmViewOutput == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainWarmViewOutput = null;
        }
        mainWarmViewOutput.onViewDestroyed();
    }

    public void onDestroy() {
        super.onDestroy();
        MainWarmViewOutput mainWarmViewOutput = this.mOutput;
        if (mainWarmViewOutput == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainWarmViewOutput = null;
        }
        mainWarmViewOutput.onDestroy();
    }

    public final void applyBleDataEntity(BleDataEntity bleDataEntity) {
        Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
        MainWarmViewOutput mainWarmViewOutput = this.mOutput;
        if (mainWarmViewOutput == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainWarmViewOutput = null;
        }
        mainWarmViewOutput.applyBleDataEntity(bleDataEntity);
    }

    private final void initView(View view) {
        CharSequence charSequence;
        WeakReference<MainActivity> weakReference = this.mMainActivity;
        if (weakReference != null && weakReference != null && ((MainActivity) weakReference.get()) != null) {
            CustomSlideView customSlideView = (CustomSlideView) view.findViewById(R.id.warm_slideView);
            this.mSlideView = customSlideView;
            if (customSlideView != null) {
                customSlideView.setGradientColor(R.color.LevelAutoTopWarm, R.color.LevelAutoBottomWarm);
            }
            this.mCountDownTextView = (CustomFontTextView) view.findViewById(R.id.warm_countdown);
            MainWarmViewOutput mainWarmViewOutput = this.mOutput;
            if (mainWarmViewOutput == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOutput");
                mainWarmViewOutput = null;
            }
            CapabilityEntity capability = mainWarmViewOutput.getCapability();
            ((FrameLayout) view.findViewById(R.id.warm_frame)).setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 9.5f));
            AppCompatToggleButton appCompatToggleButton = (AppCompatToggleButton) view.findViewById(R.id.level4_toggle_button);
            if (capability.getCapability3().isSupportCoolStep4()) {
                charSequence = appCompatToggleButton.getResources().getString(R.string.accessibility_common_level_4);
            } else {
                charSequence = appCompatToggleButton.getResources().getString(R.string.accessibility_common_boost);
            }
            appCompatToggleButton.setContentDescription(charSequence);
            appCompatToggleButton.setClickable(false);
            AppCompatToggleButton appCompatToggleButton2 = (AppCompatToggleButton) view.findViewById(R.id.level3_toggle_button);
            appCompatToggleButton2.setContentDescription(appCompatToggleButton2.getResources().getString(R.string.accessibility_common_level_3));
            appCompatToggleButton2.setClickable(false);
            AppCompatToggleButton appCompatToggleButton3 = (AppCompatToggleButton) view.findViewById(R.id.level2_toggle_button);
            appCompatToggleButton3.setContentDescription(appCompatToggleButton3.getResources().getString(R.string.accessibility_common_level_2));
            appCompatToggleButton3.setClickable(false);
            AppCompatToggleButton appCompatToggleButton4 = (AppCompatToggleButton) view.findViewById(R.id.level1_toggle_button);
            appCompatToggleButton4.setContentDescription(appCompatToggleButton4.getResources().getString(R.string.accessibility_common_level_1));
            appCompatToggleButton4.setClickable(false);
            Capability3 capability3 = capability.getCapability3();
            boolean isSupportCoolStep4 = capability3 != null ? capability3.isSupportCoolStep4() : false;
            if (isSupportCoolStep4) {
                appCompatToggleButton.setText(getString(R.string.mainview_content_level_4_indicator));
                appCompatToggleButton.setTextOn(getString(R.string.mainview_content_level_4_indicator));
                appCompatToggleButton.setTextOff(getString(R.string.mainview_content_level_4_indicator));
            }
            appCompatToggleButton.setTextColor(getResources().getColorStateList(R.color.main_warm_level_text_color));
            appCompatToggleButton2.setTextColor(getResources().getColorStateList(R.color.main_warm_level_text_color));
            appCompatToggleButton3.setTextColor(getResources().getColorStateList(R.color.main_warm_level_text_color));
            appCompatToggleButton4.setTextColor(getResources().getColorStateList(R.color.main_warm_level_text_color));
            appCompatToggleButton.setOnTouchListener(new MainWarmFragment$$ExternalSyntheticLambda4());
            appCompatToggleButton2.setOnTouchListener(new MainWarmFragment$$ExternalSyntheticLambda5());
            appCompatToggleButton3.setOnTouchListener(new MainWarmFragment$$ExternalSyntheticLambda6());
            appCompatToggleButton4.setOnTouchListener(new MainWarmFragment$$ExternalSyntheticLambda7());
            this.mToggleButtonList.clear();
            this.mToggleButtonList.add(appCompatToggleButton4);
            this.mToggleButtonList.add(appCompatToggleButton3);
            this.mToggleButtonList.add(appCompatToggleButton2);
            this.mToggleButtonList.add(appCompatToggleButton);
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
                customSlideView5.setOnSlideListener(new MainWarmFragment$initView$5(this, isSupportCoolStep4));
            }
            AppCompatButton appCompatButton = (AppCompatButton) view.findViewById(R.id.main_warm_off);
            this.mOffButton = appCompatButton;
            if (appCompatButton != null) {
                appCompatButton.setOnClickListener(new MainWarmFragment$$ExternalSyntheticLambda8(this));
            }
            this.mAutoButton = (AppCompatToggleButton) view.findViewById(R.id.main_warm_auto);
            this.mSmartButton = (AppCompatButton) view.findViewById(R.id.main_warm_smart);
            switchSmartAutoButtonVisibility();
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$9(MainWarmFragment mainWarmFragment, View view) {
        MainWarmFragment mainWarmFragment2 = mainWarmFragment;
        Intrinsics.checkNotNullParameter(mainWarmFragment2, "this$0");
        CustomFontTextView customFontTextView = mainWarmFragment2.mCountDownTextView;
        if (customFontTextView != null) {
            customFontTextView.setVisibility(4);
        }
        MainWarmViewOutput mainWarmViewOutput = mainWarmFragment2.mOutput;
        if (mainWarmViewOutput == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainWarmViewOutput = null;
        }
        mainWarmViewOutput.setWarmOff();
        mainWarmFragment2.updateDeviceModeInfo(new DeviceModeEntity(DeviceModeActionCode.MANUAL, DeviceModeSettingTriggerCode.SET_DEVICE_MODE, (DeviceCoolingCode) null, (ContinuousOperationStatus) null, (SwitchCoolHeatWaitStatus) null, CoolHeatTypeCode.HEAT, (DeviceModeEntity.Temperature) null, (ModeCommonSettingOperation) null, (Integer) null, TempStepCode.OFF, TempBoostOption.NONE, TempWaveOption.WAVE_OFF, 0, 0, 0, (MyModeActionType) null, (MyModeSpecialSubMode) null, (Integer) null, (Integer) null, (MyModeOperationCode) null, (Integer) null, (MyModeTypeCode) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyTempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (FanStepCode) null, -32292, 63, (DefaultConstructorMarker) null));
    }

    private final void switchSmartAutoButtonVisibility() {
        FragmentActivity activity = getActivity();
        MainActivity mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
        if (mainActivity != null) {
            MainWarmTemporaryModel mainWarmTemporaryModel = MainWarmTemporaryModel.INSTANCE;
            boolean mIsSupportSmart = mainActivity.getMIsSupportSmart();
            boolean mIsSupportWarmAuto = mainActivity.getMIsSupportWarmAuto();
            AppCompatToggleButton appCompatToggleButton = this.mAutoButton;
            Intrinsics.checkNotNull(appCompatToggleButton);
            AppCompatButton appCompatButton = this.mSmartButton;
            Intrinsics.checkNotNull(appCompatButton);
            mainWarmTemporaryModel.switchSmartAutoButtonVisibility(mIsSupportSmart, mIsSupportWarmAuto, appCompatToggleButton, appCompatButton, this.aDeviceModeActionCode, new MainWarmFragment$$ExternalSyntheticLambda1(mainActivity, this), new MainWarmFragment$$ExternalSyntheticLambda2(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void switchSmartAutoButtonVisibility$lambda$10(MainActivity mainActivity, MainWarmFragment mainWarmFragment, View view) {
        Intrinsics.checkNotNullParameter(mainActivity, "$mainActivity");
        Intrinsics.checkNotNullParameter(mainWarmFragment, "this$0");
        mainActivity.transitToSmartWarm(mainWarmFragment.mCurrentLevel != TempStepCode.OFF.ordinal());
    }

    /* access modifiers changed from: private */
    public static final void switchSmartAutoButtonVisibility$lambda$11(MainWarmFragment mainWarmFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(mainWarmFragment, "this$0");
        MainWarmViewOutput mainWarmViewOutput = mainWarmFragment.mOutput;
        if (mainWarmViewOutput == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainWarmViewOutput = null;
        }
        mainWarmViewOutput.setWarmAuto(z);
    }

    public void updateBoost(TempBoostOption tempBoostOption) {
        Intrinsics.checkNotNullParameter(tempBoostOption, "aTempBoostOption");
        this.mTempBoostOption = tempBoostOption;
        if (tempBoostOption != TempBoostOption.NONE) {
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

    public void updateWarmTimer(Integer num) {
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
                customFontTextView.setVisibility((this.mTempBoostOption == TempBoostOption.BOOST || this.mCurrentLevel == WarmLevel.values().length) ? 0 : 4);
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

    public void updateOff() {
        changeOffBg(true);
        AppCompatToggleButton appCompatToggleButton = this.mAutoButton;
        if (appCompatToggleButton != null) {
            appCompatToggleButton.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        }
        AppCompatToggleButton appCompatToggleButton2 = this.mAutoButton;
        if (appCompatToggleButton2 != null) {
            appCompatToggleButton2.setChecked(false);
        }
        AppCompatToggleButton appCompatToggleButton3 = this.mAutoButton;
        if (appCompatToggleButton3 != null) {
            appCompatToggleButton3.setOnCheckedChangeListener(new MainWarmFragment$$ExternalSyntheticLambda3(this));
        }
        AppCompatToggleButton appCompatToggleButton4 = this.mAutoButton;
        if (appCompatToggleButton4 != null) {
            appCompatToggleButton4.setTypeface(Typeface.DEFAULT);
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
    public static final void updateOff$lambda$14(MainWarmFragment mainWarmFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(mainWarmFragment, "this$0");
        MainWarmViewOutput mainWarmViewOutput = mainWarmFragment.mOutput;
        if (mainWarmViewOutput == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainWarmViewOutput = null;
        }
        mainWarmViewOutput.setWarmAuto(z);
    }

    public void updateTemp(TempStepCode tempStepCode) {
        CustomSlideView customSlideView;
        Intrinsics.checkNotNullParameter(tempStepCode, "aTemp");
        boolean z = this.mCurrentLevel != tempStepCode.ordinal();
        changeOffBg(false);
        this.mCurrentLevel = tempStepCode.ordinal();
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
            appCompatToggleButton3.setOnCheckedChangeListener(new MainWarmFragment$$ExternalSyntheticLambda0(this));
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
    public static final void updateActionMode$lambda$15(MainWarmFragment mainWarmFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(mainWarmFragment, "this$0");
        MainWarmViewOutput mainWarmViewOutput = mainWarmFragment.mOutput;
        if (mainWarmViewOutput == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainWarmViewOutput = null;
        }
        mainWarmViewOutput.setWarmAuto(z);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainWarmFragment$CustomCountDown;", "Landroid/os/CountDownTimer;", "millisInFuture", "", "countDownInterval", "(Ljp/co/sony/reonpocket/modules/main/view/MainWarmFragment;JJ)V", "mDataFormat", "Ljava/text/SimpleDateFormat;", "onFinish", "", "onTick", "millisUntilFinished", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainWarmFragment.kt */
    public final class CustomCountDown extends CountDownTimer {
        private final SimpleDateFormat mDataFormat = new SimpleDateFormat("m:ss");

        public CustomCountDown(long j, long j2) {
            super(j, j2);
        }

        public void onFinish() {
            CustomFontTextView access$getMCountDownTextView$p = MainWarmFragment.this.mCountDownTextView;
            if (access$getMCountDownTextView$p != null) {
                access$getMCountDownTextView$p.setText("");
            }
            CustomFontTextView access$getMCountDownTextView$p2 = MainWarmFragment.this.mCountDownTextView;
            if (access$getMCountDownTextView$p2 != null) {
                access$getMCountDownTextView$p2.setVisibility(4);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x001a, code lost:
            if (jp.co.sony.reonpocket.modules.main.view.MainWarmFragment.access$getMCurrentLevel$p(r3.this$0) == 4) goto L_0x001c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onTick(long r4) {
            /*
                r3 = this;
                jp.co.sony.reonpocket.modules.main.view.MainWarmFragment r0 = jp.co.sony.reonpocket.modules.main.view.MainWarmFragment.this
                jp.co.sony.reonpocket.view.CustomFontTextView r0 = r0.mCountDownTextView
                if (r0 != 0) goto L_0x0009
                goto L_0x0020
            L_0x0009:
                jp.co.sony.reonpocket.modules.main.view.MainWarmFragment r1 = jp.co.sony.reonpocket.modules.main.view.MainWarmFragment.this
                jp.co.sony.reonpocket.constant.TempBoostOption r1 = r1.mTempBoostOption
                jp.co.sony.reonpocket.constant.TempBoostOption r2 = jp.co.sony.reonpocket.constant.TempBoostOption.BOOST
                if (r1 == r2) goto L_0x001c
                jp.co.sony.reonpocket.modules.main.view.MainWarmFragment r1 = jp.co.sony.reonpocket.modules.main.view.MainWarmFragment.this
                int r1 = r1.mCurrentLevel
                r2 = 4
                if (r1 != r2) goto L_0x001d
            L_0x001c:
                r2 = 0
            L_0x001d:
                r0.setVisibility(r2)
            L_0x0020:
                jp.co.sony.reonpocket.modules.main.view.MainWarmFragment r0 = jp.co.sony.reonpocket.modules.main.view.MainWarmFragment.this
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
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.main.view.MainWarmFragment.CustomCountDown.onTick(long):void");
        }
    }

    private final void changeOffBg(boolean z) {
        if (getContext() != null) {
            if (z) {
                for (LinearLayout backgroundColor : this.mOffBackgroundList) {
                    backgroundColor.setBackgroundColor(getResources().getColor(R.color.LevelBackgroundWarmOff));
                }
                return;
            }
            int size = this.mOffBackgroundList.size();
            for (int i = 0; i < size; i++) {
                Resources resources = getResources();
                Integer num = this.LevelBackgroundList.get(i);
                Intrinsics.checkNotNullExpressionValue(num, "get(...)");
                this.mOffBackgroundList.get(i).setBackgroundColor(resources.getColor(num.intValue()));
            }
        }
    }

    public void onFail(String str) {
        MainActivity mainActivity;
        Intrinsics.checkNotNullParameter(str, "aReason");
        WeakReference<MainActivity> weakReference = this.mMainActivity;
        if (weakReference != null && (mainActivity = (MainActivity) weakReference.get()) != null) {
            mainActivity.onFail(str);
        }
    }

    /* access modifiers changed from: private */
    public final void updateDeviceModeInfo(DeviceModeEntity deviceModeEntity) {
        String str;
        if (deviceModeEntity.getTemperature() != null && deviceModeEntity.getBoostOption() != null) {
            Bundle bundle = new Bundle();
            bundle.putString(AnalyticsUtil.EventParameter.COOL_WARM.getValue(), AnalyticsUtil.ParameterConstants.WARM.getValue());
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
}
