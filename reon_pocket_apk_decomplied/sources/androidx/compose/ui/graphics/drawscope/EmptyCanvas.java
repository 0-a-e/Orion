package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Vertices;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ:\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0004H\u0016JH\u0010\u0019\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J*\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\b$\u0010%J*\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\b*\u0010+JB\u0010,\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020.2\u0006\u00102\u001a\u0002002\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\b3\u00104J*\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00020\"2\u0006\u00107\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\b8\u00109J0\u0010:\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010;\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J0\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020>2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\"0@2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ*\u0010C\u001a\u00020\u00042\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020D2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\bE\u0010FJ0\u0010G\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J@\u0010H\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010I\u001a\u00020\r2\u0006\u0010J\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J*\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020O2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\bP\u0010QJ\b\u0010R\u001a\u00020\u0004H\u0016J\b\u0010S\u001a\u00020\u0004H\u0016J\u0010\u0010T\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\rH\u0016J\b\u0010V\u001a\u00020\u0004H\u0016J\u0018\u0010W\u001a\u00020\u00042\u0006\u0010X\u001a\u00020Y2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010Z\u001a\u00020\u00042\u0006\u0010[\u001a\u00020\r2\u0006\u0010\\\u001a\u00020\rH\u0016J\u0018\u0010]\u001a\u00020\u00042\u0006\u0010[\u001a\u00020\r2\u0006\u0010\\\u001a\u00020\rH\u0016J\u0018\u0010^\u001a\u00020\u00042\u0006\u0010_\u001a\u00020\r2\u0006\u0010`\u001a\u00020\rH\u0016\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006a"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/EmptyCanvas;", "Landroidx/compose/ui/graphics/Canvas;", "()V", "clipPath", "", "path", "Landroidx/compose/ui/graphics/Path;", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "clipRect", "left", "", "top", "right", "bottom", "clipRect-N_I0leg", "(FFFFI)V", "concat", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "concat-58bKbWc", "([F)V", "disableZ", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "paint", "Landroidx/compose/ui/graphics/Paint;", "drawCircle", "center", "Landroidx/compose/ui/geometry/Offset;", "radius", "drawCircle-9KIMszo", "(JFLandroidx/compose/ui/graphics/Paint;)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "topLeftOffset", "drawImage-d-4ec7I", "(Landroidx/compose/ui/graphics/ImageBitmap;JLandroidx/compose/ui/graphics/Paint;)V", "drawImageRect", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImageRect-HPBpro0", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJLandroidx/compose/ui/graphics/Paint;)V", "drawLine", "p1", "p2", "drawLine-Wko1d7g", "(JJLandroidx/compose/ui/graphics/Paint;)V", "drawOval", "drawPath", "drawPoints", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "points", "", "drawPoints-O7TthRY", "(ILjava/util/List;Landroidx/compose/ui/graphics/Paint;)V", "drawRawPoints", "", "drawRawPoints-O7TthRY", "(I[FLandroidx/compose/ui/graphics/Paint;)V", "drawRect", "drawRoundRect", "radiusX", "radiusY", "drawVertices", "vertices", "Landroidx/compose/ui/graphics/Vertices;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawVertices-TPEHhCM", "(Landroidx/compose/ui/graphics/Vertices;ILandroidx/compose/ui/graphics/Paint;)V", "enableZ", "restore", "rotate", "degrees", "save", "saveLayer", "bounds", "Landroidx/compose/ui/geometry/Rect;", "scale", "sx", "sy", "skew", "translate", "dx", "dy", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: EmptyCanvas.kt */
public final class EmptyCanvas implements Canvas {
    /* renamed from: clipRect-mtrdD-E  reason: not valid java name */
    public /* synthetic */ void m4546clipRectmtrdDE(Rect rect, int i) {
        Canvas.CC.m3786$default$clipRectmtrdDE(this, rect, i);
    }

    public /* synthetic */ void drawArc(Rect rect, float f, float f2, boolean z, Paint paint) {
        Canvas.CC.$default$drawArc(this, rect, f, f2, z, paint);
    }

    public /* synthetic */ void drawArcRad(Rect rect, float f, float f2, boolean z, Paint paint) {
        Canvas.CC.$default$drawArcRad(this, rect, f, f2, z, paint);
    }

    public /* synthetic */ void drawOval(Rect rect, Paint paint) {
        Canvas.CC.$default$drawOval(this, rect, paint);
    }

    public /* synthetic */ void drawRect(Rect rect, Paint paint) {
        Canvas.CC.$default$drawRect(this, rect, paint);
    }

    public /* synthetic */ void skewRad(float f, float f2) {
        Canvas.CC.$default$skewRad(this, f, f2);
    }

    public void save() {
        throw new UnsupportedOperationException();
    }

    public void restore() {
        throw new UnsupportedOperationException();
    }

    public void saveLayer(Rect rect, Paint paint) {
        throw new UnsupportedOperationException();
    }

    public void translate(float f, float f2) {
        throw new UnsupportedOperationException();
    }

    public void scale(float f, float f2) {
        throw new UnsupportedOperationException();
    }

    public void rotate(float f) {
        throw new UnsupportedOperationException();
    }

    public void skew(float f, float f2) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: concat-58bKbWc  reason: not valid java name */
    public void m4547concat58bKbWc(float[] fArr) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: clipRect-N_I0leg  reason: not valid java name */
    public void m4545clipRectN_I0leg(float f, float f2, float f3, float f4, int i) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: clipPath-mtrdD-E  reason: not valid java name */
    public void m4544clipPathmtrdDE(Path path, int i) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: drawLine-Wko1d7g  reason: not valid java name */
    public void m4551drawLineWko1d7g(long j, long j2, Paint paint) {
        throw new UnsupportedOperationException();
    }

    public void drawRect(float f, float f2, float f3, float f4, Paint paint) {
        throw new UnsupportedOperationException();
    }

    public void drawRoundRect(float f, float f2, float f3, float f4, float f5, float f6, Paint paint) {
        throw new UnsupportedOperationException();
    }

    public void drawOval(float f, float f2, float f3, float f4, Paint paint) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: drawCircle-9KIMszo  reason: not valid java name */
    public void m4548drawCircle9KIMszo(long j, float f, Paint paint) {
        throw new UnsupportedOperationException();
    }

    public void drawArc(float f, float f2, float f3, float f4, float f5, float f6, boolean z, Paint paint) {
        throw new UnsupportedOperationException();
    }

    public void drawPath(Path path, Paint paint) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: drawImage-d-4ec7I  reason: not valid java name */
    public void m4549drawImaged4ec7I(ImageBitmap imageBitmap, long j, Paint paint) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: drawImageRect-HPBpro0  reason: not valid java name */
    public void m4550drawImageRectHPBpro0(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, Paint paint) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: drawPoints-O7TthRY  reason: not valid java name */
    public void m4552drawPointsO7TthRY(int i, List<Offset> list, Paint paint) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: drawRawPoints-O7TthRY  reason: not valid java name */
    public void m4553drawRawPointsO7TthRY(int i, float[] fArr, Paint paint) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: drawVertices-TPEHhCM  reason: not valid java name */
    public void m4554drawVerticesTPEHhCM(Vertices vertices, int i, Paint paint) {
        throw new UnsupportedOperationException();
    }

    public void enableZ() {
        throw new UnsupportedOperationException();
    }

    public void disableZ() {
        throw new UnsupportedOperationException();
    }
}
