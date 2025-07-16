package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¨\u0006\u000e"}, d2 = {"androidx/compose/foundation/lazy/grid/LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "createItem", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "index", "", "key", "", "contentType", "crossAxisSize", "mainAxisSpacing", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGrid.kt */
public final class LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 extends LazyGridMeasuredItemProvider {
    final /* synthetic */ int $afterContentPadding;
    final /* synthetic */ int $beforeContentPadding;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ LazyGridState $state;
    final /* synthetic */ LazyLayoutMeasureScope $this_null;
    final /* synthetic */ long $visualItemOffset;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1(LazyGridItemProvider lazyGridItemProvider, LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, LazyGridState lazyGridState, boolean z, boolean z2, int i2, int i3, long j) {
        super(lazyGridItemProvider, lazyLayoutMeasureScope, i);
        this.$this_null = lazyLayoutMeasureScope;
        this.$state = lazyGridState;
        this.$isVertical = z;
        this.$reverseLayout = z2;
        this.$beforeContentPadding = i2;
        this.$afterContentPadding = i3;
        this.$visualItemOffset = j;
    }

    public LazyGridMeasuredItem createItem(int i, Object obj, Object obj2, int i2, int i3, List<? extends Placeable> list) {
        return new LazyGridMeasuredItem(i, obj, this.$isVertical, i2, i3, this.$reverseLayout, this.$this_null.getLayoutDirection(), this.$beforeContentPadding, this.$afterContentPadding, list, this.$visualItemOffset, obj2, this.$state.getPlacementAnimator$foundation_release(), (DefaultConstructorMarker) null);
    }
}
