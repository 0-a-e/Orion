package jp.co.sony.reonpocket.connection.log.logcat;

import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: LogCatLogActivity.kt */
/* synthetic */ class LogCatLogActivityKt$Content$5 extends FunctionReferenceImpl implements Function1<File, Unit> {
    LogCatLogActivityKt$Content$5(Object obj) {
        super(1, obj, LogCatLogPresenter.class, "onLongClickLogFile", "onLongClickLogFile(Ljava/io/File;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((File) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(File file) {
        Intrinsics.checkNotNullParameter(file, "p0");
        ((LogCatLogPresenter) this.receiver).onLongClickLogFile(file);
    }
}
