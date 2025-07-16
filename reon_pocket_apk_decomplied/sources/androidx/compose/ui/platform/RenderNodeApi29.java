package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.RenderNode;
import android.os.Build;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010b\u001a\u00020cH\u0016J\u0010\u0010d\u001a\u00020c2\u0006\u0010e\u001a\u00020fH\u0016J\b\u0010g\u001a\u00020hH\u0016J\u0010\u0010i\u001a\u00020c2\u0006\u0010j\u001a\u00020kH\u0016J\u0010\u0010l\u001a\u00020c2\u0006\u0010j\u001a\u00020kH\u0016J\r\u0010m\u001a\u00020\u0017H\u0000¢\u0006\u0002\bnJ\r\u0010o\u001a\u00020\u0017H\u0000¢\u0006\u0002\bpJ\u0010\u0010q\u001a\u00020c2\u0006\u0010r\u001a\u00020\fH\u0016J\u0010\u0010s\u001a\u00020c2\u0006\u0010r\u001a\u00020\fH\u0016J.\u0010t\u001a\u00020c2\u0006\u0010u\u001a\u00020v2\b\u0010w\u001a\u0004\u0018\u00010x2\u0012\u0010y\u001a\u000e\u0012\u0004\u0012\u00020{\u0012\u0004\u0012\u00020c0zH\u0016J\u0010\u0010|\u001a\u00020\u00172\u0006\u0010m\u001a\u00020\u0017H\u0016J\u0012\u0010}\u001a\u00020c2\b\u0010~\u001a\u0004\u0018\u00010H\u0016J)\u0010\u0001\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\f2\u0006\u0010T\u001a\u00020\f2\u0006\u0010@\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0016R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8V@VX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR$\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u0016\u0010\u000bR$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00178V@VX\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00178V@VX\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR*\u0010!\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020 8V@VX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R$\u0010$\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR\u0014\u0010'\u001a\u00020\u00178VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u001aR\u0014\u0010)\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u000fR\u0016\u0010+\u001a\u00020 X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010,R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R$\u00103\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b4\u0010\t\"\u0004\b5\u0010\u000bR$\u00106\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b7\u0010\t\"\u0004\b8\u0010\u000bR(\u00109\u001a\u0004\u0018\u00010.2\b\u0010\u0005\u001a\u0004\u0018\u00010.8V@VX\u000e¢\u0006\f\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u000e\u0010>\u001a\u00020?X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\u000fR$\u0010B\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\bC\u0010\t\"\u0004\bD\u0010\u000bR$\u0010E\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\bF\u0010\t\"\u0004\bG\u0010\u000bR$\u0010H\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\bI\u0010\t\"\u0004\bJ\u0010\u000bR$\u0010K\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\bL\u0010\t\"\u0004\bM\u0010\u000bR$\u0010N\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\bO\u0010\t\"\u0004\bP\u0010\u000bR$\u0010Q\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8V@VX\u000e¢\u0006\f\u001a\u0004\bR\u0010\u000f\"\u0004\bS\u0010\u0011R\u0014\u0010T\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\bU\u0010\u000fR$\u0010V\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\bW\u0010\t\"\u0004\bX\u0010\u000bR$\u0010Y\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\bZ\u0010\t\"\u0004\b[\u0010\u000bR\u0014\u0010\\\u001a\u00020]8VX\u0004¢\u0006\u0006\u001a\u0004\b^\u0010_R\u0014\u0010`\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\ba\u0010\u000f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001"}, d2 = {"Landroidx/compose/ui/platform/RenderNodeApi29;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "", "ambientShadowColor", "getAmbientShadowColor", "()I", "setAmbientShadowColor", "(I)V", "bottom", "getBottom", "cameraDistance", "getCameraDistance", "setCameraDistance", "", "clipToBounds", "getClipToBounds", "()Z", "setClipToBounds", "(Z)V", "clipToOutline", "getClipToOutline", "setClipToOutline", "Landroidx/compose/ui/graphics/CompositingStrategy;", "compositingStrategy", "getCompositingStrategy--NrFUSI", "setCompositingStrategy-aDBOjCE", "elevation", "getElevation", "setElevation", "hasDisplayList", "getHasDisplayList", "height", "getHeight", "internalCompositingStrategy", "I", "internalRenderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "left", "getLeft", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "pivotX", "getPivotX", "setPivotX", "pivotY", "getPivotY", "setPivotY", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "renderNode", "Landroid/graphics/RenderNode;", "right", "getRight", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "spotShadowColor", "getSpotShadowColor", "setSpotShadowColor", "top", "getTop", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "uniqueId", "", "getUniqueId", "()J", "width", "getWidth", "discardDisplayList", "", "drawInto", "canvas", "Landroid/graphics/Canvas;", "dumpRenderNodeData", "Landroidx/compose/ui/platform/DeviceRenderNodeData;", "getInverseMatrix", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "hasOverlappingRendering", "hasOverlappingRendering$ui_release", "isUsingCompositingLayer", "isUsingCompositingLayer$ui_release", "offsetLeftAndRight", "offset", "offsetTopAndBottom", "record", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipPath", "Landroidx/compose/ui/graphics/Path;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "setHasOverlappingRendering", "setOutline", "outline", "Landroid/graphics/Outline;", "setPosition", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RenderNodeApi29.android.kt */
public final class RenderNodeApi29 implements DeviceRenderNode {
    public static final int $stable = 8;
    private int internalCompositingStrategy = CompositingStrategy.Companion.m3906getAutoNrFUSI();
    private RenderEffect internalRenderEffect;
    private final AndroidComposeView ownerView;
    private final RenderNode renderNode = RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m("Compose");

