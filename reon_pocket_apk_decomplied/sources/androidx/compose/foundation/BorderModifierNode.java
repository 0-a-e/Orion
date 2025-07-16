package androidx.compose.foundation;

import androidx.compose.ui.draw.CacheDrawModifierNode;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ,\u0010\u001e\u001a\u00020\u001f*\u00020 2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002JF\u0010'\u001a\u00020\u001f*\u00020 2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010!\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\b-\u0010.R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R,\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@FX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006/"}, d2 = {"Landroidx/compose/foundation/BorderModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "widthParameter", "Landroidx/compose/ui/unit/Dp;", "brushParameter", "Landroidx/compose/ui/graphics/Brush;", "shapeParameter", "Landroidx/compose/ui/graphics/Shape;", "(FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "borderCache", "Landroidx/compose/foundation/BorderCache;", "value", "brush", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "setBrush", "(Landroidx/compose/ui/graphics/Brush;)V", "drawWithCacheModifierNode", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "shape", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "width", "getWidth-D9Ej5fM", "()F", "setWidth-0680j_4", "(F)V", "F", "drawGenericBorder", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "outline", "Landroidx/compose/ui/graphics/Outline$Generic;", "fillArea", "", "strokeWidth", "", "drawRoundRectBorder", "Landroidx/compose/ui/graphics/Outline$Rounded;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "borderSize", "Landroidx/compose/ui/geometry/Size;", "drawRoundRectBorder-JqoCqck", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Outline$Rounded;JJZF)Landroidx/compose/ui/draw/DrawResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Border.kt */
public final class BorderModifierNode extends DelegatingNode {
    public static final int $stable = 8;
    private BorderCache borderCache;
    private Brush brush;
    private final CacheDrawModifierNode drawWithCacheModifierNode;
    private Shape shape;
    private float width;

