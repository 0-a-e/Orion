package jp.co.sony.reonpocket.modules.main.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.lang.ref.WeakReference;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.constant.SmartModePreference;
import jp.co.sony.reonpocket.data.entity.DeviceModeEntity;
import jp.co.sony.reonpocket.modules.base.view.BaseFragment;
import jp.co.sony.reonpocket.view.CustomFontTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00029:B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0007H\u0002J\b\u0010&\u001a\u00020$H\u0002J\b\u0010'\u001a\u00020$H\u0002J\u0010\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020*H\u0002J&\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\"\u00102\u001a\u00020$2\b\u00103\u001a\u0004\u0018\u00010\u001f2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000205H\u0016J\b\u00107\u001a\u00020$H\u0002J\b\u00108\u001a\u00020$H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X.¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X.¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\"\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainSmartModeSettingFragment;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment;", "Landroid/widget/NumberPicker$OnValueChangeListener;", "()V", "coolPref", "Ljp/co/sony/reonpocket/constant/SmartModePreference;", "isCoolMode", "", "isTagInfoReceiving", "mButtonGroup", "Landroid/widget/LinearLayout;", "mCompButton", "Landroid/widget/Button;", "mCurrentSmartCoolTempSwitchThreshold", "", "mCurrentSmartPreference", "mCurrentSmartWarmTempSwitchThreshold", "mCurrentSwitchCoolTemp", "mCurrentSwitchWarmTemp", "mIsCoolMode", "mMainActivity", "Ljava/lang/ref/WeakReference;", "Ljp/co/sony/reonpocket/modules/main/view/MainActivity;", "mSmartCoolButton", "mSmartCoolModeEntry", "", "", "[Ljava/lang/String;", "mSmartModeLevelView", "Ljp/co/sony/reonpocket/view/CustomFontTextView;", "mSmartModePicker", "Landroid/widget/NumberPicker;", "mSmartWarmButton", "mSmartWarmModeEntry", "warmPref", "changeMode", "", "isNextCoolMode", "changeModePicker", "compButtonTapped", "initUi", "aView", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onValueChange", "picker", "oldVal", "", "newVal", "smartCoolButtonTapped", "smartWarmButtonTapped", "Companion", "SmartModeSelectListener", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainSmartModeSettingFragment.kt */
public final class MainSmartModeSettingFragment extends BaseFragment implements NumberPicker.OnValueChangeListener {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String IS_COOL_MODE = "isCoolMode";
    private static final String IS_TAG_INFO_RECEIVING = "isTagInfoReceiving";
    private static final String SMART_COOL_PREF = "smartCoolPreference";
    private static final String SMART_COOL_TEMP_SWITCH_THRESHOLD = "smartCoolTempSwitchThreshold";
    private static final String SMART_WARM_PREF = "smartWarmPreference";
    private static final String SMART_WARM_TEMP_SWITCH_THRESHOLD = "smartWarmTempSwitchThreshold";
    private SmartModePreference coolPref = SmartModePreference.OFF;
    private boolean isCoolMode;
    private boolean isTagInfoReceiving;
    private LinearLayout mButtonGroup;
    private Button mCompButton;
    private double mCurrentSmartCoolTempSwitchThreshold = 25.0d;
    private SmartModePreference mCurrentSmartPreference = SmartModePreference.OFF;
    private double mCurrentSmartWarmTempSwitchThreshold = 25.0d;
    private double mCurrentSwitchCoolTemp = 25.0d;
    private double mCurrentSwitchWarmTemp = 25.0d;
    private boolean mIsCoolMode = true;
    private WeakReference<MainActivity> mMainActivity;
    private Button mSmartCoolButton;
    private String[] mSmartCoolModeEntry;
    private CustomFontTextView mSmartModeLevelView;
    private NumberPicker mSmartModePicker;
    private Button mSmartWarmButton;
    private String[] mSmartWarmModeEntry;
    private SmartModePreference warmPref = SmartModePreference.OFF;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&¨\u0006\f"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainSmartModeSettingFragment$SmartModeSelectListener;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment$Callback;", "onSmartModeSelected", "", "coolPref", "Ljp/co/sony/reonpocket/constant/SmartModePreference;", "warmPref", "isCoolMode", "", "coolTempSwitchThreshold", "", "warmTempStepSwitchThreshold", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainSmartModeSettingFragment.kt */
    public interface SmartModeSelectListener extends BaseFragment.Callback {
        void onSmartModeSelected(SmartModePreference smartModePreference, SmartModePreference smartModePreference2, boolean z, double d, double d2);
    }

