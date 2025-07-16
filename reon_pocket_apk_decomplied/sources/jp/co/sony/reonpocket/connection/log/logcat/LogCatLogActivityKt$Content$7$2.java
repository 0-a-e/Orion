package jp.co.sony.reonpocket.connection.log.logcat;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: LogCatLogActivity.kt */
final class LogCatLogActivityKt$Content$7$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ ConfirmDeleteLogFileDialogInfo $info;
    final /* synthetic */ LogCatLogPresenter $presenter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LogCatLogActivityKt$Content$7$2(LogCatLogPresenter logCatLogPresenter, ConfirmDeleteLogFileDialogInfo confirmDeleteLogFileDialogInfo) {
        super(2);
        this.$presenter = logCatLogPresenter;
        this.$info = confirmDeleteLogFileDialogInfo;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        int i2 = i;
        if ((i2 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2134973392, i2, -1, "jp.co.sony.reonpocket.connection.log.logcat.Content.<anonymous>.<anonymous> (LogCatLogActivity.kt:110)");
            }
            final LogCatLogPresenter logCatLogPresenter = this.$presenter;
            final ConfirmDeleteLogFileDialogInfo confirmDeleteLogFileDialogInfo = this.$info;
            ButtonKt.TextButton(new Function0<Unit>() {
                public final void invoke() {
                    logCatLogPresenter.onConfirmDeleteLogFile(confirmDeleteLogFileDialogInfo);
                }
            }, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$LogCatLogActivityKt.INSTANCE.m6983getLambda1$app_prodRelease(), composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
