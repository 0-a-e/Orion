package jp.co.sony.reonpocket.modules.main.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.transition.Slide;
import androidx.transition.TransitionSet;
import androidx.viewpager.widget.ViewPager;
import com.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider;
import com.google.android.gms.tasks.Task;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import java.io.Serializable;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.constant.AutoModeStatus;
import jp.co.sony.reonpocket.constant.BatteryChargeStatus;
import jp.co.sony.reonpocket.constant.BleConnStatusCode;
import jp.co.sony.reonpocket.constant.BoostStatus;
import jp.co.sony.reonpocket.constant.ContinuousOperationStatus;
import jp.co.sony.reonpocket.constant.CoolBoost;
import jp.co.sony.reonpocket.constant.CoolHeatTypeCode;
import jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode;
import jp.co.sony.reonpocket.constant.DeviceCoolingCode;
import jp.co.sony.reonpocket.constant.DeviceInfoConstants;
import jp.co.sony.reonpocket.constant.DeviceModeActionCode;
import jp.co.sony.reonpocket.constant.DeviceModeSettingTriggerCode;
import jp.co.sony.reonpocket.constant.FanStepCode;
import jp.co.sony.reonpocket.constant.ModeCommonSettingOperation;
import jp.co.sony.reonpocket.constant.MyModeActionType;
import jp.co.sony.reonpocket.constant.MyModeOperationCode;
import jp.co.sony.reonpocket.constant.MyModeSpecialSubMode;
import jp.co.sony.reonpocket.constant.MyModeTypeCode;
import jp.co.sony.reonpocket.constant.MyTempStepCode;
import jp.co.sony.reonpocket.constant.NotificationId;
import jp.co.sony.reonpocket.constant.PowerSupplyStatus;
import jp.co.sony.reonpocket.constant.SmartModePreference;
import jp.co.sony.reonpocket.constant.SwitchCoolHeatWaitStatus;
import jp.co.sony.reonpocket.constant.SwitchingTrigger1;
import jp.co.sony.reonpocket.constant.SwitchingTrigger2;
import jp.co.sony.reonpocket.constant.TagFuncLimit;
import jp.co.sony.reonpocket.constant.TargetTempControlFactorALS;
import jp.co.sony.reonpocket.constant.TargetTempControlFactorAction;
import jp.co.sony.reonpocket.constant.TargetTempControlFactorBoost;
import jp.co.sony.reonpocket.constant.TargetTempControlFactorClothesTemp;
import jp.co.sony.reonpocket.constant.TargetTempControlFactorEnvironment;
import jp.co.sony.reonpocket.constant.TargetTempControlStatus;
import jp.co.sony.reonpocket.constant.TempBoostOption;
import jp.co.sony.reonpocket.constant.TempStepCode;
import jp.co.sony.reonpocket.constant.TempWaveOption;
import jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode;
import jp.co.sony.reonpocket.constant.TemperatureOnOffCode;
import jp.co.sony.reonpocket.constant.UpdateVersionConstant;
import jp.co.sony.reonpocket.data.entity.BatteryEntity;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import jp.co.sony.reonpocket.data.entity.Capability1;
import jp.co.sony.reonpocket.data.entity.CapabilityEntity;
import jp.co.sony.reonpocket.data.entity.DeviceModeEntity;
import jp.co.sony.reonpocket.data.entity.DeviceModeEntityKt;
import jp.co.sony.reonpocket.data.entity.NotificationEntity;
import jp.co.sony.reonpocket.data.entity.NotifyDeviceSensorDataEntity;
import jp.co.sony.reonpocket.data.entity.NotifyTagSensorDataEntity;
import jp.co.sony.reonpocket.data.entity.ThermoControlStatusEntity;
import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.data.interactor.TagInfoInteractor;
import jp.co.sony.reonpocket.data.interactor.TagInfoInteractorInput;
import jp.co.sony.reonpocket.data.interactor.TagScanInteractor;
import jp.co.sony.reonpocket.modules.base.view.BaseActivity;
import jp.co.sony.reonpocket.modules.base.view.BaseActivityKt;
import jp.co.sony.reonpocket.modules.base.view.BaseViewOutput;
import jp.co.sony.reonpocket.modules.connect.view.ConnectionActivity;
import jp.co.sony.reonpocket.modules.main.presenter.MainPresenter;
import jp.co.sony.reonpocket.modules.main.view.MainCoolFragment;
import jp.co.sony.reonpocket.modules.main.view.MainSmartCoolModeFragment;
import jp.co.sony.reonpocket.modules.main.view.MainSmartCoolModeSettingFragment;
import jp.co.sony.reonpocket.modules.main.view.MainSmartModeFragment;
import jp.co.sony.reonpocket.modules.main.view.MainSmartModeSettingFragment;
import jp.co.sony.reonpocket.modules.main.view.MainSmartSettingSwitchingTempFragment;
import jp.co.sony.reonpocket.modules.main.view.MainSmartWarmFragment;
import jp.co.sony.reonpocket.modules.main.view.MainWarmFragment;
import jp.co.sony.reonpocket.modules.pairing.view.PairingActivityKt;
import jp.co.sony.reonpocket.modules.settings.view.SettingActivity;
import jp.co.sony.reonpocket.util.AnalyticsUtil;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.util.DialogBuilderUtil;
import jp.co.sony.reonpocket.util.DialogHelperUtil;
import jp.co.sony.reonpocket.util.LockableBottomSheetBehavior;
import jp.co.sony.reonpocket.util.PermissionUtil;
import jp.co.sony.reonpocket.util.RemoteConfigUtil;
import jp.co.sony.reonpocket.util.SafeArray;
import jp.co.sony.reonpocket.view.CustomDebugStatusView;
import jp.co.sony.reonpocket.view.CustomFontTextView;
import jp.co.sony.reonpocket.view.CustomImageView;
import jp.co.sony.reonpocket.view.CustomViewPager;
import jp.co.sony.reonpocket.view.DeviceTemperatureView;
import jp.co.sony.reonpocket.view.TagMiniInfoView;
import jp.co.sony.reonpocket.view.TagMiniInfoViewOutput;
import jp.co.sony.reonpocket.view.fragment.AlertDialogFragment;
import jp.co.sony.reonpocket.view.fragment.BaseDialogFragment;
import jp.co.sony.reonpocket.view.fragment.DataDialogFragment;
import jp.co.sony.reonpocket.view.fragment.ProgressDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f*\u0001*\b\u0007\u0018\u0000 \u00032\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n:\u0006\u0003\u0003\u0003B\u0005¢\u0006\u0002\u0010\u000bJ\n\u0010¢\u0001\u001a\u00030£\u0001H\u0016J\u0013\u0010¤\u0001\u001a\u00030£\u00012\u0007\u0010¥\u0001\u001a\u00020\u0012H\u0002J\u0014\u0010¦\u0001\u001a\u00030£\u00012\b\u0010§\u0001\u001a\u00030¨\u0001H\u0002JD\u0010©\u0001\u001a\u00030ª\u00012\b\u0010«\u0001\u001a\u00030¬\u00012\b\u0010­\u0001\u001a\u00030®\u00012\b\u0010¯\u0001\u001a\u00030°\u00012\b\u0010±\u0001\u001a\u00030°\u00012\u0007\u0010²\u0001\u001a\u00020\r2\u0007\u0010³\u0001\u001a\u00020\rH\u0002J\u0014\u0010´\u0001\u001a\u00030ª\u00012\b\u0010­\u0001\u001a\u00030®\u0001H\u0002J\n\u0010µ\u0001\u001a\u00030£\u0001H\u0016J\t\u0010¶\u0001\u001a\u00020\rH\u0002J\t\u0010·\u0001\u001a\u00020eH\u0016J\t\u0010¸\u0001\u001a\u00020\rH\u0002J\t\u0010¹\u0001\u001a\u00020\rH\u0002J\t\u0010º\u0001\u001a\u00020\rH\u0002J\t\u0010»\u0001\u001a\u00020\rH\u0002J\n\u0010¼\u0001\u001a\u00030£\u0001H\u0002J\n\u0010½\u0001\u001a\u00030£\u0001H\u0016J\n\u0010¾\u0001\u001a\u00030£\u0001H\u0016J\n\u0010¿\u0001\u001a\u00030£\u0001H\u0002J\n\u0010À\u0001\u001a\u00030Á\u0001H\u0016J\n\u0010Â\u0001\u001a\u00030£\u0001H\u0002J\t\u0010Ã\u0001\u001a\u00020\u0012H\u0016J\t\u0010Ä\u0001\u001a\u00020\u0012H\u0016J\t\u0010Å\u0001\u001a\u00020\u0012H\u0014J&\u0010Æ\u0001\u001a\u00030£\u00012\b\u0010Ç\u0001\u001a\u00030È\u00012\u0007\u0010É\u0001\u001a\u00020\r2\u0007\u0010Ê\u0001\u001a\u00020\rH\u0016J\u0014\u0010Ë\u0001\u001a\u00030£\u00012\b\u0010Ì\u0001\u001a\u00030Í\u0001H\u0016J3\u0010Î\u0001\u001a\u00030£\u00012\b\u0010Ï\u0001\u001a\u00030Ð\u00012\u001d\u0010Ñ\u0001\u001a\u0018\u0012\u0004\u0012\u00020E\u0018\u00010Ò\u0001j\u000b\u0012\u0004\u0012\u00020E\u0018\u0001`Ó\u0001H\u0016J\n\u0010Ô\u0001\u001a\u00030£\u0001H\u0002J\u0015\u0010Õ\u0001\u001a\u00030£\u00012\t\u0010Ö\u0001\u001a\u0004\u0018\u00010/H\u0014J\u0013\u0010×\u0001\u001a\u00020\u00122\b\u0010Ø\u0001\u001a\u00030Ù\u0001H\u0016J\u001d\u0010Ú\u0001\u001a\u00030£\u00012\b\u0010Ç\u0001\u001a\u00030È\u00012\u0007\u0010É\u0001\u001a\u00020\rH\u0016J&\u0010Û\u0001\u001a\u00030£\u00012\b\u0010Ç\u0001\u001a\u00030È\u00012\u0007\u0010É\u0001\u001a\u00020\r2\u0007\u0010Ê\u0001\u001a\u00020\rH\u0016J\u001d\u0010Ü\u0001\u001a\u00030£\u00012\b\u0010Ç\u0001\u001a\u00030È\u00012\u0007\u0010É\u0001\u001a\u00020\rH\u0016J\u0013\u0010Ý\u0001\u001a\u00030£\u00012\u0007\u0010Þ\u0001\u001a\u00020EH\u0016J\u0014\u0010ß\u0001\u001a\u00030£\u00012\b\u0010§\u0001\u001a\u00030¨\u0001H\u0014J\u0013\u0010à\u0001\u001a\u00030£\u00012\u0007\u0010á\u0001\u001a\u00020\rH\u0016J%\u0010â\u0001\u001a\u00030£\u00012\u0007\u0010á\u0001\u001a\u00020\r2\u0007\u0010ã\u0001\u001a\u00020\u000f2\u0007\u0010ä\u0001\u001a\u00020\rH\u0016J\u0013\u0010å\u0001\u001a\u00030£\u00012\u0007\u0010æ\u0001\u001a\u00020\rH\u0016J\n\u0010ç\u0001\u001a\u00030£\u0001H\u0014J\u0014\u0010è\u0001\u001a\u00030£\u00012\b\u0010é\u0001\u001a\u00030°\u0001H\u0016J;\u0010ê\u0001\u001a\u00030£\u00012\b\u0010¯\u0001\u001a\u00030°\u00012\b\u0010ë\u0001\u001a\u00030°\u00012\u0007\u0010ì\u0001\u001a\u00020\u00122\b\u0010í\u0001\u001a\u00030î\u00012\b\u0010ï\u0001\u001a\u00030î\u0001H\u0016J\u001e\u0010ð\u0001\u001a\u00030£\u00012\b\u0010í\u0001\u001a\u00030î\u00012\b\u0010ï\u0001\u001a\u00030î\u0001H\u0016J\n\u0010ñ\u0001\u001a\u00030£\u0001H\u0002J\n\u0010ò\u0001\u001a\u00030£\u0001H\u0014J\u0016\u0010ó\u0001\u001a\u00030£\u00012\n\u0010ô\u0001\u001a\u0005\u0018\u00010õ\u0001H\u0016J\u0016\u0010ö\u0001\u001a\u00030£\u00012\n\u0010÷\u0001\u001a\u0005\u0018\u00010õ\u0001H\u0016J\u0016\u0010ø\u0001\u001a\u00030£\u00012\n\u0010ô\u0001\u001a\u0005\u0018\u00010õ\u0001H\u0016J\n\u0010ù\u0001\u001a\u00030£\u0001H\u0002J\b\u0010ú\u0001\u001a\u00030£\u0001J\n\u0010û\u0001\u001a\u00030£\u0001H\u0016J\n\u0010ü\u0001\u001a\u00030£\u0001H\u0003J\u0013\u0010ý\u0001\u001a\u00030£\u00012\u0007\u0010æ\u0001\u001a\u00020\rH\u0002J\u0014\u0010þ\u0001\u001a\u00030£\u00012\b\u0010ÿ\u0001\u001a\u00030\u0002H\u0002J\u0014\u0010\u0002\u001a\u00030£\u00012\b\u0010Ì\u0001\u001a\u00030Í\u0001H\u0002J\n\u0010\u0002\u001a\u00030£\u0001H\u0002J\u0013\u0010\u0002\u001a\u00030£\u00012\u0007\u0010\u0002\u001a\u00020\u0012H\u0016J\u0013\u0010\u0002\u001a\u00030£\u00012\u0007\u0010\u0002\u001a\u00020\u0012H\u0016J\u0013\u0010\u0002\u001a\u00030£\u00012\u0007\u0010\u0002\u001a\u00020\u0012H\u0016J\u0014\u0010\u0002\u001a\u00030£\u00012\b\u0010\u0002\u001a\u00030°\u0001H\u0002J\n\u0010\u0002\u001a\u00030£\u0001H\u0002J\u0016\u0010\u0002\u001a\u00030£\u00012\n\u0010\u0002\u001a\u0005\u0018\u00010°\u0001H\u0016J\u0014\u0010\u0002\u001a\u00030£\u00012\b\u0010\u0002\u001a\u00030î\u0001H\u0016J\n\u0010\u0002\u001a\u00030£\u0001H\u0002J\u001b\u0010\u0002\u001a\u00030£\u00012\t\u0010\u0002\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0003\u0010\u0002J\n\u0010\u0002\u001a\u00030£\u0001H\u0002J\u0014\u0010\u0002\u001a\u00030£\u00012\b\u0010\u0002\u001a\u00030°\u0001H\u0002J\n\u0010\u0002\u001a\u00030£\u0001H\u0002J\u0016\u0010\u0002\u001a\u00030£\u00012\n\u0010\u0002\u001a\u0005\u0018\u00010°\u0001H\u0016J\u0014\u0010\u0002\u001a\u00030£\u00012\b\u0010\u0002\u001a\u00030î\u0001H\u0016J\u0013\u0010\u0002\u001a\u00030£\u00012\u0007\u0010\u0002\u001a\u00020\u0012H\u0016J\u0011\u0010\u0002\u001a\u00030£\u00012\u0007\u0010\u0002\u001a\u00020\rJ\n\u0010\u0002\u001a\u00030£\u0001H\u0002J\n\u0010\u0002\u001a\u00030£\u0001H\u0016J\n\u0010\u0002\u001a\u00030£\u0001H\u0016J\u0013\u0010\u0002\u001a\u00030£\u00012\u0007\u0010 \u0002\u001a\u00020EH\u0002J\n\u0010¡\u0002\u001a\u00030£\u0001H\u0016J\n\u0010¢\u0002\u001a\u00030£\u0001H\u0016J\n\u0010£\u0002\u001a\u00030£\u0001H\u0016J\n\u0010¤\u0002\u001a\u00030£\u0001H\u0002J\n\u0010¥\u0002\u001a\u00030£\u0001H\u0016J\u001d\u0010¦\u0002\u001a\u00030£\u00012\u000b\b\u0003\u0010§\u0002\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0003\u0010¨\u0002J\n\u0010©\u0002\u001a\u00030£\u0001H\u0002J\n\u0010ª\u0002\u001a\u00030£\u0001H\u0016JG\u0010«\u0002\u001a\u00030£\u00012\t\u0010¬\u0002\u001a\u0004\u0018\u00010E2\u0007\u0010­\u0002\u001a\u00020E2\u0007\u0010®\u0002\u001a\u00020E2\u0007\u0010¯\u0002\u001a\u00020E2\t\u0010°\u0002\u001a\u0004\u0018\u00010E2\n\u0010±\u0002\u001a\u0005\u0018\u00010²\u0002H\u0016J\u0018\u0010³\u0002\u001a\u00030£\u00012\f\u0010´\u0002\u001a\u0007\u0012\u0002\b\u00030µ\u0002H\u0002J\n\u0010¶\u0002\u001a\u00030£\u0001H\u0002J\u0013\u0010·\u0002\u001a\u00030£\u00012\u0007\u0010¸\u0002\u001a\u00020\u0012H\u0016J\b\u0010¹\u0002\u001a\u00030£\u0001J\b\u0010º\u0002\u001a\u00030£\u0001J\b\u0010»\u0002\u001a\u00030£\u0001J\b\u0010¼\u0002\u001a\u00030£\u0001J\n\u0010½\u0002\u001a\u00030£\u0001H\u0002J\n\u0010¾\u0002\u001a\u00030£\u0001H\u0016J&\u0010¾\u0002\u001a\u00030£\u00012\u0007\u0010¿\u0002\u001a\u00020E2\b\u0010À\u0002\u001a\u00030Á\u00022\u0007\u0010Â\u0002\u001a\u00020EH\u0016J\u001d\u0010Ã\u0002\u001a\u00030£\u00012\b\u0010À\u0002\u001a\u00030Á\u00022\u0007\u0010Â\u0002\u001a\u00020EH\u0002J\n\u0010Ä\u0002\u001a\u00030£\u0001H\u0016J\n\u0010Å\u0002\u001a\u00030£\u0001H\u0016J\u001c\u0010Æ\u0002\u001a\u00030£\u00012\u0007\u0010Ç\u0002\u001a\u0002012\u0007\u0010È\u0002\u001a\u00020EH\u0002J\n\u0010É\u0002\u001a\u00030£\u0001H\u0002J\b\u0010Ê\u0002\u001a\u00030£\u0001J\u001e\u0010Ë\u0002\u001a\u00030£\u00012\b\u0010Ì\u0002\u001a\u00030Í\u00022\b\u0010ÿ\u0001\u001a\u00030\u0002H\u0016J\u0013\u0010Î\u0002\u001a\u00030£\u00012\u0007\u0010Ï\u0002\u001a\u00020\u0012H\u0002J\u0011\u0010Ð\u0002\u001a\u00030£\u00012\u0007\u0010Ï\u0002\u001a\u00020\u0012J\u0011\u0010Ñ\u0002\u001a\u00030£\u00012\u0007\u0010Ï\u0002\u001a\u00020\u0012J\b\u0010Ò\u0002\u001a\u00030£\u0001J\n\u0010Ó\u0002\u001a\u00030£\u0001H\u0016J\u001e\u0010Ô\u0002\u001a\u00030£\u00012\b\u0010Ì\u0002\u001a\u00030Í\u00022\b\u0010ÿ\u0001\u001a\u00030\u0002H\u0016J\u001b\u0010Õ\u0002\u001a\u00030£\u00012\t\u0010Ö\u0002\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0003\u0010¨\u0002J\n\u0010×\u0002\u001a\u00030£\u0001H\u0002J\t\u0010Ø\u0002\u001a\u00020\rH\u0002J\u0014\u0010Ù\u0002\u001a\u00030£\u00012\b\u0010Ú\u0002\u001a\u00030Û\u0002H\u0016J\n\u0010Ü\u0002\u001a\u00030£\u0001H\u0002J\u0013\u0010Ý\u0002\u001a\u00030£\u00012\u0007\u0010Þ\u0002\u001a\u00020=H\u0016J\u0013\u0010ß\u0002\u001a\u00030£\u00012\u0007\u0010à\u0002\u001a\u00020\u000fH\u0016J\u0013\u0010á\u0002\u001a\u00030£\u00012\u0007\u0010â\u0002\u001a\u00020\rH\u0016J\u0013\u0010ã\u0002\u001a\u00030£\u00012\u0007\u0010ä\u0002\u001a\u00020\u0012H\u0016J\u0013\u0010å\u0002\u001a\u00030£\u00012\u0007\u0010æ\u0002\u001a\u00020\u0012H\u0016J\u0013\u0010ç\u0002\u001a\u00030£\u00012\u0007\u0010è\u0002\u001a\u00020\u0012H\u0016J\u0013\u0010é\u0002\u001a\u00030£\u00012\u0007\u0010ê\u0002\u001a\u00020\u0012H\u0016J\u0013\u0010ë\u0002\u001a\u00030£\u00012\u0007\u0010ì\u0002\u001a\u00020\u0012H\u0016J\u0014\u0010í\u0002\u001a\u00030£\u00012\b\u0010î\u0002\u001a\u00030ï\u0002H\u0016J\u0013\u0010ð\u0002\u001a\u00030£\u00012\u0007\u0010ñ\u0002\u001a\u00020\u0012H\u0002J\u0013\u0010ò\u0002\u001a\u00030£\u00012\u0007\u0010ó\u0002\u001a\u00020\u0012H\u0016J\u0012\u0010ô\u0002\u001a\u00020\r2\u0007\u0010õ\u0002\u001a\u00020\u0012H\u0002J\n\u0010ö\u0002\u001a\u00030£\u0001H\u0016J\u0014\u0010÷\u0002\u001a\u00030£\u00012\b\u0010ø\u0002\u001a\u00030ù\u0002H\u0016J\u0014\u0010÷\u0002\u001a\u00030£\u00012\b\u0010ø\u0002\u001a\u00030ú\u0002H\u0016J\u001f\u0010û\u0002\u001a\u00030£\u00012\n\u0010ø\u0002\u001a\u0005\u0018\u00010\u00012\u0007\u0010ü\u0002\u001a\u00020\u0012H\u0016J\n\u0010ý\u0002\u001a\u00030£\u0001H\u0016J\u001f\u0010ý\u0002\u001a\u00030£\u00012\u0007\u0010þ\u0002\u001a\u00020\u00122\n\u0010ø\u0002\u001a\u0005\u0018\u00010\u0001H\u0016J\u001f\u0010ÿ\u0002\u001a\u00030£\u00012\u0007\u0010þ\u0002\u001a\u00020\u00122\n\u0010ø\u0002\u001a\u0005\u0018\u00010Á\u0002H\u0016J\u0014\u0010\u0003\u001a\u00030£\u00012\b\u0010ø\u0002\u001a\u00030\u0001H\u0016J\n\u0010\u0003\u001a\u00030£\u0001H\u0002J\u0012\u0010\u0003\u001a\u00020\r2\u0007\u0010õ\u0002\u001a\u00020\u0012H\u0002R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u00020*X\u0004¢\u0006\u0004\n\u0002\u0010+R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X.¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X.¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX.¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010F\u001a\b\u0012\u0004\u0012\u00020=0GX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010KX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010U\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u0019\"\u0004\bW\u0010\u001bR\u001a\u0010X\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0019\"\u0004\bZ\u0010\u001bR\u001a\u0010[\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0019\"\u0004\b]\u0010\u001bR\u001a\u0010^\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u0019\"\u0004\b`\u0010\u001bR\u000e\u0010a\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010f\u001a\u0004\u0018\u00010gX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010h\u001a\u0004\u0018\u00010iX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010j\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010k\u001a\u0004\u0018\u00010lX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010m\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010n\u001a\u0004\u0018\u00010oX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010p\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010q\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010r\u001a\u0004\u0018\u00010sX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010t\u001a\u0004\u0018\u00010gX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010u\u001a\u0004\u0018\u00010iX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020EX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010w\u001a\b\u0012\u0004\u0012\u00020y0xX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010z\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010{\u001a\u0004\u0018\u00010|X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020~X.¢\u0006\u0002\n\u0000R\u0013\u0010\u001a\u00070\u0001R\u00020\u0000X.¢\u0006\u0002\n\u0000R\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020e0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0001\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0001\u001a\u0004\u0018\u000109X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020E0 \u00018\u0002X\u0004¢\u0006\u0002\n\u0000R\u000f\u0010¡\u0001\u001a\u00020\rXD¢\u0006\u0002\n\u0000¨\u0006\u0003"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainActivity;", "Ljp/co/sony/reonpocket/modules/base/view/BaseActivity;", "Ljp/co/sony/reonpocket/modules/main/view/MainSmartCoolModeSettingFragment$SmartModePreferenceSelectListener;", "Ljp/co/sony/reonpocket/modules/main/view/MainSmartModeSettingFragment$SmartModeSelectListener;", "Ljp/co/sony/reonpocket/modules/main/view/MainSmartSettingSwitchingTempFragment$SmartSwitchThresholdListener;", "Ljp/co/sony/reonpocket/modules/main/view/MainViewInput;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "Ljp/co/sony/reonpocket/view/fragment/DataDialogFragment$Callback;", "Ljp/co/sony/reonpocket/view/fragment/AlertDialogFragment$Callback;", "Ljp/co/sony/reonpocket/view/TagMiniInfoViewOutput;", "()V", "coolPageIndexDefaultValue", "", "currentDeviceTemp", "", "Ljava/lang/Float;", "isFirstOpen", "", "isForeground", "isFoundDialogDisplay", "isSettingConfiguration", "isShowingModeSwitchProgress", "isShowingProgress", "isTagInfoReceiving", "()Z", "setTagInfoReceiving", "(Z)V", "mAutoDialogFragment", "Ljp/co/sony/reonpocket/view/fragment/DataDialogFragment;", "mAutoStartIcon", "Ljp/co/sony/reonpocket/view/CustomImageView;", "mBatteryFullIcon", "mBatteryIcon", "mBatteryLevel", "mBatteryRemain", "Ljp/co/sony/reonpocket/view/CustomFontTextView;", "mBehavior", "Ljp/co/sony/reonpocket/util/LockableBottomSheetBehavior;", "Landroid/view/View;", "mBottomSheet", "mBottomSheetCallback", "jp/co/sony/reonpocket/modules/main/view/MainActivity$mBottomSheetCallback$1", "Ljp/co/sony/reonpocket/modules/main/view/MainActivity$mBottomSheetCallback$1;", "mBottomSheetLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "mBundleFromPreView", "Landroid/os/Bundle;", "mContext", "Landroid/content/Context;", "mCoolFragment", "Ljp/co/sony/reonpocket/modules/main/view/MainCoolFragment;", "mCoolPageIndex", "mCoolWaveOption", "Ljp/co/sony/reonpocket/constant/TempWaveOption;", "mCoolingIcon", "mCustomToast", "Landroid/widget/Toast;", "mDebugStatusView", "Ljp/co/sony/reonpocket/view/CustomDebugStatusView;", "mDeviceErrorCode", "Ljp/co/sony/reonpocket/constant/DeviceInfoConstants;", "mDeviceIcon", "mDfuCompleteDialog", "Ljp/co/sony/reonpocket/view/fragment/AlertDialogFragment;", "mDfuProgressBarDialog", "mDialogHelper", "Ljp/co/sony/reonpocket/util/DialogHelperUtil;", "mErrorMessage", "", "mErrorStack", "Ljava/util/Stack;", "mHeatFragment", "Ljp/co/sony/reonpocket/modules/main/view/MainWarmFragment;", "mImageView", "Landroid/widget/ImageView;", "mIsAutoModeEnable", "mIsCoolAuto", "mIsCoolHeatFromPreference", "mIsCoolOff", "mIsDeviceAlert", "mIsFirstOperate", "mIsHeatAuto", "mIsHeatOff", "mIsOff", "mIsRegisterTag", "getMIsRegisterTag", "setMIsRegisterTag", "mIsSupportCoolAuto", "getMIsSupportCoolAuto", "setMIsSupportCoolAuto", "mIsSupportSmart", "getMIsSupportSmart", "setMIsSupportSmart", "mIsSupportWarmAuto", "getMIsSupportWarmAuto", "setMIsSupportWarmAuto", "mIsTagNoAmbientTemp", "mIsTagRegistered", "mIsTransit", "mLastSelectedPage", "Ljp/co/sony/reonpocket/modules/main/view/MainActivity$Companion$Page;", "mModeSwitchProgressCountDownTimer", "Landroid/os/CountDownTimer;", "mModeSwitchProgressDialog", "Ljp/co/sony/reonpocket/view/fragment/ProgressDialogFragment;", "mNotificationDialogFragment", "mOutput", "Ljp/co/sony/reonpocket/modules/main/view/MainActivity$MainViewOutput;", "mPasswordDialogFragment", "mPasswordEditText", "Landroid/widget/EditText;", "mPercentTextView", "mPlugIcon", "mProgressBar", "Landroid/widget/ProgressBar;", "mProgressCountDownTimer", "mProgressDialog", "mProgressMessage", "mRegisteredFragments", "Ljp/co/sony/reonpocket/util/SafeArray;", "Landroidx/fragment/app/Fragment;", "mRequestLocationDialog", "mReviewInfo", "Lcom/google/android/play/core/review/ReviewInfo;", "mReviewManager", "Lcom/google/android/play/core/review/ReviewManager;", "mSectionsPagerAdapter", "Ljp/co/sony/reonpocket/modules/main/view/MainActivity$SectionsPagerAdapter;", "mSmartCoolFragment", "Ljp/co/sony/reonpocket/modules/main/view/MainSmartCoolModeFragment;", "mSmartCoolPageIndex", "mSmartFragment", "Ljp/co/sony/reonpocket/modules/main/view/MainSmartModeFragment;", "mSmartPageIndex", "mSmartWarmFragment", "Ljp/co/sony/reonpocket/modules/main/view/MainSmartWarmFragment;", "mSmartWarmPageIndex", "mTabLayout", "Lcom/google/android/material/tabs/TabLayout;", "mTabPages", "", "mTagInfo", "Ljp/co/sony/reonpocket/data/entity/NotifyTagSensorDataEntity;", "mTagInfoInteractor", "Ljp/co/sony/reonpocket/data/interactor/TagInfoInteractor;", "mTagMiniInfoView", "Ljp/co/sony/reonpocket/view/TagMiniInfoView;", "mTagMiniInfoViewWrap", "mTagRegisterSuccessDialog", "mTempCycleViewProgress", "mTempSettingValue", "mToast", "mToolbar", "Landroidx/appcompat/widget/Toolbar;", "mViewPager", "Ljp/co/sony/reonpocket/view/CustomViewPager;", "mWarmPageIndex", "mWaveDialogFragment", "requestPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "warmPageIndexDefaultValue", "calcelCustomToast", "", "changeWarmMode", "isRegister", "checkRelatedErrorNotificationAndShowDialog", "intent", "Landroid/content/Intent;", "createTemperatureEntity", "Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity$Temperature;", "aTempOffOnCode", "Ljp/co/sony/reonpocket/constant/TemperatureOnOffCode;", "aTempCoolHeatType", "Ljp/co/sony/reonpocket/constant/TemperatureCoolHeatTypeCode;", "coolPref", "Ljp/co/sony/reonpocket/constant/SmartModePreference;", "heatPref", "tempCoolWrite", "tempHeatWrite", "createTemperatureOffEntity", "dismissModeSwitchingProgress", "getCoolFragmentPageIndex", "getLastSelectedPage", "getSmartCoolFragmentPageIndex", "getSmartFragmentPageIndex", "getSmartWarmFragmentPageIndex", "getWarmFragmentPageIndex", "hiddenModeSwitchProgress", "hiddenProgress", "hiddenTagDfuProgress", "initBottomSheet", "initPresenter", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewOutput;", "initView", "isActiveSmartMode", "isSmartMixTypeCool", "isToolbar", "onAlertDialogSucceeded", "aDialog", "Ljp/co/sony/reonpocket/view/fragment/BaseDialogFragment;", "aRequestCode", "aResultCode", "onBatteryStateChange", "aBatteryEntity", "Ljp/co/sony/reonpocket/data/entity/BatteryEntity;", "onConnectionStatus", "aConnStatusCode", "Ljp/co/sony/reonpocket/constant/BleConnStatusCode;", "aServiceUuidList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onCoolTap", "onCreate", "savedInstanceState", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onDataDialogCancelled", "onDataDialogSucceeded", "onDismiss", "onFail", "aErrorMessage", "onNewIntent", "onPageScrollStateChanged", "i", "onPageScrolled", "v", "i1", "onPageSelected", "position", "onResume", "onSelected", "smartModePreference", "onSmartModeSelected", "warmPref", "isCoolMode", "coolTempSwitchThreshold", "", "warmTempStepSwitchThreshold", "onSmartSwitchThresholdSelected", "onSmartTap", "onStart", "onTabReselected", "p0", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabSelected", "tab", "onTabUnselected", "onWarmTap", "readDeviceMode", "requestForStoreReview", "requestNotificationPermission", "resetSlider", "sendCoolWarmChangeLogToFA", "aDeviceModeEntity", "Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity;", "setBatteryState", "setCoolFragment", "setIsForeground", "isFg", "setIsShownSmartCoolBefore", "aIsSmartShown", "setIsShownSmartWarmBefore", "setSmartCoolFragment", "aSmartModePreference", "setSmartCoolOff", "setSmartCoolPreference", "pref", "setSmartCoolTempSwitchThreshold", "value", "setSmartFragment", "setSmartMixPreference", "boolean", "(Ljava/lang/Boolean;)V", "setSmartOff", "setSmartWarmFragment", "setSmartWarmOff", "setSmartWarmPreference", "setSmartWarmTempSwitchThreshold", "setSwipeEnabled", "aIsOn", "setTempSettingValue", "aTempSettingValue", "setWarmFragment", "showAutoStartNotification", "showAutoStopMessage", "showCustomToast", "aMsg", "showDfuComplete", "showDfuDisconnect", "showDfuFail", "showDfuFailed", "showDfuStarting", "showModeChangeProgress", "aProgressMessageStringRes", "(Ljava/lang/Integer;)V", "showModeSwitchProgressDialog", "showModeSwitchingProgress", "showNotification", "aButtonPreference", "aTitle", "aSubtitle", "aDescription", "aUrl", "aBitMap", "Landroid/graphics/Bitmap;", "showPassCheckDialog", "aClass", "Ljava/lang/Class;", "showProgressDialog", "showRequestBackgroundLocationDialog", "aIsRequestPermission", "showSmartCoolSetting", "showSmartSetting", "showSmartSwitchingTempSetting", "showSmartWarmSetting", "showTagDfuDialog", "showTagRegisterDialog", "bdAddress", "aTagInfo", "Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity;", "aTagModelName", "showTagRegisteredDialog", "showTagRegistrationFailedDialog", "showTagUpdateMessage", "showToast", "aContext", "aContent", "startTagScan", "transitToCool", "transitToCoolOrWarmByTypeCode", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "transitToSmart", "aIsStartRunning", "transitToSmartCool", "transitToSmartWarm", "transitToWarm", "unRegisterTagStatus", "updateActionMode", "updateBatteryRemainTime", "aRemainTime", "updateCoolOff", "updateCoolPageIndex", "updateCoolingStatus", "aCoolingCode", "Ljp/co/sony/reonpocket/constant/DeviceCoolingCode;", "updateDeviceImage", "updateDeviceInfo", "aInfoCode", "updateDeviceTemp", "aTemp", "updateDfuProgress", "aProgress", "updateIsAlert", "aIsShowAlert", "updateIsAutoStartEnable", "aIsEnable", "updateIsOff", "aIsOff", "updateNoAmbientTemperature", "isNotGet", "updateNoReceiving", "isNoReceiving", "updateSettingTrigger", "aSettingTriggerCode", "Ljp/co/sony/reonpocket/constant/DeviceModeSettingTriggerCode;", "updateShowSmartMode", "aIsDisplay", "updateSmartModeIconDisplay", "isIconDisplay", "updateSmartPageIndex", "isTagRegistered", "updateSmartWarmTagNoReceiving", "updateStatusText", "entity", "Ljp/co/sony/reonpocket/data/entity/NotifyDeviceSensorDataEntity;", "Ljp/co/sony/reonpocket/data/entity/ThermoControlStatusEntity;", "updateTagEntity", "isReceiving", "updateTagMiniInfoView", "isActive", "updateTagMiniInfoViewNoReceiving", "updateTagStatusText", "updateWarmOff", "updateWarmPageIndex", "Companion", "MainViewOutput", "SectionsPagerAdapter", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainActivity.kt */
public final class MainActivity extends BaseActivity implements MainSmartCoolModeSettingFragment.SmartModePreferenceSelectListener, MainSmartModeSettingFragment.SmartModeSelectListener, MainSmartSettingSwitchingTempFragment.SmartSwitchThresholdListener, MainViewInput, ViewPager.OnPageChangeListener, TabLayout.OnTabSelectedListener, DataDialogFragment.Callback, AlertDialogFragment.Callback, TagMiniInfoViewOutput {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int INDEX_UNDEFINED = 0;
    private static final long PROGRESS_DIALOG_INTERVAL = 10000;
    private static final long PROGRESS_DIALOG_INTERVAL_SWITCH_MODE = 10000;
    private static final String PROGRESS_DIALOG_TAG = "progress_dialog_tag";
    private static final int REQUEST_ACCESS_BACKGROUND_LOCATION = 2;
    public static final String SHOW_ERROR_DIALOG_KEY_RELATED_NOTIFICATION_ID = "show_error_dialog_key_related_notification_id";
    private static final String SWITCH_MODE_PROGRESS_DIALOG_TAG = "switch_mode_progress_dialog_tag";
    /* access modifiers changed from: private */
    public static AppBarLayout mBarLayout;
    private final int coolPageIndexDefaultValue;
    private Float currentDeviceTemp;
    private boolean isFirstOpen = true;
    private boolean isForeground;
    /* access modifiers changed from: private */
    public boolean isFoundDialogDisplay;
    private boolean isSettingConfiguration;
    private boolean isShowingModeSwitchProgress;
    private boolean isShowingProgress;
    private boolean isTagInfoReceiving;
    /* access modifiers changed from: private */
    public DataDialogFragment mAutoDialogFragment;
    private CustomImageView mAutoStartIcon;
    private CustomImageView mBatteryFullIcon;
    private CustomImageView mBatteryIcon;
    private int mBatteryLevel;
    private CustomFontTextView mBatteryRemain;
    private LockableBottomSheetBehavior<View> mBehavior;
    private View mBottomSheet;
    private final MainActivity$mBottomSheetCallback$1 mBottomSheetCallback = new MainActivity$mBottomSheetCallback$1();
    private ViewGroup.LayoutParams mBottomSheetLayoutParams;
    private Bundle mBundleFromPreView;
    private Context mContext;
    private MainCoolFragment mCoolFragment;
    private int mCoolPageIndex;
    private TempWaveOption mCoolWaveOption = TempWaveOption.WAVE_OFF;
    private CustomImageView mCoolingIcon;
    private Toast mCustomToast;
    private CustomDebugStatusView mDebugStatusView;
    private DeviceInfoConstants mDeviceErrorCode;
    private CustomImageView mDeviceIcon;
    private AlertDialogFragment mDfuCompleteDialog;
    private DataDialogFragment mDfuProgressBarDialog;
    private DialogHelperUtil mDialogHelper;
    private String mErrorMessage;
    private final Stack<DeviceInfoConstants> mErrorStack = new Stack<>();
    private MainWarmFragment mHeatFragment;
    /* access modifiers changed from: private */
    public ImageView mImageView;
    private boolean mIsAutoModeEnable = true;
    private boolean mIsCoolAuto;
    private int mIsCoolHeatFromPreference = CoolHeatTypeCode.COOL.getCode();
    private boolean mIsCoolOff;
    private boolean mIsDeviceAlert;
    private boolean mIsFirstOperate = true;
    private boolean mIsHeatAuto;
    private boolean mIsHeatOff;
    private boolean mIsOff = true;
    private boolean mIsRegisterTag;
    private boolean mIsSupportCoolAuto;
    private boolean mIsSupportSmart;
    private boolean mIsSupportWarmAuto;
    private boolean mIsTagNoAmbientTemp;
    private boolean mIsTagRegistered;
    private boolean mIsTransit;
    private Companion.Page mLastSelectedPage = Companion.Page.COOL;
    private CountDownTimer mModeSwitchProgressCountDownTimer;
    private ProgressDialogFragment mModeSwitchProgressDialog;
    private DataDialogFragment mNotificationDialogFragment;
    /* access modifiers changed from: private */
    public MainViewOutput mOutput;
    private DataDialogFragment mPasswordDialogFragment;
    /* access modifiers changed from: private */
    public EditText mPasswordEditText;
    /* access modifiers changed from: private */
    public CustomFontTextView mPercentTextView;
    private CustomImageView mPlugIcon;
    /* access modifiers changed from: private */
    public ProgressBar mProgressBar;
    private CountDownTimer mProgressCountDownTimer;
    private ProgressDialogFragment mProgressDialog;
    /* access modifiers changed from: private */
    public String mProgressMessage = "";
    /* access modifiers changed from: private */
    public final SafeArray<Fragment> mRegisteredFragments = new SafeArray<>((List) null, 1, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public DataDialogFragment mRequestLocationDialog;
    private ReviewInfo mReviewInfo;
    private ReviewManager mReviewManager;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private MainSmartCoolModeFragment mSmartCoolFragment;
    private int mSmartCoolPageIndex;
    private MainSmartModeFragment mSmartFragment;
    private int mSmartPageIndex;
    private MainSmartWarmFragment mSmartWarmFragment;
    private int mSmartWarmPageIndex;
    private TabLayout mTabLayout;
    private final List<Companion.Page> mTabPages = new ArrayList();
    private NotifyTagSensorDataEntity mTagInfo;
    private final TagInfoInteractor mTagInfoInteractor = new TagInfoInteractor();
    private TagMiniInfoView mTagMiniInfoView;
    private View mTagMiniInfoViewWrap;
    private DataDialogFragment mTagRegisterSuccessDialog;
    private int mTempCycleViewProgress;
    private int mTempSettingValue = TempStepCode.STEP_1.getCode();
    private Toast mToast;
    private Toolbar mToolbar;
    private CustomViewPager mViewPager;
    private int mWarmPageIndex;
    private DataDialogFragment mWaveDialogFragment;
    private final ActivityResultLauncher<String> requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new MainActivity$$ExternalSyntheticLambda0());
    private final int warmPageIndexDefaultValue = 1;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;

        /* JADX WARNING: Can't wrap try/catch for region: R(57:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|(2:19|20)|21|23|24|25|26|27|28|29|30|31|32|33|35|36|37|38|39|40|(2:41|42)|43|45|46|47|48|49|50|51|52|(2:53|54)|55|57|58|(2:59|60)|61|63|64|65|66|(2:67|68)|69|71|72|(2:73|74)|75|77) */
        /* JADX WARNING: Can't wrap try/catch for region: R(60:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|(2:19|20)|21|23|24|25|26|27|28|29|30|31|32|33|35|36|37|38|39|40|(2:41|42)|43|45|46|47|48|49|50|51|52|(2:53|54)|55|57|58|59|60|61|63|64|65|66|67|68|69|71|72|(2:73|74)|75|77) */
        /* JADX WARNING: Can't wrap try/catch for region: R(62:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|27|28|29|30|31|32|33|35|36|37|38|39|40|(2:41|42)|43|45|46|47|48|49|50|51|52|(2:53|54)|55|57|58|59|60|61|63|64|65|66|67|68|69|71|72|73|74|75|77) */
        /* JADX WARNING: Can't wrap try/catch for region: R(63:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|27|28|29|30|31|32|33|35|36|37|38|39|40|(2:41|42)|43|45|46|47|48|49|50|51|52|(2:53|54)|55|57|58|59|60|61|63|64|65|66|67|68|69|71|72|73|74|75|77) */
        /* JADX WARNING: Can't wrap try/catch for region: R(64:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|27|28|29|30|31|32|33|35|36|37|38|39|40|41|42|43|45|46|47|48|49|50|51|52|(2:53|54)|55|57|58|59|60|61|63|64|65|66|67|68|69|71|72|73|74|75|77) */
        /* JADX WARNING: Can't wrap try/catch for region: R(65:0|1|2|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|27|28|29|30|31|32|33|35|36|37|38|39|40|41|42|43|45|46|47|48|49|50|51|52|(2:53|54)|55|57|58|59|60|61|63|64|65|66|67|68|69|71|72|73|74|75|77) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x005e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0066 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x007f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0087 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x008f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00b0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00b8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00d9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x00f2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x00fa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x0113 */
        static {
            /*
                jp.co.sony.reonpocket.constant.DeviceInfoConstants[] r0 = jp.co.sony.reonpocket.constant.DeviceInfoConstants.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                jp.co.sony.reonpocket.constant.DeviceInfoConstants r2 = jp.co.sony.reonpocket.constant.DeviceInfoConstants.NORMAL_MOVEMENT_AUTO_STOP     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                jp.co.sony.reonpocket.constant.DeviceInfoConstants r3 = jp.co.sony.reonpocket.constant.DeviceInfoConstants.NORMAL_MOVEMENT_COOL     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                jp.co.sony.reonpocket.constant.DeviceInfoConstants r4 = jp.co.sony.reonpocket.constant.DeviceInfoConstants.NORMAL_MOVEMENT_HIGH_TEMP     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                r4 = 4
                jp.co.sony.reonpocket.constant.DeviceInfoConstants r5 = jp.co.sony.reonpocket.constant.DeviceInfoConstants.NORMAL_MOVEMENT_LOW_BATTERY     // Catch:{ NoSuchFieldError -> 0x002b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                r5 = 5
                jp.co.sony.reonpocket.constant.DeviceInfoConstants r6 = jp.co.sony.reonpocket.constant.DeviceInfoConstants.NORMAL_MOVEMENT_WARM     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r0[r6] = r5     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                jp.co.sony.reonpocket.constant.DeviceInfoConstants r6 = jp.co.sony.reonpocket.constant.DeviceInfoConstants.EXCEPTION_INTERNAL_HIGH_TEMP     // Catch:{ NoSuchFieldError -> 0x003d }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r7 = 6
                r0[r6] = r7     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                $EnumSwitchMapping$0 = r0
                jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page[] r0 = jp.co.sony.reonpocket.modules.main.view.MainActivity.Companion.Page.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page r6 = jp.co.sony.reonpocket.modules.main.view.MainActivity.Companion.Page.COOL     // Catch:{ NoSuchFieldError -> 0x004e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r0[r6] = r1     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page r6 = jp.co.sony.reonpocket.modules.main.view.MainActivity.Companion.Page.WARM     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r0[r6] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page r6 = jp.co.sony.reonpocket.modules.main.view.MainActivity.Companion.Page.SMARTCOOL     // Catch:{ NoSuchFieldError -> 0x005e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r0[r6] = r3     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page r6 = jp.co.sony.reonpocket.modules.main.view.MainActivity.Companion.Page.SMART     // Catch:{ NoSuchFieldError -> 0x0066 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0066 }
                r0[r6] = r4     // Catch:{ NoSuchFieldError -> 0x0066 }
            L_0x0066:
                jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page r6 = jp.co.sony.reonpocket.modules.main.view.MainActivity.Companion.Page.SMARTWARM     // Catch:{ NoSuchFieldError -> 0x006e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r0[r6] = r5     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                $EnumSwitchMapping$1 = r0
                jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode[] r0 = jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode r6 = jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode.COOL     // Catch:{ NoSuchFieldError -> 0x007f }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x007f }
                r0[r6] = r1     // Catch:{ NoSuchFieldError -> 0x007f }
            L_0x007f:
                jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode r6 = jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode.COOL_HEAT_MIX     // Catch:{ NoSuchFieldError -> 0x0087 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0087 }
                r0[r6] = r2     // Catch:{ NoSuchFieldError -> 0x0087 }
            L_0x0087:
                jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode r6 = jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode.HEAT     // Catch:{ NoSuchFieldError -> 0x008f }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r0[r6] = r3     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode r6 = jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode.OFF     // Catch:{ NoSuchFieldError -> 0x0097 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0097 }
                r0[r6] = r4     // Catch:{ NoSuchFieldError -> 0x0097 }
            L_0x0097:
                $EnumSwitchMapping$2 = r0
                jp.co.sony.reonpocket.constant.CoolHeatTypeCode[] r0 = jp.co.sony.reonpocket.constant.CoolHeatTypeCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.CoolHeatTypeCode r6 = jp.co.sony.reonpocket.constant.CoolHeatTypeCode.COOL     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r0[r6] = r1     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                jp.co.sony.reonpocket.constant.CoolHeatTypeCode r6 = jp.co.sony.reonpocket.constant.CoolHeatTypeCode.OFF_COOL     // Catch:{ NoSuchFieldError -> 0x00b0 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b0 }
                r0[r6] = r2     // Catch:{ NoSuchFieldError -> 0x00b0 }
            L_0x00b0:
                jp.co.sony.reonpocket.constant.CoolHeatTypeCode r6 = jp.co.sony.reonpocket.constant.CoolHeatTypeCode.HEAT     // Catch:{ NoSuchFieldError -> 0x00b8 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b8 }
                r0[r6] = r3     // Catch:{ NoSuchFieldError -> 0x00b8 }
            L_0x00b8:
                jp.co.sony.reonpocket.constant.CoolHeatTypeCode r6 = jp.co.sony.reonpocket.constant.CoolHeatTypeCode.OFF_HEAT     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r0[r6] = r4     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                jp.co.sony.reonpocket.constant.CoolHeatTypeCode r4 = jp.co.sony.reonpocket.constant.CoolHeatTypeCode.SMART     // Catch:{ NoSuchFieldError -> 0x00c8 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c8 }
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00c8 }
            L_0x00c8:
                $EnumSwitchMapping$3 = r0
                jp.co.sony.reonpocket.constant.PowerSupplyStatus[] r0 = jp.co.sony.reonpocket.constant.PowerSupplyStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.PowerSupplyStatus r4 = jp.co.sony.reonpocket.constant.PowerSupplyStatus.VBUS_ON     // Catch:{ NoSuchFieldError -> 0x00d9 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d9 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x00d9 }
            L_0x00d9:
                jp.co.sony.reonpocket.constant.PowerSupplyStatus r4 = jp.co.sony.reonpocket.constant.PowerSupplyStatus.VBUS_OFF     // Catch:{ NoSuchFieldError -> 0x00e1 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e1 }
                r0[r4] = r2     // Catch:{ NoSuchFieldError -> 0x00e1 }
            L_0x00e1:
                $EnumSwitchMapping$4 = r0
                jp.co.sony.reonpocket.constant.BatteryChargeStatus[] r0 = jp.co.sony.reonpocket.constant.BatteryChargeStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.BatteryChargeStatus r4 = jp.co.sony.reonpocket.constant.BatteryChargeStatus.CHARGING     // Catch:{ NoSuchFieldError -> 0x00f2 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f2 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x00f2 }
            L_0x00f2:
                jp.co.sony.reonpocket.constant.BatteryChargeStatus r4 = jp.co.sony.reonpocket.constant.BatteryChargeStatus.DISCHARGING     // Catch:{ NoSuchFieldError -> 0x00fa }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fa }
                r0[r4] = r2     // Catch:{ NoSuchFieldError -> 0x00fa }
            L_0x00fa:
                jp.co.sony.reonpocket.constant.BatteryChargeStatus r4 = jp.co.sony.reonpocket.constant.BatteryChargeStatus.FULL     // Catch:{ NoSuchFieldError -> 0x0102 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0102 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0102 }
            L_0x0102:
                $EnumSwitchMapping$5 = r0
                jp.co.sony.reonpocket.constant.DeviceCoolingCode[] r0 = jp.co.sony.reonpocket.constant.DeviceCoolingCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.DeviceCoolingCode r3 = jp.co.sony.reonpocket.constant.DeviceCoolingCode.OFF     // Catch:{ NoSuchFieldError -> 0x0113 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0113 }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0113 }
            L_0x0113:
                jp.co.sony.reonpocket.constant.DeviceCoolingCode r1 = jp.co.sony.reonpocket.constant.DeviceCoolingCode.ON     // Catch:{ NoSuchFieldError -> 0x011b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x011b }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x011b }
            L_0x011b:
                $EnumSwitchMapping$6 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.main.view.MainActivity.WhenMappings.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public static final void requestForStoreReview$lambda$37$lambda$36(Task task) {
        Intrinsics.checkNotNullParameter(task, "<anonymous parameter 0>");
    }

    /* access modifiers changed from: private */
    public static final void requestPermissionLauncher$lambda$41(boolean z) {
    }

    /* access modifiers changed from: private */
    public static final boolean updateSmartModeIconDisplay$lambda$45$lambda$44(View view, MotionEvent motionEvent) {
        return false;
    }

    /* access modifiers changed from: private */
    public static final boolean updateSmartModeIconDisplay$lambda$47$lambda$46(View view, MotionEvent motionEvent) {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isToolbar() {
        return false;
    }

    public void onDataDialogCancelled(BaseDialogFragment baseDialogFragment, int i) {
        Intrinsics.checkNotNullParameter(baseDialogFragment, "aDialog");
    }

    public void onDismiss(BaseDialogFragment baseDialogFragment, int i) {
        Intrinsics.checkNotNullParameter(baseDialogFragment, "aDialog");
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onTabReselected(TabLayout.Tab tab) {
    }

    public void onTabUnselected(TabLayout.Tab tab) {
    }

    public void updateSettingTrigger(DeviceModeSettingTriggerCode deviceModeSettingTriggerCode) {
        Intrinsics.checkNotNullParameter(deviceModeSettingTriggerCode, "aSettingTriggerCode");
    }

    public void updateStatusText(NotifyDeviceSensorDataEntity notifyDeviceSensorDataEntity) {
        Intrinsics.checkNotNullParameter(notifyDeviceSensorDataEntity, "entity");
    }

    public void updateStatusText(ThermoControlStatusEntity thermoControlStatusEntity) {
        Intrinsics.checkNotNullParameter(thermoControlStatusEntity, "entity");
    }

    public void updateTagStatusText(NotifyTagSensorDataEntity notifyTagSensorDataEntity) {
        Intrinsics.checkNotNullParameter(notifyTagSensorDataEntity, "entity");
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainActivity$Companion;", "", "()V", "INDEX_UNDEFINED", "", "PROGRESS_DIALOG_INTERVAL", "", "PROGRESS_DIALOG_INTERVAL_SWITCH_MODE", "PROGRESS_DIALOG_TAG", "", "REQUEST_ACCESS_BACKGROUND_LOCATION", "SHOW_ERROR_DIALOG_KEY_RELATED_NOTIFICATION_ID", "SWITCH_MODE_PROGRESS_DIALOG_TAG", "mBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "getMBarLayout$app_prodRelease", "()Lcom/google/android/material/appbar/AppBarLayout;", "setMBarLayout$app_prodRelease", "(Lcom/google/android/material/appbar/AppBarLayout;)V", "Page", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AppBarLayout getMBarLayout$app_prodRelease() {
            return MainActivity.mBarLayout;
        }

        public final void setMBarLayout$app_prodRelease(AppBarLayout appBarLayout) {
            MainActivity.mBarLayout = appBarLayout;
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainActivity$Companion$Page;", "", "layout", "", "standard", "light", "(Ljava/lang/String;IIII)V", "getLayout", "()I", "getLight", "getStandard", "SMARTCOOL", "COOL", "SMART", "WARM", "SMARTWARM", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* compiled from: MainActivity.kt */
        public enum Page {
            SMARTCOOL(R.layout.view_tab_smart, 0, -1),
            COOL(R.layout.view_tab_cool, 1, 0),
            SMART(R.layout.view_tab_smart_coolwarm, 2, -1),
            WARM(R.layout.view_tab_warm, 3, 1),
            SMARTWARM(R.layout.view_tab_warm, 4, 1);
            
            private final int layout;
            private final int light;
            private final int standard;

            public static EnumEntries<Page> getEntries() {
                return $ENTRIES;
            }

            private Page(int i, int i2, int i3) {
                this.layout = i;
                this.standard = i2;
                this.light = i3;
            }

            public final int getLayout() {
                return this.layout;
            }

            public final int getLight() {
                return this.light;
            }

            public final int getStandard() {
                return this.standard;
            }

            static {
                Page[] $values;
                $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
            }
        }
    }

    public final boolean getMIsSupportCoolAuto() {
        return this.mIsSupportCoolAuto;
    }

    public final void setMIsSupportCoolAuto(boolean z) {
        this.mIsSupportCoolAuto = z;
    }

    public final boolean getMIsSupportWarmAuto() {
        return this.mIsSupportWarmAuto;
    }

    public final void setMIsSupportWarmAuto(boolean z) {
        this.mIsSupportWarmAuto = z;
    }

    public final boolean getMIsSupportSmart() {
        return this.mIsSupportSmart;
    }

    public final void setMIsSupportSmart(boolean z) {
        this.mIsSupportSmart = z;
    }

    public final boolean getMIsRegisterTag() {
        return this.mIsRegisterTag;
    }

    public final void setMIsRegisterTag(boolean z) {
        this.mIsRegisterTag = z;
    }

    public final boolean isTagInfoReceiving() {
        return this.isTagInfoReceiving;
    }

    public final void setTagInfoReceiving(boolean z) {
        this.isTagInfoReceiving = z;
    }

    private final void initBottomSheet() {
        View findViewById = findViewById(R.id.bottom_sheet);
        this.mBottomSheet = findViewById;
        Intrinsics.checkNotNull(findViewById);
        BottomSheetBehavior from = BottomSheetBehavior.from(findViewById);
        Intrinsics.checkNotNull(from, "null cannot be cast to non-null type jp.co.sony.reonpocket.util.LockableBottomSheetBehavior<android.view.View>");
        LockableBottomSheetBehavior<View> lockableBottomSheetBehavior = (LockableBottomSheetBehavior) from;
        this.mBehavior = lockableBottomSheetBehavior;
        if (lockableBottomSheetBehavior != null) {
            lockableBottomSheetBehavior.setHideable(false);
        }
        LockableBottomSheetBehavior<View> lockableBottomSheetBehavior2 = this.mBehavior;
        if (lockableBottomSheetBehavior2 != null) {
            lockableBottomSheetBehavior2.setBottomSheetCallback(this.mBottomSheetCallback);
        }
        View view = this.mBottomSheet;
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        this.mBottomSheetLayoutParams = layoutParams;
        if (layoutParams != null) {
            layoutParams.height = -2;
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        checkRelatedErrorNotificationAndShowDialog(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Unit unit;
        TabLayout.Tab tabAt;
        TabLayout.Tab tabAt2;
        TabLayout.Tab tabAt3;
        TabLayout.Tab tabAt4;
        TabLayout.Tab tabAt5;
        String string;
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        Context context = this;
        this.mContext = context;
        ReviewManager create = ReviewManagerFactory.create(context);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        this.mReviewManager = create;
        Bundle extras = getIntent().getExtras();
        this.mBundleFromPreView = extras;
        if (extras != null) {
            this.mIsCoolHeatFromPreference = extras.getInt(PairingActivityKt.TRANSIT_TO_MAIN_COOL_HEAT, CoolHeatTypeCode.COOL.getCode());
        }
        Bundle bundle2 = this.mBundleFromPreView;
        if (!(bundle2 == null || (string = bundle2.getString(MainActivityKt.TRANSIT_PARENT)) == null)) {
            Class<ConnectionActivity> cls = ConnectionActivity.class;
            if (Intrinsics.areEqual((Object) string, (Object) "ConnectionActivity")) {
                BaseActivity.ActivityReferenceUtil.INSTANCE.finishOtherActivity(getClass());
            }
        }
        if (this.isFirstOpen && Build.VERSION.SDK_INT >= 33) {
            requestNotificationPermission();
        }
        initView();
        initBottomSheet();
        getWindow().getDecorView().setSystemUiVisibility(8192);
        int i = this.mIsCoolHeatFromPreference;
        ReviewManager reviewManager = null;
        if (i == CoolHeatTypeCode.COOL.getCode() || i == CoolHeatTypeCode.OFF_COOL.getCode() || i == CoolHeatTypeCode.OFF_HEAT.getCode()) {
            MainViewOutput mainViewOutput = this.mOutput;
            if (mainViewOutput != null) {
                int pagePosition = mainViewOutput.getPagePosition();
                if (pagePosition >= this.mTabPages.size() || pagePosition < 0) {
                    CustomViewPager customViewPager = this.mViewPager;
                    if (customViewPager != null) {
                        customViewPager.setCurrentItem(0);
                    }
                    TabLayout tabLayout = this.mTabLayout;
                    if (!(tabLayout == null || (tabAt2 = tabLayout.getTabAt(0)) == null)) {
                        tabAt2.select();
                    }
                    this.mIsFirstOperate = false;
                } else {
                    this.mLastSelectedPage = this.mTabPages.get(pagePosition);
                    CustomViewPager customViewPager2 = this.mViewPager;
                    if (customViewPager2 != null) {
                        customViewPager2.setCurrentItem(pagePosition);
                    }
                    TabLayout tabLayout2 = this.mTabLayout;
                    if (!(tabLayout2 == null || (tabAt3 = tabLayout2.getTabAt(pagePosition)) == null)) {
                        tabAt3.select();
                    }
                    this.mIsFirstOperate = false;
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                CustomViewPager customViewPager3 = this.mViewPager;
                if (customViewPager3 != null) {
                    customViewPager3.setCurrentItem(0);
                }
                TabLayout tabLayout3 = this.mTabLayout;
                if (!(tabLayout3 == null || (tabAt = tabLayout3.getTabAt(0)) == null)) {
                    tabAt.select();
                }
                this.mIsFirstOperate = false;
            }
        } else if (i == CoolHeatTypeCode.HEAT.getCode()) {
            int indexOf = this.mTabPages.indexOf(Companion.Page.WARM);
            CustomViewPager customViewPager4 = this.mViewPager;
            if (customViewPager4 != null) {
                customViewPager4.setCurrentItem(indexOf);
            }
            TabLayout tabLayout4 = this.mTabLayout;
            if (!(tabLayout4 == null || (tabAt5 = tabLayout4.getTabAt(indexOf)) == null)) {
                tabAt5.select();
            }
            this.mIsFirstOperate = false;
        } else if (i == CoolHeatTypeCode.SMART.getCode()) {
            int indexOf2 = this.mTabPages.indexOf(Companion.Page.SMART);
            CustomViewPager customViewPager5 = this.mViewPager;
            if (customViewPager5 != null) {
                customViewPager5.setCurrentItem(indexOf2);
            }
            TabLayout tabLayout5 = this.mTabLayout;
            if (!(tabLayout5 == null || (tabAt4 = tabLayout5.getTabAt(indexOf2)) == null)) {
                tabAt4.select();
            }
            this.mIsFirstOperate = false;
        }
        ReviewManager reviewManager2 = this.mReviewManager;
        if (reviewManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReviewManager");
        } else {
            reviewManager = reviewManager2;
        }
        Task<ReviewInfo> requestReviewFlow = reviewManager.requestReviewFlow();
        Intrinsics.checkNotNullExpressionValue(requestReviewFlow, "requestReviewFlow(...)");
        requestReviewFlow.addOnCompleteListener(new MainActivity$$ExternalSyntheticLambda1(this));
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        checkRelatedErrorNotificationAndShowDialog(intent);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$4(MainActivity mainActivity, Task task) {
        Intrinsics.checkNotNullParameter(mainActivity, "this$0");
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            mainActivity.mReviewInfo = (ReviewInfo) task.getResult();
        }
    }

    private final void initView() {
        boolean z;
        Unit unit;
        int i;
        TagMiniInfoView tagMiniInfoView;
        CapabilityEntity capability;
        Capability1 capability1;
        CapabilityEntity capability2;
        Capability1 capability12;
        CapabilityEntity capability3;
        Capability1 capability13;
        DeviceModeActionCode deviceModeActionCode;
        TempWaveOption tempWaveOption;
        int i2;
        SmartModePreference smartModePreference;
        boolean z2;
        CurrentCoolHeatTypeCode currentCoolHeatTypeCode;
        MainViewOutput mainViewOutput;
        SmartModePreference smartModePreference2;
        boolean z3;
        CurrentCoolHeatTypeCode currentCoolHeatTypeCode2;
        MainViewOutput mainViewOutput2;
        TempStepCode tempStepCode;
        MainViewOutput mainViewOutput3;
        MainViewOutput mainViewOutput4 = this.mOutput;
        boolean z4 = mainViewOutput4 != null && mainViewOutput4.getPagePosition() == -1;
        this.isFirstOpen = z4;
        if (z4 && (mainViewOutput3 = this.mOutput) != null) {
            mainViewOutput3.savePagePosition(0);
            Unit unit2 = Unit.INSTANCE;
        }
        View findViewById = findViewById(R.id.toolbar);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById;
        this.mToolbar = toolbar;
        Intrinsics.checkNotNull(toolbar);
        toolbar.setTitle((CharSequence) "");
        setSupportActionBar(this.mToolbar);
        Bundle bundle = this.mBundleFromPreView;
        CustomDebugStatusView customDebugStatusView = null;
        if (bundle != null) {
            int i3 = bundle.getInt(PairingActivityKt.TRANSIT_TO_MAIN_MODE);
            DeviceModeActionCode deviceModeActionCode2 = DeviceModeActionCode.MANUAL;
            DeviceModeActionCode[] values = DeviceModeActionCode.values();
            int length = values.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    deviceModeActionCode = null;
                    break;
                }
                deviceModeActionCode = values[i4];
                if (deviceModeActionCode.getCode() == i3) {
                    break;
                }
                i4++;
            }
            if (deviceModeActionCode != null) {
                Unit unit3 = Unit.INSTANCE;
                Unit unit4 = Unit.INSTANCE;
                deviceModeActionCode2 = deviceModeActionCode;
            }
            int i5 = bundle.getInt(PairingActivityKt.TRANSIT_TO_MAIN_WAVE);
            TempWaveOption tempWaveOption2 = TempWaveOption.WAVE_OFF;
            TempWaveOption[] values2 = TempWaveOption.values();
            int length2 = values2.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length2) {
                    tempWaveOption = null;
                    break;
                }
                tempWaveOption = values2[i6];
                if (tempWaveOption.getCode() == i5) {
                    break;
                }
                i6++;
            }
            if (tempWaveOption != null) {
                Unit unit5 = Unit.INSTANCE;
                Unit unit6 = Unit.INSTANCE;
                tempWaveOption2 = tempWaveOption;
            }
            if (bundle.getInt(PairingActivityKt.TRANSIT_TO_MAIN_BOOST, TempBoostOption.NONE.getCode()) == TempBoostOption.NONE.getCode()) {
                TempStepCode[] values3 = TempStepCode.values();
                int length3 = values3.length;
                int i7 = 0;
                while (true) {
                    if (i7 >= length3) {
                        tempStepCode = null;
                        break;
                    }
                    tempStepCode = values3[i7];
                    if (bundle.getInt(PairingActivityKt.TRANSIT_TO_MAIN_TEMPERATURE, TempStepCode.OFF.getCode()) == tempStepCode.getCode()) {
                        break;
                    }
                    i7++;
                }
                i2 = tempStepCode != null ? tempStepCode.ordinal() : TempStepCode.OFF.ordinal();
            } else {
                i2 = TempStepCode.STEP_4.ordinal();
            }
            int i8 = bundle.getInt(PairingActivityKt.TRANSIT_TO_MAIN_COOL_HEAT, CoolHeatTypeCode.OFF_COOL.getCode());
            if (i8 == CoolHeatTypeCode.COOL.getCode()) {
                this.mIsOff = false;
                this.mCoolFragment = MainCoolFragment.Companion.newInstance(i2, deviceModeActionCode2, tempWaveOption2);
                this.mHeatFragment = MainWarmFragment.Companion.newInstance$default(MainWarmFragment.Companion, 0, (DeviceModeActionCode) null, 3, (Object) null);
            } else if (i8 == CoolHeatTypeCode.HEAT.getCode()) {
                this.mIsOff = false;
                this.mCoolFragment = MainCoolFragment.Companion.newInstance$default(MainCoolFragment.Companion, 0, (DeviceModeActionCode) null, (TempWaveOption) null, 7, (Object) null);
                this.mHeatFragment = MainWarmFragment.Companion.newInstance(i2, deviceModeActionCode2);
            } else {
                this.mIsOff = true;
                this.mCoolFragment = MainCoolFragment.Companion.newInstance$default(MainCoolFragment.Companion, 0, (DeviceModeActionCode) null, (TempWaveOption) null, 7, (Object) null);
                this.mHeatFragment = MainWarmFragment.Companion.newInstance$default(MainWarmFragment.Companion, 0, (DeviceModeActionCode) null, 3, (Object) null);
            }
            int i9 = bundle.getInt(PairingActivityKt.TRANSIT_TO_MAIN_SMART_MODE_ON_OFF);
            if (!(i9 == CurrentCoolHeatTypeCode.COOL.getCode() || i9 == CurrentCoolHeatTypeCode.PAUSE.getCode())) {
                int code = CurrentCoolHeatTypeCode.WEAKCOOL.getCode();
            }
            z = bundle.getInt(PairingActivityKt.TRANSIT_TO_MAIN_MODE) == DeviceModeActionCode.TEMPERATURE.getCode();
            this.mSmartCoolFragment = MainSmartCoolModeFragment.Companion.newInstance$default(MainSmartCoolModeFragment.Companion, (CurrentCoolHeatTypeCode) null, (SmartModePreference) null, 3, (Object) null);
            this.mSmartWarmFragment = MainSmartWarmFragment.Companion.newInstance$default(MainSmartWarmFragment.Companion, (CurrentCoolHeatTypeCode) null, (SmartModePreference) null, 3, (Object) null);
            int i10 = bundle.getInt(PairingActivityKt.TRANSIT_TO_MAIN_SMART_MODE_ON_OFF, CurrentCoolHeatTypeCode.OFF.getCode());
            if (i10 == CurrentCoolHeatTypeCode.COOL.getCode() || i10 == CurrentCoolHeatTypeCode.OFF.getCode() || i10 == CurrentCoolHeatTypeCode.PAUSE.getCode() || i10 == CurrentCoolHeatTypeCode.WEAKCOOL.getCode()) {
                int i11 = bundle.getInt(PairingActivityKt.TRANSIT_TO_MAIN_SMART_COOL_MODE_PREFERENCE, TemperatureOnOffCode.OFF.getCode());
                SmartModePreference[] values4 = SmartModePreference.values();
                int length4 = values4.length;
                int i12 = 0;
                while (true) {
                    if (i12 >= length4) {
                        smartModePreference = null;
                        break;
                    }
                    smartModePreference = values4[i12];
                    if (smartModePreference.getCode() == i11) {
                        break;
                    }
                    i12++;
                }
                if (smartModePreference != null) {
                    if (!(smartModePreference == SmartModePreference.OFF || (mainViewOutput = this.mOutput) == null)) {
                        mainViewOutput.setSmartCoolPreference(smartModePreference);
                        Unit unit7 = Unit.INSTANCE;
                    }
                    Unit unit8 = Unit.INSTANCE;
                    Unit unit9 = Unit.INSTANCE;
                }
                bundle.getInt(PairingActivityKt.TRANSIT_TO_MAIN_SMART_COOL_MODE_USER_TEMPERATURE);
                if (i9 != CurrentCoolHeatTypeCode.OFF.getCode() && (i9 == CurrentCoolHeatTypeCode.COOL.getCode() || i9 == CurrentCoolHeatTypeCode.PAUSE.getCode() || i9 == CurrentCoolHeatTypeCode.WEAKCOOL.getCode())) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.mIsOff = z2;
                MainSmartCoolModeFragment.Companion companion = MainSmartCoolModeFragment.Companion;
                CurrentCoolHeatTypeCode[] values5 = CurrentCoolHeatTypeCode.values();
                int length5 = values5.length;
                int i13 = 0;
                while (true) {
                    if (i13 >= length5) {
                        currentCoolHeatTypeCode = null;
                        break;
                    }
                    currentCoolHeatTypeCode = values5[i13];
                    if (currentCoolHeatTypeCode.getCode() == i9) {
                        break;
                    }
                    i13++;
                }
                if (currentCoolHeatTypeCode == null) {
                    currentCoolHeatTypeCode = CurrentCoolHeatTypeCode.OFF;
                }
                MainViewOutput mainViewOutput5 = this.mOutput;
                this.mSmartCoolFragment = companion.newInstance(currentCoolHeatTypeCode, mainViewOutput5 != null ? mainViewOutput5.getSmartCoolPreference() : null);
            } else if (i10 == CurrentCoolHeatTypeCode.HEAT.getCode() || i10 == CurrentCoolHeatTypeCode.WEAKHEAT.getCode()) {
                int i14 = bundle.getInt(PairingActivityKt.TRANSIT_TO_MAIN_SMART_COOL_MODE_PREFERENCE, TemperatureOnOffCode.OFF.getCode());
                SmartModePreference[] values6 = SmartModePreference.values();
                int length6 = values6.length;
                int i15 = 0;
                while (true) {
                    if (i15 >= length6) {
                        smartModePreference2 = null;
                        break;
                    }
                    smartModePreference2 = values6[i15];
                    if (smartModePreference2.getCode() == i14) {
                        break;
                    }
                    i15++;
                }
                if (smartModePreference2 != null) {
                    if (!(smartModePreference2 == SmartModePreference.OFF || (mainViewOutput2 = this.mOutput) == null)) {
                        mainViewOutput2.setSmartWarmPreference(smartModePreference2);
                        Unit unit10 = Unit.INSTANCE;
                    }
                    Unit unit11 = Unit.INSTANCE;
                    Unit unit12 = Unit.INSTANCE;
                }
                if (i9 == CurrentCoolHeatTypeCode.HEAT.getCode() || i9 == CurrentCoolHeatTypeCode.WEAKHEAT.getCode()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.mIsOff = !z3;
                MainSmartWarmFragment.Companion companion2 = MainSmartWarmFragment.Companion;
                CurrentCoolHeatTypeCode[] values7 = CurrentCoolHeatTypeCode.values();
                int length7 = values7.length;
                int i16 = 0;
                while (true) {
                    if (i16 >= length7) {
                        currentCoolHeatTypeCode2 = null;
                        break;
                    }
                    currentCoolHeatTypeCode2 = values7[i16];
                    if (currentCoolHeatTypeCode2.getCode() == i9) {
                        break;
                    }
                    i16++;
                }
                if (currentCoolHeatTypeCode2 == null) {
                    currentCoolHeatTypeCode2 = CurrentCoolHeatTypeCode.OFF;
                }
                MainViewOutput mainViewOutput6 = this.mOutput;
                this.mSmartWarmFragment = companion2.newInstance(currentCoolHeatTypeCode2, mainViewOutput6 != null ? mainViewOutput6.getSmartWarmPreference() : null);
            } else {
                this.mIsOff = true;
                this.mSmartCoolFragment = MainSmartCoolModeFragment.Companion.newInstance$default(MainSmartCoolModeFragment.Companion, (CurrentCoolHeatTypeCode) null, (SmartModePreference) null, 3, (Object) null);
                this.mSmartWarmFragment = MainSmartWarmFragment.Companion.newInstance$default(MainSmartWarmFragment.Companion, (CurrentCoolHeatTypeCode) null, (SmartModePreference) null, 3, (Object) null);
            }
            Unit unit13 = Unit.INSTANCE;
            unit = Unit.INSTANCE;
        } else {
            z = false;
            unit = null;
        }
        if (unit == null) {
            MainActivity mainActivity = this;
            this.mIsOff = true;
            this.mCoolFragment = MainCoolFragment.Companion.newInstance$default(MainCoolFragment.Companion, 0, (DeviceModeActionCode) null, (TempWaveOption) null, 7, (Object) null);
            this.mHeatFragment = MainWarmFragment.Companion.newInstance$default(MainWarmFragment.Companion, 0, (DeviceModeActionCode) null, 3, (Object) null);
            this.mSmartCoolFragment = MainSmartCoolModeFragment.Companion.newInstance$default(MainSmartCoolModeFragment.Companion, (CurrentCoolHeatTypeCode) null, (SmartModePreference) null, 3, (Object) null);
            this.mSmartWarmFragment = MainSmartWarmFragment.Companion.newInstance$default(MainSmartWarmFragment.Companion, (CurrentCoolHeatTypeCode) null, (SmartModePreference) null, 3, (Object) null);
            this.mSmartFragment = MainSmartModeFragment.Companion.newInstance$default(MainSmartModeFragment.Companion, (CurrentCoolHeatTypeCode) null, (SmartModePreference) null, (SmartModePreference) null, (Double) null, (Double) null, 31, (Object) null);
            Unit unit14 = Unit.INSTANCE;
        }
        MainViewOutput mainViewOutput7 = this.mOutput;
        this.mIsSupportCoolAuto = (mainViewOutput7 == null || (capability3 = mainViewOutput7.getCapability()) == null || (capability13 = capability3.getCapability1()) == null) ? false : capability13.isSupportCoolAutoMode();
        MainViewOutput mainViewOutput8 = this.mOutput;
        this.mIsSupportWarmAuto = (mainViewOutput8 == null || (capability2 = mainViewOutput8.getCapability()) == null || (capability12 = capability2.getCapability1()) == null) ? false : capability12.isSupportWarmAutoMode();
        MainViewOutput mainViewOutput9 = this.mOutput;
        this.mIsSupportSmart = (mainViewOutput9 == null || (capability = mainViewOutput9.getCapability()) == null || (capability1 = capability.getCapability1()) == null) ? false : capability1.isSupportTempMode();
        MainViewOutput mainViewOutput10 = this.mOutput;
        this.mIsRegisterTag = mainViewOutput10 != null ? mainViewOutput10.getIsRegisterTag() : false;
        MainViewOutput mainViewOutput11 = this.mOutput;
        boolean isShownSmartCoolBefore = mainViewOutput11 != null ? mainViewOutput11.getIsShownSmartCoolBefore() : false;
        MainViewOutput mainViewOutput12 = this.mOutput;
        boolean isShownSmartWarmBefore = mainViewOutput12 != null ? mainViewOutput12.getIsShownSmartWarmBefore() : false;
        boolean z5 = this.mIsSupportSmart;
        if (!z5 || !z) {
            if (this.isFirstOpen) {
                if (z5) {
                    SafeArray<Fragment> safeArray = this.mRegisteredFragments;
                    MainSmartCoolModeFragment mainSmartCoolModeFragment = this.mSmartCoolFragment;
                    Intrinsics.checkNotNull(mainSmartCoolModeFragment);
                    safeArray.add(0, mainSmartCoolModeFragment);
                } else {
                    SafeArray<Fragment> safeArray2 = this.mRegisteredFragments;
                    MainCoolFragment mainCoolFragment = this.mCoolFragment;
                    Intrinsics.checkNotNull(mainCoolFragment);
                    safeArray2.add(0, mainCoolFragment);
                }
            } else if (!z5 || !isShownSmartCoolBefore) {
                SafeArray<Fragment> safeArray3 = this.mRegisteredFragments;
                MainCoolFragment mainCoolFragment2 = this.mCoolFragment;
                Intrinsics.checkNotNull(mainCoolFragment2);
                safeArray3.add(0, mainCoolFragment2);
            } else {
                SafeArray<Fragment> safeArray4 = this.mRegisteredFragments;
                MainSmartCoolModeFragment mainSmartCoolModeFragment2 = this.mSmartCoolFragment;
                Intrinsics.checkNotNull(mainSmartCoolModeFragment2);
                safeArray4.add(0, mainSmartCoolModeFragment2);
            }
            this.mCoolPageIndex = updateCoolPageIndex();
            this.mSmartCoolPageIndex = 0;
        } else {
            SafeArray<Fragment> safeArray5 = this.mRegisteredFragments;
            MainSmartCoolModeFragment mainSmartCoolModeFragment3 = this.mSmartCoolFragment;
            Intrinsics.checkNotNull(mainSmartCoolModeFragment3);
            safeArray5.add(0, mainSmartCoolModeFragment3);
            this.mCoolPageIndex = updateCoolPageIndex();
            this.mSmartCoolPageIndex = 0;
        }
        if (!this.mIsRegisterTag || !this.mIsSupportSmart) {
            i = 1;
        } else {
            MainSmartModeFragment newInstance$default = MainSmartModeFragment.Companion.newInstance$default(MainSmartModeFragment.Companion, (CurrentCoolHeatTypeCode) null, (SmartModePreference) null, (SmartModePreference) null, (Double) null, (Double) null, 31, (Object) null);
            this.mSmartFragment = newInstance$default;
            this.mRegisteredFragments.add(1, newInstance$default);
            this.mSmartPageIndex = 1;
            i = 2;
        }
        if (!this.mIsSupportSmart || !isShownSmartWarmBefore) {
            SafeArray<Fragment> safeArray6 = this.mRegisteredFragments;
            MainWarmFragment mainWarmFragment = this.mHeatFragment;
            Intrinsics.checkNotNull(mainWarmFragment);
            safeArray6.add(i, mainWarmFragment);
        } else {
            SafeArray<Fragment> safeArray7 = this.mRegisteredFragments;
            MainSmartWarmFragment mainSmartWarmFragment = this.mSmartWarmFragment;
            Intrinsics.checkNotNull(mainSmartWarmFragment);
            safeArray7.add(i, mainSmartWarmFragment);
        }
        this.mWarmPageIndex = i;
        this.mSmartWarmPageIndex = i;
        mBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        this.mSectionsPagerAdapter = new SectionsPagerAdapter(this, supportFragmentManager);
        View findViewById2 = findViewById(R.id.tabs);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type com.google.android.material.tabs.TabLayout");
        this.mTabLayout = (TabLayout) findViewById2;
        this.mDialogHelper = DialogHelperUtil.Companion.newInstance((FragmentActivity) this);
        View findViewById3 = findViewById(R.id.container);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type jp.co.sony.reonpocket.view.CustomViewPager");
        CustomViewPager customViewPager = (CustomViewPager) findViewById3;
        this.mViewPager = customViewPager;
        Intrinsics.checkNotNull(customViewPager);
        SectionsPagerAdapter sectionsPagerAdapter = this.mSectionsPagerAdapter;
        if (sectionsPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSectionsPagerAdapter");
            sectionsPagerAdapter = null;
        }
        customViewPager.setAdapter(sectionsPagerAdapter);
        CustomViewPager customViewPager2 = this.mViewPager;
        if (customViewPager2 != null) {
            customViewPager2.addOnPageChangeListener(this);
            Unit unit15 = Unit.INSTANCE;
        }
        CustomViewPager customViewPager3 = this.mViewPager;
        if (customViewPager3 != null) {
            customViewPager3.addOnPageChangeListener(this);
            Unit unit16 = Unit.INSTANCE;
            Unit unit17 = Unit.INSTANCE;
        }
        TabLayout tabLayout = this.mTabLayout;
        if (tabLayout != null) {
            TabLayout.Tab newTab = tabLayout.newTab();
            Intrinsics.checkNotNullExpressionValue(newTab, "newTab(...)");
            TabLayout.Tab newTab2 = tabLayout.newTab();
            Intrinsics.checkNotNullExpressionValue(newTab2, "newTab(...)");
            TabLayout.Tab newTab3 = tabLayout.newTab();
            Intrinsics.checkNotNullExpressionValue(newTab3, "newTab(...)");
            newTab.setTag(getString(R.string.mainview_content_mode_indicator_cool));
            newTab.setContentDescription((CharSequence) getString(R.string.accessibility_common_cool));
            newTab.setCustomView(Companion.Page.COOL.getLayout());
            newTab2.setTag(getString(R.string.mainview_content_mode_indicator_smart));
            newTab2.setContentDescription((CharSequence) getString(R.string.accessibility_common_smart));
            newTab2.setCustomView(Companion.Page.SMART.getLayout());
            newTab3.setTag(getString(R.string.mainview_content_mode_indicator_warm));
            newTab3.setContentDescription((CharSequence) getString(R.string.accessibility_common_warm));
            newTab3.setCustomView(Companion.Page.WARM.getLayout());
            tabLayout.addTab(newTab, true);
            this.mTabPages.add(Companion.Page.COOL);
            if (this.mIsRegisterTag && this.mIsSupportSmart) {
                tabLayout.addTab(newTab2, false);
                this.mTabPages.add(Companion.Page.SMART);
            }
            tabLayout.addTab(newTab3, false);
            this.mTabPages.add(Companion.Page.WARM);
            tabLayout.addOnTabSelectedListener(this);
            Unit unit18 = Unit.INSTANCE;
            Unit unit19 = Unit.INSTANCE;
        }
        this.mTagMiniInfoViewWrap = findViewById(R.id.tag_mini_info_wrap);
        this.mTagMiniInfoView = (TagMiniInfoView) findViewById(R.id.tag_mini_info);
        updateTagMiniInfoView();
        MainViewOutput mainViewOutput13 = this.mOutput;
        boolean isTagRegistered = mainViewOutput13 != null ? mainViewOutput13.isTagRegistered() : false;
        boolean isTagAvailableInThisCountry$default = TagInfoInteractorInput.DefaultImpls.isTagAvailableInThisCountry$default(this.mTagInfoInteractor, this, (String) null, 2, (Object) null);
        if (isTagRegistered) {
            TagMiniInfoView tagMiniInfoView2 = this.mTagMiniInfoView;
            if (tagMiniInfoView2 != null) {
                tagMiniInfoView2.updateTagInfoInitTagRegisterd();
                Unit unit20 = Unit.INSTANCE;
            }
        } else if (isTagAvailableInThisCountry$default && (tagMiniInfoView = this.mTagMiniInfoView) != null) {
            tagMiniInfoView.updateTagInfoUnregistered();
            Unit unit21 = Unit.INSTANCE;
        }
        TagMiniInfoView tagMiniInfoView3 = this.mTagMiniInfoView;
        if (tagMiniInfoView3 != null) {
            tagMiniInfoView3.setOutput(this);
        }
        this.isFirstOpen = false;
        View findViewById4 = findViewById(R.id.status_view);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        CustomDebugStatusView customDebugStatusView2 = (CustomDebugStatusView) findViewById4;
        this.mDebugStatusView = customDebugStatusView2;
        if (customDebugStatusView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDebugStatusView");
        } else {
            customDebugStatusView = customDebugStatusView2;
        }
        customDebugStatusView.setVisibility(4);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        BatteryChargeStatus batteryChargeStatus;
        Intrinsics.checkNotNullParameter(menu, "menu");
        ((AppCompatImageButton) findViewById(R.id.action_setting)).setOnClickListener(new MainActivity$$ExternalSyntheticLambda3(this));
        ((FrameLayout) findViewById(R.id.device_temp_view)).setOnClickListener(new MainActivity$$ExternalSyntheticLambda4(this));
        this.mBatteryRemain = (CustomFontTextView) findViewById(R.id.action_battery_remain);
        this.mPlugIcon = (CustomImageView) findViewById(R.id.action_plug);
        CustomImageView customImageView = (CustomImageView) findViewById(R.id.action_auto_start);
        this.mAutoStartIcon = customImageView;
        if (customImageView != null) {
            customImageView.setOnClickListener(new MainActivity$$ExternalSyntheticLambda5(this));
        }
        CustomImageView customImageView2 = this.mAutoStartIcon;
        int i = 0;
        if (customImageView2 != null) {
            MainViewOutput mainViewOutput = this.mOutput;
            Intrinsics.checkNotNull(mainViewOutput);
            customImageView2.setVisibility(mainViewOutput.getAutoStartState() ? 0 : 8);
        }
        CustomImageView customImageView3 = (CustomImageView) findViewById(R.id.action_cooling);
        this.mCoolingIcon = customImageView3;
        if (customImageView3 != null) {
            customImageView3.setOnClickListener(new MainActivity$$ExternalSyntheticLambda6(this));
        }
        this.mDeviceIcon = (CustomImageView) findViewById(R.id.action_device);
        this.mBatteryIcon = (CustomImageView) findViewById(R.id.action_battery);
        this.mBatteryFullIcon = (CustomImageView) findViewById(R.id.action_battery_full);
        CustomImageView customImageView4 = this.mPlugIcon;
        if (customImageView4 != null) {
            customImageView4.setContentDescription(getResources().getString(R.string.accessibility_battery_power_supply));
        }
        CustomImageView customImageView5 = this.mPlugIcon;
        if (customImageView5 != null) {
            customImageView5.setVisibility(8);
        }
        Bundle bundle = this.mBundleFromPreView;
        PowerSupplyStatus powerSupplyStatus = null;
        Integer valueOf = bundle != null ? Integer.valueOf(bundle.getInt(PairingActivityKt.TRANSIT_TO_MAIN_BATTERY_LEVEL)) : null;
        Bundle bundle2 = this.mBundleFromPreView;
        Integer valueOf2 = bundle2 != null ? Integer.valueOf(bundle2.getInt(PairingActivityKt.TRANSIT_TO_MAIN_BATTERY_CHARGE)) : null;
        Bundle bundle3 = this.mBundleFromPreView;
        Integer valueOf3 = bundle3 != null ? Integer.valueOf(bundle3.getInt(PairingActivityKt.TRANSIT_TO_MAIN_BATTERY_POWER_SUPPLY)) : null;
        Bundle bundle4 = this.mBundleFromPreView;
        int i2 = bundle4 != null ? bundle4.getInt(PairingActivityKt.TRANSIT_TO_MAIN_BATTERY_POWER_SUPPLY) : 65535;
        if (valueOf != null) {
            int intValue = valueOf.intValue();
            BatteryChargeStatus[] values = BatteryChargeStatus.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    batteryChargeStatus = null;
                    break;
                }
                batteryChargeStatus = values[i3];
                int code = batteryChargeStatus.getCode();
                if (valueOf2 != null && code == valueOf2.intValue()) {
                    break;
                }
                i3++;
            }
            if (batteryChargeStatus != null) {
                PowerSupplyStatus[] values2 = PowerSupplyStatus.values();
                int length2 = values2.length;
                while (true) {
                    if (i >= length2) {
                        break;
                    }
                    PowerSupplyStatus powerSupplyStatus2 = values2[i];
                    int code2 = powerSupplyStatus2.getCode();
                    if (valueOf3 != null && code2 == valueOf3.intValue()) {
                        powerSupplyStatus = powerSupplyStatus2;
                        break;
                    }
                    i++;
                }
                if (!(powerSupplyStatus == null || this.mBatteryIcon == null)) {
                    setBatteryState(new BatteryEntity(intValue, batteryChargeStatus, powerSupplyStatus, i2));
                }
            }
        }
        Bundle bundle5 = this.mBundleFromPreView;
        if (bundle5 == null) {
            return true;
        }
        bundle5.clear();
        return true;
    }

    /* access modifiers changed from: private */
    public static final void onCreateOptionsMenu$lambda$21$lambda$20(MainActivity mainActivity, View view) {
        Intrinsics.checkNotNullParameter(mainActivity, "this$0");
        MainViewOutput mainViewOutput = mainActivity.mOutput;
        if (mainViewOutput != null) {
            mainViewOutput.transitToSetting();
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreateOptionsMenu$lambda$23$lambda$22(MainActivity mainActivity, View view) {
        Integer num;
        Intrinsics.checkNotNullParameter(mainActivity, "this$0");
        if (mainActivity.mErrorStack.size() > 0) {
            num = Integer.valueOf(mainActivity.mErrorStack.pop().getCode());
        } else {
            DeviceInfoConstants deviceInfoConstants = mainActivity.mDeviceErrorCode;
            num = deviceInfoConstants != null ? Integer.valueOf(deviceInfoConstants.getCode()) : null;
        }
        MainViewOutput mainViewOutput = mainActivity.mOutput;
        if (mainViewOutput != null) {
            mainViewOutput.transitToDeviceInfo(Integer.valueOf(num != null ? num.intValue() : -1));
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreateOptionsMenu$lambda$24(MainActivity mainActivity, View view) {
        Intrinsics.checkNotNullParameter(mainActivity, "this$0");
        DialogHelperUtil dialogHelperUtil = mainActivity.mDialogHelper;
        if (dialogHelperUtil == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil = null;
        }
        dialogHelperUtil.showConfirmationDialog(R.string.setting_auto_start_icon_title, R.string.setting_auto_start_icon_description, 0, DialogHelperUtil.RequestCode.NO_REQUEST.ordinal(), (Integer) 0, Integer.valueOf(R.string.common_ok));
    }

    /* access modifiers changed from: private */
    public static final void onCreateOptionsMenu$lambda$25(MainActivity mainActivity, View view) {
        Intrinsics.checkNotNullParameter(mainActivity, "this$0");
        DialogHelperUtil dialogHelperUtil = mainActivity.mDialogHelper;
        if (dialogHelperUtil == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil = null;
        }
        dialogHelperUtil.showConfirmationDialog(R.string.setting_waste_heat_message_title, R.string.setting_waste_heat_message_description, 0, DialogHelperUtil.RequestCode.NO_REQUEST.ordinal(), (Integer) 0, Integer.valueOf(R.string.common_ok));
    }

    public final void transitToCool() {
        setCoolFragment();
        DeviceModeEntity deviceModeEntity = r0;
        DeviceModeEntity deviceModeEntity2 = new DeviceModeEntity(DeviceModeActionCode.MANUAL, DeviceModeSettingTriggerCode.SET_DEVICE_MODE, (DeviceCoolingCode) null, (ContinuousOperationStatus) null, (SwitchCoolHeatWaitStatus) null, CoolHeatTypeCode.OFF_COOL, (DeviceModeEntity.Temperature) null, (ModeCommonSettingOperation) null, (Integer) null, TempStepCode.OFF, TempBoostOption.NONE, TempWaveOption.WAVE_OFF, (Integer) null, 0, (Integer) null, (MyModeActionType) null, (MyModeSpecialSubMode) null, (Integer) null, (Integer) null, (MyModeOperationCode) null, (Integer) null, (MyModeTypeCode) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyTempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (FanStepCode) null, -32292, 63, (DefaultConstructorMarker) null);
        MainViewOutput mainViewOutput = this.mOutput;
        if (mainViewOutput != null) {
            mainViewOutput.writeDeviceMode(deviceModeEntity);
        }
    }

    private final void setCoolFragment() {
        MainCoolFragment mainCoolFragment = this.mCoolFragment;
        if (mainCoolFragment == null) {
            mainCoolFragment = MainCoolFragment.Companion.newInstance$default(MainCoolFragment.Companion, 0, (DeviceModeActionCode) null, (TempWaveOption) null, 7, (Object) null);
        }
        this.mCoolFragment = mainCoolFragment;
        this.mRegisteredFragments.set(this.mCoolPageIndex, mainCoolFragment);
        SectionsPagerAdapter sectionsPagerAdapter = this.mSectionsPagerAdapter;
        if (sectionsPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSectionsPagerAdapter");
            sectionsPagerAdapter = null;
        }
        sectionsPagerAdapter.notifyDataSetChanged();
    }

    public final void transitToWarm() {
        setWarmFragment();
        DeviceModeEntity deviceModeEntity = r1;
        DeviceModeEntity deviceModeEntity2 = new DeviceModeEntity(DeviceModeActionCode.MANUAL, DeviceModeSettingTriggerCode.SET_DEVICE_MODE, (DeviceCoolingCode) null, (ContinuousOperationStatus) null, (SwitchCoolHeatWaitStatus) null, CoolHeatTypeCode.OFF_HEAT, (DeviceModeEntity.Temperature) null, (ModeCommonSettingOperation) null, (Integer) null, TempStepCode.OFF, TempBoostOption.NONE, TempWaveOption.WAVE_OFF, (Integer) null, 0, (Integer) null, (MyModeActionType) null, (MyModeSpecialSubMode) null, (Integer) null, (Integer) null, (MyModeOperationCode) null, (Integer) null, (MyModeTypeCode) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyTempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (FanStepCode) null, -32292, 63, (DefaultConstructorMarker) null);
        MainViewOutput mainViewOutput = this.mOutput;
        DeviceModeEntity deviceModeEntity3 = deviceModeEntity;
        if (mainViewOutput != null) {
            mainViewOutput.writeDeviceMode(deviceModeEntity3);
        }
        sendCoolWarmChangeLogToFA(deviceModeEntity3);
    }

    private final void setWarmFragment() {
        MainWarmFragment mainWarmFragment = this.mHeatFragment;
        SectionsPagerAdapter sectionsPagerAdapter = null;
        if (mainWarmFragment == null) {
            mainWarmFragment = MainWarmFragment.Companion.newInstance$default(MainWarmFragment.Companion, 0, (DeviceModeActionCode) null, 3, (Object) null);
        }
        this.mHeatFragment = mainWarmFragment;
        this.mRegisteredFragments.set(this.mWarmPageIndex, mainWarmFragment);
        SectionsPagerAdapter sectionsPagerAdapter2 = this.mSectionsPagerAdapter;
        if (sectionsPagerAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSectionsPagerAdapter");
        } else {
            sectionsPagerAdapter = sectionsPagerAdapter2;
        }
        sectionsPagerAdapter.notifyDataSetChanged();
    }

    public final void transitToSmartCool(boolean z) {
        SmartModePreference smartModePreference;
        if (z) {
            MainViewOutput mainViewOutput = this.mOutput;
            if (mainViewOutput == null || (smartModePreference = mainViewOutput.getSmartCoolPreference()) == null) {
                smartModePreference = SmartModePreference.OFF;
            }
        } else {
            smartModePreference = SmartModePreference.OFF;
        }
        setSmartCoolFragment(smartModePreference);
        MainSmartCoolModeFragment mainSmartCoolModeFragment = this.mSmartCoolFragment;
        if (mainSmartCoolModeFragment != null) {
            mainSmartCoolModeFragment.doSmartCoolSetting(smartModePreference);
        }
    }

    private final void setSmartCoolFragment(SmartModePreference smartModePreference) {
        MainSmartCoolModeFragment mainSmartCoolModeFragment;
        MainSmartCoolModeFragment mainSmartCoolModeFragment2 = this.mSmartCoolFragment;
        if (mainSmartCoolModeFragment2 == null) {
            if (smartModePreference == SmartModePreference.OFF) {
                mainSmartCoolModeFragment = MainSmartCoolModeFragment.Companion.newInstance(CurrentCoolHeatTypeCode.OFF, smartModePreference);
            } else {
                mainSmartCoolModeFragment = MainSmartCoolModeFragment.Companion.newInstance(CurrentCoolHeatTypeCode.COOL, smartModePreference);
            }
            mainSmartCoolModeFragment2 = mainSmartCoolModeFragment;
        }
        this.mSmartCoolFragment = mainSmartCoolModeFragment2;
        this.mRegisteredFragments.set(this.mCoolPageIndex, mainSmartCoolModeFragment2);
        SectionsPagerAdapter sectionsPagerAdapter = this.mSectionsPagerAdapter;
        if (sectionsPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSectionsPagerAdapter");
            sectionsPagerAdapter = null;
        }
        sectionsPagerAdapter.notifyDataSetChanged();
    }

    private final void transitToSmart(boolean z) {
        setSmartFragment();
        MainViewOutput mainViewOutput = this.mOutput;
        double d = -128.0d;
        double smartCoolTempSwitchThreshold = mainViewOutput != null ? mainViewOutput.getSmartCoolTempSwitchThreshold() : -128.0d;
        MainViewOutput mainViewOutput2 = this.mOutput;
        if (mainViewOutput2 != null) {
            d = mainViewOutput2.getSmartWarmTempSwitchThreshold();
        }
        MainViewOutput mainViewOutput3 = this.mOutput;
        SmartModePreference smartCoolPreference = mainViewOutput3 != null ? mainViewOutput3.getSmartCoolPreference() : null;
        MainViewOutput mainViewOutput4 = this.mOutput;
        SmartModePreference smartWarmPreference = mainViewOutput4 != null ? mainViewOutput4.getSmartWarmPreference() : null;
        if (smartCoolPreference == SmartModePreference.OFF || smartCoolPreference == null || smartWarmPreference == null) {
            MainSmartModeFragment mainSmartModeFragment = this.mSmartFragment;
            if (mainSmartModeFragment != null) {
                mainSmartModeFragment.doSmartSetting(z, smartCoolTempSwitchThreshold, d);
                return;
            }
            return;
        }
        MainSmartModeFragment mainSmartModeFragment2 = this.mSmartFragment;
        if (mainSmartModeFragment2 != null) {
            mainSmartModeFragment2.doSmartSetting(z, smartCoolPreference, smartWarmPreference, smartCoolTempSwitchThreshold, d);
        }
    }

    private final void setSmartFragment() {
        MainSmartModeFragment mainSmartModeFragment = this.mSmartFragment;
        if (mainSmartModeFragment == null) {
            mainSmartModeFragment = MainSmartModeFragment.Companion.newInstance$default(MainSmartModeFragment.Companion, (CurrentCoolHeatTypeCode) null, (SmartModePreference) null, (SmartModePreference) null, (Double) null, (Double) null, 31, (Object) null);
        }
        this.mSmartFragment = mainSmartModeFragment;
        this.mRegisteredFragments.set(this.mSmartPageIndex, mainSmartModeFragment);
        SectionsPagerAdapter sectionsPagerAdapter = this.mSectionsPagerAdapter;
        if (sectionsPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSectionsPagerAdapter");
            sectionsPagerAdapter = null;
        }
        sectionsPagerAdapter.notifyDataSetChanged();
    }

    public final void transitToSmartWarm(boolean z) {
        SmartModePreference smartModePreference;
        if (z) {
            MainViewOutput mainViewOutput = this.mOutput;
            if (mainViewOutput == null || (smartModePreference = mainViewOutput.getSmartWarmPreference()) == null) {
                smartModePreference = SmartModePreference.OFF;
            }
        } else {
            smartModePreference = SmartModePreference.OFF;
        }
        setSmartWarmFragment(smartModePreference);
        MainSmartWarmFragment mainSmartWarmFragment = this.mSmartWarmFragment;
        if (mainSmartWarmFragment != null) {
            mainSmartWarmFragment.doSmartWarmSetting(smartModePreference);
        }
    }

    private final void setSmartWarmFragment(SmartModePreference smartModePreference) {
        CurrentCoolHeatTypeCode currentCoolHeatTypeCode;
        MainSmartWarmFragment mainSmartWarmFragment = this.mSmartWarmFragment;
        if (mainSmartWarmFragment == null) {
            if (smartModePreference == SmartModePreference.OFF) {
                currentCoolHeatTypeCode = CurrentCoolHeatTypeCode.OFF;
            } else {
                currentCoolHeatTypeCode = CurrentCoolHeatTypeCode.HEAT;
            }
            mainSmartWarmFragment = MainSmartWarmFragment.Companion.newInstance(currentCoolHeatTypeCode, smartModePreference);
        }
        this.mSmartWarmFragment = mainSmartWarmFragment;
        this.mRegisteredFragments.set(this.mWarmPageIndex, mainSmartWarmFragment);
        SectionsPagerAdapter sectionsPagerAdapter = this.mSectionsPagerAdapter;
        if (sectionsPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSectionsPagerAdapter");
            sectionsPagerAdapter = null;
        }
        sectionsPagerAdapter.notifyDataSetChanged();
    }

    public void updateDeviceInfo(DeviceInfoConstants deviceInfoConstants) {
        Intrinsics.checkNotNullParameter(deviceInfoConstants, "aInfoCode");
        switch (WhenMappings.$EnumSwitchMapping$0[deviceInfoConstants.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                this.mDeviceErrorCode = deviceInfoConstants;
                return;
            default:
                if (deviceInfoConstants == DeviceInfoConstants.EXCEPTION_CANNOT_CHARGING_CAUSE_HIGH_TEMP || deviceInfoConstants == DeviceInfoConstants.EXCEPTION_CANNOT_CHARGING || deviceInfoConstants == DeviceInfoConstants.EXCEPTION_CANNOT_CHARGING_UNKNOWN) {
                    CustomImageView customImageView = this.mBatteryIcon;
                    if (customImageView != null) {
                        customImageView.setImageResource(R.drawable.ic_battery_temperature_anomaly);
                    }
                    CustomImageView customImageView2 = this.mBatteryIcon;
                    if (customImageView2 != null) {
                        customImageView2.setContentDescription(getResources().getString(R.string.accessibility_battery_temperature_error));
                    }
                }
                if (this.mErrorStack.search(deviceInfoConstants) <= 1) {
                    this.mErrorStack.push(deviceInfoConstants);
                    return;
                }
                return;
        }
    }

    public void updateIsAutoStartEnable(boolean z) {
        MainViewOutput mainViewOutput = this.mOutput;
        Intrinsics.checkNotNull(mainViewOutput);
        if (z != mainViewOutput.getAutoStartState()) {
            MainViewOutput mainViewOutput2 = this.mOutput;
            Intrinsics.checkNotNull(mainViewOutput2);
            mainViewOutput2.saveAutoStartState(z);
        }
        CustomImageView customImageView = this.mAutoStartIcon;
        if (customImageView != null) {
            customImageView.setVisibility(z ? 0 : 8);
        }
    }

    public void updateIsAlert(boolean z) {
        this.mIsDeviceAlert = z;
        if (!z) {
            CollectionsKt.removeAll(this.mErrorStack, (T[]) new DeviceInfoConstants[]{DeviceInfoConstants.EXCEPTION_INTERNAL_HIGH_TEMP, DeviceInfoConstants.EXCEPTION_INTERNAL_LOW_TEMP, DeviceInfoConstants.EXCEPTION_FAN_STOP, DeviceInfoConstants.EXCEPTION_DEVICE_STOP});
            if (this.mErrorStack.size() > 0) {
                return;
            }
        }
        updateDeviceImage();
    }

    public void updateDeviceTemp(float f) {
        this.currentDeviceTemp = Float.valueOf(f);
        updateDeviceImage();
    }

    private final void updateDeviceImage() {
        int i;
        Float f = this.currentDeviceTemp;
        if (f != null) {
            float floatValue = f.floatValue();
            DeviceTemperatureView.TemperatureThresholdEntity mTemperatureThresholdEntity = RemoteConfigUtil.INSTANCE.getMTemperatureThresholdEntity();
            float minTemp = mTemperatureThresholdEntity != null ? mTemperatureThresholdEntity.getMinTemp() : 26.0f;
            float midTemp = mTemperatureThresholdEntity != null ? mTemperatureThresholdEntity.getMidTemp() : 32.8f;
            float maxTemp = mTemperatureThresholdEntity != null ? mTemperatureThresholdEntity.getMaxTemp() : 39.6f;
            CustomImageView customImageView = this.mDeviceIcon;
            if (customImageView != null) {
                if (this.mIsDeviceAlert) {
                    if (floatValue < minTemp) {
                        i = R.drawable.ic_device_temp_caution_01;
                    } else {
                        float f2 = midTemp - minTemp;
                        if (floatValue < minTemp + (f2 * 0.4f)) {
                            i = R.drawable.ic_device_temp_caution_02;
                        } else {
                            float f3 = (float) 5;
                            if (floatValue < midTemp - (f2 / f3)) {
                                i = R.drawable.ic_device_temp_caution_03;
                            } else {
                                float f4 = maxTemp - midTemp;
                                if (floatValue < midTemp + (f4 / f3)) {
                                    i = R.drawable.ic_device_temp_caution_04;
                                } else if (floatValue < maxTemp - (f4 * 0.4f)) {
                                    i = R.drawable.ic_device_temp_caution_05;
                                } else if (floatValue < maxTemp) {
                                    i = R.drawable.ic_device_temp_caution_06;
                                } else {
                                    i = R.drawable.ic_device_temp_caution_07;
                                }
                            }
                        }
                    }
                } else if (floatValue < minTemp) {
                    i = R.drawable.ic_device_temp_01;
                } else {
                    float f5 = midTemp - minTemp;
                    if (floatValue < minTemp + (f5 * 0.4f)) {
                        i = R.drawable.ic_device_temp_02;
                    } else {
                        float f6 = (float) 5;
                        if (floatValue < midTemp - (f5 / f6)) {
                            i = R.drawable.ic_device_temp_03;
                        } else {
                            float f7 = maxTemp - midTemp;
                            if (floatValue < midTemp + (f7 / f6)) {
                                i = R.drawable.ic_device_temp_04;
                            } else if (floatValue < maxTemp - (f7 * 0.4f)) {
                                i = R.drawable.ic_device_temp_05;
                            } else if (floatValue < maxTemp) {
                                i = R.drawable.ic_device_temp_06;
                            } else {
                                i = R.drawable.ic_device_temp_07;
                            }
                        }
                    }
                }
                customImageView.setImageResource(i);
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainActivity$SectionsPagerAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "(Ljp/co/sony/reonpocket/modules/main/view/MainActivity;Landroidx/fragment/app/FragmentManager;)V", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "getItemPosition", "object", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainActivity.kt */
    public final class SectionsPagerAdapter extends FragmentStatePagerAdapter {
        final /* synthetic */ MainActivity this$0;

        public int getItemPosition(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "object");
            return -2;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SectionsPagerAdapter(MainActivity mainActivity, FragmentManager fragmentManager) {
            super(fragmentManager);
            Intrinsics.checkNotNullParameter(fragmentManager, "fm");
            this.this$0 = mainActivity;
        }

        public Fragment getItem(int i) {
            Fragment fragment = (Fragment) this.this$0.mRegisteredFragments.get(i);
            if (fragment != null) {
                return fragment;
            }
            DebugLogUtil.INSTANCE.e("There are no fragments that match the specified index.");
            return new Fragment();
        }

        public int getCount() {
            return this.this$0.mRegisteredFragments.size();
        }
    }

    private final void showToast(Context context, String str) {
        Toast toast = this.mToast;
        if (toast == null) {
            this.mToast = Toast.makeText(context, str, 0);
        } else {
            Intrinsics.checkNotNull(toast);
            toast.setText(str);
        }
        Toast toast2 = this.mToast;
        Intrinsics.checkNotNull(toast2);
        toast2.show();
    }

    public void requestForStoreReview() {
        ReviewInfo reviewInfo = this.mReviewInfo;
        if (reviewInfo != null) {
            ReviewManager reviewManager = this.mReviewManager;
            if (reviewManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mReviewManager");
                reviewManager = null;
            }
            Task<Void> launchReviewFlow = reviewManager.launchReviewFlow(this, reviewInfo);
            Intrinsics.checkNotNullExpressionValue(launchReviewFlow, "launchReviewFlow(...)");
            launchReviewFlow.addOnCompleteListener(new MainActivity$$ExternalSyntheticLambda7());
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        MainViewOutput mainViewOutput = this.mOutput;
        if (mainViewOutput != null) {
            mainViewOutput.readBattery();
        }
    }

    public void showRequestBackgroundLocationDialog(boolean z) {
        DialogHelperUtil dialogHelperUtil;
        Unit unit;
        DataDialogFragment dataDialogFragment = this.mRequestLocationDialog;
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
        DataDialogFragment showDataDialog$default = DialogHelperUtil.showDataDialog$default(dialogHelperUtil, 0, BaseDialogFragment.Builder.DialogType.INFORMATION_PATTERN_3, DialogHelperUtil.RequestCode.INFORMATION.ordinal(), 0, 0, 0, 32, (Object) null);
        this.mRequestLocationDialog = showDataDialog$default;
        if (showDataDialog$default != null) {
            showDataDialog$default.setLifecycleListener(new MainActivity$showRequestBackgroundLocationDialog$2$1(this, z));
            Unit unit2 = Unit.INSTANCE;
        }
    }

    private final void requestNotificationPermission() {
        if (checkSelfPermission("android.permission.POST_NOTIFICATIONS") == -1) {
            this.requestPermissionLauncher.launch("android.permission.POST_NOTIFICATIONS");
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        MainViewOutput mainViewOutput;
        super.onResume();
        if (this.mOutput != null) {
            if (!PermissionUtil.INSTANCE.isLocationPermissionsGranted(this) && (mainViewOutput = this.mOutput) != null) {
                MainViewOutput.DefaultImpls.transitToConnection$default(mainViewOutput, (Bundle) null, 1, (Object) null);
            }
            if (this.mIsTransit) {
                Bundle bundle = new Bundle();
                bundle.putString(MainActivityKt.MAIN_ACTIVITY_ERROR_REASON, this.mErrorMessage);
                MainViewOutput mainViewOutput2 = this.mOutput;
                if (mainViewOutput2 != null) {
                    mainViewOutput2.transitToConnection(bundle);
                    return;
                }
                return;
            }
            MainViewOutput mainViewOutput3 = this.mOutput;
            Intrinsics.checkNotNull(mainViewOutput3);
            if (!mainViewOutput3.isConnected()) {
                MainViewOutput mainViewOutput4 = this.mOutput;
                if (mainViewOutput4 != null) {
                    mainViewOutput4.transitToSplash();
                    return;
                }
                return;
            }
            CustomImageView customImageView = this.mAutoStartIcon;
            if (customImageView != null) {
                MainViewOutput mainViewOutput5 = this.mOutput;
                Intrinsics.checkNotNull(mainViewOutput5);
                customImageView.setVisibility(mainViewOutput5.getAutoStartState() ? 0 : 8);
            }
            MainViewOutput mainViewOutput6 = this.mOutput;
            if (mainViewOutput6 != null) {
                mainViewOutput6.readAutoStart();
            }
            MainViewOutput mainViewOutput7 = this.mOutput;
            boolean isRegisterTag = mainViewOutput7 != null ? mainViewOutput7.getIsRegisterTag() : this.mIsRegisterTag;
            if (this.mIsRegisterTag != isRegisterTag) {
                updateShowSmartMode(isRegisterTag);
                this.mIsRegisterTag = isRegisterTag;
            }
            readDeviceMode();
        }
    }

    private final void changeWarmMode(boolean z) {
        boolean z2 = this.mRegisteredFragments.get(this.mWarmPageIndex) instanceof MainSmartWarmFragment;
        if (!z && z2) {
            TabLayout tabLayout = this.mTabLayout;
            if (tabLayout != null) {
                tabLayout.removeOnTabSelectedListener(this);
            }
            TabLayout tabLayout2 = this.mTabLayout;
            if (tabLayout2 != null) {
                tabLayout2.removeTabAt(this.mWarmPageIndex);
            }
            TabLayout tabLayout3 = this.mTabLayout;
            if (tabLayout3 != null) {
                tabLayout3.addOnTabSelectedListener(this);
            }
            this.mRegisteredFragments.removeAt(this.mWarmPageIndex);
            this.mTabPages.remove(this.mWarmPageIndex);
            MainViewOutput mainViewOutput = this.mOutput;
            this.mWarmPageIndex = updateWarmPageIndex(mainViewOutput != null ? mainViewOutput.getIsRegisterTag() : false);
            TabLayout tabLayout4 = this.mTabLayout;
            if (tabLayout4 != null) {
                TabLayout.Tab newTab = tabLayout4.newTab();
                newTab.setTag(getString(R.string.mainview_content_mode_indicator_warm));
                newTab.setContentDescription((CharSequence) getString(R.string.accessibility_common_warm));
                newTab.setCustomView(Companion.Page.WARM.getLayout());
                tabLayout4.addTab(newTab, this.mWarmPageIndex);
            }
            SectionsPagerAdapter sectionsPagerAdapter = null;
            this.mRegisteredFragments.add(this.mWarmPageIndex, MainWarmFragment.Companion.newInstance$default(MainWarmFragment.Companion, 0, (DeviceModeActionCode) null, 3, (Object) null));
            SectionsPagerAdapter sectionsPagerAdapter2 = this.mSectionsPagerAdapter;
            if (sectionsPagerAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSectionsPagerAdapter");
            } else {
                sectionsPagerAdapter = sectionsPagerAdapter2;
            }
            sectionsPagerAdapter.notifyDataSetChanged();
            this.mTabPages.add(this.mWarmPageIndex, Companion.Page.WARM);
        }
    }

    public BaseViewOutput initPresenter() {
        MainViewOutput mainPresenter = new MainPresenter(this, this);
        this.mOutput = mainPresenter;
        Intrinsics.checkNotNull(mainPresenter, "null cannot be cast to non-null type jp.co.sony.reonpocket.modules.main.presenter.MainPresenter");
        return (MainPresenter) mainPresenter;
    }

    public void onConnectionStatus(BleConnStatusCode bleConnStatusCode, ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(bleConnStatusCode, "aConnStatusCode");
        if (!isAppOnForeground()) {
            this.mIsTransit = true;
            BaseActivity.ActivityReferenceUtil.INSTANCE.finishOtherActivity(getClass());
        } else if (bleConnStatusCode != BleConnStatusCode.CONNECTED) {
            Bundle bundle = new Bundle();
            bundle.putString(MainActivityKt.MAIN_ACTIVITY_ERROR_REASON, this.mErrorMessage);
            MainViewOutput mainViewOutput = this.mOutput;
            if (mainViewOutput != null) {
                mainViewOutput.transitToConnection(bundle);
            }
        }
    }

    public void onFail(String str) {
        Intrinsics.checkNotNullParameter(str, "aErrorMessage");
        this.mErrorMessage = str;
        showErrorDialog(str);
    }

    public void onBatteryStateChange(BatteryEntity batteryEntity) {
        Intrinsics.checkNotNullParameter(batteryEntity, "aBatteryEntity");
        setBatteryState(batteryEntity);
    }

    public void onPageSelected(int i) {
        TabLayout.Tab tabAt;
        if (!this.mIsFirstOperate) {
            this.mLastSelectedPage = this.mTabPages.get(i);
            CustomViewPager customViewPager = this.mViewPager;
            if (customViewPager != null) {
                customViewPager.removeOnPageChangeListener(this);
            }
            TabLayout tabLayout = this.mTabLayout;
            if (tabLayout != null) {
                tabLayout.removeOnTabSelectedListener(this);
            }
            TabLayout tabLayout2 = this.mTabLayout;
            if (!(tabLayout2 == null || (tabAt = tabLayout2.getTabAt(i)) == null)) {
                tabAt.select();
            }
            CustomViewPager customViewPager2 = this.mViewPager;
            if (customViewPager2 != null) {
                customViewPager2.addOnPageChangeListener(this);
            }
            TabLayout tabLayout3 = this.mTabLayout;
            if (tabLayout3 != null) {
                tabLayout3.addOnTabSelectedListener(this);
            }
            MainViewOutput mainViewOutput = this.mOutput;
            if (mainViewOutput != null) {
                mainViewOutput.savePagePosition(i);
            }
        }
        resetSlider(i);
    }

    private final void resetSlider(int i) {
        SectionsPagerAdapter sectionsPagerAdapter = this.mSectionsPagerAdapter;
        if (sectionsPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSectionsPagerAdapter");
            sectionsPagerAdapter = null;
        }
        Fragment item = sectionsPagerAdapter.getItem(i);
        if (item instanceof MainCoolFragment) {
            updateWarmOff();
        } else if (item instanceof MainWarmFragment) {
            updateCoolOff();
        }
    }

    private final void showModeSwitchProgressDialog() {
        this.isShowingModeSwitchProgress = true;
        DialogHelperUtil dialogHelperUtil = this.mDialogHelper;
        if (dialogHelperUtil == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil = null;
        }
        String string = getString(R.string.mainview_wait_dialog_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        DialogInterface showProgressDialog = dialogHelperUtil.showProgressDialog(string, SWITCH_MODE_PROGRESS_DIALOG_TAG, false);
        Intrinsics.checkNotNull(showProgressDialog, "null cannot be cast to non-null type jp.co.sony.reonpocket.view.fragment.ProgressDialogFragment");
        this.mModeSwitchProgressDialog = (ProgressDialogFragment) showProgressDialog;
    }

    /* access modifiers changed from: private */
    public final void showProgressDialog() {
        this.isShowingProgress = true;
        DialogHelperUtil dialogHelperUtil = this.mDialogHelper;
        if (dialogHelperUtil == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil = null;
        }
        DialogInterface showProgressDialog = dialogHelperUtil.showProgressDialog(this.mProgressMessage, "progress_dialog_tag", false);
        Intrinsics.checkNotNull(showProgressDialog, "null cannot be cast to non-null type jp.co.sony.reonpocket.view.fragment.ProgressDialogFragment");
        this.mProgressDialog = (ProgressDialogFragment) showProgressDialog;
    }

    private final void sendCoolWarmChangeLogToFA(DeviceModeEntity deviceModeEntity) {
        CoolHeatTypeCode coolHeatTypeCode;
        String str;
        String str2;
        List<Companion.Page> list = this.mTabPages;
        CustomViewPager customViewPager = this.mViewPager;
        Intrinsics.checkNotNull(customViewPager);
        int i = WhenMappings.$EnumSwitchMapping$1[list.get(customViewPager.getCurrentItem()).ordinal()];
        if (i == 1) {
            coolHeatTypeCode = CoolHeatTypeCode.COOL;
        } else if (i == 2) {
            coolHeatTypeCode = CoolHeatTypeCode.HEAT;
        } else {
            return;
        }
        if (deviceModeEntity.getTemperature() != null && deviceModeEntity.getBoostOption() != null) {
            Bundle bundle = new Bundle();
            if (coolHeatTypeCode == CoolHeatTypeCode.COOL) {
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
                        str2 = AnalyticsUtil.ParameterConstants.BOOST.getValue();
                    } else {
                        TempStepCode temperature2 = deviceModeEntity.getTemperature();
                        Intrinsics.checkNotNull(temperature2);
                        str2 = String.valueOf(temperature2.getCode() + 1);
                    }
                    bundle.putString(value, str2);
                }
            }
            if (coolHeatTypeCode == CoolHeatTypeCode.HEAT) {
                bundle.putString(AnalyticsUtil.EventParameter.COOL_WARM.getValue(), AnalyticsUtil.ParameterConstants.WARM.getValue());
                TempStepCode temperature3 = deviceModeEntity.getTemperature();
                Intrinsics.checkNotNull(temperature3);
                if (temperature3 == TempStepCode.OFF) {
                    bundle.putInt(AnalyticsUtil.EventParameter.TEMP.getValue(), Integer.parseInt(AnalyticsUtil.ParameterConstants.LEVEl_OFF.getValue()));
                } else {
                    String value2 = AnalyticsUtil.EventParameter.TEMP.getValue();
                    TempBoostOption boostOption2 = deviceModeEntity.getBoostOption();
                    Intrinsics.checkNotNull(boostOption2);
                    if (boostOption2 == TempBoostOption.BOOST) {
                        str = AnalyticsUtil.ParameterConstants.BOOST.getValue();
                    } else {
                        TempStepCode temperature4 = deviceModeEntity.getTemperature();
                        Intrinsics.checkNotNull(temperature4);
                        str = String.valueOf(temperature4.getCode() + 1);
                    }
                    bundle.putString(value2, str);
                }
            }
            AnalyticsUtil.INSTANCE.logEventWithBundle(this, getMFirebaseAnalytics(), AnalyticsUtil.EventName.MANUAL_COOL_WARM_CHANGE, bundle);
        }
    }

    public final void setTempSettingValue(int i) {
        this.mTempSettingValue = i;
    }

    public void updateActionMode(BleDataEntity bleDataEntity, DeviceModeEntity deviceModeEntity) {
        TemperatureCoolHeatTypeCode temperatureCoolHeatTypeCode;
        TabLayout.Tab tabAt;
        TabLayout.Tab tabAt2;
        TabLayout.Tab tabAt3;
        Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
        Intrinsics.checkNotNullParameter(deviceModeEntity, "aDeviceModeEntity");
        DeviceModeEntity.Temperature temperatureEntity = deviceModeEntity.getTemperatureEntity();
        TabLayout tabLayout = this.mTabLayout;
        if (tabLayout != null) {
            tabLayout.removeOnTabSelectedListener(this);
        }
        if (temperatureEntity != null) {
            temperatureCoolHeatTypeCode = temperatureEntity.getTempCoolHeatType();
        } else {
            temperatureCoolHeatTypeCode = null;
        }
        int i = temperatureCoolHeatTypeCode == null ? -1 : WhenMappings.$EnumSwitchMapping$2[temperatureCoolHeatTypeCode.ordinal()];
        if (i == 1) {
            if (getSmartCoolFragmentPageIndex() < 0) {
                setSmartCoolFragment(temperatureEntity.getCoolPreference());
                MainSmartCoolModeFragment mainSmartCoolModeFragment = this.mSmartCoolFragment;
                if (mainSmartCoolModeFragment != null) {
                    mainSmartCoolModeFragment.applyBleDataEntity(bleDataEntity);
                }
            }
            TabLayout tabLayout2 = this.mTabLayout;
            if (!(tabLayout2 == null || (tabAt = tabLayout2.getTabAt(this.mCoolPageIndex)) == null)) {
                tabAt.select();
            }
            this.mLastSelectedPage = Companion.Page.SMARTCOOL;
            CustomViewPager customViewPager = this.mViewPager;
            Intrinsics.checkNotNull(customViewPager);
            customViewPager.setCurrentItem(this.mCoolPageIndex);
        } else if (i == 2) {
            if (getSmartFragmentPageIndex() < 0) {
                setSmartFragment();
                MainSmartModeFragment mainSmartModeFragment = this.mSmartFragment;
                if (mainSmartModeFragment != null) {
                    mainSmartModeFragment.applyBleDataEntity(bleDataEntity);
                }
            }
            TabLayout tabLayout3 = this.mTabLayout;
            if (!(tabLayout3 == null || (tabAt2 = tabLayout3.getTabAt(this.mSmartPageIndex)) == null)) {
                tabAt2.select();
            }
            this.mLastSelectedPage = Companion.Page.SMART;
            CustomViewPager customViewPager2 = this.mViewPager;
            Intrinsics.checkNotNull(customViewPager2);
            customViewPager2.setCurrentItem(this.mSmartPageIndex);
        } else if (i == 3) {
            if (getSmartWarmFragmentPageIndex() < 0) {
                setSmartWarmFragment(temperatureEntity.getHeatPreference());
                MainSmartWarmFragment mainSmartWarmFragment = this.mSmartWarmFragment;
                if (mainSmartWarmFragment != null) {
                    mainSmartWarmFragment.applyBleDataEntity(bleDataEntity);
                }
            }
            TabLayout tabLayout4 = this.mTabLayout;
            if (!(tabLayout4 == null || (tabAt3 = tabLayout4.getTabAt(this.mWarmPageIndex)) == null)) {
                tabAt3.select();
            }
            this.mLastSelectedPage = Companion.Page.SMARTWARM;
            CustomViewPager customViewPager3 = this.mViewPager;
            Intrinsics.checkNotNull(customViewPager3);
            customViewPager3.setCurrentItem(this.mWarmPageIndex);
        }
        TabLayout tabLayout5 = this.mTabLayout;
        if (tabLayout5 != null) {
            tabLayout5.addOnTabSelectedListener(this);
        }
    }

    private final int getSmartWarmFragmentPageIndex() {
        SectionsPagerAdapter sectionsPagerAdapter = this.mSectionsPagerAdapter;
        if (sectionsPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSectionsPagerAdapter");
            sectionsPagerAdapter = null;
        }
        if (sectionsPagerAdapter.getItem(this.mWarmPageIndex) instanceof MainSmartWarmFragment) {
            return this.mWarmPageIndex;
        }
        return -1;
    }

    private final int getSmartCoolFragmentPageIndex() {
        SectionsPagerAdapter sectionsPagerAdapter = this.mSectionsPagerAdapter;
        if (sectionsPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSectionsPagerAdapter");
            sectionsPagerAdapter = null;
        }
        if (sectionsPagerAdapter.getItem(this.mCoolPageIndex) instanceof MainSmartCoolModeFragment) {
            return this.mCoolPageIndex;
        }
        return -1;
    }

    private final int getSmartFragmentPageIndex() {
        SectionsPagerAdapter sectionsPagerAdapter = this.mSectionsPagerAdapter;
        if (sectionsPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSectionsPagerAdapter");
            sectionsPagerAdapter = null;
        }
        if (sectionsPagerAdapter.getItem(this.mSmartPageIndex) instanceof MainSmartModeFragment) {
            return this.mSmartPageIndex;
        }
        return -1;
    }

    private final void updateCoolOff() {
        SectionsPagerAdapter sectionsPagerAdapter = this.mSectionsPagerAdapter;
        if (sectionsPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSectionsPagerAdapter");
            sectionsPagerAdapter = null;
        }
        Fragment item = sectionsPagerAdapter.getItem(this.mCoolPageIndex);
        if (item instanceof MainCoolFragment) {
            ((MainCoolFragment) item).updateOff();
        }
    }

    public void transitToCoolOrWarmByTypeCode(BleDataEntity bleDataEntity, DeviceModeEntity deviceModeEntity) {
        int i;
        Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
        Intrinsics.checkNotNullParameter(deviceModeEntity, "aDeviceModeEntity");
        CoolHeatTypeCode coolHeatType = deviceModeEntity.getCoolHeatType();
        TabLayout tabLayout = this.mTabLayout;
        if (tabLayout != null) {
            tabLayout.removeOnTabSelectedListener(this);
        }
        if (coolHeatType == null) {
            i = -1;
        } else {
            i = WhenMappings.$EnumSwitchMapping$3[coolHeatType.ordinal()];
        }
        if (i == 1 || i == 2) {
            if (getCoolFragmentPageIndex() < 0) {
                setCoolFragment();
                MainCoolFragment mainCoolFragment = this.mCoolFragment;
                if (mainCoolFragment != null) {
                    mainCoolFragment.applyBleDataEntity(bleDataEntity);
                }
            }
            this.mLastSelectedPage = Companion.Page.COOL;
            CustomViewPager customViewPager = this.mViewPager;
            if (customViewPager != null) {
                customViewPager.setCurrentItem(this.mCoolPageIndex);
            }
        } else if (i == 3 || i == 4) {
            if (getWarmFragmentPageIndex() < 0) {
                setWarmFragment();
                MainWarmFragment mainWarmFragment = this.mHeatFragment;
                if (mainWarmFragment != null) {
                    mainWarmFragment.applyBleDataEntity(bleDataEntity);
                }
            }
            this.mLastSelectedPage = Companion.Page.WARM;
            CustomViewPager customViewPager2 = this.mViewPager;
            if (customViewPager2 != null) {
                customViewPager2.setCurrentItem(this.mWarmPageIndex);
            }
        }
        TabLayout tabLayout2 = this.mTabLayout;
        if (tabLayout2 != null) {
            tabLayout2.addOnTabSelectedListener(this);
        }
    }

    private final int getWarmFragmentPageIndex() {
        SectionsPagerAdapter sectionsPagerAdapter = this.mSectionsPagerAdapter;
        if (sectionsPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSectionsPagerAdapter");
            sectionsPagerAdapter = null;
        }
        if (sectionsPagerAdapter.getItem(this.mWarmPageIndex) instanceof MainWarmFragment) {
            return this.mWarmPageIndex;
        }
        return -1;
    }

    private final int getCoolFragmentPageIndex() {
        SectionsPagerAdapter sectionsPagerAdapter = this.mSectionsPagerAdapter;
        if (sectionsPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSectionsPagerAdapter");
            sectionsPagerAdapter = null;
        }
        if (sectionsPagerAdapter.getItem(this.mCoolPageIndex) instanceof MainCoolFragment) {
            return this.mCoolPageIndex;
        }
        return -1;
    }

    private final void updateBatteryRemainTime(Integer num) {
        CharSequence charSequence;
        String str;
        String str2;
        CustomFontTextView customFontTextView = this.mBatteryRemain;
        if (customFontTextView != null) {
            if (num == null || num.intValue() != 65535) {
                IntRange until = RangesKt.until((int) TimeUnit.MINUTES.toSeconds(60), 65535);
                if (num == null || !until.contains(num.intValue())) {
                    IntRange until2 = RangesKt.until((int) TimeUnit.MINUTES.toSeconds(15), (int) TimeUnit.MINUTES.toSeconds(60));
                    if (num == null || !until2.contains(num.intValue())) {
                        IntRange intRange = new IntRange(1, (int) TimeUnit.MINUTES.toSeconds(15));
                        if (num != null && intRange.contains(num.intValue())) {
                            charSequence = getString(R.string.setting_buttery_remaining_time_less_than, new Object[]{15});
                        }
                    } else {
                        Intrinsics.checkNotNull(num);
                        int intValue = (((num.intValue() % 86400) % 3600) / STSAssumeRoleSessionCredentialsProvider.DEFAULT_DURATION_SECONDS) * 15;
                        if (intValue > 0) {
                            str = getString(R.string.setting_buttery_remaining_time_in_minute, new Object[]{Integer.valueOf(intValue)});
                        } else {
                            str = getString(R.string.setting_buttery_remaining_time_less_than, new Object[]{15});
                        }
                        charSequence = str;
                    }
                } else {
                    Intrinsics.checkNotNull(num);
                    int intValue2 = (((num.intValue() % 86400) % 3600) / 1800) * 30;
                    int intValue3 = (num.intValue() % 86400) / 3600;
                    if (intValue2 > 0) {
                        str2 = getString(R.string.setting_buttery_remaining_time, new Object[]{Integer.valueOf(intValue3), Integer.valueOf(intValue2)});
                    } else {
                        str2 = getString(R.string.setting_buttery_remaining_time_in_hour, new Object[]{Integer.valueOf(intValue3)});
                    }
                    charSequence = str2;
                }
            }
            customFontTextView.setText(charSequence);
        }
    }

    public final void readDeviceMode() {
        MainViewOutput mainViewOutput = this.mOutput;
        if (mainViewOutput != null) {
            mainViewOutput.readDeviceMode();
        }
    }

    private final void setBatteryState(BatteryEntity batteryEntity) {
        CustomImageView customImageView;
        this.mBatteryLevel = batteryEntity.getLevel();
        if (!(batteryEntity.getBatteryChargeStatus() == BatteryChargeStatus.ERROR_HIGH_TEMP || batteryEntity.getBatteryChargeStatus() == BatteryChargeStatus.ERROR_LOW_TEMP)) {
            CollectionsKt.removeAll(this.mErrorStack, (T[]) new DeviceInfoConstants[]{DeviceInfoConstants.EXCEPTION_CANNOT_CHARGING, DeviceInfoConstants.EXCEPTION_CANNOT_CHARGING_CAUSE_HIGH_TEMP, DeviceInfoConstants.EXCEPTION_CANNOT_CHARGING_UNKNOWN});
            if (this.mErrorStack.size() == 0) {
                this.mIsDeviceAlert = false;
                updateDeviceImage();
            }
        }
        int i = WhenMappings.$EnumSwitchMapping$5[batteryEntity.getBatteryChargeStatus().ordinal()];
        if (i == 1) {
            CustomImageView customImageView2 = this.mPlugIcon;
            if (customImageView2 != null) {
                customImageView2.setVisibility(8);
            }
            CustomImageView customImageView3 = this.mBatteryIcon;
            if (customImageView3 != null) {
                customImageView3.setImageResource(R.drawable.ic_battery_charging);
            }
            CustomImageView customImageView4 = this.mBatteryIcon;
            if (customImageView4 != null) {
                customImageView4.setContentDescription(getResources().getString(R.string.accessibility_battery_charging));
            }
        } else if (i == 2) {
            int i2 = WhenMappings.$EnumSwitchMapping$4[batteryEntity.getPowerSupplyStatus().ordinal()];
            if (i2 == 1) {
                CustomImageView customImageView5 = this.mPlugIcon;
                if (customImageView5 != null) {
                    customImageView5.setVisibility(0);
                }
            } else if (i2 == 2 && (customImageView = this.mPlugIcon) != null) {
                customImageView.setVisibility(8);
            }
            int i3 = this.mBatteryLevel;
            if (i3 >= 0 && i3 < 26) {
                CustomImageView customImageView6 = this.mBatteryIcon;
                if (customImageView6 != null) {
                    customImageView6.setImageResource(R.drawable.ic_battery_1);
                }
                CustomImageView customImageView7 = this.mBatteryFullIcon;
                if (customImageView7 != null) {
                    customImageView7.setVisibility(4);
                }
                CustomImageView customImageView8 = this.mBatteryIcon;
                if (customImageView8 != null) {
                    customImageView8.setContentDescription(getResources().getString(R.string.accessibility_battery, new Object[]{1}));
                }
            } else if (26 <= i3 && i3 < 51) {
                CustomImageView customImageView9 = this.mBatteryIcon;
                if (customImageView9 != null) {
                    customImageView9.setImageResource(R.drawable.ic_battery_2);
                }
                CustomImageView customImageView10 = this.mBatteryFullIcon;
                if (customImageView10 != null) {
                    customImageView10.setVisibility(4);
                }
                CustomImageView customImageView11 = this.mBatteryIcon;
                if (customImageView11 != null) {
                    customImageView11.setContentDescription(getResources().getString(R.string.accessibility_battery, new Object[]{2}));
                }
            } else if (51 <= i3 && i3 < 76) {
                CustomImageView customImageView12 = this.mBatteryIcon;
                if (customImageView12 != null) {
                    customImageView12.setImageResource(R.drawable.ic_battery_3);
                }
                CustomImageView customImageView13 = this.mBatteryFullIcon;
                if (customImageView13 != null) {
                    customImageView13.setVisibility(4);
                }
                CustomImageView customImageView14 = this.mBatteryIcon;
                if (customImageView14 != null) {
                    customImageView14.setContentDescription(getResources().getString(R.string.accessibility_battery, new Object[]{3}));
                }
            } else if (76 <= i3 && i3 < 101) {
                CustomImageView customImageView15 = this.mBatteryIcon;
                if (customImageView15 != null) {
                    customImageView15.setImageResource(R.drawable.ic_battery_4);
                }
                CustomImageView customImageView16 = this.mBatteryFullIcon;
                if (customImageView16 != null) {
                    customImageView16.setVisibility(4);
                }
                CustomImageView customImageView17 = this.mBatteryIcon;
                if (customImageView17 != null) {
                    customImageView17.setContentDescription(getResources().getString(R.string.accessibility_battery, new Object[]{4}));
                }
            }
        } else if (i == 3) {
            CustomImageView customImageView18 = this.mPlugIcon;
            if (customImageView18 != null) {
                customImageView18.setVisibility(8);
            }
            if (batteryEntity.getLevel() == 100) {
                CustomImageView customImageView19 = this.mBatteryIcon;
                if (customImageView19 != null) {
                    customImageView19.setImageResource(R.drawable.ic_battery_4);
                }
                CustomImageView customImageView20 = this.mBatteryFullIcon;
                if (customImageView20 != null) {
                    customImageView20.setVisibility(0);
                }
                CustomImageView customImageView21 = this.mBatteryIcon;
                if (customImageView21 != null) {
                    customImageView21.setContentDescription(getResources().getString(R.string.accessibility_battery_full));
                    return;
                }
                return;
            }
            CustomImageView customImageView22 = this.mBatteryIcon;
            if (customImageView22 != null) {
                customImageView22.setImageResource(R.drawable.ic_battery_charging);
            }
            CustomImageView customImageView23 = this.mBatteryFullIcon;
            if (customImageView23 != null) {
                customImageView23.setVisibility(4);
            }
            CustomImageView customImageView24 = this.mBatteryIcon;
            if (customImageView24 != null) {
                customImageView24.setContentDescription(getResources().getString(R.string.accessibility_battery_charging));
            }
        }
    }

    public void onTabSelected(TabLayout.Tab tab) {
        if (!this.mIsFirstOperate && tab != null) {
            int i = WhenMappings.$EnumSwitchMapping$1[this.mTabPages.get(tab.getPosition()).ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            onSmartTap();
                            return;
                        } else if (i != 5) {
                            return;
                        }
                    }
                }
                onWarmTap();
                return;
            }
            onCoolTap();
        }
    }

    private final DeviceModeEntity.Temperature createTemperatureEntity(TemperatureOnOffCode temperatureOnOffCode, TemperatureCoolHeatTypeCode temperatureCoolHeatTypeCode, SmartModePreference smartModePreference, SmartModePreference smartModePreference2, int i, int i2) {
        return new DeviceModeEntity.Temperature(temperatureOnOffCode, temperatureCoolHeatTypeCode, CoolBoost.NONE, (CurrentCoolHeatTypeCode) null, (TagFuncLimit) null, (SwitchingTrigger1) null, (SwitchingTrigger2) null, (BoostStatus) null, (TargetTempControlStatus) null, (TargetTempControlFactorALS) null, (TargetTempControlFactorEnvironment) null, (TargetTempControlFactorClothesTemp) null, (TargetTempControlFactorAction) null, (TargetTempControlFactorBoost) null, smartModePreference, smartModePreference2, i, i2, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 65535, Integer.valueOf(DeviceModeEntityKt.SMART_MODE_INVALID_SWITCH_THRESHOLD), 3948536, (DefaultConstructorMarker) null);
    }

    private final DeviceModeEntity.Temperature createTemperatureOffEntity(TemperatureCoolHeatTypeCode temperatureCoolHeatTypeCode) {
        return createTemperatureEntity(TemperatureOnOffCode.OFF, temperatureCoolHeatTypeCode, SmartModePreference.OFF, SmartModePreference.OFF, DeviceModeEntityKt.SMART_MODE_OFF_TEMPERATURE, DeviceModeEntityKt.SMART_MODE_OFF_TEMPERATURE);
    }

    private final void setSmartOff() {
        DeviceModeEntity.Temperature createTemperatureOffEntity = createTemperatureOffEntity(TemperatureCoolHeatTypeCode.COOL_HEAT_MIX);
        MainViewOutput mainViewOutput = this.mOutput;
        if (mainViewOutput != null) {
            DeviceModeEntity deviceModeEntity = r2;
            DeviceModeEntity deviceModeEntity2 = new DeviceModeEntity(DeviceModeActionCode.TEMPERATURE, DeviceModeSettingTriggerCode.SET_DEVICE_MODE, (DeviceCoolingCode) null, (ContinuousOperationStatus) null, (SwitchCoolHeatWaitStatus) null, (CoolHeatTypeCode) null, createTemperatureOffEntity, (ModeCommonSettingOperation) null, (Integer) null, (TempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyModeActionType) null, (MyModeSpecialSubMode) null, (Integer) null, (Integer) null, (MyModeOperationCode) null, (Integer) null, (MyModeTypeCode) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyTempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (FanStepCode) null, -68, 63, (DefaultConstructorMarker) null);
            mainViewOutput.writeDeviceMode(deviceModeEntity);
        }
    }

    private final void setSmartCoolOff() {
        DeviceModeEntity deviceModeEntity = new DeviceModeEntity(DeviceModeActionCode.TEMPERATURE, DeviceModeSettingTriggerCode.SET_DEVICE_MODE, (DeviceCoolingCode) null, (ContinuousOperationStatus) null, (SwitchCoolHeatWaitStatus) null, (CoolHeatTypeCode) null, createTemperatureOffEntity(TemperatureCoolHeatTypeCode.COOL), (ModeCommonSettingOperation) null, (Integer) null, (TempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyModeActionType) null, (MyModeSpecialSubMode) null, (Integer) null, (Integer) null, (MyModeOperationCode) null, (Integer) null, (MyModeTypeCode) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyTempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (FanStepCode) null, -68, 63, (DefaultConstructorMarker) null);
        MainViewOutput mainViewOutput = this.mOutput;
        if (mainViewOutput != null) {
            mainViewOutput.writeDeviceMode(deviceModeEntity);
        }
    }

    private final void setSmartWarmOff() {
        DeviceModeEntity deviceModeEntity = new DeviceModeEntity(DeviceModeActionCode.TEMPERATURE, DeviceModeSettingTriggerCode.SET_DEVICE_MODE, (DeviceCoolingCode) null, (ContinuousOperationStatus) null, (SwitchCoolHeatWaitStatus) null, (CoolHeatTypeCode) null, createTemperatureOffEntity(TemperatureCoolHeatTypeCode.HEAT), (ModeCommonSettingOperation) null, (Integer) null, (TempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyModeActionType) null, (MyModeSpecialSubMode) null, (Integer) null, (Integer) null, (MyModeOperationCode) null, (Integer) null, (MyModeTypeCode) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyTempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (FanStepCode) null, -68, 63, (DefaultConstructorMarker) null);
        MainViewOutput mainViewOutput = this.mOutput;
        if (mainViewOutput != null) {
            mainViewOutput.writeDeviceMode(deviceModeEntity);
        }
    }

    private final void onCoolTap() {
        boolean z;
        SectionsPagerAdapter sectionsPagerAdapter = this.mSectionsPagerAdapter;
        SectionsPagerAdapter sectionsPagerAdapter2 = null;
        if (sectionsPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSectionsPagerAdapter");
            sectionsPagerAdapter = null;
        }
        CustomViewPager customViewPager = this.mViewPager;
        Integer valueOf = customViewPager != null ? Integer.valueOf(customViewPager.getCurrentItem()) : null;
        Intrinsics.checkNotNull(valueOf);
        Fragment item = sectionsPagerAdapter.getItem(valueOf.intValue());
        SectionsPagerAdapter sectionsPagerAdapter3 = this.mSectionsPagerAdapter;
        if (sectionsPagerAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSectionsPagerAdapter");
        } else {
            sectionsPagerAdapter2 = sectionsPagerAdapter3;
        }
        Fragment item2 = sectionsPagerAdapter2.getItem(this.mCoolPageIndex);
        if (item instanceof MainWarmFragment) {
            z = true;
        } else {
            z = item instanceof MainSmartWarmFragment;
        }
        if (z) {
            showModeChangeProgress(Integer.valueOf(R.string.mainview_wait_dialog_title));
            if (item2 instanceof MainCoolFragment) {
                transitToCool();
            } else if (item2 instanceof MainSmartCoolModeFragment) {
                transitToSmartCool(!this.mIsOff);
            }
        } else if (item instanceof MainSmartModeFragment) {
            if (((MainSmartModeFragment) item).getMState() == CurrentCoolHeatTypeCode.HEAT) {
                showModeChangeProgress(Integer.valueOf(R.string.mainview_wait_dialog_title));
            }
            if (item2 instanceof MainCoolFragment) {
                transitToCool();
            } else if (item2 instanceof MainSmartCoolModeFragment) {
                transitToSmartCool(!this.mIsOff);
            }
        } else if (!(item instanceof MainCoolFragment)) {
            boolean z2 = item instanceof MainSmartCoolModeFragment;
        }
    }

    private final void onWarmTap() {
        boolean z;
        SectionsPagerAdapter sectionsPagerAdapter = this.mSectionsPagerAdapter;
        SectionsPagerAdapter sectionsPagerAdapter2 = null;
        if (sectionsPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSectionsPagerAdapter");
            sectionsPagerAdapter = null;
        }
        CustomViewPager customViewPager = this.mViewPager;
        Integer valueOf = customViewPager != null ? Integer.valueOf(customViewPager.getCurrentItem()) : null;
        Intrinsics.checkNotNull(valueOf);
        Fragment item = sectionsPagerAdapter.getItem(valueOf.intValue());
        SectionsPagerAdapter sectionsPagerAdapter3 = this.mSectionsPagerAdapter;
        if (sectionsPagerAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSectionsPagerAdapter");
        } else {
            sectionsPagerAdapter2 = sectionsPagerAdapter3;
        }
        Fragment item2 = sectionsPagerAdapter2.getItem(this.mWarmPageIndex);
        if (item instanceof MainCoolFragment) {
            z = true;
        } else {
            z = item instanceof MainSmartCoolModeFragment;
        }
        if (z) {
            showModeChangeProgress(Integer.valueOf(R.string.mainview_wait_dialog_title));
            if (item2 instanceof MainWarmFragment) {
                transitToWarm();
            } else if (item2 instanceof MainSmartWarmFragment) {
                transitToSmartWarm(!this.mIsOff);
            }
        } else if (item instanceof MainSmartModeFragment) {
            if (((MainSmartModeFragment) item).getMState() == CurrentCoolHeatTypeCode.COOL) {
                showModeChangeProgress(Integer.valueOf(R.string.mainview_wait_dialog_title));
            }
            if (item2 instanceof MainWarmFragment) {
                transitToWarm();
            } else if (item2 instanceof MainSmartWarmFragment) {
                transitToSmartWarm(!this.mIsOff);
            }
        } else if (!(item instanceof MainWarmFragment)) {
            boolean z2 = item instanceof MainSmartWarmFragment;
        }
    }

    public void updateSmartWarmTagNoReceiving() {
        MainSmartWarmFragment mainSmartWarmFragment;
        if (AccessController.getContext() == null) {
            DebugLogUtil.INSTANCE.e("fun updateNoReceiving error: getContext() is null");
            return;
        }
        this.isTagInfoReceiving = false;
        SafeArray<Fragment> safeArray = this.mRegisteredFragments;
        CustomViewPager customViewPager = this.mViewPager;
        Integer valueOf = customViewPager != null ? Integer.valueOf(customViewPager.getCurrentItem()) : null;
        Intrinsics.checkNotNull(valueOf);
        if ((safeArray.get(valueOf.intValue()) instanceof MainSmartWarmFragment) && (mainSmartWarmFragment = this.mSmartWarmFragment) != null) {
            mainSmartWarmFragment.updateNoReceiving(true);
        }
    }

    private final void onSmartTap() {
        boolean z;
        boolean z2;
        boolean z3;
        SectionsPagerAdapter sectionsPagerAdapter = this.mSectionsPagerAdapter;
        Integer num = null;
        if (sectionsPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSectionsPagerAdapter");
            sectionsPagerAdapter = null;
        }
        CustomViewPager customViewPager = this.mViewPager;
        if (customViewPager != null) {
            num = Integer.valueOf(customViewPager.getCurrentItem());
        }
        Intrinsics.checkNotNull(num);
        Fragment item = sectionsPagerAdapter.getItem(num.intValue());
        if (item instanceof MainCoolFragment) {
            z = true;
        } else {
            z = item instanceof MainSmartCoolModeFragment;
        }
        if (z) {
            z2 = true;
        } else {
            z2 = item instanceof MainWarmFragment;
        }
        if (z2) {
            z3 = true;
        } else {
            z3 = item instanceof MainSmartWarmFragment;
        }
        if (z3) {
            transitToSmart(!this.mIsOff);
        } else {
            boolean z4 = item instanceof MainSmartModeFragment;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0038, code lost:
        r5 = r5.getTabAt(r4.mSmartPageIndex);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateSmartModeIconDisplay(boolean r5) {
        /*
            r4 = this;
            java.security.AccessControlContext r0 = java.security.AccessController.getContext()
            if (r0 != 0) goto L_0x000e
            jp.co.sony.reonpocket.util.DebugLogUtil r5 = jp.co.sony.reonpocket.util.DebugLogUtil.INSTANCE
            java.lang.String r0 = "fun updateSmartModeIconDisplay error: getContext() is null"
            r5.e(r0)
            return
        L_0x000e:
            r4.isTagInfoReceiving = r5
            boolean r0 = r4.mIsRegisterTag
            if (r0 == 0) goto L_0x00d7
            boolean r0 = r4.mIsSupportSmart
            if (r0 != 0) goto L_0x001a
            goto L_0x00d7
        L_0x001a:
            jp.co.sony.reonpocket.view.CustomViewPager r0 = r4.mViewPager
            if (r0 == 0) goto L_0x0024
            r1 = r4
            androidx.viewpager.widget.ViewPager$OnPageChangeListener r1 = (androidx.viewpager.widget.ViewPager.OnPageChangeListener) r1
            r0.removeOnPageChangeListener(r1)
        L_0x0024:
            com.google.android.material.tabs.TabLayout r0 = r4.mTabLayout
            if (r0 == 0) goto L_0x002e
            r1 = r4
            com.google.android.material.tabs.TabLayout$BaseOnTabSelectedListener r1 = (com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener) r1
            r0.removeOnTabSelectedListener(r1)
        L_0x002e:
            r0 = 0
            r1 = 0
            java.lang.String r2 = "null cannot be cast to non-null type android.widget.LinearLayout"
            if (r5 == 0) goto L_0x007e
            com.google.android.material.tabs.TabLayout r5 = r4.mTabLayout
            if (r5 == 0) goto L_0x0043
            int r3 = r4.mSmartPageIndex
            com.google.android.material.tabs.TabLayout$Tab r5 = r5.getTabAt(r3)
            if (r5 == 0) goto L_0x0043
            com.google.android.material.tabs.TabLayout$TabView r5 = r5.view
            goto L_0x0044
        L_0x0043:
            r5 = r1
        L_0x0044:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5, r2)
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            int r3 = jp.co.sony.reonpocket.R.id.tab_icon
            android.view.View r5 = r5.findViewById(r3)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r5.setImageResource(r0)
            int r3 = jp.co.sony.reonpocket.R.drawable.bg_tab_coolwarm
            android.graphics.drawable.Drawable r3 = r4.getDrawable(r3)
            r5.setBackground(r3)
            com.google.android.material.tabs.TabLayout r5 = r4.mTabLayout
            if (r5 == 0) goto L_0x0065
            android.view.View r1 = r5.getChildAt(r0)
        L_0x0065:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            int r5 = r4.mSmartPageIndex
            android.view.View r5 = r1.getChildAt(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5, r2)
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            jp.co.sony.reonpocket.modules.main.view.MainActivity$$ExternalSyntheticLambda8 r0 = new jp.co.sony.reonpocket.modules.main.view.MainActivity$$ExternalSyntheticLambda8
            r0.<init>()
            r5.setOnTouchListener(r0)
            goto L_0x00c3
        L_0x007e:
            com.google.android.material.tabs.TabLayout r5 = r4.mTabLayout
            if (r5 == 0) goto L_0x008d
            int r3 = r4.mSmartPageIndex
            com.google.android.material.tabs.TabLayout$Tab r5 = r5.getTabAt(r3)
            if (r5 == 0) goto L_0x008d
            com.google.android.material.tabs.TabLayout$TabView r5 = r5.view
            goto L_0x008e
        L_0x008d:
            r5 = r1
        L_0x008e:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5, r2)
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            int r3 = jp.co.sony.reonpocket.R.id.tab_icon
            android.view.View r5 = r5.findViewById(r3)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r5.setBackground(r1)
            int r3 = jp.co.sony.reonpocket.R.drawable.ic_tab_smart_disable
            r5.setImageResource(r3)
            com.google.android.material.tabs.TabLayout r5 = r4.mTabLayout
            if (r5 == 0) goto L_0x00ab
            android.view.View r1 = r5.getChildAt(r0)
        L_0x00ab:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            int r5 = r4.mSmartPageIndex
            android.view.View r5 = r1.getChildAt(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5, r2)
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            jp.co.sony.reonpocket.modules.main.view.MainActivity$$ExternalSyntheticLambda9 r0 = new jp.co.sony.reonpocket.modules.main.view.MainActivity$$ExternalSyntheticLambda9
            r0.<init>()
            r5.setOnTouchListener(r0)
        L_0x00c3:
            jp.co.sony.reonpocket.view.CustomViewPager r5 = r4.mViewPager
            if (r5 == 0) goto L_0x00cd
            r0 = r4
            androidx.viewpager.widget.ViewPager$OnPageChangeListener r0 = (androidx.viewpager.widget.ViewPager.OnPageChangeListener) r0
            r5.addOnPageChangeListener(r0)
        L_0x00cd:
            com.google.android.material.tabs.TabLayout r5 = r4.mTabLayout
            if (r5 == 0) goto L_0x00d7
            r0 = r4
            com.google.android.material.tabs.TabLayout$BaseOnTabSelectedListener r0 = (com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener) r0
            r5.addOnTabSelectedListener(r0)
        L_0x00d7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.main.view.MainActivity.updateSmartModeIconDisplay(boolean):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:83:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0286  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x028d  */
    /* JADX WARNING: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateShowSmartMode(boolean r15) {
        /*
            r14 = this;
            boolean r0 = r14.mIsSupportSmart
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            com.google.android.material.tabs.TabLayout r0 = r14.mTabLayout
            if (r0 == 0) goto L_0x000f
            r1 = r14
            com.google.android.material.tabs.TabLayout$BaseOnTabSelectedListener r1 = (com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener) r1
            r0.removeOnTabSelectedListener(r1)
        L_0x000f:
            r0 = 0
            r1 = 3
            r2 = 0
            if (r15 == 0) goto L_0x01be
            java.util.List<jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page> r3 = r14.mTabPages
            jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page r4 = jp.co.sony.reonpocket.modules.main.view.MainActivity.Companion.Page.SMART
            int r3 = r3.indexOf(r4)
            if (r3 >= 0) goto L_0x01f4
            jp.co.sony.reonpocket.util.SafeArray<androidx.fragment.app.Fragment> r3 = r14.mRegisteredFragments
            int r4 = r14.mWarmPageIndex
            java.lang.Object r3 = r3.get(r4)
            androidx.fragment.app.Fragment r3 = (androidx.fragment.app.Fragment) r3
            jp.co.sony.reonpocket.modules.main.view.MainActivity$MainViewOutput r4 = r14.mOutput
            if (r4 == 0) goto L_0x0030
            boolean r0 = r4.getIsRegisterTag()
        L_0x0030:
            int r4 = r14.updateSmartPageIndex(r0)
            r14.mSmartPageIndex = r4
            int r0 = r14.updateWarmPageIndex(r0)
            r14.mWarmPageIndex = r0
            com.google.android.material.tabs.TabLayout r0 = r14.mTabLayout
            java.lang.String r4 = "apply(...)"
            if (r0 == 0) goto L_0x0076
            int r5 = r0.getTabCount()
            int r6 = r14.mSmartPageIndex
            if (r5 <= r6) goto L_0x004d
            r0.removeTabAt(r6)
        L_0x004d:
            com.google.android.material.tabs.TabLayout$Tab r5 = r0.newTab()
            int r6 = jp.co.sony.reonpocket.R.string.mainview_content_mode_indicator_smart
            java.lang.String r6 = r14.getString(r6)
            r5.setTag(r6)
            int r6 = jp.co.sony.reonpocket.R.string.accessibility_common_smart
            java.lang.String r6 = r14.getString(r6)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r5.setContentDescription((java.lang.CharSequence) r6)
            jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page r6 = jp.co.sony.reonpocket.modules.main.view.MainActivity.Companion.Page.SMART
            int r6 = r6.getLayout()
            r5.setCustomView((int) r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)
            int r6 = r14.mSmartPageIndex
            r0.addTab((com.google.android.material.tabs.TabLayout.Tab) r5, (int) r6)
        L_0x0076:
            java.util.List<jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page> r0 = r14.mTabPages
            int r0 = r0.size()
            int r5 = r14.mSmartPageIndex
            if (r0 <= r5) goto L_0x0085
            java.util.List<jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page> r0 = r14.mTabPages
            r0.remove(r5)
        L_0x0085:
            java.util.List<jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page> r0 = r14.mTabPages
            int r5 = r14.mSmartPageIndex
            jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page r6 = jp.co.sony.reonpocket.modules.main.view.MainActivity.Companion.Page.SMART
            r0.add(r5, r6)
            jp.co.sony.reonpocket.util.SafeArray<androidx.fragment.app.Fragment> r0 = r14.mRegisteredFragments
            int r5 = r14.mSmartPageIndex
            java.lang.Object r0 = r0.get(r5)
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            boolean r5 = r0 instanceof jp.co.sony.reonpocket.modules.main.view.MainSmartModeFragment
            if (r5 == 0) goto L_0x00a1
            jp.co.sony.reonpocket.modules.main.view.MainSmartModeFragment r0 = (jp.co.sony.reonpocket.modules.main.view.MainSmartModeFragment) r0
            r14.mSmartFragment = r0
            goto L_0x00c1
        L_0x00a1:
            if (r0 == 0) goto L_0x00aa
            jp.co.sony.reonpocket.util.SafeArray<androidx.fragment.app.Fragment> r0 = r14.mRegisteredFragments
            int r5 = r14.mSmartPageIndex
            r0.removeAt(r5)
        L_0x00aa:
            jp.co.sony.reonpocket.modules.main.view.MainSmartModeFragment$Companion r6 = jp.co.sony.reonpocket.modules.main.view.MainSmartModeFragment.Companion
            r12 = 31
            r13 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            jp.co.sony.reonpocket.modules.main.view.MainSmartModeFragment r0 = jp.co.sony.reonpocket.modules.main.view.MainSmartModeFragment.Companion.newInstance$default(r6, r7, r8, r9, r10, r11, r12, r13)
            r14.mSmartFragment = r0
            jp.co.sony.reonpocket.util.SafeArray<androidx.fragment.app.Fragment> r5 = r14.mRegisteredFragments
            int r6 = r14.mSmartPageIndex
            r5.add(r6, r0)
        L_0x00c1:
            com.google.android.material.tabs.TabLayout r0 = r14.mTabLayout
            if (r0 == 0) goto L_0x00d0
            int r5 = r0.getTabCount()
            int r6 = r14.mWarmPageIndex
            if (r5 <= r6) goto L_0x00d0
            r0.removeTabAt(r6)
        L_0x00d0:
            java.util.List<jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page> r0 = r14.mTabPages
            int r0 = r0.size()
            int r5 = r14.mWarmPageIndex
            if (r0 <= r5) goto L_0x00df
            java.util.List<jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page> r0 = r14.mTabPages
            r0.remove(r5)
        L_0x00df:
            boolean r0 = r3 instanceof jp.co.sony.reonpocket.modules.main.view.MainWarmFragment
            if (r0 == 0) goto L_0x0127
            r0 = r3
            jp.co.sony.reonpocket.modules.main.view.MainWarmFragment r0 = (jp.co.sony.reonpocket.modules.main.view.MainWarmFragment) r0
            r14.mHeatFragment = r0
            jp.co.sony.reonpocket.util.SafeArray<androidx.fragment.app.Fragment> r0 = r14.mRegisteredFragments
            int r5 = r14.mWarmPageIndex
            r0.add(r5, r3)
            java.util.List<jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page> r0 = r14.mTabPages
            int r3 = r14.mWarmPageIndex
            jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page r5 = jp.co.sony.reonpocket.modules.main.view.MainActivity.Companion.Page.WARM
            r0.add(r3, r5)
            com.google.android.material.tabs.TabLayout r0 = r14.mTabLayout
            if (r0 == 0) goto L_0x01f4
            com.google.android.material.tabs.TabLayout$Tab r3 = r0.newTab()
            int r5 = jp.co.sony.reonpocket.R.string.mainview_content_mode_indicator_warm
            java.lang.String r5 = r14.getString(r5)
            r3.setTag(r5)
            int r5 = jp.co.sony.reonpocket.R.string.accessibility_common_warm
            java.lang.String r5 = r14.getString(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r3.setContentDescription((java.lang.CharSequence) r5)
            jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page r5 = jp.co.sony.reonpocket.modules.main.view.MainActivity.Companion.Page.WARM
            int r5 = r5.getLayout()
            r3.setCustomView((int) r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            int r4 = r14.mWarmPageIndex
            r0.addTab((com.google.android.material.tabs.TabLayout.Tab) r3, (int) r4)
            goto L_0x01f4
        L_0x0127:
            boolean r0 = r3 instanceof jp.co.sony.reonpocket.modules.main.view.MainSmartWarmFragment
            if (r0 == 0) goto L_0x016f
            r0 = r3
            jp.co.sony.reonpocket.modules.main.view.MainSmartWarmFragment r0 = (jp.co.sony.reonpocket.modules.main.view.MainSmartWarmFragment) r0
            r14.mSmartWarmFragment = r0
            jp.co.sony.reonpocket.util.SafeArray<androidx.fragment.app.Fragment> r0 = r14.mRegisteredFragments
            int r5 = r14.mWarmPageIndex
            r0.add(r5, r3)
            java.util.List<jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page> r0 = r14.mTabPages
            int r3 = r14.mWarmPageIndex
            jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page r5 = jp.co.sony.reonpocket.modules.main.view.MainActivity.Companion.Page.SMARTWARM
            r0.add(r3, r5)
            com.google.android.material.tabs.TabLayout r0 = r14.mTabLayout
            if (r0 == 0) goto L_0x01f4
            com.google.android.material.tabs.TabLayout$Tab r3 = r0.newTab()
            int r5 = jp.co.sony.reonpocket.R.string.mainview_content_mode_indicator_smart_warm
            java.lang.String r5 = r14.getString(r5)
            r3.setTag(r5)
            int r5 = jp.co.sony.reonpocket.R.string.accessibility_common_warm
            java.lang.String r5 = r14.getString(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r3.setContentDescription((java.lang.CharSequence) r5)
            jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page r5 = jp.co.sony.reonpocket.modules.main.view.MainActivity.Companion.Page.SMARTWARM
            int r5 = r5.getLayout()
            r3.setCustomView((int) r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            int r4 = r14.mWarmPageIndex
            r0.addTab((com.google.android.material.tabs.TabLayout.Tab) r3, (int) r4)
            goto L_0x01f4
        L_0x016f:
            if (r3 == 0) goto L_0x0178
            jp.co.sony.reonpocket.util.SafeArray<androidx.fragment.app.Fragment> r0 = r14.mRegisteredFragments
            int r3 = r14.mWarmPageIndex
            r0.removeAt(r3)
        L_0x0178:
            jp.co.sony.reonpocket.modules.main.view.MainSmartWarmFragment$Companion r0 = jp.co.sony.reonpocket.modules.main.view.MainSmartWarmFragment.Companion
            jp.co.sony.reonpocket.modules.main.view.MainSmartWarmFragment r0 = jp.co.sony.reonpocket.modules.main.view.MainSmartWarmFragment.Companion.newInstance$default(r0, r2, r2, r1, r2)
            r14.mSmartWarmFragment = r0
            jp.co.sony.reonpocket.util.SafeArray<androidx.fragment.app.Fragment> r3 = r14.mRegisteredFragments
            int r5 = r14.mWarmPageIndex
            r3.add(r5, r0)
            java.util.List<jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page> r0 = r14.mTabPages
            int r3 = r14.mWarmPageIndex
            jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page r5 = jp.co.sony.reonpocket.modules.main.view.MainActivity.Companion.Page.SMARTWARM
            r0.add(r3, r5)
            com.google.android.material.tabs.TabLayout r0 = r14.mTabLayout
            if (r0 == 0) goto L_0x01f4
            com.google.android.material.tabs.TabLayout$Tab r3 = r0.newTab()
            int r5 = jp.co.sony.reonpocket.R.string.mainview_content_mode_indicator_smart_warm
            java.lang.String r5 = r14.getString(r5)
            r3.setTag(r5)
            int r5 = jp.co.sony.reonpocket.R.string.accessibility_common_warm
            java.lang.String r5 = r14.getString(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r3.setContentDescription((java.lang.CharSequence) r5)
            jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page r5 = jp.co.sony.reonpocket.modules.main.view.MainActivity.Companion.Page.SMARTWARM
            int r5 = r5.getLayout()
            r3.setCustomView((int) r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            int r4 = r14.mWarmPageIndex
            r0.addTab((com.google.android.material.tabs.TabLayout.Tab) r3, (int) r4)
            goto L_0x01f4
        L_0x01be:
            java.util.List<jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page> r3 = r14.mTabPages
            jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page r4 = jp.co.sony.reonpocket.modules.main.view.MainActivity.Companion.Page.SMART
            int r3 = r3.indexOf(r4)
            r4 = -1
            if (r3 <= r4) goto L_0x01f4
            com.google.android.material.tabs.TabLayout r3 = r14.mTabLayout
            if (r3 == 0) goto L_0x01d2
            int r4 = r14.mSmartPageIndex
            r3.removeTabAt(r4)
        L_0x01d2:
            jp.co.sony.reonpocket.util.SafeArray<androidx.fragment.app.Fragment> r3 = r14.mRegisteredFragments
            int r4 = r14.mSmartPageIndex
            r3.removeAt(r4)
            java.util.List<jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page> r3 = r14.mTabPages
            int r4 = r14.mSmartPageIndex
            r3.remove(r4)
            jp.co.sony.reonpocket.modules.main.view.MainActivity$MainViewOutput r3 = r14.mOutput
            if (r3 == 0) goto L_0x01e8
            boolean r0 = r3.getIsRegisterTag()
        L_0x01e8:
            int r3 = r14.updateSmartPageIndex(r0)
            r14.mSmartPageIndex = r3
            int r0 = r14.updateWarmPageIndex(r0)
            r14.mWarmPageIndex = r0
        L_0x01f4:
            jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page r0 = r14.mLastSelectedPage
            int[] r3 = jp.co.sony.reonpocket.modules.main.view.MainActivity.WhenMappings.$EnumSwitchMapping$1
            int r0 = r0.ordinal()
            r0 = r3[r0]
            r3 = 1
            if (r0 == r3) goto L_0x0248
            r3 = 2
            if (r0 == r3) goto L_0x0233
            if (r0 == r1) goto L_0x0248
            r1 = 4
            if (r0 == r1) goto L_0x0213
            r15 = 5
            if (r0 != r15) goto L_0x020d
            goto L_0x0233
        L_0x020d:
            kotlin.NoWhenBranchMatchedException r15 = new kotlin.NoWhenBranchMatchedException
            r15.<init>()
            throw r15
        L_0x0213:
            if (r15 == 0) goto L_0x021e
            java.util.List<jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page> r15 = r14.mTabPages
            jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page r0 = jp.co.sony.reonpocket.modules.main.view.MainActivity.Companion.Page.COOL
            int r15 = r15.indexOf(r0)
            goto L_0x025c
        L_0x021e:
            java.util.List<jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page> r15 = r14.mTabPages
            jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page r0 = jp.co.sony.reonpocket.modules.main.view.MainActivity.Companion.Page.COOL
            int r15 = r15.indexOf(r0)
            java.util.List<jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page> r0 = r14.mTabPages
            jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page r1 = jp.co.sony.reonpocket.modules.main.view.MainActivity.Companion.Page.SMARTCOOL
            int r0 = r0.indexOf(r1)
            int r15 = java.lang.Math.max(r15, r0)
            goto L_0x025c
        L_0x0233:
            java.util.List<jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page> r15 = r14.mTabPages
            jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page r0 = jp.co.sony.reonpocket.modules.main.view.MainActivity.Companion.Page.WARM
            int r15 = r15.indexOf(r0)
            java.util.List<jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page> r0 = r14.mTabPages
            jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page r1 = jp.co.sony.reonpocket.modules.main.view.MainActivity.Companion.Page.SMARTWARM
            int r0 = r0.indexOf(r1)
            int r15 = java.lang.Math.max(r15, r0)
            goto L_0x025c
        L_0x0248:
            java.util.List<jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page> r15 = r14.mTabPages
            jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page r0 = jp.co.sony.reonpocket.modules.main.view.MainActivity.Companion.Page.COOL
            int r15 = r15.indexOf(r0)
            java.util.List<jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page> r0 = r14.mTabPages
            jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page r1 = jp.co.sony.reonpocket.modules.main.view.MainActivity.Companion.Page.SMARTCOOL
            int r0 = r0.indexOf(r1)
            int r15 = java.lang.Math.max(r15, r0)
        L_0x025c:
            com.google.android.material.tabs.TabLayout r0 = r14.mTabLayout
            if (r0 == 0) goto L_0x0269
            com.google.android.material.tabs.TabLayout$Tab r0 = r0.getTabAt(r15)
            if (r0 == 0) goto L_0x0269
            r0.select()
        L_0x0269:
            java.util.List<jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page> r0 = r14.mTabPages
            java.lang.Object r0 = r0.get(r15)
            jp.co.sony.reonpocket.modules.main.view.MainActivity$Companion$Page r0 = (jp.co.sony.reonpocket.modules.main.view.MainActivity.Companion.Page) r0
            r14.mLastSelectedPage = r0
            jp.co.sony.reonpocket.modules.main.view.MainActivity$SectionsPagerAdapter r0 = r14.mSectionsPagerAdapter
            if (r0 != 0) goto L_0x027d
            java.lang.String r0 = "mSectionsPagerAdapter"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto L_0x027e
        L_0x027d:
            r2 = r0
        L_0x027e:
            r2.notifyDataSetChanged()
            jp.co.sony.reonpocket.view.CustomViewPager r0 = r14.mViewPager
            if (r0 != 0) goto L_0x0286
            goto L_0x0289
        L_0x0286:
            r0.setCurrentItem(r15)
        L_0x0289:
            com.google.android.material.tabs.TabLayout r15 = r14.mTabLayout
            if (r15 == 0) goto L_0x0293
            r0 = r14
            com.google.android.material.tabs.TabLayout$BaseOnTabSelectedListener r0 = (com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener) r0
            r15.addOnTabSelectedListener(r0)
        L_0x0293:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.main.view.MainActivity.updateShowSmartMode(boolean):void");
    }

    private final void updateWarmOff() {
        SectionsPagerAdapter sectionsPagerAdapter = this.mSectionsPagerAdapter;
        if (sectionsPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSectionsPagerAdapter");
            sectionsPagerAdapter = null;
        }
        Fragment item = sectionsPagerAdapter.getItem(this.mWarmPageIndex);
        if (item instanceof MainWarmFragment) {
            ((MainWarmFragment) item).updateOff();
        }
    }

    public void showAutoStartNotification() {
        DialogHelperUtil dialogHelperUtil;
        Unit unit;
        MainViewOutput mainViewOutput = this.mOutput;
        if (mainViewOutput != null) {
            mainViewOutput.setAutoStart(true);
        }
        DataDialogFragment dataDialogFragment = this.mAutoDialogFragment;
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
        DataDialogFragment showDataDialog$default = DialogHelperUtil.showDataDialog$default(dialogHelperUtil, 0, BaseDialogFragment.Builder.DialogType.INFORMATION_PATTERN_3, DialogHelperUtil.RequestCode.INFORMATION.ordinal(), 0, 0, 0, 32, (Object) null);
        this.mAutoDialogFragment = showDataDialog$default;
        if (showDataDialog$default != null) {
            showDataDialog$default.setLifecycleListener(new MainActivity$showAutoStartNotification$2$1(this));
            Unit unit2 = Unit.INSTANCE;
        }
    }

    public void showNotification(String str, String str2, String str3, String str4, String str5, Bitmap bitmap) {
        Unit unit;
        DialogHelperUtil dialogHelperUtil;
        DialogHelperUtil dialogHelperUtil2;
        Unit unit2;
        String str6 = str;
        Intrinsics.checkNotNullParameter(str2, "aTitle");
        Intrinsics.checkNotNullParameter(str3, "aSubtitle");
        Intrinsics.checkNotNullParameter(str4, "aDescription");
        NotificationEntity mNotificationEntity = RemoteConfigUtil.INSTANCE.getMNotificationEntity();
        if (mNotificationEntity != null) {
            AnalyticsUtil.INSTANCE.logEventWithString(this, getMFirebaseAnalytics(), AnalyticsUtil.EventName.SHOW_INFORMATION, AnalyticsUtil.EventParameter.NOTIFICATION_ID, String.valueOf(mNotificationEntity.getVersion()));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            AnalyticsUtil.INSTANCE.logEventWithString(this, getMFirebaseAnalytics(), AnalyticsUtil.EventName.SHOW_INFORMATION, AnalyticsUtil.EventParameter.NOTIFICATION_ID, AnalyticsUtil.ParameterConstants.NO_ID.getValue());
        }
        DataDialogFragment dataDialogFragment = this.mNotificationDialogFragment;
        if (dataDialogFragment != null) {
            Dialog dialog = dataDialogFragment.getDialog();
            if (dialog != null) {
                if (!dialog.isShowing()) {
                    dialog.show();
                }
                unit2 = Unit.INSTANCE;
            } else {
                unit2 = null;
            }
            if (unit2 != null) {
                return;
            }
        }
        if (str6 == null || !Intrinsics.areEqual((Object) str6, (Object) MainActivityKt.BUTTON_PREFERENCE_TOP_LEFT)) {
            DialogHelperUtil dialogHelperUtil3 = this.mDialogHelper;
            if (dialogHelperUtil3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
                dialogHelperUtil = null;
            } else {
                dialogHelperUtil = dialogHelperUtil3;
            }
            DataDialogFragment showDataDialog = dialogHelperUtil.showDataDialog(str2, BaseDialogFragment.Builder.DialogType.INFORMATION, DialogHelperUtil.RequestCode.INFORMATION.ordinal(), R.string.common_ok, 0);
            this.mNotificationDialogFragment = showDataDialog;
            if (showDataDialog != null) {
                showDataDialog.setLifecycleListener(new MainActivity$showNotification$4$2(str3, this, str4, str5, bitmap));
                Unit unit3 = Unit.INSTANCE;
                return;
            }
            return;
        }
        DialogHelperUtil dialogHelperUtil4 = this.mDialogHelper;
        if (dialogHelperUtil4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil2 = null;
        } else {
            dialogHelperUtil2 = dialogHelperUtil4;
        }
        DataDialogFragment showDataDialog$default = DialogHelperUtil.showDataDialog$default(dialogHelperUtil2, 0, BaseDialogFragment.Builder.DialogType.INFORMATION_PATTERN_2, DialogHelperUtil.RequestCode.INFORMATION.ordinal(), 0, 0, 0, 32, (Object) null);
        this.mNotificationDialogFragment = showDataDialog$default;
        if (showDataDialog$default != null) {
            showDataDialog$default.setLifecycleListener(new MainActivity$showNotification$4$1$1(str2, str3, this, str4, str5, bitmap));
        }
    }

    public void onDataDialogSucceeded(BaseDialogFragment baseDialogFragment, int i, int i2) {
        EditText editText;
        MainViewOutput mainViewOutput;
        Intrinsics.checkNotNullParameter(baseDialogFragment, "aDialog");
        if (i == DialogHelperUtil.RequestCode.PASSWORD_SETTING.ordinal() && (editText = this.mPasswordEditText) != null && Intrinsics.areEqual((Object) editText.getText().toString(), (Object) MainActivityKt.SETTING_PASSWORD) && (mainViewOutput = this.mOutput) != null) {
            mainViewOutput.transitToSetting();
        }
    }

    public void onAlertDialogSucceeded(BaseDialogFragment baseDialogFragment, int i, int i2) {
        MainViewOutput mainViewOutput;
        Intrinsics.checkNotNullParameter(baseDialogFragment, "aDialog");
        if (i == DialogHelperUtil.RequestCode.TAG_DFU_FAILED.ordinal()) {
            MainViewOutput mainViewOutput2 = this.mOutput;
            if (mainViewOutput2 != null) {
                mainViewOutput2.tagScan();
            }
        } else if (i == DialogHelperUtil.RequestCode.WITH_SUPPORT.ordinal() && i2 == -1 && (mainViewOutput = this.mOutput) != null) {
            mainViewOutput.transitToSupport();
        }
    }

    private final void showCustomToast(String str) {
        LayoutInflater layoutInflater = getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "getLayoutInflater(...)");
        View inflate = layoutInflater.inflate(R.layout.view_toast, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.toast_msg);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setText(str);
        Toast toast = new Toast(this);
        this.mCustomToast = toast;
        Intrinsics.checkNotNull(toast);
        toast.setGravity(55, getResources().getDimensionPixelSize(R.dimen.mainToastTopBotMargin), 0);
        Toast toast2 = this.mCustomToast;
        Intrinsics.checkNotNull(toast2);
        toast2.setView(inflate);
        Toast toast3 = this.mCustomToast;
        Intrinsics.checkNotNull(toast3);
        toast3.setDuration(1);
        Toast toast4 = this.mCustomToast;
        Intrinsics.checkNotNull(toast4);
        toast4.show();
    }

    private final void showPassCheckDialog(Class<?> cls) {
        DialogHelperUtil dialogHelperUtil;
        Unit unit;
        DataDialogFragment dataDialogFragment = this.mPasswordDialogFragment;
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
        DataDialogFragment showDataDialog$default = DialogHelperUtil.showDataDialog$default(dialogHelperUtil, 0, BaseDialogFragment.Builder.DialogType.PASSWORD, Intrinsics.areEqual((Object) cls, (Object) SettingActivity.class) ? DialogHelperUtil.RequestCode.PASSWORD_SETTING.ordinal() : 0, R.string.common_ok, 0, 0, 32, (Object) null);
        this.mPasswordDialogFragment = showDataDialog$default;
        if (showDataDialog$default != null) {
            showDataDialog$default.setLifecycleListener(new MainActivity$showPassCheckDialog$2$1(this));
            Unit unit2 = Unit.INSTANCE;
        }
    }

    static /* synthetic */ void showModeChangeProgress$default(MainActivity mainActivity, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        mainActivity.showModeChangeProgress(num);
    }

    private final void showModeChangeProgress(Integer num) {
        if (!this.isShowingProgress && !this.mIsOff) {
            CountDownTimer countDownTimer = this.mProgressCountDownTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            CountDownTimer mainActivity$showModeChangeProgress$1 = new MainActivity$showModeChangeProgress$1(this);
            this.mProgressCountDownTimer = mainActivity$showModeChangeProgress$1;
            mainActivity$showModeChangeProgress$1.start();
            if (num != null) {
                String string = getString(num.intValue());
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                this.mProgressMessage = string;
            }
            showProgressDialog();
        }
    }

    public void updateCoolingStatus(DeviceCoolingCode deviceCoolingCode) {
        Intrinsics.checkNotNullParameter(deviceCoolingCode, "aCoolingCode");
        int i = WhenMappings.$EnumSwitchMapping$6[deviceCoolingCode.ordinal()];
        if (i == 1) {
            CustomImageView customImageView = this.mCoolingIcon;
            if (customImageView != null) {
                customImageView.clearAnimation();
            }
            CustomImageView customImageView2 = this.mCoolingIcon;
            if (customImageView2 != null) {
                customImageView2.setVisibility(8);
            }
        } else if (i == 2) {
            CustomImageView customImageView3 = this.mCoolingIcon;
            if (customImageView3 != null) {
                customImageView3.setVisibility(0);
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
            loadAnimation.setFillAfter(true);
            CustomImageView customImageView4 = this.mCoolingIcon;
            if (customImageView4 != null) {
                customImageView4.startAnimation(loadAnimation);
            }
        }
    }

    public final void showSmartCoolSetting() {
        SmartModePreference smartModePreference;
        SafeArray<Fragment> safeArray = this.mRegisteredFragments;
        CustomViewPager customViewPager = this.mViewPager;
        Integer valueOf = customViewPager != null ? Integer.valueOf(customViewPager.getCurrentItem()) : null;
        Intrinsics.checkNotNull(valueOf);
        if (safeArray.get(valueOf.intValue()) instanceof MainSmartCoolModeFragment) {
            TransitionSet transitionSet = new TransitionSet();
            Slide slide = new Slide();
            slide.setSlideEdge(80);
            transitionSet.addTransition(slide);
            int i = R.id.bottom_sheet;
            MainSmartCoolModeSettingFragment.Companion companion = MainSmartCoolModeSettingFragment.Companion;
            MainViewOutput mainViewOutput = this.mOutput;
            if (mainViewOutput == null || (smartModePreference = mainViewOutput.getSmartCoolPreference()) == null) {
                smartModePreference = SmartModePreference.WEAK;
            }
            showFragment(i, companion.newInstance(smartModePreference, true), false, transitionSet);
            LockableBottomSheetBehavior<View> lockableBottomSheetBehavior = this.mBehavior;
            if (lockableBottomSheetBehavior != null) {
                lockableBottomSheetBehavior.setState(3);
            }
            LockableBottomSheetBehavior<View> lockableBottomSheetBehavior2 = this.mBehavior;
            if (lockableBottomSheetBehavior2 != null) {
                lockableBottomSheetBehavior2.setSwipeEnabled(true);
            }
        }
    }

    public final void showSmartWarmSetting() {
        SmartModePreference smartModePreference;
        SafeArray<Fragment> safeArray = this.mRegisteredFragments;
        CustomViewPager customViewPager = this.mViewPager;
        Integer valueOf = customViewPager != null ? Integer.valueOf(customViewPager.getCurrentItem()) : null;
        Intrinsics.checkNotNull(valueOf);
        if (safeArray.get(valueOf.intValue()) instanceof MainSmartWarmFragment) {
            TransitionSet transitionSet = new TransitionSet();
            Slide slide = new Slide();
            slide.setSlideEdge(80);
            transitionSet.addTransition(slide);
            int i = R.id.bottom_sheet;
            MainSmartCoolModeSettingFragment.Companion companion = MainSmartCoolModeSettingFragment.Companion;
            MainViewOutput mainViewOutput = this.mOutput;
            if (mainViewOutput == null || (smartModePreference = mainViewOutput.getSmartWarmPreference()) == null) {
                smartModePreference = SmartModePreference.WEAK;
            }
            showFragment(i, companion.newInstance(smartModePreference, false), false, transitionSet);
            LockableBottomSheetBehavior<View> lockableBottomSheetBehavior = this.mBehavior;
            if (lockableBottomSheetBehavior != null) {
                lockableBottomSheetBehavior.setState(3);
            }
            LockableBottomSheetBehavior<View> lockableBottomSheetBehavior2 = this.mBehavior;
            if (lockableBottomSheetBehavior2 != null) {
                lockableBottomSheetBehavior2.setSwipeEnabled(true);
            }
        }
    }

    public void onSelected(SmartModePreference smartModePreference) {
        Intrinsics.checkNotNullParameter(smartModePreference, "smartModePreference");
        SafeArray<Fragment> safeArray = this.mRegisteredFragments;
        CustomViewPager customViewPager = this.mViewPager;
        Integer valueOf = customViewPager != null ? Integer.valueOf(customViewPager.getCurrentItem()) : null;
        Intrinsics.checkNotNull(valueOf);
        Fragment fragment = safeArray.get(valueOf.intValue());
        if (fragment instanceof MainSmartCoolModeFragment) {
            ((MainSmartCoolModeFragment) fragment).setSmartCoolPreference(!this.mIsOff, smartModePreference);
        }
        if (fragment instanceof MainSmartWarmFragment) {
            ((MainSmartWarmFragment) fragment).setSmartWarmPreference(!this.mIsOff, smartModePreference);
        }
    }

    public final void showSmartSetting() {
        SmartModePreference smartModePreference;
        SmartModePreference smartModePreference2;
        SafeArray<Fragment> safeArray = this.mRegisteredFragments;
        CustomViewPager customViewPager = this.mViewPager;
        Integer valueOf = customViewPager != null ? Integer.valueOf(customViewPager.getCurrentItem()) : null;
        Intrinsics.checkNotNull(valueOf);
        if (safeArray.get(valueOf.intValue()) instanceof MainSmartModeFragment) {
            TransitionSet transitionSet = new TransitionSet();
            Slide slide = new Slide();
            slide.setSlideEdge(80);
            transitionSet.addTransition(slide);
            int i = R.id.bottom_sheet;
            MainSmartModeSettingFragment.Companion companion = MainSmartModeSettingFragment.Companion;
            MainViewOutput mainViewOutput = this.mOutput;
            boolean smartMixPreference = mainViewOutput != null ? mainViewOutput.getSmartMixPreference() : true;
            MainViewOutput mainViewOutput2 = this.mOutput;
            if (mainViewOutput2 == null || (smartModePreference = mainViewOutput2.getSmartCoolPreference()) == null) {
                smartModePreference = SmartModePreference.WEAK;
            }
            MainViewOutput mainViewOutput3 = this.mOutput;
            if (mainViewOutput3 == null || (smartModePreference2 = mainViewOutput3.getSmartWarmPreference()) == null) {
                smartModePreference2 = SmartModePreference.WEAK;
            }
            MainViewOutput mainViewOutput4 = this.mOutput;
            double smartCoolTempSwitchThreshold = mainViewOutput4 != null ? mainViewOutput4.getSmartCoolTempSwitchThreshold() : 25.0d;
            MainViewOutput mainViewOutput5 = this.mOutput;
            showFragment(i, companion.newInstance(smartMixPreference, smartModePreference, smartModePreference2, smartCoolTempSwitchThreshold, mainViewOutput5 != null ? mainViewOutput5.getSmartWarmTempSwitchThreshold() : 25.0d, this.isTagInfoReceiving), false, transitionSet);
            LockableBottomSheetBehavior<View> lockableBottomSheetBehavior = this.mBehavior;
            if (lockableBottomSheetBehavior != null) {
                lockableBottomSheetBehavior.setState(3);
            }
            LockableBottomSheetBehavior<View> lockableBottomSheetBehavior2 = this.mBehavior;
            if (lockableBottomSheetBehavior2 != null) {
                lockableBottomSheetBehavior2.setSwipeEnabled(true);
            }
        }
    }

    public void onSmartModeSelected(SmartModePreference smartModePreference, SmartModePreference smartModePreference2, boolean z, double d, double d2) {
        Intrinsics.checkNotNullParameter(smartModePreference, "coolPref");
        Intrinsics.checkNotNullParameter(smartModePreference2, "warmPref");
        SafeArray<Fragment> safeArray = this.mRegisteredFragments;
        CustomViewPager customViewPager = this.mViewPager;
        Integer valueOf = customViewPager != null ? Integer.valueOf(customViewPager.getCurrentItem()) : null;
        Intrinsics.checkNotNull(valueOf);
        Fragment fragment = safeArray.get(valueOf.intValue());
        if (fragment instanceof MainSmartModeFragment) {
            ((MainSmartModeFragment) fragment).doSmartSetting(smartModePreference, smartModePreference2, d, d2);
        }
    }

    public final void showSmartSwitchingTempSetting() {
        SafeArray<Fragment> safeArray = this.mRegisteredFragments;
        CustomViewPager customViewPager = this.mViewPager;
        Integer valueOf = customViewPager != null ? Integer.valueOf(customViewPager.getCurrentItem()) : null;
        Intrinsics.checkNotNull(valueOf);
        if (safeArray.get(valueOf.intValue()) instanceof MainSmartModeFragment) {
            TransitionSet transitionSet = new TransitionSet();
            Slide slide = new Slide();
            slide.setSlideEdge(80);
            transitionSet.addTransition(slide);
            showFragment(R.id.bottom_sheet, MainSmartSettingSwitchingTempFragment.Companion.newInstance(), false, transitionSet);
            LockableBottomSheetBehavior<View> lockableBottomSheetBehavior = this.mBehavior;
            if (lockableBottomSheetBehavior != null) {
                lockableBottomSheetBehavior.setState(3);
            }
            LockableBottomSheetBehavior<View> lockableBottomSheetBehavior2 = this.mBehavior;
            if (lockableBottomSheetBehavior2 != null) {
                lockableBottomSheetBehavior2.setSwipeEnabled(true);
            }
        }
    }

    public void onSmartSwitchThresholdSelected(double d, double d2) {
        SafeArray<Fragment> safeArray = this.mRegisteredFragments;
        CustomViewPager customViewPager = this.mViewPager;
        Integer valueOf = customViewPager != null ? Integer.valueOf(customViewPager.getCurrentItem()) : null;
        Intrinsics.checkNotNull(valueOf);
        Fragment fragment = safeArray.get(valueOf.intValue());
        if (fragment instanceof MainSmartModeFragment) {
            ((MainSmartModeFragment) fragment).doSmartSetting(d, d2);
        }
    }

    public void setSwipeEnabled(boolean z) {
        LockableBottomSheetBehavior<View> lockableBottomSheetBehavior = this.mBehavior;
        if (lockableBottomSheetBehavior != null) {
            lockableBottomSheetBehavior.setSwipeEnabled(z);
        }
    }

    public void updateIsOff(boolean z) {
        this.mIsOff = z;
    }

    public void showAutoStopMessage() {
        if (!this.isForeground) {
            MainViewOutput mainViewOutput = this.mOutput;
            if (mainViewOutput != null) {
                mainViewOutput.setNextToastShow(true);
            }
            MainViewOutput mainViewOutput2 = this.mOutput;
            if (mainViewOutput2 != null) {
                mainViewOutput2.saveAutoStopTime(System.currentTimeMillis());
                return;
            }
            return;
        }
        MainViewOutput mainViewOutput3 = this.mOutput;
        if (mainViewOutput3 != null) {
            mainViewOutput3.setNextToastShow(false);
        }
        MainViewOutput mainViewOutput4 = this.mOutput;
        if (mainViewOutput4 != null) {
            mainViewOutput4.saveAutoStopTime(0);
        }
        String string = getString(R.string.mainview_toast_auto_stop);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        showCustomToast(string);
    }

    public void setIsForeground(boolean z) {
        this.isForeground = z;
    }

    public void calcelCustomToast() {
        Toast toast = this.mCustomToast;
        if (toast != null) {
            toast.cancel();
        }
    }

    public void setSmartCoolPreference(SmartModePreference smartModePreference) {
        MainViewOutput mainViewOutput = this.mOutput;
        if (mainViewOutput != null) {
            if (smartModePreference == null) {
                smartModePreference = SmartModePreference.OFF;
            }
            mainViewOutput.setSmartCoolPreference(smartModePreference);
        }
    }

    public void setSmartWarmPreference(SmartModePreference smartModePreference) {
        MainViewOutput mainViewOutput = this.mOutput;
        if (mainViewOutput != null) {
            if (smartModePreference == null) {
                smartModePreference = SmartModePreference.OFF;
            }
            mainViewOutput.setSmartWarmPreference(smartModePreference);
        }
    }

    public void setSmartMixPreference(Boolean bool) {
        MainViewOutput mainViewOutput = this.mOutput;
        if (mainViewOutput != null) {
            mainViewOutput.setSmartMixPreference(bool != null ? bool.booleanValue() : true);
        }
    }

    public void setSmartCoolTempSwitchThreshold(double d) {
        MainViewOutput mainViewOutput = this.mOutput;
        if (mainViewOutput != null) {
            mainViewOutput.setSmartCoolTempSwitchThreshold(d);
        }
    }

    public void setSmartWarmTempSwitchThreshold(double d) {
        MainViewOutput mainViewOutput = this.mOutput;
        if (mainViewOutput != null) {
            mainViewOutput.setSmartWarmTempSwitchThreshold(d);
        }
    }

    public boolean isActiveSmartMode() {
        SafeArray<Fragment> safeArray = this.mRegisteredFragments;
        CustomViewPager customViewPager = this.mViewPager;
        Integer valueOf = customViewPager != null ? Integer.valueOf(customViewPager.getCurrentItem()) : null;
        Intrinsics.checkNotNull(valueOf);
        Fragment fragment = safeArray.get(valueOf.intValue());
        if (fragment instanceof MainSmartCoolModeFragment) {
            return ((MainSmartCoolModeFragment) fragment).isActive();
        }
        if (!this.mIsRegisterTag) {
            return false;
        }
        if (fragment instanceof MainSmartModeFragment) {
            return ((MainSmartModeFragment) fragment).isActive();
        }
        if (fragment instanceof MainSmartWarmFragment) {
            return ((MainSmartWarmFragment) fragment).isActive();
        }
        return false;
    }

    public boolean isSmartMixTypeCool() {
        if (!this.mIsRegisterTag) {
            return false;
        }
        SafeArray<Fragment> safeArray = this.mRegisteredFragments;
        CustomViewPager customViewPager = this.mViewPager;
        Integer valueOf = customViewPager != null ? Integer.valueOf(customViewPager.getCurrentItem()) : null;
        Intrinsics.checkNotNull(valueOf);
        Fragment fragment = safeArray.get(valueOf.intValue());
        if (fragment instanceof MainSmartModeFragment) {
            return ((MainSmartModeFragment) fragment).isSmartMixTypeCool();
        }
        return false;
    }

    public Companion.Page getLastSelectedPage() {
        return this.mLastSelectedPage;
    }

    public void setIsShownSmartCoolBefore(boolean z) {
        MainViewOutput mainViewOutput = this.mOutput;
        if (mainViewOutput != null) {
            mainViewOutput.saveIsShownSmartCoolBefore(z);
        }
    }

    public void updateTagMiniInfoView(boolean z, NotifyTagSensorDataEntity notifyTagSensorDataEntity) {
        TagMiniInfoView tagMiniInfoView;
        if (z) {
            TagMiniInfoView tagMiniInfoView2 = this.mTagMiniInfoView;
            if (tagMiniInfoView2 != null) {
                tagMiniInfoView2.updateTagInfo(notifyTagSensorDataEntity);
            }
        } else if (TagInfoInteractorInput.DefaultImpls.isTagAvailableInThisCountry$default(this.mTagInfoInteractor, this, (String) null, 2, (Object) null) && (tagMiniInfoView = this.mTagMiniInfoView) != null) {
            tagMiniInfoView.updateTagInfoUnregistered();
        }
    }

    public void updateTagEntity(NotifyTagSensorDataEntity notifyTagSensorDataEntity, boolean z) {
        this.mTagInfo = notifyTagSensorDataEntity;
        this.isTagInfoReceiving = z;
    }

    public void updateTagMiniInfoViewNoReceiving(boolean z, TagDataEntity tagDataEntity) {
        TagMiniInfoView tagMiniInfoView;
        if (z) {
            TagMiniInfoView tagMiniInfoView2 = this.mTagMiniInfoView;
            if (tagMiniInfoView2 != null) {
                tagMiniInfoView2.updateTagInfoNoReceiving(tagDataEntity);
            }
        } else if (TagInfoInteractorInput.DefaultImpls.isTagAvailableInThisCountry$default(this.mTagInfoInteractor, this, (String) null, 2, (Object) null) && (tagMiniInfoView = this.mTagMiniInfoView) != null) {
            tagMiniInfoView.updateTagInfoUnregistered();
        }
    }

    public void updateTagMiniInfoView() {
        MainViewOutput mainViewOutput = this.mOutput;
        boolean isTagRegistered = mainViewOutput != null ? mainViewOutput.isTagRegistered() : false;
        boolean isTagAvailableInThisCountry$default = TagInfoInteractorInput.DefaultImpls.isTagAvailableInThisCountry$default(this.mTagInfoInteractor, this, (String) null, 2, (Object) null);
        if (isTagRegistered || isTagAvailableInThisCountry$default) {
            View view = this.mTagMiniInfoViewWrap;
            if (view != null) {
                view.setVisibility(8);
            }
            TagMiniInfoView tagMiniInfoView = this.mTagMiniInfoView;
            if (tagMiniInfoView != null) {
                tagMiniInfoView.setVisibility(0);
            }
            TagMiniInfoView tagMiniInfoView2 = this.mTagMiniInfoView;
            if (tagMiniInfoView2 != null) {
                tagMiniInfoView2.setOnClickListener(new MainActivity$$ExternalSyntheticLambda2(this));
                return;
            }
            return;
        }
        View view2 = this.mTagMiniInfoViewWrap;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        TagMiniInfoView tagMiniInfoView3 = this.mTagMiniInfoView;
        if (tagMiniInfoView3 != null) {
            tagMiniInfoView3.setVisibility(8);
        }
        TagMiniInfoView tagMiniInfoView4 = this.mTagMiniInfoView;
        if (tagMiniInfoView4 != null) {
            tagMiniInfoView4.setOnClickListener((View.OnClickListener) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void updateTagMiniInfoView$lambda$74(MainActivity mainActivity, View view) {
        Intrinsics.checkNotNullParameter(mainActivity, "this$0");
        MainViewOutput mainViewOutput = mainActivity.mOutput;
        if (mainViewOutput != null) {
            mainViewOutput.transitToTagInfo(mainActivity.isTagInfoReceiving, mainActivity.mIsTagNoAmbientTemp, mainActivity.mTagInfo);
        }
    }

    public void showTagUpdateMessage() {
        DialogBuilderUtil.INSTANCE.showTagFwUpdateDialog(this, new MainActivity$showTagUpdateMessage$1(this));
    }

    private final void showTagDfuDialog() {
        this.mDfuProgressBarDialog = DialogBuilderUtil.INSTANCE.showTagFwUpdateProgressDialog(this, new MainActivity$showTagDfuDialog$1(this));
    }

    public void showDfuComplete() {
        hiddenTagDfuProgress();
        this.mDfuCompleteDialog = DialogBuilderUtil.INSTANCE.showTagFwUpdateCompleteDialog(this);
    }

    private final void showDfuFailed() {
        DialogHelperUtil dialogHelperUtil = this.mDialogHelper;
        if (dialogHelperUtil == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogHelper");
            dialogHelperUtil = null;
        }
        dialogHelperUtil.showConfirmationDialog(R.string.tag_error_update_title, R.string.tag_error_update_description, 0, DialogHelperUtil.RequestCode.TAG_DFU_FAILED.ordinal(), Integer.valueOf(R.string.common_ok), (Integer) 0);
    }

    public void showDfuDisconnect() {
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setIndeterminate(true);
        }
    }

    public void showDfuFail() {
        MainViewOutput mainViewOutput = this.mOutput;
        if (mainViewOutput != null) {
            mainViewOutput.unregisterTag();
        }
        this.mIsRegisterTag = false;
        updateTagMiniInfoView(false, (NotifyTagSensorDataEntity) null);
        updateShowSmartMode(false);
        changeWarmMode(false);
        hiddenProgress();
        hiddenTagDfuProgress();
        showDfuFailed();
    }

    public void showDfuStarting() {
        hiddenProgress();
        showTagDfuDialog();
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setIndeterminate(true);
        }
    }

    public void updateDfuProgress(int i) {
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setIndeterminate(false);
        }
        ProgressBar progressBar2 = this.mProgressBar;
        if (progressBar2 != null) {
            progressBar2.setProgress(i);
        }
        CustomFontTextView customFontTextView = this.mPercentTextView;
        if (customFontTextView != null) {
            customFontTextView.setText(getString(R.string.setting_dfu_on_going_percent, new Object[]{Integer.valueOf(i)}));
        }
    }

    public void setIsShownSmartWarmBefore(boolean z) {
        MainViewOutput mainViewOutput = this.mOutput;
        if (mainViewOutput != null) {
            mainViewOutput.saveIsShownSmartWarmBefore(z);
        }
    }

    public void showTagRegisterDialog(String str, TagDataEntity tagDataEntity, String str2) {
        Intrinsics.checkNotNullParameter(str, "bdAddress");
        Intrinsics.checkNotNullParameter(tagDataEntity, "aTagInfo");
        Intrinsics.checkNotNullParameter(str2, "aTagModelName");
        if (this.isForeground && !this.isFoundDialogDisplay) {
            this.isFoundDialogDisplay = true;
            DialogBuilderUtil.INSTANCE.showTagFoundDialog(this, tagDataEntity, str2, new MainActivity$showTagRegisterDialog$1(this, str, tagDataEntity, str2));
        }
    }

    public void showTagRegisterDialog() {
        DialogBuilderUtil.INSTANCE.showTagRegisterDialog(this, new MainActivity$showTagRegisterDialog$2(this));
    }

    /* access modifiers changed from: private */
    public final void showTagRegisteredDialog(TagDataEntity tagDataEntity, String str) {
        if (this.isForeground) {
            MainViewOutput mainViewOutput = this.mOutput;
            if (mainViewOutput != null) {
                mainViewOutput.updateDialogStatus(true);
            }
            this.mTagRegisterSuccessDialog = DialogBuilderUtil.INSTANCE.showTagRegisteredDialog(this, tagDataEntity, str, new MainActivity$showTagRegisteredDialog$1(this));
            if (tagDataEntity.getFwVersionCode() < Integer.parseInt(UpdateVersionConstant.TAG_FIRMWARE_VERSION_CODE)) {
                tagDataEntity.getFwVersionCode();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void startTagScan() {
        MainViewOutput mainViewOutput = this.mOutput;
        boolean isTagRegistered = mainViewOutput != null ? mainViewOutput.isTagRegistered() : false;
        this.mIsTagRegistered = isTagRegistered;
        updateTagMiniInfoView(isTagRegistered, this.mTagInfo);
    }

    public void showTagRegistrationFailedDialog() {
        DialogBuilderUtil.INSTANCE.showTagRegistrationFailedDialog(this, new MainActivity$showTagRegistrationFailedDialog$1(this));
    }

    public void unRegisterTagStatus() {
        MainViewOutput mainViewOutput = this.mOutput;
        if (mainViewOutput != null) {
            mainViewOutput.unregisterTag();
        }
        updateTagMiniInfoView(false, (NotifyTagSensorDataEntity) null);
        updateTagMiniInfoView();
    }

    private final int updateCoolPageIndex() {
        return this.coolPageIndexDefaultValue;
    }

    private final int updateSmartPageIndex(boolean z) {
        int i = this.coolPageIndexDefaultValue;
        return z ? i + 1 : i;
    }

    private final int updateWarmPageIndex(boolean z) {
        int i = this.warmPageIndexDefaultValue;
        return z ? i + 1 : i;
    }

    public void updateNoReceiving(boolean z) {
        if (AccessController.getContext() == null) {
            DebugLogUtil.INSTANCE.e("fun updateNoReceiving error: getContext() is null");
            return;
        }
        SafeArray<Fragment> safeArray = this.mRegisteredFragments;
        CustomViewPager customViewPager = this.mViewPager;
        Integer valueOf = customViewPager != null ? Integer.valueOf(customViewPager.getCurrentItem()) : null;
        Intrinsics.checkNotNull(valueOf);
        Fragment fragment = safeArray.get(valueOf.intValue());
        if (fragment instanceof MainSmartCoolModeFragment) {
            ((MainSmartCoolModeFragment) fragment).updateNoReceiving(z);
        } else if (fragment instanceof MainSmartModeFragment) {
            ((MainSmartModeFragment) fragment).updateNoReceiving(z);
        } else if (fragment instanceof MainSmartWarmFragment) {
            ((MainSmartWarmFragment) fragment).updateNoReceiving(z);
        }
    }

    public void updateNoAmbientTemperature(boolean z) {
        this.mIsTagNoAmbientTemp = z;
        SafeArray<Fragment> safeArray = this.mRegisteredFragments;
        CustomViewPager customViewPager = this.mViewPager;
        Integer valueOf = customViewPager != null ? Integer.valueOf(customViewPager.getCurrentItem()) : null;
        Intrinsics.checkNotNull(valueOf);
        Fragment fragment = safeArray.get(valueOf.intValue());
        if (fragment instanceof MainSmartCoolModeFragment) {
            ((MainSmartCoolModeFragment) fragment).updateNoAmbientTemp(z);
        } else if (fragment instanceof MainSmartModeFragment) {
            ((MainSmartModeFragment) fragment).updateNoAmbientTemp(z);
        } else if (fragment instanceof MainSmartWarmFragment) {
            ((MainSmartWarmFragment) fragment).updateNoAmbientTemp(z);
        }
    }

    private final void checkRelatedErrorNotificationAndShowDialog(Intent intent) {
        String convertNotificationIdToErrorReason;
        Serializable serializableExtra = intent.getSerializableExtra(SHOW_ERROR_DIALOG_KEY_RELATED_NOTIFICATION_ID);
        NotificationId notificationId = serializableExtra instanceof NotificationId ? (NotificationId) serializableExtra : null;
        if (notificationId != null && (convertNotificationIdToErrorReason = BaseActivityKt.convertNotificationIdToErrorReason(notificationId)) != null) {
            setErrorReason(convertNotificationIdToErrorReason);
        }
    }

    /* access modifiers changed from: private */
    public final void hiddenModeSwitchProgress() {
        Dialog dialog;
        this.isShowingModeSwitchProgress = false;
        ProgressDialogFragment progressDialogFragment = this.mModeSwitchProgressDialog;
        if (progressDialogFragment != null && (dialog = progressDialogFragment.getDialog()) != null) {
            dialog.dismiss();
        }
    }

    public void hiddenProgress() {
        Dialog dialog;
        this.isShowingProgress = false;
        ProgressDialogFragment progressDialogFragment = this.mProgressDialog;
        if (progressDialogFragment != null && (dialog = progressDialogFragment.getDialog()) != null) {
            dialog.dismiss();
        }
    }

    public void hiddenTagDfuProgress() {
        Dialog dialog;
        DataDialogFragment dataDialogFragment = this.mDfuProgressBarDialog;
        if (dataDialogFragment != null && (dialog = dataDialogFragment.getDialog()) != null) {
            dialog.dismiss();
        }
    }

    public void showModeSwitchingProgress() {
        CountDownTimer countDownTimer = this.mModeSwitchProgressCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer mainActivity$showModeSwitchingProgress$1 = new MainActivity$showModeSwitchingProgress$1(this);
        this.mModeSwitchProgressCountDownTimer = mainActivity$showModeSwitchingProgress$1;
        mainActivity$showModeSwitchingProgress$1.start();
        if (!this.isShowingModeSwitchProgress) {
            showModeSwitchProgressDialog();
        }
    }

    public void dismissModeSwitchingProgress() {
        CountDownTimer countDownTimer = this.mModeSwitchProgressCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        hiddenModeSwitchProgress();
    }

    @Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\bH&J\b\u0010\u000e\u001a\u00020\bH&J\b\u0010\u000f\u001a\u00020\bH&J\b\u0010\u0010\u001a\u00020\bH&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\bH&J\b\u0010\u0018\u001a\u00020\u0014H&J\b\u0010\u0019\u001a\u00020\u0016H&J\b\u0010\u001a\u001a\u00020\bH&J\b\u0010\u001b\u001a\u00020\bH&J\b\u0010\u001c\u001a\u00020\u0003H&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\bH&J\b\u0010\u001f\u001a\u00020\u0003H&J\b\u0010 \u001a\u00020\u0003H&J\b\u0010!\u001a\u00020\u0003H&J\b\u0010\"\u001a\u00020\u0003H&J\b\u0010#\u001a\u00020\u0003H&J \u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020&H&J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\bH&J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\nH&J\u0010\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\bH&J\u0010\u00100\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\bH&J\u0010\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u0012H&J\u0010\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\bH&J\u0010\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u00020\bH&J\u0010\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0014H&J\u0010\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0016H&J\u0010\u0010;\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\bH&J\u0010\u0010=\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0014H&J\u0010\u0010>\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0016H&J\u0010\u0010?\u001a\u00020\u00032\u0006\u0010@\u001a\u00020AH&J\b\u0010B\u001a\u00020\u0003H&J\b\u0010C\u001a\u00020\u0003H&J\u0014\u0010D\u001a\u00020\u00032\n\b\u0002\u0010E\u001a\u0004\u0018\u00010FH&J\u0017\u0010G\u001a\u00020\u00032\b\u0010H\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0002\u0010IJ\b\u0010J\u001a\u00020\u0003H&J\b\u0010K\u001a\u00020\u0003H&J\b\u0010L\u001a\u00020\u0003H&J\"\u0010M\u001a\u00020\u00032\u0006\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010PH&J\b\u0010Q\u001a\u00020\u0003H&J\u0010\u0010R\u001a\u00020\u00032\u0006\u0010S\u001a\u00020\bH&J\u0010\u0010T\u001a\u00020\u00032\u0006\u0010U\u001a\u00020VH&J\b\u0010W\u001a\u00020\u0003H&¨\u0006X"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainActivity$MainViewOutput;", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewOutput;", "checkRemoteConfig", "", "disconnect", "getAutoModeStatus", "Ljp/co/sony/reonpocket/constant/AutoModeStatus;", "getAutoStartState", "", "getAutoStopTime", "", "getCapability", "Ljp/co/sony/reonpocket/data/entity/CapabilityEntity;", "getIsRegisterTag", "getIsShownSmartCoolBefore", "getIsShownSmartWarmBefore", "getOnWriteSetTagControlResult", "getPagePosition", "", "getSmartCoolPreference", "Ljp/co/sony/reonpocket/constant/SmartModePreference;", "getSmartCoolTempSwitchThreshold", "", "getSmartMixPreference", "getSmartWarmPreference", "getSmartWarmTempSwitchThreshold", "isConnected", "isTagRegistered", "markAutoStartPopupShown", "markLocationPopup", "aIsShow", "onTagWriteFailed", "readAutoStart", "readBattery", "readBoost", "readDeviceMode", "registerTag", "bdAddress", "", "entity", "Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity;", "deviceName", "saveAutoStartState", "aIsEnable", "saveAutoStopTime", "aValue", "saveIsShownSmartCoolBefore", "aIsSmartShown", "saveIsShownSmartWarmBefore", "savePagePosition", "aPos", "setAutoStart", "aIsOn", "setNextToastShow", "isNextShow", "setSmartCoolPreference", "aSmartPreference", "setSmartCoolTempSwitchThreshold", "value", "setSmartMixPreference", "aIsCoolMode", "setSmartWarmPreference", "setSmartWarmTempSwitchThreshold", "setTagScanListener", "info", "Ljp/co/sony/reonpocket/data/interactor/TagScanInteractor$TagInfo;", "startDfu", "tagScan", "transitToConnection", "aBundle", "Landroid/os/Bundle;", "transitToDeviceInfo", "aErrorCode", "(Ljava/lang/Integer;)V", "transitToSetting", "transitToSplash", "transitToSupport", "transitToTagInfo", "isTagInfoReceiving", "isTagNoAmbientTemp", "Ljp/co/sony/reonpocket/data/entity/NotifyTagSensorDataEntity;", "unregisterTag", "updateDialogStatus", "isShow", "writeDeviceMode", "aEntity", "Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity;", "writeDeviceModeOff", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainActivity.kt */
    public interface MainViewOutput extends BaseViewOutput {
        void checkRemoteConfig();

        void disconnect();

        AutoModeStatus getAutoModeStatus();

        boolean getAutoStartState();

        long getAutoStopTime();

        CapabilityEntity getCapability();

        boolean getIsRegisterTag();

        boolean getIsShownSmartCoolBefore();

        boolean getIsShownSmartWarmBefore();

        boolean getOnWriteSetTagControlResult();

        int getPagePosition();

        SmartModePreference getSmartCoolPreference();

        double getSmartCoolTempSwitchThreshold();

        boolean getSmartMixPreference();

        SmartModePreference getSmartWarmPreference();

        double getSmartWarmTempSwitchThreshold();

        boolean isConnected();

        boolean isTagRegistered();

        void markAutoStartPopupShown();

        void markLocationPopup(boolean z);

        void onTagWriteFailed();

        void readAutoStart();

        void readBattery();

        void readBoost();

        void readDeviceMode();

        void registerTag(String str, TagDataEntity tagDataEntity, String str2);

        void saveAutoStartState(boolean z);

        void saveAutoStopTime(long j);

        void saveIsShownSmartCoolBefore(boolean z);

        void saveIsShownSmartWarmBefore(boolean z);

        void savePagePosition(int i);

        void setAutoStart(boolean z);

        void setNextToastShow(boolean z);

        void setSmartCoolPreference(SmartModePreference smartModePreference);

        void setSmartCoolTempSwitchThreshold(double d);

        void setSmartMixPreference(boolean z);

        void setSmartWarmPreference(SmartModePreference smartModePreference);

        void setSmartWarmTempSwitchThreshold(double d);

        void setTagScanListener(TagScanInteractor.TagInfo tagInfo);

        void startDfu();

        void tagScan();

        void transitToConnection(Bundle bundle);

        void transitToDeviceInfo(Integer num);

        void transitToSetting();

        void transitToSplash();

        void transitToSupport();

        void transitToTagInfo(boolean z, boolean z2, NotifyTagSensorDataEntity notifyTagSensorDataEntity);

        void unregisterTag();

        void updateDialogStatus(boolean z);

        void writeDeviceMode(DeviceModeEntity deviceModeEntity);

        void writeDeviceModeOff();

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* compiled from: MainActivity.kt */
        public static final class DefaultImpls {
            public static /* synthetic */ void transitToConnection$default(MainViewOutput mainViewOutput, Bundle bundle, int i, Object obj) {
                if (obj == null) {
                    if ((i & 1) != 0) {
                        bundle = null;
                    }
                    mainViewOutput.transitToConnection(bundle);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: transitToConnection");
            }
        }
    }
}
