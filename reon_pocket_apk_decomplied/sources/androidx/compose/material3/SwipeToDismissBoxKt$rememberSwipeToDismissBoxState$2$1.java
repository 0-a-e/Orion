package androidx.compose.material3;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/material3/SwipeToDismissBoxState;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeToDismissBox.kt */
final class SwipeToDismissBoxKt$rememberSwipeToDismissBoxState$2$1 extends Lambda implements Function0<SwipeToDismissBoxState> {
    final /* synthetic */ Function1<SwipeToDismissBoxValue, Boolean> $confirmValueChange;
    final /* synthetic */ Density $density;
    final /* synthetic */ SwipeToDismissBoxValue $initialValue;
    final /* synthetic */ Function1<Float, Float> $positionalThreshold;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeToDismissBoxKt$rememberSwipeToDismissBoxState$2$1(SwipeToDismissBoxValue swipeToDismissBoxValue, Density density, Function1<? super SwipeToDismissBoxValue, Boolean> function1, Function1<? super Float, Float> function12) {
        super(0);
        this.$initialValue = swipeToDismissBoxValue;
        this.$density = density;
        this.$confirmValueChange = function1;
        this.$positionalThreshold = function12;
    }

    public final SwipeToDismissBoxState invoke() {
        return new SwipeToDismissBoxState(this.$initialValue, this.$density, this.$confirmValueChange, this.$positionalThreshold);
    }
}
