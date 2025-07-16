package androidx.compose.ui;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ZIndexModifier.kt */
final class ZIndexNode$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ ZIndexNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ZIndexNode$measure$1(Placeable placeable, ZIndexNode zIndexNode) {
        super(1);
        this.$placeable = placeable;
        this.this$0 = zIndexNode;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        placementScope.place(this.$placeable, 0, 0, this.this$0.getZIndex());
    }
}
