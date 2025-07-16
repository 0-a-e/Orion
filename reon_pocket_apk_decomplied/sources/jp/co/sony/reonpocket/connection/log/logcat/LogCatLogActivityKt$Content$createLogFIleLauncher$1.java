package jp.co.sony.reonpocket.connection.log.logcat;

import android.net.Uri;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "uri", "Landroid/net/Uri;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: LogCatLogActivity.kt */
final class LogCatLogActivityKt$Content$createLogFIleLauncher$1 extends Lambda implements Function1<Uri, Unit> {
    final /* synthetic */ Ref.ObjectRef<File> $logFile;
    final /* synthetic */ LogCatLogPresenter $presenter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LogCatLogActivityKt$Content$createLogFIleLauncher$1(Ref.ObjectRef<File> objectRef, LogCatLogPresenter logCatLogPresenter) {
        super(1);
        this.$logFile = objectRef;
        this.$presenter = logCatLogPresenter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Uri) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Uri uri) {
        if (uri != null && this.$logFile.element != null) {
            LogCatLogPresenter logCatLogPresenter = this.$presenter;
            T t = this.$logFile.element;
            Intrinsics.checkNotNull(t);
            logCatLogPresenter.onClickLogFile((File) t, uri);
        }
    }
}
