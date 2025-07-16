package androidx.compose.foundation;

import androidx.compose.foundation.AbstractClickableNode;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B/\b\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010 \u001a\u00020\u000bH\u0016J*\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\b\u0010*\u001a\u00020\u000bH\u0004J\u001f\u0010+\u001a\u00020\u000b*\u00020,2\u0006\u0010-\u001a\u00020.H@ø\u0001\u0000¢\u0006\u0004\b/\u00100J\u0012\u00101\u001a\u00020\u000b*\u000202H¤@¢\u0006\u0002\u00103R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000\u0001\u000245\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00066"}, d2 = {"Landroidx/compose/foundation/AbstractClickablePointerInputNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "onClick", "Lkotlin/Function0;", "", "interactionData", "Landroidx/compose/foundation/AbstractClickableNode$InteractionData;", "(ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/AbstractClickableNode$InteractionData;)V", "delayPressInteraction", "getEnabled", "()Z", "setEnabled", "(Z)V", "getInteractionData", "()Landroidx/compose/foundation/AbstractClickableNode$InteractionData;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "setInteractionSource", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "setOnClick", "(Lkotlin/jvm/functions/Function0;)V", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "onCancelPointerInput", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "resetPointerInputHandler", "handlePressInteraction", "Landroidx/compose/foundation/gestures/PressGestureScope;", "offset", "Landroidx/compose/ui/geometry/Offset;", "handlePressInteraction-d-4ec7I", "(Landroidx/compose/foundation/gestures/PressGestureScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pointerInput", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/foundation/ClickablePointerInputNode;", "Landroidx/compose/foundation/CombinedClickablePointerInputNode;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Clickable.kt */
abstract class AbstractClickablePointerInputNode extends DelegatingNode implements ModifierLocalModifierNode, CompositionLocalConsumerModifierNode, PointerInputModifierNode {
    private final Function0<Boolean> delayPressInteraction;
    private boolean enabled;
    private final AbstractClickableNode.InteractionData interactionData;
    private MutableInteractionSource interactionSource;
    private Function0<Unit> onClick;
    private final SuspendingPointerInputModifierNode pointerInputNode;

    public /* synthetic */ AbstractClickablePointerInputNode(boolean z, MutableInteractionSource mutableInteractionSource, Function0 function0, AbstractClickableNode.InteractionData interactionData2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, mutableInteractionSource, function0, interactionData2);
    }

    public /* synthetic */ Object getCurrent(ModifierLocal modifierLocal) {
        return ModifierLocalModifierNode.CC.$default$getCurrent(this, modifierLocal);
    }

    public /* synthetic */ ModifierLocalMap getProvidedValues() {
        return ModifierLocalModifierNode.CC.$default$getProvidedValues(this);
    }

    public /* synthetic */ boolean interceptOutOfBoundsChildEvents() {
        return PointerInputModifierNode.CC.$default$interceptOutOfBoundsChildEvents(this);
    }

    public /* synthetic */ void onDensityChange() {
        PointerInputModifierNode.CC.$default$onDensityChange(this);
    }

    public /* synthetic */ void onViewConfigurationChange() {
        PointerInputModifierNode.CC.$default$onViewConfigurationChange(this);
    }

    /* access modifiers changed from: protected */
    public abstract Object pointerInput(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation);

    public /* synthetic */ void provide(ModifierLocal modifierLocal, Object obj) {
        ModifierLocalModifierNode.CC.$default$provide(this, modifierLocal, obj);
    }

    public /* synthetic */ boolean sharePointerInputWithSiblings() {
        return PointerInputModifierNode.CC.$default$sharePointerInputWithSiblings(this);
    }

    /* access modifiers changed from: protected */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* access modifiers changed from: protected */
    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    /* access modifiers changed from: protected */
    public final MutableInteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    /* access modifiers changed from: protected */
    public final void setInteractionSource(MutableInteractionSource mutableInteractionSource) {
        this.interactionSource = mutableInteractionSource;
    }

    /* access modifiers changed from: protected */
    public final Function0<Unit> getOnClick() {
        return this.onClick;
    }

    /* access modifiers changed from: protected */
    public final void setOnClick(Function0<Unit> function0) {
        this.onClick = function0;
    }

    /* access modifiers changed from: protected */
    public final AbstractClickableNode.InteractionData getInteractionData() {
        return this.interactionData;
    }

    private AbstractClickablePointerInputNode(boolean z, MutableInteractionSource mutableInteractionSource, Function0<Unit> function0, AbstractClickableNode.InteractionData interactionData2) {
        this.enabled = z;
        this.interactionSource = mutableInteractionSource;
        this.onClick = function0;
        this.interactionData = interactionData2;
        this.delayPressInteraction = new AbstractClickablePointerInputNode$delayPressInteraction$1(this);
        this.pointerInputNode = (SuspendingPointerInputModifierNode) delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new AbstractClickablePointerInputNode$pointerInputNode$1(this, (Continuation<? super AbstractClickablePointerInputNode$pointerInputNode$1>) null)));
    }

    /* renamed from: onPointerEvent-H0pRuoY  reason: not valid java name */
    public void m188onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        this.pointerInputNode.m5707onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
    }

    public void onCancelPointerInput() {
        this.pointerInputNode.onCancelPointerInput();
    }

    /* access modifiers changed from: protected */
    /* renamed from: handlePressInteraction-d-4ec7I  reason: not valid java name */
    public final Object m187handlePressInteractiond4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
        Object r8;
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        if (mutableInteractionSource == null || (r8 = ClickableKt.m255handlePressInteractionEPk0efs(pressGestureScope, j, mutableInteractionSource, this.interactionData, this.delayPressInteraction, continuation)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return Unit.INSTANCE;
        }
        return r8;
    }

    /* access modifiers changed from: protected */
    public final void resetPointerInputHandler() {
        this.pointerInputNode.resetPointerInputHandler();
    }
}
