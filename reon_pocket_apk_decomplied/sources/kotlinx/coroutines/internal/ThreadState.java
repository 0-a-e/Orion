package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t0\bX\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bX\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/internal/ThreadState;", "", "context", "Lkotlin/coroutines/CoroutineContext;", "n", "", "(Lkotlin/coroutines/CoroutineContext;I)V", "elements", "", "Lkotlinx/coroutines/ThreadContextElement;", "[Lkotlinx/coroutines/ThreadContextElement;", "i", "values", "[Ljava/lang/Object;", "append", "", "element", "value", "restore", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ThreadContext.kt */
final class ThreadState {
    public final CoroutineContext context;
    private final ThreadContextElement<Object>[] elements;
    private int i;
    private final Object[] values;

    public ThreadState(CoroutineContext coroutineContext, int i2) {
        this.context = coroutineContext;
        this.values = new Object[i2];
        this.elements = new ThreadContextElement[i2];
    }

    public final void append(ThreadContextElement<?> threadContextElement, Object obj) {
        Object[] objArr = this.values;
        int i2 = this.i;
        objArr[i2] = obj;
        ThreadContextElement<Object>[] threadContextElementArr = this.elements;
        this.i = i2 + 1;
        Intrinsics.checkNotNull(threadContextElement, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        threadContextElementArr[i2] = threadContextElement;
    }

    public final void restore(CoroutineContext coroutineContext) {
        int length = this.elements.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                ThreadContextElement<Object> threadContextElement = this.elements[length];
                Intrinsics.checkNotNull(threadContextElement);
                threadContextElement.restoreThreadContext(coroutineContext, this.values[length]);
                if (i2 >= 0) {
                    length = i2;
                } else {
                    return;
                }
            }
        }
    }
}
