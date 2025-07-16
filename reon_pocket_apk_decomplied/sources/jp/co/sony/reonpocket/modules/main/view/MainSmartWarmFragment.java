package jp.co.sony.reonpocket.modules.main.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode;
import jp.co.sony.reonpocket.constant.SmartModePreference;
import jp.co.sony.reonpocket.constant.TemperatureOnOffCode;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import jp.co.sony.reonpocket.data.entity.DeviceModeEntity;
import jp.co.sony.reonpocket.modules.base.view.BaseFragment;
import jp.co.sony.reonpocket.modules.main.presenter.MainSmartWarmPresenter;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.util.DialogHelperUtil;
import jp.co.sony.reonpocket.view.TemperatureSurfaceView;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 ]2\u00020\u00012\u00020\u0002:\u0001]B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020\bJ\u0010\u00100\u001a\u00020+2\u0006\u00101\u001a\u00020\u001aH\u0002J\u0006\u00102\u001a\u00020\u000eJ\b\u00103\u001a\u00020+H\u0002J\u0012\u00104\u001a\u00020+2\b\u00105\u001a\u0004\u0018\u000106H\u0016J&\u00107\u001a\u0004\u0018\u00010\u001a2\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u0010<\u001a\u00020+H\u0016J\b\u0010=\u001a\u00020+H\u0016J\u0010\u0010>\u001a\u00020+2\u0006\u0010?\u001a\u00020@H\u0016J\b\u0010A\u001a\u00020+H\u0016J\u001a\u0010B\u001a\u00020+2\u0006\u0010C\u001a\u00020\u001a2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0016\u0010D\u001a\u00020+2\u0006\u0010E\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\bJ!\u0010F\u001a\u00020+2\b\u0010G\u001a\u0004\u0018\u00010\b2\b\u0010H\u001a\u0004\u0018\u00010IH\u0002¢\u0006\u0002\u0010JJ \u0010K\u001a\u00020+2\u0006\u0010L\u001a\u00020(2\u0006\u0010M\u001a\u00020\u000e2\u0006\u0010N\u001a\u00020\u000eH\u0016J\u000e\u0010O\u001a\u00020+2\u0006\u0010P\u001a\u00020\u000eJ\u000e\u0010Q\u001a\u00020+2\u0006\u0010R\u001a\u00020\u000eJ\u0010\u0010S\u001a\u00020+2\u0006\u0010T\u001a\u00020\u0005H\u0016J\u0010\u0010U\u001a\u00020+2\u0006\u0010V\u001a\u00020\u0005H\u0016J \u0010W\u001a\u00020+2\u0006\u0010X\u001a\u00020\b2\u0006\u0010Y\u001a\u00020I2\u0006\u0010H\u001a\u00020IH\u0016J\u0010\u0010Z\u001a\u00020+2\u0006\u0010[\u001a\u00020\\H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainSmartWarmFragment;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment;", "Ljp/co/sony/reonpocket/modules/main/view/MainSmartWarmViewInput;", "()V", "LOWER_TEMP", "", "UPPER_TEMP", "mCurrentPreference", "Ljp/co/sony/reonpocket/constant/SmartModePreference;", "mCurrentWriteTemperature", "", "mDialogHelper", "Ljp/co/sony/reonpocket/util/DialogHelperUtil;", "mIsNoAmbientTemp", "", "mIsNoTagInfoReceiving", "mIsOn", "mMainActivity", "Ljava/lang/ref/WeakReference;", "Ljp/co/sony/reonpocket/modules/main/view/MainActivity;", "mManualButton", "Landroidx/appcompat/widget/AppCompatButton;", "mOffButton", "mOffView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mOnButton", "Landroid/view/View;", "mOptionButton", "mOutput", "Ljp/co/sony/reonpocket/modules/main/presenter/MainSmartWarmPresenter;", "mPauseToast", "Landroid/widget/LinearLayout;", "mPauseToastMsg", "Landroid/widget/TextView;", "mScaleLayout", "Landroid/widget/FrameLayout;", "mSmartModeIndicator", "Ljp/co/sony/reonpocket/view/TemperatureSurfaceView;", "mSmartModePreference", "mState", "Ljp/co/sony/reonpocket/constant/CurrentCoolHeatTypeCode;", "type", "applyBleDataEntity", "", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "doSmartWarmSetting", "aSmartModePreference", "initUi", "aView", "isActive", "manualButtonTapped", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onFail", "aReason", "", "onResume", "onViewCreated", "view", "setSmartWarmPreference", "aIsOn", "setTargetTemperatureView", "smartPreference", "targetTemp", "", "(Ljp/co/sony/reonpocket/constant/SmartModePreference;Ljava/lang/Double;)V", "updateCurrentState", "aTypeCode", "aIsTagInfoNoReceiving", "isNoAmbientTemp", "updateNoAmbientTemp", "isNotGet", "updateNoReceiving", "isNoReceiving", "updateTecRate", "aRate", "updateTecTemp", "aTecTemp", "updateTempSetting", "pref", "settingTemp", "updateViewVisibility", "aTemperature", "Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity$Temperature;", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainSmartWarmFragment.kt */
public final class MainSmartWarmFragment extends BaseFragment implements MainSmartWarmViewInput {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String SMART_MODE_PREF = "smartModePreference";
    private static final String TYPE_KEY = "type";
    private final float LOWER_TEMP = 33.0f;
    private final float UPPER_TEMP = 43.0f;
    private SmartModePreference mCurrentPreference = DeviceModeEntity.SmartWarmModeCombine.LEVEL1.getPref();
    private int mCurrentWriteTemperature = DeviceModeEntity.SmartWarmModeCombine.LEVEL1.getTemperature();
    private DialogHelperUtil mDialogHelper;
    private boolean mIsNoAmbientTemp;
    private boolean mIsNoTagInfoReceiving;
    private boolean mIsOn;
    private WeakReference<MainActivity> mMainActivity;
    private AppCompatButton mManualButton;
    private AppCompatButton mOffButton;
    private ConstraintLayout mOffView;
    private View mOnButton;
    private AppCompatButton mOptionButton;
    private MainSmartWarmPresenter mOutput;
    private LinearLayout mPauseToast;
    private TextView mPauseToastMsg;
    private FrameLayout mScaleLayout;
    private TemperatureSurfaceView mSmartModeIndicator;
    private SmartModePreference mSmartModePreference;
    private CurrentCoolHeatTypeCode mState = CurrentCoolHeatTypeCode.OFF;
    private CurrentCoolHeatTypeCode type = CurrentCoolHeatTypeCode.OFF;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainSmartWarmFragment.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode[] r0 = jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode r1 = jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode.OFF     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode r1 = jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode.HEAT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode r1 = jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode.PAUSE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode r1 = jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode.WEAKHEAT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.main.view.MainSmartWarmFragment.WhenMappings.<clinit>():void");
        }
    }

    @JvmStatic
    public static final MainSmartWarmFragment newInstance(CurrentCoolHeatTypeCode currentCoolHeatTypeCode, SmartModePreference smartModePreference) {
        return Companion.newInstance(currentCoolHeatTypeCode, smartModePreference);
    }

    public void onFail(String str) {
        Intrinsics.checkNotNullParameter(str, "aReason");
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainSmartWarmFragment$Companion;", "", "()V", "SMART_MODE_PREF", "", "TYPE_KEY", "newInstance", "Ljp/co/sony/reonpocket/modules/main/view/MainSmartWarmFragment;", "type", "Ljp/co/sony/reonpocket/constant/CurrentCoolHeatTypeCode;", "mSmartModePreference", "Ljp/co/sony/reonpocket/constant/SmartModePreference;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainSmartWarmFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ MainSmartWarmFragment newInstance$default(Companion companion, CurrentCoolHeatTypeCode currentCoolHeatTypeCode, SmartModePreference smartModePreference, int i, Object obj) {
            if ((i & 1) != 0) {
                currentCoolHeatTypeCode = CurrentCoolHeatTypeCode.OFF;
            }
            if ((i & 2) != 0) {
                smartModePreference = null;
            }
            return companion.newInstance(currentCoolHeatTypeCode, smartModePreference);
        }

        @JvmStatic
        public final MainSmartWarmFragment newInstance(CurrentCoolHeatTypeCode currentCoolHeatTypeCode, SmartModePreference smartModePreference) {
            Intrinsics.checkNotNullParameter(currentCoolHeatTypeCode, "type");
            MainSmartWarmFragment mainSmartWarmFragment = new MainSmartWarmFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("type", currentCoolHeatTypeCode.getCode());
            bundle.putInt(MainSmartWarmFragment.SMART_MODE_PREF, smartModePreference != null ? smartModePreference.getCode() : SmartModePreference.WEAK.getCode());
            mainSmartWarmFragment.setArguments(bundle);
            return mainSmartWarmFragment;
        }
    }

    public void onCreate(Bundle bundle) {
        SmartModePreference smartModePreference;
        Object obj;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Iterator it = CurrentCoolHeatTypeCode.getEntries().iterator();
            while (true) {
                smartModePreference = null;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((CurrentCoolHeatTypeCode) obj).getCode() == arguments.getInt("type")) {
                    break;
                }
            }
            CurrentCoolHeatTypeCode currentCoolHeatTypeCode = (CurrentCoolHeatTypeCode) obj;
            if (currentCoolHeatTypeCode == null) {
                currentCoolHeatTypeCode = CurrentCoolHeatTypeCode.OFF;
            }
            this.type = currentCoolHeatTypeCode;
            SmartModePreference[] values = SmartModePreference.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                SmartModePreference smartModePreference2 = values[i];
                if (smartModePreference2.getCode() == arguments.getInt(SMART_MODE_PREF)) {
                    smartModePreference = smartModePreference2;
                    break;
                }
                i++;
            }
            if (smartModePreference == null) {
                smartModePreference = SmartModePreference.WEAK;
            }
            this.mSmartModePreference = smartModePreference;
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type jp.co.sony.reonpocket.modules.main.view.MainActivity");
            this.mMainActivity = new WeakReference<>((MainActivity) activity);
            this.mDialogHelper = DialogHelperUtil.Companion.newInstance((Fragment) this);
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            MainSmartWarmPresenter mainSmartWarmPresenter = new MainSmartWarmPresenter(requireContext, this);
            this.mOutput = mainSmartWarmPresenter;
            mainSmartWarmPresenter.onCreate();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_main_smart_warm_mode, viewGroup, false);
        Intrinsics.checkNotNull(inflate);
        initUi(inflate);
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        MainSmartWarmPresenter mainSmartWarmPresenter = this.mOutput;
        if (mainSmartWarmPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainSmartWarmPresenter = null;
        }
        mainSmartWarmPresenter.onViewCreated();
    }

    public void onResume() {
        MainActivity mainActivity;
        super.onResume();
        MainSmartWarmPresenter mainSmartWarmPresenter = this.mOutput;
        if (mainSmartWarmPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainSmartWarmPresenter = null;
        }
        mainSmartWarmPresenter.onResume();
        WeakReference<MainActivity> weakReference = this.mMainActivity;
        if (weakReference != null && (mainActivity = (MainActivity) weakReference.get()) != null) {
            mainActivity.setIsShownSmartWarmBefore(true);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        MainSmartWarmPresenter mainSmartWarmPresenter = this.mOutput;
        if (mainSmartWarmPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainSmartWarmPresenter = null;
        }
        mainSmartWarmPresenter.onViewDestroyed();
    }

    public void onDestroy() {
        super.onDestroy();
        MainSmartWarmPresenter mainSmartWarmPresenter = this.mOutput;
        if (mainSmartWarmPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainSmartWarmPresenter = null;
        }
        mainSmartWarmPresenter.onDestroy();
    }

    public final void applyBleDataEntity(BleDataEntity bleDataEntity) {
        Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
        MainSmartWarmPresenter mainSmartWarmPresenter = this.mOutput;
        if (mainSmartWarmPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainSmartWarmPresenter = null;
        }
        mainSmartWarmPresenter.applyBleDataEntity(bleDataEntity);
    }

    private final void initUi(View view) {
        ConstraintLayout constraintLayout;
        this.mScaleLayout = (FrameLayout) view.findViewById(R.id.scale_view);
        this.mOffView = (ConstraintLayout) view.findViewById(R.id.smart_warm_mode_off_view);
        AppCompatButton appCompatButton = (AppCompatButton) view.findViewById(R.id.main_smart_warm_setting);
        this.mOptionButton = appCompatButton;
        if (appCompatButton != null) {
            appCompatButton.setOnClickListener(new MainSmartWarmFragment$$ExternalSyntheticLambda0(this));
        }
        AppCompatButton appCompatButton2 = (AppCompatButton) view.findViewById(R.id.main_smart_warm_legacy);
        this.mManualButton = appCompatButton2;
        if (appCompatButton2 != null) {
            appCompatButton2.setOnClickListener(new MainSmartWarmFragment$$ExternalSyntheticLambda1(this));
        }
        this.mPauseToast = (LinearLayout) view.findViewById(R.id.toast_pause);
        this.mPauseToastMsg = (TextView) view.findViewById(R.id.toast_msg);
        AppCompatButton appCompatButton3 = (AppCompatButton) view.findViewById(R.id.main_smart_warm_off);
        this.mOffButton = appCompatButton3;
        if (appCompatButton3 != null) {
            appCompatButton3.setOnClickListener(new MainSmartWarmFragment$$ExternalSyntheticLambda2(this));
        }
        View findViewById = view.findViewById(R.id.smart_warm_mode_start_button);
        this.mOnButton = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(new MainSmartWarmFragment$$ExternalSyntheticLambda3(this));
        }
        SmartModePreference smartModePreference = this.mSmartModePreference;
        if (smartModePreference == null) {
            smartModePreference = SmartModePreference.WEAK;
        }
        this.mCurrentPreference = smartModePreference;
        TemperatureSurfaceView temperatureSurfaceView = (TemperatureSurfaceView) view.findViewById(R.id.smart_warm_mode_indicator);
        this.mSmartModeIndicator = temperatureSurfaceView;
        if (temperatureSurfaceView != null) {
            temperatureSurfaceView.setTemp(this.UPPER_TEMP, this.LOWER_TEMP);
        }
        CurrentCoolHeatTypeCode currentCoolHeatTypeCode = this.type;
        this.mState = currentCoolHeatTypeCode;
        int i = WhenMappings.$EnumSwitchMapping$0[currentCoolHeatTypeCode.ordinal()];
        boolean z = false;
        if (i != 1) {
            if (i == 2) {
                TemperatureSurfaceView temperatureSurfaceView2 = this.mSmartModeIndicator;
                if (temperatureSurfaceView2 != null) {
                    temperatureSurfaceView2.setIsDisplayAnimation(true);
                }
                TemperatureSurfaceView temperatureSurfaceView3 = this.mSmartModeIndicator;
                if (temperatureSurfaceView3 != null) {
                    temperatureSurfaceView3.setIsDisplayTarget(true);
                }
                FrameLayout frameLayout = this.mScaleLayout;
                if (frameLayout != null) {
                    frameLayout.setVisibility(0);
                }
                LinearLayout linearLayout = this.mPauseToast;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                TextView textView = this.mPauseToastMsg;
                if (textView != null) {
                    textView.setText(R.string.mainview_content_smart_status_warm);
                }
            } else if (i == 3) {
                TemperatureSurfaceView temperatureSurfaceView4 = this.mSmartModeIndicator;
                if (temperatureSurfaceView4 != null) {
                    temperatureSurfaceView4.setIsDisplayAnimation(false);
                }
                TemperatureSurfaceView temperatureSurfaceView5 = this.mSmartModeIndicator;
                if (temperatureSurfaceView5 != null) {
                    temperatureSurfaceView5.setIsDisplayTarget(false);
                }
                FrameLayout frameLayout2 = this.mScaleLayout;
                if (frameLayout2 != null) {
                    frameLayout2.setVisibility(0);
                }
                LinearLayout linearLayout2 = this.mPauseToast;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                TextView textView2 = this.mPauseToastMsg;
                if (textView2 != null) {
                    textView2.setText(R.string.mainview_content_smart_pause);
                }
            } else if (i != 4) {
                TemperatureSurfaceView temperatureSurfaceView6 = this.mSmartModeIndicator;
                if (temperatureSurfaceView6 != null) {
                    temperatureSurfaceView6.setIsDisplayAnimation(false);
                }
                TemperatureSurfaceView temperatureSurfaceView7 = this.mSmartModeIndicator;
                if (temperatureSurfaceView7 != null) {
                    temperatureSurfaceView7.setIsDisplayTarget(false);
                }
                FrameLayout frameLayout3 = this.mScaleLayout;
                if (frameLayout3 != null) {
                    frameLayout3.setVisibility(4);
                }
                LinearLayout linearLayout3 = this.mPauseToast;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(8);
                }
            } else {
                TemperatureSurfaceView temperatureSurfaceView8 = this.mSmartModeIndicator;
                if (temperatureSurfaceView8 != null) {
                    temperatureSurfaceView8.setIsDisplayAnimation(true);
                }
                TemperatureSurfaceView temperatureSurfaceView9 = this.mSmartModeIndicator;
                if (temperatureSurfaceView9 != null) {
                    temperatureSurfaceView9.setIsDisplayTarget(true);
                }
                FrameLayout frameLayout4 = this.mScaleLayout;
                if (frameLayout4 != null) {
                    frameLayout4.setVisibility(0);
                }
                LinearLayout linearLayout4 = this.mPauseToast;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(0);
                }
                TextView textView3 = this.mPauseToastMsg;
                if (textView3 != null) {
                    textView3.setText(R.string.mainview_content_smart_status_weakwarm);
                }
            }
            z = true;
        } else {
            TemperatureSurfaceView temperatureSurfaceView10 = this.mSmartModeIndicator;
            if (temperatureSurfaceView10 != null) {
                temperatureSurfaceView10.setIsDisplayAnimation(false);
            }
            TemperatureSurfaceView temperatureSurfaceView11 = this.mSmartModeIndicator;
            if (temperatureSurfaceView11 != null) {
                temperatureSurfaceView11.setIsDisplayTarget(false);
            }
            FrameLayout frameLayout5 = this.mScaleLayout;
            if (frameLayout5 != null) {
                frameLayout5.setVisibility(4);
            }
            LinearLayout linearLayout5 = this.mPauseToast;
            if (linearLayout5 != null) {
                linearLayout5.setVisibility(8);
            }
        }
        this.mIsOn = z;
        AppCompatButton appCompatButton4 = this.mOffButton;
        if (appCompatButton4 != null) {
            appCompatButton4.setEnabled(z);
        }
        if (this.mIsOn && (constraintLayout = this.mOffView) != null) {
            constraintLayout.setVisibility(8);
        }
        TemperatureSurfaceView temperatureSurfaceView12 = this.mSmartModeIndicator;
        if (temperatureSurfaceView12 != null) {
            temperatureSurfaceView12.setOff(!this.mIsOn);
        }
        setTargetTemperatureView(this.mSmartModePreference, (Double) null);
    }

    /* access modifiers changed from: private */
    public static final void initUi$lambda$2(MainSmartWarmFragment mainSmartWarmFragment, View view) {
        MainActivity mainActivity;
        Intrinsics.checkNotNullParameter(mainSmartWarmFragment, "this$0");
        WeakReference<MainActivity> weakReference = mainSmartWarmFragment.mMainActivity;
        if (weakReference != null && (mainActivity = (MainActivity) weakReference.get()) != null) {
            mainActivity.showSmartWarmSetting();
        }
    }

    /* access modifiers changed from: private */
    public static final void initUi$lambda$3(MainSmartWarmFragment mainSmartWarmFragment, View view) {
        Intrinsics.checkNotNullParameter(mainSmartWarmFragment, "this$0");
        mainSmartWarmFragment.manualButtonTapped();
    }

    /* access modifiers changed from: private */
    public static final void initUi$lambda$4(MainSmartWarmFragment mainSmartWarmFragment, View view) {
        Intrinsics.checkNotNullParameter(mainSmartWarmFragment, "this$0");
        MainSmartWarmPresenter mainSmartWarmPresenter = mainSmartWarmFragment.mOutput;
        if (mainSmartWarmPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainSmartWarmPresenter = null;
        }
        mainSmartWarmPresenter.setSmartWarmOff();
    }

    /* access modifiers changed from: private */
    public static final void initUi$lambda$7(MainSmartWarmFragment mainSmartWarmFragment, View view) {
        MainSmartWarmPresenter mainSmartWarmPresenter;
        DeviceModeEntity.SmartWarmModeCombine smartWarmModeCombine;
        Intrinsics.checkNotNullParameter(mainSmartWarmFragment, "this$0");
        DeviceModeEntity.SmartWarmModeCombine[] values = DeviceModeEntity.SmartWarmModeCombine.values();
        int length = values.length;
        int i = 0;
        while (true) {
            mainSmartWarmPresenter = null;
            if (i >= length) {
                smartWarmModeCombine = null;
                break;
            }
            smartWarmModeCombine = values[i];
            if (smartWarmModeCombine.getPref() == mainSmartWarmFragment.mCurrentPreference) {
                break;
            }
            i++;
        }
        if (smartWarmModeCombine != null) {
            mainSmartWarmFragment.mCurrentWriteTemperature = smartWarmModeCombine.getTemperature();
        }
        MainSmartWarmPresenter mainSmartWarmPresenter2 = mainSmartWarmFragment.mOutput;
        if (mainSmartWarmPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
        } else {
            mainSmartWarmPresenter = mainSmartWarmPresenter2;
        }
        mainSmartWarmPresenter.setSmartWarmMode(true, mainSmartWarmFragment.mCurrentPreference, ((double) mainSmartWarmFragment.mCurrentWriteTemperature) / 100.0d);
    }

    public final void doSmartWarmSetting(SmartModePreference smartModePreference) {
        Intrinsics.checkNotNullParameter(smartModePreference, "aSmartModePreference");
        MainSmartWarmPresenter mainSmartWarmPresenter = null;
        if (smartModePreference == SmartModePreference.OFF) {
            MainSmartWarmPresenter mainSmartWarmPresenter2 = this.mOutput;
            if (mainSmartWarmPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            } else {
                mainSmartWarmPresenter = mainSmartWarmPresenter2;
            }
            mainSmartWarmPresenter.setSmartWarmOff();
            return;
        }
        DeviceModeEntity.SmartWarmModeCombine forPref = DeviceModeEntity.SmartWarmModeCombine.Companion.forPref(smartModePreference);
        if (forPref != null) {
            int temperature = forPref.getTemperature();
            MainSmartWarmPresenter mainSmartWarmPresenter3 = this.mOutput;
            if (mainSmartWarmPresenter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            } else {
                mainSmartWarmPresenter = mainSmartWarmPresenter3;
            }
            mainSmartWarmPresenter.setSmartWarmMode(true, smartModePreference, ((double) temperature) / 100.0d);
        }
    }

    public final void setSmartWarmPreference(boolean z, SmartModePreference smartModePreference) {
        Intrinsics.checkNotNullParameter(smartModePreference, "aSmartModePreference");
        DeviceModeEntity.SmartWarmModeCombine forPref = DeviceModeEntity.SmartWarmModeCombine.Companion.forPref(smartModePreference);
        if (forPref != null) {
            int temperature = forPref.getTemperature();
            MainSmartWarmPresenter mainSmartWarmPresenter = this.mOutput;
            if (mainSmartWarmPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOutput");
                mainSmartWarmPresenter = null;
            }
            mainSmartWarmPresenter.setSmartWarmMode(z, smartModePreference, ((double) temperature) / 100.0d);
        }
    }

    public void updateTempSetting(SmartModePreference smartModePreference, double d, double d2) {
        MainActivity mainActivity;
        Intrinsics.checkNotNullParameter(smartModePreference, "pref");
        this.mCurrentPreference = smartModePreference;
        setTargetTemperatureView(smartModePreference, Double.valueOf(d2));
        WeakReference<MainActivity> weakReference = this.mMainActivity;
        if (weakReference != null && (mainActivity = (MainActivity) weakReference.get()) != null) {
            mainActivity.setSmartWarmPreference(smartModePreference);
        }
    }

    public void updateViewVisibility(DeviceModeEntity.Temperature temperature) {
        int i;
        Intrinsics.checkNotNullParameter(temperature, "aTemperature");
        if (temperature.getTempOffOnCode() == TemperatureOnOffCode.ON) {
            this.mIsOn = true;
            AppCompatButton appCompatButton = this.mOffButton;
            if (appCompatButton != null) {
                appCompatButton.setEnabled(true);
            }
            TemperatureSurfaceView temperatureSurfaceView = this.mSmartModeIndicator;
            if (temperatureSurfaceView != null) {
                temperatureSurfaceView.setOff(false);
            }
            FrameLayout frameLayout = this.mScaleLayout;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            ConstraintLayout constraintLayout = this.mOffView;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
        } else {
            this.mIsOn = false;
            AppCompatButton appCompatButton2 = this.mOffButton;
            if (appCompatButton2 != null) {
                appCompatButton2.setEnabled(false);
            }
            TemperatureSurfaceView temperatureSurfaceView2 = this.mSmartModeIndicator;
            if (temperatureSurfaceView2 != null) {
                temperatureSurfaceView2.setOff(true);
            }
            FrameLayout frameLayout2 = this.mScaleLayout;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(4);
            }
            ConstraintLayout constraintLayout2 = this.mOffView;
            if (constraintLayout2 != null) {
                constraintLayout2.setVisibility(0);
            }
        }
        setTargetTemperatureView(temperature.getHeatPreference(), (Double) null);
        this.mCurrentPreference = temperature.getHeatPreference();
        DeviceModeEntity.SmartWarmModeCombine forPref = DeviceModeEntity.SmartWarmModeCombine.Companion.forPref(temperature.getHeatPreference());
        if (forPref != null) {
            i = forPref.getTemperature();
        } else {
            i = DeviceModeEntity.SmartWarmModeCombine.LEVEL1.getTemperature();
        }
        this.mCurrentWriteTemperature = i;
    }

    public void updateTecTemp(float f) {
        TemperatureSurfaceView temperatureSurfaceView = this.mSmartModeIndicator;
        if (temperatureSurfaceView != null) {
            temperatureSurfaceView.setTecTemperature(f);
        }
    }

    public void updateCurrentState(CurrentCoolHeatTypeCode currentCoolHeatTypeCode, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(currentCoolHeatTypeCode, "aTypeCode");
        if (!this.mIsOn) {
            LinearLayout linearLayout = this.mPauseToast;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                return;
            }
            return;
        }
        MainSmartWarmPresenter mainSmartWarmPresenter = this.mOutput;
        if (mainSmartWarmPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainSmartWarmPresenter = null;
        }
        if (!mainSmartWarmPresenter.getIsRegisterTag() || !this.mIsNoTagInfoReceiving || (!z2 && !this.mIsNoAmbientTemp)) {
            this.mState = currentCoolHeatTypeCode;
            int i = WhenMappings.$EnumSwitchMapping$0[currentCoolHeatTypeCode.ordinal()];
            if (i == 1) {
                TemperatureSurfaceView temperatureSurfaceView = this.mSmartModeIndicator;
                if (temperatureSurfaceView != null) {
                    temperatureSurfaceView.setIsDisplayAnimation(false);
                }
                TemperatureSurfaceView temperatureSurfaceView2 = this.mSmartModeIndicator;
                if (temperatureSurfaceView2 != null) {
                    temperatureSurfaceView2.setIsDisplayTarget(false);
                }
                LinearLayout linearLayout2 = this.mPauseToast;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(8);
                }
            } else if (i == 2) {
                TemperatureSurfaceView temperatureSurfaceView3 = this.mSmartModeIndicator;
                if (temperatureSurfaceView3 != null) {
                    temperatureSurfaceView3.setIsDisplayAnimation(true);
                }
                TemperatureSurfaceView temperatureSurfaceView4 = this.mSmartModeIndicator;
                if (temperatureSurfaceView4 != null) {
                    temperatureSurfaceView4.setIsDisplayTarget(true);
                }
                LinearLayout linearLayout3 = this.mPauseToast;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(0);
                }
                TextView textView = this.mPauseToastMsg;
                if (textView != null) {
                    textView.setText(R.string.mainview_content_smart_status_warm);
                }
            } else if (i == 3) {
                TemperatureSurfaceView temperatureSurfaceView5 = this.mSmartModeIndicator;
                if (temperatureSurfaceView5 != null) {
                    temperatureSurfaceView5.setIsDisplayAnimation(false);
                }
                TemperatureSurfaceView temperatureSurfaceView6 = this.mSmartModeIndicator;
                if (temperatureSurfaceView6 != null) {
                    temperatureSurfaceView6.setIsDisplayTarget(false);
                }
                LinearLayout linearLayout4 = this.mPauseToast;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(0);
                }
                TextView textView2 = this.mPauseToastMsg;
                if (textView2 != null) {
                    textView2.setText(R.string.mainview_content_smart_pause);
                }
            } else if (i != 4) {
                TemperatureSurfaceView temperatureSurfaceView7 = this.mSmartModeIndicator;
                if (temperatureSurfaceView7 != null) {
                    temperatureSurfaceView7.setIsDisplayAnimation(true);
                }
                TemperatureSurfaceView temperatureSurfaceView8 = this.mSmartModeIndicator;
                if (temperatureSurfaceView8 != null) {
                    temperatureSurfaceView8.setIsDisplayTarget(true);
                }
            } else {
                TemperatureSurfaceView temperatureSurfaceView9 = this.mSmartModeIndicator;
                if (temperatureSurfaceView9 != null) {
                    temperatureSurfaceView9.setIsDisplayAnimation(true);
                }
                TemperatureSurfaceView temperatureSurfaceView10 = this.mSmartModeIndicator;
                if (temperatureSurfaceView10 != null) {
                    temperatureSurfaceView10.setIsDisplayTarget(true);
                }
                LinearLayout linearLayout5 = this.mPauseToast;
                if (linearLayout5 != null) {
                    linearLayout5.setVisibility(0);
                }
                TextView textView3 = this.mPauseToastMsg;
                if (textView3 != null) {
                    textView3.setText(R.string.mainview_content_smart_status_weakcool);
                }
            }
        } else {
            LinearLayout linearLayout6 = this.mPauseToast;
            if (linearLayout6 != null) {
                linearLayout6.setVisibility(0);
            }
            TextView textView4 = this.mPauseToastMsg;
            if (textView4 != null) {
                textView4.setText(getString(R.string.mainview_content_smart_bad_condition_tag));
            }
        }
    }

    public void updateTecRate(float f) {
        TemperatureSurfaceView temperatureSurfaceView = this.mSmartModeIndicator;
        if (temperatureSurfaceView != null) {
            temperatureSurfaceView.setTecRate(f);
        }
    }

    public final void updateNoReceiving(boolean z) {
        if (getContext() == null || !isAttachingActivity()) {
            DebugLogUtil.INSTANCE.e("fun updateNoReceiving error: context or activity is null");
            return;
        }
        this.mIsNoTagInfoReceiving = z;
        updateCurrentState(this.mState, z, this.mIsNoAmbientTemp);
    }

    public final void updateNoAmbientTemp(boolean z) {
        this.mIsNoAmbientTemp = z;
        updateCurrentState(this.mState, this.mIsNoTagInfoReceiving, z);
    }

    private final void manualButtonTapped() {
        MainActivity mainActivity;
        WeakReference<MainActivity> weakReference = this.mMainActivity;
        if (weakReference != null && (mainActivity = (MainActivity) weakReference.get()) != null) {
            mainActivity.transitToWarm();
        }
    }

    private final void setTargetTemperatureView(SmartModePreference smartModePreference, Double d) {
        Float f;
        DeviceModeEntity.SmartWarmModeCombine smartWarmModeCombine;
        int i;
        DeviceModeEntity.SmartWarmModeCombine[] values = DeviceModeEntity.SmartWarmModeCombine.values();
        int length = values.length;
        boolean z = false;
        int i2 = 0;
        while (true) {
            f = null;
            if (i2 >= length) {
                smartWarmModeCombine = null;
                break;
            }
            smartWarmModeCombine = values[i2];
            if (smartWarmModeCombine.getPref() == smartModePreference) {
                break;
            }
            i2++;
        }
        if (smartWarmModeCombine != null) {
            i = smartWarmModeCombine.getTemperature();
        } else {
            i = DeviceModeEntity.SmartWarmModeCombine.LEVEL1.getTemperature();
        }
        if (this.mState == CurrentCoolHeatTypeCode.WEAKHEAT) {
            z = true;
        }
        if (d != null) {
            f = Float.valueOf((float) d.doubleValue());
        }
        if (f != null) {
            float floatValue = f.floatValue();
            TemperatureSurfaceView temperatureSurfaceView = this.mSmartModeIndicator;
            if (temperatureSurfaceView != null) {
                temperatureSurfaceView.setTargetTemperature(((float) i) / 100.0f, floatValue, z);
            }
        }
    }

    public final boolean isActive() {
        return this.mIsOn;
    }
}
