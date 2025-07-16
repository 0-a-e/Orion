package androidx.compose.foundation.gestures;

import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "I", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2", f = "AnchoredDraggable.kt", i = {}, l = {711}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AnchoredDraggable.kt */
final class AnchoredDraggableKt$restartable$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ Function0<I> $inputs;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnchoredDraggableKt$restartable$2(Function0<? extends I> function0, Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super AnchoredDraggableKt$restartable$2> continuation) {
        super(2, continuation);
        this.$inputs = function0;
        this.$block = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AnchoredDraggableKt$restartable$2 anchoredDraggableKt$restartable$2 = new AnchoredDraggableKt$restartable$2(this.$inputs, this.$block, continuation);
        anchoredDraggableKt$restartable$2.L$0 = obj;
        return anchoredDraggableKt$restartable$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnchoredDraggableKt$restartable$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Flow<T> snapshotFlow = SnapshotStateKt.snapshotFlow(this.$inputs);
            final Function2<I, Continuation<? super Unit>, Object> function2 = this.$block;
            this.label = 1;
            if (snapshotFlow.collect(new FlowCollector() {
                /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object emit(final I r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1$emit$1
                        if (r0 == 0) goto L_0x0014
                        r0 = r9
                        androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1$emit$1 r0 = (androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1$emit$1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L_0x0014
                        int r9 = r0.label
                        int r9 = r9 - r2
                        r0.label = r9
                        goto L_0x0019
                    L_0x0014:
                        androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1$emit$1 r0 = new androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1$emit$1
                        r0.<init>(r7, r9)
                    L_0x0019:
                        java.lang.Object r9 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L_0x003c
                        if (r2 != r3) goto L_0x0034
                        java.lang.Object r8 = r0.L$2
                        kotlinx.coroutines.Job r8 = (kotlinx.coroutines.Job) r8
                        java.lang.Object r8 = r0.L$1
                        java.lang.Object r0 = r0.L$0
                        androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1 r0 = (androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2.AnonymousClass1) r0
                        kotlin.ResultKt.throwOnFailure(r9)
                        goto L_0x0061
                    L_0x0034:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L_0x003c:
                        kotlin.ResultKt.throwOnFailure(r9)
                        kotlin.jvm.internal.Ref$ObjectRef<kotlinx.coroutines.Job> r9 = r1
                        T r9 = r9.element
                        kotlinx.coroutines.Job r9 = (kotlinx.coroutines.Job) r9
                        if (r9 == 0) goto L_0x0060
                        androidx.compose.foundation.gestures.AnchoredDragFinishedSignal r2 = new androidx.compose.foundation.gestures.AnchoredDragFinishedSignal
                        r2.<init>()
                        java.util.concurrent.CancellationException r2 = (java.util.concurrent.CancellationException) r2
                        r9.cancel((java.util.concurrent.CancellationException) r2)
                        r0.L$0 = r7
                        r0.L$1 = r8
                        r0.L$2 = r9
                        r0.label = r3
                        java.lang.Object r9 = r9.join(r0)
                        if (r9 != r1) goto L_0x0060
                        return r1
                    L_0x0060:
                        r0 = r7
                    L_0x0061:
                        kotlin.jvm.internal.Ref$ObjectRef<kotlinx.coroutines.Job> r9 = r1
                        kotlinx.coroutines.CoroutineScope r1 = r7
                        kotlinx.coroutines.CoroutineStart r3 = kotlinx.coroutines.CoroutineStart.UNDISPATCHED
                        androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1$2 r2 = new androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1$2
                        kotlin.jvm.functions.Function2<I, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r4 = r5
                        kotlinx.coroutines.CoroutineScope r0 = r7
                        r5 = 0
                        r2.<init>(r4, r8, r0, r5)
                        r4 = r2
                        kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
                        r5 = 1
                        r6 = 0
                        r2 = 0
                        kotlinx.coroutines.Job r8 = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r1, r2, r3, r4, r5, r6)
                        r9.element = r8
                        kotlin.Unit r8 = kotlin.Unit.INSTANCE
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
