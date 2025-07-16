package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u00052\u0006\u0010\u0006\u001a\u0002H\u00022\u0006\u0010\u0007\u001a\u0002H\u00032\u0006\u0010\b\u001a\u0002H\u00042\u0006\u0010\t\u001a\u0002H\u0005H\u000b¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"<anonymous>", "", "P1", "P2", "P3", "P4", "p1", "p2", "p3", "p4", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: MovableContent.kt */
final class MovableContentKt$movableContentOf$5 extends Lambda implements Function6<P1, P2, P3, P4, Composer, Integer, Unit> {
    final /* synthetic */ MovableContent<Pair<Pair<P1, P2>, Pair<P3, P4>>> $movableContent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MovableContentKt$movableContentOf$5(MovableContent<Pair<Pair<P1, P2>, Pair<P3, P4>>> movableContent) {
        super(6);
        this.$movableContent = movableContent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        invoke(obj, obj2, obj3, obj4, (Composer) obj5, ((Number) obj6).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(P1 p1, P2 p2, P3 p3, P4 p4, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "C:MovableContent.kt#9igjgp");
        if ((i & 14) == 0) {
            i2 = (composer.changed((Object) p1) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composer.changed((Object) p2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composer.changed((Object) p3) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composer.changed((Object) p4) ? 2048 : 1024;
        }
        if ((46811 & i2) != 9362 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1741877681, i2, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:147)");
            }
            composer.insertMovableContent(this.$movableContent, TuplesKt.to(TuplesKt.to(p1, p2), TuplesKt.to(p3, p4)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
