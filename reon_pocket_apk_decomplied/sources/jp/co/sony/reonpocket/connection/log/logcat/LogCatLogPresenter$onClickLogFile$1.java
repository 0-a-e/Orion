package jp.co.sony.reonpocket.connection.log.logcat;

import android.net.Uri;
import java.io.File;
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
@DebugMetadata(c = "jp.co.sony.reonpocket.connection.log.logcat.LogCatLogPresenter$onClickLogFile$1", f = "LogCatLogPresenter.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LogCatLogPresenter.kt */
final class LogCatLogPresenter$onClickLogFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $logFile;
    final /* synthetic */ Uri $outputFileUri;
    int label;
    final /* synthetic */ LogCatLogPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LogCatLogPresenter$onClickLogFile$1(LogCatLogPresenter logCatLogPresenter, File file, Uri uri, Continuation<? super LogCatLogPresenter$onClickLogFile$1> continuation) {
        super(2, continuation);
        this.this$0 = logCatLogPresenter;
        this.$logFile = file;
        this.$outputFileUri = uri;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LogCatLogPresenter$onClickLogFile$1(this.this$0, this.$logFile, this.$outputFileUri, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LogCatLogPresenter$onClickLogFile$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        Object value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.logCatLogger.outputLogFile(this.$logFile, this.$outputFileUri, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) obj).booleanValue()) {
            str = "ログファイルを出力しました " + this.$logFile.getName();
        } else {
            str = "ログファイルの出力に失敗しました " + this.$logFile.getName();
        }
        MutableStateFlow access$get_toastMessage$p = this.this$0._toastMessage;
        do {
            value = access$get_toastMessage$p.getValue();
            String str2 = (String) value;
        } while (!access$get_toastMessage$p.compareAndSet(value, str));
        return Unit.INSTANCE;
    }
}
