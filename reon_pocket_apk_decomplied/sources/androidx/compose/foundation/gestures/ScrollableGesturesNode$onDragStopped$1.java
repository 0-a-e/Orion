package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "velocity", "Landroidx/compose/ui/unit/Velocity;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableGesturesNode$onDragStopped$1", f = "Scrollable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Scrollable.kt */
final class ScrollableGesturesNode$onDragStopped$1 extends SuspendLambda implements Function3<CoroutineScope, Velocity, Continuation<? super Unit>, Object> {
    /* synthetic */ long J$0;
    int label;
    final /* synthetic */ ScrollableGesturesNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollableGesturesNode$onDragStopped$1(ScrollableGesturesNode scrollableGesturesNode, Continuation<? super ScrollableGesturesNode$onDragStopped$1> continuation) {
        super(3, continuation);
        this.this$0 = scrollableGesturesNode;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m445invokeLuvzFrg((CoroutineScope) obj, ((Velocity) obj2).m6864unboximpl(), (Continuation) obj3);
    }

    /* renamed from: invoke-LuvzFrg  reason: not valid java name */
    public final Object m445invokeLuvzFrg(CoroutineScope coroutineScope, long j, Continuation<? super Unit> continuation) {
        ScrollableGesturesNode$onDragStopped$1 scrollableGesturesNode$onDragStopped$1 = new ScrollableGesturesNode$onDragStopped$1(this.this$0, continuation);
        scrollableGesturesNode$onDragStopped$1.J$0 = j;
        return scrollableGesturesNode$onDragStopped$1.invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableGesturesNode$onDragStopped$1$1", f = "Scrollable.kt", i = {}, l = {612}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.gestures.ScrollableGesturesNode$onDragStopped$1$1  reason: invalid class name */
    /* compiled from: Scrollable.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(scrollableGesturesNode, j, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (scrollableGesturesNode.getScrollLogic().m467onDragStoppedsFctU(j, this) == coroutine_suspended) {
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

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            final long j = this.J$0;
            CoroutineScope coroutineScope = this.this$0.getNestedScrollDispatcher().getCoroutineScope();
            final ScrollableGesturesNode scrollableGesturesNode = this.this$0;
            Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
