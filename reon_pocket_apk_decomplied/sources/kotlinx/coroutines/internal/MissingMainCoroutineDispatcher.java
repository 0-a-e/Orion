package kotlinx.coroutines.internal;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011H\u0016J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\fH\u0002J\u001e\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016J\b\u0010!\u001a\u00020\u0006H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\""}, d2 = {"Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "cause", "", "errorHint", "", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "immediate", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "isDispatchNeeded", "", "limitedParallelism", "Lkotlinx/coroutines/CoroutineDispatcher;", "parallelism", "", "missing", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainDispatchers.kt */
final class MissingMainCoroutineDispatcher extends MainCoroutineDispatcher implements Delay {
    private final Throwable cause;
    private final String errorHint;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MissingMainCoroutineDispatcher(Throwable th, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, (i & 2) != 0 ? null : str);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    public Object delay(long j, Continuation<? super Unit> continuation) {
        return Delay.DefaultImpls.delay(this, j, continuation);
    }

    public MissingMainCoroutineDispatcher(Throwable th, String str) {
        this.cause = th;
        this.errorHint = str;
    }

    public MainCoroutineDispatcher getImmediate() {
        return this;
    }

    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        missing();
        throw new KotlinNothingValueException();
    }

    public CoroutineDispatcher limitedParallelism(int i) {
        missing();
        throw new KotlinNothingValueException();
    }

    public DisposableHandle invokeOnTimeout(long j, Runnable runnable, CoroutineContext coroutineContext) {
        missing();
        throw new KotlinNothingValueException();
    }

    public Void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        missing();
        throw new KotlinNothingValueException();
    }

    public Void scheduleResumeAfterDelay(long j, CancellableContinuation<? super Unit> cancellableContinuation) {
        missing();
        throw new KotlinNothingValueException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001d, code lost:
        if (r1 == null) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Void missing() {
        /*
            r4 = this;
            java.lang.Throwable r0 = r4.cause
            if (r0 == 0) goto L_0x0030
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Module with the Main dispatcher had failed to initialize"
            r0.<init>(r1)
            java.lang.String r1 = r4.errorHint
            if (r1 == 0) goto L_0x001f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = ". "
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r1 != 0) goto L_0x0021
        L_0x001f:
            java.lang.String r1 = ""
        L_0x0021:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.Throwable r2 = r4.cause
            r1.<init>(r0, r2)
            throw r1
        L_0x0030:
            kotlinx.coroutines.internal.MainDispatchersKt.throwMissingMainDispatcherException()
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.MissingMainCoroutineDispatcher.missing():java.lang.Void");
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Dispatchers.Main[missing");
        if (this.cause != null) {
            str = ", cause=" + this.cause;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }
}
