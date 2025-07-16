package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.vector.PathNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J>\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rJ>\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\rJ\u0006\u0010\u001a\u001a\u00020\u0000J6\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\rJ6\u0010 \u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\rJ\u000e\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\rJ\u000e\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\rJ\u0016\u0010)\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\r2\u0006\u0010*\u001a\u00020\rJ\u0016\u0010+\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\r2\u0006\u0010,\u001a\u00020\rJ\u0016\u0010-\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\r2\u0006\u0010*\u001a\u00020\rJ\u0016\u0010.\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\r2\u0006\u0010,\u001a\u00020\rJ&\u0010/\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rJ&\u00100\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\rJ&\u00101\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rJ&\u00102\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\rJ\u0016\u00103\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rJ\u0016\u00104\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\rJ\u000e\u00105\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\rJ\u000e\u00106\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\rR\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u00067"}, d2 = {"Landroidx/compose/ui/graphics/vector/PathBuilder;", "", "()V", "_nodes", "Ljava/util/ArrayList;", "Landroidx/compose/ui/graphics/vector/PathNode;", "Lkotlin/collections/ArrayList;", "nodes", "", "getNodes", "()Ljava/util/List;", "arcTo", "horizontalEllipseRadius", "", "verticalEllipseRadius", "theta", "isMoreThanHalf", "", "isPositiveArc", "x1", "y1", "arcToRelative", "a", "b", "dx1", "dy1", "close", "curveTo", "x2", "y2", "x3", "y3", "curveToRelative", "dx2", "dy2", "dx3", "dy3", "horizontalLineTo", "x", "horizontalLineToRelative", "dx", "lineTo", "y", "lineToRelative", "dy", "moveTo", "moveToRelative", "quadTo", "quadToRelative", "reflectiveCurveTo", "reflectiveCurveToRelative", "reflectiveQuadTo", "reflectiveQuadToRelative", "verticalLineTo", "verticalLineToRelative", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PathBuilder.kt */
public final class PathBuilder {
    private final ArrayList<PathNode> _nodes = new ArrayList<>(32);

    public final List<PathNode> getNodes() {
        return this._nodes;
    }

    public final PathBuilder close() {
        this._nodes.add(PathNode.Close.INSTANCE);
        return this;
    }

    public final PathBuilder moveTo(float f, float f2) {
        this._nodes.add(new PathNode.MoveTo(f, f2));
        return this;
    }

    public final PathBuilder moveToRelative(float f, float f2) {
        this._nodes.add(new PathNode.RelativeMoveTo(f, f2));
        return this;
    }

    public final PathBuilder lineTo(float f, float f2) {
        this._nodes.add(new PathNode.LineTo(f, f2));
        return this;
    }

    public final PathBuilder lineToRelative(float f, float f2) {
        this._nodes.add(new PathNode.RelativeLineTo(f, f2));
        return this;
    }

    public final PathBuilder horizontalLineTo(float f) {
        this._nodes.add(new PathNode.HorizontalTo(f));
        return this;
    }

    public final PathBuilder horizontalLineToRelative(float f) {
        this._nodes.add(new PathNode.RelativeHorizontalTo(f));
        return this;
    }

    public final PathBuilder verticalLineTo(float f) {
        this._nodes.add(new PathNode.VerticalTo(f));
        return this;
    }

    public final PathBuilder verticalLineToRelative(float f) {
        this._nodes.add(new PathNode.RelativeVerticalTo(f));
        return this;
    }

    public final PathBuilder curveTo(float f, float f2, float f3, float f4, float f5, float f6) {
        this._nodes.add(new PathNode.CurveTo(f, f2, f3, f4, f5, f6));
        return this;
    }

    public final PathBuilder curveToRelative(float f, float f2, float f3, float f4, float f5, float f6) {
        this._nodes.add(new PathNode.RelativeCurveTo(f, f2, f3, f4, f5, f6));
        return this;
    }

    public final PathBuilder reflectiveCurveTo(float f, float f2, float f3, float f4) {
        this._nodes.add(new PathNode.ReflectiveCurveTo(f, f2, f3, f4));
        return this;
    }

    public final PathBuilder reflectiveCurveToRelative(float f, float f2, float f3, float f4) {
        this._nodes.add(new PathNode.RelativeReflectiveCurveTo(f, f2, f3, f4));
        return this;
    }

    public final PathBuilder quadTo(float f, float f2, float f3, float f4) {
        this._nodes.add(new PathNode.QuadTo(f, f2, f3, f4));
        return this;
    }

    public final PathBuilder quadToRelative(float f, float f2, float f3, float f4) {
        this._nodes.add(new PathNode.RelativeQuadTo(f, f2, f3, f4));
        return this;
    }

    public final PathBuilder reflectiveQuadTo(float f, float f2) {
        this._nodes.add(new PathNode.ReflectiveQuadTo(f, f2));
        return this;
    }

    public final PathBuilder reflectiveQuadToRelative(float f, float f2) {
        this._nodes.add(new PathNode.RelativeReflectiveQuadTo(f, f2));
        return this;
    }

    public final PathBuilder arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
        this._nodes.add(new PathNode.ArcTo(f, f2, f3, z, z2, f4, f5));
        return this;
    }

    public final PathBuilder arcToRelative(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
        this._nodes.add(new PathNode.RelativeArcTo(f, f2, f3, z, z2, f4, f5));
        return this;
    }
}
