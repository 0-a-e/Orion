package androidx.compose.material3;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.BasicTooltip_androidKt$handleGestures$1", f = "BasicTooltip.android.kt", i = {}, l = {156}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BasicTooltip.android.kt */
final class BasicTooltip_androidKt$handleGestures$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BasicTooltipState $state;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicTooltip_androidKt$handleGestures$1(BasicTooltipState basicTooltipState, Continuation<? super BasicTooltip_androidKt$handleGestures$1> continuation) {
        super(2, continuation);
        this.$state = basicTooltipState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BasicTooltip_androidKt$handleGestures$1 basicTooltip_androidKt$handleGestures$1 = new BasicTooltip_androidKt$handleGestures$1(this.$state, continuation);
        basicTooltip_androidKt$handleGestures$1.L$0 = obj;
        return basicTooltip_androidKt$handleGestures$1;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((BasicTooltip_androidKt$handleGestures$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.BasicTooltip_androidKt$handleGestures$1$1", f = "BasicTooltip.android.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.BasicTooltip_androidKt$handleGestures$1$1  reason: invalid class name */
    /* compiled from: BasicTooltip.android.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(pointerInputScope, basicTooltipState, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                PointerInputScope pointerInputScope = pointerInputScope;
                final BasicTooltipState basicTooltipState = basicTooltipState;
                this.label = 1;
                if (ForEachGestureKt.awaitEachGesture(pointerInputScope, new Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                    long J$0;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    int label;

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass1 r0 = 

                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                final PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                                final BasicTooltipState basicTooltipState = this.$state;
                                this.label = 1;
                                if (CoroutineScopeKt.coroutineScope(new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
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
