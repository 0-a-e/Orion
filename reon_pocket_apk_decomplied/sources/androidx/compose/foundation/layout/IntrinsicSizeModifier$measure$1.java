package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Intrinsic.kt */
final class IntrinsicSizeModifier$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ Placeable $placeable;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntrinsicSizeModifier$measure$1(Placeable placeable) {
        super(1);
        this.$placeable = placeable;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.m5410placeRelative70tqf50$default(placementScope, this.$placeable, IntOffset.Companion.m6758getZeronOccac(), 0.0f, 2, (Object) null);
    }
}