    public RenderNodeApi29(AndroidComposeView androidComposeView) {
        this.ownerView = androidComposeView;
    }

    public final AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    public final boolean isUsingCompositingLayer$ui_release() {
        return RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$1(this.renderNode);
    }

    public final boolean hasOverlappingRendering$ui_release() {
        return RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m(this.renderNode);
    }

    public long getUniqueId() {
        return RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m(this.renderNode);
    }

    public int getLeft() {
        return RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$3(this.renderNode);
    }

    public int getTop() {
        return RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$6(this.renderNode);
    }

    public int getRight() {
        return RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$7(this.renderNode);
    }

    public int getBottom() {
        return RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m(this.renderNode);
    }

    public int getWidth() {
        return RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$1(this.renderNode);
    }

    public int getHeight() {
        return RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$2(this.renderNode);
    }

    public float getScaleX() {
        return RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m(this.renderNode);
    }

    public void setScaleX(float f) {
        boolean unused = this.renderNode.setScaleX(f);
    }

    public float getScaleY() {
        return RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$1(this.renderNode);
    }

    public void setScaleY(float f) {
        boolean unused = this.renderNode.setScaleY(f);
    }

    public float getTranslationX() {
        return RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$2(this.renderNode);
    }

    public void setTranslationX(float f) {
        boolean unused = this.renderNode.setTranslationX(f);
    }

    public float getTranslationY() {
        return RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$5(this.renderNode);
    }

    public void setTranslationY(float f) {
        boolean unused = this.renderNode.setTranslationY(f);
    }

    public float getElevation() {
        return RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$7(this.renderNode);
    }

    public void setElevation(float f) {
        boolean unused = this.renderNode.setElevation(f);
    }

    public int getAmbientShadowColor() {
        return RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$4(this.renderNode);
    }

    public void setAmbientShadowColor(int i) {
        boolean unused = this.renderNode.setAmbientShadowColor(i);
    }

    public int getSpotShadowColor() {
        return RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$5(this.renderNode);
    }

    public void setSpotShadowColor(int i) {
        boolean unused = this.renderNode.setSpotShadowColor(i);
    }

    public float getRotationZ() {
        return this.renderNode.getRotationZ();
    }

    public void setRotationZ(float f) {
        boolean unused = this.renderNode.setRotationZ(f);
    }

    public float getRotationX() {
        return this.renderNode.getRotationX();
    }

    public void setRotationX(float f) {
        boolean unused = this.renderNode.setRotationX(f);
    }

    public float getRotationY() {
        return this.renderNode.getRotationY();
    }

    public void setRotationY(float f) {
        boolean unused = this.renderNode.setRotationY(f);
    }

    public float getCameraDistance() {
        return RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$3(this.renderNode);
    }

    public void setCameraDistance(float f) {
        boolean unused = this.renderNode.setCameraDistance(f);
    }

    public float getPivotX() {
        return RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$4(this.renderNode);
    }

    public void setPivotX(float f) {
        boolean unused = this.renderNode.setPivotX(f);
    }

    public float getPivotY() {
        return RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$6(this.renderNode);
    }

    public void setPivotY(float f) {
        boolean unused = this.renderNode.setPivotY(f);
    }

    public boolean getClipToOutline() {
        return RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$3(this.renderNode);
    }

