package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006\u0012\u0004\u0012\u0002H\u00040\u0006H\u000b¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "P1", "P2", "P3", "it", "Lkotlin/Pair;", "invoke", "(Lkotlin/Pair;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: MovableContent.kt */
final class MovableContentKt$movableContentOf$movableContent$3 extends Lambda implements Function3<Pair<? extends Pair<? extends P1, ? extends P2>, ? extends P3>, Composer, Integer, Unit> {
    final /* synthetic */ Function5<P1, P2, P3, Composer, Integer, Unit> $content;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MovableContentKt$movableContentOf$movableContent$3(Function5<? super P1, ? super P2, ? super P3, ? super Composer, ? super Integer, Unit> function5) {
        super(3);
        this.$content = function5;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Pair) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Pair<? extends Pair<? extends P1, ? extends P2>, ? extends P3> pair, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C115@4463L51:MovableContent.kt#9igjgp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-284417101, i, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:115)");
        }
        this.$content.invoke(((Pair) pair.getFirst()).getFirst(), ((Pair) pair.getFirst()).getSecond(), pair.getSecond(), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