    public /* synthetic */ BorderModifierNode(float f, Brush brush2, Shape shape2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, brush2, shape2);
    }

    private BorderModifierNode(float f, Brush brush2, Shape shape2) {
        this.width = f;
        this.brush = brush2;
        this.shape = shape2;
        this.drawWithCacheModifierNode = (CacheDrawModifierNode) delegate(DrawModifierKt.CacheDrawModifierNode(new BorderModifierNode$drawWithCacheModifierNode$1(this)));
    }

    /* renamed from: getWidth-D9Ej5fM  reason: not valid java name */
    public final float m232getWidthD9Ej5fM() {
        return this.width;
    }

    /* renamed from: setWidth-0680j_4  reason: not valid java name */
    public final void m233setWidth0680j_4(float f) {
        if (!Dp.m6619equalsimpl0(this.width, f)) {
            this.width = f;
            this.drawWithCacheModifierNode.invalidateDrawCache();
        }
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public final void setBrush(Brush brush2) {
        if (!Intrinsics.areEqual((Object) this.brush, (Object) brush2)) {
            this.brush = brush2;
            this.drawWithCacheModifierNode.invalidateDrawCache();
        }
    }

    public final Shape getShape() {
        return this.shape;
    }

    public final void setShape(Shape shape2) {
        if (!Intrinsics.areEqual((Object) this.shape, (Object) shape2)) {
            this.shape = shape2;
            this.drawWithCacheModifierNode.invalidateDrawCache();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00da, code lost:
        if (androidx.compose.ui.graphics.ImageBitmapConfig.m4040equalsimpl(r14, r4) != false) goto L_0x00dc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.draw.DrawResult drawGenericBorder(androidx.compose.ui.draw.CacheDrawScope r46, androidx.compose.ui.graphics.Brush r47, androidx.compose.ui.graphics.Outline.Generic r48, boolean r49, float r50) {
        /*
            r45 = this;
            r0 = r45
            r1 = r46
            r11 = r47
            if (r49 == 0) goto L_0x0017
            androidx.compose.foundation.BorderModifierNode$drawGenericBorder$1 r2 = new androidx.compose.foundation.BorderModifierNode$drawGenericBorder$1
            r3 = r48
            r2.<init>(r3, r11)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.ui.draw.DrawResult r1 = r1.onDrawWithContent(r2)
            goto L_0x02a4
        L_0x0017:
            r3 = r48
            boolean r2 = r11 instanceof androidx.compose.ui.graphics.SolidColor
            r4 = 0
            if (r2 == 0) goto L_0x0038
            androidx.compose.ui.graphics.ImageBitmapConfig$Companion r2 = androidx.compose.ui.graphics.ImageBitmapConfig.Companion
            int r2 = r2.m4045getAlpha8_sVssgQ()
            androidx.compose.ui.graphics.ColorFilter$Companion r5 = androidx.compose.ui.graphics.ColorFilter.Companion
            r6 = r11
            androidx.compose.ui.graphics.SolidColor r6 = (androidx.compose.ui.graphics.SolidColor) r6
            long r6 = r6.m4212getValue0d7_KjU()
            r9 = 2
            r10 = 0
            r8 = 0
            androidx.compose.ui.graphics.ColorFilter r5 = androidx.compose.ui.graphics.ColorFilter.Companion.m3857tintxETnrds$default(r5, r6, r8, r9, r10)
            r14 = r2
            r19 = r5
            goto L_0x0041
        L_0x0038:
            androidx.compose.ui.graphics.ImageBitmapConfig$Companion r2 = androidx.compose.ui.graphics.ImageBitmapConfig.Companion
            int r2 = r2.m4046getArgb8888_sVssgQ()
            r14 = r2
            r19 = r4
        L_0x0041:
            androidx.compose.ui.graphics.Path r2 = r48.getPath()
            androidx.compose.ui.geometry.Rect r10 = r2.getBounds()
            androidx.compose.foundation.BorderCache r2 = r0.borderCache
            if (r2 != 0) goto L_0x0062
            androidx.compose.foundation.BorderCache r2 = new androidx.compose.foundation.BorderCache
            r25 = 15
            r26 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r20 = r2
            r20.<init>(r21, r22, r23, r24, r25, r26)
            r0.borderCache = r2
        L_0x0062:
            androidx.compose.foundation.BorderCache r2 = r0.borderCache
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            androidx.compose.ui.graphics.Path r9 = r2.obtainPath()
            r9.reset()
            r9.addRect(r10)
            androidx.compose.ui.graphics.Path r2 = r48.getPath()
            androidx.compose.ui.graphics.PathOperation$Companion r5 = androidx.compose.ui.graphics.PathOperation.Companion
            int r5 = r5.m4139getDifferenceb3I0S0c()
            r9.m4110opN5in7k0(r9, r2, r5)
            kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef
            r8.<init>()
            float r2 = r10.getWidth()
            double r5 = (double) r2
            double r5 = java.lang.Math.ceil(r5)
            float r2 = (float) r5
            int r2 = (int) r2
            float r5 = r10.getHeight()
            double r5 = (double) r5
            double r5 = java.lang.Math.ceil(r5)
            float r5 = (float) r5
            int r5 = (int) r5
            long r20 = androidx.compose.ui.unit.IntSizeKt.IntSize(r2, r5)
            androidx.compose.foundation.BorderCache r2 = r0.borderCache
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            androidx.compose.ui.graphics.ImageBitmap r5 = r2.imageBitmap
            androidx.compose.ui.graphics.Canvas r6 = r2.canvas
            if (r5 == 0) goto L_0x00b5
            int r7 = r5.m4037getConfig_sVssgQ()
            androidx.compose.ui.graphics.ImageBitmapConfig r7 = androidx.compose.ui.graphics.ImageBitmapConfig.m4038boximpl(r7)
            goto L_0x00b6
        L_0x00b5:
            r7 = r4
        L_0x00b6:
            androidx.compose.ui.graphics.ImageBitmapConfig$Companion r12 = androidx.compose.ui.graphics.ImageBitmapConfig.Companion
            int r12 = r12.m4046getArgb8888_sVssgQ()
            r13 = 0
            if (r7 != 0) goto L_0x00c1
            r7 = r13
            goto L_0x00c9
        L_0x00c1:
            int r7 = r7.m4044unboximpl()
            boolean r7 = androidx.compose.ui.graphics.ImageBitmapConfig.m4041equalsimpl0(r7, r12)
        L_0x00c9:
            r15 = 1
            if (r7 != 0) goto L_0x00dc
            if (r5 == 0) goto L_0x00d6
            int r4 = r5.m4037getConfig_sVssgQ()
            androidx.compose.ui.graphics.ImageBitmapConfig r4 = androidx.compose.ui.graphics.ImageBitmapConfig.m4038boximpl(r4)
        L_0x00d6:
            boolean r4 = androidx.compose.ui.graphics.ImageBitmapConfig.m4040equalsimpl(r14, r4)
            if (r4 == 0) goto L_0x00dd
        L_0x00dc:
            r13 = r15
        L_0x00dd:
            if (r5 == 0) goto L_0x010a
            if (r6 == 0) goto L_0x010a
            long r16 = r46.m3452getSizeNHjbRc()
            float r4 = androidx.compose.ui.geometry.Size.m3631getWidthimpl(r16)
            int r7 = r5.getWidth()
            float r7 = (float) r7
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r4 > 0) goto L_0x010a
            long r16 = r46.m3452getSizeNHjbRc()
            float r4 = androidx.compose.ui.geometry.Size.m3628getHeightimpl(r16)
            int r7 = r5.getHeight()
            float r7 = (float) r7
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r4 > 0) goto L_0x010a
            if (r13 != 0) goto L_0x0106
            goto L_0x010a
        L_0x0106:
            r12 = r5
            r13 = r6
            r7 = r15
            goto L_0x012b
        L_0x010a:
            int r12 = androidx.compose.ui.unit.IntSize.m6790getWidthimpl(r20)
            int r13 = androidx.compose.ui.unit.IntSize.m6789getHeightimpl(r20)
            r17 = 24
            r18 = 0
            r4 = 0
            r16 = 0
            r7 = r15
            r15 = r4
            androidx.compose.ui.graphics.ImageBitmap r5 = androidx.compose.ui.graphics.ImageBitmapKt.m4051ImageBitmapx__hDU$default(r12, r13, r14, r15, r16, r17, r18)
            r2.imageBitmap = r5
            androidx.compose.ui.graphics.Canvas r6 = androidx.compose.ui.graphics.CanvasKt.Canvas(r5)
            r2.canvas = r6
            r12 = r5
            r13 = r6
        L_0x012b:
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope r4 = r2.canvasDrawScope
            if (r4 != 0) goto L_0x0139
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope r4 = new androidx.compose.ui.graphics.drawscope.CanvasDrawScope
            r4.<init>()
            r2.canvasDrawScope = r4
        L_0x0139:
            r14 = r4
            long r4 = androidx.compose.ui.unit.IntSizeKt.m6800toSizeozmzZPI(r20)
            androidx.compose.ui.unit.LayoutDirection r2 = r46.getLayoutDirection()
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope$DrawParams r6 = r14.getDrawParams()
            androidx.compose.ui.unit.Density r15 = r6.component1()
            r49 = r9
            androidx.compose.ui.unit.LayoutDirection r9 = r6.component2()
            r16 = r9
            androidx.compose.ui.graphics.Canvas r9 = r6.component3()
            r17 = r8
            r18 = r9
            long r8 = r6.m4369component4NHjbRc()
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope$DrawParams r6 = r14.getDrawParams()
            r7 = r1
            androidx.compose.ui.unit.Density r7 = (androidx.compose.ui.unit.Density) r7
            r6.setDensity(r7)
            r6.setLayoutDirection(r2)
            r6.setCanvas(r13)
            r6.m4372setSizeuvyYCjk(r4)
            r13.save()
            r35 = r14
            androidx.compose.ui.graphics.drawscope.DrawScope r35 = (androidx.compose.ui.graphics.drawscope.DrawScope) r35
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            long r23 = r2.m3842getBlack0d7_KjU()
            androidx.compose.ui.graphics.BlendMode$Companion r2 = androidx.compose.ui.graphics.BlendMode.Companion
            int r32 = r2.m3719getClear0nO6VwU()
            r33 = 58
            r34 = 0
            r25 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r22 = r35
            r27 = r4
            androidx.compose.ui.graphics.drawscope.DrawScope.CC.m4470drawRectnJ9OG0$default(r22, r23, r25, r27, r29, r30, r31, r32, r33, r34)
            float r2 = r10.getLeft()
            float r7 = -r2
            float r2 = r10.getTop()
            float r6 = -r2
            androidx.compose.ui.graphics.drawscope.DrawContext r2 = r35.getDrawContext()
            androidx.compose.ui.graphics.drawscope.DrawTransform r2 = r2.getTransform()
            r2.translate(r7, r6)
            androidx.compose.ui.graphics.Path r3 = r48.getPath()
            androidx.compose.ui.graphics.drawscope.Stroke r2 = new androidx.compose.ui.graphics.drawscope.Stroke
            r4 = 2
            float r4 = (float) r4
            float r23 = r50 * r4
            r28 = 30
            r29 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r22 = r2
            r22.<init>(r23, r24, r25, r26, r27, r28, r29)
            r22 = r2
            androidx.compose.ui.graphics.drawscope.DrawStyle r22 = (androidx.compose.ui.graphics.drawscope.DrawStyle) r22
            r23 = 52
            r24 = 0
            r5 = 0
            r25 = 0
            r2 = r35
            r4 = r47
            r36 = r6
            r6 = r22
            r37 = r7
            r7 = r25
            r38 = r8
            r9 = r17
            r8 = r26
            r40 = r9
            r41 = r16
            r42 = r18
            r16 = r49
            r9 = r23
            r17 = r10
            r10 = r24
            androidx.compose.ui.graphics.drawscope.DrawScope.CC.m4465drawPathGBMwjPU$default(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            long r2 = r35.m4434getSizeNHjbRc()
            float r2 = androidx.compose.ui.geometry.Size.m3631getWidthimpl(r2)
            r3 = 1
            float r3 = (float) r3
            float r2 = r2 + r3
            long r4 = r35.m4434getSizeNHjbRc()
            float r4 = androidx.compose.ui.geometry.Size.m3631getWidthimpl(r4)
            float r2 = r2 / r4
            long r4 = r35.m4434getSizeNHjbRc()
            float r4 = androidx.compose.ui.geometry.Size.m3628getHeightimpl(r4)
            float r4 = r4 + r3
            long r5 = r35.m4434getSizeNHjbRc()
            float r3 = androidx.compose.ui.geometry.Size.m3628getHeightimpl(r5)
            float r4 = r4 / r3
            long r5 = r35.m4433getCenterF1C5BW0()
            androidx.compose.ui.graphics.drawscope.DrawContext r10 = r35.getDrawContext()
            long r8 = r10.m4412getSizeNHjbRc()
            androidx.compose.ui.graphics.Canvas r3 = r10.getCanvas()
            r3.save()
            androidx.compose.ui.graphics.drawscope.DrawTransform r3 = r10.getTransform()
            r3.m4527scale0AR0LA0(r2, r4, r5)
            androidx.compose.ui.graphics.BlendMode$Companion r2 = androidx.compose.ui.graphics.BlendMode.Companion
            int r18 = r2.m3719getClear0nO6VwU()
            r22 = 28
            r23 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r2 = r35
            r3 = r16
            r4 = r47
            r43 = r8
            r8 = r18
            r9 = r22
            r11 = r10
            r10 = r23
            androidx.compose.ui.graphics.drawscope.DrawScope.CC.m4465drawPathGBMwjPU$default(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            androidx.compose.ui.graphics.Canvas r2 = r11.getCanvas()
            r2.restore()
            r2 = r43
            r11.m4413setSizeuvyYCjk(r2)
            androidx.compose.ui.graphics.drawscope.DrawContext r2 = r35.getDrawContext()
            androidx.compose.ui.graphics.drawscope.DrawTransform r2 = r2.getTransform()
            r3 = r37
            float r3 = -r3
            r4 = r36
            float r4 = -r4
            r2.translate(r3, r4)
            r13.restore()
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope$DrawParams r2 = r14.getDrawParams()
            r2.setDensity(r15)
            r3 = r41
            r2.setLayoutDirection(r3)
            r3 = r42
            r2.setCanvas(r3)
            r3 = r38
            r2.m4372setSizeuvyYCjk(r3)
            r12.prepareToDraw()
            r2 = r40
            r2.element = r12
            androidx.compose.foundation.BorderModifierNode$drawGenericBorder$3 r3 = new androidx.compose.foundation.BorderModifierNode$drawGenericBorder$3
            r5 = r3
            r6 = r17
            r7 = r2
            r8 = r20
            r10 = r19
            r5.<init>(r6, r7, r8, r10)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.ui.draw.DrawResult r1 = r1.onDrawWithContent(r3)
        L_0x02a4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BorderModifierNode.drawGenericBorder(androidx.compose.ui.draw.CacheDrawScope, androidx.compose.ui.graphics.Brush, androidx.compose.ui.graphics.Outline$Generic, boolean, float):androidx.compose.ui.draw.DrawResult");
    }

    /* access modifiers changed from: private */
    /* renamed from: drawRoundRectBorder-JqoCqck  reason: not valid java name */
    public final DrawResult m231drawRoundRectBorderJqoCqck(CacheDrawScope cacheDrawScope, Brush brush2, Outline.Rounded rounded, long j, long j2, boolean z, float f) {
        CacheDrawScope cacheDrawScope2 = cacheDrawScope;
        float f2 = f;
        if (RoundRectKt.isSimple(rounded.getRoundRect())) {
            return cacheDrawScope2.onDrawWithContent(new BorderModifierNode$drawRoundRectBorder$1(z, brush2, rounded.getRoundRect().m3612getTopLeftCornerRadiuskKHJgLs(), f2 / ((float) 2), f, j, j2, new Stroke(f, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null)));
        }
        if (this.borderCache == null) {
            this.borderCache = new BorderCache((ImageBitmap) null, (Canvas) null, (CanvasDrawScope) null, (Path) null, 15, (DefaultConstructorMarker) null);
        }
        BorderCache borderCache2 = this.borderCache;
        Intrinsics.checkNotNull(borderCache2);
        return cacheDrawScope2.onDrawWithContent(new BorderModifierNode$drawRoundRectBorder$2(BorderKt.createRoundRectPath(borderCache2.obtainPath(), rounded.getRoundRect(), f2, z), brush2));
    }
}
