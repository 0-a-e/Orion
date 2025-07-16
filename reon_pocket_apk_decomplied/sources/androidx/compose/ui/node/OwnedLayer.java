package androidx.compose.ui.node;

import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH&J\"\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000eH&ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u001cH&ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H&ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u001eJ*\u0010#\u001a\u00020\u00032\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030'H&J\u001a\u0010(\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&ø\u0001\u0000¢\u0006\u0004\b)\u0010\fJ\b\u0010*\u001a\u00020\u0003H&J \u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H&ø\u0001\u0001\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u00062À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/OwnedLayer;", "", "destroy", "", "drawLayer", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "invalidate", "inverseTransform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "inverseTransform-58bKbWc", "([F)V", "isInLayer", "", "position", "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "inverse", "mapOffset", "point", "mapOffset-8S9VItk", "(JZ)J", "move", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "resize", "size", "Landroidx/compose/ui/unit/IntSize;", "resize-ozmzZPI", "reuseLayer", "drawBlock", "Lkotlin/Function1;", "invalidateParentLayer", "Lkotlin/Function0;", "transform", "transform-58bKbWc", "updateDisplayList", "updateLayerProperties", "scope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: OwnedLayer.kt */
public interface OwnedLayer {
    void destroy();

    void drawLayer(Canvas canvas);

    void invalidate();

    /* renamed from: inverseTransform-58bKbWc  reason: not valid java name */
    void m5697inverseTransform58bKbWc(float[] fArr);

    /* renamed from: isInLayer-k-4lQ0M  reason: not valid java name */
    boolean m5698isInLayerk4lQ0M(long j);

    void mapBounds(MutableRect mutableRect, boolean z);

    /* renamed from: mapOffset-8S9VItk  reason: not valid java name */
    long m5699mapOffset8S9VItk(long j, boolean z);

    /* renamed from: move--gyyYBs  reason: not valid java name */
    void m5700movegyyYBs(long j);

    /* renamed from: resize-ozmzZPI  reason: not valid java name */
    void m5701resizeozmzZPI(long j);

    void reuseLayer(Function1<? super Canvas, Unit> function1, Function0<Unit> function0);

    /* renamed from: transform-58bKbWc  reason: not valid java name */
    void m5702transform58bKbWc(float[] fArr);

    void updateDisplayList();

    void updateLayerProperties(ReusableGraphicsLayerScope reusableGraphicsLayerScope, LayoutDirection layoutDirection, Density density);
}
