package jp.co.sony.reonpocket.modules.main.view;

import androidx.appcompat.widget.AppCompatToggleButton;
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
import jp.co.sony.reonpocket.data.entity.DeviceModeEntity;
import jp.co.sony.reonpocket.modules.main.view.MainWarmFragment;
import jp.co.sony.reonpocket.view.CustomFontTextView;
import jp.co.sony.reonpocket.view.CustomSlideView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"jp/co/sony/reonpocket/modules/main/view/MainWarmFragment$initView$5", "Ljp/co/sony/reonpocket/view/CustomSlideView$OnSlideListener;", "onSlideChange", "", "pos", "", "onSlideFinish", "onSlideStart", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainWarmFragment.kt */
public final class MainWarmFragment$initView$5 implements CustomSlideView.OnSlideListener {
    final /* synthetic */ boolean $isSupportCoolStep4;
    final /* synthetic */ MainWarmFragment this$0;

    public void onSlideFinish(int i) {
    }

    public void onSlideStart(int i) {
    }

    MainWarmFragment$initView$5(MainWarmFragment mainWarmFragment, boolean z) {
        this.this$0 = mainWarmFragment;
        this.$isSupportCoolStep4 = z;
    }

    public void onSlideChange(int i) {
        TempStepCode tempStepCode;
        TempStepCode tempStepCode2;
        int i2 = i;
        CustomFontTextView access$getMCountDownTextView$p = this.this$0.mCountDownTextView;
        if (access$getMCountDownTextView$p != null) {
            access$getMCountDownTextView$p.setVisibility(4);
        }
        this.this$0.mCurrentLevel = i2;
        int size = this.this$0.mToggleButtonList.size();
        int i3 = 0;
        while (true) {
            boolean z = true;
            if (i3 >= size) {
                break;
            }
            AppCompatToggleButton appCompatToggleButton = (AppCompatToggleButton) this.this$0.mToggleButtonList.get(i3);
            if (i2 <= i3) {
                z = false;
            }
            appCompatToggleButton.setChecked(z);
            i3++;
        }
        MainWarmViewOutput mainWarmViewOutput = null;
        if (this.this$0.mCurrentLevel - 1 != MainWarmFragment.WarmLevel.BOOST.ordinal()) {
            TempStepCode[] values = TempStepCode.values();
            MainWarmFragment mainWarmFragment = this.this$0;
            int length = values.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    tempStepCode = null;
                    break;
                }
                TempStepCode tempStepCode3 = values[i4];
                if (tempStepCode3.ordinal() == mainWarmFragment.mCurrentLevel) {
                    tempStepCode = tempStepCode3;
                    break;
                }
                i4++;
            }
            if (tempStepCode != null) {
                MainWarmFragment mainWarmFragment2 = this.this$0;
                MainWarmViewOutput access$getMOutput$p = mainWarmFragment2.mOutput;
                if (access$getMOutput$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mOutput");
                } else {
                    mainWarmViewOutput = access$getMOutput$p;
                }
                mainWarmViewOutput.updateWarmLevel(tempStepCode);
                mainWarmFragment2.mTempSettingValue = tempStepCode.getCode();
                mainWarmFragment2.updateDeviceModeInfo(new DeviceModeEntity(DeviceModeActionCode.MANUAL, DeviceModeSettingTriggerCode.SET_DEVICE_MODE, (DeviceCoolingCode) null, (ContinuousOperationStatus) null, (SwitchCoolHeatWaitStatus) null, CoolHeatTypeCode.HEAT, (DeviceModeEntity.Temperature) null, (ModeCommonSettingOperation) null, (Integer) null, tempStepCode, TempBoostOption.NONE, TempWaveOption.WAVE_OFF, 0, 0, 0, (MyModeActionType) null, (MyModeSpecialSubMode) null, (Integer) null, (Integer) null, (MyModeOperationCode) null, (Integer) null, (MyModeTypeCode) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyTempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (FanStepCode) null, -32292, 63, (DefaultConstructorMarker) null));
            }
        } else if (this.$isSupportCoolStep4) {
            MainWarmViewOutput access$getMOutput$p2 = this.this$0.mOutput;
            if (access$getMOutput$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOutput");
            } else {
                mainWarmViewOutput = access$getMOutput$p2;
            }
            mainWarmViewOutput.updateWarmLevel(TempStepCode.STEP_4);
            this.this$0.mTempSettingValue = TempStepCode.STEP_4.getCode();
            this.this$0.updateDeviceModeInfo(new DeviceModeEntity(DeviceModeActionCode.MANUAL, DeviceModeSettingTriggerCode.SET_DEVICE_MODE, (DeviceCoolingCode) null, (ContinuousOperationStatus) null, (SwitchCoolHeatWaitStatus) null, CoolHeatTypeCode.HEAT, (DeviceModeEntity.Temperature) null, (ModeCommonSettingOperation) null, (Integer) null, TempStepCode.STEP_4, TempBoostOption.NONE, TempWaveOption.WAVE_OFF, 0, 0, 0, (MyModeActionType) null, (MyModeSpecialSubMode) null, (Integer) null, (Integer) null, (MyModeOperationCode) null, (Integer) null, (MyModeTypeCode) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyTempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (FanStepCode) null, -32292, 63, (DefaultConstructorMarker) null));
        } else {
            MainWarmViewOutput access$getMOutput$p3 = this.this$0.mOutput;
            if (access$getMOutput$p3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOutput");
                access$getMOutput$p3 = null;
            }
            access$getMOutput$p3.setWarmBoost();
            TempStepCode[] values2 = TempStepCode.values();
            MainWarmFragment mainWarmFragment3 = this.this$0;
            int length2 = values2.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length2) {
                    tempStepCode2 = null;
                    break;
                }
                tempStepCode2 = values2[i5];
                if (tempStepCode2.ordinal() == mainWarmFragment3.mTempSettingValue) {
                    break;
                }
                i5++;
            }
            this.this$0.updateDeviceModeInfo(new DeviceModeEntity(DeviceModeActionCode.MANUAL, DeviceModeSettingTriggerCode.SET_DEVICE_MODE, (DeviceCoolingCode) null, (ContinuousOperationStatus) null, (SwitchCoolHeatWaitStatus) null, CoolHeatTypeCode.HEAT, (DeviceModeEntity.Temperature) null, (ModeCommonSettingOperation) null, (Integer) null, tempStepCode2 != null ? tempStepCode2 : null, TempBoostOption.BOOST, TempWaveOption.WAVE_OFF, 0, 0, 0, (MyModeActionType) null, (MyModeSpecialSubMode) null, (Integer) null, (Integer) null, (MyModeOperationCode) null, (Integer) null, (MyModeTypeCode) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyTempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (FanStepCode) null, -32292, 63, (DefaultConstructorMarker) null));
        }
    }
}
