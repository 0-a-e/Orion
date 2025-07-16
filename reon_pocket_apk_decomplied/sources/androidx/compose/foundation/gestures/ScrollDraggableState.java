package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J?\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152'\u0010\u0016\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017¢\u0006\u0002\b\u001aH@¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0012H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0005¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollDraggableState;", "Landroidx/compose/foundation/gestures/DraggableState;", "Landroidx/compose/foundation/gestures/DragScope;", "scrollLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "(Landroidx/compose/foundation/gestures/ScrollingLogic;)V", "latestScrollScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "getLatestScrollScope", "()Landroidx/compose/foundation/gestures/ScrollScope;", "setLatestScrollScope", "(Landroidx/compose/foundation/gestures/ScrollScope;)V", "getScrollLogic", "()Landroidx/compose/foundation/gestures/ScrollingLogic;", "setScrollLogic", "dispatchRawDelta", "", "delta", "", "drag", "dragPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dragBy", "pixels", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scrollable.kt */
final class ScrollDraggableState implements DraggableState, DragScope {
    private ScrollScope latestScrollScope = ScrollableKt.NoOpScrollScope;
    private ScrollingLogic scrollLogic;

    public ScrollDraggableState(ScrollingLogic scrollingLogic) {
        this.scrollLogic = scrollingLogic;
    }

    public final ScrollingLogic getScrollLogic() {
        return this.scrollLogic;
    }

    public final void setScrollLogic(ScrollingLogic scrollingLogic) {
        this.scrollLogic = scrollingLogic;
    }

    public final ScrollScope getLatestScrollScope() {
        return this.latestScrollScope;
    }

    public final void setLatestScrollScope(ScrollScope scrollScope) {
        this.latestScrollScope = scrollScope;
    }

    public void dragBy(float f) {
        ScrollingLogic scrollingLogic = this.scrollLogic;
        scrollingLogic.m465dispatchScroll3eAAhYA(this.latestScrollScope, scrollingLogic.m474toOffsettuRUvjQ(f), NestedScrollSource.Companion.m5005getDragWNlRxjI());
    }

    public Object drag(MutatePriority mutatePriority, Function2<? super DragScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object scroll = this.scrollLogic.getScrollableState().scroll(mutatePriority, new ScrollDraggableState$drag$2(this, function2, (Continuation<? super ScrollDraggableState$drag$2>) null), continuation);
        return scroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll : Unit.INSTANCE;
    }

    public void dispatchRawDelta(float f) {
        ScrollingLogic scrollingLogic = this.scrollLogic;
        scrollingLogic.m468performRawScrollMKHz9U(scrollingLogic.m474toOffsettuRUvjQ(f));
    }
}
