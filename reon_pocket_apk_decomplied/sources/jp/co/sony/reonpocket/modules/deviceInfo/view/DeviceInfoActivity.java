package jp.co.sony.reonpocket.modules.deviceInfo.view;

import android.content.Context;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.constant.CoolHeatTypeCode;
import jp.co.sony.reonpocket.constant.DeviceInfoConstants;
import jp.co.sony.reonpocket.constant.DeviceModeActionCode;
import jp.co.sony.reonpocket.constant.MyCoolHiBoostTempStep;
import jp.co.sony.reonpocket.constant.MyWarmTempStep;
import jp.co.sony.reonpocket.constant.ReonProductType;
import jp.co.sony.reonpocket.data.interactor.DeviceInfoInteractor;
import jp.co.sony.reonpocket.databinding.ActivityDeviceInfoBinding;
import jp.co.sony.reonpocket.databinding.ViewDeviceErrorInfoBinding;
import jp.co.sony.reonpocket.databinding.ViewDeviceInfoBinding;
import jp.co.sony.reonpocket.databinding.ViewHelpGuideBinding;
import jp.co.sony.reonpocket.modules.base.view.BaseActivity;
import jp.co.sony.reonpocket.modules.base.view.BaseViewOutput;
import jp.co.sony.reonpocket.modules.deviceInfo.presenter.DeviceInfoPresenter;
import jp.co.sony.reonpocket.modules.main.router.MainRouterKt;
import jp.co.sony.reonpocket.modules.main.view.MainActivity;
import jp.co.sony.reonpocket.util.RemoteConfigUtil;
import jp.co.sony.reonpocket.view.CustomFontTextView;
import jp.co.sony.reonpocket.view.DeviceTemperatureView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001DB\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u001aH\u0002J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001eH\u0002J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020#H\u0002J\b\u0010(\u001a\u00020\u0011H\u0014J\u0012\u0010)\u001a\u00020#2\b\u0010*\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010+\u001a\u00020#2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\u0018\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0011H\u0002J \u00102\u001a\u00020#2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0002J\u0010\u00109\u001a\u00020#2\u0006\u0010:\u001a\u00020\u001aH\u0002J\u0018\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020=H\u0002J \u0010?\u001a\u00020#2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020=2\u0006\u0010$\u001a\u00020\u001eH\u0002J\u0010\u0010@\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001eH\u0002J\u0018\u0010A\u001a\u00020#2\u0006\u0010B\u001a\u00020=2\u0006\u0010C\u001a\u00020=H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Ljp/co/sony/reonpocket/modules/deviceInfo/view/DeviceInfoActivity;", "Ljp/co/sony/reonpocket/modules/base/view/BaseActivity;", "Ljp/co/sony/reonpocket/modules/deviceInfo/view/DeviceInfoViewInput;", "()V", "binding", "Ljp/co/sony/reonpocket/databinding/ActivityDeviceInfoBinding;", "deviceErrorInfoBinding", "Ljp/co/sony/reonpocket/databinding/ViewDeviceErrorInfoBinding;", "deviceInfoBinding", "Ljp/co/sony/reonpocket/databinding/ViewDeviceInfoBinding;", "mConfirmReonPosition", "Landroid/view/View;", "mCurrentModePattern", "Ljp/co/sony/reonpocket/modules/deviceInfo/view/ModePattern;", "mDeviceInfoView", "Ljp/co/sony/reonpocket/view/DeviceTemperatureView;", "mIsActiveMode", "", "mIsSmartMixTypeCool", "mOpenYourNeck", "mOutput", "Ljp/co/sony/reonpocket/modules/deviceInfo/view/DeviceInfoActivity$DeviceInfoViewOutput;", "mStopStrongCool", "mTryWaveMode", "createContentsView", "titleId", "", "detailId", "imageId", "getHelpContentsPattern", "Ljp/co/sony/reonpocket/modules/deviceInfo/view/HelpContentsPattern;", "deviceMode", "Ljp/co/sony/reonpocket/constant/DeviceModeActionCode;", "getMainViewInfoCode", "initHelpContents", "", "helpPattern", "initPresenter", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewOutput;", "initView", "isToolbar", "onClick", "v", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setIsActiveMode", "coolHeatTypeCode", "Ljp/co/sony/reonpocket/constant/CoolHeatTypeCode;", "isSmartActive", "setModePattern", "currentPage", "Ljp/co/sony/reonpocket/modules/main/view/MainActivity$Companion$Page;", "coolStep", "Ljp/co/sony/reonpocket/constant/MyCoolHiBoostTempStep;", "heatStep", "Ljp/co/sony/reonpocket/constant/MyWarmTempStep;", "setUpAlertView", "code", "setUpDeviceInfoView", "temp", "", "finTemp", "setUpHelpView", "setUpTitleView", "updateDeviceTemp", "aTemp", "aFinTemp", "DeviceInfoViewOutput", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DeviceInfoActivity.kt */
public final class DeviceInfoActivity extends BaseActivity implements DeviceInfoViewInput {
    public static final int $stable = 8;
    private ActivityDeviceInfoBinding binding;
    private ViewDeviceErrorInfoBinding deviceErrorInfoBinding;
    private ViewDeviceInfoBinding deviceInfoBinding;
    private View mConfirmReonPosition;
    private ModePattern mCurrentModePattern = ModePattern.OFF;
    private DeviceTemperatureView mDeviceInfoView;
    private boolean mIsActiveMode;
    private boolean mIsSmartMixTypeCool;
    private View mOpenYourNeck;
    private DeviceInfoViewOutput mOutput;
    private View mStopStrongCool;
    private View mTryWaveMode;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Ljp/co/sony/reonpocket/modules/deviceInfo/view/DeviceInfoActivity$DeviceInfoViewOutput;", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewOutput;", "getDeviceModelName", "", "transitToSupportPage", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DeviceInfoActivity.kt */
    public interface DeviceInfoViewOutput extends BaseViewOutput {
        String getDeviceModelName();

        void transitToSupportPage();
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DeviceInfoActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;

