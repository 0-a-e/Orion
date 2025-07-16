package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B$\u0012\u001d\u0010\u0002\u001a\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\bJ\"\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u00020\u0005X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R%\u0010\u0002\u001a\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\b\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlotCache;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "calculation", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)V", "cachedConstraints", "J", "cachedDensity", "", "cachedSizes", "invoke", "density", "constraints", "invoke-0kLqBqw", "(Landroidx/compose/ui/unit/Density;J)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridDsl.kt */
final class LazyStaggeredGridSlotCache implements LazyGridStaggeredGridSlotsProvider {
    private long cachedConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null);
    private float cachedDensity;
    private LazyStaggeredGridSlots cachedSizes;
    private final Function2<Density, Constraints, LazyStaggeredGridSlots> calculation;

    public LazyStaggeredGridSlotCache(Function2<? super Density, ? super Constraints, LazyStaggeredGridSlots> function2) {
        this.calculation = function2;
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public LazyStaggeredGridSlots m948invoke0kLqBqw(Density density, long j) {
        if (this.cachedSizes == null || !Constraints.m6519equalsimpl0(this.cachedConstraints, j) || this.cachedDensity != density.getDensity()) {
            this.cachedConstraints = j;
            this.cachedDensity = density.getDensity();
            LazyStaggeredGridSlots invoke = this.calculation.invoke(density, Constraints.m6514boximpl(j));
            this.cachedSizes = invoke;
            return invoke;
        }
        LazyStaggeredGridSlots lazyStaggeredGridSlots = this.cachedSizes;
        Intrinsics.checkNotNull(lazyStaggeredGridSlots);
        return lazyStaggeredGridSlots;
    }
}
