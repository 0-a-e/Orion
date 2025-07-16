package jp.co.sony.reonpocket.modules.autoStart.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.fragment.app.Fragment;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.constant.AutoStartDeviceModeActionCode;
import jp.co.sony.reonpocket.constant.AutoStartOperationCode;
import jp.co.sony.reonpocket.constant.CoolHeatTypeCode;
import jp.co.sony.reonpocket.constant.SmartModePreference;
import jp.co.sony.reonpocket.constant.TempBoostOption;
import jp.co.sony.reonpocket.constant.TempWaveOption;
import jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode;
import jp.co.sony.reonpocket.data.entity.AutoStartEntity;
import jp.co.sony.reonpocket.databinding.FragmentAutoStartBinding;
import jp.co.sony.reonpocket.databinding.ViewPreferenceDescriptionBinding;
import jp.co.sony.reonpocket.databinding.ViewPreferenceSwitchBinding;
import jp.co.sony.reonpocket.modules.base.view.BaseFragment;
import jp.co.sony.reonpocket.util.DialogHelperUtil;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0002#$B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0012\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\"\u001a\u00020\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Ljp/co/sony/reonpocket/modules/autoStart/view/AutoStartFragment;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "()V", "binding", "Ljp/co/sony/reonpocket/databinding/FragmentAutoStartBinding;", "mDeviceModeActionCode", "Ljp/co/sony/reonpocket/constant/AutoStartDeviceModeActionCode;", "mDialogHelper", "Ljp/co/sony/reonpocket/util/DialogHelperUtil;", "mLastModeSwitch", "Landroid/widget/Switch;", "mOperationCode", "Ljp/co/sony/reonpocket/constant/AutoStartOperationCode;", "doSetting", "", "doUpdate", "aAutoStartEntity", "Ljp/co/sony/reonpocket/data/entity/AutoStartEntity;", "initUi", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCheckedChanged", "buttonView", "Landroid/widget/CompoundButton;", "isChecked", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "Companion", "OnSettingListener", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AutoStartFragment.kt */
public final class AutoStartFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int LAST_SWITCH_ID = 0;
    private FragmentAutoStartBinding binding;
    private final AutoStartDeviceModeActionCode mDeviceModeActionCode = AutoStartDeviceModeActionCode.LAST_MODE;
    private DialogHelperUtil mDialogHelper;
    private Switch mLastModeSwitch;
    private AutoStartOperationCode mOperationCode = AutoStartOperationCode.CTRL_REGIST;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/modules/autoStart/view/AutoStartFragment$OnSettingListener;", "Ljp/co/sony/reonpocket/modules/base/view/BaseFragment$Callback;", "onDone", "", "aAutoStartEntity", "Ljp/co/sony/reonpocket/data/entity/AutoStartEntity;", "onRequestDataInit", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: AutoStartFragment.kt */
    public interface OnSettingListener extends BaseFragment.Callback {
        void onDone(AutoStartEntity autoStartEntity);

        void onRequestDataInit();
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: AutoStartFragment.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                jp.co.sony.reonpocket.constant.AutoStartOperationCode[] r0 = jp.co.sony.reonpocket.constant.AutoStartOperationCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.AutoStartOperationCode r1 = jp.co.sony.reonpocket.constant.AutoStartOperationCode.CTRL_REGIST     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                jp.co.sony.reonpocket.constant.AutoStartOperationCode r1 = jp.co.sony.reonpocket.constant.AutoStartOperationCode.CTRL_CLEAR     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.autoStart.view.AutoStartFragment.WhenMappings.<clinit>():void");
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/modules/autoStart/view/AutoStartFragment$Companion;", "", "()V", "LAST_SWITCH_ID", "", "newInstance", "Ljp/co/sony/reonpocket/modules/autoStart/view/AutoStartFragment;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: AutoStartFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AutoStartFragment newInstance() {
            return new AutoStartFragment();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentAutoStartBinding inflate = FragmentAutoStartBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        this.mDialogHelper = DialogHelperUtil.Companion.newInstance((Fragment) this);
        initUi(inflate);
        return inflate.getRoot();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        OnSettingListener onSettingListener = (OnSettingListener) getCallback$app_prodRelease();
        if (onSettingListener != null) {
            onSettingListener.onRequestDataInit();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    private final void initUi(FragmentAutoStartBinding fragmentAutoStartBinding) {
        if (((OnSettingListener) getCallback$app_prodRelease()) != null) {
            ViewPreferenceSwitchBinding viewPreferenceSwitchBinding = fragmentAutoStartBinding.lastModeItem;
            Intrinsics.checkNotNullExpressionValue(viewPreferenceSwitchBinding, "lastModeItem");
            fragmentAutoStartBinding.headerDescriptionStub.setOnInflateListener(new AutoStartFragment$$ExternalSyntheticLambda0(this));
            fragmentAutoStartBinding.headerDescriptionStub.inflate();
            viewPreferenceSwitchBinding.listTitle.setText(getString(R.string.setting_auto_start_setting_title));
            viewPreferenceSwitchBinding.listSubTitle.setVisibility(8);
            Switch switchR = viewPreferenceSwitchBinding.listSwitch;
            Intrinsics.checkNotNullExpressionValue(switchR, "listSwitch");
            this.mLastModeSwitch = switchR;
            Switch switchR2 = null;
            if (switchR == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLastModeSwitch");
                switchR = null;
            }
            switchR.setId(0);
            Switch switchR3 = this.mLastModeSwitch;
            if (switchR3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLastModeSwitch");
            } else {
                switchR2 = switchR3;
            }
            switchR2.setOnCheckedChangeListener(this);
        }
    }

    /* access modifiers changed from: private */
    public static final void initUi$lambda$0(AutoStartFragment autoStartFragment, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(autoStartFragment, "this$0");
        ViewPreferenceDescriptionBinding bind = ViewPreferenceDescriptionBinding.bind(view);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        bind.description.setText(autoStartFragment.getString(R.string.setting_auto_start_description));
    }

    public final void doUpdate(AutoStartEntity autoStartEntity) {
        Intrinsics.checkNotNullParameter(autoStartEntity, "aAutoStartEntity");
        if (autoStartEntity.getOperationCode() == AutoStartOperationCode.CTRL_CLEAR || autoStartEntity.getCoolHeatType() == CoolHeatTypeCode.OFF_COOL || autoStartEntity.getCoolHeatType() == CoolHeatTypeCode.OFF_HEAT) {
            this.mOperationCode = AutoStartOperationCode.CTRL_CLEAR;
        } else if (autoStartEntity.getOperationCode() != null) {
            this.mOperationCode = autoStartEntity.getOperationCode();
            Switch switchR = this.mLastModeSwitch;
            if (switchR == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLastModeSwitch");
                switchR = null;
            }
            int i = WhenMappings.$EnumSwitchMapping$0[this.mOperationCode.ordinal()];
            boolean z = true;
            if (i != 1) {
                if (i == 2) {
                    z = false;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            switchR.setChecked(z);
        }
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton != null && compoundButton.getId() == 0) {
            if (z) {
                this.mOperationCode = AutoStartOperationCode.CTRL_REGIST;
            } else {
                this.mOperationCode = AutoStartOperationCode.CTRL_CLEAR;
            }
        }
    }

    public final void doSetting() {
        AutoStartOperationCode autoStartOperationCode = this.mOperationCode;
        AutoStartDeviceModeActionCode autoStartDeviceModeActionCode = this.mDeviceModeActionCode;
        AutoStartEntity autoStartEntity = r1;
        AutoStartEntity autoStartEntity2 = new AutoStartEntity(autoStartOperationCode, autoStartDeviceModeActionCode, (Integer) null, (CoolHeatTypeCode) null, (TemperatureCoolHeatTypeCode) null, (Integer) null, (SmartModePreference) null, (SmartModePreference) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, 4092, (DefaultConstructorMarker) null);
        OnSettingListener onSettingListener = (OnSettingListener) getCallback$app_prodRelease();
        if (onSettingListener != null) {
            onSettingListener.onDone(autoStartEntity);
        }
    }
}
