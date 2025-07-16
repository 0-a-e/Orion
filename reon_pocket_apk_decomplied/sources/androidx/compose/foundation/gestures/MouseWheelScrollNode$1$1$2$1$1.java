package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollNode$1$1$2$1$1", f = "Scrollable.kt", i = {}, l = {684}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Scrollable.kt */
final class MouseWheelScrollNode$1$1$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $scrollAmount;
    final /* synthetic */ ScrollingLogic $this_with;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MouseWheelScrollNode$1$1$2$1$1(ScrollingLogic scrollingLogic, long j, Continuation<? super MouseWheelScrollNode$1$1$2$1$1> continuation) {
        super(2, continuation);
        this.$this_with = scrollingLogic;
        this.$scrollAmount = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MouseWheelScrollNode$1$1$2$1$1(this.$this_with, this.$scrollAmount, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MouseWheelScrollNode$1$1$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollNode$1$1$2$1$1$1", f = "Scrollable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.gestures.MouseWheelScrollNode$1$1$2$1$1$1  reason: invalid class name */
    /* compiled from: Scrollable.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(scrollingLogic, j, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                scrollingLogic.m465dispatchScroll3eAAhYA((ScrollScope) this.L$0, j, NestedScrollSource.Companion.m5008getWheelWNlRxjI());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ScrollableState scrollableState = this.$this_with.getScrollableState();
            MutatePriority mutatePriority = MutatePriority.UserInput;
            final ScrollingLogic scrollingLogic = this.$this_with;
            final long j = this.$scrollAmount;
            this.label = 1;
            if (scrollableState.scroll(mutatePriority, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
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
