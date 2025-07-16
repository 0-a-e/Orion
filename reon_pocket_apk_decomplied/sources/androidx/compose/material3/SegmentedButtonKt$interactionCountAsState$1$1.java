package androidx.compose.material3;

import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.MutableIntState;
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
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SegmentedButtonKt$interactionCountAsState$1$1", f = "SegmentedButton.kt", i = {}, l = {402}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SegmentedButton.kt */
final class SegmentedButtonKt$interactionCountAsState$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableIntState $interactionCount;
    final /* synthetic */ InteractionSource $this_interactionCountAsState;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SegmentedButtonKt$interactionCountAsState$1$1(InteractionSource interactionSource, MutableIntState mutableIntState, Continuation<? super SegmentedButtonKt$interactionCountAsState$1$1> continuation) {
        super(2, continuation);
        this.$this_interactionCountAsState = interactionSource;
        this.$interactionCount = mutableIntState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SegmentedButtonKt$interactionCountAsState$1$1(this.$this_interactionCountAsState, this.$interactionCount, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SegmentedButtonKt$interactionCountAsState$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<Interaction> interactions = this.$this_interactionCountAsState.getInteractions();
            final MutableIntState mutableIntState = this.$interactionCount;
            this.label = 1;
            if (interactions.collect(new FlowCollector() {
                public final Object emit(Interaction interaction, Continuation<? super Unit> continuation) {
                    boolean z;
                    boolean z2;
                    boolean z3 = true;
                    if (interaction instanceof PressInteraction.Press) {
                        z = true;
                    } else {
                        z = interaction instanceof FocusInteraction.Focus;
                    }
                    if (z) {
                        MutableIntState mutableIntState = mutableIntState;
                        mutableIntState.setIntValue(mutableIntState.getIntValue() + 1);
                    } else {
                        if (interaction instanceof PressInteraction.Release) {
                            z2 = true;
                        } else {
                            z2 = interaction instanceof FocusInteraction.Unfocus;
                        }
                        if (!z2) {
                            z3 = interaction instanceof PressInteraction.Cancel;
                        }
                        if (z3) {
                            MutableIntState mutableIntState2 = mutableIntState;
                            mutableIntState2.setIntValue(mutableIntState2.getIntValue() - 1);
                        }
                    }
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
