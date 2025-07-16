package androidx.compose.ui.platform;

import android.graphics.Outline;
import android.os.Build;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200J\u0018\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020!ø\u0001\u0000¢\u0006\u0004\b3\u00104J\u0018\u00105\u001a\u00020.2\u0006\u0010&\u001a\u00020\u001eø\u0001\u0000¢\u0006\u0004\b6\u00107J6\u00105\u001a\u00020\u00062\u0006\u0010$\u001a\u00020%2\u0006\u00108\u001a\u00020#2\u0006\u0010-\u001a\u00020\u00062\u0006\u00109\u001a\u00020#2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u0003J\b\u0010:\u001a\u00020.H\u0002J\u0010\u0010;\u001a\u00020.2\u0006\u0010<\u001a\u00020\rH\u0002J\u0010\u0010=\u001a\u00020.2\u0006\u0010>\u001a\u00020?H\u0002J\u0010\u0010@\u001a\u00020.2\u0006\u0010A\u001a\u00020*H\u0002J0\u0010B\u001a\u00020\u0006*\u0004\u0018\u00010*2\u0006\u0010C\u001a\u00020!2\u0006\u0010&\u001a\u00020\u001e2\u0006\u0010D\u001a\u00020#H\u0002ø\u0001\u0000¢\u0006\u0004\bE\u0010FR\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\tR\u000e\u0010\u001b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\u00020\u001eX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001fR\u0016\u0010 \u001a\u00020!X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\u00020\u001eX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001fR\u0010\u0010'\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006G"}, d2 = {"Landroidx/compose/ui/platform/OutlineResolver;", "", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/ui/unit/Density;)V", "<set-?>", "", "cacheIsDirty", "getCacheIsDirty$ui_release", "()Z", "cachedOutline", "Landroid/graphics/Outline;", "cachedRrectPath", "Landroidx/compose/ui/graphics/Path;", "calculatedOutline", "Landroidx/compose/ui/graphics/Outline;", "clipPath", "getClipPath", "()Landroidx/compose/ui/graphics/Path;", "isSupportedOutline", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outline", "getOutline", "()Landroid/graphics/Outline;", "outlineClipSupported", "getOutlineClipSupported", "outlineNeeded", "outlinePath", "rectSize", "Landroidx/compose/ui/geometry/Size;", "J", "rectTopLeft", "Landroidx/compose/ui/geometry/Offset;", "roundedCornerRadius", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "size", "tmpOpPath", "tmpPath", "tmpRoundRect", "Landroidx/compose/ui/geometry/RoundRect;", "tmpTouchPointPath", "usePathForClip", "clipToOutline", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "isInOutline", "position", "isInOutline-k-4lQ0M", "(J)Z", "update", "update-uvyYCjk", "(J)V", "alpha", "elevation", "updateCache", "updateCacheWithPath", "composePath", "updateCacheWithRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "updateCacheWithRoundRect", "roundRect", "isSameBounds", "offset", "radius", "isSameBounds-4L21HEs", "(Landroidx/compose/ui/geometry/RoundRect;JJF)Z", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: OutlineResolver.android.kt */
public final class OutlineResolver {
    public static final int $stable = 8;
    private boolean cacheIsDirty;
    private final Outline cachedOutline;
    private Path cachedRrectPath;
    private androidx.compose.ui.graphics.Outline calculatedOutline;
    private Density density;
    private boolean isSupportedOutline = true;
    private LayoutDirection layoutDirection;
    private boolean outlineNeeded;
    private Path outlinePath;
    private long rectSize;
    private long rectTopLeft;
    private float roundedCornerRadius;
    private Shape shape;
    private long size;
    private Path tmpOpPath;
    private Path tmpPath;
    private RoundRect tmpRoundRect;
    private Path tmpTouchPointPath;
    private boolean usePathForClip;

    public OutlineResolver(Density density2) {
        this.density = density2;
        Outline outline = new Outline();
        outline.setAlpha(1.0f);
        this.cachedOutline = outline;
        this.size = Size.Companion.m3640getZeroNHjbRc();
        this.shape = RectangleShapeKt.getRectangleShape();
        this.rectTopLeft = Offset.Companion.m3578getZeroF1C5BW0();
        this.rectSize = Size.Companion.m3640getZeroNHjbRc();
        this.layoutDirection = LayoutDirection.Ltr;
    }

    public final boolean getCacheIsDirty$ui_release() {
        return this.cacheIsDirty;
    }

    public final Outline getOutline() {
        updateCache();
        if (!this.outlineNeeded || !this.isSupportedOutline) {
            return null;
        }
        return this.cachedOutline;
    }

    public final boolean getOutlineClipSupported() {
        return !this.usePathForClip;
    }

    public final Path getClipPath() {
        updateCache();
        return this.outlinePath;
    }

