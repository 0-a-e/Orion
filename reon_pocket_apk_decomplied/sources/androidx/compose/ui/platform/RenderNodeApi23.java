package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.graphics.Outline;
import android.os.Build;
import android.view.DisplayListCanvas;
import android.view.RenderNode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010e\u001a\u00020fH\u0016J\b\u0010g\u001a\u00020fH\u0002J\u0010\u0010h\u001a\u00020f2\u0006\u0010i\u001a\u00020jH\u0016J\b\u0010k\u001a\u00020lH\u0016J\u0010\u0010m\u001a\u00020f2\u0006\u0010n\u001a\u00020oH\u0016J\r\u0010p\u001a\u00020\fH\u0000¢\u0006\u0002\bqJ\u0010\u0010r\u001a\u00020f2\u0006\u0010n\u001a\u00020oH\u0016J\r\u0010s\u001a\u00020\u0018H\u0000¢\u0006\u0002\btJ\u0010\u0010u\u001a\u00020f2\u0006\u0010v\u001a\u00020\fH\u0016J\u0010\u0010w\u001a\u00020f2\u0006\u0010v\u001a\u00020\fH\u0016J.\u0010x\u001a\u00020f2\u0006\u0010y\u001a\u00020z2\b\u0010{\u001a\u0004\u0018\u00010|2\u0012\u0010}\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0004\u0012\u00020f0~H\u0016J\u0011\u0010\u0001\u001a\u00020\u00182\u0006\u0010s\u001a\u00020\u0018H\u0016J\u0015\u0010\u0001\u001a\u00020f2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J)\u0010\u0001\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\f2\u0006\u0010V\u001a\u00020\f2\u0006\u0010A\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0016J\u0011\u0010\u0001\u001a\u00020f2\u0006\u0010?\u001a\u00020@H\u0002R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8V@VX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R$\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0018@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00188V@VX\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR*\u0010\"\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020!8V@VX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b#\u0010\u000f\"\u0004\b$\u0010\u0011R$\u0010%\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b&\u0010\t\"\u0004\b'\u0010\u000bR\u0014\u0010(\u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u001bR\u0014\u0010*\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u000fR\u0016\u0010,\u001a\u00020!X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010-R\u001a\u0010.\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u000f\"\u0004\b0\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R$\u00103\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b4\u0010\t\"\u0004\b5\u0010\u000bR$\u00106\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b7\u0010\t\"\u0004\b8\u0010\u000bR\u001c\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u000e\u0010?\u001a\u00020@X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010A\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u000f\"\u0004\bC\u0010\u0011R$\u0010D\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\bE\u0010\t\"\u0004\bF\u0010\u000bR$\u0010G\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\bH\u0010\t\"\u0004\bI\u0010\u000bR$\u0010J\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\bK\u0010\t\"\u0004\bL\u0010\u000bR$\u0010M\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\bN\u0010\t\"\u0004\bO\u0010\u000bR$\u0010P\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\bQ\u0010\t\"\u0004\bR\u0010\u000bR$\u0010S\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8V@VX\u000e¢\u0006\f\u001a\u0004\bT\u0010\u000f\"\u0004\bU\u0010\u0011R\u001a\u0010V\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u000f\"\u0004\bX\u0010\u0011R$\u0010Y\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\bZ\u0010\t\"\u0004\b[\u0010\u000bR$\u0010\\\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b]\u0010\t\"\u0004\b^\u0010\u000bR\u0014\u0010_\u001a\u00020`8VX\u0004¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0014\u0010c\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\bd\u0010\u000f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001"}, d2 = {"Landroidx/compose/ui/platform/RenderNodeApi23;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "", "ambientShadowColor", "getAmbientShadowColor", "()I", "setAmbientShadowColor", "(I)V", "bottom", "getBottom", "setBottom", "cameraDistance", "getCameraDistance", "setCameraDistance", "", "clipToBounds", "getClipToBounds", "()Z", "setClipToBounds", "(Z)V", "clipToOutline", "getClipToOutline", "setClipToOutline", "Landroidx/compose/ui/graphics/CompositingStrategy;", "compositingStrategy", "getCompositingStrategy--NrFUSI", "setCompositingStrategy-aDBOjCE", "elevation", "getElevation", "setElevation", "hasDisplayList", "getHasDisplayList", "height", "getHeight", "internalCompositingStrategy", "I", "left", "getLeft", "setLeft", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "pivotX", "getPivotX", "setPivotX", "pivotY", "getPivotY", "setPivotY", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "renderNode", "Landroid/view/RenderNode;", "right", "getRight", "setRight", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "spotShadowColor", "getSpotShadowColor", "setSpotShadowColor", "top", "getTop", "setTop", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "uniqueId", "", "getUniqueId", "()J", "width", "getWidth", "discardDisplayList", "", "discardDisplayListInternal", "drawInto", "canvas", "Landroid/graphics/Canvas;", "dumpRenderNodeData", "Landroidx/compose/ui/platform/DeviceRenderNodeData;", "getInverseMatrix", "matrix", "Landroid/graphics/Matrix;", "getLayerType", "getLayerType$ui_release", "getMatrix", "hasOverlappingRendering", "hasOverlappingRendering$ui_release", "offsetLeftAndRight", "offset", "offsetTopAndBottom", "record", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipPath", "Landroidx/compose/ui/graphics/Path;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "setHasOverlappingRendering", "setOutline", "outline", "Landroid/graphics/Outline;", "setPosition", "verifyShadowColorProperties", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RenderNodeApi23.android.kt */
public final class RenderNodeApi23 implements DeviceRenderNode {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static boolean needToValidateAccess = true;
    /* access modifiers changed from: private */
    public static boolean testFailCreateRenderNode;
    private int bottom;
    private boolean clipToBounds;
    private int internalCompositingStrategy = CompositingStrategy.Companion.m3906getAutoNrFUSI();
    private int left;
    private final AndroidComposeView ownerView;
    private RenderEffect renderEffect;
    private final RenderNode renderNode;
    private int right;
    private int top;

    public long getUniqueId() {
        return 0;
    }

    public RenderNodeApi23(AndroidComposeView androidComposeView) {
        this.ownerView = androidComposeView;
        RenderNode create = RenderNode.create("Compose", androidComposeView);
        this.renderNode = create;
        if (needToValidateAccess) {
            create.setScaleX(create.getScaleX());
            create.setScaleY(create.getScaleY());
            create.setTranslationX(create.getTranslationX());
            create.setTranslationY(create.getTranslationY());
            create.setElevation(create.getElevation());
            create.setRotation(create.getRotation());
            create.setRotationX(create.getRotationX());
            create.setRotationY(create.getRotationY());
            create.setCameraDistance(create.getCameraDistance());
            create.setPivotX(create.getPivotX());
            create.setPivotY(create.getPivotY());
            create.setClipToOutline(create.getClipToOutline());
            create.setClipToBounds(false);
            create.setAlpha(create.getAlpha());
            create.isValid();
            create.setLeftTopRightBottom(0, 0, 0, 0);
            create.offsetLeftAndRight(0);
            create.offsetTopAndBottom(0);
            verifyShadowColorProperties(create);
            discardDisplayListInternal();
            create.setLayerType(0);
            create.setHasOverlappingRendering(create.hasOverlappingRendering());
            needToValidateAccess = false;
        }
        if (testFailCreateRenderNode) {
            throw new NoClassDefFoundError();
        }
    }

    public final AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    public int getLeft() {
        return this.left;
    }

    public void setLeft(int i) {
        this.left = i;
    }

    public int getTop() {
        return this.top;
    }

    public void setTop(int i) {
        this.top = i;
    }

    public int getRight() {
        return this.right;
    }

    public void setRight(int i) {
        this.right = i;
    }

    public int getBottom() {
        return this.bottom;
    }

    public void setBottom(int i) {
        this.bottom = i;
    }

    public int getWidth() {
        return getRight() - getLeft();
    }

    public int getHeight() {
        return getBottom() - getTop();
    }

    public RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    public void setRenderEffect(RenderEffect renderEffect2) {
        this.renderEffect = renderEffect2;
    }

    public float getScaleX() {
        return this.renderNode.getScaleX();
    }

    public void setScaleX(float f) {
        this.renderNode.setScaleX(f);
    }

    public float getScaleY() {
        return this.renderNode.getScaleY();
    }

    public void setScaleY(float f) {
        this.renderNode.setScaleY(f);
    }

    public float getTranslationX() {
        return this.renderNode.getTranslationX();
    }

    public void setTranslationX(float f) {
        this.renderNode.setTranslationX(f);
    }

    public float getTranslationY() {
        return this.renderNode.getTranslationY();
    }

    public void setTranslationY(float f) {
        this.renderNode.setTranslationY(f);
    }

    public float getElevation() {
        return this.renderNode.getElevation();
    }

    public void setElevation(float f) {
        this.renderNode.setElevation(f);
    }

    public int getAmbientShadowColor() {
        return Build.VERSION.SDK_INT >= 28 ? RenderNodeVerificationHelper28.INSTANCE.getAmbientShadowColor(this.renderNode) : ViewCompat.MEASURED_STATE_MASK;
    }

    public void setAmbientShadowColor(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            RenderNodeVerificationHelper28.INSTANCE.setAmbientShadowColor(this.renderNode, i);
        }
    }

    public int getSpotShadowColor() {
        return Build.VERSION.SDK_INT >= 28 ? RenderNodeVerificationHelper28.INSTANCE.getSpotShadowColor(this.renderNode) : ViewCompat.MEASURED_STATE_MASK;
    }

    public void setSpotShadowColor(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            RenderNodeVerificationHelper28.INSTANCE.setSpotShadowColor(this.renderNode, i);
        }
    }

    public float getRotationZ() {
        return this.renderNode.getRotation();
    }

    public void setRotationZ(float f) {
        this.renderNode.setRotation(f);
    }

    public float getRotationX() {
        return this.renderNode.getRotationX();
    }

    public void setRotationX(float f) {
        this.renderNode.setRotationX(f);
    }

    public float getRotationY() {
        return this.renderNode.getRotationY();
    }

    public void setRotationY(float f) {
        this.renderNode.setRotationY(f);
    }

    public float getCameraDistance() {
        return -this.renderNode.getCameraDistance();
    }

    public void setCameraDistance(float f) {
        this.renderNode.setCameraDistance(-f);
    }

    public float getPivotX() {
        return this.renderNode.getPivotX();
    }

    public void setPivotX(float f) {
        this.renderNode.setPivotX(f);
    }

    public float getPivotY() {
        return this.renderNode.getPivotY();
    }

    public void setPivotY(float f) {
        this.renderNode.setPivotY(f);
    }

    public boolean getClipToOutline() {
        return this.renderNode.getClipToOutline();
    }

    public void setClipToOutline(boolean z) {
        this.renderNode.setClipToOutline(z);
    }

    public boolean getClipToBounds() {
        return this.clipToBounds;
    }

    public void setClipToBounds(boolean z) {
        this.clipToBounds = z;
        this.renderNode.setClipToBounds(z);
    }

    public float getAlpha() {
        return this.renderNode.getAlpha();
    }

    public void setAlpha(float f) {
        this.renderNode.setAlpha(f);
    }

    /* renamed from: getCompositingStrategy--NrFUSI  reason: not valid java name */
    public int m5818getCompositingStrategyNrFUSI() {
        return this.internalCompositingStrategy;
    }

    /* renamed from: setCompositingStrategy-aDBOjCE  reason: not valid java name */
    public void m5819setCompositingStrategyaDBOjCE(int i) {
        if (CompositingStrategy.m3902equalsimpl0(i, CompositingStrategy.Companion.m3908getOffscreenNrFUSI())) {
            this.renderNode.setLayerType(2);
            this.renderNode.setHasOverlappingRendering(true);
        } else if (CompositingStrategy.m3902equalsimpl0(i, CompositingStrategy.Companion.m3907getModulateAlphaNrFUSI())) {
            this.renderNode.setLayerType(0);
            this.renderNode.setHasOverlappingRendering(false);
        } else {
            this.renderNode.setLayerType(0);
            this.renderNode.setHasOverlappingRendering(true);
        }
        this.internalCompositingStrategy = i;
    }

    public final int getLayerType$ui_release() {
        return CompositingStrategy.m3902equalsimpl0(this.internalCompositingStrategy, CompositingStrategy.Companion.m3908getOffscreenNrFUSI()) ? 2 : 0;
    }

    public final boolean hasOverlappingRendering$ui_release() {
        return this.renderNode.hasOverlappingRendering();
    }

    public boolean getHasDisplayList() {
        return this.renderNode.isValid();
    }

    public void setOutline(Outline outline) {
        this.renderNode.setOutline(outline);
    }

    public boolean setPosition(int i, int i2, int i3, int i4) {
        setLeft(i);
        setTop(i2);
        setRight(i3);
        setBottom(i4);
        return this.renderNode.setLeftTopRightBottom(i, i2, i3, i4);
    }

    public void offsetLeftAndRight(int i) {
        setLeft(getLeft() + i);
        setRight(getRight() + i);
        this.renderNode.offsetLeftAndRight(i);
    }

    public void offsetTopAndBottom(int i) {
        setTop(getTop() + i);
        setBottom(getBottom() + i);
        this.renderNode.offsetTopAndBottom(i);
    }

    public void record(CanvasHolder canvasHolder, Path path, Function1<? super Canvas, Unit> function1) {
        android.graphics.Canvas start = this.renderNode.start(getWidth(), getHeight());
        android.graphics.Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
        canvasHolder.getAndroidCanvas().setInternalCanvas(start);
        Canvas androidCanvas = canvasHolder.getAndroidCanvas();
        if (path != null) {
            androidCanvas.save();
            Canvas.CC.m3788clipPathmtrdDE$default(androidCanvas, path, 0, 2, (Object) null);
        }
        function1.invoke(androidCanvas);
        if (path != null) {
            androidCanvas.restore();
        }
        canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
        this.renderNode.end(start);
    }

    public void getMatrix(Matrix matrix) {
        this.renderNode.getMatrix(matrix);
    }

    public void getInverseMatrix(Matrix matrix) {
        this.renderNode.getInverseMatrix(matrix);
    }

    public void drawInto(android.graphics.Canvas canvas) {
        Intrinsics.checkNotNull(canvas, "null cannot be cast to non-null type android.view.DisplayListCanvas");
        ((DisplayListCanvas) canvas).drawRenderNode(this.renderNode);
    }

    public boolean setHasOverlappingRendering(boolean z) {
        return this.renderNode.setHasOverlappingRendering(z);
    }

    public DeviceRenderNodeData dumpRenderNodeData() {
        return new DeviceRenderNodeData(0, 0, 0, 0, 0, 0, 0, this.renderNode.getScaleX(), this.renderNode.getScaleY(), this.renderNode.getTranslationX(), this.renderNode.getTranslationY(), this.renderNode.getElevation(), getAmbientShadowColor(), getSpotShadowColor(), this.renderNode.getRotation(), this.renderNode.getRotationX(), this.renderNode.getRotationY(), this.renderNode.getCameraDistance(), this.renderNode.getPivotX(), this.renderNode.getPivotY(), this.renderNode.getClipToOutline(), getClipToBounds(), this.renderNode.getAlpha(), getRenderEffect(), this.internalCompositingStrategy, (DefaultConstructorMarker) null);
    }

    public void discardDisplayList() {
        discardDisplayListInternal();
    }

    private final void discardDisplayListInternal() {
        if (Build.VERSION.SDK_INT >= 24) {
            RenderNodeVerificationHelper24.INSTANCE.discardDisplayList(this.renderNode);
        } else {
            RenderNodeVerificationHelper23.INSTANCE.destroyDisplayListData(this.renderNode);
        }
    }

    private final void verifyShadowColorProperties(RenderNode renderNode2) {
        if (Build.VERSION.SDK_INT >= 28) {
            RenderNodeVerificationHelper28.INSTANCE.setAmbientShadowColor(renderNode2, RenderNodeVerificationHelper28.INSTANCE.getAmbientShadowColor(renderNode2));
            RenderNodeVerificationHelper28.INSTANCE.setSpotShadowColor(renderNode2, RenderNodeVerificationHelper28.INSTANCE.getSpotShadowColor(renderNode2));
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/compose/ui/platform/RenderNodeApi23$Companion;", "", "()V", "needToValidateAccess", "", "testFailCreateRenderNode", "getTestFailCreateRenderNode$ui_release", "()Z", "setTestFailCreateRenderNode$ui_release", "(Z)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: RenderNodeApi23.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getTestFailCreateRenderNode$ui_release() {
            return RenderNodeApi23.testFailCreateRenderNode;
        }

        public final void setTestFailCreateRenderNode$ui_release(boolean z) {
            RenderNodeApi23.testFailCreateRenderNode = z;
        }
    }
}
