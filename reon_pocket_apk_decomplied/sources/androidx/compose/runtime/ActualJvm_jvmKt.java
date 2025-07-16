package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0000\u001a(\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00050\u000f¢\u0006\u0002\b\u0010H\u0000¢\u0006\u0002\u0010\u0011\u001a.\u0010\u0012\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u00132\u0006\u0010\f\u001a\u00020\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u0002H\u00130\u000f¢\u0006\u0002\b\u0010H\u0000¢\u0006\u0002\u0010\u0014\u001a*\u0010\u0015\u001a\u0002H\u0016\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0017\u001a\u00020\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00160\u000fH\b¢\u0006\u0002\u0010\u0019*\u001e\b\u0000\u0010\u001a\u001a\u0004\b\u0000\u0010\u001b\"\b\u0012\u0004\u0012\u0002H\u001b0\u001c2\b\u0012\u0004\u0012\u0002H\u001b0\u001c*\f\b\u0000\u0010\u001d\"\u00020\u001e2\u00020\u001e¨\u0006\u001f"}, d2 = {"currentThreadId", "", "currentThreadName", "", "ensureMutable", "", "it", "", "identityHashCode", "", "instance", "invokeComposable", "composer", "Landroidx/compose/runtime/Composer;", "composable", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/runtime/Composer;Lkotlin/jvm/functions/Function2;)V", "invokeComposableForResult", "T", "(Landroidx/compose/runtime/Composer;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "synchronized", "R", "lock", "block", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "AtomicReference", "V", "Ljava/util/concurrent/atomic/AtomicReference;", "TestOnly", "Lorg/jetbrains/annotations/TestOnly;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ActualJvm.jvm.kt */
public final class ActualJvm_jvmKt {
    public static final void ensureMutable(Object obj) {
    }

    public static final int identityHashCode(Object obj) {
        return System.identityHashCode(obj);
    }

    /* renamed from: synchronized  reason: not valid java name */
    public static final <R> R m3256synchronized(Object obj, Function0<? extends R> function0) {
        R invoke;
        synchronized (obj) {
            try {
                invoke = function0.invoke();
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        return invoke;
    }

    public static final void invokeComposable(Composer composer, Function2<? super Composer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNull(function2, "null cannot be cast to non-null type kotlin.Function2<androidx.compose.runtime.Composer, kotlin.Int, kotlin.Unit>");
        ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(composer, 1);
    }

    public static final <T> T invokeComposableForResult(Composer composer, Function2<? super Composer, ? super Integer, ? extends T> function2) {
        Intrinsics.checkNotNull(function2, "null cannot be cast to non-null type kotlin.Function2<androidx.compose.runtime.Composer, kotlin.Int, T of androidx.compose.runtime.ActualJvm_jvmKt.invokeComposableForResult>");
        return ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(composer, 1);
    }

    public static final long currentThreadId() {
        return Thread.currentThread().getId();
    }

    public static final String currentThreadName() {
        return Thread.currentThread().getName();
    }
}
