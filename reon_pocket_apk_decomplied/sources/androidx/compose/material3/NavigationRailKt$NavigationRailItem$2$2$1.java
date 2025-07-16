package androidx.compose.material3;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationRail.kt */
final class NavigationRailKt$NavigationRailItem$2$2$1 extends Lambda implements Function0<Float> {
    final /* synthetic */ State<Float> $animationProgress;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationRailKt$NavigationRailItem$2$2$1(State<Float> state) {
        super(0);
        this.$animationProgress = state;
    }

    public final Float invoke() {
        return this.$animationProgress.getValue();
    }
}
