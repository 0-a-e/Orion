package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ForEachGestureKt$awaitEachGesture$2", f = "ForEachGesture.kt", i = {0, 1, 2}, l = {104, 107, 112}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "$this$awaitPointerEventScope"}, s = {"L$0", "L$0", "L$0"})
/* compiled from: ForEachGesture.kt */
final class ForEachGestureKt$awaitEachGesture$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ CoroutineContext $currentContext;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ForEachGestureKt$awaitEachGesture$2(CoroutineContext coroutineContext, Function2<? super AwaitPointerEventScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super ForEachGestureKt$awaitEachGesture$2> continuation) {
        super(2, continuation);
        this.$currentContext = coroutineContext;
        this.$block = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ForEachGestureKt$awaitEachGesture$2 forEachGestureKt$awaitEachGesture$2 = new ForEachGestureKt$awaitEachGesture$2(this.$currentContext, this.$block, continuation);
        forEachGestureKt$awaitEachGesture$2.L$0 = obj;
        return forEachGestureKt$awaitEachGesture$2;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((ForEachGestureKt$awaitEachGesture$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0043 A[SYNTHETIC, Splitter:B:19:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005e A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0034
            if (r1 == r4) goto L_0x002a
            if (r1 == r3) goto L_0x0021
            if (r1 != r2) goto L_0x0019
            java.lang.Object r1 = r7.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0028
        L_0x0019:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0021:
            java.lang.Object r1 = r7.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ CancellationException -> 0x0032 }
        L_0x0028:
            r8 = r1
            goto L_0x003b
        L_0x002a:
            java.lang.Object r1 = r7.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ CancellationException -> 0x0032 }
            goto L_0x0051
        L_0x0032:
            r8 = move-exception
            goto L_0x0063
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
        L_0x003b:
            kotlin.coroutines.CoroutineContext r1 = r7.$currentContext
            boolean r1 = kotlinx.coroutines.JobKt.isActive(r1)
            if (r1 == 0) goto L_0x007a
            kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r1 = r7.$block     // Catch:{ CancellationException -> 0x005f }
            r7.L$0 = r8     // Catch:{ CancellationException -> 0x005f }
            r7.label = r4     // Catch:{ CancellationException -> 0x005f }
            java.lang.Object r1 = r1.invoke(r8, r7)     // Catch:{ CancellationException -> 0x005f }
            if (r1 != r0) goto L_0x0050
            return r0
        L_0x0050:
            r1 = r8
        L_0x0051:
            r8 = r7
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8     // Catch:{ CancellationException -> 0x0032 }
            r7.L$0 = r1     // Catch:{ CancellationException -> 0x0032 }
            r7.label = r3     // Catch:{ CancellationException -> 0x0032 }
            java.lang.Object r8 = androidx.compose.foundation.gestures.ForEachGestureKt.awaitAllPointersUp((androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r8)     // Catch:{ CancellationException -> 0x0032 }
            if (r8 != r0) goto L_0x0028
            return r0
        L_0x005f:
            r1 = move-exception
            r6 = r1
            r1 = r8
            r8 = r6
        L_0x0063:
            kotlin.coroutines.CoroutineContext r5 = r7.$currentContext
            boolean r5 = kotlinx.coroutines.JobKt.isActive(r5)
            if (r5 == 0) goto L_0x0079
            r8 = r7
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r7.L$0 = r1
            r7.label = r2
            java.lang.Object r8 = androidx.compose.foundation.gestures.ForEachGestureKt.awaitAllPointersUp((androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r8)
            if (r8 != r0) goto L_0x0028
            return r0
        L_0x0079:
            throw r8
        L_0x007a:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ForEachGestureKt$awaitEachGesture$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
