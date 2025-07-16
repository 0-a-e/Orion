package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidCursorHandle.android.kt */
final class AndroidCursorHandle_androidKt$CursorHandle$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ Modifier $modifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidCursorHandle_androidKt$CursorHandle$2(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier) {
        super(2);
        this.$content = function2;
        this.$modifier = modifier;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:AndroidCursorHandle.android.kt#423gt5");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1458480226, i, -1, "androidx.compose.foundation.text.CursorHandle.<anonymous> (AndroidCursorHandle.android.kt:47)");
            }
            if (this.$content == null) {
                composer.startReplaceableGroup(1275643845);
                ComposerKt.sourceInformation(composer, "48@1847L40");
                AndroidCursorHandle_androidKt.DefaultCursorHandle(this.$modifier, composer, 0);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(1275643915);
                ComposerKt.sourceInformation(composer, "50@1917L9");
                this.$content.invoke(composer, 0);
                composer.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
