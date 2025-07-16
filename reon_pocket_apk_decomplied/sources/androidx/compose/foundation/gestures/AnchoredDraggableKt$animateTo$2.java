package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.SuspendAnimationKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H@"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "anchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "latestTarget"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$animateTo$2", f = "AnchoredDraggable.kt", i = {}, l = {687}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AnchoredDraggable.kt */
final class AnchoredDraggableKt$animateTo$2 extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnchoredDraggableState<T> $this_animateTo;
    final /* synthetic */ float $velocity;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnchoredDraggableKt$animateTo$2(AnchoredDraggableState<T> anchoredDraggableState, float f, Continuation<? super AnchoredDraggableKt$animateTo$2> continuation) {
        super(4, continuation);
        this.$this_animateTo = anchoredDraggableState;
        this.$velocity = f;
    }

    public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors<T> draggableAnchors, T t, Continuation<? super Unit> continuation) {
        AnchoredDraggableKt$animateTo$2 anchoredDraggableKt$animateTo$2 = new AnchoredDraggableKt$animateTo$2(this.$this_animateTo, this.$velocity, continuation);
        anchoredDraggableKt$animateTo$2.L$0 = anchoredDragScope;
        anchoredDraggableKt$animateTo$2.L$1 = draggableAnchors;
        anchoredDraggableKt$animateTo$2.L$2 = t;
        return anchoredDraggableKt$animateTo$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final AnchoredDragScope anchoredDragScope = (AnchoredDragScope) this.L$0;
            float positionOf = ((DraggableAnchors) this.L$1).positionOf(this.L$2);
            if (!Float.isNaN(positionOf)) {
                final Ref.FloatRef floatRef = new Ref.FloatRef();
                floatRef.element = Float.isNaN(this.$this_animateTo.getOffset()) ? 0.0f : this.$this_animateTo.getOffset();
                this.L$0 = null;
                this.L$1 = null;
                this.label = 1;
                if (SuspendAnimationKt.animate(floatRef.element, positionOf, this.$velocity, this.$this_animateTo.getAnimationSpec(), new Function2<Float, Float, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke(((Number) obj).floatValue(), ((Number) obj2).floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f, float f2) {
                        anchoredDragScope.dragTo(f, f2);
                        floatRef.element = f;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
