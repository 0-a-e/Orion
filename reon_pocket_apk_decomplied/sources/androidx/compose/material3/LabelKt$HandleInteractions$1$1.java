package androidx.compose.material3;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.LabelKt$HandleInteractions$1$1", f = "Label.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Label.kt */
final class LabelKt$HandleInteractions$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ BasicTooltipState $state;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LabelKt$HandleInteractions$1$1(MutableInteractionSource mutableInteractionSource, BasicTooltipState basicTooltipState, Continuation<? super LabelKt$HandleInteractions$1$1> continuation) {
        super(2, continuation);
        this.$interactionSource = mutableInteractionSource;
        this.$state = basicTooltipState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LabelKt$HandleInteractions$1$1(this.$interactionSource, this.$state, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LabelKt$HandleInteractions$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "interaction", "Landroidx/compose/foundation/interaction/Interaction;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.LabelKt$HandleInteractions$1$1$1", f = "Label.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.LabelKt$HandleInteractions$1$1$1  reason: invalid class name */
    /* compiled from: Label.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Interaction, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(basicTooltipState, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(Interaction interaction, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(interaction, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            boolean z;
            boolean z2;
            boolean z3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            boolean z4 = true;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Interaction interaction = (Interaction) this.L$0;
                if (interaction instanceof PressInteraction.Press) {
                    z = true;
                } else {
                    z = interaction instanceof DragInteraction.Start;
                }
                if (z) {
                    z2 = true;
                } else {
                    z2 = interaction instanceof HoverInteraction.Enter;
                }
                if (z2) {
                    this.label = 1;
                    if (basicTooltipState.show(MutatePriority.UserInput, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (interaction instanceof PressInteraction.Release) {
                        z3 = true;
                    } else {
                        z3 = interaction instanceof DragInteraction.Stop;
                    }
                    if (!z3) {
                        z4 = interaction instanceof HoverInteraction.Exit;
                    }
                    if (z4) {
                        basicTooltipState.dismiss();
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

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<Interaction> interactions = this.$interactionSource.getInteractions();
            final BasicTooltipState basicTooltipState = this.$state;
            this.label = 1;
            if (FlowKt.collectLatest(interactions, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
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
