package jp.co.sony.reonpocket.connection.log.logcat;

import android.net.Uri;
import androidx.activity.compose.ManagedActivityResultLauncher;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Ljava/io/File;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: LogCatLogActivity.kt */
final class LogCatLogActivityKt$Content$1 extends Lambda implements Function1<File, Unit> {
    final /* synthetic */ ManagedActivityResultLauncher<String, Uri> $createLogFIleLauncher;
    final /* synthetic */ Ref.ObjectRef<File> $logFile;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LogCatLogActivityKt$Content$1(Ref.ObjectRef<File> objectRef, ManagedActivityResultLauncher<String, Uri> managedActivityResultLauncher) {
        super(1);
        this.$logFile = objectRef;
        this.$createLogFIleLauncher = managedActivityResultLauncher;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((File) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(File file) {
        Intrinsics.checkNotNullParameter(file, "it");
        this.$logFile.element = file;
        ManagedActivityResultLauncher<String, Uri> managedActivityResultLauncher = this.$createLogFIleLauncher;
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        managedActivityResultLauncher.launch(name);
    }
}