        /* JADX WARNING: Can't wrap try/catch for region: R(53:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|(2:15|16)|17|(2:19|20)|21|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|47|48|49|50|51|52|(2:53|54)|55|57|58|59|60|61|62|(2:63|64)|65|67) */
        /* JADX WARNING: Can't wrap try/catch for region: R(55:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|(2:15|16)|17|19|20|21|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|47|48|49|50|51|52|(2:53|54)|55|57|58|59|60|61|62|63|64|65|67) */
        /* JADX WARNING: Can't wrap try/catch for region: R(56:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|15|16|17|19|20|21|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|47|48|49|50|51|52|(2:53|54)|55|57|58|59|60|61|62|63|64|65|67) */
        /* JADX WARNING: Can't wrap try/catch for region: R(58:0|(2:1|2)|3|5|6|7|9|10|(2:11|12)|13|15|16|17|19|20|21|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|47|48|49|50|51|52|53|54|55|57|58|59|60|61|62|63|64|65|67) */
        /* JADX WARNING: Can't wrap try/catch for region: R(59:0|(2:1|2)|3|5|6|7|9|10|11|12|13|15|16|17|19|20|21|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|47|48|49|50|51|52|53|54|55|57|58|59|60|61|62|63|64|65|67) */
        /* JADX WARNING: Can't wrap try/catch for region: R(60:0|1|2|3|5|6|7|9|10|11|12|13|15|16|17|19|20|21|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|47|48|49|50|51|52|53|54|55|57|58|59|60|61|62|63|64|65|67) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0055 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x005d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0065 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0076 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x007f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0088 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00a6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00c1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00c9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00d1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00ea */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00f2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x00fa */
        static {
            /*
                jp.co.sony.reonpocket.constant.ReonProductType[] r0 = jp.co.sony.reonpocket.constant.ReonProductType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                jp.co.sony.reonpocket.constant.ReonProductType r2 = jp.co.sony.reonpocket.constant.ReonProductType.PRO     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                jp.co.sony.reonpocket.constant.ReonProductType r3 = jp.co.sony.reonpocket.constant.ReonProductType.ORIGINAL     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                jp.co.sony.reonpocket.modules.deviceInfo.view.HelpContentsPattern[] r0 = jp.co.sony.reonpocket.modules.deviceInfo.view.HelpContentsPattern.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.modules.deviceInfo.view.HelpContentsPattern r3 = jp.co.sony.reonpocket.modules.deviceInfo.view.HelpContentsPattern.PATTERN1     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                jp.co.sony.reonpocket.modules.deviceInfo.view.HelpContentsPattern r3 = jp.co.sony.reonpocket.modules.deviceInfo.view.HelpContentsPattern.PATTERN2     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                r3 = 3
                jp.co.sony.reonpocket.modules.deviceInfo.view.HelpContentsPattern r4 = jp.co.sony.reonpocket.modules.deviceInfo.view.HelpContentsPattern.PATTERN3     // Catch:{ NoSuchFieldError -> 0x003b }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                r4 = 4
                jp.co.sony.reonpocket.modules.deviceInfo.view.HelpContentsPattern r5 = jp.co.sony.reonpocket.modules.deviceInfo.view.HelpContentsPattern.PATTERN4     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                $EnumSwitchMapping$1 = r0
                jp.co.sony.reonpocket.constant.DeviceInfoConstants[] r0 = jp.co.sony.reonpocket.constant.DeviceInfoConstants.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.DeviceInfoConstants r5 = jp.co.sony.reonpocket.constant.DeviceInfoConstants.NORMAL_MOVEMENT_WARM     // Catch:{ NoSuchFieldError -> 0x0055 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0055 }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0055 }
            L_0x0055:
                jp.co.sony.reonpocket.constant.DeviceInfoConstants r5 = jp.co.sony.reonpocket.constant.DeviceInfoConstants.NORMAL_MOVEMENT_COOL     // Catch:{ NoSuchFieldError -> 0x005d }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x005d }
                r0[r5] = r2     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                jp.co.sony.reonpocket.constant.DeviceInfoConstants r5 = jp.co.sony.reonpocket.constant.DeviceInfoConstants.NORMAL_MOVEMENT_HIGH_TEMP     // Catch:{ NoSuchFieldError -> 0x0065 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0065 }
                r0[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0065 }
            L_0x0065:
                jp.co.sony.reonpocket.constant.DeviceInfoConstants r5 = jp.co.sony.reonpocket.constant.DeviceInfoConstants.NORMAL_MOVEMENT_LOW_BATTERY     // Catch:{ NoSuchFieldError -> 0x006d }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                jp.co.sony.reonpocket.constant.DeviceInfoConstants r5 = jp.co.sony.reonpocket.constant.DeviceInfoConstants.EXCEPTION_CANNOT_CHARGING     // Catch:{ NoSuchFieldError -> 0x0076 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0076 }
                r6 = 5
                r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0076 }
            L_0x0076:
                jp.co.sony.reonpocket.constant.DeviceInfoConstants r5 = jp.co.sony.reonpocket.constant.DeviceInfoConstants.EXCEPTION_INTERNAL_HIGH_TEMP     // Catch:{ NoSuchFieldError -> 0x007f }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x007f }
                r6 = 6
                r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x007f }
            L_0x007f:
                jp.co.sony.reonpocket.constant.DeviceInfoConstants r5 = jp.co.sony.reonpocket.constant.DeviceInfoConstants.EXCEPTION_INTERNAL_LOW_TEMP     // Catch:{ NoSuchFieldError -> 0x0088 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0088 }
                r6 = 7
                r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0088 }
            L_0x0088:
                jp.co.sony.reonpocket.constant.DeviceInfoConstants r5 = jp.co.sony.reonpocket.constant.DeviceInfoConstants.EXCEPTION_FAN_STOP     // Catch:{ NoSuchFieldError -> 0x0092 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0092 }
                r6 = 8
                r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0092 }
            L_0x0092:
                jp.co.sony.reonpocket.constant.DeviceInfoConstants r5 = jp.co.sony.reonpocket.constant.DeviceInfoConstants.EXCEPTION_DEVICE_STOP     // Catch:{ NoSuchFieldError -> 0x009c }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r6 = 9
                r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                jp.co.sony.reonpocket.constant.DeviceInfoConstants r5 = jp.co.sony.reonpocket.constant.DeviceInfoConstants.EXCEPTION_CANNOT_CHARGING_CAUSE_HIGH_TEMP     // Catch:{ NoSuchFieldError -> 0x00a6 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a6 }
                r6 = 10
                r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x00a6 }
            L_0x00a6:
                jp.co.sony.reonpocket.constant.DeviceInfoConstants r5 = jp.co.sony.reonpocket.constant.DeviceInfoConstants.EXCEPTION_CANNOT_CHARGING_UNKNOWN     // Catch:{ NoSuchFieldError -> 0x00b0 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b0 }
                r6 = 11
                r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x00b0 }
            L_0x00b0:
                $EnumSwitchMapping$2 = r0
                jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page[] r0 = jp.co.sony.reonpocket.modules.main.view.MainActivity.Companion.Page.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page r5 = jp.co.sony.reonpocket.modules.main.view.MainActivity.Companion.Page.COOL     // Catch:{ NoSuchFieldError -> 0x00c1 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c1 }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x00c1 }
            L_0x00c1:
                jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page r5 = jp.co.sony.reonpocket.modules.main.view.MainActivity.Companion.Page.SMARTCOOL     // Catch:{ NoSuchFieldError -> 0x00c9 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c9 }
                r0[r5] = r2     // Catch:{ NoSuchFieldError -> 0x00c9 }
            L_0x00c9:
                jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page r5 = jp.co.sony.reonpocket.modules.main.view.MainActivity.Companion.Page.SMART     // Catch:{ NoSuchFieldError -> 0x00d1 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d1 }
                r0[r5] = r3     // Catch:{ NoSuchFieldError -> 0x00d1 }
            L_0x00d1:
                jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page r5 = jp.co.sony.reonpocket.modules.main.view.MainActivity.Companion.Page.WARM     // Catch:{ NoSuchFieldError -> 0x00d9 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d9 }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x00d9 }
            L_0x00d9:
                $EnumSwitchMapping$3 = r0
                jp.co.sony.reonpocket.modules.deviceInfo.view.ModePattern[] r0 = jp.co.sony.reonpocket.modules.deviceInfo.view.ModePattern.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.modules.deviceInfo.view.ModePattern r5 = jp.co.sony.reonpocket.modules.deviceInfo.view.ModePattern.COOL     // Catch:{ NoSuchFieldError -> 0x00ea }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ea }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x00ea }
            L_0x00ea:
                jp.co.sony.reonpocket.modules.deviceInfo.view.ModePattern r1 = jp.co.sony.reonpocket.modules.deviceInfo.view.ModePattern.WARM     // Catch:{ NoSuchFieldError -> 0x00f2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f2 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f2 }
            L_0x00f2:
                jp.co.sony.reonpocket.modules.deviceInfo.view.ModePattern r1 = jp.co.sony.reonpocket.modules.deviceInfo.view.ModePattern.COOLANDWARM     // Catch:{ NoSuchFieldError -> 0x00fa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fa }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00fa }
            L_0x00fa:
                jp.co.sony.reonpocket.modules.deviceInfo.view.ModePattern r1 = jp.co.sony.reonpocket.modules.deviceInfo.view.ModePattern.OFF     // Catch:{ NoSuchFieldError -> 0x0102 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0102 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0102 }
            L_0x0102:
                $EnumSwitchMapping$4 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.deviceInfo.view.DeviceInfoActivity.WhenMappings.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public boolean isToolbar() {
        return false;
    }

    public BaseViewOutput initPresenter() {
        DeviceInfoViewOutput deviceInfoPresenter = new DeviceInfoPresenter(this, this);
        this.mOutput = deviceInfoPresenter;
        Intrinsics.checkNotNull(deviceInfoPresenter, "null cannot be cast to non-null type jp.co.sony.reonpocket.modules.deviceInfo.presenter.DeviceInfoPresenter");
        return (DeviceInfoPresenter) deviceInfoPresenter;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Transition inflateTransition = TransitionInflater.from(this).inflateTransition(R.transition.bottom_top_transition);
        Window window = getWindow();
        Intrinsics.checkNotNull(inflateTransition);
        window.setEnterTransition(inflateTransition);
        ActivityDeviceInfoBinding inflate = ActivityDeviceInfoBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView((View) inflate.getRoot());
        initView();
    }

    private final void initView() {
        ActivityDeviceInfoBinding activityDeviceInfoBinding;
        Object obj;
        MyCoolHiBoostTempStep myCoolHiBoostTempStep;
        MyWarmTempStep myWarmTempStep;
        MainActivity.Companion.Page page;
        DeviceModeActionCode deviceModeActionCode;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            float f = extras.getFloat(MainRouterKt.MAIN_VIEW_TEMPERATURE, 0.0f);
            float f2 = extras.getFloat(MainRouterKt.MAIN_VIEW_FAN_TEMPERATURE, 0.0f);
            Iterator it = CoolHeatTypeCode.getEntries().iterator();
            while (true) {
                activityDeviceInfoBinding = null;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((CoolHeatTypeCode) obj).getCode() == extras.getInt(MainRouterKt.MAIN_VIEW_COOL_HEAT_TYPE)) {
                    break;
                }
            }
            CoolHeatTypeCode coolHeatTypeCode = (CoolHeatTypeCode) obj;
            if (coolHeatTypeCode == null) {
                coolHeatTypeCode = CoolHeatTypeCode.OFF_COOL;
            }
            this.mIsSmartMixTypeCool = extras.getBoolean(MainRouterKt.MAIN_VIEW_SMART_MIX_MODE_TYPE);
            MyCoolHiBoostTempStep[] values = MyCoolHiBoostTempStep.values();
            int length = values.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    myCoolHiBoostTempStep = null;
                    break;
                }
                myCoolHiBoostTempStep = values[i2];
                if (myCoolHiBoostTempStep.getCode() == extras.getInt(MainRouterKt.MAIN_VIEW_MY_COOL_STEP)) {
                    break;
                }
                i2++;
            }
            if (myCoolHiBoostTempStep == null) {
                myCoolHiBoostTempStep = MyCoolHiBoostTempStep.OFF;
            }
            MyWarmTempStep[] values2 = MyWarmTempStep.values();
            int length2 = values2.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length2) {
                    myWarmTempStep = null;
                    break;
                }
                myWarmTempStep = values2[i3];
                if (myWarmTempStep.getCode() == extras.getInt(MainRouterKt.MAIN_VIEW_MY_HEAT_STEP)) {
                    break;
                }
                i3++;
            }
            if (myWarmTempStep == null) {
                myWarmTempStep = MyWarmTempStep.OFF;
            }
            boolean z = extras.getBoolean(MainRouterKt.MAIN_VIEW_IS_SMART_ACTIVE);
            MainActivity.Companion.Page[] values3 = MainActivity.Companion.Page.values();
            int length3 = values3.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length3) {
                    page = null;
                    break;
                }
                page = values3[i4];
                if (page.getStandard() == extras.getInt(MainRouterKt.MAIN_VIEW_CURRENT_PAGE)) {
                    break;
                }
                i4++;
            }
            if (page == null) {
                page = MainActivity.Companion.Page.COOL;
            }
            DeviceModeActionCode[] values4 = DeviceModeActionCode.values();
            int length4 = values4.length;
            while (true) {
                if (i >= length4) {
                    deviceModeActionCode = null;
                    break;
                }
                deviceModeActionCode = values4[i];
                if (deviceModeActionCode.getCode() == extras.getInt(MainRouterKt.MAIN_VIEW_DEVICE_MODE)) {
                    break;
                }
                i++;
            }
            if (deviceModeActionCode == null) {
                deviceModeActionCode = DeviceModeActionCode.MANUAL;
            }
            setModePattern(page, myCoolHiBoostTempStep, myWarmTempStep);
            setIsActiveMode(coolHeatTypeCode, z);
            HelpContentsPattern helpContentsPattern = getHelpContentsPattern(deviceModeActionCode);
            initHelpContents(helpContentsPattern);
            setUpDeviceInfoView(f, f2);
            setUpHelpView(f, f2, helpContentsPattern);
            setUpTitleView(helpContentsPattern);
            ActivityDeviceInfoBinding activityDeviceInfoBinding2 = this.binding;
            if (activityDeviceInfoBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityDeviceInfoBinding2 = null;
            }
            activityDeviceInfoBinding2.commonLayout.setOnInflateListener(new DeviceInfoActivity$$ExternalSyntheticLambda2(this));
            ActivityDeviceInfoBinding activityDeviceInfoBinding3 = this.binding;
            if (activityDeviceInfoBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityDeviceInfoBinding = activityDeviceInfoBinding3;
            }
            activityDeviceInfoBinding.errorLayout.setOnInflateListener(new DeviceInfoActivity$$ExternalSyntheticLambda3(this));
            setUpAlertView(getMainViewInfoCode());
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$5(DeviceInfoActivity deviceInfoActivity, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(deviceInfoActivity, "this$0");
        deviceInfoActivity.deviceInfoBinding = ViewDeviceInfoBinding.bind(view);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$6(DeviceInfoActivity deviceInfoActivity, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(deviceInfoActivity, "this$0");
        deviceInfoActivity.deviceErrorInfoBinding = ViewDeviceErrorInfoBinding.bind(view);
    }

    private final void initHelpContents(HelpContentsPattern helpContentsPattern) {
        int i;
        ActivityDeviceInfoBinding activityDeviceInfoBinding = this.binding;
        ActivityDeviceInfoBinding activityDeviceInfoBinding2 = null;
        if (activityDeviceInfoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDeviceInfoBinding = null;
        }
        View.OnClickListener onClickListener = this;
        activityDeviceInfoBinding.close.setOnClickListener(onClickListener);
        ActivityDeviceInfoBinding activityDeviceInfoBinding3 = this.binding;
        if (activityDeviceInfoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityDeviceInfoBinding2 = activityDeviceInfoBinding3;
        }
        activityDeviceInfoBinding2.support.setOnClickListener(onClickListener);
        this.mStopStrongCool = createContentsView(R.string.help_info_content_stop_strong_cool_title, R.string.help_info_content_stop_strong_cool_description, R.drawable.img_guide_01);
        if (helpContentsPattern == HelpContentsPattern.PATTERN1 || helpContentsPattern == HelpContentsPattern.PATTERN2) {
            i = R.string.help_info_content_reon_position_confirmation_cool_description;
        } else if (helpContentsPattern == HelpContentsPattern.PATTERN3) {
            i = R.string.help_info_content_reon_position_confirmation_warm_description;
        } else {
            i = R.string.help_info_content_reon_position_confirmation_cool_description;
        }
        this.mConfirmReonPosition = createContentsView(R.string.help_info_content_reon_position_confirmation_title, i, R.drawable.img_guide_02);
        this.mTryWaveMode = createContentsView(R.string.help_info_content_wave_mode_title, R.string.help_info_content_wave_mode_description, R.drawable.img_guide_03);
        this.mOpenYourNeck = createContentsView(R.string.help_info_content_open_your_neck_title, R.string.help_info_content_open_your_neck_description, R.drawable.img_guide_04);
    }

    private final void setUpDeviceInfoView(float f, float f2) {
        String str;
        DeviceTemperatureView deviceTemperatureView;
        DeviceInfoViewOutput deviceInfoViewOutput = this.mOutput;
        if (deviceInfoViewOutput == null || (str = deviceInfoViewOutput.getDeviceModelName()) == null) {
            str = "";
        }
        ActivityDeviceInfoBinding activityDeviceInfoBinding = this.binding;
        if (activityDeviceInfoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDeviceInfoBinding = null;
        }
        DeviceTemperatureView deviceTemperatureView2 = activityDeviceInfoBinding.deviceTempView;
        this.mDeviceInfoView = deviceTemperatureView2;
        if (deviceTemperatureView2 != null) {
            deviceTemperatureView2.setModelName(str);
        }
        DeviceTemperatureView.TemperatureThresholdEntity mTemperatureThresholdEntity = RemoteConfigUtil.INSTANCE.getMTemperatureThresholdEntity();
        if (!(mTemperatureThresholdEntity == null || (deviceTemperatureView = this.mDeviceInfoView) == null)) {
            deviceTemperatureView.setMTemperatureThresholdEntity(mTemperatureThresholdEntity);
        }
        DeviceTemperatureView deviceTemperatureView3 = this.mDeviceInfoView;
        if (deviceTemperatureView3 != null) {
            deviceTemperatureView3.setTemperature(f);
        }
        DeviceTemperatureView deviceTemperatureView4 = this.mDeviceInfoView;
        if (deviceTemperatureView4 != null) {
            deviceTemperatureView4.setFinTemperature(f2);
        }
    }

    private final void setUpHelpView(float f, float f2, HelpContentsPattern helpContentsPattern) {
        Context context = this;
        String peripheralName = new DeviceInfoInteractor().getPeripheralName(context);
        ActivityDeviceInfoBinding activityDeviceInfoBinding = this.binding;
        if (activityDeviceInfoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDeviceInfoBinding = null;
        }
        LinearLayout linearLayout = activityDeviceInfoBinding.helpContentLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "helpContentLayout");
        List<View> arrayList = new ArrayList<>();
        int i = 0;
        boolean z = f > 30.0f || f2 >= 41.0f;
        int i2 = WhenMappings.$EnumSwitchMapping$1[helpContentsPattern.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    arrayList.add(this.mConfirmReonPosition);
                }
            } else if (z) {
                arrayList.add(this.mOpenYourNeck);
                arrayList.add(this.mConfirmReonPosition);
            } else {
                arrayList.add(this.mConfirmReonPosition);
                arrayList.add(this.mOpenYourNeck);
            }
        } else if (z) {
            arrayList.add(this.mOpenYourNeck);
            arrayList.add(this.mStopStrongCool);
            arrayList.add(this.mConfirmReonPosition);
            int i3 = WhenMappings.$EnumSwitchMapping$0[ReonProductType.Companion.getReonProductType(peripheralName).ordinal()];
            if (i3 != 1 && i3 == 2) {
                arrayList.add(this.mTryWaveMode);
            }
        } else {
            arrayList.add(this.mConfirmReonPosition);
            if (WhenMappings.$EnumSwitchMapping$0[ReonProductType.Companion.getReonProductType(peripheralName).ordinal()] == 2) {
                arrayList.add(this.mTryWaveMode);
            }
            arrayList.add(this.mStopStrongCool);
            arrayList.add(this.mOpenYourNeck);
        }
        if (!arrayList.isEmpty()) {
            for (View addView : arrayList) {
                int i4 = i + 1;
                linearLayout.addView(addView);
                if (i < arrayList.size() - 1) {
                    Space space = new Space(context);
                    space.setLayoutParams(new LinearLayout.LayoutParams(-1, space.getResources().getDimensionPixelSize(R.dimen.helpGuideSpace)));
                    linearLayout.addView(space);
                    i = i4;
                } else {
                    return;
                }
            }
        }
    }

    private final View createContentsView(int i, int i2, int i3) {
        ViewHelpGuideBinding inflate = ViewHelpGuideBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        inflate.helpGuideTitle.setText(getString(i));
        inflate.helpGuideDescription.setText(getString(i2));
        inflate.helpGuideImage.setImageResource(i3);
        FrameLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    private final int getMainViewInfoCode() {
        DeviceInfoConstants deviceInfoConstants;
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return -1;
        }
        float f = extras.getFloat(MainRouterKt.MAIN_VIEW_FAN_TEMPERATURE, 0.0f);
        int i = extras.getInt(MainRouterKt.MAIN_VIEW_INFO_CODE, -1);
        DeviceInfoConstants[] values = DeviceInfoConstants.values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                deviceInfoConstants = null;
                break;
            }
            deviceInfoConstants = values[i2];
            if (deviceInfoConstants.getCode() == i) {
                break;
            }
            i2++;
        }
        if (deviceInfoConstants != DeviceInfoConstants.NORMAL_MOVEMENT_HIGH_TEMP) {
            return i;
        }
        if (this.mCurrentModePattern == ModePattern.COOL && ((this.mCurrentModePattern != ModePattern.COOL || this.mIsActiveMode) && f >= 41.0f)) {
            return i;
        }
        if (this.mCurrentModePattern == ModePattern.WARM || this.mCurrentModePattern == ModePattern.COOLANDWARM) {
            return DeviceInfoConstants.NORMAL_MOVEMENT_WARM.getCode();
        }
        return DeviceInfoConstants.NORMAL_MOVEMENT_COOL.getCode();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: jp.co.sony.reonpocket.view.CustomFontTextView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: jp.co.sony.reonpocket.view.CustomFontTextView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: jp.co.sony.reonpocket.view.CustomFontTextView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: jp.co.sony.reonpocket.view.CustomFontTextView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: jp.co.sony.reonpocket.view.CustomFontButton} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: jp.co.sony.reonpocket.view.CustomFontTextView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: jp.co.sony.reonpocket.view.CustomFontButton} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: jp.co.sony.reonpocket.view.CustomFontButton} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: jp.co.sony.reonpocket.view.CustomFontButton} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: jp.co.sony.reonpocket.view.CustomFontButton} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v21, resolved type: jp.co.sony.reonpocket.view.CustomFontButton} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v23 */
    /* JADX WARNING: type inference failed for: r2v24 */
    /* JADX WARNING: type inference failed for: r2v25 */
    /* JADX WARNING: type inference failed for: r2v26 */
    /* JADX WARNING: type inference failed for: r2v27 */
    /* JADX WARNING: type inference failed for: r2v28 */
    /* JADX WARNING: type inference failed for: r2v29 */
    /* JADX WARNING: type inference failed for: r2v30 */
    /* JADX WARNING: type inference failed for: r2v31 */
    /* JADX WARNING: type inference failed for: r2v32 */
    /* JADX WARNING: type inference failed for: r2v33 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setUpAlertView(int r8) {
        /*
            r7 = this;
            r0 = -1
            java.lang.String r1 = "binding"
            r2 = 0
            if (r8 == r0) goto L_0x02c1
            jp.co.sony.reonpocket.constant.DeviceInfoConstants[] r0 = jp.co.sony.reonpocket.constant.DeviceInfoConstants.values()
            int r3 = r0.length
            r4 = 0
        L_0x000c:
            if (r4 >= r3) goto L_0x001a
            r5 = r0[r4]
            int r6 = r5.getCode()
            if (r6 != r8) goto L_0x0017
            goto L_0x001b
        L_0x0017:
            int r4 = r4 + 1
            goto L_0x000c
        L_0x001a:
            r5 = r2
        L_0x001b:
            if (r5 == 0) goto L_0x02e2
            int[] r8 = jp.co.sony.reonpocket.modules.deviceInfo.view.DeviceInfoActivity.WhenMappings.$EnumSwitchMapping$2
            int r0 = r5.ordinal()
            r8 = r8[r0]
            r0 = 8
            switch(r8) {
                case 1: goto L_0x029f;
                case 2: goto L_0x029f;
                case 3: goto L_0x0249;
                case 4: goto L_0x0225;
                case 5: goto L_0x01dd;
                case 6: goto L_0x0194;
                case 7: goto L_0x014c;
                case 8: goto L_0x0104;
                case 9: goto L_0x00bc;
                case 10: goto L_0x0074;
                case 11: goto L_0x002c;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x02e2
        L_0x002c:
            jp.co.sony.reonpocket.databinding.ActivityDeviceInfoBinding r8 = r7.binding
            if (r8 != 0) goto L_0x0034
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r8 = r2
        L_0x0034:
            android.view.ViewStub r8 = r8.errorLayout
            r8.inflate()
            jp.co.sony.reonpocket.databinding.ViewDeviceErrorInfoBinding r8 = r7.deviceErrorInfoBinding
            if (r8 == 0) goto L_0x0040
            jp.co.sony.reonpocket.view.CustomFontTextView r8 = r8.errorTitle
            goto L_0x0041
        L_0x0040:
            r8 = r2
        L_0x0041:
            if (r8 != 0) goto L_0x0044
            goto L_0x004f
        L_0x0044:
            int r1 = jp.co.sony.reonpocket.R.string.help_info_message_unexpected_not_charge_error_title
            java.lang.String r1 = r7.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r8.setText(r1)
        L_0x004f:
            jp.co.sony.reonpocket.databinding.ViewDeviceErrorInfoBinding r8 = r7.deviceErrorInfoBinding
            if (r8 == 0) goto L_0x0056
            jp.co.sony.reonpocket.view.CustomFontTextView r8 = r8.errorDescription
            goto L_0x0057
        L_0x0056:
            r8 = r2
        L_0x0057:
            if (r8 != 0) goto L_0x005a
            goto L_0x0065
        L_0x005a:
            int r1 = jp.co.sony.reonpocket.R.string.help_info_message_unexpected_not_charge_error_description
            java.lang.String r1 = r7.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r8.setText(r1)
        L_0x0065:
            jp.co.sony.reonpocket.databinding.ViewDeviceErrorInfoBinding r8 = r7.deviceErrorInfoBinding
            if (r8 == 0) goto L_0x006b
            jp.co.sony.reonpocket.view.CustomFontButton r2 = r8.errorSupportButton
        L_0x006b:
            if (r2 != 0) goto L_0x006f
            goto L_0x02e2
        L_0x006f:
            r2.setVisibility(r0)
            goto L_0x02e2
        L_0x0074:
            jp.co.sony.reonpocket.databinding.ActivityDeviceInfoBinding r8 = r7.binding
            if (r8 != 0) goto L_0x007c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r8 = r2
        L_0x007c:
            android.view.ViewStub r8 = r8.errorLayout
            r8.inflate()
            jp.co.sony.reonpocket.databinding.ViewDeviceErrorInfoBinding r8 = r7.deviceErrorInfoBinding
            if (r8 == 0) goto L_0x0088
            jp.co.sony.reonpocket.view.CustomFontTextView r8 = r8.errorTitle
            goto L_0x0089
        L_0x0088:
            r8 = r2
        L_0x0089:
            if (r8 != 0) goto L_0x008c
            goto L_0x0097
        L_0x008c:
            int r1 = jp.co.sony.reonpocket.R.string.help_info_message_not_charge_error_title
            java.lang.String r1 = r7.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r8.setText(r1)
        L_0x0097:
            jp.co.sony.reonpocket.databinding.ViewDeviceErrorInfoBinding r8 = r7.deviceErrorInfoBinding
            if (r8 == 0) goto L_0x009e
            jp.co.sony.reonpocket.view.CustomFontTextView r8 = r8.errorDescription
            goto L_0x009f
        L_0x009e:
            r8 = r2
        L_0x009f:
            if (r8 != 0) goto L_0x00a2
            goto L_0x00ad
        L_0x00a2:
            int r1 = jp.co.sony.reonpocket.R.string.help_info_message_not_charge_high_temp_error_description
            java.lang.String r1 = r7.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r8.setText(r1)
        L_0x00ad:
            jp.co.sony.reonpocket.databinding.ViewDeviceErrorInfoBinding r8 = r7.deviceErrorInfoBinding
            if (r8 == 0) goto L_0x00b3
            jp.co.sony.reonpocket.view.CustomFontButton r2 = r8.errorSupportButton
        L_0x00b3:
            if (r2 != 0) goto L_0x00b7
            goto L_0x02e2
        L_0x00b7:
            r2.setVisibility(r0)
            goto L_0x02e2
        L_0x00bc:
            jp.co.sony.reonpocket.databinding.ActivityDeviceInfoBinding r8 = r7.binding
            if (r8 != 0) goto L_0x00c4
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r8 = r2
        L_0x00c4:
            android.view.ViewStub r8 = r8.errorLayout
            r8.inflate()
            jp.co.sony.reonpocket.databinding.ViewDeviceErrorInfoBinding r8 = r7.deviceErrorInfoBinding
            if (r8 == 0) goto L_0x00d0
            jp.co.sony.reonpocket.view.CustomFontTextView r8 = r8.errorTitle
            goto L_0x00d1
        L_0x00d0:
            r8 = r2
        L_0x00d1:
            if (r8 != 0) goto L_0x00d4
            goto L_0x00df
        L_0x00d4:
            int r1 = jp.co.sony.reonpocket.R.string.help_info_message_unexpected_stop_error_title
            java.lang.String r1 = r7.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r8.setText(r1)
        L_0x00df:
            jp.co.sony.reonpocket.databinding.ViewDeviceErrorInfoBinding r8 = r7.deviceErrorInfoBinding
            if (r8 == 0) goto L_0x00e6
            jp.co.sony.reonpocket.view.CustomFontTextView r8 = r8.errorDescription
            goto L_0x00e7
        L_0x00e6:
            r8 = r2
        L_0x00e7:
            if (r8 != 0) goto L_0x00ea
            goto L_0x00f5
        L_0x00ea:
            int r1 = jp.co.sony.reonpocket.R.string.help_info_message_unexpected_stop_error_description
            java.lang.String r1 = r7.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r8.setText(r1)
        L_0x00f5:
            jp.co.sony.reonpocket.databinding.ViewDeviceErrorInfoBinding r8 = r7.deviceErrorInfoBinding
            if (r8 == 0) goto L_0x00fb
            jp.co.sony.reonpocket.view.CustomFontButton r2 = r8.errorSupportButton
        L_0x00fb:
            if (r2 != 0) goto L_0x00ff
            goto L_0x02e2
        L_0x00ff:
            r2.setVisibility(r0)
            goto L_0x02e2
        L_0x0104:
            jp.co.sony.reonpocket.databinding.ActivityDeviceInfoBinding r8 = r7.binding
            if (r8 != 0) goto L_0x010c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r8 = r2
        L_0x010c:
            android.view.ViewStub r8 = r8.errorLayout
            r8.inflate()
            jp.co.sony.reonpocket.databinding.ViewDeviceErrorInfoBinding r8 = r7.deviceErrorInfoBinding
            if (r8 == 0) goto L_0x0118
            jp.co.sony.reonpocket.view.CustomFontTextView r8 = r8.errorTitle
            goto L_0x0119
        L_0x0118:
            r8 = r2
        L_0x0119:
            if (r8 != 0) goto L_0x011c
            goto L_0x0127
        L_0x011c:
            int r1 = jp.co.sony.reonpocket.R.string.help_info_message_fan_not_work_error_title
            java.lang.String r1 = r7.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r8.setText(r1)
        L_0x0127:
            jp.co.sony.reonpocket.databinding.ViewDeviceErrorInfoBinding r8 = r7.deviceErrorInfoBinding
            if (r8 == 0) goto L_0x012e
            jp.co.sony.reonpocket.view.CustomFontTextView r8 = r8.errorDescription
            goto L_0x012f
        L_0x012e:
            r8 = r2
        L_0x012f:
            if (r8 != 0) goto L_0x0132
            goto L_0x013d
        L_0x0132:
            int r1 = jp.co.sony.reonpocket.R.string.help_info_message_fan_not_work_error_description
            java.lang.String r1 = r7.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r8.setText(r1)
        L_0x013d:
            jp.co.sony.reonpocket.databinding.ViewDeviceErrorInfoBinding r8 = r7.deviceErrorInfoBinding
            if (r8 == 0) goto L_0x0143
            jp.co.sony.reonpocket.view.CustomFontButton r2 = r8.errorSupportButton
        L_0x0143:
            if (r2 != 0) goto L_0x0147
            goto L_0x02e2
        L_0x0147:
            r2.setVisibility(r0)
            goto L_0x02e2
        L_0x014c:
            jp.co.sony.reonpocket.databinding.ActivityDeviceInfoBinding r8 = r7.binding
            if (r8 != 0) goto L_0x0154
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r8 = r2
        L_0x0154:
            android.view.ViewStub r8 = r8.errorLayout
            r8.inflate()
            jp.co.sony.reonpocket.databinding.ViewDeviceErrorInfoBinding r8 = r7.deviceErrorInfoBinding
            if (r8 == 0) goto L_0x0160
            jp.co.sony.reonpocket.view.CustomFontTextView r8 = r8.errorTitle
            goto L_0x0161
        L_0x0160:
            r8 = r2
        L_0x0161:
            if (r8 != 0) goto L_0x0164
            goto L_0x016f
        L_0x0164:
            int r1 = jp.co.sony.reonpocket.R.string.help_info_message_low_temp_error_title
            java.lang.String r1 = r7.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r8.setText(r1)
        L_0x016f:
            jp.co.sony.reonpocket.databinding.ViewDeviceErrorInfoBinding r8 = r7.deviceErrorInfoBinding
            if (r8 == 0) goto L_0x0176
            jp.co.sony.reonpocket.view.CustomFontTextView r8 = r8.errorDescription
            goto L_0x0177
        L_0x0176:
            r8 = r2
        L_0x0177:
            if (r8 != 0) goto L_0x017a
            goto L_0x0185
        L_0x017a:
            int r1 = jp.co.sony.reonpocket.R.string.help_info_message_low_temp_error_description
            java.lang.String r1 = r7.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r8.setText(r1)
        L_0x0185:
            jp.co.sony.reonpocket.databinding.ViewDeviceErrorInfoBinding r8 = r7.deviceErrorInfoBinding
            if (r8 == 0) goto L_0x018b
            jp.co.sony.reonpocket.view.CustomFontButton r2 = r8.errorSupportButton
        L_0x018b:
            if (r2 != 0) goto L_0x018f
            goto L_0x02e2
        L_0x018f:
            r2.setVisibility(r0)
            goto L_0x02e2
        L_0x0194:
            jp.co.sony.reonpocket.databinding.ActivityDeviceInfoBinding r8 = r7.binding
            if (r8 != 0) goto L_0x019c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r8 = r2
        L_0x019c:
            android.view.ViewStub r8 = r8.errorLayout
            r8.inflate()
            jp.co.sony.reonpocket.databinding.ViewDeviceErrorInfoBinding r8 = r7.deviceErrorInfoBinding
            if (r8 == 0) goto L_0x01a8
            jp.co.sony.reonpocket.view.CustomFontTextView r8 = r8.errorTitle
            goto L_0x01a9
        L_0x01a8:
            r8 = r2
        L_0x01a9:
            if (r8 != 0) goto L_0x01ac
            goto L_0x01b7
        L_0x01ac:
            int r0 = jp.co.sony.reonpocket.R.string.help_info_message_high_temp_error_title
            java.lang.String r0 = r7.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r8.setText(r0)
        L_0x01b7:
            jp.co.sony.reonpocket.databinding.ViewDeviceErrorInfoBinding r8 = r7.deviceErrorInfoBinding
            if (r8 == 0) goto L_0x01bd
            jp.co.sony.reonpocket.view.CustomFontTextView r2 = r8.errorDescription
        L_0x01bd:
            if (r2 != 0) goto L_0x01c0
            goto L_0x01cb
        L_0x01c0:
            int r8 = jp.co.sony.reonpocket.R.string.help_info_message_high_temp_error_description
            java.lang.String r8 = r7.getString(r8)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r2.setText(r8)
        L_0x01cb:
            jp.co.sony.reonpocket.databinding.ViewDeviceErrorInfoBinding r8 = r7.deviceErrorInfoBinding
            if (r8 == 0) goto L_0x02e2
            jp.co.sony.reonpocket.view.CustomFontButton r8 = r8.errorSupportButton
            if (r8 == 0) goto L_0x02e2
            jp.co.sony.reonpocket.modules.deviceInfo.view.DeviceInfoActivity$$ExternalSyntheticLambda1 r0 = new jp.co.sony.reonpocket.modules.deviceInfo.view.DeviceInfoActivity$$ExternalSyntheticLambda1
            r0.<init>(r7)
            r8.setOnClickListener(r0)
            goto L_0x02e2
        L_0x01dd:
            jp.co.sony.reonpocket.databinding.ActivityDeviceInfoBinding r8 = r7.binding
            if (r8 != 0) goto L_0x01e5
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r8 = r2
        L_0x01e5:
            android.view.ViewStub r8 = r8.errorLayout
            r8.inflate()
            jp.co.sony.reonpocket.databinding.ViewDeviceErrorInfoBinding r8 = r7.deviceErrorInfoBinding
            if (r8 == 0) goto L_0x01f1
            jp.co.sony.reonpocket.view.CustomFontTextView r8 = r8.errorTitle
            goto L_0x01f2
        L_0x01f1:
            r8 = r2
        L_0x01f2:
            if (r8 != 0) goto L_0x01f5
            goto L_0x0200
        L_0x01f5:
            int r1 = jp.co.sony.reonpocket.R.string.help_info_message_not_charge_error_title
            java.lang.String r1 = r7.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r8.setText(r1)
        L_0x0200:
            jp.co.sony.reonpocket.databinding.ViewDeviceErrorInfoBinding r8 = r7.deviceErrorInfoBinding
            if (r8 == 0) goto L_0x0207
            jp.co.sony.reonpocket.view.CustomFontTextView r8 = r8.errorDescription
            goto L_0x0208
        L_0x0207:
            r8 = r2
        L_0x0208:
            if (r8 != 0) goto L_0x020b
            goto L_0x0216
        L_0x020b:
            int r1 = jp.co.sony.reonpocket.R.string.help_info_message_not_charge_low_temp_error_description
            java.lang.String r1 = r7.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r8.setText(r1)
        L_0x0216:
            jp.co.sony.reonpocket.databinding.ViewDeviceErrorInfoBinding r8 = r7.deviceErrorInfoBinding
            if (r8 == 0) goto L_0x021c
            jp.co.sony.reonpocket.view.CustomFontButton r2 = r8.errorSupportButton
        L_0x021c:
            if (r2 != 0) goto L_0x0220
            goto L_0x02e2
        L_0x0220:
            r2.setVisibility(r0)
            goto L_0x02e2
        L_0x0225:
            jp.co.sony.reonpocket.databinding.ActivityDeviceInfoBinding r8 = r7.binding
            if (r8 != 0) goto L_0x022d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r8 = r2
        L_0x022d:
            android.view.ViewStub r8 = r8.errorLayout
            r8.inflate()
            jp.co.sony.reonpocket.databinding.ViewDeviceInfoBinding r8 = r7.deviceInfoBinding
            if (r8 == 0) goto L_0x0238
            jp.co.sony.reonpocket.view.CustomFontTextView r2 = r8.messageTitle
        L_0x0238:
            if (r2 != 0) goto L_0x023c
            goto L_0x02e2
        L_0x023c:
            int r8 = jp.co.sony.reonpocket.R.string.help_info_message_low_battery_title
            java.lang.String r8 = r7.getString(r8)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r2.setText(r8)
            goto L_0x02e2
        L_0x0249:
            jp.co.sony.reonpocket.databinding.ActivityDeviceInfoBinding r8 = r7.binding
            if (r8 != 0) goto L_0x0251
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r8 = r2
        L_0x0251:
            android.view.ViewStub r8 = r8.errorLayout
            r8.inflate()
            jp.co.sony.reonpocket.databinding.ViewDeviceErrorInfoBinding r8 = r7.deviceErrorInfoBinding
            if (r8 == 0) goto L_0x025d
            jp.co.sony.reonpocket.view.CustomImageView r8 = r8.errorImg
            goto L_0x025e
        L_0x025d:
            r8 = r2
        L_0x025e:
            if (r8 != 0) goto L_0x0261
            goto L_0x0264
        L_0x0261:
            r8.setVisibility(r0)
        L_0x0264:
            jp.co.sony.reonpocket.databinding.ViewDeviceErrorInfoBinding r8 = r7.deviceErrorInfoBinding
            if (r8 == 0) goto L_0x026b
            jp.co.sony.reonpocket.view.CustomFontTextView r8 = r8.errorTitle
            goto L_0x026c
        L_0x026b:
            r8 = r2
        L_0x026c:
            if (r8 != 0) goto L_0x026f
            goto L_0x027a
        L_0x026f:
            int r0 = jp.co.sony.reonpocket.R.string.help_info_message_high_temp_alert_title
            java.lang.String r0 = r7.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r8.setText(r0)
        L_0x027a:
            jp.co.sony.reonpocket.databinding.ViewDeviceErrorInfoBinding r8 = r7.deviceErrorInfoBinding
            if (r8 == 0) goto L_0x0280
            jp.co.sony.reonpocket.view.CustomFontTextView r2 = r8.errorDescription
        L_0x0280:
            if (r2 != 0) goto L_0x0283
            goto L_0x028e
        L_0x0283:
            int r8 = jp.co.sony.reonpocket.R.string.help_info_message_high_temp_alert_description
            java.lang.String r8 = r7.getString(r8)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r2.setText(r8)
        L_0x028e:
            jp.co.sony.reonpocket.databinding.ViewDeviceErrorInfoBinding r8 = r7.deviceErrorInfoBinding
            if (r8 == 0) goto L_0x02e2
            jp.co.sony.reonpocket.view.CustomFontButton r8 = r8.errorSupportButton
            if (r8 == 0) goto L_0x02e2
            jp.co.sony.reonpocket.modules.deviceInfo.view.DeviceInfoActivity$$ExternalSyntheticLambda0 r0 = new jp.co.sony.reonpocket.modules.deviceInfo.view.DeviceInfoActivity$$ExternalSyntheticLambda0
            r0.<init>(r7)
            r8.setOnClickListener(r0)
            goto L_0x02e2
        L_0x029f:
            jp.co.sony.reonpocket.databinding.ActivityDeviceInfoBinding r8 = r7.binding
            if (r8 != 0) goto L_0x02a7
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r8 = r2
        L_0x02a7:
            android.view.ViewStub r8 = r8.commonLayout
            r8.inflate()
            jp.co.sony.reonpocket.databinding.ViewDeviceInfoBinding r8 = r7.deviceInfoBinding
            if (r8 == 0) goto L_0x02b2
            jp.co.sony.reonpocket.view.CustomFontTextView r2 = r8.messageTitle
        L_0x02b2:
            if (r2 != 0) goto L_0x02b5
            goto L_0x02e2
        L_0x02b5:
            int r8 = jp.co.sony.reonpocket.R.string.help_info_message_normal
            java.lang.String r8 = r7.getString(r8)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r2.setText(r8)
            goto L_0x02e2
        L_0x02c1:
            jp.co.sony.reonpocket.databinding.ActivityDeviceInfoBinding r8 = r7.binding
            if (r8 != 0) goto L_0x02c9
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r8 = r2
        L_0x02c9:
            android.view.ViewStub r8 = r8.commonLayout
            r8.inflate()
            jp.co.sony.reonpocket.databinding.ViewDeviceInfoBinding r8 = r7.deviceInfoBinding
            if (r8 == 0) goto L_0x02d4
            jp.co.sony.reonpocket.view.CustomFontTextView r2 = r8.messageTitle
        L_0x02d4:
            if (r2 != 0) goto L_0x02d7
            goto L_0x02e2
        L_0x02d7:
            int r8 = jp.co.sony.reonpocket.R.string.help_info_message_normal
            java.lang.String r8 = r7.getString(r8)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r2.setText(r8)
        L_0x02e2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.deviceInfo.view.DeviceInfoActivity.setUpAlertView(int):void");
    }

    /* access modifiers changed from: private */
    public static final void setUpAlertView$lambda$13$lambda$11(DeviceInfoActivity deviceInfoActivity, View view) {
        Intrinsics.checkNotNullParameter(deviceInfoActivity, "this$0");
        DeviceInfoViewOutput deviceInfoViewOutput = deviceInfoActivity.mOutput;
        if (deviceInfoViewOutput != null) {
            deviceInfoViewOutput.transitToSupportPage();
        }
    }

    /* access modifiers changed from: private */
    public static final void setUpAlertView$lambda$13$lambda$12(DeviceInfoActivity deviceInfoActivity, View view) {
        Intrinsics.checkNotNullParameter(deviceInfoActivity, "this$0");
        DeviceInfoViewOutput deviceInfoViewOutput = deviceInfoActivity.mOutput;
        if (deviceInfoViewOutput != null) {
            deviceInfoViewOutput.transitToSupportPage();
        }
    }

    private final void setUpTitleView(HelpContentsPattern helpContentsPattern) {
        ActivityDeviceInfoBinding activityDeviceInfoBinding = this.binding;
        if (activityDeviceInfoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDeviceInfoBinding = null;
        }
        CustomFontTextView customFontTextView = activityDeviceInfoBinding.helpInfoContentTitle;
        Intrinsics.checkNotNullExpressionValue(customFontTextView, "helpInfoContentTitle");
        int i = WhenMappings.$EnumSwitchMapping$1[helpContentsPattern.ordinal()];
        if (i == 1 || i == 2) {
            customFontTextView.setBackgroundResource(R.drawable.bg_help_guide_title);
            customFontTextView.setText(R.string.help_info_content_title_cool);
        } else if (i == 3) {
            customFontTextView.setBackgroundResource(R.drawable.bg_help_guide_title_warm);
            customFontTextView.setText(R.string.help_info_content_title_warm);
        } else if (i == 4) {
            customFontTextView.setVisibility(8);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public void updateDeviceTemp(float f, float f2) {
        DeviceTemperatureView deviceTemperatureView = this.mDeviceInfoView;
        if (deviceTemperatureView != null) {
            deviceTemperatureView.setTemperature(f);
        }
        DeviceTemperatureView deviceTemperatureView2 = this.mDeviceInfoView;
        if (deviceTemperatureView2 != null) {
            deviceTemperatureView2.setFinTemperature(f2);
        }
    }

    public void onClick(View view) {
        super.onClick(view);
        if (view != null) {
            int id = view.getId();
            if (id == R.id.support) {
                DeviceInfoViewOutput deviceInfoViewOutput = this.mOutput;
                if (deviceInfoViewOutput != null) {
                    deviceInfoViewOutput.transitToSupportPage();
                }
            } else if (id == R.id.close) {
                finish();
            }
        }
    }

    private final void setModePattern(MainActivity.Companion.Page page, MyCoolHiBoostTempStep myCoolHiBoostTempStep, MyWarmTempStep myWarmTempStep) {
        int i = WhenMappings.$EnumSwitchMapping$3[page.ordinal()];
        if (i == 1) {
            this.mCurrentModePattern = ModePattern.COOL;
        } else if (i == 2) {
            this.mCurrentModePattern = ModePattern.COOL;
        } else if (i == 3) {
            this.mCurrentModePattern = ModePattern.COOLANDWARM;
        } else if (i == 4) {
            this.mCurrentModePattern = ModePattern.WARM;
        }
    }

    private final void setIsActiveMode(CoolHeatTypeCode coolHeatTypeCode, boolean z) {
        int i = WhenMappings.$EnumSwitchMapping$4[this.mCurrentModePattern.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        this.mIsActiveMode = false;
                    }
                } else if (coolHeatTypeCode == CoolHeatTypeCode.SMART || z) {
                    this.mIsActiveMode = true;
                }
            } else if (coolHeatTypeCode == CoolHeatTypeCode.HEAT || z) {
                this.mIsActiveMode = true;
            }
        } else if (coolHeatTypeCode == CoolHeatTypeCode.COOL || z) {
            this.mIsActiveMode = true;
        }
    }

