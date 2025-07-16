package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/layout/LimitInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "insets", "sides", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "(Landroidx/compose/foundation/layout/WindowInsets;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getInsets", "()Landroidx/compose/foundation/layout/WindowInsets;", "getSides-JoeWqyM", "()I", "I", "equals", "", "other", "", "getBottom", "", "density", "Landroidx/compose/ui/unit/Density;", "getLeft", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getRight", "getTop", "hashCode", "toString", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowInsets.kt */
final class LimitInsets implements WindowInsets {
    private final WindowInsets insets;
    private final int sides;

    public /* synthetic */ LimitInsets(WindowInsets windowInsets, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowInsets, i);
    }

    private LimitInsets(WindowInsets windowInsets, int i) {
        this.insets = windowInsets;
        this.sides = i;
    }

    public final WindowInsets getInsets() {
        return this.insets;
    }

    /* renamed from: getSides-JoeWqyM  reason: not valid java name */
    public final int m623getSidesJoeWqyM() {
        return this.sides;
    }

    public int getLeft(Density density, LayoutDirection layoutDirection) {
        int i;
        if (layoutDirection == LayoutDirection.Ltr) {
            i = WindowInsetsSides.Companion.m789getAllowLeftInLtrJoeWqyM$foundation_layout_release();
        } else {
            i = WindowInsetsSides.Companion.m790getAllowLeftInRtlJoeWqyM$foundation_layout_release();
        }
        if (WindowInsetsSides.m783hasAnybkgdKaI$foundation_layout_release(this.sides, i)) {
            return this.insets.getLeft(density, layoutDirection);
        }
        return 0;
    }

    public int getTop(Density density) {
        if (WindowInsetsSides.m783hasAnybkgdKaI$foundation_layout_release(this.sides, WindowInsetsSides.Companion.m799getTopJoeWqyM())) {
            return this.insets.getTop(density);
        }
        return 0;
    }

    public int getRight(Density density, LayoutDirection layoutDirection) {
        int i;
        if (layoutDirection == LayoutDirection.Ltr) {
            i = WindowInsetsSides.Companion.m791getAllowRightInLtrJoeWqyM$foundation_layout_release();
        } else {
            i = WindowInsetsSides.Companion.m792getAllowRightInRtlJoeWqyM$foundation_layout_release();
        }
        if (WindowInsetsSides.m783hasAnybkgdKaI$foundation_layout_release(this.sides, i)) {
            return this.insets.getRight(density, layoutDirection);
        }
        return 0;
    }

    public int getBottom(Density density) {
        if (WindowInsetsSides.m783hasAnybkgdKaI$foundation_layout_release(this.sides, WindowInsetsSides.Companion.m793getBottomJoeWqyM())) {
            return this.insets.getBottom(density);
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LimitInsets)) {
            return false;
        }
        LimitInsets limitInsets = (LimitInsets) obj;
        if (!Intrinsics.areEqual((Object) this.insets, (Object) limitInsets.insets) || !WindowInsetsSides.m782equalsimpl0(this.sides, limitInsets.sides)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.insets.hashCode() * 31) + WindowInsetsSides.m784hashCodeimpl(this.sides);
    }

    public String toString() {
        return "(" + this.insets + " only " + WindowInsetsSides.m786toStringimpl(this.sides) + ')';
    }
}
