package jp.co.sony.reonpocket.modules.main.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.lang.ref.WeakReference;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.constant.SmartModePreference;
import jp.co.sony.reonpocket.data.entity.DeviceModeEntity;
import jp.co.sony.reonpocket.modules.base.view.BaseFragment;
import jp.co.sony.reonpocket.view.CustomFontButton;
import jp.co.sony.reonpocket.view.CustomFontTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0002$%B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J&\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\"\u0010\u001f\u001a\u00020\u00152\b\u0010 \u001a\u0004\u0018\u00010\u00122\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX.¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainSmartCoolModeSettingFragment;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment;", "Landroid/widget/NumberPicker$OnValueChangeListener;", "()V", "isSmartCool", "", "mCurrentSmartModePreference", "Ljp/co/sony/reonpocket/constant/SmartModePreference;", "mMainActivity", "Ljava/lang/ref/WeakReference;", "Ljp/co/sony/reonpocket/modules/main/view/MainActivity;", "mSmartModeEntry", "", "", "[Ljava/lang/String;", "mSmartModeLevelView", "Ljp/co/sony/reonpocket/view/CustomFontTextView;", "mSmartModePicker", "Landroid/widget/NumberPicker;", "pref", "initUi", "", "aView", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onValueChange", "picker", "oldVal", "", "newVal", "Companion", "SmartModePreferenceSelectListener", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainSmartCoolModeSettingFragment.kt */
public final class MainSmartCoolModeSettingFragment extends BaseFragment implements NumberPicker.OnValueChangeListener {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String IS_SMART_COOL = "isSmartCool";
    private static final String SMART_MODE_PREF = "smartModePreference";
    private boolean isSmartCool;
    private SmartModePreference mCurrentSmartModePreference = SmartModePreference.OFF;
    private WeakReference<MainActivity> mMainActivity;
    private String[] mSmartModeEntry;
    private CustomFontTextView mSmartModeLevelView;
    private NumberPicker mSmartModePicker;
    private SmartModePreference pref = SmartModePreference.WEAK;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainSmartCoolModeSettingFragment$SmartModePreferenceSelectListener;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment$Callback;", "onSelected", "", "smartModePreference", "Ljp/co/sony/reonpocket/constant/SmartModePreference;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainSmartCoolModeSettingFragment.kt */
    public interface SmartModePreferenceSelectListener extends BaseFragment.Callback {
        void onSelected(SmartModePreference smartModePreference);
    }

