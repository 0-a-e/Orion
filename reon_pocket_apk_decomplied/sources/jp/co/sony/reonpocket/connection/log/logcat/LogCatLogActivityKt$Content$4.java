package jp.co.sony.reonpocket.connection.log.logcat;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: LogCatLogActivity.kt */
/* synthetic */ class LogCatLogActivityKt$Content$4 extends FunctionReferenceImpl implements Function0<Unit> {
    LogCatLogActivityKt$Content$4(Object obj) {
        super(0, obj, LogCatLogPresenter.class, "onClickDeleteAllFiles", "onClickDeleteAllFiles()V", 0);
    }

    public final void invoke() {
        ((LogCatLogPresenter) this.receiver).onClickDeleteAllFiles();
    }
}
