package androidx.compose.foundation.shape;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0003J0\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H&J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018JB\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0014H&ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/shape/CornerBasedShape;", "Landroidx/compose/ui/graphics/Shape;", "topStart", "Landroidx/compose/foundation/shape/CornerSize;", "topEnd", "bottomEnd", "bottomStart", "(Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;)V", "getBottomEnd", "()Landroidx/compose/foundation/shape/CornerSize;", "getBottomStart", "getTopEnd", "getTopStart", "copy", "all", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "", "createOutline-LjSzlW0", "(JFFFFLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CornerBasedShape.kt */
public abstract class CornerBasedShape implements Shape {
    public static final int $stable = 0;
    private final CornerSize bottomEnd;
    private final CornerSize bottomStart;
    private final CornerSize topEnd;
    private final CornerSize topStart;

    public abstract CornerBasedShape copy(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4);

    /* renamed from: createOutline-LjSzlW0  reason: not valid java name */
    public abstract Outline m1021createOutlineLjSzlW0(long j, float f, float f2, float f3, float f4, LayoutDirection layoutDirection);

    public CornerBasedShape(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
        this.topStart = cornerSize;
        this.topEnd = cornerSize2;
        this.bottomEnd = cornerSize3;
        this.bottomStart = cornerSize4;
    }

    public final CornerSize getTopStart() {
        return this.topStart;
    }

    public final CornerSize getTopEnd() {
        return this.topEnd;
    }

    public final CornerSize getBottomEnd() {
        return this.bottomEnd;
    }

    public final CornerSize getBottomStart() {
        return this.bottomStart;
    }

    /* renamed from: createOutline-Pq9zytI  reason: not valid java name */
    public final Outline m1022createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
        float r3 = this.topStart.m1023toPxTmRCtEA(j, density);
        float r4 = this.topEnd.m1023toPxTmRCtEA(j, density);
        float r5 = this.bottomEnd.m1023toPxTmRCtEA(j, density);
        float r0 = this.bottomStart.m1023toPxTmRCtEA(j, density);
        float r6 = Size.m3630getMinDimensionimpl(j);
        float f = r3 + r0;
        if (f > r6) {
            float f2 = r6 / f;
            r3 *= f2;
            r0 *= f2;
        }
        float f3 = r0;
        float f4 = r4 + r5;
        if (f4 > r6) {
            float f5 = r6 / f4;
            r4 *= f5;
            r5 *= f5;
        }
        if (r3 >= 0.0f && r4 >= 0.0f && r5 >= 0.0f && f3 >= 0.0f) {
            return m1021createOutlineLjSzlW0(j, r3, r4, r5, f3, layoutDirection);
        }
        throw new IllegalArgumentException(("Corner size in Px can't be negative(topStart = " + r3 + ", topEnd = " + r4 + ", bottomEnd = " + r5 + ", bottomStart = " + f3 + ")!").toString());
    }

    public static /* synthetic */ CornerBasedShape copy$default(CornerBasedShape cornerBasedShape, CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                cornerSize = cornerBasedShape.topStart;
            }
            if ((i & 2) != 0) {
                cornerSize2 = cornerBasedShape.topEnd;
            }
            if ((i & 4) != 0) {
                cornerSize3 = cornerBasedShape.bottomEnd;
            }
            if ((i & 8) != 0) {
                cornerSize4 = cornerBasedShape.bottomStart;
            }
            return cornerBasedShape.copy(cornerSize, cornerSize2, cornerSize3, cornerSize4);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
    }

    public final CornerBasedShape copy(CornerSize cornerSize) {
        return copy(cornerSize, cornerSize, cornerSize, cornerSize);
    }
}
