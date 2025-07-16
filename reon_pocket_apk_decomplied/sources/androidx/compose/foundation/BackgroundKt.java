package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0007H\u0007\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"background", "Landroidx/compose/ui/Modifier;", "brush", "Landroidx/compose/ui/graphics/Brush;", "shape", "Landroidx/compose/ui/graphics/Shape;", "alpha", "", "color", "Landroidx/compose/ui/graphics/Color;", "background-bw27NRU", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Background.kt */
public final class BackgroundKt {
    /* renamed from: background-bw27NRU$default  reason: not valid java name */
    public static /* synthetic */ Modifier m214backgroundbw27NRU$default(Modifier modifier, long j, Shape shape, int i, Object obj) {
        if ((i & 2) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        return m213backgroundbw27NRU(modifier, j, shape);
    }

    public static /* synthetic */ Modifier background$default(Modifier modifier, Brush brush, Shape shape, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        if ((i & 4) != 0) {
            f = 1.0f;
        }
        return background(modifier, brush, shape, f);
    }

    public static final Modifier background(Modifier modifier, Brush brush, Shape shape, float f) {
        return modifier.then(new BackgroundElement(0, brush, f, shape, InspectableValueKt.isDebugInspectorInfoEnabled() ? new BackgroundKt$background$$inlined$debugInspectorInfo$1(f, brush, shape) : InspectableValueKt.getNoInspectorInfo(), 1, (DefaultConstructorMarker) null));
    }

    /* renamed from: background-bw27NRU  reason: not valid java name */
    public static final Modifier m213backgroundbw27NRU(Modifier modifier, long j, Shape shape) {
        return modifier.then(new BackgroundElement(j, (Brush) null, 1.0f, shape, InspectableValueKt.isDebugInspectorInfoEnabled() ? new BackgroundKt$backgroundbw27NRU$$inlined$debugInspectorInfo$1(j, shape) : InspectableValueKt.getNoInspectorInfo(), 2, (DefaultConstructorMarker) null));
    }
}
