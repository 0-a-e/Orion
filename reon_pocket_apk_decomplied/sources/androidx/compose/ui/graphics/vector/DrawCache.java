package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JI\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00190\u001c¢\u0006\u0002\b\u001eø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J$\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u001d2\b\b\u0002\u0010#\u001a\u00020$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&J\f\u0010'\u001a\u00020\u0019*\u00020\u001dH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u00020\bX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R&\u0010\f\u001a\u0004\u0018\u00010\r8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u00020\u0016X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0017\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Landroidx/compose/ui/graphics/vector/DrawCache;", "", "()V", "cacheScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "cachedCanvas", "Landroidx/compose/ui/graphics/Canvas;", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "I", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "mCachedImage", "Landroidx/compose/ui/graphics/ImageBitmap;", "getMCachedImage$annotations", "getMCachedImage", "()Landroidx/compose/ui/graphics/ImageBitmap;", "setMCachedImage", "(Landroidx/compose/ui/graphics/ImageBitmap;)V", "scopeDensity", "Landroidx/compose/ui/unit/Density;", "size", "Landroidx/compose/ui/unit/IntSize;", "J", "drawCachedImage", "", "density", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "drawCachedImage-FqjB98A", "(IJLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Lkotlin/jvm/functions/Function1;)V", "drawInto", "target", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "clear", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DrawCache.kt */
public final class DrawCache {
    public static final int $stable = 8;
    private final CanvasDrawScope cacheScope = new CanvasDrawScope();
    private Canvas cachedCanvas;
    private int config = ImageBitmapConfig.Companion.m4046getArgb8888_sVssgQ();
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private ImageBitmap mCachedImage;
    private Density scopeDensity;
    private long size = IntSize.Companion.m6795getZeroYbymL2g();

    public static /* synthetic */ void getMCachedImage$annotations() {
    }

    public final ImageBitmap getMCachedImage() {
        return this.mCachedImage;
    }

    public final void setMCachedImage(ImageBitmap imageBitmap) {
        this.mCachedImage = imageBitmap;
    }

    /* renamed from: drawCachedImage-FqjB98A  reason: not valid java name */
    public final void m4571drawCachedImageFqjB98A(int i, long j, Density density, LayoutDirection layoutDirection2, Function1<? super DrawScope, Unit> function1) {
        int i2 = i;
        Density density2 = density;
        LayoutDirection layoutDirection3 = layoutDirection2;
        this.scopeDensity = density2;
        this.layoutDirection = layoutDirection3;
        ImageBitmap imageBitmap = this.mCachedImage;
        Canvas canvas = this.cachedCanvas;
        if (imageBitmap == null || canvas == null || IntSize.m6790getWidthimpl(j) > imageBitmap.getWidth() || IntSize.m6789getHeightimpl(j) > imageBitmap.getHeight() || !ImageBitmapConfig.m4041equalsimpl0(this.config, i)) {
            imageBitmap = ImageBitmapKt.m4051ImageBitmapx__hDU$default(IntSize.m6790getWidthimpl(j), IntSize.m6789getHeightimpl(j), i, false, (ColorSpace) null, 24, (Object) null);
            canvas = CanvasKt.Canvas(imageBitmap);
            this.mCachedImage = imageBitmap;
            this.cachedCanvas = canvas;
            this.config = i2;
        }
        this.size = j;
        CanvasDrawScope canvasDrawScope = this.cacheScope;
        long r3 = IntSizeKt.m6800toSizeozmzZPI(j);
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope.getDrawParams();
        Density component1 = drawParams.component1();
        LayoutDirection component2 = drawParams.component2();
        Canvas component3 = drawParams.component3();
        long r12 = drawParams.m4369component4NHjbRc();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope.getDrawParams();
        drawParams2.setDensity(density2);
        drawParams2.setLayoutDirection(layoutDirection3);
        drawParams2.setCanvas(canvas);
        drawParams2.m4372setSizeuvyYCjk(r3);
        canvas.save();
        DrawScope drawScope = canvasDrawScope;
        clear(drawScope);
        function1.invoke(drawScope);
        canvas.restore();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope.getDrawParams();
        drawParams3.setDensity(component1);
        drawParams3.setLayoutDirection(component2);
        drawParams3.setCanvas(component3);
        drawParams3.m4372setSizeuvyYCjk(r12);
        imageBitmap.prepareToDraw();
    }

    public static /* synthetic */ void drawInto$default(DrawCache drawCache, DrawScope drawScope, float f, ColorFilter colorFilter, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 1.0f;
        }
        if ((i & 4) != 0) {
            colorFilter = null;
        }
        drawCache.drawInto(drawScope, f, colorFilter);
    }

    public final void drawInto(DrawScope drawScope, float f, ColorFilter colorFilter) {
        ImageBitmap imageBitmap = this.mCachedImage;
        if (imageBitmap != null) {
            DrawScope.CC.m4459drawImageAZ2fEMs$default(drawScope, imageBitmap, 0, this.size, 0, 0, f, (DrawStyle) null, colorFilter, 0, 0, 858, (Object) null);
            return;
        }
        throw new IllegalStateException("drawCachedImage must be invoked first before attempting to draw the result into another destination".toString());
    }

    private final void clear(DrawScope drawScope) {
        DrawScope.CC.m4470drawRectnJ9OG0$default(drawScope, Color.Companion.m3842getBlack0d7_KjU(), 0, 0, 0.0f, (DrawStyle) null, (ColorFilter) null, BlendMode.Companion.m3719getClear0nO6VwU(), 62, (Object) null);
    }
}
