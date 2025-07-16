package androidx.compose.ui.graphics;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u001a¢\u0006\u0002\u0010\u001bJ\t\u00105\u001a\u00020\u0004HÆ\u0003J\t\u00106\u001a\u00020\u0004HÆ\u0003J\u0016\u00107\u001a\u00020\u000fHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u0010\u001fJ\t\u00109\u001a\u00020\u0011HÆ\u0003J\t\u0010:\u001a\u00020\u0013HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u0016\u0010<\u001a\u00020\u0017HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010\u001fJ\u0016\u0010>\u001a\u00020\u0017HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010\u001fJ\u0016\u0010@\u001a\u00020\u001aHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bA\u0010%J\t\u0010B\u001a\u00020\u0004HÆ\u0003J\t\u0010C\u001a\u00020\u0004HÆ\u0003J\t\u0010D\u001a\u00020\u0004HÆ\u0003J\t\u0010E\u001a\u00020\u0004HÆ\u0003J\t\u0010F\u001a\u00020\u0004HÆ\u0003J\t\u0010G\u001a\u00020\u0004HÆ\u0003J\t\u0010H\u001a\u00020\u0004HÆ\u0003J\t\u0010I\u001a\u00020\u0004HÆ\u0003J¿\u0001\u0010J\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u001aHÆ\u0001ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\b\u0010M\u001a\u00020\u0002H\u0016J\u0013\u0010N\u001a\u00020\u00132\b\u0010O\u001a\u0004\u0018\u00010PHÖ\u0003J\t\u0010Q\u001a\u00020RHÖ\u0001J\t\u0010S\u001a\u00020THÖ\u0001J\u0010\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u0002H\u0016J\f\u0010X\u001a\u00020V*\u00020YH\u0016R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0016\u001a\u00020\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0019\u0010\u0019\u001a\u00020\u001aø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001dR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001dR\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0019\u0010\u0018\u001a\u00020\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b1\u0010\u001fR\u0019\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b2\u0010\u001fR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001dR\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001d\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Z"}, d2 = {"Landroidx/compose/ui/graphics/GraphicsLayerElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/graphics/SimpleGraphicsLayerModifier;", "scaleX", "", "scaleY", "alpha", "translationX", "translationY", "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "spotShadowColor", "compositingStrategy", "Landroidx/compose/ui/graphics/CompositingStrategy;", "(FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlpha", "()F", "getAmbientShadowColor-0d7_KjU", "()J", "J", "getCameraDistance", "getClip", "()Z", "getCompositingStrategy--NrFUSI", "()I", "I", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "getRotationX", "getRotationY", "getRotationZ", "getScaleX", "getScaleY", "getShadowElevation", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "getSpotShadowColor-0d7_KjU", "getTransformOrigin-SzJe1aQ", "getTranslationX", "getTranslationY", "component1", "component10", "component11", "component11-SzJe1aQ", "component12", "component13", "component14", "component15", "component15-0d7_KjU", "component16", "component16-0d7_KjU", "component17", "component17--NrFUSI", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "copy-JVvOYNQ", "(FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJI)Landroidx/compose/ui/graphics/GraphicsLayerElement;", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GraphicsLayerModifier.kt */
final class GraphicsLayerElement extends ModifierNodeElement<SimpleGraphicsLayerModifier> {
    private final float alpha;
    private final long ambientShadowColor;
    private final float cameraDistance;
    private final boolean clip;
    private final int compositingStrategy;
    private final RenderEffect renderEffect;
    private final float rotationX;
    private final float rotationY;
    private final float rotationZ;
    private final float scaleX;
    private final float scaleY;
    private final float shadowElevation;
    private final Shape shape;
    private final long spotShadowColor;
    private final long transformOrigin;
    private final float translationX;
    private final float translationY;

