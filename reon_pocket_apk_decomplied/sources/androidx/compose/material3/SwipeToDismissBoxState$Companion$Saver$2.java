package androidx.compose.material3;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/material3/SwipeToDismissBoxState;", "it", "Landroidx/compose/material3/SwipeToDismissBoxValue;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeToDismissBox.kt */
final class SwipeToDismissBoxState$Companion$Saver$2 extends Lambda implements Function1<SwipeToDismissBoxValue, SwipeToDismissBoxState> {
    final /* synthetic */ Function1<SwipeToDismissBoxValue, Boolean> $confirmValueChange;
    final /* synthetic */ Density $density;
    final /* synthetic */ Function1<Float, Float> $positionalThreshold;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeToDismissBoxState$Companion$Saver$2(Density density, Function1<? super SwipeToDismissBoxValue, Boolean> function1, Function1<? super Float, Float> function12) {
        super(1);
        this.$density = density;
        this.$confirmValueChange = function1;
        this.$positionalThreshold = function12;
    }

    public final SwipeToDismissBoxState invoke(SwipeToDismissBoxValue swipeToDismissBoxValue) {
        return new SwipeToDismissBoxState(swipeToDismissBoxValue, this.$density, this.$confirmValueChange, this.$positionalThreshold);
    }
}
