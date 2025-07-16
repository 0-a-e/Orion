package jp.co.sony.reonpocket.connection.log.logcat;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "jp.co.sony.reonpocket.connection.log.logcat.LogCatLogPresenter$onClickDeleteAllFiles$1", f = "LogCatLogPresenter.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LogCatLogPresenter.kt */
final class LogCatLogPresenter$onClickDeleteAllFiles$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LogCatLogPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LogCatLogPresenter$onClickDeleteAllFiles$1(LogCatLogPresenter logCatLogPresenter, Continuation<? super LogCatLogPresenter$onClickDeleteAllFiles$1> continuation) {
        super(2, continuation);
        this.this$0 = logCatLogPresenter;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LogCatLogPresenter$onClickDeleteAllFiles$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LogCatLogPresenter$onClickDeleteAllFiles$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.logCatLogRepository.deleteAllLogFiles(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.loadLogFiles();
        MutableStateFlow access$get_toastMessage$p = this.this$0._toastMessage;
        do {
            value = access$get_toastMessage$p.getValue();
            String str = (String) value;
        } while (!access$get_toastMessage$p.compareAndSet(value, "ログファイルを全て削除しました"));
        return Unit.INSTANCE;
    }
}
