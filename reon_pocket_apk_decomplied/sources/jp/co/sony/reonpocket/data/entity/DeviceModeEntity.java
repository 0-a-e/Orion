package jp.co.sony.reonpocket.data.entity;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import jp.co.sony.reonpocket.ReonPocketApplication;
import jp.co.sony.reonpocket.constant.BleActionCode;
import jp.co.sony.reonpocket.constant.BoostStatus;
import jp.co.sony.reonpocket.constant.ContinuousOperationStatus;
import jp.co.sony.reonpocket.constant.CoolBoost;
import jp.co.sony.reonpocket.constant.CoolHeatTypeCode;
import jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode;
import jp.co.sony.reonpocket.constant.DeviceCoolingCode;
import jp.co.sony.reonpocket.constant.DeviceModeActionCode;
import jp.co.sony.reonpocket.constant.DeviceModeSettingTriggerCode;
import jp.co.sony.reonpocket.constant.FanStepCode;
import jp.co.sony.reonpocket.constant.ModeCommonSettingOperation;
import jp.co.sony.reonpocket.constant.ModelConstant;
import jp.co.sony.reonpocket.constant.MyModeActionType;
import jp.co.sony.reonpocket.constant.MyModeOperationCode;
import jp.co.sony.reonpocket.constant.MyModeSpecialSubMode;
import jp.co.sony.reonpocket.constant.MyModeTypeCode;
import jp.co.sony.reonpocket.constant.MyTempStepCode;
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
import jp.co.sony.reonpocket.data.interactor.DeviceInfoInteractor;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.util.RemoteConfigUtil;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0003\b\u0001\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\b\u0018\u0000 Ý\u00012\u00020\u0001:\bÝ\u0001Þ\u0001ß\u0001à\u0001BË\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000103\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000109¢\u0006\u0002\u0010:J\f\u0010¬\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010­\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\f\u0010®\u0001\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\f\u0010¯\u0001\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u0011\u0010°\u0001\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010DJ\u0011\u0010±\u0001\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010DJ\u0011\u0010²\u0001\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010DJ\f\u0010³\u0001\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\f\u0010´\u0001\u001a\u0004\u0018\u00010 HÆ\u0003J\u0011\u0010µ\u0001\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010DJ\u0011\u0010¶\u0001\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010DJ\f\u0010·\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010¸\u0001\u001a\u0004\u0018\u00010$HÆ\u0003J\u0011\u0010¹\u0001\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010DJ\f\u0010º\u0001\u001a\u0004\u0018\u00010'HÆ\u0003J\u0011\u0010»\u0001\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010DJ\f\u0010¼\u0001\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\f\u0010½\u0001\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u0011\u0010¾\u0001\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010DJ\u0011\u0010¿\u0001\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010DJ\f\u0010À\u0001\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\f\u0010Á\u0001\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\f\u0010Â\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010Ã\u0001\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010DJ\u0011\u0010Ä\u0001\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010DJ\u0011\u0010Å\u0001\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010DJ\f\u0010Æ\u0001\u001a\u0004\u0018\u000103HÆ\u0003J\f\u0010Ç\u0001\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\f\u0010È\u0001\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u0011\u0010É\u0001\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010DJ\u0011\u0010Ê\u0001\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010DJ\f\u0010Ë\u0001\u001a\u0004\u0018\u000109HÆ\u0003J\f\u0010Ì\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003J\f\u0010Í\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\f\u0010Î\u0001\u001a\u0004\u0018\u00010\rHÆ\u0003J\f\u0010Ï\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\f\u0010Ð\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0011\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010DJØ\u0003\u0010Ò\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u00108\u001a\u0004\u0018\u000109HÆ\u0001¢\u0006\u0003\u0010Ó\u0001J\u0017\u0010Ô\u0001\u001a\u00030Õ\u00012\n\u0010Ö\u0001\u001a\u0005\u0018\u00010×\u0001HÖ\u0003J\n\u0010Ø\u0001\u001a\u00020\u0013HÖ\u0001J\f\u0010Ù\u0001\u001a\u0005\u0018\u00010Ú\u0001H\u0016J\u000b\u0010Û\u0001\u001a\u00030Ü\u0001HÖ\u0001R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bT\u0010D\"\u0004\bU\u0010FR\u001c\u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001c\u0010)\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010<\"\u0004\b_\u0010>R\u001e\u0010+\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\b`\u0010D\"\u0004\ba\u0010FR\u001e\u0010(\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bb\u0010D\"\u0004\bc\u0010FR\u001c\u0010*\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u001c\u00104\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010<\"\u0004\bi\u0010>R\u001e\u00107\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bj\u0010D\"\u0004\bk\u0010FR\u001e\u00106\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bl\u0010D\"\u0004\bm\u0010FR\u001c\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u001c\u00105\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010e\"\u0004\bs\u0010gR\u001c\u0010-\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010<\"\u0004\bu\u0010>R\u001e\u0010/\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bv\u0010D\"\u0004\bw\u0010FR\u001e\u0010,\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bx\u0010D\"\u0004\by\u0010FR\u001c\u0010.\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010e\"\u0004\b{\u0010gR\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010}\"\u0004\b~\u0010R \u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R \u0010\"\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0012\n\u0002\u0010G\u001a\u0005\b\u0001\u0010D\"\u0005\b\u0001\u0010FR \u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R \u0010!\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0012\n\u0002\u0010G\u001a\u0005\b\u0001\u0010D\"\u0005\b\u0001\u0010FR \u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R \u00100\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0012\n\u0002\u0010G\u001a\u0005\b\u0001\u0010D\"\u0005\b\u0001\u0010FR \u0010%\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0012\n\u0002\u0010G\u001a\u0005\b\u0001\u0010D\"\u0005\b\u0001\u0010FR \u00101\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0012\n\u0002\u0010G\u001a\u0005\b\u0001\u0010D\"\u0005\b\u0001\u0010FR \u0010\u001c\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0012\n\u0002\u0010G\u001a\u0005\b\u0001\u0010D\"\u0005\b\u0001\u0010FR \u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R \u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R \u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R \u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¤\u0001\u0010¥\u0001\"\u0006\b¦\u0001\u0010§\u0001R \u0010\u001b\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0012\n\u0002\u0010G\u001a\u0005\b¨\u0001\u0010D\"\u0005\b©\u0001\u0010FR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bª\u0001\u0010e\"\u0005\b«\u0001\u0010g¨\u0006á\u0001"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity;", "Ljp/co/sony/reonpocket/data/entity/BaseEntity;", "mode", "Ljp/co/sony/reonpocket/constant/DeviceModeActionCode;", "settingTrigger", "Ljp/co/sony/reonpocket/constant/DeviceModeSettingTriggerCode;", "coolingCode", "Ljp/co/sony/reonpocket/constant/DeviceCoolingCode;", "continuousOperationStatus", "Ljp/co/sony/reonpocket/constant/ContinuousOperationStatus;", "switchCoolHeatWaitStatus", "Ljp/co/sony/reonpocket/constant/SwitchCoolHeatWaitStatus;", "coolHeatType", "Ljp/co/sony/reonpocket/constant/CoolHeatTypeCode;", "temperatureEntity", "Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity$Temperature;", "commonOperation", "Ljp/co/sony/reonpocket/constant/ModeCommonSettingOperation;", "commonStopDuration", "", "temperature", "Ljp/co/sony/reonpocket/constant/TempStepCode;", "boostOption", "Ljp/co/sony/reonpocket/constant/TempBoostOption;", "waveOption", "Ljp/co/sony/reonpocket/constant/TempWaveOption;", "currentModeRemainTime", "totalDuration", "remainDuration", "myModeActionType", "Ljp/co/sony/reonpocket/constant/MyModeActionType;", "myModeSpecialSubMode", "Ljp/co/sony/reonpocket/constant/MyModeSpecialSubMode;", "myModeSpecialTotalTime", "myModeSpecialRemainTime", "myModeAction", "Ljp/co/sony/reonpocket/constant/MyModeOperationCode;", "mySettingNo", "myModeType", "Ljp/co/sony/reonpocket/constant/MyModeTypeCode;", "myCoolTemp", "myCoolBoostOption", "myCoolWaveOption", "myCoolDuration", "myHeatTemp", "myHeatBoostOption", "myHeatWaveOption", "myHeatDuration", "myOffDuration", "myTotalDuration", "myCurrentTemperatureStep", "Ljp/co/sony/reonpocket/constant/MyTempStepCode;", "myCurrentBoostOption", "myCurrentWaveOption", "myCurrentRemainDuration", "myCurrentDuration", "fanStep", "Ljp/co/sony/reonpocket/constant/FanStepCode;", "(Ljp/co/sony/reonpocket/constant/DeviceModeActionCode;Ljp/co/sony/reonpocket/constant/DeviceModeSettingTriggerCode;Ljp/co/sony/reonpocket/constant/DeviceCoolingCode;Ljp/co/sony/reonpocket/constant/ContinuousOperationStatus;Ljp/co/sony/reonpocket/constant/SwitchCoolHeatWaitStatus;Ljp/co/sony/reonpocket/constant/CoolHeatTypeCode;Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity$Temperature;Ljp/co/sony/reonpocket/constant/ModeCommonSettingOperation;Ljava/lang/Integer;Ljp/co/sony/reonpocket/constant/TempStepCode;Ljp/co/sony/reonpocket/constant/TempBoostOption;Ljp/co/sony/reonpocket/constant/TempWaveOption;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljp/co/sony/reonpocket/constant/MyModeActionType;Ljp/co/sony/reonpocket/constant/MyModeSpecialSubMode;Ljava/lang/Integer;Ljava/lang/Integer;Ljp/co/sony/reonpocket/constant/MyModeOperationCode;Ljava/lang/Integer;Ljp/co/sony/reonpocket/constant/MyModeTypeCode;Ljava/lang/Integer;Ljp/co/sony/reonpocket/constant/TempBoostOption;Ljp/co/sony/reonpocket/constant/TempWaveOption;Ljava/lang/Integer;Ljava/lang/Integer;Ljp/co/sony/reonpocket/constant/TempBoostOption;Ljp/co/sony/reonpocket/constant/TempWaveOption;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljp/co/sony/reonpocket/constant/MyTempStepCode;Ljp/co/sony/reonpocket/constant/TempBoostOption;Ljp/co/sony/reonpocket/constant/TempWaveOption;Ljava/lang/Integer;Ljava/lang/Integer;Ljp/co/sony/reonpocket/constant/FanStepCode;)V", "getBoostOption", "()Ljp/co/sony/reonpocket/constant/TempBoostOption;", "setBoostOption", "(Ljp/co/sony/reonpocket/constant/TempBoostOption;)V", "getCommonOperation", "()Ljp/co/sony/reonpocket/constant/ModeCommonSettingOperation;", "setCommonOperation", "(Ljp/co/sony/reonpocket/constant/ModeCommonSettingOperation;)V", "getCommonStopDuration", "()Ljava/lang/Integer;", "setCommonStopDuration", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getContinuousOperationStatus", "()Ljp/co/sony/reonpocket/constant/ContinuousOperationStatus;", "setContinuousOperationStatus", "(Ljp/co/sony/reonpocket/constant/ContinuousOperationStatus;)V", "getCoolHeatType", "()Ljp/co/sony/reonpocket/constant/CoolHeatTypeCode;", "setCoolHeatType", "(Ljp/co/sony/reonpocket/constant/CoolHeatTypeCode;)V", "getCoolingCode", "()Ljp/co/sony/reonpocket/constant/DeviceCoolingCode;", "setCoolingCode", "(Ljp/co/sony/reonpocket/constant/DeviceCoolingCode;)V", "getCurrentModeRemainTime", "setCurrentModeRemainTime", "getFanStep", "()Ljp/co/sony/reonpocket/constant/FanStepCode;", "setFanStep", "(Ljp/co/sony/reonpocket/constant/FanStepCode;)V", "getMode", "()Ljp/co/sony/reonpocket/constant/DeviceModeActionCode;", "setMode", "(Ljp/co/sony/reonpocket/constant/DeviceModeActionCode;)V", "getMyCoolBoostOption", "setMyCoolBoostOption", "getMyCoolDuration", "setMyCoolDuration", "getMyCoolTemp", "setMyCoolTemp", "getMyCoolWaveOption", "()Ljp/co/sony/reonpocket/constant/TempWaveOption;", "setMyCoolWaveOption", "(Ljp/co/sony/reonpocket/constant/TempWaveOption;)V", "getMyCurrentBoostOption", "setMyCurrentBoostOption", "getMyCurrentDuration", "setMyCurrentDuration", "getMyCurrentRemainDuration", "setMyCurrentRemainDuration", "getMyCurrentTemperatureStep", "()Ljp/co/sony/reonpocket/constant/MyTempStepCode;", "setMyCurrentTemperatureStep", "(Ljp/co/sony/reonpocket/constant/MyTempStepCode;)V", "getMyCurrentWaveOption", "setMyCurrentWaveOption", "getMyHeatBoostOption", "setMyHeatBoostOption", "getMyHeatDuration", "setMyHeatDuration", "getMyHeatTemp", "setMyHeatTemp", "getMyHeatWaveOption", "setMyHeatWaveOption", "getMyModeAction", "()Ljp/co/sony/reonpocket/constant/MyModeOperationCode;", "setMyModeAction", "(Ljp/co/sony/reonpocket/constant/MyModeOperationCode;)V", "getMyModeActionType", "()Ljp/co/sony/reonpocket/constant/MyModeActionType;", "setMyModeActionType", "(Ljp/co/sony/reonpocket/constant/MyModeActionType;)V", "getMyModeSpecialRemainTime", "setMyModeSpecialRemainTime", "getMyModeSpecialSubMode", "()Ljp/co/sony/reonpocket/constant/MyModeSpecialSubMode;", "setMyModeSpecialSubMode", "(Ljp/co/sony/reonpocket/constant/MyModeSpecialSubMode;)V", "getMyModeSpecialTotalTime", "setMyModeSpecialTotalTime", "getMyModeType", "()Ljp/co/sony/reonpocket/constant/MyModeTypeCode;", "setMyModeType", "(Ljp/co/sony/reonpocket/constant/MyModeTypeCode;)V", "getMyOffDuration", "setMyOffDuration", "getMySettingNo", "setMySettingNo", "getMyTotalDuration", "setMyTotalDuration", "getRemainDuration", "setRemainDuration", "getSettingTrigger", "()Ljp/co/sony/reonpocket/constant/DeviceModeSettingTriggerCode;", "setSettingTrigger", "(Ljp/co/sony/reonpocket/constant/DeviceModeSettingTriggerCode;)V", "getSwitchCoolHeatWaitStatus", "()Ljp/co/sony/reonpocket/constant/SwitchCoolHeatWaitStatus;", "setSwitchCoolHeatWaitStatus", "(Ljp/co/sony/reonpocket/constant/SwitchCoolHeatWaitStatus;)V", "getTemperature", "()Ljp/co/sony/reonpocket/constant/TempStepCode;", "setTemperature", "(Ljp/co/sony/reonpocket/constant/TempStepCode;)V", "getTemperatureEntity", "()Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity$Temperature;", "setTemperatureEntity", "(Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity$Temperature;)V", "getTotalDuration", "setTotalDuration", "getWaveOption", "setWaveOption", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljp/co/sony/reonpocket/constant/DeviceModeActionCode;Ljp/co/sony/reonpocket/constant/DeviceModeSettingTriggerCode;Ljp/co/sony/reonpocket/constant/DeviceCoolingCode;Ljp/co/sony/reonpocket/constant/ContinuousOperationStatus;Ljp/co/sony/reonpocket/constant/SwitchCoolHeatWaitStatus;Ljp/co/sony/reonpocket/constant/CoolHeatTypeCode;Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity$Temperature;Ljp/co/sony/reonpocket/constant/ModeCommonSettingOperation;Ljava/lang/Integer;Ljp/co/sony/reonpocket/constant/TempStepCode;Ljp/co/sony/reonpocket/constant/TempBoostOption;Ljp/co/sony/reonpocket/constant/TempWaveOption;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljp/co/sony/reonpocket/constant/MyModeActionType;Ljp/co/sony/reonpocket/constant/MyModeSpecialSubMode;Ljava/lang/Integer;Ljava/lang/Integer;Ljp/co/sony/reonpocket/constant/MyModeOperationCode;Ljava/lang/Integer;Ljp/co/sony/reonpocket/constant/MyModeTypeCode;Ljava/lang/Integer;Ljp/co/sony/reonpocket/constant/TempBoostOption;Ljp/co/sony/reonpocket/constant/TempWaveOption;Ljava/lang/Integer;Ljava/lang/Integer;Ljp/co/sony/reonpocket/constant/TempBoostOption;Ljp/co/sony/reonpocket/constant/TempWaveOption;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljp/co/sony/reonpocket/constant/MyTempStepCode;Ljp/co/sony/reonpocket/constant/TempBoostOption;Ljp/co/sony/reonpocket/constant/TempWaveOption;Ljava/lang/Integer;Ljava/lang/Integer;Ljp/co/sony/reonpocket/constant/FanStepCode;)Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity;", "equals", "", "other", "", "hashCode", "toByte", "", "toString", "", "Companion", "SmartCoolModeCombine", "SmartWarmModeCombine", "Temperature", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DeviceModeEntity.kt */
public final class DeviceModeEntity implements BaseEntity {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final byte INVALID_WRITE_DATA = 0;
    /* access modifiers changed from: private */
    public static final Map<SmartModePreference, Integer> smartCoolDefaultPrefMap = MapsKt.mapOf(TuplesKt.to(SmartModePreference.WEAK, 2900), TuplesKt.to(SmartModePreference.LOWER_WEAK, 2775), TuplesKt.to(SmartModePreference.NORMAL, 2650), TuplesKt.to(SmartModePreference.LOWER_STRONG, 2600), TuplesKt.to(SmartModePreference.STRONG, 2550));
    /* access modifiers changed from: private */
    public static final Map<SmartModePreference, Integer> smartCoolRNP5PrefMap = MapsKt.mapOf(TuplesKt.to(SmartModePreference.WEAK, 2900), TuplesKt.to(SmartModePreference.LOWER_WEAK, 2775), TuplesKt.to(SmartModePreference.NORMAL, 2650), TuplesKt.to(SmartModePreference.LOWER_STRONG, 2525), TuplesKt.to(SmartModePreference.STRONG, 2400));
    /* access modifiers changed from: private */
    public static final Map<SmartModePreference, Integer> smartCoolRNPP1PrefMap = MapsKt.mapOf(TuplesKt.to(SmartModePreference.WEAK, 2900), TuplesKt.to(SmartModePreference.LOWER_WEAK, 2700), TuplesKt.to(SmartModePreference.NORMAL, 2500), TuplesKt.to(SmartModePreference.LOWER_STRONG, 2300), TuplesKt.to(SmartModePreference.STRONG, 2100));
    /* access modifiers changed from: private */
    public static final ArrayList<Integer> smartWarmDefaultPrefList = CollectionsKt.arrayListOf(3800, 3900, 4050, 4125, 4200);
    private TempBoostOption boostOption;
    private ModeCommonSettingOperation commonOperation;
    private Integer commonStopDuration;
    private ContinuousOperationStatus continuousOperationStatus;
    private CoolHeatTypeCode coolHeatType;
    private DeviceCoolingCode coolingCode;
    private Integer currentModeRemainTime;
    private FanStepCode fanStep;
    private DeviceModeActionCode mode;
    private TempBoostOption myCoolBoostOption;
    private Integer myCoolDuration;
    private Integer myCoolTemp;
    private TempWaveOption myCoolWaveOption;
    private TempBoostOption myCurrentBoostOption;
    private Integer myCurrentDuration;
    private Integer myCurrentRemainDuration;
    private MyTempStepCode myCurrentTemperatureStep;
    private TempWaveOption myCurrentWaveOption;
    private TempBoostOption myHeatBoostOption;
    private Integer myHeatDuration;
    private Integer myHeatTemp;
    private TempWaveOption myHeatWaveOption;
    private MyModeOperationCode myModeAction;
    private MyModeActionType myModeActionType;
    private Integer myModeSpecialRemainTime;
    private MyModeSpecialSubMode myModeSpecialSubMode;
    private Integer myModeSpecialTotalTime;
    private MyModeTypeCode myModeType;
    private Integer myOffDuration;
    private Integer mySettingNo;
    private Integer myTotalDuration;
    private Integer remainDuration;
    private DeviceModeSettingTriggerCode settingTrigger;
    private SwitchCoolHeatWaitStatus switchCoolHeatWaitStatus;
    private TempStepCode temperature;
    private Temperature temperatureEntity;
    private Integer totalDuration;
    private TempWaveOption waveOption;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DeviceModeEntity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|25) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|25) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0032 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0056 */
        static {
            /*
                jp.co.sony.reonpocket.constant.MyModeActionType[] r0 = jp.co.sony.reonpocket.constant.MyModeActionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                jp.co.sony.reonpocket.constant.MyModeActionType r2 = jp.co.sony.reonpocket.constant.MyModeActionType.CUSTOM     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                jp.co.sony.reonpocket.constant.MyModeActionType r3 = jp.co.sony.reonpocket.constant.MyModeActionType.SPECIAL     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                jp.co.sony.reonpocket.constant.DeviceModeActionCode[] r0 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.DeviceModeActionCode r3 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.MANUAL     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                jp.co.sony.reonpocket.constant.DeviceModeActionCode r1 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.AUTO     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                jp.co.sony.reonpocket.constant.DeviceModeActionCode r1 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.MY     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                jp.co.sony.reonpocket.constant.DeviceModeActionCode r1 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.TEMPERATURE     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                jp.co.sony.reonpocket.constant.DeviceModeActionCode r1 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.FAN     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                jp.co.sony.reonpocket.constant.DeviceModeActionCode r1 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.MY_SETTING     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                jp.co.sony.reonpocket.constant.DeviceModeActionCode r1 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.POWER_OFF     // Catch:{ NoSuchFieldError -> 0x005f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005f }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005f }
            L_0x005f:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.data.entity.DeviceModeEntity.WhenMappings.<clinit>():void");
        }
    }

    public static /* synthetic */ DeviceModeEntity copy$default(DeviceModeEntity deviceModeEntity, DeviceModeActionCode deviceModeActionCode, DeviceModeSettingTriggerCode deviceModeSettingTriggerCode, DeviceCoolingCode deviceCoolingCode, ContinuousOperationStatus continuousOperationStatus2, SwitchCoolHeatWaitStatus switchCoolHeatWaitStatus2, CoolHeatTypeCode coolHeatTypeCode, Temperature temperature2, ModeCommonSettingOperation modeCommonSettingOperation, Integer num, TempStepCode tempStepCode, TempBoostOption tempBoostOption, TempWaveOption tempWaveOption, Integer num2, Integer num3, Integer num4, MyModeActionType myModeActionType2, MyModeSpecialSubMode myModeSpecialSubMode2, Integer num5, Integer num6, MyModeOperationCode myModeOperationCode, Integer num7, MyModeTypeCode myModeTypeCode, Integer num8, TempBoostOption tempBoostOption2, TempWaveOption tempWaveOption2, Integer num9, Integer num10, TempBoostOption tempBoostOption3, TempWaveOption tempWaveOption3, Integer num11, Integer num12, Integer num13, MyTempStepCode myTempStepCode, TempBoostOption tempBoostOption4, TempWaveOption tempWaveOption4, Integer num14, Integer num15, FanStepCode fanStepCode, int i, int i2, Object obj) {
        DeviceModeEntity deviceModeEntity2 = deviceModeEntity;
        int i3 = i;
        return deviceModeEntity.copy((i3 & 1) != 0 ? deviceModeEntity2.mode : deviceModeActionCode, (i3 & 2) != 0 ? deviceModeEntity2.settingTrigger : deviceModeSettingTriggerCode, (i3 & 4) != 0 ? deviceModeEntity2.coolingCode : deviceCoolingCode, (i3 & 8) != 0 ? deviceModeEntity2.continuousOperationStatus : continuousOperationStatus2, (i3 & 16) != 0 ? deviceModeEntity2.switchCoolHeatWaitStatus : switchCoolHeatWaitStatus2, (i3 & 32) != 0 ? deviceModeEntity2.coolHeatType : coolHeatTypeCode, (i3 & 64) != 0 ? deviceModeEntity2.temperatureEntity : temperature2, (i3 & 128) != 0 ? deviceModeEntity2.commonOperation : modeCommonSettingOperation, (i3 & 256) != 0 ? deviceModeEntity2.commonStopDuration : num, (i3 & 512) != 0 ? deviceModeEntity2.temperature : tempStepCode, (i3 & 1024) != 0 ? deviceModeEntity2.boostOption : tempBoostOption, (i3 & 2048) != 0 ? deviceModeEntity2.waveOption : tempWaveOption, (i3 & 4096) != 0 ? deviceModeEntity2.currentModeRemainTime : num2, (i3 & 8192) != 0 ? deviceModeEntity2.totalDuration : num3, (i3 & 16384) != 0 ? deviceModeEntity2.remainDuration : num4, (i3 & 32768) != 0 ? deviceModeEntity2.myModeActionType : myModeActionType2, (i3 & 65536) != 0 ? deviceModeEntity2.myModeSpecialSubMode : myModeSpecialSubMode2, (i3 & 131072) != 0 ? deviceModeEntity2.myModeSpecialTotalTime : num5, (i3 & 262144) != 0 ? deviceModeEntity2.myModeSpecialRemainTime : num6, (i3 & 524288) != 0 ? deviceModeEntity2.myModeAction : myModeOperationCode, (i3 & 1048576) != 0 ? deviceModeEntity2.mySettingNo : num7, (i3 & 2097152) != 0 ? deviceModeEntity2.myModeType : myModeTypeCode, (i3 & 4194304) != 0 ? deviceModeEntity2.myCoolTemp : num8, (i3 & 8388608) != 0 ? deviceModeEntity2.myCoolBoostOption : tempBoostOption2, (i3 & 16777216) != 0 ? deviceModeEntity2.myCoolWaveOption : tempWaveOption2, (i3 & 33554432) != 0 ? deviceModeEntity2.myCoolDuration : num9, (i3 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? deviceModeEntity2.myHeatTemp : num10, (i3 & 134217728) != 0 ? deviceModeEntity2.myHeatBoostOption : tempBoostOption3, (i3 & 268435456) != 0 ? deviceModeEntity2.myHeatWaveOption : tempWaveOption3, (i3 & 536870912) != 0 ? deviceModeEntity2.myHeatDuration : num11, (i3 & 1073741824) != 0 ? deviceModeEntity2.myOffDuration : num12, (i3 & Integer.MIN_VALUE) != 0 ? deviceModeEntity2.myTotalDuration : num13, (i2 & 1) != 0 ? deviceModeEntity2.myCurrentTemperatureStep : myTempStepCode, (i2 & 2) != 0 ? deviceModeEntity2.myCurrentBoostOption : tempBoostOption4, (i2 & 4) != 0 ? deviceModeEntity2.myCurrentWaveOption : tempWaveOption4, (i2 & 8) != 0 ? deviceModeEntity2.myCurrentRemainDuration : num14, (i2 & 16) != 0 ? deviceModeEntity2.myCurrentDuration : num15, (i2 & 32) != 0 ? deviceModeEntity2.fanStep : fanStepCode);
    }

    public final DeviceModeActionCode component1() {
        return this.mode;
    }

    public final TempStepCode component10() {
        return this.temperature;
    }

    public final TempBoostOption component11() {
        return this.boostOption;
    }

    public final TempWaveOption component12() {
        return this.waveOption;
    }

    public final Integer component13() {
        return this.currentModeRemainTime;
    }

    public final Integer component14() {
        return this.totalDuration;
    }

    public final Integer component15() {
        return this.remainDuration;
    }

    public final MyModeActionType component16() {
        return this.myModeActionType;
    }

    public final MyModeSpecialSubMode component17() {
        return this.myModeSpecialSubMode;
    }

    public final Integer component18() {
        return this.myModeSpecialTotalTime;
    }

    public final Integer component19() {
        return this.myModeSpecialRemainTime;
    }

    public final DeviceModeSettingTriggerCode component2() {
        return this.settingTrigger;
    }

    public final MyModeOperationCode component20() {
        return this.myModeAction;
    }

    public final Integer component21() {
        return this.mySettingNo;
    }

    public final MyModeTypeCode component22() {
        return this.myModeType;
    }

    public final Integer component23() {
        return this.myCoolTemp;
    }

    public final TempBoostOption component24() {
        return this.myCoolBoostOption;
    }

    public final TempWaveOption component25() {
        return this.myCoolWaveOption;
    }

    public final Integer component26() {
        return this.myCoolDuration;
    }

    public final Integer component27() {
        return this.myHeatTemp;
    }

    public final TempBoostOption component28() {
        return this.myHeatBoostOption;
    }

    public final TempWaveOption component29() {
        return this.myHeatWaveOption;
    }

    public final DeviceCoolingCode component3() {
        return this.coolingCode;
    }

    public final Integer component30() {
        return this.myHeatDuration;
    }

    public final Integer component31() {
        return this.myOffDuration;
    }

    public final Integer component32() {
        return this.myTotalDuration;
    }

    public final MyTempStepCode component33() {
        return this.myCurrentTemperatureStep;
    }

    public final TempBoostOption component34() {
        return this.myCurrentBoostOption;
    }

    public final TempWaveOption component35() {
        return this.myCurrentWaveOption;
    }

    public final Integer component36() {
        return this.myCurrentRemainDuration;
    }

    public final Integer component37() {
        return this.myCurrentDuration;
    }

    public final FanStepCode component38() {
        return this.fanStep;
    }

    public final ContinuousOperationStatus component4() {
        return this.continuousOperationStatus;
    }

    public final SwitchCoolHeatWaitStatus component5() {
        return this.switchCoolHeatWaitStatus;
    }

    public final CoolHeatTypeCode component6() {
        return this.coolHeatType;
    }

    public final Temperature component7() {
        return this.temperatureEntity;
    }

    public final ModeCommonSettingOperation component8() {
        return this.commonOperation;
    }

    public final Integer component9() {
        return this.commonStopDuration;
    }

    public final DeviceModeEntity copy(DeviceModeActionCode deviceModeActionCode, DeviceModeSettingTriggerCode deviceModeSettingTriggerCode, DeviceCoolingCode deviceCoolingCode, ContinuousOperationStatus continuousOperationStatus2, SwitchCoolHeatWaitStatus switchCoolHeatWaitStatus2, CoolHeatTypeCode coolHeatTypeCode, Temperature temperature2, ModeCommonSettingOperation modeCommonSettingOperation, Integer num, TempStepCode tempStepCode, TempBoostOption tempBoostOption, TempWaveOption tempWaveOption, Integer num2, Integer num3, Integer num4, MyModeActionType myModeActionType2, MyModeSpecialSubMode myModeSpecialSubMode2, Integer num5, Integer num6, MyModeOperationCode myModeOperationCode, Integer num7, MyModeTypeCode myModeTypeCode, Integer num8, TempBoostOption tempBoostOption2, TempWaveOption tempWaveOption2, Integer num9, Integer num10, TempBoostOption tempBoostOption3, TempWaveOption tempWaveOption3, Integer num11, Integer num12, Integer num13, MyTempStepCode myTempStepCode, TempBoostOption tempBoostOption4, TempWaveOption tempWaveOption4, Integer num14, Integer num15, FanStepCode fanStepCode) {
        return new DeviceModeEntity(deviceModeActionCode, deviceModeSettingTriggerCode, deviceCoolingCode, continuousOperationStatus2, switchCoolHeatWaitStatus2, coolHeatTypeCode, temperature2, modeCommonSettingOperation, num, tempStepCode, tempBoostOption, tempWaveOption, num2, num3, num4, myModeActionType2, myModeSpecialSubMode2, num5, num6, myModeOperationCode, num7, myModeTypeCode, num8, tempBoostOption2, tempWaveOption2, num9, num10, tempBoostOption3, tempWaveOption3, num11, num12, num13, myTempStepCode, tempBoostOption4, tempWaveOption4, num14, num15, fanStepCode);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceModeEntity)) {
            return false;
        }
        DeviceModeEntity deviceModeEntity = (DeviceModeEntity) obj;
        return this.mode == deviceModeEntity.mode && this.settingTrigger == deviceModeEntity.settingTrigger && this.coolingCode == deviceModeEntity.coolingCode && this.continuousOperationStatus == deviceModeEntity.continuousOperationStatus && this.switchCoolHeatWaitStatus == deviceModeEntity.switchCoolHeatWaitStatus && this.coolHeatType == deviceModeEntity.coolHeatType && Intrinsics.areEqual((Object) this.temperatureEntity, (Object) deviceModeEntity.temperatureEntity) && this.commonOperation == deviceModeEntity.commonOperation && Intrinsics.areEqual((Object) this.commonStopDuration, (Object) deviceModeEntity.commonStopDuration) && this.temperature == deviceModeEntity.temperature && this.boostOption == deviceModeEntity.boostOption && this.waveOption == deviceModeEntity.waveOption && Intrinsics.areEqual((Object) this.currentModeRemainTime, (Object) deviceModeEntity.currentModeRemainTime) && Intrinsics.areEqual((Object) this.totalDuration, (Object) deviceModeEntity.totalDuration) && Intrinsics.areEqual((Object) this.remainDuration, (Object) deviceModeEntity.remainDuration) && this.myModeActionType == deviceModeEntity.myModeActionType && this.myModeSpecialSubMode == deviceModeEntity.myModeSpecialSubMode && Intrinsics.areEqual((Object) this.myModeSpecialTotalTime, (Object) deviceModeEntity.myModeSpecialTotalTime) && Intrinsics.areEqual((Object) this.myModeSpecialRemainTime, (Object) deviceModeEntity.myModeSpecialRemainTime) && this.myModeAction == deviceModeEntity.myModeAction && Intrinsics.areEqual((Object) this.mySettingNo, (Object) deviceModeEntity.mySettingNo) && this.myModeType == deviceModeEntity.myModeType && Intrinsics.areEqual((Object) this.myCoolTemp, (Object) deviceModeEntity.myCoolTemp) && this.myCoolBoostOption == deviceModeEntity.myCoolBoostOption && this.myCoolWaveOption == deviceModeEntity.myCoolWaveOption && Intrinsics.areEqual((Object) this.myCoolDuration, (Object) deviceModeEntity.myCoolDuration) && Intrinsics.areEqual((Object) this.myHeatTemp, (Object) deviceModeEntity.myHeatTemp) && this.myHeatBoostOption == deviceModeEntity.myHeatBoostOption && this.myHeatWaveOption == deviceModeEntity.myHeatWaveOption && Intrinsics.areEqual((Object) this.myHeatDuration, (Object) deviceModeEntity.myHeatDuration) && Intrinsics.areEqual((Object) this.myOffDuration, (Object) deviceModeEntity.myOffDuration) && Intrinsics.areEqual((Object) this.myTotalDuration, (Object) deviceModeEntity.myTotalDuration) && this.myCurrentTemperatureStep == deviceModeEntity.myCurrentTemperatureStep && this.myCurrentBoostOption == deviceModeEntity.myCurrentBoostOption && this.myCurrentWaveOption == deviceModeEntity.myCurrentWaveOption && Intrinsics.areEqual((Object) this.myCurrentRemainDuration, (Object) deviceModeEntity.myCurrentRemainDuration) && Intrinsics.areEqual((Object) this.myCurrentDuration, (Object) deviceModeEntity.myCurrentDuration) && this.fanStep == deviceModeEntity.fanStep;
    }

    public int hashCode() {
        DeviceModeActionCode deviceModeActionCode = this.mode;
        int i = 0;
        int hashCode = (deviceModeActionCode == null ? 0 : deviceModeActionCode.hashCode()) * 31;
        DeviceModeSettingTriggerCode deviceModeSettingTriggerCode = this.settingTrigger;
        int hashCode2 = (hashCode + (deviceModeSettingTriggerCode == null ? 0 : deviceModeSettingTriggerCode.hashCode())) * 31;
        DeviceCoolingCode deviceCoolingCode = this.coolingCode;
        int hashCode3 = (hashCode2 + (deviceCoolingCode == null ? 0 : deviceCoolingCode.hashCode())) * 31;
        ContinuousOperationStatus continuousOperationStatus2 = this.continuousOperationStatus;
        int hashCode4 = (hashCode3 + (continuousOperationStatus2 == null ? 0 : continuousOperationStatus2.hashCode())) * 31;
        SwitchCoolHeatWaitStatus switchCoolHeatWaitStatus2 = this.switchCoolHeatWaitStatus;
        int hashCode5 = (hashCode4 + (switchCoolHeatWaitStatus2 == null ? 0 : switchCoolHeatWaitStatus2.hashCode())) * 31;
        CoolHeatTypeCode coolHeatTypeCode = this.coolHeatType;
        int hashCode6 = (hashCode5 + (coolHeatTypeCode == null ? 0 : coolHeatTypeCode.hashCode())) * 31;
        Temperature temperature2 = this.temperatureEntity;
        int hashCode7 = (hashCode6 + (temperature2 == null ? 0 : temperature2.hashCode())) * 31;
        ModeCommonSettingOperation modeCommonSettingOperation = this.commonOperation;
        int hashCode8 = (hashCode7 + (modeCommonSettingOperation == null ? 0 : modeCommonSettingOperation.hashCode())) * 31;
        Integer num = this.commonStopDuration;
        int hashCode9 = (hashCode8 + (num == null ? 0 : num.hashCode())) * 31;
        TempStepCode tempStepCode = this.temperature;
        int hashCode10 = (hashCode9 + (tempStepCode == null ? 0 : tempStepCode.hashCode())) * 31;
        TempBoostOption tempBoostOption = this.boostOption;
        int hashCode11 = (hashCode10 + (tempBoostOption == null ? 0 : tempBoostOption.hashCode())) * 31;
        TempWaveOption tempWaveOption = this.waveOption;
        int hashCode12 = (hashCode11 + (tempWaveOption == null ? 0 : tempWaveOption.hashCode())) * 31;
        Integer num2 = this.currentModeRemainTime;
        int hashCode13 = (hashCode12 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.totalDuration;
        int hashCode14 = (hashCode13 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.remainDuration;
        int hashCode15 = (hashCode14 + (num4 == null ? 0 : num4.hashCode())) * 31;
        MyModeActionType myModeActionType2 = this.myModeActionType;
        int hashCode16 = (hashCode15 + (myModeActionType2 == null ? 0 : myModeActionType2.hashCode())) * 31;
        MyModeSpecialSubMode myModeSpecialSubMode2 = this.myModeSpecialSubMode;
        int hashCode17 = (hashCode16 + (myModeSpecialSubMode2 == null ? 0 : myModeSpecialSubMode2.hashCode())) * 31;
        Integer num5 = this.myModeSpecialTotalTime;
        int hashCode18 = (hashCode17 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.myModeSpecialRemainTime;
        int hashCode19 = (hashCode18 + (num6 == null ? 0 : num6.hashCode())) * 31;
        MyModeOperationCode myModeOperationCode = this.myModeAction;
        int hashCode20 = (hashCode19 + (myModeOperationCode == null ? 0 : myModeOperationCode.hashCode())) * 31;
        Integer num7 = this.mySettingNo;
        int hashCode21 = (hashCode20 + (num7 == null ? 0 : num7.hashCode())) * 31;
        MyModeTypeCode myModeTypeCode = this.myModeType;
        int hashCode22 = (hashCode21 + (myModeTypeCode == null ? 0 : myModeTypeCode.hashCode())) * 31;
        Integer num8 = this.myCoolTemp;
        int hashCode23 = (hashCode22 + (num8 == null ? 0 : num8.hashCode())) * 31;
        TempBoostOption tempBoostOption2 = this.myCoolBoostOption;
        int hashCode24 = (hashCode23 + (tempBoostOption2 == null ? 0 : tempBoostOption2.hashCode())) * 31;
        TempWaveOption tempWaveOption2 = this.myCoolWaveOption;
        int hashCode25 = (hashCode24 + (tempWaveOption2 == null ? 0 : tempWaveOption2.hashCode())) * 31;
        Integer num9 = this.myCoolDuration;
        int hashCode26 = (hashCode25 + (num9 == null ? 0 : num9.hashCode())) * 31;
        Integer num10 = this.myHeatTemp;
        int hashCode27 = (hashCode26 + (num10 == null ? 0 : num10.hashCode())) * 31;
        TempBoostOption tempBoostOption3 = this.myHeatBoostOption;
        int hashCode28 = (hashCode27 + (tempBoostOption3 == null ? 0 : tempBoostOption3.hashCode())) * 31;
        TempWaveOption tempWaveOption3 = this.myHeatWaveOption;
        int hashCode29 = (hashCode28 + (tempWaveOption3 == null ? 0 : tempWaveOption3.hashCode())) * 31;
        Integer num11 = this.myHeatDuration;
        int hashCode30 = (hashCode29 + (num11 == null ? 0 : num11.hashCode())) * 31;
        Integer num12 = this.myOffDuration;
        int hashCode31 = (hashCode30 + (num12 == null ? 0 : num12.hashCode())) * 31;
        Integer num13 = this.myTotalDuration;
        int hashCode32 = (hashCode31 + (num13 == null ? 0 : num13.hashCode())) * 31;
        MyTempStepCode myTempStepCode = this.myCurrentTemperatureStep;
        int hashCode33 = (hashCode32 + (myTempStepCode == null ? 0 : myTempStepCode.hashCode())) * 31;
        TempBoostOption tempBoostOption4 = this.myCurrentBoostOption;
        int hashCode34 = (hashCode33 + (tempBoostOption4 == null ? 0 : tempBoostOption4.hashCode())) * 31;
        TempWaveOption tempWaveOption4 = this.myCurrentWaveOption;
        int hashCode35 = (hashCode34 + (tempWaveOption4 == null ? 0 : tempWaveOption4.hashCode())) * 31;
        Integer num14 = this.myCurrentRemainDuration;
        int hashCode36 = (hashCode35 + (num14 == null ? 0 : num14.hashCode())) * 31;
        Integer num15 = this.myCurrentDuration;
        int hashCode37 = (hashCode36 + (num15 == null ? 0 : num15.hashCode())) * 31;
        FanStepCode fanStepCode = this.fanStep;
        if (fanStepCode != null) {
            i = fanStepCode.hashCode();
        }
        return hashCode37 + i;
    }

    public String toString() {
        DeviceModeActionCode deviceModeActionCode = this.mode;
        DeviceModeSettingTriggerCode deviceModeSettingTriggerCode = this.settingTrigger;
        DeviceCoolingCode deviceCoolingCode = this.coolingCode;
        ContinuousOperationStatus continuousOperationStatus2 = this.continuousOperationStatus;
        SwitchCoolHeatWaitStatus switchCoolHeatWaitStatus2 = this.switchCoolHeatWaitStatus;
        CoolHeatTypeCode coolHeatTypeCode = this.coolHeatType;
        Temperature temperature2 = this.temperatureEntity;
        ModeCommonSettingOperation modeCommonSettingOperation = this.commonOperation;
        Integer num = this.commonStopDuration;
        TempStepCode tempStepCode = this.temperature;
        TempBoostOption tempBoostOption = this.boostOption;
        TempWaveOption tempWaveOption = this.waveOption;
        Integer num2 = this.currentModeRemainTime;
        Integer num3 = this.totalDuration;
        Integer num4 = this.remainDuration;
        MyModeActionType myModeActionType2 = this.myModeActionType;
        MyModeSpecialSubMode myModeSpecialSubMode2 = this.myModeSpecialSubMode;
        Integer num5 = this.myModeSpecialTotalTime;
        Integer num6 = this.myModeSpecialRemainTime;
        MyModeOperationCode myModeOperationCode = this.myModeAction;
        Integer num7 = this.mySettingNo;
        MyModeTypeCode myModeTypeCode = this.myModeType;
        Integer num8 = this.myCoolTemp;
        TempBoostOption tempBoostOption2 = this.myCoolBoostOption;
        TempWaveOption tempWaveOption2 = this.myCoolWaveOption;
        Integer num9 = this.myCoolDuration;
        Integer num10 = this.myHeatTemp;
        TempBoostOption tempBoostOption3 = this.myHeatBoostOption;
        TempWaveOption tempWaveOption3 = this.myHeatWaveOption;
        Integer num11 = this.myHeatDuration;
        Integer num12 = this.myOffDuration;
        Integer num13 = this.myTotalDuration;
        MyTempStepCode myTempStepCode = this.myCurrentTemperatureStep;
        TempBoostOption tempBoostOption4 = this.myCurrentBoostOption;
        TempWaveOption tempWaveOption4 = this.myCurrentWaveOption;
        Integer num14 = this.myCurrentRemainDuration;
        Integer num15 = this.myCurrentDuration;
        return "DeviceModeEntity(mode=" + deviceModeActionCode + ", settingTrigger=" + deviceModeSettingTriggerCode + ", coolingCode=" + deviceCoolingCode + ", continuousOperationStatus=" + continuousOperationStatus2 + ", switchCoolHeatWaitStatus=" + switchCoolHeatWaitStatus2 + ", coolHeatType=" + coolHeatTypeCode + ", temperatureEntity=" + temperature2 + ", commonOperation=" + modeCommonSettingOperation + ", commonStopDuration=" + num + ", temperature=" + tempStepCode + ", boostOption=" + tempBoostOption + ", waveOption=" + tempWaveOption + ", currentModeRemainTime=" + num2 + ", totalDuration=" + num3 + ", remainDuration=" + num4 + ", myModeActionType=" + myModeActionType2 + ", myModeSpecialSubMode=" + myModeSpecialSubMode2 + ", myModeSpecialTotalTime=" + num5 + ", myModeSpecialRemainTime=" + num6 + ", myModeAction=" + myModeOperationCode + ", mySettingNo=" + num7 + ", myModeType=" + myModeTypeCode + ", myCoolTemp=" + num8 + ", myCoolBoostOption=" + tempBoostOption2 + ", myCoolWaveOption=" + tempWaveOption2 + ", myCoolDuration=" + num9 + ", myHeatTemp=" + num10 + ", myHeatBoostOption=" + tempBoostOption3 + ", myHeatWaveOption=" + tempWaveOption3 + ", myHeatDuration=" + num11 + ", myOffDuration=" + num12 + ", myTotalDuration=" + num13 + ", myCurrentTemperatureStep=" + myTempStepCode + ", myCurrentBoostOption=" + tempBoostOption4 + ", myCurrentWaveOption=" + tempWaveOption4 + ", myCurrentRemainDuration=" + num14 + ", myCurrentDuration=" + num15 + ", fanStep=" + this.fanStep + ")";
    }

    public DeviceModeEntity(DeviceModeActionCode deviceModeActionCode, DeviceModeSettingTriggerCode deviceModeSettingTriggerCode, DeviceCoolingCode deviceCoolingCode, ContinuousOperationStatus continuousOperationStatus2, SwitchCoolHeatWaitStatus switchCoolHeatWaitStatus2, CoolHeatTypeCode coolHeatTypeCode, Temperature temperature2, ModeCommonSettingOperation modeCommonSettingOperation, Integer num, TempStepCode tempStepCode, TempBoostOption tempBoostOption, TempWaveOption tempWaveOption, Integer num2, Integer num3, Integer num4, MyModeActionType myModeActionType2, MyModeSpecialSubMode myModeSpecialSubMode2, Integer num5, Integer num6, MyModeOperationCode myModeOperationCode, Integer num7, MyModeTypeCode myModeTypeCode, Integer num8, TempBoostOption tempBoostOption2, TempWaveOption tempWaveOption2, Integer num9, Integer num10, TempBoostOption tempBoostOption3, TempWaveOption tempWaveOption3, Integer num11, Integer num12, Integer num13, MyTempStepCode myTempStepCode, TempBoostOption tempBoostOption4, TempWaveOption tempWaveOption4, Integer num14, Integer num15, FanStepCode fanStepCode) {
        this.mode = deviceModeActionCode;
        this.settingTrigger = deviceModeSettingTriggerCode;
        this.coolingCode = deviceCoolingCode;
        this.continuousOperationStatus = continuousOperationStatus2;
        this.switchCoolHeatWaitStatus = switchCoolHeatWaitStatus2;
        this.coolHeatType = coolHeatTypeCode;
        this.temperatureEntity = temperature2;
        this.commonOperation = modeCommonSettingOperation;
        this.commonStopDuration = num;
        this.temperature = tempStepCode;
        this.boostOption = tempBoostOption;
        this.waveOption = tempWaveOption;
        this.currentModeRemainTime = num2;
        this.totalDuration = num3;
        this.remainDuration = num4;
        this.myModeActionType = myModeActionType2;
        this.myModeSpecialSubMode = myModeSpecialSubMode2;
        this.myModeSpecialTotalTime = num5;
        this.myModeSpecialRemainTime = num6;
        this.myModeAction = myModeOperationCode;
        this.mySettingNo = num7;
        this.myModeType = myModeTypeCode;
        this.myCoolTemp = num8;
        this.myCoolBoostOption = tempBoostOption2;
        this.myCoolWaveOption = tempWaveOption2;
        this.myCoolDuration = num9;
        this.myHeatTemp = num10;
        this.myHeatBoostOption = tempBoostOption3;
        this.myHeatWaveOption = tempWaveOption3;
        this.myHeatDuration = num11;
        this.myOffDuration = num12;
        this.myTotalDuration = num13;
        this.myCurrentTemperatureStep = myTempStepCode;
        this.myCurrentBoostOption = tempBoostOption4;
        this.myCurrentWaveOption = tempWaveOption4;
        this.myCurrentRemainDuration = num14;
        this.myCurrentDuration = num15;
        this.fanStep = fanStepCode;
    }

    public final DeviceModeActionCode getMode() {
        return this.mode;
    }

    public final void setMode(DeviceModeActionCode deviceModeActionCode) {
        this.mode = deviceModeActionCode;
    }

    public final DeviceModeSettingTriggerCode getSettingTrigger() {
        return this.settingTrigger;
    }

    public final void setSettingTrigger(DeviceModeSettingTriggerCode deviceModeSettingTriggerCode) {
        this.settingTrigger = deviceModeSettingTriggerCode;
    }

    public final DeviceCoolingCode getCoolingCode() {
        return this.coolingCode;
    }

    public final void setCoolingCode(DeviceCoolingCode deviceCoolingCode) {
        this.coolingCode = deviceCoolingCode;
    }

    public final ContinuousOperationStatus getContinuousOperationStatus() {
        return this.continuousOperationStatus;
    }

    public final void setContinuousOperationStatus(ContinuousOperationStatus continuousOperationStatus2) {
        this.continuousOperationStatus = continuousOperationStatus2;
    }

    public final SwitchCoolHeatWaitStatus getSwitchCoolHeatWaitStatus() {
        return this.switchCoolHeatWaitStatus;
    }

    public final void setSwitchCoolHeatWaitStatus(SwitchCoolHeatWaitStatus switchCoolHeatWaitStatus2) {
        this.switchCoolHeatWaitStatus = switchCoolHeatWaitStatus2;
    }

    public final CoolHeatTypeCode getCoolHeatType() {
        return this.coolHeatType;
    }

    public final void setCoolHeatType(CoolHeatTypeCode coolHeatTypeCode) {
        this.coolHeatType = coolHeatTypeCode;
    }

    public final Temperature getTemperatureEntity() {
        return this.temperatureEntity;
    }

    public final void setTemperatureEntity(Temperature temperature2) {
        this.temperatureEntity = temperature2;
    }

    public final ModeCommonSettingOperation getCommonOperation() {
        return this.commonOperation;
    }

    public final void setCommonOperation(ModeCommonSettingOperation modeCommonSettingOperation) {
        this.commonOperation = modeCommonSettingOperation;
    }

    public final Integer getCommonStopDuration() {
        return this.commonStopDuration;
    }

    public final void setCommonStopDuration(Integer num) {
        this.commonStopDuration = num;
    }

    public final TempStepCode getTemperature() {
        return this.temperature;
    }

    public final void setTemperature(TempStepCode tempStepCode) {
        this.temperature = tempStepCode;
    }

    public final TempBoostOption getBoostOption() {
        return this.boostOption;
    }

    public final void setBoostOption(TempBoostOption tempBoostOption) {
        this.boostOption = tempBoostOption;
    }

    public final TempWaveOption getWaveOption() {
        return this.waveOption;
    }

    public final void setWaveOption(TempWaveOption tempWaveOption) {
        this.waveOption = tempWaveOption;
    }

    public final Integer getCurrentModeRemainTime() {
        return this.currentModeRemainTime;
    }

    public final void setCurrentModeRemainTime(Integer num) {
        this.currentModeRemainTime = num;
    }

    public final Integer getTotalDuration() {
        return this.totalDuration;
    }

    public final void setTotalDuration(Integer num) {
        this.totalDuration = num;
    }

    public final Integer getRemainDuration() {
        return this.remainDuration;
    }

    public final void setRemainDuration(Integer num) {
        this.remainDuration = num;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeviceModeEntity(jp.co.sony.reonpocket.constant.DeviceModeActionCode r39, jp.co.sony.reonpocket.constant.DeviceModeSettingTriggerCode r40, jp.co.sony.reonpocket.constant.DeviceCoolingCode r41, jp.co.sony.reonpocket.constant.ContinuousOperationStatus r42, jp.co.sony.reonpocket.constant.SwitchCoolHeatWaitStatus r43, jp.co.sony.reonpocket.constant.CoolHeatTypeCode r44, jp.co.sony.reonpocket.data.entity.DeviceModeEntity.Temperature r45, jp.co.sony.reonpocket.constant.ModeCommonSettingOperation r46, java.lang.Integer r47, jp.co.sony.reonpocket.constant.TempStepCode r48, jp.co.sony.reonpocket.constant.TempBoostOption r49, jp.co.sony.reonpocket.constant.TempWaveOption r50, java.lang.Integer r51, java.lang.Integer r52, java.lang.Integer r53, jp.co.sony.reonpocket.constant.MyModeActionType r54, jp.co.sony.reonpocket.constant.MyModeSpecialSubMode r55, java.lang.Integer r56, java.lang.Integer r57, jp.co.sony.reonpocket.constant.MyModeOperationCode r58, java.lang.Integer r59, jp.co.sony.reonpocket.constant.MyModeTypeCode r60, java.lang.Integer r61, jp.co.sony.reonpocket.constant.TempBoostOption r62, jp.co.sony.reonpocket.constant.TempWaveOption r63, java.lang.Integer r64, java.lang.Integer r65, jp.co.sony.reonpocket.constant.TempBoostOption r66, jp.co.sony.reonpocket.constant.TempWaveOption r67, java.lang.Integer r68, java.lang.Integer r69, java.lang.Integer r70, jp.co.sony.reonpocket.constant.MyTempStepCode r71, jp.co.sony.reonpocket.constant.TempBoostOption r72, jp.co.sony.reonpocket.constant.TempWaveOption r73, java.lang.Integer r74, java.lang.Integer r75, jp.co.sony.reonpocket.constant.FanStepCode r76, int r77, int r78, kotlin.jvm.internal.DefaultConstructorMarker r79) {
        /*
            r38 = this;
            r0 = r77
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r40
        L_0x000b:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r41
        L_0x0013:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0019
            r4 = r2
            goto L_0x001b
        L_0x0019:
            r4 = r42
        L_0x001b:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x0021
            r5 = r2
            goto L_0x0023
        L_0x0021:
            r5 = r43
        L_0x0023:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0029
            r6 = r2
            goto L_0x002b
        L_0x0029:
            r6 = r44
        L_0x002b:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x0031
            r7 = r2
            goto L_0x0033
        L_0x0031:
            r7 = r45
        L_0x0033:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0039
            r8 = r2
            goto L_0x003b
        L_0x0039:
            r8 = r46
        L_0x003b:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x0041
            r9 = r2
            goto L_0x0043
        L_0x0041:
            r9 = r47
        L_0x0043:
            r10 = r0 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x0049
            r10 = r2
            goto L_0x004b
        L_0x0049:
            r10 = r48
        L_0x004b:
            r11 = r0 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x0051
            r11 = r2
            goto L_0x0053
        L_0x0051:
            r11 = r49
        L_0x0053:
            r12 = r0 & 2048(0x800, float:2.87E-42)
            if (r12 == 0) goto L_0x0059
            r12 = r2
            goto L_0x005b
        L_0x0059:
            r12 = r50
        L_0x005b:
            r13 = r0 & 4096(0x1000, float:5.74E-42)
            if (r13 == 0) goto L_0x0061
            r13 = r2
            goto L_0x0063
        L_0x0061:
            r13 = r51
        L_0x0063:
            r14 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r14 == 0) goto L_0x0069
            r14 = r2
            goto L_0x006b
        L_0x0069:
            r14 = r52
        L_0x006b:
            r15 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r15 == 0) goto L_0x0071
            r15 = r2
            goto L_0x0073
        L_0x0071:
            r15 = r53
        L_0x0073:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x007d
            jp.co.sony.reonpocket.constant.MyModeActionType r16 = jp.co.sony.reonpocket.constant.MyModeActionType.CUSTOM
            goto L_0x007f
        L_0x007d:
            r16 = r54
        L_0x007f:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x0088
            r17 = r2
            goto L_0x008a
        L_0x0088:
            r17 = r55
        L_0x008a:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x0093
            r18 = r2
            goto L_0x0095
        L_0x0093:
            r18 = r56
        L_0x0095:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x009e
            r19 = r2
            goto L_0x00a0
        L_0x009e:
            r19 = r57
        L_0x00a0:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00a9
            r20 = r2
            goto L_0x00ab
        L_0x00a9:
            r20 = r58
        L_0x00ab:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00b4
            r21 = r2
            goto L_0x00b6
        L_0x00b4:
            r21 = r59
        L_0x00b6:
            r22 = 2097152(0x200000, float:2.938736E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00bf
            r22 = r2
            goto L_0x00c1
        L_0x00bf:
            r22 = r60
        L_0x00c1:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00ca
            r23 = r2
            goto L_0x00cc
        L_0x00ca:
            r23 = r61
        L_0x00cc:
            r24 = 8388608(0x800000, float:1.17549435E-38)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00d5
            r24 = r2
            goto L_0x00d7
        L_0x00d5:
            r24 = r62
        L_0x00d7:
            r25 = 16777216(0x1000000, float:2.3509887E-38)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00e0
            r25 = r2
            goto L_0x00e2
        L_0x00e0:
            r25 = r63
        L_0x00e2:
            r26 = 33554432(0x2000000, float:9.403955E-38)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00eb
            r26 = r2
            goto L_0x00ed
        L_0x00eb:
            r26 = r64
        L_0x00ed:
            r27 = 67108864(0x4000000, float:1.5046328E-36)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00f6
            r27 = r2
            goto L_0x00f8
        L_0x00f6:
            r27 = r65
        L_0x00f8:
            r28 = 134217728(0x8000000, float:3.85186E-34)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x0101
            r28 = r2
            goto L_0x0103
        L_0x0101:
            r28 = r66
        L_0x0103:
            r29 = 268435456(0x10000000, float:2.5243549E-29)
            r29 = r0 & r29
            if (r29 == 0) goto L_0x010c
            r29 = r2
            goto L_0x010e
        L_0x010c:
            r29 = r67
        L_0x010e:
            r30 = 536870912(0x20000000, float:1.0842022E-19)
            r30 = r0 & r30
            if (r30 == 0) goto L_0x0117
            r30 = r2
            goto L_0x0119
        L_0x0117:
            r30 = r68
        L_0x0119:
            r31 = 1073741824(0x40000000, float:2.0)
            r31 = r0 & r31
            if (r31 == 0) goto L_0x0122
            r31 = r2
            goto L_0x0124
        L_0x0122:
            r31 = r69
        L_0x0124:
            r32 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r32
            if (r0 == 0) goto L_0x012c
            r0 = r2
            goto L_0x012e
        L_0x012c:
            r0 = r70
        L_0x012e:
            r32 = r78 & 1
            if (r32 == 0) goto L_0x0135
            r32 = r2
            goto L_0x0137
        L_0x0135:
            r32 = r71
        L_0x0137:
            r33 = r78 & 2
            if (r33 == 0) goto L_0x013e
            r33 = r2
            goto L_0x0140
        L_0x013e:
            r33 = r72
        L_0x0140:
            r34 = r78 & 4
            if (r34 == 0) goto L_0x0147
            r34 = r2
            goto L_0x0149
        L_0x0147:
            r34 = r73
        L_0x0149:
            r35 = r78 & 8
            if (r35 == 0) goto L_0x0150
            r35 = r2
            goto L_0x0152
        L_0x0150:
            r35 = r74
        L_0x0152:
            r36 = r78 & 16
            if (r36 == 0) goto L_0x0159
            r36 = r2
            goto L_0x015b
        L_0x0159:
            r36 = r75
        L_0x015b:
            r37 = r78 & 32
            if (r37 == 0) goto L_0x0160
            goto L_0x0162
        L_0x0160:
            r2 = r76
        L_0x0162:
            r40 = r38
            r41 = r39
            r42 = r1
            r43 = r3
            r44 = r4
            r45 = r5
            r46 = r6
            r47 = r7
            r48 = r8
            r49 = r9
            r50 = r10
            r51 = r11
            r52 = r12
            r53 = r13
            r54 = r14
            r55 = r15
            r56 = r16
            r57 = r17
            r58 = r18
            r59 = r19
            r60 = r20
            r61 = r21
            r62 = r22
            r63 = r23
            r64 = r24
            r65 = r25
            r66 = r26
            r67 = r27
            r68 = r28
            r69 = r29
            r70 = r30
            r71 = r31
            r72 = r0
            r73 = r32
            r74 = r33
            r75 = r34
            r76 = r35
            r77 = r36
            r78 = r2
            r40.<init>(r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.data.entity.DeviceModeEntity.<init>(jp.co.sony.reonpocket.constant.DeviceModeActionCode, jp.co.sony.reonpocket.constant.DeviceModeSettingTriggerCode, jp.co.sony.reonpocket.constant.DeviceCoolingCode, jp.co.sony.reonpocket.constant.ContinuousOperationStatus, jp.co.sony.reonpocket.constant.SwitchCoolHeatWaitStatus, jp.co.sony.reonpocket.constant.CoolHeatTypeCode, jp.co.sony.reonpocket.data.entity.DeviceModeEntity$Temperature, jp.co.sony.reonpocket.constant.ModeCommonSettingOperation, java.lang.Integer, jp.co.sony.reonpocket.constant.TempStepCode, jp.co.sony.reonpocket.constant.TempBoostOption, jp.co.sony.reonpocket.constant.TempWaveOption, java.lang.Integer, java.lang.Integer, java.lang.Integer, jp.co.sony.reonpocket.constant.MyModeActionType, jp.co.sony.reonpocket.constant.MyModeSpecialSubMode, java.lang.Integer, java.lang.Integer, jp.co.sony.reonpocket.constant.MyModeOperationCode, java.lang.Integer, jp.co.sony.reonpocket.constant.MyModeTypeCode, java.lang.Integer, jp.co.sony.reonpocket.constant.TempBoostOption, jp.co.sony.reonpocket.constant.TempWaveOption, java.lang.Integer, java.lang.Integer, jp.co.sony.reonpocket.constant.TempBoostOption, jp.co.sony.reonpocket.constant.TempWaveOption, java.lang.Integer, java.lang.Integer, java.lang.Integer, jp.co.sony.reonpocket.constant.MyTempStepCode, jp.co.sony.reonpocket.constant.TempBoostOption, jp.co.sony.reonpocket.constant.TempWaveOption, java.lang.Integer, java.lang.Integer, jp.co.sony.reonpocket.constant.FanStepCode, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final MyModeActionType getMyModeActionType() {
        return this.myModeActionType;
    }

    public final void setMyModeActionType(MyModeActionType myModeActionType2) {
        this.myModeActionType = myModeActionType2;
    }

    public final MyModeSpecialSubMode getMyModeSpecialSubMode() {
        return this.myModeSpecialSubMode;
    }

    public final void setMyModeSpecialSubMode(MyModeSpecialSubMode myModeSpecialSubMode2) {
        this.myModeSpecialSubMode = myModeSpecialSubMode2;
    }

    public final Integer getMyModeSpecialTotalTime() {
        return this.myModeSpecialTotalTime;
    }

    public final void setMyModeSpecialTotalTime(Integer num) {
        this.myModeSpecialTotalTime = num;
    }

    public final Integer getMyModeSpecialRemainTime() {
        return this.myModeSpecialRemainTime;
    }

    public final void setMyModeSpecialRemainTime(Integer num) {
        this.myModeSpecialRemainTime = num;
    }

    public final MyModeOperationCode getMyModeAction() {
        return this.myModeAction;
    }

    public final void setMyModeAction(MyModeOperationCode myModeOperationCode) {
        this.myModeAction = myModeOperationCode;
    }

    public final Integer getMySettingNo() {
        return this.mySettingNo;
    }

    public final void setMySettingNo(Integer num) {
        this.mySettingNo = num;
    }

    public final MyModeTypeCode getMyModeType() {
        return this.myModeType;
    }

    public final void setMyModeType(MyModeTypeCode myModeTypeCode) {
        this.myModeType = myModeTypeCode;
    }

    public final Integer getMyCoolTemp() {
        return this.myCoolTemp;
    }

    public final void setMyCoolTemp(Integer num) {
        this.myCoolTemp = num;
    }

    public final TempBoostOption getMyCoolBoostOption() {
        return this.myCoolBoostOption;
    }

    public final void setMyCoolBoostOption(TempBoostOption tempBoostOption) {
        this.myCoolBoostOption = tempBoostOption;
    }

    public final TempWaveOption getMyCoolWaveOption() {
        return this.myCoolWaveOption;
    }

    public final void setMyCoolWaveOption(TempWaveOption tempWaveOption) {
        this.myCoolWaveOption = tempWaveOption;
    }

    public final Integer getMyCoolDuration() {
        return this.myCoolDuration;
    }

    public final void setMyCoolDuration(Integer num) {
        this.myCoolDuration = num;
    }

    public final Integer getMyHeatTemp() {
        return this.myHeatTemp;
    }

    public final void setMyHeatTemp(Integer num) {
        this.myHeatTemp = num;
    }

    public final TempBoostOption getMyHeatBoostOption() {
        return this.myHeatBoostOption;
    }

    public final void setMyHeatBoostOption(TempBoostOption tempBoostOption) {
        this.myHeatBoostOption = tempBoostOption;
    }

    public final TempWaveOption getMyHeatWaveOption() {
        return this.myHeatWaveOption;
    }

    public final void setMyHeatWaveOption(TempWaveOption tempWaveOption) {
        this.myHeatWaveOption = tempWaveOption;
    }

    public final Integer getMyHeatDuration() {
        return this.myHeatDuration;
    }

    public final void setMyHeatDuration(Integer num) {
        this.myHeatDuration = num;
    }

    public final Integer getMyOffDuration() {
        return this.myOffDuration;
    }

    public final void setMyOffDuration(Integer num) {
        this.myOffDuration = num;
    }

    public final Integer getMyTotalDuration() {
        return this.myTotalDuration;
    }

    public final void setMyTotalDuration(Integer num) {
        this.myTotalDuration = num;
    }

    public final MyTempStepCode getMyCurrentTemperatureStep() {
        return this.myCurrentTemperatureStep;
    }

    public final void setMyCurrentTemperatureStep(MyTempStepCode myTempStepCode) {
        this.myCurrentTemperatureStep = myTempStepCode;
    }

    public final TempBoostOption getMyCurrentBoostOption() {
        return this.myCurrentBoostOption;
    }

    public final void setMyCurrentBoostOption(TempBoostOption tempBoostOption) {
        this.myCurrentBoostOption = tempBoostOption;
    }

    public final TempWaveOption getMyCurrentWaveOption() {
        return this.myCurrentWaveOption;
    }

    public final void setMyCurrentWaveOption(TempWaveOption tempWaveOption) {
        this.myCurrentWaveOption = tempWaveOption;
    }

    public final Integer getMyCurrentRemainDuration() {
        return this.myCurrentRemainDuration;
    }

    public final void setMyCurrentRemainDuration(Integer num) {
        this.myCurrentRemainDuration = num;
    }

    public final Integer getMyCurrentDuration() {
        return this.myCurrentDuration;
    }

    public final void setMyCurrentDuration(Integer num) {
        this.myCurrentDuration = num;
    }

    public final FanStepCode getFanStep() {
        return this.fanStep;
    }

    public final void setFanStep(FanStepCode fanStepCode) {
        this.fanStep = fanStepCode;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\bH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity$SmartCoolModeCombine;", "", "pref", "Ljp/co/sony/reonpocket/constant/SmartModePreference;", "(Ljava/lang/String;ILjp/co/sony/reonpocket/constant/SmartModePreference;)V", "getPref", "()Ljp/co/sony/reonpocket/constant/SmartModePreference;", "temperature", "", "getTemperature", "()I", "targetTemp", "LEVEL1", "LEVEL2", "LEVEL3", "LEVEL4", "LEVEL5", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DeviceModeEntity.kt */
    public enum SmartCoolModeCombine {
        LEVEL1(SmartModePreference.WEAK),
        LEVEL2(SmartModePreference.LOWER_WEAK),
        LEVEL3(SmartModePreference.NORMAL),
        LEVEL4(SmartModePreference.LOWER_STRONG),
        LEVEL5(SmartModePreference.STRONG);
        
        public static final Companion Companion = null;
        private final SmartModePreference pref;

        public static EnumEntries<SmartCoolModeCombine> getEntries() {
            return $ENTRIES;
        }

        private SmartCoolModeCombine(SmartModePreference smartModePreference) {
            this.pref = smartModePreference;
        }

        public final SmartModePreference getPref() {
            return this.pref;
        }

        static {
            SmartCoolModeCombine[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity$SmartCoolModeCombine$Companion;", "", "()V", "forPref", "Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity$SmartCoolModeCombine;", "pref", "Ljp/co/sony/reonpocket/constant/SmartModePreference;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* compiled from: DeviceModeEntity.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final SmartCoolModeCombine forPref(SmartModePreference smartModePreference) {
                Intrinsics.checkNotNullParameter(smartModePreference, "pref");
                for (SmartCoolModeCombine smartCoolModeCombine : SmartCoolModeCombine.values()) {
                    if (smartModePreference == smartCoolModeCombine.getPref()) {
                        return smartCoolModeCombine;
                    }
                }
                return null;
            }
        }

        private final int targetTemp() {
            boolean z;
            String peripheralName = new DeviceInfoInteractor().getPeripheralName(ReonPocketApplication.Companion.getApplicationContext());
            if (Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_3.getModel())) {
                z = true;
            } else {
                z = Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_4.getModel());
            }
            if (z) {
                Integer num = DeviceModeEntity.Companion.getSmartCoolDefaultPrefMap().get(this.pref);
                if (num != null) {
                    return num.intValue();
                }
                return 0;
            } else if (Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_5.getModel())) {
                Integer num2 = DeviceModeEntity.Companion.getSmartCoolRNP5PrefMap().get(this.pref);
                if (num2 != null) {
                    return num2.intValue();
                }
                return 0;
            } else if (Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_P1.getModel())) {
                Integer num3 = DeviceModeEntity.Companion.getSmartCoolRNPP1PrefMap().get(this.pref);
                if (num3 != null) {
                    return num3.intValue();
                }
                return 0;
            } else {
                Integer num4 = DeviceModeEntity.Companion.getSmartCoolRNP5PrefMap().get(this.pref);
                if (num4 != null) {
                    return num4.intValue();
                }
                return 0;
            }
        }

        public final int getTemperature() {
            return targetTemp();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\b\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\bH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity$SmartWarmModeCombine;", "", "pref", "Ljp/co/sony/reonpocket/constant/SmartModePreference;", "(Ljava/lang/String;ILjp/co/sony/reonpocket/constant/SmartModePreference;)V", "getPref", "()Ljp/co/sony/reonpocket/constant/SmartModePreference;", "temperature", "", "getTemperature", "()I", "setTemperature", "(I)V", "remoteTemp", "LEVEL1", "LEVEL2", "LEVEL3", "LEVEL4", "LEVEL5", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DeviceModeEntity.kt */
    public enum SmartWarmModeCombine {
        LEVEL1(SmartModePreference.WEAK),
        LEVEL2(SmartModePreference.LOWER_WEAK),
        LEVEL3(SmartModePreference.NORMAL),
        LEVEL4(SmartModePreference.LOWER_STRONG),
        LEVEL5(SmartModePreference.STRONG);
        
        public static final Companion Companion = null;
        private final SmartModePreference pref;
        private int temperature;

        public static EnumEntries<SmartWarmModeCombine> getEntries() {
            return $ENTRIES;
        }

        private SmartWarmModeCombine(SmartModePreference smartModePreference) {
            this.pref = smartModePreference;
            this.temperature = remoteTemp();
        }

        public final SmartModePreference getPref() {
            return this.pref;
        }

        static {
            SmartWarmModeCombine[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity$SmartWarmModeCombine$Companion;", "", "()V", "forPref", "Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity$SmartWarmModeCombine;", "pref", "Ljp/co/sony/reonpocket/constant/SmartModePreference;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* compiled from: DeviceModeEntity.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final SmartWarmModeCombine forPref(SmartModePreference smartModePreference) {
                Intrinsics.checkNotNullParameter(smartModePreference, "pref");
                for (SmartWarmModeCombine smartWarmModeCombine : SmartWarmModeCombine.values()) {
                    if (smartModePreference == smartWarmModeCombine.getPref()) {
                        return smartWarmModeCombine;
                    }
                }
                return null;
            }
        }

        private final int remoteTemp() {
            ArrayList<Integer> mSmartWarmTemperaturePreferenceEntities = RemoteConfigUtil.INSTANCE.getMSmartWarmTemperaturePreferenceEntities();
            Collection collection = mSmartWarmTemperaturePreferenceEntities;
            if (collection == null || collection.isEmpty()) {
                Integer num = DeviceModeEntity.Companion.getSmartWarmDefaultPrefList().get(this.pref.getCode() - 1);
                Intrinsics.checkNotNull(num);
                return num.intValue();
            }
            Integer num2 = mSmartWarmTemperaturePreferenceEntities.get(this.pref.getCode() - 1);
            Intrinsics.checkNotNull(num2);
            return num2.intValue();
        }

        public final int getTemperature() {
            return this.temperature;
        }

        public final void setTemperature(int i) {
            this.temperature = i;
        }
    }

    @Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bP\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BG\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000eB\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012\u0006\u0010)\u001a\u00020\u0007\u0012\u0006\u0010*\u001a\u00020\u0007\u0012\u0006\u0010+\u001a\u00020\n\u0012\u0006\u0010,\u001a\u00020\n\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u00103J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010 HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\"HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010$HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010&HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010(HÆ\u0003J\t\u0010d\u001a\u00020\u0007HÆ\u0003J\t\u0010e\u001a\u00020\u0007HÆ\u0003J\t\u0010f\u001a\u00020\nHÆ\u0003J\t\u0010g\u001a\u00020\nHÆ\u0003J\u0010\u0010h\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00109J\t\u0010i\u001a\u00020\u0005HÆ\u0003J\u0010\u0010j\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00109J\u0010\u0010k\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00109J\u0010\u0010l\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00109J\u0010\u0010m\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00109J\u0010\u0010n\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00109J\t\u0010o\u001a\u00020\u0012HÆ\u0003J\t\u0010p\u001a\u00020\u0014HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u0002\u0010v\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001a\u00020\u00072\b\b\u0002\u0010*\u001a\u00020\u00072\b\b\u0002\u0010+\u001a\u00020\n2\b\b\u0002\u0010,\u001a\u00020\n2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\n2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\n2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\n2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010wJ\u0013\u0010x\u001a\u00020y2\b\u0010z\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010{\u001a\u00020\nHÖ\u0001J\t\u0010|\u001a\u00020}HÖ\u0001R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0015\u00101\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010:\u001a\u0004\b8\u00109R\u0015\u00102\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010:\u001a\u0004\b;\u00109R\u0011\u0010)\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0011\u0010*\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b>\u0010=R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0015\u0010-\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010:\u001a\u0004\bE\u00109R\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0013\u0010%\u001a\u0004\u0018\u00010&¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0013\u0010'\u001a\u0004\u0018\u00010(¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0013\u0010#\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0013\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0015\u0010.\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010:\u001a\u0004\bT\u00109R\u0011\u0010+\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0011\u0010,\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bY\u0010VR\u0015\u00100\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010:\u001a\u0004\bZ\u00109R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\R\u0015\u0010/\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010:\u001a\u0004\b]\u00109¨\u0006~"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity$Temperature;", "", "aTempOffOnCode", "Ljp/co/sony/reonpocket/constant/TemperatureOnOffCode;", "aTempCoolHeatType", "Ljp/co/sony/reonpocket/constant/TemperatureCoolHeatTypeCode;", "aCoolPreference", "Ljp/co/sony/reonpocket/constant/SmartModePreference;", "aHeatPreference", "aTempCoolWrite", "", "aTempHeatWrite", "aTempCoolSwitchThreshold", "aTempWarmSwitchThreshold", "(Ljp/co/sony/reonpocket/constant/TemperatureOnOffCode;Ljp/co/sony/reonpocket/constant/TemperatureCoolHeatTypeCode;Ljp/co/sony/reonpocket/constant/SmartModePreference;Ljp/co/sony/reonpocket/constant/SmartModePreference;IIII)V", "tempOffOnCode", "tempCoolHeatType", "coolBoost", "Ljp/co/sony/reonpocket/constant/CoolBoost;", "tempCurrentCoolHeatType", "Ljp/co/sony/reonpocket/constant/CurrentCoolHeatTypeCode;", "tagFuncLimit", "Ljp/co/sony/reonpocket/constant/TagFuncLimit;", "switchingTrigger1", "Ljp/co/sony/reonpocket/constant/SwitchingTrigger1;", "switchingTrigger2", "Ljp/co/sony/reonpocket/constant/SwitchingTrigger2;", "boostStatus", "Ljp/co/sony/reonpocket/constant/BoostStatus;", "targetTempControlStatus", "Ljp/co/sony/reonpocket/constant/TargetTempControlStatus;", "targetTempControlFactorALS", "Ljp/co/sony/reonpocket/constant/TargetTempControlFactorALS;", "targetTempControlFactorEnvironment", "Ljp/co/sony/reonpocket/constant/TargetTempControlFactorEnvironment;", "targetTempControlFactorClothesTemp", "Ljp/co/sony/reonpocket/constant/TargetTempControlFactorClothesTemp;", "targetTempControlFactorAction", "Ljp/co/sony/reonpocket/constant/TargetTempControlFactorAction;", "targetTempControlFactorBoost", "Ljp/co/sony/reonpocket/constant/TargetTempControlFactorBoost;", "coolPreference", "heatPreference", "tempCoolWrite", "tempHeatWrite", "targetTemp", "tempCoolSwitchThreshold", "tempWarmSwitchThreshold", "tempModeRemainTime", "coolBoostDurationValue", "coolBoostTempOffset", "(Ljp/co/sony/reonpocket/constant/TemperatureOnOffCode;Ljp/co/sony/reonpocket/constant/TemperatureCoolHeatTypeCode;Ljp/co/sony/reonpocket/constant/CoolBoost;Ljp/co/sony/reonpocket/constant/CurrentCoolHeatTypeCode;Ljp/co/sony/reonpocket/constant/TagFuncLimit;Ljp/co/sony/reonpocket/constant/SwitchingTrigger1;Ljp/co/sony/reonpocket/constant/SwitchingTrigger2;Ljp/co/sony/reonpocket/constant/BoostStatus;Ljp/co/sony/reonpocket/constant/TargetTempControlStatus;Ljp/co/sony/reonpocket/constant/TargetTempControlFactorALS;Ljp/co/sony/reonpocket/constant/TargetTempControlFactorEnvironment;Ljp/co/sony/reonpocket/constant/TargetTempControlFactorClothesTemp;Ljp/co/sony/reonpocket/constant/TargetTempControlFactorAction;Ljp/co/sony/reonpocket/constant/TargetTempControlFactorBoost;Ljp/co/sony/reonpocket/constant/SmartModePreference;Ljp/co/sony/reonpocket/constant/SmartModePreference;IILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBoostStatus", "()Ljp/co/sony/reonpocket/constant/BoostStatus;", "getCoolBoost", "()Ljp/co/sony/reonpocket/constant/CoolBoost;", "getCoolBoostDurationValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCoolBoostTempOffset", "getCoolPreference", "()Ljp/co/sony/reonpocket/constant/SmartModePreference;", "getHeatPreference", "getSwitchingTrigger1", "()Ljp/co/sony/reonpocket/constant/SwitchingTrigger1;", "getSwitchingTrigger2", "()Ljp/co/sony/reonpocket/constant/SwitchingTrigger2;", "getTagFuncLimit", "()Ljp/co/sony/reonpocket/constant/TagFuncLimit;", "getTargetTemp", "getTargetTempControlFactorALS", "()Ljp/co/sony/reonpocket/constant/TargetTempControlFactorALS;", "getTargetTempControlFactorAction", "()Ljp/co/sony/reonpocket/constant/TargetTempControlFactorAction;", "getTargetTempControlFactorBoost", "()Ljp/co/sony/reonpocket/constant/TargetTempControlFactorBoost;", "getTargetTempControlFactorClothesTemp", "()Ljp/co/sony/reonpocket/constant/TargetTempControlFactorClothesTemp;", "getTargetTempControlFactorEnvironment", "()Ljp/co/sony/reonpocket/constant/TargetTempControlFactorEnvironment;", "getTargetTempControlStatus", "()Ljp/co/sony/reonpocket/constant/TargetTempControlStatus;", "getTempCoolHeatType", "()Ljp/co/sony/reonpocket/constant/TemperatureCoolHeatTypeCode;", "getTempCoolSwitchThreshold", "getTempCoolWrite", "()I", "getTempCurrentCoolHeatType", "()Ljp/co/sony/reonpocket/constant/CurrentCoolHeatTypeCode;", "getTempHeatWrite", "getTempModeRemainTime", "getTempOffOnCode", "()Ljp/co/sony/reonpocket/constant/TemperatureOnOffCode;", "getTempWarmSwitchThreshold", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljp/co/sony/reonpocket/constant/TemperatureOnOffCode;Ljp/co/sony/reonpocket/constant/TemperatureCoolHeatTypeCode;Ljp/co/sony/reonpocket/constant/CoolBoost;Ljp/co/sony/reonpocket/constant/CurrentCoolHeatTypeCode;Ljp/co/sony/reonpocket/constant/TagFuncLimit;Ljp/co/sony/reonpocket/constant/SwitchingTrigger1;Ljp/co/sony/reonpocket/constant/SwitchingTrigger2;Ljp/co/sony/reonpocket/constant/BoostStatus;Ljp/co/sony/reonpocket/constant/TargetTempControlStatus;Ljp/co/sony/reonpocket/constant/TargetTempControlFactorALS;Ljp/co/sony/reonpocket/constant/TargetTempControlFactorEnvironment;Ljp/co/sony/reonpocket/constant/TargetTempControlFactorClothesTemp;Ljp/co/sony/reonpocket/constant/TargetTempControlFactorAction;Ljp/co/sony/reonpocket/constant/TargetTempControlFactorBoost;Ljp/co/sony/reonpocket/constant/SmartModePreference;Ljp/co/sony/reonpocket/constant/SmartModePreference;IILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity$Temperature;", "equals", "", "other", "hashCode", "toString", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DeviceModeEntity.kt */
    public static final class Temperature {
        public static final int $stable = 0;
        private final BoostStatus boostStatus;
        private final CoolBoost coolBoost;
        private final Integer coolBoostDurationValue;
        private final Integer coolBoostTempOffset;
        private final SmartModePreference coolPreference;
        private final SmartModePreference heatPreference;
        private final SwitchingTrigger1 switchingTrigger1;
        private final SwitchingTrigger2 switchingTrigger2;
        private final TagFuncLimit tagFuncLimit;
        private final Integer targetTemp;
        private final TargetTempControlFactorALS targetTempControlFactorALS;
        private final TargetTempControlFactorAction targetTempControlFactorAction;
        private final TargetTempControlFactorBoost targetTempControlFactorBoost;
        private final TargetTempControlFactorClothesTemp targetTempControlFactorClothesTemp;
        private final TargetTempControlFactorEnvironment targetTempControlFactorEnvironment;
        private final TargetTempControlStatus targetTempControlStatus;
        private final TemperatureCoolHeatTypeCode tempCoolHeatType;
        private final Integer tempCoolSwitchThreshold;
        private final int tempCoolWrite;
        private final CurrentCoolHeatTypeCode tempCurrentCoolHeatType;
        private final int tempHeatWrite;
        private final Integer tempModeRemainTime;
        private final TemperatureOnOffCode tempOffOnCode;
        private final Integer tempWarmSwitchThreshold;

        public static /* synthetic */ Temperature copy$default(Temperature temperature, TemperatureOnOffCode temperatureOnOffCode, TemperatureCoolHeatTypeCode temperatureCoolHeatTypeCode, CoolBoost coolBoost2, CurrentCoolHeatTypeCode currentCoolHeatTypeCode, TagFuncLimit tagFuncLimit2, SwitchingTrigger1 switchingTrigger12, SwitchingTrigger2 switchingTrigger22, BoostStatus boostStatus2, TargetTempControlStatus targetTempControlStatus2, TargetTempControlFactorALS targetTempControlFactorALS2, TargetTempControlFactorEnvironment targetTempControlFactorEnvironment2, TargetTempControlFactorClothesTemp targetTempControlFactorClothesTemp2, TargetTempControlFactorAction targetTempControlFactorAction2, TargetTempControlFactorBoost targetTempControlFactorBoost2, SmartModePreference smartModePreference, SmartModePreference smartModePreference2, int i, int i2, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, int i3, Object obj) {
            Temperature temperature2 = temperature;
            int i4 = i3;
            return temperature.copy((i4 & 1) != 0 ? temperature2.tempOffOnCode : temperatureOnOffCode, (i4 & 2) != 0 ? temperature2.tempCoolHeatType : temperatureCoolHeatTypeCode, (i4 & 4) != 0 ? temperature2.coolBoost : coolBoost2, (i4 & 8) != 0 ? temperature2.tempCurrentCoolHeatType : currentCoolHeatTypeCode, (i4 & 16) != 0 ? temperature2.tagFuncLimit : tagFuncLimit2, (i4 & 32) != 0 ? temperature2.switchingTrigger1 : switchingTrigger12, (i4 & 64) != 0 ? temperature2.switchingTrigger2 : switchingTrigger22, (i4 & 128) != 0 ? temperature2.boostStatus : boostStatus2, (i4 & 256) != 0 ? temperature2.targetTempControlStatus : targetTempControlStatus2, (i4 & 512) != 0 ? temperature2.targetTempControlFactorALS : targetTempControlFactorALS2, (i4 & 1024) != 0 ? temperature2.targetTempControlFactorEnvironment : targetTempControlFactorEnvironment2, (i4 & 2048) != 0 ? temperature2.targetTempControlFactorClothesTemp : targetTempControlFactorClothesTemp2, (i4 & 4096) != 0 ? temperature2.targetTempControlFactorAction : targetTempControlFactorAction2, (i4 & 8192) != 0 ? temperature2.targetTempControlFactorBoost : targetTempControlFactorBoost2, (i4 & 16384) != 0 ? temperature2.coolPreference : smartModePreference, (i4 & 32768) != 0 ? temperature2.heatPreference : smartModePreference2, (i4 & 65536) != 0 ? temperature2.tempCoolWrite : i, (i4 & 131072) != 0 ? temperature2.tempHeatWrite : i2, (i4 & 262144) != 0 ? temperature2.targetTemp : num, (i4 & 524288) != 0 ? temperature2.tempCoolSwitchThreshold : num2, (i4 & 1048576) != 0 ? temperature2.tempWarmSwitchThreshold : num3, (i4 & 2097152) != 0 ? temperature2.tempModeRemainTime : num4, (i4 & 4194304) != 0 ? temperature2.coolBoostDurationValue : num5, (i4 & 8388608) != 0 ? temperature2.coolBoostTempOffset : num6);
        }

        public final TemperatureOnOffCode component1() {
            return this.tempOffOnCode;
        }

        public final TargetTempControlFactorALS component10() {
            return this.targetTempControlFactorALS;
        }

        public final TargetTempControlFactorEnvironment component11() {
            return this.targetTempControlFactorEnvironment;
        }

        public final TargetTempControlFactorClothesTemp component12() {
            return this.targetTempControlFactorClothesTemp;
        }

        public final TargetTempControlFactorAction component13() {
            return this.targetTempControlFactorAction;
        }

        public final TargetTempControlFactorBoost component14() {
            return this.targetTempControlFactorBoost;
        }

        public final SmartModePreference component15() {
            return this.coolPreference;
        }

        public final SmartModePreference component16() {
            return this.heatPreference;
        }

        public final int component17() {
            return this.tempCoolWrite;
        }

        public final int component18() {
            return this.tempHeatWrite;
        }

        public final Integer component19() {
            return this.targetTemp;
        }

        public final TemperatureCoolHeatTypeCode component2() {
            return this.tempCoolHeatType;
        }

        public final Integer component20() {
            return this.tempCoolSwitchThreshold;
        }

        public final Integer component21() {
            return this.tempWarmSwitchThreshold;
        }

        public final Integer component22() {
            return this.tempModeRemainTime;
        }

        public final Integer component23() {
            return this.coolBoostDurationValue;
        }

        public final Integer component24() {
            return this.coolBoostTempOffset;
        }

        public final CoolBoost component3() {
            return this.coolBoost;
        }

        public final CurrentCoolHeatTypeCode component4() {
            return this.tempCurrentCoolHeatType;
        }

        public final TagFuncLimit component5() {
            return this.tagFuncLimit;
        }

        public final SwitchingTrigger1 component6() {
            return this.switchingTrigger1;
        }

        public final SwitchingTrigger2 component7() {
            return this.switchingTrigger2;
        }

        public final BoostStatus component8() {
            return this.boostStatus;
        }

        public final TargetTempControlStatus component9() {
            return this.targetTempControlStatus;
        }

        public final Temperature copy(TemperatureOnOffCode temperatureOnOffCode, TemperatureCoolHeatTypeCode temperatureCoolHeatTypeCode, CoolBoost coolBoost2, CurrentCoolHeatTypeCode currentCoolHeatTypeCode, TagFuncLimit tagFuncLimit2, SwitchingTrigger1 switchingTrigger12, SwitchingTrigger2 switchingTrigger22, BoostStatus boostStatus2, TargetTempControlStatus targetTempControlStatus2, TargetTempControlFactorALS targetTempControlFactorALS2, TargetTempControlFactorEnvironment targetTempControlFactorEnvironment2, TargetTempControlFactorClothesTemp targetTempControlFactorClothesTemp2, TargetTempControlFactorAction targetTempControlFactorAction2, TargetTempControlFactorBoost targetTempControlFactorBoost2, SmartModePreference smartModePreference, SmartModePreference smartModePreference2, int i, int i2, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6) {
            TemperatureOnOffCode temperatureOnOffCode2 = temperatureOnOffCode;
            Intrinsics.checkNotNullParameter(temperatureOnOffCode2, "tempOffOnCode");
            Intrinsics.checkNotNullParameter(temperatureCoolHeatTypeCode, "tempCoolHeatType");
            Intrinsics.checkNotNullParameter(coolBoost2, "coolBoost");
            Intrinsics.checkNotNullParameter(currentCoolHeatTypeCode, "tempCurrentCoolHeatType");
            Intrinsics.checkNotNullParameter(smartModePreference, "coolPreference");
            Intrinsics.checkNotNullParameter(smartModePreference2, "heatPreference");
            return new Temperature(temperatureOnOffCode2, temperatureCoolHeatTypeCode, coolBoost2, currentCoolHeatTypeCode, tagFuncLimit2, switchingTrigger12, switchingTrigger22, boostStatus2, targetTempControlStatus2, targetTempControlFactorALS2, targetTempControlFactorEnvironment2, targetTempControlFactorClothesTemp2, targetTempControlFactorAction2, targetTempControlFactorBoost2, smartModePreference, smartModePreference2, i, i2, num, num2, num3, num4, num5, num6);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Temperature)) {
                return false;
            }
            Temperature temperature = (Temperature) obj;
            return this.tempOffOnCode == temperature.tempOffOnCode && this.tempCoolHeatType == temperature.tempCoolHeatType && this.coolBoost == temperature.coolBoost && this.tempCurrentCoolHeatType == temperature.tempCurrentCoolHeatType && this.tagFuncLimit == temperature.tagFuncLimit && this.switchingTrigger1 == temperature.switchingTrigger1 && this.switchingTrigger2 == temperature.switchingTrigger2 && this.boostStatus == temperature.boostStatus && this.targetTempControlStatus == temperature.targetTempControlStatus && this.targetTempControlFactorALS == temperature.targetTempControlFactorALS && this.targetTempControlFactorEnvironment == temperature.targetTempControlFactorEnvironment && this.targetTempControlFactorClothesTemp == temperature.targetTempControlFactorClothesTemp && this.targetTempControlFactorAction == temperature.targetTempControlFactorAction && this.targetTempControlFactorBoost == temperature.targetTempControlFactorBoost && this.coolPreference == temperature.coolPreference && this.heatPreference == temperature.heatPreference && this.tempCoolWrite == temperature.tempCoolWrite && this.tempHeatWrite == temperature.tempHeatWrite && Intrinsics.areEqual((Object) this.targetTemp, (Object) temperature.targetTemp) && Intrinsics.areEqual((Object) this.tempCoolSwitchThreshold, (Object) temperature.tempCoolSwitchThreshold) && Intrinsics.areEqual((Object) this.tempWarmSwitchThreshold, (Object) temperature.tempWarmSwitchThreshold) && Intrinsics.areEqual((Object) this.tempModeRemainTime, (Object) temperature.tempModeRemainTime) && Intrinsics.areEqual((Object) this.coolBoostDurationValue, (Object) temperature.coolBoostDurationValue) && Intrinsics.areEqual((Object) this.coolBoostTempOffset, (Object) temperature.coolBoostTempOffset);
        }

        public int hashCode() {
            int hashCode = ((((((this.tempOffOnCode.hashCode() * 31) + this.tempCoolHeatType.hashCode()) * 31) + this.coolBoost.hashCode()) * 31) + this.tempCurrentCoolHeatType.hashCode()) * 31;
            TagFuncLimit tagFuncLimit2 = this.tagFuncLimit;
            int i = 0;
            int hashCode2 = (hashCode + (tagFuncLimit2 == null ? 0 : tagFuncLimit2.hashCode())) * 31;
            SwitchingTrigger1 switchingTrigger12 = this.switchingTrigger1;
            int hashCode3 = (hashCode2 + (switchingTrigger12 == null ? 0 : switchingTrigger12.hashCode())) * 31;
            SwitchingTrigger2 switchingTrigger22 = this.switchingTrigger2;
            int hashCode4 = (hashCode3 + (switchingTrigger22 == null ? 0 : switchingTrigger22.hashCode())) * 31;
            BoostStatus boostStatus2 = this.boostStatus;
            int hashCode5 = (hashCode4 + (boostStatus2 == null ? 0 : boostStatus2.hashCode())) * 31;
            TargetTempControlStatus targetTempControlStatus2 = this.targetTempControlStatus;
            int hashCode6 = (hashCode5 + (targetTempControlStatus2 == null ? 0 : targetTempControlStatus2.hashCode())) * 31;
            TargetTempControlFactorALS targetTempControlFactorALS2 = this.targetTempControlFactorALS;
            int hashCode7 = (hashCode6 + (targetTempControlFactorALS2 == null ? 0 : targetTempControlFactorALS2.hashCode())) * 31;
            TargetTempControlFactorEnvironment targetTempControlFactorEnvironment2 = this.targetTempControlFactorEnvironment;
            int hashCode8 = (hashCode7 + (targetTempControlFactorEnvironment2 == null ? 0 : targetTempControlFactorEnvironment2.hashCode())) * 31;
            TargetTempControlFactorClothesTemp targetTempControlFactorClothesTemp2 = this.targetTempControlFactorClothesTemp;
            int hashCode9 = (hashCode8 + (targetTempControlFactorClothesTemp2 == null ? 0 : targetTempControlFactorClothesTemp2.hashCode())) * 31;
            TargetTempControlFactorAction targetTempControlFactorAction2 = this.targetTempControlFactorAction;
            int hashCode10 = (hashCode9 + (targetTempControlFactorAction2 == null ? 0 : targetTempControlFactorAction2.hashCode())) * 31;
            TargetTempControlFactorBoost targetTempControlFactorBoost2 = this.targetTempControlFactorBoost;
            int hashCode11 = (((((((((hashCode10 + (targetTempControlFactorBoost2 == null ? 0 : targetTempControlFactorBoost2.hashCode())) * 31) + this.coolPreference.hashCode()) * 31) + this.heatPreference.hashCode()) * 31) + this.tempCoolWrite) * 31) + this.tempHeatWrite) * 31;
            Integer num = this.targetTemp;
            int hashCode12 = (hashCode11 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.tempCoolSwitchThreshold;
            int hashCode13 = (hashCode12 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.tempWarmSwitchThreshold;
            int hashCode14 = (hashCode13 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.tempModeRemainTime;
            int hashCode15 = (hashCode14 + (num4 == null ? 0 : num4.hashCode())) * 31;
            Integer num5 = this.coolBoostDurationValue;
            int hashCode16 = (hashCode15 + (num5 == null ? 0 : num5.hashCode())) * 31;
            Integer num6 = this.coolBoostTempOffset;
            if (num6 != null) {
                i = num6.hashCode();
            }
            return hashCode16 + i;
        }

        public String toString() {
            TemperatureOnOffCode temperatureOnOffCode = this.tempOffOnCode;
            TemperatureCoolHeatTypeCode temperatureCoolHeatTypeCode = this.tempCoolHeatType;
            CoolBoost coolBoost2 = this.coolBoost;
            CurrentCoolHeatTypeCode currentCoolHeatTypeCode = this.tempCurrentCoolHeatType;
            TagFuncLimit tagFuncLimit2 = this.tagFuncLimit;
            SwitchingTrigger1 switchingTrigger12 = this.switchingTrigger1;
            SwitchingTrigger2 switchingTrigger22 = this.switchingTrigger2;
            BoostStatus boostStatus2 = this.boostStatus;
            TargetTempControlStatus targetTempControlStatus2 = this.targetTempControlStatus;
            TargetTempControlFactorALS targetTempControlFactorALS2 = this.targetTempControlFactorALS;
            TargetTempControlFactorEnvironment targetTempControlFactorEnvironment2 = this.targetTempControlFactorEnvironment;
            TargetTempControlFactorClothesTemp targetTempControlFactorClothesTemp2 = this.targetTempControlFactorClothesTemp;
            TargetTempControlFactorAction targetTempControlFactorAction2 = this.targetTempControlFactorAction;
            TargetTempControlFactorBoost targetTempControlFactorBoost2 = this.targetTempControlFactorBoost;
            SmartModePreference smartModePreference = this.coolPreference;
            SmartModePreference smartModePreference2 = this.heatPreference;
            int i = this.tempCoolWrite;
            int i2 = this.tempHeatWrite;
            Integer num = this.targetTemp;
            Integer num2 = this.tempCoolSwitchThreshold;
            Integer num3 = this.tempWarmSwitchThreshold;
            Integer num4 = this.tempModeRemainTime;
            Integer num5 = this.coolBoostDurationValue;
            return "Temperature(tempOffOnCode=" + temperatureOnOffCode + ", tempCoolHeatType=" + temperatureCoolHeatTypeCode + ", coolBoost=" + coolBoost2 + ", tempCurrentCoolHeatType=" + currentCoolHeatTypeCode + ", tagFuncLimit=" + tagFuncLimit2 + ", switchingTrigger1=" + switchingTrigger12 + ", switchingTrigger2=" + switchingTrigger22 + ", boostStatus=" + boostStatus2 + ", targetTempControlStatus=" + targetTempControlStatus2 + ", targetTempControlFactorALS=" + targetTempControlFactorALS2 + ", targetTempControlFactorEnvironment=" + targetTempControlFactorEnvironment2 + ", targetTempControlFactorClothesTemp=" + targetTempControlFactorClothesTemp2 + ", targetTempControlFactorAction=" + targetTempControlFactorAction2 + ", targetTempControlFactorBoost=" + targetTempControlFactorBoost2 + ", coolPreference=" + smartModePreference + ", heatPreference=" + smartModePreference2 + ", tempCoolWrite=" + i + ", tempHeatWrite=" + i2 + ", targetTemp=" + num + ", tempCoolSwitchThreshold=" + num2 + ", tempWarmSwitchThreshold=" + num3 + ", tempModeRemainTime=" + num4 + ", coolBoostDurationValue=" + num5 + ", coolBoostTempOffset=" + this.coolBoostTempOffset + ")";
        }

        public Temperature(TemperatureOnOffCode temperatureOnOffCode, TemperatureCoolHeatTypeCode temperatureCoolHeatTypeCode, CoolBoost coolBoost2, CurrentCoolHeatTypeCode currentCoolHeatTypeCode, TagFuncLimit tagFuncLimit2, SwitchingTrigger1 switchingTrigger12, SwitchingTrigger2 switchingTrigger22, BoostStatus boostStatus2, TargetTempControlStatus targetTempControlStatus2, TargetTempControlFactorALS targetTempControlFactorALS2, TargetTempControlFactorEnvironment targetTempControlFactorEnvironment2, TargetTempControlFactorClothesTemp targetTempControlFactorClothesTemp2, TargetTempControlFactorAction targetTempControlFactorAction2, TargetTempControlFactorBoost targetTempControlFactorBoost2, SmartModePreference smartModePreference, SmartModePreference smartModePreference2, int i, int i2, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6) {
            SmartModePreference smartModePreference3 = smartModePreference;
            SmartModePreference smartModePreference4 = smartModePreference2;
            Intrinsics.checkNotNullParameter(temperatureOnOffCode, "tempOffOnCode");
            Intrinsics.checkNotNullParameter(temperatureCoolHeatTypeCode, "tempCoolHeatType");
            Intrinsics.checkNotNullParameter(coolBoost2, "coolBoost");
            Intrinsics.checkNotNullParameter(currentCoolHeatTypeCode, "tempCurrentCoolHeatType");
            Intrinsics.checkNotNullParameter(smartModePreference3, "coolPreference");
            Intrinsics.checkNotNullParameter(smartModePreference4, "heatPreference");
            this.tempOffOnCode = temperatureOnOffCode;
            this.tempCoolHeatType = temperatureCoolHeatTypeCode;
            this.coolBoost = coolBoost2;
            this.tempCurrentCoolHeatType = currentCoolHeatTypeCode;
            this.tagFuncLimit = tagFuncLimit2;
            this.switchingTrigger1 = switchingTrigger12;
            this.switchingTrigger2 = switchingTrigger22;
            this.boostStatus = boostStatus2;
            this.targetTempControlStatus = targetTempControlStatus2;
            this.targetTempControlFactorALS = targetTempControlFactorALS2;
            this.targetTempControlFactorEnvironment = targetTempControlFactorEnvironment2;
            this.targetTempControlFactorClothesTemp = targetTempControlFactorClothesTemp2;
            this.targetTempControlFactorAction = targetTempControlFactorAction2;
            this.targetTempControlFactorBoost = targetTempControlFactorBoost2;
            this.coolPreference = smartModePreference3;
            this.heatPreference = smartModePreference4;
            this.tempCoolWrite = i;
            this.tempHeatWrite = i2;
            this.targetTemp = num;
            this.tempCoolSwitchThreshold = num2;
            this.tempWarmSwitchThreshold = num3;
            this.tempModeRemainTime = num4;
            this.coolBoostDurationValue = num5;
            this.coolBoostTempOffset = num6;
        }

        public final TemperatureOnOffCode getTempOffOnCode() {
            return this.tempOffOnCode;
        }

        public final TemperatureCoolHeatTypeCode getTempCoolHeatType() {
            return this.tempCoolHeatType;
        }

        public final CoolBoost getCoolBoost() {
            return this.coolBoost;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Temperature(jp.co.sony.reonpocket.constant.TemperatureOnOffCode r28, jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode r29, jp.co.sony.reonpocket.constant.CoolBoost r30, jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode r31, jp.co.sony.reonpocket.constant.TagFuncLimit r32, jp.co.sony.reonpocket.constant.SwitchingTrigger1 r33, jp.co.sony.reonpocket.constant.SwitchingTrigger2 r34, jp.co.sony.reonpocket.constant.BoostStatus r35, jp.co.sony.reonpocket.constant.TargetTempControlStatus r36, jp.co.sony.reonpocket.constant.TargetTempControlFactorALS r37, jp.co.sony.reonpocket.constant.TargetTempControlFactorEnvironment r38, jp.co.sony.reonpocket.constant.TargetTempControlFactorClothesTemp r39, jp.co.sony.reonpocket.constant.TargetTempControlFactorAction r40, jp.co.sony.reonpocket.constant.TargetTempControlFactorBoost r41, jp.co.sony.reonpocket.constant.SmartModePreference r42, jp.co.sony.reonpocket.constant.SmartModePreference r43, int r44, int r45, java.lang.Integer r46, java.lang.Integer r47, java.lang.Integer r48, java.lang.Integer r49, java.lang.Integer r50, java.lang.Integer r51, int r52, kotlin.jvm.internal.DefaultConstructorMarker r53) {
            /*
                r27 = this;
                r0 = r52
                r1 = r0 & 8
                if (r1 == 0) goto L_0x000a
                jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode r1 = jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode.OFF
                r6 = r1
                goto L_0x000c
            L_0x000a:
                r6 = r31
            L_0x000c:
                r1 = r0 & 16
                r2 = 0
                if (r1 == 0) goto L_0x0013
                r7 = r2
                goto L_0x0015
            L_0x0013:
                r7 = r32
            L_0x0015:
                r1 = r0 & 32
                if (r1 == 0) goto L_0x001b
                r8 = r2
                goto L_0x001d
            L_0x001b:
                r8 = r33
            L_0x001d:
                r1 = r0 & 64
                if (r1 == 0) goto L_0x0023
                r9 = r2
                goto L_0x0025
            L_0x0023:
                r9 = r34
            L_0x0025:
                r1 = r0 & 128(0x80, float:1.794E-43)
                if (r1 == 0) goto L_0x002b
                r10 = r2
                goto L_0x002d
            L_0x002b:
                r10 = r35
            L_0x002d:
                r1 = r0 & 256(0x100, float:3.59E-43)
                if (r1 == 0) goto L_0x0033
                r11 = r2
                goto L_0x0035
            L_0x0033:
                r11 = r36
            L_0x0035:
                r1 = r0 & 512(0x200, float:7.175E-43)
                if (r1 == 0) goto L_0x003b
                r12 = r2
                goto L_0x003d
            L_0x003b:
                r12 = r37
            L_0x003d:
                r1 = r0 & 1024(0x400, float:1.435E-42)
                if (r1 == 0) goto L_0x0043
                r13 = r2
                goto L_0x0045
            L_0x0043:
                r13 = r38
            L_0x0045:
                r1 = r0 & 2048(0x800, float:2.87E-42)
                if (r1 == 0) goto L_0x004b
                r14 = r2
                goto L_0x004d
            L_0x004b:
                r14 = r39
            L_0x004d:
                r1 = r0 & 4096(0x1000, float:5.74E-42)
                if (r1 == 0) goto L_0x0053
                r15 = r2
                goto L_0x0055
            L_0x0053:
                r15 = r40
            L_0x0055:
                r1 = r0 & 8192(0x2000, float:1.14794E-41)
                if (r1 == 0) goto L_0x005c
                r16 = r2
                goto L_0x005e
            L_0x005c:
                r16 = r41
            L_0x005e:
                r1 = 262144(0x40000, float:3.67342E-40)
                r1 = r1 & r0
                if (r1 == 0) goto L_0x0066
                r21 = r2
                goto L_0x0068
            L_0x0066:
                r21 = r46
            L_0x0068:
                r1 = 524288(0x80000, float:7.34684E-40)
                r1 = r1 & r0
                if (r1 == 0) goto L_0x0070
                r22 = r2
                goto L_0x0072
            L_0x0070:
                r22 = r47
            L_0x0072:
                r1 = 1048576(0x100000, float:1.469368E-39)
                r1 = r1 & r0
                if (r1 == 0) goto L_0x007a
                r23 = r2
                goto L_0x007c
            L_0x007a:
                r23 = r48
            L_0x007c:
                r1 = 2097152(0x200000, float:2.938736E-39)
                r1 = r1 & r0
                if (r1 == 0) goto L_0x0084
                r24 = r2
                goto L_0x0086
            L_0x0084:
                r24 = r49
            L_0x0086:
                r1 = 4194304(0x400000, float:5.877472E-39)
                r1 = r1 & r0
                if (r1 == 0) goto L_0x008e
                r25 = r2
                goto L_0x0090
            L_0x008e:
                r25 = r50
            L_0x0090:
                r1 = 8388608(0x800000, float:1.17549435E-38)
                r0 = r0 & r1
                if (r0 == 0) goto L_0x0098
                r26 = r2
                goto L_0x009a
            L_0x0098:
                r26 = r51
            L_0x009a:
                r2 = r27
                r3 = r28
                r4 = r29
                r5 = r30
                r17 = r42
                r18 = r43
                r19 = r44
                r20 = r45
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.data.entity.DeviceModeEntity.Temperature.<init>(jp.co.sony.reonpocket.constant.TemperatureOnOffCode, jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode, jp.co.sony.reonpocket.constant.CoolBoost, jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode, jp.co.sony.reonpocket.constant.TagFuncLimit, jp.co.sony.reonpocket.constant.SwitchingTrigger1, jp.co.sony.reonpocket.constant.SwitchingTrigger2, jp.co.sony.reonpocket.constant.BoostStatus, jp.co.sony.reonpocket.constant.TargetTempControlStatus, jp.co.sony.reonpocket.constant.TargetTempControlFactorALS, jp.co.sony.reonpocket.constant.TargetTempControlFactorEnvironment, jp.co.sony.reonpocket.constant.TargetTempControlFactorClothesTemp, jp.co.sony.reonpocket.constant.TargetTempControlFactorAction, jp.co.sony.reonpocket.constant.TargetTempControlFactorBoost, jp.co.sony.reonpocket.constant.SmartModePreference, jp.co.sony.reonpocket.constant.SmartModePreference, int, int, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final CurrentCoolHeatTypeCode getTempCurrentCoolHeatType() {
            return this.tempCurrentCoolHeatType;
        }

        public final TagFuncLimit getTagFuncLimit() {
            return this.tagFuncLimit;
        }

        public final SwitchingTrigger1 getSwitchingTrigger1() {
            return this.switchingTrigger1;
        }

        public final SwitchingTrigger2 getSwitchingTrigger2() {
            return this.switchingTrigger2;
        }

        public final BoostStatus getBoostStatus() {
            return this.boostStatus;
        }

        public final TargetTempControlStatus getTargetTempControlStatus() {
            return this.targetTempControlStatus;
        }

        public final TargetTempControlFactorALS getTargetTempControlFactorALS() {
            return this.targetTempControlFactorALS;
        }

        public final TargetTempControlFactorEnvironment getTargetTempControlFactorEnvironment() {
            return this.targetTempControlFactorEnvironment;
        }

        public final TargetTempControlFactorClothesTemp getTargetTempControlFactorClothesTemp() {
            return this.targetTempControlFactorClothesTemp;
        }

        public final TargetTempControlFactorAction getTargetTempControlFactorAction() {
            return this.targetTempControlFactorAction;
        }

        public final TargetTempControlFactorBoost getTargetTempControlFactorBoost() {
            return this.targetTempControlFactorBoost;
        }

        public final SmartModePreference getCoolPreference() {
            return this.coolPreference;
        }

        public final SmartModePreference getHeatPreference() {
            return this.heatPreference;
        }

        public final int getTempCoolWrite() {
            return this.tempCoolWrite;
        }

        public final int getTempHeatWrite() {
            return this.tempHeatWrite;
        }

        public final Integer getTargetTemp() {
            return this.targetTemp;
        }

        public final Integer getTempCoolSwitchThreshold() {
            return this.tempCoolSwitchThreshold;
        }

        public final Integer getTempWarmSwitchThreshold() {
            return this.tempWarmSwitchThreshold;
        }

        public final Integer getTempModeRemainTime() {
            return this.tempModeRemainTime;
        }

        public final Integer getCoolBoostDurationValue() {
            return this.coolBoostDurationValue;
        }

        public final Integer getCoolBoostTempOffset() {
            return this.coolBoostTempOffset;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Temperature(TemperatureOnOffCode temperatureOnOffCode, TemperatureCoolHeatTypeCode temperatureCoolHeatTypeCode, SmartModePreference smartModePreference, SmartModePreference smartModePreference2, int i, int i2, int i3, int i4) {
            this(temperatureOnOffCode, temperatureCoolHeatTypeCode, CoolBoost.NONE, (CurrentCoolHeatTypeCode) null, (TagFuncLimit) null, (SwitchingTrigger1) null, (SwitchingTrigger2) null, (BoostStatus) null, (TargetTempControlStatus) null, (TargetTempControlFactorALS) null, (TargetTempControlFactorEnvironment) null, (TargetTempControlFactorClothesTemp) null, (TargetTempControlFactorAction) null, (TargetTempControlFactorBoost) null, smartModePreference, smartModePreference2, i, i2, (Integer) null, Integer.valueOf(i3), Integer.valueOf(i4), (Integer) null, 65535, Integer.valueOf(DeviceModeEntityKt.SMART_MODE_INVALID_SWITCH_THRESHOLD), 2375672, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(temperatureOnOffCode, "aTempOffOnCode");
            Intrinsics.checkNotNullParameter(temperatureCoolHeatTypeCode, "aTempCoolHeatType");
            Intrinsics.checkNotNullParameter(smartModePreference, "aCoolPreference");
            Intrinsics.checkNotNullParameter(smartModePreference2, "aHeatPreference");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:129:?, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:?, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] toByte() {
        /*
            r19 = this;
            r0 = r19
            jp.co.sony.reonpocket.constant.DeviceModeActionCode r1 = r0.mode
            if (r1 != 0) goto L_0x0008
            r1 = -1
            goto L_0x0010
        L_0x0008:
            int[] r2 = jp.co.sony.reonpocket.data.entity.DeviceModeEntity.WhenMappings.$EnumSwitchMapping$1
            int r1 = r1.ordinal()
            r1 = r2[r1]
        L_0x0010:
            r14 = 6
            r15 = 3
            r2 = 4
            java.lang.String r3 = "BIG_ENDIAN"
            r4 = 2
            r5 = 1
            r16 = 0
            r17 = 0
            switch(r1) {
                case 1: goto L_0x038d;
                case 2: goto L_0x038d;
                case 3: goto L_0x0166;
                case 4: goto L_0x008c;
                case 5: goto L_0x0056;
                case 6: goto L_0x004d;
                case 7: goto L_0x0027;
                default: goto L_0x001e;
            }
        L_0x001e:
            jp.co.sony.reonpocket.util.DebugLogUtil r1 = jp.co.sony.reonpocket.util.DebugLogUtil.INSTANCE
            java.lang.String r2 = "internal error"
            r1.e(r2)
            goto L_0x04ce
        L_0x0027:
            jp.co.sony.reonpocket.constant.DeviceModeActionCode r1 = r0.mode
            if (r1 != 0) goto L_0x002c
            return r16
        L_0x002c:
            jp.co.sony.reonpocket.constant.DeviceModeSettingTriggerCode r2 = r0.settingTrigger
            if (r2 != 0) goto L_0x0031
            return r16
        L_0x0031:
            byte[] r2 = new byte[r4]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.getCode()
            byte r1 = (byte) r1
            r2[r17] = r1
            jp.co.sony.reonpocket.constant.DeviceModeSettingTriggerCode r1 = r0.settingTrigger
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.getCode()
            byte r1 = (byte) r1
            r2[r5] = r1
        L_0x0049:
            r16 = r2
            goto L_0x04ce
        L_0x004d:
            jp.co.sony.reonpocket.util.DebugLogUtil r1 = jp.co.sony.reonpocket.util.DebugLogUtil.INSTANCE
            java.lang.String r2 = "notify only"
            r1.e(r2)
            goto L_0x04ce
        L_0x0056:
            jp.co.sony.reonpocket.constant.DeviceModeActionCode r1 = r0.mode
            if (r1 != 0) goto L_0x005b
            return r16
        L_0x005b:
            jp.co.sony.reonpocket.constant.DeviceModeSettingTriggerCode r3 = r0.settingTrigger
            if (r3 != 0) goto L_0x0060
            return r16
        L_0x0060:
            jp.co.sony.reonpocket.constant.FanStepCode r3 = r0.fanStep
            if (r3 != 0) goto L_0x0065
            return r16
        L_0x0065:
            byte[] r2 = new byte[r2]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.getCode()
            byte r1 = (byte) r1
            r2[r17] = r1
            jp.co.sony.reonpocket.constant.DeviceModeSettingTriggerCode r1 = r0.settingTrigger
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.getCode()
            byte r1 = (byte) r1
            r2[r5] = r1
            r2[r4] = r17
            jp.co.sony.reonpocket.constant.FanStepCode r1 = r0.fanStep
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.getCode()
            byte r1 = (byte) r1
            r2[r15] = r1
            goto L_0x0049
        L_0x008c:
            jp.co.sony.reonpocket.constant.DeviceModeActionCode r1 = r0.mode
            if (r1 != 0) goto L_0x0091
            return r16
        L_0x0091:
            jp.co.sony.reonpocket.constant.DeviceModeSettingTriggerCode r6 = r0.settingTrigger
            if (r6 != 0) goto L_0x0096
            return r16
        L_0x0096:
            jp.co.sony.reonpocket.data.entity.DeviceModeEntity$Temperature r7 = r0.temperatureEntity
            if (r7 != 0) goto L_0x009b
            return r16
        L_0x009b:
            java.lang.Integer r18 = r7.getTempCoolSwitchThreshold()
            if (r18 == 0) goto L_0x0165
            int r8 = r18.intValue()
            java.lang.Integer r18 = r7.getTempWarmSwitchThreshold()
            if (r18 == 0) goto L_0x0165
            int r9 = r18.intValue()
            jp.co.sony.reonpocket.constant.TemperatureOnOffCode r16 = r7.getTempOffOnCode()
            int r16 = r16.getCode()
            jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode r18 = r7.getTempCoolHeatType()
            int r18 = r18.getCode()
            int r18 = r18 << 4
            r16 = r16 | r18
            jp.co.sony.reonpocket.constant.CoolBoost r18 = r7.getCoolBoost()
            int r18 = r18.getCode()
            int r18 = r18 << 6
            r10 = r16 | r18
            byte r10 = (byte) r10
            jp.co.sony.reonpocket.constant.SmartModePreference r16 = r7.getCoolPreference()
            int r16 = r16.getCode()
            jp.co.sony.reonpocket.constant.SmartModePreference r18 = r7.getHeatPreference()
            int r18 = r18.getCode()
            int r18 = r18 << 4
            r11 = r16 | r18
            byte r11 = (byte) r11
            jp.co.sony.reonpocket.data.entity.BleDataEntity$Companion r12 = jp.co.sony.reonpocket.data.entity.BleDataEntity.Companion
            int r14 = r7.getTempCoolWrite()
            java.nio.ByteOrder r13 = java.nio.ByteOrder.BIG_ENDIAN
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r3)
            r2 = 34
            byte[] r12 = r12.createWriteBytes(r14, r2, r13)
            jp.co.sony.reonpocket.data.entity.BleDataEntity$Companion r13 = jp.co.sony.reonpocket.data.entity.BleDataEntity.Companion
            int r7 = r7.getTempHeatWrite()
            java.nio.ByteOrder r14 = java.nio.ByteOrder.BIG_ENDIAN
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r3)
            byte[] r2 = r13.createWriteBytes(r7, r2, r14)
            r3 = 20
            byte[] r3 = new byte[r3]
            int r1 = r1.getCode()
            byte r1 = (byte) r1
            r3[r17] = r1
            int r1 = r6.getCode()
            byte r1 = (byte) r1
            r3[r5] = r1
            r3[r4] = r17
            r3[r15] = r10
            r1 = 4
            r3[r1] = r17
            r1 = 5
            r3[r1] = r17
            r1 = 6
            r3[r1] = r11
            byte r1 = r12[r17]
            r4 = 7
            r3[r4] = r1
            byte r1 = r12[r5]
            r4 = 8
            r3[r4] = r1
            byte r1 = r2[r17]
            r4 = 9
            r3[r4] = r1
            byte r1 = r2[r5]
            r2 = 10
            r3[r2] = r1
            r1 = 11
            r3[r1] = r17
            r1 = 12
            r3[r1] = r17
            byte r1 = (byte) r8
            r2 = 13
            r3[r2] = r1
            byte r1 = (byte) r9
            r2 = 14
            r3[r2] = r1
            r1 = 15
            r3[r1] = r17
            r1 = 16
            r3[r1] = r17
            r1 = 17
            r3[r1] = r17
            r1 = 18
            r3[r1] = r17
            r1 = 19
            r3[r1] = r17
        L_0x0161:
            r16 = r3
            goto L_0x04ce
        L_0x0165:
            return r16
        L_0x0166:
            jp.co.sony.reonpocket.constant.DeviceModeActionCode r1 = r0.mode
            if (r1 != 0) goto L_0x016b
            return r16
        L_0x016b:
            jp.co.sony.reonpocket.constant.DeviceModeSettingTriggerCode r1 = r0.settingTrigger
            if (r1 != 0) goto L_0x0170
            return r16
        L_0x0170:
            jp.co.sony.reonpocket.constant.MyModeActionType r1 = r0.myModeActionType
            if (r1 != 0) goto L_0x0175
            return r16
        L_0x0175:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int[] r2 = jp.co.sony.reonpocket.data.entity.DeviceModeEntity.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r2[r1]
            if (r1 == r5) goto L_0x0216
            if (r1 != r4) goto L_0x0210
            jp.co.sony.reonpocket.constant.MyModeSpecialSubMode r1 = r0.myModeSpecialSubMode
            if (r1 != 0) goto L_0x0189
            return r16
        L_0x0189:
            java.lang.Integer r1 = r0.myModeSpecialTotalTime
            if (r1 == 0) goto L_0x020f
            r1.intValue()
            java.lang.Integer r1 = r0.myModeSpecialRemainTime
            if (r1 == 0) goto L_0x020f
            r1.intValue()
            jp.co.sony.reonpocket.data.entity.BleDataEntity$Companion r1 = jp.co.sony.reonpocket.data.entity.BleDataEntity.Companion
            java.lang.Integer r2 = r0.myModeSpecialTotalTime
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            int r2 = r2.intValue()
            java.nio.ByteOrder r6 = java.nio.ByteOrder.BIG_ENDIAN
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r3)
            r7 = 18
            byte[] r1 = r1.createWriteBytes(r2, r7, r6)
            jp.co.sony.reonpocket.data.entity.BleDataEntity$Companion r2 = jp.co.sony.reonpocket.data.entity.BleDataEntity.Companion
            java.lang.Integer r6 = r0.myModeSpecialRemainTime
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            int r6 = r6.intValue()
            java.nio.ByteOrder r8 = java.nio.ByteOrder.BIG_ENDIAN
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)
            byte[] r2 = r2.createWriteBytes(r6, r7, r8)
            r3 = 9
            byte[] r3 = new byte[r3]
            jp.co.sony.reonpocket.constant.DeviceModeActionCode r6 = r0.mode
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            int r6 = r6.getCode()
            byte r6 = (byte) r6
            r3[r17] = r6
            jp.co.sony.reonpocket.constant.DeviceModeSettingTriggerCode r6 = r0.settingTrigger
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            int r6 = r6.getCode()
            byte r6 = (byte) r6
            r3[r5] = r6
            r3[r4] = r17
            jp.co.sony.reonpocket.constant.MyModeActionType r4 = r0.myModeActionType
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            int r4 = r4.getCode()
            byte r4 = (byte) r4
            r3[r15] = r4
            jp.co.sony.reonpocket.constant.MyModeSpecialSubMode r4 = r0.myModeSpecialSubMode
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            int r4 = r4.getCode()
            byte r4 = (byte) r4
            r6 = 4
            r3[r6] = r4
            byte r4 = r1[r17]
            r6 = 5
            r3[r6] = r4
            byte r1 = r1[r5]
            r4 = 6
            r3[r4] = r1
            byte r1 = r2[r17]
            r4 = 7
            r3[r4] = r1
            byte r1 = r2[r5]
            r2 = 8
            r3[r2] = r1
            goto L_0x0161
        L_0x020f:
            return r16
        L_0x0210:
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        L_0x0216:
            jp.co.sony.reonpocket.constant.MyModeOperationCode r1 = r0.myModeAction
            if (r1 != 0) goto L_0x021b
            return r16
        L_0x021b:
            java.lang.Integer r1 = r0.mySettingNo
            if (r1 == 0) goto L_0x038c
            r1.intValue()
            jp.co.sony.reonpocket.constant.MyModeTypeCode r1 = r0.myModeType
            if (r1 != 0) goto L_0x0227
            return r16
        L_0x0227:
            java.lang.Integer r1 = r0.myCoolTemp
            if (r1 == 0) goto L_0x038c
            r1.intValue()
            jp.co.sony.reonpocket.constant.TempBoostOption r1 = r0.myCoolBoostOption
            if (r1 != 0) goto L_0x0233
            return r16
        L_0x0233:
            jp.co.sony.reonpocket.constant.TempWaveOption r1 = r0.myCoolWaveOption
            if (r1 != 0) goto L_0x0238
            return r16
        L_0x0238:
            java.lang.Integer r1 = r0.myCoolDuration
            if (r1 == 0) goto L_0x038c
            r1.intValue()
            jp.co.sony.reonpocket.data.entity.BleDataEntity$Companion r1 = jp.co.sony.reonpocket.data.entity.BleDataEntity.Companion
            java.lang.Integer r2 = r0.myCoolDuration
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            int r2 = r2.intValue()
            java.nio.ByteOrder r6 = java.nio.ByteOrder.BIG_ENDIAN
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r3)
            r7 = 18
            byte[] r1 = r1.createWriteBytes(r2, r7, r6)
            java.lang.Integer r2 = r0.myHeatTemp
            if (r2 == 0) goto L_0x038c
            r2.intValue()
            jp.co.sony.reonpocket.constant.TempBoostOption r2 = r0.myHeatBoostOption
            if (r2 != 0) goto L_0x0261
            return r16
        L_0x0261:
            jp.co.sony.reonpocket.constant.TempWaveOption r2 = r0.myHeatWaveOption
            if (r2 != 0) goto L_0x0266
            return r16
        L_0x0266:
            java.lang.Integer r2 = r0.myHeatDuration
            if (r2 == 0) goto L_0x038c
            r2.intValue()
            jp.co.sony.reonpocket.data.entity.BleDataEntity$Companion r2 = jp.co.sony.reonpocket.data.entity.BleDataEntity.Companion
            java.lang.Integer r6 = r0.myHeatDuration
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            int r6 = r6.intValue()
            java.nio.ByteOrder r7 = java.nio.ByteOrder.BIG_ENDIAN
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r3)
            r8 = 18
            byte[] r2 = r2.createWriteBytes(r6, r8, r7)
            java.lang.Integer r6 = r0.myOffDuration
            if (r6 == 0) goto L_0x038c
            r6.intValue()
            jp.co.sony.reonpocket.data.entity.BleDataEntity$Companion r6 = jp.co.sony.reonpocket.data.entity.BleDataEntity.Companion
            java.lang.Integer r7 = r0.myOffDuration
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            int r7 = r7.intValue()
            java.nio.ByteOrder r9 = java.nio.ByteOrder.BIG_ENDIAN
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r3)
            byte[] r6 = r6.createWriteBytes(r7, r8, r9)
            java.lang.Integer r7 = r0.myTotalDuration
            if (r7 == 0) goto L_0x038c
            r7.intValue()
            jp.co.sony.reonpocket.data.entity.BleDataEntity$Companion r7 = jp.co.sony.reonpocket.data.entity.BleDataEntity.Companion
            java.lang.Integer r9 = r0.myTotalDuration
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            int r9 = r9.intValue()
            java.nio.ByteOrder r10 = java.nio.ByteOrder.BIG_ENDIAN
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r3)
            byte[] r3 = r7.createWriteBytes(r9, r8, r10)
            r7 = 19
            byte[] r7 = new byte[r7]
            jp.co.sony.reonpocket.constant.DeviceModeActionCode r8 = r0.mode
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            int r8 = r8.getCode()
            byte r8 = (byte) r8
            r7[r17] = r8
            jp.co.sony.reonpocket.constant.DeviceModeSettingTriggerCode r8 = r0.settingTrigger
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            int r8 = r8.getCode()
            byte r8 = (byte) r8
            r7[r5] = r8
            r7[r4] = r17
            jp.co.sony.reonpocket.constant.MyModeActionType r8 = r0.myModeActionType
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            int r8 = r8.getCode()
            byte r8 = (byte) r8
            r7[r15] = r8
            jp.co.sony.reonpocket.constant.MyModeOperationCode r8 = r0.myModeAction
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            int r8 = r8.getCode()
            byte r8 = (byte) r8
            r9 = 4
            r7[r9] = r8
            java.lang.Integer r8 = r0.mySettingNo
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            int r8 = r8.intValue()
            byte r8 = (byte) r8
            r9 = 5
            r7[r9] = r8
            jp.co.sony.reonpocket.constant.MyModeTypeCode r8 = r0.myModeType
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            int r8 = r8.getCode()
            byte r8 = (byte) r8
            r9 = 6
            r7[r9] = r8
            java.lang.Integer r8 = r0.myCoolTemp
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            int r8 = r8.intValue()
            byte r8 = (byte) r8
            r9 = 7
            r7[r9] = r8
            jp.co.sony.reonpocket.constant.TempBoostOption r8 = r0.myCoolBoostOption
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            int r8 = r8.getCode()
            jp.co.sony.reonpocket.constant.TempWaveOption r9 = r0.myCoolWaveOption
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            int r9 = r9.getCode()
            int r9 = r9 << r4
            r8 = r8 | r9
            byte r8 = (byte) r8
            r9 = 8
            r7[r9] = r8
            byte r8 = r1[r17]
            r9 = 9
            r7[r9] = r8
            byte r1 = r1[r5]
            r8 = 10
            r7[r8] = r1
            java.lang.Integer r1 = r0.myHeatTemp
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.intValue()
            byte r1 = (byte) r1
            r8 = 11
            r7[r8] = r1
            jp.co.sony.reonpocket.constant.TempBoostOption r1 = r0.myHeatBoostOption
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.getCode()
            jp.co.sony.reonpocket.constant.TempWaveOption r8 = r0.myHeatWaveOption
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            int r8 = r8.getCode()
            int r4 = r8 << 2
            r1 = r1 | r4
            byte r1 = (byte) r1
            r4 = 12
            r7[r4] = r1
            byte r1 = r2[r17]
            r4 = 13
            r7[r4] = r1
            byte r1 = r2[r5]
            r2 = 14
            r7[r2] = r1
            byte r1 = r6[r17]
            r2 = 15
            r7[r2] = r1
            byte r1 = r6[r5]
            r2 = 16
            r7[r2] = r1
            byte r1 = r3[r17]
            r2 = 17
            r7[r2] = r1
            byte r1 = r3[r5]
            r2 = 18
            r7[r2] = r1
            r16 = r7
            goto L_0x04ce
        L_0x038c:
            return r16
        L_0x038d:
            jp.co.sony.reonpocket.constant.DeviceModeActionCode r1 = r0.mode
            if (r1 != 0) goto L_0x0392
            return r16
        L_0x0392:
            jp.co.sony.reonpocket.constant.DeviceModeSettingTriggerCode r1 = r0.settingTrigger
            if (r1 != 0) goto L_0x0397
            return r16
        L_0x0397:
            jp.co.sony.reonpocket.constant.CoolHeatTypeCode r1 = r0.coolHeatType
            if (r1 != 0) goto L_0x039c
            return r16
        L_0x039c:
            jp.co.sony.reonpocket.constant.TempStepCode r1 = r0.temperature
            if (r1 != 0) goto L_0x03a1
            return r16
        L_0x03a1:
            jp.co.sony.reonpocket.constant.TempBoostOption r1 = r0.boostOption
            if (r1 != 0) goto L_0x03a6
            return r16
        L_0x03a6:
            jp.co.sony.reonpocket.constant.TempWaveOption r1 = r0.waveOption
            if (r1 != 0) goto L_0x03ab
            return r16
        L_0x03ab:
            java.lang.Integer r1 = r0.currentModeRemainTime
            if (r1 == 0) goto L_0x04ce
            r1.intValue()
            java.lang.Integer r1 = r0.totalDuration
            if (r1 == 0) goto L_0x04ce
            r1.intValue()
            jp.co.sony.reonpocket.data.entity.BleDataEntity$Companion r1 = jp.co.sony.reonpocket.data.entity.BleDataEntity.Companion
            java.lang.Integer r2 = r0.currentModeRemainTime
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            int r2 = r2.intValue()
            java.nio.ByteOrder r6 = java.nio.ByteOrder.BIG_ENDIAN
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r3)
            r7 = 18
            byte[] r1 = r1.createWriteBytes(r2, r7, r6)
            jp.co.sony.reonpocket.data.entity.BleDataEntity$Companion r2 = jp.co.sony.reonpocket.data.entity.BleDataEntity.Companion
            java.lang.Integer r6 = r0.totalDuration
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            int r6 = r6.intValue()
            java.nio.ByteOrder r8 = java.nio.ByteOrder.BIG_ENDIAN
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)
            byte[] r2 = r2.createWriteBytes(r6, r7, r8)
            java.lang.Integer r6 = r0.remainDuration
            if (r6 == 0) goto L_0x04ce
            r6.intValue()
            jp.co.sony.reonpocket.data.entity.BleDataEntity$Companion r6 = jp.co.sony.reonpocket.data.entity.BleDataEntity.Companion
            java.lang.Integer r8 = r0.remainDuration
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            int r8 = r8.intValue()
            java.nio.ByteOrder r9 = java.nio.ByteOrder.BIG_ENDIAN
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r3)
            byte[] r3 = r6.createWriteBytes(r8, r7, r9)
            jp.co.sony.reonpocket.constant.CoolHeatTypeCode[] r6 = new jp.co.sony.reonpocket.constant.CoolHeatTypeCode[r4]
            jp.co.sony.reonpocket.constant.CoolHeatTypeCode r7 = jp.co.sony.reonpocket.constant.CoolHeatTypeCode.OFF_COOL
            r6[r17] = r7
            jp.co.sony.reonpocket.constant.CoolHeatTypeCode r7 = jp.co.sony.reonpocket.constant.CoolHeatTypeCode.OFF_HEAT
            r6[r5] = r7
            jp.co.sony.reonpocket.constant.CoolHeatTypeCode r7 = r0.coolHeatType
            boolean r6 = kotlin.collections.ArraysKt.contains((T[]) r6, r7)
            if (r6 == 0) goto L_0x0459
            r6 = 12
            byte[] r1 = new byte[r6]
            jp.co.sony.reonpocket.constant.DeviceModeActionCode r2 = r0.mode
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            int r2 = r2.getCode()
            byte r2 = (byte) r2
            r1[r17] = r2
            jp.co.sony.reonpocket.constant.DeviceModeSettingTriggerCode r2 = r0.settingTrigger
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            int r2 = r2.getCode()
            byte r2 = (byte) r2
            r1[r5] = r2
            r1[r4] = r17
            jp.co.sony.reonpocket.constant.CoolHeatTypeCode r2 = r0.coolHeatType
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            int r2 = r2.getCode()
            byte r2 = (byte) r2
            r1[r15] = r2
            r2 = 4
            r1[r2] = r17
            r2 = 5
            r1[r2] = r17
            r2 = 6
            r1[r2] = r17
            r2 = 7
            r1[r2] = r17
            r2 = 8
            r1[r2] = r17
            r2 = 9
            r1[r2] = r17
            r2 = 10
            r1[r2] = r17
            r2 = 11
            r1[r2] = r17
            r16 = r1
            goto L_0x04ce
        L_0x0459:
            r6 = 12
            byte[] r6 = new byte[r6]
            jp.co.sony.reonpocket.constant.DeviceModeActionCode r7 = r0.mode
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            int r7 = r7.getCode()
            byte r7 = (byte) r7
            r6[r17] = r7
            jp.co.sony.reonpocket.constant.DeviceModeSettingTriggerCode r7 = r0.settingTrigger
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            int r7 = r7.getCode()
            byte r7 = (byte) r7
            r6[r5] = r7
            r6[r4] = r17
            jp.co.sony.reonpocket.constant.CoolHeatTypeCode r7 = r0.coolHeatType
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            int r7 = r7.getCode()
            byte r7 = (byte) r7
            r6[r15] = r7
            jp.co.sony.reonpocket.constant.TempStepCode r7 = r0.temperature
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            int r7 = r7.getCode()
            byte r7 = (byte) r7
            r8 = 4
            r6[r8] = r7
            jp.co.sony.reonpocket.constant.TempBoostOption r7 = r0.boostOption
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            int r7 = r7.getCode()
            jp.co.sony.reonpocket.constant.TempWaveOption r8 = r0.waveOption
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            int r8 = r8.getCode()
            int r4 = r8 << 2
            r4 = r4 | r7
            byte r4 = (byte) r4
            r7 = 5
            r6[r7] = r4
            byte r4 = r1[r17]
            r7 = 6
            r6[r7] = r4
            byte r1 = r1[r5]
            r4 = 7
            r6[r4] = r1
            byte r1 = r2[r17]
            r4 = 8
            r6[r4] = r1
            byte r1 = r2[r5]
            r2 = 9
            r6[r2] = r1
            byte r1 = r3[r17]
            r2 = 10
            r6[r2] = r1
            byte r1 = r3[r5]
            r2 = 11
            r6[r2] = r1
            r16 = r6
        L_0x04ce:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.data.entity.DeviceModeEntity.toByte():byte[]");
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR!\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0010j\b\u0012\u0004\u0012\u00020\b`\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity$Companion;", "", "()V", "INVALID_WRITE_DATA", "", "smartCoolDefaultPrefMap", "", "Ljp/co/sony/reonpocket/constant/SmartModePreference;", "", "getSmartCoolDefaultPrefMap", "()Ljava/util/Map;", "smartCoolRNP5PrefMap", "getSmartCoolRNP5PrefMap", "smartCoolRNPP1PrefMap", "getSmartCoolRNPP1PrefMap", "smartWarmDefaultPrefList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getSmartWarmDefaultPrefList", "()Ljava/util/ArrayList;", "getObject", "Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity;", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DeviceModeEntity.kt */
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* compiled from: DeviceModeEntity.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;
            public static final /* synthetic */ int[] $EnumSwitchMapping$2;

            /* JADX WARNING: Can't wrap try/catch for region: R(27:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|(2:15|16)|17|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|35) */
            /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|(2:5|6)|7|9|10|11|12|13|(2:15|16)|17|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|35) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
            /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004c */
            /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0054 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005c */
            /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0065 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x006e */
            /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0077 */
            static {
                /*
                    jp.co.sony.reonpocket.constant.MyModeActionType[] r0 = jp.co.sony.reonpocket.constant.MyModeActionType.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    r1 = 1
                    jp.co.sony.reonpocket.constant.MyModeActionType r2 = jp.co.sony.reonpocket.constant.MyModeActionType.CUSTOM     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    r2 = 2
                    jp.co.sony.reonpocket.constant.MyModeActionType r3 = jp.co.sony.reonpocket.constant.MyModeActionType.SPECIAL     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    $EnumSwitchMapping$0 = r0
                    jp.co.sony.reonpocket.constant.BleActionCode[] r0 = jp.co.sony.reonpocket.constant.BleActionCode.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    jp.co.sony.reonpocket.constant.BleActionCode r3 = jp.co.sony.reonpocket.constant.BleActionCode.READ     // Catch:{ NoSuchFieldError -> 0x002a }
                    int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                    r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
                L_0x002a:
                    jp.co.sony.reonpocket.constant.BleActionCode r3 = jp.co.sony.reonpocket.constant.BleActionCode.NOTIFY     // Catch:{ NoSuchFieldError -> 0x0032 }
                    int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                    r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
                L_0x0032:
                    r3 = 3
                    jp.co.sony.reonpocket.constant.BleActionCode r4 = jp.co.sony.reonpocket.constant.BleActionCode.WRITE     // Catch:{ NoSuchFieldError -> 0x003b }
                    int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                    r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x003b }
                L_0x003b:
                    $EnumSwitchMapping$1 = r0
                    jp.co.sony.reonpocket.constant.DeviceModeActionCode[] r0 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    jp.co.sony.reonpocket.constant.DeviceModeActionCode r4 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.MANUAL     // Catch:{ NoSuchFieldError -> 0x004c }
                    int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
                    r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x004c }
                L_0x004c:
                    jp.co.sony.reonpocket.constant.DeviceModeActionCode r1 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.AUTO     // Catch:{ NoSuchFieldError -> 0x0054 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
                L_0x0054:
                    jp.co.sony.reonpocket.constant.DeviceModeActionCode r1 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.MY     // Catch:{ NoSuchFieldError -> 0x005c }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
                    r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x005c }
                L_0x005c:
                    jp.co.sony.reonpocket.constant.DeviceModeActionCode r1 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.MY_SETTING     // Catch:{ NoSuchFieldError -> 0x0065 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0065 }
                    r2 = 4
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0065 }
                L_0x0065:
                    jp.co.sony.reonpocket.constant.DeviceModeActionCode r1 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.TEMPERATURE     // Catch:{ NoSuchFieldError -> 0x006e }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                    r2 = 5
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
                L_0x006e:
                    jp.co.sony.reonpocket.constant.DeviceModeActionCode r1 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.FAN     // Catch:{ NoSuchFieldError -> 0x0077 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0077 }
                    r2 = 6
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0077 }
                L_0x0077:
                    jp.co.sony.reonpocket.constant.DeviceModeActionCode r1 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.POWER_OFF     // Catch:{ NoSuchFieldError -> 0x0080 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0080 }
                    r2 = 7
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0080 }
                L_0x0080:
                    $EnumSwitchMapping$2 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.data.entity.DeviceModeEntity.Companion.WhenMappings.<clinit>():void");
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<SmartModePreference, Integer> getSmartCoolDefaultPrefMap() {
            return DeviceModeEntity.smartCoolDefaultPrefMap;
        }

        public final Map<SmartModePreference, Integer> getSmartCoolRNP5PrefMap() {
            return DeviceModeEntity.smartCoolRNP5PrefMap;
        }

        public final Map<SmartModePreference, Integer> getSmartCoolRNPP1PrefMap() {
            return DeviceModeEntity.smartCoolRNPP1PrefMap;
        }

        public final ArrayList<Integer> getSmartWarmDefaultPrefList() {
            return DeviceModeEntity.smartWarmDefaultPrefList;
        }

        public final DeviceModeEntity getObject(BleDataEntity bleDataEntity) {
            DeviceModeActionCode deviceModeActionCode;
            DeviceCoolingCode deviceCoolingCode;
            DeviceCoolingCode deviceCoolingCode2;
            Unit unit;
            ContinuousOperationStatus continuousOperationStatus;
            ContinuousOperationStatus continuousOperationStatus2;
            Unit unit2;
            Object obj;
            SwitchCoolHeatWaitStatus switchCoolHeatWaitStatus;
            Unit unit3;
            int i;
            DeviceModeSettingTriggerCode deviceModeSettingTriggerCode;
            CoolHeatTypeCode coolHeatTypeCode;
            TempStepCode tempStepCode;
            TempBoostOption tempBoostOption;
            TempWaveOption tempWaveOption;
            Integer num;
            TempWaveOption tempWaveOption2;
            Unit unit4;
            TempBoostOption tempBoostOption2;
            Unit unit5;
            TempStepCode tempStepCode2;
            Unit unit6;
            CoolHeatTypeCode coolHeatTypeCode2;
            Unit unit7;
            DeviceModeSettingTriggerCode deviceModeSettingTriggerCode2;
            Unit unit8;
            DeviceModeSettingTriggerCode deviceModeSettingTriggerCode3;
            MyModeActionType myModeActionType;
            MyModeOperationCode myModeOperationCode;
            MyModeTypeCode myModeTypeCode;
            Unit unit9;
            TempBoostOption tempBoostOption3;
            TempWaveOption tempWaveOption3;
            TempBoostOption tempBoostOption4;
            TempWaveOption tempWaveOption4;
            CoolHeatTypeCode coolHeatTypeCode3;
            MyTempStepCode myTempStepCode;
            Integer intValue$default;
            TempBoostOption tempBoostOption5;
            TempWaveOption tempWaveOption5;
            Unit unit10;
            MyModeSpecialSubMode myModeSpecialSubMode;
            MyModeSpecialSubMode myModeSpecialSubMode2;
            Unit unit11;
            MyModeActionType myModeActionType2;
            Unit unit12;
            DeviceModeSettingTriggerCode deviceModeSettingTriggerCode4;
            Unit unit13;
            DeviceModeSettingTriggerCode deviceModeSettingTriggerCode5;
            MyModeOperationCode myModeOperationCode2;
            MyModeTypeCode myModeTypeCode2;
            TempBoostOption tempBoostOption6;
            TempWaveOption tempWaveOption6;
            TempBoostOption tempBoostOption7;
            TempWaveOption tempWaveOption7;
            TempWaveOption tempWaveOption8;
            Unit unit14;
            TempBoostOption tempBoostOption8;
            Unit unit15;
            TempWaveOption tempWaveOption9;
            Unit unit16;
            TempBoostOption tempBoostOption9;
            Unit unit17;
            MyModeTypeCode myModeTypeCode3;
            Unit unit18;
            MyModeOperationCode myModeOperationCode3;
            Unit unit19;
            Unit unit20;
            DeviceModeSettingTriggerCode deviceModeSettingTriggerCode6;
            MyModeOperationCode myModeOperationCode4;
            MyModeTypeCode myModeTypeCode4;
            TempBoostOption tempBoostOption10;
            TempWaveOption tempWaveOption10;
            Unit unit21;
            TempBoostOption tempBoostOption11;
            TempWaveOption tempWaveOption11;
            DeviceModeSettingTriggerCode deviceModeSettingTriggerCode7;
            TemperatureOnOffCode temperatureOnOffCode;
            TemperatureCoolHeatTypeCode temperatureCoolHeatTypeCode;
            CoolBoost coolBoost;
            Integer intValue$default2;
            CurrentCoolHeatTypeCode currentCoolHeatTypeCode;
            TagFuncLimit tagFuncLimit;
            SwitchingTrigger1 switchingTrigger1;
            SwitchingTrigger2 switchingTrigger2;
            BoostStatus boostStatus;
            Integer intValue$default3;
            TargetTempControlStatus targetTempControlStatus;
            TargetTempControlFactorALS targetTempControlFactorALS;
            TargetTempControlFactorEnvironment targetTempControlFactorEnvironment;
            TargetTempControlFactorClothesTemp targetTempControlFactorClothesTemp;
            TargetTempControlFactorAction targetTempControlFactorAction;
            TargetTempControlFactorBoost targetTempControlFactorBoost;
            Integer intValue$default4;
            SmartModePreference smartModePreference;
            SmartModePreference smartModePreference2;
            Integer intValue$default5;
            DeviceModeSettingTriggerCode deviceModeSettingTriggerCode8;
            DeviceModeSettingTriggerCode deviceModeSettingTriggerCode9;
            FanStepCode fanStepCode;
            FanStepCode fanStepCode2;
            Unit unit22;
            DeviceModeSettingTriggerCode deviceModeSettingTriggerCode10;
            Unit unit23;
            DeviceModeSettingTriggerCode deviceModeSettingTriggerCode11;
            Object obj2;
            Unit unit24;
            DeviceModeActionCode deviceModeActionCode2;
            Unit unit25;
            Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
            if (bleDataEntity.getData() != null) {
                DeviceModeActionCode[] values = DeviceModeActionCode.values();
                int length = values.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        deviceModeActionCode2 = null;
                        break;
                    }
                    deviceModeActionCode2 = values[i2];
                    int code = deviceModeActionCode2.getCode();
                    Integer intValue$default6 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 0, (ByteOrder) null, 4, (Object) null);
                    if (intValue$default6 != null && code == intValue$default6.intValue()) {
                        break;
                    }
                    i2++;
                }
                if (deviceModeActionCode2 != null) {
                    Unit unit26 = Unit.INSTANCE;
                    unit25 = Unit.INSTANCE;
                } else {
                    unit25 = null;
                    deviceModeActionCode2 = null;
                }
                if (unit25 == null) {
                    return null;
                }
                Unit unit27 = Unit.INSTANCE;
                Unit unit28 = Unit.INSTANCE;
                deviceModeActionCode = deviceModeActionCode2;
            } else {
                deviceModeActionCode = null;
            }
            Integer intValue$default7 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 2, (ByteOrder) null, 4, (Object) null);
            int intValue = intValue$default7 != null ? intValue$default7.intValue() : 0;
            DeviceCoolingCode[] values2 = DeviceCoolingCode.values();
            int length2 = values2.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length2) {
                    deviceCoolingCode = null;
                    break;
                }
                deviceCoolingCode = values2[i3];
                if (deviceCoolingCode.getCode() == (intValue & 1)) {
                    break;
                }
                i3++;
            }
            if (deviceCoolingCode != null) {
                Unit unit29 = Unit.INSTANCE;
                unit = Unit.INSTANCE;
                deviceCoolingCode2 = deviceCoolingCode;
            } else {
                unit = null;
                deviceCoolingCode2 = null;
            }
            if (unit == null) {
                return null;
            }
            ContinuousOperationStatus[] values3 = ContinuousOperationStatus.values();
            int length3 = values3.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length3) {
                    continuousOperationStatus = null;
                    break;
                }
                continuousOperationStatus = values3[i4];
                if (continuousOperationStatus.getCode() == ((intValue & 2) >> 1)) {
                    break;
                }
                i4++;
            }
            if (continuousOperationStatus != null) {
                Unit unit30 = Unit.INSTANCE;
                unit2 = Unit.INSTANCE;
                continuousOperationStatus2 = continuousOperationStatus;
            } else {
                unit2 = null;
                continuousOperationStatus2 = null;
            }
            if (unit2 == null) {
                return null;
            }
            Iterator it = SwitchCoolHeatWaitStatus.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((SwitchCoolHeatWaitStatus) obj).getCode() == ((intValue & 4) >> 2)) {
                    break;
                }
            }
            SwitchCoolHeatWaitStatus switchCoolHeatWaitStatus2 = (SwitchCoolHeatWaitStatus) obj;
            if (switchCoolHeatWaitStatus2 != null) {
                Unit unit31 = Unit.INSTANCE;
                unit3 = Unit.INSTANCE;
                switchCoolHeatWaitStatus = switchCoolHeatWaitStatus2;
            } else {
                unit3 = null;
                switchCoolHeatWaitStatus = null;
            }
            if (unit3 == null) {
                return null;
            }
            if (deviceModeActionCode == null) {
                i = -1;
            } else {
                i = WhenMappings.$EnumSwitchMapping$2[deviceModeActionCode.ordinal()];
            }
            switch (i) {
                case 1:
                case 2:
                    if (bleDataEntity.getData() != null) {
                        DeviceModeSettingTriggerCode[] values4 = DeviceModeSettingTriggerCode.values();
                        int length4 = values4.length;
                        int i5 = 0;
                        while (true) {
                            if (i5 < length4) {
                                deviceModeSettingTriggerCode2 = values4[i5];
                                int code2 = deviceModeSettingTriggerCode2.getCode();
                                Integer intValue$default8 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 1, (ByteOrder) null, 4, (Object) null);
                                if (intValue$default8 == null || code2 != intValue$default8.intValue()) {
                                    i5++;
                                }
                            } else {
                                deviceModeSettingTriggerCode2 = null;
                            }
                        }
                        if (deviceModeSettingTriggerCode2 != null) {
                            Unit unit32 = Unit.INSTANCE;
                            unit8 = Unit.INSTANCE;
                        } else {
                            unit8 = null;
                            deviceModeSettingTriggerCode2 = null;
                        }
                        if (unit8 == null) {
                            return null;
                        }
                        Unit unit33 = Unit.INSTANCE;
                        Unit unit34 = Unit.INSTANCE;
                        deviceModeSettingTriggerCode = deviceModeSettingTriggerCode2;
                    } else {
                        deviceModeSettingTriggerCode = null;
                    }
                    if (bleDataEntity.getData() != null) {
                        CoolHeatTypeCode[] values5 = CoolHeatTypeCode.values();
                        int length5 = values5.length;
                        int i6 = 0;
                        while (true) {
                            if (i6 < length5) {
                                coolHeatTypeCode2 = values5[i6];
                                int code3 = coolHeatTypeCode2.getCode();
                                Integer intValue$default9 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 3, (ByteOrder) null, 4, (Object) null);
                                if (intValue$default9 == null || code3 != intValue$default9.intValue()) {
                                    i6++;
                                }
                            } else {
                                coolHeatTypeCode2 = null;
                            }
                        }
                        if (coolHeatTypeCode2 != null) {
                            Unit unit35 = Unit.INSTANCE;
                            unit7 = Unit.INSTANCE;
                        } else {
                            unit7 = null;
                            coolHeatTypeCode2 = null;
                        }
                        if (unit7 == null) {
                            return null;
                        }
                        Unit unit36 = Unit.INSTANCE;
                        Unit unit37 = Unit.INSTANCE;
                        coolHeatTypeCode = coolHeatTypeCode2;
                    } else {
                        coolHeatTypeCode = null;
                    }
                    if (bleDataEntity.getData() != null) {
                        TempStepCode[] values6 = TempStepCode.values();
                        int length6 = values6.length;
                        int i7 = 0;
                        while (true) {
                            if (i7 < length6) {
                                tempStepCode2 = values6[i7];
                                int code4 = tempStepCode2.getCode();
                                Integer intValue$default10 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 4, (ByteOrder) null, 4, (Object) null);
                                if (intValue$default10 == null || code4 != intValue$default10.intValue()) {
                                    i7++;
                                }
                            } else {
                                tempStepCode2 = null;
                            }
                        }
                        if (tempStepCode2 != null) {
                            Unit unit38 = Unit.INSTANCE;
                            unit6 = Unit.INSTANCE;
                        } else {
                            unit6 = null;
                            tempStepCode2 = null;
                        }
                        if (unit6 == null) {
                            return null;
                        }
                        Unit unit39 = Unit.INSTANCE;
                        Unit unit40 = Unit.INSTANCE;
                        tempStepCode = tempStepCode2;
                    } else {
                        tempStepCode = null;
                    }
                    Integer intValue$default11 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 5, (ByteOrder) null, 4, (Object) null);
                    if (intValue$default11 == null) {
                        return null;
                    }
                    intValue$default11.intValue();
                    if (bleDataEntity.getData() != null) {
                        TempBoostOption[] values7 = TempBoostOption.values();
                        int length7 = values7.length;
                        int i8 = 0;
                        while (true) {
                            if (i8 < length7) {
                                tempBoostOption2 = values7[i8];
                                if (tempBoostOption2.getCode() != (intValue$default11.intValue() & 3)) {
                                    i8++;
                                }
                            } else {
                                tempBoostOption2 = null;
                            }
                        }
                        if (tempBoostOption2 != null) {
                            Unit unit41 = Unit.INSTANCE;
                            unit5 = Unit.INSTANCE;
                        } else {
                            unit5 = null;
                            tempBoostOption2 = null;
                        }
                        if (unit5 == null) {
                            return null;
                        }
                        Unit unit42 = Unit.INSTANCE;
                        Unit unit43 = Unit.INSTANCE;
                        tempBoostOption = tempBoostOption2;
                    } else {
                        tempBoostOption = null;
                    }
                    if (bleDataEntity.getData() != null) {
                        TempWaveOption[] values8 = TempWaveOption.values();
                        int length8 = values8.length;
                        int i9 = 0;
                        while (true) {
                            if (i9 < length8) {
                                tempWaveOption2 = values8[i9];
                                if (tempWaveOption2.getCode() != ((intValue$default11.intValue() & 4) >> 2)) {
                                    i9++;
                                }
                            } else {
                                tempWaveOption2 = null;
                            }
                        }
                        if (tempWaveOption2 != null) {
                            Unit unit44 = Unit.INSTANCE;
                            unit4 = Unit.INSTANCE;
                            tempWaveOption = tempWaveOption2;
                        } else {
                            tempWaveOption = null;
                            unit4 = null;
                        }
                        if (unit4 == null) {
                            return null;
                        }
                        Unit unit45 = Unit.INSTANCE;
                        Unit unit46 = Unit.INSTANCE;
                    } else {
                        tempWaveOption = null;
                    }
                    Integer intValue$default12 = BleDataEntity.getIntValue$default(bleDataEntity, 18, 6, (ByteOrder) null, 4, (Object) null);
                    if (intValue$default12 != null && intValue$default12.intValue() == 65535) {
                        num = null;
                    } else {
                        num = BleDataEntity.getIntValue$default(bleDataEntity, 18, 6, (ByteOrder) null, 4, (Object) null);
                    }
                    BleDataEntity bleDataEntity2 = bleDataEntity;
                    return new DeviceModeEntity(deviceModeActionCode, deviceModeSettingTriggerCode, deviceCoolingCode2, continuousOperationStatus2, switchCoolHeatWaitStatus, coolHeatTypeCode, (Temperature) null, (ModeCommonSettingOperation) null, (Integer) null, tempStepCode, tempBoostOption, tempWaveOption, num, BleDataEntity.getIntValue$default(bleDataEntity2, 18, 8, (ByteOrder) null, 4, (Object) null), BleDataEntity.getIntValue$default(bleDataEntity2, 18, 10, (ByteOrder) null, 4, (Object) null), (MyModeActionType) null, (MyModeSpecialSubMode) null, (Integer) null, (Integer) null, (MyModeOperationCode) null, (Integer) null, (MyModeTypeCode) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyTempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (FanStepCode) null, -32320, 63, (DefaultConstructorMarker) null);
                case 3:
                    int i10 = WhenMappings.$EnumSwitchMapping$1[bleDataEntity.getAction().ordinal()];
                    if (i10 == 1 || i10 == 2) {
                        if (bleDataEntity.getData() != null) {
                            DeviceModeSettingTriggerCode[] values9 = DeviceModeSettingTriggerCode.values();
                            int length9 = values9.length;
                            int i11 = 0;
                            while (true) {
                                if (i11 < length9) {
                                    deviceModeSettingTriggerCode4 = values9[i11];
                                    int code5 = deviceModeSettingTriggerCode4.getCode();
                                    Integer intValue$default13 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 1, (ByteOrder) null, 4, (Object) null);
                                    if (intValue$default13 == null || code5 != intValue$default13.intValue()) {
                                        i11++;
                                    }
                                } else {
                                    deviceModeSettingTriggerCode4 = null;
                                }
                            }
                            if (deviceModeSettingTriggerCode4 != null) {
                                Unit unit47 = Unit.INSTANCE;
                                unit13 = Unit.INSTANCE;
                            } else {
                                unit13 = null;
                                deviceModeSettingTriggerCode4 = null;
                            }
                            if (unit13 == null) {
                                return null;
                            }
                            Unit unit48 = Unit.INSTANCE;
                            Unit unit49 = Unit.INSTANCE;
                            deviceModeSettingTriggerCode3 = deviceModeSettingTriggerCode4;
                        } else {
                            deviceModeSettingTriggerCode3 = null;
                        }
                        if (bleDataEntity.getData() != null) {
                            MyModeActionType[] values10 = MyModeActionType.values();
                            int length10 = values10.length;
                            int i12 = 0;
                            while (true) {
                                if (i12 < length10) {
                                    myModeActionType2 = values10[i12];
                                    int code6 = myModeActionType2.getCode();
                                    Integer intValue$default14 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 3, (ByteOrder) null, 4, (Object) null);
                                    if (intValue$default14 == null || code6 != intValue$default14.intValue()) {
                                        i12++;
                                    }
                                } else {
                                    myModeActionType2 = null;
                                }
                            }
                            if (myModeActionType2 != null) {
                                Unit unit50 = Unit.INSTANCE;
                                unit12 = Unit.INSTANCE;
                            } else {
                                unit12 = null;
                                myModeActionType2 = null;
                            }
                            if (unit12 == null) {
                                return null;
                            }
                            Unit unit51 = Unit.INSTANCE;
                            Unit unit52 = Unit.INSTANCE;
                            myModeActionType = myModeActionType2;
                        } else {
                            myModeActionType = null;
                        }
                        Intrinsics.checkNotNull(myModeActionType);
                        int i13 = WhenMappings.$EnumSwitchMapping$0[myModeActionType.ordinal()];
                        if (i13 == 1) {
                            if (bleDataEntity.getData() != null) {
                                MyModeOperationCode[] values11 = MyModeOperationCode.values();
                                int length11 = values11.length;
                                int i14 = 0;
                                while (true) {
                                    if (i14 < length11) {
                                        myModeOperationCode = values11[i14];
                                        int code7 = myModeOperationCode.getCode();
                                        Integer intValue$default15 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 4, (ByteOrder) null, 4, (Object) null);
                                        if (intValue$default15 == null || code7 != intValue$default15.intValue()) {
                                            i14++;
                                        }
                                    } else {
                                        myModeOperationCode = null;
                                    }
                                }
                                if (myModeOperationCode != null) {
                                    Unit unit53 = Unit.INSTANCE;
                                    unit10 = Unit.INSTANCE;
                                } else {
                                    unit10 = null;
                                    myModeOperationCode = null;
                                }
                                if (unit10 == null) {
                                    return null;
                                }
                                Unit unit54 = Unit.INSTANCE;
                                Unit unit55 = Unit.INSTANCE;
                            } else {
                                myModeOperationCode = null;
                            }
                            if (myModeOperationCode == MyModeOperationCode.READ_STATUS) {
                                byte[] data = bleDataEntity.getData();
                                Intrinsics.checkNotNull(data);
                                if (data.length < 18) {
                                    CoolHeatTypeCode[] values12 = CoolHeatTypeCode.values();
                                    int length12 = values12.length;
                                    int i15 = 0;
                                    while (true) {
                                        if (i15 < length12) {
                                            CoolHeatTypeCode coolHeatTypeCode4 = values12[i15];
                                            int code8 = coolHeatTypeCode4.getCode();
                                            Integer intValue$default16 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 6, (ByteOrder) null, 4, (Object) null);
                                            if (intValue$default16 != null && code8 == intValue$default16.intValue()) {
                                                coolHeatTypeCode3 = coolHeatTypeCode4;
                                            } else {
                                                i15++;
                                            }
                                        } else {
                                            coolHeatTypeCode3 = null;
                                        }
                                    }
                                    if (coolHeatTypeCode3 == null) {
                                        return null;
                                    }
                                    MyTempStepCode[] values13 = MyTempStepCode.values();
                                    int length13 = values13.length;
                                    int i16 = 0;
                                    while (true) {
                                        if (i16 < length13) {
                                            MyTempStepCode myTempStepCode2 = values13[i16];
                                            int code9 = myTempStepCode2.getCode();
                                            Integer intValue$default17 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 7, (ByteOrder) null, 4, (Object) null);
                                            if (intValue$default17 != null && code9 == intValue$default17.intValue()) {
                                                myTempStepCode = myTempStepCode2;
                                            } else {
                                                i16++;
                                            }
                                        } else {
                                            myTempStepCode = null;
                                        }
                                    }
                                    if (myTempStepCode == null || (intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 8, (ByteOrder) null, 4, (Object) null)) == null) {
                                        return null;
                                    }
                                    intValue$default.intValue();
                                    TempBoostOption[] values14 = TempBoostOption.values();
                                    int length14 = values14.length;
                                    int i17 = 0;
                                    while (true) {
                                        if (i17 < length14) {
                                            TempBoostOption tempBoostOption12 = values14[i17];
                                            if (tempBoostOption12.getCode() == (intValue$default.intValue() & 3)) {
                                                tempBoostOption5 = tempBoostOption12;
                                            } else {
                                                i17++;
                                            }
                                        } else {
                                            tempBoostOption5 = null;
                                        }
                                    }
                                    if (tempBoostOption5 == null) {
                                        return null;
                                    }
                                    TempWaveOption[] values15 = TempWaveOption.values();
                                    int length15 = values15.length;
                                    int i18 = 0;
                                    while (true) {
                                        if (i18 < length15) {
                                            TempWaveOption tempWaveOption12 = values15[i18];
                                            if (tempWaveOption12.getCode() == ((intValue$default.intValue() & 4) >> 2)) {
                                                tempWaveOption5 = tempWaveOption12;
                                            } else {
                                                i18++;
                                            }
                                        } else {
                                            tempWaveOption5 = null;
                                        }
                                    }
                                    if (tempWaveOption5 == null) {
                                        return null;
                                    }
                                    BleDataEntity bleDataEntity3 = bleDataEntity;
                                    return new DeviceModeEntity(deviceModeActionCode, deviceModeSettingTriggerCode3, deviceCoolingCode2, continuousOperationStatus2, (SwitchCoolHeatWaitStatus) null, coolHeatTypeCode3, (Temperature) null, (ModeCommonSettingOperation) null, (Integer) null, (TempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, myModeActionType, (MyModeSpecialSubMode) null, (Integer) null, (Integer) null, myModeOperationCode, (Integer) null, (MyModeTypeCode) null, (Integer) null, (TempBoostOption) null, tempWaveOption5, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, BleDataEntity.getIntValue$default(bleDataEntity3, 18, 9, (ByteOrder) null, 4, (Object) null), myTempStepCode, tempBoostOption5, (TempWaveOption) null, BleDataEntity.getIntValue$default(bleDataEntity3, 18, 11, (ByteOrder) null, 4, (Object) null), BleDataEntity.getIntValue$default(bleDataEntity3, 18, 13, (ByteOrder) null, 4, (Object) null), (FanStepCode) null, 2130149328, 36, (DefaultConstructorMarker) null);
                                }
                            }
                            if (bleDataEntity.getData() == null) {
                                return null;
                            }
                            MyModeTypeCode[] values16 = MyModeTypeCode.values();
                            int length16 = values16.length;
                            int i19 = 0;
                            while (true) {
                                if (i19 < length16) {
                                    MyModeTypeCode myModeTypeCode5 = values16[i19];
                                    int code10 = myModeTypeCode5.getCode();
                                    Integer intValue$default18 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 6, (ByteOrder) null, 4, (Object) null);
                                    if (intValue$default18 != null && code10 == intValue$default18.intValue()) {
                                        myModeTypeCode = myModeTypeCode5;
                                    } else {
                                        i19++;
                                    }
                                } else {
                                    myModeTypeCode = null;
                                }
                            }
                            if (myModeTypeCode == null) {
                                return null;
                            }
                            BleDataEntity bleDataEntity4 = bleDataEntity;
                            Integer intValue$default19 = BleDataEntity.getIntValue$default(bleDataEntity4, 17, 7, (ByteOrder) null, 4, (Object) null);
                            Integer intValue$default20 = BleDataEntity.getIntValue$default(bleDataEntity4, 17, 7, (ByteOrder) null, 4, (Object) null);
                            if (intValue$default20 != null) {
                                String binaryString = Integer.toBinaryString(intValue$default20.intValue());
                                Intrinsics.checkNotNullExpressionValue(binaryString, "toBinaryString(...)");
                                StringsKt.reversed((CharSequence) StringsKt.padStart(binaryString, 8, '0')).toString();
                                Unit unit56 = Unit.INSTANCE;
                                unit9 = Unit.INSTANCE;
                            } else {
                                unit9 = null;
                            }
                            if (unit9 == null) {
                                return null;
                            }
                            TempBoostOption[] values17 = TempBoostOption.values();
                            int length17 = values17.length;
                            int i20 = 0;
                            while (true) {
                                if (i20 < length17) {
                                    TempBoostOption tempBoostOption13 = values17[i20];
                                    if (tempBoostOption13.getCode() == (intValue$default20.intValue() & 3)) {
                                        tempBoostOption3 = tempBoostOption13;
                                    } else {
                                        i20++;
                                    }
                                } else {
                                    tempBoostOption3 = null;
                                }
                            }
                            if (tempBoostOption3 == null) {
                                return null;
                            }
                            TempWaveOption[] values18 = TempWaveOption.values();
                            int length18 = values18.length;
                            int i21 = 0;
                            while (true) {
                                if (i21 < length18) {
                                    TempWaveOption tempWaveOption13 = values18[i21];
                                    if (tempWaveOption13.getCode() == ((intValue$default20.intValue() & 4) >> 2)) {
                                        tempWaveOption3 = tempWaveOption13;
                                    } else {
                                        i21++;
                                    }
                                } else {
                                    tempWaveOption3 = null;
                                }
                            }
                            if (tempWaveOption3 == null) {
                                return null;
                            }
                            BleDataEntity bleDataEntity5 = bleDataEntity;
                            Integer intValue$default21 = BleDataEntity.getIntValue$default(bleDataEntity5, 17, 10, (ByteOrder) null, 4, (Object) null);
                            Integer intValue$default22 = BleDataEntity.getIntValue$default(bleDataEntity5, 17, 11, (ByteOrder) null, 4, (Object) null);
                            if (intValue$default22 == null) {
                                return null;
                            }
                            intValue$default22.intValue();
                            TempBoostOption[] values19 = TempBoostOption.values();
                            int length19 = values19.length;
                            int i22 = 0;
                            while (true) {
                                if (i22 < length19) {
                                    TempBoostOption tempBoostOption14 = values19[i22];
                                    if (tempBoostOption14.getCode() == (intValue$default22.intValue() & 3)) {
                                        tempBoostOption4 = tempBoostOption14;
                                    } else {
                                        i22++;
                                    }
                                } else {
                                    tempBoostOption4 = null;
                                }
                            }
                            if (tempBoostOption4 == null) {
                                return null;
                            }
                            TempWaveOption[] values20 = TempWaveOption.values();
                            int length20 = values20.length;
                            int i23 = 0;
                            while (true) {
                                if (i23 < length20) {
                                    TempWaveOption tempWaveOption14 = values20[i23];
                                    if (tempWaveOption14.getCode() == ((intValue$default22.intValue() & 4) >> 2)) {
                                        tempWaveOption4 = tempWaveOption14;
                                    } else {
                                        i23++;
                                    }
                                } else {
                                    tempWaveOption4 = null;
                                }
                            }
                            if (tempWaveOption4 == null) {
                                return null;
                            }
                            BleDataEntity bleDataEntity6 = bleDataEntity;
                            return new DeviceModeEntity(deviceModeActionCode, deviceModeSettingTriggerCode3, deviceCoolingCode2, continuousOperationStatus2, (SwitchCoolHeatWaitStatus) null, (CoolHeatTypeCode) null, (Temperature) null, (ModeCommonSettingOperation) null, (Integer) null, (TempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyModeActionType) null, (MyModeSpecialSubMode) null, (Integer) null, (Integer) null, myModeOperationCode, 1, myModeTypeCode, intValue$default19, tempBoostOption3, tempWaveOption3, BleDataEntity.getIntValue$default(bleDataEntity6, 18, 8, (ByteOrder) null, 4, (Object) null), intValue$default21, tempBoostOption4, tempWaveOption4, BleDataEntity.getIntValue$default(bleDataEntity6, 18, 12, (ByteOrder) null, 4, (Object) null), BleDataEntity.getIntValue$default(bleDataEntity6, 18, 14, (ByteOrder) null, 4, (Object) null), BleDataEntity.getIntValue$default(bleDataEntity6, 18, 16, (ByteOrder) null, 4, (Object) null), (MyTempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (FanStepCode) null, 524272, 63, (DefaultConstructorMarker) null);
                        } else if (i13 == 2) {
                            if (bleDataEntity.getData() != null) {
                                MyModeSpecialSubMode[] values21 = MyModeSpecialSubMode.values();
                                int length21 = values21.length;
                                int i24 = 0;
                                while (true) {
                                    if (i24 < length21) {
                                        myModeSpecialSubMode2 = values21[i24];
                                        int code11 = myModeSpecialSubMode2.getCode();
                                        Integer intValue$default23 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 4, (ByteOrder) null, 4, (Object) null);
                                        if (intValue$default23 == null || code11 != intValue$default23.intValue()) {
                                            i24++;
                                        }
                                    } else {
                                        myModeSpecialSubMode2 = null;
                                    }
                                }
                                if (myModeSpecialSubMode2 != null) {
                                    Unit unit57 = Unit.INSTANCE;
                                    unit11 = Unit.INSTANCE;
                                } else {
                                    unit11 = null;
                                    myModeSpecialSubMode2 = null;
                                }
                                if (unit11 == null) {
                                    return null;
                                }
                                Unit unit58 = Unit.INSTANCE;
                                Unit unit59 = Unit.INSTANCE;
                                myModeSpecialSubMode = myModeSpecialSubMode2;
                            } else {
                                myModeSpecialSubMode = null;
                            }
                            BleDataEntity bleDataEntity7 = bleDataEntity;
                            return new DeviceModeEntity(deviceModeActionCode, deviceModeSettingTriggerCode3, deviceCoolingCode2, continuousOperationStatus2, (SwitchCoolHeatWaitStatus) null, (CoolHeatTypeCode) null, (Temperature) null, (ModeCommonSettingOperation) null, (Integer) null, (TempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, myModeActionType, myModeSpecialSubMode, BleDataEntity.getIntValue$default(bleDataEntity7, 18, 5, (ByteOrder) null, 4, (Object) null), BleDataEntity.getIntValue$default(bleDataEntity7, 18, 7, (ByteOrder) null, 4, (Object) null), (MyModeOperationCode) null, (Integer) null, (MyModeTypeCode) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyTempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (FanStepCode) null, -491536, 63, (DefaultConstructorMarker) null);
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else if (i10 == 3) {
                        if (bleDataEntity.getData() != null) {
                            DeviceModeSettingTriggerCode[] values22 = DeviceModeSettingTriggerCode.values();
                            int length22 = values22.length;
                            int i25 = 0;
                            while (true) {
                                if (i25 < length22) {
                                    deviceModeSettingTriggerCode5 = values22[i25];
                                    int code12 = deviceModeSettingTriggerCode5.getCode();
                                    Integer intValue$default24 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 1, (ByteOrder) null, 4, (Object) null);
                                    if (intValue$default24 == null || code12 != intValue$default24.intValue()) {
                                        i25++;
                                    }
                                } else {
                                    deviceModeSettingTriggerCode5 = null;
                                }
                            }
                            if (deviceModeSettingTriggerCode5 != null) {
                                Unit unit60 = Unit.INSTANCE;
                                unit20 = Unit.INSTANCE;
                            } else {
                                unit20 = null;
                                deviceModeSettingTriggerCode5 = null;
                            }
                            if (unit20 == null) {
                                return null;
                            }
                            Unit unit61 = Unit.INSTANCE;
                            Unit unit62 = Unit.INSTANCE;
                        } else {
                            deviceModeSettingTriggerCode5 = null;
                        }
                        if (bleDataEntity.getData() != null) {
                            MyModeOperationCode[] values23 = MyModeOperationCode.values();
                            int length23 = values23.length;
                            int i26 = 0;
                            while (true) {
                                if (i26 < length23) {
                                    myModeOperationCode3 = values23[i26];
                                    int code13 = myModeOperationCode3.getCode();
                                    Integer intValue$default25 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 3, (ByteOrder) null, 4, (Object) null);
                                    if (intValue$default25 == null || code13 != intValue$default25.intValue()) {
                                        i26++;
                                    }
                                } else {
                                    myModeOperationCode3 = null;
                                }
                            }
                            if (myModeOperationCode3 != null) {
                                Unit unit63 = Unit.INSTANCE;
                                unit19 = Unit.INSTANCE;
                            } else {
                                unit19 = null;
                                myModeOperationCode3 = null;
                            }
                            if (unit19 == null) {
                                return null;
                            }
                            Unit unit64 = Unit.INSTANCE;
                            Unit unit65 = Unit.INSTANCE;
                            myModeOperationCode2 = myModeOperationCode3;
                        } else {
                            myModeOperationCode2 = null;
                        }
                        if (bleDataEntity.getData() != null) {
                            MyModeTypeCode[] values24 = MyModeTypeCode.values();
                            int length24 = values24.length;
                            int i27 = 0;
                            while (true) {
                                if (i27 < length24) {
                                    myModeTypeCode3 = values24[i27];
                                    int code14 = myModeTypeCode3.getCode();
                                    Integer intValue$default26 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 5, (ByteOrder) null, 4, (Object) null);
                                    if (intValue$default26 == null || code14 != intValue$default26.intValue()) {
                                        i27++;
                                    }
                                } else {
                                    myModeTypeCode3 = null;
                                }
                            }
                            if (myModeTypeCode3 != null) {
                                Unit unit66 = Unit.INSTANCE;
                                unit18 = Unit.INSTANCE;
                            } else {
                                unit18 = null;
                                myModeTypeCode3 = null;
                            }
                            if (unit18 == null) {
                                return null;
                            }
                            Unit unit67 = Unit.INSTANCE;
                            Unit unit68 = Unit.INSTANCE;
                            myModeTypeCode2 = myModeTypeCode3;
                        } else {
                            myModeTypeCode2 = null;
                        }
                        BleDataEntity bleDataEntity8 = bleDataEntity;
                        Integer intValue$default27 = BleDataEntity.getIntValue$default(bleDataEntity8, 17, 6, (ByteOrder) null, 4, (Object) null);
                        Integer intValue$default28 = BleDataEntity.getIntValue$default(bleDataEntity8, 17, 7, (ByteOrder) null, 4, (Object) null);
                        if (intValue$default28 != null) {
                            intValue$default28.intValue();
                            if (bleDataEntity.getData() != null) {
                                TempBoostOption[] values25 = TempBoostOption.values();
                                int length25 = values25.length;
                                int i28 = 0;
                                while (true) {
                                    if (i28 < length25) {
                                        tempBoostOption9 = values25[i28];
                                        if (tempBoostOption9.getCode() != (intValue$default28.intValue() & 3)) {
                                            i28++;
                                        }
                                    } else {
                                        tempBoostOption9 = null;
                                    }
                                }
                                if (tempBoostOption9 != null) {
                                    Unit unit69 = Unit.INSTANCE;
                                    unit17 = Unit.INSTANCE;
                                } else {
                                    unit17 = null;
                                    tempBoostOption9 = null;
                                }
                                if (unit17 == null) {
                                    return null;
                                }
                                Unit unit70 = Unit.INSTANCE;
                                Unit unit71 = Unit.INSTANCE;
                                tempBoostOption6 = tempBoostOption9;
                            } else {
                                tempBoostOption6 = null;
                            }
                            if (bleDataEntity.getData() != null) {
                                TempWaveOption[] values26 = TempWaveOption.values();
                                int length26 = values26.length;
                                int i29 = 0;
                                while (true) {
                                    if (i29 < length26) {
                                        tempWaveOption9 = values26[i29];
                                        if (tempWaveOption9.getCode() != ((intValue$default28.intValue() & 4) >> 2)) {
                                            i29++;
                                        }
                                    } else {
                                        tempWaveOption9 = null;
                                    }
                                }
                                if (tempWaveOption9 != null) {
                                    Unit unit72 = Unit.INSTANCE;
                                    unit16 = Unit.INSTANCE;
                                } else {
                                    unit16 = null;
                                    tempWaveOption9 = null;
                                }
                                if (unit16 == null) {
                                    return null;
                                }
                                Unit unit73 = Unit.INSTANCE;
                                Unit unit74 = Unit.INSTANCE;
                                tempWaveOption6 = tempWaveOption9;
                            } else {
                                tempWaveOption6 = null;
                            }
                            BleDataEntity bleDataEntity9 = bleDataEntity;
                            Integer intValue$default29 = BleDataEntity.getIntValue$default(bleDataEntity9, 17, 10, (ByteOrder) null, 4, (Object) null);
                            Integer intValue$default30 = BleDataEntity.getIntValue$default(bleDataEntity9, 17, 11, (ByteOrder) null, 4, (Object) null);
                            if (intValue$default30 != null) {
                                intValue$default30.intValue();
                                if (bleDataEntity.getData() != null) {
                                    TempBoostOption[] values27 = TempBoostOption.values();
                                    int length27 = values27.length;
                                    int i30 = 0;
                                    while (true) {
                                        if (i30 < length27) {
                                            tempBoostOption8 = values27[i30];
                                            if (tempBoostOption8.getCode() != (intValue$default30.intValue() & 3)) {
                                                i30++;
                                            }
                                        } else {
                                            tempBoostOption8 = null;
                                        }
                                    }
                                    if (tempBoostOption8 != null) {
                                        Unit unit75 = Unit.INSTANCE;
                                        unit15 = Unit.INSTANCE;
                                    } else {
                                        unit15 = null;
                                        tempBoostOption8 = null;
                                    }
                                    if (unit15 == null) {
                                        return null;
                                    }
                                    Unit unit76 = Unit.INSTANCE;
                                    Unit unit77 = Unit.INSTANCE;
                                    tempBoostOption7 = tempBoostOption8;
                                } else {
                                    tempBoostOption7 = null;
                                }
                                if (bleDataEntity.getData() != null) {
                                    TempWaveOption[] values28 = TempWaveOption.values();
                                    int length28 = values28.length;
                                    int i31 = 0;
                                    while (true) {
                                        if (i31 < length28) {
                                            tempWaveOption8 = values28[i31];
                                            if (tempWaveOption8.getCode() != ((intValue$default30.intValue() & 4) >> 2)) {
                                                i31++;
                                            }
                                        } else {
                                            tempWaveOption8 = null;
                                        }
                                    }
                                    if (tempWaveOption8 != null) {
                                        Unit unit78 = Unit.INSTANCE;
                                        unit14 = Unit.INSTANCE;
                                    } else {
                                        unit14 = null;
                                        tempWaveOption8 = null;
                                    }
                                    if (unit14 == null) {
                                        return null;
                                    }
                                    Unit unit79 = Unit.INSTANCE;
                                    Unit unit80 = Unit.INSTANCE;
                                    tempWaveOption7 = tempWaveOption8;
                                } else {
                                    tempWaveOption7 = null;
                                }
                                BleDataEntity bleDataEntity10 = bleDataEntity;
                                return new DeviceModeEntity(deviceModeActionCode, deviceModeSettingTriggerCode5, deviceCoolingCode2, continuousOperationStatus2, (SwitchCoolHeatWaitStatus) null, (CoolHeatTypeCode) null, (Temperature) null, (ModeCommonSettingOperation) null, (Integer) null, (TempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyModeActionType) null, (MyModeSpecialSubMode) null, (Integer) null, (Integer) null, myModeOperationCode2, 1, myModeTypeCode2, intValue$default27, tempBoostOption6, tempWaveOption6, BleDataEntity.getIntValue$default(bleDataEntity10, 18, 8, (ByteOrder) null, 4, (Object) null), intValue$default29, tempBoostOption7, tempWaveOption7, BleDataEntity.getIntValue$default(bleDataEntity10, 18, 12, (ByteOrder) null, 4, (Object) null), BleDataEntity.getIntValue$default(bleDataEntity10, 18, 14, (ByteOrder) null, 4, (Object) null), BleDataEntity.getIntValue$default(bleDataEntity10, 18, 16, (ByteOrder) null, 4, (Object) null), (MyTempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (FanStepCode) null, 524272, 63, (DefaultConstructorMarker) null);
                            }
                        }
                        return null;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                case 4:
                    if (bleDataEntity.getAction() != BleActionCode.NOTIFY) {
                        DebugLogUtil.INSTANCE.e("read or write not enable");
                        return null;
                    } else if (bleDataEntity.getData() == null) {
                        return null;
                    } else {
                        DeviceModeSettingTriggerCode[] values29 = DeviceModeSettingTriggerCode.values();
                        int length29 = values29.length;
                        int i32 = 0;
                        while (true) {
                            if (i32 < length29) {
                                DeviceModeSettingTriggerCode deviceModeSettingTriggerCode12 = values29[i32];
                                int code15 = deviceModeSettingTriggerCode12.getCode();
                                int i33 = i32;
                                int i34 = length29;
                                Integer intValue$default31 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 1, (ByteOrder) null, 4, (Object) null);
                                if (intValue$default31 != null && code15 == intValue$default31.intValue()) {
                                    deviceModeSettingTriggerCode6 = deviceModeSettingTriggerCode12;
                                } else {
                                    i32 = i33 + 1;
                                    length29 = i34;
                                }
                            } else {
                                deviceModeSettingTriggerCode6 = null;
                            }
                        }
                        if (deviceModeSettingTriggerCode6 == null) {
                            return null;
                        }
                        MyModeOperationCode[] values30 = MyModeOperationCode.values();
                        int length30 = values30.length;
                        int i35 = 0;
                        while (true) {
                            if (i35 < length30) {
                                MyModeOperationCode myModeOperationCode5 = values30[i35];
                                int code16 = myModeOperationCode5.getCode();
                                int i36 = i35;
                                int i37 = length30;
                                Integer intValue$default32 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 3, (ByteOrder) null, 4, (Object) null);
                                if (intValue$default32 != null && code16 == intValue$default32.intValue()) {
                                    myModeOperationCode4 = myModeOperationCode5;
                                } else {
                                    i35 = i36 + 1;
                                    length30 = i37;
                                }
                            } else {
                                myModeOperationCode4 = null;
                            }
                        }
                        if (myModeOperationCode4 == null) {
                            return null;
                        }
                        MyModeTypeCode[] values31 = MyModeTypeCode.values();
                        int length31 = values31.length;
                        int i38 = 0;
                        while (true) {
                            if (i38 < length31) {
                                MyModeTypeCode myModeTypeCode6 = values31[i38];
                                int code17 = myModeTypeCode6.getCode();
                                int i39 = i38;
                                Integer intValue$default33 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 5, (ByteOrder) null, 4, (Object) null);
                                if (intValue$default33 != null && code17 == intValue$default33.intValue()) {
                                    myModeTypeCode4 = myModeTypeCode6;
                                } else {
                                    i38 = i39 + 1;
                                }
                            } else {
                                myModeTypeCode4 = null;
                            }
                        }
                        if (myModeTypeCode4 == null) {
                            return null;
                        }
                        BleDataEntity bleDataEntity11 = bleDataEntity;
                        Integer intValue$default34 = BleDataEntity.getIntValue$default(bleDataEntity11, 17, 6, (ByteOrder) null, 4, (Object) null);
                        Integer intValue$default35 = BleDataEntity.getIntValue$default(bleDataEntity11, 17, 7, (ByteOrder) null, 4, (Object) null);
                        if (intValue$default35 == null) {
                            return null;
                        }
                        intValue$default35.intValue();
                        TempBoostOption[] values32 = TempBoostOption.values();
                        int length32 = values32.length;
                        int i40 = 0;
                        while (true) {
                            if (i40 < length32) {
                                TempBoostOption tempBoostOption15 = values32[i40];
                                if (tempBoostOption15.getCode() == (intValue$default35.intValue() & 3)) {
                                    tempBoostOption10 = tempBoostOption15;
                                } else {
                                    i40++;
                                }
                            } else {
                                tempBoostOption10 = null;
                            }
                        }
                        if (tempBoostOption10 == null) {
                            return null;
                        }
                        TempWaveOption[] values33 = TempWaveOption.values();
                        int length33 = values33.length;
                        int i41 = 0;
                        while (true) {
                            if (i41 < length33) {
                                TempWaveOption tempWaveOption15 = values33[i41];
                                if (tempWaveOption15.getCode() == ((intValue$default35.intValue() & 4) >> 2)) {
                                    tempWaveOption10 = tempWaveOption15;
                                } else {
                                    i41++;
                                }
                            } else {
                                tempWaveOption10 = null;
                            }
                        }
                        if (tempWaveOption10 == null) {
                            return null;
                        }
                        BleDataEntity bleDataEntity12 = bleDataEntity;
                        Integer intValue$default36 = BleDataEntity.getIntValue$default(bleDataEntity12, 17, 10, (ByteOrder) null, 4, (Object) null);
                        Integer intValue$default37 = BleDataEntity.getIntValue$default(bleDataEntity12, 17, 11, (ByteOrder) null, 4, (Object) null);
                        if (intValue$default37 != null) {
                            String binaryString2 = Integer.toBinaryString(intValue$default37.intValue());
                            Intrinsics.checkNotNullExpressionValue(binaryString2, "toBinaryString(...)");
                            StringsKt.reversed((CharSequence) StringsKt.padStart(binaryString2, 8, '0')).toString();
                            Unit unit81 = Unit.INSTANCE;
                            unit21 = Unit.INSTANCE;
                        } else {
                            unit21 = null;
                        }
                        if (unit21 == null) {
                            return null;
                        }
                        TempBoostOption[] values34 = TempBoostOption.values();
                        int length34 = values34.length;
                        int i42 = 0;
                        while (true) {
                            if (i42 < length34) {
                                TempBoostOption tempBoostOption16 = values34[i42];
                                if (tempBoostOption16.getCode() == (intValue$default37.intValue() & 3)) {
                                    tempBoostOption11 = tempBoostOption16;
                                } else {
                                    i42++;
                                }
                            } else {
                                tempBoostOption11 = null;
                            }
                        }
                        if (tempBoostOption11 == null) {
                            return null;
                        }
                        TempWaveOption[] values35 = TempWaveOption.values();
                        int length35 = values35.length;
                        int i43 = 0;
                        while (true) {
                            if (i43 < length35) {
                                TempWaveOption tempWaveOption16 = values35[i43];
                                if (tempWaveOption16.getCode() == ((intValue$default37.intValue() & 4) >> 2)) {
                                    tempWaveOption11 = tempWaveOption16;
                                } else {
                                    i43++;
                                }
                            } else {
                                tempWaveOption11 = null;
                            }
                        }
                        if (tempWaveOption11 == null) {
                            return null;
                        }
                        BleDataEntity bleDataEntity13 = bleDataEntity;
                        return new DeviceModeEntity(deviceModeActionCode, deviceModeSettingTriggerCode6, deviceCoolingCode2, continuousOperationStatus2, (SwitchCoolHeatWaitStatus) null, (CoolHeatTypeCode) null, (Temperature) null, (ModeCommonSettingOperation) null, (Integer) null, (TempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyModeActionType) null, (MyModeSpecialSubMode) null, (Integer) null, (Integer) null, myModeOperationCode4, BleDataEntity.getIntValue$default(bleDataEntity13, 17, 4, (ByteOrder) null, 4, (Object) null), myModeTypeCode4, intValue$default34, tempBoostOption10, tempWaveOption10, BleDataEntity.getIntValue$default(bleDataEntity13, 18, 8, (ByteOrder) null, 4, (Object) null), intValue$default36, tempBoostOption11, tempWaveOption11, BleDataEntity.getIntValue$default(bleDataEntity13, 18, 12, (ByteOrder) null, 4, (Object) null), BleDataEntity.getIntValue$default(bleDataEntity13, 18, 14, (ByteOrder) null, 4, (Object) null), BleDataEntity.getIntValue$default(bleDataEntity13, 18, 16, (ByteOrder) null, 4, (Object) null), (MyTempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (FanStepCode) null, 524272, 63, (DefaultConstructorMarker) null);
                    }
                case 5:
                    if (bleDataEntity.getData() == null) {
                        return null;
                    }
                    Integer intValue$default38 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 1, (ByteOrder) null, 4, (Object) null);
                    if (intValue$default38 != null) {
                        int intValue2 = intValue$default38.intValue();
                        DeviceModeSettingTriggerCode[] values36 = DeviceModeSettingTriggerCode.values();
                        int length36 = values36.length;
                        int i44 = 0;
                        while (true) {
                            if (i44 < length36) {
                                deviceModeSettingTriggerCode8 = values36[i44];
                                if (deviceModeSettingTriggerCode8.getCode() != intValue2) {
                                    i44++;
                                }
                            } else {
                                deviceModeSettingTriggerCode8 = null;
                            }
                        }
                        deviceModeSettingTriggerCode7 = deviceModeSettingTriggerCode8;
                    } else {
                        deviceModeSettingTriggerCode7 = null;
                    }
                    Integer intValue$default39 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 3, (ByteOrder) null, 4, (Object) null);
                    if (intValue$default39 != null) {
                        int intValue3 = intValue$default39.intValue();
                        int i45 = intValue3 & 15;
                        TemperatureOnOffCode[] values37 = TemperatureOnOffCode.values();
                        int length37 = values37.length;
                        int i46 = 0;
                        while (true) {
                            if (i46 < length37) {
                                temperatureOnOffCode = values37[i46];
                                if (temperatureOnOffCode.getCode() != i45) {
                                    i46++;
                                }
                            } else {
                                temperatureOnOffCode = null;
                            }
                        }
                        TemperatureOnOffCode temperatureOnOffCode2 = temperatureOnOffCode;
                        if (temperatureOnOffCode2 == null) {
                            return null;
                        }
                        int i47 = (intValue3 & 48) >> 4;
                        TemperatureCoolHeatTypeCode[] values38 = TemperatureCoolHeatTypeCode.values();
                        int length38 = values38.length;
                        int i48 = 0;
                        while (true) {
                            if (i48 < length38) {
                                temperatureCoolHeatTypeCode = values38[i48];
                                if (temperatureCoolHeatTypeCode.getCode() != i47) {
                                    i48++;
                                }
                            } else {
                                temperatureCoolHeatTypeCode = null;
                            }
                        }
                        TemperatureCoolHeatTypeCode temperatureCoolHeatTypeCode2 = temperatureCoolHeatTypeCode;
                        if (temperatureCoolHeatTypeCode2 == null) {
                            return null;
                        }
                        int i49 = (intValue3 & 64) >> 6;
                        CoolBoost[] values39 = CoolBoost.values();
                        int length39 = values39.length;
                        int i50 = 0;
                        while (true) {
                            if (i50 < length39) {
                                coolBoost = values39[i50];
                                if (coolBoost.getCode() != i49) {
                                    i50++;
                                }
                            } else {
                                coolBoost = null;
                            }
                        }
                        CoolBoost coolBoost2 = coolBoost;
                        if (!(coolBoost2 == null || (intValue$default2 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 4, (ByteOrder) null, 4, (Object) null)) == null)) {
                            int intValue4 = intValue$default2.intValue() & 15;
                            CurrentCoolHeatTypeCode[] values40 = CurrentCoolHeatTypeCode.values();
                            int length40 = values40.length;
                            int i51 = 0;
                            while (true) {
                                if (i51 < length40) {
                                    currentCoolHeatTypeCode = values40[i51];
                                    if (currentCoolHeatTypeCode.getCode() != intValue4) {
                                        i51++;
                                    }
                                } else {
                                    currentCoolHeatTypeCode = null;
                                }
                            }
                            CurrentCoolHeatTypeCode currentCoolHeatTypeCode2 = currentCoolHeatTypeCode;
                            if (currentCoolHeatTypeCode2 == null) {
                                return null;
                            }
                            int intValue5 = (intValue$default2.intValue() & 16) >> 4;
                            TagFuncLimit[] values41 = TagFuncLimit.values();
                            int length41 = values41.length;
                            int i52 = 0;
                            while (true) {
                                if (i52 < length41) {
                                    tagFuncLimit = values41[i52];
                                    if (tagFuncLimit.getCode() != intValue5) {
                                        i52++;
                                    }
                                } else {
                                    tagFuncLimit = null;
                                }
                            }
                            TagFuncLimit tagFuncLimit2 = tagFuncLimit;
                            if (tagFuncLimit2 == null) {
                                return null;
                            }
                            int intValue6 = (intValue$default2.intValue() & 32) >> 5;
                            SwitchingTrigger1[] values42 = SwitchingTrigger1.values();
                            int length42 = values42.length;
                            int i53 = 0;
                            while (true) {
                                if (i53 < length42) {
                                    switchingTrigger1 = values42[i53];
                                    if (switchingTrigger1.getCode() != intValue6) {
                                        i53++;
                                    }
                                } else {
                                    switchingTrigger1 = null;
                                }
                            }
                            SwitchingTrigger1 switchingTrigger12 = switchingTrigger1;
                            if (switchingTrigger12 == null) {
                                return null;
                            }
                            int intValue7 = (intValue$default2.intValue() & 64) >> 6;
                            SwitchingTrigger2[] values43 = SwitchingTrigger2.values();
                            int length43 = values43.length;
                            int i54 = 0;
                            while (true) {
                                if (i54 < length43) {
                                    switchingTrigger2 = values43[i54];
                                    if (switchingTrigger2.getCode() != intValue7) {
                                        i54++;
                                    }
                                } else {
                                    switchingTrigger2 = null;
                                }
                            }
                            SwitchingTrigger2 switchingTrigger22 = switchingTrigger2;
                            if (switchingTrigger22 == null) {
                                return null;
                            }
                            int intValue8 = (intValue$default2.intValue() & 128) >> 7;
                            BoostStatus[] values44 = BoostStatus.values();
                            int length44 = values44.length;
                            int i55 = 0;
                            while (true) {
                                if (i55 < length44) {
                                    boostStatus = values44[i55];
                                    if (boostStatus.getCode() != intValue8) {
                                        i55++;
                                    }
                                } else {
                                    boostStatus = null;
                                }
                            }
                            BoostStatus boostStatus2 = boostStatus;
                            if (!(boostStatus2 == null || (intValue$default3 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 5, (ByteOrder) null, 4, (Object) null)) == null)) {
                                int intValue9 = intValue$default3.intValue() & 3;
                                TargetTempControlStatus[] values45 = TargetTempControlStatus.values();
                                int length45 = values45.length;
                                int i56 = 0;
                                while (true) {
                                    if (i56 < length45) {
                                        targetTempControlStatus = values45[i56];
                                        if (targetTempControlStatus.getCode() != intValue9) {
                                            i56++;
                                        }
                                    } else {
                                        targetTempControlStatus = null;
                                    }
                                }
                                TargetTempControlStatus targetTempControlStatus2 = targetTempControlStatus;
                                if (targetTempControlStatus2 == null) {
                                    return null;
                                }
                                int intValue10 = (intValue$default3.intValue() & 4) >> 2;
                                TargetTempControlFactorALS[] values46 = TargetTempControlFactorALS.values();
                                int length46 = values46.length;
                                int i57 = 0;
                                while (true) {
                                    if (i57 < length46) {
                                        targetTempControlFactorALS = values46[i57];
                                        if (targetTempControlFactorALS.getCode() != intValue10) {
                                            i57++;
                                        }
                                    } else {
                                        targetTempControlFactorALS = null;
                                    }
                                }
                                TargetTempControlFactorALS targetTempControlFactorALS2 = targetTempControlFactorALS;
                                if (targetTempControlFactorALS2 == null) {
                                    return null;
                                }
                                int intValue11 = (intValue$default3.intValue() & 8) >> 3;
                                TargetTempControlFactorEnvironment[] values47 = TargetTempControlFactorEnvironment.values();
                                int length47 = values47.length;
                                int i58 = 0;
                                while (true) {
                                    if (i58 < length47) {
                                        targetTempControlFactorEnvironment = values47[i58];
                                        if (targetTempControlFactorEnvironment.getCode() != intValue11) {
                                            i58++;
                                        }
                                    } else {
                                        targetTempControlFactorEnvironment = null;
                                    }
                                }
                                TargetTempControlFactorEnvironment targetTempControlFactorEnvironment2 = targetTempControlFactorEnvironment;
                                if (targetTempControlFactorEnvironment2 == null) {
                                    return null;
                                }
                                int intValue12 = (intValue$default3.intValue() & 16) >> 4;
                                TargetTempControlFactorClothesTemp[] values48 = TargetTempControlFactorClothesTemp.values();
                                int length48 = values48.length;
                                int i59 = 0;
                                while (true) {
                                    if (i59 < length48) {
                                        targetTempControlFactorClothesTemp = values48[i59];
                                        if (targetTempControlFactorClothesTemp.getCode() != intValue12) {
                                            i59++;
                                        }
                                    } else {
                                        targetTempControlFactorClothesTemp = null;
                                    }
                                }
                                TargetTempControlFactorClothesTemp targetTempControlFactorClothesTemp2 = targetTempControlFactorClothesTemp;
                                if (targetTempControlFactorClothesTemp2 == null) {
                                    return null;
                                }
                                int intValue13 = (intValue$default3.intValue() & 32) >> 5;
                                TargetTempControlFactorAction[] values49 = TargetTempControlFactorAction.values();
                                int length49 = values49.length;
                                int i60 = 0;
                                while (true) {
                                    if (i60 < length49) {
                                        targetTempControlFactorAction = values49[i60];
                                        if (targetTempControlFactorAction.getCode() != intValue13) {
                                            i60++;
                                        }
                                    } else {
                                        targetTempControlFactorAction = null;
                                    }
                                }
                                TargetTempControlFactorAction targetTempControlFactorAction2 = targetTempControlFactorAction;
                                if (targetTempControlFactorAction2 == null) {
                                    return null;
                                }
                                int intValue14 = (intValue$default3.intValue() & 64) >> 6;
                                TargetTempControlFactorBoost[] values50 = TargetTempControlFactorBoost.values();
                                int length50 = values50.length;
                                int i61 = 0;
                                while (true) {
                                    if (i61 < length50) {
                                        targetTempControlFactorBoost = values50[i61];
                                        if (targetTempControlFactorBoost.getCode() != intValue14) {
                                            i61++;
                                        }
                                    } else {
                                        targetTempControlFactorBoost = null;
                                    }
                                }
                                TargetTempControlFactorBoost targetTempControlFactorBoost2 = targetTempControlFactorBoost;
                                if (!(targetTempControlFactorBoost2 == null || (intValue$default4 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 6, (ByteOrder) null, 4, (Object) null)) == null)) {
                                    int intValue15 = intValue$default4.intValue() & 15;
                                    SmartModePreference[] values51 = SmartModePreference.values();
                                    int length51 = values51.length;
                                    int i62 = 0;
                                    while (true) {
                                        if (i62 < length51) {
                                            smartModePreference = values51[i62];
                                            if (smartModePreference.getCode() != intValue15) {
                                                i62++;
                                            }
                                        } else {
                                            smartModePreference = null;
                                        }
                                    }
                                    SmartModePreference smartModePreference3 = smartModePreference;
                                    if (smartModePreference3 == null) {
                                        return null;
                                    }
                                    int intValue16 = (intValue$default4.intValue() & 240) >> 4;
                                    SmartModePreference[] values52 = SmartModePreference.values();
                                    int length52 = values52.length;
                                    int i63 = 0;
                                    while (true) {
                                        if (i63 < length52) {
                                            smartModePreference2 = values52[i63];
                                            if (smartModePreference2.getCode() != intValue16) {
                                                i63++;
                                            }
                                        } else {
                                            smartModePreference2 = null;
                                        }
                                    }
                                    SmartModePreference smartModePreference4 = smartModePreference2;
                                    if (!(smartModePreference4 == null || (intValue$default5 = BleDataEntity.getIntValue$default(bleDataEntity, 34, 7, (ByteOrder) null, 4, (Object) null)) == null)) {
                                        int intValue17 = intValue$default5.intValue();
                                        Integer intValue$default40 = BleDataEntity.getIntValue$default(bleDataEntity, 34, 9, (ByteOrder) null, 4, (Object) null);
                                        if (intValue$default40 != null) {
                                            int intValue18 = intValue$default40.intValue();
                                            Integer intValue$default41 = BleDataEntity.getIntValue$default(bleDataEntity, 34, 11, (ByteOrder) null, 4, (Object) null);
                                            if (intValue$default41 != null) {
                                                intValue$default41.intValue();
                                                Integer intValue$default42 = BleDataEntity.getIntValue$default(bleDataEntity, 33, 13, (ByteOrder) null, 4, (Object) null);
                                                if (intValue$default42 != null) {
                                                    intValue$default42.intValue();
                                                    Integer intValue$default43 = BleDataEntity.getIntValue$default(bleDataEntity, 33, 14, (ByteOrder) null, 4, (Object) null);
                                                    if (intValue$default43 != null) {
                                                        intValue$default43.intValue();
                                                        Integer intValue$default44 = BleDataEntity.getIntValue$default(bleDataEntity, 18, 15, (ByteOrder) null, 4, (Object) null);
                                                        if (intValue$default44 != null) {
                                                            intValue$default44.intValue();
                                                            Integer intValue$default45 = BleDataEntity.getIntValue$default(bleDataEntity, 18, 17, (ByteOrder) null, 4, (Object) null);
                                                            if (intValue$default45 != null) {
                                                                intValue$default45.intValue();
                                                                Integer intValue$default46 = BleDataEntity.getIntValue$default(bleDataEntity, 33, 19, (ByteOrder) null, 4, (Object) null);
                                                                if (intValue$default46 != null) {
                                                                    intValue$default46.intValue();
                                                                    Temperature temperature = r21;
                                                                    Temperature temperature2 = new Temperature(temperatureOnOffCode2, temperatureCoolHeatTypeCode2, coolBoost2, currentCoolHeatTypeCode2, tagFuncLimit2, switchingTrigger12, switchingTrigger22, boostStatus2, targetTempControlStatus2, targetTempControlFactorALS2, targetTempControlFactorEnvironment2, targetTempControlFactorClothesTemp2, targetTempControlFactorAction2, targetTempControlFactorBoost2, smartModePreference3, smartModePreference4, intValue17, intValue18, intValue$default41, intValue$default42, intValue$default43, intValue$default44, intValue$default45, intValue$default46);
                                                                    return new DeviceModeEntity(deviceModeActionCode, deviceModeSettingTriggerCode7, deviceCoolingCode2, continuousOperationStatus2, switchCoolHeatWaitStatus, (CoolHeatTypeCode) null, temperature, (ModeCommonSettingOperation) null, (Integer) null, (TempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyModeActionType) null, (MyModeSpecialSubMode) null, (Integer) null, (Integer) null, (MyModeOperationCode) null, (Integer) null, (MyModeTypeCode) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyTempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (FanStepCode) null, -96, 63, (DefaultConstructorMarker) null);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return null;
                case 6:
                    if (bleDataEntity.getData() != null) {
                        DeviceModeSettingTriggerCode[] values53 = DeviceModeSettingTriggerCode.values();
                        int length53 = values53.length;
                        int i64 = 0;
                        while (true) {
                            if (i64 < length53) {
                                deviceModeSettingTriggerCode10 = values53[i64];
                                int code18 = deviceModeSettingTriggerCode10.getCode();
                                Integer intValue$default47 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 1, (ByteOrder) null, 4, (Object) null);
                                if (intValue$default47 == null || code18 != intValue$default47.intValue()) {
                                    i64++;
                                }
                            } else {
                                deviceModeSettingTriggerCode10 = null;
                            }
                        }
                        if (deviceModeSettingTriggerCode10 != null) {
                            Unit unit82 = Unit.INSTANCE;
                            unit23 = Unit.INSTANCE;
                        } else {
                            unit23 = null;
                            deviceModeSettingTriggerCode10 = null;
                        }
                        if (unit23 == null) {
                            return null;
                        }
                        Unit unit83 = Unit.INSTANCE;
                        Unit unit84 = Unit.INSTANCE;
                        deviceModeSettingTriggerCode9 = deviceModeSettingTriggerCode10;
                    } else {
                        deviceModeSettingTriggerCode9 = null;
                    }
                    if (bleDataEntity.getData() != null) {
                        FanStepCode[] values54 = FanStepCode.values();
                        int length54 = values54.length;
                        int i65 = 0;
                        while (true) {
                            if (i65 < length54) {
                                fanStepCode2 = values54[i65];
                                int code19 = fanStepCode2.getCode();
                                Integer intValue$default48 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 3, (ByteOrder) null, 4, (Object) null);
                                if (intValue$default48 == null || code19 != intValue$default48.intValue()) {
                                    i65++;
                                }
                            } else {
                                fanStepCode2 = null;
                            }
                        }
                        if (fanStepCode2 != null) {
                            Unit unit85 = Unit.INSTANCE;
                            unit22 = Unit.INSTANCE;
                        } else {
                            unit22 = null;
                            fanStepCode2 = null;
                        }
                        if (unit22 == null) {
                            return null;
                        }
                        Unit unit86 = Unit.INSTANCE;
                        Unit unit87 = Unit.INSTANCE;
                        fanStepCode = fanStepCode2;
                    } else {
                        fanStepCode = null;
                    }
                    return new DeviceModeEntity(deviceModeActionCode, deviceModeSettingTriggerCode9, deviceCoolingCode2, continuousOperationStatus2, (SwitchCoolHeatWaitStatus) null, (CoolHeatTypeCode) null, (Temperature) null, (ModeCommonSettingOperation) null, (Integer) null, (TempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyModeActionType) null, (MyModeSpecialSubMode) null, (Integer) null, (Integer) null, (MyModeOperationCode) null, (Integer) null, (MyModeTypeCode) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyTempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, fanStepCode, -16, 31, (DefaultConstructorMarker) null);
                case 7:
                    if (bleDataEntity.getData() != null) {
                        Iterator it2 = DeviceModeSettingTriggerCode.getEntries().iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                obj2 = it2.next();
                                int code20 = ((DeviceModeSettingTriggerCode) obj2).getCode();
                                Integer intValue$default49 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 1, (ByteOrder) null, 4, (Object) null);
                                if (intValue$default49 != null && code20 == intValue$default49.intValue()) {
                                }
                            } else {
                                obj2 = null;
                            }
                        }
                        DeviceModeSettingTriggerCode deviceModeSettingTriggerCode13 = (DeviceModeSettingTriggerCode) obj2;
                        if (deviceModeSettingTriggerCode13 != null) {
                            Unit unit88 = Unit.INSTANCE;
                            unit24 = Unit.INSTANCE;
                        } else {
                            unit24 = null;
                            deviceModeSettingTriggerCode13 = null;
                        }
                        if (unit24 == null) {
                            return null;
                        }
                        Unit unit89 = Unit.INSTANCE;
                        Unit unit90 = Unit.INSTANCE;
                        deviceModeSettingTriggerCode11 = deviceModeSettingTriggerCode13;
                    } else {
                        deviceModeSettingTriggerCode11 = null;
                    }
                    return new DeviceModeEntity(deviceModeActionCode, deviceModeSettingTriggerCode11, (DeviceCoolingCode) null, (ContinuousOperationStatus) null, (SwitchCoolHeatWaitStatus) null, (CoolHeatTypeCode) null, (Temperature) null, (ModeCommonSettingOperation) null, (Integer) null, (TempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyModeActionType) null, (MyModeSpecialSubMode) null, (Integer) null, (Integer) null, (MyModeOperationCode) null, (Integer) null, (MyModeTypeCode) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyTempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (FanStepCode) null, -4, 63, (DefaultConstructorMarker) null);
                default:
                    return null;
            }
        }
    }
}
