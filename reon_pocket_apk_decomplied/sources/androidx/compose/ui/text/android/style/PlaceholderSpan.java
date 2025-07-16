package androidx.compose.ui.text.android.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 (2\u00020\u0001:\u0001(B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJR\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%H\u0016J4\u0010&\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\fH\u0017R\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX.¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00058F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00058F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Landroidx/compose/ui/text/android/style/PlaceholderSpan;", "Landroid/text/style/ReplacementSpan;", "width", "", "widthUnit", "", "height", "heightUnit", "pxPerSp", "verticalAlign", "(FIFIFI)V", "<set-?>", "Landroid/graphics/Paint$FontMetricsInt;", "fontMetrics", "getFontMetrics", "()Landroid/graphics/Paint$FontMetricsInt;", "heightPx", "getHeightPx", "()I", "isLaidOut", "", "getVerticalAlign", "widthPx", "getWidthPx", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PlaceholderSpan.kt */
public final class PlaceholderSpan extends ReplacementSpan {
    public static final int $stable = 8;
    public static final int ALIGN_ABOVE_BASELINE = 0;
    public static final int ALIGN_BOTTOM = 2;
    public static final int ALIGN_CENTER = 3;
    public static final int ALIGN_TEXT_BOTTOM = 5;
    public static final int ALIGN_TEXT_CENTER = 6;
    public static final int ALIGN_TEXT_TOP = 4;
    public static final int ALIGN_TOP = 1;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int UNIT_EM = 1;
    public static final int UNIT_SP = 0;
    public static final int UNIT_UNSPECIFIED = 2;
    private Paint.FontMetricsInt fontMetrics;
    private final float height;
    private int heightPx;
    private final int heightUnit;
    private boolean isLaidOut;
    private final float pxPerSp;
    private final int verticalAlign;
    private final float width;
    private int widthPx;
    private final int widthUnit;

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
    }

    public final int getVerticalAlign() {
        return this.verticalAlign;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/text/android/style/PlaceholderSpan$Companion;", "", "()V", "ALIGN_ABOVE_BASELINE", "", "ALIGN_BOTTOM", "ALIGN_CENTER", "ALIGN_TEXT_BOTTOM", "ALIGN_TEXT_CENTER", "ALIGN_TEXT_TOP", "ALIGN_TOP", "UNIT_EM", "UNIT_SP", "UNIT_UNSPECIFIED", "Unit", "VerticalAlign", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PlaceholderSpan.kt */
    public static final class Companion {

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/compose/ui/text/android/style/PlaceholderSpan$Companion$Unit;", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @Retention(AnnotationRetention.SOURCE)
        @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
        /* compiled from: PlaceholderSpan.kt */
        public @interface Unit {
        }

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/compose/ui/text/android/style/PlaceholderSpan$Companion$VerticalAlign;", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @Retention(AnnotationRetention.SOURCE)
        @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
        /* compiled from: PlaceholderSpan.kt */
        public @interface VerticalAlign {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public PlaceholderSpan(float f, int i, float f2, int i2, float f3, int i3) {
        this.width = f;
        this.widthUnit = i;
        this.height = f2;
        this.heightUnit = i2;
        this.pxPerSp = f3;
        this.verticalAlign = i3;
    }

    public final Paint.FontMetricsInt getFontMetrics() {
        Paint.FontMetricsInt fontMetricsInt = this.fontMetrics;
        if (fontMetricsInt != null) {
            return fontMetricsInt;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fontMetrics");
        return null;
    }

    public final int getWidthPx() {
        if (this.isLaidOut) {
            return this.widthPx;
        }
        throw new IllegalStateException("PlaceholderSpan is not laid out yet.".toString());
    }

    public final int getHeightPx() {
        if (this.isLaidOut) {
            return this.heightPx;
        }
        throw new IllegalStateException("PlaceholderSpan is not laid out yet.".toString());
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        float f;
        int i3;
        this.isLaidOut = true;
        float textSize = paint.getTextSize();
        this.fontMetrics = paint.getFontMetricsInt();
        if (getFontMetrics().descent > getFontMetrics().ascent) {
            int i4 = this.widthUnit;
            if (i4 == 0) {
                f = this.width * this.pxPerSp;
            } else if (i4 == 1) {
                f = this.width * textSize;
            } else {
                throw new IllegalArgumentException("Unsupported unit.");
            }
            this.widthPx = PlaceholderSpanKt.ceilToInt(f);
            int i5 = this.heightUnit;
            if (i5 == 0) {
                i3 = PlaceholderSpanKt.ceilToInt(this.height * this.pxPerSp);
            } else if (i5 == 1) {
                i3 = PlaceholderSpanKt.ceilToInt(this.height * textSize);
            } else {
                throw new IllegalArgumentException("Unsupported unit.");
            }
            this.heightPx = i3;
            if (fontMetricsInt != null) {
                fontMetricsInt.ascent = getFontMetrics().ascent;
                fontMetricsInt.descent = getFontMetrics().descent;
                fontMetricsInt.leading = getFontMetrics().leading;
                switch (this.verticalAlign) {
                    case 0:
                        if (fontMetricsInt.ascent > (-getHeightPx())) {
                            fontMetricsInt.ascent = -getHeightPx();
                            break;
                        }
                        break;
                    case 1:
                    case 4:
                        if (fontMetricsInt.ascent + getHeightPx() > fontMetricsInt.descent) {
                            fontMetricsInt.descent = fontMetricsInt.ascent + getHeightPx();
                            break;
                        }
                        break;
                    case 2:
                    case 5:
                        if (fontMetricsInt.ascent > fontMetricsInt.descent - getHeightPx()) {
                            fontMetricsInt.ascent = fontMetricsInt.descent - getHeightPx();
                            break;
                        }
                        break;
                    case 3:
                    case 6:
                        if (fontMetricsInt.descent - fontMetricsInt.ascent < getHeightPx()) {
                            fontMetricsInt.ascent -= (getHeightPx() - (fontMetricsInt.descent - fontMetricsInt.ascent)) / 2;
                            fontMetricsInt.descent = fontMetricsInt.ascent + getHeightPx();
                            break;
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown verticalAlign.");
                }
                fontMetricsInt.top = Math.min(getFontMetrics().top, fontMetricsInt.ascent);
                fontMetricsInt.bottom = Math.max(getFontMetrics().bottom, fontMetricsInt.descent);
            }
            return getWidthPx();
        }
        throw new IllegalArgumentException("Invalid fontMetrics: line height can not be negative.".toString());
    }
}
