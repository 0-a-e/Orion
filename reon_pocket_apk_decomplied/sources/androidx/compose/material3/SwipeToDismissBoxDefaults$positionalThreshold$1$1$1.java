package androidx.compose.material3;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "it", "invoke", "(F)Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeToDismissBox.kt */
final class SwipeToDismissBoxDefaults$positionalThreshold$1$1$1 extends Lambda implements Function1<Float, Float> {
    final /* synthetic */ Density $this_with;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeToDismissBoxDefaults$positionalThreshold$1$1$1(Density density) {
        super(1);
        this.$this_with = density;
    }

    public final Float invoke(float f) {
        return Float.valueOf(this.$this_with.m6550toPx0680j_4(Dp.m6614constructorimpl((float) 56)));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).floatValue());
    }
}
