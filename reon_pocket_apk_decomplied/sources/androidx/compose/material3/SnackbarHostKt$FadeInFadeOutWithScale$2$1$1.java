package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnackbarHost.kt */
final class SnackbarHostKt$FadeInFadeOutWithScale$2$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function3<SnackbarData, Composer, Integer, Unit> $content;
    final /* synthetic */ SnackbarData $item;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnackbarHostKt$FadeInFadeOutWithScale$2$1$1(Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit> function3, SnackbarData snackbarData) {
        super(2);
        this.$content = function3;
        this.$item = snackbarData;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C410@15266L15:SnackbarHost.kt#uh7d8r");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1135367807, i, -1, "androidx.compose.material3.FadeInFadeOutWithScale.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SnackbarHost.kt:410)");
            }
            Function3<SnackbarData, Composer, Integer, Unit> function3 = this.$content;
            SnackbarData snackbarData = this.$item;
            Intrinsics.checkNotNull(snackbarData);
            function3.invoke(snackbarData, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
