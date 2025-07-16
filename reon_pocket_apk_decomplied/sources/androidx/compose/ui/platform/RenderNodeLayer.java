package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Fields;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.layout.GraphicLayerInfo;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 U2\u00020\u00012\u00020\u0002:\u0002UVB/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u0007H\u0002J\b\u0010,\u001a\u00020\bH\u0016J\u0010\u0010-\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u0007H\u0016J\b\u0010.\u001a\u00020\bH\u0016J\u001a\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u000201H\u0016ø\u0001\u0000¢\u0006\u0004\b2\u00103J\u001a\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u000206H\u0016ø\u0001\u0000¢\u0006\u0004\b7\u00108J\u0018\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u000fH\u0016J\"\u0010=\u001a\u0002062\u0006\u0010>\u001a\u0002062\u0006\u0010<\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\u001a\u0010A\u001a\u00020\b2\u0006\u00105\u001a\u00020BH\u0016ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ\u001a\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020GH\u0016ø\u0001\u0000¢\u0006\u0004\bH\u0010DJ*\u0010I\u001a\u00020\b2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0016J\u001a\u0010J\u001a\u00020\b2\u0006\u00100\u001a\u000201H\u0016ø\u0001\u0000¢\u0006\u0004\bK\u00103J\b\u0010L\u001a\u00020\bH\u0002J\b\u0010M\u001a\u00020\bH\u0016J \u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020TH\u0016R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0018R\u000e\u0010$\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\u00020(X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010)\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006W"}, d2 = {"Landroidx/compose/ui/platform/RenderNodeLayer;", "Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/layout/GraphicLayerInfo;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "", "invalidateParentLayer", "Lkotlin/Function0;", "(Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "drawnWithZ", "", "isDestroyed", "value", "isDirty", "setDirty", "(Z)V", "layerId", "", "getLayerId", "()J", "matrixCache", "Landroidx/compose/ui/platform/LayerMatrixCache;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "mutatedFields", "", "outlineResolver", "Landroidx/compose/ui/platform/OutlineResolver;", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "ownerViewId", "getOwnerViewId", "renderNode", "softwareLayerPaint", "Landroidx/compose/ui/graphics/Paint;", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "clipRenderNode", "canvas", "destroy", "drawLayer", "invalidate", "inverseTransform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "inverseTransform-58bKbWc", "([F)V", "isInLayer", "position", "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "inverse", "mapOffset", "point", "mapOffset-8S9VItk", "(JZ)J", "move", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "resize", "size", "Landroidx/compose/ui/unit/IntSize;", "resize-ozmzZPI", "reuseLayer", "transform", "transform-58bKbWc", "triggerRepaint", "updateDisplayList", "updateLayerProperties", "scope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "Companion", "UniqueDrawingIdApi29", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RenderNodeLayer.android.kt */
public final class RenderNodeLayer implements OwnedLayer, GraphicLayerInfo {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Function2<DeviceRenderNode, Matrix, Unit> getMatrix = RenderNodeLayer$Companion$getMatrix$1.INSTANCE;
    private final CanvasHolder canvasHolder = new CanvasHolder();
    private Function1<? super Canvas, Unit> drawBlock;
    private boolean drawnWithZ;
    private Function0<Unit> invalidateParentLayer;
    private boolean isDestroyed;
    private boolean isDirty;
    private final LayerMatrixCache<DeviceRenderNode> matrixCache = new LayerMatrixCache<>(getMatrix);
    private int mutatedFields;
    private final OutlineResolver outlineResolver;
    private final AndroidComposeView ownerView;
    private final DeviceRenderNode renderNode;
    private Paint softwareLayerPaint;
    private long transformOrigin = TransformOrigin.Companion.m4269getCenterSzJe1aQ();

    public RenderNodeLayer(AndroidComposeView androidComposeView, Function1<? super Canvas, Unit> function1, Function0<Unit> function0) {
        DeviceRenderNode deviceRenderNode;
        this.ownerView = androidComposeView;
        this.drawBlock = function1;
        this.invalidateParentLayer = function0;
        this.outlineResolver = new OutlineResolver(androidComposeView.getDensity());
        if (Build.VERSION.SDK_INT >= 29) {
            deviceRenderNode = new RenderNodeApi29(androidComposeView);
        } else {
            deviceRenderNode = new RenderNodeApi23(androidComposeView);
        }
        deviceRenderNode.setHasOverlappingRendering(true);
        deviceRenderNode.setClipToBounds(false);
        this.renderNode = deviceRenderNode;
    }

    public final AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    private final void setDirty(boolean z) {
        if (z != this.isDirty) {
            this.isDirty = z;
            this.ownerView.notifyLayerIsDirty$ui_release(this, z);
        }
    }

    public long getLayerId() {
        return this.renderNode.getUniqueId();
    }

    public long getOwnerViewId() {
        if (Build.VERSION.SDK_INT >= 29) {
            return UniqueDrawingIdApi29.getUniqueDrawingId(this.ownerView);
        }
        return -1;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/platform/RenderNodeLayer$UniqueDrawingIdApi29;", "", "()V", "getUniqueDrawingId", "", "view", "Landroid/view/View;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: RenderNodeLayer.android.kt */
    private static final class UniqueDrawingIdApi29 {
        public static final UniqueDrawingIdApi29 INSTANCE = new UniqueDrawingIdApi29();

        private UniqueDrawingIdApi29() {
        }

        @JvmStatic
        public static final long getUniqueDrawingId(View view) {
            return RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m(view);
        }
    }

    public void updateLayerProperties(ReusableGraphicsLayerScope reusableGraphicsLayerScope, LayoutDirection layoutDirection, Density density) {
        Function0<Unit> function0;
        int mutatedFields$ui_release = reusableGraphicsLayerScope.getMutatedFields$ui_release() | this.mutatedFields;
        int i = mutatedFields$ui_release & 4096;
        if (i != 0) {
            this.transformOrigin = reusableGraphicsLayerScope.m4167getTransformOriginSzJe1aQ();
        }
        boolean z = false;
        boolean z2 = this.renderNode.getClipToOutline() && !this.outlineResolver.getOutlineClipSupported();
        if ((mutatedFields$ui_release & 1) != 0) {
            this.renderNode.setScaleX(reusableGraphicsLayerScope.getScaleX());
        }
        if ((mutatedFields$ui_release & 2) != 0) {
            this.renderNode.setScaleY(reusableGraphicsLayerScope.getScaleY());
        }
        if ((mutatedFields$ui_release & 4) != 0) {
            this.renderNode.setAlpha(reusableGraphicsLayerScope.getAlpha());
        }
        if ((mutatedFields$ui_release & 8) != 0) {
            this.renderNode.setTranslationX(reusableGraphicsLayerScope.getTranslationX());
        }
        if ((mutatedFields$ui_release & 16) != 0) {
            this.renderNode.setTranslationY(reusableGraphicsLayerScope.getTranslationY());
        }
        if ((mutatedFields$ui_release & 32) != 0) {
            this.renderNode.setElevation(reusableGraphicsLayerScope.getShadowElevation());
        }
        if ((mutatedFields$ui_release & 64) != 0) {
            this.renderNode.setAmbientShadowColor(ColorKt.m3870toArgb8_81llA(reusableGraphicsLayerScope.m4163getAmbientShadowColor0d7_KjU()));
        }
        if ((mutatedFields$ui_release & 128) != 0) {
            this.renderNode.setSpotShadowColor(ColorKt.m3870toArgb8_81llA(reusableGraphicsLayerScope.m4166getSpotShadowColor0d7_KjU()));
        }
        if ((mutatedFields$ui_release & 1024) != 0) {
            this.renderNode.setRotationZ(reusableGraphicsLayerScope.getRotationZ());
        }
        if ((mutatedFields$ui_release & 256) != 0) {
            this.renderNode.setRotationX(reusableGraphicsLayerScope.getRotationX());
        }
        if ((mutatedFields$ui_release & 512) != 0) {
            this.renderNode.setRotationY(reusableGraphicsLayerScope.getRotationY());
        }
        if ((mutatedFields$ui_release & 2048) != 0) {
            this.renderNode.setCameraDistance(reusableGraphicsLayerScope.getCameraDistance());
        }
        if (i != 0) {
            this.renderNode.setPivotX(TransformOrigin.m4264getPivotFractionXimpl(this.transformOrigin) * ((float) this.renderNode.getWidth()));
            this.renderNode.setPivotY(TransformOrigin.m4265getPivotFractionYimpl(this.transformOrigin) * ((float) this.renderNode.getHeight()));
        }
        boolean z3 = reusableGraphicsLayerScope.getClip() && reusableGraphicsLayerScope.getShape() != RectangleShapeKt.getRectangleShape();
        if ((mutatedFields$ui_release & CpioConstants.C_ISBLK) != 0) {
            this.renderNode.setClipToOutline(z3);
            this.renderNode.setClipToBounds(reusableGraphicsLayerScope.getClip() && reusableGraphicsLayerScope.getShape() == RectangleShapeKt.getRectangleShape());
        }
        if ((131072 & mutatedFields$ui_release) != 0) {
            this.renderNode.setRenderEffect(reusableGraphicsLayerScope.getRenderEffect());
        }
        if ((32768 & mutatedFields$ui_release) != 0) {
            this.renderNode.m5774setCompositingStrategyaDBOjCE(reusableGraphicsLayerScope.m4164getCompositingStrategyNrFUSI());
        }
        boolean update = this.outlineResolver.update(reusableGraphicsLayerScope.getShape(), reusableGraphicsLayerScope.getAlpha(), z3, reusableGraphicsLayerScope.getShadowElevation(), layoutDirection, density);
        if (this.outlineResolver.getCacheIsDirty$ui_release()) {
            this.renderNode.setOutline(this.outlineResolver.getOutline());
        }
        if (z3 && !this.outlineResolver.getOutlineClipSupported()) {
            z = true;
        }
        if (z2 != z || (z && update)) {
            invalidate();
        } else {
            triggerRepaint();
        }
        if (!this.drawnWithZ && this.renderNode.getElevation() > 0.0f && (function0 = this.invalidateParentLayer) != null) {
            function0.invoke();
        }
        if ((mutatedFields$ui_release & Fields.MatrixAffectingFields) != 0) {
            this.matrixCache.invalidate();
        }
        this.mutatedFields = reusableGraphicsLayerScope.getMutatedFields$ui_release();
    }

    /* renamed from: isInLayer-k-4lQ0M  reason: not valid java name */
    public boolean m5823isInLayerk4lQ0M(long j) {
        float r0 = Offset.m3562getXimpl(j);
        float r1 = Offset.m3563getYimpl(j);
        if (this.renderNode.getClipToBounds()) {
            if (0.0f > r0 || r0 >= ((float) this.renderNode.getWidth()) || 0.0f > r1 || r1 >= ((float) this.renderNode.getHeight())) {
                return false;
            }
            return true;
        } else if (this.renderNode.getClipToOutline()) {
            return this.outlineResolver.m5816isInOutlinek4lQ0M(j);
        } else {
            return true;
        }
    }

    /* renamed from: resize-ozmzZPI  reason: not valid java name */
    public void m5826resizeozmzZPI(long j) {
        int r0 = IntSize.m6790getWidthimpl(j);
        int r7 = IntSize.m6789getHeightimpl(j);
        float f = (float) r0;
        this.renderNode.setPivotX(TransformOrigin.m4264getPivotFractionXimpl(this.transformOrigin) * f);
        float f2 = (float) r7;
        this.renderNode.setPivotY(TransformOrigin.m4265getPivotFractionYimpl(this.transformOrigin) * f2);
        DeviceRenderNode deviceRenderNode = this.renderNode;
        if (deviceRenderNode.setPosition(deviceRenderNode.getLeft(), this.renderNode.getTop(), this.renderNode.getLeft() + r0, this.renderNode.getTop() + r7)) {
            this.outlineResolver.m5817updateuvyYCjk(SizeKt.Size(f, f2));
            this.renderNode.setOutline(this.outlineResolver.getOutline());
            invalidate();
            this.matrixCache.invalidate();
        }
    }

    /* renamed from: move--gyyYBs  reason: not valid java name */
    public void m5825movegyyYBs(long j) {
        int left = this.renderNode.getLeft();
        int top = this.renderNode.getTop();
        int r2 = IntOffset.m6748getXimpl(j);
        int r4 = IntOffset.m6749getYimpl(j);
        if (left != r2 || top != r4) {
            if (left != r2) {
                this.renderNode.offsetLeftAndRight(r2 - left);
            }
            if (top != r4) {
                this.renderNode.offsetTopAndBottom(r4 - top);
            }
            triggerRepaint();
            this.matrixCache.invalidate();
        }
    }

    public void invalidate() {
        if (!this.isDirty && !this.isDestroyed) {
            this.ownerView.invalidate();
            setDirty(true);
        }
    }

    private final void triggerRepaint() {
        if (Build.VERSION.SDK_INT >= 26) {
            WrapperRenderNodeLayerHelperMethods.INSTANCE.onDescendantInvalidated(this.ownerView);
        } else {
            this.ownerView.invalidate();
        }
    }

    public void drawLayer(Canvas canvas) {
        android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        boolean z = false;
        if (nativeCanvas.isHardwareAccelerated()) {
            updateDisplayList();
            if (this.renderNode.getElevation() > 0.0f) {
                z = true;
            }
            this.drawnWithZ = z;
            if (z) {
                canvas.enableZ();
            }
            this.renderNode.drawInto(nativeCanvas);
            if (this.drawnWithZ) {
                canvas.disableZ();
                return;
            }
            return;
        }
        float left = (float) this.renderNode.getLeft();
        float top = (float) this.renderNode.getTop();
        float right = (float) this.renderNode.getRight();
        float bottom = (float) this.renderNode.getBottom();
        if (this.renderNode.getAlpha() < 1.0f) {
            Paint paint = this.softwareLayerPaint;
            if (paint == null) {
                paint = AndroidPaint_androidKt.Paint();
                this.softwareLayerPaint = paint;
            }
            paint.setAlpha(this.renderNode.getAlpha());
            nativeCanvas.saveLayer(left, top, right, bottom, paint.asFrameworkPaint());
        } else {
            canvas.save();
        }
        canvas.translate(left, top);
        canvas.m3778concat58bKbWc(this.matrixCache.m5790calculateMatrixGrdbGEg(this.renderNode));
        clipRenderNode(canvas);
        Function1<? super Canvas, Unit> function1 = this.drawBlock;
        if (function1 != null) {
            function1.invoke(canvas);
        }
        canvas.restore();
        setDirty(false);
    }

    private final void clipRenderNode(Canvas canvas) {
        if (this.renderNode.getClipToOutline() || this.renderNode.getClipToBounds()) {
            this.outlineResolver.clipToOutline(canvas);
        }
    }

    public void updateDisplayList() {
        if (this.isDirty || !this.renderNode.getHasDisplayList()) {
            Path clipPath = (!this.renderNode.getClipToOutline() || this.outlineResolver.getOutlineClipSupported()) ? null : this.outlineResolver.getClipPath();
            Function1<? super Canvas, Unit> function1 = this.drawBlock;
            if (function1 != null) {
                this.renderNode.record(this.canvasHolder, clipPath, function1);
            }
            setDirty(false);
        }
    }

    public void destroy() {
        if (this.renderNode.getHasDisplayList()) {
            this.renderNode.discardDisplayList();
        }
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.isDestroyed = true;
        setDirty(false);
        this.ownerView.requestClearInvalidObservations();
        this.ownerView.recycle$ui_release(this);
    }

    /* renamed from: mapOffset-8S9VItk  reason: not valid java name */
    public long m5824mapOffset8S9VItk(long j, boolean z) {
        if (!z) {
            return androidx.compose.ui.graphics.Matrix.m4064mapMKHz9U(this.matrixCache.m5790calculateMatrixGrdbGEg(this.renderNode), j);
        }
        float[] r4 = this.matrixCache.m5789calculateInverseMatrixbWbORWo(this.renderNode);
        return r4 != null ? androidx.compose.ui.graphics.Matrix.m4064mapMKHz9U(r4, j) : Offset.Companion.m3576getInfiniteF1C5BW0();
    }

    public void mapBounds(MutableRect mutableRect, boolean z) {
        if (z) {
            float[] r3 = this.matrixCache.m5789calculateInverseMatrixbWbORWo(this.renderNode);
            if (r3 == null) {
                mutableRect.set(0.0f, 0.0f, 0.0f, 0.0f);
            } else {
                androidx.compose.ui.graphics.Matrix.m4066mapimpl(r3, mutableRect);
            }
        } else {
            androidx.compose.ui.graphics.Matrix.m4066mapimpl(this.matrixCache.m5790calculateMatrixGrdbGEg(this.renderNode), mutableRect);
        }
    }

    public void reuseLayer(Function1<? super Canvas, Unit> function1, Function0<Unit> function0) {
        setDirty(false);
        this.isDestroyed = false;
        this.drawnWithZ = false;
        this.transformOrigin = TransformOrigin.Companion.m4269getCenterSzJe1aQ();
        this.drawBlock = function1;
        this.invalidateParentLayer = function0;
    }

    /* renamed from: transform-58bKbWc  reason: not valid java name */
    public void m5827transform58bKbWc(float[] fArr) {
        androidx.compose.ui.graphics.Matrix.m4075timesAssign58bKbWc(fArr, this.matrixCache.m5790calculateMatrixGrdbGEg(this.renderNode));
    }

    /* renamed from: inverseTransform-58bKbWc  reason: not valid java name */
    public void m5822inverseTransform58bKbWc(float[] fArr) {
        float[] r0 = this.matrixCache.m5789calculateInverseMatrixbWbORWo(this.renderNode);
        if (r0 != null) {
            androidx.compose.ui.graphics.Matrix.m4075timesAssign58bKbWc(fArr, r0);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/compose/ui/platform/RenderNodeLayer$Companion;", "", "()V", "getMatrix", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "Landroid/graphics/Matrix;", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: RenderNodeLayer.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
