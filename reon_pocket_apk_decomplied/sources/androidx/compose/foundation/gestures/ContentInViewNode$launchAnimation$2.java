package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ContentInViewNode;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.ui.geometry.Rect;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2", f = "ContentInViewNode.kt", i = {}, l = {190}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ContentInViewNode.kt */
final class ContentInViewNode$launchAnimation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ContentInViewNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContentInViewNode$launchAnimation$2(ContentInViewNode contentInViewNode, Continuation<? super ContentInViewNode$launchAnimation$2> continuation) {
        super(2, continuation);
        this.this$0 = contentInViewNode;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ContentInViewNode$launchAnimation$2 contentInViewNode$launchAnimation$2 = new ContentInViewNode$launchAnimation$2(this.this$0, continuation);
        contentInViewNode$launchAnimation$2.L$0 = obj;
        return contentInViewNode$launchAnimation$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ContentInViewNode$launchAnimation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CancellationException cancellationException;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final Job job = JobKt.getJob(((CoroutineScope) this.L$0).getCoroutineContext());
            this.this$0.isAnimationRunning = true;
            ScrollableState access$getScrollState$p = this.this$0.scrollState;
            final ContentInViewNode contentInViewNode = this.this$0;
            this.label = 1;
            if (ScrollableState.CC.scroll$default(access$getScrollState$p, (MutatePriority) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this, 1, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (CancellationException e) {
                cancellationException = e;
                throw cancellationException;
            } catch (Throwable th) {
                this.this$0.isAnimationRunning = false;
                this.this$0.bringIntoViewRequests.cancelAndRemoveAll(cancellationException);
                this.this$0.trackingFocusedChild = false;
                throw th;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.bringIntoViewRequests.resumeAndRemoveAll();
        this.this$0.isAnimationRunning = false;
        this.this$0.bringIntoViewRequests.cancelAndRemoveAll((Throwable) null);
        this.this$0.trackingFocusedChild = false;
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2$1", f = "ContentInViewNode.kt", i = {}, l = {195}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2$1  reason: invalid class name */
    /* compiled from: ContentInViewNode.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(contentInViewNode, job, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ScrollScope scrollScope = (ScrollScope) this.L$0;
                contentInViewNode.animationState.setValue(contentInViewNode.calculateScrollDelta());
                UpdatableAnimationState access$getAnimationState$p = contentInViewNode.animationState;
                final ContentInViewNode contentInViewNode = contentInViewNode;
                final Job job = job;
                final ContentInViewNode contentInViewNode2 = contentInViewNode;
                this.label = 1;
                if (access$getAnimationState$p.animateToZero(new Function1<Float, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke(((Number) obj).floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f) {
                        float f2 = contentInViewNode.reverseDirection ? 1.0f : -1.0f;
                        float scrollBy = f2 * scrollScope.scrollBy(f2 * f);
                        if (Math.abs(scrollBy) < Math.abs(f)) {
                            Job job = job;
                            JobKt__JobKt.cancel$default(job, "Scroll animation cancelled because scroll was not consumed (" + scrollBy + " < " + f + ')', (Throwable) null, 2, (Object) null);
                        }
                    }
                }, new Function0<Unit>() {
                    public final void invoke() {
                        boolean z;
                        BringIntoViewRequestPriorityQueue access$getBringIntoViewRequests$p = contentInViewNode2.bringIntoViewRequests;
                        ContentInViewNode contentInViewNode = contentInViewNode2;
                        while (true) {
                            z = true;
                            if (access$getBringIntoViewRequests$p.requests.isNotEmpty()) {
                                Rect invoke = ((ContentInViewNode.Request) access$getBringIntoViewRequests$p.requests.last()).getCurrentBounds().invoke();
                                if (!(invoke == null ? true : ContentInViewNode.m347isMaxVisibleO0kMr_c$default(contentInViewNode, invoke, 0, 1, (Object) null))) {
                                    break;
                                }
                                Unit unit = Unit.INSTANCE;
                                Result.Companion companion = Result.Companion;
                                ((ContentInViewNode.Request) access$getBringIntoViewRequests$p.requests.removeAt(access$getBringIntoViewRequests$p.requests.getSize() - 1)).getContinuation().resumeWith(Result.m7042constructorimpl(unit));
                            } else {
                                break;
                            }
                        }
                        if (contentInViewNode2.trackingFocusedChild) {
                            Rect access$getFocusedChildBounds = contentInViewNode2.getFocusedChildBounds();
                            if (access$getFocusedChildBounds == null || !ContentInViewNode.m347isMaxVisibleO0kMr_c$default(contentInViewNode2, access$getFocusedChildBounds, 0, 1, (Object) null)) {
                                z = false;
                            }
                            if (z) {
                                contentInViewNode2.trackingFocusedChild = false;
                            }
                        }
                        contentInViewNode2.animationState.setValue(contentInViewNode2.calculateScrollDelta());
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
}
