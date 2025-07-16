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

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ$\u0010\f\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0012\u0010\r\u001a\u00020\b*\u00020\u000eH@¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/ClickablePointerInputNode;", "Landroidx/compose/foundation/AbstractClickablePointerInputNode;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "onClick", "Lkotlin/Function0;", "", "interactionData", "Landroidx/compose/foundation/AbstractClickableNode$InteractionData;", "(ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/AbstractClickableNode$InteractionData;)V", "update", "pointerInput", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Clickable.kt */
final class ClickablePointerInputNode extends AbstractClickablePointerInputNode {
    public ClickablePointerInputNode(boolean z, MutableInteractionSource mutableInteractionSource, Function0<Unit> function0, AbstractClickableNode.InteractionData interactionData) {
        super(z, mutableInteractionSource, function0, interactionData, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: protected */
    public Object pointerInput(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        AbstractClickableNode.InteractionData interactionData = getInteractionData();
        long r1 = IntSizeKt.m6796getCenterozmzZPI(pointerInputScope.m5139getSizeYbymL2g());
        interactionData.m186setCentreOffsetk4lQ0M(OffsetKt.Offset((float) IntOffset.m6748getXimpl(r1), (float) IntOffset.m6749getYimpl(r1)));
        Object detectTapAndPress = TapGestureDetectorKt.detectTapAndPress(pointerInputScope, new ClickablePointerInputNode$pointerInput$2(this, (Continuation<? super ClickablePointerInputNode$pointerInput$2>) null), new ClickablePointerInputNode$pointerInput$3(this), continuation);
        return detectTapAndPress == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectTapAndPress : Unit.INSTANCE;
    }

    public final void update(boolean z, MutableInteractionSource mutableInteractionSource, Function0<Unit> function0) {
        setEnabled(z);
        setOnClick(function0);
        setInteractionSource(mutableInteractionSource);
    }
}
