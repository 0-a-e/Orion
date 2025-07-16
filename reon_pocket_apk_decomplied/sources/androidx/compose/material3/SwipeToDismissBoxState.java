package androidx.compose.material3;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.unit.Density;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+BN\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\u0010\u000eJ\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0003H@¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020\b2\u0006\u0010#\u001a\u00020&H\u0007J\u0006\u0010'\u001a\u00020\nJ\u000e\u0010(\u001a\u00020\"H@¢\u0006\u0002\u0010)J\u0016\u0010*\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u0003H@¢\u0006\u0002\u0010$R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\n8G¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\u001f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b \u0010\u0015¨\u0006,"}, d2 = {"Landroidx/compose/material3/SwipeToDismissBoxState;", "", "initialValue", "Landroidx/compose/material3/SwipeToDismissBoxValue;", "density", "Landroidx/compose/ui/unit/Density;", "confirmValueChange", "Lkotlin/Function1;", "", "positionalThreshold", "", "Lkotlin/ParameterName;", "name", "totalDistance", "(Landroidx/compose/material3/SwipeToDismissBoxValue;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "anchoredDraggableState", "Landroidx/compose/material3/AnchoredDraggableState;", "getAnchoredDraggableState$material3_release", "()Landroidx/compose/material3/AnchoredDraggableState;", "currentValue", "getCurrentValue", "()Landroidx/compose/material3/SwipeToDismissBoxValue;", "getDensity$material3_release", "()Landroidx/compose/ui/unit/Density;", "dismissDirection", "getDismissDirection", "offset", "getOffset$material3_release", "()F", "progress", "getProgress", "targetValue", "getTargetValue", "dismiss", "", "direction", "(Landroidx/compose/material3/SwipeToDismissBoxValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isDismissed", "Landroidx/compose/material3/DismissDirection;", "requireOffset", "reset", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeToDismissBox.kt */
public final class SwipeToDismissBoxState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final AnchoredDraggableState<SwipeToDismissBoxValue> anchoredDraggableState;
    private final Density density;

    public SwipeToDismissBoxState(SwipeToDismissBoxValue swipeToDismissBoxValue, Density density2, Function1<? super SwipeToDismissBoxValue, Boolean> function1, Function1<? super Float, Float> function12) {
        this.density = density2;
        SwipeToDismissBoxValue swipeToDismissBoxValue2 = swipeToDismissBoxValue;
        Function1<? super Float, Float> function13 = function12;
        this.anchoredDraggableState = new AnchoredDraggableState(swipeToDismissBoxValue2, function13, new SwipeToDismissBoxState$anchoredDraggableState$1(this), AnchoredDraggableDefaults.INSTANCE.getAnimationSpec(), function1);
    }

    public final Density getDensity$material3_release() {
        return this.density;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SwipeToDismissBoxState(SwipeToDismissBoxValue swipeToDismissBoxValue, Density density2, Function1 function1, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(swipeToDismissBoxValue, density2, (i & 4) != 0 ? AnonymousClass1.INSTANCE : function1, function12);
    }

    public final AnchoredDraggableState<SwipeToDismissBoxValue> getAnchoredDraggableState$material3_release() {
        return this.anchoredDraggableState;
    }

    public final float getOffset$material3_release() {
        return this.anchoredDraggableState.getOffset();
    }

    public final float requireOffset() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final SwipeToDismissBoxValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    public final SwipeToDismissBoxValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final float getProgress() {
        return this.anchoredDraggableState.getProgress();
    }

    public final SwipeToDismissBoxValue getDismissDirection() {
        if (getOffset$material3_release() != 0.0f && !Float.isNaN(getOffset$material3_release())) {
            return getOffset$material3_release() > 0.0f ? SwipeToDismissBoxValue.StartToEnd : SwipeToDismissBoxValue.EndToStart;
        }
        return SwipeToDismissBoxValue.Settled;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "DismissDirection is no longer used by SwipeToDismissBoxState. Please compare currentValue against SwipeToDismissValue instead.")
    public final /* synthetic */ boolean isDismissed(DismissDirection dismissDirection) {
        SwipeToDismissBoxValue swipeToDismissBoxValue;
        SwipeToDismissBoxValue currentValue = getCurrentValue();
        if (dismissDirection == DismissDirection.StartToEnd) {
            swipeToDismissBoxValue = SwipeToDismissBoxValue.StartToEnd;
        } else {
            swipeToDismissBoxValue = SwipeToDismissBoxValue.EndToStart;
        }
        return currentValue == swipeToDismissBoxValue;
    }

    public final Object snapTo(SwipeToDismissBoxValue swipeToDismissBoxValue, Continuation<? super Unit> continuation) {
        Object snapTo = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, swipeToDismissBoxValue, continuation);
        return snapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? snapTo : Unit.INSTANCE;
    }

    public final Object reset(Continuation<? super Unit> continuation) {
        Object animateTo$default = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, SwipeToDismissBoxValue.Settled, 0.0f, continuation, 2, (Object) null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    public final Object dismiss(SwipeToDismissBoxValue swipeToDismissBoxValue, Continuation<? super Unit> continuation) {
        Object animateTo$default = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, swipeToDismissBoxValue, 0.0f, continuation, 2, (Object) null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JQ\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/material3/SwipeToDismissBoxState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/SwipeToDismissBoxState;", "Landroidx/compose/material3/SwipeToDismissBoxValue;", "confirmValueChange", "Lkotlin/Function1;", "", "positionalThreshold", "", "Lkotlin/ParameterName;", "name", "totalDistance", "density", "Landroidx/compose/ui/unit/Density;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SwipeToDismissBox.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<SwipeToDismissBoxState, SwipeToDismissBoxValue> Saver(Function1<? super SwipeToDismissBoxValue, Boolean> function1, Function1<? super Float, Float> function12, Density density) {
            return SaverKt.Saver(SwipeToDismissBoxState$Companion$Saver$1.INSTANCE, new SwipeToDismissBoxState$Companion$Saver$2(density, function1, function12));
        }
    }
}
