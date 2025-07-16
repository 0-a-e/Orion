package jp.co.sony.reonpocket.connection.log.logcat;

import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: LogCatLogActivity.kt */
final class LogCatLogActivityKt$LogFileList$1$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ File $file;
    final /* synthetic */ Function1<File, Unit> $onLongClickLogFile;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LogCatLogActivityKt$LogFileList$1$2$1(Function1<? super File, Unit> function1, File file) {
        super(0);
        this.$onLongClickLogFile = function1;
        this.$file = file;
    }

    public final void invoke() {
        this.$onLongClickLogFile.invoke(this.$file);
    }
}
