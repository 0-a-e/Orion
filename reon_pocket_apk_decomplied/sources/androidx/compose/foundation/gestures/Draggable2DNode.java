package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u001e\b\u0000\u0018\u00002\u00020\u0001BÅ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f\u0012<\u0010\r\u001a8\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u000e¢\u0006\u0002\b\u0017\u0012<\u0010\u0018\u001a8\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u000e¢\u0006\u0002\b\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u0007¢\u0006\u0002\u0010\u001cJ7\u0010*\u001a\u00020\u00152'\u0010+\u001a#\b\u0001\u0012\u0004\u0012\u00020-\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00160,¢\u0006\u0002\b\u0017H@¢\u0006\u0002\u0010.JË\u0001\u0010/\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f2<\u0010\r\u001a8\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u000e¢\u0006\u0002\b\u00172<\u0010\u0018\u001a8\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u000e¢\u0006\u0002\b\u00172\u0006\u0010\u001b\u001a\u00020\u0007¢\u0006\u0002\u0010\u001cJ\u001a\u00100\u001a\u00020\u0015*\u00020-2\u0006\u00101\u001a\u000202H@¢\u0006\u0002\u00103R\u0010\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020'X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Landroidx/compose/foundation/gestures/Draggable2DNode;", "Landroidx/compose/foundation/gestures/AbstractDraggableNode;", "state", "Landroidx/compose/foundation/gestures/Draggable2DState;", "canDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "Lkotlin/Function0;", "onDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "startedPosition", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "onDragStopped", "Landroidx/compose/ui/unit/Velocity;", "velocity", "reverseDirection", "(Landroidx/compose/foundation/gestures/Draggable2DState;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)V", "abstractDragScope", "androidx/compose/foundation/gestures/Draggable2DNode$abstractDragScope$1", "Landroidx/compose/foundation/gestures/Draggable2DNode$abstractDragScope$1;", "drag2DScope", "Landroidx/compose/foundation/gestures/Drag2DScope;", "getDrag2DScope", "()Landroidx/compose/foundation/gestures/Drag2DScope;", "setDrag2DScope", "(Landroidx/compose/foundation/gestures/Drag2DScope;)V", "pointerDirectionConfig", "Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "getPointerDirectionConfig", "()Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "drag", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/AbstractDragScope;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "draggingBy", "dragDelta", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "(Landroidx/compose/foundation/gestures/AbstractDragScope;Landroidx/compose/foundation/gestures/DragEvent$DragDelta;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Draggable2D.kt */
public final class Draggable2DNode extends AbstractDraggableNode {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public final Draggable2DNode$abstractDragScope$1 abstractDragScope = new Draggable2DNode$abstractDragScope$1(this);
    private Drag2DScope drag2DScope = Draggable2DKt.NoOpDrag2DScope;
    private final PointerDirectionConfig pointerDirectionConfig = DragGestureDetectorKt.getBidirectionalPointerDirectionConfig();
    private Draggable2DState state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Draggable2DNode(Draggable2DState draggable2DState, Function1<? super PointerInputChange, Boolean> function1, boolean z, MutableInteractionSource mutableInteractionSource, Function0<Boolean> function0, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function3<? super CoroutineScope, ? super Velocity, ? super Continuation<? super Unit>, ? extends Object> function32, boolean z2) {
        super(function1, z, mutableInteractionSource, function0, function3, function32, z2);
        this.state = draggable2DState;
    }

    public final Drag2DScope getDrag2DScope() {
        return this.drag2DScope;
    }

    public final void setDrag2DScope(Drag2DScope drag2DScope2) {
        this.drag2DScope = drag2DScope2;
    }

    public Object drag(Function2<? super AbstractDragScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object drag = this.state.drag(MutatePriority.UserInput, new Draggable2DNode$drag$2(this, function2, (Continuation<? super Draggable2DNode$drag$2>) null), continuation);
        return drag == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? drag : Unit.INSTANCE;
    }

    public Object draggingBy(AbstractDragScope abstractDragScope2, DragEvent.DragDelta dragDelta, Continuation<? super Unit> continuation) {
        abstractDragScope2.m340dragByk4lQ0M(dragDelta.m355getDeltaF1C5BW0());
        return Unit.INSTANCE;
    }

    public PointerDirectionConfig getPointerDirectionConfig() {
        return this.pointerDirectionConfig;
    }

    public final void update(Draggable2DState draggable2DState, Function1<? super PointerInputChange, Boolean> function1, boolean z, MutableInteractionSource mutableInteractionSource, Function0<Boolean> function0, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function3<? super CoroutineScope, ? super Velocity, ? super Continuation<? super Unit>, ? extends Object> function32, boolean z2) {
        boolean z3;
        boolean z4 = true;
        if (!Intrinsics.areEqual((Object) this.state, (Object) draggable2DState)) {
            this.state = draggable2DState;
            z3 = true;
        } else {
            z3 = false;
        }
        setCanDrag(function1);
        if (getEnabled() != z) {
            setEnabled(z);
            if (!z) {
                disposeInteractionSource();
            }
            z3 = true;
        }
        if (!Intrinsics.areEqual((Object) getInteractionSource(), (Object) mutableInteractionSource)) {
            disposeInteractionSource();
            setInteractionSource(mutableInteractionSource);
        }
        setStartDragImmediately(function0);
        setOnDragStarted(function3);
        setOnDragStopped(function32);
        if (getReverseDirection() != z2) {
            setReverseDirection(z2);
        } else {
            z4 = z3;
        }
        if (z4) {
            getPointerInputNode().resetPointerInputHandler();
        }
    }
}
