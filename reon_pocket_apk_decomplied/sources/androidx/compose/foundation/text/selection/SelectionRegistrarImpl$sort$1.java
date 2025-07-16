package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "a", "Landroidx/compose/foundation/text/selection/Selectable;", "b", "invoke", "(Landroidx/compose/foundation/text/selection/Selectable;Landroidx/compose/foundation/text/selection/Selectable;)Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionRegistrarImpl.kt */
final class SelectionRegistrarImpl$sort$1 extends Lambda implements Function2<Selectable, Selectable, Integer> {
    final /* synthetic */ LayoutCoordinates $containerLayoutCoordinates;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectionRegistrarImpl$sort$1(LayoutCoordinates layoutCoordinates) {
        super(2);
        this.$containerLayoutCoordinates = layoutCoordinates;
    }

    public final Integer invoke(Selectable selectable, Selectable selectable2) {
        long j;
        long j2;
        int i;
        LayoutCoordinates layoutCoordinates = selectable.getLayoutCoordinates();
        LayoutCoordinates layoutCoordinates2 = selectable2.getLayoutCoordinates();
        if (layoutCoordinates != null) {
            j = this.$containerLayoutCoordinates.m5319localPositionOfR5De75A(layoutCoordinates, Offset.Companion.m3578getZeroF1C5BW0());
        } else {
            j = Offset.Companion.m3578getZeroF1C5BW0();
        }
        if (layoutCoordinates2 != null) {
            j2 = this.$containerLayoutCoordinates.m5319localPositionOfR5De75A(layoutCoordinates2, Offset.Companion.m3578getZeroF1C5BW0());
        } else {
            j2 = Offset.Companion.m3578getZeroF1C5BW0();
        }
        if (Offset.m3563getYimpl(j) == Offset.m3563getYimpl(j2)) {
            i = ComparisonsKt.compareValues(Float.valueOf(Offset.m3562getXimpl(j)), Float.valueOf(Offset.m3562getXimpl(j2)));
        } else {
            i = ComparisonsKt.compareValues(Float.valueOf(Offset.m3563getYimpl(j)), Float.valueOf(Offset.m3563getYimpl(j2)));
        }
        return Integer.valueOf(i);
    }
}
