package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.TextInputService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2", f = "CoreTextField.kt", i = {}, l = {348}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CoreTextField.kt */
final class CoreTextFieldKt$CoreTextField$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ImeOptions $imeOptions;
    final /* synthetic */ TextFieldSelectionManager $manager;
    final /* synthetic */ TextFieldState $state;
    final /* synthetic */ TextInputService $textInputService;
    final /* synthetic */ State<Boolean> $writeable$delegate;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$2(TextFieldState textFieldState, State<Boolean> state, TextInputService textInputService, TextFieldSelectionManager textFieldSelectionManager, ImeOptions imeOptions, Continuation<? super CoreTextFieldKt$CoreTextField$2> continuation) {
        super(2, continuation);
        this.$state = textFieldState;
        this.$writeable$delegate = state;
        this.$textInputService = textInputService;
        this.$manager = textFieldSelectionManager;
        this.$imeOptions = imeOptions;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoreTextFieldKt$CoreTextField$2(this.$state, this.$writeable$delegate, this.$textInputService, this.$manager, this.$imeOptions, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoreTextFieldKt$CoreTextField$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final State<Boolean> state = this.$writeable$delegate;
            Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<Boolean>() {
                public final Boolean invoke() {
                    return Boolean.valueOf(CoreTextFieldKt.CoreTextField$lambda$8(state));
                }
            });
            final TextFieldState textFieldState = this.$state;
            final TextInputService textInputService = this.$textInputService;
            final TextFieldSelectionManager textFieldSelectionManager = this.$manager;
            final ImeOptions imeOptions = this.$imeOptions;
            this.label = 1;
            if (snapshotFlow.collect(new FlowCollector() {
                public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                    return emit(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) continuation);
                }

                public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                    if (!z || !textFieldState.getHasFocus()) {
                        CoreTextFieldKt.endInputSession(textFieldState);
                    } else {
                        CoreTextFieldKt.startInputSession(textInputService, textFieldState, textFieldSelectionManager.getValue$foundation_release(), imeOptions, textFieldSelectionManager.getOffsetMapping$foundation_release());
                    }
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                CoreTextFieldKt.endInputSession(this.$state);
                throw th;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        CoreTextFieldKt.endInputSession(this.$state);
        return Unit.INSTANCE;
    }
}
