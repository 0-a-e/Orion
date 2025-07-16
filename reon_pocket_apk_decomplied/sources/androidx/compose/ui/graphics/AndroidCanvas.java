package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J:\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 H\u0016ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\b\u0010#\u001a\u00020\u000fH\u0016JH\u0010$\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J*\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\b/\u00100J*\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020-2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\b5\u00106JB\u00107\u001a\u00020\u000f2\u0006\u00102\u001a\u0002032\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u0002092\u0006\u0010=\u001a\u00020;2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\b>\u0010?J*\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020-2\u0006\u0010B\u001a\u00020-2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ&\u0010E\u001a\u00020\u000f2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020-0G2\u0006\u0010)\u001a\u00020*2\u0006\u0010H\u001a\u00020IH\u0002J0\u0010J\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0016J\u0018\u0010K\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*H\u0016J0\u0010L\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020N2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020-0G2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ\u001e\u0010L\u001a\u00020\u000f2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020-0G2\u0006\u0010)\u001a\u00020*H\u0002J \u0010Q\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020R2\u0006\u0010)\u001a\u00020*2\u0006\u0010H\u001a\u00020IH\u0002J*\u0010S\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020N2\u0006\u0010F\u001a\u00020R2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\bT\u0010UJ \u0010S\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020R2\u0006\u0010)\u001a\u00020*2\u0006\u0010H\u001a\u00020IH\u0002J0\u0010V\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0016J@\u0010W\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010X\u001a\u00020\u00182\u0006\u0010Y\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0016J*\u0010Z\u001a\u00020\u000f2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\b_\u0010`J\b\u0010a\u001a\u00020\u000fH\u0016J\b\u0010b\u001a\u00020\u000fH\u0016J\u0010\u0010c\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020\u0018H\u0016J\b\u0010e\u001a\u00020\u000fH\u0016J\u0018\u0010f\u001a\u00020\u000f2\u0006\u0010g\u001a\u00020h2\u0006\u0010)\u001a\u00020*H\u0016J\u0018\u0010i\u001a\u00020\u000f2\u0006\u0010j\u001a\u00020\u00182\u0006\u0010k\u001a\u00020\u0018H\u0016J\u0018\u0010l\u001a\u00020\u000f2\u0006\u0010j\u001a\u00020\u00182\u0006\u0010k\u001a\u00020\u0018H\u0016J\u0018\u0010m\u001a\u00020\u000f2\u0006\u0010n\u001a\u00020\u00182\u0006\u0010o\u001a\u00020\u0018H\u0016J\u0014\u0010p\u001a\u00020q*\u00020\u0013ø\u0001\u0000¢\u0006\u0004\br\u0010sR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R(\u0010\u0005\u001a\u00060\u0006j\u0002`\u00078\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006t"}, d2 = {"Landroidx/compose/ui/graphics/AndroidCanvas;", "Landroidx/compose/ui/graphics/Canvas;", "()V", "dstRect", "Landroid/graphics/Rect;", "internalCanvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "getInternalCanvas$annotations", "getInternalCanvas", "()Landroid/graphics/Canvas;", "setInternalCanvas", "(Landroid/graphics/Canvas;)V", "srcRect", "clipPath", "", "path", "Landroidx/compose/ui/graphics/Path;", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "clipRect", "left", "", "top", "right", "bottom", "clipRect-N_I0leg", "(FFFFI)V", "concat", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "concat-58bKbWc", "([F)V", "disableZ", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "paint", "Landroidx/compose/ui/graphics/Paint;", "drawCircle", "center", "Landroidx/compose/ui/geometry/Offset;", "radius", "drawCircle-9KIMszo", "(JFLandroidx/compose/ui/graphics/Paint;)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "topLeftOffset", "drawImage-d-4ec7I", "(Landroidx/compose/ui/graphics/ImageBitmap;JLandroidx/compose/ui/graphics/Paint;)V", "drawImageRect", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImageRect-HPBpro0", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJLandroidx/compose/ui/graphics/Paint;)V", "drawLine", "p1", "p2", "drawLine-Wko1d7g", "(JJLandroidx/compose/ui/graphics/Paint;)V", "drawLines", "points", "", "stepBy", "", "drawOval", "drawPath", "drawPoints", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-O7TthRY", "(ILjava/util/List;Landroidx/compose/ui/graphics/Paint;)V", "drawRawLines", "", "drawRawPoints", "drawRawPoints-O7TthRY", "(I[FLandroidx/compose/ui/graphics/Paint;)V", "drawRect", "drawRoundRect", "radiusX", "radiusY", "drawVertices", "vertices", "Landroidx/compose/ui/graphics/Vertices;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawVertices-TPEHhCM", "(Landroidx/compose/ui/graphics/Vertices;ILandroidx/compose/ui/graphics/Paint;)V", "enableZ", "restore", "rotate", "degrees", "save", "saveLayer", "bounds", "Landroidx/compose/ui/geometry/Rect;", "scale", "sx", "sy", "skew", "translate", "dx", "dy", "toRegionOp", "Landroid/graphics/Region$Op;", "toRegionOp--7u2Bmg", "(I)Landroid/graphics/Region$Op;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidCanvas.android.kt */
public final class AndroidCanvas implements Canvas {
    private Rect dstRect;
    private Canvas internalCanvas = AndroidCanvas_androidKt.EmptyCanvas;
    private Rect srcRect;

