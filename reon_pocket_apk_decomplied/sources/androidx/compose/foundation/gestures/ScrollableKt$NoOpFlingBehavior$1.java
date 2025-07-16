package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0003H@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"androidx/compose/foundation/gestures/ScrollableKt$NoOpFlingBehavior$1", "Landroidx/compose/foundation/gestures/FlingBehavior;", "performFling", "", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scrollable.kt */
public final class ScrollableKt$NoOpFlingBehavior$1 implements FlingBehavior {
    ScrollableKt$NoOpFlingBehavior$1() {
    }

    public Object performFling(ScrollScope scrollScope, float f, Continuation<? super Float> continuation) {
        return Boxing.boxFloat(0.0f);
    }
}
