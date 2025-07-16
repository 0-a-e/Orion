package androidx.compose.ui.platform;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidCompositionLocals.android.kt */
final class AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ AndroidComposeView $owner;
    final /* synthetic */ AndroidUriHandler $uriHandler;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$3(AndroidComposeView androidComposeView, AndroidUriHandler androidUriHandler, Function2<? super Composer, ? super Integer, Unit> function2) {
        super(2);
        this.$owner = androidComposeView;
        this.$uriHandler = androidUriHandler;
        this.$content = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C118@4176L135:AndroidCompositionLocals.android.kt#itgzvw");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1471621628, i, -1, "androidx.compose.ui.platform.ProvideAndroidCompositionLocals.<anonymous> (AndroidCompositionLocals.android.kt:118)");
            }
            CompositionLocalsKt.ProvideCommonCompositionLocals(this.$owner, this.$uriHandler, this.$content, composer, 72);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