    public static /* synthetic */ void getInternalCanvas$annotations() {
    }

    /* renamed from: clipRect-mtrdD-E  reason: not valid java name */
    public /* synthetic */ void m3658clipRectmtrdDE(androidx.compose.ui.geometry.Rect rect, int i) {
        Canvas.CC.m3786$default$clipRectmtrdDE(this, rect, i);
    }

    public /* synthetic */ void drawArc(androidx.compose.ui.geometry.Rect rect, float f, float f2, boolean z, Paint paint) {
        Canvas.CC.$default$drawArc(this, rect, f, f2, z, paint);
    }

    public /* synthetic */ void drawArcRad(androidx.compose.ui.geometry.Rect rect, float f, float f2, boolean z, Paint paint) {
        Canvas.CC.$default$drawArcRad(this, rect, f, f2, z, paint);
    }

    public /* synthetic */ void drawOval(androidx.compose.ui.geometry.Rect rect, Paint paint) {
        Canvas.CC.$default$drawOval(this, rect, paint);
    }

    public /* synthetic */ void drawRect(androidx.compose.ui.geometry.Rect rect, Paint paint) {
        Canvas.CC.$default$drawRect(this, rect, paint);
    }

    public /* synthetic */ void skewRad(float f, float f2) {
        Canvas.CC.$default$skewRad(this, f, f2);
    }

    public final android.graphics.Canvas getInternalCanvas() {
        return this.internalCanvas;
    }

    public final void setInternalCanvas(android.graphics.Canvas canvas) {
        this.internalCanvas = canvas;
    }

    public void save() {
        this.internalCanvas.save();
    }

    public void restore() {
        this.internalCanvas.restore();
    }

