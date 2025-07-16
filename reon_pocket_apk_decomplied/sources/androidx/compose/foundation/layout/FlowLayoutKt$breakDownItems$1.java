package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "placeable", "Landroidx/compose/ui/layout/Placeable;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FlowLayout.kt */
final class FlowLayoutKt$breakDownItems$1 extends Lambda implements Function1<Placeable, Unit> {
    final /* synthetic */ int $index;
    final /* synthetic */ Placeable[] $placeables;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowLayoutKt$breakDownItems$1(Placeable[] placeableArr, int i) {
        super(1);
        this.$placeables = placeableArr;
        this.$index = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable placeable) {
        this.$placeables[this.$index + 1] = placeable;
    }
}
