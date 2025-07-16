package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: Job.kt */
/* synthetic */ class JobKt__JobKt$invokeOnCompletion$1 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
    JobKt__JobKt$invokeOnCompletion$1(Object obj) {
        super(1, obj, InternalCompletionHandler.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        ((InternalCompletionHandler) this.receiver).invoke(th);
    }
}
