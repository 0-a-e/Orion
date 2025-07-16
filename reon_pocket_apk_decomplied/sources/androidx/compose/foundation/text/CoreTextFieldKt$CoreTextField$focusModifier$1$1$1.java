package androidx.compose.foundation.text;

import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
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
@DebugMetadata(c = "androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1$1$1", f = "CoreTextField.kt", i = {}, l = {330}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CoreTextField.kt */
final class CoreTextFieldKt$CoreTextField$focusModifier$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
    final /* synthetic */ TextLayoutResultProxy $layoutResult;
    final /* synthetic */ OffsetMapping $offsetMapping;
    final /* synthetic */ TextFieldState $state;
    final /* synthetic */ TextFieldValue $value;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$focusModifier$1$1$1(BringIntoViewRequester bringIntoViewRequester, TextFieldValue textFieldValue, TextFieldState textFieldState, TextLayoutResultProxy textLayoutResultProxy, OffsetMapping offsetMapping, Continuation<? super CoreTextFieldKt$CoreTextField$focusModifier$1$1$1> continuation) {
        super(2, continuation);
        this.$bringIntoViewRequester = bringIntoViewRequester;
        this.$value = textFieldValue;
        this.$state = textFieldState;
        this.$layoutResult = textLayoutResultProxy;
        this.$offsetMapping = offsetMapping;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1(this.$bringIntoViewRequester, this.$value, this.$state, this.$layoutResult, this.$offsetMapping, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoreTextFieldKt$CoreTextField$focusModifier$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BringIntoViewRequester bringIntoViewRequester = this.$bringIntoViewRequester;
            TextFieldValue textFieldValue = this.$value;
            this.label = 1;
            if (CoreTextFieldKt.bringSelectionEndIntoView(bringIntoViewRequester, textFieldValue, this.$state.getTextDelegate(), this.$layoutResult.getValue(), this.$offsetMapping, this) == coroutine_suspended) {
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
