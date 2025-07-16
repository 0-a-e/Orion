package androidx.compose.ui.platform;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "methodSession", "Landroidx/compose/ui/platform/InputMethodSession;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.platform.AndroidPlatformTextInputSession$startInputMethod$3", f = "AndroidPlatformTextInputSession.android.kt", i = {0}, l = {158}, m = "invokeSuspend", n = {"methodSession"}, s = {"L$0"})
/* compiled from: AndroidPlatformTextInputSession.android.kt */
final class AndroidPlatformTextInputSession$startInputMethod$3 extends SuspendLambda implements Function2<InputMethodSession, Continuation<?>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AndroidPlatformTextInputSession this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidPlatformTextInputSession$startInputMethod$3(AndroidPlatformTextInputSession androidPlatformTextInputSession, Continuation<? super AndroidPlatformTextInputSession$startInputMethod$3> continuation) {
        super(2, continuation);
        this.this$0 = androidPlatformTextInputSession;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AndroidPlatformTextInputSession$startInputMethod$3 androidPlatformTextInputSession$startInputMethod$3 = new AndroidPlatformTextInputSession$startInputMethod$3(this.this$0, continuation);
        androidPlatformTextInputSession$startInputMethod$3.L$0 = obj;
        return androidPlatformTextInputSession$startInputMethod$3;
    }

    public final Object invoke(InputMethodSession inputMethodSession, Continuation<?> continuation) {
        return ((AndroidPlatformTextInputSession$startInputMethod$3) create(inputMethodSession, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            InputMethodSession inputMethodSession = (InputMethodSession) this.L$0;
            AndroidPlatformTextInputSession androidPlatformTextInputSession = this.this$0;
            this.L$0 = inputMethodSession;
            this.L$1 = androidPlatformTextInputSession;
            this.label = 1;
            Continuation continuation = this;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            androidPlatformTextInputSession.textInputService.startInput();
            cancellableContinuationImpl.invokeOnCancellation(new AndroidPlatformTextInputSession$startInputMethod$3$1$1(inputMethodSession, androidPlatformTextInputSession));
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            AndroidPlatformTextInputSession androidPlatformTextInputSession2 = (AndroidPlatformTextInputSession) this.L$1;
            InputMethodSession inputMethodSession2 = (InputMethodSession) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
