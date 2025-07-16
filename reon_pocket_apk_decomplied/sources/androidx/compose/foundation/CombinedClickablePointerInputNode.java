package androidx.compose.foundation;

import androidx.compose.foundation.AbstractClickableNode;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\rJD\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007J\u0012\u0010\u000f\u001a\u00020\b*\u00020\u0010H@¢\u0006\u0002\u0010\u0011R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/CombinedClickablePointerInputNode;", "Landroidx/compose/foundation/AbstractClickablePointerInputNode;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "onClick", "Lkotlin/Function0;", "", "interactionData", "Landroidx/compose/foundation/AbstractClickableNode$InteractionData;", "onLongClick", "onDoubleClick", "(ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/AbstractClickableNode$InteractionData;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "update", "pointerInput", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Clickable.kt */
final class CombinedClickablePointerInputNode extends AbstractClickablePointerInputNode {
    /* access modifiers changed from: private */
    public Function0<Unit> onDoubleClick;
    /* access modifiers changed from: private */
    public Function0<Unit> onLongClick;

    public CombinedClickablePointerInputNode(boolean z, MutableInteractionSource mutableInteractionSource, Function0<Unit> function0, AbstractClickableNode.InteractionData interactionData, Function0<Unit> function02, Function0<Unit> function03) {
        super(z, mutableInteractionSource, function0, interactionData, (DefaultConstructorMarker) null);
        this.onLongClick = function02;
        this.onDoubleClick = function03;
    }

    /* access modifiers changed from: protected */
    public Object pointerInput(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        AbstractClickableNode.InteractionData interactionData = getInteractionData();
        long r1 = IntSizeKt.m6796getCenterozmzZPI(pointerInputScope.m5139getSizeYbymL2g());
        interactionData.m186setCentreOffsetk4lQ0M(OffsetKt.Offset((float) IntOffset.m6748getXimpl(r1), (float) IntOffset.m6749getYimpl(r1)));
        Object detectTapGestures = TapGestureDetectorKt.detectTapGestures(pointerInputScope, (!getEnabled() || this.onDoubleClick == null) ? null : new CombinedClickablePointerInputNode$pointerInput$2(this), (!getEnabled() || this.onLongClick == null) ? null : new CombinedClickablePointerInputNode$pointerInput$3(this), new CombinedClickablePointerInputNode$pointerInput$4(this, (Continuation<? super CombinedClickablePointerInputNode$pointerInput$4>) null), new CombinedClickablePointerInputNode$pointerInput$5(this), continuation);
        return detectTapGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectTapGestures : Unit.INSTANCE;
    }

    public final void update(boolean z, MutableInteractionSource mutableInteractionSource, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03) {
        boolean z2;
        setOnClick(function0);
        setInteractionSource(mutableInteractionSource);
        boolean z3 = true;
        boolean z4 = false;
        if (getEnabled() != z) {
            setEnabled(z);
            z2 = true;
        } else {
            z2 = false;
        }
        if ((this.onLongClick == null) != (function02 == null)) {
            z2 = true;
        }
        this.onLongClick = function02;
        boolean z5 = this.onDoubleClick == null;
        if (function03 == null) {
            z4 = true;
        }
        if (z5 == z4) {
            z3 = z2;
        }
        this.onDoubleClick = function03;
        if (z3) {
            resetPointerInputHandler();
        }
    }
}
