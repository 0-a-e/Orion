package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/material3/AnchoredDraggableState;", "T", "", "it", "invoke", "(Ljava/lang/Object;)Landroidx/compose/material3/AnchoredDraggableState;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnchoredDraggable.kt */
final class AnchoredDraggableState$Companion$Saver$2 extends Lambda implements Function1<T, AnchoredDraggableState<T>> {
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ Function1<T, Boolean> $confirmValueChange;
    final /* synthetic */ Function1<Float, Float> $positionalThreshold;
    final /* synthetic */ Function0<Float> $velocityThreshold;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnchoredDraggableState$Companion$Saver$2(Function1<? super Float, Float> function1, Function0<Float> function0, AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> function12) {
        super(1);
        this.$positionalThreshold = function1;
        this.$velocityThreshold = function0;
        this.$animationSpec = animationSpec;
        this.$confirmValueChange = function12;
    }

    public final AnchoredDraggableState<T> invoke(T t) {
        return new AnchoredDraggableState(t, this.$positionalThreshold, this.$velocityThreshold, this.$animationSpec, this.$confirmValueChange);
    }
}