    public final boolean update(Shape shape2, float f, boolean z, float f2, LayoutDirection layoutDirection2, Density density2) {
        this.cachedOutline.setAlpha(f);
        boolean z2 = !Intrinsics.areEqual((Object) this.shape, (Object) shape2);
        if (z2) {
            this.shape = shape2;
            this.cacheIsDirty = true;
        }
        boolean z3 = z || f2 > 0.0f;
        if (this.outlineNeeded != z3) {
            this.outlineNeeded = z3;
            this.cacheIsDirty = true;
        }
        if (this.layoutDirection != layoutDirection2) {
            this.layoutDirection = layoutDirection2;
            this.cacheIsDirty = true;
        }
        if (!Intrinsics.areEqual((Object) this.density, (Object) density2)) {
            this.density = density2;
            this.cacheIsDirty = true;
        }
        return z2;
    }

    /* renamed from: isInOutline-k-4lQ0M  reason: not valid java name */
    public final boolean m5816isInOutlinek4lQ0M(long j) {
        androidx.compose.ui.graphics.Outline outline;
        if (this.outlineNeeded && (outline = this.calculatedOutline) != null) {
            return ShapeContainingUtilKt.isInOutline(outline, Offset.m3562getXimpl(j), Offset.m3563getYimpl(j), this.tmpTouchPointPath, this.tmpOpPath);
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0029, code lost:
        if (m5815isSameBounds4L21HEs(r1, r7.rectTopLeft, r7.rectSize, r6) == false) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void clipToOutline(androidx.compose.ui.graphics.Canvas r21) {
        /*
            r20 = this;
            r7 = r20
            r8 = r21
            androidx.compose.ui.graphics.Path r0 = r20.getClipPath()
            r9 = 0
            r10 = 0
            r11 = 2
            if (r0 == 0) goto L_0x0012
            androidx.compose.ui.graphics.Canvas.CC.m3788clipPathmtrdDE$default(r8, r0, r9, r11, r10)
            goto L_0x00a3
        L_0x0012:
            float r6 = r7.roundedCornerRadius
            r12 = 0
            int r0 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r0 <= 0) goto L_0x0072
            androidx.compose.ui.graphics.Path r13 = r7.tmpPath
            androidx.compose.ui.geometry.RoundRect r1 = r7.tmpRoundRect
            if (r13 == 0) goto L_0x002b
            long r2 = r7.rectTopLeft
            long r4 = r7.rectSize
            r0 = r20
            boolean r0 = r0.m5815isSameBounds4L21HEs(r1, r2, r4, r6)
            if (r0 != 0) goto L_0x006e
        L_0x002b:
            long r0 = r7.rectTopLeft
            float r14 = androidx.compose.ui.geometry.Offset.m3562getXimpl(r0)
            long r0 = r7.rectTopLeft
            float r15 = androidx.compose.ui.geometry.Offset.m3563getYimpl(r0)
            long r0 = r7.rectTopLeft
            float r0 = androidx.compose.ui.geometry.Offset.m3562getXimpl(r0)
            long r1 = r7.rectSize
            float r1 = androidx.compose.ui.geometry.Size.m3631getWidthimpl(r1)
            float r16 = r0 + r1
            long r0 = r7.rectTopLeft
            float r0 = androidx.compose.ui.geometry.Offset.m3563getYimpl(r0)
            long r1 = r7.rectSize
            float r1 = androidx.compose.ui.geometry.Size.m3628getHeightimpl(r1)
            float r17 = r0 + r1
            float r0 = r7.roundedCornerRadius
            long r18 = androidx.compose.ui.geometry.CornerRadiusKt.CornerRadius$default(r0, r12, r11, r10)
            androidx.compose.ui.geometry.RoundRect r0 = androidx.compose.ui.geometry.RoundRectKt.m3616RoundRectgG7oq9Y(r14, r15, r16, r17, r18)
            if (r13 != 0) goto L_0x0064
            androidx.compose.ui.graphics.Path r13 = androidx.compose.ui.graphics.AndroidPath_androidKt.Path()
            goto L_0x0067
        L_0x0064:
            r13.reset()
        L_0x0067:
            r13.addRoundRect(r0)
            r7.tmpRoundRect = r0
            r7.tmpPath = r13
        L_0x006e:
            androidx.compose.ui.graphics.Canvas.CC.m3788clipPathmtrdDE$default(r8, r13, r9, r11, r10)
            goto L_0x00a3
        L_0x0072:
            long r0 = r7.rectTopLeft
            float r9 = androidx.compose.ui.geometry.Offset.m3562getXimpl(r0)
            long r0 = r7.rectTopLeft
            float r10 = androidx.compose.ui.geometry.Offset.m3563getYimpl(r0)
            long r0 = r7.rectTopLeft
            float r0 = androidx.compose.ui.geometry.Offset.m3562getXimpl(r0)
            long r1 = r7.rectSize
            float r1 = androidx.compose.ui.geometry.Size.m3631getWidthimpl(r1)
            float r11 = r0 + r1
            long r0 = r7.rectTopLeft
            float r0 = androidx.compose.ui.geometry.Offset.m3563getYimpl(r0)
            long r1 = r7.rectSize
            float r1 = androidx.compose.ui.geometry.Size.m3628getHeightimpl(r1)
            float r12 = r0 + r1
            r14 = 16
            r15 = 0
            r13 = 0
            r8 = r21
            androidx.compose.ui.graphics.Canvas.CC.m3789clipRectN_I0leg$default(r8, r9, r10, r11, r12, r13, r14, r15)
        L_0x00a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.OutlineResolver.clipToOutline(androidx.compose.ui.graphics.Canvas):void");
    }

    /* renamed from: update-uvyYCjk  reason: not valid java name */
    public final void m5817updateuvyYCjk(long j) {
        if (!Size.m3627equalsimpl0(this.size, j)) {
            this.size = j;
            this.cacheIsDirty = true;
        }
    }

    private final void updateCache() {
        if (this.cacheIsDirty) {
            this.rectTopLeft = Offset.Companion.m3578getZeroF1C5BW0();
            long j = this.size;
            this.rectSize = j;
            this.roundedCornerRadius = 0.0f;
            this.outlinePath = null;
            this.cacheIsDirty = false;
            this.usePathForClip = false;
            if (!this.outlineNeeded || Size.m3631getWidthimpl(j) <= 0.0f || Size.m3628getHeightimpl(this.size) <= 0.0f) {
                this.cachedOutline.setEmpty();
                return;
            }
            this.isSupportedOutline = true;
            androidx.compose.ui.graphics.Outline r0 = this.shape.m4201createOutlinePq9zytI(this.size, this.layoutDirection, this.density);
            this.calculatedOutline = r0;
            if (r0 instanceof Outline.Rectangle) {
                updateCacheWithRect(((Outline.Rectangle) r0).getRect());
            } else if (r0 instanceof Outline.Rounded) {
                updateCacheWithRoundRect(((Outline.Rounded) r0).getRoundRect());
            } else if (r0 instanceof Outline.Generic) {
                updateCacheWithPath(((Outline.Generic) r0).getPath());
            }
        }
    }

    private final void updateCacheWithRect(Rect rect) {
        this.rectTopLeft = OffsetKt.Offset(rect.getLeft(), rect.getTop());
        this.rectSize = SizeKt.Size(rect.getWidth(), rect.getHeight());
        this.cachedOutline.setRect(MathKt.roundToInt(rect.getLeft()), MathKt.roundToInt(rect.getTop()), MathKt.roundToInt(rect.getRight()), MathKt.roundToInt(rect.getBottom()));
    }

    private final void updateCacheWithRoundRect(RoundRect roundRect) {
        float r0 = CornerRadius.m3537getXimpl(roundRect.m3612getTopLeftCornerRadiuskKHJgLs());
        this.rectTopLeft = OffsetKt.Offset(roundRect.getLeft(), roundRect.getTop());
        this.rectSize = SizeKt.Size(roundRect.getWidth(), roundRect.getHeight());
        if (RoundRectKt.isSimple(roundRect)) {
            this.cachedOutline.setRoundRect(MathKt.roundToInt(roundRect.getLeft()), MathKt.roundToInt(roundRect.getTop()), MathKt.roundToInt(roundRect.getRight()), MathKt.roundToInt(roundRect.getBottom()), r0);
            this.roundedCornerRadius = r0;
            return;
        }
        Path path = this.cachedRrectPath;
        if (path == null) {
            path = AndroidPath_androidKt.Path();
            this.cachedRrectPath = path;
        }
        path.reset();
        path.addRoundRect(roundRect);
        updateCacheWithPath(path);
    }

    private final void updateCacheWithPath(Path path) {
        if (Build.VERSION.SDK_INT > 28 || path.isConvex()) {
            android.graphics.Outline outline = this.cachedOutline;
            if (path instanceof AndroidPath) {
                outline.setConvexPath(((AndroidPath) path).getInternalPath());
                this.usePathForClip = !this.cachedOutline.canClip();
            } else {
                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
            }
        } else {
            this.isSupportedOutline = false;
            this.cachedOutline.setEmpty();
            this.usePathForClip = true;
        }
        this.outlinePath = path;
    }

    /* renamed from: isSameBounds-4L21HEs  reason: not valid java name */
    private final boolean m5815isSameBounds4L21HEs(RoundRect roundRect, long j, long j2, float f) {
        if (roundRect != null && RoundRectKt.isSimple(roundRect) && roundRect.getLeft() == Offset.m3562getXimpl(j) && roundRect.getTop() == Offset.m3563getYimpl(j) && roundRect.getRight() == Offset.m3562getXimpl(j) + Size.m3631getWidthimpl(j2) && roundRect.getBottom() == Offset.m3563getYimpl(j) + Size.m3628getHeightimpl(j2) && CornerRadius.m3537getXimpl(roundRect.m3612getTopLeftCornerRadiuskKHJgLs()) == f) {
            return true;
        }
        return false;
    }
}
