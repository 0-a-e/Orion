package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
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

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0005H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/material3/AnchoredDragScope;", "anchors", "Landroidx/compose/material3/DraggableAnchors;", "Landroidx/compose/material3/DrawerValue;", "latestTarget"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.DrawerState$animateTo$3", f = "NavigationDrawer.kt", i = {}, l = {246}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NavigationDrawer.kt */
final class DrawerState$animateTo$3 extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<DrawerValue>, DrawerValue, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ float $velocity;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;
    final /* synthetic */ DrawerState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DrawerState$animateTo$3(DrawerState drawerState, float f, AnimationSpec<Float> animationSpec, Continuation<? super DrawerState$animateTo$3> continuation) {
        super(4, continuation);
        this.this$0 = drawerState;
        this.$velocity = f;
        this.$animationSpec = animationSpec;
    }

    public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors<DrawerValue> draggableAnchors, DrawerValue drawerValue, Continuation<? super Unit> continuation) {
        DrawerState$animateTo$3 drawerState$animateTo$3 = new DrawerState$animateTo$3(this.this$0, this.$velocity, this.$animationSpec, continuation);
        drawerState$animateTo$3.L$0 = anchoredDragScope;
        drawerState$animateTo$3.L$1 = draggableAnchors;
        drawerState$animateTo$3.L$2 = drawerValue;
        return drawerState$animateTo$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final AnchoredDragScope anchoredDragScope = (AnchoredDragScope) this.L$0;
            float positionOf = ((DraggableAnchors) this.L$1).positionOf((DrawerValue) this.L$2);
            if (!Float.isNaN(positionOf)) {
                final Ref.FloatRef floatRef = new Ref.FloatRef();
                floatRef.element = Float.isNaN(this.this$0.getCurrentOffset()) ? 0.0f : this.this$0.getCurrentOffset();
                this.L$0 = null;
                this.L$1 = null;
                this.label = 1;
                if (SuspendAnimationKt.animate(floatRef.element, positionOf, this.$velocity, this.$animationSpec, new Function2<Float, Float, Unit>() {
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
