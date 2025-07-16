package androidx.compose.ui.node;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutNodeLayoutDelegate.kt */
final class LayoutNodeLayoutDelegate$MeasurePassDelegate$placeOuterCoordinatorBlock$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LayoutNodeLayoutDelegate this$0;
    final /* synthetic */ LayoutNodeLayoutDelegate.MeasurePassDelegate this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LayoutNodeLayoutDelegate$MeasurePassDelegate$placeOuterCoordinatorBlock$1(LayoutNodeLayoutDelegate layoutNodeLayoutDelegate, LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate) {
        super(0);
        this.this$0 = layoutNodeLayoutDelegate;
        this.this$1 = measurePassDelegate;
    }

    public final void invoke() {
        Placeable.PlacementScope placementScope;
        NodeCoordinator wrappedBy$ui_release = this.this$0.getOuterCoordinator().getWrappedBy$ui_release();
        if (wrappedBy$ui_release == null || (placementScope = wrappedBy$ui_release.getPlacementScope()) == null) {
            placementScope = LayoutNodeKt.requireOwner(this.this$0.layoutNode).getPlacementScope();
        }
        Placeable.PlacementScope placementScope2 = placementScope;
        LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate = this.this$1;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.this$0;
        Function1 access$getPlaceOuterCoordinatorLayerBlock$p = measurePassDelegate.placeOuterCoordinatorLayerBlock;
        if (access$getPlaceOuterCoordinatorLayerBlock$p == null) {
            placementScope2.m5413place70tqf50(layoutNodeLayoutDelegate.getOuterCoordinator(), measurePassDelegate.placeOuterCoordinatorPosition, measurePassDelegate.placeOuterCoordinatorZIndex);
        } else {
            placementScope2.m5418placeWithLayeraW9wM(layoutNodeLayoutDelegate.getOuterCoordinator(), measurePassDelegate.placeOuterCoordinatorPosition, measurePassDelegate.placeOuterCoordinatorZIndex, access$getPlaceOuterCoordinatorLayerBlock$p);
        }
    }
}
