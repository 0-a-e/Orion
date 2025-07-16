package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.pager.PagerState$animateScrollToPage$3$1", f = "PagerState.kt", i = {}, l = {552}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PagerState.kt */
final class PagerState$animateScrollToPage$3$1 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ int $targetPage;
    final /* synthetic */ int $targetPageOffsetToSnappedPosition;
    final /* synthetic */ LazyLayoutAnimateScrollScope $this_with;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PagerState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PagerState$animateScrollToPage$3$1(PagerState pagerState, int i, LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, int i2, AnimationSpec<Float> animationSpec, Continuation<? super PagerState$animateScrollToPage$3$1> continuation) {
        super(2, continuation);
        this.this$0 = pagerState;
        this.$targetPage = i;
        this.$this_with = lazyLayoutAnimateScrollScope;
        this.$targetPageOffsetToSnappedPosition = i2;
        this.$animationSpec = animationSpec;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PagerState$animateScrollToPage$3$1 pagerState$animateScrollToPage$3$1 = new PagerState$animateScrollToPage$3$1(this.this$0, this.$targetPage, this.$this_with, this.$targetPageOffsetToSnappedPosition, this.$animationSpec, continuation);
        pagerState$animateScrollToPage$3$1.L$0 = obj;
        return pagerState$animateScrollToPage$3$1;
    }

    public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
        return ((PagerState$animateScrollToPage$3$1) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        int i;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final ScrollScope scrollScope = (ScrollScope) this.L$0;
            this.this$0.updateTargetPage(scrollScope, this.$targetPage);
            boolean z = this.$targetPage > this.$this_with.getFirstVisibleItemIndex();
            int lastVisibleItemIndex = (this.$this_with.getLastVisibleItemIndex() - this.$this_with.getFirstVisibleItemIndex()) + 1;
            if (((z && this.$targetPage > this.$this_with.getLastVisibleItemIndex()) || (!z && this.$targetPage < this.$this_with.getFirstVisibleItemIndex())) && Math.abs(this.$targetPage - this.$this_with.getFirstVisibleItemIndex()) >= 3) {
                if (z) {
                    i = RangesKt.coerceAtLeast(this.$targetPage - lastVisibleItemIndex, this.$this_with.getFirstVisibleItemIndex());
                } else {
                    i = RangesKt.coerceAtMost(this.$targetPage + lastVisibleItemIndex, this.$this_with.getFirstVisibleItemIndex());
                }
                this.$this_with.snapToItem(scrollScope, i, 0);
            }
            int visibleItemsAverageSize = this.$this_with.getVisibleItemsAverageSize();
            float currentPage = ((float) (((this.$targetPage * visibleItemsAverageSize) - (this.this$0.getCurrentPage() * visibleItemsAverageSize)) + this.$targetPageOffsetToSnappedPosition)) - (((float) visibleItemsAverageSize) * this.this$0.getCurrentPageOffsetFraction());
            final Ref.FloatRef floatRef = new Ref.FloatRef();
            this.label = 1;
            if (SuspendAnimationKt.animate$default(0.0f, currentPage, 0.0f, this.$animationSpec, new Function2<Float, Float, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke(((Number) obj).floatValue(), ((Number) obj2).floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f, float f2) {
                    floatRef.element += scrollScope.scrollBy(f - floatRef.element);
                }
            }, this, 4, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
