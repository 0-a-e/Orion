package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/grid/LazyGridSlots;", "Landroidx/compose/ui/unit/Density;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-0kLqBqw", "(Landroidx/compose/ui/unit/Density;J)Landroidx/compose/foundation/lazy/grid/LazyGridSlots;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridDsl.kt */
final class LazyGridDslKt$rememberRowHeightSums$1$1 extends Lambda implements Function2<Density, Constraints, LazyGridSlots> {
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ GridCells $rows;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyGridDslKt$rememberRowHeightSums$1$1(PaddingValues paddingValues, GridCells gridCells, Arrangement.Vertical vertical) {
        super(2);
        this.$contentPadding = paddingValues;
        this.$rows = gridCells;
        this.$verticalArrangement = vertical;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m834invoke0kLqBqw((Density) obj, ((Constraints) obj2).m6532unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final LazyGridSlots m834invoke0kLqBqw(Density density, long j) {
        if (Constraints.m6525getMaxHeightimpl(j) != Integer.MAX_VALUE) {
            int r4 = Constraints.m6525getMaxHeightimpl(j) - density.m6545roundToPx0680j_4(Dp.m6614constructorimpl(this.$contentPadding.m687calculateTopPaddingD9Ej5fM() + this.$contentPadding.m684calculateBottomPaddingD9Ej5fM()));
            GridCells gridCells = this.$rows;
            Arrangement.Vertical vertical = this.$verticalArrangement;
            int[] intArray = CollectionsKt.toIntArray(gridCells.calculateCrossAxisCellSizes(density, r4, density.m6545roundToPx0680j_4(vertical.m570getSpacingD9Ej5fM())));
            int[] iArr = new int[intArray.length];
            vertical.arrange(density, r4, intArray, iArr);
            return new LazyGridSlots(intArray, iArr);
        }
        throw new IllegalArgumentException("LazyHorizontalGrid's height should be bound by parent.".toString());
    }
}
