package androidx.compose.ui.platform;

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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.platform.WindowInfoKt$WindowFocusObserver$1$1", f = "WindowInfo.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: WindowInfo.kt */
final class WindowInfoKt$WindowFocusObserver$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function1<Boolean, Unit>> $callback;
    final /* synthetic */ WindowInfo $windowInfo;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WindowInfoKt$WindowFocusObserver$1$1(WindowInfo windowInfo, State<? extends Function1<? super Boolean, Unit>> state, Continuation<? super WindowInfoKt$WindowFocusObserver$1$1> continuation) {
        super(2, continuation);
        this.$windowInfo = windowInfo;
        this.$callback = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WindowInfoKt$WindowFocusObserver$1$1(this.$windowInfo, this.$callback, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WindowInfoKt$WindowFocusObserver$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final WindowInfo windowInfo = this.$windowInfo;
            Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<Boolean>() {
                public final Boolean invoke() {
                    return Boolean.valueOf(windowInfo.isWindowFocused());
                }
            });
            final State<Function1<Boolean, Unit>> state = this.$callback;
            this.label = 1;
            if (snapshotFlow.collect(new FlowCollector() {
                public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                    return emit(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) continuation);
                }

                public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                    state.getValue().invoke(Boxing.boxBoolean(z));
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
