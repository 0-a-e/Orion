package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.AnchoredDraggableKt", f = "AnchoredDraggable.kt", i = {}, l = {732}, m = "restartable", n = {}, s = {})
/* compiled from: AnchoredDraggable.kt */
final class AnchoredDraggableKt$restartable$1<I> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    AnchoredDraggableKt$restartable$1(Continuation<? super AnchoredDraggableKt$restartable$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AnchoredDraggableKt.restartable((Function0) null, (Function2) null, this);
    }
}
