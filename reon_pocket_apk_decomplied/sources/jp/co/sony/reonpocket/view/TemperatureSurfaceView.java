package jp.co.sony.reonpocket.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Message;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Locale;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.util.DensityUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b&*\u0001\u0017\b\u0007\u0018\u0000 \u00012\u00020\u0001:\u0004\u0001\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010a\u001a\u00020\nH\u0002J\u0010\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020eH\u0002J\u0010\u0010f\u001a\u00020c2\u0006\u0010d\u001a\u00020eH\u0002J\u0010\u0010g\u001a\u00020c2\u0006\u0010d\u001a\u00020eH\u0002J\u0010\u0010h\u001a\u00020c2\u0006\u0010d\u001a\u00020eH\u0002J\u0010\u0010i\u001a\u00020c2\u0006\u0010d\u001a\u00020eH\u0002J\u0010\u0010j\u001a\u00020c2\u0006\u0010d\u001a\u00020eH\u0002J\u0010\u0010k\u001a\u00020c2\u0006\u0010d\u001a\u00020eH\u0002J\b\u0010l\u001a\u00020cH\u0002J\u001a\u0010m\u001a\u00020c2\u0006\u0010n\u001a\u00020\u00032\b\u0010o\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010p\u001a\u00020cH\u0002J\b\u0010q\u001a\u00020cH\u0002J\u0010\u0010r\u001a\u00020c2\u0006\u0010s\u001a\u00020eH\u0014J0\u0010t\u001a\u00020c2\u0006\u0010u\u001a\u00020\u00112\u0006\u0010v\u001a\u00020\u00072\u0006\u0010w\u001a\u00020\u00072\u0006\u0010x\u001a\u00020\u00072\u0006\u0010y\u001a\u00020\u0007H\u0014J\u000e\u0010z\u001a\u00020c2\u0006\u0010{\u001a\u00020\u0011J\u000e\u0010|\u001a\u00020c2\u0006\u0010{\u001a\u00020\u0011J\u000e\u0010}\u001a\u00020c2\u0006\u0010~\u001a\u00020\u0011J!\u0010\u001a\u00020c2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\u0011J\u0010\u0010\u0001\u001a\u00020c2\u0007\u0010\u0001\u001a\u00020\nJ\u0010\u0010\u0001\u001a\u00020c2\u0007\u0010\u0001\u001a\u00020\nJ\u0019\u0010\u0001\u001a\u00020c2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0013j\b\u0012\u0004\u0012\u00020\u0007`\u0014X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0013j\b\u0012\u0004\u0012\u00020\u0007`\u0014X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$XD¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010+R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010V\u001a\b\u0012\u0004\u0012\u00020\n0WX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020_X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010`\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0013j\b\u0012\u0004\u0012\u00020\n`\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Ljp/co/sony/reonpocket/view/TemperatureSurfaceView;", "Ljp/co/sony/reonpocket/view/CustomAccessibilityView;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MAX_TEMPERATURE", "", "MIN_TEMPERATURE", "SMART_COOL_MAX_TEMPERATURE", "SMART_COOL_MIN_TEMPERATURE", "SMART_WARM_MAX_TEMPERATURE", "SMART_WARM_MIN_TEMPERATURE", "animationRunning", "", "arcAlphas", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "circleAlphas", "handler", "jp/co/sony/reonpocket/view/TemperatureSurfaceView$handler$1", "Ljp/co/sony/reonpocket/view/TemperatureSurfaceView$handler$1;", "isDisplayAnimation", "isDisplayTarget", "mBackgroundPaint", "Landroid/graphics/Paint;", "mDefaultCoolEndColor", "mDefaultCoolMidColor", "mDefaultStartColor", "mDefaultTargetTemperatureViewHeight", "mDefaultWarmEndColor", "mDefaultWarmMidColor", "mDelayMilliseconds", "", "mDistance", "mEndColor", "mIconBackgroundPaint", "mIconImageView", "Landroidx/appcompat/widget/AppCompatImageView;", "mIconResId", "Ljava/lang/Integer;", "mIconResource", "Landroid/graphics/drawable/Drawable;", "mIconSize", "mIconTopX", "mIconTopY", "mIsDifferentTargetTemp", "mIsWeakState", "mLineColor", "mLineHeight", "mLineTopY", "mLowerGradientPaint", "mMaxHeight", "mMiddleLowerGradientPaint", "mMiddleUpperGradientPaint", "mMinHeight", "mPath", "Landroid/graphics/Path;", "mReonTargetTemperature", "mRippleArcPaint", "mRippleCirclePaint", "mRippleMaxRadius", "mRippleMinRadius", "mSpreadPaint", "mStartColor", "mTargetTemperature", "mTargetTemperatureMax", "mTargetTemperatureMin", "mTargetTemperatureTextColor", "mTargetTemperatureTextMarginX", "mTargetTemperatureTextMaxCenterY", "mTargetTemperatureTextMinCenterY", "mTargetTemperatureViewColor", "mTargetTemperatureViewHeight", "mTargetTemperatureViewMinTopY", "mTargetTemperatureViewTopY", "mTargetText", "", "mTargetTextPaint", "mTargetViewPaint", "mTecTempLinePaint", "mTecTemperature", "mTecTemperatureCenterY", "mTempRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "mUpperGradientPaint", "maxArcAlpha", "maxCircleAlpha", "maxRippleIndex", "misOff", "rippleIndex", "runnable", "Ljava/lang/Runnable;", "spreadRadius", "checkTargetTemp", "drawBackground", "", "aCanvas", "Landroid/graphics/Canvas;", "drawLineAndIcon", "drawRippleEffect", "drawSmartCoolGradientBackground", "drawSmartGradientBackground", "drawTargetText", "drawTargetView", "initAlpha", "initAttrs", "aContext", "aAttrs", "initRadius", "initVariable", "onDraw", "canvas", "onLayout", "changed", "l", "t", "r", "b", "setIsDisplayAnimation", "aIsDisplay", "setIsDisplayTarget", "setOff", "aIsOff", "setTargetTemperature", "temperature", "reonTargetTemp", "isWeakState", "setTecRate", "aRate", "setTecTemperature", "setTemp", "aMaxTemp", "aMinTemp", "Companion", "TemperatureType", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TemperatureSurfaceView.kt */
public final class TemperatureSurfaceView extends CustomAccessibilityView {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static float RIPPLE_MAX_RADIUS = 160.0f;
    private float MAX_TEMPERATURE;
    private float MIN_TEMPERATURE;
    private final float SMART_COOL_MAX_TEMPERATURE;
    private final float SMART_COOL_MIN_TEMPERATURE;
    private final float SMART_WARM_MAX_TEMPERATURE;
    private final float SMART_WARM_MIN_TEMPERATURE;
    private boolean animationRunning;
    private final ArrayList<Integer> arcAlphas;
    private final ArrayList<Integer> circleAlphas;
    private final TemperatureSurfaceView$handler$1 handler;
    private boolean isDisplayAnimation;
    private boolean isDisplayTarget;
    private final Paint mBackgroundPaint;
    private final Context mContext;
    private final int mDefaultCoolEndColor;
    private final int mDefaultCoolMidColor;
    private final int mDefaultStartColor;
    private float mDefaultTargetTemperatureViewHeight;
    private final int mDefaultWarmEndColor;
    private final int mDefaultWarmMidColor;
    private final long mDelayMilliseconds;
    private float mDistance;
    private final int mEndColor;
    private final Paint mIconBackgroundPaint;
    private AppCompatImageView mIconImageView;
    private Integer mIconResId;
    private Drawable mIconResource;
    private float mIconSize;
    private int mIconTopX;
    private int mIconTopY;
    private boolean mIsDifferentTargetTemp;
    private boolean mIsWeakState;
    private int mLineColor;
    private float mLineHeight;
    private int mLineTopY;
    private Paint mLowerGradientPaint;
    private float mMaxHeight;
    private Paint mMiddleLowerGradientPaint;
    private Paint mMiddleUpperGradientPaint;
    private float mMinHeight;
    private final Path mPath;
    private float mReonTargetTemperature;
    private final Paint mRippleArcPaint;
    private final Paint mRippleCirclePaint;
    private float mRippleMaxRadius;
    private float mRippleMinRadius;
    private final Paint mSpreadPaint;
    private final int mStartColor;
    private float mTargetTemperature;
    private float mTargetTemperatureMax;
    private float mTargetTemperatureMin;
    private int mTargetTemperatureTextColor;
    private float mTargetTemperatureTextMarginX;
    private float mTargetTemperatureTextMaxCenterY;
    private final float mTargetTemperatureTextMinCenterY;
    private int mTargetTemperatureViewColor;
    private float mTargetTemperatureViewHeight;
    private float mTargetTemperatureViewMinTopY;
    private float mTargetTemperatureViewTopY;
    private final String mTargetText;
    private final Paint mTargetTextPaint;
    private final Paint mTargetViewPaint;
    private final Paint mTecTempLinePaint;
    private float mTecTemperature;
    private float mTecTemperatureCenterY;
    private ClosedFloatingPointRange<Float> mTempRange;
    private Paint mUpperGradientPaint;
    private final int maxArcAlpha;
    private final int maxCircleAlpha;
    /* access modifiers changed from: private */
    public int maxRippleIndex;
    private boolean misOff;
    /* access modifiers changed from: private */
    public int rippleIndex;
    private final Runnable runnable;
    private final ArrayList<Float> spreadRadius;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TemperatureSurfaceView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                jp.co.sony.reonpocket.view.TemperatureSurfaceView$TemperatureType[] r0 = jp.co.sony.reonpocket.view.TemperatureSurfaceView.TemperatureType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.view.TemperatureSurfaceView$TemperatureType r1 = jp.co.sony.reonpocket.view.TemperatureSurfaceView.TemperatureType.UPPER     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                jp.co.sony.reonpocket.view.TemperatureSurfaceView$TemperatureType r1 = jp.co.sony.reonpocket.view.TemperatureSurfaceView.TemperatureType.NORMAL     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                jp.co.sony.reonpocket.view.TemperatureSurfaceView$TemperatureType r1 = jp.co.sony.reonpocket.view.TemperatureSurfaceView.TemperatureType.LOWER     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.view.TemperatureSurfaceView.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TemperatureSurfaceView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "mContext");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TemperatureSurfaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "mContext");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TemperatureSurfaceView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TemperatureSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.mContext = context;
        this.SMART_COOL_MIN_TEMPERATURE = 20.0f;
        this.SMART_COOL_MAX_TEMPERATURE = 33.0f;
        this.SMART_WARM_MIN_TEMPERATURE = 33.0f;
        this.SMART_WARM_MAX_TEMPERATURE = 43.0f;
        this.MAX_TEMPERATURE = 33.0f;
        this.MIN_TEMPERATURE = 20.0f;
        this.mTempRange = RangesKt.rangeTo(20.0f, 33.0f);
        this.mDefaultStartColor = context.getColor(R.color.SmartModeCoolBottomGradient);
        this.mDefaultCoolMidColor = context.getColor(R.color.SmartModeCoolMiddleGradient);
        this.mDefaultCoolEndColor = context.getColor(R.color.TemperatureBarCoolTop);
        this.mDefaultWarmMidColor = context.getColor(R.color.TemperatureBarSmartWarmMid);
        this.mDefaultWarmEndColor = context.getColor(R.color.TemperatureBarSmartWarmBottom);
        this.mUpperGradientPaint = new Paint();
        this.mLowerGradientPaint = new Paint();
        this.mMiddleUpperGradientPaint = new Paint();
        this.mMiddleLowerGradientPaint = new Paint();
        this.mBackgroundPaint = new Paint();
        this.mTargetViewPaint = new Paint();
        this.mTargetTextPaint = new Paint();
        this.mTecTempLinePaint = new Paint();
        this.mIconBackgroundPaint = new Paint();
        this.mRippleArcPaint = new Paint();
        this.mRippleCirclePaint = new Paint();
        this.mStartColor = context.getColor(R.color.LevelAutoTopCool);
        this.mEndColor = context.getColor(R.color.colorPrimary);
        String string = context.getString(R.string.mainview_content_target_temperature);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.mTargetText = string;
        this.mTecTemperature = 27.0f;
        this.mTargetTemperature = 29.0f;
        this.mSpreadPaint = new Paint();
        this.mDistance = 5.0f;
        this.mDelayMilliseconds = 33;
        this.spreadRadius = new ArrayList<>();
        this.arcAlphas = new ArrayList<>();
        this.circleAlphas = new ArrayList<>();
        this.maxArcAlpha = 236;
        this.maxCircleAlpha = 118;
        this.maxRippleIndex = 60;
        this.mIconImageView = new AppCompatImageView(context);
        initAttrs(context, attributeSet);
        initVariable();
        this.handler = new TemperatureSurfaceView$handler$1(this);
        this.runnable = new TemperatureSurfaceView$$ExternalSyntheticLambda1(this);
        this.isDisplayAnimation = true;
        this.isDisplayTarget = true;
        this.mPath = new Path();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reonpocket/view/TemperatureSurfaceView$Companion;", "", "()V", "RIPPLE_MAX_RADIUS", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TemperatureSurfaceView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Ljp/co/sony/reonpocket/view/TemperatureSurfaceView$TemperatureType;", "", "(Ljava/lang/String;I)V", "UPPER", "NORMAL", "LOWER", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TemperatureSurfaceView.kt */
    public enum TemperatureType {
        UPPER,
        NORMAL,
        LOWER;

        public static EnumEntries<TemperatureType> getEntries() {
            return $ENTRIES;
        }

        static {
            TemperatureType[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    public final void setTemp(float f, float f2) {
        this.MAX_TEMPERATURE = f;
        this.MIN_TEMPERATURE = f2;
    }

    /* access modifiers changed from: private */
    public static final void runnable$lambda$0(TemperatureSurfaceView temperatureSurfaceView) {
        Intrinsics.checkNotNullParameter(temperatureSurfaceView, "this$0");
        while (!Thread.currentThread().isInterrupted() && temperatureSurfaceView.animationRunning) {
            try {
                Thread.sleep(33);
                Message message = new Message();
                message.what = 1;
                temperatureSurfaceView.handler.sendMessage(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        temperatureSurfaceView.animationRunning = false;
    }

    public final void setTargetTemperature(float f, float f2, boolean z) {
        this.mTargetTemperature = f;
        this.mReonTargetTemperature = f2;
        this.mIsWeakState = z;
        invalidate();
    }

    public final void setTecTemperature(float f) {
        this.mTecTemperature = f;
        invalidate();
    }

    private final void initVariable() {
        this.mTargetViewPaint.setColor(this.mContext.getColor(R.color.SmartModeCoolTargetArea));
        this.mTargetTextPaint.setColor(this.mContext.getColor(R.color.InversePrimaryText));
        this.mTargetTextPaint.setTextSize(getResources().getDimension(R.dimen.targetTemperatureTextSize));
        this.mTecTempLinePaint.setColor(this.mContext.getColor(R.color.colorWhite));
        this.mIconBackgroundPaint.setColor(this.mContext.getColor(R.color.colorWhite));
        this.mTargetTemperatureTextMarginX = getResources().getDimension(R.dimen.targetTemperatureLeftPadding);
        this.mLineHeight = (float) getResources().getDimensionPixelSize(R.dimen.lineIndicatorWidth);
    }

    private final void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.TemperatureSurfaceView, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            float dimension = obtainStyledAttributes.getDimension(R.styleable.TemperatureSurfaceView_iconSize, 48.0f);
            this.mIconSize = dimension;
            RIPPLE_MAX_RADIUS = dimension * ((float) 2);
            this.mIconResource = obtainStyledAttributes.getDrawable(R.styleable.TemperatureSurfaceView_iconRes);
            float f = this.mIconSize;
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams((int) f, (int) f);
            AppCompatImageView appCompatImageView = this.mIconImageView;
            if (appCompatImageView != null) {
                appCompatImageView.setLayoutParams(layoutParams);
            }
            AppCompatImageView appCompatImageView2 = this.mIconImageView;
            if (appCompatImageView2 != null) {
                appCompatImageView2.setImageDrawable(this.mIconResource);
            }
            AppCompatImageView appCompatImageView3 = this.mIconImageView;
            if (appCompatImageView3 != null) {
                appCompatImageView3.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.mRippleArcPaint.setAntiAlias(true);
            this.mRippleArcPaint.setStyle(Paint.Style.STROKE);
            this.mRippleArcPaint.setStrokeWidth((float) DensityUtil.INSTANCE.dip2px(context, 2.0f));
            this.mRippleArcPaint.setStrokeCap(Paint.Cap.ROUND);
            this.mRippleArcPaint.setColor(-1);
            this.mRippleCirclePaint.setColor(-1);
            initAlpha();
            initRadius();
            DebugLogUtil.INSTANCE.d("initAttrs");
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private final void initRadius() {
        this.spreadRadius.clear();
        this.mDistance = (this.mRippleMaxRadius - this.mRippleMinRadius) / ((float) 60);
        float f = 0.0f;
        for (int i = 1; i < 61; i++) {
            f += this.mDistance;
            this.spreadRadius.add(Float.valueOf(f));
        }
    }

    private final void initAlpha() {
        this.arcAlphas.clear();
        int i = this.maxArcAlpha;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(i, 0, -4);
        if (progressionLastElement <= i) {
            while (true) {
                this.arcAlphas.add(Integer.valueOf(i));
                if (i == progressionLastElement) {
                    break;
                }
                i -= 4;
            }
        }
        this.circleAlphas.clear();
        int i2 = this.maxCircleAlpha;
        int progressionLastElement2 = ProgressionUtilKt.getProgressionLastElement(i2, 0, -2);
        if (progressionLastElement2 <= i2) {
            while (true) {
                this.circleAlphas.add(Integer.valueOf(i2));
                if (i2 != progressionLastElement2) {
                    i2 -= 2;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0111, code lost:
        if (r4 > r0) goto L_0x010b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r9) {
        /*
            r8 = this;
            java.lang.String r0 = "canvas"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            super.onDraw(r9)
            float r0 = r8.MAX_TEMPERATURE
            float r1 = r8.SMART_WARM_MAX_TEMPERATURE
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x001c
            float r0 = r8.MIN_TEMPERATURE
            float r1 = r8.SMART_COOL_MIN_TEMPERATURE
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x001c
            r8.drawSmartGradientBackground(r9)
            goto L_0x001f
        L_0x001c:
            r8.drawSmartCoolGradientBackground(r9)
        L_0x001f:
            boolean r0 = r8.misOff
            if (r0 == 0) goto L_0x0024
            return
        L_0x0024:
            float r0 = r8.MAX_TEMPERATURE
            float r1 = r8.SMART_WARM_MAX_TEMPERATURE
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            r2 = 1
            if (r1 != 0) goto L_0x0045
            float r1 = r8.mReonTargetTemperature
            float r3 = (float) r2
            float r0 = r0 - r3
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0038
            jp.co.sony.reonpocket.view.TemperatureSurfaceView$TemperatureType r0 = jp.co.sony.reonpocket.view.TemperatureSurfaceView.TemperatureType.UPPER
            goto L_0x005c
        L_0x0038:
            float r0 = r8.MIN_TEMPERATURE
            float r0 = r0 + r3
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0042
            jp.co.sony.reonpocket.view.TemperatureSurfaceView$TemperatureType r0 = jp.co.sony.reonpocket.view.TemperatureSurfaceView.TemperatureType.LOWER
            goto L_0x005c
        L_0x0042:
            jp.co.sony.reonpocket.view.TemperatureSurfaceView$TemperatureType r0 = jp.co.sony.reonpocket.view.TemperatureSurfaceView.TemperatureType.NORMAL
            goto L_0x005c
        L_0x0045:
            float r1 = r8.mReonTargetTemperature
            float r3 = (float) r2
            float r0 = r0 - r3
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0050
            jp.co.sony.reonpocket.view.TemperatureSurfaceView$TemperatureType r0 = jp.co.sony.reonpocket.view.TemperatureSurfaceView.TemperatureType.UPPER
            goto L_0x005c
        L_0x0050:
            float r0 = r8.MIN_TEMPERATURE
            float r0 = r0 + r3
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x005a
            jp.co.sony.reonpocket.view.TemperatureSurfaceView$TemperatureType r0 = jp.co.sony.reonpocket.view.TemperatureSurfaceView.TemperatureType.LOWER
            goto L_0x005c
        L_0x005a:
            jp.co.sony.reonpocket.view.TemperatureSurfaceView$TemperatureType r0 = jp.co.sony.reonpocket.view.TemperatureSurfaceView.TemperatureType.NORMAL
        L_0x005c:
            float r1 = r8.mTecTemperature
            float r3 = r8.MAX_TEMPERATURE
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x0067
            jp.co.sony.reonpocket.view.TemperatureSurfaceView$TemperatureType r1 = jp.co.sony.reonpocket.view.TemperatureSurfaceView.TemperatureType.LOWER
            goto L_0x0072
        L_0x0067:
            float r3 = r8.MIN_TEMPERATURE
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x0070
            jp.co.sony.reonpocket.view.TemperatureSurfaceView$TemperatureType r1 = jp.co.sony.reonpocket.view.TemperatureSurfaceView.TemperatureType.UPPER
            goto L_0x0072
        L_0x0070:
            jp.co.sony.reonpocket.view.TemperatureSurfaceView$TemperatureType r1 = jp.co.sony.reonpocket.view.TemperatureSurfaceView.TemperatureType.NORMAL
        L_0x0072:
            float r3 = r8.checkTargetTemp()
            int[] r4 = jp.co.sony.reonpocket.view.TemperatureSurfaceView.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r4[r0]
            r4 = 0
            r5 = 3
            r6 = 2
            if (r0 == r2) goto L_0x00d4
            if (r0 == r6) goto L_0x0096
            if (r0 != r5) goto L_0x0090
            int r0 = r8.getHeight()
            float r0 = (float) r0
            float r3 = r8.mTargetTemperatureViewHeight
            float r0 = r0 - r3
            goto L_0x00d5
        L_0x0090:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        L_0x0096:
            boolean r0 = r8.mIsWeakState
            if (r0 == 0) goto L_0x00ad
            float r0 = r8.MAX_TEMPERATURE
            float r3 = r8.mReonTargetTemperature
            float r3 = r0 - r3
            float r7 = (float) r2
            float r3 = r3 - r7
            float r7 = r8.MIN_TEMPERATURE
            float r0 = r0 - r7
            float r3 = r3 / r0
            int r0 = r8.getHeight()
        L_0x00aa:
            float r0 = (float) r0
            float r0 = r0 * r3
            goto L_0x00d5
        L_0x00ad:
            boolean r0 = r8.mIsDifferentTargetTemp
            if (r0 == 0) goto L_0x00c3
            float r0 = r8.MAX_TEMPERATURE
            float r7 = r8.mReonTargetTemperature
            float r7 = r0 - r7
            float r7 = r7 - r3
            float r3 = r8.MIN_TEMPERATURE
            float r0 = r0 - r3
            float r7 = r7 / r0
            int r0 = r8.getHeight()
            float r0 = (float) r0
            float r0 = r0 * r7
            goto L_0x00d5
        L_0x00c3:
            float r0 = r8.MAX_TEMPERATURE
            float r3 = r8.mReonTargetTemperature
            float r3 = r0 - r3
            float r7 = (float) r2
            float r3 = r3 - r7
            float r7 = r8.MIN_TEMPERATURE
            float r0 = r0 - r7
            float r3 = r3 / r0
            int r0 = r8.getHeight()
            goto L_0x00aa
        L_0x00d4:
            r0 = r4
        L_0x00d5:
            r8.mTargetTemperatureViewTopY = r0
            int[] r0 = jp.co.sony.reonpocket.view.TemperatureSurfaceView.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r0 = r0[r1]
            if (r0 == r2) goto L_0x00fe
            if (r0 == r6) goto L_0x00ec
            if (r0 != r5) goto L_0x00e6
            goto L_0x0103
        L_0x00e6:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        L_0x00ec:
            float r0 = r8.MAX_TEMPERATURE
            float r1 = r8.mTecTemperature
            float r1 = r0 - r1
            float r2 = r8.MIN_TEMPERATURE
            float r0 = r0 - r2
            float r1 = r1 / r0
            int r0 = r8.getHeight()
            float r0 = (float) r0
            float r4 = r1 * r0
            goto L_0x0103
        L_0x00fe:
            int r0 = r8.getHeight()
            float r4 = (float) r0
        L_0x0103:
            r8.mTecTemperatureCenterY = r4
            float r0 = r8.mMinHeight
            int r1 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r1 >= 0) goto L_0x010d
        L_0x010b:
            r4 = r0
            goto L_0x0114
        L_0x010d:
            float r0 = r8.mMaxHeight
            int r1 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r1 <= 0) goto L_0x0114
            goto L_0x010b
        L_0x0114:
            r8.mTecTemperatureCenterY = r4
            boolean r0 = r8.isDisplayTarget
            if (r0 == 0) goto L_0x0120
            r8.drawTargetView(r9)
            r8.drawTargetText(r9)
        L_0x0120:
            r8.drawLineAndIcon(r9)
            boolean r0 = r8.isDisplayAnimation
            if (r0 == 0) goto L_0x012a
            r8.drawRippleEffect(r9)
        L_0x012a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.view.TemperatureSurfaceView.onDraw(android.graphics.Canvas):void");
    }

    private final float checkTargetTemp() {
        if (this.mIsWeakState) {
            this.mTargetTemperatureViewHeight = this.mDefaultTargetTemperatureViewHeight;
            return 1.0f;
        }
        float f = this.mReonTargetTemperature;
        if (f == 0.0f || this.mTargetTemperature == f) {
            float f2 = this.mDefaultTargetTemperatureViewHeight;
            if (f2 != this.mTargetTemperatureViewHeight) {
                this.mTargetTemperatureViewHeight = f2;
            }
            this.mIsDifferentTargetTemp = false;
            return 1.0f;
        }
        float f3 = f - 1.0f;
        float f4 = f + 1.0f;
        BigDecimal subtract = new BigDecimal(String.valueOf(f4)).subtract(new BigDecimal(String.valueOf(f3)));
        Intrinsics.checkNotNullExpressionValue(subtract, "subtract(...)");
        float floatValue = subtract.floatValue();
        if (floatValue <= 2.0f) {
            return 1.0f;
        }
        float f5 = floatValue - 2.0f;
        float f6 = this.mDefaultTargetTemperatureViewHeight;
        if (!(f6 != this.mTargetTemperatureViewHeight && this.mTargetTemperatureMin == f3 && this.mTargetTemperatureMax == f4)) {
            float f7 = (float) 20;
            float f8 = ((f6 / f7) * (f5 / 0.1f)) + f6;
            this.mTargetTemperatureViewHeight = f8;
            this.mTargetTemperatureMin = f3;
            this.mTargetTemperatureMax = f4;
            float f9 = this.SMART_WARM_MAX_TEMPERATURE;
            if (f4 > f9) {
                this.mTargetTemperatureViewHeight = f8 - ((f6 / f7) * ((f4 - f9) / 0.1f));
            }
        }
        this.mIsDifferentTargetTemp = true;
        if (this.mReonTargetTemperature > this.mTargetTemperature) {
            return 1.0f + f5;
        }
        return 1.0f;
    }

    public final void setIsDisplayAnimation(boolean z) {
        this.isDisplayAnimation = z;
    }

    public final void setIsDisplayTarget(boolean z) {
        this.isDisplayTarget = z;
    }

    private final void drawSmartCoolGradientBackground(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, (float) getWidth(), ((float) getHeight()) * 0.3f, this.mUpperGradientPaint);
        canvas.drawRect(0.0f, (((float) getHeight()) * 0.3f) - 1.0f, (float) getWidth(), (float) getHeight(), this.mLowerGradientPaint);
    }

    private final void drawSmartGradientBackground(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, (float) getWidth(), ((float) getHeight()) * 0.25f, this.mUpperGradientPaint);
        Canvas canvas2 = canvas;
        canvas2.drawRect(0.0f, (((float) getHeight()) * 0.25f) - 1.0f, (float) getWidth(), ((float) getHeight()) * 0.5f, this.mMiddleUpperGradientPaint);
        canvas2.drawRect(0.0f, (((float) getHeight()) * 0.5f) - 1.0f, (float) getWidth(), ((float) getHeight()) * 0.75f, this.mMiddleLowerGradientPaint);
        canvas2.drawRect(0.0f, (((float) getHeight()) * 0.75f) - 1.0f, (float) getWidth(), (float) getHeight(), this.mLowerGradientPaint);
    }

    private final void drawRippleEffect(Canvas canvas) {
        this.mPath.reset();
        this.mPath.addCircle(((float) getWidth()) / 2.0f, this.mTecTemperatureCenterY, this.mIconSize / 2.0f, Path.Direction.CW);
        Paint paint = this.mRippleCirclePaint;
        Integer num = this.circleAlphas.get(this.rippleIndex);
        Intrinsics.checkNotNullExpressionValue(num, "get(...)");
        paint.setAlpha(num.intValue());
        Paint paint2 = this.mRippleArcPaint;
        Integer num2 = this.arcAlphas.get(this.rippleIndex);
        Intrinsics.checkNotNullExpressionValue(num2, "get(...)");
        paint2.setAlpha(num2.intValue());
        Path path = this.mPath;
        Paint paint3 = new Paint();
        paint3.setColor(0);
        Unit unit = Unit.INSTANCE;
        canvas.drawPath(path, paint3);
        if (Build.VERSION.SDK_INT >= 26) {
            boolean unused = canvas.clipOutPath(this.mPath);
        }
        Float f = this.spreadRadius.get(this.rippleIndex);
        Intrinsics.checkNotNullExpressionValue(f, "get(...)");
        float width = ((float) (getWidth() / 2)) - f.floatValue();
        float f2 = this.mTecTemperatureCenterY;
        Float f3 = this.spreadRadius.get(this.rippleIndex);
        Intrinsics.checkNotNullExpressionValue(f3, "get(...)");
        float floatValue = f2 - f3.floatValue();
        Float f4 = this.spreadRadius.get(this.rippleIndex);
        Intrinsics.checkNotNullExpressionValue(f4, "get(...)");
        float width2 = ((float) (getWidth() / 2)) + f4.floatValue();
        float f5 = this.mTecTemperatureCenterY;
        Float f6 = this.spreadRadius.get(this.rippleIndex);
        Intrinsics.checkNotNullExpressionValue(f6, "get(...)");
        canvas.drawArc(width, floatValue, width2, f5 + f6.floatValue(), 0.0f, 360.0f, false, this.mRippleArcPaint);
        float f7 = this.mTecTemperatureCenterY;
        Float f8 = this.spreadRadius.get(this.rippleIndex);
        Intrinsics.checkNotNullExpressionValue(f8, "get(...)");
        canvas.drawCircle(((float) getWidth()) / 2.0f, f7, f8.floatValue(), this.mRippleCirclePaint);
    }

    private final void drawLineAndIcon(Canvas canvas) {
        Drawable drawable = this.mIconResource;
        if (drawable != null) {
            float f = this.mIconSize;
            float f2 = this.mIconSize;
            drawable.setBounds((int) ((((float) getWidth()) / 2.0f) - (f / 2.0f)), (int) (this.mTecTemperatureCenterY - (f / 2.0f)), (int) ((((float) getWidth()) / 2.0f) + (f2 / 2.0f)), (int) (this.mTecTemperatureCenterY + (f2 / 2.0f)));
        }
        Drawable drawable2 = this.mIconResource;
        if (drawable2 != null) {
            drawable2.setAlpha(this.isDisplayAnimation ? 255 : 128);
        }
        Drawable drawable3 = this.mIconResource;
        if (drawable3 != null) {
            drawable3.draw(canvas);
        }
        float f3 = (float) 2;
        Canvas canvas2 = canvas;
        canvas2.drawRect(0.0f, this.mTecTemperatureCenterY - (this.mLineHeight / f3), (((float) getWidth()) / f3) - (this.mIconSize / f3), this.mTecTemperatureCenterY + (this.mLineHeight / f3), this.mTecTempLinePaint);
        canvas2.drawRect((((float) getWidth()) / f3) + (this.mIconSize / f3), this.mTecTemperatureCenterY - (this.mLineHeight / f3), (float) getWidth(), this.mTecTemperatureCenterY + (this.mLineHeight / f3), this.mTecTempLinePaint);
    }

    private final void drawBackground(Canvas canvas) {
        this.mBackgroundPaint.setShader(new LinearGradient(((float) getWidth()) / 2.0f, 0.0f, ((float) getWidth()) / 2.0f, (float) getHeight(), this.mStartColor, this.mEndColor, Shader.TileMode.MIRROR));
        canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.mBackgroundPaint);
    }

    private final void drawTargetText(Canvas canvas) {
        float f;
        Rect rect = new Rect();
        Paint paint = this.mTargetTextPaint;
        String str = this.mTargetText;
        paint.getTextBounds(str, 0, str.length(), rect);
        if (Intrinsics.areEqual((Object) Locale.getDefault().getLanguage(), (Object) ArchiveStreamFactory.AR)) {
            f = ((float) canvas.getWidth()) - (((float) rect.width()) + this.mTargetTemperatureTextMarginX);
        } else {
            f = this.mTargetTemperatureTextMarginX;
        }
        canvas.drawText(this.mTargetText, f, this.mTargetTemperatureViewTopY + ((float) getResources().getDimensionPixelSize(R.dimen.targetTemperatureTopPadding)) + ((float) rect.height()), this.mTargetTextPaint);
    }

    private final void drawTargetView(Canvas canvas) {
        canvas.drawRect(0.0f, this.mTargetTemperatureViewTopY, (float) getWidth(), this.mTargetTemperatureViewTopY + this.mTargetTemperatureViewHeight, this.mTargetViewPaint);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float height = (2.0f / (this.MAX_TEMPERATURE - this.MIN_TEMPERATURE)) * ((float) getHeight());
        this.mTargetTemperatureViewHeight = height;
        this.mDefaultTargetTemperatureViewHeight = height;
        this.mMaxHeight = (float) getHeight();
        this.mMinHeight = 0.0f;
        float f = this.MAX_TEMPERATURE;
        float f2 = this.SMART_WARM_MAX_TEMPERATURE;
        if (f == f2 && this.MIN_TEMPERATURE == this.SMART_COOL_MIN_TEMPERATURE) {
            this.mUpperGradientPaint.setShader(new LinearGradient(((float) getWidth()) / 2.0f, ((float) getHeight()) * 0.25f, ((float) getWidth()) / 2.0f, 0.0f, this.mDefaultWarmMidColor, this.mDefaultWarmEndColor, Shader.TileMode.MIRROR));
            this.mMiddleUpperGradientPaint.setShader(new LinearGradient(((float) getWidth()) / 2.0f, ((float) getHeight()) * 0.75f, ((float) getWidth()) / 2.0f, (float) getHeight(), this.mDefaultWarmMidColor, this.mDefaultStartColor, Shader.TileMode.MIRROR));
            this.mMiddleLowerGradientPaint.setShader(new LinearGradient(((float) getWidth()) / 2.0f, ((float) getHeight()) * 0.75f, ((float) getWidth()) / 2.0f, (float) getHeight(), this.mDefaultCoolMidColor, this.mDefaultStartColor, Shader.TileMode.MIRROR));
            this.mLowerGradientPaint.setShader(new LinearGradient(((float) getWidth()) / 2.0f, ((float) getHeight()) * 0.75f, ((float) getWidth()) / 2.0f, (float) getHeight(), this.mDefaultCoolMidColor, this.mDefaultCoolEndColor, Shader.TileMode.MIRROR));
        } else if (f == f2 && this.MIN_TEMPERATURE == this.SMART_WARM_MIN_TEMPERATURE) {
            this.mUpperGradientPaint.setShader(new LinearGradient(((float) getWidth()) / 2.0f, 0.0f, ((float) getWidth()) / 2.0f, ((float) getHeight()) * 0.3f, this.mDefaultWarmEndColor, this.mDefaultWarmMidColor, Shader.TileMode.MIRROR));
            this.mLowerGradientPaint.setShader(new LinearGradient(((float) getWidth()) / 2.0f, ((float) getHeight()) * 0.3f, ((float) getWidth()) / 2.0f, (float) getHeight(), this.mDefaultWarmMidColor, this.mDefaultStartColor, Shader.TileMode.MIRROR));
        } else {
            this.mUpperGradientPaint.setShader(new LinearGradient(((float) getWidth()) / 2.0f, 0.0f, ((float) getWidth()) / 2.0f, ((float) getHeight()) * 0.3f, this.mDefaultStartColor, this.mDefaultCoolMidColor, Shader.TileMode.MIRROR));
            this.mLowerGradientPaint.setShader(new LinearGradient(((float) getWidth()) / 2.0f, ((float) getHeight()) * 0.3f, ((float) getWidth()) / 2.0f, (float) getHeight(), this.mDefaultCoolMidColor, this.mDefaultCoolEndColor, Shader.TileMode.MIRROR));
        }
        if (!this.animationRunning) {
            this.animationRunning = true;
            new Thread(this.runnable).start();
        }
    }

    public final void setTecRate(float f) {
        if (0.0f <= f && f <= 1.0f) {
            if (f != 0.0f && f < 0.1f) {
                f = 0.1f;
            }
            float f2 = RIPPLE_MAX_RADIUS;
            float f3 = this.mIconSize;
            float f4 = (float) 2;
            this.mRippleMaxRadius = f2 * (((f * (f2 - (f3 / f4))) + (f3 / f4)) / f2);
            initRadius();
        }
    }

    public final void setOff(boolean z) {
        this.misOff = z;
        postInvalidate();
    }
}
