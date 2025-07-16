package androidx.compose.material3;

import androidx.compose.material3.MenuPosition;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Landroidx/compose/material3/WindowAlignmentMarginPosition;", "", "()V", "Horizontal", "Vertical", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MenuPosition.kt */
public final class WindowAlignmentMarginPosition {
    public static final int $stable = 0;
    public static final WindowAlignmentMarginPosition INSTANCE = new WindowAlignmentMarginPosition();

    private WindowAlignmentMarginPosition() {
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0003HÂ\u0003J\t\u0010\b\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001J2\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Landroidx/compose/material3/WindowAlignmentMarginPosition$Horizontal;", "Landroidx/compose/material3/MenuPosition$Horizontal;", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "margin", "", "(Landroidx/compose/ui/Alignment$Horizontal;I)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "position", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "menuWidth", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "position-95KtPRI", "(Landroidx/compose/ui/unit/IntRect;JILandroidx/compose/ui/unit/LayoutDirection;)I", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: MenuPosition.kt */
    public static final class Horizontal implements MenuPosition.Horizontal {
        public static final int $stable = 0;
        private final Alignment.Horizontal alignment;
        private final int margin;

        private final Alignment.Horizontal component1() {
            return this.alignment;
        }

        private final int component2() {
            return this.margin;
        }

        public static /* synthetic */ Horizontal copy$default(Horizontal horizontal, Alignment.Horizontal horizontal2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                horizontal2 = horizontal.alignment;
            }
            if ((i2 & 2) != 0) {
                i = horizontal.margin;
            }
            return horizontal.copy(horizontal2, i);
        }

        public final Horizontal copy(Alignment.Horizontal horizontal, int i) {
            return new Horizontal(horizontal, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Horizontal)) {
                return false;
            }
            Horizontal horizontal = (Horizontal) obj;
            return Intrinsics.areEqual((Object) this.alignment, (Object) horizontal.alignment) && this.margin == horizontal.margin;
        }

        public int hashCode() {
            return (this.alignment.hashCode() * 31) + this.margin;
        }

        public String toString() {
            return "Horizontal(alignment=" + this.alignment + ", margin=" + this.margin + ')';
        }

        public Horizontal(Alignment.Horizontal horizontal, int i) {
            this.alignment = horizontal;
            this.margin = i;
        }

        /* renamed from: position-95KtPRI  reason: not valid java name */
        public int m2622position95KtPRI(IntRect intRect, long j, int i, LayoutDirection layoutDirection) {
            if (i >= IntSize.m6790getWidthimpl(j) - (this.margin * 2)) {
                return Alignment.Companion.getCenterHorizontally().align(i, IntSize.m6790getWidthimpl(j), layoutDirection);
            }
            return RangesKt.coerceIn(this.alignment.align(i, IntSize.m6790getWidthimpl(j), layoutDirection), this.margin, (IntSize.m6790getWidthimpl(j) - this.margin) - i);
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0003HÂ\u0003J\t\u0010\b\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001J*\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"Landroidx/compose/material3/WindowAlignmentMarginPosition$Vertical;", "Landroidx/compose/material3/MenuPosition$Vertical;", "alignment", "Landroidx/compose/ui/Alignment$Vertical;", "margin", "", "(Landroidx/compose/ui/Alignment$Vertical;I)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "position", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "menuHeight", "position-JVtK1S4", "(Landroidx/compose/ui/unit/IntRect;JI)I", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: MenuPosition.kt */
    public static final class Vertical implements MenuPosition.Vertical {
        public static final int $stable = 0;
        private final Alignment.Vertical alignment;
        private final int margin;

        private final Alignment.Vertical component1() {
            return this.alignment;
        }

        private final int component2() {
            return this.margin;
        }

        public static /* synthetic */ Vertical copy$default(Vertical vertical, Alignment.Vertical vertical2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                vertical2 = vertical.alignment;
            }
            if ((i2 & 2) != 0) {
                i = vertical.margin;
            }
            return vertical.copy(vertical2, i);
        }

        public final Vertical copy(Alignment.Vertical vertical, int i) {
            return new Vertical(vertical, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Vertical)) {
                return false;
            }
            Vertical vertical = (Vertical) obj;
            return Intrinsics.areEqual((Object) this.alignment, (Object) vertical.alignment) && this.margin == vertical.margin;
        }

        public int hashCode() {
            return (this.alignment.hashCode() * 31) + this.margin;
        }

        public String toString() {
            return "Vertical(alignment=" + this.alignment + ", margin=" + this.margin + ')';
        }

        public Vertical(Alignment.Vertical vertical, int i) {
            this.alignment = vertical;
            this.margin = i;
        }

        /* renamed from: position-JVtK1S4  reason: not valid java name */
        public int m2623positionJVtK1S4(IntRect intRect, long j, int i) {
            if (i >= IntSize.m6789getHeightimpl(j) - (this.margin * 2)) {
                return Alignment.Companion.getCenterVertically().align(i, IntSize.m6789getHeightimpl(j));
            }
            return RangesKt.coerceIn(this.alignment.align(i, IntSize.m6789getHeightimpl(j)), this.margin, (IntSize.m6789getHeightimpl(j) - this.margin) - i);
        }
    }
}
