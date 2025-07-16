package androidx.compose.foundation.shape;

import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J(\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016JB\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0019\u0010\u001e\u001a\u00020\u001f*\u00020\u0011H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\""}, d2 = {"Landroidx/compose/foundation/shape/AbsoluteRoundedCornerShape;", "Landroidx/compose/foundation/shape/CornerBasedShape;", "topLeft", "Landroidx/compose/foundation/shape/CornerSize;", "topRight", "bottomRight", "bottomLeft", "(Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;)V", "copy", "topStart", "topEnd", "bottomEnd", "bottomStart", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "createOutline-LjSzlW0", "(JFFFFLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "equals", "", "other", "", "hashCode", "", "toString", "", "toRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "toRadius-Bz7bX_o", "(F)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AbsoluteRoundedCornerShape.kt */
public final class AbsoluteRoundedCornerShape extends CornerBasedShape {
    public static final int $stable = 0;

    public AbsoluteRoundedCornerShape(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
        super(cornerSize, cornerSize2, cornerSize3, cornerSize4);
    }

    /* renamed from: createOutline-LjSzlW0  reason: not valid java name */
    public Outline m1017createOutlineLjSzlW0(long j, float f, float f2, float f3, float f4, LayoutDirection layoutDirection) {
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        if (f5 + f6 + f7 + f8 == 0.0f) {
            return new Outline.Rectangle(SizeKt.m3652toRectuvyYCjk(j));
        }
        Rect r6 = SizeKt.m3652toRectuvyYCjk(j);
        long CornerRadius$default = CornerRadiusKt.CornerRadius$default(f5, 0.0f, 2, (Object) null);
        return new Outline.Rounded(RoundRectKt.m3614RoundRectZAM2FJo(r6, CornerRadius$default, CornerRadiusKt.CornerRadius$default(f6, 0.0f, 2, (Object) null), CornerRadiusKt.CornerRadius$default(f7, 0.0f, 2, (Object) null), CornerRadiusKt.CornerRadius$default(f8, 0.0f, 2, (Object) null)));
    }

    public AbsoluteRoundedCornerShape copy(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
        return new AbsoluteRoundedCornerShape(cornerSize, cornerSize2, cornerSize3, cornerSize4);
    }

    public String toString() {
        return "AbsoluteRoundedCornerShape(topLeft = " + getTopStart() + ", topRight = " + getTopEnd() + ", bottomRight = " + getBottomEnd() + ", bottomLeft = " + getBottomStart() + ')';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbsoluteRoundedCornerShape)) {
            return false;
        }
        AbsoluteRoundedCornerShape absoluteRoundedCornerShape = (AbsoluteRoundedCornerShape) obj;
        return Intrinsics.areEqual((Object) getTopStart(), (Object) absoluteRoundedCornerShape.getTopStart()) && Intrinsics.areEqual((Object) getTopEnd(), (Object) absoluteRoundedCornerShape.getTopEnd()) && Intrinsics.areEqual((Object) getBottomEnd(), (Object) absoluteRoundedCornerShape.getBottomEnd()) && Intrinsics.areEqual((Object) getBottomStart(), (Object) absoluteRoundedCornerShape.getBottomStart());
    }

    public int hashCode() {
        return (((((getTopStart().hashCode() * 31) + getTopEnd().hashCode()) * 31) + getBottomEnd().hashCode()) * 31) + getBottomStart().hashCode();
    }

    /* renamed from: toRadius-Bz7bX_o  reason: not valid java name */
    private final long m1016toRadiusBz7bX_o(float f) {
        return CornerRadiusKt.CornerRadius$default(f, 0.0f, 2, (Object) null);
    }
}
