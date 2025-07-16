package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "P1", "P2", "it", "Lkotlin/Pair;", "invoke", "(Lkotlin/Pair;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: MovableContent.kt */
final class MovableContentKt$movableContentOf$movableContent$2 extends Lambda implements Function3<Pair<? extends P1, ? extends P2>, Composer, Integer, Unit> {
    final /* synthetic */ Function4<P1, P2, Composer, Integer, Unit> $content;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MovableContentKt$movableContentOf$movableContent$2(Function4<? super P1, ? super P2, ? super Composer, ? super Integer, Unit> function4) {
        super(3);
        this.$content = function4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Pair) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Pair<? extends P1, ? extends P2> pair, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C87@3417L28:MovableContent.kt#9igjgp");
        if ((i & 14) == 0) {
            i |= composer.changed((Object) pair) ? 4 : 2;
        }
        if ((i & 91) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1849814513, i, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:87)");
            }
            this.$content.invoke(pair.getFirst(), pair.getSecond(), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
