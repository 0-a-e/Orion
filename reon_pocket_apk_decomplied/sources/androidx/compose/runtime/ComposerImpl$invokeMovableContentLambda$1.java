package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Composer.kt */
final class ComposerImpl$invokeMovableContentLambda$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MovableContent<Object> $content;
    final /* synthetic */ Object $parameter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ComposerImpl$invokeMovableContentLambda$1(MovableContent<Object> movableContent, Object obj) {
        super(2);
        this.$content = movableContent;
        this.$parameter = obj;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C3004@113980L18:Composer.kt#9igjgp");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(316014703, i, -1, "androidx.compose.runtime.ComposerImpl.invokeMovableContentLambda.<anonymous> (Composer.kt:3004)");
            }
            this.$content.getContent().invoke(this.$parameter, composer, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
