package androidx.compose.foundation.text2.input.internal;

import androidx.compose.foundation.text2.input.TextFieldCharSequence;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text2.input.internal.TextFieldCoreModifierNode$updateNode$2", f = "TextFieldCoreModifier.kt", i = {}, l = {226}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TextFieldCoreModifier.kt */
final class TextFieldCoreModifierNode$updateNode$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TransformedTextFieldState $textFieldState;
    int label;
    final /* synthetic */ TextFieldCoreModifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldCoreModifierNode$updateNode$2(TransformedTextFieldState transformedTextFieldState, TextFieldCoreModifierNode textFieldCoreModifierNode, Continuation<? super TextFieldCoreModifierNode$updateNode$2> continuation) {
        super(2, continuation);
        this.$textFieldState = transformedTextFieldState;
        this.this$0 = textFieldCoreModifierNode;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TextFieldCoreModifierNode$updateNode$2(this.$textFieldState, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TextFieldCoreModifierNode$updateNode$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final TransformedTextFieldState transformedTextFieldState = this.$textFieldState;
            final TextFieldCoreModifierNode textFieldCoreModifierNode = this.this$0;
            this.label = 1;
            if (BuildersKt.withContext(FixedMotionDurationScale.INSTANCE, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text2.input.internal.TextFieldCoreModifierNode$updateNode$2$1", f = "TextFieldCoreModifier.kt", i = {}, l = {228}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.text2.input.internal.TextFieldCoreModifierNode$updateNode$2$1  reason: invalid class name */
    /* compiled from: TextFieldCoreModifier.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(transformedTextFieldState, textFieldCoreModifierNode, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final TransformedTextFieldState transformedTextFieldState = transformedTextFieldState;
                Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<TextFieldCharSequence>() {
                    public final TextFieldCharSequence invoke() {
                        return transformedTextFieldState.getText();
                    }
                });
                final TextFieldCoreModifierNode textFieldCoreModifierNode = textFieldCoreModifierNode;
                this.label = 1;
                if (FlowKt.collectLatest(snapshotFlow, new Function2<TextFieldCharSequence, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass2>) null) {
                    int label;

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return 
                    }
