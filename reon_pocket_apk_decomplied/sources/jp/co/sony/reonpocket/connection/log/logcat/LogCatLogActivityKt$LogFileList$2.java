package jp.co.sony.reonpocket.connection.log.logcat;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: LogCatLogActivity.kt */
final class LogCatLogActivityKt$LogFileList$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ List<File> $logFiles;
    final /* synthetic */ Function0<Unit> $onClickDeleteAllFiles;
    final /* synthetic */ Function1<File, Unit> $onClickLogFile;
    final /* synthetic */ Function0<Unit> $onClickStartLogging;
    final /* synthetic */ Function0<Unit> $onClickStopLogging;
    final /* synthetic */ Function1<File, Unit> $onLongClickLogFile;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LogCatLogActivityKt$LogFileList$2(List<? extends File> list, Function1<? super File, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function1<? super File, Unit> function12, int i) {
        super(2);
        this.$logFiles = list;
        this.$onClickLogFile = function1;
        this.$onClickStartLogging = function0;
        this.$onClickStopLogging = function02;
        this.$onClickDeleteAllFiles = function03;
        this.$onLongClickLogFile = function12;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        LogCatLogActivityKt.LogFileList(this.$logFiles, this.$onClickLogFile, this.$onClickStartLogging, this.$onClickStopLogging, this.$onClickDeleteAllFiles, this.$onLongClickLogFile, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
