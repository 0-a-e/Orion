package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J?\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162'\u0010\u0017\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0018¢\u0006\u0002\b\u001bH@¢\u0006\u0002\u0010\u001cR\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/gestures/DefaultScrollableState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "onDelta", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "isScrollInProgress", "", "()Z", "isScrollingState", "Landroidx/compose/runtime/MutableState;", "getOnDelta", "()Lkotlin/jvm/functions/Function1;", "scrollMutex", "Landroidx/compose/foundation/MutatorMutex;", "scrollScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "dispatchRawDelta", "delta", "scroll", "", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ScrollableState.kt */
final class DefaultScrollableState implements ScrollableState {
    /* access modifiers changed from: private */
    public final MutableState<Boolean> isScrollingState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final Function1<Float, Float> onDelta;
    /* access modifiers changed from: private */
    public final MutatorMutex scrollMutex = new MutatorMutex();
    /* access modifiers changed from: private */
    public final ScrollScope scrollScope = new DefaultScrollableState$scrollScope$1(this);

    public /* synthetic */ boolean getCanScrollBackward() {
        return ScrollableState.CC.$default$getCanScrollBackward(this);
    }

    public /* synthetic */ boolean getCanScrollForward() {
        return ScrollableState.CC.$default$getCanScrollForward(this);
    }

    public DefaultScrollableState(Function1<? super Float, Float> function1) {
        this.onDelta = function1;
    }

    public final Function1<Float, Float> getOnDelta() {
        return this.onDelta;
    }

    public Object scroll(MutatePriority mutatePriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new DefaultScrollableState$scroll$2(this, mutatePriority, function2, (Continuation<? super DefaultScrollableState$scroll$2>) null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public float dispatchRawDelta(float f) {
        return this.onDelta.invoke(Float.valueOf(f)).floatValue();
    }

    public boolean isScrollInProgress() {
        return this.isScrollingState.getValue().booleanValue();
    }
}
