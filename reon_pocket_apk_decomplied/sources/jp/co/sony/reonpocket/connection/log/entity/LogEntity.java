package jp.co.sony.reonpocket.connection.log.entity;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.nio.ByteOrder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import jp.co.sony.reonpocket.connection.log.BGLogManager;
import jp.co.sony.reonpocket.connection.log.constant.CoolHeatStatusCode;
import jp.co.sony.reonpocket.connection.log.constant.LogTypeCode;
import jp.co.sony.reonpocket.connection.log.job.ReadLogJobTask;
import jp.co.sony.reonpocket.constant.BleActionCode;
import jp.co.sony.reonpocket.constant.ResponseCode;
import jp.co.sony.reonpocket.constant.UpdateVersionConstant;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

@Metadata(d1 = {"\u0000#\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0003\bú\u0001\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0002BÝ\u0005\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010AJ\n\u0010¾\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010¿\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010À\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Á\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Â\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ã\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ä\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Å\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Æ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ç\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010È\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010É\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010Ê\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ë\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ì\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Í\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Î\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ï\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ð\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ò\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ó\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010Ô\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010Õ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ö\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010×\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ø\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ù\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ú\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Û\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ü\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ý\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Þ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010ß\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010à\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010á\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010â\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ã\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ä\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010å\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010æ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ç\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010è\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010é\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ê\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ë\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ì\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010í\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010î\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ï\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ð\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ñ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ò\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ó\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ô\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010õ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ö\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010÷\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ø\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ù\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ú\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010û\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jê\u0005\u0010ü\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0016\u0010ý\u0001\u001a\u00030þ\u00012\t\u0010ÿ\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000b\u0010\u0002\u001a\u00030\u0002HÖ\u0001J\n\u0010\u0002\u001a\u00020\u0003HÖ\u0001R\u001c\u0010-\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0013\u00102\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u0010CR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010C\"\u0004\bH\u0010ER\u001c\u0010 \u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010C\"\u0004\bJ\u0010ER\u001c\u0010'\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010C\"\u0004\bL\u0010ER\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010C\"\u0004\bN\u0010ER\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010C\"\u0004\bP\u0010ER\u001c\u0010+\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010C\"\u0004\bR\u0010ER\u001c\u0010&\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010C\"\u0004\bT\u0010ER\u001c\u0010$\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010C\"\u0004\bV\u0010ER\u001c\u0010%\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010C\"\u0004\bX\u0010ER\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010C\"\u0004\bZ\u0010ER\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010C\"\u0004\b\\\u0010ER\u001c\u0010>\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010C\"\u0004\b^\u0010ER\u001c\u0010=\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010C\"\u0004\b`\u0010ER\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010C\"\u0004\bb\u0010ER\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010C\"\u0004\bd\u0010ER\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010C\"\u0004\bf\u0010ER\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010C\"\u0004\bh\u0010ER\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010C\"\u0004\bj\u0010ER\u001c\u0010*\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010C\"\u0004\bl\u0010ER\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010C\"\u0004\bn\u0010ER\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010C\"\u0004\bp\u0010ER\u001c\u0010#\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010C\"\u0004\br\u0010ER\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010C\"\u0004\bt\u0010ER\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010C\"\u0004\bv\u0010ER\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010C\"\u0004\bx\u0010ER\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010C\"\u0004\bz\u0010ER\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010C\"\u0004\b|\u0010ER\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010C\"\u0004\b~\u0010ER\u001d\u00101\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u0010C\"\u0005\b\u0001\u0010ER\u001e\u0010/\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010C\"\u0005\b\u0001\u0010ER\u001e\u00100\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010C\"\u0005\b\u0001\u0010ER\u0014\u0010.\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010CR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010C\"\u0005\b\u0001\u0010ER\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010C\"\u0005\b\u0001\u0010ER\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010C\"\u0005\b\u0001\u0010ER\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010C\"\u0005\b\u0001\u0010ER\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010C\"\u0005\b\u0001\u0010ER\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010C\"\u0005\b\u0001\u0010ER\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010C\"\u0005\b\u0001\u0010ER\u001e\u00105\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010C\"\u0005\b\u0001\u0010ER\u001e\u00108\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010C\"\u0005\b\u0001\u0010ER\u001e\u0010<\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010C\"\u0005\b\u0001\u0010ER\u001e\u00107\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010C\"\u0005\b\u0001\u0010ER\u001e\u00104\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010C\"\u0005\b\u0001\u0010ER\u001e\u0010;\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010C\"\u0005\b\u0001\u0010ER\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b \u0001\u0010C\"\u0005\b¡\u0001\u0010ER\u001e\u00106\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¢\u0001\u0010C\"\u0005\b£\u0001\u0010ER\u001e\u00109\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¤\u0001\u0010C\"\u0005\b¥\u0001\u0010ER\u001e\u00103\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¦\u0001\u0010C\"\u0005\b§\u0001\u0010ER\u001e\u0010:\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¨\u0001\u0010C\"\u0005\b©\u0001\u0010ER\u001e\u0010)\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bª\u0001\u0010C\"\u0005\b«\u0001\u0010ER\u001e\u0010\"\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¬\u0001\u0010C\"\u0005\b­\u0001\u0010ER\u001e\u0010(\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b®\u0001\u0010C\"\u0005\b¯\u0001\u0010ER\u001e\u0010!\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b°\u0001\u0010C\"\u0005\b±\u0001\u0010ER\u001e\u0010,\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b²\u0001\u0010C\"\u0005\b³\u0001\u0010ER\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b´\u0001\u0010C\"\u0005\bµ\u0001\u0010ER\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¶\u0001\u0010C\"\u0005\b·\u0001\u0010ER\u001e\u0010@\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¸\u0001\u0010C\"\u0005\b¹\u0001\u0010ER\u001e\u0010?\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bº\u0001\u0010C\"\u0005\b»\u0001\u0010ER\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¼\u0001\u0010C\"\u0005\b½\u0001\u0010E¨\u0006\u0002"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/entity/LogEntity;", "", "date", "", "ownerId", "fwVer", "appVer", "logType", "operation", "mode", "modeCoolHeatSetting", "coolStatus", "coolTemp", "coolOption", "boostTempOffset", "boostOperationStatus", "smartCoolSpecTemp", "smartCoolTargetTemp", "smartCoolTempPref", "warmStatus", "warmTemp", "warmOption", "smartWarmSpecTemp", "smartWarmTargetTemp", "smartWarmTempPref", "tagInvalid", "durationStatus", "coolWarmChangeOperationStatus1", "coolWarmChangeOperationStatus2", "fanStatus", "fanStep", "systemStatus", "batteryLevel", "tecTemp", "tec2Temp", "finTemp", "clothesTempA", "clothesTempB", "clothesHumiB", "bodySurfaceTemp", "tecOutput", "tec2Output", "fanOutput", "chargeStatus", "usbConnectStatus", "activity", "skinContactStatus", "serviceInfoPlan", "serviceInfoStatus", "serviceInfoAvailableTime", "anomalyDetectionType", "tagTemp", "tagHumi", "tagALS", "tagPS", "tagCarryStatus", "tagALSStatus", "tagPSStatus", "tagTempCollection", "tagHumiCollection", "tagBatteryLevel", "coolSwitchingTemp", "coolSwitchingHumi", "warmSwitchingTemp", "warmSwitchingHumi", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActivity", "()Ljava/lang/String;", "setActivity", "(Ljava/lang/String;)V", "getAnomalyDetectionType", "getAppVer", "setAppVer", "getBatteryLevel", "setBatteryLevel", "getBodySurfaceTemp", "setBodySurfaceTemp", "getBoostOperationStatus", "setBoostOperationStatus", "getBoostTempOffset", "setBoostTempOffset", "getChargeStatus", "setChargeStatus", "getClothesHumiB", "setClothesHumiB", "getClothesTempA", "setClothesTempA", "getClothesTempB", "setClothesTempB", "getCoolOption", "setCoolOption", "getCoolStatus", "setCoolStatus", "getCoolSwitchingHumi", "setCoolSwitchingHumi", "getCoolSwitchingTemp", "setCoolSwitchingTemp", "getCoolTemp", "setCoolTemp", "getCoolWarmChangeOperationStatus1", "setCoolWarmChangeOperationStatus1", "getCoolWarmChangeOperationStatus2", "setCoolWarmChangeOperationStatus2", "getDate", "setDate", "getDurationStatus", "setDurationStatus", "getFanOutput", "setFanOutput", "getFanStatus", "setFanStatus", "getFanStep", "setFanStep", "getFinTemp", "setFinTemp", "getFwVer", "setFwVer", "getLogType", "setLogType", "getMode", "setMode", "getModeCoolHeatSetting", "setModeCoolHeatSetting", "getOperation", "setOperation", "getOwnerId", "setOwnerId", "getServiceInfoAvailableTime", "setServiceInfoAvailableTime", "getServiceInfoPlan", "setServiceInfoPlan", "getServiceInfoStatus", "setServiceInfoStatus", "getSkinContactStatus", "getSmartCoolSpecTemp", "setSmartCoolSpecTemp", "getSmartCoolTargetTemp", "setSmartCoolTargetTemp", "getSmartCoolTempPref", "setSmartCoolTempPref", "getSmartWarmSpecTemp", "setSmartWarmSpecTemp", "getSmartWarmTargetTemp", "setSmartWarmTargetTemp", "getSmartWarmTempPref", "setSmartWarmTempPref", "getSystemStatus", "setSystemStatus", "getTagALS", "setTagALS", "getTagALSStatus", "setTagALSStatus", "getTagBatteryLevel", "setTagBatteryLevel", "getTagCarryStatus", "setTagCarryStatus", "getTagHumi", "setTagHumi", "getTagHumiCollection", "setTagHumiCollection", "getTagInvalid", "setTagInvalid", "getTagPS", "setTagPS", "getTagPSStatus", "setTagPSStatus", "getTagTemp", "setTagTemp", "getTagTempCollection", "setTagTempCollection", "getTec2Output", "setTec2Output", "getTec2Temp", "setTec2Temp", "getTecOutput", "setTecOutput", "getTecTemp", "setTecTemp", "getUsbConnectStatus", "setUsbConnectStatus", "getWarmOption", "setWarmOption", "getWarmStatus", "setWarmStatus", "getWarmSwitchingHumi", "setWarmSwitchingHumi", "getWarmSwitchingTemp", "setWarmSwitchingTemp", "getWarmTemp", "setWarmTemp", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component6", "component60", "component61", "component62", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LogEntity.kt */
public final class LogEntity {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int LOG_DATA_OFFSET = 7;
    private static final int UNKNOWN_VAL_INT16 = -32768;
    private static final int UNKNOWN_VAL_UINT16 = 65535;
    private static final String boost = "1";
    /* access modifiers changed from: private */
    public static String mAppVer = "";
    /* access modifiers changed from: private */
    public static String mFWVer = UpdateVersionConstant.REON_FIRMWARE_VERSION;
    private static final String none = "0";
    private static final String optionOff = "0";
    private static final String optionOn = "1";
    private static final String waveWithBoost = "5";
    private static final String waveWithoutBoost = "4";
    private String activity;
    private final String anomalyDetectionType;
    private String appVer;
    private String batteryLevel;
    private String bodySurfaceTemp;
    private String boostOperationStatus;
    private String boostTempOffset;
    private String chargeStatus;
    private String clothesHumiB;
    private String clothesTempA;
    private String clothesTempB;
    private String coolOption;
    private String coolStatus;
    private String coolSwitchingHumi;
    private String coolSwitchingTemp;
    private String coolTemp;
    private String coolWarmChangeOperationStatus1;
    private String coolWarmChangeOperationStatus2;
    private String date;
    private String durationStatus;
    private String fanOutput;
    private String fanStatus;
    private String fanStep;
    private String finTemp;
    private String fwVer;
    private String logType;
    private String mode;
    private String modeCoolHeatSetting;
    private String operation;
    private String ownerId;
    private String serviceInfoAvailableTime;
    private String serviceInfoPlan;
    private String serviceInfoStatus;
    private final String skinContactStatus;
    private String smartCoolSpecTemp;
    private String smartCoolTargetTemp;
    private String smartCoolTempPref;
    private String smartWarmSpecTemp;
    private String smartWarmTargetTemp;
    private String smartWarmTempPref;
    private String systemStatus;
    private String tagALS;
    private String tagALSStatus;
    private String tagBatteryLevel;
    private String tagCarryStatus;
    private String tagHumi;
    private String tagHumiCollection;
    private String tagInvalid;
    private String tagPS;
    private String tagPSStatus;
    private String tagTemp;
    private String tagTempCollection;
    private String tec2Output;
    private String tec2Temp;
    private String tecOutput;
    private String tecTemp;
    private String usbConnectStatus;
    private String warmOption;
    private String warmStatus;
    private String warmSwitchingHumi;
    private String warmSwitchingTemp;
    private String warmTemp;

    public static /* synthetic */ LogEntity copy$default(LogEntity logEntity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32, String str33, String str34, String str35, String str36, String str37, String str38, String str39, String str40, String str41, String str42, String str43, String str44, String str45, String str46, String str47, String str48, String str49, String str50, String str51, String str52, String str53, String str54, String str55, String str56, String str57, String str58, String str59, String str60, String str61, String str62, int i, int i2, Object obj) {
        LogEntity logEntity2 = logEntity;
        int i3 = i;
        int i4 = i2;
        return logEntity.copy((i3 & 1) != 0 ? logEntity2.date : str, (i3 & 2) != 0 ? logEntity2.ownerId : str2, (i3 & 4) != 0 ? logEntity2.fwVer : str3, (i3 & 8) != 0 ? logEntity2.appVer : str4, (i3 & 16) != 0 ? logEntity2.logType : str5, (i3 & 32) != 0 ? logEntity2.operation : str6, (i3 & 64) != 0 ? logEntity2.mode : str7, (i3 & 128) != 0 ? logEntity2.modeCoolHeatSetting : str8, (i3 & 256) != 0 ? logEntity2.coolStatus : str9, (i3 & 512) != 0 ? logEntity2.coolTemp : str10, (i3 & 1024) != 0 ? logEntity2.coolOption : str11, (i3 & 2048) != 0 ? logEntity2.boostTempOffset : str12, (i3 & 4096) != 0 ? logEntity2.boostOperationStatus : str13, (i3 & 8192) != 0 ? logEntity2.smartCoolSpecTemp : str14, (i3 & 16384) != 0 ? logEntity2.smartCoolTargetTemp : str15, (i3 & 32768) != 0 ? logEntity2.smartCoolTempPref : str16, (i3 & 65536) != 0 ? logEntity2.warmStatus : str17, (i3 & 131072) != 0 ? logEntity2.warmTemp : str18, (i3 & 262144) != 0 ? logEntity2.warmOption : str19, (i3 & 524288) != 0 ? logEntity2.smartWarmSpecTemp : str20, (i3 & 1048576) != 0 ? logEntity2.smartWarmTargetTemp : str21, (i3 & 2097152) != 0 ? logEntity2.smartWarmTempPref : str22, (i3 & 4194304) != 0 ? logEntity2.tagInvalid : str23, (i3 & 8388608) != 0 ? logEntity2.durationStatus : str24, (i3 & 16777216) != 0 ? logEntity2.coolWarmChangeOperationStatus1 : str25, (i3 & 33554432) != 0 ? logEntity2.coolWarmChangeOperationStatus2 : str26, (i3 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? logEntity2.fanStatus : str27, (i3 & 134217728) != 0 ? logEntity2.fanStep : str28, (i3 & 268435456) != 0 ? logEntity2.systemStatus : str29, (i3 & 536870912) != 0 ? logEntity2.batteryLevel : str30, (i3 & 1073741824) != 0 ? logEntity2.tecTemp : str31, (i3 & Integer.MIN_VALUE) != 0 ? logEntity2.tec2Temp : str32, (i4 & 1) != 0 ? logEntity2.finTemp : str33, (i4 & 2) != 0 ? logEntity2.clothesTempA : str34, (i4 & 4) != 0 ? logEntity2.clothesTempB : str35, (i4 & 8) != 0 ? logEntity2.clothesHumiB : str36, (i4 & 16) != 0 ? logEntity2.bodySurfaceTemp : str37, (i4 & 32) != 0 ? logEntity2.tecOutput : str38, (i4 & 64) != 0 ? logEntity2.tec2Output : str39, (i4 & 128) != 0 ? logEntity2.fanOutput : str40, (i4 & 256) != 0 ? logEntity2.chargeStatus : str41, (i4 & 512) != 0 ? logEntity2.usbConnectStatus : str42, (i4 & 1024) != 0 ? logEntity2.activity : str43, (i4 & 2048) != 0 ? logEntity2.skinContactStatus : str44, (i4 & 4096) != 0 ? logEntity2.serviceInfoPlan : str45, (i4 & 8192) != 0 ? logEntity2.serviceInfoStatus : str46, (i4 & 16384) != 0 ? logEntity2.serviceInfoAvailableTime : str47, (i4 & 32768) != 0 ? logEntity2.anomalyDetectionType : str48, (i4 & 65536) != 0 ? logEntity2.tagTemp : str49, (i4 & 131072) != 0 ? logEntity2.tagHumi : str50, (i4 & 262144) != 0 ? logEntity2.tagALS : str51, (i4 & 524288) != 0 ? logEntity2.tagPS : str52, (i4 & 1048576) != 0 ? logEntity2.tagCarryStatus : str53, (i4 & 2097152) != 0 ? logEntity2.tagALSStatus : str54, (i4 & 4194304) != 0 ? logEntity2.tagPSStatus : str55, (i4 & 8388608) != 0 ? logEntity2.tagTempCollection : str56, (i4 & 16777216) != 0 ? logEntity2.tagHumiCollection : str57, (i4 & 33554432) != 0 ? logEntity2.tagBatteryLevel : str58, (i4 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? logEntity2.coolSwitchingTemp : str59, (i4 & 134217728) != 0 ? logEntity2.coolSwitchingHumi : str60, (i4 & 268435456) != 0 ? logEntity2.warmSwitchingTemp : str61, (i4 & 536870912) != 0 ? logEntity2.warmSwitchingHumi : str62);
    }

    public final String component1() {
        return this.date;
    }

    public final String component10() {
        return this.coolTemp;
    }

    public final String component11() {
        return this.coolOption;
    }

    public final String component12() {
        return this.boostTempOffset;
    }

    public final String component13() {
        return this.boostOperationStatus;
    }

    public final String component14() {
        return this.smartCoolSpecTemp;
    }

    public final String component15() {
        return this.smartCoolTargetTemp;
    }

    public final String component16() {
        return this.smartCoolTempPref;
    }

    public final String component17() {
        return this.warmStatus;
    }

    public final String component18() {
        return this.warmTemp;
    }

    public final String component19() {
        return this.warmOption;
    }

    public final String component2() {
        return this.ownerId;
    }

    public final String component20() {
        return this.smartWarmSpecTemp;
    }

    public final String component21() {
        return this.smartWarmTargetTemp;
    }

    public final String component22() {
        return this.smartWarmTempPref;
    }

    public final String component23() {
        return this.tagInvalid;
    }

    public final String component24() {
        return this.durationStatus;
    }

    public final String component25() {
        return this.coolWarmChangeOperationStatus1;
    }

    public final String component26() {
        return this.coolWarmChangeOperationStatus2;
    }

    public final String component27() {
        return this.fanStatus;
    }

    public final String component28() {
        return this.fanStep;
    }

    public final String component29() {
        return this.systemStatus;
    }

    public final String component3() {
        return this.fwVer;
    }

    public final String component30() {
        return this.batteryLevel;
    }

    public final String component31() {
        return this.tecTemp;
    }

    public final String component32() {
        return this.tec2Temp;
    }

    public final String component33() {
        return this.finTemp;
    }

    public final String component34() {
        return this.clothesTempA;
    }

    public final String component35() {
        return this.clothesTempB;
    }

    public final String component36() {
        return this.clothesHumiB;
    }

    public final String component37() {
        return this.bodySurfaceTemp;
    }

    public final String component38() {
        return this.tecOutput;
    }

    public final String component39() {
        return this.tec2Output;
    }

    public final String component4() {
        return this.appVer;
    }

    public final String component40() {
        return this.fanOutput;
    }

    public final String component41() {
        return this.chargeStatus;
    }

    public final String component42() {
        return this.usbConnectStatus;
    }

    public final String component43() {
        return this.activity;
    }

    public final String component44() {
        return this.skinContactStatus;
    }

    public final String component45() {
        return this.serviceInfoPlan;
    }

    public final String component46() {
        return this.serviceInfoStatus;
    }

    public final String component47() {
        return this.serviceInfoAvailableTime;
    }

    public final String component48() {
        return this.anomalyDetectionType;
    }

    public final String component49() {
        return this.tagTemp;
    }

    public final String component5() {
        return this.logType;
    }

    public final String component50() {
        return this.tagHumi;
    }

    public final String component51() {
        return this.tagALS;
    }

    public final String component52() {
        return this.tagPS;
    }

    public final String component53() {
        return this.tagCarryStatus;
    }

    public final String component54() {
        return this.tagALSStatus;
    }

    public final String component55() {
        return this.tagPSStatus;
    }

    public final String component56() {
        return this.tagTempCollection;
    }

    public final String component57() {
        return this.tagHumiCollection;
    }

    public final String component58() {
        return this.tagBatteryLevel;
    }

    public final String component59() {
        return this.coolSwitchingTemp;
    }

    public final String component6() {
        return this.operation;
    }

    public final String component60() {
        return this.coolSwitchingHumi;
    }

    public final String component61() {
        return this.warmSwitchingTemp;
    }

    public final String component62() {
        return this.warmSwitchingHumi;
    }

    public final String component7() {
        return this.mode;
    }

    public final String component8() {
        return this.modeCoolHeatSetting;
    }

    public final String component9() {
        return this.coolStatus;
    }

    public final LogEntity copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32, String str33, String str34, String str35, String str36, String str37, String str38, String str39, String str40, String str41, String str42, String str43, String str44, String str45, String str46, String str47, String str48, String str49, String str50, String str51, String str52, String str53, String str54, String str55, String str56, String str57, String str58, String str59, String str60, String str61, String str62) {
        String str63 = str;
        Intrinsics.checkNotNullParameter(str63, "date");
        Intrinsics.checkNotNullParameter(str2, "ownerId");
        Intrinsics.checkNotNullParameter(str3, "fwVer");
        Intrinsics.checkNotNullParameter(str4, "appVer");
        return new LogEntity(str63, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29, str30, str31, str32, str33, str34, str35, str36, str37, str38, str39, str40, str41, str42, str43, str44, str45, str46, str47, str48, str49, str50, str51, str52, str53, str54, str55, str56, str57, str58, str59, str60, str61, str62);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogEntity)) {
            return false;
        }
        LogEntity logEntity = (LogEntity) obj;
        return Intrinsics.areEqual((Object) this.date, (Object) logEntity.date) && Intrinsics.areEqual((Object) this.ownerId, (Object) logEntity.ownerId) && Intrinsics.areEqual((Object) this.fwVer, (Object) logEntity.fwVer) && Intrinsics.areEqual((Object) this.appVer, (Object) logEntity.appVer) && Intrinsics.areEqual((Object) this.logType, (Object) logEntity.logType) && Intrinsics.areEqual((Object) this.operation, (Object) logEntity.operation) && Intrinsics.areEqual((Object) this.mode, (Object) logEntity.mode) && Intrinsics.areEqual((Object) this.modeCoolHeatSetting, (Object) logEntity.modeCoolHeatSetting) && Intrinsics.areEqual((Object) this.coolStatus, (Object) logEntity.coolStatus) && Intrinsics.areEqual((Object) this.coolTemp, (Object) logEntity.coolTemp) && Intrinsics.areEqual((Object) this.coolOption, (Object) logEntity.coolOption) && Intrinsics.areEqual((Object) this.boostTempOffset, (Object) logEntity.boostTempOffset) && Intrinsics.areEqual((Object) this.boostOperationStatus, (Object) logEntity.boostOperationStatus) && Intrinsics.areEqual((Object) this.smartCoolSpecTemp, (Object) logEntity.smartCoolSpecTemp) && Intrinsics.areEqual((Object) this.smartCoolTargetTemp, (Object) logEntity.smartCoolTargetTemp) && Intrinsics.areEqual((Object) this.smartCoolTempPref, (Object) logEntity.smartCoolTempPref) && Intrinsics.areEqual((Object) this.warmStatus, (Object) logEntity.warmStatus) && Intrinsics.areEqual((Object) this.warmTemp, (Object) logEntity.warmTemp) && Intrinsics.areEqual((Object) this.warmOption, (Object) logEntity.warmOption) && Intrinsics.areEqual((Object) this.smartWarmSpecTemp, (Object) logEntity.smartWarmSpecTemp) && Intrinsics.areEqual((Object) this.smartWarmTargetTemp, (Object) logEntity.smartWarmTargetTemp) && Intrinsics.areEqual((Object) this.smartWarmTempPref, (Object) logEntity.smartWarmTempPref) && Intrinsics.areEqual((Object) this.tagInvalid, (Object) logEntity.tagInvalid) && Intrinsics.areEqual((Object) this.durationStatus, (Object) logEntity.durationStatus) && Intrinsics.areEqual((Object) this.coolWarmChangeOperationStatus1, (Object) logEntity.coolWarmChangeOperationStatus1) && Intrinsics.areEqual((Object) this.coolWarmChangeOperationStatus2, (Object) logEntity.coolWarmChangeOperationStatus2) && Intrinsics.areEqual((Object) this.fanStatus, (Object) logEntity.fanStatus) && Intrinsics.areEqual((Object) this.fanStep, (Object) logEntity.fanStep) && Intrinsics.areEqual((Object) this.systemStatus, (Object) logEntity.systemStatus) && Intrinsics.areEqual((Object) this.batteryLevel, (Object) logEntity.batteryLevel) && Intrinsics.areEqual((Object) this.tecTemp, (Object) logEntity.tecTemp) && Intrinsics.areEqual((Object) this.tec2Temp, (Object) logEntity.tec2Temp) && Intrinsics.areEqual((Object) this.finTemp, (Object) logEntity.finTemp) && Intrinsics.areEqual((Object) this.clothesTempA, (Object) logEntity.clothesTempA) && Intrinsics.areEqual((Object) this.clothesTempB, (Object) logEntity.clothesTempB) && Intrinsics.areEqual((Object) this.clothesHumiB, (Object) logEntity.clothesHumiB) && Intrinsics.areEqual((Object) this.bodySurfaceTemp, (Object) logEntity.bodySurfaceTemp) && Intrinsics.areEqual((Object) this.tecOutput, (Object) logEntity.tecOutput) && Intrinsics.areEqual((Object) this.tec2Output, (Object) logEntity.tec2Output) && Intrinsics.areEqual((Object) this.fanOutput, (Object) logEntity.fanOutput) && Intrinsics.areEqual((Object) this.chargeStatus, (Object) logEntity.chargeStatus) && Intrinsics.areEqual((Object) this.usbConnectStatus, (Object) logEntity.usbConnectStatus) && Intrinsics.areEqual((Object) this.activity, (Object) logEntity.activity) && Intrinsics.areEqual((Object) this.skinContactStatus, (Object) logEntity.skinContactStatus) && Intrinsics.areEqual((Object) this.serviceInfoPlan, (Object) logEntity.serviceInfoPlan) && Intrinsics.areEqual((Object) this.serviceInfoStatus, (Object) logEntity.serviceInfoStatus) && Intrinsics.areEqual((Object) this.serviceInfoAvailableTime, (Object) logEntity.serviceInfoAvailableTime) && Intrinsics.areEqual((Object) this.anomalyDetectionType, (Object) logEntity.anomalyDetectionType) && Intrinsics.areEqual((Object) this.tagTemp, (Object) logEntity.tagTemp) && Intrinsics.areEqual((Object) this.tagHumi, (Object) logEntity.tagHumi) && Intrinsics.areEqual((Object) this.tagALS, (Object) logEntity.tagALS) && Intrinsics.areEqual((Object) this.tagPS, (Object) logEntity.tagPS) && Intrinsics.areEqual((Object) this.tagCarryStatus, (Object) logEntity.tagCarryStatus) && Intrinsics.areEqual((Object) this.tagALSStatus, (Object) logEntity.tagALSStatus) && Intrinsics.areEqual((Object) this.tagPSStatus, (Object) logEntity.tagPSStatus) && Intrinsics.areEqual((Object) this.tagTempCollection, (Object) logEntity.tagTempCollection) && Intrinsics.areEqual((Object) this.tagHumiCollection, (Object) logEntity.tagHumiCollection) && Intrinsics.areEqual((Object) this.tagBatteryLevel, (Object) logEntity.tagBatteryLevel) && Intrinsics.areEqual((Object) this.coolSwitchingTemp, (Object) logEntity.coolSwitchingTemp) && Intrinsics.areEqual((Object) this.coolSwitchingHumi, (Object) logEntity.coolSwitchingHumi) && Intrinsics.areEqual((Object) this.warmSwitchingTemp, (Object) logEntity.warmSwitchingTemp) && Intrinsics.areEqual((Object) this.warmSwitchingHumi, (Object) logEntity.warmSwitchingHumi);
    }

    public int hashCode() {
        int hashCode = ((((((this.date.hashCode() * 31) + this.ownerId.hashCode()) * 31) + this.fwVer.hashCode()) * 31) + this.appVer.hashCode()) * 31;
        String str = this.logType;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.operation;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.mode;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.modeCoolHeatSetting;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.coolStatus;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.coolTemp;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.coolOption;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.boostTempOffset;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.boostOperationStatus;
        int hashCode10 = (hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.smartCoolSpecTemp;
        int hashCode11 = (hashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.smartCoolTargetTemp;
        int hashCode12 = (hashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.smartCoolTempPref;
        int hashCode13 = (hashCode12 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.warmStatus;
        int hashCode14 = (hashCode13 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.warmTemp;
        int hashCode15 = (hashCode14 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.warmOption;
        int hashCode16 = (hashCode15 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.smartWarmSpecTemp;
        int hashCode17 = (hashCode16 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.smartWarmTargetTemp;
        int hashCode18 = (hashCode17 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.smartWarmTempPref;
        int hashCode19 = (hashCode18 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.tagInvalid;
        int hashCode20 = (hashCode19 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.durationStatus;
        int hashCode21 = (hashCode20 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.coolWarmChangeOperationStatus1;
        int hashCode22 = (hashCode21 + (str21 == null ? 0 : str21.hashCode())) * 31;
        String str22 = this.coolWarmChangeOperationStatus2;
        int hashCode23 = (hashCode22 + (str22 == null ? 0 : str22.hashCode())) * 31;
        String str23 = this.fanStatus;
        int hashCode24 = (hashCode23 + (str23 == null ? 0 : str23.hashCode())) * 31;
        String str24 = this.fanStep;
        int hashCode25 = (hashCode24 + (str24 == null ? 0 : str24.hashCode())) * 31;
        String str25 = this.systemStatus;
        int hashCode26 = (hashCode25 + (str25 == null ? 0 : str25.hashCode())) * 31;
        String str26 = this.batteryLevel;
        int hashCode27 = (hashCode26 + (str26 == null ? 0 : str26.hashCode())) * 31;
        String str27 = this.tecTemp;
        int hashCode28 = (hashCode27 + (str27 == null ? 0 : str27.hashCode())) * 31;
        String str28 = this.tec2Temp;
        int hashCode29 = (hashCode28 + (str28 == null ? 0 : str28.hashCode())) * 31;
        String str29 = this.finTemp;
        int hashCode30 = (hashCode29 + (str29 == null ? 0 : str29.hashCode())) * 31;
        String str30 = this.clothesTempA;
        int hashCode31 = (hashCode30 + (str30 == null ? 0 : str30.hashCode())) * 31;
        String str31 = this.clothesTempB;
        int hashCode32 = (hashCode31 + (str31 == null ? 0 : str31.hashCode())) * 31;
        String str32 = this.clothesHumiB;
        int hashCode33 = (hashCode32 + (str32 == null ? 0 : str32.hashCode())) * 31;
        String str33 = this.bodySurfaceTemp;
        int hashCode34 = (hashCode33 + (str33 == null ? 0 : str33.hashCode())) * 31;
        String str34 = this.tecOutput;
        int hashCode35 = (hashCode34 + (str34 == null ? 0 : str34.hashCode())) * 31;
        String str35 = this.tec2Output;
        int hashCode36 = (hashCode35 + (str35 == null ? 0 : str35.hashCode())) * 31;
        String str36 = this.fanOutput;
        int hashCode37 = (hashCode36 + (str36 == null ? 0 : str36.hashCode())) * 31;
        String str37 = this.chargeStatus;
        int hashCode38 = (hashCode37 + (str37 == null ? 0 : str37.hashCode())) * 31;
        String str38 = this.usbConnectStatus;
        int hashCode39 = (hashCode38 + (str38 == null ? 0 : str38.hashCode())) * 31;
        String str39 = this.activity;
        int hashCode40 = (hashCode39 + (str39 == null ? 0 : str39.hashCode())) * 31;
        String str40 = this.skinContactStatus;
        int hashCode41 = (hashCode40 + (str40 == null ? 0 : str40.hashCode())) * 31;
        String str41 = this.serviceInfoPlan;
        int hashCode42 = (hashCode41 + (str41 == null ? 0 : str41.hashCode())) * 31;
        String str42 = this.serviceInfoStatus;
        int hashCode43 = (hashCode42 + (str42 == null ? 0 : str42.hashCode())) * 31;
        String str43 = this.serviceInfoAvailableTime;
        int hashCode44 = (hashCode43 + (str43 == null ? 0 : str43.hashCode())) * 31;
        String str44 = this.anomalyDetectionType;
        int hashCode45 = (hashCode44 + (str44 == null ? 0 : str44.hashCode())) * 31;
        String str45 = this.tagTemp;
        int hashCode46 = (hashCode45 + (str45 == null ? 0 : str45.hashCode())) * 31;
        String str46 = this.tagHumi;
        int hashCode47 = (hashCode46 + (str46 == null ? 0 : str46.hashCode())) * 31;
        String str47 = this.tagALS;
        int hashCode48 = (hashCode47 + (str47 == null ? 0 : str47.hashCode())) * 31;
        String str48 = this.tagPS;
        int hashCode49 = (hashCode48 + (str48 == null ? 0 : str48.hashCode())) * 31;
        String str49 = this.tagCarryStatus;
        int hashCode50 = (hashCode49 + (str49 == null ? 0 : str49.hashCode())) * 31;
        String str50 = this.tagALSStatus;
        int hashCode51 = (hashCode50 + (str50 == null ? 0 : str50.hashCode())) * 31;
        String str51 = this.tagPSStatus;
        int hashCode52 = (hashCode51 + (str51 == null ? 0 : str51.hashCode())) * 31;
        String str52 = this.tagTempCollection;
        int hashCode53 = (hashCode52 + (str52 == null ? 0 : str52.hashCode())) * 31;
        String str53 = this.tagHumiCollection;
        int hashCode54 = (hashCode53 + (str53 == null ? 0 : str53.hashCode())) * 31;
        String str54 = this.tagBatteryLevel;
        int hashCode55 = (hashCode54 + (str54 == null ? 0 : str54.hashCode())) * 31;
        String str55 = this.coolSwitchingTemp;
        int hashCode56 = (hashCode55 + (str55 == null ? 0 : str55.hashCode())) * 31;
        String str56 = this.coolSwitchingHumi;
        int hashCode57 = (hashCode56 + (str56 == null ? 0 : str56.hashCode())) * 31;
        String str57 = this.warmSwitchingTemp;
        int hashCode58 = (hashCode57 + (str57 == null ? 0 : str57.hashCode())) * 31;
        String str58 = this.warmSwitchingHumi;
        if (str58 != null) {
            i = str58.hashCode();
        }
        return hashCode58 + i;
    }

    public String toString() {
        String str = this.date;
        String str2 = this.ownerId;
        String str3 = this.fwVer;
        String str4 = this.appVer;
        String str5 = this.logType;
        String str6 = this.operation;
        String str7 = this.mode;
        String str8 = this.modeCoolHeatSetting;
        String str9 = this.coolStatus;
        String str10 = this.coolTemp;
        String str11 = this.coolOption;
        String str12 = this.boostTempOffset;
        String str13 = this.boostOperationStatus;
        String str14 = this.smartCoolSpecTemp;
        String str15 = this.smartCoolTargetTemp;
        String str16 = this.smartCoolTempPref;
        String str17 = this.warmStatus;
        String str18 = this.warmTemp;
        String str19 = this.warmOption;
        String str20 = this.smartWarmSpecTemp;
        String str21 = this.smartWarmTargetTemp;
        String str22 = this.smartWarmTempPref;
        String str23 = this.tagInvalid;
        String str24 = this.durationStatus;
        String str25 = this.coolWarmChangeOperationStatus1;
        String str26 = this.coolWarmChangeOperationStatus2;
        String str27 = this.fanStatus;
        String str28 = this.fanStep;
        String str29 = this.systemStatus;
        String str30 = this.batteryLevel;
        String str31 = this.tecTemp;
        String str32 = this.tec2Temp;
        String str33 = this.finTemp;
        String str34 = this.clothesTempA;
        String str35 = this.clothesTempB;
        String str36 = this.clothesHumiB;
        String str37 = this.bodySurfaceTemp;
        String str38 = this.tecOutput;
        String str39 = this.tec2Output;
        String str40 = this.fanOutput;
        String str41 = this.chargeStatus;
        String str42 = this.usbConnectStatus;
        String str43 = this.activity;
        String str44 = this.skinContactStatus;
        String str45 = this.serviceInfoPlan;
        String str46 = this.serviceInfoStatus;
        String str47 = this.serviceInfoAvailableTime;
        String str48 = this.anomalyDetectionType;
        String str49 = this.tagTemp;
        String str50 = this.tagHumi;
        String str51 = this.tagALS;
        String str52 = this.tagPS;
        String str53 = this.tagCarryStatus;
        String str54 = this.tagALSStatus;
        String str55 = this.tagPSStatus;
        String str56 = this.tagTempCollection;
        String str57 = this.tagHumiCollection;
        String str58 = this.tagBatteryLevel;
        String str59 = this.coolSwitchingTemp;
        String str60 = this.coolSwitchingHumi;
        String str61 = this.warmSwitchingTemp;
        return "LogEntity(date=" + str + ", ownerId=" + str2 + ", fwVer=" + str3 + ", appVer=" + str4 + ", logType=" + str5 + ", operation=" + str6 + ", mode=" + str7 + ", modeCoolHeatSetting=" + str8 + ", coolStatus=" + str9 + ", coolTemp=" + str10 + ", coolOption=" + str11 + ", boostTempOffset=" + str12 + ", boostOperationStatus=" + str13 + ", smartCoolSpecTemp=" + str14 + ", smartCoolTargetTemp=" + str15 + ", smartCoolTempPref=" + str16 + ", warmStatus=" + str17 + ", warmTemp=" + str18 + ", warmOption=" + str19 + ", smartWarmSpecTemp=" + str20 + ", smartWarmTargetTemp=" + str21 + ", smartWarmTempPref=" + str22 + ", tagInvalid=" + str23 + ", durationStatus=" + str24 + ", coolWarmChangeOperationStatus1=" + str25 + ", coolWarmChangeOperationStatus2=" + str26 + ", fanStatus=" + str27 + ", fanStep=" + str28 + ", systemStatus=" + str29 + ", batteryLevel=" + str30 + ", tecTemp=" + str31 + ", tec2Temp=" + str32 + ", finTemp=" + str33 + ", clothesTempA=" + str34 + ", clothesTempB=" + str35 + ", clothesHumiB=" + str36 + ", bodySurfaceTemp=" + str37 + ", tecOutput=" + str38 + ", tec2Output=" + str39 + ", fanOutput=" + str40 + ", chargeStatus=" + str41 + ", usbConnectStatus=" + str42 + ", activity=" + str43 + ", skinContactStatus=" + str44 + ", serviceInfoPlan=" + str45 + ", serviceInfoStatus=" + str46 + ", serviceInfoAvailableTime=" + str47 + ", anomalyDetectionType=" + str48 + ", tagTemp=" + str49 + ", tagHumi=" + str50 + ", tagALS=" + str51 + ", tagPS=" + str52 + ", tagCarryStatus=" + str53 + ", tagALSStatus=" + str54 + ", tagPSStatus=" + str55 + ", tagTempCollection=" + str56 + ", tagHumiCollection=" + str57 + ", tagBatteryLevel=" + str58 + ", coolSwitchingTemp=" + str59 + ", coolSwitchingHumi=" + str60 + ", warmSwitchingTemp=" + str61 + ", warmSwitchingHumi=" + this.warmSwitchingHumi + ")";
    }

    public LogEntity(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32, String str33, String str34, String str35, String str36, String str37, String str38, String str39, String str40, String str41, String str42, String str43, String str44, String str45, String str46, String str47, String str48, String str49, String str50, String str51, String str52, String str53, String str54, String str55, String str56, String str57, String str58, String str59, String str60, String str61, String str62) {
        Intrinsics.checkNotNullParameter(str, "date");
        Intrinsics.checkNotNullParameter(str2, "ownerId");
        Intrinsics.checkNotNullParameter(str3, "fwVer");
        Intrinsics.checkNotNullParameter(str4, "appVer");
        this.date = str;
        this.ownerId = str2;
        this.fwVer = str3;
        this.appVer = str4;
        this.logType = str5;
        this.operation = str6;
        this.mode = str7;
        this.modeCoolHeatSetting = str8;
        this.coolStatus = str9;
        this.coolTemp = str10;
        this.coolOption = str11;
        this.boostTempOffset = str12;
        this.boostOperationStatus = str13;
        this.smartCoolSpecTemp = str14;
        this.smartCoolTargetTemp = str15;
        this.smartCoolTempPref = str16;
        this.warmStatus = str17;
        this.warmTemp = str18;
        this.warmOption = str19;
        this.smartWarmSpecTemp = str20;
        this.smartWarmTargetTemp = str21;
        this.smartWarmTempPref = str22;
        this.tagInvalid = str23;
        this.durationStatus = str24;
        this.coolWarmChangeOperationStatus1 = str25;
        this.coolWarmChangeOperationStatus2 = str26;
        this.fanStatus = str27;
        this.fanStep = str28;
        this.systemStatus = str29;
        this.batteryLevel = str30;
        this.tecTemp = str31;
        this.tec2Temp = str32;
        this.finTemp = str33;
        this.clothesTempA = str34;
        this.clothesTempB = str35;
        this.clothesHumiB = str36;
        this.bodySurfaceTemp = str37;
        this.tecOutput = str38;
        this.tec2Output = str39;
        this.fanOutput = str40;
        this.chargeStatus = str41;
        this.usbConnectStatus = str42;
        this.activity = str43;
        this.skinContactStatus = str44;
        this.serviceInfoPlan = str45;
        this.serviceInfoStatus = str46;
        this.serviceInfoAvailableTime = str47;
        this.anomalyDetectionType = str48;
        this.tagTemp = str49;
        this.tagHumi = str50;
        this.tagALS = str51;
        this.tagPS = str52;
        this.tagCarryStatus = str53;
        this.tagALSStatus = str54;
        this.tagPSStatus = str55;
        this.tagTempCollection = str56;
        this.tagHumiCollection = str57;
        this.tagBatteryLevel = str58;
        this.coolSwitchingTemp = str59;
        this.coolSwitchingHumi = str60;
        this.warmSwitchingTemp = str61;
        this.warmSwitchingHumi = str62;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LogEntity(java.lang.String r68, java.lang.String r69, java.lang.String r70, java.lang.String r71, java.lang.String r72, java.lang.String r73, java.lang.String r74, java.lang.String r75, java.lang.String r76, java.lang.String r77, java.lang.String r78, java.lang.String r79, java.lang.String r80, java.lang.String r81, java.lang.String r82, java.lang.String r83, java.lang.String r84, java.lang.String r85, java.lang.String r86, java.lang.String r87, java.lang.String r88, java.lang.String r89, java.lang.String r90, java.lang.String r91, java.lang.String r92, java.lang.String r93, java.lang.String r94, java.lang.String r95, java.lang.String r96, java.lang.String r97, java.lang.String r98, java.lang.String r99, java.lang.String r100, java.lang.String r101, java.lang.String r102, java.lang.String r103, java.lang.String r104, java.lang.String r105, java.lang.String r106, java.lang.String r107, java.lang.String r108, java.lang.String r109, java.lang.String r110, java.lang.String r111, java.lang.String r112, java.lang.String r113, java.lang.String r114, java.lang.String r115, java.lang.String r116, java.lang.String r117, java.lang.String r118, java.lang.String r119, java.lang.String r120, java.lang.String r121, java.lang.String r122, java.lang.String r123, java.lang.String r124, java.lang.String r125, java.lang.String r126, java.lang.String r127, java.lang.String r128, java.lang.String r129, int r130, int r131, kotlin.jvm.internal.DefaultConstructorMarker r132) {
        /*
            r67 = this;
            r0 = r130
            r1 = r131
            r2 = r0 & 16
            if (r2 == 0) goto L_0x000a
            r9 = 0
            goto L_0x000c
        L_0x000a:
            r9 = r72
        L_0x000c:
            r2 = r0 & 32
            if (r2 == 0) goto L_0x0012
            r10 = 0
            goto L_0x0014
        L_0x0012:
            r10 = r73
        L_0x0014:
            r2 = r0 & 64
            if (r2 == 0) goto L_0x001a
            r11 = 0
            goto L_0x001c
        L_0x001a:
            r11 = r74
        L_0x001c:
            r2 = r0 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x0022
            r12 = 0
            goto L_0x0024
        L_0x0022:
            r12 = r75
        L_0x0024:
            r2 = r0 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x002a
            r13 = 0
            goto L_0x002c
        L_0x002a:
            r13 = r76
        L_0x002c:
            r2 = r0 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x0032
            r14 = 0
            goto L_0x0034
        L_0x0032:
            r14 = r77
        L_0x0034:
            r2 = r0 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x003a
            r15 = 0
            goto L_0x003c
        L_0x003a:
            r15 = r78
        L_0x003c:
            r2 = r0 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x0043
            r16 = 0
            goto L_0x0045
        L_0x0043:
            r16 = r79
        L_0x0045:
            r2 = r0 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x004c
            r17 = 0
            goto L_0x004e
        L_0x004c:
            r17 = r80
        L_0x004e:
            r2 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x0055
            r18 = 0
            goto L_0x0057
        L_0x0055:
            r18 = r81
        L_0x0057:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x005e
            r19 = 0
            goto L_0x0060
        L_0x005e:
            r19 = r82
        L_0x0060:
            r2 = 32768(0x8000, float:4.5918E-41)
            r4 = r0 & r2
            if (r4 == 0) goto L_0x006a
            r20 = 0
            goto L_0x006c
        L_0x006a:
            r20 = r83
        L_0x006c:
            r4 = 65536(0x10000, float:9.18355E-41)
            r5 = r0 & r4
            if (r5 == 0) goto L_0x0075
            r21 = 0
            goto L_0x0077
        L_0x0075:
            r21 = r84
        L_0x0077:
            r5 = 131072(0x20000, float:1.83671E-40)
            r6 = r0 & r5
            if (r6 == 0) goto L_0x0080
            r22 = 0
            goto L_0x0082
        L_0x0080:
            r22 = r85
        L_0x0082:
            r6 = 262144(0x40000, float:3.67342E-40)
            r7 = r0 & r6
            if (r7 == 0) goto L_0x008b
            r23 = 0
            goto L_0x008d
        L_0x008b:
            r23 = r86
        L_0x008d:
            r7 = 524288(0x80000, float:7.34684E-40)
            r8 = r0 & r7
            if (r8 == 0) goto L_0x0096
            r24 = 0
            goto L_0x0098
        L_0x0096:
            r24 = r87
        L_0x0098:
            r8 = 1048576(0x100000, float:1.469368E-39)
            r25 = r0 & r8
            if (r25 == 0) goto L_0x00a1
            r25 = 0
            goto L_0x00a3
        L_0x00a1:
            r25 = r88
        L_0x00a3:
            r26 = 2097152(0x200000, float:2.938736E-39)
            r27 = r0 & r26
            if (r27 == 0) goto L_0x00ac
            r27 = 0
            goto L_0x00ae
        L_0x00ac:
            r27 = r89
        L_0x00ae:
            r28 = 4194304(0x400000, float:5.877472E-39)
            r29 = r0 & r28
            if (r29 == 0) goto L_0x00b7
            r29 = 0
            goto L_0x00b9
        L_0x00b7:
            r29 = r90
        L_0x00b9:
            r30 = 8388608(0x800000, float:1.17549435E-38)
            r31 = r0 & r30
            if (r31 == 0) goto L_0x00c2
            r31 = 0
            goto L_0x00c4
        L_0x00c2:
            r31 = r91
        L_0x00c4:
            r32 = 16777216(0x1000000, float:2.3509887E-38)
            r33 = r0 & r32
            if (r33 == 0) goto L_0x00cd
            r33 = 0
            goto L_0x00cf
        L_0x00cd:
            r33 = r92
        L_0x00cf:
            r34 = 33554432(0x2000000, float:9.403955E-38)
            r34 = r0 & r34
            if (r34 == 0) goto L_0x00d8
            r34 = 0
            goto L_0x00da
        L_0x00d8:
            r34 = r93
        L_0x00da:
            r35 = 67108864(0x4000000, float:1.5046328E-36)
            r35 = r0 & r35
            if (r35 == 0) goto L_0x00e3
            r35 = 0
            goto L_0x00e5
        L_0x00e3:
            r35 = r94
        L_0x00e5:
            r36 = 134217728(0x8000000, float:3.85186E-34)
            r36 = r0 & r36
            if (r36 == 0) goto L_0x00ee
            r36 = 0
            goto L_0x00f0
        L_0x00ee:
            r36 = r95
        L_0x00f0:
            r37 = 268435456(0x10000000, float:2.5243549E-29)
            r37 = r0 & r37
            if (r37 == 0) goto L_0x00f9
            r37 = 0
            goto L_0x00fb
        L_0x00f9:
            r37 = r96
        L_0x00fb:
            r38 = 536870912(0x20000000, float:1.0842022E-19)
            r38 = r0 & r38
            if (r38 == 0) goto L_0x0104
            r38 = 0
            goto L_0x0106
        L_0x0104:
            r38 = r97
        L_0x0106:
            r39 = 1073741824(0x40000000, float:2.0)
            r39 = r0 & r39
            if (r39 == 0) goto L_0x010f
            r39 = 0
            goto L_0x0111
        L_0x010f:
            r39 = r98
        L_0x0111:
            r40 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r40
            if (r0 == 0) goto L_0x0119
            r0 = 0
            goto L_0x011b
        L_0x0119:
            r0 = r99
        L_0x011b:
            r40 = r1 & 1
            if (r40 == 0) goto L_0x0122
            r40 = 0
            goto L_0x0124
        L_0x0122:
            r40 = r100
        L_0x0124:
            r41 = r1 & 2
            if (r41 == 0) goto L_0x012b
            r41 = 0
            goto L_0x012d
        L_0x012b:
            r41 = r101
        L_0x012d:
            r42 = r1 & 4
            if (r42 == 0) goto L_0x0134
            r42 = 0
            goto L_0x0136
        L_0x0134:
            r42 = r102
        L_0x0136:
            r43 = r1 & 8
            if (r43 == 0) goto L_0x013d
            r43 = 0
            goto L_0x013f
        L_0x013d:
            r43 = r103
        L_0x013f:
            r44 = r1 & 16
            if (r44 == 0) goto L_0x0146
            r44 = 0
            goto L_0x0148
        L_0x0146:
            r44 = r104
        L_0x0148:
            r45 = r1 & 32
            if (r45 == 0) goto L_0x014f
            r45 = 0
            goto L_0x0151
        L_0x014f:
            r45 = r105
        L_0x0151:
            r46 = r1 & 64
            if (r46 == 0) goto L_0x0158
            r46 = 0
            goto L_0x015a
        L_0x0158:
            r46 = r106
        L_0x015a:
            r3 = r1 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x0160
            r3 = 0
            goto L_0x0162
        L_0x0160:
            r3 = r107
        L_0x0162:
            r8 = r1 & 256(0x100, float:3.59E-43)
            if (r8 == 0) goto L_0x0169
            r47 = 0
            goto L_0x016b
        L_0x0169:
            r47 = r108
        L_0x016b:
            r8 = r1 & 512(0x200, float:7.175E-43)
            if (r8 == 0) goto L_0x0172
            r48 = 0
            goto L_0x0174
        L_0x0172:
            r48 = r109
        L_0x0174:
            r8 = r1 & 1024(0x400, float:1.435E-42)
            if (r8 == 0) goto L_0x017b
            r49 = 0
            goto L_0x017d
        L_0x017b:
            r49 = r110
        L_0x017d:
            r8 = r1 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x0184
            r50 = 0
            goto L_0x0186
        L_0x0184:
            r50 = r111
        L_0x0186:
            r8 = r1 & 4096(0x1000, float:5.74E-42)
            if (r8 == 0) goto L_0x018d
            r51 = 0
            goto L_0x018f
        L_0x018d:
            r51 = r112
        L_0x018f:
            r8 = r1 & 8192(0x2000, float:1.14794E-41)
            if (r8 == 0) goto L_0x0196
            r52 = 0
            goto L_0x0198
        L_0x0196:
            r52 = r113
        L_0x0198:
            r8 = r1 & 16384(0x4000, float:2.2959E-41)
            if (r8 == 0) goto L_0x019f
            r53 = 0
            goto L_0x01a1
        L_0x019f:
            r53 = r114
        L_0x01a1:
            r2 = r2 & r1
            if (r2 == 0) goto L_0x01a6
            r2 = 0
            goto L_0x01a8
        L_0x01a6:
            r2 = r115
        L_0x01a8:
            r4 = r4 & r1
            if (r4 == 0) goto L_0x01ae
            r54 = 0
            goto L_0x01b0
        L_0x01ae:
            r54 = r116
        L_0x01b0:
            r4 = r1 & r5
            if (r4 == 0) goto L_0x01b7
            r55 = 0
            goto L_0x01b9
        L_0x01b7:
            r55 = r117
        L_0x01b9:
            r4 = r1 & r6
            if (r4 == 0) goto L_0x01c0
            r56 = 0
            goto L_0x01c2
        L_0x01c0:
            r56 = r118
        L_0x01c2:
            r4 = r1 & r7
            if (r4 == 0) goto L_0x01cb
            r4 = 1048576(0x100000, float:1.469368E-39)
            r57 = 0
            goto L_0x01cf
        L_0x01cb:
            r57 = r119
            r4 = 1048576(0x100000, float:1.469368E-39)
        L_0x01cf:
            r4 = r4 & r1
            if (r4 == 0) goto L_0x01d5
            r58 = 0
            goto L_0x01d7
        L_0x01d5:
            r58 = r120
        L_0x01d7:
            r4 = r1 & r26
            if (r4 == 0) goto L_0x01de
            r59 = 0
            goto L_0x01e0
        L_0x01de:
            r59 = r121
        L_0x01e0:
            r4 = r1 & r28
            if (r4 == 0) goto L_0x01e7
            r60 = 0
            goto L_0x01e9
        L_0x01e7:
            r60 = r122
        L_0x01e9:
            r4 = r1 & r30
            if (r4 == 0) goto L_0x01f0
            r61 = 0
            goto L_0x01f2
        L_0x01f0:
            r61 = r123
        L_0x01f2:
            r4 = r1 & r32
            if (r4 == 0) goto L_0x01f9
            r62 = 0
            goto L_0x01fb
        L_0x01f9:
            r62 = r124
        L_0x01fb:
            r4 = 33554432(0x2000000, float:9.403955E-38)
            r4 = r4 & r1
            if (r4 == 0) goto L_0x0203
            r63 = 0
            goto L_0x0205
        L_0x0203:
            r63 = r125
        L_0x0205:
            r4 = 67108864(0x4000000, float:1.5046328E-36)
            r4 = r4 & r1
            if (r4 == 0) goto L_0x020d
            r64 = 0
            goto L_0x020f
        L_0x020d:
            r64 = r126
        L_0x020f:
            r4 = 134217728(0x8000000, float:3.85186E-34)
            r4 = r4 & r1
            if (r4 == 0) goto L_0x0217
            r65 = 0
            goto L_0x0219
        L_0x0217:
            r65 = r127
        L_0x0219:
            r4 = 268435456(0x10000000, float:2.5243549E-29)
            r4 = r4 & r1
            if (r4 == 0) goto L_0x0221
            r66 = 0
            goto L_0x0223
        L_0x0221:
            r66 = r128
        L_0x0223:
            r4 = 536870912(0x20000000, float:1.0842022E-19)
            r1 = r1 & r4
            if (r1 == 0) goto L_0x022a
            r1 = 0
            goto L_0x022c
        L_0x022a:
            r1 = r129
        L_0x022c:
            r4 = r67
            r5 = r68
            r6 = r69
            r7 = r70
            r8 = r71
            r26 = r27
            r27 = r29
            r28 = r31
            r29 = r33
            r30 = r34
            r31 = r35
            r32 = r36
            r33 = r37
            r34 = r38
            r35 = r39
            r36 = r0
            r37 = r40
            r38 = r41
            r39 = r42
            r40 = r43
            r41 = r44
            r42 = r45
            r43 = r46
            r44 = r3
            r45 = r47
            r46 = r48
            r47 = r49
            r48 = r50
            r49 = r51
            r50 = r52
            r51 = r53
            r52 = r2
            r53 = r54
            r54 = r55
            r55 = r56
            r56 = r57
            r57 = r58
            r58 = r59
            r59 = r60
            r60 = r61
            r61 = r62
            r62 = r63
            r63 = r64
            r64 = r65
            r65 = r66
            r66 = r1
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.connection.log.entity.LogEntity.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.date = str;
    }

    public final String getOwnerId() {
        return this.ownerId;
    }

    public final void setOwnerId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ownerId = str;
    }

    public final String getFwVer() {
        return this.fwVer;
    }

    public final void setFwVer(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fwVer = str;
    }

    public final String getAppVer() {
        return this.appVer;
    }

    public final void setAppVer(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appVer = str;
    }

    public final String getLogType() {
        return this.logType;
    }

    public final void setLogType(String str) {
        this.logType = str;
    }

    public final String getOperation() {
        return this.operation;
    }

    public final void setOperation(String str) {
        this.operation = str;
    }

    public final String getMode() {
        return this.mode;
    }

    public final void setMode(String str) {
        this.mode = str;
    }

    public final String getModeCoolHeatSetting() {
        return this.modeCoolHeatSetting;
    }

    public final void setModeCoolHeatSetting(String str) {
        this.modeCoolHeatSetting = str;
    }

    public final String getCoolStatus() {
        return this.coolStatus;
    }

    public final void setCoolStatus(String str) {
        this.coolStatus = str;
    }

    public final String getCoolTemp() {
        return this.coolTemp;
    }

    public final void setCoolTemp(String str) {
        this.coolTemp = str;
    }

    public final String getCoolOption() {
        return this.coolOption;
    }

    public final void setCoolOption(String str) {
        this.coolOption = str;
    }

    public final String getBoostTempOffset() {
        return this.boostTempOffset;
    }

    public final void setBoostTempOffset(String str) {
        this.boostTempOffset = str;
    }

    public final String getBoostOperationStatus() {
        return this.boostOperationStatus;
    }

    public final void setBoostOperationStatus(String str) {
        this.boostOperationStatus = str;
    }

    public final String getSmartCoolSpecTemp() {
        return this.smartCoolSpecTemp;
    }

    public final void setSmartCoolSpecTemp(String str) {
        this.smartCoolSpecTemp = str;
    }

    public final String getSmartCoolTargetTemp() {
        return this.smartCoolTargetTemp;
    }

    public final void setSmartCoolTargetTemp(String str) {
        this.smartCoolTargetTemp = str;
    }

    public final String getSmartCoolTempPref() {
        return this.smartCoolTempPref;
    }

    public final void setSmartCoolTempPref(String str) {
        this.smartCoolTempPref = str;
    }

    public final String getWarmStatus() {
        return this.warmStatus;
    }

    public final void setWarmStatus(String str) {
        this.warmStatus = str;
    }

    public final String getWarmTemp() {
        return this.warmTemp;
    }

    public final void setWarmTemp(String str) {
        this.warmTemp = str;
    }

    public final String getWarmOption() {
        return this.warmOption;
    }

    public final void setWarmOption(String str) {
        this.warmOption = str;
    }

    public final String getSmartWarmSpecTemp() {
        return this.smartWarmSpecTemp;
    }

    public final void setSmartWarmSpecTemp(String str) {
        this.smartWarmSpecTemp = str;
    }

    public final String getSmartWarmTargetTemp() {
        return this.smartWarmTargetTemp;
    }

    public final void setSmartWarmTargetTemp(String str) {
        this.smartWarmTargetTemp = str;
    }

    public final String getSmartWarmTempPref() {
        return this.smartWarmTempPref;
    }

    public final void setSmartWarmTempPref(String str) {
        this.smartWarmTempPref = str;
    }

    public final String getTagInvalid() {
        return this.tagInvalid;
    }

    public final void setTagInvalid(String str) {
        this.tagInvalid = str;
    }

    public final String getDurationStatus() {
        return this.durationStatus;
    }

    public final void setDurationStatus(String str) {
        this.durationStatus = str;
    }

    public final String getCoolWarmChangeOperationStatus1() {
        return this.coolWarmChangeOperationStatus1;
    }

    public final void setCoolWarmChangeOperationStatus1(String str) {
        this.coolWarmChangeOperationStatus1 = str;
    }

    public final String getCoolWarmChangeOperationStatus2() {
        return this.coolWarmChangeOperationStatus2;
    }

    public final void setCoolWarmChangeOperationStatus2(String str) {
        this.coolWarmChangeOperationStatus2 = str;
    }

    public final String getFanStatus() {
        return this.fanStatus;
    }

    public final void setFanStatus(String str) {
        this.fanStatus = str;
    }

    public final String getFanStep() {
        return this.fanStep;
    }

    public final void setFanStep(String str) {
        this.fanStep = str;
    }

    public final String getSystemStatus() {
        return this.systemStatus;
    }

    public final void setSystemStatus(String str) {
        this.systemStatus = str;
    }

    public final String getBatteryLevel() {
        return this.batteryLevel;
    }

    public final void setBatteryLevel(String str) {
        this.batteryLevel = str;
    }

    public final String getTecTemp() {
        return this.tecTemp;
    }

    public final void setTecTemp(String str) {
        this.tecTemp = str;
    }

    public final String getTec2Temp() {
        return this.tec2Temp;
    }

    public final void setTec2Temp(String str) {
        this.tec2Temp = str;
    }

    public final String getFinTemp() {
        return this.finTemp;
    }

    public final void setFinTemp(String str) {
        this.finTemp = str;
    }

    public final String getClothesTempA() {
        return this.clothesTempA;
    }

    public final void setClothesTempA(String str) {
        this.clothesTempA = str;
    }

    public final String getClothesTempB() {
        return this.clothesTempB;
    }

    public final void setClothesTempB(String str) {
        this.clothesTempB = str;
    }

    public final String getClothesHumiB() {
        return this.clothesHumiB;
    }

    public final void setClothesHumiB(String str) {
        this.clothesHumiB = str;
    }

    public final String getBodySurfaceTemp() {
        return this.bodySurfaceTemp;
    }

    public final void setBodySurfaceTemp(String str) {
        this.bodySurfaceTemp = str;
    }

    public final String getTecOutput() {
        return this.tecOutput;
    }

    public final void setTecOutput(String str) {
        this.tecOutput = str;
    }

    public final String getTec2Output() {
        return this.tec2Output;
    }

    public final void setTec2Output(String str) {
        this.tec2Output = str;
    }

    public final String getFanOutput() {
        return this.fanOutput;
    }

    public final void setFanOutput(String str) {
        this.fanOutput = str;
    }

    public final String getChargeStatus() {
        return this.chargeStatus;
    }

    public final void setChargeStatus(String str) {
        this.chargeStatus = str;
    }

    public final String getUsbConnectStatus() {
        return this.usbConnectStatus;
    }

    public final void setUsbConnectStatus(String str) {
        this.usbConnectStatus = str;
    }

    public final String getActivity() {
        return this.activity;
    }

    public final void setActivity(String str) {
        this.activity = str;
    }

    public final String getSkinContactStatus() {
        return this.skinContactStatus;
    }

    public final String getServiceInfoPlan() {
        return this.serviceInfoPlan;
    }

    public final void setServiceInfoPlan(String str) {
        this.serviceInfoPlan = str;
    }

    public final String getServiceInfoStatus() {
        return this.serviceInfoStatus;
    }

    public final void setServiceInfoStatus(String str) {
        this.serviceInfoStatus = str;
    }

    public final String getServiceInfoAvailableTime() {
        return this.serviceInfoAvailableTime;
    }

    public final void setServiceInfoAvailableTime(String str) {
        this.serviceInfoAvailableTime = str;
    }

    public final String getAnomalyDetectionType() {
        return this.anomalyDetectionType;
    }

    public final String getTagTemp() {
        return this.tagTemp;
    }

    public final void setTagTemp(String str) {
        this.tagTemp = str;
    }

    public final String getTagHumi() {
        return this.tagHumi;
    }

    public final void setTagHumi(String str) {
        this.tagHumi = str;
    }

    public final String getTagALS() {
        return this.tagALS;
    }

    public final void setTagALS(String str) {
        this.tagALS = str;
    }

    public final String getTagPS() {
        return this.tagPS;
    }

    public final void setTagPS(String str) {
        this.tagPS = str;
    }

    public final String getTagCarryStatus() {
        return this.tagCarryStatus;
    }

    public final void setTagCarryStatus(String str) {
        this.tagCarryStatus = str;
    }

    public final String getTagALSStatus() {
        return this.tagALSStatus;
    }

    public final void setTagALSStatus(String str) {
        this.tagALSStatus = str;
    }

    public final String getTagPSStatus() {
        return this.tagPSStatus;
    }

    public final void setTagPSStatus(String str) {
        this.tagPSStatus = str;
    }

    public final String getTagTempCollection() {
        return this.tagTempCollection;
    }

    public final void setTagTempCollection(String str) {
        this.tagTempCollection = str;
    }

    public final String getTagHumiCollection() {
        return this.tagHumiCollection;
    }

    public final void setTagHumiCollection(String str) {
        this.tagHumiCollection = str;
    }

    public final String getTagBatteryLevel() {
        return this.tagBatteryLevel;
    }

    public final void setTagBatteryLevel(String str) {
        this.tagBatteryLevel = str;
    }

    public final String getCoolSwitchingTemp() {
        return this.coolSwitchingTemp;
    }

    public final void setCoolSwitchingTemp(String str) {
        this.coolSwitchingTemp = str;
    }

    public final String getCoolSwitchingHumi() {
        return this.coolSwitchingHumi;
    }

    public final void setCoolSwitchingHumi(String str) {
        this.coolSwitchingHumi = str;
    }

    public final String getWarmSwitchingTemp() {
        return this.warmSwitchingTemp;
    }

    public final void setWarmSwitchingTemp(String str) {
        this.warmSwitchingTemp = str;
    }

    public final String getWarmSwitchingHumi() {
        return this.warmSwitchingHumi;
    }

    public final void setWarmSwitchingHumi(String str) {
        this.warmSwitchingHumi = str;
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bJ\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\bJ\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\bJ*\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J*\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J*\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J*\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J*\u0010 \u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J*\u0010!\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J*\u0010\"\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J*\u0010#\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J*\u0010$\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J*\u0010%\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/entity/LogEntity$Companion;", "", "()V", "LOG_DATA_OFFSET", "", "UNKNOWN_VAL_INT16", "UNKNOWN_VAL_UINT16", "boost", "", "mAppVer", "mFWVer", "none", "optionOff", "optionOn", "waveWithBoost", "waveWithoutBoost", "create", "Ljp/co/sony/reonpocket/connection/log/entity/LogEntity;", "content", "Ljp/co/sony/reonpocket/connection/log/BGLogManager$LogContent;", "aOwnerId", "Ljp/co/sony/reonpocket/connection/log/job/ReadLogJobTask$LogContent;", "contentArray", "", "createAnomalyDetectionTypeInfo", "aDate", "aLogType", "aEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "createDeviceModeChange1Info", "createDeviceModeChange2Info", "createFanSettingMonitorInfo", "createPaidMembershipStatusInfo", "createStatusMonitor15sec1Info", "createStatusMonitor15sec2Info", "createStatusMonitor60secInfo", "createSystemStatusMonitorInfo", "createTagStatusInfo", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: LogEntity.kt */
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* compiled from: LogEntity.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(2:19|20)|21|23) */
            /* JADX WARNING: Can't wrap try/catch for region: R(23:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|23) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
            /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
            static {
                /*
                    jp.co.sony.reonpocket.connection.log.constant.LogTypeCode[] r0 = jp.co.sony.reonpocket.connection.log.constant.LogTypeCode.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    jp.co.sony.reonpocket.connection.log.constant.LogTypeCode r1 = jp.co.sony.reonpocket.connection.log.constant.LogTypeCode.DEVICE_MODE_CHANGE_1     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    jp.co.sony.reonpocket.connection.log.constant.LogTypeCode r1 = jp.co.sony.reonpocket.connection.log.constant.LogTypeCode.DEVICE_MODE_CHANGE_2     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    jp.co.sony.reonpocket.connection.log.constant.LogTypeCode r1 = jp.co.sony.reonpocket.connection.log.constant.LogTypeCode.FAN     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    jp.co.sony.reonpocket.connection.log.constant.LogTypeCode r1 = jp.co.sony.reonpocket.connection.log.constant.LogTypeCode.SYSTEM     // Catch:{ NoSuchFieldError -> 0x002b }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                    r2 = 4
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
                L_0x002b:
                    jp.co.sony.reonpocket.connection.log.constant.LogTypeCode r1 = jp.co.sony.reonpocket.connection.log.constant.LogTypeCode.STATUS_MONITORING_15SEC_1     // Catch:{ NoSuchFieldError -> 0x0034 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                    r2 = 5
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
                L_0x0034:
                    jp.co.sony.reonpocket.connection.log.constant.LogTypeCode r1 = jp.co.sony.reonpocket.connection.log.constant.LogTypeCode.STATUS_MONITORING_15SEC_2     // Catch:{ NoSuchFieldError -> 0x003d }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                    r2 = 6
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
                L_0x003d:
                    jp.co.sony.reonpocket.connection.log.constant.LogTypeCode r1 = jp.co.sony.reonpocket.connection.log.constant.LogTypeCode.STATUS_MONITORING_60SEC     // Catch:{ NoSuchFieldError -> 0x0046 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                    r2 = 7
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
                L_0x0046:
                    jp.co.sony.reonpocket.connection.log.constant.LogTypeCode r1 = jp.co.sony.reonpocket.connection.log.constant.LogTypeCode.PAID_MEMBERSHIP_STATUS     // Catch:{ NoSuchFieldError -> 0x0050 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                    r2 = 8
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
                L_0x0050:
                    jp.co.sony.reonpocket.connection.log.constant.LogTypeCode r1 = jp.co.sony.reonpocket.connection.log.constant.LogTypeCode.TAG_STATUS     // Catch:{ NoSuchFieldError -> 0x005a }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                    r2 = 9
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
                L_0x005a:
                    jp.co.sony.reonpocket.connection.log.constant.LogTypeCode r1 = jp.co.sony.reonpocket.connection.log.constant.LogTypeCode.ANOMALY_DETECTION_TYPE     // Catch:{ NoSuchFieldError -> 0x0064 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                    r2 = 10
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
                L_0x0064:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.connection.log.entity.LogEntity.Companion.WhenMappings.<clinit>():void");
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LogEntity create(byte[] bArr, String str) {
            LogTypeCode logTypeCode;
            LogEntity logEntity;
            Intrinsics.checkNotNullParameter(str, "aOwnerId");
            BleDataEntity bleDataEntity = new BleDataEntity(BleActionCode.READ, "", "", bArr, false, (ResponseCode) null, 48, (DefaultConstructorMarker) null);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            Intrinsics.checkNotNullExpressionValue(byteOrder, "LITTLE_ENDIAN");
            Long longValue$default = BleDataEntity.getLongValue$default(bleDataEntity, 20, 0, (Long) null, byteOrder, 4, (Object) null);
            if (longValue$default == null) {
                return null;
            }
            String str2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault()).format(new Date(longValue$default.longValue() * 1000)) + "+09:00";
            Integer intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 5, (ByteOrder) null, 4, (Object) null);
            String valueOf = String.valueOf(intValue$default);
            LogTypeCode[] values = LogTypeCode.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    logTypeCode = null;
                    break;
                }
                logTypeCode = values[i];
                int code = logTypeCode.getCode();
                if (intValue$default != null && intValue$default.intValue() == code) {
                    break;
                }
                i++;
            }
            if (logTypeCode == null) {
                return null;
            }
            try {
                switch (WhenMappings.$EnumSwitchMapping$0[logTypeCode.ordinal()]) {
                    case 1:
                        logEntity = createDeviceModeChange1Info(str2, valueOf, str, bleDataEntity);
                        break;
                    case 2:
                        logEntity = createDeviceModeChange2Info(str2, valueOf, str, bleDataEntity);
                        break;
                    case 3:
                        logEntity = createFanSettingMonitorInfo(str2, valueOf, str, bleDataEntity);
                        break;
                    case 4:
                        logEntity = createSystemStatusMonitorInfo(str2, valueOf, str, bleDataEntity);
                        break;
                    case 5:
                        logEntity = createStatusMonitor15sec1Info(str2, valueOf, str, bleDataEntity);
                        break;
                    case 6:
                        logEntity = createStatusMonitor15sec2Info(str2, valueOf, str, bleDataEntity);
                        break;
                    case 7:
                        logEntity = createStatusMonitor60secInfo(str2, valueOf, str, bleDataEntity);
                        break;
                    case 8:
                        logEntity = createPaidMembershipStatusInfo(str2, valueOf, str, bleDataEntity);
                        break;
                    case 9:
                        logEntity = createTagStatusInfo(str2, valueOf, str, bleDataEntity);
                        break;
                    case 10:
                        logEntity = createAnomalyDetectionTypeInfo(str2, valueOf, str, bleDataEntity);
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                return logEntity;
            } catch (StringIndexOutOfBoundsException unused) {
                DebugLogUtil.INSTANCE.e("ReadLogJobTask.TAG", "log format error out of bounds");
                return null;
            }
        }

        public final LogEntity create(BGLogManager.LogContent logContent, String str) {
            Intrinsics.checkNotNullParameter(logContent, FirebaseAnalytics.Param.CONTENT);
            Intrinsics.checkNotNullParameter(str, "aOwnerId");
            return create(logContent.getMInfo(), str);
        }

        public final LogEntity create(ReadLogJobTask.LogContent logContent, String str) {
            Intrinsics.checkNotNullParameter(logContent, FirebaseAnalytics.Param.CONTENT);
            Intrinsics.checkNotNullParameter(str, "aOwnerId");
            return create(logContent.getMInfo(), str);
        }

        private final LogEntity createDeviceModeChange1Info(String str, String str2, String str3, BleDataEntity bleDataEntity) {
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            String str12;
            String str13;
            String str14;
            String str15;
            String str16;
            String valueOf;
            String valueOf2;
            String str17;
            String str18;
            String str19;
            String str20;
            String str21;
            String str22;
            String str23;
            String str24;
            String str25;
            BleDataEntity bleDataEntity2 = bleDataEntity;
            String valueOf3 = String.valueOf(BleDataEntity.getIntValue$default(bleDataEntity, 17, 7, (ByteOrder) null, 4, (Object) null));
            Integer intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 8, (ByteOrder) null, 4, (Object) null);
            if (intValue$default != null) {
                String binaryString = Integer.toBinaryString(intValue$default.intValue());
                Intrinsics.checkNotNullExpressionValue(binaryString, "toBinaryString(...)");
                String padStart = StringsKt.padStart(binaryString, 8, '0');
                int parseInt = Integer.parseInt(StringsKt.substring(padStart, new IntRange(4, 7)), CharsKt.checkRadix(2));
                int parseInt2 = Integer.parseInt(StringsKt.substring(padStart, new IntRange(0, 3)), CharsKt.checkRadix(2));
                String valueOf4 = String.valueOf(parseInt);
                String valueOf5 = String.valueOf(parseInt2);
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
                str4 = valueOf5;
                str5 = valueOf4;
            } else {
                str5 = null;
                str4 = null;
            }
            Integer intValue$default2 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 9, (ByteOrder) null, 4, (Object) null);
            if (intValue$default2 != null) {
                String binaryString2 = Integer.toBinaryString(intValue$default2.intValue());
                Intrinsics.checkNotNullExpressionValue(binaryString2, "toBinaryString(...)");
                String padStart2 = StringsKt.padStart(binaryString2, 8, '0');
                String valueOf6 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart2, new IntRange(4, 7)), CharsKt.checkRadix(2)));
                String valueOf7 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart2, new IntRange(0, 3)), CharsKt.checkRadix(2)));
                Unit unit3 = Unit.INSTANCE;
                Unit unit4 = Unit.INSTANCE;
                str7 = valueOf7;
                str6 = valueOf6;
            } else {
                str7 = null;
                str6 = null;
            }
            String str26 = str7;
            String str27 = str6;
            Integer intValue$default3 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 10, (ByteOrder) null, 4, (Object) null);
            if (intValue$default3 != null) {
                String binaryString3 = Integer.toBinaryString(intValue$default3.intValue());
                Intrinsics.checkNotNullExpressionValue(binaryString3, "toBinaryString(...)");
                String padStart3 = StringsKt.padStart(binaryString3, 8, '0');
                String valueOf8 = !Intrinsics.areEqual((Object) str27, (Object) String.valueOf(CoolHeatStatusCode.OFF.getCode())) ? String.valueOf(Integer.parseInt(StringsKt.substring(padStart3, new IntRange(4, 7)), CharsKt.checkRadix(2))) : null;
                str10 = str26;
                String valueOf9 = !Intrinsics.areEqual((Object) str10, (Object) String.valueOf(CoolHeatStatusCode.OFF.getCode())) ? String.valueOf(Integer.parseInt(StringsKt.substring(padStart3, new IntRange(0, 3)), CharsKt.checkRadix(2))) : null;
                Unit unit5 = Unit.INSTANCE;
                Unit unit6 = Unit.INSTANCE;
                str8 = valueOf9;
                str9 = valueOf8;
            } else {
                str10 = str26;
                str9 = null;
                str8 = null;
            }
            String str28 = str10;
            Integer intValue$default4 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 11, (ByteOrder) null, 4, (Object) null);
            if (intValue$default4 != null) {
                String binaryString4 = Integer.toBinaryString(intValue$default4.intValue());
                Intrinsics.checkNotNullExpressionValue(binaryString4, "toBinaryString(...)");
                String padStart4 = StringsKt.padStart(binaryString4, 8, '0');
                str12 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart4, new IntRange(7, 7)), CharsKt.checkRadix(2)));
                str11 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart4, new IntRange(6, 6)), CharsKt.checkRadix(2)));
                Integer.parseInt(StringsKt.substring(padStart4, new IntRange(4, 5)), CharsKt.checkRadix(2));
                str13 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart4, new IntRange(3, 3)), CharsKt.checkRadix(2)));
                str14 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart4, new IntRange(2, 2)), CharsKt.checkRadix(2)));
                Unit unit7 = Unit.INSTANCE;
                Unit unit8 = Unit.INSTANCE;
            } else {
                str14 = null;
                str13 = null;
                str12 = null;
                str11 = null;
            }
            String str29 = "0";
            if (str12 == null || str11 == null) {
                str15 = null;
            } else {
                if (Intrinsics.areEqual((Object) str12, (Object) "1") && Intrinsics.areEqual((Object) str11, (Object) str29)) {
                    str25 = "1";
                } else if (!Intrinsics.areEqual((Object) str12, (Object) str29) || !Intrinsics.areEqual((Object) str11, (Object) "1")) {
                    str25 = (!Intrinsics.areEqual((Object) str12, (Object) "1") || !Intrinsics.areEqual((Object) str11, (Object) "1")) ? str29 : "5";
                } else {
                    str25 = "4";
                }
                str15 = str25;
            }
            if (str13 == null || str14 == null) {
                str16 = null;
            } else {
                if (Intrinsics.areEqual((Object) str13, (Object) "1") && Intrinsics.areEqual((Object) str14, (Object) str29)) {
                    str29 = "1";
                } else if (Intrinsics.areEqual((Object) str13, (Object) str29) && Intrinsics.areEqual((Object) str14, (Object) "1")) {
                    str29 = "4";
                } else if (Intrinsics.areEqual((Object) str13, (Object) "1") && Intrinsics.areEqual((Object) str14, (Object) "1")) {
                    str29 = "5";
                }
                str16 = str29;
            }
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            Intrinsics.checkNotNullExpressionValue(byteOrder, "LITTLE_ENDIAN");
            Integer intValue = bleDataEntity2.getIntValue(34, 12, byteOrder);
            if (intValue != null && intValue.intValue() == -32768) {
                String num = Integer.toString(intValue.intValue(), CharsKt.checkRadix(10));
                Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
                valueOf = "UNDEFINED(" + num + ")";
            } else {
                valueOf = String.valueOf(intValue != null ? Float.valueOf(((float) intValue.intValue()) / 100.0f) : null);
            }
            String str30 = valueOf;
            ByteOrder byteOrder2 = ByteOrder.LITTLE_ENDIAN;
            Intrinsics.checkNotNullExpressionValue(byteOrder2, "LITTLE_ENDIAN");
            Integer intValue2 = bleDataEntity2.getIntValue(34, 14, byteOrder2);
            if (intValue2 != null && intValue2.intValue() == -32768) {
                String num2 = Integer.toString(intValue2.intValue(), CharsKt.checkRadix(10));
                Intrinsics.checkNotNullExpressionValue(num2, "toString(...)");
                valueOf2 = "UNDEFINED(" + num2 + ")";
            } else {
                valueOf2 = String.valueOf(intValue2 != null ? Float.valueOf(((float) intValue2.intValue()) / 100.0f) : null);
            }
            String str31 = valueOf2;
            ByteOrder byteOrder3 = ByteOrder.LITTLE_ENDIAN;
            Intrinsics.checkNotNullExpressionValue(byteOrder3, "LITTLE_ENDIAN");
            Integer intValue3 = bleDataEntity2.getIntValue(17, 16, byteOrder3);
            if (intValue3 != null) {
                String binaryString5 = Integer.toBinaryString(intValue3.intValue());
                Intrinsics.checkNotNullExpressionValue(binaryString5, "toBinaryString(...)");
                String padStart5 = StringsKt.padStart(binaryString5, 8, '0');
                String valueOf10 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart5, new IntRange(4, 7)), CharsKt.checkRadix(2)));
                String valueOf11 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart5, new IntRange(0, 3)), CharsKt.checkRadix(2)));
                Unit unit9 = Unit.INSTANCE;
                Unit unit10 = Unit.INSTANCE;
                str17 = valueOf11;
                str18 = valueOf10;
            } else {
                str18 = null;
                str17 = null;
            }
            ByteOrder byteOrder4 = ByteOrder.LITTLE_ENDIAN;
            Intrinsics.checkNotNullExpressionValue(byteOrder4, "LITTLE_ENDIAN");
            Integer intValue4 = bleDataEntity2.getIntValue(17, 17, byteOrder4);
            if (intValue4 != null) {
                String binaryString6 = Integer.toBinaryString(intValue4.intValue());
                Intrinsics.checkNotNullExpressionValue(binaryString6, "toBinaryString(...)");
                String padStart6 = StringsKt.padStart(binaryString6, 8, '0');
                String valueOf12 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart6, new IntRange(7, 7)), CharsKt.checkRadix(2)));
                String valueOf13 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart6, new IntRange(6, 6)), CharsKt.checkRadix(2)));
                String valueOf14 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart6, new IntRange(5, 5)), CharsKt.checkRadix(2)));
                String valueOf15 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart6, new IntRange(4, 4)), CharsKt.checkRadix(2)));
                String valueOf16 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart6, new IntRange(3, 3)), CharsKt.checkRadix(2)));
                Unit unit11 = Unit.INSTANCE;
                Unit unit12 = Unit.INSTANCE;
                str23 = valueOf16;
                str22 = valueOf12;
                str21 = valueOf13;
                str20 = valueOf14;
                str19 = valueOf15;
            } else {
                str23 = null;
                str22 = null;
                str21 = null;
                str20 = null;
                str19 = null;
            }
            Integer intValue$default5 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 18, (ByteOrder) null, 4, (Object) null);
            if (intValue$default5 != null) {
                String format = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(((double) intValue$default5.intValue()) / 10.0d)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                Unit unit13 = Unit.INSTANCE;
                Unit unit14 = Unit.INSTANCE;
                str24 = format;
            } else {
                str24 = null;
            }
            return new LogEntity(str, str3, LogEntity.mFWVer, LogEntity.mAppVer, str2, valueOf3, str5, str4, str27, str9, str15, str23, str24, str30, (String) null, str18, str28, str8, str16, str31, (String) null, str17, str22, str21, str20, str19, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, -66043904, LockFreeTaskQueueCore.MAX_CAPACITY_MASK, (DefaultConstructorMarker) null);
        }

        private final LogEntity createDeviceModeChange2Info(String str, String str2, String str3, BleDataEntity bleDataEntity) {
            String valueOf;
            String valueOf2;
            String valueOf3;
            String valueOf4;
            BleDataEntity bleDataEntity2 = bleDataEntity;
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            Intrinsics.checkNotNullExpressionValue(byteOrder, "LITTLE_ENDIAN");
            Integer intValue = bleDataEntity2.getIntValue(18, 7, byteOrder);
            int abs = Math.abs(-32768);
            Float f = null;
            if (intValue != null && intValue.intValue() == abs) {
                String num = Integer.toString(intValue.intValue(), CharsKt.checkRadix(10));
                Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
                valueOf = "UNDEFINED(-" + num + ")";
            } else {
                valueOf = String.valueOf(intValue != null ? Float.valueOf(((float) intValue.intValue()) / 100.0f) : null);
            }
            String str4 = valueOf;
            ByteOrder byteOrder2 = ByteOrder.LITTLE_ENDIAN;
            Intrinsics.checkNotNullExpressionValue(byteOrder2, "LITTLE_ENDIAN");
            Integer intValue2 = bleDataEntity2.getIntValue(18, 9, byteOrder2);
            int abs2 = Math.abs(-32768);
            if (intValue2 != null && intValue2.intValue() == abs2) {
                String num2 = Integer.toString(intValue2.intValue(), CharsKt.checkRadix(10));
                Intrinsics.checkNotNullExpressionValue(num2, "toString(...)");
                valueOf2 = "UNDEFINED(-" + num2 + ")";
            } else {
                valueOf2 = String.valueOf(intValue2 != null ? Float.valueOf(((float) intValue2.intValue()) / 100.0f) : null);
            }
            String str5 = valueOf2;
            ByteOrder byteOrder3 = ByteOrder.LITTLE_ENDIAN;
            Intrinsics.checkNotNullExpressionValue(byteOrder3, "LITTLE_ENDIAN");
            Integer intValue3 = bleDataEntity2.getIntValue(18, 11, byteOrder3);
            int abs3 = Math.abs(-32768);
            if (intValue3 != null && intValue3.intValue() == abs3) {
                String num3 = Integer.toString(intValue3.intValue(), CharsKt.checkRadix(10));
                Intrinsics.checkNotNullExpressionValue(num3, "toString(...)");
                valueOf3 = "UNDEFINED(-" + num3 + ")";
            } else {
                valueOf3 = String.valueOf(intValue3 != null ? Float.valueOf(((float) intValue3.intValue()) / 100.0f) : null);
            }
            String str6 = valueOf3;
            ByteOrder byteOrder4 = ByteOrder.LITTLE_ENDIAN;
            Intrinsics.checkNotNullExpressionValue(byteOrder4, "LITTLE_ENDIAN");
            Integer intValue4 = bleDataEntity2.getIntValue(18, 13, byteOrder4);
            int abs4 = Math.abs(-32768);
            if (intValue4 != null && intValue4.intValue() == abs4) {
                String num4 = Integer.toString(intValue4.intValue(), CharsKt.checkRadix(10));
                Intrinsics.checkNotNullExpressionValue(num4, "toString(...)");
                valueOf4 = "UNDEFINED(-" + num4 + ")";
            } else {
                if (intValue4 != null) {
                    f = Float.valueOf(((float) intValue4.intValue()) / 100.0f);
                }
                valueOf4 = String.valueOf(f);
            }
            return new LogEntity(str, str3, LogEntity.mFWVer, LogEntity.mAppVer, str2, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, str4, str5, str6, valueOf4, -32, 67108863, (DefaultConstructorMarker) null);
        }

        private final LogEntity createFanSettingMonitorInfo(String str, String str2, String str3, BleDataEntity bleDataEntity) {
            String valueOf = String.valueOf(BleDataEntity.getIntValue$default(bleDataEntity, 17, 7, (ByteOrder) null, 4, (Object) null));
            Integer intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 8, (ByteOrder) null, 4, (Object) null);
            String valueOf2 = intValue$default != null ? String.valueOf(intValue$default.intValue()) : null;
            Integer intValue$default2 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 9, (ByteOrder) null, 4, (Object) null);
            return new LogEntity(str, str3, LogEntity.mFWVer, LogEntity.mAppVer, str2, valueOf, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, valueOf2, intValue$default2 != null ? String.valueOf(intValue$default2.intValue()) : null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, -201326656, LockFreeTaskQueueCore.MAX_CAPACITY_MASK, (DefaultConstructorMarker) null);
        }

        private final LogEntity createSystemStatusMonitorInfo(String str, String str2, String str3, BleDataEntity bleDataEntity) {
            String str4;
            Integer intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 7, (ByteOrder) null, 4, (Object) null);
            if (intValue$default != null) {
                String binaryString = Integer.toBinaryString(intValue$default.intValue());
                Intrinsics.checkNotNullExpressionValue(binaryString, "toBinaryString(...)");
                str4 = String.valueOf(Integer.parseInt(StringsKt.substring(StringsKt.padStart(binaryString, 8, '0'), new IntRange(6, 7)), CharsKt.checkRadix(2)));
            } else {
                str4 = null;
            }
            return new LogEntity(str, str3, LogEntity.mFWVer, LogEntity.mAppVer, str2, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, str4, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, -268435488, LockFreeTaskQueueCore.MAX_CAPACITY_MASK, (DefaultConstructorMarker) null);
        }

        private final LogEntity createStatusMonitor15sec1Info(String str, String str2, String str3, BleDataEntity bleDataEntity) {
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            int i;
            String str10;
            String str11;
            String str12;
            String str13;
            String str14;
            String str15;
            BleDataEntity bleDataEntity2 = bleDataEntity;
            Integer intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 7, (ByteOrder) null, 4, (Object) null);
            String valueOf = intValue$default != null ? String.valueOf(intValue$default.intValue()) : null;
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            Intrinsics.checkNotNullExpressionValue(byteOrder, "LITTLE_ENDIAN");
            Integer intValue = bleDataEntity2.getIntValue(34, 8, byteOrder);
            if (intValue != null) {
                int intValue2 = intValue.intValue();
                if (intValue2 == -32768) {
                    String num = Integer.toString(intValue2, CharsKt.checkRadix(10));
                    Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
                    str15 = "UNDEFINED(" + num + ")";
                } else {
                    str15 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(((float) intValue2) / 100.0f)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str15, "format(...)");
                }
                str4 = str15;
            } else {
                str4 = null;
            }
            ByteOrder byteOrder2 = ByteOrder.LITTLE_ENDIAN;
            Intrinsics.checkNotNullExpressionValue(byteOrder2, "LITTLE_ENDIAN");
            Integer intValue3 = bleDataEntity2.getIntValue(34, 10, byteOrder2);
            if (intValue3 != null) {
                int intValue4 = intValue3.intValue();
                if (intValue4 == -32768) {
                    String num2 = Integer.toString(intValue4, CharsKt.checkRadix(10));
                    Intrinsics.checkNotNullExpressionValue(num2, "toString(...)");
                    str14 = "UNDEFINED(" + num2 + ")";
                } else {
                    str14 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(((float) intValue4) / 100.0f)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str14, "format(...)");
                }
                str5 = str14;
            } else {
                str5 = null;
            }
            String str16 = "%.2f";
            Integer intValue$default2 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 12, (ByteOrder) null, 4, (Object) null);
            if (intValue$default2 != null) {
                String binaryString = Integer.toBinaryString(intValue$default2.intValue());
                Intrinsics.checkNotNullExpressionValue(binaryString, "toBinaryString(...)");
                String padStart = StringsKt.padStart(binaryString, 8, '0');
                String valueOf2 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart, new IntRange(5, 7)), CharsKt.checkRadix(2)));
                String valueOf3 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart, new IntRange(2, 4)), CharsKt.checkRadix(2)));
                str8 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart, new IntRange(0, 1)), CharsKt.checkRadix(2)));
                str7 = valueOf2;
                str6 = valueOf3;
            } else {
                str8 = null;
                str7 = null;
                str6 = null;
            }
            ByteOrder byteOrder3 = ByteOrder.LITTLE_ENDIAN;
            Intrinsics.checkNotNullExpressionValue(byteOrder3, "LITTLE_ENDIAN");
            Integer intValue5 = bleDataEntity2.getIntValue(34, 13, byteOrder3);
            if (intValue5 != null) {
                int intValue6 = intValue5.intValue();
                i = -32768;
                if (intValue6 == -32768) {
                    String num3 = Integer.toString(intValue6, CharsKt.checkRadix(10));
                    Intrinsics.checkNotNullExpressionValue(num3, "toString(...)");
                    str13 = "UNDEFINED(" + num3 + ")";
                } else {
                    str13 = String.format(str16, Arrays.copyOf(new Object[]{Float.valueOf(((float) intValue6) / 100.0f)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str13, "format(...)");
                }
                str9 = str13;
            } else {
                i = -32768;
                str9 = null;
            }
            ByteOrder byteOrder4 = ByteOrder.LITTLE_ENDIAN;
            Intrinsics.checkNotNullExpressionValue(byteOrder4, "LITTLE_ENDIAN");
            Integer intValue7 = bleDataEntity2.getIntValue(34, 15, byteOrder4);
            if (intValue7 != null) {
                int intValue8 = intValue7.intValue();
                if (intValue8 == i) {
                    String num4 = Integer.toString(intValue8, CharsKt.checkRadix(10));
                    Intrinsics.checkNotNullExpressionValue(num4, "toString(...)");
                    str12 = "UNDEFINED(" + num4 + ")";
                } else {
                    str12 = String.format(str16, Arrays.copyOf(new Object[]{Float.valueOf(((float) intValue8) / 100.0f)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str12, "format(...)");
                }
                str10 = str12;
            } else {
                str10 = null;
            }
            ByteOrder byteOrder5 = ByteOrder.LITTLE_ENDIAN;
            Intrinsics.checkNotNullExpressionValue(byteOrder5, "LITTLE_ENDIAN");
            Integer intValue9 = bleDataEntity2.getIntValue(18, 17, byteOrder5);
            if (intValue9 == null || (str11 = intValue9.toString()) == null) {
                str11 = "";
            }
            return new LogEntity(str, str3, LogEntity.mFWVer, LogEntity.mAppVer, str2, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, str8, valueOf, str4, (String) null, str5, str9, (String) null, (String) null, str10, str11, (String) null, (String) null, str7, (String) null, str6, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, -1879048224, 1073740492, (DefaultConstructorMarker) null);
        }

        public final LogEntity createStatusMonitor15sec2Info(String str, String str2, String str3, BleDataEntity bleDataEntity) {
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            BleDataEntity bleDataEntity2 = bleDataEntity;
            Intrinsics.checkNotNullParameter(str, "aDate");
            Intrinsics.checkNotNullParameter(str3, "aOwnerId");
            Intrinsics.checkNotNullParameter(bleDataEntity2, "aEntity");
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            Intrinsics.checkNotNullExpressionValue(byteOrder, "LITTLE_ENDIAN");
            Integer intValue = bleDataEntity2.getIntValue(34, 7, byteOrder);
            if (intValue != null) {
                int intValue2 = intValue.intValue();
                if (intValue2 == -32768) {
                    String num = Integer.toString(intValue2, CharsKt.checkRadix(10));
                    Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
                    str11 = "UNDEFINED(" + num + ")";
                } else {
                    str11 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(((float) intValue2) / 100.0f)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str11, "format(...)");
                }
                str4 = str11;
            } else {
                str4 = null;
            }
            ByteOrder byteOrder2 = ByteOrder.LITTLE_ENDIAN;
            Intrinsics.checkNotNullExpressionValue(byteOrder2, "LITTLE_ENDIAN");
            Integer intValue3 = bleDataEntity2.getIntValue(34, 9, byteOrder2);
            if (intValue3 != null) {
                int intValue4 = intValue3.intValue();
                if (intValue4 == -32768) {
                    String num2 = Integer.toString(intValue4, CharsKt.checkRadix(10));
                    Intrinsics.checkNotNullExpressionValue(num2, "toString(...)");
                    str10 = "UNDEFINED(" + num2 + ")";
                } else {
                    str10 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(((float) intValue4) / 100.0f)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                }
                str5 = str10;
            } else {
                str5 = null;
            }
            String str12 = "%.2f";
            String str13 = "format(...)";
            Integer intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 11, (ByteOrder) null, 4, (Object) null);
            if (intValue$default == null || (str6 = intValue$default.toString()) == null) {
                str6 = "";
            }
            String str14 = str6;
            String valueOf = String.valueOf(BleDataEntity.getIntValue$default(bleDataEntity, 18, 12, (ByteOrder) null, 4, (Object) null));
            ByteOrder byteOrder3 = ByteOrder.LITTLE_ENDIAN;
            Intrinsics.checkNotNullExpressionValue(byteOrder3, "LITTLE_ENDIAN");
            Integer intValue5 = bleDataEntity2.getIntValue(34, 14, byteOrder3);
            if (intValue5 != null) {
                int intValue6 = intValue5.intValue();
                if (intValue6 == -32768) {
                    String num3 = Integer.toString(intValue6, CharsKt.checkRadix(10));
                    Intrinsics.checkNotNullExpressionValue(num3, "toString(...)");
                    str9 = "UNDEFINED(" + num3 + ")";
                } else {
                    str9 = String.format(str12, Arrays.copyOf(new Object[]{Float.valueOf(((float) intValue6) / 100.0f)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str9, str13);
                }
                str7 = str9;
            } else {
                str7 = null;
            }
            Integer intValue$default2 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 16, (ByteOrder) null, 4, (Object) null);
            if (intValue$default2 != null) {
                String binaryString = Integer.toBinaryString(intValue$default2.intValue());
                Intrinsics.checkNotNullExpressionValue(binaryString, "toBinaryString(...)");
                str8 = String.valueOf(Integer.parseInt(StringsKt.substring(StringsKt.padStart(binaryString, 8, '0'), new IntRange(5, 7)), CharsKt.checkRadix(2)));
            } else {
                str8 = null;
            }
            return new LogEntity(str, str3, LogEntity.mFWVer, LogEntity.mAppVer, str2, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, str7, (String) null, (String) null, str4, str5, (String) null, (String) null, valueOf, str14, (String) null, (String) null, (String) null, str8, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 2147483616, 1073739571, (DefaultConstructorMarker) null);
        }

        private final LogEntity createStatusMonitor60secInfo(String str, String str2, String str3, BleDataEntity bleDataEntity) {
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            String str12;
            String str13;
            String str14;
            String str15;
            String str16;
            String str17;
            String valueOf;
            String valueOf2;
            String str18;
            String str19;
            String str20;
            String str21;
            String str22;
            String str23;
            String str24;
            BleDataEntity bleDataEntity2 = bleDataEntity;
            Integer intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 7, (ByteOrder) null, 4, (Object) null);
            if (intValue$default != null) {
                String binaryString = Integer.toBinaryString(intValue$default.intValue());
                Intrinsics.checkNotNullExpressionValue(binaryString, "toBinaryString(...)");
                String padStart = StringsKt.padStart(binaryString, 8, '0');
                int parseInt = Integer.parseInt(StringsKt.substring(padStart, new IntRange(4, 7)), CharsKt.checkRadix(2));
                int parseInt2 = Integer.parseInt(StringsKt.substring(padStart, new IntRange(0, 3)), CharsKt.checkRadix(2));
                String valueOf3 = String.valueOf(parseInt);
                String valueOf4 = String.valueOf(parseInt2);
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
                str4 = valueOf4;
                str5 = valueOf3;
            } else {
                str5 = null;
                str4 = null;
            }
            Integer intValue$default2 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 8, (ByteOrder) null, 4, (Object) null);
            if (intValue$default2 != null) {
                String binaryString2 = Integer.toBinaryString(intValue$default2.intValue());
                Intrinsics.checkNotNullExpressionValue(binaryString2, "toBinaryString(...)");
                String padStart2 = StringsKt.padStart(binaryString2, 8, '0');
                String valueOf5 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart2, new IntRange(4, 7)), CharsKt.checkRadix(2)));
                String valueOf6 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart2, new IntRange(0, 3)), CharsKt.checkRadix(2)));
                Unit unit3 = Unit.INSTANCE;
                Unit unit4 = Unit.INSTANCE;
                str7 = valueOf6;
                str6 = valueOf5;
            } else {
                str7 = null;
                str6 = null;
            }
            String str25 = str7;
            String str26 = str6;
            Integer intValue$default3 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 9, (ByteOrder) null, 4, (Object) null);
            if (intValue$default3 != null) {
                String binaryString3 = Integer.toBinaryString(intValue$default3.intValue());
                Intrinsics.checkNotNullExpressionValue(binaryString3, "toBinaryString(...)");
                String padStart3 = StringsKt.padStart(binaryString3, 8, '0');
                String valueOf7 = !Intrinsics.areEqual((Object) str26, (Object) String.valueOf(CoolHeatStatusCode.OFF.getCode())) ? String.valueOf(Integer.parseInt(StringsKt.substring(padStart3, new IntRange(4, 7)), CharsKt.checkRadix(2))) : null;
                String valueOf8 = !Intrinsics.areEqual((Object) str25, (Object) String.valueOf(CoolHeatStatusCode.OFF.getCode())) ? String.valueOf(Integer.parseInt(StringsKt.substring(padStart3, new IntRange(0, 3)), CharsKt.checkRadix(2))) : null;
                Unit unit5 = Unit.INSTANCE;
                Unit unit6 = Unit.INSTANCE;
                str8 = valueOf8;
                str9 = valueOf7;
            } else {
                str9 = null;
                str8 = null;
            }
            Integer intValue$default4 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 10, (ByteOrder) null, 4, (Object) null);
            if (intValue$default4 != null) {
                String binaryString4 = Integer.toBinaryString(intValue$default4.intValue());
                Intrinsics.checkNotNullExpressionValue(binaryString4, "toBinaryString(...)");
                String padStart4 = StringsKt.padStart(binaryString4, 8, '0');
                str12 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart4, new IntRange(7, 7)), CharsKt.checkRadix(2)));
                str11 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart4, new IntRange(6, 6)), CharsKt.checkRadix(2)));
                Integer.parseInt(StringsKt.substring(padStart4, new IntRange(4, 5)), CharsKt.checkRadix(2));
                str10 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart4, new IntRange(3, 3)), CharsKt.checkRadix(2)));
                str13 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart4, new IntRange(2, 2)), CharsKt.checkRadix(2)));
                Unit unit7 = Unit.INSTANCE;
                Unit unit8 = Unit.INSTANCE;
            } else {
                str13 = null;
                str12 = null;
                str11 = null;
                str10 = null;
            }
            String str27 = "5";
            if (str12 == null || str11 == null) {
                str14 = null;
            } else {
                str14 = (!Intrinsics.areEqual((Object) str12, (Object) "1") || !Intrinsics.areEqual((Object) str11, (Object) "0")) ? (!Intrinsics.areEqual((Object) str12, (Object) "0") || !Intrinsics.areEqual((Object) str11, (Object) "1")) ? (!Intrinsics.areEqual((Object) str12, (Object) "1") || !Intrinsics.areEqual((Object) str11, (Object) "1")) ? "0" : str27 : "4" : "1";
            }
            if (str10 == null || str13 == null) {
                str15 = null;
            } else {
                if (Intrinsics.areEqual((Object) str10, (Object) "1") && Intrinsics.areEqual((Object) str13, (Object) "0")) {
                    str27 = "1";
                } else if (Intrinsics.areEqual((Object) str10, (Object) "0") && Intrinsics.areEqual((Object) str13, (Object) "1")) {
                    str27 = "4";
                } else if (!Intrinsics.areEqual((Object) str10, (Object) "1") || !Intrinsics.areEqual((Object) str13, (Object) "1")) {
                    str27 = "0";
                }
                str15 = str27;
            }
            Integer intValue$default5 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 11, (ByteOrder) null, 4, (Object) null);
            if (intValue$default5 != null) {
                String valueOf9 = String.valueOf(intValue$default5.intValue());
                Unit unit9 = Unit.INSTANCE;
                Unit unit10 = Unit.INSTANCE;
                str16 = valueOf9;
            } else {
                str16 = null;
            }
            Integer intValue$default6 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 12, (ByteOrder) null, 4, (Object) null);
            if (intValue$default6 != null) {
                String valueOf10 = String.valueOf(intValue$default6.intValue());
                Unit unit11 = Unit.INSTANCE;
                Unit unit12 = Unit.INSTANCE;
                str17 = valueOf10;
            } else {
                str17 = null;
            }
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            Intrinsics.checkNotNullExpressionValue(byteOrder, "LITTLE_ENDIAN");
            Integer intValue = bleDataEntity2.getIntValue(34, 13, byteOrder);
            if (intValue != null && intValue.intValue() == -32768) {
                String num = Integer.toString(intValue.intValue(), CharsKt.checkRadix(10));
                Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
                valueOf = "UNDEFINED(" + num + ")";
            } else {
                valueOf = String.valueOf(intValue != null ? Float.valueOf(((float) intValue.intValue()) / 100.0f) : null);
            }
            String str28 = valueOf;
            ByteOrder byteOrder2 = ByteOrder.LITTLE_ENDIAN;
            Intrinsics.checkNotNullExpressionValue(byteOrder2, "LITTLE_ENDIAN");
            Integer intValue2 = bleDataEntity2.getIntValue(34, 15, byteOrder2);
            if (intValue2 != null && intValue2.intValue() == -32768) {
                String num2 = Integer.toString(intValue2.intValue(), CharsKt.checkRadix(10));
                Intrinsics.checkNotNullExpressionValue(num2, "toString(...)");
                valueOf2 = "UNDEFINED(" + num2 + ")";
            } else {
                valueOf2 = String.valueOf(intValue2 != null ? Float.valueOf(((float) intValue2.intValue()) / 100.0f) : null);
            }
            String str29 = valueOf2;
            Integer intValue$default7 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 17, (ByteOrder) null, 4, (Object) null);
            if (intValue$default7 != null) {
                String binaryString5 = Integer.toBinaryString(intValue$default7.intValue());
                Intrinsics.checkNotNullExpressionValue(binaryString5, "toBinaryString(...)");
                String padStart5 = StringsKt.padStart(binaryString5, 8, '0');
                String valueOf11 = !Intrinsics.areEqual((Object) str26, (Object) String.valueOf(CoolHeatStatusCode.OFF.getCode())) ? String.valueOf(Integer.parseInt(StringsKt.substring(padStart5, new IntRange(4, 7)), CharsKt.checkRadix(2))) : null;
                String valueOf12 = !Intrinsics.areEqual((Object) str25, (Object) String.valueOf(CoolHeatStatusCode.OFF.getCode())) ? String.valueOf(Integer.parseInt(StringsKt.substring(padStart5, new IntRange(0, 3)), CharsKt.checkRadix(2))) : null;
                Unit unit13 = Unit.INSTANCE;
                Unit unit14 = Unit.INSTANCE;
                str18 = valueOf12;
                str19 = valueOf11;
            } else {
                str19 = null;
                str18 = null;
            }
            Integer intValue$default8 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 18, (ByteOrder) null, 4, (Object) null);
            if (intValue$default8 != null) {
                String binaryString6 = Integer.toBinaryString(intValue$default8.intValue());
                Intrinsics.checkNotNullExpressionValue(binaryString6, "toBinaryString(...)");
                String padStart6 = StringsKt.padStart(binaryString6, 8, '0');
                String valueOf13 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart6, new IntRange(7, 7)), CharsKt.checkRadix(2)));
                String valueOf14 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart6, new IntRange(6, 6)), CharsKt.checkRadix(2)));
                String valueOf15 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart6, new IntRange(5, 5)), CharsKt.checkRadix(2)));
                String valueOf16 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart6, new IntRange(4, 4)), CharsKt.checkRadix(2)));
                String valueOf17 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart6, new IntRange(3, 3)), CharsKt.checkRadix(2)));
                Unit unit15 = Unit.INSTANCE;
                Unit unit16 = Unit.INSTANCE;
                str21 = valueOf17;
                str20 = valueOf13;
                str24 = valueOf14;
                str23 = valueOf15;
                str22 = valueOf16;
            } else {
                str24 = null;
                str23 = null;
                str22 = null;
                str21 = null;
                str20 = null;
            }
            return new LogEntity(str, str3, LogEntity.mFWVer, LogEntity.mAppVer, str2, (String) null, str5, str4, str26, str9, str14, (String) null, (String) null, (String) null, str28, str19, str25, str8, str15, (String) null, str29, str18, str24, str23, str22, str21, str16, str17, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, str20, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, -267896800, 1073741311, (DefaultConstructorMarker) null);
        }

        private final LogEntity createPaidMembershipStatusInfo(String str, String str2, String str3, BleDataEntity bleDataEntity) {
            Integer intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 7, (ByteOrder) null, 4, (Object) null);
            String str4 = null;
            String num = intValue$default != null ? intValue$default.toString() : null;
            Integer intValue$default2 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 8, (ByteOrder) null, 4, (Object) null);
            String num2 = intValue$default2 != null ? intValue$default2.toString() : null;
            Integer intValue$default3 = BleDataEntity.getIntValue$default(bleDataEntity, 20, 9, (ByteOrder) null, 4, (Object) null);
            if (intValue$default3 != null) {
                str4 = intValue$default3.toString();
            }
            return new LogEntity(str, str3, LogEntity.mFWVer, LogEntity.mAppVer, str2, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, num, num2, str4, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, -32, 1073713151, (DefaultConstructorMarker) null);
        }

        private final LogEntity createTagStatusInfo(String str, String str2, String str3, BleDataEntity bleDataEntity) {
            String valueOf;
            String valueOf2;
            String valueOf3;
            String valueOf4;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            BleDataEntity bleDataEntity2 = bleDataEntity;
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            Intrinsics.checkNotNullExpressionValue(byteOrder, "LITTLE_ENDIAN");
            Integer intValue = bleDataEntity2.getIntValue(34, 7, byteOrder);
            String str9 = null;
            if (intValue != null && intValue.intValue() == 65535) {
                String num = Integer.toString(intValue.intValue(), CharsKt.checkRadix(10));
                Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
                valueOf = "UNDEFINED(" + num + ")";
            } else {
                valueOf = String.valueOf(intValue != null ? Float.valueOf(((float) intValue.intValue()) / 100.0f) : null);
            }
            String str10 = valueOf;
            ByteOrder byteOrder2 = ByteOrder.LITTLE_ENDIAN;
            Intrinsics.checkNotNullExpressionValue(byteOrder2, "LITTLE_ENDIAN");
            Integer intValue2 = bleDataEntity2.getIntValue(34, 9, byteOrder2);
            if (intValue2 != null && intValue2.intValue() == 65535) {
                String num2 = Integer.toString(intValue2.intValue(), CharsKt.checkRadix(10));
                Intrinsics.checkNotNullExpressionValue(num2, "toString(...)");
                valueOf2 = "UNDEFINED(" + num2 + ")";
            } else {
                valueOf2 = String.valueOf(intValue2 != null ? Float.valueOf(((float) intValue2.intValue()) / 100.0f) : null);
            }
            String str11 = valueOf2;
            ByteOrder byteOrder3 = ByteOrder.LITTLE_ENDIAN;
            Intrinsics.checkNotNullExpressionValue(byteOrder3, "LITTLE_ENDIAN");
            Integer intValue3 = bleDataEntity2.getIntValue(34, 11, byteOrder3);
            if (intValue3 != null && intValue3.intValue() == 65535) {
                String num3 = Integer.toString(intValue3.intValue(), CharsKt.checkRadix(10));
                Intrinsics.checkNotNullExpressionValue(num3, "toString(...)");
                valueOf3 = "UNDEFINED(" + num3 + ")";
            } else {
                valueOf3 = String.valueOf(intValue3 != null ? Float.valueOf(((float) intValue3.intValue()) / 100.0f) : null);
            }
            String str12 = valueOf3;
            ByteOrder byteOrder4 = ByteOrder.LITTLE_ENDIAN;
            Intrinsics.checkNotNullExpressionValue(byteOrder4, "LITTLE_ENDIAN");
            Integer intValue4 = bleDataEntity2.getIntValue(34, 13, byteOrder4);
            if (intValue4 != null && intValue4.intValue() == 65535) {
                String num4 = Integer.toString(intValue4.intValue(), CharsKt.checkRadix(10));
                Intrinsics.checkNotNullExpressionValue(num4, "toString(...)");
                valueOf4 = "UNDEFINED(" + num4 + ")";
            } else {
                valueOf4 = String.valueOf(intValue4 != null ? Float.valueOf(((float) intValue4.intValue()) / 100.0f) : null);
            }
            String str13 = valueOf4;
            Integer intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 15, (ByteOrder) null, 4, (Object) null);
            if (intValue$default != null) {
                String binaryString = Integer.toBinaryString(intValue$default.intValue());
                Intrinsics.checkNotNullExpressionValue(binaryString, "toBinaryString(...)");
                String padStart = StringsKt.padStart(binaryString, 8, '0');
                String valueOf5 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart, new IntRange(6, 7)), CharsKt.checkRadix(10)));
                String valueOf6 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart, new IntRange(4, 5)), CharsKt.checkRadix(10)));
                String valueOf7 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart, new IntRange(2, 3)), CharsKt.checkRadix(10)));
                String valueOf8 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart, new IntRange(1, 1)), CharsKt.checkRadix(10)));
                str4 = String.valueOf(Integer.parseInt(StringsKt.substring(padStart, new IntRange(0, 0)), CharsKt.checkRadix(10)));
                str8 = valueOf5;
                str7 = valueOf6;
                str6 = valueOf7;
                str5 = valueOf8;
            } else {
                str8 = null;
                str7 = null;
                str6 = null;
                str5 = null;
                str4 = null;
            }
            Integer intValue$default2 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 7, (ByteOrder) null, 4, (Object) null);
            if (intValue$default2 != null) {
                str9 = intValue$default2.toString();
            }
            return new LogEntity(str, str3, LogEntity.mFWVer, LogEntity.mAppVer, str2, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, str10, str11, str12, str13, str8, str7, str6, str5, str4, str9, (String) null, (String) null, (String) null, (String) null, -32, 1006698495, (DefaultConstructorMarker) null);
        }

        public final LogEntity createAnomalyDetectionTypeInfo(String str, String str2, String str3, BleDataEntity bleDataEntity) {
            Intrinsics.checkNotNullParameter(str, "aDate");
            Intrinsics.checkNotNullParameter(str3, "aOwnerId");
            Intrinsics.checkNotNullParameter(bleDataEntity, "aEntity");
            Integer intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 7, (ByteOrder) null, 4, (Object) null);
            return new LogEntity(str, str3, LogEntity.mFWVer, LogEntity.mAppVer, str2, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, intValue$default != null ? intValue$default.toString() : null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, -32, 1073709055, (DefaultConstructorMarker) null);
        }
    }
}