    @JvmStatic
    public static final MainSmartCoolModeSettingFragment newInstance(SmartModePreference smartModePreference, boolean z) {
        return Companion.newInstance(smartModePreference, z);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainSmartCoolModeSettingFragment$Companion;", "", "()V", "IS_SMART_COOL", "", "SMART_MODE_PREF", "newInstance", "Ljp/co/sony/reonpocket/modules/main/view/MainSmartCoolModeSettingFragment;", "pref", "Ljp/co/sony/reonpocket/constant/SmartModePreference;", "isSmartCool", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainSmartCoolModeSettingFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MainSmartCoolModeSettingFragment newInstance(SmartModePreference smartModePreference, boolean z) {
            Intrinsics.checkNotNullParameter(smartModePreference, "pref");
            MainSmartCoolModeSettingFragment mainSmartCoolModeSettingFragment = new MainSmartCoolModeSettingFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(MainSmartCoolModeSettingFragment.SMART_MODE_PREF, smartModePreference.getCode());
            bundle.putBoolean(MainSmartCoolModeSettingFragment.IS_SMART_COOL, z);
            mainSmartCoolModeSettingFragment.setArguments(bundle);
            return mainSmartCoolModeSettingFragment;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Bundle arguments = getArguments();
        SmartModePreference smartModePreference = null;
        if (arguments == null) {
            return null;
        }
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
            smartModePreference = SmartModePreference.OFF;
        }
        this.pref = smartModePreference;
        this.isSmartCool = arguments.getBoolean(IS_SMART_COOL);
        View inflate = layoutInflater.inflate(R.layout.fragment_smart_setting, viewGroup, false);
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type jp.co.sony.reonpocket.modules.main.view.MainActivity");
        this.mMainActivity = new WeakReference<>((MainActivity) activity);
        Intrinsics.checkNotNull(inflate);
        initUi(inflate);
        return inflate;
    }

    private final void initUi(View view) {
        String[] strArr;
        DeviceModeEntity.SmartWarmModeCombine smartWarmModeCombine;
        DeviceModeEntity.SmartCoolModeCombine smartCoolModeCombine;
        this.mSmartModePicker = (NumberPicker) view.findViewById(R.id.numberPicker);
        View findViewById = view.findViewById(R.id.smart_setting_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        CustomFontTextView customFontTextView = (CustomFontTextView) findViewById;
        if (this.isSmartCool) {
            NumberPicker numberPicker = this.mSmartModePicker;
            if (numberPicker != null) {
                numberPicker.setDisplayedValues(getResources().getStringArray(R.array.mainview_smart_favorite_cool_step_array));
            }
            customFontTextView.setText(R.string.mainview_smart_favorite_cool_description);
        } else {
            NumberPicker numberPicker2 = this.mSmartModePicker;
            if (numberPicker2 != null) {
                numberPicker2.setDisplayedValues(getResources().getStringArray(R.array.mainview_smart_favorite_warm_step_array));
            }
            customFontTextView.setText(R.string.mainview_smart_favorite_warm_description);
        }
        NumberPicker numberPicker3 = this.mSmartModePicker;
        if (numberPicker3 != null) {
            numberPicker3.setMaxValue(4);
        }
        NumberPicker numberPicker4 = this.mSmartModePicker;
        int i = 0;
        if (numberPicker4 != null) {
            numberPicker4.setMinValue(0);
        }
        NumberPicker numberPicker5 = this.mSmartModePicker;
        if (numberPicker5 != null) {
            numberPicker5.setWrapSelectorWheel(false);
        }
        if (this.isSmartCool) {
            strArr = getResources().getStringArray(R.array.mainview_smart_favorite_cool_step_array);
            Intrinsics.checkNotNull(strArr);
        } else {
            strArr = getResources().getStringArray(R.array.mainview_smart_favorite_warm_step_array);
            Intrinsics.checkNotNull(strArr);
        }
        this.mSmartModeEntry = strArr;
        view.findViewById(R.id.smart_setting_space).setOnClickListener(new MainSmartCoolModeSettingFragment$$ExternalSyntheticLambda0(this));
        String[] strArr2 = null;
        if (this.isSmartCool) {
            DeviceModeEntity.SmartCoolModeCombine[] values = DeviceModeEntity.SmartCoolModeCombine.values();
            int length = values.length;
            while (true) {
                if (i >= length) {
                    smartCoolModeCombine = null;
                    break;
                }
                smartCoolModeCombine = values[i];
                if (this.pref == smartCoolModeCombine.getPref()) {
                    break;
                }
                i++;
            }
            if (smartCoolModeCombine != null) {
                CustomFontTextView customFontTextView2 = this.mSmartModeLevelView;
                if (customFontTextView2 != null) {
                    String[] strArr3 = this.mSmartModeEntry;
                    if (strArr3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSmartModeEntry");
                    } else {
                        strArr2 = strArr3;
                    }
                    customFontTextView2.setText(strArr2[smartCoolModeCombine.ordinal()]);
                }
                NumberPicker numberPicker6 = this.mSmartModePicker;
                if (numberPicker6 != null) {
                    numberPicker6.setValue(smartCoolModeCombine.ordinal());
                }
                this.mCurrentSmartModePreference = smartCoolModeCombine.getPref();
            }
        } else {
            DeviceModeEntity.SmartWarmModeCombine[] values2 = DeviceModeEntity.SmartWarmModeCombine.values();
            int length2 = values2.length;
            while (true) {
                if (i >= length2) {
                    smartWarmModeCombine = null;
                    break;
                }
                smartWarmModeCombine = values2[i];
                if (this.pref == smartWarmModeCombine.getPref()) {
                    break;
                }
                i++;
            }
            if (smartWarmModeCombine != null) {
                CustomFontTextView customFontTextView3 = this.mSmartModeLevelView;
                if (customFontTextView3 != null) {
                    String[] strArr4 = this.mSmartModeEntry;
                    if (strArr4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSmartModeEntry");
                    } else {
                        strArr2 = strArr4;
                    }
                    customFontTextView3.setText(strArr2[smartWarmModeCombine.ordinal()]);
                }
                NumberPicker numberPicker7 = this.mSmartModePicker;
                if (numberPicker7 != null) {
                    numberPicker7.setValue(smartWarmModeCombine.ordinal());
                }
                this.mCurrentSmartModePreference = smartWarmModeCombine.getPref();
            }
        }
        ((CustomFontButton) view.findViewById(R.id.do_setting)).setOnClickListener(new MainSmartCoolModeSettingFragment$$ExternalSyntheticLambda1(this));
        NumberPicker numberPicker8 = this.mSmartModePicker;
        if (numberPicker8 != null) {
            numberPicker8.setOnValueChangedListener(this);
        }
    }

    /* access modifiers changed from: private */
    public static final void initUi$lambda$1(MainSmartCoolModeSettingFragment mainSmartCoolModeSettingFragment, View view) {
        FragmentTransaction beginTransaction;
        FragmentTransaction remove;
        Intrinsics.checkNotNullParameter(mainSmartCoolModeSettingFragment, "this$0");
        FragmentManager fragmentManager = mainSmartCoolModeSettingFragment.getFragmentManager();
        if (fragmentManager != null && (beginTransaction = fragmentManager.beginTransaction()) != null && (remove = beginTransaction.remove(mainSmartCoolModeSettingFragment)) != null) {
            remove.commit();
        }
    }

    /* access modifiers changed from: private */
    public static final void initUi$lambda$7$lambda$6(MainSmartCoolModeSettingFragment mainSmartCoolModeSettingFragment, View view) {
        FragmentTransaction beginTransaction;
        FragmentTransaction remove;
        Intrinsics.checkNotNullParameter(mainSmartCoolModeSettingFragment, "this$0");
        SmartModePreferenceSelectListener smartModePreferenceSelectListener = (SmartModePreferenceSelectListener) mainSmartCoolModeSettingFragment.getCallback$app_prodRelease();
        if (smartModePreferenceSelectListener != null) {
            smartModePreferenceSelectListener.onSelected(mainSmartCoolModeSettingFragment.mCurrentSmartModePreference);
        }
        FragmentManager fragmentManager = mainSmartCoolModeSettingFragment.getFragmentManager();
        if (fragmentManager != null && (beginTransaction = fragmentManager.beginTransaction()) != null && (remove = beginTransaction.remove(mainSmartCoolModeSettingFragment)) != null) {
            remove.commit();
        }
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
            boolean r5 = r4.isSmartCool
            r6 = 0
            r0 = 0
            if (r5 == 0) goto L_0x0023
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
            if (r6 == 0) goto L_0x003f
            jp.co.sony.reonpocket.constant.SmartModePreference r5 = r6.getPref()
            r4.mCurrentSmartModePreference = r5
            goto L_0x003f
        L_0x0023:
            jp.co.sony.reonpocket.data.entity.DeviceModeEntity$SmartWarmModeCombine[] r5 = jp.co.sony.reonpocket.data.entity.DeviceModeEntity.SmartWarmModeCombine.values()
            int r1 = r5.length
        L_0x0028:
            if (r0 >= r1) goto L_0x0037
            r2 = r5[r0]
            int r3 = r2.ordinal()
            if (r7 != r3) goto L_0x0034
            r6 = r2
            goto L_0x0037
        L_0x0034:
            int r0 = r0 + 1
            goto L_0x0028
        L_0x0037:
            if (r6 == 0) goto L_0x003f
            jp.co.sony.reonpocket.constant.SmartModePreference r5 = r6.getPref()
            r4.mCurrentSmartModePreference = r5
        L_0x003f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.main.view.MainSmartCoolModeSettingFragment.onValueChange(android.widget.NumberPicker, int, int):void");
    }
}
