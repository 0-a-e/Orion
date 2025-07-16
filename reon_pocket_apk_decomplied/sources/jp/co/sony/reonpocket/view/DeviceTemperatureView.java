package jp.co.sony.reonpocket.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.util.BitmapUtil;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.util.DensityUtil;
import jp.co.sony.reonpocket.util.LocaleUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 Q2\u00020\u0001:\u0003QRSB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0014J\b\u0010>\u001a\u00020;H\u0002J0\u0010?\u001a\u00020;2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u0007H\u0014J\u000e\u0010F\u001a\u00020;2\u0006\u0010G\u001a\u00020!J\u000e\u0010H\u001a\u00020;2\u0006\u0010I\u001a\u00020JJ\u000e\u0010K\u001a\u00020;2\u0006\u0010G\u001a\u00020!J\u0015\u0010L\u001a\u00020A*\u00020M2\u0006\u0010N\u001a\u00020!H\u0002J\u0015\u0010O\u001a\u00020M*\u00020!2\u0006\u0010P\u001a\u00020!H\u0004R\u000e\u0010\t\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R$\u00101\u001a\u0002002\u0006\u0010/\u001a\u000200@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u000e\u00106\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Ljp/co/sony/reonpocket/view/DeviceTemperatureView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "NewBasicBackground", "TemperatureBarBgWidth", "TemperatureBarHeight", "TemperatureBarLeftMargin", "TemperatureBarLength", "TemperatureBarTriangleSize", "TemperatureBarWidth", "VentilationIndicatorPoint1", "Landroid/graphics/Bitmap;", "VentilationIndicatorPoint2", "VentilationIndicatorPoint3", "VentilationIndicatorPoint4", "VentilationIndicatorPoint5", "_12Dp2Px", "mBar", "Ljp/co/sony/reonpocket/view/CustomImageView;", "mBarIndicatorBgPaint", "Landroid/graphics/Paint;", "mBarIndicatorPaint", "mCoolBotColor", "mCoolMidColor", "mCoolTopColor", "mCurrentColor", "mCurrentFinTemperature", "", "mCurrentTemperature", "mDeviceNameTextView", "Ljp/co/sony/reonpocket/view/CustomFontTextView;", "mDeviceTempSurfaceView", "Landroid/view/View;", "mFanArrowView", "mFanBar", "mFanTempTriangle", "mFanTrianglePaint", "mIndicatorBarX", "mIndicatorBarY", "mIndicatorTriX", "mIndicatorTriY", "aVal", "Ljp/co/sony/reonpocket/view/DeviceTemperatureView$TemperatureThresholdEntity;", "mTemperatureThresholdEntity", "getMTemperatureThresholdEntity", "()Ljp/co/sony/reonpocket/view/DeviceTemperatureView$TemperatureThresholdEntity;", "setMTemperatureThresholdEntity", "(Ljp/co/sony/reonpocket/view/DeviceTemperatureView$TemperatureThresholdEntity;)V", "mTrianglePaint", "mWarmBotColor", "mWarmMidColor", "mWarmTopColor", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "initVariable", "onLayout", "changed", "", "l", "t", "r", "b", "setFinTemperature", "aTemp", "setModelName", "aName", "", "setTemperature", "contains", "Ljp/co/sony/reonpocket/view/DeviceTemperatureView$OpenFloatRange;", "f", "semiOpen", "to", "Companion", "OpenFloatRange", "TemperatureThresholdEntity", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DeviceTemperatureView.kt */
public final class DeviceTemperatureView extends LinearLayout {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final float MAX_TEMPERATURE = 39.6f;
    public static final float MID_TEMPERATURE = 32.8f;
    public static final float MIN_TEMPERATURE = 26.0f;
    private final int NewBasicBackground;
    private final int TemperatureBarBgWidth;
    private final int TemperatureBarHeight;
    private final int TemperatureBarLeftMargin;
    private final int TemperatureBarLength;
    private final int TemperatureBarTriangleSize;
    private final int TemperatureBarWidth;
    private final Bitmap VentilationIndicatorPoint1;
    private final Bitmap VentilationIndicatorPoint2;
    private final Bitmap VentilationIndicatorPoint3;
    private final Bitmap VentilationIndicatorPoint4;
    private final Bitmap VentilationIndicatorPoint5;
    private final int _12Dp2Px;
    private CustomImageView mBar;
    private final Paint mBarIndicatorBgPaint;
    private final Paint mBarIndicatorPaint;
    private final int mCoolBotColor;
    private final int mCoolMidColor;
    private final int mCoolTopColor;
    private int mCurrentColor;
    private float mCurrentFinTemperature;
    private float mCurrentTemperature;
    private final CustomFontTextView mDeviceNameTextView;
    private final View mDeviceTempSurfaceView;
    private final CustomImageView mFanArrowView;
    private CustomImageView mFanBar;
    private Bitmap mFanTempTriangle;
    private final Paint mFanTrianglePaint;
    private float mIndicatorBarX;
    private float mIndicatorBarY;
    private float mIndicatorTriX;
    private float mIndicatorTriY;
    private TemperatureThresholdEntity mTemperatureThresholdEntity;
    private final Paint mTrianglePaint;
    private final int mWarmBotColor;
    private final int mWarmMidColor;
    private final int mWarmTopColor;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DeviceTemperatureView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DeviceTemperatureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeviceTemperatureView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceTemperatureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTemperatureThresholdEntity = new TemperatureThresholdEntity(26.0f, 32.8f, 39.6f);
        this.mBarIndicatorPaint = new Paint();
        this.mBarIndicatorBgPaint = new Paint();
        this.mTrianglePaint = new Paint();
        this.mFanTrianglePaint = new Paint();
        this.mCoolTopColor = context.getColor(R.color.TemperatureBarCoolTop);
        this.mCoolMidColor = context.getColor(R.color.TemperatureBarCoolMid);
        this.mCoolBotColor = context.getColor(R.color.TemperatureBarCoolBottom);
        this.mWarmTopColor = context.getColor(R.color.TemperatureBarWarmTop);
        this.mWarmMidColor = context.getColor(R.color.TemperatureBarWarmMid);
        this.mWarmBotColor = context.getColor(R.color.TemperatureBarWarmBottom);
        this.mCurrentColor = context.getColor(R.color.TemperatureBarCoolTop);
        this.mCurrentTemperature = 26.0f;
        this.mCurrentFinTemperature = 26.0f;
        this.TemperatureBarLength = context.getResources().getDimensionPixelSize(R.dimen.temperatureBarLength);
        this.TemperatureBarTriangleSize = context.getResources().getDimensionPixelSize(R.dimen.temperatureBarTriangleSize);
        this.TemperatureBarLeftMargin = context.getResources().getDimensionPixelSize(R.dimen.temperatureBarLeftMargin);
        this.TemperatureBarHeight = context.getResources().getDimensionPixelSize(R.dimen.temperatureBarHeight);
        this.TemperatureBarBgWidth = context.getResources().getDimensionPixelSize(R.dimen.temperatureBarBgWidth);
        this.TemperatureBarWidth = context.getResources().getDimensionPixelSize(R.dimen.temperatureBarWidth);
        this.VentilationIndicatorPoint1 = BitmapUtil.INSTANCE.getBitmap(context, R.drawable.ic_ventilation_indicator_point_1);
        this.VentilationIndicatorPoint2 = BitmapUtil.INSTANCE.getBitmap(context, R.drawable.ic_ventilation_indicator_point_2);
        this.VentilationIndicatorPoint3 = BitmapUtil.INSTANCE.getBitmap(context, R.drawable.ic_ventilation_indicator_point_3);
        this.VentilationIndicatorPoint4 = BitmapUtil.INSTANCE.getBitmap(context, R.drawable.ic_ventilation_indicator_point_4);
        this.VentilationIndicatorPoint5 = BitmapUtil.INSTANCE.getBitmap(context, R.drawable.ic_ventilation_indicator_point_5);
        this.NewBasicBackground = context.getColor(R.color.NewBasicBackground);
        this._12Dp2Px = DensityUtil.INSTANCE.dip2px(context, 12.0f);
        View.inflate(context, R.layout.view_device_information, this);
        View findViewById = findViewById(R.id.device_info_name);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mDeviceNameTextView = (CustomFontTextView) findViewById;
        View findViewById2 = findViewById(R.id.surface_color_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.mDeviceTempSurfaceView = findViewById2;
        View findViewById3 = findViewById(R.id.bar);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.mBar = (CustomImageView) findViewById3;
        View findViewById4 = findViewById(R.id.bar_fan_temp);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.mFanBar = (CustomImageView) findViewById4;
        View findViewById5 = findViewById(R.id.img_fan_temp_arrow);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.mFanArrowView = (CustomImageView) findViewById5;
        initVariable();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/view/DeviceTemperatureView$Companion;", "", "()V", "MAX_TEMPERATURE", "", "MID_TEMPERATURE", "MIN_TEMPERATURE", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DeviceTemperatureView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Ljp/co/sony/reonpocket/view/DeviceTemperatureView$TemperatureThresholdEntity;", "", "minTemp", "", "midTemp", "maxTemp", "(FFF)V", "getMaxTemp", "()F", "getMidTemp", "getMinTemp", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DeviceTemperatureView.kt */
    public static final class TemperatureThresholdEntity {
        public static final int $stable = 0;
        private final float maxTemp;
        private final float midTemp;
        private final float minTemp;

        public TemperatureThresholdEntity(float f, float f2, float f3) {
            this.minTemp = f;
            this.midTemp = f2;
            this.maxTemp = f3;
        }

        public final float getMinTemp() {
            return this.minTemp;
        }

        public final float getMidTemp() {
            return this.midTemp;
        }

        public final float getMaxTemp() {
            return this.maxTemp;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Ljp/co/sony/reonpocket/view/DeviceTemperatureView$OpenFloatRange;", "", "from", "", "to", "(FF)V", "getFrom", "()F", "getTo", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DeviceTemperatureView.kt */
    private static final class OpenFloatRange {
        private final float from;
        private final float to;

        public static /* synthetic */ OpenFloatRange copy$default(OpenFloatRange openFloatRange, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                f = openFloatRange.from;
            }
            if ((i & 2) != 0) {
                f2 = openFloatRange.to;
            }
            return openFloatRange.copy(f, f2);
        }

        public final float component1() {
            return this.from;
        }

        public final float component2() {
            return this.to;
        }

        public final OpenFloatRange copy(float f, float f2) {
            return new OpenFloatRange(f, f2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OpenFloatRange)) {
                return false;
            }
            OpenFloatRange openFloatRange = (OpenFloatRange) obj;
            return Float.compare(this.from, openFloatRange.from) == 0 && Float.compare(this.to, openFloatRange.to) == 0;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.from) * 31) + Float.floatToIntBits(this.to);
        }

