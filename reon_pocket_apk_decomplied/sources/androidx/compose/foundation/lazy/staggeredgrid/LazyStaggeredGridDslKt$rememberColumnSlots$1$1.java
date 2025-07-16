package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "Landroidx/compose/ui/unit/Density;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-0kLqBqw", "(Landroidx/compose/ui/unit/Density;J)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridDsl.kt */
final class LazyStaggeredGridDslKt$rememberColumnSlots$1$1 extends Lambda implements Function2<Density, Constraints, LazyStaggeredGridSlots> {
    final /* synthetic */ StaggeredGridCells $columns;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyStaggeredGridDslKt$rememberColumnSlots$1$1(PaddingValues paddingValues, StaggeredGridCells staggeredGridCells, Arrangement.Horizontal horizontal) {
        super(2);
        this.$contentPadding = paddingValues;
        this.$columns = staggeredGridCells;
        this.$horizontalArrangement = horizontal;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m925invoke0kLqBqw((Density) obj, ((Constraints) obj2).m6532unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final LazyStaggeredGridSlots m925invoke0kLqBqw(Density density, long j) {
        if (Constraints.m6526getMaxWidthimpl(j) != Integer.MAX_VALUE) {
            int r2 = Constraints.m6526getMaxWidthimpl(j) - density.m6545roundToPx0680j_4(Dp.m6614constructorimpl(PaddingKt.calculateStartPadding(this.$contentPadding, LayoutDirection.Ltr) + PaddingKt.calculateEndPadding(this.$contentPadding, LayoutDirection.Ltr)));
            StaggeredGridCells staggeredGridCells = this.$columns;
            Arrangement.Horizontal horizontal = this.$horizontalArrangement;
            int[] calculateCrossAxisCellSizes = staggeredGridCells.calculateCrossAxisCellSizes(density, r2, density.m6545roundToPx0680j_4(horizontal.m552getSpacingD9Ej5fM()));
            int[] iArr = new int[calculateCrossAxisCellSizes.length];
            horizontal.arrange(density, r2, calculateCrossAxisCellSizes, LayoutDirection.Ltr, iArr);
            return new LazyStaggeredGridSlots(iArr, calculateCrossAxisCellSizes);
        }
        throw new IllegalArgumentException("LazyVerticalStaggeredGrid's width should be bound by parent.".toString());
    }
}
