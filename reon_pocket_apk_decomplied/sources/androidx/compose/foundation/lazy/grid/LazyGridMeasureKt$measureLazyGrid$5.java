package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridMeasure.kt */
final class LazyGridMeasureKt$measureLazyGrid$5 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ MutableState<Unit> $placementScopeInvalidator;
    final /* synthetic */ List<LazyGridMeasuredItem> $positionedItems;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyGridMeasureKt$measureLazyGrid$5(List<LazyGridMeasuredItem> list, MutableState<Unit> mutableState) {
        super(1);
        this.$positionedItems = list;
        this.$placementScopeInvalidator = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        List<LazyGridMeasuredItem> list = this.$positionedItems;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i).place(placementScope);
        }
        ObservableScopeInvalidator.m905attachToScopeimpl(this.$placementScopeInvalidator);
    }
}
