package androidx.compose.ui.input.pointer;

import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine", f = "SuspendingPointerInputFilter.kt", i = {0}, l = {728}, m = "withTimeout", n = {"job"}, s = {"L$0"})
/* compiled from: SuspendingPointerInputFilter.kt */
final class SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine<R> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1(SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine<R> pointerEventHandlerCoroutine, Continuation<? super SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1> continuation) {
        super(continuation);
        this.this$0 = pointerEventHandlerCoroutine;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.withTimeout(0, (Function2) null, this);
    }
}
