package jp.co.sony.reonpocket.connection.log.logcat;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: LogCatLogActivity.kt */
/* synthetic */ class LogCatLogActivityKt$Content$2 extends FunctionReferenceImpl implements Function0<Unit> {
    LogCatLogActivityKt$Content$2(Object obj) {
        super(0, obj, LogCatLogPresenter.class, "onClickStartLogging", "onClickStartLogging()V", 0);
    }

    public final void invoke() {
        ((LogCatLogPresenter) this.receiver).onClickStartLogging();
    }
}
