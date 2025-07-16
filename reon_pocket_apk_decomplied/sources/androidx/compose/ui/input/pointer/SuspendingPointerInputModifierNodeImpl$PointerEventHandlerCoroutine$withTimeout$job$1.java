package androidx.compose.ui.input.pointer;

import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1", f = "SuspendingPointerInputFilter.kt", i = {}, l = {720, 721}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SuspendingPointerInputFilter.kt */
final class SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $timeMillis;
    int label;
    final /* synthetic */ SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine<R> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1(long j, SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine<R> pointerEventHandlerCoroutine, Continuation<? super SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1> continuation) {
        super(2, continuation);
        this.$timeMillis = j;
        this.this$0 = pointerEventHandlerCoroutine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1(this.$timeMillis, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 1
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0020
            if (r1 == r5) goto L_0x001c
            if (r1 != r4) goto L_0x0014
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x003e
        L_0x0014:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x001c:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0032
        L_0x0020:
            kotlin.ResultKt.throwOnFailure(r9)
            long r6 = r8.$timeMillis
            long r6 = r6 - r2
            r9 = r8
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r8.label = r5
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r6, r9)
            if (r9 != r0) goto L_0x0032
            return r0
        L_0x0032:
            r9 = r8
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r8.label = r4
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r2, r9)
            if (r9 != r0) goto L_0x003e
            return r0
        L_0x003e:
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine<R> r9 = r8.this$0
            kotlinx.coroutines.CancellableContinuation r9 = r9.pointerAwaiter
            if (r9 == 0) goto L_0x005e
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException r0 = new androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException
            long r1 = r8.$timeMillis
            r0.<init>(r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m7042constructorimpl(r0)
            r9.resumeWith(r0)
        L_0x005e:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
