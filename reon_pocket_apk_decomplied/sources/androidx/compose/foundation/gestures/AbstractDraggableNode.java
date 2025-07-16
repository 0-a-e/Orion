package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B½\u0001\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f\u0012<\u0010\r\u001a8\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u000e¢\u0006\u0002\b\u0017\u0012<\u0010\u0018\u001a8\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u000e¢\u0006\u0002\b\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u0007¢\u0006\u0002\u0010\u001cJ\u0006\u0010H\u001a\u00020\u0015J7\u0010I\u001a\u00020\u00152'\u0010J\u001a#\b\u0001\u0012\u0004\u0012\u00020L\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00160K¢\u0006\u0002\b\u0017H¦@¢\u0006\u0002\u0010MJ\b\u0010N\u001a\u00020\u0015H\u0016J\b\u0010O\u001a\u00020\u0015H\u0016J*\u0010P\u001a\u00020\u00152\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020VH\u0016ø\u0001\u0000¢\u0006\u0004\bW\u0010XJ\b\u0010Y\u001a\u00020\u0015H\u0002J\u001a\u0010Z\u001a\u00020\u0015*\u00020L2\u0006\u0010[\u001a\u00020\\H¦@¢\u0006\u0002\u0010]J\u0012\u0010^\u001a\u00020\u0015*\u00020\u000fH@¢\u0006\u0002\u0010_J\u001a\u0010`\u001a\u00020\u0015*\u00020\u000f2\u0006\u0010a\u001a\u00020bH@¢\u0006\u0002\u0010cJ\u001a\u0010d\u001a\u00020\u0015*\u00020\u000f2\u0006\u0010a\u001a\u00020eH@¢\u0006\u0002\u0010fR\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u0004¢\u0006\u0002\n\u0000R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u00100\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000RR\u0010\r\u001a8\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u000e¢\u0006\u0002\b\u0017X\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\b1\u00102\"\u0004\b3\u00104RR\u0010\u0018\u001a8\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u000e¢\u0006\u0002\b\u0017X\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\b6\u00102\"\u0004\b7\u00104R\u0012\u00108\u001a\u000209X¦\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0011\u0010<\u001a\u00020=¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u001a\u0010\u001b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010)\"\u0004\bA\u0010+R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u000e\u0010F\u001a\u00020GX\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006g"}, d2 = {"Landroidx/compose/foundation/gestures/AbstractDraggableNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "canDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "Lkotlin/Function0;", "onDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "startedPosition", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "onDragStopped", "Landroidx/compose/ui/unit/Velocity;", "velocity", "reverseDirection", "(Lkotlin/jvm/functions/Function1;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)V", "_canDrag", "_startDragImmediately", "getCanDrag", "()Lkotlin/jvm/functions/Function1;", "setCanDrag", "(Lkotlin/jvm/functions/Function1;)V", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/DragEvent;", "dragInteraction", "Landroidx/compose/foundation/interaction/DragInteraction$Start;", "getEnabled", "()Z", "setEnabled", "(Z)V", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "setInteractionSource", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "isListeningForEvents", "getOnDragStarted", "()Lkotlin/jvm/functions/Function3;", "setOnDragStarted", "(Lkotlin/jvm/functions/Function3;)V", "Lkotlin/jvm/functions/Function3;", "getOnDragStopped", "setOnDragStopped", "pointerDirectionConfig", "Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "getPointerDirectionConfig", "()Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "getPointerInputNode", "()Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "getReverseDirection", "setReverseDirection", "getStartDragImmediately", "()Lkotlin/jvm/functions/Function0;", "setStartDragImmediately", "(Lkotlin/jvm/functions/Function0;)V", "velocityTracker", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "disposeInteractionSource", "drag", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/AbstractDragScope;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCancelPointerInput", "onDetach", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "startListeningForEvents", "draggingBy", "dragDelta", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "(Landroidx/compose/foundation/gestures/AbstractDragScope;Landroidx/compose/foundation/gestures/DragEvent$DragDelta;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragCancel", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragStart", "event", "Landroidx/compose/foundation/gestures/DragEvent$DragStarted;", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/gestures/DragEvent$DragStarted;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragStop", "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/gestures/DragEvent$DragStopped;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Draggable.kt */
public abstract class AbstractDraggableNode extends DelegatingNode implements PointerInputModifierNode, CompositionLocalConsumerModifierNode {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public final Function1<PointerInputChange, Boolean> _canDrag = new AbstractDraggableNode$_canDrag$1(this);
    /* access modifiers changed from: private */
    public final Function0<Boolean> _startDragImmediately = new AbstractDraggableNode$_startDragImmediately$1(this);
    private Function1<? super PointerInputChange, Boolean> canDrag;
    /* access modifiers changed from: private */
    public final Channel<DragEvent> channel = ChannelKt.Channel$default(Integer.MAX_VALUE, (BufferOverflow) null, (Function1) null, 6, (Object) null);
    private DragInteraction.Start dragInteraction;
    private boolean enabled;
    private MutableInteractionSource interactionSource;
    /* access modifiers changed from: private */
    public boolean isListeningForEvents;
    private Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted;
    private Function3<? super CoroutineScope, ? super Velocity, ? super Continuation<? super Unit>, ? extends Object> onDragStopped;
    private final SuspendingPointerInputModifierNode pointerInputNode = ((SuspendingPointerInputModifierNode) delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new AbstractDraggableNode$pointerInputNode$1(this, (Continuation<? super AbstractDraggableNode$pointerInputNode$1>) null))));
    private boolean reverseDirection;
    private Function0<Boolean> startDragImmediately;
    /* access modifiers changed from: private */
    public final VelocityTracker velocityTracker = new VelocityTracker();

    public abstract Object drag(Function2<? super AbstractDragScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation);

    public abstract Object draggingBy(AbstractDragScope abstractDragScope, DragEvent.DragDelta dragDelta, Continuation<? super Unit> continuation);

    public abstract PointerDirectionConfig getPointerDirectionConfig();

    public /* synthetic */ boolean interceptOutOfBoundsChildEvents() {
        return PointerInputModifierNode.CC.$default$interceptOutOfBoundsChildEvents(this);
    }

    public /* synthetic */ void onDensityChange() {
        PointerInputModifierNode.CC.$default$onDensityChange(this);
    }

    public /* synthetic */ void onViewConfigurationChange() {
        PointerInputModifierNode.CC.$default$onViewConfigurationChange(this);
    }

    public /* synthetic */ boolean sharePointerInputWithSiblings() {
        return PointerInputModifierNode.CC.$default$sharePointerInputWithSiblings(this);
    }

    public final Function1<PointerInputChange, Boolean> getCanDrag() {
        return this.canDrag;
    }

    public final void setCanDrag(Function1<? super PointerInputChange, Boolean> function1) {
        this.canDrag = function1;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    public final MutableInteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    public final void setInteractionSource(MutableInteractionSource mutableInteractionSource) {
        this.interactionSource = mutableInteractionSource;
    }

    public final Function0<Boolean> getStartDragImmediately() {
        return this.startDragImmediately;
    }

    public final void setStartDragImmediately(Function0<Boolean> function0) {
        this.startDragImmediately = function0;
    }

    public final Function3<CoroutineScope, Offset, Continuation<? super Unit>, Object> getOnDragStarted() {
        return this.onDragStarted;
    }

    public final void setOnDragStarted(Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3) {
        this.onDragStarted = function3;
    }

    public final Function3<CoroutineScope, Velocity, Continuation<? super Unit>, Object> getOnDragStopped() {
        return this.onDragStopped;
    }

    public final void setOnDragStopped(Function3<? super CoroutineScope, ? super Velocity, ? super Continuation<? super Unit>, ? extends Object> function3) {
        this.onDragStopped = function3;
    }

    public final boolean getReverseDirection() {
        return this.reverseDirection;
    }

    public final void setReverseDirection(boolean z) {
        this.reverseDirection = z;
    }

    public AbstractDraggableNode(Function1<? super PointerInputChange, Boolean> function1, boolean z, MutableInteractionSource mutableInteractionSource, Function0<Boolean> function0, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function3<? super CoroutineScope, ? super Velocity, ? super Continuation<? super Unit>, ? extends Object> function32, boolean z2) {
        this.canDrag = function1;
        this.enabled = z;
        this.interactionSource = mutableInteractionSource;
        this.startDragImmediately = function0;
        this.onDragStarted = function3;
        this.onDragStopped = function32;
        this.reverseDirection = z2;
    }

    /* access modifiers changed from: private */
    public final void startListeningForEvents() {
        this.isListeningForEvents = true;
        Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new AbstractDraggableNode$startListeningForEvents$1(this, (Continuation<? super AbstractDraggableNode$startListeningForEvents$1>) null), 3, (Object) null);
    }

    public final SuspendingPointerInputModifierNode getPointerInputNode() {
        return this.pointerInputNode;
    }

    public void onDetach() {
        this.isListeningForEvents = false;
        disposeInteractionSource();
    }

    /* renamed from: onPointerEvent-H0pRuoY  reason: not valid java name */
    public void m341onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        this.pointerInputNode.m5707onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
    }

    public void onCancelPointerInput() {
        this.pointerInputNode.onCancelPointerInput();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processDragStart(kotlinx.coroutines.CoroutineScope r9, androidx.compose.foundation.gestures.DragEvent.DragStarted r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof androidx.compose.foundation.gestures.AbstractDraggableNode$processDragStart$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            androidx.compose.foundation.gestures.AbstractDraggableNode$processDragStart$1 r0 = (androidx.compose.foundation.gestures.AbstractDraggableNode$processDragStart$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.AbstractDraggableNode$processDragStart$1 r0 = new androidx.compose.foundation.gestures.AbstractDraggableNode$processDragStart$1
            r0.<init>(r8, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0060
            if (r2 == r5) goto L_0x004d
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00c3
        L_0x0031:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0039:
            java.lang.Object r9 = r0.L$3
            androidx.compose.foundation.interaction.DragInteraction$Start r9 = (androidx.compose.foundation.interaction.DragInteraction.Start) r9
            java.lang.Object r10 = r0.L$2
            androidx.compose.foundation.gestures.DragEvent$DragStarted r10 = (androidx.compose.foundation.gestures.DragEvent.DragStarted) r10
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            java.lang.Object r4 = r0.L$0
            androidx.compose.foundation.gestures.AbstractDraggableNode r4 = (androidx.compose.foundation.gestures.AbstractDraggableNode) r4
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00a2
        L_0x004d:
            java.lang.Object r9 = r0.L$2
            androidx.compose.foundation.gestures.DragEvent$DragStarted r9 = (androidx.compose.foundation.gestures.DragEvent.DragStarted) r9
            java.lang.Object r10 = r0.L$1
            kotlinx.coroutines.CoroutineScope r10 = (kotlinx.coroutines.CoroutineScope) r10
            java.lang.Object r2 = r0.L$0
            androidx.compose.foundation.gestures.AbstractDraggableNode r2 = (androidx.compose.foundation.gestures.AbstractDraggableNode) r2
            kotlin.ResultKt.throwOnFailure(r11)
            r7 = r10
            r10 = r9
            r9 = r7
            goto L_0x0082
        L_0x0060:
            kotlin.ResultKt.throwOnFailure(r11)
            androidx.compose.foundation.interaction.DragInteraction$Start r11 = r8.dragInteraction
            if (r11 == 0) goto L_0x0081
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r8.interactionSource
            if (r2 == 0) goto L_0x0081
            androidx.compose.foundation.interaction.DragInteraction$Cancel r6 = new androidx.compose.foundation.interaction.DragInteraction$Cancel
            r6.<init>(r11)
            androidx.compose.foundation.interaction.Interaction r6 = (androidx.compose.foundation.interaction.Interaction) r6
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.label = r5
            java.lang.Object r11 = r2.emit(r6, r0)
            if (r11 != r1) goto L_0x0081
            return r1
        L_0x0081:
            r2 = r8
        L_0x0082:
            androidx.compose.foundation.interaction.DragInteraction$Start r11 = new androidx.compose.foundation.interaction.DragInteraction$Start
            r11.<init>()
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = r2.interactionSource
            if (r5 == 0) goto L_0x00a5
            r6 = r11
            androidx.compose.foundation.interaction.Interaction r6 = (androidx.compose.foundation.interaction.Interaction) r6
            r0.L$0 = r2
            r0.L$1 = r9
            r0.L$2 = r10
            r0.L$3 = r11
            r0.label = r4
            java.lang.Object r4 = r5.emit(r6, r0)
            if (r4 != r1) goto L_0x009f
            return r1
        L_0x009f:
            r4 = r2
            r2 = r9
            r9 = r11
        L_0x00a2:
            r11 = r9
            r9 = r2
            r2 = r4
        L_0x00a5:
            r2.dragInteraction = r11
            kotlin.jvm.functions.Function3<? super kotlinx.coroutines.CoroutineScope, ? super androidx.compose.ui.geometry.Offset, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r11 = r2.onDragStarted
            long r4 = r10.m356getStartPointF1C5BW0()
            androidx.compose.ui.geometry.Offset r10 = androidx.compose.ui.geometry.Offset.m3551boximpl(r4)
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.L$2 = r2
            r0.L$3 = r2
            r0.label = r3
            java.lang.Object r9 = r11.invoke(r9, r10, r0)
            if (r9 != r1) goto L_0x00c3
            return r1
        L_0x00c3:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AbstractDraggableNode.processDragStart(kotlinx.coroutines.CoroutineScope, androidx.compose.foundation.gestures.DragEvent$DragStarted, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0087 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processDragStop(kotlinx.coroutines.CoroutineScope r10, androidx.compose.foundation.gestures.DragEvent.DragStopped r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof androidx.compose.foundation.gestures.AbstractDraggableNode$processDragStop$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            androidx.compose.foundation.gestures.AbstractDraggableNode$processDragStop$1 r0 = (androidx.compose.foundation.gestures.AbstractDraggableNode$processDragStop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.AbstractDraggableNode$processDragStop$1 r0 = new androidx.compose.foundation.gestures.AbstractDraggableNode$processDragStop$1
            r0.<init>(r9, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0049
            if (r2 == r4) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0088
        L_0x002e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0036:
            java.lang.Object r10 = r0.L$2
            androidx.compose.foundation.gestures.DragEvent$DragStopped r10 = (androidx.compose.foundation.gestures.DragEvent.DragStopped) r10
            java.lang.Object r11 = r0.L$1
            kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
            java.lang.Object r2 = r0.L$0
            androidx.compose.foundation.gestures.AbstractDraggableNode r2 = (androidx.compose.foundation.gestures.AbstractDraggableNode) r2
            kotlin.ResultKt.throwOnFailure(r12)
            r8 = r11
            r11 = r10
            r10 = r8
            goto L_0x006b
        L_0x0049:
            kotlin.ResultKt.throwOnFailure(r12)
            androidx.compose.foundation.interaction.DragInteraction$Start r12 = r9.dragInteraction
            if (r12 == 0) goto L_0x006e
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r9.interactionSource
            if (r2 == 0) goto L_0x006a
            androidx.compose.foundation.interaction.DragInteraction$Stop r6 = new androidx.compose.foundation.interaction.DragInteraction$Stop
            r6.<init>(r12)
            androidx.compose.foundation.interaction.Interaction r6 = (androidx.compose.foundation.interaction.Interaction) r6
            r0.L$0 = r9
            r0.L$1 = r10
            r0.L$2 = r11
            r0.label = r4
            java.lang.Object r12 = r2.emit(r6, r0)
            if (r12 != r1) goto L_0x006a
            return r1
        L_0x006a:
            r2 = r9
        L_0x006b:
            r2.dragInteraction = r5
            goto L_0x006f
        L_0x006e:
            r2 = r9
        L_0x006f:
            kotlin.jvm.functions.Function3<? super kotlinx.coroutines.CoroutineScope, ? super androidx.compose.ui.unit.Velocity, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r12 = r2.onDragStopped
            long r6 = r11.m357getVelocity9UxMQ8M()
            androidx.compose.ui.unit.Velocity r11 = androidx.compose.ui.unit.Velocity.m6846boximpl(r6)
            r0.L$0 = r5
            r0.L$1 = r5
            r0.L$2 = r5
            r0.label = r3
            java.lang.Object r10 = r12.invoke(r10, r11, r0)
            if (r10 != r1) goto L_0x0088
            return r1
        L_0x0088:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AbstractDraggableNode.processDragStop(kotlinx.coroutines.CoroutineScope, androidx.compose.foundation.gestures.DragEvent$DragStopped, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processDragCancel(kotlinx.coroutines.CoroutineScope r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.compose.foundation.gestures.AbstractDraggableNode$processDragCancel$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            androidx.compose.foundation.gestures.AbstractDraggableNode$processDragCancel$1 r0 = (androidx.compose.foundation.gestures.AbstractDraggableNode$processDragCancel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.AbstractDraggableNode$processDragCancel$1 r0 = new androidx.compose.foundation.gestures.AbstractDraggableNode$processDragCancel$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0042
            if (r2 == r4) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x007f
        L_0x002e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0036:
            java.lang.Object r9 = r0.L$1
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            java.lang.Object r2 = r0.L$0
            androidx.compose.foundation.gestures.AbstractDraggableNode r2 = (androidx.compose.foundation.gestures.AbstractDraggableNode) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0062
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r10)
            androidx.compose.foundation.interaction.DragInteraction$Start r10 = r8.dragInteraction
            if (r10 == 0) goto L_0x0065
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r8.interactionSource
            if (r2 == 0) goto L_0x0061
            androidx.compose.foundation.interaction.DragInteraction$Cancel r6 = new androidx.compose.foundation.interaction.DragInteraction$Cancel
            r6.<init>(r10)
            androidx.compose.foundation.interaction.Interaction r6 = (androidx.compose.foundation.interaction.Interaction) r6
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r10 = r2.emit(r6, r0)
            if (r10 != r1) goto L_0x0061
            return r1
        L_0x0061:
            r2 = r8
        L_0x0062:
            r2.dragInteraction = r5
            goto L_0x0066
        L_0x0065:
            r2 = r8
        L_0x0066:
            kotlin.jvm.functions.Function3<? super kotlinx.coroutines.CoroutineScope, ? super androidx.compose.ui.unit.Velocity, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r10 = r2.onDragStopped
            androidx.compose.ui.unit.Velocity$Companion r2 = androidx.compose.ui.unit.Velocity.Companion
            long r6 = r2.m6866getZero9UxMQ8M()
            androidx.compose.ui.unit.Velocity r2 = androidx.compose.ui.unit.Velocity.m6846boximpl(r6)
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r9 = r10.invoke(r9, r2, r0)
            if (r9 != r1) goto L_0x007f
            return r1
        L_0x007f:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AbstractDraggableNode.processDragCancel(kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void disposeInteractionSource() {
        DragInteraction.Start start = this.dragInteraction;
        if (start != null) {
            MutableInteractionSource mutableInteractionSource = this.interactionSource;
            if (mutableInteractionSource != null) {
                mutableInteractionSource.tryEmit(new DragInteraction.Cancel(start));
            }
            this.dragInteraction = null;
        }
    }
}