    public /* synthetic */ GraphicsLayerElement(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape2, boolean z, RenderEffect renderEffect2, long j2, long j3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, j, shape2, z, renderEffect2, j2, j3, i);
    }

    /* renamed from: copy-JVvOYNQ$default  reason: not valid java name */
    public static /* synthetic */ GraphicsLayerElement m3965copyJVvOYNQ$default(GraphicsLayerElement graphicsLayerElement, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape2, boolean z, RenderEffect renderEffect2, long j2, long j3, int i, int i2, Object obj) {
        GraphicsLayerElement graphicsLayerElement2 = graphicsLayerElement;
        int i3 = i2;
        return graphicsLayerElement.m3970copyJVvOYNQ((i3 & 1) != 0 ? graphicsLayerElement2.scaleX : f, (i3 & 2) != 0 ? graphicsLayerElement2.scaleY : f2, (i3 & 4) != 0 ? graphicsLayerElement2.alpha : f3, (i3 & 8) != 0 ? graphicsLayerElement2.translationX : f4, (i3 & 16) != 0 ? graphicsLayerElement2.translationY : f5, (i3 & 32) != 0 ? graphicsLayerElement2.shadowElevation : f6, (i3 & 64) != 0 ? graphicsLayerElement2.rotationX : f7, (i3 & 128) != 0 ? graphicsLayerElement2.rotationY : f8, (i3 & 256) != 0 ? graphicsLayerElement2.rotationZ : f9, (i3 & 512) != 0 ? graphicsLayerElement2.cameraDistance : f10, (i3 & 1024) != 0 ? graphicsLayerElement2.transformOrigin : j, (i3 & 2048) != 0 ? graphicsLayerElement2.shape : shape2, (i3 & 4096) != 0 ? graphicsLayerElement2.clip : z, (i3 & 8192) != 0 ? graphicsLayerElement2.renderEffect : renderEffect2, (i3 & 16384) != 0 ? graphicsLayerElement2.ambientShadowColor : j2, (i3 & 32768) != 0 ? graphicsLayerElement2.spotShadowColor : j3, (i3 & 65536) != 0 ? graphicsLayerElement2.compositingStrategy : i);
    }

    public final float component1() {
        return this.scaleX;
    }

    public final float component10() {
        return this.cameraDistance;
    }

    /* renamed from: component11-SzJe1aQ  reason: not valid java name */
    public final long m3966component11SzJe1aQ() {
        return this.transformOrigin;
    }

    public final Shape component12() {
        return this.shape;
    }

    public final boolean component13() {
        return this.clip;
    }

    public final RenderEffect component14() {
        return this.renderEffect;
    }

    /* renamed from: component15-0d7_KjU  reason: not valid java name */
    public final long m3967component150d7_KjU() {
        return this.ambientShadowColor;
    }

    /* renamed from: component16-0d7_KjU  reason: not valid java name */
    public final long m3968component160d7_KjU() {
        return this.spotShadowColor;
    }

    /* renamed from: component17--NrFUSI  reason: not valid java name */
    public final int m3969component17NrFUSI() {
        return this.compositingStrategy;
    }

    public final float component2() {
        return this.scaleY;
    }

    public final float component3() {
        return this.alpha;
    }

    public final float component4() {
        return this.translationX;
    }

    public final float component5() {
        return this.translationY;
    }

    public final float component6() {
        return this.shadowElevation;
    }

    public final float component7() {
        return this.rotationX;
    }

    public final float component8() {
        return this.rotationY;
    }

    public final float component9() {
        return this.rotationZ;
    }

    /* renamed from: copy-JVvOYNQ  reason: not valid java name */
    public final GraphicsLayerElement m3970copyJVvOYNQ(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape2, boolean z, RenderEffect renderEffect2, long j2, long j3, int i) {
        return new GraphicsLayerElement(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, j, shape2, z, renderEffect2, j2, j3, i, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GraphicsLayerElement)) {
            return false;
        }
        GraphicsLayerElement graphicsLayerElement = (GraphicsLayerElement) obj;
        return Float.compare(this.scaleX, graphicsLayerElement.scaleX) == 0 && Float.compare(this.scaleY, graphicsLayerElement.scaleY) == 0 && Float.compare(this.alpha, graphicsLayerElement.alpha) == 0 && Float.compare(this.translationX, graphicsLayerElement.translationX) == 0 && Float.compare(this.translationY, graphicsLayerElement.translationY) == 0 && Float.compare(this.shadowElevation, graphicsLayerElement.shadowElevation) == 0 && Float.compare(this.rotationX, graphicsLayerElement.rotationX) == 0 && Float.compare(this.rotationY, graphicsLayerElement.rotationY) == 0 && Float.compare(this.rotationZ, graphicsLayerElement.rotationZ) == 0 && Float.compare(this.cameraDistance, graphicsLayerElement.cameraDistance) == 0 && TransformOrigin.m4263equalsimpl0(this.transformOrigin, graphicsLayerElement.transformOrigin) && Intrinsics.areEqual((Object) this.shape, (Object) graphicsLayerElement.shape) && this.clip == graphicsLayerElement.clip && Intrinsics.areEqual((Object) this.renderEffect, (Object) graphicsLayerElement.renderEffect) && Color.m3817equalsimpl0(this.ambientShadowColor, graphicsLayerElement.ambientShadowColor) && Color.m3817equalsimpl0(this.spotShadowColor, graphicsLayerElement.spotShadowColor) && CompositingStrategy.m3902equalsimpl0(this.compositingStrategy, graphicsLayerElement.compositingStrategy);
    }

    public int hashCode() {
        int floatToIntBits = ((((((((((((((((((((((((Float.floatToIntBits(this.scaleX) * 31) + Float.floatToIntBits(this.scaleY)) * 31) + Float.floatToIntBits(this.alpha)) * 31) + Float.floatToIntBits(this.translationX)) * 31) + Float.floatToIntBits(this.translationY)) * 31) + Float.floatToIntBits(this.shadowElevation)) * 31) + Float.floatToIntBits(this.rotationX)) * 31) + Float.floatToIntBits(this.rotationY)) * 31) + Float.floatToIntBits(this.rotationZ)) * 31) + Float.floatToIntBits(this.cameraDistance)) * 31) + TransformOrigin.m4266hashCodeimpl(this.transformOrigin)) * 31) + this.shape.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.clip)) * 31;
        RenderEffect renderEffect2 = this.renderEffect;
        return ((((((floatToIntBits + (renderEffect2 == null ? 0 : renderEffect2.hashCode())) * 31) + Color.m3823hashCodeimpl(this.ambientShadowColor)) * 31) + Color.m3823hashCodeimpl(this.spotShadowColor)) * 31) + CompositingStrategy.m3903hashCodeimpl(this.compositingStrategy);
    }

    public String toString() {
        return "GraphicsLayerElement(scaleX=" + this.scaleX + ", scaleY=" + this.scaleY + ", alpha=" + this.alpha + ", translationX=" + this.translationX + ", translationY=" + this.translationY + ", shadowElevation=" + this.shadowElevation + ", rotationX=" + this.rotationX + ", rotationY=" + this.rotationY + ", rotationZ=" + this.rotationZ + ", cameraDistance=" + this.cameraDistance + ", transformOrigin=" + TransformOrigin.m4267toStringimpl(this.transformOrigin) + ", shape=" + this.shape + ", clip=" + this.clip + ", renderEffect=" + this.renderEffect + ", ambientShadowColor=" + Color.m3824toStringimpl(this.ambientShadowColor) + ", spotShadowColor=" + Color.m3824toStringimpl(this.spotShadowColor) + ", compositingStrategy=" + CompositingStrategy.m3904toStringimpl(this.compositingStrategy) + ')';
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final float getScaleY() {
        return this.scaleY;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final float getTranslationX() {
        return this.translationX;
    }

    public final float getTranslationY() {
        return this.translationY;
    }

    public final float getShadowElevation() {
        return this.shadowElevation;
    }

    public final float getRotationX() {
        return this.rotationX;
    }

    public final float getRotationY() {
        return this.rotationY;
    }

    public final float getRotationZ() {
        return this.rotationZ;
    }

    public final float getCameraDistance() {
        return this.cameraDistance;
    }

    /* renamed from: getTransformOrigin-SzJe1aQ  reason: not valid java name */
    public final long m3974getTransformOriginSzJe1aQ() {
        return this.transformOrigin;
    }

    public final Shape getShape() {
        return this.shape;
    }

    public final boolean getClip() {
        return this.clip;
    }

    public final RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    /* renamed from: getAmbientShadowColor-0d7_KjU  reason: not valid java name */
    public final long m3971getAmbientShadowColor0d7_KjU() {
        return this.ambientShadowColor;
    }

    /* renamed from: getSpotShadowColor-0d7_KjU  reason: not valid java name */
    public final long m3973getSpotShadowColor0d7_KjU() {
        return this.spotShadowColor;
    }

    /* renamed from: getCompositingStrategy--NrFUSI  reason: not valid java name */
    public final int m3972getCompositingStrategyNrFUSI() {
        return this.compositingStrategy;
    }

    private GraphicsLayerElement(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape2, boolean z, RenderEffect renderEffect2, long j2, long j3, int i) {
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
    }

    public SimpleGraphicsLayerModifier create() {
        return new SimpleGraphicsLayerModifier(this.scaleX, this.scaleY, this.alpha, this.translationX, this.translationY, this.shadowElevation, this.rotationX, this.rotationY, this.rotationZ, this.cameraDistance, this.transformOrigin, this.shape, this.clip, this.renderEffect, this.ambientShadowColor, this.spotShadowColor, this.compositingStrategy, (DefaultConstructorMarker) null);
    }

    public void update(SimpleGraphicsLayerModifier simpleGraphicsLayerModifier) {
        simpleGraphicsLayerModifier.setScaleX(this.scaleX);
        simpleGraphicsLayerModifier.setScaleY(this.scaleY);
        simpleGraphicsLayerModifier.setAlpha(this.alpha);
        simpleGraphicsLayerModifier.setTranslationX(this.translationX);
        simpleGraphicsLayerModifier.setTranslationY(this.translationY);
        simpleGraphicsLayerModifier.setShadowElevation(this.shadowElevation);
        simpleGraphicsLayerModifier.setRotationX(this.rotationX);
        simpleGraphicsLayerModifier.setRotationY(this.rotationY);
        simpleGraphicsLayerModifier.setRotationZ(this.rotationZ);
        simpleGraphicsLayerModifier.setCameraDistance(this.cameraDistance);
        simpleGraphicsLayerModifier.m4210setTransformOrigin__ExYCQ(this.transformOrigin);
        simpleGraphicsLayerModifier.setShape(this.shape);
        simpleGraphicsLayerModifier.setClip(this.clip);
        simpleGraphicsLayerModifier.setRenderEffect(this.renderEffect);
        simpleGraphicsLayerModifier.m4207setAmbientShadowColor8_81llA(this.ambientShadowColor);
        simpleGraphicsLayerModifier.m4209setSpotShadowColor8_81llA(this.spotShadowColor);
        simpleGraphicsLayerModifier.m4208setCompositingStrategyaDBOjCE(this.compositingStrategy);
        simpleGraphicsLayerModifier.invalidateLayerBlock();
    }

    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("graphicsLayer");
        inspectorInfo.getProperties().set("scaleX", Float.valueOf(this.scaleX));
        inspectorInfo.getProperties().set("scaleY", Float.valueOf(this.scaleY));
        inspectorInfo.getProperties().set("alpha", Float.valueOf(this.alpha));
        inspectorInfo.getProperties().set("translationX", Float.valueOf(this.translationX));
        inspectorInfo.getProperties().set("translationY", Float.valueOf(this.translationY));
        inspectorInfo.getProperties().set("shadowElevation", Float.valueOf(this.shadowElevation));
        inspectorInfo.getProperties().set("rotationX", Float.valueOf(this.rotationX));
        inspectorInfo.getProperties().set("rotationY", Float.valueOf(this.rotationY));
        inspectorInfo.getProperties().set("rotationZ", Float.valueOf(this.rotationZ));
        inspectorInfo.getProperties().set("cameraDistance", Float.valueOf(this.cameraDistance));
        inspectorInfo.getProperties().set("transformOrigin", TransformOrigin.m4256boximpl(this.transformOrigin));
        inspectorInfo.getProperties().set("shape", this.shape);
        inspectorInfo.getProperties().set("clip", Boolean.valueOf(this.clip));
        inspectorInfo.getProperties().set("renderEffect", this.renderEffect);
        inspectorInfo.getProperties().set("ambientShadowColor", Color.m3806boximpl(this.ambientShadowColor));
        inspectorInfo.getProperties().set("spotShadowColor", Color.m3806boximpl(this.spotShadowColor));
        inspectorInfo.getProperties().set("compositingStrategy", CompositingStrategy.m3899boximpl(this.compositingStrategy));
    }
}
