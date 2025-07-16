package androidx.compose.foundation.shape;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J(\u0010\b\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016JB\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/shape/CutCornerShape;", "Landroidx/compose/foundation/shape/CornerBasedShape;", "topStart", "Landroidx/compose/foundation/shape/CornerSize;", "topEnd", "bottomEnd", "bottomStart", "(Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;)V", "copy", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "createOutline-LjSzlW0", "(JFFFFLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CutCornerShape.kt */
public final class CutCornerShape extends CornerBasedShape {
    public static final int $stable = 0;

    public CutCornerShape(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
        super(cornerSize, cornerSize2, cornerSize3, cornerSize4);
    }

    /* renamed from: createOutline-LjSzlW0  reason: not valid java name */
    public Outline m1026createOutlineLjSzlW0(long j, float f, float f2, float f3, float f4, LayoutDirection layoutDirection) {
        if (f + f2 + f4 + f3 == 0.0f) {
            return new Outline.Rectangle(SizeKt.m3652toRectuvyYCjk(j));
        }
        Path Path = AndroidPath_androidKt.Path();
        float f5 = layoutDirection == LayoutDirection.Ltr ? f : f2;
        Path.moveTo(0.0f, f5);
        Path.lineTo(f5, 0.0f);
        if (layoutDirection == LayoutDirection.Ltr) {
            f = f2;
        }
        Path.lineTo(Size.m3631getWidthimpl(j) - f, 0.0f);
        Path.lineTo(Size.m3631getWidthimpl(j), f);
        float f6 = layoutDirection == LayoutDirection.Ltr ? f3 : f4;
        Path.lineTo(Size.m3631getWidthimpl(j), Size.m3628getHeightimpl(j) - f6);
        Path.lineTo(Size.m3631getWidthimpl(j) - f6, Size.m3628getHeightimpl(j));
        if (layoutDirection == LayoutDirection.Ltr) {
            f3 = f4;
        }
        Path.lineTo(f3, Size.m3628getHeightimpl(j));
        Path.lineTo(0.0f, Size.m3628getHeightimpl(j) - f3);
        Path.close();
        return new Outline.Generic(Path);
    }

    public CutCornerShape copy(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
        return new CutCornerShape(cornerSize, cornerSize2, cornerSize3, cornerSize4);
    }

    public String toString() {
        return "CutCornerShape(topStart = " + getTopStart() + ", topEnd = " + getTopEnd() + ", bottomEnd = " + getBottomEnd() + ", bottomStart = " + getBottomStart() + ')';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CutCornerShape)) {
            return false;
        }
        CutCornerShape cutCornerShape = (CutCornerShape) obj;
        return Intrinsics.areEqual((Object) getTopStart(), (Object) cutCornerShape.getTopStart()) && Intrinsics.areEqual((Object) getTopEnd(), (Object) cutCornerShape.getTopEnd()) && Intrinsics.areEqual((Object) getBottomEnd(), (Object) cutCornerShape.getBottomEnd()) && Intrinsics.areEqual((Object) getBottomStart(), (Object) cutCornerShape.getBottomStart());
    }

    public int hashCode() {
        return (((((getTopStart().hashCode() * 31) + getTopEnd().hashCode()) * 31) + getBottomEnd().hashCode()) * 31) + getBottomStart().hashCode();
    }
}