    private final HelpContentsPattern getHelpContentsPattern(DeviceModeActionCode deviceModeActionCode) {
        int i = WhenMappings.$EnumSwitchMapping$4[this.mCurrentModePattern.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return HelpContentsPattern.PATTERN4;
                    }
                } else if (!this.mIsActiveMode) {
                    return HelpContentsPattern.PATTERN4;
                } else {
                    if (this.mIsSmartMixTypeCool) {
                        return HelpContentsPattern.PATTERN2;
                    }
                    return HelpContentsPattern.PATTERN3;
                }
            } else if (this.mIsActiveMode) {
                return HelpContentsPattern.PATTERN3;
            } else {
                return HelpContentsPattern.PATTERN4;
            }
        } else if (deviceModeActionCode == DeviceModeActionCode.MANUAL || deviceModeActionCode == DeviceModeActionCode.AUTO) {
            if (!this.mIsActiveMode) {
                return HelpContentsPattern.PATTERN4;
            }
            return HelpContentsPattern.PATTERN1;
        } else if (deviceModeActionCode == DeviceModeActionCode.TEMPERATURE) {
            if (!this.mIsActiveMode) {
                return HelpContentsPattern.PATTERN4;
            }
            return HelpContentsPattern.PATTERN2;
        } else if (deviceModeActionCode == DeviceModeActionCode.MY || deviceModeActionCode == DeviceModeActionCode.MY_SETTING) {
            return HelpContentsPattern.PATTERN2;
        }
        return HelpContentsPattern.PATTERN4;
    }
}
