package androidx.compose.foundation.text2.input.internal.selection;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H@¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"detectPressDownGesture", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDown", "Landroidx/compose/foundation/text2/input/internal/selection/TapOnPosition;", "onUp", "Lkotlin/Function0;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text2/input/internal/selection/TapOnPosition;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PressDownGesture.kt */
public final class PressDownGestureKt {
    public static /* synthetic */ Object detectPressDownGesture$default(PointerInputScope pointerInputScope, TapOnPosition tapOnPosition, Function0 function0, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        return detectPressDownGesture(pointerInputScope, tapOnPosition, function0, continuation);
    }

    public static final Object detectPressDownGesture(PointerInputScope pointerInputScope, TapOnPosition tapOnPosition, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new PressDownGestureKt$detectPressDownGesture$2(tapOnPosition, function0, (Continuation<? super PressDownGestureKt$detectPressDownGesture$2>) null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }
}
