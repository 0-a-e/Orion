package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListMeasure.kt */
final class LazyListMeasureKt$measureLazyList$7 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ LazyListMeasuredItem $headerItem;
    final /* synthetic */ boolean $isLookingAhead;
    final /* synthetic */ MutableState<Unit> $placementScopeInvalidator;
    final /* synthetic */ List<LazyListMeasuredItem> $positionedItems;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyListMeasureKt$measureLazyList$7(List<LazyListMeasuredItem> list, LazyListMeasuredItem lazyListMeasuredItem, boolean z, MutableState<Unit> mutableState) {
        super(1);
        this.$positionedItems = list;
        this.$headerItem = lazyListMeasuredItem;
        this.$isLookingAhead = z;
        this.$placementScopeInvalidator = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        List<LazyListMeasuredItem> list = this.$positionedItems;
        LazyListMeasuredItem lazyListMeasuredItem = this.$headerItem;
        boolean z = this.$isLookingAhead;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            LazyListMeasuredItem lazyListMeasuredItem2 = list.get(i);
            if (lazyListMeasuredItem2 != lazyListMeasuredItem) {
                lazyListMeasuredItem2.place(placementScope, z);
            }
        }
        LazyListMeasuredItem lazyListMeasuredItem3 = this.$headerItem;
        if (lazyListMeasuredItem3 != null) {
            lazyListMeasuredItem3.place(placementScope, this.$isLookingAhead);
        }
        ObservableScopeInvalidator.m905attachToScopeimpl(this.$placementScopeInvalidator);
    }
}
