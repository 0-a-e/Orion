package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.ProduceStateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00040\u0003H@"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/runtime/ProduceStateScope;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1", f = "AnimatedVisibility.kt", i = {}, l = {803}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AnimatedVisibility.kt */
final class AnimatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1 extends SuspendLambda implements Function2<ProduceStateScope<Boolean>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Transition<EnterExitState> $childTransition;
    final /* synthetic */ State<Function2<EnterExitState, EnterExitState, Boolean>> $shouldDisposeBlockUpdated$delegate;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnimatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1(Transition<EnterExitState> transition, State<? extends Function2<? super EnterExitState, ? super EnterExitState, Boolean>> state, Continuation<? super AnimatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1> continuation) {
        super(2, continuation);
        this.$childTransition = transition;
        this.$shouldDisposeBlockUpdated$delegate = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AnimatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1 animatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1 = new AnimatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1(this.$childTransition, this.$shouldDisposeBlockUpdated$delegate, continuation);
        animatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1.L$0 = obj;
        return animatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1;
    }

    public final Object invoke(ProduceStateScope<Boolean> produceStateScope, Continuation<? super Unit> continuation) {
        return ((AnimatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1) create(produceStateScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ProduceStateScope produceStateScope = (ProduceStateScope) this.L$0;
            final Transition<EnterExitState> transition = this.$childTransition;
            Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<Boolean>() {
                public final Boolean invoke() {
                    return Boolean.valueOf(AnimatedVisibilityKt.getExitFinished(transition));
                }
            });
            final Transition<EnterExitState> transition2 = this.$childTransition;
            final State<Function2<EnterExitState, EnterExitState, Boolean>> state = this.$shouldDisposeBlockUpdated$delegate;
            this.label = 1;
            if (snapshotFlow.collect(new FlowCollector() {
                public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                    return emit(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) continuation);
                }

                public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                    produceStateScope.setValue(Boxing.boxBoolean(z ? ((Boolean) AnimatedVisibilityKt.AnimatedEnterExitImpl$lambda$4(state).invoke(transition2.getCurrentState(), transition2.getTargetState())).booleanValue() : false));
                    return Unit.INSTANCE;
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