    public void setClipToOutline(boolean z) {
        boolean unused = this.renderNode.setClipToOutline(z);
    }

    public boolean getClipToBounds() {
        return RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$4(this.renderNode);
    }

    public void setClipToBounds(boolean z) {
        boolean unused = this.renderNode.setClipToBounds(z);
    }

    public float getAlpha() {
        return this.renderNode.getAlpha();
    }

    public void setAlpha(float f) {
        boolean unused = this.renderNode.setAlpha(f);
    }

    public RenderEffect getRenderEffect() {
        return this.internalRenderEffect;
    }

    public void setRenderEffect(RenderEffect renderEffect) {
        this.internalRenderEffect = renderEffect;
        if (Build.VERSION.SDK_INT >= 31) {
            RenderNodeApi29VerificationHelper.INSTANCE.setRenderEffect(this.renderNode, renderEffect);
        }
    }

    /* renamed from: getCompositingStrategy--NrFUSI  reason: not valid java name */
    public int m5820getCompositingStrategyNrFUSI() {
        return this.internalCompositingStrategy;
    }

    /* renamed from: setCompositingStrategy-aDBOjCE  reason: not valid java name */
    public void m5821setCompositingStrategyaDBOjCE(int i) {
        RenderNode renderNode2 = this.renderNode;
        if (CompositingStrategy.m3902equalsimpl0(i, CompositingStrategy.Companion.m3908getOffscreenNrFUSI())) {
            boolean unused = renderNode2.setUseCompositingLayer(true, (Paint) null);
            boolean unused2 = renderNode2.setHasOverlappingRendering(true);
        } else if (CompositingStrategy.m3902equalsimpl0(i, CompositingStrategy.Companion.m3907getModulateAlphaNrFUSI())) {
            boolean unused3 = renderNode2.setUseCompositingLayer(false, (Paint) null);
            boolean unused4 = renderNode2.setHasOverlappingRendering(false);
        } else {
            boolean unused5 = renderNode2.setUseCompositingLayer(false, (Paint) null);
            boolean unused6 = renderNode2.setHasOverlappingRendering(true);
        }
        this.internalCompositingStrategy = i;
    }

    public boolean getHasDisplayList() {
        return RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$2(this.renderNode);
    }

    public void setOutline(Outline outline) {
        boolean unused = this.renderNode.setOutline(outline);
    }

    public boolean setPosition(int i, int i2, int i3, int i4) {
        return this.renderNode.setPosition(i, i2, i3, i4);
    }

    public void offsetLeftAndRight(int i) {
        boolean unused = this.renderNode.offsetLeftAndRight(i);
    }

    public void offsetTopAndBottom(int i) {
        boolean unused = this.renderNode.offsetTopAndBottom(i);
    }

    public void record(CanvasHolder canvasHolder, Path path, Function1<? super Canvas, Unit> function1) {
        android.graphics.Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
        canvasHolder.getAndroidCanvas().setInternalCanvas(RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m(this.renderNode));
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
        RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m(this.renderNode);
    }

    public void getMatrix(Matrix matrix) {
        this.renderNode.getMatrix(matrix);
    }

    public void getInverseMatrix(Matrix matrix) {
        this.renderNode.getInverseMatrix(matrix);
    }

    public void drawInto(android.graphics.Canvas canvas) {
        canvas.drawRenderNode(this.renderNode);
    }

    public boolean setHasOverlappingRendering(boolean z) {
        return this.renderNode.setHasOverlappingRendering(z);
    }

    public DeviceRenderNodeData dumpRenderNodeData() {
        return new DeviceRenderNodeData(RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m(this.renderNode), RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$3(this.renderNode), RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$6(this.renderNode), RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$7(this.renderNode), RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m(this.renderNode), RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$1(this.renderNode), RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$2(this.renderNode), RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m(this.renderNode), RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$1(this.renderNode), RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$2(this.renderNode), RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$5(this.renderNode), RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$7(this.renderNode), RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$4(this.renderNode), RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$5(this.renderNode), this.renderNode.getRotationZ(), this.renderNode.getRotationX(), this.renderNode.getRotationY(), RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$3(this.renderNode), RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$4(this.renderNode), RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$6(this.renderNode), RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$3(this.renderNode), RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$4(this.renderNode), this.renderNode.getAlpha(), this.internalRenderEffect, this.internalCompositingStrategy, (DefaultConstructorMarker) null);
    }

    public void discardDisplayList() {
        RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m$1(this.renderNode);
    }
}