    @JvmStatic
    public static final MainSmartModeSettingFragment newInstance(boolean z, SmartModePreference smartModePreference, SmartModePreference smartModePreference2, double d, double d2, boolean z2) {
        return Companion.newInstance(z, smartModePreference, smartModePreference2, d, d2, z2);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainSmartModeSettingFragment$Companion;", "", "()V", "IS_COOL_MODE", "", "IS_TAG_INFO_RECEIVING", "SMART_COOL_PREF", "SMART_COOL_TEMP_SWITCH_THRESHOLD", "SMART_WARM_PREF", "SMART_WARM_TEMP_SWITCH_THRESHOLD", "newInstance", "Ljp/co/sony/reonpocket/modules/main/view/MainSmartModeSettingFragment;", "isCoolMode", "", "coolPref", "Ljp/co/sony/reonpocket/constant/SmartModePreference;", "warmPref", "switchCoolTemp", "", "switchWarmTemp", "isTagInfoReceiving", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainSmartModeSettingFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MainSmartModeSettingFragment newInstance(boolean z, SmartModePreference smartModePreference, SmartModePreference smartModePreference2, double d, double d2, boolean z2) {
            Intrinsics.checkNotNullParameter(smartModePreference, "coolPref");
            Intrinsics.checkNotNullParameter(smartModePreference2, "warmPref");
            MainSmartModeSettingFragment mainSmartModeSettingFragment = new MainSmartModeSettingFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean(MainSmartModeSettingFragment.IS_COOL_MODE, z);
            bundle.putInt(MainSmartModeSettingFragment.SMART_COOL_PREF, smartModePreference.getCode());
            bundle.putInt(MainSmartModeSettingFragment.SMART_WARM_PREF, smartModePreference2.getCode());
            bundle.putDouble(MainSmartModeSettingFragment.SMART_COOL_TEMP_SWITCH_THRESHOLD, d);
            bundle.putDouble(MainSmartModeSettingFragment.SMART_WARM_TEMP_SWITCH_THRESHOLD, d2);
            bundle.putBoolean(MainSmartModeSettingFragment.IS_TAG_INFO_RECEIVING, z2);
            mainSmartModeSettingFragment.setArguments(bundle);
            return mainSmartModeSettingFragment;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        SmartModePreference smartModePreference;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Bundle arguments = getArguments();
        SmartModePreference smartModePreference2 = null;
        if (arguments == null) {
            return null;
        }
        this.isCoolMode = arguments.getBoolean(IS_COOL_MODE);
        SmartModePreference[] values = SmartModePreference.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                smartModePreference = null;
                break;
            }
            smartModePreference = values[i];
            if (smartModePreference.getCode() == arguments.getInt(SMART_COOL_PREF)) {
                break;
            }
            i++;
        }
        if (smartModePreference == null) {
            smartModePreference = SmartModePreference.WEAK;
        }
        this.coolPref = smartModePreference;
        SmartModePreference[] values2 = SmartModePreference.values();
        int length2 = values2.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length2) {
                break;
            }
            SmartModePreference smartModePreference3 = values2[i2];
            if (smartModePreference3.getCode() == arguments.getInt(SMART_WARM_PREF)) {
                smartModePreference2 = smartModePreference3;
                break;
            }
            i2++;
        }
        if (smartModePreference2 == null) {
            smartModePreference2 = SmartModePreference.WEAK;
        }
        this.warmPref = smartModePreference2;
        this.mCurrentSmartCoolTempSwitchThreshold = arguments.getDouble(SMART_COOL_TEMP_SWITCH_THRESHOLD);
        this.mCurrentSmartWarmTempSwitchThreshold = arguments.getDouble(SMART_WARM_TEMP_SWITCH_THRESHOLD);
        this.isTagInfoReceiving = arguments.getBoolean(IS_TAG_INFO_RECEIVING);
        View inflate = layoutInflater.inflate(R.layout.fragment_smart_setting_button_switch, viewGroup, false);
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type jp.co.sony.reonpocket.modules.main.view.MainActivity");
        this.mMainActivity = new WeakReference<>((MainActivity) activity);
        Intrinsics.checkNotNull(inflate);
        initUi(inflate);
        return inflate;
    }

    private final void initUi(View view) {
        LinearLayout linearLayout;
        this.mSmartModePicker = (NumberPicker) view.findViewById(R.id.numberPicker);
        this.mCompButton = (Button) view.findViewById(R.id.do_setting);
        this.mButtonGroup = (LinearLayout) view.findViewById(R.id.smart_setting_button);
        this.mSmartCoolButton = (Button) view.findViewById(R.id.smart_cool_setting_button);
        this.mSmartWarmButton = (Button) view.findViewById(R.id.smart_warm_setting_button);
        this.mIsCoolMode = this.isCoolMode;
        this.mCurrentSwitchCoolTemp = this.mCurrentSmartCoolTempSwitchThreshold;
        this.mCurrentSwitchWarmTemp = this.mCurrentSmartWarmTempSwitchThreshold;
        String[] stringArray = getResources().getStringArray(R.array.mainview_smart_favorite_cool_step_array);
        Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
        this.mSmartCoolModeEntry = stringArray;
        String[] stringArray2 = getResources().getStringArray(R.array.mainview_smart_favorite_warm_step_array);
        Intrinsics.checkNotNullExpressionValue(stringArray2, "getStringArray(...)");
        this.mSmartWarmModeEntry = stringArray2;
        changeModePicker();
        view.findViewById(R.id.smart_setting_space).setOnClickListener(new MainSmartModeSettingFragment$$ExternalSyntheticLambda0(this));
        Button button = this.mCompButton;
        if (button != null) {
            button.setOnClickListener(new MainSmartModeSettingFragment$$ExternalSyntheticLambda1(this));
        }
        if (!this.isTagInfoReceiving && (linearLayout = this.mButtonGroup) != null) {
            linearLayout.setVisibility(8);
        }
        Button button2 = this.mSmartCoolButton;
        if (button2 != null) {
            button2.setEnabled(!this.mIsCoolMode);
        }
        Button button3 = this.mSmartWarmButton;
        if (button3 != null) {
            button3.setEnabled(this.mIsCoolMode);
        }
        Button button4 = this.mSmartCoolButton;
        if (button4 != null) {
            button4.setOnClickListener(new MainSmartModeSettingFragment$$ExternalSyntheticLambda2(this));
        }
        Button button5 = this.mSmartWarmButton;
        if (button5 != null) {
            button5.setOnClickListener(new MainSmartModeSettingFragment$$ExternalSyntheticLambda3(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void initUi$lambda$2(MainSmartModeSettingFragment mainSmartModeSettingFragment, View view) {
        FragmentTransaction beginTransaction;
        FragmentTransaction remove;
        Intrinsics.checkNotNullParameter(mainSmartModeSettingFragment, "this$0");
        FragmentManager fragmentManager = mainSmartModeSettingFragment.getFragmentManager();
        if (fragmentManager != null && (beginTransaction = fragmentManager.beginTransaction()) != null && (remove = beginTransaction.remove(mainSmartModeSettingFragment)) != null) {
            remove.commit();
        }
    }

    /* access modifiers changed from: private */
    public static final void initUi$lambda$3(MainSmartModeSettingFragment mainSmartModeSettingFragment, View view) {
        Intrinsics.checkNotNullParameter(mainSmartModeSettingFragment, "this$0");
        mainSmartModeSettingFragment.compButtonTapped();
    }

    /* access modifiers changed from: private */
    public static final void initUi$lambda$4(MainSmartModeSettingFragment mainSmartModeSettingFragment, View view) {
        Intrinsics.checkNotNullParameter(mainSmartModeSettingFragment, "this$0");
        mainSmartModeSettingFragment.smartCoolButtonTapped();
    }

    /* access modifiers changed from: private */
    public static final void initUi$lambda$5(MainSmartModeSettingFragment mainSmartModeSettingFragment, View view) {
        Intrinsics.checkNotNullParameter(mainSmartModeSettingFragment, "this$0");
        mainSmartModeSettingFragment.smartWarmButtonTapped();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: jp.co.sony.reonpocket.data.entity.DeviceModeEntity$SmartWarmModeCombine} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: jp.co.sony.reonpocket.data.entity.DeviceModeEntity$SmartCoolModeCombine} */
    /* JADX WARNING: type inference failed for: r6v1 */
    /* JADX WARNING: type inference failed for: r6v3 */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onValueChange(android.widget.NumberPicker r5, int r6, int r7) {
        /*
            r4 = this;
            boolean r5 = r4.mIsCoolMode
            r6 = 0
            r0 = 0
            if (r5 == 0) goto L_0x0029
            jp.co.sony.reonpocket.data.entity.DeviceModeEntity$SmartCoolModeCombine[] r5 = jp.co.sony.reonpocket.data.entity.DeviceModeEntity.SmartCoolModeCombine.values()
            int r1 = r5.length
        L_0x000b:
            if (r0 >= r1) goto L_0x001a
            r2 = r5[r0]
            int r3 = r2.ordinal()
            if (r7 != r3) goto L_0x0017
            r6 = r2
            goto L_0x001a
        L_0x0017:
            int r0 = r0 + 1
            goto L_0x000b
        L_0x001a:
            if (r6 == 0) goto L_0x004b
            jp.co.sony.reonpocket.constant.SmartModePreference r5 = r6.getPref()
            r4.mCurrentSmartPreference = r5
            jp.co.sony.reonpocket.constant.SmartModePreference r5 = r6.getPref()
            r4.coolPref = r5
            goto L_0x004b
        L_0x0029:
            jp.co.sony.reonpocket.data.entity.DeviceModeEntity$SmartWarmModeCombine[] r5 = jp.co.sony.reonpocket.data.entity.DeviceModeEntity.SmartWarmModeCombine.values()
            int r1 = r5.length
        L_0x002e:
            if (r0 >= r1) goto L_0x003d
            r2 = r5[r0]
            int r3 = r2.ordinal()
            if (r7 != r3) goto L_0x003a
            r6 = r2
            goto L_0x003d
        L_0x003a:
            int r0 = r0 + 1
            goto L_0x002e
        L_0x003d:
            if (r6 == 0) goto L_0x004b
            jp.co.sony.reonpocket.constant.SmartModePreference r5 = r6.getPref()
            r4.mCurrentSmartPreference = r5
            jp.co.sony.reonpocket.constant.SmartModePreference r5 = r6.getPref()
            r4.warmPref = r5
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.main.view.MainSmartModeSettingFragment.onValueChange(android.widget.NumberPicker, int, int):void");
    }

    private final void changeModePicker() {
        NumberPicker numberPicker = this.mSmartModePicker;
        String[] strArr = null;
        if (numberPicker != null) {
            numberPicker.setDisplayedValues((String[]) null);
        }
        if (this.mIsCoolMode) {
            NumberPicker numberPicker2 = this.mSmartModePicker;
            if (numberPicker2 != null) {
                String[] strArr2 = this.mSmartCoolModeEntry;
                if (strArr2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSmartCoolModeEntry");
                    strArr2 = null;
                }
                numberPicker2.setDisplayedValues(strArr2);
            }
            NumberPicker numberPicker3 = this.mSmartModePicker;
            if (numberPicker3 != null) {
                String[] strArr3 = this.mSmartCoolModeEntry;
                if (strArr3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSmartCoolModeEntry");
                    strArr3 = null;
                }
                numberPicker3.setMaxValue(strArr3.length - 1);
            }
            NumberPicker numberPicker4 = this.mSmartModePicker;
            if (numberPicker4 != null) {
                numberPicker4.setMinValue(0);
            }
            NumberPicker numberPicker5 = this.mSmartModePicker;
            if (numberPicker5 != null) {
                numberPicker5.setWrapSelectorWheel(false);
            }
            DeviceModeEntity.SmartCoolModeCombine forPref = DeviceModeEntity.SmartCoolModeCombine.Companion.forPref(this.coolPref);
            if (forPref != null) {
                CustomFontTextView customFontTextView = this.mSmartModeLevelView;
                if (customFontTextView != null) {
                    String[] strArr4 = this.mSmartCoolModeEntry;
                    if (strArr4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSmartCoolModeEntry");
                    } else {
                        strArr = strArr4;
                    }
                    customFontTextView.setText(strArr[forPref.ordinal()]);
                }
                NumberPicker numberPicker6 = this.mSmartModePicker;
                if (numberPicker6 != null) {
                    numberPicker6.setValue(forPref.ordinal());
                }
                this.mCurrentSmartPreference = forPref.getPref();
            }
        } else {
            NumberPicker numberPicker7 = this.mSmartModePicker;
            if (numberPicker7 != null) {
                String[] strArr5 = this.mSmartWarmModeEntry;
                if (strArr5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSmartWarmModeEntry");
                    strArr5 = null;
                }
                numberPicker7.setDisplayedValues(strArr5);
            }
            NumberPicker numberPicker8 = this.mSmartModePicker;
            if (numberPicker8 != null) {
                String[] strArr6 = this.mSmartWarmModeEntry;
                if (strArr6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSmartWarmModeEntry");
                    strArr6 = null;
                }
                numberPicker8.setMaxValue(strArr6.length - 1);
            }
            NumberPicker numberPicker9 = this.mSmartModePicker;
            if (numberPicker9 != null) {
                numberPicker9.setMinValue(0);
            }
            NumberPicker numberPicker10 = this.mSmartModePicker;
            if (numberPicker10 != null) {
                numberPicker10.setWrapSelectorWheel(false);
            }
            DeviceModeEntity.SmartWarmModeCombine forPref2 = DeviceModeEntity.SmartWarmModeCombine.Companion.forPref(this.warmPref);
            if (forPref2 != null) {
                CustomFontTextView customFontTextView2 = this.mSmartModeLevelView;
                if (customFontTextView2 != null) {
                    String[] strArr7 = this.mSmartWarmModeEntry;
                    if (strArr7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSmartWarmModeEntry");
                    } else {
                        strArr = strArr7;
                    }
                    customFontTextView2.setText(strArr[forPref2.ordinal()]);
                }
                NumberPicker numberPicker11 = this.mSmartModePicker;
                if (numberPicker11 != null) {
                    numberPicker11.setValue(forPref2.ordinal());
                }
                this.mCurrentSmartPreference = forPref2.getPref();
            }
        }
        NumberPicker numberPicker12 = this.mSmartModePicker;
        if (numberPicker12 != null) {
            numberPicker12.setOnValueChangedListener(this);
        }
    }

    private final void compButtonTapped() {
        FragmentTransaction beginTransaction;
        FragmentTransaction remove;
        SmartModeSelectListener smartModeSelectListener = (SmartModeSelectListener) getCallback$app_prodRelease();
        if (smartModeSelectListener != null) {
            smartModeSelectListener.onSmartModeSelected(this.coolPref, this.warmPref, this.mIsCoolMode, this.mCurrentSwitchCoolTemp, this.mCurrentSwitchWarmTemp);
        }
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && (beginTransaction = fragmentManager.beginTransaction()) != null && (remove = beginTransaction.remove(this)) != null) {
            remove.commit();
        }
    }

    private final void smartCoolButtonTapped() {
        if (!this.mIsCoolMode) {
            changeMode(true);
        }
    }

    private final void smartWarmButtonTapped() {
        if (this.mIsCoolMode) {
            changeMode(false);
        }
    }

    private final void changeMode(boolean z) {
        this.mIsCoolMode = z;
        Button button = this.mSmartCoolButton;
        if (button != null) {
            button.setEnabled(!z);
        }
        Button button2 = this.mSmartWarmButton;
        if (button2 != null) {
            button2.setEnabled(z);
        }
        changeModePicker();
    }
}
