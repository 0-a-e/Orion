package androidx.compose.ui.graphics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a¢\u0006\u0002\u0010\u001bJ\u0006\u0010S\u001a\u000203J\b\u0010T\u001a\u00020UH\u0016J&\u0010V\u001a\u00020W*\u00020X2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\\H\u0016ø\u0001\u0000¢\u0006\u0004\b]\u0010^R\u001a\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\u0016\u001a\u00020\u0017X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001d\"\u0004\b&\u0010\u001fR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010\u0019\u001a\u00020\u001aX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001f\u00100\u001a\u0013\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020301¢\u0006\u0002\b4X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001d\"\u0004\b:\u0010\u001fR\u001a\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001d\"\u0004\b<\u0010\u001fR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001d\"\u0004\b>\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001d\"\u0004\b@\u0010\u001fR\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001d\"\u0004\bB\u0010\u001fR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001d\"\u0004\bD\u0010\u001fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0014\u0010I\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010(R\"\u0010\u0018\u001a\u00020\u0017X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\bK\u0010!\"\u0004\bL\u0010#R\"\u0010\u000e\u001a\u00020\u000fX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\bM\u0010!\"\u0004\bN\u0010#R\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u001d\"\u0004\bP\u0010\u001fR\u001a\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u001d\"\u0004\bR\u0010\u001f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006_"}, d2 = {"Landroidx/compose/ui/graphics/SimpleGraphicsLayerModifier;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "scaleX", "", "scaleY", "alpha", "translationX", "translationY", "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "spotShadowColor", "compositingStrategy", "Landroidx/compose/ui/graphics/CompositingStrategy;", "(FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "J", "getCameraDistance", "setCameraDistance", "getClip", "()Z", "setClip", "(Z)V", "getCompositingStrategy--NrFUSI", "()I", "setCompositingStrategy-aDBOjCE", "(I)V", "I", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "getRotationX", "setRotationX", "getRotationY", "setRotationY", "getRotationZ", "setRotationZ", "getScaleX", "setScaleX", "getScaleY", "setScaleY", "getShadowElevation", "setShadowElevation", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "getTransformOrigin-SzJe1aQ", "setTransformOrigin-__ExYCQ", "getTranslationX", "setTranslationX", "getTranslationY", "setTranslationY", "invalidateLayerBlock", "toString", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GraphicsLayerModifier.kt */
final class SimpleGraphicsLayerModifier extends Modifier.Node implements LayoutModifierNode {
    private float alpha;
    private long ambientShadowColor;
    private float cameraDistance;
    private boolean clip;
    private int compositingStrategy;
    /* access modifiers changed from: private */
    public Function1<? super GraphicsLayerScope, Unit> layerBlock;
    private RenderEffect renderEffect;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX;
    private float scaleY;
    private float shadowElevation;
    private Shape shape;
    private long spotShadowColor;
    private long transformOrigin;
    private float translationX;
    private float translationY;

    public /* synthetic */ SimpleGraphicsLayerModifier(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape2, boolean z, RenderEffect renderEffect2, long j2, long j3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, j, shape2, z, renderEffect2, j2, j3, i);
    }

    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final void setScaleX(float f) {
        this.scaleX = f;
    }

    public final float getScaleY() {
        return this.scaleY;
    }

    public final void setScaleY(float f) {
        this.scaleY = f;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    public final float getTranslationX() {
        return this.translationX;
    }

    public final void setTranslationX(float f) {
        this.translationX = f;
    }

    public final float getTranslationY() {
        return this.translationY;
    }

    public final void setTranslationY(float f) {
        this.translationY = f;
    }

    public final float getShadowElevation() {
        return this.shadowElevation;
    }

    public final void setShadowElevation(float f) {
        this.shadowElevation = f;
    }

    public final float getRotationX() {
        return this.rotationX;
    }

    public final void setRotationX(float f) {
        this.rotationX = f;
    }

    public final float getRotationY() {
        return this.rotationY;
    }

    public final void setRotationY(float f) {
        this.rotationY = f;
    }

    public final float getRotationZ() {
        return this.rotationZ;
    }

    public final void setRotationZ(float f) {
        this.rotationZ = f;
    }

    public final float getCameraDistance() {
        return this.cameraDistance;
    }

    public final void setCameraDistance(float f) {
        this.cameraDistance = f;
    }

    /* renamed from: getTransformOrigin-SzJe1aQ  reason: not valid java name */
    public final long m4205getTransformOriginSzJe1aQ() {
        return this.transformOrigin;
    }

    /* renamed from: setTransformOrigin-__ExYCQ  reason: not valid java name */
    public final void m4210setTransformOrigin__ExYCQ(long j) {
        this.transformOrigin = j;
    }

    public final Shape getShape() {
        return this.shape;
    }

    public final void setShape(Shape shape2) {
        this.shape = shape2;
    }

    public final boolean getClip() {
        return this.clip;
    }

    public final void setClip(boolean z) {
        this.clip = z;
    }

    public final RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    public final void setRenderEffect(RenderEffect renderEffect2) {
        this.renderEffect = renderEffect2;
    }

    /* renamed from: getAmbientShadowColor-0d7_KjU  reason: not valid java name */
    public final long m4202getAmbientShadowColor0d7_KjU() {
        return this.ambientShadowColor;
    }

    /* renamed from: setAmbientShadowColor-8_81llA  reason: not valid java name */
    public final void m4207setAmbientShadowColor8_81llA(long j) {
        this.ambientShadowColor = j;
    }

    /* renamed from: getSpotShadowColor-0d7_KjU  reason: not valid java name */
    public final long m4204getSpotShadowColor0d7_KjU() {
        return this.spotShadowColor;
    }

    /* renamed from: setSpotShadowColor-8_81llA  reason: not valid java name */
    public final void m4209setSpotShadowColor8_81llA(long j) {
        this.spotShadowColor = j;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SimpleGraphicsLayerModifier(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape2, boolean z, RenderEffect renderEffect2, long j2, long j3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, j, shape2, z, renderEffect2, j2, j3, (i2 & 65536) != 0 ? CompositingStrategy.Companion.m3906getAutoNrFUSI() : i, (DefaultConstructorMarker) null);
    }

    /* renamed from: getCompositingStrategy--NrFUSI  reason: not valid java name */
    public final int m4203getCompositingStrategyNrFUSI() {
        return this.compositingStrategy;
    }

    /* renamed from: setCompositingStrategy-aDBOjCE  reason: not valid java name */
    public final void m4208setCompositingStrategyaDBOjCE(int i) {
        this.compositingStrategy = i;
    }

    private SimpleGraphicsLayerModifier(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape2, boolean z, RenderEffect renderEffect2, long j2, long j3, int i) {
        this.scaleX = f;
        this.scaleY = f2;
        this.alpha = f3;
        this.translationX = f4;
        this.translationY = f5;
        this.shadowElevation = f6;
        this.rotationX = f7;
        this.rotationY = f8;
        this.rotationZ = f9;
        this.cameraDistance = f10;
        this.transformOrigin = j;
        this.shape = shape2;
        this.clip = z;
        this.renderEffect = renderEffect2;
        this.ambientShadowColor = j2;
        this.spotShadowColor = j3;
        this.compositingStrategy = i;
        this.layerBlock = new SimpleGraphicsLayerModifier$layerBlock$1(this);
    }

    public final void invalidateLayerBlock() {
        NodeCoordinator wrapped$ui_release = DelegatableNodeKt.m5468requireCoordinator64DMado(this, NodeKind.m5647constructorimpl(2)).getWrapped$ui_release();
        if (wrapped$ui_release != null) {
            wrapped$ui_release.updateLayerBlock(this.layerBlock, true);
        }
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m4206measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Placeable r9 = measurable.m5368measureBRTryo0(j);
        return MeasureScope.CC.layout$default(measureScope, r9.getWidth(), r9.getHeight(), (Map) null, new SimpleGraphicsLayerModifier$measure$1(r9, this), 4, (Object) null);
    }

    public String toString() {
        return "SimpleGraphicsLayerModifier(scaleX=" + this.scaleX + ", scaleY=" + this.scaleY + ", alpha = " + this.alpha + ", translationX=" + this.translationX + ", translationY=" + this.translationY + ", shadowElevation=" + this.shadowElevation + ", rotationX=" + this.rotationX + ", rotationY=" + this.rotationY + ", rotationZ=" + this.rotationZ + ", cameraDistance=" + this.cameraDistance + ", transformOrigin=" + TransformOrigin.m4267toStringimpl(this.transformOrigin) + ", shape=" + this.shape + ", clip=" + this.clip + ", renderEffect=" + this.renderEffect + ", ambientShadowColor=" + Color.m3824toStringimpl(this.ambientShadowColor) + ", spotShadowColor=" + Color.m3824toStringimpl(this.spotShadowColor) + ", compositingStrategy=" + CompositingStrategy.m3904toStringimpl(this.compositingStrategy) + ')';
    }
}
