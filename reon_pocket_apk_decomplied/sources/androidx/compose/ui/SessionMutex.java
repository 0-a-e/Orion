package androidx.compose.ui;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

@JvmInline
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001'B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B1\b\u0002\u0012&\u0010\u0005\u001a\"\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00070\u0006j\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007`\b¢\u0006\u0004\b\u0003\u0010\tJ\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J]\u0010\u001a\u001a\u0002H\u001b\"\u0004\b\u0001\u0010\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00028\u00000\u001d21\u0010\u001f\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0$\u0012\u0006\u0012\u0004\u0018\u00010\u00020 H@¢\u0006\u0004\b%\u0010&R\u0013\u0010\n\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR.\u0010\u0005\u001a\"\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00070\u0006j\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007`\bX\u0004¢\u0006\u0002\n\u0000\u0001\u0005\u0001\"\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u00070\u0006j\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u0007`\b¨\u0006("}, d2 = {"Landroidx/compose/ui/SessionMutex;", "T", "", "constructor-impl", "()Ljava/util/concurrent/atomic/AtomicReference;", "currentSessionHolder", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/ui/SessionMutex$Session;", "Landroidx/compose/ui/AtomicReference;", "(Ljava/util/concurrent/atomic/AtomicReference;)Ljava/util/concurrent/atomic/AtomicReference;", "currentSession", "getCurrentSession-impl", "(Ljava/util/concurrent/atomic/AtomicReference;)Ljava/lang/Object;", "equals", "", "other", "equals-impl", "(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/util/concurrent/atomic/AtomicReference;)I", "toString", "", "toString-impl", "(Ljava/util/concurrent/atomic/AtomicReference;)Ljava/lang/String;", "withSessionCancellingPrevious", "R", "sessionInitializer", "Lkotlin/Function1;", "Lkotlinx/coroutines/CoroutineScope;", "session", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "data", "Lkotlin/coroutines/Continuation;", "withSessionCancellingPrevious-impl", "(Ljava/util/concurrent/atomic/AtomicReference;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Session", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SessionMutex.kt */
public final class SessionMutex<T> {
    private final AtomicReference<Session<T>> currentSessionHolder;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ SessionMutex m3421boximpl(AtomicReference atomicReference) {
        return new SessionMutex(atomicReference);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static <T> AtomicReference<Session<T>> m3423constructorimpl(AtomicReference<Session<T>> atomicReference) {
        return atomicReference;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3424equalsimpl(AtomicReference<Session<T>> atomicReference, Object obj) {
        return (obj instanceof SessionMutex) && Intrinsics.areEqual((Object) atomicReference, (Object) ((SessionMutex) obj).m3430unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3425equalsimpl0(AtomicReference<Session<T>> atomicReference, AtomicReference<Session<T>> atomicReference2) {
        return Intrinsics.areEqual((Object) atomicReference, (Object) atomicReference2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3427hashCodeimpl(AtomicReference<Session<T>> atomicReference) {
        return atomicReference.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3428toStringimpl(AtomicReference<Session<T>> atomicReference) {
        return "SessionMutex(currentSessionHolder=" + atomicReference + ')';
    }

    public boolean equals(Object obj) {
        return m3424equalsimpl(this.currentSessionHolder, obj);
    }

    public int hashCode() {
        return m3427hashCodeimpl(this.currentSessionHolder);
    }

    public String toString() {
        return m3428toStringimpl(this.currentSessionHolder);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ AtomicReference m3430unboximpl() {
        return this.currentSessionHolder;
    }

    private /* synthetic */ SessionMutex(AtomicReference atomicReference) {
        this.currentSessionHolder = atomicReference;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static <T> AtomicReference<Session<T>> m3422constructorimpl() {
        return m3423constructorimpl(new AtomicReference((Object) null));
    }

    /* renamed from: getCurrentSession-impl  reason: not valid java name */
    public static final T m3426getCurrentSessionimpl(AtomicReference<Session<T>> atomicReference) {
        Session session = atomicReference.get();
        if (session != null) {
            return session.getValue();
        }
        return null;
    }

    /* renamed from: withSessionCancellingPrevious-impl  reason: not valid java name */
    public static final <R> Object m3429withSessionCancellingPreviousimpl(AtomicReference<Session<T>> atomicReference, Function1<? super CoroutineScope, ? extends T> function1, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        return CoroutineScopeKt.coroutineScope(new SessionMutex$withSessionCancellingPrevious$2(function1, atomicReference, function2, (Continuation<? super SessionMutex$withSessionCancellingPrevious$2>) null), continuation);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Landroidx/compose/ui/SessionMutex$Session;", "T", "", "job", "Lkotlinx/coroutines/Job;", "value", "(Lkotlinx/coroutines/Job;Ljava/lang/Object;)V", "getJob", "()Lkotlinx/coroutines/Job;", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SessionMutex.kt */
    private static final class Session<T> {
        private final Job job;
        private final T value;

        public Session(Job job2, T t) {
            this.job = job2;
            this.value = t;
        }

        public final Job getJob() {
            return this.job;
        }

        public final T getValue() {
            return this.value;
        }
    }
}
