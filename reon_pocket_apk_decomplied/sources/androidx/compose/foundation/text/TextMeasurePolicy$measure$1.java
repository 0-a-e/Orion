package androidx.compose.foundation.text;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicText.kt */
final class TextMeasurePolicy$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ List<Pair<Placeable, IntOffset>> $toPlace;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextMeasurePolicy$measure$1(List<? extends Pair<? extends Placeable, IntOffset>> list) {
        super(1);
        this.$toPlace = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        List<Pair<Placeable, IntOffset>> list = this.$toPlace;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Pair pair = list.get(i);
                Placeable.PlacementScope.m5409place70tqf50$default(placementScope, (Placeable) pair.component1(), ((IntOffset) pair.component2()).m6757unboximpl(), 0.0f, 2, (Object) null);
            }
        }
    }
}
