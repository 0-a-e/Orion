package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.Fields;
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
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 n2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002noB7\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\u0010\u000eJ\b\u00109\u001a\u00020\u000bH\u0016J\u0010\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020<H\u0014J\u0010\u0010=\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\nH\u0016J\b\u0010>\u001a\u00020\u000bH\u0016J\b\u0010?\u001a\u00020\u001bH\u0016J\b\u0010@\u001a\u00020\u000bH\u0016J\u001a\u0010A\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020CH\u0016ø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\u001a\u0010F\u001a\u00020\u001b2\u0006\u0010G\u001a\u00020HH\u0016ø\u0001\u0000¢\u0006\u0004\bI\u0010JJ\u0018\u0010K\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u001bH\u0016J\"\u0010O\u001a\u00020H2\u0006\u0010P\u001a\u00020H2\u0006\u0010N\u001a\u00020\u001bH\u0016ø\u0001\u0000¢\u0006\u0004\bQ\u0010RJ\u001a\u0010S\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020TH\u0016ø\u0001\u0000¢\u0006\u0004\bU\u0010VJ0\u0010W\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020\u001b2\u0006\u0010Y\u001a\u0002022\u0006\u0010Z\u001a\u0002022\u0006\u0010[\u001a\u0002022\u0006\u0010\\\u001a\u000202H\u0014J\b\u0010]\u001a\u00020\u000bH\u0002J\u001a\u0010^\u001a\u00020\u000b2\u0006\u0010_\u001a\u00020`H\u0016ø\u0001\u0000¢\u0006\u0004\ba\u0010VJ*\u0010b\u001a\u00020\u000b2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0016J\u001a\u0010c\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020CH\u0016ø\u0001\u0000¢\u0006\u0004\bd\u0010EJ\b\u0010e\u001a\u00020\u000bH\u0016J \u0010f\u001a\u00020\u000b2\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020lH\u0016J\b\u0010m\u001a\u00020\u000bH\u0002R$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@FX\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R$\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u001b@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020$X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\u00020)X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010*R\u0016\u0010+\u001a\u0004\u0018\u00010,8BX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000100X\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0014\u00107\u001a\u00020$8VX\u0004¢\u0006\u0006\u001a\u0004\b8\u0010&\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006p"}, d2 = {"Landroidx/compose/ui/platform/ViewLayer;", "Landroid/view/View;", "Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/layout/GraphicLayerInfo;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "container", "Landroidx/compose/ui/platform/DrawChildContainer;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "", "invalidateParentLayer", "Lkotlin/Function0;", "(Landroidx/compose/ui/platform/AndroidComposeView;Landroidx/compose/ui/platform/DrawChildContainer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "value", "", "cameraDistancePx", "getCameraDistancePx", "()F", "setCameraDistancePx", "(F)V", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipBoundsCache", "Landroid/graphics/Rect;", "clipToBounds", "", "getContainer", "()Landroidx/compose/ui/platform/DrawChildContainer;", "drawnWithZ", "isInvalidated", "()Z", "setInvalidated", "(Z)V", "layerId", "", "getLayerId", "()J", "mHasOverlappingRendering", "mTransformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "manualClipPath", "Landroidx/compose/ui/graphics/Path;", "getManualClipPath", "()Landroidx/compose/ui/graphics/Path;", "matrixCache", "Landroidx/compose/ui/platform/LayerMatrixCache;", "mutatedFields", "", "outlineResolver", "Landroidx/compose/ui/platform/OutlineResolver;", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "ownerViewId", "getOwnerViewId", "destroy", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "drawLayer", "forceLayout", "hasOverlappingRendering", "invalidate", "inverseTransform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "inverseTransform-58bKbWc", "([F)V", "isInLayer", "position", "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "inverse", "mapOffset", "point", "mapOffset-8S9VItk", "(JZ)J", "move", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "onLayout", "changed", "l", "t", "r", "b", "resetClipBounds", "resize", "size", "Landroidx/compose/ui/unit/IntSize;", "resize-ozmzZPI", "reuseLayer", "transform", "transform-58bKbWc", "updateDisplayList", "updateLayerProperties", "scope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "updateOutlineResolver", "Companion", "UniqueDrawingIdApi29", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ViewLayer.android.kt */
public final class ViewLayer extends View implements OwnedLayer, GraphicLayerInfo {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final ViewOutlineProvider OutlineProvider = new ViewLayer$Companion$OutlineProvider$1();
    private static final Function2<View, Matrix, Unit> getMatrix = ViewLayer$Companion$getMatrix$1.INSTANCE;
    /* access modifiers changed from: private */
    public static boolean hasRetrievedMethod;
    /* access modifiers changed from: private */
    public static Field recreateDisplayList;
    /* access modifiers changed from: private */
    public static boolean shouldUseDispatchDraw;
    /* access modifiers changed from: private */
    public static Method updateDisplayListIfDirtyMethod;
    private final CanvasHolder canvasHolder = new CanvasHolder();
    private Rect clipBoundsCache;
    private boolean clipToBounds;
    private final DrawChildContainer container;
    private Function1<? super Canvas, Unit> drawBlock;
    private boolean drawnWithZ;
    private Function0<Unit> invalidateParentLayer;
    private boolean isInvalidated;
    private final long layerId;
    private boolean mHasOverlappingRendering = true;
    private long mTransformOrigin = TransformOrigin.Companion.m4269getCenterSzJe1aQ();
    private final LayerMatrixCache<View> matrixCache = new LayerMatrixCache<>(getMatrix);
    private int mutatedFields;
    /* access modifiers changed from: private */
    public final OutlineResolver outlineResolver;
    private final AndroidComposeView ownerView;

    public void forceLayout() {
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public final AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    public final DrawChildContainer getContainer() {
        return this.container;
    }

    public ViewLayer(AndroidComposeView androidComposeView, DrawChildContainer drawChildContainer, Function1<? super Canvas, Unit> function1, Function0<Unit> function0) {
        super(androidComposeView.getContext());
        this.ownerView = androidComposeView;
        this.container = drawChildContainer;
        this.drawBlock = function1;
        this.invalidateParentLayer = function0;
        this.outlineResolver = new OutlineResolver(androidComposeView.getDensity());
        setWillNotDraw(false);
        drawChildContainer.addView(this);
        this.layerId = (long) View.generateViewId();
    }

    private final Path getManualClipPath() {
        if (!getClipToOutline() || this.outlineResolver.getOutlineClipSupported()) {
            return null;
        }
        return this.outlineResolver.getClipPath();
    }

    public final boolean isInvalidated() {
        return this.isInvalidated;
    }

    private final void setInvalidated(boolean z) {
        if (z != this.isInvalidated) {
            this.isInvalidated = z;
            this.ownerView.notifyLayerIsDirty$ui_release(this, z);
        }
    }

    public long getLayerId() {
        return this.layerId;
    }

    public long getOwnerViewId() {
        if (Build.VERSION.SDK_INT >= 29) {
            return UniqueDrawingIdApi29.getUniqueDrawingId(this.ownerView);
        }
        return -1;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/platform/ViewLayer$UniqueDrawingIdApi29;", "", "()V", "getUniqueDrawingId", "", "view", "Landroid/view/View;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ViewLayer.android.kt */
    private static final class UniqueDrawingIdApi29 {
        public static final UniqueDrawingIdApi29 INSTANCE = new UniqueDrawingIdApi29();

        private UniqueDrawingIdApi29() {
        }

        @JvmStatic
        public static final long getUniqueDrawingId(View view) {
            return RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m(view);
        }
    }

    public final float getCameraDistancePx() {
        return getCameraDistance() / ((float) getResources().getDisplayMetrics().densityDpi);
    }

    public final void setCameraDistancePx(float f) {
        setCameraDistance(f * ((float) getResources().getDisplayMetrics().densityDpi));
    }

    public void updateLayerProperties(ReusableGraphicsLayerScope reusableGraphicsLayerScope, LayoutDirection layoutDirection, Density density) {
        Function0<Unit> function0;
        int mutatedFields$ui_release = reusableGraphicsLayerScope.getMutatedFields$ui_release() | this.mutatedFields;
        if ((mutatedFields$ui_release & 4096) != 0) {
            long r2 = reusableGraphicsLayerScope.m4167getTransformOriginSzJe1aQ();
            this.mTransformOrigin = r2;
            setPivotX(TransformOrigin.m4264getPivotFractionXimpl(r2) * ((float) getWidth()));
            setPivotY(TransformOrigin.m4265getPivotFractionYimpl(this.mTransformOrigin) * ((float) getHeight()));
        }
        if ((mutatedFields$ui_release & 1) != 0) {
            setScaleX(reusableGraphicsLayerScope.getScaleX());
        }
        if ((mutatedFields$ui_release & 2) != 0) {
            setScaleY(reusableGraphicsLayerScope.getScaleY());
        }
        if ((mutatedFields$ui_release & 4) != 0) {
            setAlpha(reusableGraphicsLayerScope.getAlpha());
        }
        if ((mutatedFields$ui_release & 8) != 0) {
            setTranslationX(reusableGraphicsLayerScope.getTranslationX());
        }
        if ((mutatedFields$ui_release & 16) != 0) {
            setTranslationY(reusableGraphicsLayerScope.getTranslationY());
        }
        if ((mutatedFields$ui_release & 32) != 0) {
            setElevation(reusableGraphicsLayerScope.getShadowElevation());
        }
        if ((mutatedFields$ui_release & 1024) != 0) {
            setRotation(reusableGraphicsLayerScope.getRotationZ());
        }
        if ((mutatedFields$ui_release & 256) != 0) {
            setRotationX(reusableGraphicsLayerScope.getRotationX());
        }
        if ((mutatedFields$ui_release & 512) != 0) {
            setRotationY(reusableGraphicsLayerScope.getRotationY());
        }
        if ((mutatedFields$ui_release & 2048) != 0) {
            setCameraDistancePx(reusableGraphicsLayerScope.getCameraDistance());
        }
        boolean z = false;
        boolean z2 = getManualClipPath() != null;
        boolean z3 = reusableGraphicsLayerScope.getClip() && reusableGraphicsLayerScope.getShape() != RectangleShapeKt.getRectangleShape();
        if ((mutatedFields$ui_release & CpioConstants.C_ISBLK) != 0) {
            this.clipToBounds = reusableGraphicsLayerScope.getClip() && reusableGraphicsLayerScope.getShape() == RectangleShapeKt.getRectangleShape();
            resetClipBounds();
            setClipToOutline(z3);
        }
        boolean update = this.outlineResolver.update(reusableGraphicsLayerScope.getShape(), reusableGraphicsLayerScope.getAlpha(), z3, reusableGraphicsLayerScope.getShadowElevation(), layoutDirection, density);
        if (this.outlineResolver.getCacheIsDirty$ui_release()) {
            updateOutlineResolver();
        }
        boolean z4 = getManualClipPath() != null;
        if (z2 != z4 || (z4 && update)) {
            invalidate();
        }
        if (!this.drawnWithZ && getElevation() > 0.0f && (function0 = this.invalidateParentLayer) != null) {
            function0.invoke();
        }
        if ((mutatedFields$ui_release & Fields.MatrixAffectingFields) != 0) {
            this.matrixCache.invalidate();
        }
        if (Build.VERSION.SDK_INT >= 28) {
            if ((mutatedFields$ui_release & 64) != 0) {
                ViewLayerVerificationHelper28.INSTANCE.setOutlineAmbientShadowColor(this, ColorKt.m3870toArgb8_81llA(reusableGraphicsLayerScope.m4163getAmbientShadowColor0d7_KjU()));
            }
            if ((mutatedFields$ui_release & 128) != 0) {
                ViewLayerVerificationHelper28.INSTANCE.setOutlineSpotShadowColor(this, ColorKt.m3870toArgb8_81llA(reusableGraphicsLayerScope.m4166getSpotShadowColor0d7_KjU()));
            }
        }
        if (Build.VERSION.SDK_INT >= 31 && (131072 & mutatedFields$ui_release) != 0) {
            ViewLayerVerificationHelper31.INSTANCE.setRenderEffect(this, reusableGraphicsLayerScope.getRenderEffect());
        }
        if ((mutatedFields$ui_release & 32768) != 0) {
            int r1 = reusableGraphicsLayerScope.m4164getCompositingStrategyNrFUSI();
            if (CompositingStrategy.m3902equalsimpl0(r1, CompositingStrategy.Companion.m3908getOffscreenNrFUSI())) {
                setLayerType(2, (Paint) null);
            } else if (CompositingStrategy.m3902equalsimpl0(r1, CompositingStrategy.Companion.m3907getModulateAlphaNrFUSI())) {
                setLayerType(0, (Paint) null);
                this.mHasOverlappingRendering = z;
            } else {
                setLayerType(0, (Paint) null);
            }
            z = true;
            this.mHasOverlappingRendering = z;
        }
        this.mutatedFields = reusableGraphicsLayerScope.getMutatedFields$ui_release();
    }

    public boolean hasOverlappingRendering() {
        return this.mHasOverlappingRendering;
    }

    /* renamed from: isInLayer-k-4lQ0M  reason: not valid java name */
    public boolean m5836isInLayerk4lQ0M(long j) {
        float r0 = Offset.m3562getXimpl(j);
        float r1 = Offset.m3563getYimpl(j);
        if (this.clipToBounds) {
            if (0.0f > r0 || r0 >= ((float) getWidth()) || 0.0f > r1 || r1 >= ((float) getHeight())) {
                return false;
            }
            return true;
        } else if (getClipToOutline()) {
            return this.outlineResolver.m5816isInOutlinek4lQ0M(j);
        } else {
            return true;
        }
    }

    private final void updateOutlineResolver() {
        setOutlineProvider(this.outlineResolver.getOutline() != null ? OutlineProvider : null);
    }

    private final void resetClipBounds() {
        Rect rect;
        if (this.clipToBounds) {
            Rect rect2 = this.clipBoundsCache;
            if (rect2 == null) {
                this.clipBoundsCache = new Rect(0, 0, getWidth(), getHeight());
            } else {
                Intrinsics.checkNotNull(rect2);
                rect2.set(0, 0, getWidth(), getHeight());
            }
            rect = this.clipBoundsCache;
        } else {
            rect = null;
        }
        setClipBounds(rect);
    }

    /* renamed from: resize-ozmzZPI  reason: not valid java name */
    public void m5839resizeozmzZPI(long j) {
        int r0 = IntSize.m6790getWidthimpl(j);
        int r5 = IntSize.m6789getHeightimpl(j);
        if (r0 != getWidth() || r5 != getHeight()) {
            float f = (float) r0;
            setPivotX(TransformOrigin.m4264getPivotFractionXimpl(this.mTransformOrigin) * f);
            float f2 = (float) r5;
            setPivotY(TransformOrigin.m4265getPivotFractionYimpl(this.mTransformOrigin) * f2);
            this.outlineResolver.m5817updateuvyYCjk(SizeKt.Size(f, f2));
            updateOutlineResolver();
            layout(getLeft(), getTop(), getLeft() + r0, getTop() + r5);
            resetClipBounds();
            this.matrixCache.invalidate();
        }
    }

    /* renamed from: move--gyyYBs  reason: not valid java name */
    public void m5838movegyyYBs(long j) {
        int r0 = IntOffset.m6748getXimpl(j);
        if (r0 != getLeft()) {
            offsetLeftAndRight(r0 - getLeft());
            this.matrixCache.invalidate();
        }
        int r3 = IntOffset.m6749getYimpl(j);
        if (r3 != getTop()) {
            offsetTopAndBottom(r3 - getTop());
            this.matrixCache.invalidate();
        }
    }

    public void drawLayer(Canvas canvas) {
        boolean z = getElevation() > 0.0f;
        this.drawnWithZ = z;
        if (z) {
            canvas.enableZ();
        }
        this.container.drawChild$ui_release(canvas, this, getDrawingTime());
        if (this.drawnWithZ) {
            canvas.disableZ();
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(android.graphics.Canvas canvas) {
        boolean z;
        CanvasHolder canvasHolder2 = this.canvasHolder;
        android.graphics.Canvas internalCanvas = canvasHolder2.getAndroidCanvas().getInternalCanvas();
        canvasHolder2.getAndroidCanvas().setInternalCanvas(canvas);
        Canvas androidCanvas = canvasHolder2.getAndroidCanvas();
        if (getManualClipPath() != null || !canvas.isHardwareAccelerated()) {
            androidCanvas.save();
            this.outlineResolver.clipToOutline(androidCanvas);
            z = true;
        } else {
            z = false;
        }
        Function1<? super Canvas, Unit> function1 = this.drawBlock;
        if (function1 != null) {
            function1.invoke(androidCanvas);
        }
        if (z) {
            androidCanvas.restore();
        }
        canvasHolder2.getAndroidCanvas().setInternalCanvas(internalCanvas);
        setInvalidated(false);
    }

    public void invalidate() {
        if (!this.isInvalidated) {
            setInvalidated(true);
            super.invalidate();
            this.ownerView.invalidate();
        }
    }

    public void destroy() {
        setInvalidated(false);
        this.ownerView.requestClearInvalidObservations();
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.ownerView.recycle$ui_release(this);
        this.container.removeViewInLayout(this);
    }

    public void updateDisplayList() {
        if (this.isInvalidated && !shouldUseDispatchDraw) {
            Companion.updateDisplayList(this);
            setInvalidated(false);
        }
    }

    /* renamed from: mapOffset-8S9VItk  reason: not valid java name */
    public long m5837mapOffset8S9VItk(long j, boolean z) {
        if (!z) {
            return androidx.compose.ui.graphics.Matrix.m4064mapMKHz9U(this.matrixCache.m5790calculateMatrixGrdbGEg(this), j);
        }
        float[] r3 = this.matrixCache.m5789calculateInverseMatrixbWbORWo(this);
        return r3 != null ? androidx.compose.ui.graphics.Matrix.m4064mapMKHz9U(r3, j) : Offset.Companion.m3576getInfiniteF1C5BW0();
    }

    public void mapBounds(MutableRect mutableRect, boolean z) {
        if (z) {
            float[] r2 = this.matrixCache.m5789calculateInverseMatrixbWbORWo(this);
            if (r2 != null) {
                androidx.compose.ui.graphics.Matrix.m4066mapimpl(r2, mutableRect);
            } else {
                mutableRect.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        } else {
            androidx.compose.ui.graphics.Matrix.m4066mapimpl(this.matrixCache.m5790calculateMatrixGrdbGEg(this), mutableRect);
        }
    }

    public void reuseLayer(Function1<? super Canvas, Unit> function1, Function0<Unit> function0) {
        this.container.addView(this);
        this.clipToBounds = false;
        this.drawnWithZ = false;
        this.mTransformOrigin = TransformOrigin.Companion.m4269getCenterSzJe1aQ();
        this.drawBlock = function1;
        this.invalidateParentLayer = function0;
    }

    /* renamed from: transform-58bKbWc  reason: not valid java name */
    public void m5840transform58bKbWc(float[] fArr) {
        androidx.compose.ui.graphics.Matrix.m4075timesAssign58bKbWc(fArr, this.matrixCache.m5790calculateMatrixGrdbGEg(this));
    }

    /* renamed from: inverseTransform-58bKbWc  reason: not valid java name */
    public void m5835inverseTransform58bKbWc(float[] fArr) {
        float[] r0 = this.matrixCache.m5789calculateInverseMatrixbWbORWo(this);
        if (r0 != null) {
            androidx.compose.ui.graphics.Matrix.m4075timesAssign58bKbWc(fArr, r0);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\tH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/platform/ViewLayer$Companion;", "", "()V", "OutlineProvider", "Landroid/view/ViewOutlineProvider;", "getOutlineProvider", "()Landroid/view/ViewOutlineProvider;", "getMatrix", "Lkotlin/Function2;", "Landroid/view/View;", "Landroid/graphics/Matrix;", "", "<set-?>", "", "hasRetrievedMethod", "getHasRetrievedMethod", "()Z", "recreateDisplayList", "Ljava/lang/reflect/Field;", "shouldUseDispatchDraw", "getShouldUseDispatchDraw", "setShouldUseDispatchDraw$ui_release", "(Z)V", "updateDisplayListIfDirtyMethod", "Ljava/lang/reflect/Method;", "updateDisplayList", "view", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ViewLayer.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewOutlineProvider getOutlineProvider() {
            return ViewLayer.OutlineProvider;
        }

        public final boolean getHasRetrievedMethod() {
            return ViewLayer.hasRetrievedMethod;
        }

        public final boolean getShouldUseDispatchDraw() {
            return ViewLayer.shouldUseDispatchDraw;
        }

        public final void setShouldUseDispatchDraw$ui_release(boolean z) {
            ViewLayer.shouldUseDispatchDraw = z;
        }

        public final void updateDisplayList(View view) {
            try {
                if (!getHasRetrievedMethod()) {
                    ViewLayer.hasRetrievedMethod = true;
                    if (Build.VERSION.SDK_INT < 28) {
                        ViewLayer.updateDisplayListIfDirtyMethod = View.class.getDeclaredMethod("updateDisplayListIfDirty", (Class[]) null);
                        ViewLayer.recreateDisplayList = View.class.getDeclaredField("mRecreateDisplayList");
                    } else {
                        Object[] objArr = {"updateDisplayListIfDirty", new Class[0]};
                        ViewLayer.updateDisplayListIfDirtyMethod = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, new Class[0].getClass()}).invoke(View.class, objArr);
                        Object[] objArr2 = {"mRecreateDisplayList"};
                        ViewLayer.recreateDisplayList = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(View.class, objArr2);
                    }
                    Method access$getUpdateDisplayListIfDirtyMethod$cp = ViewLayer.updateDisplayListIfDirtyMethod;
                    if (access$getUpdateDisplayListIfDirtyMethod$cp != null) {
                        access$getUpdateDisplayListIfDirtyMethod$cp.setAccessible(true);
                    }
                    Field access$getRecreateDisplayList$cp = ViewLayer.recreateDisplayList;
                    if (access$getRecreateDisplayList$cp != null) {
                        access$getRecreateDisplayList$cp.setAccessible(true);
                    }
                }
                Field access$getRecreateDisplayList$cp2 = ViewLayer.recreateDisplayList;
                if (access$getRecreateDisplayList$cp2 != null) {
                    access$getRecreateDisplayList$cp2.setBoolean(view, true);
                }
                Method access$getUpdateDisplayListIfDirtyMethod$cp2 = ViewLayer.updateDisplayListIfDirtyMethod;
                if (access$getUpdateDisplayListIfDirtyMethod$cp2 != null) {
                    access$getUpdateDisplayListIfDirtyMethod$cp2.invoke(view, (Object[]) null);
                }
            } catch (Throwable unused) {
                setShouldUseDispatchDraw$ui_release(true);
            }
        }
    }
}