    public void saveLayer(androidx.compose.ui.geometry.Rect rect, Paint paint) {
        this.internalCanvas.saveLayer(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), paint.asFrameworkPaint(), 31);
    }

    public void translate(float f, float f2) {
        this.internalCanvas.translate(f, f2);
    }

    public void scale(float f, float f2) {
        this.internalCanvas.scale(f, f2);
    }

    public void rotate(float f) {
        this.internalCanvas.rotate(f);
    }

    public void skew(float f, float f2) {
        this.internalCanvas.skew(f, f2);
    }

    /* renamed from: concat-58bKbWc  reason: not valid java name */
    public void m3659concat58bKbWc(float[] fArr) {
        if (!MatrixKt.m4082isIdentity58bKbWc(fArr)) {
            Matrix matrix = new Matrix();
            AndroidMatrixConversions_androidKt.m3674setFromEL8BTi8(matrix, fArr);
            this.internalCanvas.concat(matrix);
        }
    }

    /* renamed from: clipRect-N_I0leg  reason: not valid java name */
    public void m3657clipRectN_I0leg(float f, float f2, float f3, float f4, int i) {
        this.internalCanvas.clipRect(f, f2, f3, f4, m3667toRegionOp7u2Bmg(i));
    }

    /* renamed from: clipPath-mtrdD-E  reason: not valid java name */
    public void m3656clipPathmtrdDE(Path path, int i) {
        android.graphics.Canvas canvas = this.internalCanvas;
        if (path instanceof AndroidPath) {
            canvas.clipPath(((AndroidPath) path).getInternalPath(), m3667toRegionOp7u2Bmg(i));
            return;
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    /* renamed from: toRegionOp--7u2Bmg  reason: not valid java name */
    public final Region.Op m3667toRegionOp7u2Bmg(int i) {
        if (ClipOp.m3800equalsimpl0(i, ClipOp.Companion.m3804getDifferencertfAjoo())) {
            return Region.Op.DIFFERENCE;
        }
        return Region.Op.INTERSECT;
    }

    /* renamed from: drawLine-Wko1d7g  reason: not valid java name */
    public void m3663drawLineWko1d7g(long j, long j2, Paint paint) {
        this.internalCanvas.drawLine(Offset.m3562getXimpl(j), Offset.m3563getYimpl(j), Offset.m3562getXimpl(j2), Offset.m3563getYimpl(j2), paint.asFrameworkPaint());
    }

    public void drawRect(float f, float f2, float f3, float f4, Paint paint) {
        this.internalCanvas.drawRect(f, f2, f3, f4, paint.asFrameworkPaint());
    }

    public void drawRoundRect(float f, float f2, float f3, float f4, float f5, float f6, Paint paint) {
        this.internalCanvas.drawRoundRect(f, f2, f3, f4, f5, f6, paint.asFrameworkPaint());
    }

    public void drawOval(float f, float f2, float f3, float f4, Paint paint) {
        this.internalCanvas.drawOval(f, f2, f3, f4, paint.asFrameworkPaint());
    }

    /* renamed from: drawCircle-9KIMszo  reason: not valid java name */
    public void m3660drawCircle9KIMszo(long j, float f, Paint paint) {
        this.internalCanvas.drawCircle(Offset.m3562getXimpl(j), Offset.m3563getYimpl(j), f, paint.asFrameworkPaint());
    }

    public void drawArc(float f, float f2, float f3, float f4, float f5, float f6, boolean z, Paint paint) {
        this.internalCanvas.drawArc(f, f2, f3, f4, f5, f6, z, paint.asFrameworkPaint());
    }

    public void drawPath(Path path, Paint paint) {
        android.graphics.Canvas canvas = this.internalCanvas;
        if (path instanceof AndroidPath) {
            canvas.drawPath(((AndroidPath) path).getInternalPath(), paint.asFrameworkPaint());
            return;
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    /* renamed from: drawImage-d-4ec7I  reason: not valid java name */
    public void m3661drawImaged4ec7I(ImageBitmap imageBitmap, long j, Paint paint) {
        this.internalCanvas.drawBitmap(AndroidImageBitmap_androidKt.asAndroidBitmap(imageBitmap), Offset.m3562getXimpl(j), Offset.m3563getYimpl(j), paint.asFrameworkPaint());
    }

    /* renamed from: drawImageRect-HPBpro0  reason: not valid java name */
    public void m3662drawImageRectHPBpro0(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, Paint paint) {
        if (this.srcRect == null) {
            this.srcRect = new Rect();
            this.dstRect = new Rect();
        }
        android.graphics.Canvas canvas = this.internalCanvas;
        Bitmap asAndroidBitmap = AndroidImageBitmap_androidKt.asAndroidBitmap(imageBitmap);
        Rect rect = this.srcRect;
        Intrinsics.checkNotNull(rect);
        rect.left = IntOffset.m6748getXimpl(j);
        rect.top = IntOffset.m6749getYimpl(j);
        rect.right = IntOffset.m6748getXimpl(j) + IntSize.m6790getWidthimpl(j2);
        rect.bottom = IntOffset.m6749getYimpl(j) + IntSize.m6789getHeightimpl(j2);
        Unit unit = Unit.INSTANCE;
        Rect rect2 = this.dstRect;
        Intrinsics.checkNotNull(rect2);
        rect2.left = IntOffset.m6748getXimpl(j3);
        rect2.top = IntOffset.m6749getYimpl(j3);
        rect2.right = IntOffset.m6748getXimpl(j3) + IntSize.m6790getWidthimpl(j4);
        rect2.bottom = IntOffset.m6749getYimpl(j3) + IntSize.m6789getHeightimpl(j4);
        Unit unit2 = Unit.INSTANCE;
        canvas.drawBitmap(asAndroidBitmap, rect, rect2, paint.asFrameworkPaint());
    }

    /* renamed from: drawPoints-O7TthRY  reason: not valid java name */
    public void m3664drawPointsO7TthRY(int i, List<Offset> list, Paint paint) {
        if (PointMode.m4148equalsimpl0(i, PointMode.Companion.m4152getLinesr_lszbg())) {
            drawLines(list, paint, 2);
        } else if (PointMode.m4148equalsimpl0(i, PointMode.Companion.m4154getPolygonr_lszbg())) {
            drawLines(list, paint, 1);
        } else if (PointMode.m4148equalsimpl0(i, PointMode.Companion.m4153getPointsr_lszbg())) {
            drawPoints(list, paint);
        }
    }

    public void enableZ() {
        CanvasUtils.INSTANCE.enableZ(this.internalCanvas, true);
    }

    public void disableZ() {
        CanvasUtils.INSTANCE.enableZ(this.internalCanvas, false);
    }

    private final void drawLines(List<Offset> list, Paint paint, int i) {
        if (list.size() >= 2) {
            Paint asFrameworkPaint = paint.asFrameworkPaint();
            int i2 = 0;
            while (i2 < list.size() - 1) {
                long r1 = list.get(i2).m3572unboximpl();
                long r3 = list.get(i2 + 1).m3572unboximpl();
                this.internalCanvas.drawLine(Offset.m3562getXimpl(r1), Offset.m3563getYimpl(r1), Offset.m3562getXimpl(r3), Offset.m3563getYimpl(r3), asFrameworkPaint);
                i2 += i;
            }
        }
    }

    /* renamed from: drawRawPoints-O7TthRY  reason: not valid java name */
    public void m3665drawRawPointsO7TthRY(int i, float[] fArr, Paint paint) {
        if (fArr.length % 2 != 0) {
            throw new IllegalArgumentException("points must have an even number of values");
        } else if (PointMode.m4148equalsimpl0(i, PointMode.Companion.m4152getLinesr_lszbg())) {
            drawRawLines(fArr, paint, 2);
        } else if (PointMode.m4148equalsimpl0(i, PointMode.Companion.m4154getPolygonr_lszbg())) {
            drawRawLines(fArr, paint, 1);
        } else if (PointMode.m4148equalsimpl0(i, PointMode.Companion.m4153getPointsr_lszbg())) {
            drawRawPoints(fArr, paint, 2);
        }
    }

    private final void drawRawPoints(float[] fArr, Paint paint, int i) {
        if (fArr.length % 2 == 0) {
            Paint asFrameworkPaint = paint.asFrameworkPaint();
            int i2 = 0;
            while (i2 < fArr.length - 1) {
                this.internalCanvas.drawPoint(fArr[i2], fArr[i2 + 1], asFrameworkPaint);
                i2 += i;
            }
        }
    }

    private final void drawRawLines(float[] fArr, Paint paint, int i) {
        if (fArr.length >= 4 && fArr.length % 2 == 0) {
            Paint asFrameworkPaint = paint.asFrameworkPaint();
            int i2 = 0;
            while (i2 < fArr.length - 3) {
                this.internalCanvas.drawLine(fArr[i2], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3], asFrameworkPaint);
                i2 += i * 2;
            }
        }
    }

    /* renamed from: drawVertices-TPEHhCM  reason: not valid java name */
    public void m3666drawVerticesTPEHhCM(Vertices vertices, int i, Paint paint) {
        this.internalCanvas.drawVertices(AndroidVertexMode_androidKt.m3710toAndroidVertexModeJOOmi9M(vertices.m4280getVertexModec2xauaI()), vertices.getPositions().length, vertices.getPositions(), 0, vertices.getTextureCoordinates(), 0, vertices.getColors(), 0, vertices.getIndices(), 0, vertices.getIndices().length, paint.asFrameworkPaint());
    }

    private final void drawPoints(List<Offset> list, Paint paint) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            long r2 = list.get(i).m3572unboximpl();
            this.internalCanvas.drawPoint(Offset.m3562getXimpl(r2), Offset.m3563getYimpl(r2), paint.asFrameworkPaint());
        }
    }
}
