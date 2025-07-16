package androidx.compose.ui.node;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0000J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u000bX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/node/LayerPositionalProperties;", "", "()V", "cameraDistance", "", "rotationX", "rotationY", "rotationZ", "scaleX", "scaleY", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "translationX", "translationY", "copyFrom", "", "scope", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "other", "hasSameValuesAs", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NodeCoordinator.kt */
final class LayerPositionalProperties {
    private float cameraDistance = 8.0f;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private long transformOrigin = TransformOrigin.Companion.m4269getCenterSzJe1aQ();
    private float translationX;
    private float translationY;

    public final void copyFrom(LayerPositionalProperties layerPositionalProperties) {
        this.scaleX = layerPositionalProperties.scaleX;
        this.scaleY = layerPositionalProperties.scaleY;
        this.translationX = layerPositionalProperties.translationX;
        this.translationY = layerPositionalProperties.translationY;
        this.rotationX = layerPositionalProperties.rotationX;
        this.rotationY = layerPositionalProperties.rotationY;
        this.rotationZ = layerPositionalProperties.rotationZ;
        this.cameraDistance = layerPositionalProperties.cameraDistance;
        this.transformOrigin = layerPositionalProperties.transformOrigin;
    }

    public final void copyFrom(GraphicsLayerScope graphicsLayerScope) {
        this.scaleX = graphicsLayerScope.getScaleX();
        this.scaleY = graphicsLayerScope.getScaleY();
        this.translationX = graphicsLayerScope.getTranslationX();
        this.translationY = graphicsLayerScope.getTranslationY();
        this.rotationX = graphicsLayerScope.getRotationX();
        this.rotationY = graphicsLayerScope.getRotationY();
        this.rotationZ = graphicsLayerScope.getRotationZ();
        this.cameraDistance = graphicsLayerScope.getCameraDistance();
        this.transformOrigin = graphicsLayerScope.m3987getTransformOriginSzJe1aQ();
    }

    public final boolean hasSameValuesAs(LayerPositionalProperties layerPositionalProperties) {
        return this.scaleX == layerPositionalProperties.scaleX && this.scaleY == layerPositionalProperties.scaleY && this.translationX == layerPositionalProperties.translationX && this.translationY == layerPositionalProperties.translationY && this.rotationX == layerPositionalProperties.rotationX && this.rotationY == layerPositionalProperties.rotationY && this.rotationZ == layerPositionalProperties.rotationZ && this.cameraDistance == layerPositionalProperties.cameraDistance && TransformOrigin.m4263equalsimpl0(this.transformOrigin, layerPositionalProperties.transformOrigin);
    }
}
