package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a2\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000f"}, d2 = {"shadow", "Landroidx/compose/ui/Modifier;", "elevation", "Landroidx/compose/ui/unit/Dp;", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "", "shadow-ziNgDLE", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;Z)Landroidx/compose/ui/Modifier;", "ambientColor", "Landroidx/compose/ui/graphics/Color;", "spotColor", "shadow-s4CzXII", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;ZJJ)Landroidx/compose/ui/Modifier;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Shadow.kt */
public final class ShadowKt {
    /* renamed from: shadow-ziNgDLE$default  reason: not valid java name */
    public static /* synthetic */ Modifier m3474shadowziNgDLE$default(Modifier modifier, float f, Shape shape, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        if ((i & 4) != 0) {
            z = false;
            if (Dp.m6613compareTo0680j_4(f, Dp.m6614constructorimpl((float) 0)) > 0) {
                z = true;
            }
        }
        return m3471shadows4CzXII(modifier, f, shape, z, GraphicsLayerScopeKt.getDefaultShadowColor(), GraphicsLayerScopeKt.getDefaultShadowColor());
    }

    /* renamed from: shadow-s4CzXII$default  reason: not valid java name */
    public static /* synthetic */ Modifier m3472shadows4CzXII$default(Modifier modifier, float f, Shape shape, boolean z, long j, long j2, int i, Object obj) {
        Shape shape2;
        boolean z2;
        long j3;
        if ((i & 2) != 0) {
            shape2 = RectangleShapeKt.getRectangleShape();
        } else {
            shape2 = shape;
        }
        if ((i & 4) != 0) {
            z2 = false;
            float f2 = f;
            if (Dp.m6613compareTo0680j_4(f, Dp.m6614constructorimpl((float) 0)) > 0) {
                z2 = true;
            }
        } else {
            float f3 = f;
            z2 = z;
        }
        long defaultShadowColor = (i & 8) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : j;
        if ((i & 16) != 0) {
            j3 = GraphicsLayerScopeKt.getDefaultShadowColor();
        } else {
            j3 = j2;
        }
        return m3471shadows4CzXII(modifier, f, shape2, z2, defaultShadowColor, j3);
    }

    /* renamed from: shadow-s4CzXII  reason: not valid java name */
    public static final Modifier m3471shadows4CzXII(Modifier modifier, float f, Shape shape, boolean z, long j, long j2) {
        float f2 = f;
        if (Dp.m6613compareTo0680j_4(f, Dp.m6614constructorimpl((float) 0)) <= 0 && !z) {
            return modifier;
        }
        Modifier modifier2 = modifier;
        return InspectableValueKt.inspectableWrapper(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ShadowKt$shadows4CzXII$$inlined$debugInspectorInfo$1(f, shape, z, j, j2) : InspectableValueKt.getNoInspectorInfo(), GraphicsLayerModifierKt.graphicsLayer(Modifier.Companion, new ShadowKt$shadow$2$1(f, shape, z, j, j2)));
    }
}
