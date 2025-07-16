package jp.co.sony.reonpocket.modules.main.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.ref.WeakReference;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode;
import jp.co.sony.reonpocket.constant.SmartModePreference;
import jp.co.sony.reonpocket.constant.TargetTempControlFactorALS;
import jp.co.sony.reonpocket.constant.TargetTempControlFactorClothesTemp;
import jp.co.sony.reonpocket.constant.TargetTempControlFactorEnvironment;
import jp.co.sony.reonpocket.constant.TargetTempControlStatus;
import jp.co.sony.reonpocket.constant.TemperatureOnOffCode;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import jp.co.sony.reonpocket.data.entity.DeviceModeEntity;
import jp.co.sony.reonpocket.modules.base.view.BaseFragment;
import jp.co.sony.reonpocket.modules.main.presenter.MainSmartCoolPresenter;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.util.DialogHelperUtil;
import jp.co.sony.reonpocket.view.TemperatureSurfaceView;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0013\b\u0007\u0018\u0000 ]2\u00020\u00012\u00020\u0002:\u0001]B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020\bJ\b\u00102\u001a\u00020-H\u0002J\u0010\u00103\u001a\u00020-2\u0006\u00104\u001a\u00020\u001aH\u0002J\u0006\u00105\u001a\u00020\u0010J\u0012\u00106\u001a\u00020-2\b\u00107\u001a\u0004\u0018\u000108H\u0016J&\u00109\u001a\u0004\u0018\u00010\u001a2\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u0010>\u001a\u00020-H\u0016J\b\u0010?\u001a\u00020-H\u0016J\u0010\u0010@\u001a\u00020-2\u0006\u0010A\u001a\u00020BH\u0016J\b\u0010C\u001a\u00020-H\u0016J\u001a\u0010D\u001a\u00020-2\u0006\u0010E\u001a\u00020\u001a2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0016\u0010F\u001a\u00020-2\u0006\u0010G\u001a\u00020\u00102\u0006\u00101\u001a\u00020\bJ!\u0010H\u001a\u00020-2\b\u0010I\u001a\u0004\u0018\u00010\b2\b\u0010J\u001a\u0004\u0018\u00010KH\u0002¢\u0006\u0002\u0010LJ\u0018\u0010M\u001a\u00020-2\u0006\u0010N\u001a\u00020\u00102\u0006\u0010O\u001a\u00020*H\u0016J\u000e\u0010P\u001a\u00020-2\u0006\u0010Q\u001a\u00020\u0010J\u000e\u0010R\u001a\u00020-2\u0006\u0010S\u001a\u00020\u0010J\u0010\u0010T\u001a\u00020-2\u0006\u0010U\u001a\u00020\u0005H\u0016J\u0010\u0010V\u001a\u00020-2\u0006\u0010W\u001a\u00020\u0005H\u0016J \u0010X\u001a\u00020-2\u0006\u0010Y\u001a\u00020\b2\u0006\u0010Z\u001a\u00020K2\u0006\u0010J\u001a\u00020KH\u0016J\u0010\u0010[\u001a\u00020-2\u0006\u0010\\\u001a\u00020*H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainSmartCoolModeFragment;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment;", "Ljp/co/sony/reonpocket/modules/main/view/MainSmartCoolViewInput;", "()V", "LOWER_TEMP", "", "UPPER_TEMP", "mCurrentPreference", "Ljp/co/sony/reonpocket/constant/SmartModePreference;", "mCurrentWriteTemperature", "", "mDialogHelper", "Ljp/co/sony/reonpocket/util/DialogHelperUtil;", "mHelpButton", "Landroidx/appcompat/widget/AppCompatButton;", "mIsNoAmbientTemp", "", "mIsOn", "mIsTagInfoNoReceiving", "mMainActivity", "Ljava/lang/ref/WeakReference;", "Ljp/co/sony/reonpocket/modules/main/view/MainActivity;", "mOffButton", "mOffView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mOnButton", "Landroid/view/View;", "mOutput", "Ljp/co/sony/reonpocket/modules/main/presenter/MainSmartCoolPresenter;", "mPauseToast", "Landroid/widget/LinearLayout;", "mPauseToastMsg", "Landroid/widget/TextView;", "mScaleLayout", "Landroid/widget/FrameLayout;", "mSettingButton", "mSmartModeIndicator", "Ljp/co/sony/reonpocket/view/TemperatureSurfaceView;", "mSmartModePreference", "mState", "Ljp/co/sony/reonpocket/constant/CurrentCoolHeatTypeCode;", "mTemperatureEntity", "Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity$Temperature;", "type", "applyBleDataEntity", "", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "doSmartCoolSetting", "aSmartModePreference", "helpButtonTapped", "initUi", "aView", "isActive", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onFail", "aReason", "", "onResume", "onViewCreated", "view", "setSmartCoolPreference", "aIsOn", "setTargetTemperatureView", "smartPreference", "targetTemp", "", "(Ljp/co/sony/reonpocket/constant/SmartModePreference;Ljava/lang/Double;)V", "updateCurrentState", "isNoAmbientTemp", "temperatureEntity", "updateNoAmbientTemp", "isNotGet", "updateNoReceiving", "isNoReceiving", "updateTecRate", "aRate", "updateTecTemp", "aTecTemp", "updateTempSetting", "pref", "settingTemp", "updateViewVisibility", "aTemperature", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainSmartCoolModeFragment.kt */
public final class MainSmartCoolModeFragment extends BaseFragment implements MainSmartCoolViewInput {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String SMART_MODE_PREF = "smartModePreference";
    private static final String TYPE_KEY = "type";
    private final float LOWER_TEMP = 20.0f;
    private final float UPPER_TEMP = 33.0f;
    private SmartModePreference mCurrentPreference = DeviceModeEntity.SmartCoolModeCombine.LEVEL1.getPref();
    private int mCurrentWriteTemperature = DeviceModeEntity.SmartCoolModeCombine.LEVEL1.getTemperature();
    private DialogHelperUtil mDialogHelper;
    private AppCompatButton mHelpButton;
    private boolean mIsNoAmbientTemp;
    private boolean mIsOn;
    private boolean mIsTagInfoNoReceiving;
    private WeakReference<MainActivity> mMainActivity;
    private AppCompatButton mOffButton;
    private ConstraintLayout mOffView;
    private View mOnButton;
    private MainSmartCoolPresenter mOutput;
    private LinearLayout mPauseToast;
    private TextView mPauseToastMsg;
    private FrameLayout mScaleLayout;
    private AppCompatButton mSettingButton;
    private TemperatureSurfaceView mSmartModeIndicator;
    private SmartModePreference mSmartModePreference;
    private CurrentCoolHeatTypeCode mState = CurrentCoolHeatTypeCode.OFF;
    private DeviceModeEntity.Temperature mTemperatureEntity;
    private CurrentCoolHeatTypeCode type = CurrentCoolHeatTypeCode.OFF;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainSmartCoolModeFragment.kt */
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
                jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode r1 = jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode.COOL     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode r1 = jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode.PAUSE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode r1 = jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode.WEAKCOOL     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.main.view.MainSmartCoolModeFragment.WhenMappings.<clinit>():void");
        }
    }

    @JvmStatic
    public static final MainSmartCoolModeFragment newInstance(CurrentCoolHeatTypeCode currentCoolHeatTypeCode, SmartModePreference smartModePreference) {
        return Companion.newInstance(currentCoolHeatTypeCode, smartModePreference);
    }

    public void onFail(String str) {
        Intrinsics.checkNotNullParameter(str, "aReason");
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainSmartCoolModeFragment$Companion;", "", "()V", "SMART_MODE_PREF", "", "TYPE_KEY", "newInstance", "Ljp/co/sony/reonpocket/modules/main/view/MainSmartCoolModeFragment;", "type", "Ljp/co/sony/reonpocket/constant/CurrentCoolHeatTypeCode;", "mSmartModePreference", "Ljp/co/sony/reonpocket/constant/SmartModePreference;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainSmartCoolModeFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ MainSmartCoolModeFragment newInstance$default(Companion companion, CurrentCoolHeatTypeCode currentCoolHeatTypeCode, SmartModePreference smartModePreference, int i, Object obj) {
            if ((i & 1) != 0) {
                currentCoolHeatTypeCode = CurrentCoolHeatTypeCode.OFF;
            }
            if ((i & 2) != 0) {
                smartModePreference = null;
            }
            return companion.newInstance(currentCoolHeatTypeCode, smartModePreference);
        }

        @JvmStatic
        public final MainSmartCoolModeFragment newInstance(CurrentCoolHeatTypeCode currentCoolHeatTypeCode, SmartModePreference smartModePreference) {
            Intrinsics.checkNotNullParameter(currentCoolHeatTypeCode, "type");
            MainSmartCoolModeFragment mainSmartCoolModeFragment = new MainSmartCoolModeFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("type", currentCoolHeatTypeCode.getCode());
            bundle.putInt(MainSmartCoolModeFragment.SMART_MODE_PREF, smartModePreference != null ? smartModePreference.getCode() : SmartModePreference.WEAK.getCode());
            mainSmartCoolModeFragment.setArguments(bundle);
            return mainSmartCoolModeFragment;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: jp.co.sony.reonpocket.constant.SmartModePreference} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: jp.co.sony.reonpocket.constant.SmartModePreference} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: jp.co.sony.reonpocket.constant.SmartModePreference} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: jp.co.sony.reonpocket.constant.SmartModePreference} */
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
            kotlin.enums.EnumEntries r0 = jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode.getEntries()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0014:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x002f
            java.lang.Object r1 = r0.next()
            r3 = r1
            jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode r3 = (jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode) r3
            int r3 = r3.getCode()
            java.lang.String r4 = "type"
            int r4 = r6.getInt(r4)
            if (r3 != r4) goto L_0x0014
            goto L_0x0030
        L_0x002f:
            r1 = r2
        L_0x0030:
            jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode r1 = (jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode) r1
            if (r1 != 0) goto L_0x0036
            jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode r1 = jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode.OFF
        L_0x0036:
            r5.type = r1
            kotlin.enums.EnumEntries r0 = jp.co.sony.reonpocket.constant.SmartModePreference.getEntries()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0042:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005c
            java.lang.Object r1 = r0.next()
            r3 = r1
            jp.co.sony.reonpocket.constant.SmartModePreference r3 = (jp.co.sony.reonpocket.constant.SmartModePreference) r3
            int r3 = r3.getCode()
            java.lang.String r4 = "smartModePreference"
            int r4 = r6.getInt(r4)
            if (r3 != r4) goto L_0x0042
            r2 = r1
        L_0x005c:
            jp.co.sony.reonpocket.constant.SmartModePreference r2 = (jp.co.sony.reonpocket.constant.SmartModePreference) r2
            if (r2 != 0) goto L_0x0062
            jp.co.sony.reonpocket.constant.SmartModePreference r2 = jp.co.sony.reonpocket.constant.SmartModePreference.WEAK
        L_0x0062:
            r5.mSmartModePreference = r2
            jp.co.sony.reonpocket.util.DialogHelperUtil$Companion r6 = jp.co.sony.reonpocket.util.DialogHelperUtil.Companion
            r0 = r5
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            jp.co.sony.reonpocket.util.DialogHelperUtil r6 = r6.newInstance((androidx.fragment.app.Fragment) r0)
            r5.mDialogHelper = r6
            java.lang.ref.WeakReference r6 = new java.lang.ref.WeakReference
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()
            java.lang.String r1 = "null cannot be cast to non-null type jp.co.sony.reonpocket.modules.main.view.MainActivity"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            jp.co.sony.reonpocket.modules.main.view.MainActivity r0 = (jp.co.sony.reonpocket.modules.main.view.MainActivity) r0
            r6.<init>(r0)
            r5.mMainActivity = r6
            jp.co.sony.reonpocket.modules.main.presenter.MainSmartCoolPresenter r6 = new jp.co.sony.reonpocket.modules.main.presenter.MainSmartCoolPresenter
            android.content.Context r0 = r5.requireContext()
            java.lang.String r1 = "requireContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r1 = r5
            jp.co.sony.reonpocket.modules.main.view.MainSmartCoolViewInput r1 = (jp.co.sony.reonpocket.modules.main.view.MainSmartCoolViewInput) r1
            r6.<init>(r0, r1)
            r5.mOutput = r6
            r6.onCreate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.main.view.MainSmartCoolModeFragment.onCreate(android.os.Bundle):void");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_main_smart_cool_mode, viewGroup, false);
        Intrinsics.checkNotNull(inflate);
        initUi(inflate);
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        MainSmartCoolPresenter mainSmartCoolPresenter = this.mOutput;
        if (mainSmartCoolPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainSmartCoolPresenter = null;
        }
        mainSmartCoolPresenter.onViewCreated();
    }

    public void onResume() {
        MainActivity mainActivity;
        super.onResume();
        MainSmartCoolPresenter mainSmartCoolPresenter = this.mOutput;
        if (mainSmartCoolPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainSmartCoolPresenter = null;
        }
        mainSmartCoolPresenter.onResume();
        WeakReference<MainActivity> weakReference = this.mMainActivity;
        if (weakReference != null && (mainActivity = (MainActivity) weakReference.get()) != null) {
            mainActivity.setIsShownSmartCoolBefore(true);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        MainSmartCoolPresenter mainSmartCoolPresenter = this.mOutput;
        if (mainSmartCoolPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainSmartCoolPresenter = null;
        }
        mainSmartCoolPresenter.onViewDestroyed();
    }

    public void onDestroy() {
        super.onDestroy();
        MainSmartCoolPresenter mainSmartCoolPresenter = this.mOutput;
        if (mainSmartCoolPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainSmartCoolPresenter = null;
        }
        mainSmartCoolPresenter.onDestroy();
    }

    public final void applyBleDataEntity(BleDataEntity bleDataEntity) {
        Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
        MainSmartCoolPresenter mainSmartCoolPresenter = this.mOutput;
        if (mainSmartCoolPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainSmartCoolPresenter = null;
        }
        mainSmartCoolPresenter.applyBleDataEntity(bleDataEntity);
    }

    private final void initUi(View view) {
        ConstraintLayout constraintLayout;
        this.mSettingButton = (AppCompatButton) view.findViewById(R.id.main_smart_cool_setting);
        this.mScaleLayout = (FrameLayout) view.findViewById(R.id.scale_view);
        AppCompatButton appCompatButton = this.mSettingButton;
        if (appCompatButton != null) {
            appCompatButton.setOnClickListener(new MainSmartCoolModeFragment$$ExternalSyntheticLambda0(this));
        }
        this.mPauseToast = (LinearLayout) view.findViewById(R.id.toast_pause);
        this.mPauseToastMsg = (TextView) view.findViewById(R.id.toast_msg);
        this.mOffButton = (AppCompatButton) view.findViewById(R.id.main_smart_cool_off);
        this.mOnButton = view.findViewById(R.id.smart_cool_mode_start_button);
        this.mOffView = (ConstraintLayout) view.findViewById(R.id.smart_cool_mode_off_view);
        View view2 = this.mOnButton;
        if (view2 != null) {
            view2.setOnClickListener(new MainSmartCoolModeFragment$$ExternalSyntheticLambda1(this));
        }
        SmartModePreference smartModePreference = this.mSmartModePreference;
        if (smartModePreference == null) {
            smartModePreference = SmartModePreference.WEAK;
        }
        this.mCurrentPreference = smartModePreference;
        AppCompatButton appCompatButton2 = this.mOffButton;
        if (appCompatButton2 != null) {
            appCompatButton2.setOnClickListener(new MainSmartCoolModeFragment$$ExternalSyntheticLambda2(this));
        }
        TemperatureSurfaceView temperatureSurfaceView = (TemperatureSurfaceView) view.findViewById(R.id.smart_mode_indicator);
        this.mSmartModeIndicator = temperatureSurfaceView;
        if (temperatureSurfaceView != null) {
            temperatureSurfaceView.setTemp(this.UPPER_TEMP, this.LOWER_TEMP);
        }
        MainSmartCoolPresenter mainSmartCoolPresenter = this.mOutput;
        if (mainSmartCoolPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainSmartCoolPresenter = null;
        }
        boolean z = false;
        if (!mainSmartCoolPresenter.isTagRegistered() || !this.mIsNoAmbientTemp) {
            CurrentCoolHeatTypeCode currentCoolHeatTypeCode = this.type;
            this.mState = currentCoolHeatTypeCode;
            int i = WhenMappings.$EnumSwitchMapping$0[currentCoolHeatTypeCode.ordinal()];
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
                        textView.setText(R.string.mainview_content_smart_status_cool);
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
                        textView3.setText(R.string.mainview_content_smart_status_weakcool);
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
            AppCompatButton appCompatButton3 = this.mOffButton;
            if (appCompatButton3 != null) {
                appCompatButton3.setEnabled(z);
            }
            AppCompatButton appCompatButton4 = (AppCompatButton) view.findViewById(R.id.main_smart_legacy);
            this.mHelpButton = appCompatButton4;
            if (appCompatButton4 != null) {
                appCompatButton4.setOnClickListener(new MainSmartCoolModeFragment$$ExternalSyntheticLambda3(this));
            }
            if (this.mIsOn && (constraintLayout = this.mOffView) != null) {
                constraintLayout.setVisibility(8);
            }
            TemperatureSurfaceView temperatureSurfaceView12 = this.mSmartModeIndicator;
            if (temperatureSurfaceView12 != null) {
                temperatureSurfaceView12.setOff(!this.mIsOn);
            }
            setTargetTemperatureView(this.mSmartModePreference, (Double) null);
            return;
        }
        TemperatureSurfaceView temperatureSurfaceView13 = this.mSmartModeIndicator;
        if (temperatureSurfaceView13 != null) {
            temperatureSurfaceView13.setIsDisplayAnimation(true);
        }
        TemperatureSurfaceView temperatureSurfaceView14 = this.mSmartModeIndicator;
        if (temperatureSurfaceView14 != null) {
            temperatureSurfaceView14.setIsDisplayTarget(true);
        }
        FrameLayout frameLayout6 = this.mScaleLayout;
        if (frameLayout6 != null) {
            frameLayout6.setVisibility(0);
        }
        LinearLayout linearLayout6 = this.mPauseToast;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(0);
        }
        TextView textView4 = this.mPauseToastMsg;
        if (textView4 != null) {
            textView4.setText(getString(R.string.mainview_content_smart_bad_condition_tag));
        }
        this.mIsOn = true;
    }

    /* access modifiers changed from: private */
    public static final void initUi$lambda$2(MainSmartCoolModeFragment mainSmartCoolModeFragment, View view) {
        MainActivity mainActivity;
        Intrinsics.checkNotNullParameter(mainSmartCoolModeFragment, "this$0");
        WeakReference<MainActivity> weakReference = mainSmartCoolModeFragment.mMainActivity;
        if (weakReference != null && (mainActivity = (MainActivity) weakReference.get()) != null) {
            mainActivity.showSmartCoolSetting();
        }
    }

    /* access modifiers changed from: private */
    public static final void initUi$lambda$5(MainSmartCoolModeFragment mainSmartCoolModeFragment, View view) {
        MainSmartCoolPresenter mainSmartCoolPresenter;
        DeviceModeEntity.SmartCoolModeCombine smartCoolModeCombine;
        Intrinsics.checkNotNullParameter(mainSmartCoolModeFragment, "this$0");
        DeviceModeEntity.SmartCoolModeCombine[] values = DeviceModeEntity.SmartCoolModeCombine.values();
        int length = values.length;
        int i = 0;
        while (true) {
            mainSmartCoolPresenter = null;
            if (i >= length) {
                smartCoolModeCombine = null;
                break;
            }
            smartCoolModeCombine = values[i];
            if (smartCoolModeCombine.getPref() == mainSmartCoolModeFragment.mCurrentPreference) {
                break;
            }
            i++;
        }
        if (smartCoolModeCombine != null) {
            mainSmartCoolModeFragment.mCurrentWriteTemperature = smartCoolModeCombine.getTemperature();
        }
        MainSmartCoolPresenter mainSmartCoolPresenter2 = mainSmartCoolModeFragment.mOutput;
        if (mainSmartCoolPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
        } else {
            mainSmartCoolPresenter = mainSmartCoolPresenter2;
        }
        mainSmartCoolPresenter.setSmartCoolMode(true, mainSmartCoolModeFragment.mCurrentPreference, ((double) mainSmartCoolModeFragment.mCurrentWriteTemperature) / 100.0d);
    }

    /* access modifiers changed from: private */
    public static final void initUi$lambda$6(MainSmartCoolModeFragment mainSmartCoolModeFragment, View view) {
        Intrinsics.checkNotNullParameter(mainSmartCoolModeFragment, "this$0");
        MainSmartCoolPresenter mainSmartCoolPresenter = mainSmartCoolModeFragment.mOutput;
        if (mainSmartCoolPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainSmartCoolPresenter = null;
        }
        mainSmartCoolPresenter.setSmartCoolOff();
    }

    /* access modifiers changed from: private */
    public static final void initUi$lambda$7(MainSmartCoolModeFragment mainSmartCoolModeFragment, View view) {
        Intrinsics.checkNotNullParameter(mainSmartCoolModeFragment, "this$0");
        mainSmartCoolModeFragment.helpButtonTapped();
    }

    public final void doSmartCoolSetting(SmartModePreference smartModePreference) {
        Intrinsics.checkNotNullParameter(smartModePreference, "aSmartModePreference");
        MainSmartCoolPresenter mainSmartCoolPresenter = null;
        if (smartModePreference == SmartModePreference.OFF) {
            MainSmartCoolPresenter mainSmartCoolPresenter2 = this.mOutput;
            if (mainSmartCoolPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            } else {
                mainSmartCoolPresenter = mainSmartCoolPresenter2;
            }
            mainSmartCoolPresenter.setSmartCoolOff();
            return;
        }
        DeviceModeEntity.SmartCoolModeCombine forPref = DeviceModeEntity.SmartCoolModeCombine.Companion.forPref(smartModePreference);
        if (forPref != null) {
            int temperature = forPref.getTemperature();
            MainSmartCoolPresenter mainSmartCoolPresenter3 = this.mOutput;
            if (mainSmartCoolPresenter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            } else {
                mainSmartCoolPresenter = mainSmartCoolPresenter3;
            }
            mainSmartCoolPresenter.setSmartCoolMode(true, smartModePreference, ((double) temperature) / 100.0d);
        }
    }

    public final void setSmartCoolPreference(boolean z, SmartModePreference smartModePreference) {
        Intrinsics.checkNotNullParameter(smartModePreference, "aSmartModePreference");
        DeviceModeEntity.SmartCoolModeCombine forPref = DeviceModeEntity.SmartCoolModeCombine.Companion.forPref(smartModePreference);
        if (forPref != null) {
            int temperature = forPref.getTemperature();
            MainSmartCoolPresenter mainSmartCoolPresenter = this.mOutput;
            if (mainSmartCoolPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOutput");
                mainSmartCoolPresenter = null;
            }
            mainSmartCoolPresenter.setSmartCoolMode(z, smartModePreference, ((double) temperature) / 100.0d);
        }
    }

    public void updateTempSetting(SmartModePreference smartModePreference, double d, double d2) {
        MainActivity mainActivity;
        Intrinsics.checkNotNullParameter(smartModePreference, "pref");
        this.mCurrentPreference = smartModePreference;
        setTargetTemperatureView(smartModePreference, Double.valueOf(d2));
        WeakReference<MainActivity> weakReference = this.mMainActivity;
        if (weakReference != null && (mainActivity = (MainActivity) weakReference.get()) != null) {
            mainActivity.setSmartCoolPreference(smartModePreference);
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
        DeviceModeEntity.SmartCoolModeCombine forPref = DeviceModeEntity.SmartCoolModeCombine.Companion.forPref(temperature.getHeatPreference());
        if (forPref != null) {
            i = forPref.getTemperature();
        } else {
            i = DeviceModeEntity.SmartCoolModeCombine.LEVEL1.getTemperature();
        }
        this.mCurrentWriteTemperature = i;
    }

    public void updateTecTemp(float f) {
        TemperatureSurfaceView temperatureSurfaceView = this.mSmartModeIndicator;
        if (temperatureSurfaceView != null) {
            temperatureSurfaceView.setTecTemperature(f);
        }
    }

    public void updateCurrentState(boolean z, DeviceModeEntity.Temperature temperature) {
        Intrinsics.checkNotNullParameter(temperature, "temperatureEntity");
        if (!this.mIsOn) {
            LinearLayout linearLayout = this.mPauseToast;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                return;
            }
            return;
        }
        MainSmartCoolPresenter mainSmartCoolPresenter = this.mOutput;
        if (mainSmartCoolPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainSmartCoolPresenter = null;
        }
        boolean isTagRegistered = mainSmartCoolPresenter.isTagRegistered();
        this.mTemperatureEntity = temperature;
        this.mState = temperature.getTempCurrentCoolHeatType();
        if (isTagRegistered && this.mIsTagInfoNoReceiving && (z || this.mIsNoAmbientTemp)) {
            LinearLayout linearLayout2 = this.mPauseToast;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            TextView textView = this.mPauseToastMsg;
            if (textView != null) {
                textView.setText(getString(R.string.mainview_content_smart_bad_condition_tag));
            }
        } else if ((!isTagRegistered || (isTagRegistered && !this.mIsTagInfoNoReceiving)) && temperature.getTargetTempControlStatus() == TargetTempControlStatus.TARGET_TEMP_DOWN && (temperature.getTargetTempControlFactorALS() == TargetTempControlFactorALS.VALID || temperature.getTargetTempControlFactorEnvironment() == TargetTempControlFactorEnvironment.VALID)) {
            LinearLayout linearLayout3 = this.mPauseToast;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(0);
            }
            TextView textView2 = this.mPauseToastMsg;
            if (textView2 != null) {
                textView2.setText(getString(R.string.mainview_content_smart_status_cool_boost_by_tag_status));
            }
        } else if (temperature.getTargetTempControlStatus() == TargetTempControlStatus.TARGET_TEMP_DOWN && temperature.getTargetTempControlFactorClothesTemp() == TargetTempControlFactorClothesTemp.VALID) {
            LinearLayout linearLayout4 = this.mPauseToast;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(0);
            }
            TextView textView3 = this.mPauseToastMsg;
            if (textView3 != null) {
                textView3.setText(getString(R.string.mainview_content_smart_status_cool_boost_by_innerclothes_status));
            }
        } else {
            int i = WhenMappings.$EnumSwitchMapping$0[temperature.getTempCurrentCoolHeatType().ordinal()];
            if (i == 1) {
                TemperatureSurfaceView temperatureSurfaceView = this.mSmartModeIndicator;
                if (temperatureSurfaceView != null) {
                    temperatureSurfaceView.setIsDisplayAnimation(false);
                }
                TemperatureSurfaceView temperatureSurfaceView2 = this.mSmartModeIndicator;
                if (temperatureSurfaceView2 != null) {
                    temperatureSurfaceView2.setIsDisplayTarget(false);
                }
                LinearLayout linearLayout5 = this.mPauseToast;
                if (linearLayout5 != null) {
                    linearLayout5.setVisibility(8);
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
                LinearLayout linearLayout6 = this.mPauseToast;
                if (linearLayout6 != null) {
                    linearLayout6.setVisibility(0);
                }
                TextView textView4 = this.mPauseToastMsg;
                if (textView4 != null) {
                    textView4.setText(R.string.mainview_content_smart_status_cool);
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
                LinearLayout linearLayout7 = this.mPauseToast;
                if (linearLayout7 != null) {
                    linearLayout7.setVisibility(0);
                }
                TextView textView5 = this.mPauseToastMsg;
                if (textView5 != null) {
                    textView5.setText(R.string.mainview_content_smart_pause);
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
                LinearLayout linearLayout8 = this.mPauseToast;
                if (linearLayout8 != null) {
                    linearLayout8.setVisibility(8);
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
                LinearLayout linearLayout9 = this.mPauseToast;
                if (linearLayout9 != null) {
                    linearLayout9.setVisibility(0);
                }
                TextView textView6 = this.mPauseToastMsg;
                if (textView6 != null) {
                    textView6.setText(R.string.mainview_content_smart_status_weakcool);
                }
            }
        }
    }

    public final void updateNoReceiving(boolean z) {
        if (getContext() == null || !isAttachingActivity()) {
            DebugLogUtil.INSTANCE.e("fun updateNoReceiving error: context or activity is null");
        } else if (this.mIsTagInfoNoReceiving != z) {
            this.mIsTagInfoNoReceiving = z;
            DeviceModeEntity.Temperature temperature = this.mTemperatureEntity;
            if (temperature != null) {
                updateCurrentState(false, temperature);
            }
        }
    }

    public final void updateNoAmbientTemp(boolean z) {
        this.mIsNoAmbientTemp = z;
        DeviceModeEntity.Temperature temperature = this.mTemperatureEntity;
        if (temperature != null) {
            updateCurrentState(z, temperature);
        }
    }

    public void updateTecRate(float f) {
        TemperatureSurfaceView temperatureSurfaceView = this.mSmartModeIndicator;
        if (temperatureSurfaceView != null) {
            temperatureSurfaceView.setTecRate(f);
        }
    }

    public final boolean isActive() {
        return this.mIsOn;
    }

    private final void helpButtonTapped() {
        MainActivity mainActivity;
        WeakReference<MainActivity> weakReference = this.mMainActivity;
        if (weakReference != null && (mainActivity = (MainActivity) weakReference.get()) != null) {
            mainActivity.transitToCool();
        }
    }

    private final void setTargetTemperatureView(SmartModePreference smartModePreference, Double d) {
        Float f;
        DeviceModeEntity.SmartCoolModeCombine smartCoolModeCombine;
        int i;
        DeviceModeEntity.SmartCoolModeCombine[] values = DeviceModeEntity.SmartCoolModeCombine.values();
        int length = values.length;
        boolean z = false;
        int i2 = 0;
        while (true) {
            f = null;
            if (i2 >= length) {
                smartCoolModeCombine = null;
                break;
            }
            smartCoolModeCombine = values[i2];
            if (smartCoolModeCombine.getPref() == smartModePreference) {
                break;
            }
            i2++;
        }
        if (smartCoolModeCombine != null) {
            i = smartCoolModeCombine.getTemperature();
        } else {
            i = DeviceModeEntity.SmartCoolModeCombine.LEVEL1.getTemperature();
        }
        if (this.mState == CurrentCoolHeatTypeCode.WEAKCOOL) {
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
}
