package jp.co.sony.reonpocket.modules.main.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.lang.ref.WeakReference;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode;
import jp.co.sony.reonpocket.constant.SmartModePreference;
import jp.co.sony.reonpocket.constant.SwitchingTrigger1;
import jp.co.sony.reonpocket.constant.SwitchingTrigger2;
import jp.co.sony.reonpocket.constant.TargetTempControlFactorALS;
import jp.co.sony.reonpocket.constant.TargetTempControlFactorClothesTemp;
import jp.co.sony.reonpocket.constant.TargetTempControlFactorEnvironment;
import jp.co.sony.reonpocket.constant.TargetTempControlStatus;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import jp.co.sony.reonpocket.data.entity.DeviceModeEntity;
import jp.co.sony.reonpocket.data.entity.DeviceModeEntityKt;
import jp.co.sony.reonpocket.modules.base.view.BaseFragment;
import jp.co.sony.reonpocket.modules.main.presenter.MainSmartPresenter;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.util.DialogHelperUtil;
import jp.co.sony.reonpocket.view.TemperatureSurfaceView;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b \b\u0007\u0018\u0000 ~2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001~B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CJ&\u0010D\u001a\u00020A2\u0006\u0010E\u001a\u00020\u00142\u0006\u0010F\u001a\u00020\u00142\u0006\u0010G\u001a\u00020\u00162\u0006\u0010H\u001a\u00020\u0016J.\u0010D\u001a\u00020A2\u0006\u0010I\u001a\u00020\u00112\u0006\u0010J\u001a\u00020\u00142\u0006\u0010K\u001a\u00020\u00142\u0006\u0010G\u001a\u00020\u00162\u0006\u0010H\u001a\u00020\u0016J\u001e\u0010D\u001a\u00020A2\u0006\u0010I\u001a\u00020\u00112\u0006\u0010G\u001a\u00020\u00162\u0006\u0010H\u001a\u00020\u0016J\u0016\u0010D\u001a\u00020A2\u0006\u0010G\u001a\u00020\u00162\u0006\u0010H\u001a\u00020\u0016J\u0010\u0010L\u001a\u00020A2\u0006\u0010M\u001a\u00020.H\u0002J\u0006\u0010N\u001a\u00020\u0011J\u0006\u0010O\u001a\u00020\u0011J\b\u0010P\u001a\u00020AH\u0002J\u0012\u0010Q\u001a\u00020A2\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J&\u0010T\u001a\u0004\u0018\u00010.2\u0006\u0010U\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010X2\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J\b\u0010Y\u001a\u00020AH\u0016J\b\u0010Z\u001a\u00020AH\u0016J\u0010\u0010[\u001a\u00020A2\u0006\u0010\\\u001a\u00020\bH\u0016J\u0010\u0010]\u001a\u00020\u00112\u0006\u0010^\u001a\u00020_H\u0016J\b\u0010`\u001a\u00020AH\u0016J\u001a\u0010a\u001a\u00020A2\u0006\u0010b\u001a\u00020.2\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J\u001a\u0010c\u001a\u00020A2\u0006\u0010d\u001a\u00020\u00112\b\u0010e\u001a\u0004\u0018\u00010\bH\u0002J\"\u0010f\u001a\u00020A2\b\u0010g\u001a\u0004\u0018\u00010\u000b2\u0006\u0010h\u001a\u00020\u00112\u0006\u0010i\u001a\u00020\u0011H\u0016J\u0010\u0010j\u001a\u00020A2\u0006\u0010k\u001a\u00020.H\u0002J\u000e\u0010l\u001a\u00020A2\u0006\u0010m\u001a\u00020\u0011J\u000e\u0010n\u001a\u00020A2\u0006\u0010o\u001a\u00020\u0011J\u0010\u0010p\u001a\u00020A2\u0006\u0010q\u001a\u00020\u0006H\u0016J\u0010\u0010r\u001a\u00020A2\u0006\u0010s\u001a\u00020\u0006H\u0016J8\u0010t\u001a\u00020A2\u0006\u0010I\u001a\u00020\u00112\u0006\u0010u\u001a\u00020\u00192\u0006\u0010G\u001a\u00020\u00162\u0006\u0010H\u001a\u00020\u00162\u0006\u0010v\u001a\u00020\u00142\u0006\u0010w\u001a\u00020\u0014H\u0016J)\u0010x\u001a\u00020A2\u0006\u0010y\u001a\u00020\u00112\b\u0010z\u001a\u0004\u0018\u00010\u00142\b\u0010{\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010|J\u0010\u0010}\u001a\u00020A2\u0006\u0010g\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X.¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0010\u0010;\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010>\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010?\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainSmartModeFragment;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment;", "Ljp/co/sony/reonpocket/modules/main/view/MainSmartViewInput;", "Landroid/widget/PopupMenu$OnMenuItemClickListener;", "()V", "LOWER_TEMP", "", "TAG", "", "UPPER_TEMP", "currentTemperatureEntity", "Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity$Temperature;", "mBottomToast", "Landroid/widget/LinearLayout;", "mBottomToastMsg", "Landroid/widget/TextView;", "mCoolHeatChangeTrigger1", "", "mCoolHeatChangeTrigger2", "mCoolPreference", "Ljp/co/sony/reonpocket/constant/SmartModePreference;", "mCoolTempSwithThreshold", "", "Ljava/lang/Double;", "mCurrentCoolHeatType", "Ljp/co/sony/reonpocket/constant/CurrentCoolHeatTypeCode;", "mCurrentCoolPreference", "mCurrentCoolTempSwitchThreshold", "mCurrentCoolWriteTemperature", "", "mCurrentWarmPreference", "mCurrentWarmTempSwitchThreshold", "mCurrentWarmWriteTemperature", "mDialogHelper", "Ljp/co/sony/reonpocket/util/DialogHelperUtil;", "mIsNoAmbientTemp", "mIsOn", "mIsTagInfoNoReceiving", "mMainActivity", "Ljava/lang/ref/WeakReference;", "Ljp/co/sony/reonpocket/modules/main/view/MainActivity;", "mOffButton", "Landroidx/appcompat/widget/AppCompatButton;", "mOffView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mOnButton", "Landroid/view/View;", "mOutput", "Ljp/co/sony/reonpocket/modules/main/presenter/MainSmartPresenter;", "mScaleLayout", "Landroid/widget/FrameLayout;", "mSettingButton", "mSmartModeIndicator", "Ljp/co/sony/reonpocket/view/TemperatureSurfaceView;", "mState", "getMState", "()Ljp/co/sony/reonpocket/constant/CurrentCoolHeatTypeCode;", "setMState", "(Ljp/co/sony/reonpocket/constant/CurrentCoolHeatTypeCode;)V", "mTopToast", "mTopToastMsg", "mWarmPreference", "mWarmTempSwithThreshold", "type", "applyBleDataEntity", "", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "doSmartSetting", "coolPref", "warmPref", "coolTempSwitchThreshold", "warmTempSwitchThreshold", "isOn", "coolSmartModePreference", "warmSmartModePreference", "initUi", "aView", "isActive", "isSmartMixTypeCool", "onButtonTapped", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onFail", "aReason", "onMenuItemClick", "item", "Landroid/view/MenuItem;", "onResume", "onViewCreated", "view", "setToast", "isOff", "message", "showCoolHeatState", "aTemperatureEntity", "aIsTagInfoNoReceiving", "aIsTagNoAmbientTemp", "showOptionMenuPopup", "anchor", "updateNoAmbientTemp", "isNotGet", "updateNoReceiving", "isNoReceiving", "updateSmartTecRate", "aRate", "updateSmartTecTemp", "aTecTemp", "updateStates", "currentCoolHeatTypeCode", "coolPreference", "heatPreference", "updateTargetTemperatureView", "isCool", "smartPreference", "targetTemp", "(ZLjp/co/sony/reonpocket/constant/SmartModePreference;Ljava/lang/Double;)V", "updateViewVisibility", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainSmartModeFragment.kt */
public final class MainSmartModeFragment extends BaseFragment implements MainSmartViewInput, PopupMenu.OnMenuItemClickListener {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String SMART_COOL_PREF = "smartCoolPreference";
    private static final String SMART_COOL_TEMP_SWITCH_THRESHOLD = "smartCoolTempSwitchThreshold";
    private static final String SMART_WARM_PREF = "smartWarmPreference";
    private static final String SMART_WARM_TEMP_SWITCH_THRESHOLD = "smartWarmTempSwitchThreshold";
    private static final String TYPE_KEY = "type";
    private final float LOWER_TEMP = 20.0f;
    private final String TAG = "MainSmartFragment";
    private final float UPPER_TEMP = 43.0f;
    private DeviceModeEntity.Temperature currentTemperatureEntity;
    private LinearLayout mBottomToast;
    private TextView mBottomToastMsg;
    private boolean mCoolHeatChangeTrigger1;
    private boolean mCoolHeatChangeTrigger2;
    private SmartModePreference mCoolPreference;
    private Double mCoolTempSwithThreshold;
    private CurrentCoolHeatTypeCode mCurrentCoolHeatType = CurrentCoolHeatTypeCode.OFF;
    private SmartModePreference mCurrentCoolPreference = DeviceModeEntity.SmartCoolModeCombine.LEVEL1.getPref();
    private double mCurrentCoolTempSwitchThreshold = 25.0d;
    private int mCurrentCoolWriteTemperature = DeviceModeEntity.SmartCoolModeCombine.LEVEL1.getTemperature();
    private SmartModePreference mCurrentWarmPreference = DeviceModeEntity.SmartWarmModeCombine.LEVEL1.getPref();
    private double mCurrentWarmTempSwitchThreshold = 25.0d;
    private int mCurrentWarmWriteTemperature = DeviceModeEntity.SmartWarmModeCombine.LEVEL1.getTemperature();
    private DialogHelperUtil mDialogHelper;
    private boolean mIsNoAmbientTemp;
    private boolean mIsOn;
    private boolean mIsTagInfoNoReceiving;
    private WeakReference<MainActivity> mMainActivity;
    private AppCompatButton mOffButton;
    private ConstraintLayout mOffView;
    private View mOnButton;
    private MainSmartPresenter mOutput;
    private FrameLayout mScaleLayout;
    private AppCompatButton mSettingButton;
    private TemperatureSurfaceView mSmartModeIndicator;
    private CurrentCoolHeatTypeCode mState = CurrentCoolHeatTypeCode.OFF;
    private LinearLayout mTopToast;
    private TextView mTopToastMsg;
    private SmartModePreference mWarmPreference;
    private Double mWarmTempSwithThreshold;
    private CurrentCoolHeatTypeCode type = CurrentCoolHeatTypeCode.OFF;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainSmartModeFragment.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|1|2|3|4|5|6|7|8|9|10|11|12|13|15) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
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
                jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode r1 = jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode.HEAT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode r1 = jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode.PAUSE     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode r1 = jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode.WEAKCOOL     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode r1 = jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode.WEAKHEAT     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.main.view.MainSmartModeFragment.WhenMappings.<clinit>():void");
        }
    }

    @JvmStatic
    public static final MainSmartModeFragment newInstance(CurrentCoolHeatTypeCode currentCoolHeatTypeCode, SmartModePreference smartModePreference, SmartModePreference smartModePreference2, Double d, Double d2) {
        return Companion.newInstance(currentCoolHeatTypeCode, smartModePreference, smartModePreference2, d, d2);
    }

    public void onFail(String str) {
        Intrinsics.checkNotNullParameter(str, "aReason");
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JG\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainSmartModeFragment$Companion;", "", "()V", "SMART_COOL_PREF", "", "SMART_COOL_TEMP_SWITCH_THRESHOLD", "SMART_WARM_PREF", "SMART_WARM_TEMP_SWITCH_THRESHOLD", "TYPE_KEY", "newInstance", "Ljp/co/sony/reonpocket/modules/main/view/MainSmartModeFragment;", "type", "Ljp/co/sony/reonpocket/constant/CurrentCoolHeatTypeCode;", "smartCoolPreference", "Ljp/co/sony/reonpocket/constant/SmartModePreference;", "smartWarmPreference", "smartCoolTempSwitchThreshold", "", "smartWarmTempSwitchThreshold", "(Ljp/co/sony/reonpocket/constant/CurrentCoolHeatTypeCode;Ljp/co/sony/reonpocket/constant/SmartModePreference;Ljp/co/sony/reonpocket/constant/SmartModePreference;Ljava/lang/Double;Ljava/lang/Double;)Ljp/co/sony/reonpocket/modules/main/view/MainSmartModeFragment;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainSmartModeFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ MainSmartModeFragment newInstance$default(Companion companion, CurrentCoolHeatTypeCode currentCoolHeatTypeCode, SmartModePreference smartModePreference, SmartModePreference smartModePreference2, Double d, Double d2, int i, Object obj) {
            if ((i & 1) != 0) {
                currentCoolHeatTypeCode = CurrentCoolHeatTypeCode.OFF;
            }
            Double d3 = null;
            SmartModePreference smartModePreference3 = (i & 2) != 0 ? null : smartModePreference;
            SmartModePreference smartModePreference4 = (i & 4) != 0 ? null : smartModePreference2;
            Double d4 = (i & 8) != 0 ? null : d;
            if ((i & 16) == 0) {
                d3 = d2;
            }
            return companion.newInstance(currentCoolHeatTypeCode, smartModePreference3, smartModePreference4, d4, d3);
        }

        @JvmStatic
        public final MainSmartModeFragment newInstance(CurrentCoolHeatTypeCode currentCoolHeatTypeCode, SmartModePreference smartModePreference, SmartModePreference smartModePreference2, Double d, Double d2) {
            Intrinsics.checkNotNullParameter(currentCoolHeatTypeCode, "type");
            MainSmartModeFragment mainSmartModeFragment = new MainSmartModeFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("type", currentCoolHeatTypeCode.getCode());
            bundle.putInt(MainSmartModeFragment.SMART_COOL_PREF, smartModePreference != null ? smartModePreference.getCode() : SmartModePreference.WEAK.getCode());
            bundle.putInt(MainSmartModeFragment.SMART_WARM_PREF, smartModePreference2 != null ? smartModePreference2.getCode() : SmartModePreference.WEAK.getCode());
            double d3 = 25.0d;
            bundle.putDouble(MainSmartModeFragment.SMART_COOL_TEMP_SWITCH_THRESHOLD, d != null ? d.doubleValue() : 25.0d);
            if (d2 != null) {
                d3 = d2.doubleValue();
            }
            bundle.putDouble(MainSmartModeFragment.SMART_WARM_TEMP_SWITCH_THRESHOLD, d3);
            mainSmartModeFragment.setArguments(bundle);
            return mainSmartModeFragment;
        }
    }

    public final CurrentCoolHeatTypeCode getMState() {
        return this.mState;
    }

    public final void setMState(CurrentCoolHeatTypeCode currentCoolHeatTypeCode) {
        Intrinsics.checkNotNullParameter(currentCoolHeatTypeCode, "<set-?>");
        this.mState = currentCoolHeatTypeCode;
    }

    public void onCreate(Bundle bundle) {
        SmartModePreference smartModePreference;
        CurrentCoolHeatTypeCode currentCoolHeatTypeCode;
        SmartModePreference smartModePreference2;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            int i = arguments.getInt("type");
            CurrentCoolHeatTypeCode[] values = CurrentCoolHeatTypeCode.values();
            int length = values.length;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                smartModePreference = null;
                if (i3 >= length) {
                    currentCoolHeatTypeCode = null;
                    break;
                }
                currentCoolHeatTypeCode = values[i3];
                if (currentCoolHeatTypeCode.getCode() == i) {
                    break;
                }
                i3++;
            }
            CurrentCoolHeatTypeCode currentCoolHeatTypeCode2 = currentCoolHeatTypeCode;
            if (currentCoolHeatTypeCode2 == null) {
                currentCoolHeatTypeCode2 = CurrentCoolHeatTypeCode.OFF;
            }
            this.type = currentCoolHeatTypeCode2;
            int i4 = arguments.getInt(SMART_COOL_PREF);
            SmartModePreference[] values2 = SmartModePreference.values();
            int length2 = values2.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length2) {
                    smartModePreference2 = null;
                    break;
                }
                smartModePreference2 = values2[i5];
                if (smartModePreference2.getCode() == i4) {
                    break;
                }
                i5++;
            }
            SmartModePreference smartModePreference3 = smartModePreference2;
            if (smartModePreference3 == null) {
                smartModePreference3 = SmartModePreference.WEAK;
            }
            this.mCoolPreference = smartModePreference3;
            int i6 = arguments.getInt(SMART_WARM_PREF);
            SmartModePreference[] values3 = SmartModePreference.values();
            int length3 = values3.length;
            while (true) {
                if (i2 >= length3) {
                    break;
                }
                SmartModePreference smartModePreference4 = values3[i2];
                if (smartModePreference4.getCode() == i6) {
                    smartModePreference = smartModePreference4;
                    break;
                }
                i2++;
            }
            SmartModePreference smartModePreference5 = smartModePreference;
            if (smartModePreference5 == null) {
                smartModePreference5 = SmartModePreference.WEAK;
            }
            this.mWarmPreference = smartModePreference5;
            this.mCoolTempSwithThreshold = Double.valueOf(arguments.getDouble(SMART_COOL_TEMP_SWITCH_THRESHOLD));
            this.mWarmTempSwithThreshold = Double.valueOf(arguments.getDouble(SMART_WARM_TEMP_SWITCH_THRESHOLD));
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type jp.co.sony.reonpocket.modules.main.view.MainActivity");
            this.mMainActivity = new WeakReference<>((MainActivity) activity);
            this.mDialogHelper = DialogHelperUtil.Companion.newInstance((Fragment) this);
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            MainSmartPresenter mainSmartPresenter = new MainSmartPresenter(requireContext, this);
            this.mOutput = mainSmartPresenter;
            mainSmartPresenter.onCreate();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_main_smart_mode, viewGroup, false);
        Intrinsics.checkNotNull(inflate);
        initUi(inflate);
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        MainSmartPresenter mainSmartPresenter = this.mOutput;
        if (mainSmartPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainSmartPresenter = null;
        }
        mainSmartPresenter.onViewCreated();
    }

    public void onResume() {
        super.onResume();
        MainSmartPresenter mainSmartPresenter = this.mOutput;
        if (mainSmartPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainSmartPresenter = null;
        }
        mainSmartPresenter.onResume();
    }

    public void onDestroyView() {
        super.onDestroyView();
        MainSmartPresenter mainSmartPresenter = this.mOutput;
        if (mainSmartPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainSmartPresenter = null;
        }
        mainSmartPresenter.onViewDestroyed();
    }

    public void onDestroy() {
        super.onDestroy();
        MainSmartPresenter mainSmartPresenter = this.mOutput;
        if (mainSmartPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainSmartPresenter = null;
        }
        mainSmartPresenter.onDestroy();
    }

    public final void applyBleDataEntity(BleDataEntity bleDataEntity) {
        Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
        MainSmartPresenter mainSmartPresenter = this.mOutput;
        if (mainSmartPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainSmartPresenter = null;
        }
        mainSmartPresenter.applyBleDataEntity(bleDataEntity);
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        MainActivity mainActivity;
        MainActivity mainActivity2;
        Intrinsics.checkNotNullParameter(menuItem, "item");
        int itemId = menuItem.getItemId();
        if (itemId == R.id.pref_temp) {
            WeakReference<MainActivity> weakReference = this.mMainActivity;
            if (weakReference == null || (mainActivity2 = (MainActivity) weakReference.get()) == null) {
                return true;
            }
            mainActivity2.showSmartSetting();
            return true;
        } else if (itemId != R.id.switch_temp) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            WeakReference<MainActivity> weakReference2 = this.mMainActivity;
            if (weakReference2 == null || (mainActivity = (MainActivity) weakReference2.get()) == null) {
                return true;
            }
            mainActivity.showSmartSwitchingTempSetting();
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x019e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initUi(android.view.View r5) {
        /*
            r4 = this;
            int r0 = jp.co.sony.reonpocket.R.id.scale_view
            android.view.View r0 = r5.findViewById(r0)
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            r4.mScaleLayout = r0
            int r0 = jp.co.sony.reonpocket.R.id.main_smart_setting
            android.view.View r0 = r5.findViewById(r0)
            androidx.appcompat.widget.AppCompatButton r0 = (androidx.appcompat.widget.AppCompatButton) r0
            r4.mSettingButton = r0
            int r0 = jp.co.sony.reonpocket.R.id.toast_warm
            android.view.View r0 = r5.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r4.mBottomToast = r0
            int r0 = jp.co.sony.reonpocket.R.id.toast_warm_msg
            android.view.View r0 = r5.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r4.mBottomToastMsg = r0
            int r0 = jp.co.sony.reonpocket.R.id.toast_cool
            android.view.View r0 = r5.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r4.mTopToast = r0
            int r0 = jp.co.sony.reonpocket.R.id.toast_cool_msg
            android.view.View r0 = r5.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r4.mTopToastMsg = r0
            int r0 = jp.co.sony.reonpocket.R.id.smart_mode_off_view
            android.view.View r0 = r5.findViewById(r0)
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            r4.mOffView = r0
            int r0 = jp.co.sony.reonpocket.R.id.main_smart_off
            android.view.View r0 = r5.findViewById(r0)
            androidx.appcompat.widget.AppCompatButton r0 = (androidx.appcompat.widget.AppCompatButton) r0
            r4.mOffButton = r0
            int r0 = jp.co.sony.reonpocket.R.id.smart_mode_start_button
            android.view.View r0 = r5.findViewById(r0)
            r4.mOnButton = r0
            int r0 = jp.co.sony.reonpocket.R.id.smart_indicator
            android.view.View r5 = r5.findViewById(r0)
            jp.co.sony.reonpocket.view.TemperatureSurfaceView r5 = (jp.co.sony.reonpocket.view.TemperatureSurfaceView) r5
            r4.mSmartModeIndicator = r5
            java.lang.Double r5 = r4.mCoolTempSwithThreshold
            r0 = 4627730092099895296(0x4039000000000000, double:25.0)
            if (r5 == 0) goto L_0x006d
            double r2 = r5.doubleValue()
            goto L_0x006e
        L_0x006d:
            r2 = r0
        L_0x006e:
            r4.mCurrentCoolTempSwitchThreshold = r2
            java.lang.Double r5 = r4.mWarmTempSwithThreshold
            if (r5 == 0) goto L_0x0078
            double r0 = r5.doubleValue()
        L_0x0078:
            r4.mCurrentWarmTempSwitchThreshold = r0
            androidx.appcompat.widget.AppCompatButton r5 = r4.mSettingButton
            if (r5 == 0) goto L_0x0086
            jp.co.sony.reonpocket.modules.main.view.MainSmartModeFragment$$ExternalSyntheticLambda0 r0 = new jp.co.sony.reonpocket.modules.main.view.MainSmartModeFragment$$ExternalSyntheticLambda0
            r0.<init>(r4)
            r5.setOnClickListener(r0)
        L_0x0086:
            androidx.appcompat.widget.AppCompatButton r5 = r4.mOffButton
            if (r5 == 0) goto L_0x0092
            jp.co.sony.reonpocket.modules.main.view.MainSmartModeFragment$$ExternalSyntheticLambda1 r0 = new jp.co.sony.reonpocket.modules.main.view.MainSmartModeFragment$$ExternalSyntheticLambda1
            r0.<init>(r4)
            r5.setOnClickListener(r0)
        L_0x0092:
            android.view.View r5 = r4.mOnButton
            if (r5 == 0) goto L_0x009e
            jp.co.sony.reonpocket.modules.main.view.MainSmartModeFragment$$ExternalSyntheticLambda2 r0 = new jp.co.sony.reonpocket.modules.main.view.MainSmartModeFragment$$ExternalSyntheticLambda2
            r0.<init>(r4)
            r5.setOnClickListener(r0)
        L_0x009e:
            jp.co.sony.reonpocket.constant.SmartModePreference r5 = r4.mCoolPreference
            if (r5 != 0) goto L_0x00a4
            jp.co.sony.reonpocket.constant.SmartModePreference r5 = jp.co.sony.reonpocket.constant.SmartModePreference.WEAK
        L_0x00a4:
            r4.mCurrentCoolPreference = r5
            jp.co.sony.reonpocket.constant.SmartModePreference r5 = r4.mWarmPreference
            if (r5 != 0) goto L_0x00ac
            jp.co.sony.reonpocket.constant.SmartModePreference r5 = jp.co.sony.reonpocket.constant.SmartModePreference.WEAK
        L_0x00ac:
            r4.mCurrentWarmPreference = r5
            jp.co.sony.reonpocket.view.TemperatureSurfaceView r5 = r4.mSmartModeIndicator
            if (r5 == 0) goto L_0x00b9
            float r0 = r4.UPPER_TEMP
            float r1 = r4.LOWER_TEMP
            r5.setTemp(r0, r1)
        L_0x00b9:
            jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode r5 = r4.type
            r4.mState = r5
            int[] r0 = jp.co.sony.reonpocket.modules.main.view.MainSmartModeFragment.WhenMappings.$EnumSwitchMapping$0
            int r5 = r5.ordinal()
            r5 = r0[r5]
            r0 = 4
            r1 = 1
            r2 = 0
            if (r5 == r1) goto L_0x0177
            r3 = 2
            if (r5 == r3) goto L_0x0156
            r3 = 3
            if (r5 == r3) goto L_0x0136
            if (r5 == r0) goto L_0x0116
            r0 = 5
            if (r5 == r0) goto L_0x00f6
            jp.co.sony.reonpocket.view.TemperatureSurfaceView r5 = r4.mSmartModeIndicator
            if (r5 == 0) goto L_0x00dc
            r5.setIsDisplayAnimation(r1)
        L_0x00dc:
            jp.co.sony.reonpocket.view.TemperatureSurfaceView r5 = r4.mSmartModeIndicator
            if (r5 == 0) goto L_0x00e3
            r5.setIsDisplayTarget(r1)
        L_0x00e3:
            android.widget.FrameLayout r5 = r4.mScaleLayout
            if (r5 != 0) goto L_0x00e8
            goto L_0x00eb
        L_0x00e8:
            r5.setVisibility(r2)
        L_0x00eb:
            int r5 = jp.co.sony.reonpocket.R.string.mainview_content_smart_status_weakwarm
            java.lang.String r5 = r4.getString(r5)
            r4.setToast(r2, r5)
            goto L_0x0196
        L_0x00f6:
            jp.co.sony.reonpocket.view.TemperatureSurfaceView r5 = r4.mSmartModeIndicator
            if (r5 == 0) goto L_0x00fd
            r5.setIsDisplayAnimation(r1)
        L_0x00fd:
            jp.co.sony.reonpocket.view.TemperatureSurfaceView r5 = r4.mSmartModeIndicator
            if (r5 == 0) goto L_0x0104
            r5.setIsDisplayTarget(r1)
        L_0x0104:
            android.widget.FrameLayout r5 = r4.mScaleLayout
            if (r5 != 0) goto L_0x0109
            goto L_0x010c
        L_0x0109:
            r5.setVisibility(r2)
        L_0x010c:
            int r5 = jp.co.sony.reonpocket.R.string.mainview_content_smart_status_weakcool
            java.lang.String r5 = r4.getString(r5)
            r4.setToast(r2, r5)
            goto L_0x0175
        L_0x0116:
            jp.co.sony.reonpocket.view.TemperatureSurfaceView r5 = r4.mSmartModeIndicator
            if (r5 == 0) goto L_0x011d
            r5.setIsDisplayAnimation(r2)
        L_0x011d:
            jp.co.sony.reonpocket.view.TemperatureSurfaceView r5 = r4.mSmartModeIndicator
            if (r5 == 0) goto L_0x0124
            r5.setIsDisplayTarget(r2)
        L_0x0124:
            android.widget.FrameLayout r5 = r4.mScaleLayout
            if (r5 != 0) goto L_0x0129
            goto L_0x012c
        L_0x0129:
            r5.setVisibility(r2)
        L_0x012c:
            int r5 = jp.co.sony.reonpocket.R.string.mainview_content_smart_pause
            java.lang.String r5 = r4.getString(r5)
            r4.setToast(r2, r5)
            goto L_0x0175
        L_0x0136:
            jp.co.sony.reonpocket.view.TemperatureSurfaceView r5 = r4.mSmartModeIndicator
            if (r5 == 0) goto L_0x013d
            r5.setIsDisplayAnimation(r1)
        L_0x013d:
            jp.co.sony.reonpocket.view.TemperatureSurfaceView r5 = r4.mSmartModeIndicator
            if (r5 == 0) goto L_0x0144
            r5.setIsDisplayTarget(r1)
        L_0x0144:
            android.widget.FrameLayout r5 = r4.mScaleLayout
            if (r5 != 0) goto L_0x0149
            goto L_0x014c
        L_0x0149:
            r5.setVisibility(r2)
        L_0x014c:
            int r5 = jp.co.sony.reonpocket.R.string.mainview_content_smart_status_warm
            java.lang.String r5 = r4.getString(r5)
            r4.setToast(r2, r5)
            goto L_0x0175
        L_0x0156:
            jp.co.sony.reonpocket.view.TemperatureSurfaceView r5 = r4.mSmartModeIndicator
            if (r5 == 0) goto L_0x015d
            r5.setIsDisplayAnimation(r1)
        L_0x015d:
            jp.co.sony.reonpocket.view.TemperatureSurfaceView r5 = r4.mSmartModeIndicator
            if (r5 == 0) goto L_0x0164
            r5.setIsDisplayTarget(r1)
        L_0x0164:
            android.widget.FrameLayout r5 = r4.mScaleLayout
            if (r5 != 0) goto L_0x0169
            goto L_0x016c
        L_0x0169:
            r5.setVisibility(r2)
        L_0x016c:
            int r5 = jp.co.sony.reonpocket.R.string.mainview_content_smart_status_cool
            java.lang.String r5 = r4.getString(r5)
            r4.setToast(r2, r5)
        L_0x0175:
            r5 = r1
            goto L_0x0197
        L_0x0177:
            jp.co.sony.reonpocket.view.TemperatureSurfaceView r5 = r4.mSmartModeIndicator
            if (r5 == 0) goto L_0x017e
            r5.setIsDisplayAnimation(r2)
        L_0x017e:
            jp.co.sony.reonpocket.view.TemperatureSurfaceView r5 = r4.mSmartModeIndicator
            if (r5 == 0) goto L_0x0185
            r5.setIsDisplayTarget(r2)
        L_0x0185:
            android.widget.FrameLayout r5 = r4.mScaleLayout
            if (r5 != 0) goto L_0x018a
            goto L_0x018d
        L_0x018a:
            r5.setVisibility(r0)
        L_0x018d:
            int r5 = jp.co.sony.reonpocket.R.string.mainview_content_smart_status_cool
            java.lang.String r5 = r4.getString(r5)
            r4.setToast(r1, r5)
        L_0x0196:
            r5 = r2
        L_0x0197:
            r4.mIsOn = r5
            androidx.appcompat.widget.AppCompatButton r0 = r4.mOffButton
            if (r0 != 0) goto L_0x019e
            goto L_0x01a1
        L_0x019e:
            r0.setEnabled(r5)
        L_0x01a1:
            boolean r5 = r4.mIsOn
            if (r5 == 0) goto L_0x01af
            androidx.constraintlayout.widget.ConstraintLayout r5 = r4.mOffView
            if (r5 != 0) goto L_0x01aa
            goto L_0x01af
        L_0x01aa:
            r0 = 8
            r5.setVisibility(r0)
        L_0x01af:
            jp.co.sony.reonpocket.view.TemperatureSurfaceView r5 = r4.mSmartModeIndicator
            if (r5 == 0) goto L_0x01b9
            boolean r0 = r4.mIsOn
            r0 = r0 ^ r1
            r5.setOff(r0)
        L_0x01b9:
            jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode r5 = r4.mCurrentCoolHeatType
            jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode r0 = jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode.COOL
            if (r5 != r0) goto L_0x01c0
            goto L_0x01c1
        L_0x01c0:
            r1 = r2
        L_0x01c1:
            jp.co.sony.reonpocket.constant.SmartModePreference r5 = r4.mCoolPreference
            r0 = 0
            r4.updateTargetTemperatureView(r1, r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.main.view.MainSmartModeFragment.initUi(android.view.View):void");
    }

    /* access modifiers changed from: private */
    public static final void initUi$lambda$0(MainSmartModeFragment mainSmartModeFragment, View view) {
        Intrinsics.checkNotNullParameter(mainSmartModeFragment, "this$0");
        Intrinsics.checkNotNull(view);
        mainSmartModeFragment.showOptionMenuPopup(view);
    }

    /* access modifiers changed from: private */
    public static final void initUi$lambda$1(MainSmartModeFragment mainSmartModeFragment, View view) {
        Intrinsics.checkNotNullParameter(mainSmartModeFragment, "this$0");
        MainSmartPresenter mainSmartPresenter = mainSmartModeFragment.mOutput;
        if (mainSmartPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainSmartPresenter = null;
        }
        mainSmartPresenter.setSmartOff();
    }

    /* access modifiers changed from: private */
    public static final void initUi$lambda$2(MainSmartModeFragment mainSmartModeFragment, View view) {
        Intrinsics.checkNotNullParameter(mainSmartModeFragment, "this$0");
        mainSmartModeFragment.onButtonTapped();
    }

    private final void showOptionMenuPopup(View view) {
        PopupMenu popupMenu = new PopupMenu(requireContext(), view);
        popupMenu.inflate(R.menu.menu_smart_option);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    private final void setToast(boolean z, String str) {
        if (z) {
            LinearLayout linearLayout = this.mBottomToast;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            LinearLayout linearLayout2 = this.mTopToast;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
        } else if (this.mCurrentCoolHeatType == CurrentCoolHeatTypeCode.COOL) {
            LinearLayout linearLayout3 = this.mBottomToast;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
            LinearLayout linearLayout4 = this.mTopToast;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(0);
            }
            TextView textView = this.mTopToastMsg;
            if (textView != null) {
                textView.setText(str);
            }
        } else {
            LinearLayout linearLayout5 = this.mTopToast;
            if (linearLayout5 != null) {
                linearLayout5.setVisibility(8);
            }
            LinearLayout linearLayout6 = this.mBottomToast;
            if (linearLayout6 != null) {
                linearLayout6.setVisibility(0);
            }
            TextView textView2 = this.mBottomToastMsg;
            if (textView2 != null) {
                textView2.setText(str);
            }
        }
    }

    public void updateTargetTemperatureView(boolean z, SmartModePreference smartModePreference, Double d) {
        int i;
        int i2 = 0;
        boolean z2 = this.mState == CurrentCoolHeatTypeCode.WEAKCOOL || this.mState == CurrentCoolHeatTypeCode.WEAKHEAT;
        DeviceModeEntity.SmartWarmModeCombine smartWarmModeCombine = null;
        if (z) {
            Enum[] values = DeviceModeEntity.SmartCoolModeCombine.values();
            int length = values.length;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                Enum enumR = values[i2];
                if (((DeviceModeEntity.SmartCoolModeCombine) enumR).getPref() == smartModePreference) {
                    smartWarmModeCombine = enumR;
                    break;
                }
                i2++;
            }
            DeviceModeEntity.SmartCoolModeCombine smartCoolModeCombine = (DeviceModeEntity.SmartCoolModeCombine) smartWarmModeCombine;
            if (smartCoolModeCombine != null) {
                i = smartCoolModeCombine.getTemperature();
            } else {
                i = DeviceModeEntity.SmartCoolModeCombine.LEVEL1.getTemperature();
            }
        } else {
            DeviceModeEntity.SmartWarmModeCombine[] values2 = DeviceModeEntity.SmartWarmModeCombine.values();
            int length2 = values2.length;
            while (true) {
                if (i2 >= length2) {
                    break;
                }
                DeviceModeEntity.SmartWarmModeCombine smartWarmModeCombine2 = values2[i2];
                if (smartWarmModeCombine2.getPref() == smartModePreference) {
                    smartWarmModeCombine = smartWarmModeCombine2;
                    break;
                }
                i2++;
            }
            DeviceModeEntity.SmartWarmModeCombine smartWarmModeCombine3 = smartWarmModeCombine;
            if (smartWarmModeCombine3 != null) {
                i = smartWarmModeCombine3.getTemperature();
            } else {
                i = DeviceModeEntity.SmartWarmModeCombine.LEVEL1.getTemperature();
            }
        }
        if (d != null) {
            float doubleValue = (float) d.doubleValue();
            TemperatureSurfaceView temperatureSurfaceView = this.mSmartModeIndicator;
            if (temperatureSurfaceView != null) {
                temperatureSurfaceView.setTargetTemperature(((float) i) / 100.0f, doubleValue, z2);
            }
        }
    }

    private final void onButtonTapped() {
        MainSmartPresenter mainSmartPresenter = this.mOutput;
        if (mainSmartPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainSmartPresenter = null;
        }
        mainSmartPresenter.setSmartMode(true, this.mCurrentCoolPreference, this.mCurrentWarmPreference, ((double) this.mCurrentCoolWriteTemperature) / 100.0d, ((double) this.mCurrentWarmWriteTemperature) / 100.0d, DeviceModeEntityKt.SMART_MODE_INVALID_SWITCH_THRESHOLD, DeviceModeEntityKt.SMART_MODE_INVALID_SWITCH_THRESHOLD);
    }

    public final void doSmartSetting(boolean z, SmartModePreference smartModePreference, SmartModePreference smartModePreference2, double d, double d2) {
        MainSmartModeFragment mainSmartModeFragment;
        SmartModePreference smartModePreference3 = smartModePreference;
        SmartModePreference smartModePreference4 = smartModePreference2;
        Intrinsics.checkNotNullParameter(smartModePreference, "coolSmartModePreference");
        Intrinsics.checkNotNullParameter(smartModePreference4, "warmSmartModePreference");
        DeviceModeEntity.SmartCoolModeCombine forPref = DeviceModeEntity.SmartCoolModeCombine.Companion.forPref(smartModePreference);
        double d3 = -32768.0d;
        double temperature = forPref != null ? ((double) forPref.getTemperature()) / 100.0d : -32768.0d;
        DeviceModeEntity.SmartWarmModeCombine forPref2 = DeviceModeEntity.SmartWarmModeCombine.Companion.forPref(smartModePreference4);
        if (forPref2 != null) {
            mainSmartModeFragment = this;
            d3 = ((double) forPref2.getTemperature()) / 100.0d;
        } else {
            mainSmartModeFragment = this;
        }
        MainSmartPresenter mainSmartPresenter = mainSmartModeFragment.mOutput;
        if (mainSmartPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainSmartPresenter = null;
        }
        double d4 = (double) 2;
        mainSmartPresenter.setSmartMode(z, smartModePreference, smartModePreference2, temperature, d3, (int) (d * d4), (int) (d4 * d2));
    }

    public final void doSmartSetting(boolean z, double d, double d2) {
        doSmartSetting(z, this.mCurrentCoolPreference, this.mCurrentWarmPreference, d, d2);
    }

    public final void doSmartSetting(SmartModePreference smartModePreference, SmartModePreference smartModePreference2, double d, double d2) {
        Intrinsics.checkNotNullParameter(smartModePreference, "coolPref");
        Intrinsics.checkNotNullParameter(smartModePreference2, "warmPref");
        doSmartSetting(this.mIsOn, smartModePreference, smartModePreference2, d, d2);
    }

    public final void doSmartSetting(double d, double d2) {
        this.mCurrentCoolTempSwitchThreshold = d;
        this.mCurrentWarmTempSwitchThreshold = d2;
        MainSmartPresenter mainSmartPresenter = this.mOutput;
        if (mainSmartPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            mainSmartPresenter = null;
        }
        double d3 = (double) 2;
        mainSmartPresenter.setSmartMode(this.mIsOn, (int) (this.mCurrentCoolTempSwitchThreshold * d3), (int) (this.mCurrentWarmTempSwitchThreshold * d3));
    }

    public final boolean isActive() {
        return this.mIsOn;
    }

    public final boolean isSmartMixTypeCool() {
        return this.mCurrentCoolHeatType == CurrentCoolHeatTypeCode.COOL;
    }

    public final void updateNoReceiving(boolean z) {
        if (getContext() == null || !isAttachingActivity()) {
            DebugLogUtil.INSTANCE.e("fun updateNoReceiving error: context or activity is null");
        } else if (this.mIsTagInfoNoReceiving != z) {
            this.mIsTagInfoNoReceiving = z;
            showCoolHeatState(this.currentTemperatureEntity, z, this.mIsNoAmbientTemp);
        }
    }

    public final void updateNoAmbientTemp(boolean z) {
        if (this.mIsNoAmbientTemp != z) {
            this.mIsNoAmbientTemp = z;
            showCoolHeatState(this.currentTemperatureEntity, this.mIsTagInfoNoReceiving, z);
        }
    }

    public void updateStates(boolean z, CurrentCoolHeatTypeCode currentCoolHeatTypeCode, double d, double d2, SmartModePreference smartModePreference, SmartModePreference smartModePreference2) {
        Intrinsics.checkNotNullParameter(currentCoolHeatTypeCode, "currentCoolHeatTypeCode");
        Intrinsics.checkNotNullParameter(smartModePreference, "coolPreference");
        Intrinsics.checkNotNullParameter(smartModePreference2, "heatPreference");
        this.mIsOn = z;
        this.mCurrentCoolHeatType = currentCoolHeatTypeCode;
        this.mCurrentCoolTempSwitchThreshold = d;
        this.mCurrentWarmTempSwitchThreshold = d2;
        this.mCurrentCoolPreference = smartModePreference;
        this.mCurrentWarmPreference = smartModePreference2;
        DeviceModeEntity.SmartCoolModeCombine forPref = DeviceModeEntity.SmartCoolModeCombine.Companion.forPref(smartModePreference);
        int i = DeviceModeEntityKt.SMART_MODE_OFF_TEMPERATURE;
        this.mCurrentCoolWriteTemperature = forPref != null ? forPref.getTemperature() : -32768;
        DeviceModeEntity.SmartWarmModeCombine forPref2 = DeviceModeEntity.SmartWarmModeCombine.Companion.forPref(smartModePreference2);
        if (forPref2 != null) {
            i = forPref2.getTemperature();
        }
        this.mCurrentWarmWriteTemperature = i;
    }

    public void updateViewVisibility(DeviceModeEntity.Temperature temperature) {
        Intrinsics.checkNotNullParameter(temperature, "aTemperatureEntity");
        AppCompatButton appCompatButton = this.mOffButton;
        if (appCompatButton != null) {
            appCompatButton.setEnabled(this.mIsOn);
        }
        TemperatureSurfaceView temperatureSurfaceView = this.mSmartModeIndicator;
        if (temperatureSurfaceView != null) {
            temperatureSurfaceView.setOff(!this.mIsOn);
        }
        FrameLayout frameLayout = this.mScaleLayout;
        int i = 0;
        if (frameLayout != null) {
            frameLayout.setVisibility(this.mIsOn ? 0 : 4);
        }
        ConstraintLayout constraintLayout = this.mOffView;
        if (constraintLayout != null) {
            if (this.mIsOn) {
                i = 8;
            }
            constraintLayout.setVisibility(i);
        }
    }

    public void updateSmartTecTemp(float f) {
        TemperatureSurfaceView temperatureSurfaceView = this.mSmartModeIndicator;
        if (temperatureSurfaceView != null) {
            temperatureSurfaceView.setTecTemperature(f);
        }
    }

    public void showCoolHeatState(DeviceModeEntity.Temperature temperature, boolean z, boolean z2) {
        CurrentCoolHeatTypeCode tempCurrentCoolHeatType;
        MainSmartPresenter mainSmartPresenter = null;
        if (!this.mIsOn) {
            setToast(true, (String) null);
            return;
        }
        MainSmartPresenter mainSmartPresenter2 = this.mOutput;
        if (mainSmartPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOutput");
        } else {
            mainSmartPresenter = mainSmartPresenter2;
        }
        boolean isTagRegistered = mainSmartPresenter.isTagRegistered();
        if (isTagRegistered) {
            if (z || this.mIsTagInfoNoReceiving) {
                TemperatureSurfaceView temperatureSurfaceView = this.mSmartModeIndicator;
                if (temperatureSurfaceView != null) {
                    temperatureSurfaceView.setIsDisplayAnimation(true);
                }
                TemperatureSurfaceView temperatureSurfaceView2 = this.mSmartModeIndicator;
                if (temperatureSurfaceView2 != null) {
                    temperatureSurfaceView2.setIsDisplayTarget(true);
                }
                setToast(false, getString(R.string.mainview_content_smart_invalid_tag));
                return;
            } else if (z2 || this.mIsNoAmbientTemp) {
                setToast(false, getString(R.string.mainview_content_smart_bad_condition_tag));
                return;
            }
        }
        this.currentTemperatureEntity = temperature;
        if (temperature != null && (tempCurrentCoolHeatType = temperature.getTempCurrentCoolHeatType()) != null) {
            this.mState = tempCurrentCoolHeatType;
            if (tempCurrentCoolHeatType == CurrentCoolHeatTypeCode.WEAKCOOL && temperature.getSwitchingTrigger1() == SwitchingTrigger1.COOL_HEAT_CHANGE_TRIGGER_1) {
                setToast(false, getString(R.string.mainview_content_smart_status_weakcool_by_innerclothes_status));
            } else if (this.mState == CurrentCoolHeatTypeCode.WEAKCOOL && temperature.getSwitchingTrigger2() == SwitchingTrigger2.COOL_HEAT_CHANGE_TRIGGER_2) {
                setToast(false, getString(R.string.mainview_content_smart_status_weakcool_by_body_surface_status));
            } else if (this.mState == CurrentCoolHeatTypeCode.COOL && temperature.getSwitchingTrigger1() == SwitchingTrigger1.COOL_HEAT_CHANGE_TRIGGER_1) {
                setToast(false, getString(R.string.mainview_content_smart_status_cool_by_innerclothes_status));
            } else if (this.mState == CurrentCoolHeatTypeCode.COOL && temperature.getSwitchingTrigger2() == SwitchingTrigger2.COOL_HEAT_CHANGE_TRIGGER_2) {
                setToast(false, getString(R.string.mainview_content_smart_status_cool_by_body_surface_status));
            } else if ((!isTagRegistered || (isTagRegistered && !z && !this.mIsTagInfoNoReceiving)) && temperature.getTargetTempControlStatus() == TargetTempControlStatus.TARGET_TEMP_DOWN && this.mState == CurrentCoolHeatTypeCode.COOL && (temperature.getTargetTempControlFactorEnvironment() == TargetTempControlFactorEnvironment.VALID || temperature.getTargetTempControlFactorALS() == TargetTempControlFactorALS.VALID)) {
                TemperatureSurfaceView temperatureSurfaceView3 = this.mSmartModeIndicator;
                if (temperatureSurfaceView3 != null) {
                    temperatureSurfaceView3.setIsDisplayAnimation(true);
                }
                TemperatureSurfaceView temperatureSurfaceView4 = this.mSmartModeIndicator;
                if (temperatureSurfaceView4 != null) {
                    temperatureSurfaceView4.setIsDisplayTarget(true);
                }
                setToast(false, getString(R.string.mainview_content_smart_status_cool_boost_by_tag_status));
            } else if (temperature.getTargetTempControlStatus() == TargetTempControlStatus.TARGET_TEMP_DOWN && this.mState == CurrentCoolHeatTypeCode.COOL && temperature.getTargetTempControlFactorClothesTemp() == TargetTempControlFactorClothesTemp.VALID) {
                TemperatureSurfaceView temperatureSurfaceView5 = this.mSmartModeIndicator;
                if (temperatureSurfaceView5 != null) {
                    temperatureSurfaceView5.setIsDisplayAnimation(true);
                }
                TemperatureSurfaceView temperatureSurfaceView6 = this.mSmartModeIndicator;
                if (temperatureSurfaceView6 != null) {
                    temperatureSurfaceView6.setIsDisplayTarget(true);
                }
                setToast(false, getString(R.string.mainview_content_smart_status_cool_boost_by_innerclothes_status));
            } else {
                switch (WhenMappings.$EnumSwitchMapping$0[this.mState.ordinal()]) {
                    case 1:
                        TemperatureSurfaceView temperatureSurfaceView7 = this.mSmartModeIndicator;
                        if (temperatureSurfaceView7 != null) {
                            temperatureSurfaceView7.setIsDisplayAnimation(false);
                        }
                        TemperatureSurfaceView temperatureSurfaceView8 = this.mSmartModeIndicator;
                        if (temperatureSurfaceView8 != null) {
                            temperatureSurfaceView8.setIsDisplayTarget(false);
                        }
                        setToast(true, getString(R.string.mainview_content_smart_status_cool));
                        return;
                    case 2:
                        TemperatureSurfaceView temperatureSurfaceView9 = this.mSmartModeIndicator;
                        if (temperatureSurfaceView9 != null) {
                            temperatureSurfaceView9.setIsDisplayAnimation(true);
                        }
                        TemperatureSurfaceView temperatureSurfaceView10 = this.mSmartModeIndicator;
                        if (temperatureSurfaceView10 != null) {
                            temperatureSurfaceView10.setIsDisplayTarget(true);
                        }
                        setToast(false, getString(R.string.mainview_content_smart_status_cool));
                        return;
                    case 3:
                        TemperatureSurfaceView temperatureSurfaceView11 = this.mSmartModeIndicator;
                        if (temperatureSurfaceView11 != null) {
                            temperatureSurfaceView11.setIsDisplayAnimation(true);
                        }
                        TemperatureSurfaceView temperatureSurfaceView12 = this.mSmartModeIndicator;
                        if (temperatureSurfaceView12 != null) {
                            temperatureSurfaceView12.setIsDisplayTarget(true);
                        }
                        setToast(false, getString(R.string.mainview_content_smart_status_warm));
                        return;
                    case 4:
                        TemperatureSurfaceView temperatureSurfaceView13 = this.mSmartModeIndicator;
                        if (temperatureSurfaceView13 != null) {
                            temperatureSurfaceView13.setIsDisplayAnimation(false);
                        }
                        TemperatureSurfaceView temperatureSurfaceView14 = this.mSmartModeIndicator;
                        if (temperatureSurfaceView14 != null) {
                            temperatureSurfaceView14.setIsDisplayTarget(false);
                        }
                        setToast(false, getString(R.string.mainview_content_smart_pause));
                        return;
                    case 5:
                        TemperatureSurfaceView temperatureSurfaceView15 = this.mSmartModeIndicator;
                        if (temperatureSurfaceView15 != null) {
                            temperatureSurfaceView15.setIsDisplayAnimation(true);
                        }
                        TemperatureSurfaceView temperatureSurfaceView16 = this.mSmartModeIndicator;
                        if (temperatureSurfaceView16 != null) {
                            temperatureSurfaceView16.setIsDisplayTarget(true);
                        }
                        setToast(false, getString(R.string.mainview_content_smart_status_weakcool));
                        return;
                    case 6:
                        TemperatureSurfaceView temperatureSurfaceView17 = this.mSmartModeIndicator;
                        if (temperatureSurfaceView17 != null) {
                            temperatureSurfaceView17.setIsDisplayAnimation(true);
                        }
                        TemperatureSurfaceView temperatureSurfaceView18 = this.mSmartModeIndicator;
                        if (temperatureSurfaceView18 != null) {
                            temperatureSurfaceView18.setIsDisplayTarget(true);
                        }
                        setToast(false, getString(R.string.mainview_content_smart_status_weakwarm));
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void updateSmartTecRate(float f) {
        TemperatureSurfaceView temperatureSurfaceView = this.mSmartModeIndicator;
        if (temperatureSurfaceView != null) {
            temperatureSurfaceView.setTecRate(f);
        }
    }
}
