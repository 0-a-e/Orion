package androidx.compose.material3;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$Slider$state$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ State<Function0<Unit>> $onValueChangeFinishedState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$Slider$state$1$1(State<? extends Function0<Unit>> state) {
        super(0);
        this.$onValueChangeFinishedState = state;
    }

    public final void invoke() {
        Function0 value = this.$onValueChangeFinishedState.getValue();
        if (value != null) {
            value.invoke();
        }
    }
}
