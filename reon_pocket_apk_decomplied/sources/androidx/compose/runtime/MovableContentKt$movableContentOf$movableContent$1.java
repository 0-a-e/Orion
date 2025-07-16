package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "it", "invoke", "(Lkotlin/Unit;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: MovableContent.kt */
final class MovableContentKt$movableContentOf$movableContent$1 extends Lambda implements Function3<Unit, Composer, Integer, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MovableContentKt$movableContentOf$movableContent$1(Function2<? super Composer, ? super Integer, Unit> function2) {
        super(3);
        this.$content = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Unit) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Unit unit, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C37@1498L9:MovableContent.kt#9igjgp");
        if ((i & 81) != 16 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1079330685, i, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:37)");
            }
            this.$content.invoke(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
