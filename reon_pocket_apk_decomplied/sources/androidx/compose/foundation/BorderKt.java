package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\u001e\u0010\u000b\u001a\u00020\f*\u00020\f2\u0006\u0010\u000b\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007\u001a.\u0010\u000b\u001a\u00020\f*\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a0\u0010\u000b\u001a\u00020\f*\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\f\u0010\u001a\u001a\u00020\u001b*\u00020\u001cH\u0002\u001a>\u0010\u001d\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u001e\u0010%\u001a\u00020&*\u00020&2\u0006\u0010'\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006*"}, d2 = {"createInsetRoundedRect", "Landroidx/compose/ui/geometry/RoundRect;", "widthPx", "", "roundedRect", "createRoundRectPath", "Landroidx/compose/ui/graphics/Path;", "targetPath", "strokeWidth", "fillArea", "", "border", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/foundation/BorderStroke;", "shape", "Landroidx/compose/ui/graphics/Shape;", "width", "Landroidx/compose/ui/unit/Dp;", "brush", "Landroidx/compose/ui/graphics/Brush;", "border-ziNgDLE", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "border-xT4_qwU", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "drawContentWithoutBorder", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "drawRectBorder", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "borderSize", "Landroidx/compose/ui/geometry/Size;", "strokeWidthPx", "drawRectBorder-NsqcLGU", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/graphics/Brush;JJZF)Landroidx/compose/ui/draw/DrawResult;", "shrink", "Landroidx/compose/ui/geometry/CornerRadius;", "value", "shrink-Kibmq7A", "(JF)J", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Border.kt */
public final class BorderKt {
    public static /* synthetic */ Modifier border$default(Modifier modifier, BorderStroke borderStroke, Shape shape, int i, Object obj) {
        if ((i & 2) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        return border(modifier, borderStroke, shape);
    }

    public static final Modifier border(Modifier modifier, BorderStroke borderStroke, Shape shape) {
        return m227borderziNgDLE(modifier, borderStroke.m240getWidthD9Ej5fM(), borderStroke.getBrush(), shape);
    }

    /* renamed from: border-xT4_qwU$default  reason: not valid java name */
    public static /* synthetic */ Modifier m226borderxT4_qwU$default(Modifier modifier, float f, long j, Shape shape, int i, Object obj) {
        if ((i & 4) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        return m225borderxT4_qwU(modifier, f, j, shape);
    }

    /* renamed from: border-xT4_qwU  reason: not valid java name */
    public static final Modifier m225borderxT4_qwU(Modifier modifier, float f, long j, Shape shape) {
        return m227borderziNgDLE(modifier, f, new SolidColor(j, (DefaultConstructorMarker) null), shape);
    }

    /* renamed from: border-ziNgDLE  reason: not valid java name */
    public static final Modifier m227borderziNgDLE(Modifier modifier, float f, Brush brush, Shape shape) {
        return modifier.then(new BorderModifierNodeElement(f, brush, shape, (DefaultConstructorMarker) null));
    }

    /* access modifiers changed from: private */
    public static final DrawResult drawContentWithoutBorder(CacheDrawScope cacheDrawScope) {
        return cacheDrawScope.onDrawWithContent(BorderKt$drawContentWithoutBorder$1.INSTANCE);
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [androidx.compose.ui.graphics.drawscope.Fill] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: drawRectBorder-NsqcLGU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.draw.DrawResult m228drawRectBorderNsqcLGU(androidx.compose.ui.draw.CacheDrawScope r16, androidx.compose.ui.graphics.Brush r17, long r18, long r20, boolean r22, float r23) {
        /*
            if (r22 == 0) goto L_0x000a
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r0.m3578getZeroF1C5BW0()
            r4 = r0
            goto L_0x000c
        L_0x000a:
            r4 = r18
        L_0x000c:
            if (r22 == 0) goto L_0x0014
            long r0 = r16.m3452getSizeNHjbRc()
            r6 = r0
            goto L_0x0016
        L_0x0014:
            r6 = r20
        L_0x0016:
            if (r22 == 0) goto L_0x001b
            androidx.compose.ui.graphics.drawscope.Fill r0 = androidx.compose.ui.graphics.drawscope.Fill.INSTANCE
            goto L_0x002a
        L_0x001b:
            androidx.compose.ui.graphics.drawscope.Stroke r0 = new androidx.compose.ui.graphics.drawscope.Stroke
            r14 = 30
            r15 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r8 = r0
            r9 = r23
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)
        L_0x002a:
            androidx.compose.ui.graphics.drawscope.DrawStyle r0 = (androidx.compose.ui.graphics.drawscope.DrawStyle) r0
            r8 = r0
            androidx.compose.foundation.BorderKt$drawRectBorder$1 r0 = new androidx.compose.foundation.BorderKt$drawRectBorder$1
            r2 = r0
            r3 = r17
            r2.<init>(r3, r4, r6, r8)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r1 = r16
            androidx.compose.ui.draw.DrawResult r0 = r1.onDrawWithContent(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BorderKt.m228drawRectBorderNsqcLGU(androidx.compose.ui.draw.CacheDrawScope, androidx.compose.ui.graphics.Brush, long, long, boolean, float):androidx.compose.ui.draw.DrawResult");
    }

    /* access modifiers changed from: private */
    public static final Path createRoundRectPath(Path path, RoundRect roundRect, float f, boolean z) {
        path.reset();
        path.addRoundRect(roundRect);
        if (!z) {
            Path Path = AndroidPath_androidKt.Path();
            Path.addRoundRect(createInsetRoundedRect(f, roundRect));
            path.m4110opN5in7k0(path, Path, PathOperation.Companion.m4139getDifferenceb3I0S0c());
        }
        return path;
    }

    private static final RoundRect createInsetRoundedRect(float f, RoundRect roundRect) {
        float f2 = f;
        return new RoundRect(f, f2, roundRect.getWidth() - f2, roundRect.getHeight() - f2, m229shrinkKibmq7A(roundRect.m3612getTopLeftCornerRadiuskKHJgLs(), f), m229shrinkKibmq7A(roundRect.m3613getTopRightCornerRadiuskKHJgLs(), f), m229shrinkKibmq7A(roundRect.m3611getBottomRightCornerRadiuskKHJgLs(), f), m229shrinkKibmq7A(roundRect.m3610getBottomLeftCornerRadiuskKHJgLs(), f), (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: shrink-Kibmq7A  reason: not valid java name */
    public static final long m229shrinkKibmq7A(long j, float f) {
        return CornerRadiusKt.CornerRadius(Math.max(0.0f, CornerRadius.m3537getXimpl(j) - f), Math.max(0.0f, CornerRadius.m3538getYimpl(j) - f));
    }
}