        public String toString() {
            float f = this.from;
            float f2 = this.to;
            return "OpenFloatRange(from=" + f + ", to=" + f2 + ")";
        }

        public OpenFloatRange(float f, float f2) {
            this.from = f;
            this.to = f2;
        }

        public final float getFrom() {
            return this.from;
        }

        public final float getTo() {
            return this.to;
        }
    }

    private final OpenFloatRange semiOpen(float f, float f2) {
        return new OpenFloatRange(f, f2);
    }

    private final boolean contains(OpenFloatRange openFloatRange, float f) {
        Intrinsics.checkNotNullParameter(openFloatRange, "<this>");
        return openFloatRange.getFrom() <= f && f < openFloatRange.getTo();
    }

    public final TemperatureThresholdEntity getMTemperatureThresholdEntity() {
        return this.mTemperatureThresholdEntity;
    }

    public final void setMTemperatureThresholdEntity(TemperatureThresholdEntity temperatureThresholdEntity) {
        Intrinsics.checkNotNullParameter(temperatureThresholdEntity, "aVal");
        this.mTemperatureThresholdEntity = temperatureThresholdEntity;
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        this.mBar.getDrawingRect(rect);
        this.mFanBar.getDrawingRect(rect2);
        offsetDescendantRectToMyCoords(this.mFanBar, rect2);
        offsetDescendantRectToMyCoords(this.mBar, rect);
        this.mIndicatorBarX = ((float) rect.left) - ((float) this.TemperatureBarLeftMargin);
        this.mIndicatorBarY = (float) rect.top;
        this.mIndicatorTriX = (float) rect2.right;
        this.mIndicatorTriY = (float) rect2.top;
        setTemperature(this.mCurrentTemperature);
        setFinTemperature(this.mCurrentFinTemperature);
    }

    public final void setFinTemperature(float f) {
        float f2;
        int i;
        float f3;
        this.mCurrentFinTemperature = f;
        Rect rect = new Rect();
        this.mFanBar.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(this.mFanBar, rect);
        Bitmap bitmap = null;
        if (contains(semiOpen(Float.MIN_VALUE, 32.0f), f)) {
            this.mFanTempTriangle = this.VentilationIndicatorPoint1;
            BitmapUtil bitmapUtil = BitmapUtil.INSTANCE;
            Bitmap bitmap2 = this.mFanTempTriangle;
            if (bitmap2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFanTempTriangle");
                bitmap2 = null;
            }
            int i2 = this._12Dp2Px;
            this.mFanTempTriangle = bitmapUtil.conversionBitmap(bitmap2, i2, i2);
            this.mFanArrowView.setImageResource(R.drawable.ic_guide_ventilation_arrow_1);
            f3 = (float) this.TemperatureBarHeight;
            f2 = 0.9f;
        } else if (contains(semiOpen(32.0f, 36.0f), f)) {
            this.mFanTempTriangle = this.VentilationIndicatorPoint2;
            BitmapUtil bitmapUtil2 = BitmapUtil.INSTANCE;
            Bitmap bitmap3 = this.mFanTempTriangle;
            if (bitmap3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFanTempTriangle");
                bitmap3 = null;
            }
            int i3 = this._12Dp2Px;
            this.mFanTempTriangle = bitmapUtil2.conversionBitmap(bitmap3, i3, i3);
            this.mFanArrowView.setImageResource(R.drawable.ic_guide_ventilation_arrow_2);
            f3 = (float) this.TemperatureBarHeight;
            f2 = 0.7f;
        } else if (contains(semiOpen(36.0f, 40.0f), f)) {
            this.mFanTempTriangle = this.VentilationIndicatorPoint3;
            BitmapUtil bitmapUtil3 = BitmapUtil.INSTANCE;
            Bitmap bitmap4 = this.mFanTempTriangle;
            if (bitmap4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFanTempTriangle");
                bitmap4 = null;
            }
            int i4 = this._12Dp2Px;
            this.mFanTempTriangle = bitmapUtil3.conversionBitmap(bitmap4, i4, i4);
            this.mFanArrowView.setImageResource(R.drawable.ic_guide_ventilation_arrow_3);
            f3 = (float) this.TemperatureBarHeight;
            f2 = 0.5f;
        } else if (contains(semiOpen(40.0f, 43.0f), f)) {
            this.mFanTempTriangle = this.VentilationIndicatorPoint4;
            BitmapUtil bitmapUtil4 = BitmapUtil.INSTANCE;
            Bitmap bitmap5 = this.mFanTempTriangle;
            if (bitmap5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFanTempTriangle");
                bitmap5 = null;
            }
            int i5 = this._12Dp2Px;
            this.mFanTempTriangle = bitmapUtil4.conversionBitmap(bitmap5, i5, i5);
            this.mFanArrowView.setImageResource(R.drawable.ic_guide_ventilation_arrow_4);
            f3 = (float) this.TemperatureBarHeight;
            f2 = 0.3f;
        } else {
            f2 = 0.1f;
            if (contains(semiOpen(43.0f, Float.MAX_VALUE), f)) {
                this.mFanTempTriangle = this.VentilationIndicatorPoint5;
                BitmapUtil bitmapUtil5 = BitmapUtil.INSTANCE;
                Bitmap bitmap6 = this.mFanTempTriangle;
                if (bitmap6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFanTempTriangle");
                    bitmap6 = null;
                }
                int i6 = this._12Dp2Px;
                this.mFanTempTriangle = bitmapUtil5.conversionBitmap(bitmap6, i6, i6);
                this.mFanArrowView.setImageResource(R.drawable.ic_guide_ventilation_arrow_5);
                i = this.TemperatureBarHeight;
            } else {
                this.mFanTempTriangle = this.VentilationIndicatorPoint5;
                BitmapUtil bitmapUtil6 = BitmapUtil.INSTANCE;
                Bitmap bitmap7 = this.mFanTempTriangle;
                if (bitmap7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFanTempTriangle");
                    bitmap7 = null;
                }
                int i7 = this._12Dp2Px;
                this.mFanTempTriangle = bitmapUtil6.conversionBitmap(bitmap7, i7, i7);
                this.mFanArrowView.setImageResource(R.drawable.ic_guide_ventilation_arrow_5);
                i = this.TemperatureBarHeight;
            }
            f3 = (float) i;
        }
        float f4 = f3 * f2;
        this.mIndicatorTriY = f4;
        float f5 = f4 + ((float) rect.top);
        this.mIndicatorTriY = f5;
        DensityUtil densityUtil = DensityUtil.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        this.mIndicatorTriY = f5 - ((float) densityUtil.dip2px(context, 4.0f));
        LocaleUtil localeUtil = LocaleUtil.INSTANCE;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        if (localeUtil.isRtl(context2)) {
            float f6 = ((float) rect.left) - ((float) this.TemperatureBarLeftMargin);
            Bitmap bitmap8 = this.mFanTempTriangle;
            if (bitmap8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFanTempTriangle");
            } else {
                bitmap = bitmap8;
            }
            this.mIndicatorTriX = f6 - ((float) bitmap.getWidth());
        } else {
            this.mIndicatorTriX = ((float) rect.right) + ((float) this.TemperatureBarLeftMargin);
        }
        postInvalidate();
    }

    public final void setTemperature(float f) {
        float f2;
        this.mCurrentTemperature = f;
        float maxTemp = this.mTemperatureThresholdEntity.getMaxTemp() - Math.max(Math.min(f, this.mTemperatureThresholdEntity.getMaxTemp()), this.mTemperatureThresholdEntity.getMinTemp());
        if (maxTemp < this.mTemperatureThresholdEntity.getMaxTemp() - this.mTemperatureThresholdEntity.getMidTemp()) {
            f2 = (maxTemp / (this.mTemperatureThresholdEntity.getMaxTemp() - this.mTemperatureThresholdEntity.getMidTemp())) * 0.5f;
        } else {
            f2 = (((maxTemp - (this.mTemperatureThresholdEntity.getMaxTemp() - this.mTemperatureThresholdEntity.getMidTemp())) / (this.mTemperatureThresholdEntity.getMidTemp() - this.mTemperatureThresholdEntity.getMinTemp())) * 0.5f) + 0.5f;
        }
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        debugLogUtil.d("DEBUG_REVERSE", "temp: " + f + ", normalizedValue: " + maxTemp + ", percentage: " + f2);
        if (f2 < 0.5f) {
            float f3 = f2 / 0.5f;
            if (f3 > 0.7f) {
                float f4 = ((float) 1) - ((f3 - 0.7f) / 0.3f);
                float red = ((float) ((Color.red(this.mWarmMidColor) + Color.red(this.mWarmTopColor)) - Color.red(this.mWarmTopColor))) * f4;
                int i = ((int) red) << 16;
                this.mCurrentColor = i | (((int) (((float) ((Color.alpha(this.mWarmMidColor) + Color.alpha(this.mWarmTopColor)) - Color.alpha(this.mWarmTopColor))) * f4)) << 24) | (((int) (((float) ((Color.green(this.mWarmMidColor) + Color.green(this.mWarmTopColor)) - Color.green(this.mWarmTopColor))) * f4)) << 8) | ((int) (((float) ((Color.blue(this.mWarmMidColor) + Color.blue(this.mWarmTopColor)) - Color.blue(this.mWarmTopColor))) * f4));
            } else {
                float f5 = ((float) 1) - (f3 / 0.7f);
                float red2 = ((float) ((Color.red(this.mWarmBotColor) + Color.red(this.mWarmMidColor)) - Color.red(this.mWarmMidColor))) * f5;
                int i2 = ((int) red2) << 16;
                this.mCurrentColor = i2 | (((int) (((float) ((Color.alpha(this.mWarmBotColor) + Color.alpha(this.mWarmMidColor)) - Color.alpha(this.mWarmMidColor))) * f5)) << 24) | (((int) (((float) ((Color.green(this.mWarmBotColor) + Color.green(this.mWarmMidColor)) - Color.green(this.mWarmMidColor))) * f5)) << 8) | ((int) (((float) ((Color.blue(this.mWarmBotColor) + Color.blue(this.mWarmMidColor)) - Color.blue(this.mWarmMidColor))) * f5));
            }
        } else {
            float f6 = (f2 - 0.5f) / 0.5f;
            if (f6 > 0.3f) {
                float f7 = ((float) 1) - ((f6 - 0.3f) / 0.7f);
                float red3 = (((float) (Color.red(this.mCoolMidColor) - Color.red(this.mCoolTopColor))) * f7) + ((float) Color.red(this.mCoolTopColor));
                int i3 = ((int) red3) << 16;
                this.mCurrentColor = i3 | (((int) ((((float) (Color.alpha(this.mCoolMidColor) - Color.alpha(this.mCoolTopColor))) * f7) + ((float) Color.alpha(this.mCoolTopColor)))) << 24) | (((int) ((((float) (Color.green(this.mCoolMidColor) - Color.green(this.mCoolTopColor))) * f7) + ((float) Color.green(this.mCoolTopColor)))) << 8) | ((int) ((((float) (Color.blue(this.mCoolMidColor) - Color.blue(this.mCoolTopColor))) * f7) + ((float) Color.blue(this.mCoolTopColor))));
            } else {
                float f8 = ((float) 1) - (f6 / 0.3f);
                float red4 = ((float) ((Color.red(this.mCoolBotColor) + Color.red(this.mCoolMidColor)) - Color.red(this.mCoolMidColor))) * f8;
                int i4 = ((int) red4) << 16;
                this.mCurrentColor = i4 | (((int) (((float) ((Color.alpha(this.mCoolBotColor) + Color.alpha(this.mCoolMidColor)) - Color.alpha(this.mCoolMidColor))) * f8)) << 24) | (((int) (((float) ((Color.green(this.mCoolBotColor) + Color.green(this.mCoolMidColor)) - Color.green(this.mCoolMidColor))) * f8)) << 8) | ((int) (((float) ((Color.blue(this.mCoolBotColor) + Color.blue(this.mCoolMidColor)) - Color.blue(this.mCoolMidColor))) * f8));
            }
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.mCurrentColor);
        gradientDrawable.setCornerRadius(5.0f);
        this.mDeviceTempSurfaceView.setBackground(gradientDrawable);
        this.mBar.getLocationOnScreen(new int[2]);
        Rect rect = new Rect();
        this.mBar.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(this.mBar, rect);
        this.mIndicatorBarX = ((float) rect.left) - ((float) this.TemperatureBarLeftMargin);
        this.mIndicatorBarY = ((float) rect.top) + (f2 * ((float) this.TemperatureBarHeight));
        this.mBarIndicatorPaint.setColor(this.mCurrentColor);
        this.mTrianglePaint.setColor(this.mCurrentColor);
        postInvalidate();
    }

    public final void setModelName(String str) {
        Intrinsics.checkNotNullParameter(str, "aName");
        this.mDeviceNameTextView.setText(str);
    }

    private final void initVariable() {
        this.mBarIndicatorBgPaint.setColor(this.NewBasicBackground);
        this.mBarIndicatorPaint.setColor(this.mCurrentColor);
        this.mTrianglePaint.setColor(this.mCurrentColor);
        this.mBarIndicatorBgPaint.setAntiAlias(true);
        this.mBarIndicatorPaint.setAntiAlias(true);
        this.mTrianglePaint.setAntiAlias(true);
        this.mBarIndicatorBgPaint.setStyle(Paint.Style.STROKE);
        this.mBarIndicatorPaint.setStyle(Paint.Style.STROKE);
        this.mTrianglePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mBarIndicatorBgPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mBarIndicatorPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mBarIndicatorBgPaint.setStrokeWidth((float) this.TemperatureBarBgWidth);
        this.mBarIndicatorPaint.setStrokeWidth((float) this.TemperatureBarWidth);
        this.mFanTempTriangle = this.VentilationIndicatorPoint1;
        BitmapUtil bitmapUtil = BitmapUtil.INSTANCE;
        Bitmap bitmap = this.mFanTempTriangle;
        if (bitmap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFanTempTriangle");
            bitmap = null;
        }
        DensityUtil densityUtil = DensityUtil.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        int dip2px = densityUtil.dip2px(context, 8.0f);
        DensityUtil densityUtil2 = DensityUtil.INSTANCE;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.mFanTempTriangle = bitmapUtil.conversionBitmap(bitmap, dip2px, densityUtil2.dip2px(context2, 8.0f));
        this.mFanTrianglePaint.setDither(true);
        this.mFanTrianglePaint.setFilterBitmap(true);
        this.mFanTrianglePaint.setAntiAlias(true);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        float f = this.mIndicatorBarX;
        float f2 = (float) 8;
        float f3 = this.mIndicatorBarY;
        canvas.drawLine(f - f2, f3, f + ((float) this.TemperatureBarLength) + f2, f3, this.mBarIndicatorBgPaint);
        float f4 = this.mIndicatorBarX;
        float f5 = this.mIndicatorBarY;
        canvas.drawLine(f4, f5, f4 + ((float) this.TemperatureBarLength), f5, this.mBarIndicatorPaint);
        Bitmap bitmap = this.mFanTempTriangle;
        if (bitmap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFanTempTriangle");
            bitmap = null;
        }
        canvas.drawBitmap(bitmap, this.mIndicatorTriX, this.mIndicatorTriY, this.mFanTrianglePaint);
        Path path = new Path();
        LocaleUtil localeUtil = LocaleUtil.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (localeUtil.isRtl(context)) {
            path.moveTo(this.mIndicatorBarX - f2, this.mIndicatorBarY);
            int i = this.TemperatureBarTriangleSize;
            path.lineTo((this.mIndicatorBarX - f2) - ((float) i), this.mIndicatorBarY + ((float) (i / 2)));
            int i2 = this.TemperatureBarTriangleSize;
            path.lineTo((this.mIndicatorBarX - f2) - ((float) i2), this.mIndicatorBarY - ((float) (i2 / 2)));
            path.lineTo(this.mIndicatorBarX - f2, this.mIndicatorBarY);
        } else {
            path.moveTo(this.mIndicatorBarX + ((float) this.TemperatureBarLength) + f2, this.mIndicatorBarY);
            int i3 = this.TemperatureBarTriangleSize;
            path.lineTo(this.mIndicatorBarX + ((float) this.TemperatureBarLength) + f2 + ((float) i3), this.mIndicatorBarY + ((float) (i3 / 2)));
            int i4 = this.TemperatureBarTriangleSize;
            path.lineTo(this.mIndicatorBarX + ((float) this.TemperatureBarLength) + f2 + ((float) i4), this.mIndicatorBarY - ((float) (i4 / 2)));
            path.lineTo(this.mIndicatorBarX + ((float) this.TemperatureBarLength) + f2, this.mIndicatorBarY);
        }
        path.close();
        canvas.drawPath(path, this.mTrianglePaint);
    }
}
